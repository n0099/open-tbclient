package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class BaseNpcModel {

    /* renamed from: a  reason: collision with root package name */
    public String f7471a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f7472b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f7473c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f7474d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f7475e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f7476f = false;

    public String getDownLoadKey() {
        return this.f7471a;
    }

    public Bitmap getIcon() {
        return this.f7474d;
    }

    public String getLocalPath() {
        return this.f7475e;
    }

    public String getModelSize() {
        return this.f7473c;
    }

    public String getOriginTitle() {
        return this.f7472b;
    }

    public boolean isLoadFromLocal() {
        return this.f7476f;
    }

    public void setDownLoadKey(String str) {
        this.f7471a = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.f7474d = bitmap;
    }

    public void setLoadFromLocal(boolean z) {
        this.f7476f = z;
    }

    public void setLocalPath(String str) {
        this.f7475e = str;
    }

    public void setModelSize(String str) {
        this.f7473c = str;
    }

    public void setOriginTitle(String str) {
        this.f7472b = str;
    }
}
