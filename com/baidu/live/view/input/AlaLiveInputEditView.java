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
/* loaded from: classes4.dex */
public class AlaLiveInputEditView extends LinearLayout implements b {
    private EditText aXO;
    private View.OnClickListener aYe;
    private TextView boO;
    private b.a boP;
    private GradientDrawable boQ;
    private String boR;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.aYe = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.boP != null) {
                    AlaLiveInputEditView.this.boP.fb(AlaLiveInputEditView.this.aXO.getText().toString());
                }
                AlaLiveInputEditView.this.EV();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.boO != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aXO.getText()));
                }
                if (AlaLiveInputEditView.this.aXO.getText() != null && AlaLiveInputEditView.this.boR != null && AlaLiveInputEditView.this.aXO.getText().length() > AlaLiveInputEditView.this.boR.length()) {
                    AlaLiveInputEditView.this.aXO.setText(AlaLiveInputEditView.this.boR);
                    AlaLiveInputEditView.this.aXO.setSelection(AlaLiveInputEditView.this.aXO.getText().length());
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
        this.aYe = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.boP != null) {
                    AlaLiveInputEditView.this.boP.fb(AlaLiveInputEditView.this.aXO.getText().toString());
                }
                AlaLiveInputEditView.this.EV();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.boO != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aXO.getText()));
                }
                if (AlaLiveInputEditView.this.aXO.getText() != null && AlaLiveInputEditView.this.boR != null && AlaLiveInputEditView.this.aXO.getText().length() > AlaLiveInputEditView.this.boR.length()) {
                    AlaLiveInputEditView.this.aXO.setText(AlaLiveInputEditView.this.boR);
                    AlaLiveInputEditView.this.aXO.setSelection(AlaLiveInputEditView.this.aXO.getText().length());
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
        this.aYe = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.boP != null) {
                    AlaLiveInputEditView.this.boP.fb(AlaLiveInputEditView.this.aXO.getText().toString());
                }
                AlaLiveInputEditView.this.EV();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.boO != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aXO.getText()));
                }
                if (AlaLiveInputEditView.this.aXO.getText() != null && AlaLiveInputEditView.this.boR != null && AlaLiveInputEditView.this.aXO.getText().length() > AlaLiveInputEditView.this.boR.length()) {
                    AlaLiveInputEditView.this.aXO.setText(AlaLiveInputEditView.this.boR);
                    AlaLiveInputEditView.this.aXO.setSelection(AlaLiveInputEditView.this.aXO.getText().length());
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
        this.aXO = (EditText) findViewById(a.g.edit_text);
        this.aXO.setIncludeFontPadding(false);
        this.aXO.addTextChangedListener(this.mTextWatcher);
        this.aXO.setInputType(2);
        this.aXO.setSingleLine(true);
        this.aXO.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.aXO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.boP != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.aXO.getText())) {
                        AlaLiveInputEditView.this.boP.fb(AlaLiveInputEditView.this.aXO.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.boO = (TextView) findViewById(a.g.tv_send);
        this.boO.setOnClickListener(this.aYe);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.aXO, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.boP = aVar;
    }

    public void EV() {
        this.aXO.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.aXO.setText(str);
                this.aXO.setSelection(str.length());
            } catch (Exception e) {
                this.aXO.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.aXO.setHint(str);
    }

    public void setMaxText(String str) {
        this.boR = str;
    }

    public void setInputEditType(int i) {
        this.aXO.setInputType(i);
    }

    public EditText getEditView() {
        return this.aXO;
    }

    public TextView getTextView() {
        return this.boO;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.aXO.requestFocus();
        } else {
            this.aXO.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.aXO.removeTextChangedListener(this.mTextWatcher);
        this.aXO.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.boQ == null) {
            this.boQ = new GradientDrawable();
            this.boQ.setShape(0);
            this.boQ.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.boQ.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.boQ.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.boQ.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.boQ.clearColorFilter();
            this.boO.setTextColor(-1);
        } else {
            this.boQ.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.boO.setTextColor(-2130706433);
        }
        this.boO.setBackgroundDrawable(this.boQ);
        this.boO.setEnabled(z);
    }
}
