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
import com.baidu.swan.games.j.a;
import com.baidu.swan.games.j.c;
/* loaded from: classes2.dex */
public class a {
    private EditText bga;
    private EditText bgb;
    private RelativeLayout bgc;
    private Button bgd;
    private a.InterfaceC0194a bgf;
    private c bgg;
    private RelativeLayout mRootView;
    private boolean bge = false;
    private View.OnClickListener bgh = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bgb != null && a.this.bge) {
                if (a.this.bgf != null) {
                    a.this.bgf.iN(a.this.bgb.getText().toString());
                }
                if (a.this.bgg != null && !a.this.bgg.bdX && a.this.bgf != null) {
                    a.this.bgf.Oy();
                    a.this.jc("");
                }
            }
        }
    };
    private TextWatcher bgi = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.bgf != null) {
                a.this.bgf.iM(editable.toString());
            }
            a.this.bgd.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.bgd.setEnabled(false);
                    } else if (!a.this.bgd.isEnabled()) {
                        a.this.bgd.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener bgj = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.bgg == null || a.this.bgg.bdY != i || a.this.bgb == null || !a.this.bge) {
                return false;
            }
            if (a.this.bgf != null) {
                a.this.bgf.iN(a.this.bgb.getText().toString());
            }
            if (!a.this.bgg.bdX && a.this.bgf != null) {
                a.this.bgf.Oy();
                a.this.jc("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.bga = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.bgc = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.bgb = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.bgd = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.bgd.setOnClickListener(this.bgh);
        this.bgb.addTextChangedListener(this.bgi);
        this.bgb.setOnEditorActionListener(this.bgj);
        this.bgd.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.bgd.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean PF() {
        if (this.bge) {
            return false;
        }
        this.bga.setVisibility(0);
        this.bgc.setVisibility(8);
        this.bga.setFocusableInTouchMode(true);
        this.bga.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.bga, 0);
        return true;
    }

    public void eM(int i) {
        this.bgc.setVisibility(0);
        this.bgb.setFocusableInTouchMode(true);
        this.bgb.requestFocus();
        this.bga.setVisibility(8);
        this.bge = true;
        if (this.bgf != null) {
            this.bgf.eF(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.bgb != null) {
            inputMethodManager.hideSoftInputFromWindow(this.bgb.getApplicationWindowToken(), 0);
            this.bge = false;
            this.bga.setVisibility(8);
            this.bgc.setVisibility(8);
            if (this.bgf != null && this.bgb != null) {
                this.bgf.iO(this.bgb.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0194a interfaceC0194a) {
        this.bgf = interfaceC0194a;
    }

    public void a(final c cVar) {
        this.bgg = cVar;
        if (this.bgb != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.bdV)) {
                this.bgb.setText(cVar.bdV);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.bdV) && cVar.bdV.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.bdV.length();
                    }
                    this.bgb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.bgb.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bgb.setSelection(cVar.bdV.length());
                    }
                }, 300L);
            } else {
                this.bgb.setText("");
            }
            this.bgd.setEnabled(!TextUtils.isEmpty(cVar.bdV));
            if (cVar.bdW) {
                this.bgb.setMinLines(1);
                this.bgb.setInputType(131073);
                this.bgd.setVisibility(0);
                this.bgd.setText(cVar.bdZ);
                return;
            }
            this.bgb.setMaxLines(1);
            this.bgb.setInputType(1);
            this.bgd.setVisibility(8);
        }
    }

    public boolean jc(final String str) {
        if (!this.bge || this.bgb == null) {
            return false;
        }
        this.bgb.setText(str);
        this.bgb.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.bgb.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean PG() {
        return this.bge;
    }
}
