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
    private EditText blo;
    private EditText blp;
    private RelativeLayout blq;
    private Button blr;
    private a.InterfaceC0204a blt;
    private c blu;
    private RelativeLayout mRootView;
    private boolean bls = false;
    private View.OnClickListener blv = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.blp != null && a.this.bls) {
                if (a.this.blt != null) {
                    a.this.blt.jy(a.this.blp.getText().toString());
                }
                if (a.this.blu != null && !a.this.blu.bin && a.this.blt != null) {
                    a.this.blt.RE();
                    a.this.jW("");
                }
            }
        }
    };
    private TextWatcher blw = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.blt != null) {
                a.this.blt.jx(editable.toString());
            }
            a.this.blr.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.blr.setEnabled(false);
                    } else if (!a.this.blr.isEnabled()) {
                        a.this.blr.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener blx = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.blu == null || a.this.blu.bio != i || a.this.blp == null || !a.this.bls) {
                return false;
            }
            if (a.this.blt != null) {
                a.this.blt.jy(a.this.blp.getText().toString());
            }
            if (!a.this.blu.bin && a.this.blt != null) {
                a.this.blt.RE();
                a.this.jW("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.blo = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.blq = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.blp = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.blr = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.blr.setOnClickListener(this.blv);
        this.blp.addTextChangedListener(this.blw);
        this.blp.setOnEditorActionListener(this.blx);
        this.blr.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.blr.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean Ta() {
        if (this.bls) {
            return false;
        }
        this.blo.setVisibility(0);
        this.blq.setVisibility(8);
        this.blo.setFocusableInTouchMode(true);
        this.blo.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.blo, 0);
        return true;
    }

    public void fg(int i) {
        this.blq.setVisibility(0);
        this.blp.setFocusableInTouchMode(true);
        this.blp.requestFocus();
        this.blo.setVisibility(8);
        this.bls = true;
        if (this.blt != null) {
            this.blt.eV(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.blp != null) {
            inputMethodManager.hideSoftInputFromWindow(this.blp.getApplicationWindowToken(), 0);
            this.bls = false;
            this.blo.setVisibility(8);
            this.blq.setVisibility(8);
            if (this.blt != null && this.blp != null) {
                this.blt.jz(this.blp.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0204a interfaceC0204a) {
        this.blt = interfaceC0204a;
    }

    public void a(final c cVar) {
        this.blu = cVar;
        if (this.blp != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.bil)) {
                this.blp.setText(cVar.bil);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.bil) && cVar.bil.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.bil.length();
                    }
                    this.blp.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.blp.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.blp.getText().length() <= cVar.bil.length()) {
                                length = a.this.blp.getText().length();
                            } else {
                                length = cVar.bil.length();
                            }
                            a.this.blp.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.blp.setText("");
            }
            this.blr.setEnabled(TextUtils.isEmpty(cVar.bil) ? false : true);
            if (cVar.bim) {
                this.blp.setMinLines(1);
                this.blp.setInputType(131073);
                this.blr.setText(cVar.bip);
                return;
            }
            this.blp.setMaxLines(1);
            this.blp.setInputType(1);
        }
    }

    public boolean jW(final String str) {
        if (!this.bls || this.blp == null) {
            return false;
        }
        this.blp.setText(str);
        this.blp.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.blp.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean Tb() {
        return this.bls;
    }
}
