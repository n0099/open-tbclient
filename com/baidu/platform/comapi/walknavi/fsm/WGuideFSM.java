package com.baidu.platform.comapi.walknavi.fsm;

import android.util.Log;
import com.baidu.platform.comapi.walknavi.b;
/* loaded from: classes7.dex */
public class WGuideFSM extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    private String f3012a;
    private String b;
    private String c;

    public WGuideFSM() {
        setInitialState("Entry");
        this.c = this.f3012a;
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
        this.f3012a = str;
    }

    public synchronized void runCurrentState() {
        if (!this.f3012a.equalsIgnoreCase("Entry")) {
            a(this.f3012a, RGState.METHOD_NAME_EXCUTE);
        }
    }

    public synchronized void runEntryState() {
        if (b.a().M() == 4) {
            this.f3012a = "SegEntry";
        } else {
            this.f3012a = "Entry";
        }
        a(this.f3012a, RGState.METHOD_NAME_EXCUTE);
    }

    public synchronized void run(String str) {
        String str2 = this.f3012a;
        String queryDestState = FSMTable.queryDestState(str2, str);
        if (queryDestState != null) {
            this.b = str;
            if ("BACK".equals(queryDestState)) {
                queryDestState = b(str2);
            }
            a(str2, RGState.METHOD_NAME_EXIT);
            a(queryDestState, "enter");
            a(queryDestState, RGState.METHOD_NAME_EXCUTE);
            this.f3012a = queryDestState;
            a(queryDestState);
        }
    }

    public String getCurrentState() {
        return this.f3012a;
    }

    public String getCurrentEvent() {
        return this.b;
    }

    public static void saveZoomLevel() {
        int i = 15;
        int k = (int) b.a().J().k();
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

    private void a(String str, String str2) {
        try {
            Class<?> cls = Class.forName(RGState.PACKAGE_NAME + "." + RGState.CLASS_PREFIX + str);
            cls.getMethod(str2, new Class[0]).invoke(cls.newInstance(), new Object[0]);
        } catch (Exception e) {
            Log.e(WGuideFSM.class.getName(), e.toString());
        }
    }

    private void a(String str) {
        if ("North2D".equals(str)) {
            this.c = "North2D";
        } else if ("Car3D".equals(str) || "Entry".equals(str)) {
            this.c = "Car3D";
        }
    }

    private String b(String str) {
        if (!"BrowseMap".equals(str)) {
            return null;
        }
        return this.c;
    }
}
