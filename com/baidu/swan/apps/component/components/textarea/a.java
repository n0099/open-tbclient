package com.baidu.swan.apps.component.components.textarea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.t;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.y.f;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a extends com.baidu.swan.apps.component.a.a.a<SwanEditText, b> {
    private d biZ;
    private int bjb;
    private SwanAppActivity bjl;
    private InterfaceC0233a bjm;
    private int bjn;
    private ShowConfirmBarLayout bjo;
    private boolean bjp;
    private int bjq;
    private String mCallback;

    /* renamed from: com.baidu.swan.apps.component.components.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0233a {
        void b(String str, String str2, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar, @NonNull InterfaceC0233a interfaceC0233a) {
        super(context, bVar);
        this.bjp = false;
        this.bjq = 1;
        this.bjl = swanAppActivity;
        this.biZ = dVar;
        this.bjm = interfaceC0233a;
    }

    public void gt(String str) {
        if (!TextUtils.equals(((b) KL()).biA, str)) {
            com.baidu.swan.apps.component.e.a.at("Component-TextArea", "sendLineChangeEvent with different id");
        }
        SwanEditText swanEditText = (SwanEditText) getView();
        if (swanEditText == null) {
            com.baidu.swan.apps.component.e.a.at("Component-TextArea", "sendLineChangeEvent with a null editText");
        } else {
            a(swanEditText, "linechange");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bO */
    public SwanEditText bm(@NonNull Context context) {
        return new SwanEditText(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void ac(@NonNull SwanEditText swanEditText) {
        super.ac(swanEditText);
        b bVar = (b) KL();
        swanEditText.setTag(bVar.biA);
        swanEditText.setInputType(262144);
        swanEditText.setSingleLine(false);
        swanEditText.setHorizontallyScrolling(false);
        this.mCallback = bVar.callback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.a.a, com.baidu.swan.apps.component.a.c.a, com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull b bVar, @NonNull b bVar2) {
        com.baidu.swan.apps.component.d.b a = super.a(bVar, bVar2);
        if (!TextUtils.equals(bVar.hint, bVar2.hint)) {
            a.ei(14);
        }
        if (bVar.bjv != bVar2.bjv) {
            a.ei(14);
        }
        if (!TextUtils.equals(bVar.bjw, bVar2.bjw)) {
            a.ei(14);
        }
        if (!TextUtils.equals(bVar.bjx, bVar2.bjx)) {
            a.ei(14);
        }
        if (bVar.bjE != bVar2.bjE) {
            a.ei(15);
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.a.a
    public void a(@NonNull final SwanEditText swanEditText, @NonNull final b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        super.a((a) swanEditText, (SwanEditText) bVar, bVar2);
        if (bVar2.ej(14)) {
            f(swanEditText, bVar);
        }
        boolean z = !KP();
        if (z) {
            swanEditText.setMinHeight(bVar.bjD);
            swanEditText.setMaxHeight(bVar.maxHeight);
        }
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.component.components.textarea.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bjl != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.bjl.getSystemService("input_method");
                    if (inputMethodManager != null && bVar.bjy) {
                        swanEditText.setFocusable(true);
                        swanEditText.setFocusableInTouchMode(true);
                        swanEditText.requestFocus();
                        inputMethodManager.showSoftInput(swanEditText, 0);
                        return;
                    }
                    return;
                }
                com.baidu.swan.apps.component.e.a.at("Component-TextArea", "activity is null, set textarea attr failed");
            }
        });
        if (bVar2.ej(15)) {
            g(swanEditText, bVar);
        }
        if (z) {
            a(swanEditText, this.bjl);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a
    public void a(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-TextArea", "renderText");
        }
        if (!TextUtils.equals(swanEditText.getText(), bVar.text)) {
            swanEditText.setText(bVar.text);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.a.a
    public void b(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        Editable text = swanEditText.getText();
        int i = 0;
        if (text != null) {
            i = text.length();
        }
        if (bVar.bjy) {
            if (bVar.bhW <= i && bVar.bhW >= 0) {
                swanEditText.setSelection(bVar.bhW);
            } else {
                swanEditText.setSelection(i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.a.a
    public void c(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        Editable text = swanEditText.getText();
        int i = 0;
        if (text != null) {
            i = text.length();
        }
        if (bVar.selectionEnd <= i && bVar.selectionEnd > 0 && bVar.selectionStart <= bVar.selectionEnd && bVar.selectionStart > 0 && bVar.bjy && !swanEditText.hasFocus()) {
            swanEditText.setSelection(bVar.selectionStart, bVar.selectionEnd);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a
    public void d(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        super.a((a) swanEditText, (SwanEditText) bVar, 48);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a
    /* renamed from: e  reason: avoid collision after fix types in other method */
    public void c(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        swanEditText.setLineSpacing(bVar.lineSpace, 1.0f);
    }

    private void f(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        StyleSpan styleSpan;
        if (DEBUG) {
            Log.d("Component-TextArea", "renderPlaceHolder");
        }
        SpannableString spannableString = new SpannableString(bVar.hint);
        String str = bVar.bjw;
        char c = 65535;
        switch (str.hashCode()) {
            case -1039745817:
                if (str.equals("normal")) {
                    c = 0;
                    break;
                }
                break;
            case 3029637:
                if (str.equals("bold")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                styleSpan = new StyleSpan(0);
                break;
            case 1:
                styleSpan = new StyleSpan(1);
                break;
            default:
                styleSpan = new StyleSpan(0);
                break;
        }
        spannableString.setSpan(styleSpan, 0, bVar.hint.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.cF(bVar.bjx)), 0, bVar.hint.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(bVar.bjv, true), 0, bVar.hint.length(), 33);
        swanEditText.setHint(spannableString);
    }

    private void g(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-TextArea", "renderDisable");
        }
        swanEditText.setEnabled(!bVar.bjE);
    }

    private void a(final SwanEditText swanEditText, @NonNull final SwanAppActivity swanAppActivity) {
        swanEditText.setSelectListener(new SwanEditText.a() { // from class: com.baidu.swan.apps.component.components.textarea.a.2
            @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
            public void selectChanged(int i, int i2) {
                a.this.a(swanEditText, "selection");
            }
        });
        swanEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.swan.apps.component.components.textarea.a.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (swanEditText.getLineCount() > 0 && a.this.bjq != swanEditText.getLineCount()) {
                    c.d("Component-TextArea", "send line change callback");
                    a.this.a(swanEditText, "linechange");
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (swanEditText.hasFocus()) {
                    c.d("Component-TextArea", "send input callback");
                    a.this.a(swanEditText, Config.INPUT_PART);
                }
            }
        });
        swanEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.swan.apps.component.components.textarea.a.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (a.DEBUG) {
                    Log.d("Component-TextArea", "onFocusChange:" + z);
                }
                if (z) {
                    if (a.this.bjb != 0) {
                        a.this.a(swanEditText, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    a.this.KV();
                    return;
                }
                a.this.a(swanEditText, "blur");
                a.this.KU();
            }
        });
        final View decorView = swanAppActivity.getWindow().getDecorView();
        com.baidu.swan.apps.textarea.b.a(((b) KL()).biA, swanAppActivity, new com.baidu.swan.apps.textarea.a() { // from class: com.baidu.swan.apps.component.components.textarea.a.5
            @Override // com.baidu.swan.apps.textarea.a
            public void w(String str, int i) {
                int i2;
                b bVar = (b) a.this.KL();
                com.baidu.swan.apps.adaptation.b.d WH = f.WV().WH();
                if (a.this.bjb != i && swanEditText.hasFocus() && WH != null) {
                    a.this.bjb = i;
                    a.this.bjn = swanEditText.getHeight();
                    a.this.a(swanEditText, AddFriendActivityConfig.TYPE_FOCUS);
                    boolean z = bVar.bjC;
                    if (bVar.bjB) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int S = af.S(38.0f);
                        if (a.this.bjo == null) {
                            a.this.bjo = new ShowConfirmBarLayout(swanAppActivity);
                            a.this.bjo.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.component.components.textarea.a.5.1
                                @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                                public void onClick(View view) {
                                    InputMethodManager inputMethodManager = (InputMethodManager) swanAppActivity.getSystemService("input_method");
                                    if (inputMethodManager != null) {
                                        inputMethodManager.hideSoftInputFromWindow(swanEditText.getWindowToken(), 0);
                                    }
                                    c.d("Component-TextArea", "send confirm change callback");
                                    a.this.a(swanEditText, "confirm");
                                }
                            });
                            layoutParams.topMargin = ((decorView.getHeight() - i) - S) - af.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(a.this.bjo, layoutParams);
                        }
                        i2 = S;
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        int webViewScrollY = (!bVar.bjA ? WH.getWebViewScrollY() : 0) + ((a.this.biZ.getWebViewContainer().getHeight() - (bVar.biE != null ? bVar.biE.getTop() : 0)) - swanEditText.getHeight());
                        int i3 = bVar.bhV;
                        if (webViewScrollY - i3 < i) {
                            a.this.bjp = true;
                            if (i3 > webViewScrollY) {
                                a.this.biZ.getWebViewContainer().setScrollY(i + i2);
                                return;
                            } else {
                                a.this.biZ.getWebViewContainer().setScrollY(i3 + (i - webViewScrollY) + i2);
                                return;
                            }
                        }
                        a.this.bjp = false;
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a
            public void x(String str, int i) {
                if (a.this.bjb != 0) {
                    a.this.bjb = 0;
                    if (a.this.biZ.getWebViewContainer().getScrollY() > 0) {
                        a.this.biZ.getWebViewContainer().setScrollY(0);
                        a.this.bjp = false;
                    }
                    if (a.this.bjo != null && a.this.bjo.getVisibility() == 0) {
                        ((FrameLayout) decorView.findViewById(16908290)).removeView(a.this.bjo);
                        a.this.bjo = null;
                    }
                }
                if (swanEditText.hasFocus()) {
                    swanEditText.clearFocus();
                    if (a.DEBUG) {
                        Log.d("Component-TextArea", "clearFocus");
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a
            public void gr(String str) {
                if (a.this.bjq != swanEditText.getLineCount()) {
                    c.d("Component-TextArea", "send line change callback");
                    a.this.a(swanEditText, "linechange");
                    a.this.b(swanEditText, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SwanEditText swanEditText, final String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1715965556:
                if (str.equals("selection")) {
                    c = 4;
                    break;
                }
                break;
            case 3027047:
                if (str.equals("blur")) {
                    c = 3;
                    break;
                }
                break;
            case 97604824:
                if (str.equals(AddFriendActivityConfig.TYPE_FOCUS)) {
                    c = 2;
                    break;
                }
                break;
            case 100358090:
                if (str.equals(Config.INPUT_PART)) {
                    c = 1;
                    break;
                }
                break;
            case 259718308:
                if (str.equals("linechange")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.bjq = swanEditText.getLineCount();
                ((b) KL()).ed(swanEditText.getHeight());
                break;
            case 1:
                ((b) KL()).gp(swanEditText.getText().toString());
                break;
            case 2:
                ((b) KL()).cf(true);
                break;
            case 3:
                ((b) KL()).cf(false);
                break;
            case 4:
                ((b) KL()).X(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
                break;
        }
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.component.components.textarea.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (swanEditText != null) {
                    JSONObject jSONObject = new JSONObject();
                    String obj = swanEditText.getTag().toString();
                    if (!TextUtils.equals(obj, ((b) a.this.KL()).biA)) {
                        com.baidu.swan.apps.component.e.a.at("Component-TextArea", "changeTextAreaStatus with different id");
                    }
                    int e = a.this.e(swanEditText);
                    try {
                        jSONObject.put("eventName", str);
                        jSONObject.put("value", swanEditText.getText().toString());
                        jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, swanEditText.getSelectionStart());
                        jSONObject.put("selectionStart", swanEditText.getSelectionStart());
                        jSONObject.put("selectionEnd", swanEditText.getSelectionEnd());
                        jSONObject.put("lineCount", swanEditText.getLineCount());
                        jSONObject.put("height", af.U(e));
                        jSONObject.put("keyboardHeight", af.U(a.this.bjb));
                    } catch (JSONException e2) {
                        if (a.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    if (a.DEBUG) {
                        Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
                    }
                    a.this.bjm.b(obj, a.this.mCallback, jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(SwanEditText swanEditText) {
        b bVar = (b) KL();
        int lineCount = swanEditText.getLineCount();
        int lineHeight = swanEditText.getLineHeight();
        int i = bVar.bjD;
        int i2 = bVar.maxHeight;
        int height = swanEditText.getHeight();
        if (bVar.bjz) {
            int paddingBottom = swanEditText.getPaddingBottom() + (lineHeight * lineCount) + swanEditText.getPaddingTop();
            int i3 = i2 < i ? i : i2;
            return paddingBottom <= i ? i : paddingBottom < i3 ? paddingBottom : i3;
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        SwanAppActivity WG = f.WV().WG();
        if (WG == null) {
            c.w("Component-TextArea", "activity is null when close input");
            return;
        }
        if (DEBUG) {
            Log.d("Component-TextArea", "forceCloseKeyboard");
        }
        t.forceHiddenSoftInput(WG, WG.getWindow().getDecorView().getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        SwanAppActivity WG = f.WV().WG();
        if (WG == null) {
            c.w("Component-TextArea", "activity is null when open input");
            return;
        }
        if (DEBUG) {
            Log.d("Component-TextArea", "forceOpenKeyboard");
        }
        t.forceToggleSoftInput(WG, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SwanEditText swanEditText, String str) {
        b bVar = (b) KL();
        if (!TextUtils.equals(str, bVar.biA)) {
            com.baidu.swan.apps.component.e.a.at("Component-TextArea", "keyBoardShow with different id");
        }
        boolean z = bVar.bjC;
        if (swanEditText.hasFocus() && !bVar.bjA) {
            if (this.bjb > 0 && z && this.bjp) {
                int height = (swanEditText.getHeight() - this.bjn) + this.biZ.getWebViewContainer().getScrollY();
                if (height > 0) {
                    this.biZ.getWebViewContainer().setScrollY(height);
                } else {
                    this.biZ.getWebViewContainer().setScrollY(0);
                }
            }
            this.bjn = swanEditText.getHeight();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.a.a
    /* renamed from: h */
    public boolean e(@NonNull final SwanEditText swanEditText, @NonNull b bVar) {
        if (TextUtils.isEmpty(bVar.bhX) || "default".equals(bVar.bhX)) {
            return false;
        }
        boolean e = super.e((a) swanEditText, (SwanEditText) bVar);
        if (e) {
            swanEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.component.components.textarea.a.7
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i >= 2 && i <= 7) {
                        a.this.a(swanEditText, "confirm");
                        return false;
                    }
                    return false;
                }
            });
            return e;
        }
        return e;
    }
}
