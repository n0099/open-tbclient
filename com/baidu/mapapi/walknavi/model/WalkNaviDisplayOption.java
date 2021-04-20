package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class WalkNaviDisplayOption {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f7477a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f7478b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7479c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7480d = false;

    public Bitmap getImageToAR() {
        return this.f7477a;
    }

    public Bitmap getImageToNormal() {
        return this.f7478b;
    }

    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.f7477a = bitmap;
        return this;
    }

    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.f7478b = bitmap;
        return this;
    }

    public boolean isIsRunInFragment() {
        return this.f7480d;
    }

    public boolean isShowDialogWithExitNavi() {
        return this.f7479c;
    }

    public WalkNaviDisplayOption runInFragment(boolean z) {
        this.f7480d = z;
        return this;
    }

    public WalkNaviDisplayOption showDialogWithExitNavi(boolean z) {
        this.f7479c = z;
        return this;
    }
}
