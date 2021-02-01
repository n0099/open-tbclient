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
/* loaded from: classes11.dex */
public class AlaLiveInputEditView extends LinearLayout implements c {
    private TextView bUX;
    private c.a bUY;
    private GradientDrawable bUZ;
    private String bVa;
    private View.OnClickListener bqO;
    private EditText bqv;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bUY != null) {
                    AlaLiveInputEditView.this.bUY.gz(AlaLiveInputEditView.this.bqv.getText().toString());
                }
                AlaLiveInputEditView.this.Ma();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bUX != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bqv.getText()));
                }
                try {
                    if (AlaLiveInputEditView.this.bqv.getText() != null && !AlaLiveInputEditView.this.bqv.getText().toString().isEmpty() && AlaLiveInputEditView.this.bVa != null && !AlaLiveInputEditView.this.bVa.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bqv.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bVa)) {
                        AlaLiveInputEditView.this.bqv.setText(AlaLiveInputEditView.this.bVa);
                        AlaLiveInputEditView.this.bqv.setSelection(AlaLiveInputEditView.this.bqv.getText().length());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
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
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bUY != null) {
                    AlaLiveInputEditView.this.bUY.gz(AlaLiveInputEditView.this.bqv.getText().toString());
                }
                AlaLiveInputEditView.this.Ma();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bUX != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bqv.getText()));
                }
                try {
                    if (AlaLiveInputEditView.this.bqv.getText() != null && !AlaLiveInputEditView.this.bqv.getText().toString().isEmpty() && AlaLiveInputEditView.this.bVa != null && !AlaLiveInputEditView.this.bVa.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bqv.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bVa)) {
                        AlaLiveInputEditView.this.bqv.setText(AlaLiveInputEditView.this.bVa);
                        AlaLiveInputEditView.this.bqv.setSelection(AlaLiveInputEditView.this.bqv.getText().length());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
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
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bUY != null) {
                    AlaLiveInputEditView.this.bUY.gz(AlaLiveInputEditView.this.bqv.getText().toString());
                }
                AlaLiveInputEditView.this.Ma();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bUX != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bqv.getText()));
                }
                try {
                    if (AlaLiveInputEditView.this.bqv.getText() != null && !AlaLiveInputEditView.this.bqv.getText().toString().isEmpty() && AlaLiveInputEditView.this.bVa != null && !AlaLiveInputEditView.this.bVa.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bqv.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bVa)) {
                        AlaLiveInputEditView.this.bqv.setText(AlaLiveInputEditView.this.bVa);
                        AlaLiveInputEditView.this.bqv.setSelection(AlaLiveInputEditView.this.bqv.getText().length());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
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
        this.bqv = (EditText) findViewById(a.f.edit_text);
        this.bqv.setIncludeFontPadding(false);
        this.bqv.addTextChangedListener(this.mTextWatcher);
        this.bqv.setInputType(2);
        this.bqv.setSingleLine(true);
        this.bqv.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bqv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bUY != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bqv.getText())) {
                        AlaLiveInputEditView.this.bUY.gz(AlaLiveInputEditView.this.bqv.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bUX = (TextView) findViewById(a.f.tv_send);
        this.bUX.setOnClickListener(this.bqO);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bqv, Integer.valueOf(a.e.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(c.a aVar) {
        this.bUY = aVar;
    }

    public void Ma() {
        this.bqv.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bqv.setText(str);
                this.bqv.setSelection(str.length());
            } catch (Exception e) {
                this.bqv.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bqv.setHint(str);
    }

    public void setMaxText(String str) {
        this.bVa = str;
    }

    public void setInputEditType(int i) {
        this.bqv.setInputType(i);
    }

    public EditText getEditView() {
        return this.bqv;
    }

    public TextView getTextView() {
        return this.bUX;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bqv.requestFocus();
        } else {
            this.bqv.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bqv.removeTextChangedListener(this.mTextWatcher);
        this.bqv.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bUZ == null) {
            this.bUZ = new GradientDrawable();
            this.bUZ.setShape(0);
            this.bUZ.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds32));
            this.bUZ.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bUZ.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bUZ.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bUZ.clearColorFilter();
            this.bUX.setTextColor(-1);
        } else {
            this.bUZ.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bUX.setTextColor(-2130706433);
        }
        this.bUX.setBackgroundDrawable(this.bUZ);
        this.bUX.setEnabled(z);
    }
}
