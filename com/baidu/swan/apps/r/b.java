package com.baidu.swan.apps.r;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.r.a.b;
import com.baidu.swan.apps.textarea.a;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int awA;
    private com.baidu.swan.apps.r.a.b awB;
    private com.baidu.swan.apps.core.c.d awy;
    private d awz = new d();

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b(com.baidu.swan.apps.core.c.d dVar, a aVar) {
        this.awy = dVar;
        e.a(aVar);
    }

    public boolean E(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        d dVar = new d();
        dVar.G(jSONObject);
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(dVar, null);
        if (a2 != null) {
            a2.setHidden(dVar.hidden);
            a2.a(dVar);
            return true;
        }
        return false;
    }

    private void Ch() {
        EditText Ck = c.Cj().Ck();
        if (Ck != null) {
            com.baidu.swan.apps.console.c.w("InputEditTextController", "old editText is destroyed");
            c(Ck);
        }
    }

    private d F(JSONObject jSONObject) {
        d dVar = new d();
        try {
            dVar.parseFromJson(jSONObject);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Input", "parsing InputInfo occurs exception", e);
        }
        return dVar;
    }

    public boolean e(Context context, String str, JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("InputEditTextController", "paramsJson: " + jSONObject);
        }
        Ch();
        final d F = F(jSONObject);
        this.awz = F;
        final SwanAppActivity DM = com.baidu.swan.apps.w.e.Ea().DM();
        if (DM == null) {
            com.baidu.swan.apps.console.c.w("InputEditTextController", "activity is null when add input");
            return false;
        }
        final EditText bG = c.Cj().bG(context);
        bG.setText(F.value);
        bG.setSingleLine(true);
        bG.setTag(str);
        int length = bG.getText().length();
        if (!TextUtils.equals("text", F.type)) {
            int i = 0;
            String str2 = F.type;
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
            this.awB = new com.baidu.swan.apps.r.a.b(DM, bG, i, F.maxLength);
            final com.baidu.swan.apps.o.a aVar = new com.baidu.swan.apps.o.a() { // from class: com.baidu.swan.apps.r.b.1
                @Override // com.baidu.swan.apps.o.a, com.baidu.swan.apps.o.b
                public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                    if (i2 != 4 || b.this.awB == null) {
                        return false;
                    }
                    b.this.awB.dismiss();
                    b.this.c(bG);
                    return true;
                }

                @Override // com.baidu.swan.apps.o.a, com.baidu.swan.apps.o.b
                public void onActivityPaused() {
                    if (b.this.awB != null) {
                        b.this.awB.dismiss();
                        b.this.c(bG);
                    }
                }
            };
            this.awB.a(new b.a() { // from class: com.baidu.swan.apps.r.b.2
                @Override // com.baidu.swan.apps.r.a.b.a
                public void cx(int i2) {
                    b.this.a(DM, bG, F, i2);
                    DM.a(aVar);
                }

                @Override // com.baidu.swan.apps.r.a.b.a
                public void Ci() {
                    b.this.b(bG);
                    DM.b(aVar);
                }
            });
            this.awB.show();
        }
        if (F.awK) {
            bG.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (F.awM <= length && F.awM >= 0) {
            bG.setSelection(F.awM);
        }
        if (F.selectionEnd <= length && F.selectionStart >= 0 && F.selectionStart <= F.selectionEnd) {
            bG.setSelection(F.selectionStart, F.selectionEnd);
        }
        if (F.maxLength >= 0) {
            bG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(F.maxLength)});
        }
        String str3 = F.awN;
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
                bG.setImeOptions(4);
                break;
            case 1:
                bG.setImeOptions(3);
                break;
            case 2:
                bG.setImeOptions(5);
                break;
            case 3:
                bG.setImeOptions(2);
                break;
            case 4:
                bG.setImeOptions(6);
                break;
        }
        String str4 = F.fontWeight;
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
                bG.setTypeface(Typeface.SANS_SERIF, 0);
                break;
            case 1:
                bG.setTypeface(Typeface.SANS_SERIF, 1);
                break;
            case 2:
                bG.setTypeface(Typeface.SANS_SERIF, 2);
                break;
            case 3:
                bG.setTypeface(Typeface.SANS_SERIF, 3);
                break;
            default:
                bG.setTypeface(Typeface.SANS_SERIF, 0);
                break;
        }
        String str5 = F.textAlign;
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
                bG.setGravity(8388627);
                break;
            case 1:
                bG.setGravity(8388629);
                break;
            case 2:
                bG.setGravity(17);
                break;
            default:
                bG.setGravity(8388627);
                break;
        }
        bG.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(F.color));
        bG.setTextSize(1, F.fontSize);
        bG.setPadding(0, -6, 0, 0);
        bG.setBackgroundColor(context.getResources().getColor(a.c.aiapps_transparent));
        a(bG, F, DM);
        new SwanAppNAViewContainer(context).a(bG, F);
        bG.setFocusable(true);
        bG.setFocusableInTouchMode(true);
        bG.requestFocus();
        if (TextUtils.equals(F.type, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) DM.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(bG, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            bG.setShowSoftInputOnFocus(false);
        } else {
            a(bG);
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
                e.d(c.Cj().Ck(), b.this.awA);
                if (dVar.awO) {
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
                if (!z) {
                    com.baidu.swan.apps.console.c.d("InputEditTextController", "send blur callback");
                    if (!TextUtils.equals("text", dVar.type) && b.this.awB != null) {
                        b.this.awB.dismiss();
                    }
                    e.c(editText, b.this.awA);
                    b.this.c(editText);
                }
            }
        });
        com.baidu.swan.apps.textarea.a.a(this.awz.id, swanAppActivity, new a.InterfaceC0178a() { // from class: com.baidu.swan.apps.r.b.6
            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0178a
            public void B(String str, int i) {
                if (editText.hasFocus()) {
                    b.this.a(swanAppActivity, editText, dVar, i);
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0178a
            public void C(String str, int i) {
                b.this.b(editText);
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0178a
            public void eK(String str) {
            }
        });
        c.Cj().a(textWatcher);
        editText.addTextChangedListener(textWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SwanAppActivity swanAppActivity, EditText editText, d dVar, int i) {
        com.baidu.swan.apps.b.c.d DN = com.baidu.swan.apps.w.e.Ea().DN();
        if (this.awA != i && DN != null) {
            this.awA = i;
            e.b(editText, this.awA);
            if (dVar.awP) {
                int webViewScrollY = DN.getWebViewScrollY();
                int height = editText.getHeight();
                if (height == 0) {
                    height = dVar.aBJ.getHeight();
                }
                int height2 = ((this.awy.yx().getHeight() - dVar.aBJ.getTop()) - height) + webViewScrollY + x.cp(swanAppActivity);
                if (height2 - dVar.awL < i) {
                    if (dVar.awL > height2) {
                        this.awy.yx().setScrollY(i);
                    } else {
                        this.awy.yx().setScrollY((i - height2) + dVar.awL);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EditText editText) {
        if (this.awA != 0) {
            this.awA = 0;
            editText.clearFocus();
            if (this.awy.yx().getScrollY() > 0) {
                this.awy.yx().setScrollY(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(EditText editText) {
        SwanAppActivity DM = com.baidu.swan.apps.w.e.Ea().DM();
        if (DM == null) {
            com.baidu.swan.apps.console.c.w("InputEditTextController", "activity is null when close input");
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) DM.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(this.awz, null);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.d("InputEditTextController", "remove input success");
            a2.MI();
            c.Cj().Cl();
            return true;
        }
        com.baidu.swan.apps.console.c.d("InputEditTextController", "remove input failure, slaveId = " + this.awz.aBH + " ; viewId = " + this.awz.id + " ; parentId = " + this.awz.aBI);
        return false;
    }
}
