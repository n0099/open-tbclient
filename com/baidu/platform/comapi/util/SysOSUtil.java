package com.baidu.platform.comapi.util;

import com.baidu.vi.VIContext;
/* loaded from: classes3.dex */
public class SysOSUtil {
    private static SysOSUtil g = new SysOSUtil();

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.platform.comapi.util.a.b f4377a = null;

    /* renamed from: b  reason: collision with root package name */
    private com.baidu.platform.comapi.util.a.a f4378b = null;
    private boolean c = false;
    private String d = "";
    private String e = "";
    private String f = "";

    private SysOSUtil() {
    }

    public static SysOSUtil getInstance() {
        return g;
    }

    public float getDensity() {
        if (this.f4378b != null) {
            return this.f4378b.c();
        }
        return 1.0f;
    }

    public int getDensityDPI() {
        if (this.f4378b != null) {
            return this.f4378b.d();
        }
        return 1;
    }

    public String getGLRenderer() {
        return this.f;
    }

    public String getGLVersion() {
        return this.e;
    }

    public String getNetType() {
        return this.d;
    }

    public String getOutputCache() {
        return this.f4377a != null ? this.f4377a.c() : "";
    }

    public String getOutputDirPath() {
        return this.f4377a != null ? this.f4377a.a() : "";
    }

    public int getScreenHeight() {
        if (this.f4378b != null) {
            return this.f4378b.b();
        }
        return 0;
    }

    public int getScreenWidth() {
        if (this.f4378b != null) {
            return this.f4378b.a();
        }
        return 0;
    }

    public String getSdcardPath() {
        return this.f4377a != null ? this.f4377a.b() : "";
    }

    public void init(com.baidu.platform.comapi.util.a.b bVar, com.baidu.platform.comapi.util.a.a aVar) {
        if (this.c) {
            return;
        }
        this.f4377a = bVar;
        this.f4378b = aVar;
        if (this.f4377a == null) {
            this.f4377a = new com.baidu.platform.comapi.util.a.b();
        }
        if (this.f4378b == null) {
            this.f4378b = new com.baidu.platform.comapi.util.a.a();
        }
        this.f4377a.a(VIContext.getContext());
        this.f4378b.a(VIContext.getContext());
        this.d = NetworkUtil.getCurrentNetMode(VIContext.getContext());
        this.c = true;
    }

    public void setGLInfo(String str, String str2) {
        if (this.f.equals(str2) && this.e.equals(str)) {
            return;
        }
        this.e = str;
        this.f = str2;
    }

    public void updateNetType(String str) {
        this.d = str;
    }
}
