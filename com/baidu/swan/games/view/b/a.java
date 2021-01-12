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
/* loaded from: classes8.dex */
public class a {
    private EditText eks;
    private EditText ekt;
    private RelativeLayout eku;
    private Button ekv;
    private a.InterfaceC0522a ekx;
    private c eky;
    private RelativeLayout mRootView;
    private boolean ekw = false;
    private View.OnClickListener ekz = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ekt != null && a.this.ekw) {
                if (a.this.ekx != null) {
                    a.this.ekx.wz(a.this.ekt.getText().toString());
                }
                if (a.this.eky != null && !a.this.eky.egp && a.this.ekx != null) {
                    a.this.ekx.aXi();
                    a.this.xo("");
                }
            }
        }
    };
    private TextWatcher ekA = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.ekx != null) {
                a.this.ekx.wy(editable.toString());
            }
            a.this.ekv.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.ekv.setEnabled(false);
                    } else if (!a.this.ekv.isEnabled()) {
                        a.this.ekv.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener ekB = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.eky == null || a.this.eky.egq != i || a.this.ekt == null || !a.this.ekw) {
                return false;
            }
            if (a.this.ekx != null) {
                a.this.ekx.wz(a.this.ekt.getText().toString());
            }
            if (!a.this.eky.egp && a.this.ekx != null) {
                a.this.ekx.aXi();
                a.this.xo("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.eks = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.eku = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.ekt = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.ekv = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.ekv.setOnClickListener(this.ekz);
        this.ekt.addTextChangedListener(this.ekA);
        this.ekt.setOnEditorActionListener(this.ekB);
        this.ekv.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.ekv.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aZy() {
        if (this.ekw) {
            return false;
        }
        this.eks.setVisibility(0);
        this.eku.setVisibility(8);
        this.eks.setFocusableInTouchMode(true);
        this.eks.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.eks, 0);
        return true;
    }

    public void ll(int i) {
        this.eku.setVisibility(0);
        this.ekt.setFocusableInTouchMode(true);
        this.ekt.requestFocus();
        this.eks.setVisibility(8);
        this.ekw = true;
        if (this.ekx != null) {
            this.ekx.ld(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.ekt != null) {
            inputMethodManager.hideSoftInputFromWindow(this.ekt.getApplicationWindowToken(), 0);
            this.ekw = false;
            this.eks.setVisibility(8);
            this.eku.setVisibility(8);
            if (this.ekx != null && this.ekt != null) {
                this.ekx.wA(this.ekt.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0522a interfaceC0522a) {
        this.ekx = interfaceC0522a;
    }

    public void a(final c cVar) {
        this.eky = cVar;
        if (this.ekt != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.egn)) {
                this.ekt.setText(cVar.egn);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.egn) && cVar.egn.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.egn.length();
                    }
                    this.ekt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.ekt.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.ekt.getText().length() <= cVar.egn.length()) {
                                length = a.this.ekt.getText().length();
                            } else {
                                length = cVar.egn.length();
                            }
                            a.this.ekt.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.ekt.setText("");
            }
            this.ekv.setEnabled(TextUtils.isEmpty(cVar.egn) ? false : true);
            if (cVar.ego) {
                this.ekt.setMinLines(1);
                this.ekt.setInputType(131073);
                this.ekv.setText(cVar.egr);
                return;
            }
            this.ekt.setMaxLines(1);
            this.ekt.setInputType(1);
        }
    }

    public boolean xo(final String str) {
        if (!this.ekw || this.ekt == null) {
            return false;
        }
        this.ekt.setText(str);
        this.ekt.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.ekt.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aZz() {
        return this.ekw;
    }
}
