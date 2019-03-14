package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class WalkNaviDisplayOption {
    private Bitmap a;
    private Bitmap b;
    private boolean c = true;
    private boolean d = false;

    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.b = bitmap;
        return this;
    }

    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.a = bitmap;
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
        return this.a;
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
