package com.baidu.poly.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ng1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class VerificationCodeView extends LinearLayout implements TextWatcher, View.OnKeyListener, View.OnFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public a b;
    public int c;
    public int d;
    public int e;
    public float f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view2, String str);

        void b(View view2, String str);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, charSequence, i, i2, i3) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048596, this, charSequence, i, i2, i3) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ng1.PolyVerificationCodeView);
        this.c = obtainStyledAttributes.getInteger(3, 4);
        this.d = obtainStyledAttributes.getDimensionPixelSize(7, 105);
        this.e = obtainStyledAttributes.getColor(5, -16777216);
        this.f = obtainStyledAttributes.getDimensionPixelSize(6, 16);
        this.g = obtainStyledAttributes.getResourceId(0, R.drawable.obfuscated_res_0x7f08127b);
        this.l = obtainStyledAttributes.getResourceId(1, R.drawable.obfuscated_res_0x7f08127a);
        this.k = obtainStyledAttributes.getBoolean(2, true);
        boolean hasValue = obtainStyledAttributes.hasValue(4);
        this.j = hasValue;
        if (hasValue) {
            this.h = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        }
        e();
        obtainStyledAttributes.recycle();
    }

    private String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.c; i++) {
                sb.append((CharSequence) ((EditText) getChildAt(i)).getText());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (int i = 0; i < this.c; i++) {
                EditText editText = new EditText(this.a);
                d(editText, i);
                addView(editText);
                if (i == 0) {
                    editText.setFocusable(true);
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                ((EditText) getChildAt(i)).setBackgroundResource(R.drawable.obfuscated_res_0x7f08127c);
            }
        }
    }

    public a getOnCodeFinishListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (a) invokeV.objValue;
    }

    public int getmCursorDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int getmEtNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int getmEtTextBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int getmEtTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public float getmEtTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public int getmEtWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (int i = 0; i < this.c; i++) {
                ((EditText) getChildAt(i)).setLayoutParams(c(i));
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i = this.c - 1; i >= 0; i--) {
                EditText editText = (EditText) getChildAt(i);
                if (editText.getText().length() >= 1) {
                    editText.setText("");
                    if (this.k) {
                        editText.setCursorVisible(true);
                    } else {
                        editText.setCursorVisible(false);
                    }
                    editText.requestFocus();
                    return;
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                EditText editText = (EditText) getChildAt(i);
                if (editText.getText().length() < 1) {
                    if (this.k) {
                        editText.setCursorVisible(true);
                    } else {
                        editText.setCursorVisible(false);
                    }
                    editText.requestFocus();
                    return;
                }
                editText.setCursorVisible(false);
                if (i == childCount - 1) {
                    editText.requestFocus();
                }
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                EditText editText = (EditText) getChildAt(i);
                editText.setText("");
                editText.setBackgroundResource(R.drawable.obfuscated_res_0x7f08127b);
            }
            EditText editText2 = (EditText) getChildAt(0);
            editText2.setCursorVisible(true);
            editText2.requestFocus();
        }
    }

    public void setEmpty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            for (int i = this.c - 1; i >= 0; i--) {
                EditText editText = (EditText) getChildAt(i);
                editText.setText("");
                if (i == 0) {
                    if (this.k) {
                        editText.setCursorVisible(true);
                    } else {
                        editText.setCursorVisible(false);
                    }
                    editText.requestFocus();
                }
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
            if (editable.length() != 0) {
                b();
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(this, getResult());
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i < getChildCount()) {
                        EditText editText = (EditText) getChildAt(i);
                        if (editText != null && TextUtils.isEmpty(editText.getText().toString().trim())) {
                            break;
                        }
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.b.b(this, getResult());
                }
            }
        }
    }

    public LinearLayout.LayoutParams c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int i2 = this.d;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            if (!this.j) {
                int i3 = this.m;
                int i4 = this.c;
                int i5 = (i3 - (this.d * i4)) / (i4 + 1);
                this.i = i5;
                if (i == 0) {
                    layoutParams.leftMargin = i5;
                    layoutParams.rightMargin = i5 / 2;
                } else if (i == i4 - 1) {
                    layoutParams.leftMargin = i5 / 2;
                    layoutParams.rightMargin = i5;
                } else {
                    int i6 = i5 / 2;
                    layoutParams.leftMargin = i6;
                    layoutParams.rightMargin = i6;
                }
            } else {
                int i7 = this.h / 2;
                layoutParams.leftMargin = i7;
                layoutParams.rightMargin = i7;
            }
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeI.objValue;
    }

    @TargetApi(17)
    public final void d(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, editText, i) == null) {
            editText.setLayoutParams(c(i));
            editText.setTextAlignment(4);
            editText.setGravity(17);
            editText.setId(i);
            editText.setCursorVisible(false);
            editText.setMaxEms(1);
            editText.setTextColor(this.e);
            editText.setTextSize(this.f);
            editText.setCursorVisible(this.k);
            editText.setMaxLines(1);
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            editText.setInputType(2);
            editText.setPadding(0, 0, 0, 0);
            editText.setOnKeyListener(this);
            editText.setBackgroundResource(this.g);
            setEditTextCursorDrawable(editText);
            editText.addTextChangedListener(this);
            editText.setOnKeyListener(this);
            editText.setOnFocusChangeListener(this);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048593, this, view2, z) == null) && z) {
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.m = getMeasuredWidth();
            h();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048594, this, view2, i, keyEvent)) == null) {
            if (i == 67 && keyEvent.getAction() == 0) {
                a();
                return false;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void setEditTextCursorDrawable(EditText editText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, editText) == null) && this.k) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(this.l));
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public void setOnCodeFinishListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public void setmCursorDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.l = i;
        }
    }

    public void setmEtNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.c = i;
        }
    }

    public void setmEtTextBg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g = i;
        }
    }

    public void setmEtTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.e = i;
        }
    }

    public void setmEtTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f) == null) {
            this.f = f;
        }
    }

    public void setmEtWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.d = i;
        }
    }
}
