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
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.p;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.r.a.b;
import com.baidu.swan.apps.textarea.a;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.d.d ayd;
    private d aye = new d();
    private int ayf;
    private com.baidu.swan.apps.r.a.b ayg;

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b(com.baidu.swan.apps.core.d.d dVar, a aVar) {
        this.ayd = dVar;
        e.a(aVar);
    }

    public boolean B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        d dVar = new d();
        dVar.D(jSONObject);
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(dVar, null);
        if (a2 != null) {
            a2.setHidden(dVar.hidden);
            a2.a(dVar);
            return true;
        }
        return false;
    }

    private void DW() {
        c(c.DY().DZ());
    }

    private d C(JSONObject jSONObject) {
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
        DW();
        final d C = C(jSONObject);
        this.aye = C;
        final SwanAppActivity Gv = com.baidu.swan.apps.w.e.GJ().Gv();
        if (Gv == null) {
            com.baidu.swan.apps.console.c.w("InputEditTextController", "activity is null when add input");
            return false;
        }
        final EditText ba = c.DY().ba(context);
        ba.setText(C.value);
        ba.setSingleLine(true);
        ba.setTag(str);
        int length = ba.getText().length();
        if (!TextUtils.equals("text", C.type)) {
            int i = 0;
            String str2 = C.type;
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
            this.ayg = new com.baidu.swan.apps.r.a.b(Gv, ba, i, C.maxLength);
            final com.baidu.swan.apps.o.a aVar = new com.baidu.swan.apps.o.a() { // from class: com.baidu.swan.apps.r.b.1
                @Override // com.baidu.swan.apps.o.a, com.baidu.swan.apps.o.b
                public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                    if (i2 != 4 || b.this.ayg == null) {
                        return false;
                    }
                    b.this.ayg.dismiss();
                    b.this.c(ba);
                    return true;
                }

                @Override // com.baidu.swan.apps.o.a, com.baidu.swan.apps.o.b
                public void onActivityPaused() {
                    if (b.this.ayg != null) {
                        b.this.ayg.dismiss();
                        b.this.c(ba);
                    }
                }
            };
            this.ayg.a(new b.a() { // from class: com.baidu.swan.apps.r.b.2
                @Override // com.baidu.swan.apps.r.a.b.a
                public void cz(int i2) {
                    if (b.DEBUG) {
                        Log.d("InputEditTextController", "numeric keyboard onKeyboardShow");
                    }
                    b.this.a(Gv, ba, C, i2);
                    Gv.a(aVar);
                }

                @Override // com.baidu.swan.apps.r.a.b.a
                public void DX() {
                    if (b.DEBUG) {
                        Log.d("InputEditTextController", "numeric keyboard onKeyboardHide");
                    }
                    b.this.b(ba);
                    Gv.b(aVar);
                }
            });
            this.ayg.show();
        }
        if (C.ayq) {
            ba.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (C.ays <= length && C.ays >= 0) {
            ba.setSelection(C.ays);
        }
        if (C.ayu <= length && C.ayt >= 0 && C.ayt <= C.ayu) {
            ba.setSelection(C.ayt, C.ayu);
        }
        if (C.maxLength >= 0) {
            ba.setFilters(new InputFilter[]{new InputFilter.LengthFilter(C.maxLength)});
        }
        String str3 = C.ayv;
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
                ba.setImeOptions(4);
                break;
            case 1:
                ba.setImeOptions(3);
                break;
            case 2:
                ba.setImeOptions(5);
                break;
            case 3:
                ba.setImeOptions(2);
                break;
            case 4:
                ba.setImeOptions(6);
                break;
        }
        String str4 = C.fontWeight;
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
                ba.setTypeface(Typeface.SANS_SERIF, 0);
                break;
            case 1:
                ba.setTypeface(Typeface.SANS_SERIF, 1);
                break;
            case 2:
                ba.setTypeface(Typeface.SANS_SERIF, 2);
                break;
            case 3:
                ba.setTypeface(Typeface.SANS_SERIF, 3);
                break;
            default:
                ba.setTypeface(Typeface.SANS_SERIF, 0);
                break;
        }
        String str5 = C.textAlign;
        char c4 = 65535;
        switch (str5.hashCode()) {
            case -1364013995:
                if (str5.equals("center")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str5.equals(CustomDialogData.POS_LEFT)) {
                    c4 = 0;
                    break;
                }
                break;
            case 108511772:
                if (str5.equals("right")) {
                    c4 = 1;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                ba.setGravity(8388627);
                break;
            case 1:
                ba.setGravity(8388629);
                break;
            case 2:
                ba.setGravity(17);
                break;
            default:
                ba.setGravity(8388627);
                break;
        }
        ba.setTextColor(com.baidu.swan.apps.ae.a.c.cE(C.color));
        ba.setTextSize(1, C.fontSize);
        ba.setPadding(0, -6, 0, 0);
        ba.setBackgroundColor(context.getResources().getColor(a.c.aiapps_transparent));
        a(ba, C, Gv);
        new SwanAppNAViewContainer(context).a(ba, C);
        ba.setFocusable(true);
        ba.setFocusableInTouchMode(true);
        ba.requestFocus();
        if (TextUtils.equals(C.type, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) Gv.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(ba, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            ba.setShowSoftInputOnFocus(false);
        } else {
            a(ba);
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
                e.d(c.DY().DZ(), b.this.ayf);
                if (dVar.ayw) {
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
                    if (!TextUtils.equals("text", dVar.type) && b.this.ayg != null) {
                        b.this.ayg.dismiss();
                    }
                    e.c(editText, b.this.ayf);
                    b.this.c(editText);
                }
            }
        });
        if (TextUtils.equals("text", dVar.type)) {
            final View decorView = swanAppActivity.getWindow().getDecorView();
            com.baidu.swan.apps.textarea.a.OQ().a(decorView, this.aye.id, new a.InterfaceC0196a() { // from class: com.baidu.swan.apps.r.b.6
                @Override // com.baidu.swan.apps.textarea.a.InterfaceC0196a
                public void y(String str, int i) {
                    if (editText.hasFocus()) {
                        b.this.a(swanAppActivity, editText, dVar, i);
                    }
                }

                @Override // com.baidu.swan.apps.textarea.a.InterfaceC0196a
                public void z(String str, int i) {
                    b.this.b(editText);
                    com.baidu.swan.apps.textarea.a.OQ().al(decorView);
                }

                @Override // com.baidu.swan.apps.textarea.a.InterfaceC0196a
                public void eF(String str) {
                }
            });
        }
        c.DY().a(textWatcher);
        editText.addTextChangedListener(textWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, d dVar, int i) {
        int i2;
        com.baidu.swan.apps.b.c.d Gw = com.baidu.swan.apps.w.e.GJ().Gw();
        if (DEBUG) {
            Log.d("InputEditTextController", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.ayf + "，keyboardHeight : " + i);
        }
        if (this.ayf != i && Gw != null) {
            this.ayf = i;
            e.b(editText, this.ayf);
            if (dVar.ayx) {
                int webViewScrollY = Gw.getWebViewScrollY();
                int height = editText.getHeight();
                if (height == 0) {
                    height = dVar.aEu.getHeight();
                }
                int bR = z.bR(swanAppActivity) + ((this.ayd.Ad().getHeight() - dVar.aEu.Hz()) - height) + webViewScrollY;
                int i3 = dVar.ayr > bR ? bR : dVar.ayr;
                int i4 = bR - i;
                int scrollY = this.ayd.Ad().getScrollY();
                if (i4 < 0) {
                    i2 = i3 - i4;
                } else {
                    i2 = i3 > i4 ? i3 - i4 : scrollY;
                }
                this.ayd.Ad().setScrollY(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull EditText editText) {
        if (DEBUG) {
            Log.d("InputEditTextController", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.ayf);
        }
        if (this.ayf != 0) {
            this.ayf = 0;
            editText.clearFocus();
            if (this.ayd.Ad().getScrollY() > 0) {
                this.ayd.Ad().setScrollY(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@Nullable EditText editText) {
        SwanAppActivity Gv = com.baidu.swan.apps.w.e.GJ().Gv();
        if (Gv == null) {
            com.baidu.swan.apps.console.c.w("InputEditTextController", "activity is null when close input");
            return;
        }
        p.a(Gv, Gv.getWindow().getDecorView().getWindowToken());
        if (editText != null) {
            editText.setOnFocusChangeListener(null);
            SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(this.aye, null);
            if (a2 != null) {
                com.baidu.swan.apps.console.c.d("InputEditTextController", "remove input success");
                a2.Qm();
                c.DY().Ea();
                return;
            }
            com.baidu.swan.apps.console.c.d("InputEditTextController", "remove input failure, slaveId = " + this.aye.aEs + " ; viewId = " + this.aye.id + " ; parentId = " + this.aye.aEt);
        }
    }
}
