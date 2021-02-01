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
/* loaded from: classes9.dex */
public class a {
    private EditText emA;
    private RelativeLayout emB;
    private Button emC;
    private a.InterfaceC0519a emE;
    private c emF;
    private EditText emz;
    private RelativeLayout mRootView;
    private boolean emD = false;
    private View.OnClickListener emG = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.emA != null && a.this.emD) {
                if (a.this.emE != null) {
                    a.this.emE.wS(a.this.emA.getText().toString());
                }
                if (a.this.emF != null && !a.this.emF.eiw && a.this.emE != null) {
                    a.this.emE.aXu();
                    a.this.xH("");
                }
            }
        }
    };
    private TextWatcher emH = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.emE != null) {
                a.this.emE.wR(editable.toString());
            }
            a.this.emC.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.emC.setEnabled(false);
                    } else if (!a.this.emC.isEnabled()) {
                        a.this.emC.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener emI = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.emF == null || a.this.emF.eix != i || a.this.emA == null || !a.this.emD) {
                return false;
            }
            if (a.this.emE != null) {
                a.this.emE.wS(a.this.emA.getText().toString());
            }
            if (!a.this.emF.eiw && a.this.emE != null) {
                a.this.emE.aXu();
                a.this.xH("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.emz = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.emB = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.emA = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.emC = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.emC.setOnClickListener(this.emG);
        this.emA.addTextChangedListener(this.emH);
        this.emA.setOnEditorActionListener(this.emI);
        this.emC.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.emC.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aZL() {
        if (this.emD) {
            return false;
        }
        this.emz.setVisibility(0);
        this.emB.setVisibility(8);
        this.emz.setFocusableInTouchMode(true);
        this.emz.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.emz, 0);
        return true;
    }

    public void lo(int i) {
        this.emB.setVisibility(0);
        this.emA.setFocusableInTouchMode(true);
        this.emA.requestFocus();
        this.emz.setVisibility(8);
        this.emD = true;
        if (this.emE != null) {
            this.emE.lg(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.emA != null) {
            inputMethodManager.hideSoftInputFromWindow(this.emA.getApplicationWindowToken(), 0);
            this.emD = false;
            this.emz.setVisibility(8);
            this.emB.setVisibility(8);
            if (this.emE != null && this.emA != null) {
                this.emE.wT(this.emA.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0519a interfaceC0519a) {
        this.emE = interfaceC0519a;
    }

    public void a(final c cVar) {
        this.emF = cVar;
        if (this.emA != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.eiu)) {
                this.emA.setText(cVar.eiu);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.eiu) && cVar.eiu.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.eiu.length();
                    }
                    this.emA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.emA.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.emA.getText().length() <= cVar.eiu.length()) {
                                length = a.this.emA.getText().length();
                            } else {
                                length = cVar.eiu.length();
                            }
                            a.this.emA.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.emA.setText("");
            }
            this.emC.setEnabled(TextUtils.isEmpty(cVar.eiu) ? false : true);
            if (cVar.eiv) {
                this.emA.setMinLines(1);
                this.emA.setInputType(131073);
                this.emC.setText(cVar.eiy);
                return;
            }
            this.emA.setMaxLines(1);
            this.emA.setInputType(1);
        }
    }

    public boolean xH(final String str) {
        if (!this.emD || this.emA == null) {
            return false;
        }
        this.emA.setText(str);
        this.emA.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.emA.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aZM() {
        return this.emD;
    }
}
