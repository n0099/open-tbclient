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
/* loaded from: classes10.dex */
public class a {
    private EditText eaO;
    private EditText eaP;
    private RelativeLayout eaQ;
    private Button eaR;
    private a.InterfaceC0536a eaT;
    private c eaU;
    private RelativeLayout mRootView;
    private boolean eaS = false;
    private View.OnClickListener eaV = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eaP != null && a.this.eaS) {
                if (a.this.eaT != null) {
                    a.this.eaT.xj(a.this.eaP.getText().toString());
                }
                if (a.this.eaU != null && !a.this.eaU.dWO && a.this.eaT != null) {
                    a.this.eaT.aWk();
                    a.this.xY("");
                }
            }
        }
    };
    private TextWatcher eaW = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.eaT != null) {
                a.this.eaT.xi(editable.toString());
            }
            a.this.eaR.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.eaR.setEnabled(false);
                    } else if (!a.this.eaR.isEnabled()) {
                        a.this.eaR.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener eaX = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.eaU == null || a.this.eaU.dWP != i || a.this.eaP == null || !a.this.eaS) {
                return false;
            }
            if (a.this.eaT != null) {
                a.this.eaT.xj(a.this.eaP.getText().toString());
            }
            if (!a.this.eaU.dWO && a.this.eaT != null) {
                a.this.eaT.aWk();
                a.this.xY("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.eaO = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.eaQ = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.eaP = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.eaR = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.eaR.setOnClickListener(this.eaV);
        this.eaP.addTextChangedListener(this.eaW);
        this.eaP.setOnEditorActionListener(this.eaX);
        this.eaR.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.eaR.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aYB() {
        if (this.eaS) {
            return false;
        }
        this.eaO.setVisibility(0);
        this.eaQ.setVisibility(8);
        this.eaO.setFocusableInTouchMode(true);
        this.eaO.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.eaO, 0);
        return true;
    }

    public void mp(int i) {
        this.eaQ.setVisibility(0);
        this.eaP.setFocusableInTouchMode(true);
        this.eaP.requestFocus();
        this.eaO.setVisibility(8);
        this.eaS = true;
        if (this.eaT != null) {
            this.eaT.mh(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.eaP != null) {
            inputMethodManager.hideSoftInputFromWindow(this.eaP.getApplicationWindowToken(), 0);
            this.eaS = false;
            this.eaO.setVisibility(8);
            this.eaQ.setVisibility(8);
            if (this.eaT != null && this.eaP != null) {
                this.eaT.xk(this.eaP.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0536a interfaceC0536a) {
        this.eaT = interfaceC0536a;
    }

    public void a(final c cVar) {
        this.eaU = cVar;
        if (this.eaP != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.dWM)) {
                this.eaP.setText(cVar.dWM);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.dWM) && cVar.dWM.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.dWM.length();
                    }
                    this.eaP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.eaP.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.eaP.getText().length() <= cVar.dWM.length()) {
                                length = a.this.eaP.getText().length();
                            } else {
                                length = cVar.dWM.length();
                            }
                            a.this.eaP.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.eaP.setText("");
            }
            this.eaR.setEnabled(TextUtils.isEmpty(cVar.dWM) ? false : true);
            if (cVar.dWN) {
                this.eaP.setMinLines(1);
                this.eaP.setInputType(131073);
                this.eaR.setText(cVar.dWQ);
                return;
            }
            this.eaP.setMaxLines(1);
            this.eaP.setInputType(1);
        }
    }

    public boolean xY(final String str) {
        if (!this.eaS || this.eaP == null) {
            return false;
        }
        this.eaP.setText(str);
        this.eaP.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.eaP.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aYC() {
        return this.eaS;
    }
}
