package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class WalkNaviDisplayOption {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f7744a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f7745b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7746c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7747d = false;

    public Bitmap getImageToAR() {
        return this.f7744a;
    }

    public Bitmap getImageToNormal() {
        return this.f7745b;
    }

    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.f7744a = bitmap;
        return this;
    }

    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.f7745b = bitmap;
        return this;
    }

    public boolean isIsRunInFragment() {
        return this.f7747d;
    }

    public boolean isShowDialogWithExitNavi() {
        return this.f7746c;
    }

    public WalkNaviDisplayOption runInFragment(boolean z) {
        this.f7747d = z;
        return this;
    }

    public WalkNaviDisplayOption showDialogWithExitNavi(boolean z) {
        this.f7746c = z;
        return this;
    }
}
