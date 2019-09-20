package com.baidu.swan.games.view.b;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.k.a;
import com.baidu.swan.games.k.c;
/* loaded from: classes2.dex */
public class a {
    private EditText bmA;
    private EditText bmB;
    private RelativeLayout bmC;
    private Button bmD;
    private a.InterfaceC0215a bmF;
    private c bmG;
    private RelativeLayout mRootView;
    private boolean bmE = false;
    private View.OnClickListener bmH = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bmB != null && a.this.bmE) {
                if (a.this.bmF != null) {
                    a.this.bmF.jI(a.this.bmB.getText().toString());
                }
                if (a.this.bmG != null && !a.this.bmG.bjy && a.this.bmF != null) {
                    a.this.bmF.SB();
                    a.this.kg("");
                }
            }
        }
    };
    private TextWatcher bmI = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.bmF != null) {
                a.this.bmF.jH(editable.toString());
            }
            a.this.bmD.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.bmD.setEnabled(false);
                    } else if (!a.this.bmD.isEnabled()) {
                        a.this.bmD.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener bmJ = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.bmG == null || a.this.bmG.bjz != i || a.this.bmB == null || !a.this.bmE) {
                return false;
            }
            if (a.this.bmF != null) {
                a.this.bmF.jI(a.this.bmB.getText().toString());
            }
            if (!a.this.bmG.bjy && a.this.bmF != null) {
                a.this.bmF.SB();
                a.this.kg("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.bmA = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.bmC = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.bmB = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.bmD = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.bmD.setOnClickListener(this.bmH);
        this.bmB.addTextChangedListener(this.bmI);
        this.bmB.setOnEditorActionListener(this.bmJ);
        this.bmD.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.bmD.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean TX() {
        if (this.bmE) {
            return false;
        }
        this.bmA.setVisibility(0);
        this.bmC.setVisibility(8);
        this.bmA.setFocusableInTouchMode(true);
        this.bmA.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.bmA, 0);
        return true;
    }

    public void fl(int i) {
        this.bmC.setVisibility(0);
        this.bmB.setFocusableInTouchMode(true);
        this.bmB.requestFocus();
        this.bmA.setVisibility(8);
        this.bmE = true;
        if (this.bmF != null) {
            this.bmF.fa(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.bmB != null) {
            inputMethodManager.hideSoftInputFromWindow(this.bmB.getApplicationWindowToken(), 0);
            this.bmE = false;
            this.bmA.setVisibility(8);
            this.bmC.setVisibility(8);
            if (this.bmF != null && this.bmB != null) {
                this.bmF.jJ(this.bmB.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0215a interfaceC0215a) {
        this.bmF = interfaceC0215a;
    }

    public void a(final c cVar) {
        this.bmG = cVar;
        if (this.bmB != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.bjw)) {
                this.bmB.setText(cVar.bjw);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.bjw) && cVar.bjw.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.bjw.length();
                    }
                    this.bmB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.bmB.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.bmB.getText().length() <= cVar.bjw.length()) {
                                length = a.this.bmB.getText().length();
                            } else {
                                length = cVar.bjw.length();
                            }
                            a.this.bmB.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.bmB.setText("");
            }
            this.bmD.setEnabled(TextUtils.isEmpty(cVar.bjw) ? false : true);
            if (cVar.bjx) {
                this.bmB.setMinLines(1);
                this.bmB.setInputType(131073);
                this.bmD.setText(cVar.bjA);
                return;
            }
            this.bmB.setMaxLines(1);
            this.bmB.setInputType(1);
        }
    }

    public boolean kg(final String str) {
        if (!this.bmE || this.bmB == null) {
            return false;
        }
        this.bmB.setText(str);
        this.bmB.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.bmB.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean TY() {
        return this.bmE;
    }
}
