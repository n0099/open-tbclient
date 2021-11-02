package com.baidu.searchbox.ui.bubble.manager;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.bubble.BubbleHistory;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.views.BubbleButtonView;
import com.baidu.searchbox.ui.bubble.views.BubbleTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleButtonManager extends BubbleTextManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BubbleTextManager";
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleManager.OnBtnClickListener mBtnClickListener;
    public BubbleButtonView mButtonViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleButtonManager() {
        super(new BubbleButtonView());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BubbleTextView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mButtonViews = (BubbleButtonView) this.mViews;
        this.mLocation.enableD20Template(false);
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void onShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onShow();
            this.mButtonViews.mArrowUp.enableNewTemplate(false);
            this.mButtonViews.mArrowDown.enableNewTemplate(false);
            this.mButtonViews.mArrowLeft.enableNewTemplate(false);
            this.mButtonViews.mArrowRight.enableNewTemplate(false);
            if (TextUtils.isEmpty(this.mButtonViews.mBtnText)) {
                return;
            }
            BubbleButtonView bubbleButtonView = this.mButtonViews;
            CharSequence charSequence = bubbleButtonView.mBtnText;
            int textColor = bubbleButtonView.getTextColor();
            BubbleButtonView bubbleButtonView2 = this.mButtonViews;
            bubbleButtonView.setBtnText(charSequence, textColor, bubbleButtonView2.mBtnTextUnit, bubbleButtonView2.mBtnTextSize);
            this.mButtonViews.setBtnClick(new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleButtonManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BubbleButtonManager this$0;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.this$0.mBtnClickListener != null) {
                            this.this$0.mBtnClickListener.onBtnClick();
                        }
                        this.this$0.dismissBubble();
                    }
                }
            });
            BubbleHistory.getInstance().trackBubbleHistory(this.mButtonViews.mBtnText.toString());
        }
    }

    public void setBtnText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.mButtonViews.mBtnText = charSequence;
    }

    public void setOnBtnClickListener(BubbleManager.OnBtnClickListener onBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onBtnClickListener) == null) {
            this.mBtnClickListener = onBtnClickListener;
        }
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, charSequence) == null) {
            this.mButtonViews.mShowText = charSequence;
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager
    public void setTextColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mButtonViews.setTextColor(i2, i2);
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager
    public void updateBubble(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            try {
                if (isDismissed()) {
                    return;
                }
                super.updateBubble(i2);
                this.mViews.updateBubble(i2, this.mButtonViews.getTextColor());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public BubbleButtonView getViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mButtonViews : (BubbleButtonView) invokeV.objValue;
    }
}
