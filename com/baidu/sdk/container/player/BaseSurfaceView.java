package com.baidu.sdk.container.player;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import d.a.f0.a.i.b;
import d.a.f0.a.i.c;
/* loaded from: classes2.dex */
public class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback, c {

    /* renamed from: e  reason: collision with root package name */
    public int f10030e;

    /* renamed from: f  reason: collision with root package name */
    public int f10031f;

    /* renamed from: g  reason: collision with root package name */
    public int f10032g;

    /* renamed from: h  reason: collision with root package name */
    public b f10033h;

    public BaseSurfaceView(Context context, b bVar) {
        super(context);
        this.f10030e = 1;
        this.f10033h = bVar;
        getHolder().addCallback(this);
    }

    public final void a() {
        requestLayout();
        invalidate();
    }

    public int getDisplayMode() {
        return this.f10030e;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int defaultSize = SurfaceView.getDefaultSize(this.f10031f, i2);
        int defaultSize2 = SurfaceView.getDefaultSize(this.f10032g, i3);
        int i5 = this.f10031f;
        if (i5 > 0 && (i4 = this.f10032g) > 0) {
            int i6 = this.f10030e;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 3) {
                        defaultSize = i5;
                        defaultSize2 = i4;
                    } else if (i6 == 4) {
                        int i7 = defaultSize * 9;
                        int i8 = defaultSize2 * 16;
                        if (i7 < i8) {
                            defaultSize2 = i7 / 16;
                        } else if (i7 > i8) {
                            defaultSize = i8 / 9;
                        }
                    } else if (i6 == 5) {
                        int i9 = defaultSize * 3;
                        int i10 = defaultSize2 * 4;
                        if (i9 < i10) {
                            defaultSize2 = i9 / 4;
                        } else if (i9 > i10) {
                            defaultSize = i10 / 3;
                        }
                    } else if (i6 == 6) {
                        defaultSize = (i5 * defaultSize2) / i4;
                    } else if (i6 == 7) {
                        if (i5 * defaultSize2 > defaultSize * i4) {
                            defaultSize = (i5 * defaultSize2) / i4;
                        } else if (i5 * defaultSize2 < defaultSize * i4) {
                            defaultSize2 = (i4 * defaultSize) / i5;
                        }
                    }
                } else if (i5 * defaultSize2 > defaultSize * i4) {
                    defaultSize2 = (i4 * defaultSize) / i5;
                } else if (i5 * defaultSize2 < defaultSize * i4) {
                    defaultSize = (i5 * defaultSize2) / i4;
                }
            } else if (i3 * i5 > i2 * i4 && i5 * defaultSize2 > defaultSize * i4) {
                defaultSize2 = (i4 * defaultSize) / i5;
            }
        }
        Log.d("BaseSurfaceView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.f10031f), Integer.valueOf(this.f10032g)));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // d.a.f0.a.i.c
    public void onVideoSizeChanged(int i2, int i3) {
        this.f10031f = i2;
        this.f10032g = i3;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        a();
    }

    @Override // d.a.f0.a.i.c
    public void setDisplayMode(int i2) {
        this.f10030e = i2;
    }

    public void setEndSurface() {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        b bVar = this.f10033h;
        if (bVar != null) {
            bVar.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b bVar = this.f10033h;
        if (bVar != null) {
            bVar.surfaceDestroy();
        }
    }
}
