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
    private EditText dUW;
    private EditText dUX;
    private RelativeLayout dUY;
    private Button dUZ;
    private a.InterfaceC0524a dVb;
    private c dVc;
    private RelativeLayout mRootView;
    private boolean dVa = false;
    private View.OnClickListener dVd = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dUX != null && a.this.dVa) {
                if (a.this.dVb != null) {
                    a.this.dVb.wV(a.this.dUX.getText().toString());
                }
                if (a.this.dVc != null && !a.this.dVc.dQW && a.this.dVb != null) {
                    a.this.dVb.aTK();
                    a.this.xK("");
                }
            }
        }
    };
    private TextWatcher dVe = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.dVb != null) {
                a.this.dVb.wU(editable.toString());
            }
            a.this.dUZ.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.dUZ.setEnabled(false);
                    } else if (!a.this.dUZ.isEnabled()) {
                        a.this.dUZ.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener dVf = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.dVc == null || a.this.dVc.dQX != i || a.this.dUX == null || !a.this.dVa) {
                return false;
            }
            if (a.this.dVb != null) {
                a.this.dVb.wV(a.this.dUX.getText().toString());
            }
            if (!a.this.dVc.dQW && a.this.dVb != null) {
                a.this.dVb.aTK();
                a.this.xK("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.dUW = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.dUY = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.dUX = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.dUZ = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.dUZ.setOnClickListener(this.dVd);
        this.dUX.addTextChangedListener(this.dVe);
        this.dUX.setOnEditorActionListener(this.dVf);
        this.dUZ.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.dUZ.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aWb() {
        if (this.dVa) {
            return false;
        }
        this.dUW.setVisibility(0);
        this.dUY.setVisibility(8);
        this.dUW.setFocusableInTouchMode(true);
        this.dUW.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.dUW, 0);
        return true;
    }

    public void mf(int i) {
        this.dUY.setVisibility(0);
        this.dUX.setFocusableInTouchMode(true);
        this.dUX.requestFocus();
        this.dUW.setVisibility(8);
        this.dVa = true;
        if (this.dVb != null) {
            this.dVb.lX(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.dUX != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dUX.getApplicationWindowToken(), 0);
            this.dVa = false;
            this.dUW.setVisibility(8);
            this.dUY.setVisibility(8);
            if (this.dVb != null && this.dUX != null) {
                this.dVb.wW(this.dUX.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0524a interfaceC0524a) {
        this.dVb = interfaceC0524a;
    }

    public void a(final c cVar) {
        this.dVc = cVar;
        if (this.dUX != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.dQU)) {
                this.dUX.setText(cVar.dQU);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.dQU) && cVar.dQU.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.dQU.length();
                    }
                    this.dUX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.dUX.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.dUX.getText().length() <= cVar.dQU.length()) {
                                length = a.this.dUX.getText().length();
                            } else {
                                length = cVar.dQU.length();
                            }
                            a.this.dUX.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.dUX.setText("");
            }
            this.dUZ.setEnabled(TextUtils.isEmpty(cVar.dQU) ? false : true);
            if (cVar.dQV) {
                this.dUX.setMinLines(1);
                this.dUX.setInputType(131073);
                this.dUZ.setText(cVar.dQY);
                return;
            }
            this.dUX.setMaxLines(1);
            this.dUX.setInputType(1);
        }
    }

    public boolean xK(final String str) {
        if (!this.dVa || this.dUX == null) {
            return false;
        }
        this.dUX.setText(str);
        this.dUX.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.dUX.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aWc() {
        return this.dVa;
    }
}
