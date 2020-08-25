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
    private EditText dyt;
    private EditText dyu;
    private RelativeLayout dyv;
    private Button dyw;
    private a.InterfaceC0498a dyy;
    private c dyz;
    private RelativeLayout mRootView;
    private boolean dyx = false;
    private View.OnClickListener dyA = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dyu != null && a.this.dyx) {
                if (a.this.dyy != null) {
                    a.this.dyy.vw(a.this.dyu.getText().toString());
                }
                if (a.this.dyz != null && !a.this.dyz.dut && a.this.dyy != null) {
                    a.this.dyy.aOw();
                    a.this.wl("");
                }
            }
        }
    };
    private TextWatcher dyB = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.dyy != null) {
                a.this.dyy.vv(editable.toString());
            }
            a.this.dyw.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.dyw.setEnabled(false);
                    } else if (!a.this.dyw.isEnabled()) {
                        a.this.dyw.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener dyC = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.dyz == null || a.this.dyz.duu != i || a.this.dyu == null || !a.this.dyx) {
                return false;
            }
            if (a.this.dyy != null) {
                a.this.dyy.vw(a.this.dyu.getText().toString());
            }
            if (!a.this.dyz.dut && a.this.dyy != null) {
                a.this.dyy.aOw();
                a.this.wl("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.dyt = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.dyv = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.dyu = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.dyw = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.dyw.setOnClickListener(this.dyA);
        this.dyu.addTextChangedListener(this.dyB);
        this.dyu.setOnEditorActionListener(this.dyC);
        this.dyw.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.dyw.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aQM() {
        if (this.dyx) {
            return false;
        }
        this.dyt.setVisibility(0);
        this.dyv.setVisibility(8);
        this.dyt.setFocusableInTouchMode(true);
        this.dyt.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.dyt, 0);
        return true;
    }

    public void lm(int i) {
        this.dyv.setVisibility(0);
        this.dyu.setFocusableInTouchMode(true);
        this.dyu.requestFocus();
        this.dyt.setVisibility(8);
        this.dyx = true;
        if (this.dyy != null) {
            this.dyy.le(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.dyu != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dyu.getApplicationWindowToken(), 0);
            this.dyx = false;
            this.dyt.setVisibility(8);
            this.dyv.setVisibility(8);
            if (this.dyy != null && this.dyu != null) {
                this.dyy.vx(this.dyu.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0498a interfaceC0498a) {
        this.dyy = interfaceC0498a;
    }

    public void a(final c cVar) {
        this.dyz = cVar;
        if (this.dyu != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.dur)) {
                this.dyu.setText(cVar.dur);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.dur) && cVar.dur.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.dur.length();
                    }
                    this.dyu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.dyu.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.dyu.getText().length() <= cVar.dur.length()) {
                                length = a.this.dyu.getText().length();
                            } else {
                                length = cVar.dur.length();
                            }
                            a.this.dyu.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.dyu.setText("");
            }
            this.dyw.setEnabled(TextUtils.isEmpty(cVar.dur) ? false : true);
            if (cVar.dus) {
                this.dyu.setMinLines(1);
                this.dyu.setInputType(131073);
                this.dyw.setText(cVar.duv);
                return;
            }
            this.dyu.setMaxLines(1);
            this.dyu.setInputType(1);
        }
    }

    public boolean wl(final String str) {
        if (!this.dyx || this.dyu == null) {
            return false;
        }
        this.dyu.setText(str);
        this.dyu.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.dyu.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aQN() {
        return this.dyx;
    }
}
