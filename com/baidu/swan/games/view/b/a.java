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
import com.baidu.swan.games.j.a;
import com.baidu.swan.games.j.c;
/* loaded from: classes2.dex */
public class a {
    private EditText bfW;
    private EditText bfX;
    private RelativeLayout bfY;
    private Button bfZ;
    private a.InterfaceC0194a bgb;
    private c bgc;
    private RelativeLayout mRootView;
    private boolean bga = false;
    private View.OnClickListener bgd = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bfX != null && a.this.bga) {
                if (a.this.bgb != null) {
                    a.this.bgb.iM(a.this.bfX.getText().toString());
                }
                if (a.this.bgc != null && !a.this.bgc.bdT && a.this.bgb != null) {
                    a.this.bgb.OA();
                    a.this.jb("");
                }
            }
        }
    };
    private TextWatcher bge = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.bgb != null) {
                a.this.bgb.iL(editable.toString());
            }
            a.this.bfZ.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.bfZ.setEnabled(false);
                    } else if (!a.this.bfZ.isEnabled()) {
                        a.this.bfZ.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener bgf = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.bgc == null || a.this.bgc.bdU != i || a.this.bfX == null || !a.this.bga) {
                return false;
            }
            if (a.this.bgb != null) {
                a.this.bgb.iM(a.this.bfX.getText().toString());
            }
            if (!a.this.bgc.bdT && a.this.bgb != null) {
                a.this.bgb.OA();
                a.this.jb("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(a.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.bfW = (EditText) this.mRootView.findViewById(a.f.ai_games_virtual_input_et);
        this.bfY = (RelativeLayout) this.mRootView.findViewById(a.f.ai_games_real_input_container);
        this.bfX = (EditText) this.mRootView.findViewById(a.f.ai_games_real_input_et);
        this.bfZ = (Button) this.mRootView.findViewById(a.f.ai_games_input_send_btn);
        this.bfZ.setOnClickListener(this.bgd);
        this.bfX.addTextChangedListener(this.bge);
        this.bfX.setOnEditorActionListener(this.bgf);
        this.bfZ.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.bfZ.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean PH() {
        if (this.bga) {
            return false;
        }
        this.bfW.setVisibility(0);
        this.bfY.setVisibility(8);
        this.bfW.setFocusableInTouchMode(true);
        this.bfW.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.bfW, 0);
        return true;
    }

    public void eN(int i) {
        this.bfY.setVisibility(0);
        this.bfX.setFocusableInTouchMode(true);
        this.bfX.requestFocus();
        this.bfW.setVisibility(8);
        this.bga = true;
        if (this.bgb != null) {
            this.bgb.eG(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.bfX != null) {
            inputMethodManager.hideSoftInputFromWindow(this.bfX.getApplicationWindowToken(), 0);
            this.bga = false;
            this.bfW.setVisibility(8);
            this.bfY.setVisibility(8);
            if (this.bgb != null && this.bfX != null) {
                this.bgb.iN(this.bfX.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0194a interfaceC0194a) {
        this.bgb = interfaceC0194a;
    }

    public void a(final c cVar) {
        this.bgc = cVar;
        if (this.bfX != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.bdR)) {
                this.bfX.setText(cVar.bdR);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.bdR) && cVar.bdR.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.bdR.length();
                    }
                    this.bfX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.bfX.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bfX.setSelection(cVar.bdR.length());
                    }
                }, 300L);
            } else {
                this.bfX.setText("");
            }
            this.bfZ.setEnabled(!TextUtils.isEmpty(cVar.bdR));
            if (cVar.bdS) {
                this.bfX.setMinLines(1);
                this.bfX.setInputType(131073);
                this.bfZ.setVisibility(0);
                this.bfZ.setText(cVar.bdV);
                return;
            }
            this.bfX.setMaxLines(1);
            this.bfX.setInputType(1);
            this.bfZ.setVisibility(8);
        }
    }

    public boolean jb(final String str) {
        if (!this.bga || this.bfX == null) {
            return false;
        }
        this.bfX.setText(str);
        this.bfX.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.bfX.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean PI() {
        return this.bga;
    }
}
