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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.q.a.b;
import com.baidu.swan.apps.q.c;
import com.baidu.swan.apps.w.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a extends com.baidu.swan.apps.component.a.a.a<SwanEditText, b> {
    private SwanAppActivity bQd;
    private d bQe;
    private com.baidu.swan.apps.q.a.b bQf;
    private int bQg;

    /* renamed from: com.baidu.swan.apps.component.components.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0320a {
        void c(String str, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar, @NonNull InterfaceC0320a interfaceC0320a) {
        super(context, bVar);
        this.bQd = swanAppActivity;
        this.bQe = dVar;
        c.a(interfaceC0320a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bA */
    public SwanEditText aY(@NonNull Context context) {
        Vq();
        return com.baidu.swan.apps.q.b.aeE().bQ(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void ab(@NonNull final SwanEditText swanEditText) {
        int i = 1;
        super.ab(swanEditText);
        final b bVar = (b) Vj();
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
            this.bQf = new com.baidu.swan.apps.q.a.b(this.bQd, swanEditText, i, bVar.maxLength);
            final com.baidu.swan.apps.framework.a aVar = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.component.components.f.a.1
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                    if (i2 != 4 || a.this.bQf == null) {
                        return false;
                    }
                    a.this.bQf.dismiss();
                    a.this.b(swanEditText);
                    return true;
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Vr() {
                    if (a.this.bQf != null) {
                        a.this.bQf.dismiss();
                        a.this.b(swanEditText);
                    }
                }
            };
            this.bQf.a(new b.a() { // from class: com.baidu.swan.apps.component.components.f.a.2
                @Override // com.baidu.swan.apps.q.a.b.a
                public void ew(int i2) {
                    if (a.DEBUG) {
                        Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                    }
                    a.this.a(a.this.bQd, swanEditText, bVar, i2);
                    a.this.bQd.a(aVar);
                }

                @Override // com.baidu.swan.apps.q.a.b.a
                public void Vs() {
                    if (a.DEBUG) {
                        Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                    }
                    a.this.c(swanEditText);
                    a.this.bQd.b(aVar);
                }
            });
            this.bQf.show();
        }
        if (bVar.bPg) {
            swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void dn(boolean z) {
        SwanEditText swanEditText;
        super.dn(z);
        if (!z) {
            com.baidu.swan.apps.component.e.a.aS("Component-Input", "attach fail");
        }
        SwanEditText swanEditText2 = (SwanEditText) getView();
        if (swanEditText2 == null) {
            com.baidu.swan.apps.component.e.a.aS("Component-Input", "onAttached with null editText");
            swanEditText = com.baidu.swan.apps.q.b.aeE().aeF();
        } else {
            swanEditText = swanEditText2;
        }
        swanEditText.setFocusable(true);
        swanEditText.setFocusableInTouchMode(true);
        swanEditText.requestFocus();
        if (TextUtils.equals(((b) Vj()).type, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.bQd.getSystemService("input_method");
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
        boolean Vn = Vn();
        if (Vn) {
            swanEditText.removeTextChangedListener(com.baidu.swan.apps.q.b.aeE().aeH());
        }
        super.a((a) swanEditText, (SwanEditText) bVar, bVar2);
        if (Vn) {
            swanEditText.addTextChangedListener(com.baidu.swan.apps.q.b.aeE().aeH());
        } else {
            a(swanEditText, bVar, this.bQd);
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
        if (Vn()) {
            super.a((a) swanEditText, (SwanEditText) bVar);
            try {
                swanEditText.setSelection(bVar.text.length());
            } catch (IndexOutOfBoundsException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.component.e.a.aS("Component-Input", "value is invalid, out of max length");
            }
        } else if (!TextUtils.equals(swanEditText.getText(), bVar.text)) {
            com.baidu.swan.apps.component.e.a.aS("Component-Input", "insert input: set text must before render");
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

    private void Vq() {
        b(com.baidu.swan.apps.q.b.aeE().aeF());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable SwanEditText swanEditText) {
        SwanAppActivity ahF = f.ahV().ahF();
        if (ahF == null) {
            com.baidu.swan.apps.console.c.w("Component-Input", "activity is null when close input");
            return;
        }
        u.forceHiddenSoftInput(ahF, ahF.getWindow().getDecorView().getWindowToken());
        if (swanEditText != null) {
            swanEditText.setOnFocusChangeListener(null);
            com.baidu.swan.apps.console.c.d("Component-Input", "remove input");
            if (Vi().isSuccess()) {
                com.baidu.swan.apps.console.c.d("Component-Input", "remove input success");
            } else {
                com.baidu.swan.apps.console.c.w("Component-Input", "remove input fail");
            }
            com.baidu.swan.apps.q.b.aeE().aeG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, b bVar, int i) {
        int i2;
        com.baidu.swan.apps.adaptation.b.d ahG = f.ahV().ahG();
        if (DEBUG) {
            Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.bQg + "，keyboardHeight : " + i);
        }
        if (this.bQg != i && ahG != null) {
            this.bQg = i;
            c.b(swanEditText, this.bQg);
            if (bVar.bQp) {
                if (bVar.bPJ == null) {
                    bVar.bPJ = new com.baidu.swan.apps.model.a.a.a();
                }
                int webViewScrollY = ahG.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = bVar.bPJ.getHeight();
                }
                int cw = ag.cw(swanAppActivity) + ((this.bQe.getWebViewContainer().getHeight() - bVar.bPJ.getTop()) - height) + webViewScrollY;
                int i3 = bVar.bPd > cw ? cw : bVar.bPd;
                int i4 = cw - i;
                int scrollY = this.bQe.getWebViewContainer().getScrollY();
                if (i4 < 0) {
                    i2 = i3 - i4;
                } else {
                    i2 = i3 > i4 ? i3 - i4 : scrollY;
                }
                this.bQe.getWebViewContainer().setScrollY(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull SwanEditText swanEditText) {
        if (DEBUG) {
            Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.bQg);
        }
        if (this.bQg != 0) {
            this.bQg = 0;
            swanEditText.clearFocus();
            if (this.bQe.getWebViewContainer().getScrollY() > 0) {
                this.bQe.getWebViewContainer().setScrollY(0);
            }
        }
    }

    private void a(final SwanEditText swanEditText, final b bVar, final SwanAppActivity swanAppActivity) {
        swanEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.component.components.f.a.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                c.d(com.baidu.swan.apps.q.b.aeE().aeF(), a.this.bQg);
                if (bVar.bQo) {
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
                    if (!TextUtils.equals("text", bVar.type) && a.this.bQf != null) {
                        a.this.bQf.dismiss();
                    }
                    c.c(swanEditText, a.this.bQg);
                    a.this.b(swanEditText);
                }
            }
        });
        if (TextUtils.equals("text", bVar.type)) {
            final View decorView = swanAppActivity.getWindow().getDecorView();
            com.baidu.swan.apps.textarea.c.asE().a(decorView, bVar.bPF, new com.baidu.swan.apps.textarea.a() { // from class: com.baidu.swan.apps.component.components.f.a.6
                @Override // com.baidu.swan.apps.textarea.a
                public void I(String str, int i) {
                    if (swanEditText.hasFocus()) {
                        a.this.a(swanAppActivity, swanEditText, bVar, i);
                    }
                }

                @Override // com.baidu.swan.apps.textarea.a
                public void J(String str, int i) {
                    a.this.c(swanEditText);
                    com.baidu.swan.apps.textarea.c.asE().au(decorView);
                }

                @Override // com.baidu.swan.apps.textarea.a
                public void iF(String str) {
                }
            });
        }
        com.baidu.swan.apps.q.b.aeE().setTextWatcher(textWatcher);
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
