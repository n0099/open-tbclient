package com.baidu.searchbox.ui.bubble.manager;

import androidx.annotation.ColorInt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.bubble.views.BubbleBaseView;
import com.baidu.searchbox.ui.bubble.views.BubbleTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleTextManager extends BubbleBaseManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BubbleTextManager";
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleTextView mTextViews;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleTextManager() {
        this(new BubbleTextView());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((BubbleTextView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void onNightModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            updateBubble(z ? this.mViews.getBgColorNight() : this.mViews.getBgColorDay());
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void onShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BubbleTextView bubbleTextView = this.mTextViews;
            CharSequence charSequence = bubbleTextView.mShowText;
            int textColor = bubbleTextView.getTextColor();
            BubbleTextView bubbleTextView2 = this.mTextViews;
            bubbleTextView.setBubbleText(charSequence, textColor, bubbleTextView2.mUnit, bubbleTextView2.mSize);
        }
    }

    public void setFontSizew(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            BubbleTextView bubbleTextView = this.mTextViews;
            bubbleTextView.mUnit = i2;
            bubbleTextView.mSize = f2;
        }
    }

    public void setTextColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mTextViews.setTextColor(i2, i2);
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void showBubble() {
        BubbleTextView bubbleTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bubbleTextView = this.mTextViews) != null && bubbleTextView.isValidate()) {
            super.showBubble();
        }
    }

    public void updateBubble(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            try {
                if (isDismissed()) {
                    return;
                }
                this.mViews.updateBubble(i2, this.mTextViews.getTextColor());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleTextManager(BubbleTextView bubbleTextView) {
        super(bubbleTextView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleTextView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BubbleBaseView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTextViews = bubbleTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public BubbleTextView getViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTextViews : (BubbleTextView) invokeV.objValue;
    }
}
