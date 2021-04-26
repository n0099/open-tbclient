package com.baidu.platform.comapi.walknavi.fsm;

import android.util.Log;
import com.baidu.platform.comapi.walknavi.b;
/* loaded from: classes2.dex */
public class WGuideFSM extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    public String f9967a;

    /* renamed from: b  reason: collision with root package name */
    public String f9968b;

    /* renamed from: c  reason: collision with root package name */
    public String f9969c;

    public WGuideFSM() {
        setInitialState("Entry");
        this.f9969c = this.f9967a;
        FSMTable.initTransition();
    }

    private void cacheBackState(String str) {
        if ("North2D".equals(str)) {
            this.f9969c = "North2D";
        } else if ("Car3D".equals(str) || "Entry".equals(str)) {
            this.f9969c = "Car3D";
        }
    }

    private String getBackState(String str) {
        if ("BrowseMap".equals(str)) {
            return this.f9969c;
        }
        return null;
    }

    public static void restoreZoomLevel() {
        int i2 = com.baidu.platform.comapi.walknavi.b.a.f9818c;
        if (i2 < 15) {
            i2 = 15;
        } else if (i2 > 20) {
            i2 = 19;
        }
        com.baidu.platform.comapi.walknavi.b.a.f9818c = i2;
    }

    public static void saveZoomLevel() {
        int k = (int) b.a().G().k();
        if (k < 15) {
            k = 15;
        } else if (k > 20) {
            k = 19;
        }
        com.baidu.platform.comapi.walknavi.b.a.f9818c = k;
    }

    private void stateReflection(String str, String str2) {
        try {
            Class<?> cls = Class.forName(RGState.PACKAGE_NAME + "." + RGState.CLASS_PREFIX + str);
            cls.getMethod(str2, new Class[0]).invoke(cls.newInstance(), new Object[0]);
        } catch (Exception e2) {
            Log.e(WGuideFSM.class.getName(), e2.toString());
        }
    }

    public String getCurrentEvent() {
        return this.f9968b;
    }

    public String getCurrentState() {
        return this.f9967a;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        FSMTable.release();
    }

    public synchronized void run(String str) {
        String str2 = this.f9967a;
        String queryDestState = FSMTable.queryDestState(str2, str);
        if (queryDestState != null) {
            this.f9968b = str;
            if ("BACK".equals(queryDestState)) {
                queryDestState = getBackState(str2);
            }
            stateReflection(str2, "exit");
            stateReflection(queryDestState, RGState.METHOD_NAME_ENTER);
            stateReflection(queryDestState, RGState.METHOD_NAME_EXCUTE);
            this.f9967a = queryDestState;
            cacheBackState(queryDestState);
        }
    }

    public synchronized void runCurrentState() {
        if (!this.f9967a.equalsIgnoreCase("Entry")) {
            stateReflection(this.f9967a, RGState.METHOD_NAME_EXCUTE);
        }
    }

    public synchronized void runEntryState() {
        if (b.a().J() == 4) {
            this.f9967a = "SegEntry";
        } else {
            this.f9967a = "Entry";
        }
        stateReflection(this.f9967a, RGState.METHOD_NAME_EXCUTE);
    }

    public void setInitialState(String str) {
        this.f9967a = str;
    }
}
