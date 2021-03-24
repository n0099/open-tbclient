package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class WalkNaviDisplayOption {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f7441a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f7442b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7443c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7444d = false;

    public Bitmap getImageToAR() {
        return this.f7441a;
    }

    public Bitmap getImageToNormal() {
        return this.f7442b;
    }

    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.f7441a = bitmap;
        return this;
    }

    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.f7442b = bitmap;
        return this;
    }

    public boolean isIsRunInFragment() {
        return this.f7444d;
    }

    public boolean isShowDialogWithExitNavi() {
        return this.f7443c;
    }

    public WalkNaviDisplayOption runInFragment(boolean z) {
        this.f7444d = z;
        return this;
    }

    public WalkNaviDisplayOption showDialogWithExitNavi(boolean z) {
        this.f7443c = z;
        return this;
    }
}
