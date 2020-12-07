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
/* loaded from: classes25.dex */
public class a {
    private EditText egf;
    private EditText egg;
    private RelativeLayout egh;
    private Button egi;
    private a.InterfaceC0546a egk;
    private c egm;
    private RelativeLayout mRootView;
    private boolean egj = false;
    private View.OnClickListener egn = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.egg != null && a.this.egj) {
                if (a.this.egk != null) {
                    a.this.egk.xL(a.this.egg.getText().toString());
                }
                if (a.this.egm != null && !a.this.egm.ece && a.this.egk != null) {
                    a.this.egk.aYH();
                    a.this.yA("");
                }
            }
        }
    };
    private TextWatcher ego = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.egk != null) {
                a.this.egk.xK(editable.toString());
            }
            a.this.egi.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.egi.setEnabled(false);
                    } else if (!a.this.egi.isEnabled()) {
                        a.this.egi.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener egp = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.egm == null || a.this.egm.ecf != i || a.this.egg == null || !a.this.egj) {
                return false;
            }
            if (a.this.egk != null) {
                a.this.egk.xL(a.this.egg.getText().toString());
            }
            if (!a.this.egm.ece && a.this.egk != null) {
                a.this.egk.aYH();
                a.this.yA("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.egf = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.egh = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.egg = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.egi = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.egi.setOnClickListener(this.egn);
        this.egg.addTextChangedListener(this.ego);
        this.egg.setOnEditorActionListener(this.egp);
        this.egi.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.egi.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean baZ() {
        if (this.egj) {
            return false;
        }
        this.egf.setVisibility(0);
        this.egh.setVisibility(8);
        this.egf.setFocusableInTouchMode(true);
        this.egf.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.egf, 0);
        return true;
    }

    public void mJ(int i) {
        this.egh.setVisibility(0);
        this.egg.setFocusableInTouchMode(true);
        this.egg.requestFocus();
        this.egf.setVisibility(8);
        this.egj = true;
        if (this.egk != null) {
            this.egk.mB(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.egg != null) {
            inputMethodManager.hideSoftInputFromWindow(this.egg.getApplicationWindowToken(), 0);
            this.egj = false;
            this.egf.setVisibility(8);
            this.egh.setVisibility(8);
            if (this.egk != null && this.egg != null) {
                this.egk.xM(this.egg.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0546a interfaceC0546a) {
        this.egk = interfaceC0546a;
    }

    public void a(final c cVar) {
        this.egm = cVar;
        if (this.egg != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.ecc)) {
                this.egg.setText(cVar.ecc);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.ecc) && cVar.ecc.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.ecc.length();
                    }
                    this.egg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.egg.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.egg.getText().length() <= cVar.ecc.length()) {
                                length = a.this.egg.getText().length();
                            } else {
                                length = cVar.ecc.length();
                            }
                            a.this.egg.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.egg.setText("");
            }
            this.egi.setEnabled(TextUtils.isEmpty(cVar.ecc) ? false : true);
            if (cVar.ecd) {
                this.egg.setMinLines(1);
                this.egg.setInputType(131073);
                this.egi.setText(cVar.ecg);
                return;
            }
            this.egg.setMaxLines(1);
            this.egg.setInputType(1);
        }
    }

    public boolean yA(final String str) {
        if (!this.egj || this.egg == null) {
            return false;
        }
        this.egg.setText(str);
        this.egg.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.egg.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean bba() {
        return this.egj;
    }
}
