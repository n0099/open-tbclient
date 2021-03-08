package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes4.dex */
public class WalkNaviDisplayOption {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f2179a;
    private Bitmap b;
    private boolean c = true;
    private boolean d = false;

    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.b = bitmap;
        return this;
    }

    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.f2179a = bitmap;
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
        return this.f2179a;
    }

    public Bitmap getImageToNormal() {
        return this.b;
    }

    public boolean isShowDialogWithExitNavi() {
        return this.c;
    }

    public boolean isIsRunInFragment() {
        return this.d;
    }
}
