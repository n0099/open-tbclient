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
/* loaded from: classes9.dex */
public class a {
    private EditText cph;
    private EditText cpi;
    private RelativeLayout cpj;
    private Button cpk;
    private a.InterfaceC0327a cpm;
    private c cpn;
    private RelativeLayout mRootView;
    private boolean cpl = false;
    private View.OnClickListener cpo = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cpi != null && a.this.cpl) {
                if (a.this.cpm != null) {
                    a.this.cpm.oS(a.this.cpi.getText().toString());
                }
                if (a.this.cpn != null && !a.this.cpn.clq && a.this.cpm != null) {
                    a.this.cpm.amd();
                    a.this.pC("");
                }
            }
        }
    };
    private TextWatcher cpp = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.cpm != null) {
                a.this.cpm.oR(editable.toString());
            }
            a.this.cpk.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.cpk.setEnabled(false);
                    } else if (!a.this.cpk.isEnabled()) {
                        a.this.cpk.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener cpq = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.cpn == null || a.this.cpn.clr != i || a.this.cpi == null || !a.this.cpl) {
                return false;
            }
            if (a.this.cpm != null) {
                a.this.cpm.oS(a.this.cpi.getText().toString());
            }
            if (!a.this.cpn.clq && a.this.cpm != null) {
                a.this.cpm.amd();
                a.this.pC("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.cph = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.cpj = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.cpi = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.cpk = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.cpk.setOnClickListener(this.cpo);
        this.cpi.addTextChangedListener(this.cpp);
        this.cpi.setOnEditorActionListener(this.cpq);
        this.cpk.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cpk.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aoi() {
        if (this.cpl) {
            return false;
        }
        this.cph.setVisibility(0);
        this.cpj.setVisibility(8);
        this.cph.setFocusableInTouchMode(true);
        this.cph.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.cph, 0);
        return true;
    }

    public void hK(int i) {
        this.cpj.setVisibility(0);
        this.cpi.setFocusableInTouchMode(true);
        this.cpi.requestFocus();
        this.cph.setVisibility(8);
        this.cpl = true;
        if (this.cpm != null) {
            this.cpm.hC(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.cpi != null) {
            inputMethodManager.hideSoftInputFromWindow(this.cpi.getApplicationWindowToken(), 0);
            this.cpl = false;
            this.cph.setVisibility(8);
            this.cpj.setVisibility(8);
            if (this.cpm != null && this.cpi != null) {
                this.cpm.oT(this.cpi.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0327a interfaceC0327a) {
        this.cpm = interfaceC0327a;
    }

    public void a(final c cVar) {
        this.cpn = cVar;
        if (this.cpi != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.clo)) {
                this.cpi.setText(cVar.clo);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.clo) && cVar.clo.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.clo.length();
                    }
                    this.cpi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.cpi.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.cpi.getText().length() <= cVar.clo.length()) {
                                length = a.this.cpi.getText().length();
                            } else {
                                length = cVar.clo.length();
                            }
                            a.this.cpi.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.cpi.setText("");
            }
            this.cpk.setEnabled(TextUtils.isEmpty(cVar.clo) ? false : true);
            if (cVar.clp) {
                this.cpi.setMinLines(1);
                this.cpi.setInputType(131073);
                this.cpk.setText(cVar.cls);
                return;
            }
            this.cpi.setMaxLines(1);
            this.cpi.setInputType(1);
        }
    }

    public boolean pC(final String str) {
        if (!this.cpl || this.cpi == null) {
            return false;
        }
        this.cpi.setText(str);
        this.cpi.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.cpi.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aoj() {
        return this.cpl;
    }
}
