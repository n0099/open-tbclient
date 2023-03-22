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
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends ViewGroup {
    public static final String k = "number";
    public static final String l = "text";
    public static final String m = "password";
    public static final String n = "phone";
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
    public class C0145a implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public C0145a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() != 0) {
                a.this.f();
                a.this.e();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public synchronized boolean onKey(View view2, int i, KeyEvent keyEvent) {
            if (i == 67) {
                a.this.d();
            }
            return false;
        }
    }

    public a(Context context) {
        super(context);
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
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    public void setBox(int i) {
        this.b = i;
    }

    public void setBoxErrorBg(Drawable drawable) {
        this.g = drawable;
    }

    public void setBoxNormalBg(Drawable drawable) {
        this.f = drawable;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    public void setInputType(String str) {
        this.e = str;
    }

    public void setListener(c cVar) {
        this.i = cVar;
    }

    public void setOnCompleteListener(c cVar) {
        this.i = cVar;
    }

    public void setTextColor(int i) {
        this.h = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            EditText editText = (EditText) getChildAt(childCount);
            if (editText.getText().length() == 1) {
                editText.requestFocus();
                editText.setSelection(1);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            EditText editText = (EditText) getChildAt(i);
            if (editText.getText().length() < 1) {
                editText.requestFocus();
                return;
            }
        }
    }

    private int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public void a() {
        for (EditText editText : this.j) {
            editText.setBackground(this.g);
        }
    }

    public void c() {
        for (EditText editText : this.j) {
            editText.setBackground(this.f);
            editText.setText("");
        }
        EditText editText2 = this.j.get(0);
        if (editText2 != null) {
            editText2.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c cVar;
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

    public void b() {
        C0145a c0145a = new C0145a();
        b bVar = new b();
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
            editText.addTextChangedListener(c0145a);
            addView(editText, i);
            this.j.add(editText);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
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
