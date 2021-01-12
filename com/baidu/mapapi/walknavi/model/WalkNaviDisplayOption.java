package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes6.dex */
public class WalkNaviDisplayOption {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f2987a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f2988b;
    private boolean c = true;
    private boolean d = false;

    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.f2988b = bitmap;
        return this;
    }

    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.f2987a = bitmap;
        return this;
    }

    public WalkNaviDisplayOption showDialogWithExitNavi(boolean z) {
        this.c = z;
        return this;
    }

    public WalkNaviDisplayOption runInFragment(boolean z) {
        this.d = z;
        return this;
    }

    public Bitmap getImageToAR() {
        return this.f2987a;
    }

    public Bitmap getImageToNormal() {
        return this.f2988b;
    }

    public boolean isShowDialogWithExitNavi() {
        return this.c;
    }

    public boolean isIsRunInFragment() {
        return this.d;
    }
}
