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
import com.baidu.swan.games.m.a;
import com.baidu.swan.games.m.c;
/* loaded from: classes11.dex */
public class a {
    private EditText ctI;
    private EditText ctJ;
    private RelativeLayout ctK;
    private Button ctL;
    private a.InterfaceC0339a ctN;
    private c ctO;
    private RelativeLayout mRootView;
    private boolean ctM = false;
    private View.OnClickListener ctP = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ctJ != null && a.this.ctM) {
                if (a.this.ctN != null) {
                    a.this.ctN.pj(a.this.ctJ.getText().toString());
                }
                if (a.this.ctO != null && !a.this.ctO.cpU && a.this.ctN != null) {
                    a.this.ctN.aoO();
                    a.this.pT("");
                }
            }
        }
    };
    private TextWatcher ctQ = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.ctN != null) {
                a.this.ctN.pi(editable.toString());
            }
            a.this.ctL.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.ctL.setEnabled(false);
                    } else if (!a.this.ctL.isEnabled()) {
                        a.this.ctL.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener ctR = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.ctO == null || a.this.ctO.cpV != i || a.this.ctJ == null || !a.this.ctM) {
                return false;
            }
            if (a.this.ctN != null) {
                a.this.ctN.pj(a.this.ctJ.getText().toString());
            }
            if (!a.this.ctO.cpU && a.this.ctN != null) {
                a.this.ctN.aoO();
                a.this.pT("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.ctI = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.ctK = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.ctJ = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.ctL = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.ctL.setOnClickListener(this.ctP);
        this.ctJ.addTextChangedListener(this.ctQ);
        this.ctJ.setOnEditorActionListener(this.ctR);
        this.ctL.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.ctL.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean aqU() {
        if (this.ctM) {
            return false;
        }
        this.ctI.setVisibility(0);
        this.ctK.setVisibility(8);
        this.ctI.setFocusableInTouchMode(true);
        this.ctI.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.ctI, 0);
        return true;
    }

    public void ib(int i) {
        this.ctK.setVisibility(0);
        this.ctJ.setFocusableInTouchMode(true);
        this.ctJ.requestFocus();
        this.ctI.setVisibility(8);
        this.ctM = true;
        if (this.ctN != null) {
            this.ctN.hT(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.ctJ != null) {
            inputMethodManager.hideSoftInputFromWindow(this.ctJ.getApplicationWindowToken(), 0);
            this.ctM = false;
            this.ctI.setVisibility(8);
            this.ctK.setVisibility(8);
            if (this.ctN != null && this.ctJ != null) {
                this.ctN.pk(this.ctJ.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0339a interfaceC0339a) {
        this.ctN = interfaceC0339a;
    }

    public void a(final c cVar) {
        this.ctO = cVar;
        if (this.ctJ != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.cpS)) {
                this.ctJ.setText(cVar.cpS);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.cpS) && cVar.cpS.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.cpS.length();
                    }
                    this.ctJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.ctJ.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int length;
                        try {
                            if (a.this.ctJ.getText().length() <= cVar.cpS.length()) {
                                length = a.this.ctJ.getText().length();
                            } else {
                                length = cVar.cpS.length();
                            }
                            a.this.ctJ.setSelection(length);
                        } catch (Exception e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 300L);
            } else {
                this.ctJ.setText("");
            }
            this.ctL.setEnabled(TextUtils.isEmpty(cVar.cpS) ? false : true);
            if (cVar.cpT) {
                this.ctJ.setMinLines(1);
                this.ctJ.setInputType(131073);
                this.ctL.setText(cVar.cpW);
                return;
            }
            this.ctJ.setMaxLines(1);
            this.ctJ.setInputType(1);
        }
    }

    public boolean pT(final String str) {
        if (!this.ctM || this.ctJ == null) {
            return false;
        }
        this.ctJ.setText(str);
        this.ctJ.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.ctJ.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean aqV() {
        return this.ctM;
    }
}
