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
    private a.InterfaceC0339a ctA;
    private c ctB;
    private EditText ctu;
    private EditText ctv;
    private RelativeLayout ctw;
    private Button cty;
    private RelativeLayout mRootView;
    private boolean ctz = false;
    private View.OnClickListener ctC = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ctv != null && a.this.ctz) {
                if (a.this.ctA != null) {
                    a.this.ctA.pk(a.this.ctv.getText().toString());
                }
                if (a.this.ctB != null && !a.this.ctB.cpH && a.this.ctA != null) {
                    a.this.ctA.aoJ();
                    a.this.pU("");
                }
            }
        }
    };
    private TextWatcher ctD = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.ctA != null) {
                a.this.ctA.pj(editable.toString());
            }
            a.this.cty.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.cty.setEnabled(false);
                    } else if (!a.this.cty.isEnabled()) {
                        a.this.cty.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener ctE = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.ctB == null || a.this.ctB.cpI != i || a.this.ctv == null || !a.this.ctz) {
                return false;
            }
            if (a.this.ctA != null) {
                a.this.ctA.pk(a.this.ctv.getText().toString());
            }
            if (!a.this.ctB.cpH && a.this.ctA != null) {
                a.this.ctA.aoJ();
                a.this.pU("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.ctu = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.ctw = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.ctv = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.cty = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.cty.setOnClickListener(this.ctC);
        this.ctv.addTextChangedListener(this.ctD);
        this.ctv.setOnEditorActionListener(this.ctE);
        this.cty.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cty.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aqP() {
        if (this.ctz) {
            return false;
        }
        this.ctu.setVisibility(0);
        this.ctw.setVisibility(8);
        this.ctu.setFocusableInTouchMode(true);
        this.ctu.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.ctu, 0);
        return true;
    }

    public void ib(int i) {
        this.ctw.setVisibility(0);
        this.ctv.setFocusableInTouchMode(true);
        this.ctv.requestFocus();
        this.ctu.setVisibility(8);
        this.ctz = true;
        if (this.ctA != null) {
            this.ctA.hT(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.ctv != null) {
            inputMethodManager.hideSoftInputFromWindow(this.ctv.getApplicationWindowToken(), 0);
            this.ctz = false;
            this.ctu.setVisibility(8);
            this.ctw.setVisibility(8);
            if (this.ctA != null && this.ctv != null) {
                this.ctA.pl(this.ctv.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0339a interfaceC0339a) {
        this.ctA = interfaceC0339a;
    }

    public void a(final c cVar) {
        this.ctB = cVar;
        if (this.ctv != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.cpF)) {
                this.ctv.setText(cVar.cpF);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.cpF) && cVar.cpF.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.cpF.length();
                    }
                    this.ctv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.ctv.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.ctv.getText().length() <= cVar.cpF.length()) {
                                length = a.this.ctv.getText().length();
                            } else {
                                length = cVar.cpF.length();
                            }
                            a.this.ctv.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.ctv.setText("");
            }
            this.cty.setEnabled(TextUtils.isEmpty(cVar.cpF) ? false : true);
            if (cVar.cpG) {
                this.ctv.setMinLines(1);
                this.ctv.setInputType(131073);
                this.cty.setText(cVar.cpJ);
                return;
            }
            this.ctv.setMaxLines(1);
            this.ctv.setInputType(1);
        }
    }

    public boolean pU(final String str) {
        if (!this.ctz || this.ctv == null) {
            return false;
        }
        this.ctv.setText(str);
        this.ctv.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.ctv.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aqQ() {
        return this.ctz;
    }
}
