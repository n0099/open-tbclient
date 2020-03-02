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
    private a.InterfaceC0339a ctB;
    private c ctC;
    private EditText ctv;
    private EditText ctw;
    private RelativeLayout cty;
    private Button ctz;
    private RelativeLayout mRootView;
    private boolean ctA = false;
    private View.OnClickListener ctD = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ctw != null && a.this.ctA) {
                if (a.this.ctB != null) {
                    a.this.ctB.pk(a.this.ctw.getText().toString());
                }
                if (a.this.ctC != null && !a.this.ctC.cpI && a.this.ctB != null) {
                    a.this.ctB.aoL();
                    a.this.pU("");
                }
            }
        }
    };
    private TextWatcher ctE = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.ctB != null) {
                a.this.ctB.pj(editable.toString());
            }
            a.this.ctz.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.ctz.setEnabled(false);
                    } else if (!a.this.ctz.isEnabled()) {
                        a.this.ctz.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener ctF = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.ctC == null || a.this.ctC.cpJ != i || a.this.ctw == null || !a.this.ctA) {
                return false;
            }
            if (a.this.ctB != null) {
                a.this.ctB.pk(a.this.ctw.getText().toString());
            }
            if (!a.this.ctC.cpI && a.this.ctB != null) {
                a.this.ctB.aoL();
                a.this.pU("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.ctv = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.cty = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.ctw = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.ctz = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.ctz.setOnClickListener(this.ctD);
        this.ctw.addTextChangedListener(this.ctE);
        this.ctw.setOnEditorActionListener(this.ctF);
        this.ctz.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.ctz.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aqR() {
        if (this.ctA) {
            return false;
        }
        this.ctv.setVisibility(0);
        this.cty.setVisibility(8);
        this.ctv.setFocusableInTouchMode(true);
        this.ctv.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.ctv, 0);
        return true;
    }

    public void ib(int i) {
        this.cty.setVisibility(0);
        this.ctw.setFocusableInTouchMode(true);
        this.ctw.requestFocus();
        this.ctv.setVisibility(8);
        this.ctA = true;
        if (this.ctB != null) {
            this.ctB.hT(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.ctw != null) {
            inputMethodManager.hideSoftInputFromWindow(this.ctw.getApplicationWindowToken(), 0);
            this.ctA = false;
            this.ctv.setVisibility(8);
            this.cty.setVisibility(8);
            if (this.ctB != null && this.ctw != null) {
                this.ctB.pl(this.ctw.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0339a interfaceC0339a) {
        this.ctB = interfaceC0339a;
    }

    public void a(final c cVar) {
        this.ctC = cVar;
        if (this.ctw != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.cpG)) {
                this.ctw.setText(cVar.cpG);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.cpG) && cVar.cpG.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.cpG.length();
                    }
                    this.ctw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.ctw.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.ctw.getText().length() <= cVar.cpG.length()) {
                                length = a.this.ctw.getText().length();
                            } else {
                                length = cVar.cpG.length();
                            }
                            a.this.ctw.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.ctw.setText("");
            }
            this.ctz.setEnabled(TextUtils.isEmpty(cVar.cpG) ? false : true);
            if (cVar.cpH) {
                this.ctw.setMinLines(1);
                this.ctw.setInputType(131073);
                this.ctz.setText(cVar.cpK);
                return;
            }
            this.ctw.setMaxLines(1);
            this.ctw.setInputType(1);
        }
    }

    public boolean pU(final String str) {
        if (!this.ctA || this.ctw == null) {
            return false;
        }
        this.ctw.setText(str);
        this.ctw.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.ctw.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aqS() {
        return this.ctA;
    }
}
