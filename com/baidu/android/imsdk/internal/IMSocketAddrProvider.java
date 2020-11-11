package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.dns.DnsHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes18.dex */
public class IMSocketAddrProvider {
    private static final long SMART_DNS_TIME_OUT = 5000;
    private static ConcurrentLinkedQueue<String> SOCKET_ADDR_PRIORITY_QUEUE = null;
    private static final String TAG = "IMSocketAddrProvider";
    public static Context mContext;
    private static volatile IMSocketAddrProvider mInstance;
    private String mLastSuccAddr;
    private String mNowConnectAddr;
    private IGetSocketAddrListener mSocketAddrListener;

    /* loaded from: classes18.dex */
    public interface IGetSocketAddrListener extends IMListener {
        void onGetSocketAddrResult(String str);
    }

    public IMSocketAddrProvider(Context context) {
        mContext = context.getApplicationContext();
        SOCKET_ADDR_PRIORITY_QUEUE = new ConcurrentLinkedQueue<>();
    }

    public static IMSocketAddrProvider getInstance(Context context) {
        if (mInstance == null) {
            synchronized (IMSocketAddrProvider.class) {
                if (mInstance == null) {
                    mInstance = new IMSocketAddrProvider(context);
                }
            }
        }
        return mInstance;
    }

    public void getSocketAddr(IGetSocketAddrListener iGetSocketAddrListener) {
        if (iGetSocketAddrListener != null) {
            this.mSocketAddrListener = iGetSocketAddrListener;
            if (Constants.getEnv(mContext) == 1 || Constants.getEnv(mContext) == 2) {
                this.mSocketAddrListener.onGetSocketAddrResult(Constants.URL_SOCKET_SERVER + ":" + Constants.URL_SOCKET_PORT);
                this.mSocketAddrListener = null;
                return;
            }
            onFailSocketAddr(this.mNowConnectAddr);
            pollSocketAddrsQueue();
            fullSocketAddrsQueue();
        }
    }

    private void fullSocketAddrsQueue() {
        if (SOCKET_ADDR_PRIORITY_QUEUE.isEmpty()) {
            LogUtils.d(TAG, "socket queue is empty......");
            getSmartSocketAddrs();
        }
    }

