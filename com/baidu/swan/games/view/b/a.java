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
    private EditText cSC;
    private EditText cSD;
    private RelativeLayout cSE;
    private Button cSF;
    private a.InterfaceC0369a cSH;
    private c cSI;
    private RelativeLayout mRootView;
    private boolean cSG = false;
    private View.OnClickListener cSJ = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cSD != null && a.this.cSG) {
                if (a.this.cSH != null) {
                    a.this.cSH.qw(a.this.cSD.getText().toString());
                }
                if (a.this.cSI != null && !a.this.cSI.cOQ && a.this.cSH != null) {
                    a.this.cSH.axb();
                    a.this.rg("");
                }
            }
        }
    };
    private TextWatcher cSK = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.cSH != null) {
                a.this.cSH.qv(editable.toString());
            }
            a.this.cSF.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.cSF.setEnabled(false);
                    } else if (!a.this.cSF.isEnabled()) {
                        a.this.cSF.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener cSL = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.cSI == null || a.this.cSI.cOR != i || a.this.cSD == null || !a.this.cSG) {
                return false;
            }
            if (a.this.cSH != null) {
                a.this.cSH.qw(a.this.cSD.getText().toString());
            }
            if (!a.this.cSI.cOQ && a.this.cSH != null) {
                a.this.cSH.axb();
                a.this.rg("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.cSC = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.cSE = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.cSD = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.cSF = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.cSF.setOnClickListener(this.cSJ);
        this.cSD.addTextChangedListener(this.cSK);
        this.cSD.setOnEditorActionListener(this.cSL);
        this.cSF.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cSF.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean azf() {
        if (this.cSG) {
            return false;
        }
        this.cSC.setVisibility(0);
        this.cSE.setVisibility(8);
        this.cSC.setFocusableInTouchMode(true);
        this.cSC.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.cSC, 0);
        return true;
    }

    public void ii(int i) {
        this.cSE.setVisibility(0);
        this.cSD.setFocusableInTouchMode(true);
        this.cSD.requestFocus();
        this.cSC.setVisibility(8);
        this.cSG = true;
        if (this.cSH != null) {
            this.cSH.ia(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.cSD != null) {
            inputMethodManager.hideSoftInputFromWindow(this.cSD.getApplicationWindowToken(), 0);
            this.cSG = false;
            this.cSC.setVisibility(8);
            this.cSE.setVisibility(8);
            if (this.cSH != null && this.cSD != null) {
                this.cSH.qx(this.cSD.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0369a interfaceC0369a) {
        this.cSH = interfaceC0369a;
    }

    public void a(final c cVar) {
        this.cSI = cVar;
        if (this.cSD != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.cOO)) {
                this.cSD.setText(cVar.cOO);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.cOO) && cVar.cOO.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.cOO.length();
                    }
                    this.cSD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.cSD.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.cSD.getText().length() <= cVar.cOO.length()) {
                                length = a.this.cSD.getText().length();
                            } else {
                                length = cVar.cOO.length();
                            }
                            a.this.cSD.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.cSD.setText("");
            }
            this.cSF.setEnabled(TextUtils.isEmpty(cVar.cOO) ? false : true);
            if (cVar.cOP) {
                this.cSD.setMinLines(1);
                this.cSD.setInputType(131073);
                this.cSF.setText(cVar.cOS);
                return;
            }
            this.cSD.setMaxLines(1);
            this.cSD.setInputType(1);
        }
    }

    public boolean rg(final String str) {
        if (!this.cSG || this.cSD == null) {
            return false;
        }
        this.cSD.setText(str);
        this.cSD.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.cSD.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean azg() {
        return this.cSG;
    }
}
