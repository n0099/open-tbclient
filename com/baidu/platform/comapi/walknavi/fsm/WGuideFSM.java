package com.baidu.platform.comapi.walknavi.fsm;

import android.util.Log;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.platform.comapi.walknavi.b;
/* loaded from: classes5.dex */
public class WGuideFSM extends com.baidu.platform.comapi.walknavi.a {
    private String a;
    private String b;
    private String c;

    public WGuideFSM() {
        setInitialState("Entry");
        this.c = this.a;
        FSMTable.initTransition();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        FSMTable.release();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public void setInitialState(String str) {
        this.a = str;
    }

    public synchronized void runCurrentState() {
        if (!this.a.equalsIgnoreCase("Entry")) {
            stateReflection(this.a, RGState.METHOD_NAME_EXCUTE);
        }
    }

    public synchronized void runEntryState() {
        if (b.a().J() == 4) {
            this.a = "SegEntry";
        } else {
            this.a = "Entry";
        }
        stateReflection(this.a, RGState.METHOD_NAME_EXCUTE);
    }

    public synchronized void run(String str) {
        String str2 = this.a;
        String queryDestState = FSMTable.queryDestState(str2, str);
        if (queryDestState != null) {
            this.b = str;
            if ("BACK".equals(queryDestState)) {
                queryDestState = getBackState(str2);
            }
            stateReflection(str2, RGState.METHOD_NAME_EXIT);
            stateReflection(queryDestState, "enter");
            stateReflection(queryDestState, RGState.METHOD_NAME_EXCUTE);
            this.a = queryDestState;
            cacheBackState(queryDestState);
        }
    }

    public String getCurrentState() {
        return this.a;
    }

    public String getCurrentEvent() {
        return this.b;
    }

    public static void saveZoomLevel() {
        int i = 15;
        int k = (int) b.a().G().k();
        if (k >= 15) {
            i = k > 20 ? 19 : k;
        }
        com.baidu.platform.comapi.walknavi.b.a.c = i;
    }

    public static void restoreZoomLevel() {
        int i = 15;
        int i2 = com.baidu.platform.comapi.walknavi.b.a.c;
        if (i2 >= 15) {
            i = i2 > 20 ? 19 : i2;
        }
        com.baidu.platform.comapi.walknavi.b.a.c = i;
    }

    private void stateReflection(String str, String str2) {
        try {
            Class<?> cls = Class.forName(RGState.PACKAGE_NAME + DefaultConfig.TOKEN_SEPARATOR + RGState.CLASS_PREFIX + str);
            cls.getMethod(str2, new Class[0]).invoke(cls.newInstance(), new Object[0]);
        } catch (Exception e) {
            Log.e(WGuideFSM.class.getName(), e.toString());
        }
    }

    private void cacheBackState(String str) {
        if ("North2D".equals(str)) {
            this.c = "North2D";
        } else if ("Car3D".equals(str) || "Entry".equals(str)) {
            this.c = "Car3D";
        }
    }

    private String getBackState(String str) {
        if (!"BrowseMap".equals(str)) {
            return null;
        }
        return this.c;
    }
}
