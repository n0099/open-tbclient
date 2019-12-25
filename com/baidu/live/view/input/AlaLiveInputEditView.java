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
import com.baidu.live.q.a;
import com.baidu.live.view.input.b;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class AlaLiveInputEditView extends LinearLayout implements b {
    private b.a aAL;
    private GradientDrawable aAM;
    private String aAN;
    private EditText apR;
    private View.OnClickListener apZ;
    private TextView mSendView;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.apZ = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aAL != null) {
                    AlaLiveInputEditView.this.aAL.dk(AlaLiveInputEditView.this.apR.getText().toString());
                }
                AlaLiveInputEditView.this.vC();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.apR.getText()));
                }
                if (AlaLiveInputEditView.this.apR.getText().length() > AlaLiveInputEditView.this.aAN.length()) {
                    AlaLiveInputEditView.this.apR.setText(AlaLiveInputEditView.this.aAN);
                    AlaLiveInputEditView.this.apR.setSelection(AlaLiveInputEditView.this.apR.getText().length());
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
        this.apZ = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aAL != null) {
                    AlaLiveInputEditView.this.aAL.dk(AlaLiveInputEditView.this.apR.getText().toString());
                }
                AlaLiveInputEditView.this.vC();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.apR.getText()));
                }
                if (AlaLiveInputEditView.this.apR.getText().length() > AlaLiveInputEditView.this.aAN.length()) {
                    AlaLiveInputEditView.this.apR.setText(AlaLiveInputEditView.this.aAN);
                    AlaLiveInputEditView.this.apR.setSelection(AlaLiveInputEditView.this.apR.getText().length());
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
        this.apZ = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aAL != null) {
                    AlaLiveInputEditView.this.aAL.dk(AlaLiveInputEditView.this.apR.getText().toString());
                }
                AlaLiveInputEditView.this.vC();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.apR.getText()));
                }
                if (AlaLiveInputEditView.this.apR.getText().length() > AlaLiveInputEditView.this.aAN.length()) {
                    AlaLiveInputEditView.this.apR.setText(AlaLiveInputEditView.this.aAN);
                    AlaLiveInputEditView.this.apR.setSelection(AlaLiveInputEditView.this.apR.getText().length());
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
        this.apR = (EditText) findViewById(a.g.edit_text);
        this.apR.setIncludeFontPadding(false);
        this.apR.addTextChangedListener(this.mTextWatcher);
        this.apR.setInputType(2);
        this.apR.setSingleLine(true);
        this.apR.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.apR.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.aAL != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.apR.getText())) {
                        AlaLiveInputEditView.this.aAL.dk(AlaLiveInputEditView.this.apR.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.mSendView = (TextView) findViewById(a.g.tv_send);
        this.mSendView.setOnClickListener(this.apZ);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.apR, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.aAL = aVar;
    }

    public void vC() {
        this.apR.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            this.apR.setText(str);
            this.apR.setSelection(str.length());
        }
    }

    public void setHintText(String str) {
        this.apR.setHint(str);
    }

    public void setMaxText(String str) {
        this.aAN = str;
    }

    public void setInputEditType(int i) {
        this.apR.setInputType(i);
    }

    public EditText getEditView() {
        return this.apR;
    }

    public TextView getTextView() {
        return this.mSendView;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.apR.requestFocus();
        } else {
            this.apR.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.apR.removeTextChangedListener(this.mTextWatcher);
        this.apR.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.aAM == null) {
            this.aAM = new GradientDrawable();
            this.aAM.setShape(0);
            this.aAM.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.aAM.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.aAM.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.aAM.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.aAM.clearColorFilter();
            this.mSendView.setTextColor(-1);
        } else {
            this.aAM.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.mSendView.setTextColor(-2130706433);
        }
        this.mSendView.setBackgroundDrawable(this.aAM);
        this.mSendView.setEnabled(z);
    }
}
