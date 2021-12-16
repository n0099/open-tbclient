package com.baidu.searchbox.player.kernel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class StretchTextureView extends TextureView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STYLE_DEFAULT = 0;
    public static final int STYLE_MATCH_HEIGHT = 1;
    public static final int STYLE_MATCH_WIDTH = 2;
    public static final int STYLE_MATCH_WIDTH_HEIGHT = 3;
    public static final String TAG = "MiniVideoTextureView";
    public transient /* synthetic */ FieldHolder $fh;
    public int mStyle;
    public int mVideoHeight;
    public int mVideoWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StretchTextureView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.mStyle = 0;
    }

    private int setStyleMatchHeight(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, this, i2, i3, i4, i5)) == null) ? (i4 <= 0 || i5 <= 0) ? i2 : (int) (i4 * (i3 / i5)) : invokeIIII.intValue;
    }

    private int setStyleMatchWidth(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, this, i2, i3, i4, i5)) == null) ? (i4 <= 0 || i5 <= 0) ? i3 : (int) (i5 * (i2 / i4)) : invokeIIII.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e5, code lost:
        r1 = (int) ((r1 * r0) / r2);
        r0 = r2;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            int defaultSize = TextureView.getDefaultSize(this.mVideoWidth, i2);
            int defaultSize2 = TextureView.getDefaultSize(this.mVideoHeight, i3);
            BdVideoLog.d(TAG, "onMeasure ** mVideoWidth : " + this.mVideoWidth + ", mVideoHeight : " + this.mVideoHeight + ", TextureViewWidth : " + defaultSize + ", TextureViewHeight : " + defaultSize2);
            int i6 = this.mStyle;
            if (i6 == 0) {
                int defaultSize3 = TextureView.getDefaultSize(this.mVideoWidth, i2);
                int defaultSize4 = TextureView.getDefaultSize(this.mVideoHeight, i3);
                if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                    int mode = View.MeasureSpec.getMode(i2);
                    int size = View.MeasureSpec.getSize(i2);
                    int mode2 = View.MeasureSpec.getMode(i3);
                    int size2 = View.MeasureSpec.getSize(i3);
                    if (mode == 1073741824 && mode2 == 1073741824) {
                        int i7 = this.mVideoWidth;
                        int i8 = i7 * size2;
                        int i9 = this.mVideoHeight;
                        if (i8 < size * i9) {
                            defaultSize = (i7 * size2) / i9;
                            defaultSize2 = size2;
                        } else {
                            if (i7 * size2 > size * i9) {
                                defaultSize2 = (i9 * size) / i7;
                                defaultSize = size;
                            }
                            defaultSize = size;
                            defaultSize2 = size2;
                        }
                    } else if (mode == 1073741824) {
                        int i10 = (this.mVideoHeight * size) / this.mVideoWidth;
                        if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                            defaultSize2 = i10;
                            defaultSize = size;
                        }
                        defaultSize = size;
                        defaultSize2 = size2;
                    } else if (mode2 == 1073741824) {
                        int i11 = (this.mVideoWidth * size2) / this.mVideoHeight;
                        if (mode != Integer.MIN_VALUE || i11 <= size) {
                            defaultSize = i11;
                            defaultSize2 = size2;
                        }
                        defaultSize = size;
                        defaultSize2 = size2;
                    } else {
                        int i12 = this.mVideoWidth;
                        int i13 = this.mVideoHeight;
                        if (mode2 != Integer.MIN_VALUE || i13 <= size2) {
                            defaultSize2 = i13;
                        } else {
                            i12 = (i12 * size2) / i13;
                            defaultSize2 = size2;
                        }
                        if (mode != Integer.MIN_VALUE || i12 <= size) {
                            defaultSize = i12;
                        } else {
                            defaultSize2 = (this.mVideoHeight * size) / this.mVideoWidth;
                            defaultSize = size;
                        }
                    }
                }
                if (getRotation() != 0.0f && getRotation() % 90.0f == 0.0f) {
                    if (defaultSize3 < defaultSize4) {
                        defaultSize = (int) ((defaultSize * defaultSize3) / defaultSize2);
                        defaultSize2 = defaultSize3;
                    } else {
                        defaultSize = (int) ((defaultSize * defaultSize3) / defaultSize2);
                        defaultSize2 = defaultSize3;
                    }
                }
            } else if (i6 == 1) {
                defaultSize = setStyleMatchHeight(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
            } else if (i6 == 2) {
                defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
            } else if (i6 == 3 && (i4 = this.mVideoWidth) > 0 && (i5 = this.mVideoHeight) > 0) {
                if (i4 / i5 > 1.0f) {
                    defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, i4, i5);
                } else if (i4 / i5 <= defaultSize / defaultSize2) {
                    defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, i4, i5);
                } else {
                    defaultSize = setStyleMatchHeight(defaultSize, defaultSize2, i4, i5);
                }
            }
            BdVideoLog.d(TAG, "setMeasuredDimension **  TextureViewWidth : " + defaultSize + ", TextureViewHeight : " + defaultSize2);
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    public void setRenderStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 != 0 && i2 != 1 && i2 != 2 && i2 != 3) {
                this.mStyle = 0;
            } else {
                this.mStyle = i2;
            }
            requestLayout();
        }
    }

    public void setVideoWidthAndHeight(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.mVideoWidth = i2;
            this.mVideoHeight = i3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StretchTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStyle = 0;
    }
}
