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
    private d aRb;
    private int aRd;
    private a brL;
    private int brO;
    private ShowConfirmBarLayout brQ;
    private HashMap<String, EditText> brM = null;
    private HashMap<String, com.baidu.swan.apps.textarea.b.a> brN = null;
    private boolean brR = false;
    private SwanAppActivity brP = e.LE().Lq();

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b() {
        d Fs;
        com.baidu.swan.apps.core.d.e AI = e.LE().AI();
        if (AI != null && (Fs = AI.Fs()) != null) {
            this.aRb = Fs;
        }
    }

    public boolean a(a aVar, Context context, JSONObject jSONObject) {
        this.brL = aVar;
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "addTextAreaEditText paramsJson: " + jSONObject);
        }
        com.baidu.swan.apps.textarea.b.a aK = com.baidu.swan.apps.textarea.b.a.aK(jSONObject);
        if (this.brM == null) {
            this.brM = new HashMap<>();
        }
        if (this.brM.get(aK.id) != null) {
            c.w("TextAreaSecondaryParser", "insert failed: text has added with same view id");
            return false;
        }
        if (this.brN == null) {
            this.brN = new HashMap<>();
        }
        if (this.brP != null) {
            EditText editText = new EditText(this.brP);
            this.brN.put(aK.id, aK);
            a(true, editText, aK, (Activity) this.brP);
            this.brM.put(aK.id, editText);
            editText.setTag(aK.id);
            a(editText, this.brP, aK);
            if (aK.aXv) {
                if (this.aRb != null) {
                    FrameLayout EZ = this.aRb.EZ();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aK.mWidth, aK.mHeight);
                    layoutParams.topMargin = aK.mTop;
                    layoutParams.leftMargin = aK.mLeft;
                    EZ.addView(editText, layoutParams);
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(aK.mLeft, aK.mTop, aK.mWidth, aK.mHeight);
            if (aK.brv) {
                bVar.bU(true);
            }
            aK.aXr = bVar;
            return new SwanAppNAViewContainer(context).a(editText, aK);
        }
        return false;
    }

    public boolean aL(JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "updateTextAreaById paramsJson: " + jSONObject);
        }
        if (this.brP == null) {
            return false;
        }
        com.baidu.swan.apps.textarea.b.a a2 = com.baidu.swan.apps.textarea.b.a.a(this.brN.get(jSONObject.optString("inputId")), jSONObject);
        EditText editText = this.brM.get(a2.id);
        this.brN.put(a2.id, a2);
        if (editText != null) {
            a(false, editText, a2, (Activity) this.brP);
            if (a2.aXv) {
                if (this.aRb != null) {
                    FrameLayout EZ = this.aRb.EZ();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2.mWidth, a2.mHeight);
                    layoutParams.topMargin = a2.mTop;
                    layoutParams.leftMargin = a2.mLeft;
                    if (!editText.getParent().equals(EZ)) {
                        c.d("TextAreaSecondaryParser", "textarea change to fixed");
                        c(true, a2.aXp, a2.id, a2.aXq);
                        ((ViewGroup) editText.getParent()).removeView(editText);
                        EZ.addView(editText, layoutParams);
                    } else {
                        EZ.updateViewLayout(editText, layoutParams);
                    }
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(a2.mLeft, a2.mTop, a2.mWidth, a2.mHeight);
            if (a2.brv) {
                bVar.bU(true);
            }
            a2.aXr = bVar;
            SwanAppNAViewContainer a3 = com.baidu.swan.apps.view.container.c.b.a(a2, null);
            return a3 != null && a3.a(a2);
        }
        return false;
    }

    public boolean c(boolean z, String str, String str2, String str3) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "removeTextAreaById id: " + str2);
        }
        EditText editText = this.brM.get(str2);
        if (editText == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
        aVar.aXp = str;
        aVar.id = str2;
        aVar.aXq = str3;
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a2 == null) {
            d(editText);
        } else if (!a2.Va()) {
            d(editText);
        }
        if (z) {
            return true;
        }
        this.brM.remove(str2);
        this.brN.remove(str2);
        if (this.brM.size() == 0) {
            com.baidu.swan.apps.textarea.c.a.TG().iH(str);
            this.brM = null;
        }
        return true;
    }

    private boolean d(EditText editText) {
        if (this.aRb == null) {
            return false;
        }
        this.aRb.EZ().removeView(editText);
        return true;
    }

    public void iI(String str) {
        b iG = com.baidu.swan.apps.textarea.c.a.TG().iG(str);
        if (iG != null) {
            for (EditText editText : iG.brM.values()) {
                if (editText != null) {
                    String obj = editText.getTag().toString();
                    com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
                    aVar.aXp = str;
                    aVar.id = obj;
                    SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
                    if (a2 != null && !a2.Va() && this.aRb != null) {
                        this.aRb.EZ().removeView(editText);
                    }
                }
            }
            com.baidu.swan.apps.textarea.c.a.TG().iH(str);
            iG.brM = null;
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
        SpannableString spannableString = new SpannableString(aVar.brq);
        String str = aVar.brs;
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
        spannableString.setSpan(styleSpan, 0, aVar.brq.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.swan.apps.ae.a.c.bR(aVar.brt)), 0, aVar.brq.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.brr, true), 0, aVar.brq.length(), 33);
        editText.setHint(spannableString);
        int length = editText.getText().length();
        if (aVar.bru) {
            if (aVar.brz <= length && aVar.brz >= 0) {
                editText.setSelection(aVar.brz);
            } else {
                editText.setSelection(length);
            }
        }
        if (aVar.brB <= length && aVar.brB > 0 && aVar.brA <= aVar.brB && aVar.brA > 0 && aVar.bru && !editText.hasFocus()) {
            editText.setSelection(aVar.brA, aVar.brB);
        }
        if (aVar.brx >= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(aVar.brx)});
        }
        String str2 = aVar.brD;
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
        String str3 = aVar.brF;
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
        if (aVar.brH != null) {
            editText.setPadding(z.S(aVar.brH.optInt(3)), z.S(aVar.brH.optInt(0)), z.S(aVar.brH.optInt(1)), z.S(aVar.brH.optInt(2)));
        }
        editText.setLineSpacing(aVar.brE, 1.0f);
        if (z) {
            editText.setMinHeight(aVar.brI);
            editText.setMaxHeight(aVar.mMaxHeight);
        }
        if (aVar.brv) {
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
                if (inputMethodManager != null && aVar.bru) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }
        });
        editText.setEnabled(!aVar.brG);
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
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(obj)).brJ != editText.getLineCount()) {
                        c.d("TextAreaSecondaryParser", "send line change callback");
                        b.this.a(editText, "linechange", aVar, b.this.aRd);
                        ((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(obj)).brJ = editText.getLineCount();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editText.hasFocus()) {
                    c.d("TextAreaSecondaryParser", "send input callback");
                    b.this.a(editText, Config.INPUT_PART, aVar, b.this.aRd);
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
                    if (b.this.aRd != 0) {
                        b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.aRd);
                        return;
                    }
                    return;
                }
                b.this.a(editText, "blur", aVar, 0);
                b.this.TH();
            }
        });
        final View decorView = swanAppActivity.getWindow().getDecorView();
        com.baidu.swan.apps.textarea.a.TE().a(decorView, aVar.id, new a.InterfaceC0223a() { // from class: com.baidu.swan.apps.textarea.c.b.4
            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0223a
            public void y(String str, int i) {
                int i2;
                com.baidu.swan.apps.b.c.d Lr = e.LE().Lr();
                if (b.this.brN.get(str) != null && b.this.aRd != i && editText.hasFocus() && Lr != null) {
                    b.this.aRd = i;
                    b.this.brO = editText.getHeight();
                    b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.aRd);
                    boolean z = ((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(str)).brC;
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(str)).brw) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int S = z.S(38.0f);
                        if (b.this.brQ == null) {
                            b.this.brQ = new ShowConfirmBarLayout(swanAppActivity);
                            b.this.brQ.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.textarea.c.b.4.1
                                @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                                public void onClick(View view) {
                                    InputMethodManager inputMethodManager = (InputMethodManager) swanAppActivity.getSystemService("input_method");
                                    if (inputMethodManager != null) {
                                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                    }
                                    c.d("TextAreaSecondaryParser", "send confirm change callback");
                                    b.this.a(editText, "confirm", aVar, b.this.aRd);
                                }
                            });
                            layoutParams.topMargin = ((decorView.getHeight() - i) - S) - z.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(b.this.brQ, layoutParams);
                        }
                        i2 = S;
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        int webViewScrollY = (!((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(str)).aXv ? Lr.getWebViewScrollY() : 0) + ((b.this.aRb.EZ().getHeight() - ((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(str)).mTop) - editText.getHeight());
                        int i3 = ((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(str)).bry;
                        if (webViewScrollY - i3 < i) {
                            b.this.brR = true;
                            if (i3 > webViewScrollY) {
                                b.this.aRb.EZ().setScrollY(i + i2);
                                return;
                            } else {
                                b.this.aRb.EZ().setScrollY(i3 + (i - webViewScrollY) + i2);
                                return;
                            }
                        }
                        b.this.brR = false;
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0223a
            public void z(String str, int i) {
                if (b.this.aRd != 0 && b.this.brN.get(str) != null) {
                    b.this.aRd = 0;
                    if (b.this.aRb.EZ().getScrollY() > 0) {
                        b.this.aRb.EZ().setScrollY(0);
                        b.this.brR = false;
                    }
                    if (b.this.brQ != null && b.this.brQ.getVisibility() == 0) {
                        ((FrameLayout) decorView.findViewById(16908290)).removeView(b.this.brQ);
                        b.this.brQ = null;
                    }
                }
                if (editText.hasFocus()) {
                    editText.clearFocus();
                    if (b.DEBUG) {
                        Log.d("TextAreaSecondaryParser", "clearFocus");
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0223a
            public void fm(String str) {
                if (b.this.brN.get(str) != null && ((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(str)).brJ != editText.getLineCount()) {
                    c.d("TextAreaSecondaryParser", "send line change callback");
                    b.this.a(editText, "linechange", aVar, b.this.aRd);
                    ((com.baidu.swan.apps.textarea.b.a) b.this.brN.get(str)).brJ = editText.getLineCount();
                    b.this.a(editText, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TH() {
        SwanAppActivity Lq = e.LE().Lq();
        if (Lq == null) {
            c.w("TextAreaSecondaryParser", "activity is null when close input");
            return;
        }
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "forceCloseKeyboard");
        }
        p.a(Lq, Lq.getWindow().getDecorView().getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText, String str) {
        boolean z = this.brN.get(str).brC;
        if (editText.hasFocus() && !this.brN.get(str).aXv) {
            if (this.aRd > 0 && z && this.brR) {
                int height = (editText.getHeight() - this.brO) + this.aRb.EZ().getScrollY();
                if (height > 0) {
                    this.aRb.EZ().setScrollY(height);
                } else {
                    this.aRb.EZ().setScrollY(0);
                }
            }
            this.brO = editText.getHeight();
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
                        jSONObject.put("keyboardHeight", z.U(b.this.aRd));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (b.DEBUG) {
                        Log.d("TextAreaSecondaryParser", "changeTextAreaStatus:" + jSONObject.toString());
                    }
                    b.this.brL.d(obj, jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(EditText editText, com.baidu.swan.apps.textarea.b.a aVar) {
        int lineCount = editText.getLineCount();
        int lineHeight = editText.getLineHeight();
        int i = aVar.brI;
        int i2 = aVar.mMaxHeight;
        int height = editText.getHeight();
        if (aVar.brv) {
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
        com.baidu.swan.apps.textarea.b.a aVar = this.brN.get(str);
        EditText editText = this.brM.get(aVar.id);
        a(editText, "linechange", aVar, this.aRd);
        this.brN.get(str).brJ = editText.getLineCount();
    }
}
