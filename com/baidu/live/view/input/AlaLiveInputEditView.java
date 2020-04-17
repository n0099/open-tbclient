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
import com.baidu.live.u.a;
import com.baidu.live.view.input.b;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class AlaLiveInputEditView extends LinearLayout implements b {
    private EditText aNX;
    private View.OnClickListener aOi;
    private TextView bbL;
    private b.a bbM;
    private GradientDrawable bbN;
    private String bbO;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.aOi = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bbM != null) {
                    AlaLiveInputEditView.this.bbM.em(AlaLiveInputEditView.this.aNX.getText().toString());
                }
                AlaLiveInputEditView.this.CP();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bbL != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aNX.getText()));
                }
                if (AlaLiveInputEditView.this.aNX.getText() != null && AlaLiveInputEditView.this.bbO != null && AlaLiveInputEditView.this.aNX.getText().length() > AlaLiveInputEditView.this.bbO.length()) {
                    AlaLiveInputEditView.this.aNX.setText(AlaLiveInputEditView.this.bbO);
                    AlaLiveInputEditView.this.aNX.setSelection(AlaLiveInputEditView.this.aNX.getText().length());
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
        this.aOi = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bbM != null) {
                    AlaLiveInputEditView.this.bbM.em(AlaLiveInputEditView.this.aNX.getText().toString());
                }
                AlaLiveInputEditView.this.CP();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bbL != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aNX.getText()));
                }
                if (AlaLiveInputEditView.this.aNX.getText() != null && AlaLiveInputEditView.this.bbO != null && AlaLiveInputEditView.this.aNX.getText().length() > AlaLiveInputEditView.this.bbO.length()) {
                    AlaLiveInputEditView.this.aNX.setText(AlaLiveInputEditView.this.bbO);
                    AlaLiveInputEditView.this.aNX.setSelection(AlaLiveInputEditView.this.aNX.getText().length());
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
        this.aOi = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bbM != null) {
                    AlaLiveInputEditView.this.bbM.em(AlaLiveInputEditView.this.aNX.getText().toString());
                }
                AlaLiveInputEditView.this.CP();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bbL != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aNX.getText()));
                }
                if (AlaLiveInputEditView.this.aNX.getText() != null && AlaLiveInputEditView.this.bbO != null && AlaLiveInputEditView.this.aNX.getText().length() > AlaLiveInputEditView.this.bbO.length()) {
                    AlaLiveInputEditView.this.aNX.setText(AlaLiveInputEditView.this.bbO);
                    AlaLiveInputEditView.this.aNX.setSelection(AlaLiveInputEditView.this.aNX.getText().length());
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
        this.aNX = (EditText) findViewById(a.g.edit_text);
        this.aNX.setIncludeFontPadding(false);
        this.aNX.addTextChangedListener(this.mTextWatcher);
        this.aNX.setInputType(2);
        this.aNX.setSingleLine(true);
        this.aNX.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.aNX.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bbM != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.aNX.getText())) {
                        AlaLiveInputEditView.this.bbM.em(AlaLiveInputEditView.this.aNX.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bbL = (TextView) findViewById(a.g.tv_send);
        this.bbL.setOnClickListener(this.aOi);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.aNX, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bbM = aVar;
    }

    public void CP() {
        this.aNX.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            this.aNX.setText(str);
            this.aNX.setSelection(str.length());
        }
    }

    public void setHintText(String str) {
        this.aNX.setHint(str);
    }

    public void setMaxText(String str) {
        this.bbO = str;
    }

    public void setInputEditType(int i) {
        this.aNX.setInputType(i);
    }

    public EditText getEditView() {
        return this.aNX;
    }

    public TextView getTextView() {
        return this.bbL;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.aNX.requestFocus();
        } else {
            this.aNX.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.aNX.removeTextChangedListener(this.mTextWatcher);
        this.aNX.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bbN == null) {
            this.bbN = new GradientDrawable();
            this.bbN.setShape(0);
            this.bbN.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.bbN.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bbN.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bbN.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bbN.clearColorFilter();
            this.bbL.setTextColor(-1);
        } else {
            this.bbN.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bbL.setTextColor(-2130706433);
        }
        this.bbL.setBackgroundDrawable(this.bbN);
        this.bbL.setEnabled(z);
    }
}
