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
    private Button dyA;
    private a.InterfaceC0498a dyC;
    private c dyD;
    private EditText dyx;
    private EditText dyy;
    private RelativeLayout dyz;
    private RelativeLayout mRootView;
    private boolean dyB = false;
    private View.OnClickListener dyE = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dyy != null && a.this.dyB) {
                if (a.this.dyC != null) {
                    a.this.dyC.vx(a.this.dyy.getText().toString());
                }
                if (a.this.dyD != null && !a.this.dyD.dux && a.this.dyC != null) {
                    a.this.dyC.aOw();
                    a.this.wm("");
                }
            }
        }
    };
    private TextWatcher dyF = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.dyC != null) {
                a.this.dyC.vw(editable.toString());
            }
            a.this.dyA.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.dyA.setEnabled(false);
                    } else if (!a.this.dyA.isEnabled()) {
                        a.this.dyA.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener dyG = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.dyD == null || a.this.dyD.duy != i || a.this.dyy == null || !a.this.dyB) {
                return false;
            }
            if (a.this.dyC != null) {
                a.this.dyC.vx(a.this.dyy.getText().toString());
            }
            if (!a.this.dyD.dux && a.this.dyC != null) {
                a.this.dyC.aOw();
                a.this.wm("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.dyx = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.dyz = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.dyy = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.dyA = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.dyA.setOnClickListener(this.dyE);
        this.dyy.addTextChangedListener(this.dyF);
        this.dyy.setOnEditorActionListener(this.dyG);
        this.dyA.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.dyA.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aQM() {
        if (this.dyB) {
            return false;
        }
        this.dyx.setVisibility(0);
        this.dyz.setVisibility(8);
        this.dyx.setFocusableInTouchMode(true);
        this.dyx.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.dyx, 0);
        return true;
    }

    public void lm(int i) {
        this.dyz.setVisibility(0);
        this.dyy.setFocusableInTouchMode(true);
        this.dyy.requestFocus();
        this.dyx.setVisibility(8);
        this.dyB = true;
        if (this.dyC != null) {
            this.dyC.le(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.dyy != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dyy.getApplicationWindowToken(), 0);
            this.dyB = false;
            this.dyx.setVisibility(8);
            this.dyz.setVisibility(8);
            if (this.dyC != null && this.dyy != null) {
                this.dyC.vy(this.dyy.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0498a interfaceC0498a) {
        this.dyC = interfaceC0498a;
    }

    public void a(final c cVar) {
        this.dyD = cVar;
        if (this.dyy != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.duv)) {
                this.dyy.setText(cVar.duv);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.duv) && cVar.duv.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.duv.length();
                    }
                    this.dyy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.dyy.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.dyy.getText().length() <= cVar.duv.length()) {
                                length = a.this.dyy.getText().length();
                            } else {
                                length = cVar.duv.length();
                            }
                            a.this.dyy.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.dyy.setText("");
            }
            this.dyA.setEnabled(TextUtils.isEmpty(cVar.duv) ? false : true);
            if (cVar.duw) {
                this.dyy.setMinLines(1);
                this.dyy.setInputType(131073);
                this.dyA.setText(cVar.duz);
                return;
            }
            this.dyy.setMaxLines(1);
            this.dyy.setInputType(1);
        }
    }

    public boolean wm(final String str) {
        if (!this.dyB || this.dyy == null) {
            return false;
        }
        this.dyy.setText(str);
        this.dyy.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.dyy.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aQN() {
        return this.dyB;
    }
}
