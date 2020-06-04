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
    private EditText ddJ;
    private EditText ddK;
    private RelativeLayout ddL;
    private Button ddM;
    private a.InterfaceC0431a ddO;
    private c ddP;
    private RelativeLayout mRootView;
    private boolean ddN = false;
    private View.OnClickListener ddQ = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ddK != null && a.this.ddN) {
                if (a.this.ddO != null) {
                    a.this.ddO.rZ(a.this.ddK.getText().toString());
                }
                if (a.this.ddP != null && !a.this.ddP.cZN && a.this.ddO != null) {
                    a.this.ddO.aAS();
                    a.this.sK("");
                }
            }
        }
    };
    private TextWatcher ddR = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.ddO != null) {
                a.this.ddO.rY(editable.toString());
            }
            a.this.ddM.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.ddM.setEnabled(false);
                    } else if (!a.this.ddM.isEnabled()) {
                        a.this.ddM.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener ddS = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.ddP == null || a.this.ddP.cZO != i || a.this.ddK == null || !a.this.ddN) {
                return false;
            }
            if (a.this.ddO != null) {
                a.this.ddO.rZ(a.this.ddK.getText().toString());
            }
            if (!a.this.ddP.cZN && a.this.ddO != null) {
                a.this.ddO.aAS();
                a.this.sK("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.ddJ = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.ddL = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.ddK = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.ddM = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.ddM.setOnClickListener(this.ddQ);
        this.ddK.addTextChangedListener(this.ddR);
        this.ddK.setOnEditorActionListener(this.ddS);
        this.ddM.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.ddM.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aCX() {
        if (this.ddN) {
            return false;
        }
        this.ddJ.setVisibility(0);
        this.ddL.setVisibility(8);
        this.ddJ.setFocusableInTouchMode(true);
        this.ddJ.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.ddJ, 0);
        return true;
    }

    public void iB(int i) {
        this.ddL.setVisibility(0);
        this.ddK.setFocusableInTouchMode(true);
        this.ddK.requestFocus();
        this.ddJ.setVisibility(8);
        this.ddN = true;
        if (this.ddO != null) {
            this.ddO.it(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.ddK != null) {
            inputMethodManager.hideSoftInputFromWindow(this.ddK.getApplicationWindowToken(), 0);
            this.ddN = false;
            this.ddJ.setVisibility(8);
            this.ddL.setVisibility(8);
            if (this.ddO != null && this.ddK != null) {
                this.ddO.sa(this.ddK.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0431a interfaceC0431a) {
        this.ddO = interfaceC0431a;
    }

    public void a(final c cVar) {
        this.ddP = cVar;
        if (this.ddK != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.cZL)) {
                this.ddK.setText(cVar.cZL);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.cZL) && cVar.cZL.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.cZL.length();
                    }
                    this.ddK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.ddK.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.ddK.getText().length() <= cVar.cZL.length()) {
                                length = a.this.ddK.getText().length();
                            } else {
                                length = cVar.cZL.length();
                            }
                            a.this.ddK.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.ddK.setText("");
            }
            this.ddM.setEnabled(TextUtils.isEmpty(cVar.cZL) ? false : true);
            if (cVar.cZM) {
                this.ddK.setMinLines(1);
                this.ddK.setInputType(131073);
                this.ddM.setText(cVar.cZP);
                return;
            }
            this.ddK.setMaxLines(1);
            this.ddK.setInputType(1);
        }
    }

    public boolean sK(final String str) {
        if (!this.ddN || this.ddK == null) {
            return false;
        }
        this.ddK.setText(str);
        this.ddK.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.ddK.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aCY() {
        return this.ddN;
    }
}
