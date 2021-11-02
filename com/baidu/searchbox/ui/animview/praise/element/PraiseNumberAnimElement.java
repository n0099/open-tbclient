package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.util.PraiseLevelUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Stack;
/* loaded from: classes7.dex */
public class PraiseNumberAnimElement extends BaseAnimatedElement {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int OFFSET_Y_DP = 2;
    public static int[] mNumberDrawableOffsetX;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsAlignRight;
    public Stack<Drawable> mNumDrawableStack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PraiseNumberAnimElement() {
        super(null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Drawable.Callback) objArr[0], (BaseAnimatedElement.ScaleType) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void drawNumber(Canvas canvas, long j) {
        Stack<Drawable> stack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65537, this, canvas, j) == null) || (stack = this.mNumDrawableStack) == null || stack.size() <= 0) {
            return;
        }
        int[] iArr = mNumberDrawableOffsetX;
        if (iArr != null && iArr.length > 0) {
            canvas.translate(mNumberDrawableOffsetX[getSafetyIndex(PraiseLevelUtil.matchPraiseLevel(j).mTextCount)], 0.0f);
        }
        int i2 = this.mNumDrawableStack.peek().getBounds().right;
        int dp2px = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f);
        while (!this.mNumDrawableStack.empty()) {
            if (!this.mIsAlignRight) {
                this.mNumDrawableStack.pop().draw(canvas);
                canvas.translate(i2, 0.0f);
            } else {
                canvas.save();
                canvas.translate((-i2) * (this.mNumDrawableStack.size() - 1), (this.mNumDrawableStack.size() - 1) * dp2px);
                this.mNumDrawableStack.pop().draw(canvas);
                canvas.restore();
            }
        }
    }

    private int getSafetyIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            if (i2 < 0) {
                return 0;
            }
            int[] iArr = mNumberDrawableOffsetX;
            int length = iArr == null ? 1 : iArr.length;
            return i2 >= length ? length - 1 : i2;
        }
        return invokeI.intValue;
    }

    private void parseOtherParams(Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, objArr) == null) || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
            return;
        }
        int i2 = -((Integer) objArr[0]).intValue();
        mNumberDrawableOffsetX = new int[]{0, 0, i2, i2 * 2, i2 * 3};
    }

    private void setAlignRight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            this.mIsAlignRight = z;
        }
    }

    private void setNumber(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j) == null) {
            long abs = Math.abs(j);
            if (this.mNumDrawableStack == null) {
                this.mNumDrawableStack = new Stack<>();
            }
            this.mNumDrawableStack.clear();
            do {
                Drawable drawable = this.mResourceProvider.getDrawable("number", Integer.valueOf((int) (abs % 10)), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.mWidth, this.mHeight);
                    this.mNumDrawableStack.push(drawable);
                }
                abs /= 10;
            } while (abs > 0);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f2), Long.valueOf(j)}) == null) {
            setNumber(j);
            drawNumber(canvas, j);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            parseOtherParams(objArr);
            setAlignRight(true);
            enableDrawDebugBound(false, BaseAnimatedElement.DEBUG_PAINT_COLOR);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        Stack<Drawable> stack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (stack = this.mNumDrawableStack) == null) {
            return;
        }
        stack.clear();
    }
}
