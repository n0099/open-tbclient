package com.baidu.searchbox.abtest;

import android.util.Log;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.ABTestConfig;
import com.baidu.tieba.j8;
import com.baidu.tieba.k8;
import com.baidu.tieba.q8;
import com.baidu.tieba.s8;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AbTestManager {
    public static final boolean DEBUG = ABTestConfig.isDebug();
    public static final String TAG = "AbTestManager";
    public static AbTestManager mAbTestManager;
    public k8 mExperimentManager = k8.n(AppRuntime.getAppContext());

    @Deprecated
    public void addEvent(String str) {
    }

    public static AbTestManager getInstance() {
        if (mAbTestManager == null) {
            synchronized (AbTestManager.class) {
                if (mAbTestManager == null) {
                    mAbTestManager = new AbTestManager();
                }
            }
        }
        return mAbTestManager;
    }

    public void forceReloadConfig() {
        this.mExperimentManager.h();
        BdEventBus.Companion.getDefault().post(new s8());
    }

    public String getExpInfos() {
        return this.mExperimentManager.m();
    }

    public ArrayList<j8> getExperimentInfoList() {
        return this.mExperimentManager.l();
    }

    public JSONObject getRawSwitch() {
        return this.mExperimentManager.q();
    }

    public void addLocalExpInfo(q8 q8Var) {
        this.mExperimentManager.g(q8Var);
    }

    @Deprecated
    public void forceReloadConfig(List<String> list) {
        this.mExperimentManager.i(list);
    }

    public JSONObject getRawSwitch(int i) {
        return this.mExperimentManager.q();
    }

    public Object getSwitch(String str) {
        Object t = this.mExperimentManager.t(str);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + t);
        }
        return t;
    }

    public boolean has(String str) {
        boolean v = this.mExperimentManager.v(str);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " has key: " + v);
        }
        return v;
    }

    public boolean isInExperiment(int i) {
        return this.mExperimentManager.x(i);
    }

    public ArrayList<String> getSidsFromTids(ArrayList<Integer> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<j8> l = this.mExperimentManager.l();
        if (l == null) {
            return arrayList2;
        }
        for (int i = 0; i < l.size(); i++) {
            j8 j8Var = l.get(i);
            if (j8Var != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2).intValue() == j8Var.c()) {
                        arrayList2.add(j8Var.c() + "_" + j8Var.b());
                    }
                }
            }
        }
        return arrayList2;
    }

    public double getSwitch(String str, double d) {
        double k = this.mExperimentManager.k(str, d);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + k + " default value :" + d);
        }
        return k;
    }

    @Deprecated
    public int getValueFromOldABCache(String str, int i) {
        return this.mExperimentManager.u(str, i);
    }

    public int getSwitch(String str, int i) {
        int o = this.mExperimentManager.o(str, i);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + o + " default value :" + i);
        }
        return o;
    }

    public long getSwitch(String str, long j) {
        long p = this.mExperimentManager.p(str, j);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + p + " default value :" + j);
        }
        return p;
    }

    public String getSwitch(String str, String str2) {
        String r = this.mExperimentManager.r(str, str2);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + r + " default value :" + str2);
        }
        return r;
    }

    public boolean getSwitch(String str, boolean z) {
        boolean j = this.mExperimentManager.j(str, z);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + j + " default value :" + z);
        }
        return j;
    }
}
