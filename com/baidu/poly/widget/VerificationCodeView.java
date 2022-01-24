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
import c.a.h0.f;
import c.a.h0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes10.dex */
public class VerificationCodeView extends LinearLayout implements TextWatcher, View.OnKeyListener, View.OnFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f37856e;

    /* renamed from: f  reason: collision with root package name */
    public a f37857f;

    /* renamed from: g  reason: collision with root package name */
    public int f37858g;

    /* renamed from: h  reason: collision with root package name */
    public int f37859h;

    /* renamed from: i  reason: collision with root package name */
    public int f37860i;

    /* renamed from: j  reason: collision with root package name */
    public float f37861j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;

    /* loaded from: classes10.dex */
    public interface a {
        void onComplete(View view, String str);

        void onTextChange(View view, String str);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37856e = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.PolyVerificationCodeView);
        this.f37858g = obtainStyledAttributes.getInteger(k.PolyVerificationCodeView_vcv_et_number, 4);
        this.f37859h = obtainStyledAttributes.getDimensionPixelSize(k.PolyVerificationCodeView_vcv_et_width, 105);
        this.f37860i = obtainStyledAttributes.getColor(k.PolyVerificationCodeView_vcv_et_text_color, -16777216);
        this.f37861j = obtainStyledAttributes.getDimensionPixelSize(k.PolyVerificationCodeView_vcv_et_text_size, 16);
        this.k = obtainStyledAttributes.getResourceId(k.PolyVerificationCodeView_vcv_et_bg, f.poly_sdk_verification_code_et_bg);
        this.p = obtainStyledAttributes.getResourceId(k.PolyVerificationCodeView_vcv_et_cursor, f.poly_sdk_verification_code_cursor_bg);
        this.o = obtainStyledAttributes.getBoolean(k.PolyVerificationCodeView_vcv_et_cursor_visible, true);
        boolean hasValue = obtainStyledAttributes.hasValue(k.PolyVerificationCodeView_vcv_et_spacing);
        this.n = hasValue;
        if (hasValue) {
            this.l = obtainStyledAttributes.getDimensionPixelSize(k.PolyVerificationCodeView_vcv_et_spacing, 0);
        }
        e();
        obtainStyledAttributes.recycle();
    }

    private String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.f37858g; i2++) {
                sb.append((CharSequence) ((EditText) getChildAt(i2)).getText());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i2 = this.f37858g - 1; i2 >= 0; i2--) {
                EditText editText = (EditText) getChildAt(i2);
                if (editText.getText().length() >= 1) {
                    editText.setText("");
                    if (this.o) {
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

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
            if (editable.length() != 0) {
                b();
            }
            a aVar = this.f37857f;
            if (aVar != null) {
                aVar.onTextChange(this, getResult());
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= getChildCount()) {
                        z = true;
                        break;
                    }
                    EditText editText = (EditText) getChildAt(i2);
                    if (editText != null && TextUtils.isEmpty(editText.getText().toString().trim())) {
                        break;
                    }
                    i2++;
                }
                if (z) {
                    this.f37857f.onComplete(this, getResult());
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                EditText editText = (EditText) getChildAt(i2);
                if (editText.getText().length() < 1) {
                    if (this.o) {
                        editText.setCursorVisible(true);
                    } else {
                        editText.setCursorVisible(false);
                    }
                    editText.requestFocus();
                    return;
                }
                editText.setCursorVisible(false);
                if (i2 == childCount - 1) {
                    editText.requestFocus();
                }
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, charSequence, i2, i3, i4) == null) {
        }
    }

    @TargetApi(17)
    public final void d(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, editText, i2) == null) {
            editText.setLayoutParams(getETLayoutParams(i2));
            editText.setTextAlignment(4);
            editText.setGravity(17);
            editText.setId(i2);
            editText.setCursorVisible(false);
            editText.setMaxEms(1);
            editText.setTextColor(this.f37860i);
            editText.setTextSize(this.f37861j);
            editText.setCursorVisible(this.o);
            editText.setMaxLines(1);
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            editText.setInputType(2);
            editText.setPadding(0, 0, 0, 0);
            editText.setOnKeyListener(this);
            editText.setBackgroundResource(this.k);
            setEditTextCursorDrawable(editText);
            editText.addTextChangedListener(this);
            editText.setOnKeyListener(this);
            editText.setOnFocusChangeListener(this);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (int i2 = 0; i2 < this.f37858g; i2++) {
                EditText editText = new EditText(this.f37856e);
                d(editText, i2);
                addView(editText);
                if (i2 == 0) {
                    editText.setFocusable(true);
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (int i2 = 0; i2 < this.f37858g; i2++) {
                ((EditText) getChildAt(i2)).setLayoutParams(getETLayoutParams(i2));
            }
        }
    }

    public LinearLayout.LayoutParams getETLayoutParams(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int i3 = this.f37859h;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            if (!this.n) {
                int i4 = this.q;
                int i5 = this.f37858g;
                int i6 = (i4 - (this.f37859h * i5)) / (i5 + 1);
                this.m = i6;
                if (i2 == 0) {
                    layoutParams.leftMargin = i6;
                    layoutParams.rightMargin = i6 / 2;
                } else if (i2 == i5 - 1) {
                    layoutParams.leftMargin = i6 / 2;
                    layoutParams.rightMargin = i6;
                } else {
                    int i7 = i6 / 2;
                    layoutParams.leftMargin = i7;
                    layoutParams.rightMargin = i7;
                }
            } else {
                int i8 = this.l / 2;
                layoutParams.leftMargin = i8;
                layoutParams.rightMargin = i8;
            }
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeI.objValue;
    }

    public a getOnCodeFinishListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37857f : (a) invokeV.objValue;
    }

    public int getmCursorDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.p : invokeV.intValue;
    }

    public int getmEtNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37858g : invokeV.intValue;
    }

    public int getmEtTextBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : invokeV.intValue;
    }

    public int getmEtTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37860i : invokeV.intValue;
    }

    public float getmEtTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f37861j : invokeV.floatValue;
    }

    public int getmEtWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37859h : invokeV.intValue;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048591, this, view, z) == null) && z) {
            b();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048592, this, view, i2, keyEvent)) == null) {
            if (i2 == 67 && keyEvent.getAction() == 0) {
                a();
                return false;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.q = getMeasuredWidth();
            f();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048594, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public void setEditTextCursorDrawable(EditText editText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, editText) == null) && this.o) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(this.p));
            } catch (Exception unused) {
            }
        }
    }

    public void setEmpty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            for (int i2 = this.f37858g - 1; i2 >= 0; i2--) {
                EditText editText = (EditText) getChildAt(i2);
                editText.setText("");
                if (i2 == 0) {
                    if (this.o) {
                        editText.setCursorVisible(true);
                    } else {
                        editText.setCursorVisible(false);
                    }
                    editText.requestFocus();
                }
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).setEnabled(z);
            }
        }
    }

    public void setOnCodeFinishListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            this.f37857f = aVar;
        }
    }

    public void setmCursorDrawable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setmEtNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f37858g = i2;
        }
    }

    public void setmEtTextBg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setmEtTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.f37860i = i2;
        }
    }

    public void setmEtTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
            this.f37861j = f2;
        }
    }

    public void setmEtWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f37859h = i2;
        }
    }

    public void showErrorNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                ((EditText) getChildAt(i2)).setBackgroundResource(f.poly_sdk_verification_code_et_error_bg);
            }
        }
    }

    public void showNormalNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                EditText editText = (EditText) getChildAt(i2);
                editText.setText("");
                editText.setBackgroundResource(f.poly_sdk_verification_code_et_bg);
            }
            EditText editText2 = (EditText) getChildAt(0);
            editText2.setCursorVisible(true);
            editText2.requestFocus();
        }
    }
}
