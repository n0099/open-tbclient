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
import com.baidu.live.k.a;
import com.baidu.live.view.input.b;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class AlaLiveInputEditView extends LinearLayout implements b {
    private EditText ahP;
    private View.OnClickListener ahY;
    private TextView asQ;
    private b.a asR;
    private GradientDrawable asS;
    private String asT;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.ahY = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.asR != null) {
                    AlaLiveInputEditView.this.asR.cs(AlaLiveInputEditView.this.ahP.getText().toString());
                }
                AlaLiveInputEditView.this.tI();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.asQ != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.ahP.getText()));
                }
                if (AlaLiveInputEditView.this.ahP.getText().length() > AlaLiveInputEditView.this.asT.length()) {
                    AlaLiveInputEditView.this.ahP.setText(AlaLiveInputEditView.this.asT);
                    AlaLiveInputEditView.this.ahP.setSelection(AlaLiveInputEditView.this.ahP.getText().length());
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
        this.ahY = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.asR != null) {
                    AlaLiveInputEditView.this.asR.cs(AlaLiveInputEditView.this.ahP.getText().toString());
                }
                AlaLiveInputEditView.this.tI();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.asQ != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.ahP.getText()));
                }
                if (AlaLiveInputEditView.this.ahP.getText().length() > AlaLiveInputEditView.this.asT.length()) {
                    AlaLiveInputEditView.this.ahP.setText(AlaLiveInputEditView.this.asT);
                    AlaLiveInputEditView.this.ahP.setSelection(AlaLiveInputEditView.this.ahP.getText().length());
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
        this.ahY = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.asR != null) {
                    AlaLiveInputEditView.this.asR.cs(AlaLiveInputEditView.this.ahP.getText().toString());
                }
                AlaLiveInputEditView.this.tI();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.asQ != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.ahP.getText()));
                }
                if (AlaLiveInputEditView.this.ahP.getText().length() > AlaLiveInputEditView.this.asT.length()) {
                    AlaLiveInputEditView.this.ahP.setText(AlaLiveInputEditView.this.asT);
                    AlaLiveInputEditView.this.ahP.setSelection(AlaLiveInputEditView.this.ahP.getText().length());
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
        this.ahP = (EditText) findViewById(a.g.edit_text);
        this.ahP.setIncludeFontPadding(false);
        this.ahP.addTextChangedListener(this.mTextWatcher);
        this.ahP.setInputType(2);
        this.ahP.setSingleLine(true);
        this.ahP.setImeOptions(268435460);
        this.ahP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.asR != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.ahP.getText())) {
                        AlaLiveInputEditView.this.asR.cs(AlaLiveInputEditView.this.ahP.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.asQ = (TextView) findViewById(a.g.tv_send);
        this.asQ.setOnClickListener(this.ahY);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.ahP, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.asR = aVar;
    }

    public void tI() {
        this.ahP.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            this.ahP.setText(str);
            this.ahP.setSelection(str.length());
        }
    }

    public void setHintText(String str) {
        this.ahP.setHint(str);
    }

    public void setMaxText(String str) {
        this.asT = str;
    }

    public void setInputEditType(int i) {
        this.ahP.setInputType(i);
    }

    public EditText getEditView() {
        return this.ahP;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.ahP.requestFocus();
        } else {
            this.ahP.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendEnabled(boolean z) {
        if (this.asS == null) {
            this.asS = new GradientDrawable();
            this.asS.setShape(0);
            this.asS.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.asS.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.asS.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.asS.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.asS.clearColorFilter();
            this.asQ.setTextColor(-1);
        } else {
            this.asS.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.asQ.setTextColor(-2130706433);
        }
        this.asQ.setBackgroundDrawable(this.asS);
        this.asQ.setEnabled(z);
    }
}
