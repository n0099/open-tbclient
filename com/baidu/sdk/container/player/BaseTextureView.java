package com.baidu.sdk.container.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import d.a.f0.a.i.c;
import d.a.f0.a.i.d;
@TargetApi(14)
/* loaded from: classes2.dex */
public class BaseTextureView extends TextureView implements TextureView.SurfaceTextureListener, c {

    /* renamed from: e  reason: collision with root package name */
    public int f9972e;

    /* renamed from: f  reason: collision with root package name */
    public int f9973f;

    /* renamed from: g  reason: collision with root package name */
    public int f9974g;

    /* renamed from: h  reason: collision with root package name */
    public d f9975h;

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f9976i;

    public BaseTextureView(Context context, d dVar) {
        super(context);
        this.f9972e = 1;
        this.f9975h = dVar;
        setSurfaceTextureListener(this);
    }

    public final void a() {
        requestLayout();
        invalidate();
    }

    public int getDisplayMode() {
        return this.f9972e;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int defaultSize = TextureView.getDefaultSize(this.f9973f, i2);
        int defaultSize2 = TextureView.getDefaultSize(this.f9974g, i3);
        int i5 = this.f9973f;
        if (i5 > 0 && (i4 = this.f9974g) > 0) {
            int i6 = this.f9972e;
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
        Log.i("BaseTextureView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.f9973f), Integer.valueOf(this.f9974g)));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        d dVar = this.f9975h;
        if (dVar != null) {
            dVar.surfaceCreated(new Surface(surfaceTexture));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        d dVar = this.f9975h;
        if (dVar != null) {
            dVar.surfaceDestroy();
        }
        this.f9976i = surfaceTexture;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // d.a.f0.a.i.c
    public void onVideoSizeChanged(int i2, int i3) {
        this.f9973f = i2;
        this.f9974g = i3;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        a();
    }

    @Override // d.a.f0.a.i.c
    public void setDisplayMode(int i2) {
        this.f9972e = i2;
    }

    @TargetApi(16)
    public void setEndSurface() {
        SurfaceTexture surfaceTexture = this.f9976i;
        if (surfaceTexture != null) {
            setSurfaceTexture(surfaceTexture);
        }
    }
}
