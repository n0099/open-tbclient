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
    private EditText dZg;
    private EditText dZh;
    private RelativeLayout dZi;
    private Button dZj;
    private a.InterfaceC0534a dZl;
    private c dZm;
    private RelativeLayout mRootView;
    private boolean dZk = false;
    private View.OnClickListener dZn = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dZh != null && a.this.dZk) {
                if (a.this.dZl != null) {
                    a.this.dZl.xe(a.this.dZh.getText().toString());
                }
                if (a.this.dZm != null && !a.this.dZm.dVg && a.this.dZl != null) {
                    a.this.dZl.aVC();
                    a.this.xT("");
                }
            }
        }
    };
    private TextWatcher dZo = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.dZl != null) {
                a.this.dZl.xd(editable.toString());
            }
            a.this.dZj.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.dZj.setEnabled(false);
                    } else if (!a.this.dZj.isEnabled()) {
                        a.this.dZj.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener dZp = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.dZm == null || a.this.dZm.dVh != i || a.this.dZh == null || !a.this.dZk) {
                return false;
            }
            if (a.this.dZl != null) {
                a.this.dZl.xe(a.this.dZh.getText().toString());
            }
            if (!a.this.dZm.dVg && a.this.dZl != null) {
                a.this.dZl.aVC();
                a.this.xT("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.dZg = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.dZi = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.dZh = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.dZj = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.dZj.setOnClickListener(this.dZn);
        this.dZh.addTextChangedListener(this.dZo);
        this.dZh.setOnEditorActionListener(this.dZp);
        this.dZj.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.dZj.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aXU() {
        if (this.dZk) {
            return false;
        }
        this.dZg.setVisibility(0);
        this.dZi.setVisibility(8);
        this.dZg.setFocusableInTouchMode(true);
        this.dZg.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.dZg, 0);
        return true;
    }

    public void ml(int i) {
        this.dZi.setVisibility(0);
        this.dZh.setFocusableInTouchMode(true);
        this.dZh.requestFocus();
        this.dZg.setVisibility(8);
        this.dZk = true;
        if (this.dZl != null) {
            this.dZl.md(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.dZh != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dZh.getApplicationWindowToken(), 0);
            this.dZk = false;
            this.dZg.setVisibility(8);
            this.dZi.setVisibility(8);
            if (this.dZl != null && this.dZh != null) {
                this.dZl.xf(this.dZh.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0534a interfaceC0534a) {
        this.dZl = interfaceC0534a;
    }

    public void a(final c cVar) {
        this.dZm = cVar;
        if (this.dZh != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.dVe)) {
                this.dZh.setText(cVar.dVe);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.dVe) && cVar.dVe.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.dVe.length();
                    }
                    this.dZh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.dZh.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.dZh.getText().length() <= cVar.dVe.length()) {
                                length = a.this.dZh.getText().length();
                            } else {
                                length = cVar.dVe.length();
                            }
                            a.this.dZh.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.dZh.setText("");
            }
            this.dZj.setEnabled(TextUtils.isEmpty(cVar.dVe) ? false : true);
            if (cVar.dVf) {
                this.dZh.setMinLines(1);
                this.dZh.setInputType(131073);
                this.dZj.setText(cVar.dVi);
                return;
            }
            this.dZh.setMaxLines(1);
            this.dZh.setInputType(1);
        }
    }

    public boolean xT(final String str) {
        if (!this.dZk || this.dZh == null) {
            return false;
        }
        this.dZh.setText(str);
        this.dZh.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.dZh.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aXV() {
        return this.dZk;
    }
}
