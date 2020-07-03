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
/* loaded from: classes3.dex */
public class AlaLiveInputEditView extends LinearLayout implements b {
    private EditText aWR;
    private View.OnClickListener aXc;
    private TextView bot;
    private b.a bou;
    private GradientDrawable bov;
    private String bow;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.aXc = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bou != null) {
                    AlaLiveInputEditView.this.bou.fc(AlaLiveInputEditView.this.aWR.getText().toString());
                }
                AlaLiveInputEditView.this.EO();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bot != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aWR.getText()));
                }
                if (AlaLiveInputEditView.this.aWR.getText() != null && AlaLiveInputEditView.this.bow != null && AlaLiveInputEditView.this.aWR.getText().length() > AlaLiveInputEditView.this.bow.length()) {
                    AlaLiveInputEditView.this.aWR.setText(AlaLiveInputEditView.this.bow);
                    AlaLiveInputEditView.this.aWR.setSelection(AlaLiveInputEditView.this.aWR.getText().length());
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
        this.aXc = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bou != null) {
                    AlaLiveInputEditView.this.bou.fc(AlaLiveInputEditView.this.aWR.getText().toString());
                }
                AlaLiveInputEditView.this.EO();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bot != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aWR.getText()));
                }
                if (AlaLiveInputEditView.this.aWR.getText() != null && AlaLiveInputEditView.this.bow != null && AlaLiveInputEditView.this.aWR.getText().length() > AlaLiveInputEditView.this.bow.length()) {
                    AlaLiveInputEditView.this.aWR.setText(AlaLiveInputEditView.this.bow);
                    AlaLiveInputEditView.this.aWR.setSelection(AlaLiveInputEditView.this.aWR.getText().length());
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
        this.aXc = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bou != null) {
                    AlaLiveInputEditView.this.bou.fc(AlaLiveInputEditView.this.aWR.getText().toString());
                }
                AlaLiveInputEditView.this.EO();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bot != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aWR.getText()));
                }
                if (AlaLiveInputEditView.this.aWR.getText() != null && AlaLiveInputEditView.this.bow != null && AlaLiveInputEditView.this.aWR.getText().length() > AlaLiveInputEditView.this.bow.length()) {
                    AlaLiveInputEditView.this.aWR.setText(AlaLiveInputEditView.this.bow);
                    AlaLiveInputEditView.this.aWR.setSelection(AlaLiveInputEditView.this.aWR.getText().length());
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
        this.aWR = (EditText) findViewById(a.g.edit_text);
        this.aWR.setIncludeFontPadding(false);
        this.aWR.addTextChangedListener(this.mTextWatcher);
        this.aWR.setInputType(2);
        this.aWR.setSingleLine(true);
        this.aWR.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.aWR.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bou != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.aWR.getText())) {
                        AlaLiveInputEditView.this.bou.fc(AlaLiveInputEditView.this.aWR.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bot = (TextView) findViewById(a.g.tv_send);
        this.bot.setOnClickListener(this.aXc);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.aWR, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bou = aVar;
    }

    public void EO() {
        this.aWR.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.aWR.setText(str);
                this.aWR.setSelection(str.length());
            } catch (Exception e) {
                this.aWR.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.aWR.setHint(str);
    }

    public void setMaxText(String str) {
        this.bow = str;
    }

    public void setInputEditType(int i) {
        this.aWR.setInputType(i);
    }

    public EditText getEditView() {
        return this.aWR;
    }

    public TextView getTextView() {
        return this.bot;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.aWR.requestFocus();
        } else {
            this.aWR.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.aWR.removeTextChangedListener(this.mTextWatcher);
        this.aWR.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bov == null) {
            this.bov = new GradientDrawable();
            this.bov.setShape(0);
            this.bov.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.bov.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bov.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bov.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bov.clearColorFilter();
            this.bot.setTextColor(-1);
        } else {
            this.bov.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bot.setTextColor(-2130706433);
        }
        this.bot.setBackgroundDrawable(this.bov);
        this.bot.setEnabled(z);
    }
}
