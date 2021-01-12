package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes6.dex */
public class BaseNpcModel {

    /* renamed from: a  reason: collision with root package name */
    private String f2985a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f2986b = "";
    private String c = "";
    private Bitmap d = null;
    private String e = "";
    private boolean f = false;

    public String getDownLoadKey() {
        return this.f2985a;
    }

    public void setDownLoadKey(String str) {
        this.f2985a = str;
    }

    public String getOriginTitle() {
        return this.f2986b;
    }

    public void setOriginTitle(String str) {
        this.f2986b = str;
    }

    public String getLocalPath() {
        return this.e;
    }

    public void setLocalPath(String str) {
        this.e = str;
    }

    public String getModelSize() {
        return this.c;
    }

    public void setModelSize(String str) {
        this.c = str;
    }

    public Bitmap getIcon() {
        return this.d;
    }

    public void setIcon(Bitmap bitmap) {
        this.d = bitmap;
    }

    public boolean isLoadFromLocal() {
        return this.f;
    }

    public void setLoadFromLocal(boolean z) {
        this.f = z;
    }
}
