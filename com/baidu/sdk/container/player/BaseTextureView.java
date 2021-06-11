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
    public int f10034e;

    /* renamed from: f  reason: collision with root package name */
    public int f10035f;

    /* renamed from: g  reason: collision with root package name */
    public int f10036g;

    /* renamed from: h  reason: collision with root package name */
    public d f10037h;

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f10038i;

    public BaseTextureView(Context context, d dVar) {
        super(context);
        this.f10034e = 1;
        this.f10037h = dVar;
        setSurfaceTextureListener(this);
    }

    public final void a() {
        requestLayout();
        invalidate();
    }

    public int getDisplayMode() {
        return this.f10034e;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int defaultSize = TextureView.getDefaultSize(this.f10035f, i2);
        int defaultSize2 = TextureView.getDefaultSize(this.f10036g, i3);
        int i5 = this.f10035f;
        if (i5 > 0 && (i4 = this.f10036g) > 0) {
            int i6 = this.f10034e;
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
        Log.i("BaseTextureView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.f10035f), Integer.valueOf(this.f10036g)));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        d dVar = this.f10037h;
        if (dVar != null) {
            dVar.surfaceCreated(new Surface(surfaceTexture));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        d dVar = this.f10037h;
        if (dVar != null) {
            dVar.surfaceDestroy();
        }
        this.f10038i = surfaceTexture;
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
        this.f10035f = i2;
        this.f10036g = i3;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        a();
    }

    @Override // d.a.f0.a.i.c
    public void setDisplayMode(int i2) {
        this.f10034e = i2;
    }

    @TargetApi(16)
    public void setEndSurface() {
        SurfaceTexture surfaceTexture = this.f10038i;
        if (surfaceTexture != null) {
            setSurfaceTexture(surfaceTexture);
        }
    }
}
