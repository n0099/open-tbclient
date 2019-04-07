package com.baidu.swan.apps.textarea.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
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
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.c.d;
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
    private a aVt;
    private int aVw;
    private ShowConfirmBarLayout aVy;
    private d awx;
    private int awz;
    private HashMap<String, EditText> aVu = null;
    private HashMap<String, com.baidu.swan.apps.textarea.b.a> aVv = null;
    private boolean aVz = false;
    private SwanAppActivity aVx = e.Ea().DM();

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b() {
        d yO;
        com.baidu.swan.apps.core.c.e uy = e.Ea().uy();
        if (uy != null && (yO = uy.yO()) != null) {
            this.awx = yO;
        }
    }

    public boolean a(a aVar, Context context, JSONObject jSONObject) {
        this.aVt = aVar;
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "addTextAreaEditText paramsJson: " + jSONObject);
        }
        com.baidu.swan.apps.textarea.b.a aj = com.baidu.swan.apps.textarea.b.a.aj(jSONObject);
        if (this.aVu == null) {
            this.aVu = new HashMap<>();
        }
        if (this.aVu.get(aj.id) != null) {
            c.w("TextAreaSecondaryParser", "insert failed: text has added with same view id");
            return false;
        }
        if (this.aVv == null) {
            this.aVv = new HashMap<>();
        }
        if (this.aVx != null) {
            EditText editText = new EditText(this.aVx);
            this.aVv.put(aj.id, aj);
            a(true, editText, aj, (Activity) this.aVx);
            this.aVu.put(aj.id, editText);
            editText.setTag(aj.id);
            a(editText, this.aVx, aj);
            if (aj.aBM) {
                if (this.awx != null) {
                    FrameLayout yx = this.awx.yx();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aj.mWidth, aj.mHeight);
                    layoutParams.topMargin = aj.mTop;
                    layoutParams.leftMargin = aj.mLeft;
                    yx.addView(editText, layoutParams);
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(aj.mLeft, aj.mTop, aj.mWidth, aj.mHeight);
            if (aj.aVc) {
                bVar.br(true);
            }
            aj.aBI = bVar;
            return new SwanAppNAViewContainer(context).a(editText, aj);
        }
        return false;
    }

    public boolean ak(JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "updateTextAreaById paramsJson: " + jSONObject);
        }
        if (this.aVx == null) {
            return false;
        }
        com.baidu.swan.apps.textarea.b.a a2 = com.baidu.swan.apps.textarea.b.a.a(this.aVv.get(jSONObject.optString("inputId")), jSONObject);
        EditText editText = this.aVu.get(a2.id);
        this.aVv.put(a2.id, a2);
        if (editText != null) {
            a(false, editText, a2, (Activity) this.aVx);
            if (a2.aBM) {
                if (this.awx != null) {
                    FrameLayout yx = this.awx.yx();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2.mWidth, a2.mHeight);
                    layoutParams.topMargin = a2.mTop;
                    layoutParams.leftMargin = a2.mLeft;
                    if (!editText.getParent().equals(yx)) {
                        c.d("TextAreaSecondaryParser", "textarea change to fixed");
                        b(true, a2.aBG, a2.id, a2.aBH);
                        ((ViewGroup) editText.getParent()).removeView(editText);
                        yx.addView(editText, layoutParams);
                    } else {
                        yx.updateViewLayout(editText, layoutParams);
                    }
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(a2.mLeft, a2.mTop, a2.mWidth, a2.mHeight);
            if (a2.aVc) {
                bVar.br(true);
            }
            a2.aBI = bVar;
            SwanAppNAViewContainer a3 = com.baidu.swan.apps.view.container.c.b.a(a2, null);
            return a3 != null && a3.a(a2);
        }
        return false;
    }

    public boolean b(boolean z, String str, String str2, String str3) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "removeTextAreaById id: " + str2);
        }
        EditText editText = this.aVu.get(str2);
        if (editText == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
        aVar.aBG = str;
        aVar.id = str2;
        aVar.aBH = str3;
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a2 == null) {
            d(editText);
        } else if (!a2.MI()) {
            d(editText);
        }
        if (z) {
            return true;
        }
        this.aVu.remove(str2);
        this.aVv.remove(str2);
        if (this.aVu.size() == 0) {
            com.baidu.swan.apps.textarea.c.a.Lu().ht(str);
            this.aVu = null;
        }
        return true;
    }

    private boolean d(EditText editText) {
        if (this.awx == null) {
            return false;
        }
        this.awx.yx().removeView(editText);
        return true;
    }

    public void hu(String str) {
        b hs = com.baidu.swan.apps.textarea.c.a.Lu().hs(str);
        if (hs != null) {
            for (EditText editText : hs.aVu.values()) {
                if (editText != null) {
                    String obj = editText.getTag().toString();
                    com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
                    aVar.aBG = str;
                    aVar.id = obj;
                    SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
                    if (a2 != null && !a2.MI() && this.awx != null) {
                        this.awx.yx().removeView(editText);
                    }
                }
            }
            com.baidu.swan.apps.textarea.c.a.Lu().ht(str);
            hs.aVu = null;
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
        SpannableString spannableString = new SpannableString(aVar.aUX);
        String str = aVar.aUZ;
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
        spannableString.setSpan(styleSpan, 0, aVar.aUX.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.swan.apps.ae.a.c.parseColor(aVar.aVa)), 0, aVar.aUX.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.aUY, true), 0, aVar.aUX.length(), 33);
        editText.setHint(spannableString);
        int length = editText.getText().length();
        if (aVar.aVb) {
            if (aVar.aVg <= length && aVar.aVg >= 0) {
                editText.setSelection(aVar.aVg);
            } else {
                editText.setSelection(length);
            }
        }
        if (aVar.aVi <= length && aVar.aVi > 0 && aVar.aVh <= aVar.aVi && aVar.aVh > 0 && aVar.aVb && !editText.hasFocus()) {
            editText.setSelection(aVar.aVh, aVar.aVi);
        }
        if (aVar.aVe >= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(aVar.aVe)});
        }
        String str2 = aVar.aVk;
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
        String str3 = aVar.aVn;
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
        editText.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(aVar.aVl));
        editText.setTextSize(aVar.mFontSize);
        if (aVar.aVp != null) {
            editText.setPadding(x.ad(aVar.aVp.optInt(3)), x.ad(aVar.aVp.optInt(0)), x.ad(aVar.aVp.optInt(1)), x.ad(aVar.aVp.optInt(2)));
        }
        editText.setLineSpacing(aVar.aVm, 1.0f);
        if (z) {
            editText.setMinHeight(aVar.aVq);
            editText.setMaxHeight(aVar.mMaxHeight);
        }
        if (aVar.aVc) {
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
                if (inputMethodManager != null && aVar.aVb) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }
        });
        editText.setEnabled(!aVar.aVo);
    }

    private void a(final EditText editText, final SwanAppActivity swanAppActivity, final com.baidu.swan.apps.textarea.b.a aVar) {
        editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.swan.apps.textarea.c.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (editText.getLineCount() > 0) {
                    String obj = editText.getTag().toString();
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(obj)).aVr != editText.getLineCount()) {
                        c.d("TextAreaSecondaryParser", "send line change callback");
                        b.this.a(editText, "linechange", aVar, b.this.awz);
                        ((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(obj)).aVr = editText.getLineCount();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editText.hasFocus()) {
                    c.d("TextAreaSecondaryParser", "send input callback");
                    b.this.a(editText, "input", aVar, b.this.awz);
                }
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.swan.apps.textarea.c.b.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    if (b.this.awz != 0) {
                        b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.awz);
                        return;
                    }
                    return;
                }
                b.this.a(editText, "blur", aVar, 0);
            }
        });
        com.baidu.swan.apps.textarea.a.a(aVar.id, swanAppActivity, new a.InterfaceC0178a() { // from class: com.baidu.swan.apps.textarea.c.b.4
            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0178a
            public void B(String str, int i) {
                int i2;
                com.baidu.swan.apps.b.c.d DN = e.Ea().DN();
                if (b.this.aVv.get(str) != null && b.this.awz != i && editText.hasFocus() && DN != null) {
                    b.this.awz = i;
                    b.this.aVw = editText.getHeight();
                    b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.awz);
                    boolean z = ((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(str)).aVj;
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(str)).aVd) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int ad = x.ad(38.0f);
                        if (b.this.aVy == null) {
                            b.this.aVy = new ShowConfirmBarLayout(swanAppActivity);
                            b.this.aVy.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.textarea.c.b.4.1
                                @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                                public void onClick(View view) {
                                    if (swanAppActivity == null) {
                                        c.w("TextAreaSecondaryParser", "activity is null when click confirmBar");
                                        return;
                                    }
                                    InputMethodManager inputMethodManager = (InputMethodManager) swanAppActivity.getSystemService("input_method");
                                    if (inputMethodManager != null) {
                                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                    }
                                    c.d("TextAreaSecondaryParser", "send confirm change callback");
                                    b.this.a(editText, "confirm", aVar, b.this.awz);
                                }
                            });
                            View decorView = swanAppActivity.getWindow().getDecorView();
                            layoutParams.topMargin = ((decorView.getHeight() - i) - ad) - x.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(b.this.aVy, layoutParams);
                        }
                        i2 = ad;
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        int webViewScrollY = (!((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(str)).aBM ? DN.getWebViewScrollY() : 0) + ((b.this.awx.yx().getHeight() - ((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(str)).mTop) - editText.getHeight());
                        int i3 = ((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(str)).aVf;
                        if (webViewScrollY - i3 < i) {
                            b.this.aVz = true;
                            if (i3 > webViewScrollY) {
                                b.this.awx.yx().setScrollY(i + i2);
                                return;
                            } else {
                                b.this.awx.yx().setScrollY(i3 + (i - webViewScrollY) + i2);
                                return;
                            }
                        }
                        b.this.aVz = false;
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0178a
            public void C(String str, int i) {
                if (b.this.awz != 0 && b.this.aVv.get(str) != null) {
                    b.this.awz = 0;
                    if (b.this.awx.yx().getScrollY() > 0) {
                        b.this.awx.yx().setScrollY(0);
                        b.this.aVz = false;
                    }
                    if (b.this.aVy != null && b.this.aVy.getVisibility() == 0) {
                        ((FrameLayout) swanAppActivity.getWindow().getDecorView().findViewById(16908290)).removeView(b.this.aVy);
                        b.this.aVy = null;
                    }
                }
                if (editText.getParent() != null && editText.hasFocus()) {
                    ((ViewGroup) editText.getParent()).requestFocus();
                    editText.clearFocus();
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0178a
            public void eK(String str) {
                if (b.this.aVv.get(str) != null && ((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(str)).aVr != editText.getLineCount()) {
                    c.d("TextAreaSecondaryParser", "send line change callback");
                    b.this.a(editText, "linechange", aVar, b.this.awz);
                    ((com.baidu.swan.apps.textarea.b.a) b.this.aVv.get(str)).aVr = editText.getLineCount();
                    b.this.a(editText, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText, String str) {
        boolean z = this.aVv.get(str).aVj;
        if (editText.hasFocus() && !this.aVv.get(str).aBM) {
            if (this.awz > 0 && z && this.aVz) {
                int height = (editText.getHeight() - this.aVw) + this.awx.yx().getScrollY();
                if (height > 0) {
                    this.awx.yx().setScrollY(height);
                } else {
                    this.awx.yx().setScrollY(0);
                }
            }
            this.aVw = editText.getHeight();
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
                        jSONObject.put("height", x.ae(a2));
                        jSONObject.put("keyboardHeight", x.ae(b.this.awz));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.aVt.d(obj, jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(EditText editText, com.baidu.swan.apps.textarea.b.a aVar) {
        int lineCount = editText.getLineCount();
        int lineHeight = editText.getLineHeight();
        int i = aVar.aVq;
        int i2 = aVar.mMaxHeight;
        int height = editText.getHeight();
        if (aVar.aVc) {
            int paddingBottom = editText.getPaddingBottom() + (lineHeight * lineCount) + editText.getPaddingTop();
            int i3 = i2 < i ? i : i2;
            if (paddingBottom <= i) {
                return i;
            }
            return paddingBottom >= i3 ? i3 : paddingBottom;
        }
        return height;
    }

    public void hv(String str) {
        com.baidu.swan.apps.textarea.b.a aVar = this.aVv.get(str);
        EditText editText = this.aVu.get(aVar.id);
        a(editText, "linechange", aVar, this.awz);
        this.aVv.get(str).aVr = editText.getLineCount();
    }
}
