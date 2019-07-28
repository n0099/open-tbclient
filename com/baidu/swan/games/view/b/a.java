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
import com.baidu.swan.games.k.a;
import com.baidu.swan.games.k.c;
/* loaded from: classes2.dex */
public class a {
    private EditText bmb;
    private EditText bmc;
    private RelativeLayout bmd;
    private Button bme;
    private a.InterfaceC0206a bmg;
    private c bmh;
    private RelativeLayout mRootView;
    private boolean bmf = false;
    private View.OnClickListener bmi = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bmc != null && a.this.bmf) {
                if (a.this.bmg != null) {
                    a.this.bmg.jG(a.this.bmc.getText().toString());
                }
                if (a.this.bmh != null && !a.this.bmh.bja && a.this.bmg != null) {
                    a.this.bmg.Sx();
                    a.this.ke("");
                }
            }
        }
    };
    private TextWatcher bmj = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.bmg != null) {
                a.this.bmg.jF(editable.toString());
            }
            a.this.bme.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.bme.setEnabled(false);
                    } else if (!a.this.bme.isEnabled()) {
                        a.this.bme.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener bmk = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.bmh == null || a.this.bmh.bjb != i || a.this.bmc == null || !a.this.bmf) {
                return false;
            }
            if (a.this.bmg != null) {
                a.this.bmg.jG(a.this.bmc.getText().toString());
            }
            if (!a.this.bmh.bja && a.this.bmg != null) {
                a.this.bmg.Sx();
                a.this.ke("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.bmb = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.bmd = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.bmc = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.bme = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.bme.setOnClickListener(this.bmi);
        this.bmc.addTextChangedListener(this.bmj);
        this.bmc.setOnEditorActionListener(this.bmk);
        this.bme.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.bme.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean TT() {
        if (this.bmf) {
            return false;
        }
        this.bmb.setVisibility(0);
        this.bmd.setVisibility(8);
        this.bmb.setFocusableInTouchMode(true);
        this.bmb.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.bmb, 0);
        return true;
    }

    public void fk(int i) {
        this.bmd.setVisibility(0);
        this.bmc.setFocusableInTouchMode(true);
        this.bmc.requestFocus();
        this.bmb.setVisibility(8);
        this.bmf = true;
        if (this.bmg != null) {
            this.bmg.eZ(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.bmc != null) {
            inputMethodManager.hideSoftInputFromWindow(this.bmc.getApplicationWindowToken(), 0);
            this.bmf = false;
            this.bmb.setVisibility(8);
            this.bmd.setVisibility(8);
            if (this.bmg != null && this.bmc != null) {
                this.bmg.jH(this.bmc.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0206a interfaceC0206a) {
        this.bmg = interfaceC0206a;
    }

    public void a(final c cVar) {
        this.bmh = cVar;
        if (this.bmc != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.biY)) {
                this.bmc.setText(cVar.biY);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.biY) && cVar.biY.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.biY.length();
                    }
                    this.bmc.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.bmc.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.bmc.getText().length() <= cVar.biY.length()) {
                                length = a.this.bmc.getText().length();
                            } else {
                                length = cVar.biY.length();
                            }
                            a.this.bmc.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.bmc.setText("");
            }
            this.bme.setEnabled(TextUtils.isEmpty(cVar.biY) ? false : true);
            if (cVar.biZ) {
                this.bmc.setMinLines(1);
                this.bmc.setInputType(131073);
                this.bme.setText(cVar.bjc);
                return;
            }
            this.bmc.setMaxLines(1);
            this.bmc.setInputType(1);
        }
    }

    public boolean ke(final String str) {
        if (!this.bmf || this.bmc == null) {
            return false;
        }
        this.bmc.setText(str);
        this.bmc.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.bmc.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean TU() {
        return this.bmf;
    }
}
