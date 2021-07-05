package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(21)
/* loaded from: classes.dex */
public class CardViewApi21Impl implements CardViewImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CardViewApi21Impl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cardViewDelegate)) == null) ? (RoundRectDrawable) cardViewDelegate.getCardBackground() : (RoundRectDrawable) invokeL.objValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cardViewDelegate)) == null) ? getCardBackground(cardViewDelegate).getColor() : (ColorStateList) invokeL.objValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardViewDelegate)) == null) ? cardViewDelegate.getCardView().getElevation() : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cardViewDelegate)) == null) ? getCardBackground(cardViewDelegate).getPadding() : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cardViewDelegate)) == null) ? getRadius(cardViewDelegate) * 2.0f : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cardViewDelegate)) == null) ? getRadius(cardViewDelegate) * 2.0f : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate cardViewDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cardViewDelegate)) == null) ? getCardBackground(cardViewDelegate).getRadius() : invokeL.floatValue;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{cardViewDelegate, context, colorStateList, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            cardViewDelegate.setCardBackground(new RoundRectDrawable(colorStateList, f2));
            View cardView = cardViewDelegate.getCardView();
            cardView.setClipToOutline(true);
            cardView.setElevation(f3);
            setMaxElevation(cardViewDelegate, f4);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cardViewDelegate) == null) {
            setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cardViewDelegate) == null) {
            setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, cardViewDelegate, colorStateList) == null) {
            getCardBackground(cardViewDelegate).setColor(colorStateList);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate cardViewDelegate, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048587, this, cardViewDelegate, f2) == null) {
            cardViewDelegate.getCardView().setElevation(f2);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048588, this, cardViewDelegate, f2) == null) {
            getCardBackground(cardViewDelegate).setPadding(f2, cardViewDelegate.getUseCompatPadding(), cardViewDelegate.getPreventCornerOverlap());
            updatePadding(cardViewDelegate);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate cardViewDelegate, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048589, this, cardViewDelegate, f2) == null) {
            getCardBackground(cardViewDelegate).setRadius(f2);
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cardViewDelegate) == null) {
            if (!cardViewDelegate.getUseCompatPadding()) {
                cardViewDelegate.setShadowPadding(0, 0, 0, 0);
                return;
            }
            float maxElevation = getMaxElevation(cardViewDelegate);
            float radius = getRadius(cardViewDelegate);
            int ceil = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
        }
    }
}
