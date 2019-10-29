package com.baidu.swan.apps.textarea.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.p;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.textarea.a;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.swan.apps.w.e;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d aRt;
    private int aRv;
    private a bsC;
    private int bsF;
    private ShowConfirmBarLayout bsH;
    private HashMap<String, EditText> bsD = null;
    private HashMap<String, com.baidu.swan.apps.textarea.b.a> bsE = null;
    private boolean bsI = false;
    private SwanAppActivity bsG = e.LD().Lp();

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b() {
        d Fr;
        com.baidu.swan.apps.core.d.e AH = e.LD().AH();
        if (AH != null && (Fr = AH.Fr()) != null) {
            this.aRt = Fr;
        }
    }

    public boolean a(a aVar, Context context, JSONObject jSONObject) {
        this.bsC = aVar;
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "addTextAreaEditText paramsJson: " + jSONObject);
        }
        com.baidu.swan.apps.textarea.b.a aJ = com.baidu.swan.apps.textarea.b.a.aJ(jSONObject);
        if (this.bsD == null) {
            this.bsD = new HashMap<>();
        }
        if (this.bsD.get(aJ.id) != null) {
            c.w("TextAreaSecondaryParser", "insert failed: text has added with same view id");
            return false;
        }
        if (this.bsE == null) {
            this.bsE = new HashMap<>();
        }
        if (this.bsG != null) {
            EditText editText = new EditText(this.bsG);
            this.bsE.put(aJ.id, aJ);
            a(true, editText, aJ, (Activity) this.bsG);
            this.bsD.put(aJ.id, editText);
            editText.setTag(aJ.id);
            a(editText, this.bsG, aJ);
            if (aJ.aXN) {
                if (this.aRt != null) {
                    FrameLayout EY = this.aRt.EY();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aJ.mWidth, aJ.mHeight);
                    layoutParams.topMargin = aJ.mTop;
                    layoutParams.leftMargin = aJ.mLeft;
                    EY.addView(editText, layoutParams);
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(aJ.mLeft, aJ.mTop, aJ.mWidth, aJ.mHeight);
            if (aJ.bsm) {
                bVar.bU(true);
            }
            aJ.aXJ = bVar;
            return new SwanAppNAViewContainer(context).a(editText, aJ);
        }
        return false;
    }

    public boolean aK(JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "updateTextAreaById paramsJson: " + jSONObject);
        }
        if (this.bsG == null) {
            return false;
        }
        com.baidu.swan.apps.textarea.b.a a2 = com.baidu.swan.apps.textarea.b.a.a(this.bsE.get(jSONObject.optString("inputId")), jSONObject);
        EditText editText = this.bsD.get(a2.id);
        this.bsE.put(a2.id, a2);
        if (editText != null) {
            a(false, editText, a2, (Activity) this.bsG);
            if (a2.aXN) {
                if (this.aRt != null) {
                    FrameLayout EY = this.aRt.EY();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2.mWidth, a2.mHeight);
                    layoutParams.topMargin = a2.mTop;
                    layoutParams.leftMargin = a2.mLeft;
                    if (!editText.getParent().equals(EY)) {
                        c.d("TextAreaSecondaryParser", "textarea change to fixed");
                        c(true, a2.aXH, a2.id, a2.aXI);
                        ((ViewGroup) editText.getParent()).removeView(editText);
                        EY.addView(editText, layoutParams);
                    } else {
                        EY.updateViewLayout(editText, layoutParams);
                    }
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(a2.mLeft, a2.mTop, a2.mWidth, a2.mHeight);
            if (a2.bsm) {
                bVar.bU(true);
            }
            a2.aXJ = bVar;
            SwanAppNAViewContainer a3 = com.baidu.swan.apps.view.container.c.b.a(a2, null);
            return a3 != null && a3.a(a2);
        }
        return false;
    }

    public boolean c(boolean z, String str, String str2, String str3) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "removeTextAreaById id: " + str2);
        }
        EditText editText = this.bsD.get(str2);
        if (editText == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
        aVar.aXH = str;
        aVar.id = str2;
        aVar.aXI = str3;
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a2 == null) {
            d(editText);
        } else if (!a2.Vc()) {
            d(editText);
        }
        if (z) {
            return true;
        }
        this.bsD.remove(str2);
        this.bsE.remove(str2);
        if (this.bsD.size() == 0) {
            com.baidu.swan.apps.textarea.c.a.TI().iH(str);
            this.bsD = null;
        }
        return true;
    }

    private boolean d(EditText editText) {
        if (this.aRt == null) {
            return false;
        }
        this.aRt.EY().removeView(editText);
        return true;
    }

    public void iI(String str) {
        b iG = com.baidu.swan.apps.textarea.c.a.TI().iG(str);
        if (iG != null) {
            for (EditText editText : iG.bsD.values()) {
                if (editText != null) {
                    String obj = editText.getTag().toString();
                    com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
                    aVar.aXH = str;
                    aVar.id = obj;
                    SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
                    if (a2 != null && !a2.Vc() && this.aRt != null) {
                        this.aRt.EY().removeView(editText);
                    }
                }
            }
            com.baidu.swan.apps.textarea.c.a.TI().iH(str);
            iG.bsD = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(boolean z, final EditText editText, final com.baidu.swan.apps.textarea.b.a aVar, final Activity activity) {
        boolean z2;
        StyleSpan styleSpan;
        boolean z3;
        boolean z4;
        if (!TextUtils.equals(aVar.mValue, editText.getText())) {
            editText.setText(aVar.mValue);
        }
        editText.setBackgroundColor(0);
        SpannableString spannableString = new SpannableString(aVar.bsh);
        String str = aVar.bsj;
        switch (str.hashCode()) {
            case -1039745817:
                if (str.equals("normal")) {
                    z2 = false;
                    break;
                }
                z2 = true;
                break;
            case 3029637:
                if (str.equals("bold")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            default:
                z2 = true;
                break;
        }
        switch (z2) {
            case false:
                styleSpan = new StyleSpan(0);
                break;
            case true:
                styleSpan = new StyleSpan(1);
                break;
            default:
                styleSpan = new StyleSpan(0);
                break;
        }
        spannableString.setSpan(styleSpan, 0, aVar.bsh.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.swan.apps.ae.a.c.bR(aVar.bsk)), 0, aVar.bsh.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.bsi, true), 0, aVar.bsh.length(), 33);
        editText.setHint(spannableString);
        int length = editText.getText().length();
        if (aVar.bsl) {
            if (aVar.bsq <= length && aVar.bsq >= 0) {
                editText.setSelection(aVar.bsq);
            } else {
                editText.setSelection(length);
            }
        }
        if (aVar.bss <= length && aVar.bss > 0 && aVar.bsr <= aVar.bss && aVar.bsr > 0 && aVar.bsl && !editText.hasFocus()) {
            editText.setSelection(aVar.bsr, aVar.bss);
        }
        if (aVar.bso >= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(aVar.bso)});
        }
        String str2 = aVar.bsu;
        switch (str2.hashCode()) {
            case -1039745817:
                if (str2.equals("normal")) {
                    z3 = false;
                    break;
                }
                z3 = true;
                break;
            case 3029637:
                if (str2.equals("bold")) {
                    z3 = true;
                    break;
                }
                z3 = true;
                break;
            default:
                z3 = true;
                break;
        }
        switch (z3) {
            case false:
                editText.setTypeface(Typeface.SANS_SERIF, 0);
                break;
            case true:
                editText.setTypeface(Typeface.SANS_SERIF, 1);
                break;
            default:
                editText.setTypeface(Typeface.SANS_SERIF, 0);
                break;
        }
        String str3 = aVar.bsw;
        switch (str3.hashCode()) {
            case -1364013995:
                if (str3.equals("center")) {
                    z4 = true;
                    break;
                }
                z4 = true;
                break;
            case 3317767:
                if (str3.equals("left")) {
                    z4 = false;
                    break;
                }
                z4 = true;
                break;
            case 108511772:
                if (str3.equals(HorizontalTranslateLayout.RIGHT)) {
                    z4 = true;
                    break;
                }
                z4 = true;
                break;
            default:
                z4 = true;
                break;
        }
        switch (z4) {
            case false:
                editText.setGravity(8388659);
                break;
            case true:
                editText.setGravity(8388661);
                break;
            case true:
                editText.setGravity(49);
                break;
            default:
                editText.setGravity(8388659);
                break;
        }
        editText.setTextColor(com.baidu.swan.apps.ae.a.c.bR(aVar.mColor));
        editText.setTextSize(aVar.mFontSize);
        if (aVar.bsy != null) {
            editText.setPadding(z.S(aVar.bsy.optInt(3)), z.S(aVar.bsy.optInt(0)), z.S(aVar.bsy.optInt(1)), z.S(aVar.bsy.optInt(2)));
        }
        editText.setLineSpacing(aVar.bsv, 1.0f);
        if (z) {
            editText.setMinHeight(aVar.bsz);
            editText.setMaxHeight(aVar.mMaxHeight);
        }
        if (aVar.bsm) {
            aVar.mHeight = -2;
        }
        new Handler().post(new Runnable() { // from class: com.baidu.swan.apps.textarea.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (activity == null) {
                    c.w("TextAreaSecondaryParser", "activity is null, set textarea attr failed");
                    return;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                if (inputMethodManager != null && aVar.bsl) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }
        });
        editText.setEnabled(!aVar.bsx);
    }

    private void a(final EditText editText, @NonNull final SwanAppActivity swanAppActivity, final com.baidu.swan.apps.textarea.b.a aVar) {
        editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.swan.apps.textarea.c.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (editText.getLineCount() > 0) {
                    String obj = editText.getTag().toString();
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(obj)).bsA != editText.getLineCount()) {
                        c.d("TextAreaSecondaryParser", "send line change callback");
                        b.this.a(editText, "linechange", aVar, b.this.aRv);
                        ((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(obj)).bsA = editText.getLineCount();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editText.hasFocus()) {
                    c.d("TextAreaSecondaryParser", "send input callback");
                    b.this.a(editText, Config.INPUT_PART, aVar, b.this.aRv);
                }
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.swan.apps.textarea.c.b.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (b.DEBUG) {
                    Log.d("TextAreaSecondaryParser", "onFocusChange:" + z);
                }
                if (z) {
                    if (b.this.aRv != 0) {
                        b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.aRv);
                        return;
                    }
                    return;
                }
                b.this.a(editText, "blur", aVar, 0);
                b.this.TJ();
            }
        });
        final View decorView = swanAppActivity.getWindow().getDecorView();
        com.baidu.swan.apps.textarea.a.TG().a(decorView, aVar.id, new a.InterfaceC0228a() { // from class: com.baidu.swan.apps.textarea.c.b.4
            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0228a
            public void y(String str, int i) {
                int i2;
                com.baidu.swan.apps.b.c.d Lq = e.LD().Lq();
                if (b.this.bsE.get(str) != null && b.this.aRv != i && editText.hasFocus() && Lq != null) {
                    b.this.aRv = i;
                    b.this.bsF = editText.getHeight();
                    b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.aRv);
                    boolean z = ((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(str)).bst;
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(str)).bsn) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int S = z.S(38.0f);
                        if (b.this.bsH == null) {
                            b.this.bsH = new ShowConfirmBarLayout(swanAppActivity);
                            b.this.bsH.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.textarea.c.b.4.1
                                @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                                public void onClick(View view) {
                                    InputMethodManager inputMethodManager = (InputMethodManager) swanAppActivity.getSystemService("input_method");
                                    if (inputMethodManager != null) {
                                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                    }
                                    c.d("TextAreaSecondaryParser", "send confirm change callback");
                                    b.this.a(editText, "confirm", aVar, b.this.aRv);
                                }
                            });
                            layoutParams.topMargin = ((decorView.getHeight() - i) - S) - z.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(b.this.bsH, layoutParams);
                        }
                        i2 = S;
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        int webViewScrollY = (!((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(str)).aXN ? Lq.getWebViewScrollY() : 0) + ((b.this.aRt.EY().getHeight() - ((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(str)).mTop) - editText.getHeight());
                        int i3 = ((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(str)).bsp;
                        if (webViewScrollY - i3 < i) {
                            b.this.bsI = true;
                            if (i3 > webViewScrollY) {
                                b.this.aRt.EY().setScrollY(i + i2);
                                return;
                            } else {
                                b.this.aRt.EY().setScrollY(i3 + (i - webViewScrollY) + i2);
                                return;
                            }
                        }
                        b.this.bsI = false;
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0228a
            public void z(String str, int i) {
                if (b.this.aRv != 0 && b.this.bsE.get(str) != null) {
                    b.this.aRv = 0;
                    if (b.this.aRt.EY().getScrollY() > 0) {
                        b.this.aRt.EY().setScrollY(0);
                        b.this.bsI = false;
                    }
                    if (b.this.bsH != null && b.this.bsH.getVisibility() == 0) {
                        ((FrameLayout) decorView.findViewById(16908290)).removeView(b.this.bsH);
                        b.this.bsH = null;
                    }
                }
                if (editText.hasFocus()) {
                    editText.clearFocus();
                    if (b.DEBUG) {
                        Log.d("TextAreaSecondaryParser", "clearFocus");
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0228a
            public void fm(String str) {
                if (b.this.bsE.get(str) != null && ((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(str)).bsA != editText.getLineCount()) {
                    c.d("TextAreaSecondaryParser", "send line change callback");
                    b.this.a(editText, "linechange", aVar, b.this.aRv);
                    ((com.baidu.swan.apps.textarea.b.a) b.this.bsE.get(str)).bsA = editText.getLineCount();
                    b.this.a(editText, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TJ() {
        SwanAppActivity Lp = e.LD().Lp();
        if (Lp == null) {
            c.w("TextAreaSecondaryParser", "activity is null when close input");
            return;
        }
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "forceCloseKeyboard");
        }
        p.a(Lp, Lp.getWindow().getDecorView().getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText, String str) {
        boolean z = this.bsE.get(str).bst;
        if (editText.hasFocus() && !this.bsE.get(str).aXN) {
            if (this.aRv > 0 && z && this.bsI) {
                int height = (editText.getHeight() - this.bsF) + this.aRt.EY().getScrollY();
                if (height > 0) {
                    this.aRt.EY().setScrollY(height);
                } else {
                    this.aRt.EY().setScrollY(0);
                }
            }
            this.bsF = editText.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final EditText editText, final String str, final com.baidu.swan.apps.textarea.b.a aVar, int i) {
        new Handler().post(new Runnable() { // from class: com.baidu.swan.apps.textarea.c.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (editText != null) {
                    JSONObject jSONObject = new JSONObject();
                    String obj = editText.getTag().toString();
                    int a2 = b.this.a(editText, aVar);
                    try {
                        jSONObject.put("eventName", str);
                        jSONObject.put("value", editText.getText().toString());
                        jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, editText.getSelectionStart());
                        jSONObject.put("lineCount", editText.getLineCount());
                        jSONObject.put("height", z.U(a2));
                        jSONObject.put("keyboardHeight", z.U(b.this.aRv));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (b.DEBUG) {
                        Log.d("TextAreaSecondaryParser", "changeTextAreaStatus:" + jSONObject.toString());
                    }
                    b.this.bsC.d(obj, jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(EditText editText, com.baidu.swan.apps.textarea.b.a aVar) {
        int lineCount = editText.getLineCount();
        int lineHeight = editText.getLineHeight();
        int i = aVar.bsz;
        int i2 = aVar.mMaxHeight;
        int height = editText.getHeight();
        if (aVar.bsm) {
            int paddingBottom = editText.getPaddingBottom() + (lineHeight * lineCount) + editText.getPaddingTop();
            int i3 = i2 < i ? i : i2;
            if (paddingBottom <= i) {
                return i;
            }
            return paddingBottom >= i3 ? i3 : paddingBottom;
        }
        return height;
    }

    public void iJ(String str) {
        com.baidu.swan.apps.textarea.b.a aVar = this.bsE.get(str);
        EditText editText = this.bsD.get(aVar.id);
        a(editText, "linechange", aVar, this.aRv);
        this.bsE.get(str).bsA = editText.getLineCount();
    }
}
