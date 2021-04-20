package com.baidu.sdk.container.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import d.b.c0.a.i.c;
import d.b.c0.a.i.d;
@TargetApi(14)
/* loaded from: classes2.dex */
public class BaseTextureView extends TextureView implements TextureView.SurfaceTextureListener, c {

    /* renamed from: e  reason: collision with root package name */
    public int f11223e;

    /* renamed from: f  reason: collision with root package name */
    public int f11224f;

    /* renamed from: g  reason: collision with root package name */
    public int f11225g;

    /* renamed from: h  reason: collision with root package name */
    public d f11226h;
    public SurfaceTexture i;

    public BaseTextureView(Context context, d dVar) {
        super(context);
        this.f11223e = 1;
        this.f11226h = dVar;
        setSurfaceTextureListener(this);
    }

    public final void a() {
        requestLayout();
        invalidate();
    }

    public int getDisplayMode() {
        return this.f11223e;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = TextureView.getDefaultSize(this.f11224f, i);
        int defaultSize2 = TextureView.getDefaultSize(this.f11225g, i2);
        int i4 = this.f11224f;
        if (i4 > 0 && (i3 = this.f11225g) > 0) {
            int i5 = this.f11223e;
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
        Log.i("BaseTextureView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.f11224f), Integer.valueOf(this.f11225g)));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        d dVar = this.f11226h;
        if (dVar != null) {
            dVar.surfaceCreated(new Surface(surfaceTexture));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        d dVar = this.f11226h;
        if (dVar != null) {
            dVar.surfaceDestroy();
        }
        this.i = surfaceTexture;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // d.b.c0.a.i.c
    public void onVideoSizeChanged(int i, int i2) {
        this.f11224f = i;
        this.f11225g = i2;
        if (i == 0 || i2 == 0) {
            return;
        }
        a();
    }

    @Override // d.b.c0.a.i.c
    public void setDisplayMode(int i) {
        this.f11223e = i;
    }

    @TargetApi(16)
    public void setEndSurface() {
        SurfaceTexture surfaceTexture = this.i;
        if (surfaceTexture != null) {
            setSurfaceTexture(surfaceTexture);
        }
    }
}
