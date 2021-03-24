package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class BaseNpcModel {

    /* renamed from: a  reason: collision with root package name */
    public String f7435a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f7436b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f7437c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f7438d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f7439e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f7440f = false;

    public String getDownLoadKey() {
        return this.f7435a;
    }

    public Bitmap getIcon() {
        return this.f7438d;
    }

    public String getLocalPath() {
        return this.f7439e;
    }

    public String getModelSize() {
        return this.f7437c;
    }

    public String getOriginTitle() {
        return this.f7436b;
    }

    public boolean isLoadFromLocal() {
        return this.f7440f;
    }

    public void setDownLoadKey(String str) {
        this.f7435a = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.f7438d = bitmap;
    }

    public void setLoadFromLocal(boolean z) {
        this.f7440f = z;
    }

    public void setLocalPath(String str) {
        this.f7439e = str;
    }

    public void setModelSize(String str) {
        this.f7437c = str;
    }

    public void setOriginTitle(String str) {
        this.f7436b = str;
    }
}
