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
    private EditText cSH;
    private EditText cSI;
    private RelativeLayout cSJ;
    private Button cSK;
    private a.InterfaceC0390a cSM;
    private c cSN;
    private RelativeLayout mRootView;
    private boolean cSL = false;
    private View.OnClickListener cSO = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cSI != null && a.this.cSL) {
                if (a.this.cSM != null) {
                    a.this.cSM.qw(a.this.cSI.getText().toString());
                }
                if (a.this.cSN != null && !a.this.cSN.cOV && a.this.cSM != null) {
                    a.this.cSM.axb();
                    a.this.rg("");
                }
            }
        }
    };
    private TextWatcher cSP = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.cSM != null) {
                a.this.cSM.qv(editable.toString());
            }
            a.this.cSK.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.cSK.setEnabled(false);
                    } else if (!a.this.cSK.isEnabled()) {
                        a.this.cSK.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener cSQ = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.cSN == null || a.this.cSN.cOW != i || a.this.cSI == null || !a.this.cSL) {
                return false;
            }
            if (a.this.cSM != null) {
                a.this.cSM.qw(a.this.cSI.getText().toString());
            }
            if (!a.this.cSN.cOV && a.this.cSM != null) {
                a.this.cSM.axb();
                a.this.rg("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.cSH = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.cSJ = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.cSI = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.cSK = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.cSK.setOnClickListener(this.cSO);
        this.cSI.addTextChangedListener(this.cSP);
        this.cSI.setOnEditorActionListener(this.cSQ);
        this.cSK.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cSK.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean azf() {
        if (this.cSL) {
            return false;
        }
        this.cSH.setVisibility(0);
        this.cSJ.setVisibility(8);
        this.cSH.setFocusableInTouchMode(true);
        this.cSH.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.cSH, 0);
        return true;
    }

    public void ii(int i) {
        this.cSJ.setVisibility(0);
        this.cSI.setFocusableInTouchMode(true);
        this.cSI.requestFocus();
        this.cSH.setVisibility(8);
        this.cSL = true;
        if (this.cSM != null) {
            this.cSM.ia(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.cSI != null) {
            inputMethodManager.hideSoftInputFromWindow(this.cSI.getApplicationWindowToken(), 0);
            this.cSL = false;
            this.cSH.setVisibility(8);
            this.cSJ.setVisibility(8);
            if (this.cSM != null && this.cSI != null) {
                this.cSM.qx(this.cSI.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0390a interfaceC0390a) {
        this.cSM = interfaceC0390a;
    }

    public void a(final c cVar) {
        this.cSN = cVar;
        if (this.cSI != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.cOT)) {
                this.cSI.setText(cVar.cOT);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.cOT) && cVar.cOT.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.cOT.length();
                    }
                    this.cSI.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.cSI.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.cSI.getText().length() <= cVar.cOT.length()) {
                                length = a.this.cSI.getText().length();
                            } else {
                                length = cVar.cOT.length();
                            }
                            a.this.cSI.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.cSI.setText("");
            }
            this.cSK.setEnabled(TextUtils.isEmpty(cVar.cOT) ? false : true);
            if (cVar.cOU) {
                this.cSI.setMinLines(1);
                this.cSI.setInputType(131073);
                this.cSK.setText(cVar.cOX);
                return;
            }
            this.cSI.setMaxLines(1);
            this.cSI.setInputType(1);
        }
    }

    public boolean rg(final String str) {
        if (!this.cSL || this.cSI == null) {
            return false;
        }
        this.cSI.setText(str);
        this.cSI.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.cSI.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean azg() {
        return this.cSL;
    }
}
