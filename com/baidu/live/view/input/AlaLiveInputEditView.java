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
/* loaded from: classes10.dex */
public class AlaLiveInputEditView extends LinearLayout implements c {
    private TextView bRq;
    private c.a bRr;
    private GradientDrawable bRs;
    private String bRt;
    private EditText bmU;
    private View.OnClickListener bnn;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bRr != null) {
                    AlaLiveInputEditView.this.bRr.gb(AlaLiveInputEditView.this.bmU.getText().toString());
                }
                AlaLiveInputEditView.this.KC();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bRq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bmU.getText()));
                }
                if (AlaLiveInputEditView.this.bmU.getText() != null && !AlaLiveInputEditView.this.bmU.getText().toString().isEmpty() && AlaLiveInputEditView.this.bRt != null && !AlaLiveInputEditView.this.bRt.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bmU.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bRt)) {
                    AlaLiveInputEditView.this.bmU.setText(AlaLiveInputEditView.this.bRt);
                    AlaLiveInputEditView.this.bmU.setSelection(AlaLiveInputEditView.this.bmU.getText().length());
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
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bRr != null) {
                    AlaLiveInputEditView.this.bRr.gb(AlaLiveInputEditView.this.bmU.getText().toString());
                }
                AlaLiveInputEditView.this.KC();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bRq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bmU.getText()));
                }
                if (AlaLiveInputEditView.this.bmU.getText() != null && !AlaLiveInputEditView.this.bmU.getText().toString().isEmpty() && AlaLiveInputEditView.this.bRt != null && !AlaLiveInputEditView.this.bRt.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bmU.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bRt)) {
                    AlaLiveInputEditView.this.bmU.setText(AlaLiveInputEditView.this.bRt);
                    AlaLiveInputEditView.this.bmU.setSelection(AlaLiveInputEditView.this.bmU.getText().length());
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
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bRr != null) {
                    AlaLiveInputEditView.this.bRr.gb(AlaLiveInputEditView.this.bmU.getText().toString());
                }
                AlaLiveInputEditView.this.KC();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bRq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bmU.getText()));
                }
                if (AlaLiveInputEditView.this.bmU.getText() != null && !AlaLiveInputEditView.this.bmU.getText().toString().isEmpty() && AlaLiveInputEditView.this.bRt != null && !AlaLiveInputEditView.this.bRt.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.bmU.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bRt)) {
                    AlaLiveInputEditView.this.bmU.setText(AlaLiveInputEditView.this.bRt);
                    AlaLiveInputEditView.this.bmU.setSelection(AlaLiveInputEditView.this.bmU.getText().length());
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
        this.bmU = (EditText) findViewById(a.f.edit_text);
        this.bmU.setIncludeFontPadding(false);
        this.bmU.addTextChangedListener(this.mTextWatcher);
        this.bmU.setInputType(2);
        this.bmU.setSingleLine(true);
        this.bmU.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bmU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bRr != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bmU.getText())) {
                        AlaLiveInputEditView.this.bRr.gb(AlaLiveInputEditView.this.bmU.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bRq = (TextView) findViewById(a.f.tv_send);
        this.bRq.setOnClickListener(this.bnn);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bmU, Integer.valueOf(a.e.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(c.a aVar) {
        this.bRr = aVar;
    }

    public void KC() {
        this.bmU.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bmU.setText(str);
                this.bmU.setSelection(str.length());
            } catch (Exception e) {
                this.bmU.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bmU.setHint(str);
    }

    public void setMaxText(String str) {
        this.bRt = str;
    }

    public void setInputEditType(int i) {
        this.bmU.setInputType(i);
    }

    public EditText getEditView() {
        return this.bmU;
    }

    public TextView getTextView() {
        return this.bRq;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bmU.requestFocus();
        } else {
            this.bmU.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bmU.removeTextChangedListener(this.mTextWatcher);
        this.bmU.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bRs == null) {
            this.bRs = new GradientDrawable();
            this.bRs.setShape(0);
            this.bRs.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds32));
            this.bRs.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bRs.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bRs.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bRs.clearColorFilter();
            this.bRq.setTextColor(-1);
        } else {
            this.bRs.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bRq.setTextColor(-2130706433);
        }
        this.bRq.setBackgroundDrawable(this.bRs);
        this.bRq.setEnabled(z);
    }
}
