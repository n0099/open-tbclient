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
    private a aYu;
    private int aYx;
    private ShowConfirmBarLayout aYz;
    private d axa;
    private int axc;
    private HashMap<String, EditText> aYv = null;
    private HashMap<String, com.baidu.swan.apps.textarea.b.a> aYw = null;
    private boolean aYA = false;
    private SwanAppActivity aYy = e.FV().FH();

    /* loaded from: classes2.dex */
    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public b() {
        d zL;
        com.baidu.swan.apps.core.d.e vi = e.FV().vi();
        if (vi != null && (zL = vi.zL()) != null) {
            this.axa = zL;
        }
    }

    public boolean a(a aVar, Context context, JSONObject jSONObject) {
        this.aYu = aVar;
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "addTextAreaEditText paramsJson: " + jSONObject);
        }
        com.baidu.swan.apps.textarea.b.a al = com.baidu.swan.apps.textarea.b.a.al(jSONObject);
        if (this.aYv == null) {
            this.aYv = new HashMap<>();
        }
        if (this.aYv.get(al.id) != null) {
            c.w("TextAreaSecondaryParser", "insert failed: text has added with same view id");
            return false;
        }
        if (this.aYw == null) {
            this.aYw = new HashMap<>();
        }
        if (this.aYy != null) {
            EditText editText = new EditText(this.aYy);
            this.aYw.put(al.id, al);
            a(true, editText, al, (Activity) this.aYy);
            this.aYv.put(al.id, editText);
            editText.setTag(al.id);
            a(editText, this.aYy, al);
            if (al.aDs) {
                if (this.axa != null) {
                    FrameLayout zs = this.axa.zs();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(al.mWidth, al.mHeight);
                    layoutParams.topMargin = al.mTop;
                    layoutParams.leftMargin = al.mLeft;
                    zs.addView(editText, layoutParams);
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(al.mLeft, al.mTop, al.mWidth, al.mHeight);
            if (al.aYd) {
                bVar.bz(true);
            }
            al.aDo = bVar;
            return new SwanAppNAViewContainer(context).a(editText, al);
        }
        return false;
    }

    public boolean am(JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "updateTextAreaById paramsJson: " + jSONObject);
        }
        if (this.aYy == null) {
            return false;
        }
        com.baidu.swan.apps.textarea.b.a a2 = com.baidu.swan.apps.textarea.b.a.a(this.aYw.get(jSONObject.optString("inputId")), jSONObject);
        EditText editText = this.aYv.get(a2.id);
        this.aYw.put(a2.id, a2);
        if (editText != null) {
            a(false, editText, a2, (Activity) this.aYy);
            if (a2.aDs) {
                if (this.axa != null) {
                    FrameLayout zs = this.axa.zs();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2.mWidth, a2.mHeight);
                    layoutParams.topMargin = a2.mTop;
                    layoutParams.leftMargin = a2.mLeft;
                    if (!editText.getParent().equals(zs)) {
                        c.d("TextAreaSecondaryParser", "textarea change to fixed");
                        b(true, a2.aDm, a2.id, a2.aDn);
                        ((ViewGroup) editText.getParent()).removeView(editText);
                        zs.addView(editText, layoutParams);
                    } else {
                        zs.updateViewLayout(editText, layoutParams);
                    }
                    return true;
                }
                return false;
            }
            com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b(a2.mLeft, a2.mTop, a2.mWidth, a2.mHeight);
            if (a2.aYd) {
                bVar.bz(true);
            }
            a2.aDo = bVar;
            SwanAppNAViewContainer a3 = com.baidu.swan.apps.view.container.c.b.a(a2, null);
            return a3 != null && a3.a(a2);
        }
        return false;
    }

    public boolean b(boolean z, String str, String str2, String str3) {
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "removeTextAreaById id: " + str2);
        }
        EditText editText = this.aYv.get(str2);
        if (editText == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
        aVar.aDm = str;
        aVar.id = str2;
        aVar.aDn = str3;
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a2 == null) {
            d(editText);
        } else if (!a2.Pr()) {
            d(editText);
        }
        if (z) {
            return true;
        }
        this.aYv.remove(str2);
        this.aYw.remove(str2);
        if (this.aYv.size() == 0) {
            com.baidu.swan.apps.textarea.c.a.NZ().hU(str);
            this.aYv = null;
        }
        return true;
    }

    private boolean d(EditText editText) {
        if (this.axa == null) {
            return false;
        }
        this.axa.zs().removeView(editText);
        return true;
    }

    public void hV(String str) {
        b hT = com.baidu.swan.apps.textarea.c.a.NZ().hT(str);
        if (hT != null) {
            for (EditText editText : hT.aYv.values()) {
                if (editText != null) {
                    String obj = editText.getTag().toString();
                    com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a("", "textArea");
                    aVar.aDm = str;
                    aVar.id = obj;
                    SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
                    if (a2 != null && !a2.Pr() && this.axa != null) {
                        this.axa.zs().removeView(editText);
                    }
                }
            }
            com.baidu.swan.apps.textarea.c.a.NZ().hU(str);
            hT.aYv = null;
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
        SpannableString spannableString = new SpannableString(aVar.aXY);
        String str = aVar.aYa;
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
        spannableString.setSpan(styleSpan, 0, aVar.aXY.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.swan.apps.ae.a.c.parseColor(aVar.aYb)), 0, aVar.aXY.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.aXZ, true), 0, aVar.aXY.length(), 33);
        editText.setHint(spannableString);
        int length = editText.getText().length();
        if (aVar.aYc) {
            if (aVar.aYh <= length && aVar.aYh >= 0) {
                editText.setSelection(aVar.aYh);
            } else {
                editText.setSelection(length);
            }
        }
        if (aVar.aYj <= length && aVar.aYj > 0 && aVar.aYi <= aVar.aYj && aVar.aYi > 0 && aVar.aYc && !editText.hasFocus()) {
            editText.setSelection(aVar.aYi, aVar.aYj);
        }
        if (aVar.aYf >= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(aVar.aYf)});
        }
        String str2 = aVar.aYl;
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
        String str3 = aVar.aYo;
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
        editText.setTextColor(com.baidu.swan.apps.ae.a.c.parseColor(aVar.aYm));
        editText.setTextSize(aVar.mFontSize);
        if (aVar.aYq != null) {
            editText.setPadding(z.ad(aVar.aYq.optInt(3)), z.ad(aVar.aYq.optInt(0)), z.ad(aVar.aYq.optInt(1)), z.ad(aVar.aYq.optInt(2)));
        }
        editText.setLineSpacing(aVar.aYn, 1.0f);
        if (z) {
            editText.setMinHeight(aVar.aYr);
            editText.setMaxHeight(aVar.mMaxHeight);
        }
        if (aVar.aYd) {
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
                if (inputMethodManager != null && aVar.aYc) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }
        });
        editText.setEnabled(!aVar.aYp);
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
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(obj)).aYs != editText.getLineCount()) {
                        c.d("TextAreaSecondaryParser", "send line change callback");
                        b.this.a(editText, "linechange", aVar, b.this.axc);
                        ((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(obj)).aYs = editText.getLineCount();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editText.hasFocus()) {
                    c.d("TextAreaSecondaryParser", "send input callback");
                    b.this.a(editText, "input", aVar, b.this.axc);
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
                    if (b.this.axc != 0) {
                        b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.axc);
                        return;
                    }
                    return;
                }
                b.this.a(editText, "blur", aVar, 0);
                b.this.Oa();
            }
        });
        final View decorView = swanAppActivity.getWindow().getDecorView();
        com.baidu.swan.apps.textarea.a.NX().a(decorView, aVar.id, new a.InterfaceC0185a() { // from class: com.baidu.swan.apps.textarea.c.b.4
            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0185a
            public void y(String str, int i) {
                int i2;
                com.baidu.swan.apps.b.c.d FI = e.FV().FI();
                if (b.this.aYw.get(str) != null && b.this.axc != i && editText.hasFocus() && FI != null) {
                    b.this.axc = i;
                    b.this.aYx = editText.getHeight();
                    b.this.a(editText, AddFriendActivityConfig.TYPE_FOCUS, aVar, b.this.axc);
                    boolean z = ((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(str)).aYk;
                    if (((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(str)).aYe) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int ad = z.ad(38.0f);
                        if (b.this.aYz == null) {
                            b.this.aYz = new ShowConfirmBarLayout(swanAppActivity);
                            b.this.aYz.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.textarea.c.b.4.1
                                @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                                public void onClick(View view) {
                                    InputMethodManager inputMethodManager = (InputMethodManager) swanAppActivity.getSystemService("input_method");
                                    if (inputMethodManager != null) {
                                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                    }
                                    c.d("TextAreaSecondaryParser", "send confirm change callback");
                                    b.this.a(editText, "confirm", aVar, b.this.axc);
                                }
                            });
                            layoutParams.topMargin = ((decorView.getHeight() - i) - ad) - z.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(b.this.aYz, layoutParams);
                        }
                        i2 = ad;
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        int webViewScrollY = (!((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(str)).aDs ? FI.getWebViewScrollY() : 0) + ((b.this.axa.zs().getHeight() - ((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(str)).mTop) - editText.getHeight());
                        int i3 = ((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(str)).aYg;
                        if (webViewScrollY - i3 < i) {
                            b.this.aYA = true;
                            if (i3 > webViewScrollY) {
                                b.this.axa.zs().setScrollY(i + i2);
                                return;
                            } else {
                                b.this.axa.zs().setScrollY(i3 + (i - webViewScrollY) + i2);
                                return;
                            }
                        }
                        b.this.aYA = false;
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0185a
            public void z(String str, int i) {
                if (b.this.axc != 0 && b.this.aYw.get(str) != null) {
                    b.this.axc = 0;
                    if (b.this.axa.zs().getScrollY() > 0) {
                        b.this.axa.zs().setScrollY(0);
                        b.this.aYA = false;
                    }
                    if (b.this.aYz != null && b.this.aYz.getVisibility() == 0) {
                        ((FrameLayout) decorView.findViewById(16908290)).removeView(b.this.aYz);
                        b.this.aYz = null;
                    }
                }
                if (editText.hasFocus()) {
                    editText.clearFocus();
                    if (b.DEBUG) {
                        Log.d("TextAreaSecondaryParser", "clearFocus");
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a.InterfaceC0185a
            public void ey(String str) {
                if (b.this.aYw.get(str) != null && ((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(str)).aYs != editText.getLineCount()) {
                    c.d("TextAreaSecondaryParser", "send line change callback");
                    b.this.a(editText, "linechange", aVar, b.this.axc);
                    ((com.baidu.swan.apps.textarea.b.a) b.this.aYw.get(str)).aYs = editText.getLineCount();
                    b.this.a(editText, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        SwanAppActivity FH = e.FV().FH();
        if (FH == null) {
            c.w("TextAreaSecondaryParser", "activity is null when close input");
            return;
        }
        if (DEBUG) {
            Log.d("TextAreaSecondaryParser", "forceCloseKeyboard");
        }
        p.a(FH, FH.getWindow().getDecorView().getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText, String str) {
        boolean z = this.aYw.get(str).aYk;
        if (editText.hasFocus() && !this.aYw.get(str).aDs) {
            if (this.axc > 0 && z && this.aYA) {
                int height = (editText.getHeight() - this.aYx) + this.axa.zs().getScrollY();
                if (height > 0) {
                    this.axa.zs().setScrollY(height);
                } else {
                    this.axa.zs().setScrollY(0);
                }
            }
            this.aYx = editText.getHeight();
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
                        jSONObject.put("keyboardHeight", z.af(b.this.axc));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (b.DEBUG) {
                        Log.d("TextAreaSecondaryParser", "changeTextAreaStatus:" + jSONObject.toString());
                    }
                    b.this.aYu.d(obj, jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(EditText editText, com.baidu.swan.apps.textarea.b.a aVar) {
        int lineCount = editText.getLineCount();
        int lineHeight = editText.getLineHeight();
        int i = aVar.aYr;
        int i2 = aVar.mMaxHeight;
        int height = editText.getHeight();
        if (aVar.aYd) {
            int paddingBottom = editText.getPaddingBottom() + (lineHeight * lineCount) + editText.getPaddingTop();
            int i3 = i2 < i ? i : i2;
            if (paddingBottom <= i) {
                return i;
            }
            return paddingBottom >= i3 ? i3 : paddingBottom;
        }
        return height;
    }

    public void hW(String str) {
        com.baidu.swan.apps.textarea.b.a aVar = this.aYw.get(str);
        EditText editText = this.aYv.get(aVar.id);
        a(editText, "linechange", aVar, this.axc);
        this.aYw.get(str).aYs = editText.getLineCount();
    }
}
