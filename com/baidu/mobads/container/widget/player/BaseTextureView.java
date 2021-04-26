package com.baidu.mobads.container.widget.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
@TargetApi(14)
/* loaded from: classes2.dex */
public class BaseTextureView extends TextureView implements TextureView.SurfaceTextureListener, ISurfaceView {
    public int mDisplayMode;
    public SurfaceTexture mSurface;
    public ITextureListener mTextureListener;
    public int mVideoHeight;
    public int mVideoWidth;

    public BaseTextureView(Context context, ITextureListener iTextureListener) {
        super(context);
        this.mDisplayMode = 1;
        this.mTextureListener = iTextureListener;
        setSurfaceTextureListener(this);
    }

    private void resetSize() {
        requestLayout();
        invalidate();
    }

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int defaultSize = TextureView.getDefaultSize(this.mVideoWidth, i2);
        int defaultSize2 = TextureView.getDefaultSize(this.mVideoHeight, i3);
        int i5 = this.mVideoWidth;
        if (i5 > 0 && (i4 = this.mVideoHeight) > 0) {
            int i6 = this.mDisplayMode;
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
        Log.i("BaseTextureView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight)));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        ITextureListener iTextureListener = this.mTextureListener;
        if (iTextureListener != null) {
            iTextureListener.surfaceCreated(new Surface(surfaceTexture));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        ITextureListener iTextureListener = this.mTextureListener;
        if (iTextureListener != null) {
            iTextureListener.surfaceDestroy();
        }
        this.mSurface = surfaceTexture;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.baidu.mobads.container.widget.player.ISurfaceView
    public void onVideoSizeChanged(int i2, int i3) {
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        resetSize();
    }

    @Override // com.baidu.mobads.container.widget.player.ISurfaceView
    public void setDisplayMode(int i2) {
        this.mDisplayMode = i2;
    }

    @Override // com.baidu.mobads.container.widget.player.ISurfaceView
    @TargetApi(16)
    public void setEndSurface() {
        SurfaceTexture surfaceTexture = this.mSurface;
        if (surfaceTexture != null) {
            setSurfaceTexture(surfaceTexture);
        }
    }
}
