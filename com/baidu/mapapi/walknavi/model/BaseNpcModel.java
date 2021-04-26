package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class BaseNpcModel {

    /* renamed from: a  reason: collision with root package name */
    public String f7738a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f7739b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f7740c = "";

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f7741d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f7742e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f7743f = false;

    public String getDownLoadKey() {
        return this.f7738a;
    }

    public Bitmap getIcon() {
        return this.f7741d;
    }

    public String getLocalPath() {
        return this.f7742e;
    }

    public String getModelSize() {
        return this.f7740c;
    }

    public String getOriginTitle() {
        return this.f7739b;
    }

    public boolean isLoadFromLocal() {
        return this.f7743f;
    }

    public void setDownLoadKey(String str) {
        this.f7738a = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.f7741d = bitmap;
    }

    public void setLoadFromLocal(boolean z) {
        this.f7743f = z;
    }

    public void setLocalPath(String str) {
        this.f7742e = str;
    }

    public void setModelSize(String str) {
        this.f7740c = str;
    }

    public void setOriginTitle(String str) {
        this.f7739b = str;
    }
}
