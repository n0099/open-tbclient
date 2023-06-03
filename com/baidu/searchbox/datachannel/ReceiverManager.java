package com.baidu.searchbox.datachannel;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ReceiverManager {
    public static ReceiverManager sInstance = new ReceiverManager();
    public List<BaseBroadcastReceiver> mReceivers = new ArrayList();

    public static ReceiverManager getInstance() {
        return sInstance;
    }

    public synchronized List<BaseBroadcastReceiver> getReceivers() {
        return this.mReceivers;
    }

    public synchronized List<BaseBroadcastReceiver> removeAllReceivers() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.mReceivers);
        this.mReceivers.clear();
        return arrayList;
    }

    public synchronized void addReceiver(BaseBroadcastReceiver baseBroadcastReceiver) {
        this.mReceivers.add(baseBroadcastReceiver);
    }

    public synchronized List<BaseBroadcastReceiver> removeReceivers(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<BaseBroadcastReceiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            BaseBroadcastReceiver next = it.next();
            if (TextUtils.equals(next.mHost, str)) {
                arrayList.add(next);
                it.remove();
            }
        }
        return arrayList;
    }

    public synchronized void printAllReceivers() {
        Log.d(Contract.TAG, "Remaining receivers count : " + this.mReceivers.size());
        for (BaseBroadcastReceiver baseBroadcastReceiver : this.mReceivers) {
            Log.d(Contract.TAG, baseBroadcastReceiver.toString());
        }
    }

    public synchronized List<BaseBroadcastReceiver> removeReceivers(String str, String str2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<BaseBroadcastReceiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            BaseBroadcastReceiver next = it.next();
            if (TextUtils.equals(next.mHost, str) && TextUtils.equals(next.mPage, str2)) {
                arrayList.add(next);
                it.remove();
            }
        }
        return arrayList;
    }

    public synchronized List<BaseBroadcastReceiver> removeReceivers(String str, String str2, String str3) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<BaseBroadcastReceiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            BaseBroadcastReceiver next = it.next();
            if (TextUtils.equals(next.mHost, str) && TextUtils.equals(next.mPage, str2) && TextUtils.equals(next.mAction, str3)) {
                arrayList.add(next);
                it.remove();
            }
        }
        return arrayList;
    }
}
