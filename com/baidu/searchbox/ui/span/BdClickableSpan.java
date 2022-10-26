package com.baidu.searchbox.ui.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class BdClickableSpan extends ClickableSpan implements ITouchableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isNeedUnderLine;
    public boolean mIsPressed;
    public int mNormalBgColor;
    public int mNormalTextColor;
    public int mPressedBgColor;
    public int mPressedTextColor;

    public abstract void onSpanClick(View view2);

    public BdClickableSpan(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isNeedUnderLine = false;
        this.mNormalBgColor = i;
        this.mPressedBgColor = i2;
        this.mNormalTextColor = i3;
        this.mPressedTextColor = i4;
    }

    @Override // android.text.style.ClickableSpan, com.baidu.searchbox.ui.span.ITouchableSpan
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewCompat.isAttachedToWindow(view2)) {
            onSpanClick(view2);
        }
    }

    @Override // com.baidu.searchbox.ui.span.ITouchableSpan
    public void setPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mIsPressed = z;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, textPaint) == null) {
            if (this.mIsPressed) {
                i = this.mPressedTextColor;
            } else {
                i = this.mNormalTextColor;
            }
            textPaint.setColor(i);
            if (this.mIsPressed) {
                i2 = this.mPressedBgColor;
            } else {
                i2 = this.mNormalBgColor;
            }
            textPaint.bgColor = i2;
            textPaint.setUnderlineText(this.isNeedUnderLine);
        }
    }
}
