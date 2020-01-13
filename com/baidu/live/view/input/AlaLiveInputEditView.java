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
import com.baidu.live.r.a;
import com.baidu.live.view.input.b;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class AlaLiveInputEditView extends LinearLayout implements b {
    private String aBA;
    private b.a aBy;
    private GradientDrawable aBz;
    private EditText aqD;
    private View.OnClickListener aqL;
    private TextView mSendView;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.aqL = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aBy != null) {
                    AlaLiveInputEditView.this.aBy.dm(AlaLiveInputEditView.this.aqD.getText().toString());
                }
                AlaLiveInputEditView.this.vT();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aqD.getText()));
                }
                if (AlaLiveInputEditView.this.aqD.getText().length() > AlaLiveInputEditView.this.aBA.length()) {
                    AlaLiveInputEditView.this.aqD.setText(AlaLiveInputEditView.this.aBA);
                    AlaLiveInputEditView.this.aqD.setSelection(AlaLiveInputEditView.this.aqD.getText().length());
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
        this.aqL = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aBy != null) {
                    AlaLiveInputEditView.this.aBy.dm(AlaLiveInputEditView.this.aqD.getText().toString());
                }
                AlaLiveInputEditView.this.vT();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aqD.getText()));
                }
                if (AlaLiveInputEditView.this.aqD.getText().length() > AlaLiveInputEditView.this.aBA.length()) {
                    AlaLiveInputEditView.this.aqD.setText(AlaLiveInputEditView.this.aBA);
                    AlaLiveInputEditView.this.aqD.setSelection(AlaLiveInputEditView.this.aqD.getText().length());
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
        this.aqL = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aBy != null) {
                    AlaLiveInputEditView.this.aBy.dm(AlaLiveInputEditView.this.aqD.getText().toString());
                }
                AlaLiveInputEditView.this.vT();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aqD.getText()));
                }
                if (AlaLiveInputEditView.this.aqD.getText().length() > AlaLiveInputEditView.this.aBA.length()) {
                    AlaLiveInputEditView.this.aqD.setText(AlaLiveInputEditView.this.aBA);
                    AlaLiveInputEditView.this.aqD.setSelection(AlaLiveInputEditView.this.aqD.getText().length());
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
        this.aqD = (EditText) findViewById(a.g.edit_text);
        this.aqD.setIncludeFontPadding(false);
        this.aqD.addTextChangedListener(this.mTextWatcher);
        this.aqD.setInputType(2);
        this.aqD.setSingleLine(true);
        this.aqD.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.aqD.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.aBy != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.aqD.getText())) {
                        AlaLiveInputEditView.this.aBy.dm(AlaLiveInputEditView.this.aqD.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.mSendView = (TextView) findViewById(a.g.tv_send);
        this.mSendView.setOnClickListener(this.aqL);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.aqD, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.aBy = aVar;
    }

    public void vT() {
        this.aqD.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            this.aqD.setText(str);
            this.aqD.setSelection(str.length());
        }
    }

    public void setHintText(String str) {
        this.aqD.setHint(str);
    }

    public void setMaxText(String str) {
        this.aBA = str;
    }

    public void setInputEditType(int i) {
        this.aqD.setInputType(i);
    }

    public EditText getEditView() {
        return this.aqD;
    }

    public TextView getTextView() {
        return this.mSendView;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.aqD.requestFocus();
        } else {
            this.aqD.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.aqD.removeTextChangedListener(this.mTextWatcher);
        this.aqD.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.aBz == null) {
            this.aBz = new GradientDrawable();
            this.aBz.setShape(0);
            this.aBz.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.aBz.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.aBz.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.aBz.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.aBz.clearColorFilter();
            this.mSendView.setTextColor(-1);
        } else {
            this.aBz.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.mSendView.setTextColor(-2130706433);
        }
        this.mSendView.setBackgroundDrawable(this.aBz);
        this.mSendView.setEnabled(z);
    }
}
