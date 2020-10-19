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
/* loaded from: classes10.dex */
public class a {
    private EditText dMA;
    private RelativeLayout dMB;
    private Button dMC;
    private a.InterfaceC0510a dME;
    private c dMF;
    private EditText dMz;
    private RelativeLayout mRootView;
    private boolean dMD = false;
    private View.OnClickListener dMG = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dMA != null && a.this.dMD) {
                if (a.this.dME != null) {
                    a.this.dME.wC(a.this.dMA.getText().toString());
                }
                if (a.this.dMF != null && !a.this.dMF.dIz && a.this.dME != null) {
                    a.this.dME.aRQ();
                    a.this.xr("");
                }
            }
        }
    };
    private TextWatcher dMH = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.dME != null) {
                a.this.dME.wB(editable.toString());
            }
            a.this.dMC.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.dMC.setEnabled(false);
                    } else if (!a.this.dMC.isEnabled()) {
                        a.this.dMC.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener dMI = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.dMF == null || a.this.dMF.dIA != i || a.this.dMA == null || !a.this.dMD) {
                return false;
            }
            if (a.this.dME != null) {
                a.this.dME.wC(a.this.dMA.getText().toString());
            }
            if (!a.this.dMF.dIz && a.this.dME != null) {
                a.this.dME.aRQ();
                a.this.xr("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.dMz = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.dMB = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.dMA = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.dMC = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.dMC.setOnClickListener(this.dMG);
        this.dMA.addTextChangedListener(this.dMH);
        this.dMA.setOnEditorActionListener(this.dMI);
        this.dMC.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.dMC.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aUh() {
        if (this.dMD) {
            return false;
        }
        this.dMz.setVisibility(0);
        this.dMB.setVisibility(8);
        this.dMz.setFocusableInTouchMode(true);
        this.dMz.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.dMz, 0);
        return true;
    }

    public void lU(int i) {
        this.dMB.setVisibility(0);
        this.dMA.setFocusableInTouchMode(true);
        this.dMA.requestFocus();
        this.dMz.setVisibility(8);
        this.dMD = true;
        if (this.dME != null) {
            this.dME.lM(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.dMA != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dMA.getApplicationWindowToken(), 0);
            this.dMD = false;
            this.dMz.setVisibility(8);
            this.dMB.setVisibility(8);
            if (this.dME != null && this.dMA != null) {
                this.dME.wD(this.dMA.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0510a interfaceC0510a) {
        this.dME = interfaceC0510a;
    }

    public void a(final c cVar) {
        this.dMF = cVar;
        if (this.dMA != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.dIx)) {
                this.dMA.setText(cVar.dIx);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.dIx) && cVar.dIx.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.dIx.length();
                    }
                    this.dMA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.dMA.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.dMA.getText().length() <= cVar.dIx.length()) {
                                length = a.this.dMA.getText().length();
                            } else {
                                length = cVar.dIx.length();
                            }
                            a.this.dMA.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.dMA.setText("");
            }
            this.dMC.setEnabled(TextUtils.isEmpty(cVar.dIx) ? false : true);
            if (cVar.dIy) {
                this.dMA.setMinLines(1);
                this.dMA.setInputType(131073);
                this.dMC.setText(cVar.dIB);
                return;
            }
            this.dMA.setMaxLines(1);
            this.dMA.setInputType(1);
        }
    }

    public boolean xr(final String str) {
        if (!this.dMD || this.dMA == null) {
            return false;
        }
        this.dMA.setText(str);
        this.dMA.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.dMA.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aUi() {
        return this.dMD;
    }
}
