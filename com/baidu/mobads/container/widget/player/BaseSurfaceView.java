package com.baidu.mobads.container.widget.player;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes2.dex */
public class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback, ISurfaceView {
    public int mDisplayMode;
    public ISurfaceListener mSurfaceListener;
    public int mVideoHeight;
    public int mVideoWidth;

    public BaseSurfaceView(Context context, ISurfaceListener iSurfaceListener) {
        super(context);
        this.mDisplayMode = 1;
        this.mSurfaceListener = iSurfaceListener;
        getHolder().addCallback(this);
    }

    private void resetSize() {
        requestLayout();
        invalidate();
    }

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = SurfaceView.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = SurfaceView.getDefaultSize(this.mVideoHeight, i2);
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
        Log.d("BaseSurfaceView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight)));
        setMeasuredDimension(defaultSize, defaultSize2);
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
    public void setEndSurface() {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ISurfaceListener iSurfaceListener = this.mSurfaceListener;
        if (iSurfaceListener != null) {
            iSurfaceListener.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ISurfaceListener iSurfaceListener = this.mSurfaceListener;
        if (iSurfaceListener != null) {
            iSurfaceListener.surfaceDestroy();
        }
    }
}
