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
    private b.a aGe;
    private GradientDrawable aGf;
    private String aGg;
    private View.OnClickListener auG;
    private EditText auy;
    private TextView mSendView;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.auG = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aGe != null) {
                    AlaLiveInputEditView.this.aGe.dw(AlaLiveInputEditView.this.auy.getText().toString());
                }
                AlaLiveInputEditView.this.xX();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.auy.getText()));
                }
                if (AlaLiveInputEditView.this.auy.getText().length() > AlaLiveInputEditView.this.aGg.length()) {
                    AlaLiveInputEditView.this.auy.setText(AlaLiveInputEditView.this.aGg);
                    AlaLiveInputEditView.this.auy.setSelection(AlaLiveInputEditView.this.auy.getText().length());
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
        this.auG = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aGe != null) {
                    AlaLiveInputEditView.this.aGe.dw(AlaLiveInputEditView.this.auy.getText().toString());
                }
                AlaLiveInputEditView.this.xX();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.auy.getText()));
                }
                if (AlaLiveInputEditView.this.auy.getText().length() > AlaLiveInputEditView.this.aGg.length()) {
                    AlaLiveInputEditView.this.auy.setText(AlaLiveInputEditView.this.aGg);
                    AlaLiveInputEditView.this.auy.setSelection(AlaLiveInputEditView.this.auy.getText().length());
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
        this.auG = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aGe != null) {
                    AlaLiveInputEditView.this.aGe.dw(AlaLiveInputEditView.this.auy.getText().toString());
                }
                AlaLiveInputEditView.this.xX();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.auy.getText()));
                }
                if (AlaLiveInputEditView.this.auy.getText().length() > AlaLiveInputEditView.this.aGg.length()) {
                    AlaLiveInputEditView.this.auy.setText(AlaLiveInputEditView.this.aGg);
                    AlaLiveInputEditView.this.auy.setSelection(AlaLiveInputEditView.this.auy.getText().length());
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
        this.auy = (EditText) findViewById(a.g.edit_text);
        this.auy.setIncludeFontPadding(false);
        this.auy.addTextChangedListener(this.mTextWatcher);
        this.auy.setInputType(2);
        this.auy.setSingleLine(true);
        this.auy.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.auy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.aGe != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.auy.getText())) {
                        AlaLiveInputEditView.this.aGe.dw(AlaLiveInputEditView.this.auy.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.mSendView = (TextView) findViewById(a.g.tv_send);
        this.mSendView.setOnClickListener(this.auG);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.auy, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.aGe = aVar;
    }

    public void xX() {
        this.auy.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            this.auy.setText(str);
            this.auy.setSelection(str.length());
        }
    }

    public void setHintText(String str) {
        this.auy.setHint(str);
    }

    public void setMaxText(String str) {
        this.aGg = str;
    }

    public void setInputEditType(int i) {
        this.auy.setInputType(i);
    }

    public EditText getEditView() {
        return this.auy;
    }

    public TextView getTextView() {
        return this.mSendView;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.auy.requestFocus();
        } else {
            this.auy.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.auy.removeTextChangedListener(this.mTextWatcher);
        this.auy.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.aGf == null) {
            this.aGf = new GradientDrawable();
            this.aGf.setShape(0);
            this.aGf.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.aGf.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.aGf.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.aGf.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.aGf.clearColorFilter();
            this.mSendView.setTextColor(-1);
        } else {
            this.aGf.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.mSendView.setTextColor(-2130706433);
        }
        this.mSendView.setBackgroundDrawable(this.aGf);
        this.mSendView.setEnabled(z);
    }
}
