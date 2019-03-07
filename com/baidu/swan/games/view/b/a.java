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
import com.baidu.swan.apps.b;
import com.baidu.swan.games.j.a;
import com.baidu.swan.games.j.c;
/* loaded from: classes2.dex */
public class a {
    private EditText bfV;
    private EditText bfW;
    private RelativeLayout bfX;
    private Button bfY;
    private a.InterfaceC0165a bga;
    private c bgb;
    private RelativeLayout mRootView;
    private boolean bfZ = false;
    private View.OnClickListener bgc = new View.OnClickListener() { // from class: com.baidu.swan.games.view.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bfW != null && a.this.bfZ) {
                if (a.this.bga != null) {
                    a.this.bga.iM(a.this.bfW.getText().toString());
                }
                if (a.this.bgb != null && !a.this.bgb.bdS && a.this.bga != null) {
                    a.this.bga.OA();
                    a.this.jb("");
                }
            }
        }
    };
    private TextWatcher bgd = new TextWatcher() { // from class: com.baidu.swan.games.view.b.a.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(final Editable editable) {
            if (a.this.bga != null) {
                a.this.bga.iL(editable.toString());
            }
            a.this.bfY.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(editable.toString())) {
                        a.this.bfY.setEnabled(false);
                    } else if (!a.this.bfY.isEnabled()) {
                        a.this.bfY.setEnabled(true);
                    }
                }
            });
        }
    };
    private TextView.OnEditorActionListener bge = new TextView.OnEditorActionListener() { // from class: com.baidu.swan.games.view.b.a.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.bgb == null || a.this.bgb.bdT != i || a.this.bfW == null || !a.this.bfZ) {
                return false;
            }
            if (a.this.bga != null) {
                a.this.bga.iM(a.this.bfW.getText().toString());
            }
            if (!a.this.bgb.bdS && a.this.bga != null) {
                a.this.bga.OA();
                a.this.jb("");
            }
            return true;
        }
    };

    public a(Context context) {
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(b.g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.bfV = (EditText) this.mRootView.findViewById(b.f.ai_games_virtual_input_et);
        this.bfX = (RelativeLayout) this.mRootView.findViewById(b.f.ai_games_real_input_container);
        this.bfW = (EditText) this.mRootView.findViewById(b.f.ai_games_real_input_et);
        this.bfY = (Button) this.mRootView.findViewById(b.f.ai_games_input_send_btn);
        this.bfY.setOnClickListener(this.bgc);
        this.bfW.addTextChangedListener(this.bgd);
        this.bfW.setOnEditorActionListener(this.bge);
        this.bfY.post(new Runnable() { // from class: com.baidu.swan.games.view.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.bfY.setEnabled(false);
            }
        });
    }

    public View getContentView() {
        return this.mRootView;
    }

    public boolean PH() {
        if (this.bfZ) {
            return false;
        }
        this.bfV.setVisibility(0);
        this.bfX.setVisibility(8);
        this.bfV.setFocusableInTouchMode(true);
        this.bfV.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.bfV, 0);
        return true;
    }

    public void eN(int i) {
        this.bfX.setVisibility(0);
        this.bfW.setFocusableInTouchMode(true);
        this.bfW.requestFocus();
        this.bfV.setVisibility(8);
        this.bfZ = true;
        if (this.bga != null) {
            this.bga.eG(i);
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && this.bfW != null) {
            inputMethodManager.hideSoftInputFromWindow(this.bfW.getApplicationWindowToken(), 0);
            this.bfZ = false;
            this.bfV.setVisibility(8);
            this.bfX.setVisibility(8);
            if (this.bga != null && this.bfW != null) {
                this.bga.iN(this.bfW.getText().toString());
            }
        }
    }

    public void a(a.InterfaceC0165a interfaceC0165a) {
        this.bga = interfaceC0165a;
    }

    public void a(final c cVar) {
        this.bgb = cVar;
        if (this.bfW != null && cVar != null) {
            if (!TextUtils.isEmpty(cVar.bdQ)) {
                this.bfW.setText(cVar.bdQ);
                if (cVar.maxLength > 0) {
                    if (!TextUtils.isEmpty(cVar.bdQ) && cVar.bdQ.length() > cVar.maxLength) {
                        cVar.maxLength = cVar.bdQ.length();
                    }
                    this.bfW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.maxLength)});
                }
                this.bfW.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bfW.setSelection(cVar.bdQ.length());
                    }
                }, 300L);
            } else {
                this.bfW.setText("");
            }
            this.bfY.setEnabled(!TextUtils.isEmpty(cVar.bdQ));
            if (cVar.bdR) {
                this.bfW.setMinLines(1);
                this.bfW.setInputType(131073);
                this.bfY.setVisibility(0);
                this.bfY.setText(cVar.bdU);
                return;
            }
            this.bfW.setMaxLines(1);
            this.bfW.setInputType(1);
            this.bfY.setVisibility(8);
        }
    }

    public boolean jb(final String str) {
        if (!this.bfZ || this.bfW == null) {
            return false;
        }
        this.bfW.setText(str);
        this.bfW.postDelayed(new Runnable() { // from class: com.baidu.swan.games.view.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.bfW.setSelection(str.length());
            }
        }, 300L);
        return true;
    }

    public boolean PI() {
        return this.bfZ;
    }
}
