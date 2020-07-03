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
/* loaded from: classes11.dex */
public class a {
    private a.InterfaceC0437a diB;
    private c diC;
    private EditText diw;
    private EditText dix;
    private RelativeLayout diy;
    private Button diz;
    private RelativeLayout mRootView;
    private boolean diA = false;
    private View.OnClickListener diD = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dix != null && a.this.diA) {
                if (a.this.diB != null) {
                    a.this.diB.sh(a.this.dix.getText().toString());
                }
                if (a.this.diC != null && !a.this.diC.deC && a.this.diB != null) {
                    a.this.diB.aBY();
                    a.this.sS("");
                }
            }
        }
    };
    private TextWatcher diE = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.diB != null) {
                a.this.diB.sg(editable.toString());
            }
            a.this.diz.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.diz.setEnabled(false);
                    } else if (!a.this.diz.isEnabled()) {
                        a.this.diz.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener diF = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.diC == null || a.this.diC.deD != i || a.this.dix == null || !a.this.diA) {
                return false;
            }
            if (a.this.diB != null) {
                a.this.diB.sh(a.this.dix.getText().toString());
            }
            if (!a.this.diC.deC && a.this.diB != null) {
                a.this.diB.aBY();
                a.this.sS("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.diw = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.diy = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.dix = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.diz = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.diz.setOnClickListener(this.diD);
        this.dix.addTextChangedListener(this.diE);
        this.dix.setOnEditorActionListener(this.diF);
        this.diz.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.diz.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aEd() {
        if (this.diA) {
            return false;
        }
        this.diw.setVisibility(0);
        this.diy.setVisibility(8);
        this.diw.setFocusableInTouchMode(true);
        this.diw.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.diw, 0);
        return true;
    }

    public void iM(int i) {
        this.diy.setVisibility(0);
        this.dix.setFocusableInTouchMode(true);
        this.dix.requestFocus();
        this.diw.setVisibility(8);
        this.diA = true;
        if (this.diB != null) {
            this.diB.iE(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.dix != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dix.getApplicationWindowToken(), 0);
            this.diA = false;
            this.diw.setVisibility(8);
            this.diy.setVisibility(8);
            if (this.diB != null && this.dix != null) {
                this.diB.si(this.dix.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0437a interfaceC0437a) {
        this.diB = interfaceC0437a;
    }

    public void a(final c cVar) {
        this.diC = cVar;
        if (this.dix != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.deA)) {
                this.dix.setText(cVar.deA);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.deA) && cVar.deA.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.deA.length();
                    }
                    this.dix.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.dix.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.dix.getText().length() <= cVar.deA.length()) {
                                length = a.this.dix.getText().length();
                            } else {
                                length = cVar.deA.length();
                            }
                            a.this.dix.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.dix.setText("");
            }
            this.diz.setEnabled(TextUtils.isEmpty(cVar.deA) ? false : true);
            if (cVar.deB) {
                this.dix.setMinLines(1);
                this.dix.setInputType(131073);
                this.diz.setText(cVar.deE);
                return;
            }
            this.dix.setMaxLines(1);
            this.dix.setInputType(1);
        }
    }

    public boolean sS(final String str) {
        if (!this.diA || this.dix == null) {
            return false;
        }
        this.dix.setText(str);
        this.dix.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.dix.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aEe() {
        return this.diA;
    }
}
