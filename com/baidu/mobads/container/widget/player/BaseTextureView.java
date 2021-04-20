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
    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = TextureView.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = TextureView.getDefaultSize(this.mVideoHeight, i2);
        int i4 = this.mVideoWidth;
        if (i4 > 0 && (i3 = this.mVideoHeight) > 0) {
            int i5 = this.mDisplayMode;
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
        Log.i("BaseTextureView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight)));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
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
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.baidu.mobads.container.widget.player.ISurfaceView
    public void onVideoSizeChanged(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        if (i == 0 || i2 == 0) {
            return;
        }
        resetSize();
    }

    @Override // com.baidu.mobads.container.widget.player.ISurfaceView
    public void setDisplayMode(int i) {
        this.mDisplayMode = i;
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
