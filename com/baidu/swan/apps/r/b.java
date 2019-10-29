package com.baidu.swan.apps.r;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.p;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.r.a.b;
import com.baidu.swan.apps.textarea.a;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.d.d aRt;
    private d aRu = new d();
    private int aRv;
    private com.baidu.swan.apps.r.a.b aRw;

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b(com.baidu.swan.apps.core.d.d dVar, a aVar) {
        this.aRt = dVar;
        e.a(aVar);
    }

    public boolean Z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        d dVar = new d();
        dVar.ab(jSONObject);
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(dVar, null);
        if (a2 != null) {
            a2.setHidden(dVar.hidden);
            a2.a(dVar);
            return true;
        }
        return false;
    }

    private void IQ() {
        c(c.IS().IT());
    }

    private d aa(JSONObject jSONObject) {
        d dVar = new d();
        try {
            dVar.parseFromJson(jSONObject);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Input", "parsing InputInfo occurs exception", e);
        }
        return dVar;
    }

    public boolean a(Context context, String str, JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("InputEditTextController", "paramsJson: " + jSONObject);
        }
        IQ();
        final d aa = aa(jSONObject);
        this.aRu = aa;
        final SwanAppActivity Lp = com.baidu.swan.apps.w.e.LD().Lp();
        if (Lp == null) {
            com.baidu.swan.apps.console.c.w("InputEditTextController", "activity is null when add input");
            return false;
        }
        final EditText bc = c.IS().bc(context);
        bc.setText(aa.value);
        bc.setSingleLine(true);
        bc.setTag(str);
        int length = bc.getText().length();
        if (!TextUtils.equals("text", aa.type)) {
            int i = 0;
            String str2 = aa.type;
            char c = 65535;
            switch (str2.hashCode()) {
                case -1193508181:
                    if (str2.equals("idcard")) {
                        c = 1;
                        break;
                    }
                    break;
                case 95582509:
                    if (str2.equals("digit")) {
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
                    i = 1;
                    break;
            }
            this.aRw = new com.baidu.swan.apps.r.a.b(Lp, bc, i, aa.maxLength);
            final com.baidu.swan.apps.o.a aVar = new com.baidu.swan.apps.o.a() { // from class: com.baidu.swan.apps.r.b.1
                @Override // com.baidu.swan.apps.o.a, com.baidu.swan.apps.o.b
                public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                    if (i2 != 4 || b.this.aRw == null) {
                        return false;
                    }
                    b.this.aRw.dismiss();
                    b.this.c(bc);
                    return true;
                }

                @Override // com.baidu.swan.apps.o.a, com.baidu.swan.apps.o.b
                public void onActivityPaused() {
                    if (b.this.aRw != null) {
                        b.this.aRw.dismiss();
                        b.this.c(bc);
                    }
                }
            };
            this.aRw.a(new b.a() { // from class: com.baidu.swan.apps.r.b.2
                @Override // com.baidu.swan.apps.r.a.b.a
                public void du(int i2) {
                    if (b.DEBUG) {
                        Log.d("InputEditTextController", "numeric keyboard onKeyboardShow");
                    }
                    b.this.a(Lp, bc, aa, i2);
                    Lp.a(aVar);
                }

                @Override // com.baidu.swan.apps.r.a.b.a
                public void IR() {
                    if (b.DEBUG) {
                        Log.d("InputEditTextController", "numeric keyboard onKeyboardHide");
                    }
                    b.this.b(bc);
                    Lp.b(aVar);
                }
            });
            this.aRw.show();
        }
        if (aa.aRG) {
            bc.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (aa.aRI <= length && aa.aRI >= 0) {
            bc.setSelection(aa.aRI);
        }
        if (aa.aRK <= length && aa.aRJ >= 0 && aa.aRJ <= aa.aRK) {
            bc.setSelection(aa.aRJ, aa.aRK);
        }
        if (aa.maxLength >= 0) {
            bc.setFilters(new InputFilter[]{new InputFilter.LengthFilter(aa.maxLength)});
        }
        String str3 = aa.aRL;
        char c2 = 65535;
        switch (str3.hashCode()) {
            case -906336856:
                if (str3.equals("search")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3304:
                if (str3.equals("go")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3089282:
                if (str3.equals("done")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3377907:
                if (str3.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                    c2 = 2;
                    break;
                }
                break;
            case 3526536:
                if (str3.equals("send")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                bc.setImeOptions(4);
                break;
            case 1:
                bc.setImeOptions(3);
                break;
            case 2:
                bc.setImeOptions(5);
                break;
            case 3:
                bc.setImeOptions(2);
                break;
            case 4:
                bc.setImeOptions(6);
                break;
        }
        String str4 = aa.fontWeight;
        char c3 = 65535;
        switch (str4.hashCode()) {
            case -1178781136:
                if (str4.equals("italic")) {
                    c3 = 2;
                    break;
                }
                break;
            case -1039745817:
                if (str4.equals("normal")) {
                    c3 = 0;
                    break;
                }
                break;
            case -841373419:
                if (str4.equals("boldItalic")) {
                    c3 = 3;
                    break;
                }
                break;
            case 3029637:
                if (str4.equals("bold")) {
                    c3 = 1;
                    break;
                }
                break;
        }
        switch (c3) {
            case 0:
                bc.setTypeface(Typeface.SANS_SERIF, 0);
                break;
            case 1:
                bc.setTypeface(Typeface.SANS_SERIF, 1);
                break;
            case 2:
                bc.setTypeface(Typeface.SANS_SERIF, 2);
                break;
            case 3:
                bc.setTypeface(Typeface.SANS_SERIF, 3);
                break;
            default:
                bc.setTypeface(Typeface.SANS_SERIF, 0);
                break;
        }
        String str5 = aa.textAlign;
        char c4 = 65535;
        switch (str5.hashCode()) {
            case -1364013995:
                if (str5.equals("center")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str5.equals("left")) {
                    c4 = 0;
                    break;
                }
                break;
            case 108511772:
                if (str5.equals(HorizontalTranslateLayout.RIGHT)) {
                    c4 = 1;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                bc.setGravity(8388627);
                break;
            case 1:
                bc.setGravity(8388629);
                break;
            case 2:
                bc.setGravity(17);
                break;
            default:
                bc.setGravity(8388627);
                break;
        }
        bc.setTextColor(com.baidu.swan.apps.ae.a.c.bR(aa.color));
        bc.setTextSize(1, aa.fontSize);
        bc.setPadding(0, -6, 0, 0);
        bc.setBackgroundColor(context.getResources().getColor(a.c.aiapps_transparent));
        a(bc, aa, Lp);
        new SwanAppNAViewContainer(context).a(bc, aa);
        bc.setFocusable(true);
        bc.setFocusableInTouchMode(true);
        bc.requestFocus();
        if (TextUtils.equals(aa.type, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) Lp.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(bc, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            bc.setShowSoftInputOnFocus(false);
        } else {
            a(bc);
        }
        return true;
    }

    private void a(EditText editText) {
        try {
            Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(editText, false);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void a(final EditText editText, final d dVar, final SwanAppActivity swanAppActivity) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.r.b.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                e.d(c.IS().IT(), b.this.aRv);
                if (dVar.aRM) {
                    return true;
                }
                editText.clearFocus();
                return false;
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.swan.apps.r.b.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 != i3) {
                    e.a(editText, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.swan.apps.r.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (b.DEBUG) {
                    Log.d("InputEditTextController", "onFocusChange:" + z);
                }
                if (!z) {
                    com.baidu.swan.apps.console.c.d("InputEditTextController", "send blur callback");
                    if (!TextUtils.equals("text", dVar.type) && b.this.aRw != null) {
                        b.this.aRw.dismiss();
                    }
                    e.c(editText, b.this.aRv);
                    b.this.c(editText);
                }
            }
        });
        if (TextUtils.equals("text", dVar.type)) {
            final View decorView = swanAppActivity.getWindow().getDecorView();
            com.baidu.swan.apps.textarea.a.TG().a(decorView, this.aRu.id, new a.InterfaceC0228a() { // from class: com.baidu.swan.apps.r.b.6
                @Override // com.baidu.swan.apps.textarea.a.InterfaceC0228a
                public void y(String str, int i) {
                    if (editText.hasFocus()) {
                        b.this.a(swanAppActivity, editText, dVar, i);
                    }
                }

                @Override // com.baidu.swan.apps.textarea.a.InterfaceC0228a
                public void z(String str, int i) {
                    b.this.b(editText);
                    com.baidu.swan.apps.textarea.a.TG().ar(decorView);
                }

                @Override // com.baidu.swan.apps.textarea.a.InterfaceC0228a
                public void fm(String str) {
                }
            });
        }
        c.IS().a(textWatcher);
        editText.addTextChangedListener(textWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, d dVar, int i) {
        int i2;
        com.baidu.swan.apps.b.c.d Lq = com.baidu.swan.apps.w.e.LD().Lq();
        if (DEBUG) {
            Log.d("InputEditTextController", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.aRv + "，keyboardHeight : " + i);
        }
        if (this.aRv != i && Lq != null) {
            this.aRv = i;
            e.b(editText, this.aRv);
            if (dVar.aRN) {
                int webViewScrollY = Lq.getWebViewScrollY();
                int height = editText.getHeight();
                if (height == 0) {
                    height = dVar.aXJ.getHeight();
                }
                int bS = z.bS(swanAppActivity) + ((this.aRt.EY().getHeight() - dVar.aXJ.Mt()) - height) + webViewScrollY;
                int i3 = dVar.aRH > bS ? bS : dVar.aRH;
                int i4 = bS - i;
                int scrollY = this.aRt.EY().getScrollY();
                if (i4 < 0) {
                    i2 = i3 - i4;
                } else {
                    i2 = i3 > i4 ? i3 - i4 : scrollY;
                }
                this.aRt.EY().setScrollY(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull EditText editText) {
        if (DEBUG) {
            Log.d("InputEditTextController", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.aRv);
        }
        if (this.aRv != 0) {
            this.aRv = 0;
            editText.clearFocus();
            if (this.aRt.EY().getScrollY() > 0) {
                this.aRt.EY().setScrollY(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@Nullable EditText editText) {
        SwanAppActivity Lp = com.baidu.swan.apps.w.e.LD().Lp();
        if (Lp == null) {
            com.baidu.swan.apps.console.c.w("InputEditTextController", "activity is null when close input");
            return;
        }
        p.a(Lp, Lp.getWindow().getDecorView().getWindowToken());
        if (editText != null) {
            editText.setOnFocusChangeListener(null);
            SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(this.aRu, null);
            if (a2 != null) {
                com.baidu.swan.apps.console.c.d("InputEditTextController", "remove input success");
                a2.Vc();
                c.IS().IU();
                return;
            }
            com.baidu.swan.apps.console.c.d("InputEditTextController", "remove input failure, slaveId = " + this.aRu.aXH + " ; viewId = " + this.aRu.id + " ; parentId = " + this.aRu.aXI);
        }
    }
}
