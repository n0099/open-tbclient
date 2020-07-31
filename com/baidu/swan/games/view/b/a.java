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
/* loaded from: classes7.dex */
public class a {
    private EditText dor;
    private EditText dos;
    private RelativeLayout dot;
    private Button dou;
    private a.InterfaceC0450a dow;
    private c dox;
    private RelativeLayout mRootView;
    private boolean dov = false;
    private View.OnClickListener doy = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dos != null && a.this.dov) {
                if (a.this.dow != null) {
                    a.this.dow.tg(a.this.dos.getText().toString());
                }
                if (a.this.dox != null && !a.this.dox.dkl && a.this.dow != null) {
                    a.this.dow.aFF();
                    a.this.tV("");
                }
            }
        }
    };
    private TextWatcher doz = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.dow != null) {
                a.this.dow.tf(editable.toString());
            }
            a.this.dou.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.dou.setEnabled(false);
                    } else if (!a.this.dou.isEnabled()) {
                        a.this.dou.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener doA = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.dox == null || a.this.dox.dkm != i || a.this.dos == null || !a.this.dov) {
                return false;
            }
            if (a.this.dow != null) {
                a.this.dow.tg(a.this.dos.getText().toString());
            }
            if (!a.this.dox.dkl && a.this.dow != null) {
                a.this.dow.aFF();
                a.this.tV("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.dor = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.dot = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.dos = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.dou = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.dou.setOnClickListener(this.doy);
        this.dos.addTextChangedListener(this.doz);
        this.dos.setOnEditorActionListener(this.doA);
        this.dou.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.dou.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aHW() {
        if (this.dov) {
            return false;
        }
        this.dor.setVisibility(0);
        this.dot.setVisibility(8);
        this.dor.setFocusableInTouchMode(true);
        this.dor.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.dor, 0);
        return true;
    }

    public void jd(int i) {
        this.dot.setVisibility(0);
        this.dos.setFocusableInTouchMode(true);
        this.dos.requestFocus();
        this.dor.setVisibility(8);
        this.dov = true;
        if (this.dow != null) {
            this.dow.iV(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.dos != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dos.getApplicationWindowToken(), 0);
            this.dov = false;
            this.dor.setVisibility(8);
            this.dot.setVisibility(8);
            if (this.dow != null && this.dos != null) {
                this.dow.th(this.dos.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0450a interfaceC0450a) {
        this.dow = interfaceC0450a;
    }

    public void a(final c cVar) {
        this.dox = cVar;
        if (this.dos != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.dkj)) {
                this.dos.setText(cVar.dkj);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.dkj) && cVar.dkj.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.dkj.length();
                    }
                    this.dos.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.dos.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.dos.getText().length() <= cVar.dkj.length()) {
                                length = a.this.dos.getText().length();
                            } else {
                                length = cVar.dkj.length();
                            }
                            a.this.dos.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.dos.setText("");
            }
            this.dou.setEnabled(TextUtils.isEmpty(cVar.dkj) ? false : true);
            if (cVar.dkk) {
                this.dos.setMinLines(1);
                this.dos.setInputType(131073);
                this.dou.setText(cVar.dkn);
                return;
            }
            this.dos.setMaxLines(1);
            this.dos.setInputType(1);
        }
    }

    public boolean tV(final String str) {
        if (!this.dov || this.dos == null) {
            return false;
        }
        this.dos.setText(str);
        this.dos.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.dos.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aHX() {
        return this.dov;
    }
}
