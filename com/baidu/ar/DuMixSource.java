package com.baidu.ar;

import android.graphics.SurfaceTexture;
/* loaded from: classes3.dex */
public class DuMixSource {
    private String a;
    private int b;
    private String c;
    private boolean d;
    private SurfaceTexture e;
    private int f;
    private int g;

    public DuMixSource(DuMixSource duMixSource) {
        this.b = -1;
        this.d = false;
        this.f = 0;
        this.g = 0;
        this.a = duMixSource.getArKey();
        this.b = duMixSource.getArType();
        this.c = duMixSource.getResFilePath();
        this.e = duMixSource.getCameraSource();
        this.f = duMixSource.getSourceWidth();
        this.g = duMixSource.getSourceHeight();
    }

    public DuMixSource(String str) {
        this.b = -1;
        this.d = false;
        this.f = 0;
        this.g = 0;
        this.a = str;
    }

    public DuMixSource(String str, int i, String str2) {
        this.b = -1;
        this.d = false;
        this.f = 0;
        this.g = 0;
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    public DuMixSource(String str, int i, String str2, SurfaceTexture surfaceTexture, int i2, int i3) {
        this.b = -1;
        this.d = false;
        this.f = 0;
        this.g = 0;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.e = surfaceTexture;
        this.f = i2;
        this.g = i3;
    }

    public DuMixSource(String str, SurfaceTexture surfaceTexture, int i, int i2) {
        this.b = -1;
        this.d = false;
        this.f = 0;
        this.g = 0;
        this.a = str;
        this.e = surfaceTexture;
        this.f = i;
        this.g = i2;
    }

    public String getArKey() {
        return this.a;
    }

    public int getArType() {
        return this.b;
    }

    public SurfaceTexture getCameraSource() {
        return this.e;
    }

    public String getResFilePath() {
        return this.c;
    }

    public int getSourceHeight() {
        return this.g;
    }

    public int getSourceWidth() {
        return this.f;
    }

    public boolean isFrontCamera() {
        return this.d;
    }

    public void setArKey(String str) {
        this.a = str;
    }

    public void setArType(int i) {
        this.b = i;
    }

    public void setCameraSource(SurfaceTexture surfaceTexture) {
        this.e = surfaceTexture;
    }

    public void setFrontCamera(boolean z) {
        this.d = z;
    }

    public void setResFilePath(String str) {
        this.c = str;
    }

    public void setSourceHeight(int i) {
        this.g = i;
    }

    public void setSourceWidth(int i) {
        this.f = i;
    }
}
