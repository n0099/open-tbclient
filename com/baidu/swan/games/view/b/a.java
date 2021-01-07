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
import com.baidu.swan.games.n.a;
import com.baidu.swan.games.n.c;
/* loaded from: classes9.dex */
public class a {
    private EditText eph;
    private EditText epi;
    private RelativeLayout epj;
    private Button epk;
    private a.InterfaceC0539a epm;
    private c epn;
    private RelativeLayout mRootView;
    private boolean epl = false;
    private View.OnClickListener epo = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.epi != null && a.this.epl) {
                if (a.this.epm != null) {
                    a.this.epm.xK(a.this.epi.getText().toString());
                }
                if (a.this.epn != null && !a.this.epn.elb && a.this.epm != null) {
                    a.this.epm.bbc();
                    a.this.yz("");
                }
            }
        }
    };
    private TextWatcher epp = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.epm != null) {
                a.this.epm.xJ(editable.toString());
            }
            a.this.epk.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.epk.setEnabled(false);
                    } else if (!a.this.epk.isEnabled()) {
                        a.this.epk.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener epq = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.epn == null || a.this.epn.elc != i || a.this.epi == null || !a.this.epl) {
                return false;
            }
            if (a.this.epm != null) {
                a.this.epm.xK(a.this.epi.getText().toString());
            }
            if (!a.this.epn.elb && a.this.epm != null) {
                a.this.epm.bbc();
                a.this.yz("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.eph = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.epj = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.epi = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.epk = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.epk.setOnClickListener(this.epo);
        this.epi.addTextChangedListener(this.epp);
        this.epi.setOnEditorActionListener(this.epq);
        this.epk.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.epk.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean bds() {
        if (this.epl) {
            return false;
        }
        this.eph.setVisibility(0);
        this.epj.setVisibility(8);
        this.eph.setFocusableInTouchMode(true);
        this.eph.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.eph, 0);
        return true;
    }

    public void mR(int i) {
        this.epj.setVisibility(0);
        this.epi.setFocusableInTouchMode(true);
        this.epi.requestFocus();
        this.eph.setVisibility(8);
        this.epl = true;
        if (this.epm != null) {
            this.epm.mJ(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.epi != null) {
            inputMethodManager.hideSoftInputFromWindow(this.epi.getApplicationWindowToken(), 0);
            this.epl = false;
            this.eph.setVisibility(8);
            this.epj.setVisibility(8);
            if (this.epm != null && this.epi != null) {
                this.epm.xL(this.epi.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0539a interfaceC0539a) {
        this.epm = interfaceC0539a;
    }

    public void a(final c cVar) {
        this.epn = cVar;
        if (this.epi != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.ekZ)) {
                this.epi.setText(cVar.ekZ);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.ekZ) && cVar.ekZ.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.ekZ.length();
                    }
                    this.epi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.epi.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.epi.getText().length() <= cVar.ekZ.length()) {
                                length = a.this.epi.getText().length();
                            } else {
                                length = cVar.ekZ.length();
                            }
                            a.this.epi.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.epi.setText("");
            }
            this.epk.setEnabled(TextUtils.isEmpty(cVar.ekZ) ? false : true);
            if (cVar.ela) {
                this.epi.setMinLines(1);
                this.epi.setInputType(131073);
                this.epk.setText(cVar.eld);
                return;
            }
            this.epi.setMaxLines(1);
            this.epi.setInputType(1);
        }
    }

    public boolean yz(final String str) {
        if (!this.epl || this.epi == null) {
            return false;
        }
        this.epi.setText(str);
        this.epi.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.epi.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean bdt() {
        return this.epl;
    }
}
