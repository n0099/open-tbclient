package com.baidu.searchbox.util;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class KVFileObserver {
    public static final boolean DEBUG = false;
    public static final String TAG = "KVFileObserver";
    public ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> mListeners = new ArrayList<>();

    public boolean hasListeners() {
        boolean z;
        synchronized (this) {
            if (this.mListeners.size() > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public void addListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.mListeners.add(onSharedPreferenceChangeListener);
        }
    }

    public void removeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.mListeners.remove(onSharedPreferenceChangeListener);
        }
    }

    public void notifyListeners(SharedPreferences sharedPreferences, List<String> list) {
        ArrayList arrayList;
        if (list != null && list.size() != 0) {
            synchronized (this) {
                arrayList = new ArrayList(this.mListeners);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
                if (onSharedPreferenceChangeListener != null) {
                    for (int i = 0; i < list.size(); i++) {
                        onSharedPreferenceChangeListener.onSharedPreferenceChanged(sharedPreferences, list.get(i));
                    }
                }
            }
        }
    }
}
