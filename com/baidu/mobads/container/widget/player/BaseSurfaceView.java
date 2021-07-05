package com.baidu.mobads.container.widget.player;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback, ISurfaceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDisplayMode;
    public ISurfaceListener mSurfaceListener;
    public int mVideoHeight;
    public int mVideoWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSurfaceView(Context context, ISurfaceListener iSurfaceListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iSurfaceListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDisplayMode = 1;
        this.mSurfaceListener = iSurfaceListener;
        getHolder().addCallback(this);
    }

    private void resetSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            requestLayout();
            invalidate();
        }
    }

    public int getDisplayMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDisplayMode : invokeV.intValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            int defaultSize = SurfaceView.getDefaultSize(this.mVideoWidth, i2);
            int defaultSize2 = SurfaceView.getDefaultSize(this.mVideoHeight, i3);
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
            Log.d("BaseSurfaceView", String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight)));
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    @Override // com.baidu.mobads.container.widget.player.ISurfaceView
    public void onVideoSizeChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.mVideoWidth = i2;
            this.mVideoHeight = i3;
            if (i2 == 0 || i3 == 0) {
                return;
            }
            resetSize();
        }
    }

    @Override // com.baidu.mobads.container.widget.player.ISurfaceView
    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mDisplayMode = i2;
        }
    }

    @Override // com.baidu.mobads.container.widget.player.ISurfaceView
    public void setEndSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048581, this, surfaceHolder, i2, i3, i4) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ISurfaceListener iSurfaceListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, surfaceHolder) == null) || (iSurfaceListener = this.mSurfaceListener) == null) {
            return;
        }
        iSurfaceListener.surfaceCreated(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ISurfaceListener iSurfaceListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, surfaceHolder) == null) || (iSurfaceListener = this.mSurfaceListener) == null) {
            return;
        }
        iSurfaceListener.surfaceDestroy();
    }
}
