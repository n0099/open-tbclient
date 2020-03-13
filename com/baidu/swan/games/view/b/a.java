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
import com.baidu.swan.games.m.a;
import com.baidu.swan.games.m.c;
/* loaded from: classes11.dex */
public class a {
    private Button ctA;
    private a.InterfaceC0339a ctC;
    private c ctD;
    private EditText ctw;
    private EditText cty;
    private RelativeLayout ctz;
    private RelativeLayout mRootView;
    private boolean ctB = false;
    private View.OnClickListener ctE = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cty != null && a.this.ctB) {
                if (a.this.ctC != null) {
                    a.this.ctC.pk(a.this.cty.getText().toString());
                }
                if (a.this.ctD != null && !a.this.ctD.cpJ && a.this.ctC != null) {
                    a.this.ctC.aoL();
                    a.this.pU("");
                }
            }
        }
    };
    private TextWatcher ctF = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.ctC != null) {
                a.this.ctC.pj(editable.toString());
            }
            a.this.ctA.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.ctA.setEnabled(false);
                    } else if (!a.this.ctA.isEnabled()) {
                        a.this.ctA.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener ctG = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.ctD == null || a.this.ctD.cpK != i || a.this.cty == null || !a.this.ctB) {
                return false;
            }
            if (a.this.ctC != null) {
                a.this.ctC.pk(a.this.cty.getText().toString());
            }
            if (!a.this.ctD.cpJ && a.this.ctC != null) {
                a.this.ctC.aoL();
                a.this.pU("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.ctw = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.ctz = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.cty = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.ctA = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.ctA.setOnClickListener(this.ctE);
        this.cty.addTextChangedListener(this.ctF);
        this.cty.setOnEditorActionListener(this.ctG);
        this.ctA.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.ctA.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aqR() {
        if (this.ctB) {
            return false;
        }
        this.ctw.setVisibility(0);
        this.ctz.setVisibility(8);
        this.ctw.setFocusableInTouchMode(true);
        this.ctw.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.ctw, 0);
        return true;
    }

    public void ib(int i) {
        this.ctz.setVisibility(0);
        this.cty.setFocusableInTouchMode(true);
        this.cty.requestFocus();
        this.ctw.setVisibility(8);
        this.ctB = true;
        if (this.ctC != null) {
            this.ctC.hT(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.cty != null) {
            inputMethodManager.hideSoftInputFromWindow(this.cty.getApplicationWindowToken(), 0);
            this.ctB = false;
            this.ctw.setVisibility(8);
            this.ctz.setVisibility(8);
            if (this.ctC != null && this.cty != null) {
                this.ctC.pl(this.cty.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0339a interfaceC0339a) {
        this.ctC = interfaceC0339a;
    }

    public void a(final c cVar) {
        this.ctD = cVar;
        if (this.cty != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.cpH)) {
                this.cty.setText(cVar.cpH);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.cpH) && cVar.cpH.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.cpH.length();
                    }
                    this.cty.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.cty.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.cty.getText().length() <= cVar.cpH.length()) {
                                length = a.this.cty.getText().length();
                            } else {
                                length = cVar.cpH.length();
                            }
                            a.this.cty.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.cty.setText("");
            }
            this.ctA.setEnabled(TextUtils.isEmpty(cVar.cpH) ? false : true);
            if (cVar.cpI) {
                this.cty.setMinLines(1);
                this.cty.setInputType(131073);
                this.ctA.setText(cVar.cpL);
                return;
            }
            this.cty.setMaxLines(1);
            this.cty.setInputType(1);
        }
    }

    public boolean pU(final String str) {
        if (!this.ctB || this.cty == null) {
            return false;
        }
        this.cty.setText(str);
        this.cty.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.cty.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aqS() {
        return this.ctB;
    }
}
