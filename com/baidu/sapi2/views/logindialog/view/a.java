package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String k = "number";
    public static final String l = "text";
    public static final String m = "password";
    public static final String n = "phone";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public int c;
    public int d;
    public String e;
    public Drawable f;
    public Drawable g;
    public int h;
    public c i;
    public List<EditText> j;

    /* loaded from: classes2.dex */
    public interface c {
        void a(String str);
    }

    /* renamed from: com.baidu.sapi2.views.logindialog.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0161a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public C0161a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || editable.length() == 0) {
                return;
            }
            this.a.f();
            this.a.e();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public synchronized boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                synchronized (this) {
                    if (i == 67) {
                        this.a.d();
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
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
        this.c = 0;
        this.d = 0;
        this.e = k;
        this.f = null;
        this.g = null;
        this.h = Color.parseColor("#1F1F1F");
        this.j = new ArrayList();
        this.a = context;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, attributeSet)) == null) {
            return new LinearLayout.LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public void setBox(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.b = i;
        }
    }

    public void setBoxErrorBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, drawable) == null) {
            this.g = drawable;
        }
    }

    public void setBoxNormalBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            this.f = drawable;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public void setInputType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.e = str;
        }
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public void setOnCompleteListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                EditText editText = (EditText) getChildAt(childCount);
                if (editText.getText().length() == 1) {
                    editText.requestFocus();
                    editText.setSelection(1);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                EditText editText = (EditText) getChildAt(i);
                if (editText.getText().length() < 1) {
                    editText.requestFocus();
                    return;
                }
            }
        }
    }

    private int getScreenWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return getResources().getDisplayMetrics().widthPixels;
        }
        return invokeV.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (EditText editText : this.j) {
                editText.setBackground(this.g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < this.b) {
                    String obj = ((EditText) getChildAt(i)).getText().toString();
                    if (obj.length() == 0) {
                        break;
                    }
                    sb.append(obj);
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && (cVar = this.i) != null) {
                cVar.a(sb.toString());
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (EditText editText : this.j) {
                editText.setBackground(this.f);
                editText.setText("");
            }
            EditText editText2 = this.j.get(0);
            if (editText2 != null) {
                editText2.requestFocus();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C0161a c0161a = new C0161a(this);
            b bVar = new b(this);
            this.j.clear();
            for (int i = 0; i < this.b; i++) {
                EditText editText = new EditText(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dp2px(this.a, 38.0f), ViewUtils.dp2px(this.a, 38.0f));
                int i2 = this.d;
                layoutParams.bottomMargin = i2;
                layoutParams.topMargin = i2;
                int i3 = this.c;
                layoutParams.leftMargin = i3;
                layoutParams.rightMargin = i3;
                layoutParams.gravity = 17;
                editText.setOnKeyListener(bVar);
                editText.setBackground(this.f);
                editText.setTextColor(this.h);
                editText.setLayoutParams(layoutParams);
                editText.setGravity(17);
                editText.setPadding(0, ViewUtils.dp2px(this.a, 1.0f), 0, 0);
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
                if (k.equals(this.e)) {
                    editText.setInputType(2);
                } else if (m.equals(this.e)) {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else if ("text".equals(this.e)) {
                    editText.setInputType(1);
                } else if ("phone".equals(this.e)) {
                    editText.setInputType(3);
                }
                editText.setId(i);
                editText.setEms(1);
                editText.addTextChangedListener(c0161a);
                addView(editText, i);
                this.j.add(editText);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                childAt.setVisibility(0);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = this.c;
                int i7 = i6 + ((measuredWidth + i6) * i5);
                int i8 = this.d;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int measuredWidth = getMeasuredWidth();
            if (measuredWidth == -1) {
                measuredWidth = getScreenWidth();
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                measureChild(getChildAt(i3), i, i2);
            }
            if (childCount > 0) {
                View childAt = getChildAt(0);
                int measuredWidth2 = childAt.getMeasuredWidth();
                if (measuredWidth != -2) {
                    this.c = (measuredWidth - (measuredWidth2 * childCount)) / (childCount + 1);
                }
                setMeasuredDimension(ViewGroup.resolveSize((measuredWidth2 * childCount) + (this.c * (childCount + 1)), i), ViewGroup.resolveSize(childAt.getMeasuredHeight() + (this.d * 2), i2));
            }
        }
    }
}
