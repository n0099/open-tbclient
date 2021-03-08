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
    private EditText eoc;
    private EditText eod;
    private RelativeLayout eoe;
    private Button eog;
    private a.InterfaceC0525a eoi;
    private c eoj;
    private RelativeLayout mRootView;
    private boolean eoh = false;
    private View.OnClickListener eok = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eod != null && a.this.eoh) {
                if (a.this.eoi != null) {
                    a.this.eoi.wZ(a.this.eod.getText().toString());
                }
                if (a.this.eoj != null && !a.this.eoj.ejX && a.this.eoi != null) {
                    a.this.eoi.aXx();
                    a.this.xO("");
                }
            }
        }
    };
    private TextWatcher eol = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.eoi != null) {
                a.this.eoi.wY(editable.toString());
            }
            a.this.eog.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.eog.setEnabled(false);
                    } else if (!a.this.eog.isEnabled()) {
                        a.this.eog.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener eom = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.eoj == null || a.this.eoj.ejY != i || a.this.eod == null || !a.this.eoh) {
                return false;
            }
            if (a.this.eoi != null) {
                a.this.eoi.wZ(a.this.eod.getText().toString());
            }
            if (!a.this.eoj.ejX && a.this.eoi != null) {
                a.this.eoi.aXx();
                a.this.xO("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.eoc = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.eoe = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.eod = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.eog = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.eog.setOnClickListener(this.eok);
        this.eod.addTextChangedListener(this.eol);
        this.eod.setOnEditorActionListener(this.eom);
        this.eog.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.eog.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aZO() {
        if (this.eoh) {
            return false;
        }
        this.eoc.setVisibility(0);
        this.eoe.setVisibility(8);
        this.eoc.setFocusableInTouchMode(true);
        this.eoc.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.eoc, 0);
        return true;
    }

    public void lp(int i) {
        this.eoe.setVisibility(0);
        this.eod.setFocusableInTouchMode(true);
        this.eod.requestFocus();
        this.eoc.setVisibility(8);
        this.eoh = true;
        if (this.eoi != null) {
            this.eoi.lh(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.eod != null) {
            inputMethodManager.hideSoftInputFromWindow(this.eod.getApplicationWindowToken(), 0);
            this.eoh = false;
            this.eoc.setVisibility(8);
            this.eoe.setVisibility(8);
            if (this.eoi != null && this.eod != null) {
                this.eoi.xa(this.eod.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0525a interfaceC0525a) {
        this.eoi = interfaceC0525a;
    }

    public void a(final c cVar) {
        this.eoj = cVar;
        if (this.eod != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.ejV)) {
                this.eod.setText(cVar.ejV);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.ejV) && cVar.ejV.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.ejV.length();
                    }
                    this.eod.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.eod.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.eod.getText().length() <= cVar.ejV.length()) {
                                length = a.this.eod.getText().length();
                            } else {
                                length = cVar.ejV.length();
                            }
                            a.this.eod.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.eod.setText("");
            }
            this.eog.setEnabled(TextUtils.isEmpty(cVar.ejV) ? false : true);
            if (cVar.ejW) {
                this.eod.setMinLines(1);
                this.eod.setInputType(131073);
                this.eog.setText(cVar.ejZ);
                return;
            }
            this.eod.setMaxLines(1);
            this.eod.setInputType(1);
        }
    }

    public boolean xO(final String str) {
        if (!this.eoh || this.eod == null) {
            return false;
        }
        this.eod.setText(str);
        this.eod.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.eod.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aZP() {
        return this.eoh;
    }
}
