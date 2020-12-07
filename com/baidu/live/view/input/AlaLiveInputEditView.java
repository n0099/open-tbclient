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
import com.baidu.live.view.input.c;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class AlaLiveInputEditView extends LinearLayout implements c {
    private TextView bQv;
    private c.a bQw;
    private GradientDrawable bQx;
    private String bQy;
    private EditText bpY;
    private View.OnClickListener bqo;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bqo = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bQw != null) {
                    AlaLiveInputEditView.this.bQw.hC(AlaLiveInputEditView.this.bpY.getText().toString());
                }
                AlaLiveInputEditView.this.OS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bQv != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bpY.getText()));
                }
                if (AlaLiveInputEditView.this.bpY.getText() != null && !AlaLiveInputEditView.this.bpY.getText().toString().isEmpty() && AlaLiveInputEditView.this.bQy != null && !AlaLiveInputEditView.this.bQy.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bpY.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bQy)) {
                    AlaLiveInputEditView.this.bpY.setText(AlaLiveInputEditView.this.bQy);
                    AlaLiveInputEditView.this.bpY.setSelection(AlaLiveInputEditView.this.bpY.getText().length());
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
        this.bqo = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bQw != null) {
                    AlaLiveInputEditView.this.bQw.hC(AlaLiveInputEditView.this.bpY.getText().toString());
                }
                AlaLiveInputEditView.this.OS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bQv != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bpY.getText()));
                }
                if (AlaLiveInputEditView.this.bpY.getText() != null && !AlaLiveInputEditView.this.bpY.getText().toString().isEmpty() && AlaLiveInputEditView.this.bQy != null && !AlaLiveInputEditView.this.bQy.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bpY.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bQy)) {
                    AlaLiveInputEditView.this.bpY.setText(AlaLiveInputEditView.this.bQy);
                    AlaLiveInputEditView.this.bpY.setSelection(AlaLiveInputEditView.this.bpY.getText().length());
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
        this.bqo = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bQw != null) {
                    AlaLiveInputEditView.this.bQw.hC(AlaLiveInputEditView.this.bpY.getText().toString());
                }
                AlaLiveInputEditView.this.OS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bQv != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bpY.getText()));
                }
                if (AlaLiveInputEditView.this.bpY.getText() != null && !AlaLiveInputEditView.this.bpY.getText().toString().isEmpty() && AlaLiveInputEditView.this.bQy != null && !AlaLiveInputEditView.this.bQy.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bpY.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bQy)) {
                    AlaLiveInputEditView.this.bpY.setText(AlaLiveInputEditView.this.bQy);
                    AlaLiveInputEditView.this.bpY.setSelection(AlaLiveInputEditView.this.bpY.getText().length());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.sdk_live_input_edit_view, this);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-15329245);
        float dimensionPixelOffset3 = getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset3, dimensionPixelOffset3, dimensionPixelOffset3, dimensionPixelOffset3, 0.0f, 0.0f, 0.0f, 0.0f});
        setBackgroundDrawable(gradientDrawable);
        this.bpY = (EditText) findViewById(a.f.edit_text);
        this.bpY.setIncludeFontPadding(false);
        this.bpY.addTextChangedListener(this.mTextWatcher);
        this.bpY.setInputType(2);
        this.bpY.setSingleLine(true);
        this.bpY.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bpY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bQw != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bpY.getText())) {
                        AlaLiveInputEditView.this.bQw.hC(AlaLiveInputEditView.this.bpY.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bQv = (TextView) findViewById(a.f.tv_send);
        this.bQv.setOnClickListener(this.bqo);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bpY, Integer.valueOf(a.e.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(c.a aVar) {
        this.bQw = aVar;
    }

    public void OS() {
        this.bpY.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bpY.setText(str);
                this.bpY.setSelection(str.length());
            } catch (Exception e) {
                this.bpY.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bpY.setHint(str);
    }

    public void setMaxText(String str) {
        this.bQy = str;
    }

    public void setInputEditType(int i) {
        this.bpY.setInputType(i);
    }

    public EditText getEditView() {
        return this.bpY;
    }

    public TextView getTextView() {
        return this.bQv;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bpY.requestFocus();
        } else {
            this.bpY.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bpY.removeTextChangedListener(this.mTextWatcher);
        this.bpY.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bQx == null) {
            this.bQx = new GradientDrawable();
            this.bQx.setShape(0);
            this.bQx.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds32));
            this.bQx.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bQx.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bQx.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bQx.clearColorFilter();
            this.bQv.setTextColor(-1);
        } else {
            this.bQx.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bQv.setTextColor(-2130706433);
        }
        this.bQv.setBackgroundDrawable(this.bQx);
        this.bQv.setEnabled(z);
    }
}
