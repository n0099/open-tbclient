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
    private TextView bEw;
    private b.a bEx;
    private GradientDrawable bEy;
    private String bEz;
    private EditText bjL;
    private View.OnClickListener bkc;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bkc = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bEx != null) {
                    AlaLiveInputEditView.this.bEx.gV(AlaLiveInputEditView.this.bjL.getText().toString());
                }
                AlaLiveInputEditView.this.Mm();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bEw != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bjL.getText()));
                }
                if (AlaLiveInputEditView.this.bjL.getText() != null && AlaLiveInputEditView.this.bEz != null && AlaLiveInputEditView.this.bjL.getText().length() > AlaLiveInputEditView.this.bEz.length()) {
                    AlaLiveInputEditView.this.bjL.setText(AlaLiveInputEditView.this.bEz);
                    AlaLiveInputEditView.this.bjL.setSelection(AlaLiveInputEditView.this.bjL.getText().length());
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
        this.bkc = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bEx != null) {
                    AlaLiveInputEditView.this.bEx.gV(AlaLiveInputEditView.this.bjL.getText().toString());
                }
                AlaLiveInputEditView.this.Mm();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bEw != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bjL.getText()));
                }
                if (AlaLiveInputEditView.this.bjL.getText() != null && AlaLiveInputEditView.this.bEz != null && AlaLiveInputEditView.this.bjL.getText().length() > AlaLiveInputEditView.this.bEz.length()) {
                    AlaLiveInputEditView.this.bjL.setText(AlaLiveInputEditView.this.bEz);
                    AlaLiveInputEditView.this.bjL.setSelection(AlaLiveInputEditView.this.bjL.getText().length());
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
        this.bkc = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bEx != null) {
                    AlaLiveInputEditView.this.bEx.gV(AlaLiveInputEditView.this.bjL.getText().toString());
                }
                AlaLiveInputEditView.this.Mm();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bEw != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bjL.getText()));
                }
                if (AlaLiveInputEditView.this.bjL.getText() != null && AlaLiveInputEditView.this.bEz != null && AlaLiveInputEditView.this.bjL.getText().length() > AlaLiveInputEditView.this.bEz.length()) {
                    AlaLiveInputEditView.this.bjL.setText(AlaLiveInputEditView.this.bEz);
                    AlaLiveInputEditView.this.bjL.setSelection(AlaLiveInputEditView.this.bjL.getText().length());
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
        this.bjL = (EditText) findViewById(a.g.edit_text);
        this.bjL.setIncludeFontPadding(false);
        this.bjL.addTextChangedListener(this.mTextWatcher);
        this.bjL.setInputType(2);
        this.bjL.setSingleLine(true);
        this.bjL.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bjL.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bEx != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bjL.getText())) {
                        AlaLiveInputEditView.this.bEx.gV(AlaLiveInputEditView.this.bjL.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bEw = (TextView) findViewById(a.g.tv_send);
        this.bEw.setOnClickListener(this.bkc);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bjL, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bEx = aVar;
    }

    public void Mm() {
        this.bjL.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bjL.setText(str);
                this.bjL.setSelection(str.length());
            } catch (Exception e) {
                this.bjL.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bjL.setHint(str);
    }

    public void setMaxText(String str) {
        this.bEz = str;
    }

    public void setInputEditType(int i) {
        this.bjL.setInputType(i);
    }

    public EditText getEditView() {
        return this.bjL;
    }

    public TextView getTextView() {
        return this.bEw;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bjL.requestFocus();
        } else {
            this.bjL.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bjL.removeTextChangedListener(this.mTextWatcher);
        this.bjL.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bEy == null) {
            this.bEy = new GradientDrawable();
            this.bEy.setShape(0);
            this.bEy.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.bEy.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bEy.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bEy.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bEy.clearColorFilter();
            this.bEw.setTextColor(-1);
        } else {
            this.bEy.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bEw.setTextColor(-2130706433);
        }
        this.bEw.setBackgroundDrawable(this.bEy);
        this.bEw.setEnabled(z);
    }
}
