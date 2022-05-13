package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
/* loaded from: classes3.dex */
public class SingleLineEllipsizeTextView extends EMTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLineEllipsizeTextView(Context context) {
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
        this.b = StringHelper.STRING_MORE;
        setSingleLine();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            super.onMeasure(i, i2);
            CharSequence text = getText();
            if (li.isEmpty(text.toString())) {
                return;
            }
            TextPaint paint = getPaint();
            float measureText = paint.measureText(this.b);
            float measureText2 = paint.measureText(text.toString());
            float paddingRight = getPaddingRight() + getPaddingLeft();
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables.length == 4) {
                if (compoundDrawables[0] != null) {
                    paddingRight += compoundDrawables[0].getBounds().width() + getCompoundDrawablePadding();
                }
                if (compoundDrawables[2] != null) {
                    paddingRight += compoundDrawables[2].getBounds().width() + getCompoundDrawablePadding();
                }
            }
            float measuredWidth = getMeasuredWidth() - paddingRight;
            if (measureText2 > measuredWidth) {
                int length = text.length();
                while (measureText2 + measureText > measuredWidth && length > 1) {
                    length--;
                    measureText2 = paint.measureText(text, 0, length - 1);
                }
                if (length > 0) {
                    if (paint.measureText(((Object) text.subSequence(0, length - 1)) + this.b) > measuredWidth) {
                        length--;
                    }
                }
                if (length > 0) {
                    text = ((Object) text.subSequence(0, length - 1)) + this.b;
                }
                float measureText3 = paint.measureText(text.toString());
                setText(text);
                setMeasuredDimension((int) (measureText3 + paddingRight), getMeasuredHeight());
            }
        }
    }

    public void setEllipsisSuffix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.b = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.b = StringHelper.STRING_MORE;
        setSingleLine();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.b = StringHelper.STRING_MORE;
        setSingleLine();
    }
}
