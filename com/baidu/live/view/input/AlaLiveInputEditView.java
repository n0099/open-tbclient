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
    private TextView bLq;
    private b.a bLr;
    private GradientDrawable bLs;
    private String bLt;
    private EditText bkP;
    private View.OnClickListener blg;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.blg = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bLr != null) {
                    AlaLiveInputEditView.this.bLr.hh(AlaLiveInputEditView.this.bkP.getText().toString());
                }
                AlaLiveInputEditView.this.Mx();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bLq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bkP.getText()));
                }
                if (AlaLiveInputEditView.this.bkP.getText() != null && AlaLiveInputEditView.this.bLt != null && AlaLiveInputEditView.this.bkP.getText().length() > AlaLiveInputEditView.this.bLt.length()) {
                    AlaLiveInputEditView.this.bkP.setText(AlaLiveInputEditView.this.bLt);
                    AlaLiveInputEditView.this.bkP.setSelection(AlaLiveInputEditView.this.bkP.getText().length());
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
        this.blg = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bLr != null) {
                    AlaLiveInputEditView.this.bLr.hh(AlaLiveInputEditView.this.bkP.getText().toString());
                }
                AlaLiveInputEditView.this.Mx();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bLq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bkP.getText()));
                }
                if (AlaLiveInputEditView.this.bkP.getText() != null && AlaLiveInputEditView.this.bLt != null && AlaLiveInputEditView.this.bkP.getText().length() > AlaLiveInputEditView.this.bLt.length()) {
                    AlaLiveInputEditView.this.bkP.setText(AlaLiveInputEditView.this.bLt);
                    AlaLiveInputEditView.this.bkP.setSelection(AlaLiveInputEditView.this.bkP.getText().length());
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
        this.blg = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bLr != null) {
                    AlaLiveInputEditView.this.bLr.hh(AlaLiveInputEditView.this.bkP.getText().toString());
                }
                AlaLiveInputEditView.this.Mx();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bLq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bkP.getText()));
                }
                if (AlaLiveInputEditView.this.bkP.getText() != null && AlaLiveInputEditView.this.bLt != null && AlaLiveInputEditView.this.bkP.getText().length() > AlaLiveInputEditView.this.bLt.length()) {
                    AlaLiveInputEditView.this.bkP.setText(AlaLiveInputEditView.this.bLt);
                    AlaLiveInputEditView.this.bkP.setSelection(AlaLiveInputEditView.this.bkP.getText().length());
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
        this.bkP = (EditText) findViewById(a.f.edit_text);
        this.bkP.setIncludeFontPadding(false);
        this.bkP.addTextChangedListener(this.mTextWatcher);
        this.bkP.setInputType(2);
        this.bkP.setSingleLine(true);
        this.bkP.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bkP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bLr != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bkP.getText())) {
                        AlaLiveInputEditView.this.bLr.hh(AlaLiveInputEditView.this.bkP.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bLq = (TextView) findViewById(a.f.tv_send);
        this.bLq.setOnClickListener(this.blg);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bkP, Integer.valueOf(a.e.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bLr = aVar;
    }

    public void Mx() {
        this.bkP.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bkP.setText(str);
                this.bkP.setSelection(str.length());
            } catch (Exception e) {
                this.bkP.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bkP.setHint(str);
    }

    public void setMaxText(String str) {
        this.bLt = str;
    }

    public void setInputEditType(int i) {
        this.bkP.setInputType(i);
    }

    public EditText getEditView() {
        return this.bkP;
    }

    public TextView getTextView() {
        return this.bLq;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bkP.requestFocus();
        } else {
            this.bkP.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bkP.removeTextChangedListener(this.mTextWatcher);
        this.bkP.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bLs == null) {
            this.bLs = new GradientDrawable();
            this.bLs.setShape(0);
            this.bLs.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds32));
            this.bLs.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bLs.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bLs.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bLs.clearColorFilter();
            this.bLq.setTextColor(-1);
        } else {
            this.bLs.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bLq.setTextColor(-2130706433);
        }
        this.bLq.setBackgroundDrawable(this.bLs);
        this.bLq.setEnabled(z);
    }
}
