package com.baidu.sapi2.passhost.pluginsdk.service;

import com.baidu.sapi2.base.debug.Log;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Observable {
    private static final String TAG = "Observable";
    private final MultiHashMap<Integer, Observer> observers = new MultiHashMap<>(12);

    public synchronized int getListenerCount(int i) {
        ArrayList<Observer> arrayList;
        arrayList = this.observers.get(Integer.valueOf(i));
        return arrayList != null ? arrayList.size() : 0;
    }

    public boolean hasListener(int i) {
        return getListenerCount(i) > 0;
    }

    public synchronized void addListener(int i, Observer observer) {
        this.observers.put(Integer.valueOf(i), observer);
    }

    public synchronized void setListener(int i, Observer observer) {
        this.observers.remove(Integer.valueOf(i));
        this.observers.put(Integer.valueOf(i), observer);
    }

    public synchronized void remove(Observer observer) {
        this.observers.removeValue(observer);
    }

    public void notify(Object obj, int i, Object... objArr) {
        Log.i(TAG, Integer.valueOf(i));
        synchronized (this) {
            ArrayList<Observer> arrayList = this.observers.get(Integer.valueOf(i));
            if (arrayList != null) {
                Observer[] observerArr = new Observer[arrayList.size()];
                arrayList.toArray(observerArr);
                if (observerArr != null) {
                    for (Observer observer : observerArr) {
                        if (observer != null) {
                            try {
                                observer.onNotify(obj, i, objArr);
                            } catch (Throwable th) {
                                Log.e(TAG, th.getMessage(), th);
                            }
                        }
                    }
                }
            }
        }
    }

    public void notify(int i, Object... objArr) {
        notify(null, i, objArr);
    }
}
