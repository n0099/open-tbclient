package com.baidu.sdk.container.player;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import d.b.d0.a.i.b;
import d.b.d0.a.i.c;
/* loaded from: classes2.dex */
public class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback, c {

    /* renamed from: e  reason: collision with root package name */
    public int f11219e;

    /* renamed from: f  reason: collision with root package name */
    public int f11220f;

    /* renamed from: g  reason: collision with root package name */
    public int f11221g;

    /* renamed from: h  reason: collision with root package name */
    public b f11222h;

    public BaseSurfaceView(Context context, b bVar) {
        super(context);
        this.f11219e = 1;
        this.f11222h = bVar;
        getHolder().addCallback(this);
    }

    public final void a() {
        requestLayout();
        invalidate();
    }

    public int getDisplayMode() {
        return this.f11219e;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = SurfaceView.getDefaultSize(this.f11220f, i);
        int defaultSize2 = SurfaceView.getDefaultSize(this.f11221g, i2);
        int i4 = this.f11220f;
        if (i4 > 0 && (i3 = this.f11221g) > 0) {
            int i5 = this.f11219e;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 3) {
                        defaultSize = i4;
                        defaultSize2 = i3;
                    } else if (i5 == 4) {
                        int i6 = defaultSize * 9;
                        int i7 = defaultSize2 * 16;
                        if (i6 < i7) {
                            defaultSize2 = i6 / 16;
                        } else if (i6 > i7) {
                            defaultSize = i7 / 9;
                        }
                    } else if (i5 == 5) {
                        int i8 = defaultSize * 3;
                        int i9 = defaultSize2 * 4;
                        if (i8 < i9) {
                            defaultSize2 = i8 / 4;
                        } else if (i8 > i9) {
                            defaultSize = i9 / 3;
                        }
                    } else if (i5 == 6) {
                        defaultSize = (i4 * defaultSize2) / i3;
                    } else if (i5 == 7) {
                        if (i4 * defaultSize2 > defaultSize * i3) {
                            defaultSize = (i4 * defaultSize2) / i3;
                        } else if (i4 * defaultSize2 < defaultSize * i3) {
                            defaultSize2 = (i3 * defaultSize) / i4;
                        }
                    }
                } else if (i4 * defaultSize2 > defaultSize * i3) {
                    defaultSize2 = (i3 * defaultSize) / i4;
                } else if (i4 * defaultSize2 < defaultSize * i3) {
                    defaultSize = (i4 * defaultSize2) / i3;
                }
            } else if (i2 * i4 > i * i3 && i4 * defaultSize2 > defaultSize * i3) {
                defaultSize2 = (i3 * defaultSize) / i4;
            }
        }
        Log.d("BaseSurfaceView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.f11220f), Integer.valueOf(this.f11221g)));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // d.b.d0.a.i.c
    public void onVideoSizeChanged(int i, int i2) {
        this.f11220f = i;
        this.f11221g = i2;
        if (i == 0 || i2 == 0) {
            return;
        }
        a();
    }

    @Override // d.b.d0.a.i.c
    public void setDisplayMode(int i) {
        this.f11219e = i;
    }

    public void setEndSurface() {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        b bVar = this.f11222h;
        if (bVar != null) {
            bVar.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b bVar = this.f11222h;
        if (bVar != null) {
            bVar.surfaceDestroy();
        }
    }
}
