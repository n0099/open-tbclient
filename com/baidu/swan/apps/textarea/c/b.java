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
import com.baidu.swan.apps.c;
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
    protected static final boolean DEBUG = c.DEBUG;
    private a aVp;
    private int aVs;
    private ShowConfirmBarLayout aVu;
    private d awt;
    private int awv;
    private HashMap<String, EditText> aVq = null;
    private HashMap<String, com.baidu.swan.apps.textarea.b.a> aVr = null;
    private boolean aVv = false;
    private SwanAppActivity aVt = e.Ec().DO();

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b() {
        d yP;
        com.baidu.swan.apps.core.c.e uz = e.Ec().uz();
        if (uz != null && (yP = uz.yP()) != null) {
            this.awt = yP;
        }
    }

    public boolean a(a aVar, Context context, JSONObject jSONObject) {
        this.aVp = aVar;
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "addTextAreaEditText paramsJson: " + jSONObject);
        }
        com.baidu.swan.apps.textarea.b.a aj = com.baidu.swan.apps.textarea.b.a.aj(jSONObject);
        if (this.aVq == null) {
            this.aVq = new HashMap<>();
        }
        if (this.aVq.get(aj.id) != null) {
            com.baidu.swan.apps.console.c.w("TextAreaSecondaryParser", "insert failed: text has added with same view id");
            return false;
        }
        if (this.aVr == null) {
            this.aVr = new HashMap<>();
        }
        if (this.aVt != null) {
            EditText editText = new EditText(this.aVt);
            this.aVr.put(aj.id, aj);
            a(true, editText, aj, (Activity) this.aVt);
            this.aVq.put(aj.id, editText);
            editText.setTag(aj.id);
            a(editText, this.aVt, aj);
            if (aj.aBI) {
                if (this.awt != null) {
                    FrameLayout yy = this.awt.yy();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aj.mWidth, aj.mHeight);
                    layoutParams.topMargin = aj.mTop;
                    layoutParams.leftMargin = aj.mLeft;
                    yy.addView(editText, layoutParams);
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(aj.mLeft, aj.mTop, aj.mWidth, aj.mHeight);
            if (aj.aUY) {
                bVar.br(true);
            }
            aj.aBE = bVar;
            return new SwanAppNAViewContainer(context).a(editText, aj);
        }
        return false;
    }

    public boolean ak(JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "updateTextAreaById paramsJson: " + jSONObject);
        }
        if (this.aVt == null) {
            return false;
        }
        com.baidu.swan.apps.textarea.b.a a2 = com.baidu.swan.apps.textarea.b.a.a(this.aVr.get(jSONObject.optString("inputId")), jSONObject);
        EditText editText = this.aVq.get(a2.id);
        this.aVr.put(a2.id, a2);
        if (editText != null) {
            a(false, editText, a2, (Activity) this.aVt);
            if (a2.aBI) {
                if (this.awt != null) {
                    FrameLayout yy = this.awt.yy();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2.mWidth, a2.mHeight);
                    layoutParams.topMargin = a2.mTop;
                    layoutParams.leftMargin = a2.mLeft;
                    if (!editText.getParent().equals(yy)) {
                        com.baidu.swan.apps.console.c.d("TextAreaSecondaryParser", "textarea change to fixed");
                        b(true, a2.aBC, a2.id, a2.aBD);
                        ((ViewGroup) editText.getParent()).removeView(editText);
                        yy.addView(editText, layoutParams);
                    } else {
                        yy.updateViewLayout(editText, layoutParams);
                    }
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(a2.mLeft, a2.mTop, a2.mWidth, a2.mHeight);
            if (a2.aUY) {
                bVar.br(true);
            }
            a2.aBE = bVar;
            SwanAppNAViewContainer a3 = com.baidu.swan.apps.view.container.c.b.a(a2, null);
            return a3 != null && a3.a(a2);
        }
        return false;
    }

    public boolean b(boolean z, String str, String str2, String str3) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "removeTextAreaById id: " + str2);
        }
        EditText editText = this.aVq.get(str2);
        if (editText == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
        aVar.aBC = str;
        aVar.id = str2;
        aVar.aBD = str3;
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a2 == null) {
            d(editText);
        } else if (!a2.MK()) {
            d(editText);
        }
        if (z) {
            return true;
        }
        this.aVq.remove(str2);
        this.aVr.remove(str2);
        if (this.aVq.size() == 0) {
            com.baidu.swan.apps.textarea.c.a.Lw().hs(str);
            this.aVq = null;
        }
        return true;
    }

    private boolean d(EditText editText) {
        if (this.awt == null) {
            return false;
        }
        this.awt.yy().removeView(editText);
        return true;
    }

    public void ht(String str) {
        b hr = com.baidu.swan.apps.textarea.c.a.Lw().hr(str);
        if (hr != null) {
            for (EditText editText : hr.aVq.values()) {
                if (editText != null) {
                    String obj = editText.getTag().toString();
                    com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
                    aVar.aBC = str;
                    aVar.id = obj;
                    SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
                    if (a2 != null && !a2.MK() && this.awt != null) {
                        this.awt.yy().removeView(editText);
                    }
                }
            }
            com.baidu.swan.apps.textarea.c.a.Lw().hs(str);
            hr.aVq = null;
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
        SpannableString spannableString = new SpannableString(aVar.aUT);
        String str = aVar.aUV;
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
        spannableString.setSpan(styleSpan, 0, aVar.aUT.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.swan.apps.ae.a.c.parseColor(aVar.aUW)), 0, aVar.aUT.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.aUU, true), 0, aVar.aUT.length(), 33);
        editText.setHint(spannableString);
        int length = editText.getText().length();
        if (aVar.aUX) {
            if (aVar.aVc <= length && aVar.aVc >= 0) {
                editText.setSelection(aVar.aVc);
            } else {
                editText.setSelection(length);
            }
        }
        if (aVar.aVe <= length && aVar.aVe > 0 && aVar.aVd <= aVar.aVe && aVar.aVd > 0 && aVar.aUX && !editText.hasFocus()) {
            editText.setSelection(aVar.aVd, aVar.aVe);
        }
        if (aVar.aVa >= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(aVar.aVa)});
        }
        String str2 = aVar.aVg;
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
        String str3 = aVar.aVj;
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
        editText.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(aVar.aVh));
        editText.setTextSize(aVar.mFontSize);
        if (aVar.aVl != null) {
            editText.setPadding(x.ad(aVar.aVl.optInt(3)), x.ad(aVar.aVl.optInt(0)), x.ad(aVar.aVl.optInt(1)), x.ad(aVar.aVl.optInt(2)));
        }
        editText.setLineSpacing(aVar.aVi, 1.0f);
        if (z) {
            editText.setMinHeight(aVar.aVm);
            editText.setMaxHeight(aVar.mMaxHeight);
        }
        if (aVar.aUY) {
            aVar.mHeight = -2;
        }
        new Handler().post(new Runnable() { // from class: com.baidu.swan.apps.textarea.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (activity == null) {
                    com.baidu.swan.apps.console.c.w("TextAreaSecondaryParser", "activity is null, set textarea attr failed");
                    return;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                if (inputMethodManager != null && aVar.aUX) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }
        });
        editText.setEnabled(!aVar.aVk);
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
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(obj)).aVn != editText.getLineCount()) {
                        com.baidu.swan.apps.console.c.d("TextAreaSecondaryParser", "send line change callback");
                        b.this.a(editText, "linechange", aVar, b.this.awv);
                        ((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(obj)).aVn = editText.getLineCount();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editText.hasFocus()) {
                    com.baidu.swan.apps.console.c.d("TextAreaSecondaryParser", "send input callback");
                    b.this.a(editText, "input", aVar, b.this.awv);
                }
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.swan.apps.textarea.c.b.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    if (b.this.awv != 0) {
                        b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.awv);
                        return;
                    }
                    return;
                }
                b.this.a(editText, "blur", aVar, 0);
            }
        });
        com.baidu.swan.apps.textarea.a.a(aVar.id, swanAppActivity, new a.InterfaceC0149a() { // from class: com.baidu.swan.apps.textarea.c.b.4
            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0149a
            public void B(String str, int i) {
                int i2;
                com.baidu.swan.apps.b.c.d DP = e.Ec().DP();
                if (b.this.aVr.get(str) != null && b.this.awv != i && editText.hasFocus() && DP != null) {
                    b.this.awv = i;
                    b.this.aVs = editText.getHeight();
                    b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.awv);
                    boolean z = ((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(str)).aVf;
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(str)).aUZ) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int ad = x.ad(38.0f);
                        if (b.this.aVu == null) {
                            b.this.aVu = new ShowConfirmBarLayout(swanAppActivity);
                            b.this.aVu.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.textarea.c.b.4.1
                                @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                                public void onClick(View view) {
                                    if (swanAppActivity == null) {
                                        com.baidu.swan.apps.console.c.w("TextAreaSecondaryParser", "activity is null when click confirmBar");
                                        return;
                                    }
                                    InputMethodManager inputMethodManager = (InputMethodManager) swanAppActivity.getSystemService("input_method");
                                    if (inputMethodManager != null) {
                                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                    }
                                    com.baidu.swan.apps.console.c.d("TextAreaSecondaryParser", "send confirm change callback");
                                    b.this.a(editText, "confirm", aVar, b.this.awv);
                                }
                            });
                            View decorView = swanAppActivity.getWindow().getDecorView();
                            layoutParams.topMargin = ((decorView.getHeight() - i) - ad) - x.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(b.this.aVu, layoutParams);
                        }
                        i2 = ad;
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        int webViewScrollY = (!((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(str)).aBI ? DP.getWebViewScrollY() : 0) + ((b.this.awt.yy().getHeight() - ((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(str)).mTop) - editText.getHeight());
                        int i3 = ((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(str)).aVb;
                        if (webViewScrollY - i3 < i) {
                            b.this.aVv = true;
                            if (i3 > webViewScrollY) {
                                b.this.awt.yy().setScrollY(i + i2);
                                return;
                            } else {
                                b.this.awt.yy().setScrollY(i3 + (i - webViewScrollY) + i2);
                                return;
                            }
                        }
                        b.this.aVv = false;
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0149a
            public void C(String str, int i) {
                if (b.this.awv != 0 && b.this.aVr.get(str) != null) {
                    b.this.awv = 0;
                    if (b.this.awt.yy().getScrollY() > 0) {
                        b.this.awt.yy().setScrollY(0);
                        b.this.aVv = false;
                    }
                    if (b.this.aVu != null && b.this.aVu.getVisibility() == 0) {
                        ((FrameLayout) swanAppActivity.getWindow().getDecorView().findViewById(16908290)).removeView(b.this.aVu);
                        b.this.aVu = null;
                    }
                }
                if (editText.getParent() != null && editText.hasFocus()) {
                    ((ViewGroup) editText.getParent()).requestFocus();
                    editText.clearFocus();
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0149a
            public void eJ(String str) {
                if (b.this.aVr.get(str) != null && ((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(str)).aVn != editText.getLineCount()) {
                    com.baidu.swan.apps.console.c.d("TextAreaSecondaryParser", "send line change callback");
                    b.this.a(editText, "linechange", aVar, b.this.awv);
                    ((com.baidu.swan.apps.textarea.b.a) b.this.aVr.get(str)).aVn = editText.getLineCount();
                    b.this.a(editText, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText, String str) {
        boolean z = this.aVr.get(str).aVf;
        if (editText.hasFocus() && !this.aVr.get(str).aBI) {
            if (this.awv > 0 && z && this.aVv) {
                int height = (editText.getHeight() - this.aVs) + this.awt.yy().getScrollY();
                if (height > 0) {
                    this.awt.yy().setScrollY(height);
                } else {
                    this.awt.yy().setScrollY(0);
                }
            }
            this.aVs = editText.getHeight();
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
                        jSONObject.put("keyboardHeight", x.ae(b.this.awv));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    b.this.aVp.d(obj, jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(EditText editText, com.baidu.swan.apps.textarea.b.a aVar) {
        int lineCount = editText.getLineCount();
        int lineHeight = editText.getLineHeight();
        int i = aVar.aVm;
        int i2 = aVar.mMaxHeight;
        int height = editText.getHeight();
        if (aVar.aUY) {
            int paddingBottom = editText.getPaddingBottom() + (lineHeight * lineCount) + editText.getPaddingTop();
            int i3 = i2 < i ? i : i2;
            if (paddingBottom <= i) {
                return i;
            }
            return paddingBottom >= i3 ? i3 : paddingBottom;
        }
        return height;
    }

    public void hu(String str) {
        com.baidu.swan.apps.textarea.b.a aVar = this.aVr.get(str);
        EditText editText = this.aVq.get(aVar.id);
        a(editText, "linechange", aVar, this.awv);
        this.aVr.get(str).aVn = editText.getLineCount();
    }
}
