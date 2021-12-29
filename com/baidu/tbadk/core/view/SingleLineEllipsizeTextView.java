package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SingleLineEllipsizeTextView extends EMTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f41922f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLineEllipsizeTextView(Context context) {
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
        this.f41922f = "...";
        setSingleLine();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            CharSequence text = getText();
            if (m.isEmpty(text.toString())) {
                return;
            }
            TextPaint paint = getPaint();
            float measureText = paint.measureText(this.f41922f);
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
                    if (paint.measureText(((Object) text.subSequence(0, length - 1)) + this.f41922f) > measuredWidth) {
                        length--;
                    }
                }
                if (length > 0) {
                    text = ((Object) text.subSequence(0, length - 1)) + this.f41922f;
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
            this.f41922f = str;
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
        this.f41922f = "...";
        setSingleLine();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41922f = "...";
        setSingleLine();
    }
}
