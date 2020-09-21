package com.baidu.swan.apps.component.components.f;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.w;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.q.a.b;
import com.baidu.swan.apps.q.c;
import com.baidu.swan.apps.v.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends com.baidu.swan.apps.component.a.a.a<SwanEditText, b> {
    private com.baidu.swan.apps.q.a.b cdA;
    private int cdB;
    private SwanAppActivity cdy;
    private e cdz;

    /* renamed from: com.baidu.swan.apps.component.components.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0365a {
        void c(String str, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull e eVar, @NonNull InterfaceC0365a interfaceC0365a) {
        super(context, bVar);
        this.cdy = swanAppActivity;
        this.cdz = eVar;
        c.a(interfaceC0365a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bK */
    public SwanEditText be(@NonNull Context context) {
        adS();
        return com.baidu.swan.apps.q.b.apf().bZ(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void ah(@NonNull final SwanEditText swanEditText) {
        int i = 1;
        super.ah(swanEditText);
        final b bVar = (b) adL();
        swanEditText.setText(bVar.text);
        swanEditText.setSingleLine(true);
        swanEditText.setTag(bVar.callback);
        if (!TextUtils.equals("text", bVar.type)) {
            String str = bVar.type;
            char c = 65535;
            switch (str.hashCode()) {
                case -1193508181:
                    if (str.equals("idcard")) {
                        c = 1;
                        break;
                    }
                    break;
                case 95582509:
                    if (str.equals("digit")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = 2;
                    break;
                case 1:
                    break;
                default:
                    i = 0;
                    break;
            }
            this.cdA = new com.baidu.swan.apps.q.a.b(this.cdy, swanEditText, i, bVar.maxLength);
            final com.baidu.swan.apps.framework.a aVar = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.component.components.f.a.1
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                    if (i2 != 4 || a.this.cdA == null) {
                        return false;
                    }
                    a.this.cdA.dismiss();
                    a.this.b(swanEditText);
                    return true;
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void adT() {
                    if (a.this.cdA != null) {
                        a.this.cdA.dismiss();
                        a.this.b(swanEditText);
                    }
                }
            };
            this.cdA.a(new b.a() { // from class: com.baidu.swan.apps.component.components.f.a.2
                @Override // com.baidu.swan.apps.q.a.b.a
                public void gQ(int i2) {
                    if (a.DEBUG) {
                        Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                    }
                    a.this.a(a.this.cdy, swanEditText, bVar, i2);
                    a.this.cdy.a(aVar);
                }

                @Override // com.baidu.swan.apps.q.a.b.a
                public void adU() {
                    if (a.DEBUG) {
                        Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                    }
                    a.this.c(swanEditText);
                    a.this.cdy.b(aVar);
                }
            });
            this.cdA.show();
        }
        if (bVar.ccA) {
            swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void dD(boolean z) {
        SwanEditText swanEditText;
        super.dD(z);
        if (!z) {
            com.baidu.swan.apps.component.e.a.ba("Component-Input", "attach fail");
        }
        SwanEditText swanEditText2 = (SwanEditText) getView();
        if (swanEditText2 == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Input", "onAttached with null editText");
            swanEditText = com.baidu.swan.apps.q.b.apf().apg();
        } else {
            swanEditText = swanEditText2;
        }
        swanEditText.setFocusable(true);
        swanEditText.setFocusableInTouchMode(true);
        swanEditText.requestFocus();
        if (TextUtils.equals(((b) adL()).type, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.cdy.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(swanEditText, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            swanEditText.setShowSoftInputOnFocus(false);
        } else {
            d(swanEditText);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.a.a
    public void a(@NonNull SwanEditText swanEditText, @NonNull b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        boolean adP = adP();
        if (adP) {
            swanEditText.removeTextChangedListener(com.baidu.swan.apps.q.b.apf().apj());
        }
        super.a((a) swanEditText, (SwanEditText) bVar, bVar2);
        if (adP) {
            swanEditText.addTextChangedListener(com.baidu.swan.apps.q.b.apf().apj());
        } else {
            a(swanEditText, bVar, this.cdy);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a
    /* renamed from: a */
    public void b(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-Input", "renderPadding");
        }
        swanEditText.setPadding(0, -6, 0, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a
    /* renamed from: b */
    public void a(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-Input", "renderText");
        }
        if (adP()) {
            super.a((a) swanEditText, (SwanEditText) bVar);
            try {
                swanEditText.setSelection(bVar.text.length());
            } catch (IndexOutOfBoundsException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.component.e.a.ba("Component-Input", "value is invalid, out of max length");
            }
        } else if (!TextUtils.equals(swanEditText.getText(), bVar.text)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Input", "insert input: set text must before render");
            super.a((a) swanEditText, (SwanEditText) bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a
    /* renamed from: c */
    public void d(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        a((a) swanEditText, (SwanEditText) bVar, 16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a
    /* renamed from: d */
    public void e(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-Input", "renderTextStyleFontWeight");
        }
        String str = bVar.fontWeight;
        char c = 65535;
        switch (str.hashCode()) {
            case -1178781136:
                if (str.equals("italic")) {
                    c = 0;
                    break;
                }
                break;
            case -841373419:
                if (str.equals("boldItalic")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                swanEditText.setTypeface(Typeface.SANS_SERIF, 2);
                return;
            case 1:
                swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
                return;
            default:
                super.e((a) swanEditText, (SwanEditText) bVar);
                return;
        }
    }

    private void adS() {
        b(com.baidu.swan.apps.q.b.apf().apg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable SwanEditText swanEditText) {
        SwanAppActivity ast = f.asJ().ast();
        if (ast == null) {
            com.baidu.swan.apps.console.c.w("Component-Input", "activity is null when close input");
            return;
        }
        w.forceHiddenSoftInput(ast, ast.getWindow().getDecorView().getWindowToken());
        if (swanEditText != null) {
            swanEditText.setOnFocusChangeListener(null);
            com.baidu.swan.apps.console.c.i("Component-Input", "remove input");
            if (adK().isSuccess()) {
                com.baidu.swan.apps.console.c.i("Component-Input", "remove input success");
            } else {
                com.baidu.swan.apps.console.c.w("Component-Input", "remove input fail");
            }
            com.baidu.swan.apps.q.b.apf().aph();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, b bVar, int i) {
        int i2;
        d asu = f.asJ().asu();
        if (DEBUG) {
            Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.cdB + "，keyboardHeight : " + i);
        }
        if (this.cdB != i && asu != null) {
            this.cdB = i;
            c.d(swanEditText, this.cdB);
            if (bVar.cdK) {
                if (bVar.cdd == null) {
                    bVar.cdd = new com.baidu.swan.apps.model.a.a.a();
                }
                int webViewScrollY = asu.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = bVar.cdd.getHeight();
                }
                int cH = ah.cH(swanAppActivity) + ((this.cdz.getWebViewContainer().getHeight() - bVar.cdd.getTop()) - height) + webViewScrollY;
                int i3 = bVar.ccx > cH ? cH : bVar.ccx;
                int i4 = cH - i;
                int scrollY = this.cdz.getWebViewContainer().getScrollY();
                if (i4 < 0) {
                    i2 = i3 - i4;
                } else {
                    i2 = i3 > i4 ? i3 - i4 : scrollY;
                }
                this.cdz.getWebViewContainer().setScrollY(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull SwanEditText swanEditText) {
        if (DEBUG) {
            Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.cdB);
        }
        if (this.cdB != 0) {
            this.cdB = 0;
            swanEditText.clearFocus();
            if (this.cdz.getWebViewContainer().getScrollY() > 0) {
                this.cdz.getWebViewContainer().setScrollY(0);
            }
        }
    }

    private void a(final SwanEditText swanEditText, final b bVar, final SwanAppActivity swanAppActivity) {
        swanEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.component.components.f.a.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                c.f(com.baidu.swan.apps.q.b.apf().apg(), a.this.cdB);
                if (bVar.cdJ) {
                    return true;
                }
                swanEditText.clearFocus();
                return false;
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.swan.apps.component.components.f.a.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 != i3) {
                    c.c(swanEditText, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        swanEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.swan.apps.component.components.f.a.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (a.DEBUG) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (!z) {
                    com.baidu.swan.apps.console.c.i("Component-Input", "send blur callback");
                    if (!TextUtils.equals("text", bVar.type) && a.this.cdA != null) {
                        a.this.cdA.dismiss();
                    }
                    c.e(swanEditText, a.this.cdB);
                    a.this.b(swanEditText);
                }
            }
        });
        if (TextUtils.equals("text", bVar.type)) {
            final View decorView = swanAppActivity.getWindow().getDecorView();
            com.baidu.swan.apps.textarea.c.aEE().a(decorView, bVar.ccZ, new com.baidu.swan.apps.textarea.a() { // from class: com.baidu.swan.apps.component.components.f.a.6
                @Override // com.baidu.swan.apps.textarea.a
                public void J(String str, int i) {
                    if (swanEditText.hasFocus()) {
                        a.this.a(swanAppActivity, swanEditText, bVar, i);
                    }
                }

                @Override // com.baidu.swan.apps.textarea.a
                public void K(String str, int i) {
                    a.this.c(swanEditText);
                    com.baidu.swan.apps.textarea.c.aEE().aA(decorView);
                }

                @Override // com.baidu.swan.apps.textarea.a
                public void kR(String str) {
                }
            });
        }
        com.baidu.swan.apps.q.b.apf().setTextWatcher(textWatcher);
        swanEditText.addTextChangedListener(textWatcher);
    }

    private void d(SwanEditText swanEditText) {
        try {
            Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(swanEditText, false);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
