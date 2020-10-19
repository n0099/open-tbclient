package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
import android.graphics.Typeface;
/* loaded from: classes7.dex */
public class WalkNaviDisplayOption implements com.baidu.mapapi.walknavi.adapter.a {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f2175a = null;
    private Bitmap b = null;
    private Bitmap c = null;
    private Bitmap d = null;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private int h = 0;
    private boolean i = false;
    private int j = 0;
    private boolean k = false;
    private int l = 0;
    private Typeface m = null;

    /* JADX DEBUG: Method merged with bridge method */
    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.f2175a = bitmap;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.b = bitmap;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public WalkNaviDisplayOption setTopGuideLayout(int i) {
        this.g = true;
        this.h = i;
        return this;
    }

    public com.baidu.mapapi.walknavi.adapter.a setCalorieLayout(int i) {
        this.i = true;
        this.j = i;
        return this;
    }

    public com.baidu.mapapi.walknavi.adapter.a setBottomSettingLayout(int i) {
        this.k = true;
        this.l = i;
        return this;
    }

    public com.baidu.mapapi.walknavi.adapter.a setNaviTextTypeface(Typeface typeface) {
        this.m = typeface;
        return this;
    }

    public com.baidu.mapapi.walknavi.adapter.a setArNaviResources(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.c = bitmap;
        this.d = bitmap2;
        this.b = bitmap3;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public WalkNaviDisplayOption showDialogWithExitNavi(boolean z) {
        this.e = z;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public WalkNaviDisplayOption runInFragment(boolean z) {
        this.f = z;
        return this;
    }

    public Bitmap getImageToAR() {
        return this.f2175a;
    }

    public Bitmap getImageToNormal() {
        return this.b;
    }

    public Bitmap getImageNPC() {
        return this.d;
    }

    public Bitmap getImageArCloseIcon() {
        return this.c;
    }

    public boolean isShowDialogWithExitNavi() {
        return this.e;
    }

    public boolean isIsRunInFragment() {
        return this.f;
    }

    public boolean getIsCustomWNaviGuideLayout() {
        return this.g;
    }

    public int getTopGuideLayout() {
        return this.h;
    }

    public boolean getIsCustomWNaviCalorieLayout() {
        return this.i;
    }

    public int getCalorieLayout() {
        return this.j;
    }

    public boolean getIsCustomWNaviRgBarLayout() {
        return this.k;
    }

    public int getBottomSettingLayout() {
        return this.l;
    }

    public Typeface getWNaviTextTypeface() {
        return this.m;
    }
}
