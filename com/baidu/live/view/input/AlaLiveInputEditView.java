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
    private EditText aOd;
    private View.OnClickListener aOo;
    private TextView bbQ;
    private b.a bbR;
    private GradientDrawable bbS;
    private String bbT;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.aOo = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bbR != null) {
                    AlaLiveInputEditView.this.bbR.em(AlaLiveInputEditView.this.aOd.getText().toString());
                }
                AlaLiveInputEditView.this.CO();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bbQ != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aOd.getText()));
                }
                if (AlaLiveInputEditView.this.aOd.getText() != null && AlaLiveInputEditView.this.bbT != null && AlaLiveInputEditView.this.aOd.getText().length() > AlaLiveInputEditView.this.bbT.length()) {
                    AlaLiveInputEditView.this.aOd.setText(AlaLiveInputEditView.this.bbT);
                    AlaLiveInputEditView.this.aOd.setSelection(AlaLiveInputEditView.this.aOd.getText().length());
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
        this.aOo = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bbR != null) {
                    AlaLiveInputEditView.this.bbR.em(AlaLiveInputEditView.this.aOd.getText().toString());
                }
                AlaLiveInputEditView.this.CO();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bbQ != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aOd.getText()));
                }
                if (AlaLiveInputEditView.this.aOd.getText() != null && AlaLiveInputEditView.this.bbT != null && AlaLiveInputEditView.this.aOd.getText().length() > AlaLiveInputEditView.this.bbT.length()) {
                    AlaLiveInputEditView.this.aOd.setText(AlaLiveInputEditView.this.bbT);
                    AlaLiveInputEditView.this.aOd.setSelection(AlaLiveInputEditView.this.aOd.getText().length());
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
        this.aOo = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bbR != null) {
                    AlaLiveInputEditView.this.bbR.em(AlaLiveInputEditView.this.aOd.getText().toString());
                }
                AlaLiveInputEditView.this.CO();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bbQ != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aOd.getText()));
                }
                if (AlaLiveInputEditView.this.aOd.getText() != null && AlaLiveInputEditView.this.bbT != null && AlaLiveInputEditView.this.aOd.getText().length() > AlaLiveInputEditView.this.bbT.length()) {
                    AlaLiveInputEditView.this.aOd.setText(AlaLiveInputEditView.this.bbT);
                    AlaLiveInputEditView.this.aOd.setSelection(AlaLiveInputEditView.this.aOd.getText().length());
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
        this.aOd = (EditText) findViewById(a.g.edit_text);
        this.aOd.setIncludeFontPadding(false);
        this.aOd.addTextChangedListener(this.mTextWatcher);
        this.aOd.setInputType(2);
        this.aOd.setSingleLine(true);
        this.aOd.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.aOd.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bbR != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.aOd.getText())) {
                        AlaLiveInputEditView.this.bbR.em(AlaLiveInputEditView.this.aOd.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bbQ = (TextView) findViewById(a.g.tv_send);
        this.bbQ.setOnClickListener(this.aOo);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.aOd, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bbR = aVar;
    }

    public void CO() {
        this.aOd.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            this.aOd.setText(str);
            this.aOd.setSelection(str.length());
        }
    }

    public void setHintText(String str) {
        this.aOd.setHint(str);
    }

    public void setMaxText(String str) {
        this.bbT = str;
    }

    public void setInputEditType(int i) {
        this.aOd.setInputType(i);
    }

    public EditText getEditView() {
        return this.aOd;
    }

    public TextView getTextView() {
        return this.bbQ;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.aOd.requestFocus();
        } else {
            this.aOd.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.aOd.removeTextChangedListener(this.mTextWatcher);
        this.aOd.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bbS == null) {
            this.bbS = new GradientDrawable();
            this.bbS.setShape(0);
            this.bbS.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.bbS.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bbS.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bbS.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bbS.clearColorFilter();
            this.bbQ.setTextColor(-1);
        } else {
            this.bbS.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bbQ.setTextColor(-2130706433);
        }
        this.bbQ.setBackgroundDrawable(this.bbS);
        this.bbQ.setEnabled(z);
    }
}
