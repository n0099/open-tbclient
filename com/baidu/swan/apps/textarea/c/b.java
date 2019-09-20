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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a aZC;
    private int aZF;
    private ShowConfirmBarLayout aZH;
    private d ayd;
    private int ayf;
    private HashMap<String, EditText> aZD = null;
    private HashMap<String, com.baidu.swan.apps.textarea.b.a> aZE = null;
    private boolean aZI = false;
    private SwanAppActivity aZG = e.GJ().Gv();

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b() {
        d Aw;
        com.baidu.swan.apps.core.d.e vN = e.GJ().vN();
        if (vN != null && (Aw = vN.Aw()) != null) {
            this.ayd = Aw;
        }
    }

    public boolean a(a aVar, Context context, JSONObject jSONObject) {
        this.aZC = aVar;
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "addTextAreaEditText paramsJson: " + jSONObject);
        }
        com.baidu.swan.apps.textarea.b.a al = com.baidu.swan.apps.textarea.b.a.al(jSONObject);
        if (this.aZD == null) {
            this.aZD = new HashMap<>();
        }
        if (this.aZD.get(al.id) != null) {
            c.w("TextAreaSecondaryParser", "insert failed: text has added with same view id");
            return false;
        }
        if (this.aZE == null) {
            this.aZE = new HashMap<>();
        }
        if (this.aZG != null) {
            EditText editText = new EditText(this.aZG);
            this.aZE.put(al.id, al);
            a(true, editText, al, (Activity) this.aZG);
            this.aZD.put(al.id, editText);
            editText.setTag(al.id);
            a(editText, this.aZG, al);
            if (al.aEy) {
                if (this.ayd != null) {
                    FrameLayout Ad = this.ayd.Ad();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(al.mWidth, al.mHeight);
                    layoutParams.topMargin = al.mTop;
                    layoutParams.leftMargin = al.mLeft;
                    Ad.addView(editText, layoutParams);
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(al.mLeft, al.mTop, al.mWidth, al.mHeight);
            if (al.aZl) {
                bVar.bC(true);
            }
            al.aEu = bVar;
            return new SwanAppNAViewContainer(context).a(editText, al);
        }
        return false;
    }

    public boolean am(JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "updateTextAreaById paramsJson: " + jSONObject);
        }
        if (this.aZG == null) {
            return false;
        }
        com.baidu.swan.apps.textarea.b.a a2 = com.baidu.swan.apps.textarea.b.a.a(this.aZE.get(jSONObject.optString("inputId")), jSONObject);
        EditText editText = this.aZD.get(a2.id);
        this.aZE.put(a2.id, a2);
        if (editText != null) {
            a(false, editText, a2, (Activity) this.aZG);
            if (a2.aEy) {
                if (this.ayd != null) {
                    FrameLayout Ad = this.ayd.Ad();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2.mWidth, a2.mHeight);
                    layoutParams.topMargin = a2.mTop;
                    layoutParams.leftMargin = a2.mLeft;
                    if (!editText.getParent().equals(Ad)) {
                        c.d("TextAreaSecondaryParser", "textarea change to fixed");
                        b(true, a2.aEs, a2.id, a2.aEt);
                        ((ViewGroup) editText.getParent()).removeView(editText);
                        Ad.addView(editText, layoutParams);
                    } else {
                        Ad.updateViewLayout(editText, layoutParams);
                    }
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(a2.mLeft, a2.mTop, a2.mWidth, a2.mHeight);
            if (a2.aZl) {
                bVar.bC(true);
            }
            a2.aEu = bVar;
            SwanAppNAViewContainer a3 = com.baidu.swan.apps.view.container.c.b.a(a2, null);
            return a3 != null && a3.a(a2);
        }
        return false;
    }

    public boolean b(boolean z, String str, String str2, String str3) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "removeTextAreaById id: " + str2);
        }
        EditText editText = this.aZD.get(str2);
        if (editText == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
        aVar.aEs = str;
        aVar.id = str2;
        aVar.aEt = str3;
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a2 == null) {
            d(editText);
        } else if (!a2.Qm()) {
            d(editText);
        }
        if (z) {
            return true;
        }
        this.aZD.remove(str2);
        this.aZE.remove(str2);
        if (this.aZD.size() == 0) {
            com.baidu.swan.apps.textarea.c.a.OS().ie(str);
            this.aZD = null;
        }
        return true;
    }

    private boolean d(EditText editText) {
        if (this.ayd == null) {
            return false;
        }
        this.ayd.Ad().removeView(editText);
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public void m16if(String str) {
        b ic = com.baidu.swan.apps.textarea.c.a.OS().ic(str);
        if (ic != null) {
            for (EditText editText : ic.aZD.values()) {
                if (editText != null) {
                    String obj = editText.getTag().toString();
                    com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
                    aVar.aEs = str;
                    aVar.id = obj;
                    SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
                    if (a2 != null && !a2.Qm() && this.ayd != null) {
                        this.ayd.Ad().removeView(editText);
                    }
                }
            }
            com.baidu.swan.apps.textarea.c.a.OS().ie(str);
            ic.aZD = null;
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
        SpannableString spannableString = new SpannableString(aVar.aZg);
        String str = aVar.aZi;
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
        spannableString.setSpan(styleSpan, 0, aVar.aZg.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.swan.apps.ae.a.c.cE(aVar.aZj)), 0, aVar.aZg.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.aZh, true), 0, aVar.aZg.length(), 33);
        editText.setHint(spannableString);
        int length = editText.getText().length();
        if (aVar.aZk) {
            if (aVar.aZp <= length && aVar.aZp >= 0) {
                editText.setSelection(aVar.aZp);
            } else {
                editText.setSelection(length);
            }
        }
        if (aVar.aZr <= length && aVar.aZr > 0 && aVar.aZq <= aVar.aZr && aVar.aZq > 0 && aVar.aZk && !editText.hasFocus()) {
            editText.setSelection(aVar.aZq, aVar.aZr);
        }
        if (aVar.aZn >= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(aVar.aZn)});
        }
        String str2 = aVar.aZt;
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
        String str3 = aVar.aZw;
        switch (str3.hashCode()) {
            case -1364013995:
                if (str3.equals("center")) {
                    z4 = true;
                    break;
                }
                z4 = true;
                break;
            case 3317767:
                if (str3.equals(CustomDialogData.POS_LEFT)) {
                    z4 = false;
                    break;
                }
                z4 = true;
                break;
            case 108511772:
                if (str3.equals("right")) {
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
        editText.setTextColor(com.baidu.swan.apps.ae.a.c.cE(aVar.aZu));
        editText.setTextSize(aVar.mFontSize);
        if (aVar.aZy != null) {
            editText.setPadding(z.ad(aVar.aZy.optInt(3)), z.ad(aVar.aZy.optInt(0)), z.ad(aVar.aZy.optInt(1)), z.ad(aVar.aZy.optInt(2)));
        }
        editText.setLineSpacing(aVar.aZv, 1.0f);
        if (z) {
            editText.setMinHeight(aVar.aZz);
            editText.setMaxHeight(aVar.mMaxHeight);
        }
        if (aVar.aZl) {
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
                if (inputMethodManager != null && aVar.aZk) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }
        });
        editText.setEnabled(!aVar.aZx);
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
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(obj)).aZA != editText.getLineCount()) {
                        c.d("TextAreaSecondaryParser", "send line change callback");
                        b.this.a(editText, "linechange", aVar, b.this.ayf);
                        ((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(obj)).aZA = editText.getLineCount();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editText.hasFocus()) {
                    c.d("TextAreaSecondaryParser", "send input callback");
                    b.this.a(editText, Config.INPUT_PART, aVar, b.this.ayf);
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
                    if (b.this.ayf != 0) {
                        b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.ayf);
                        return;
                    }
                    return;
                }
                b.this.a(editText, "blur", aVar, 0);
                b.this.OT();
            }
        });
        final View decorView = swanAppActivity.getWindow().getDecorView();
        com.baidu.swan.apps.textarea.a.OQ().a(decorView, aVar.id, new a.InterfaceC0196a() { // from class: com.baidu.swan.apps.textarea.c.b.4
            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0196a
            public void y(String str, int i) {
                int i2;
                com.baidu.swan.apps.b.c.d Gw = e.GJ().Gw();
                if (b.this.aZE.get(str) != null && b.this.ayf != i && editText.hasFocus() && Gw != null) {
                    b.this.ayf = i;
                    b.this.aZF = editText.getHeight();
                    b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.ayf);
                    boolean z = ((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(str)).aZs;
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(str)).aZm) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int ad = z.ad(38.0f);
                        if (b.this.aZH == null) {
                            b.this.aZH = new ShowConfirmBarLayout(swanAppActivity);
                            b.this.aZH.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.textarea.c.b.4.1
                                @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                                public void onClick(View view) {
                                    InputMethodManager inputMethodManager = (InputMethodManager) swanAppActivity.getSystemService("input_method");
                                    if (inputMethodManager != null) {
                                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                    }
                                    c.d("TextAreaSecondaryParser", "send confirm change callback");
                                    b.this.a(editText, "confirm", aVar, b.this.ayf);
                                }
                            });
                            layoutParams.topMargin = ((decorView.getHeight() - i) - ad) - z.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(b.this.aZH, layoutParams);
                        }
                        i2 = ad;
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        int webViewScrollY = (!((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(str)).aEy ? Gw.getWebViewScrollY() : 0) + ((b.this.ayd.Ad().getHeight() - ((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(str)).mTop) - editText.getHeight());
                        int i3 = ((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(str)).aZo;
                        if (webViewScrollY - i3 < i) {
                            b.this.aZI = true;
                            if (i3 > webViewScrollY) {
                                b.this.ayd.Ad().setScrollY(i + i2);
                                return;
                            } else {
                                b.this.ayd.Ad().setScrollY(i3 + (i - webViewScrollY) + i2);
                                return;
                            }
                        }
                        b.this.aZI = false;
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0196a
            public void z(String str, int i) {
                if (b.this.ayf != 0 && b.this.aZE.get(str) != null) {
                    b.this.ayf = 0;
                    if (b.this.ayd.Ad().getScrollY() > 0) {
                        b.this.ayd.Ad().setScrollY(0);
                        b.this.aZI = false;
                    }
                    if (b.this.aZH != null && b.this.aZH.getVisibility() == 0) {
                        ((FrameLayout) decorView.findViewById(16908290)).removeView(b.this.aZH);
                        b.this.aZH = null;
                    }
                }
                if (editText.hasFocus()) {
                    editText.clearFocus();
                    if (b.DEBUG) {
                        Log.d("TextAreaSecondaryParser", "clearFocus");
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0196a
            public void eF(String str) {
                if (b.this.aZE.get(str) != null && ((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(str)).aZA != editText.getLineCount()) {
                    c.d("TextAreaSecondaryParser", "send line change callback");
                    b.this.a(editText, "linechange", aVar, b.this.ayf);
                    ((com.baidu.swan.apps.textarea.b.a) b.this.aZE.get(str)).aZA = editText.getLineCount();
                    b.this.a(editText, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OT() {
        SwanAppActivity Gv = e.GJ().Gv();
        if (Gv == null) {
            c.w("TextAreaSecondaryParser", "activity is null when close input");
            return;
        }
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "forceCloseKeyboard");
        }
        p.a(Gv, Gv.getWindow().getDecorView().getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText, String str) {
        boolean z = this.aZE.get(str).aZs;
        if (editText.hasFocus() && !this.aZE.get(str).aEy) {
            if (this.ayf > 0 && z && this.aZI) {
                int height = (editText.getHeight() - this.aZF) + this.ayd.Ad().getScrollY();
                if (height > 0) {
                    this.ayd.Ad().setScrollY(height);
                } else {
                    this.ayd.Ad().setScrollY(0);
                }
            }
            this.aZF = editText.getHeight();
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
                        jSONObject.put(UBC.CONTENT_KEY_VALUE, editText.getText().toString());
                        jSONObject.put("cursor", editText.getSelectionStart());
                        jSONObject.put("lineCount", editText.getLineCount());
                        jSONObject.put("height", z.af(a2));
                        jSONObject.put("keyboardHeight", z.af(b.this.ayf));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (b.DEBUG) {
                        Log.d("TextAreaSecondaryParser", "changeTextAreaStatus:" + jSONObject.toString());
                    }
                    b.this.aZC.d(obj, jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(EditText editText, com.baidu.swan.apps.textarea.b.a aVar) {
        int lineCount = editText.getLineCount();
        int lineHeight = editText.getLineHeight();
        int i = aVar.aZz;
        int i2 = aVar.mMaxHeight;
        int height = editText.getHeight();
        if (aVar.aZl) {
            int paddingBottom = editText.getPaddingBottom() + (lineHeight * lineCount) + editText.getPaddingTop();
            int i3 = i2 < i ? i : i2;
            if (paddingBottom <= i) {
                return i;
            }
            return paddingBottom >= i3 ? i3 : paddingBottom;
        }
        return height;
    }

    public void ig(String str) {
        com.baidu.swan.apps.textarea.b.a aVar = this.aZE.get(str);
        EditText editText = this.aZD.get(aVar.id);
        a(editText, "linechange", aVar, this.ayf);
        this.aZE.get(str).aZA = editText.getLineCount();
    }
}
