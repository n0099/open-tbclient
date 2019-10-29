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
    private EditText bFm;
    private EditText bFn;
    private RelativeLayout bFo;
    private Button bFp;
    private a.InterfaceC0247a bFr;
    private c bFs;
    private RelativeLayout mRootView;
    private boolean bFq = false;
    private View.OnClickListener bFt = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bFn != null && a.this.bFq) {
                if (a.this.bFr != null) {
                    a.this.bFr.kk(a.this.bFn.getText().toString());
                }
                if (a.this.bFs != null && !a.this.bFs.bCm && a.this.bFr != null) {
                    a.this.bFr.Xs();
                    a.this.kI("");
                }
            }
        }
    };
    private TextWatcher bFu = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.bFr != null) {
                a.this.bFr.kj(editable.toString());
            }
            a.this.bFp.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.bFp.setEnabled(false);
                    } else if (!a.this.bFp.isEnabled()) {
                        a.this.bFp.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener bFv = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.bFs == null || a.this.bFs.bCn != i || a.this.bFn == null || !a.this.bFq) {
                return false;
            }
            if (a.this.bFr != null) {
                a.this.bFr.kk(a.this.bFn.getText().toString());
            }
            if (!a.this.bFs.bCm && a.this.bFr != null) {
                a.this.bFr.Xs();
                a.this.kI("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.bFm = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.bFo = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.bFn = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.bFp = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.bFp.setOnClickListener(this.bFt);
        this.bFn.addTextChangedListener(this.bFu);
        this.bFn.setOnEditorActionListener(this.bFv);
        this.bFp.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.bFp.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean YO() {
        if (this.bFq) {
            return false;
        }
        this.bFm.setVisibility(0);
        this.bFo.setVisibility(8);
        this.bFm.setFocusableInTouchMode(true);
        this.bFm.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.bFm, 0);
        return true;
    }

    public void gg(int i) {
        this.bFo.setVisibility(0);
        this.bFn.setFocusableInTouchMode(true);
        this.bFn.requestFocus();
        this.bFm.setVisibility(8);
        this.bFq = true;
        if (this.bFr != null) {
            this.bFr.fV(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.bFn != null) {
            inputMethodManager.hideSoftInputFromWindow(this.bFn.getApplicationWindowToken(), 0);
            this.bFq = false;
            this.bFm.setVisibility(8);
            this.bFo.setVisibility(8);
            if (this.bFr != null && this.bFn != null) {
                this.bFr.kl(this.bFn.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0247a interfaceC0247a) {
        this.bFr = interfaceC0247a;
    }

    public void a(final c cVar) {
        this.bFs = cVar;
        if (this.bFn != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.bCk)) {
                this.bFn.setText(cVar.bCk);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.bCk) && cVar.bCk.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.bCk.length();
                    }
                    this.bFn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.bFn.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.bFn.getText().length() <= cVar.bCk.length()) {
                                length = a.this.bFn.getText().length();
                            } else {
                                length = cVar.bCk.length();
                            }
                            a.this.bFn.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.bFn.setText("");
            }
            this.bFp.setEnabled(TextUtils.isEmpty(cVar.bCk) ? false : true);
            if (cVar.bCl) {
                this.bFn.setMinLines(1);
                this.bFn.setInputType(131073);
                this.bFp.setText(cVar.bCo);
                return;
            }
            this.bFn.setMaxLines(1);
            this.bFn.setInputType(1);
        }
    }

    public boolean kI(final String str) {
        if (!this.bFq || this.bFn == null) {
            return false;
        }
        this.bFn.setText(str);
        this.bFn.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.bFn.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean YP() {
        return this.bFq;
    }
}
