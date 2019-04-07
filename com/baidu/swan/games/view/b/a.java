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
    private EditText bfZ;
    private EditText bga;
    private RelativeLayout bgb;
    private Button bgc;
    private a.InterfaceC0194a bge;
    private c bgf;
    private RelativeLayout mRootView;
    private boolean bgd = false;
    private View.OnClickListener bgg = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bga != null && a.this.bgd) {
                if (a.this.bge != null) {
                    a.this.bge.iN(a.this.bga.getText().toString());
                }
                if (a.this.bgf != null && !a.this.bgf.bdW && a.this.bge != null) {
                    a.this.bge.Oy();
                    a.this.jc("");
                }
            }
        }
    };
    private TextWatcher bgh = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.bge != null) {
                a.this.bge.iM(editable.toString());
            }
            a.this.bgc.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.bgc.setEnabled(false);
                    } else if (!a.this.bgc.isEnabled()) {
                        a.this.bgc.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener bgi = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.bgf == null || a.this.bgf.bdX != i || a.this.bga == null || !a.this.bgd) {
                return false;
            }
            if (a.this.bge != null) {
                a.this.bge.iN(a.this.bga.getText().toString());
            }
            if (!a.this.bgf.bdW && a.this.bge != null) {
                a.this.bge.Oy();
                a.this.jc("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.bfZ = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.bgb = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.bga = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.bgc = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.bgc.setOnClickListener(this.bgg);
        this.bga.addTextChangedListener(this.bgh);
        this.bga.setOnEditorActionListener(this.bgi);
        this.bgc.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.bgc.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean PF() {
        if (this.bgd) {
            return false;
        }
        this.bfZ.setVisibility(0);
        this.bgb.setVisibility(8);
        this.bfZ.setFocusableInTouchMode(true);
        this.bfZ.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.bfZ, 0);
        return true;
    }

    public void eM(int i) {
        this.bgb.setVisibility(0);
        this.bga.setFocusableInTouchMode(true);
        this.bga.requestFocus();
        this.bfZ.setVisibility(8);
        this.bgd = true;
        if (this.bge != null) {
            this.bge.eF(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.bga != null) {
            inputMethodManager.hideSoftInputFromWindow(this.bga.getApplicationWindowToken(), 0);
            this.bgd = false;
            this.bfZ.setVisibility(8);
            this.bgb.setVisibility(8);
            if (this.bge != null && this.bga != null) {
                this.bge.iO(this.bga.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0194a interfaceC0194a) {
        this.bge = interfaceC0194a;
    }

    public void a(final c cVar) {
        this.bgf = cVar;
        if (this.bga != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.bdU)) {
                this.bga.setText(cVar.bdU);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.bdU) && cVar.bdU.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.bdU.length();
                    }
                    this.bga.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.bga.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bga.setSelection(cVar.bdU.length());
                    }
                }, 300L);
            } else {
                this.bga.setText("");
            }
            this.bgc.setEnabled(!TextUtils.isEmpty(cVar.bdU));
            if (cVar.bdV) {
                this.bga.setMinLines(1);
                this.bga.setInputType(131073);
                this.bgc.setVisibility(0);
                this.bgc.setText(cVar.bdY);
                return;
            }
            this.bga.setMaxLines(1);
            this.bga.setInputType(1);
            this.bgc.setVisibility(8);
        }
    }

    public boolean jc(final String str) {
        if (!this.bgd || this.bga == null) {
            return false;
        }
        this.bga.setText(str);
        this.bga.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.bga.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean PG() {
        return this.bgd;
    }
}
