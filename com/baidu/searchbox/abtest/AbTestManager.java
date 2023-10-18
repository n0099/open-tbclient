package com.baidu.searchbox.abtest;

import android.util.Log;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.ABTestConfig;
import com.baidu.tieba.b4;
import com.baidu.tieba.r3;
import com.baidu.tieba.s3;
import com.baidu.tieba.z3;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AbTestManager {
    public static final boolean DEBUG = ABTestConfig.isDebug();
    public static final String TAG = "AbTestManager";
    public static AbTestManager mAbTestManager;
    public s3 mExperimentManager = s3.n(AppRuntime.getAppContext());

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
        BdEventBus.Companion.getDefault().post(new b4());
    }

    public String getExpInfos() {
        return this.mExperimentManager.m();
    }

    public ArrayList<r3> getExperimentInfoList() {
        return this.mExperimentManager.l();
    }

    public JSONObject getRawSwitch() {
        return this.mExperimentManager.q();
    }

    public void addLocalExpInfo(z3 z3Var) {
        this.mExperimentManager.g(z3Var);
    }

    @Deprecated
    public void forceReloadConfig(List<String> list) {
        this.mExperimentManager.i(list);
    }

    public JSONObject getRawSwitch(int i) {
        return this.mExperimentManager.q();
    }

    public Object getSwitch(String str) {
        Object u = this.mExperimentManager.u(str);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + u);
        }
        return u;
    }

    public boolean has(String str) {
        boolean w = this.mExperimentManager.w(str);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " has key: " + w);
        }
        return w;
    }

    public boolean isInExperiment(int i) {
        return this.mExperimentManager.z(i);
    }

    public ArrayList<String> getSidsFromTids(ArrayList<Integer> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<r3> l = this.mExperimentManager.l();
        if (l == null) {
            return arrayList2;
        }
        for (int i = 0; i < l.size(); i++) {
            r3 r3Var = l.get(i);
            if (r3Var != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2).intValue() == r3Var.c()) {
                        arrayList2.add(r3Var.c() + "_" + r3Var.b());
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
        return this.mExperimentManager.v(str, i);
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
        String s = this.mExperimentManager.s(str, str2);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + s + " default value :" + str2);
        }
        return s;
    }

    public boolean getSwitch(String str, boolean z) {
        boolean j = this.mExperimentManager.j(str, z);
        if (DEBUG) {
            Log.d(TAG, " get switch key: " + str + " switch value: " + j + " default value :" + z);
        }
        return j;
    }
}
