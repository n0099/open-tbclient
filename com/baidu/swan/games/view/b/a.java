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
/* loaded from: classes10.dex */
public class a {
    private c cpA;
    private EditText cpt;
    private EditText cpv;
    private RelativeLayout cpw;
    private Button cpx;
    private a.InterfaceC0329a cpz;
    private RelativeLayout mRootView;
    private boolean cpy = false;
    private View.OnClickListener cpB = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cpv != null && a.this.cpy) {
                if (a.this.cpz != null) {
                    a.this.cpz.oV(a.this.cpv.getText().toString());
                }
                if (a.this.cpA != null && !a.this.cpA.clD && a.this.cpz != null) {
                    a.this.cpz.amw();
                    a.this.pF("");
                }
            }
        }
    };
    private TextWatcher cpC = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.cpz != null) {
                a.this.cpz.oU(editable.toString());
            }
            a.this.cpx.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.cpx.setEnabled(false);
                    } else if (!a.this.cpx.isEnabled()) {
                        a.this.cpx.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener cpD = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.cpA == null || a.this.cpA.clE != i || a.this.cpv == null || !a.this.cpy) {
                return false;
            }
            if (a.this.cpz != null) {
                a.this.cpz.oV(a.this.cpv.getText().toString());
            }
            if (!a.this.cpA.clD && a.this.cpz != null) {
                a.this.cpz.amw();
                a.this.pF("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.cpt = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.cpw = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.cpv = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.cpx = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.cpx.setOnClickListener(this.cpB);
        this.cpv.addTextChangedListener(this.cpC);
        this.cpv.setOnEditorActionListener(this.cpD);
        this.cpx.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cpx.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aoB() {
        if (this.cpy) {
            return false;
        }
        this.cpt.setVisibility(0);
        this.cpw.setVisibility(8);
        this.cpt.setFocusableInTouchMode(true);
        this.cpt.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.cpt, 0);
        return true;
    }

    public void hK(int i) {
        this.cpw.setVisibility(0);
        this.cpv.setFocusableInTouchMode(true);
        this.cpv.requestFocus();
        this.cpt.setVisibility(8);
        this.cpy = true;
        if (this.cpz != null) {
            this.cpz.hC(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.cpv != null) {
            inputMethodManager.hideSoftInputFromWindow(this.cpv.getApplicationWindowToken(), 0);
            this.cpy = false;
            this.cpt.setVisibility(8);
            this.cpw.setVisibility(8);
            if (this.cpz != null && this.cpv != null) {
                this.cpz.oW(this.cpv.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0329a interfaceC0329a) {
        this.cpz = interfaceC0329a;
    }

    public void a(final c cVar) {
        this.cpA = cVar;
        if (this.cpv != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.clB)) {
                this.cpv.setText(cVar.clB);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.clB) && cVar.clB.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.clB.length();
                    }
                    this.cpv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.cpv.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.cpv.getText().length() <= cVar.clB.length()) {
                                length = a.this.cpv.getText().length();
                            } else {
                                length = cVar.clB.length();
                            }
                            a.this.cpv.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.cpv.setText("");
            }
            this.cpx.setEnabled(TextUtils.isEmpty(cVar.clB) ? false : true);
            if (cVar.clC) {
                this.cpv.setMinLines(1);
                this.cpv.setInputType(131073);
                this.cpx.setText(cVar.clF);
                return;
            }
            this.cpv.setMaxLines(1);
            this.cpv.setInputType(1);
        }
    }

    public boolean pF(final String str) {
        if (!this.cpy || this.cpv == null) {
            return false;
        }
        this.cpv.setText(str);
        this.cpv.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.cpv.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aoC() {
        return this.cpy;
    }
}
