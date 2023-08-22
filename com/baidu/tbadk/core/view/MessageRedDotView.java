package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.di;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MessageRedDotView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String THREE_DOT_STR = "...";
    public static final int TYPE_PLUS = 2;
    public static final int TYPE_THREE_DOT = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int extendSize;
    public boolean fixMeasuredWidthHeight;
    public boolean isEnterForumStyle;
    public Drawable mBackgroundDrawable;
    public int mBackgroundId;
    public int mDotSize;
    public int mIntervalSize;
    public int mLastSkinType;
    public int mRedDotHeight;
    public String mRedNum;
    public int mShadowBottomOffset;
    public int mShadowLength;
    public Paint mShadowPaint;
    public int mShadowRadius;
    public RectF mShadowRect;
    public int mShadowRectRadius;
    public int mShadowRightOffset;
    public int mTextBottomIncrement;
    public int mTextPaddingLeft;
    public int mTextPaddingTop;
    public Paint mTextPaint;
    public Rect mTextRect;
    public int mType;
    public Paint mWhiteDotPaint;
    public RectF mWhiteDotRect;
    public boolean needRequestLayout;
    public boolean shadowEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRedDotView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mType = 1;
        this.isEnterForumStyle = false;
        this.shadowEnabled = false;
        this.mLastSkinType = 3;
        this.extendSize = 0;
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mType = 1;
        this.isEnterForumStyle = false;
        this.shadowEnabled = false;
        this.mLastSkinType = 3;
        this.extendSize = 0;
        initView();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            Drawable drawable = this.mBackgroundDrawable;
            if (drawable != null) {
                if (this.isEnterForumStyle && this.fixMeasuredWidthHeight) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight();
                    int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds4);
                    setMeasuredDimension(intrinsicWidth + dimens, intrinsicHeight + dimens);
                    return;
                }
                int i4 = this.mShadowRightOffset;
                int i5 = this.mShadowBottomOffset;
                if (i4 >= i5) {
                    i3 = this.mShadowRadius + i4;
                } else {
                    i3 = i5 + this.mShadowRadius;
                }
                this.mShadowLength = i3;
                setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.mShadowLength * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.mShadowLength * 2));
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mType = 1;
        this.isEnterForumStyle = false;
        this.shadowEnabled = false;
        this.mLastSkinType = 3;
        this.extendSize = 0;
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mType = 1;
        this.isEnterForumStyle = false;
        this.shadowEnabled = false;
        this.mLastSkinType = 3;
        this.extendSize = 0;
        initView();
    }

    private void drawNormalStr(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) && !di.isEmpty(this.mRedNum) && this.mBackgroundDrawable != null) {
            Paint paint = this.mTextPaint;
            String str = this.mRedNum;
            paint.getTextBounds(str, 0, str.length(), this.mTextRect);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = (this.mBackgroundDrawable.getIntrinsicWidth() / 2) + this.mShadowLength + (this.extendSize / 2);
            float height = (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.mTextRect.centerY();
            if (this.isEnterForumStyle) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                float f = fontMetrics.descent;
                float height2 = this.mTextPaddingTop + ((bounds.height() / 2) - (f - (((-fontMetrics.ascent) + f) / 2.0f)));
                intrinsicWidth = bounds.width() / 2;
                height = height2;
            }
            canvas.drawText(this.mRedNum, intrinsicWidth, height, this.mTextPaint);
        }
    }

    private void drawThreeDot(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, this, canvas) != null) || (drawable = this.mBackgroundDrawable) == null) {
            return;
        }
        int intrinsicWidth = (drawable.getIntrinsicWidth() / 2) + this.mShadowLength;
        int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.mShadowLength;
        if (this.isEnterForumStyle) {
            Rect bounds = this.mBackgroundDrawable.getBounds();
            int width = bounds.width() / 2;
            intrinsicHeight = bounds.height() / 2;
            intrinsicWidth = width;
        }
        int i3 = this.mDotSize;
        float f = intrinsicHeight - (i3 / 2);
        float f2 = intrinsicHeight + (i3 / 2);
        this.mWhiteDotRect.set(intrinsicWidth - (i3 / 2), f, intrinsicWidth + (i3 / 2), f2);
        canvas.drawOval(this.mWhiteDotRect, this.mWhiteDotPaint);
        RectF rectF = this.mWhiteDotRect;
        int i4 = this.mIntervalSize;
        rectF.set((i - i4) - this.mDotSize, f, i - i4, f2);
        canvas.drawOval(this.mWhiteDotRect, this.mWhiteDotPaint);
        RectF rectF2 = this.mWhiteDotRect;
        int i5 = this.mIntervalSize;
        rectF2.set(i2 + i5, f, i2 + i5 + this.mDotSize, f2);
        canvas.drawOval(this.mWhiteDotRect, this.mWhiteDotPaint);
    }

    private void initTextBottomIncrement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            String model = DeviceInfoHelper.getModel();
            if (model.contains("vivo") && model.contains("X20")) {
                this.mTextBottomIncrement = BdUtilHelper.getDimens(getContext(), R.dimen.tbds2);
            }
        }
    }

    public String getRedNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mRedNum;
        }
        return (String) invokeV.objValue;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            setLayerType(1, null);
            initTextBottomIncrement();
            Paint paint = new Paint(1);
            this.mTextPaint = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            if (!this.isEnterForumStyle && this.shadowEnabled) {
                this.mTextPaint.setTextSize(BdUtilHelper.getDimens(getContext(), R.dimen.tbfontsize26));
                this.mTextPaint.setTypeface(Typeface.MONOSPACE);
            } else {
                this.mTextPaint.setTextSize(BdUtilHelper.getDimens(getContext(), R.dimen.tbfontsize28));
                this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
            }
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextRect = new Rect();
            this.mTextPaddingLeft = BdUtilHelper.getDimens(getContext(), R.dimen.tbds13);
            this.mRedDotHeight = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            Paint paint2 = new Paint();
            this.mShadowPaint = paint2;
            paint2.setAntiAlias(true);
            this.mShadowPaint.setStyle(Paint.Style.FILL);
            this.mShadowPaint.setColor(SkinManager.getColor(R.color.transparent));
            this.mShadowRightOffset = 0;
            this.mShadowRadius = BdUtilHelper.getDimens(getContext(), R.dimen.tbds8);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds3);
            this.mShadowBottomOffset = dimens;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mShadowRightOffset, dimens, SkinManager.getColor(R.color.cp_cont_h_alpha66));
            this.mShadowRect = new RectF();
            this.mShadowRectRadius = BdUtilHelper.getDimens(getContext(), R.dimen.tbds21);
            this.mDotSize = BdUtilHelper.getDimens(getContext(), R.dimen.tbds8);
            this.mIntervalSize = BdUtilHelper.getDimens(getContext(), R.dimen.tbds6);
            Paint paint3 = new Paint();
            this.mWhiteDotPaint = paint3;
            paint3.setAntiAlias(true);
            this.mWhiteDotPaint.setStyle(Paint.Style.FILL);
            this.mWhiteDotPaint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.mWhiteDotRect = new RectF();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mLastSkinType = TbadkApplication.getInst().getSkinType();
            int i = this.mBackgroundId;
            if (i > 0) {
                this.mBackgroundDrawable = SkinManager.getDrawable(i);
            } else {
                Drawable drawable = this.mBackgroundDrawable;
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColor(SkinManager.getColor(R.color.CAM_X0301));
                }
            }
            this.mWhiteDotPaint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            Paint paint = this.mTextPaint;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            }
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mShadowRightOffset, this.mShadowBottomOffset, SkinManager.getColor(R.color.cp_cont_h_alpha66));
            if (this.needRequestLayout) {
                this.needRequestLayout = false;
                requestLayout();
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            Drawable drawable = this.mBackgroundDrawable;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight();
                if (this.isEnterForumStyle) {
                    this.mBackgroundDrawable.setBounds(0, this.mTextPaddingTop, BdUtilHelper.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, BdUtilHelper.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight + this.mTextPaddingTop);
                } else {
                    Drawable drawable2 = this.mBackgroundDrawable;
                    int i = this.mShadowLength;
                    int i2 = this.extendSize;
                    drawable2.setBounds(i, i - (i2 / 2), intrinsicWidth + i + i2, intrinsicHeight + i + (i2 / 2));
                }
                this.mBackgroundDrawable.draw(canvas);
                if (!this.isEnterForumStyle && this.shadowEnabled) {
                    RectF rectF = this.mShadowRect;
                    int i3 = this.mShadowLength;
                    rectF.set(i3, i3, intrinsicWidth + i3, i3 + intrinsicHeight);
                    if (intrinsicWidth != intrinsicHeight) {
                        RectF rectF2 = this.mShadowRect;
                        int i4 = this.mShadowRectRadius;
                        canvas.drawRoundRect(rectF2, i4, i4, this.mShadowPaint);
                    } else {
                        canvas.drawOval(this.mShadowRect, this.mShadowPaint);
                    }
                }
                if (!di.isEmpty(this.mRedNum)) {
                    if (this.mRedNum.equals("...")) {
                        drawThreeDot(canvas);
                    } else {
                        drawNormalStr(canvas);
                    }
                }
            }
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i <= 0) {
                i2 = R.drawable.icon_news_red_dot;
                this.mRedNum = null;
            } else if (i < 10) {
                this.mRedNum = String.valueOf(i);
                i2 = R.drawable.icon_news_red_dot_one_number;
            } else if (i < 100) {
                this.mRedNum = String.valueOf(i);
                i2 = R.drawable.icon_news_red_dot_two_number;
            } else {
                int i3 = this.mType;
                if (i3 == 1) {
                    this.mRedNum = "...";
                    i2 = R.drawable.icon_news_red_dot_three_dot_number;
                } else if (i3 == 2) {
                    this.mRedNum = "99+";
                    i2 = R.drawable.icon_news_red_dot_three_number;
                } else {
                    i2 = 0;
                }
            }
            if (i2 != this.mBackgroundId) {
                this.needRequestLayout = true;
            } else {
                this.needRequestLayout = false;
            }
            this.mBackgroundId = i2;
            onChangeSkinType();
        }
    }

    public void refresh(String str, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            if (z) {
                this.mRedNum = "...";
                i = R.drawable.icon_news_red_dot_three_dot_number;
            } else if (di.isEmpty(str)) {
                i = R.drawable.icon_news_red_dot;
                this.mRedNum = null;
            } else {
                int measureText = (int) this.mTextPaint.measureText(str);
                Drawable drawable = this.mBackgroundDrawable;
                if (drawable != null && drawable.getIntrinsicWidth() - (this.mTextPaddingLeft * 2) == measureText) {
                    if (this.mLastSkinType != TbadkApplication.getInst().getSkinType()) {
                        Drawable drawable2 = this.mBackgroundDrawable;
                        if (drawable2 instanceof GradientDrawable) {
                            ((GradientDrawable) drawable2).setColor(SkinManager.getColor(R.color.CAM_X0301));
                            this.needRequestLayout = false;
                        }
                    }
                } else {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setCornerRadius(this.mShadowRectRadius);
                    gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0301));
                    gradientDrawable.setSize(((int) this.mTextPaint.measureText(str)) + (this.mTextPaddingLeft * 2), this.mRedDotHeight);
                    this.mBackgroundDrawable = gradientDrawable;
                    this.needRequestLayout = true;
                }
                this.mRedNum = str;
                this.mBackgroundId = 0;
                onChangeSkinType();
                return;
            }
            if (i != this.mBackgroundId) {
                this.needRequestLayout = true;
            } else {
                this.needRequestLayout = false;
            }
            this.mBackgroundId = i;
            onChangeSkinType();
        }
    }

    public void setEnterForumStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.isEnterForumStyle = z;
        }
    }

    public void setExtendSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.extendSize = i;
        }
    }

    public void setFixMeasuredWidthHeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.fixMeasuredWidthHeight = z;
        }
    }

    public void setShadowEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.shadowEnabled = z;
        }
    }

    public void setTextBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mTextPaint.setFakeBoldText(z);
        }
    }

    public void setTextPaddingTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mTextPaddingTop = i;
        }
    }

    public void setTextSize(@IdRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mTextPaint.setTextSize(BdUtilHelper.getDimens(getContext(), i));
        }
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, typeface) == null) {
            this.mTextPaint.setTypeface(typeface);
        }
    }

    public void setThreeDotMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mType = i;
        }
    }
}
