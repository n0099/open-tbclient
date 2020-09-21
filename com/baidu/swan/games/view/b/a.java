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
/* loaded from: classes3.dex */
public class a {
    private RelativeLayout dAA;
    private Button dAB;
    private a.InterfaceC0493a dAD;
    private c dAE;
    private EditText dAy;
    private EditText dAz;
    private RelativeLayout mRootView;
    private boolean dAC = false;
    private View.OnClickListener dAF = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dAz != null && a.this.dAC) {
                if (a.this.dAD != null) {
                    a.this.dAD.vQ(a.this.dAz.getText().toString());
                }
                if (a.this.dAE != null && !a.this.dAE.dwy && a.this.dAD != null) {
                    a.this.dAD.aPh();
                    a.this.wF("");
                }
            }
        }
    };
    private TextWatcher dAG = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.dAD != null) {
                a.this.dAD.vP(editable.toString());
            }
            a.this.dAB.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.dAB.setEnabled(false);
                    } else if (!a.this.dAB.isEnabled()) {
                        a.this.dAB.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener dAH = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.dAE == null || a.this.dAE.dwz != i || a.this.dAz == null || !a.this.dAC) {
                return false;
            }
            if (a.this.dAD != null) {
                a.this.dAD.vQ(a.this.dAz.getText().toString());
            }
            if (!a.this.dAE.dwy && a.this.dAD != null) {
                a.this.dAD.aPh();
                a.this.wF("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.dAy = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.dAA = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.dAz = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.dAB = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.dAB.setOnClickListener(this.dAF);
        this.dAz.addTextChangedListener(this.dAG);
        this.dAz.setOnEditorActionListener(this.dAH);
        this.dAB.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.dAB.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aRy() {
        if (this.dAC) {
            return false;
        }
        this.dAy.setVisibility(0);
        this.dAA.setVisibility(8);
        this.dAy.setFocusableInTouchMode(true);
        this.dAy.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.dAy, 0);
        return true;
    }

    public void lx(int i) {
        this.dAA.setVisibility(0);
        this.dAz.setFocusableInTouchMode(true);
        this.dAz.requestFocus();
        this.dAy.setVisibility(8);
        this.dAC = true;
        if (this.dAD != null) {
            this.dAD.lp(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.dAz != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dAz.getApplicationWindowToken(), 0);
            this.dAC = false;
            this.dAy.setVisibility(8);
            this.dAA.setVisibility(8);
            if (this.dAD != null && this.dAz != null) {
                this.dAD.vR(this.dAz.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0493a interfaceC0493a) {
        this.dAD = interfaceC0493a;
    }

    public void a(final c cVar) {
        this.dAE = cVar;
        if (this.dAz != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.dww)) {
                this.dAz.setText(cVar.dww);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.dww) && cVar.dww.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.dww.length();
                    }
                    this.dAz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.dAz.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.dAz.getText().length() <= cVar.dww.length()) {
                                length = a.this.dAz.getText().length();
                            } else {
                                length = cVar.dww.length();
                            }
                            a.this.dAz.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.dAz.setText("");
            }
            this.dAB.setEnabled(TextUtils.isEmpty(cVar.dww) ? false : true);
            if (cVar.dwx) {
                this.dAz.setMinLines(1);
                this.dAz.setInputType(131073);
                this.dAB.setText(cVar.dwA);
                return;
            }
            this.dAz.setMaxLines(1);
            this.dAz.setInputType(1);
        }
    }

    public boolean wF(final String str) {
        if (!this.dAC || this.dAz == null) {
            return false;
        }
        this.dAz.setText(str);
        this.dAz.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.dAz.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aRz() {
        return this.dAC;
    }
}
