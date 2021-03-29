package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class WalkNaviDisplayOption {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f7442a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f7443b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7444c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7445d = false;

    public Bitmap getImageToAR() {
        return this.f7442a;
    }

    public Bitmap getImageToNormal() {
        return this.f7443b;
    }

    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.f7442a = bitmap;
        return this;
    }

    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.f7443b = bitmap;
        return this;
    }

    public boolean isIsRunInFragment() {
        return this.f7445d;
    }

    public boolean isShowDialogWithExitNavi() {
        return this.f7444c;
    }

    public WalkNaviDisplayOption runInFragment(boolean z) {
        this.f7445d = z;
        return this;
    }

    public WalkNaviDisplayOption showDialogWithExitNavi(boolean z) {
        this.f7444c = z;
        return this;
    }
}
