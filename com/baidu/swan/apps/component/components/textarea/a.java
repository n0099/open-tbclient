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
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.w;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.swan.apps.v.f;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends com.baidu.swan.apps.component.a.a.a<SwanEditText, b> {
    private int cdB;
    private SwanAppActivity cdL;
    private InterfaceC0366a cdM;
    private int cdN;
    private ShowConfirmBarLayout cdO;
    private boolean cdP;
    private int cdQ;
    private e cdz;
    private String mCallback;

    /* renamed from: com.baidu.swan.apps.component.components.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0366a {
        void a(String str, String str2, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull e eVar, @NonNull InterfaceC0366a interfaceC0366a) {
        super(context, bVar);
        this.cdP = false;
        this.cdQ = 1;
        this.cdL = swanAppActivity;
        this.cdz = eVar;
        this.cdM = interfaceC0366a;
    }

    public void kS(String str) {
        if (!TextUtils.equals(((b) adL()).ccZ, str)) {
            com.baidu.swan.apps.component.e.a.ba("Component-TextArea", "sendLineChangeEvent with different id");
        }
        SwanEditText swanEditText = (SwanEditText) getView();
        if (swanEditText == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-TextArea", "sendLineChangeEvent with a null editText");
        } else {
            a(swanEditText, "linechange");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bK */
    public SwanEditText be(@NonNull Context context) {
        return new SwanEditText(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void ah(@NonNull SwanEditText swanEditText) {
        super.ah(swanEditText);
        b bVar = (b) adL();
        swanEditText.setTag(bVar.ccZ);
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
            a.gS(14);
        }
        if (bVar.cdV != bVar2.cdV) {
            a.gS(14);
        }
        if (!TextUtils.equals(bVar.cdW, bVar2.cdW)) {
            a.gS(14);
        }
        if (!TextUtils.equals(bVar.cdX, bVar2.cdX)) {
            a.gS(14);
        }
        if (bVar.ced != bVar2.ced) {
            a.gS(15);
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.a.a
    public void a(@NonNull final SwanEditText swanEditText, @NonNull final b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        super.a((a) swanEditText, (SwanEditText) bVar, bVar2);
        if (bVar2.gT(14)) {
            f(swanEditText, bVar);
        }
        boolean z = !adP();
        if (z) {
            swanEditText.setMinHeight(bVar.minHeight);
            swanEditText.setMaxHeight(bVar.maxHeight);
        }
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.component.components.textarea.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cdL != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cdL.getSystemService("input_method");
                    if (inputMethodManager != null && bVar.cdY) {
                        swanEditText.setFocusable(true);
                        swanEditText.setFocusableInTouchMode(true);
                        swanEditText.requestFocus();
                        inputMethodManager.showSoftInput(swanEditText, 0);
                        return;
                    }
                    return;
                }
                com.baidu.swan.apps.component.e.a.ba("Component-TextArea", "activity is null, set textarea attr failed");
            }
        });
        if (bVar2.gT(15)) {
            g(swanEditText, bVar);
        }
        if (z) {
            a(swanEditText, this.cdL);
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
        if (bVar.cdY) {
            if (bVar.ccy <= i && bVar.ccy >= 0) {
                swanEditText.setSelection(bVar.ccy);
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
        if (bVar.selectionEnd <= i && bVar.selectionEnd > 0 && bVar.selectionStart <= bVar.selectionEnd && bVar.selectionStart > 0 && bVar.cdY && !swanEditText.hasFocus()) {
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
        String str = bVar.cdW;
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
        spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.fq(bVar.cdX)), 0, bVar.hint.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(bVar.cdV, true), 0, bVar.hint.length(), 33);
        swanEditText.setHint(spannableString);
    }

    private void g(@NonNull SwanEditText swanEditText, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-TextArea", "renderDisable");
        }
        swanEditText.setEnabled(!bVar.ced);
    }

    private void a(final SwanEditText swanEditText, @NonNull final SwanAppActivity swanAppActivity) {
        swanEditText.setSelectListener(new SwanEditText.a() { // from class: com.baidu.swan.apps.component.components.textarea.a.2
            @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
            public void ah(int i, int i2) {
                a.this.a(swanEditText, "selection");
            }
        });
        swanEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.swan.apps.component.components.textarea.a.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (swanEditText.getLineCount() > 0 && a.this.cdQ != swanEditText.getLineCount()) {
                    c.i("Component-TextArea", "send line change callback");
                    a.this.a(swanEditText, "linechange");
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (swanEditText.hasFocus()) {
                    c.i("Component-TextArea", "send input callback");
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
                    if (a.this.cdB != 0) {
                        a.this.a(swanEditText, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    a.this.adW();
                    return;
                }
                a.this.a(swanEditText, "blur");
                a.this.adV();
            }
        });
        final View decorView = swanAppActivity.getWindow().getDecorView();
        com.baidu.swan.apps.textarea.b.a(((b) adL()).ccZ, swanAppActivity, new com.baidu.swan.apps.textarea.a() { // from class: com.baidu.swan.apps.component.components.textarea.a.5
            @Override // com.baidu.swan.apps.textarea.a
            public void J(String str, int i) {
                int i2;
                final b bVar = (b) a.this.adL();
                d asu = f.asJ().asu();
                if (a.this.cdB != i && swanEditText.hasFocus() && asu != null) {
                    a.this.cdB = i;
                    a.this.cdN = swanEditText.getHeight();
                    a.this.a(swanEditText, AddFriendActivityConfig.TYPE_FOCUS);
                    boolean z = bVar.cec;
                    if (bVar.ceb) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int H = ah.H(38.0f);
                        if (a.this.cdO == null) {
                            a.this.cdO = new ShowConfirmBarLayout(swanAppActivity);
                            a.this.cdO.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.a() { // from class: com.baidu.swan.apps.component.components.textarea.a.5.1
                                @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.a
                                public void onClick(View view) {
                                    InputMethodManager inputMethodManager;
                                    if (!bVar.cdJ && (inputMethodManager = (InputMethodManager) swanAppActivity.getSystemService("input_method")) != null) {
                                        inputMethodManager.hideSoftInputFromWindow(swanEditText.getWindowToken(), 0);
                                    }
                                    c.i("Component-TextArea", "send confirm change callback");
                                    a.this.a(swanEditText, "confirm");
                                }
                            });
                            layoutParams.topMargin = ((decorView.getHeight() - i) - H) - ah.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(a.this.cdO, layoutParams);
                        }
                        i2 = H;
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        int webViewScrollY = (!bVar.cea ? asu.getWebViewScrollY() : 0) + ((a.this.cdz.getWebViewContainer().getHeight() - (bVar.cdd != null ? bVar.cdd.getTop() : 0)) - swanEditText.getHeight());
                        int i3 = bVar.ccx;
                        if (webViewScrollY - i3 < i) {
                            a.this.cdP = true;
                            if (i3 > webViewScrollY) {
                                a.this.cdz.getWebViewContainer().setScrollY(i + i2);
                                return;
                            } else {
                                a.this.cdz.getWebViewContainer().setScrollY(i3 + (i - webViewScrollY) + i2);
                                return;
                            }
                        }
                        a.this.cdP = false;
                    }
                }
            }

            @Override // com.baidu.swan.apps.textarea.a
            public void K(String str, int i) {
                if (a.this.cdB != 0) {
                    a.this.cdB = 0;
                    if (a.this.cdz.getWebViewContainer().getScrollY() > 0) {
                        a.this.cdz.getWebViewContainer().setScrollY(0);
                        a.this.cdP = false;
                    }
                    if (a.this.cdO != null && a.this.cdO.getVisibility() == 0) {
                        ((FrameLayout) decorView.findViewById(16908290)).removeView(a.this.cdO);
                        a.this.cdO = null;
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
            public void kR(String str) {
                if (a.this.cdQ != swanEditText.getLineCount()) {
                    c.i("Component-TextArea", "send line change callback");
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
                this.cdQ = swanEditText.getLineCount();
                ((b) adL()).gN(swanEditText.getHeight());
                break;
            case 1:
                ((b) adL()).kP(swanEditText.getText().toString());
                break;
            case 2:
                ((b) adL()).dE(true);
                break;
            case 3:
                ((b) adL()).dE(false);
                break;
            case 4:
                ((b) adL()).ag(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
                break;
        }
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.component.components.textarea.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (swanEditText != null) {
                    JSONObject jSONObject = new JSONObject();
                    String obj = swanEditText.getTag().toString();
                    if (!TextUtils.equals(obj, ((b) a.this.adL()).ccZ)) {
                        com.baidu.swan.apps.component.e.a.ba("Component-TextArea", "changeTextAreaStatus with different id");
                    }
                    int e = a.this.e(swanEditText);
                    try {
                        jSONObject.put("eventName", str);
                        jSONObject.put("value", swanEditText.getText().toString());
                        jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, swanEditText.getSelectionStart());
                        jSONObject.put("selectionStart", swanEditText.getSelectionStart());
                        jSONObject.put("selectionEnd", swanEditText.getSelectionEnd());
                        jSONObject.put("lineCount", swanEditText.getLineCount());
                        jSONObject.put("height", ah.J(e));
                        jSONObject.put("keyboardHeight", ah.J(a.this.cdB));
                    } catch (JSONException e2) {
                        if (a.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    if (a.DEBUG) {
                        Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
                    }
                    a.this.cdM.a(obj, a.this.mCallback, jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(SwanEditText swanEditText) {
        b bVar = (b) adL();
        int lineCount = swanEditText.getLineCount();
        int lineHeight = swanEditText.getLineHeight();
        int i = bVar.minHeight;
        int i2 = bVar.maxHeight;
        int height = swanEditText.getHeight();
        if (bVar.cdZ) {
            int paddingBottom = swanEditText.getPaddingBottom() + (lineHeight * lineCount) + swanEditText.getPaddingTop();
            int i3 = i2 < i ? i : i2;
            return paddingBottom <= i ? i : paddingBottom < i3 ? paddingBottom : i3;
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adV() {
        SwanAppActivity ast = f.asJ().ast();
        if (ast == null) {
            c.w("Component-TextArea", "activity is null when close input");
            return;
        }
        if (DEBUG) {
            Log.d("Component-TextArea", "forceCloseKeyboard");
        }
        w.forceHiddenSoftInput(ast, ast.getWindow().getDecorView().getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adW() {
        SwanAppActivity ast = f.asJ().ast();
        if (ast == null) {
            c.w("Component-TextArea", "activity is null when open input");
            return;
        }
        if (DEBUG) {
            Log.d("Component-TextArea", "forceOpenKeyboard");
        }
        w.forceToggleSoftInput(ast, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SwanEditText swanEditText, String str) {
        b bVar = (b) adL();
        if (!TextUtils.equals(str, bVar.ccZ)) {
            com.baidu.swan.apps.component.e.a.ba("Component-TextArea", "keyBoardShow with different id");
        }
        boolean z = bVar.cec;
        if (swanEditText.hasFocus() && !bVar.cea) {
            if (this.cdB > 0 && z && this.cdP) {
                int height = (swanEditText.getHeight() - this.cdN) + this.cdz.getWebViewContainer().getScrollY();
                if (height > 0) {
                    this.cdz.getWebViewContainer().setScrollY(height);
                } else {
                    this.cdz.getWebViewContainer().setScrollY(0);
                }
            }
            this.cdN = swanEditText.getHeight();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.a.a
    /* renamed from: h */
    public boolean e(@NonNull final SwanEditText swanEditText, @NonNull final b bVar) {
        if (TextUtils.isEmpty(bVar.ccz) || "default".equals(bVar.ccz)) {
            return false;
        }
        boolean e = super.e((a) swanEditText, (SwanEditText) bVar);
        if (e) {
            swanEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.component.components.textarea.a.7
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i >= 2 && i <= 7) {
                        a.this.a(swanEditText, "confirm");
                    }
                    return bVar.cdJ;
                }
            });
            return e;
        }
        return e;
    }
}
