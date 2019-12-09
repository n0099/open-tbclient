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
    private a.InterfaceC0242a bEA;
    private c bEB;
    private EditText bEv;
    private EditText bEw;
    private RelativeLayout bEx;
    private Button bEy;
    private RelativeLayout mRootView;
    private boolean bEz = false;
    private View.OnClickListener bEC = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bEw != null && a.this.bEz) {
                if (a.this.bEA != null) {
                    a.this.bEA.kk(a.this.bEw.getText().toString());
                }
                if (a.this.bEB != null && !a.this.bEB.bBv && a.this.bEA != null) {
                    a.this.bEA.Xq();
                    a.this.kI("");
                }
            }
        }
    };
    private TextWatcher bED = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.bEA != null) {
                a.this.bEA.kj(editable.toString());
            }
            a.this.bEy.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.bEy.setEnabled(false);
                    } else if (!a.this.bEy.isEnabled()) {
                        a.this.bEy.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener bEE = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.bEB == null || a.this.bEB.bBw != i || a.this.bEw == null || !a.this.bEz) {
                return false;
            }
            if (a.this.bEA != null) {
                a.this.bEA.kk(a.this.bEw.getText().toString());
            }
            if (!a.this.bEB.bBv && a.this.bEA != null) {
                a.this.bEA.Xq();
                a.this.kI("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.bEv = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.bEx = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.bEw = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.bEy = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.bEy.setOnClickListener(this.bEC);
        this.bEw.addTextChangedListener(this.bED);
        this.bEw.setOnEditorActionListener(this.bEE);
        this.bEy.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.bEy.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean YM() {
        if (this.bEz) {
            return false;
        }
        this.bEv.setVisibility(0);
        this.bEx.setVisibility(8);
        this.bEv.setFocusableInTouchMode(true);
        this.bEv.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.bEv, 0);
        return true;
    }

    public void gf(int i) {
        this.bEx.setVisibility(0);
        this.bEw.setFocusableInTouchMode(true);
        this.bEw.requestFocus();
        this.bEv.setVisibility(8);
        this.bEz = true;
        if (this.bEA != null) {
            this.bEA.fU(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.bEw != null) {
            inputMethodManager.hideSoftInputFromWindow(this.bEw.getApplicationWindowToken(), 0);
            this.bEz = false;
            this.bEv.setVisibility(8);
            this.bEx.setVisibility(8);
            if (this.bEA != null && this.bEw != null) {
                this.bEA.kl(this.bEw.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0242a interfaceC0242a) {
        this.bEA = interfaceC0242a;
    }

    public void a(final c cVar) {
        this.bEB = cVar;
        if (this.bEw != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.bBt)) {
                this.bEw.setText(cVar.bBt);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.bBt) && cVar.bBt.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.bBt.length();
                    }
                    this.bEw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.bEw.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.bEw.getText().length() <= cVar.bBt.length()) {
                                length = a.this.bEw.getText().length();
                            } else {
                                length = cVar.bBt.length();
                            }
                            a.this.bEw.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.bEw.setText("");
            }
            this.bEy.setEnabled(TextUtils.isEmpty(cVar.bBt) ? false : true);
            if (cVar.bBu) {
                this.bEw.setMinLines(1);
                this.bEw.setInputType(131073);
                this.bEy.setText(cVar.bBx);
                return;
            }
            this.bEw.setMaxLines(1);
            this.bEw.setInputType(1);
        }
    }

    public boolean kI(final String str) {
        if (!this.bEz || this.bEw == null) {
            return false;
        }
        this.bEw.setText(str);
        this.bEw.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.bEw.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean YN() {
        return this.bEz;
    }
}
