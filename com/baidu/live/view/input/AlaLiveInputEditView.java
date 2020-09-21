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
    private EditText bfV;
    private View.OnClickListener bgm;
    private TextView bxT;
    private b.a bxU;
    private GradientDrawable bxV;
    private String bxW;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bgm = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bxU != null) {
                    AlaLiveInputEditView.this.bxU.gH(AlaLiveInputEditView.this.bfV.getText().toString());
                }
                AlaLiveInputEditView.this.Lh();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bxT != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bfV.getText()));
                }
                if (AlaLiveInputEditView.this.bfV.getText() != null && AlaLiveInputEditView.this.bxW != null && AlaLiveInputEditView.this.bfV.getText().length() > AlaLiveInputEditView.this.bxW.length()) {
                    AlaLiveInputEditView.this.bfV.setText(AlaLiveInputEditView.this.bxW);
                    AlaLiveInputEditView.this.bfV.setSelection(AlaLiveInputEditView.this.bfV.getText().length());
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
        this.bgm = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bxU != null) {
                    AlaLiveInputEditView.this.bxU.gH(AlaLiveInputEditView.this.bfV.getText().toString());
                }
                AlaLiveInputEditView.this.Lh();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bxT != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bfV.getText()));
                }
                if (AlaLiveInputEditView.this.bfV.getText() != null && AlaLiveInputEditView.this.bxW != null && AlaLiveInputEditView.this.bfV.getText().length() > AlaLiveInputEditView.this.bxW.length()) {
                    AlaLiveInputEditView.this.bfV.setText(AlaLiveInputEditView.this.bxW);
                    AlaLiveInputEditView.this.bfV.setSelection(AlaLiveInputEditView.this.bfV.getText().length());
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
        this.bgm = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bxU != null) {
                    AlaLiveInputEditView.this.bxU.gH(AlaLiveInputEditView.this.bfV.getText().toString());
                }
                AlaLiveInputEditView.this.Lh();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bxT != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bfV.getText()));
                }
                if (AlaLiveInputEditView.this.bfV.getText() != null && AlaLiveInputEditView.this.bxW != null && AlaLiveInputEditView.this.bfV.getText().length() > AlaLiveInputEditView.this.bxW.length()) {
                    AlaLiveInputEditView.this.bfV.setText(AlaLiveInputEditView.this.bxW);
                    AlaLiveInputEditView.this.bfV.setSelection(AlaLiveInputEditView.this.bfV.getText().length());
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
        this.bfV = (EditText) findViewById(a.g.edit_text);
        this.bfV.setIncludeFontPadding(false);
        this.bfV.addTextChangedListener(this.mTextWatcher);
        this.bfV.setInputType(2);
        this.bfV.setSingleLine(true);
        this.bfV.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bfV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bxU != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bfV.getText())) {
                        AlaLiveInputEditView.this.bxU.gH(AlaLiveInputEditView.this.bfV.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bxT = (TextView) findViewById(a.g.tv_send);
        this.bxT.setOnClickListener(this.bgm);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bfV, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bxU = aVar;
    }

    public void Lh() {
        this.bfV.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bfV.setText(str);
                this.bfV.setSelection(str.length());
            } catch (Exception e) {
                this.bfV.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bfV.setHint(str);
    }

    public void setMaxText(String str) {
        this.bxW = str;
    }

    public void setInputEditType(int i) {
        this.bfV.setInputType(i);
    }

    public EditText getEditView() {
        return this.bfV;
    }

    public TextView getTextView() {
        return this.bxT;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bfV.requestFocus();
        } else {
            this.bfV.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bfV.removeTextChangedListener(this.mTextWatcher);
        this.bfV.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bxV == null) {
            this.bxV = new GradientDrawable();
            this.bxV.setShape(0);
            this.bxV.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.bxV.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bxV.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bxV.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bxV.clearColorFilter();
            this.bxT.setTextColor(-1);
        } else {
            this.bxV.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bxT.setTextColor(-2130706433);
        }
        this.bxT.setBackgroundDrawable(this.bxV);
        this.bxT.setEnabled(z);
    }
}
