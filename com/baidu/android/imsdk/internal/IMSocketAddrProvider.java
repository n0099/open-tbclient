package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class IMSocketAddrProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long SMART_DNS_TIME_OUT = 5000;
    public static ConcurrentLinkedQueue SOCKET_ADDR_PRIORITY_QUEUE = null;
    public static final String TAG = "IMSocketAddrProvider";
    public static Context mContext;
    public static volatile IMSocketAddrProvider mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public String mLastSuccAddr;
    public String mNowConnectAddr;
    public IGetSocketAddrListener mSocketAddrListener;

    /* loaded from: classes.dex */
    public interface IGetSocketAddrListener extends IMListener {
        void onGetSocketAddrResult(String str);
    }

    public IMSocketAddrProvider(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        mContext = context.getApplicationContext();
        SOCKET_ADDR_PRIORITY_QUEUE = new ConcurrentLinkedQueue();
    }

    public void onFailSocketAddr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            LogUtils.d(TAG, "socket queue onFailSocketAddr = " + str);
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, this.mLastSuccAddr)) {
                SOCKET_ADDR_PRIORITY_QUEUE.remove(str);
            }
        }
    }

    public void onSuccessSocketAddr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            LogUtils.d(TAG, "socket queue onSuccessSocketAddr = " + str);
            this.mLastSuccAddr = str;
            ConcurrentLinkedQueue concurrentLinkedQueue = SOCKET_ADDR_PRIORITY_QUEUE;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
                if (!this.mLastSuccAddr.startsWith(Constants.URL_SOCKET_SERVER)) {
                    SOCKET_ADDR_PRIORITY_QUEUE.offer(this.mLastSuccAddr);
                }
            }
        }
    }

    public static IMSocketAddrProvider getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (mInstance == null) {
                synchronized (IMSocketAddrProvider.class) {
                    if (mInstance == null) {
                        mInstance = new IMSocketAddrProvider(context);
                    }
                }
            }
            return mInstance;
        }
        return (IMSocketAddrProvider) invokeL.objValue;
    }

    private void offerSocketAddressToQueue(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, str) == null) && !TextUtils.isEmpty(str) && !SOCKET_ADDR_PRIORITY_QUEUE.contains(str)) {
            SOCKET_ADDR_PRIORITY_QUEUE.offer(str);
        }
    }

    public void onGetHttpDNSAddressResult(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            fullDnsAndUrlAddress(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fullDnsAndUrlAddress(List list) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, list) == null) {
            LogUtils.d(TAG, "socket queue is adding...... ");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (Utility.isIpv4((String) list.get(i))) {
                        arrayList.add(list.get(i));
                    } else {
                        arrayList2.add(list.get(i));
                    }
                }
            }
            String str2 = null;
            if (!arrayList.isEmpty()) {
                str = (String) arrayList.get(0);
            } else {
                str = null;
            }
            if (!arrayList2.isEmpty()) {
                str2 = (String) arrayList2.get(0);
            }
            if (str != null) {
                offerSocketAddressToQueue(str + ":443");
            }
            if (str2 != null) {
                offerSocketAddressToQueue(str2 + ":443");
            }
            if (str != null) {
                offerSocketAddressToQueue(str + ":" + Constants.SOCKET_BACKUP_PORT_SSL);
            }
            if (str2 != null) {
                offerSocketAddressToQueue(str2 + ":" + Constants.SOCKET_BACKUP_PORT_SSL);
            }
            offerSocketAddressToQueue(Constants.URL_SOCKET_SERVER + ":443");
            offerSocketAddressToQueue(Constants.URL_SOCKET_SERVER + ":" + Constants.SOCKET_BACKUP_PORT_SSL);
            StringBuilder sb = new StringBuilder();
            sb.append("new socket queue is ");
            sb.append(SOCKET_ADDR_PRIORITY_QUEUE.toString());
            LogUtils.d(TAG, sb.toString());
            pollSocketAddrsQueue();
        }
    }

    private void fullSocketAddrsQueue() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && SOCKET_ADDR_PRIORITY_QUEUE.isEmpty()) {
            LogUtils.d(TAG, "socket queue is empty......");
            getSmartSocketAddrs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHttpDnsAddress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            LogUtils.d(TAG, "will getHttpDnsAddress......");
            try {
                IMHttpDnsUrlRequest iMHttpDnsUrlRequest = new IMHttpDnsUrlRequest(mContext);
                HttpHelper.executor(mContext, iMHttpDnsUrlRequest, iMHttpDnsUrlRequest);
            } catch (Exception unused) {
                onGetHttpDNSAddressResult(null);
            }
        }
    }

    private void pollSocketAddrsQueue() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.mSocketAddrListener != null && !SOCKET_ADDR_PRIORITY_QUEUE.isEmpty()) {
            this.mNowConnectAddr = (String) SOCKET_ADDR_PRIORITY_QUEUE.poll();
            returnSmartestSocketAdderss();
        }
    }

    private void getSmartSocketAddrs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            LogUtils.d(TAG, "will getSmartSocketAddrs......");
            try {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.internal.IMSocketAddrProvider.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IMSocketAddrProvider this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Utility.writeLoginFlag(IMSocketAddrProvider.mContext, "11N", "BDHttpDNS begin");
                            LogUtils.d(IMSocketAddrProvider.TAG, "bddns > doing...");
                            Timer timer = new Timer();
                            timer.schedule(new TimerTask(this) { // from class: com.baidu.android.imsdk.internal.IMSocketAddrProvider.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.util.TimerTask, java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Utility.writeLoginFlag(IMSocketAddrProvider.mContext, "11N_1", "BDHttpDNS exception");
                                        LogUtils.d(IMSocketAddrProvider.TAG, "bddns > bdDnsIps is time out");
                                        this.this$1.this$0.getHttpDnsAddress();
                                    }
                                }
                            }, 5000L);
                            DnsHelper dnsHelper = new DnsHelper(IMSocketAddrProvider.mContext);
                            dnsHelper.setHttpDnsState(false, null, false, true);
                            List ipListForceHttp = dnsHelper.getIpListForceHttp(Constants.URL_SOCKET_SERVER);
                            LogUtils.d(IMSocketAddrProvider.TAG, "bddns > bdDnsIps = " + ipListForceHttp);
                            Context context = IMSocketAddrProvider.mContext;
                            Utility.writeLoginFlag(context, "11Y", "BDHttpDNS success, ip=" + ipListForceHttp);
                            timer.cancel();
                            LogUtils.d(IMSocketAddrProvider.TAG, "bddns > bdDnsIps timer.canceled... ");
                            this.this$0.fullDnsAndUrlAddress(ipListForceHttp);
                        }
                    }
                });
            } catch (Throwable th) {
                getHttpDnsAddress();
                Utility.writeLoginFlag(mContext, "11N_2", "BDHttpDNS exception");
                th.printStackTrace();
            }
        }
    }

    private void returnSmartestSocketAdderss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            LogUtils.d(TAG, "************* socket queue return = " + this.mNowConnectAddr + " ****************");
            IGetSocketAddrListener iGetSocketAddrListener = this.mSocketAddrListener;
            if (iGetSocketAddrListener != null) {
                iGetSocketAddrListener.onGetSocketAddrResult(this.mNowConnectAddr);
            }
            if (!SOCKET_ADDR_PRIORITY_QUEUE.isEmpty()) {
                LogUtils.d(TAG, SOCKET_ADDR_PRIORITY_QUEUE.toString());
            }
            this.mSocketAddrListener = null;
        }
    }

    public void getSocketAddr(IGetSocketAddrListener iGetSocketAddrListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, iGetSocketAddrListener) != null) || iGetSocketAddrListener == null) {
            return;
        }
        this.mSocketAddrListener = iGetSocketAddrListener;
        if (Constants.getEnv(mContext) != 1 && Constants.getEnv(mContext) != 2) {
            onFailSocketAddr(this.mNowConnectAddr);
            pollSocketAddrsQueue();
            fullSocketAddrsQueue();
            return;
        }
        IGetSocketAddrListener iGetSocketAddrListener2 = this.mSocketAddrListener;
        iGetSocketAddrListener2.onGetSocketAddrResult(Constants.URL_SOCKET_SERVER + ":" + Constants.URL_SOCKET_PORT);
        this.mSocketAddrListener = null;
    }
}
