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
    private TextView bNa;
    private b.a bNb;
    private GradientDrawable bNc;
    private String bNd;
    private EditText bmA;
    private View.OnClickListener bmR;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bmR = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bNb != null) {
                    AlaLiveInputEditView.this.bNb.hn(AlaLiveInputEditView.this.bmA.getText().toString());
                }
                AlaLiveInputEditView.this.Ng();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bNa != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bmA.getText()));
                }
                if (AlaLiveInputEditView.this.bmA.getText() != null && AlaLiveInputEditView.this.bNd != null && AlaLiveInputEditView.this.bmA.getText().length() > AlaLiveInputEditView.this.bNd.length()) {
                    AlaLiveInputEditView.this.bmA.setText(AlaLiveInputEditView.this.bNd);
                    AlaLiveInputEditView.this.bmA.setSelection(AlaLiveInputEditView.this.bmA.getText().length());
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
        this.bmR = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bNb != null) {
                    AlaLiveInputEditView.this.bNb.hn(AlaLiveInputEditView.this.bmA.getText().toString());
                }
                AlaLiveInputEditView.this.Ng();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bNa != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bmA.getText()));
                }
                if (AlaLiveInputEditView.this.bmA.getText() != null && AlaLiveInputEditView.this.bNd != null && AlaLiveInputEditView.this.bmA.getText().length() > AlaLiveInputEditView.this.bNd.length()) {
                    AlaLiveInputEditView.this.bmA.setText(AlaLiveInputEditView.this.bNd);
                    AlaLiveInputEditView.this.bmA.setSelection(AlaLiveInputEditView.this.bmA.getText().length());
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
        this.bmR = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bNb != null) {
                    AlaLiveInputEditView.this.bNb.hn(AlaLiveInputEditView.this.bmA.getText().toString());
                }
                AlaLiveInputEditView.this.Ng();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bNa != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bmA.getText()));
                }
                if (AlaLiveInputEditView.this.bmA.getText() != null && AlaLiveInputEditView.this.bNd != null && AlaLiveInputEditView.this.bmA.getText().length() > AlaLiveInputEditView.this.bNd.length()) {
                    AlaLiveInputEditView.this.bmA.setText(AlaLiveInputEditView.this.bNd);
                    AlaLiveInputEditView.this.bmA.setSelection(AlaLiveInputEditView.this.bmA.getText().length());
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
        this.bmA = (EditText) findViewById(a.f.edit_text);
        this.bmA.setIncludeFontPadding(false);
        this.bmA.addTextChangedListener(this.mTextWatcher);
        this.bmA.setInputType(2);
        this.bmA.setSingleLine(true);
        this.bmA.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bmA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bNb != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bmA.getText())) {
                        AlaLiveInputEditView.this.bNb.hn(AlaLiveInputEditView.this.bmA.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bNa = (TextView) findViewById(a.f.tv_send);
        this.bNa.setOnClickListener(this.bmR);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bmA, Integer.valueOf(a.e.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bNb = aVar;
    }

    public void Ng() {
        this.bmA.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bmA.setText(str);
                this.bmA.setSelection(str.length());
            } catch (Exception e) {
                this.bmA.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bmA.setHint(str);
    }

    public void setMaxText(String str) {
        this.bNd = str;
    }

    public void setInputEditType(int i) {
        this.bmA.setInputType(i);
    }

    public EditText getEditView() {
        return this.bmA;
    }

    public TextView getTextView() {
        return this.bNa;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bmA.requestFocus();
        } else {
            this.bmA.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bmA.removeTextChangedListener(this.mTextWatcher);
        this.bmA.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bNc == null) {
            this.bNc = new GradientDrawable();
            this.bNc.setShape(0);
            this.bNc.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds32));
            this.bNc.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bNc.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bNc.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bNc.clearColorFilter();
            this.bNa.setTextColor(-1);
        } else {
            this.bNc.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bNa.setTextColor(-2130706433);
        }
        this.bNa.setBackgroundDrawable(this.bNc);
        this.bNa.setEnabled(z);
    }
}