    private void getSmartSocketAddrs() {
        LogUtils.d(TAG, "will getSmartSocketAddrs......");
        try {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.internal.IMSocketAddrProvider.1
                @Override // java.lang.Runnable
                public void run() {
                    Utility.writeLoginFlag(IMSocketAddrProvider.mContext, "11N", "BDHttpDNS begin");
                    LogUtils.d(IMSocketAddrProvider.TAG, "bddns > doing...");
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() { // from class: com.baidu.android.imsdk.internal.IMSocketAddrProvider.1.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            Utility.writeLoginFlag(IMSocketAddrProvider.mContext, "11N_1", "BDHttpDNS exception");
                            LogUtils.d(IMSocketAddrProvider.TAG, "bddns > bdDnsIps is time out");
                            IMSocketAddrProvider.this.getHttpDnsAddress();
                        }
                    }, 5000L);
                    DnsHelper dnsHelper = new DnsHelper(IMSocketAddrProvider.mContext);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    List<String> ipListForceHttp = dnsHelper.getIpListForceHttp(Constants.URL_SOCKET_SERVER);
                    LogUtils.d(IMSocketAddrProvider.TAG, "bddns > bdDnsIps = " + ipListForceHttp);
                    Utility.writeLoginFlag(IMSocketAddrProvider.mContext, "11Y", "BDHttpDNS success, ip=" + ipListForceHttp);
                    timer.cancel();
                    LogUtils.d(IMSocketAddrProvider.TAG, "bddns > bdDnsIps timer.canceled... ");
                    IMSocketAddrProvider.this.fullDnsAndUrlAddress(ipListForceHttp);
                }
            });
        } catch (Throwable th) {
            getHttpDnsAddress();
            Utility.writeLoginFlag(mContext, "11N_2", "BDHttpDNS exception");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHttpDnsAddress() {
        LogUtils.d(TAG, "will getHttpDnsAddress......");
        try {
            IMHttpDnsUrlRequest iMHttpDnsUrlRequest = new IMHttpDnsUrlRequest(mContext);
            HttpHelper.executor(mContext, iMHttpDnsUrlRequest, iMHttpDnsUrlRequest);
        } catch (Exception e) {
            onGetHttpDNSAddressResult(null);
        }
    }

    public void onGetHttpDNSAddressResult(List<String> list) {
        fullDnsAndUrlAddress(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fullDnsAndUrlAddress(List<String> list) {
        LogUtils.d(TAG, "socket queue is adding...... ");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (Utility.isIpv4(list.get(i))) {
                    arrayList.add(list.get(i));
                } else {
                    arrayList2.add(list.get(i));
                }
            }
        }
        String str = !arrayList.isEmpty() ? (String) arrayList.get(0) : null;
        String str2 = !arrayList2.isEmpty() ? (String) arrayList2.get(0) : null;
        if (str != null) {
            offerSocketAddressToQueue(str + ":" + Constants.SOCKET_PORT_SSL);
        }
        if (str2 != null) {
            offerSocketAddressToQueue(str2 + ":" + Constants.SOCKET_PORT_SSL);
        }
        if (str != null) {
            offerSocketAddressToQueue(str + ":" + Constants.SOCKET_BACKUP_PORT_SSL);
        }
        if (str2 != null) {
            offerSocketAddressToQueue(str2 + ":" + Constants.SOCKET_BACKUP_PORT_SSL);
        }
        offerSocketAddressToQueue(Constants.URL_SOCKET_SERVER + ":" + Constants.SOCKET_PORT_SSL);
        offerSocketAddressToQueue(Constants.URL_SOCKET_SERVER + ":" + Constants.SOCKET_BACKUP_PORT_SSL);
        LogUtils.d(TAG, "new socket queue is " + SOCKET_ADDR_PRIORITY_QUEUE.toString());
        pollSocketAddrsQueue();
    }

    private void pollSocketAddrsQueue() {
        if (this.mSocketAddrListener != null && !SOCKET_ADDR_PRIORITY_QUEUE.isEmpty()) {
            this.mNowConnectAddr = SOCKET_ADDR_PRIORITY_QUEUE.poll();
            returnSmartestSocketAdderss();
        }
    }

    private void returnSmartestSocketAdderss() {
        LogUtils.d(TAG, "************* socket queue return = " + this.mNowConnectAddr + " ****************");
        if (this.mSocketAddrListener != null) {
            this.mSocketAddrListener.onGetSocketAddrResult(this.mNowConnectAddr);
        }
        if (!SOCKET_ADDR_PRIORITY_QUEUE.isEmpty()) {
            LogUtils.d(TAG, SOCKET_ADDR_PRIORITY_QUEUE.toString());
        }
        this.mSocketAddrListener = null;
    }

    private void offerSocketAddressToQueue(String str) {
        if (!TextUtils.isEmpty(str) && !SOCKET_ADDR_PRIORITY_QUEUE.contains(str)) {
            SOCKET_ADDR_PRIORITY_QUEUE.offer(str);
        }
    }

    public void onSuccessSocketAddr(String str) {
        LogUtils.d(TAG, "socket queue onSuccessSocketAddr = " + str);
        this.mLastSuccAddr = str;
        if (SOCKET_ADDR_PRIORITY_QUEUE != null) {
            SOCKET_ADDR_PRIORITY_QUEUE.clear();
            if (!this.mLastSuccAddr.startsWith(Constants.URL_SOCKET_SERVER)) {
                SOCKET_ADDR_PRIORITY_QUEUE.offer(this.mLastSuccAddr);
            }
        }
    }

    public void onFailSocketAddr(String str) {
        LogUtils.d(TAG, "socket queue onFailSocketAddr = " + str);
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, this.mLastSuccAddr)) {
            SOCKET_ADDR_PRIORITY_QUEUE.remove(str);
        }
    }
}
