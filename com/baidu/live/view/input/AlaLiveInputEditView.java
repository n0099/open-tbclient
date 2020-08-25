package com.baidu.live.view.input;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.live.sdk.a;
import com.baidu.live.view.input.b;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class AlaLiveInputEditView extends LinearLayout implements b {
    private EditText bde;
    private View.OnClickListener bdv;
    private TextView buB;
    private b.a buC;
    private GradientDrawable buD;
    private String buE;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bdv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.buC != null) {
                    AlaLiveInputEditView.this.buC.gw(AlaLiveInputEditView.this.bde.getText().toString());
                }
                AlaLiveInputEditView.this.KA();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.buB != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bde.getText()));
                }
                if (AlaLiveInputEditView.this.bde.getText() != null && AlaLiveInputEditView.this.buE != null && AlaLiveInputEditView.this.bde.getText().length() > AlaLiveInputEditView.this.buE.length()) {
                    AlaLiveInputEditView.this.bde.setText(AlaLiveInputEditView.this.buE);
                    AlaLiveInputEditView.this.bde.setSelection(AlaLiveInputEditView.this.bde.getText().length());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public AlaLiveInputEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.buC != null) {
                    AlaLiveInputEditView.this.buC.gw(AlaLiveInputEditView.this.bde.getText().toString());
                }
                AlaLiveInputEditView.this.KA();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.buB != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bde.getText()));
                }
                if (AlaLiveInputEditView.this.bde.getText() != null && AlaLiveInputEditView.this.buE != null && AlaLiveInputEditView.this.bde.getText().length() > AlaLiveInputEditView.this.buE.length()) {
                    AlaLiveInputEditView.this.bde.setText(AlaLiveInputEditView.this.buE);
                    AlaLiveInputEditView.this.bde.setSelection(AlaLiveInputEditView.this.bde.getText().length());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public AlaLiveInputEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.buC != null) {
                    AlaLiveInputEditView.this.buC.gw(AlaLiveInputEditView.this.bde.getText().toString());
                }
                AlaLiveInputEditView.this.KA();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.buB != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bde.getText()));
                }
                if (AlaLiveInputEditView.this.bde.getText() != null && AlaLiveInputEditView.this.buE != null && AlaLiveInputEditView.this.bde.getText().length() > AlaLiveInputEditView.this.buE.length()) {
                    AlaLiveInputEditView.this.bde.setText(AlaLiveInputEditView.this.buE);
                    AlaLiveInputEditView.this.bde.setSelection(AlaLiveInputEditView.this.bde.getText().length());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_input_edit_view, this);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-15329245);
        float dimensionPixelOffset3 = getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset3, dimensionPixelOffset3, dimensionPixelOffset3, dimensionPixelOffset3, 0.0f, 0.0f, 0.0f, 0.0f});
        setBackgroundDrawable(gradientDrawable);
        this.bde = (EditText) findViewById(a.g.edit_text);
        this.bde.setIncludeFontPadding(false);
        this.bde.addTextChangedListener(this.mTextWatcher);
        this.bde.setInputType(2);
        this.bde.setSingleLine(true);
        this.bde.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bde.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.buC != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bde.getText())) {
                        AlaLiveInputEditView.this.buC.gw(AlaLiveInputEditView.this.bde.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.buB = (TextView) findViewById(a.g.tv_send);
        this.buB.setOnClickListener(this.bdv);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bde, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.buC = aVar;
    }

    public void KA() {
        this.bde.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bde.setText(str);
                this.bde.setSelection(str.length());
            } catch (Exception e) {
                this.bde.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bde.setHint(str);
    }

    public void setMaxText(String str) {
        this.buE = str;
    }

    public void setInputEditType(int i) {
        this.bde.setInputType(i);
    }

    public EditText getEditView() {
        return this.bde;
    }

    public TextView getTextView() {
        return this.buB;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bde.requestFocus();
        } else {
            this.bde.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bde.removeTextChangedListener(this.mTextWatcher);
        this.bde.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.buD == null) {
            this.buD = new GradientDrawable();
            this.buD.setShape(0);
            this.buD.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.buD.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.buD.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.buD.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.buD.clearColorFilter();
            this.buB.setTextColor(-1);
        } else {
            this.buD.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.buB.setTextColor(-2130706433);
        }
        this.buB.setBackgroundDrawable(this.buD);
        this.buB.setEnabled(z);
    }
}
