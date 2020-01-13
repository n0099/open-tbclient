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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.t;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.s.a.b;
import com.baidu.swan.apps.s.c;
import com.baidu.swan.apps.y.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends com.baidu.swan.apps.component.a.a.a<SwanEditText, b> {
    private SwanAppActivity bev;
    private d bew;
    private com.baidu.swan.apps.s.a.b bex;
    private int bey;

    /* renamed from: com.baidu.swan.apps.component.components.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0222a {
        void b(String str, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar, @NonNull InterfaceC0222a interfaceC0222a) {
        super(context, bVar);
        this.bev = swanAppActivity;
        this.bew = dVar;
        c.a(interfaceC0222a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bL */
    public SwanEditText bj(@NonNull Context context) {
        Iy();
        return com.baidu.swan.apps.s.b.Rt().ca(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void ac(@NonNull final SwanEditText swanEditText) {
        int i = 1;
        super.ac(swanEditText);
        final b bVar = (b) Ir();
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
            this.bex = new com.baidu.swan.apps.s.a.b(this.bev, swanEditText, i, bVar.maxLength);
            final com.baidu.swan.apps.framework.a aVar = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.component.components.f.a.1
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                    if (i2 != 4 || a.this.bex == null) {
                        return false;
                    }
                    a.this.bex.dismiss();
                    a.this.b(swanEditText);
                    return true;
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void onActivityPaused() {
                    if (a.this.bex != null) {
                        a.this.bex.dismiss();
                        a.this.b(swanEditText);
                    }
                }
            };
            this.bex.a(new b.a() { // from class: com.baidu.swan.apps.component.components.f.a.2
                @Override // com.baidu.swan.apps.s.a.b.a
                public void dQ(int i2) {
                    if (a.DEBUG) {
                        Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                    }
                    a.this.a(a.this.bev, swanEditText, bVar, i2);
                    a.this.bev.a(aVar);
                }

                @Override // com.baidu.swan.apps.s.a.b.a
                public void Iz() {
                    if (a.DEBUG) {
                        Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                    }
                    a.this.c(swanEditText);
                    a.this.bev.b(aVar);
                }
            });
            this.bex.show();
        }
        if (bVar.bdw) {
            swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void bV(boolean z) {
        SwanEditText swanEditText;
        super.bV(z);
        if (!z) {
            com.baidu.swan.apps.component.e.a.ak("Component-Input", "attach fail");
        }
        SwanEditText swanEditText2 = (SwanEditText) getView();
        if (swanEditText2 == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Input", "onAttached with null editText");
            swanEditText = com.baidu.swan.apps.s.b.Rt().Ru();
        } else {
            swanEditText = swanEditText2;
        }
        swanEditText.setFocusable(true);
        swanEditText.setFocusableInTouchMode(true);
        swanEditText.requestFocus();
        if (TextUtils.equals(((b) Ir()).type, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.bev.getSystemService("input_method");
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
        boolean Iv = Iv();
        if (Iv) {
            swanEditText.removeTextChangedListener(com.baidu.swan.apps.s.b.Rt().Rw());
        }
        super.a((a) swanEditText, (SwanEditText) bVar, bVar2);
        if (Iv) {
            swanEditText.addTextChangedListener(com.baidu.swan.apps.s.b.Rt().Rw());
        } else {
            a(swanEditText, bVar, this.bev);
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
        if (Iv()) {
            super.a((a) swanEditText, (SwanEditText) bVar);
            try {
                swanEditText.setSelection(bVar.text.length());
            } catch (IndexOutOfBoundsException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.component.e.a.ak("Component-Input", "value is invalid, out of max length");
            }
        } else if (!TextUtils.equals(swanEditText.getText(), bVar.text)) {
            com.baidu.swan.apps.component.e.a.ak("Component-Input", "insert input: set text must before render");
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

    private void Iy() {
        b(com.baidu.swan.apps.s.b.Rt().Ru());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable SwanEditText swanEditText) {
        SwanAppActivity Un = f.UC().Un();
        if (Un == null) {
            com.baidu.swan.apps.console.c.w("Component-Input", "activity is null when close input");
            return;
        }
        t.forceHiddenSoftInput(Un, Un.getWindow().getDecorView().getWindowToken());
        if (swanEditText != null) {
            swanEditText.setOnFocusChangeListener(null);
            com.baidu.swan.apps.console.c.d("Component-Input", "remove input");
            if (Iq().isSuccess()) {
                com.baidu.swan.apps.console.c.d("Component-Input", "remove input success");
            } else {
                com.baidu.swan.apps.console.c.w("Component-Input", "remove input fail");
            }
            com.baidu.swan.apps.s.b.Rt().Rv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, b bVar, int i) {
        int i2;
        com.baidu.swan.apps.adaptation.b.d Uo = f.UC().Uo();
        if (DEBUG) {
            Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.bey + "，keyboardHeight : " + i);
        }
        if (this.bey != i && Uo != null) {
            this.bey = i;
            c.b(swanEditText, this.bey);
            if (bVar.beH) {
                if (bVar.bdZ == null) {
                    bVar.bdZ = new com.baidu.swan.apps.model.a.a.a();
                }
                int webViewScrollY = Uo.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = bVar.bdZ.getHeight();
                }
                int cF = af.cF(swanAppActivity) + ((this.bew.getWebViewContainer().getHeight() - bVar.bdZ.getTop()) - height) + webViewScrollY;
                int i3 = bVar.bdr > cF ? cF : bVar.bdr;
                int i4 = cF - i;
                int scrollY = this.bew.getWebViewContainer().getScrollY();
                if (i4 < 0) {
                    i2 = i3 - i4;
                } else {
                    i2 = i3 > i4 ? i3 - i4 : scrollY;
                }
                this.bew.getWebViewContainer().setScrollY(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull SwanEditText swanEditText) {
        if (DEBUG) {
            Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.bey);
        }
        if (this.bey != 0) {
            this.bey = 0;
            swanEditText.clearFocus();
            if (this.bew.getWebViewContainer().getScrollY() > 0) {
                this.bew.getWebViewContainer().setScrollY(0);
            }
        }
    }

    private void a(final SwanEditText swanEditText, final b bVar, final SwanAppActivity swanAppActivity) {
        swanEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.component.components.f.a.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                c.d(com.baidu.swan.apps.s.b.Rt().Ru(), a.this.bey);
                if (bVar.beG) {
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
                    c.a(swanEditText, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
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
                    com.baidu.swan.apps.console.c.d("Component-Input", "send blur callback");
                    if (!TextUtils.equals("text", bVar.type) && a.this.bex != null) {
                        a.this.bex.dismiss();
                    }
                    c.c(swanEditText, a.this.bey);
                    a.this.b(swanEditText);
                }
            }
        });
        if (TextUtils.equals("text", bVar.type)) {
            final View decorView = swanAppActivity.getWindow().getDecorView();
            com.baidu.swan.apps.textarea.c.adN().a(decorView, bVar.bdV, new com.baidu.swan.apps.textarea.a() { // from class: com.baidu.swan.apps.component.components.f.a.6
                @Override // com.baidu.swan.apps.textarea.a
                public void y(String str, int i) {
                    if (swanEditText.hasFocus()) {
                        a.this.a(swanAppActivity, swanEditText, bVar, i);
                    }
                }

                @Override // com.baidu.swan.apps.textarea.a
                public void z(String str, int i) {
                    a.this.c(swanEditText);
                    com.baidu.swan.apps.textarea.c.adN().at(decorView);
                }

                @Override // com.baidu.swan.apps.textarea.a
                public void gd(String str) {
                }
            });
        }
        com.baidu.swan.apps.s.b.Rt().setTextWatcher(textWatcher);
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
