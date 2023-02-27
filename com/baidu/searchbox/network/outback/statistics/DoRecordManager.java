package com.baidu.searchbox.network.outback.statistics;

import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.OutbackComponent;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class DoRecordManager {
    public static final boolean DEBUG = false;
    public static int DEFAULT_INITIAL_CAPACITY = 50;
    public static int FAILED_MSG = 101;
    public static int SUCCESSFUL_MSG = 100;
    public static final String TAG = "DoRecordManager";
    public static DoRecordManager sDoRecordManager;
    public volatile List<RecordObserver> mSynchronizedList = Collections.synchronizedList(new ArrayList(DEFAULT_INITIAL_CAPACITY));

    public static DoRecordManager getInstance() {
        if (sDoRecordManager == null) {
            synchronized (DoRecordManager.class) {
                if (sDoRecordManager == null) {
                    sDoRecordManager = new DoRecordManager();
                }
            }
        }
        return sDoRecordManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcast(int i, NetworkStatRecord networkStatRecord) {
        synchronized (this.mSynchronizedList) {
            for (RecordObserver recordObserver : this.mSynchronizedList) {
                recordObserver.doRecord(networkStatRecord, i);
            }
        }
    }

    public void doRecord(final NetworkStatRecord networkStatRecord, final int i) {
        if (networkStatRecord != null) {
            doAdditionalRecord(networkStatRecord);
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.network.outback.statistics.DoRecordManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(networkStatRecord.clientIP)) {
                        networkStatRecord.clientIP = ConnectManager.getClientIP();
                    }
                    DoRecordManager.this.setRecordLocalDnsList(networkStatRecord);
                    DoRecordManager.this.broadcast(i, networkStatRecord);
                }
            }, "OutbackParseLocalDnsDoRecord");
        }
    }

    private void doAdditionalRecord(NetworkStatRecord networkStatRecord) {
        IAdditionalRecord additionalRecord;
        if (networkStatRecord != null && (additionalRecord = OutbackComponent.getInstance().getAdditionalRecord()) != null) {
            networkStatRecord.processName = additionalRecord.getProcessName();
            networkStatRecord.appLaunchTimestamp = additionalRecord.getAppLaunchTimeStamp();
            networkStatRecord.clientIPv6 = additionalRecord.getClientIPV6();
            networkStatRecord.httpDnsAreaInfo = additionalRecord.getHttpDnsAreaInfo();
            networkStatRecord.httpDnsAreaInfoLastUpdateTime = additionalRecord.getHttpDnsAreaInfoLastUpdateTime();
            networkStatRecord.ipStack = additionalRecord.getIpStack();
            networkStatRecord.networkQuality = additionalRecord.getNetworkQuality();
        }
    }

    private List<String> parseRawAddressArray(InetAddress[] inetAddressArr) {
        if (inetAddressArr != null && inetAddressArr.length > 0) {
            List<InetAddress> asList = Arrays.asList(inetAddressArr);
            ArrayList arrayList = new ArrayList(asList.size());
            for (InetAddress inetAddress : asList) {
                arrayList.add(inetAddress.getHostAddress());
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecordLocalDnsList(NetworkStatRecord networkStatRecord) {
        if (networkStatRecord != null) {
            try {
                URL url = new URL(networkStatRecord.url);
                if (!TextUtils.isEmpty(url.getHost())) {
                    networkStatRecord.localDnsIpList = parseRawAddressArray(InetAddress.getAllByName(url.getHost()));
                }
            } catch (IllegalArgumentException | NullPointerException | SecurityException | MalformedURLException | UnknownHostException unused) {
            }
        }
    }

    public void attach(RecordObserver recordObserver) {
        this.mSynchronizedList.add(recordObserver);
    }

    public void detach(RecordObserver recordObserver) {
        if (!this.mSynchronizedList.isEmpty()) {
            this.mSynchronizedList.remove(recordObserver);
        }
    }
}
