package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CardViewBaseImpl implements CardViewImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF mCornerRect;

    public CardViewBaseImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCornerRect = new RectF();
    }

    private RoundRectDrawableWithShadow createBackground(Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{context, colorStateList, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f2, f3, f4) : (RoundRectDrawableWithShadow) invokeCommon.objValue;
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, cardViewDelegate)) == null) ? (RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground() : (RoundRectDrawableWithShadow) invokeL.objValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cardViewDelegate)) == null) ? getShadowBackground(cardViewDelegate).getColor() : (ColorStateList) invokeL.objValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardViewDelegate)) == null) ? getShadowBackground(cardViewDelegate).getShadowSize() : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cardViewDelegate)) == null) ? getShadowBackground(cardViewDelegate).getMaxShadowSize() : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cardViewDelegate)) == null) ? getShadowBackground(cardViewDelegate).getMinHeight() : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cardViewDelegate)) == null) ? getShadowBackground(cardViewDelegate).getMinWidth() : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cardViewDelegate)) == null) ? getShadowBackground(cardViewDelegate).getCornerRadius() : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper(this) { // from class: androidx.cardview.widget.CardViewBaseImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CardViewBaseImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper
                public void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{canvas, rectF, Float.valueOf(f2), paint}) == null) {
                        float f3 = 2.0f * f2;
                        float width = (rectF.width() - f3) - 1.0f;
                        float height = (rectF.height() - f3) - 1.0f;
                        if (f2 >= 1.0f) {
                            float f4 = f2 + 0.5f;
                            float f5 = -f4;
                            this.this$0.mCornerRect.set(f5, f5, f4, f4);
                            int save = canvas.save();
                            canvas.translate(rectF.left + f4, rectF.top + f4);
                            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
                            canvas.translate(width, 0.0f);
                            canvas.rotate(90.0f);
                            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
                            canvas.translate(height, 0.0f);
                            canvas.rotate(90.0f);
                            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
                            canvas.translate(width, 0.0f);
                            canvas.rotate(90.0f);
                            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
                            canvas.restoreToCount(save);
                            float f6 = rectF.top;
                            canvas.drawRect((rectF.left + f4) - 1.0f, f6, (rectF.right - f4) + 1.0f, f6 + f4, paint);
                            float f7 = rectF.bottom;
                            canvas.drawRect((rectF.left + f4) - 1.0f, f7 - f4, (rectF.right - f4) + 1.0f, f7, paint);
                        }
                        canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
                    }
                }
            };
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{cardViewDelegate, context, colorStateList, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            RoundRectDrawableWithShadow createBackground = createBackground(context, colorStateList, f2, f3, f4);
            createBackground.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
            cardViewDelegate.setCardBackground(createBackground);
            updatePadding(cardViewDelegate);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cardViewDelegate) == null) {
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cardViewDelegate) == null) {
            getShadowBackground(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
            updatePadding(cardViewDelegate);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, cardViewDelegate, colorStateList) == null) {
            getShadowBackground(cardViewDelegate).setColor(colorStateList);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate cardViewDelegate, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048587, this, cardViewDelegate, f2) == null) {
            getShadowBackground(cardViewDelegate).setShadowSize(f2);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048588, this, cardViewDelegate, f2) == null) {
            getShadowBackground(cardViewDelegate).setMaxShadowSize(f2);
            updatePadding(cardViewDelegate);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate cardViewDelegate, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048589, this, cardViewDelegate, f2) == null) {
            getShadowBackground(cardViewDelegate).setCornerRadius(f2);
            updatePadding(cardViewDelegate);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cardViewDelegate) == null) {
            Rect rect = new Rect();
            getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
            cardViewDelegate.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(cardViewDelegate)), (int) Math.ceil(getMinHeight(cardViewDelegate)));
            cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
