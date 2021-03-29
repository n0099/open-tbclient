package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class BaseNpcModel {

    /* renamed from: a  reason: collision with root package name */
    public String f7436a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f7437b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f7438c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f7439d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f7440e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f7441f = false;

    public String getDownLoadKey() {
        return this.f7436a;
    }

    public Bitmap getIcon() {
        return this.f7439d;
    }

    public String getLocalPath() {
        return this.f7440e;
    }

    public String getModelSize() {
        return this.f7438c;
    }

    public String getOriginTitle() {
        return this.f7437b;
    }

    public boolean isLoadFromLocal() {
        return this.f7441f;
    }

    public void setDownLoadKey(String str) {
        this.f7436a = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.f7439d = bitmap;
    }

    public void setLoadFromLocal(boolean z) {
        this.f7441f = z;
    }

    public void setLocalPath(String str) {
        this.f7440e = str;
    }

    public void setModelSize(String str) {
        this.f7438c = str;
    }

    public void setOriginTitle(String str) {
        this.f7437b = str;
    }
}
