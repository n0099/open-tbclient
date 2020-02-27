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
    private b.a aFO;
    private GradientDrawable aFP;
    private String aFQ;
    private EditText aun;
    private View.OnClickListener auv;
    private TextView mSendView;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.auv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aFO != null) {
                    AlaLiveInputEditView.this.aFO.dx(AlaLiveInputEditView.this.aun.getText().toString());
                }
                AlaLiveInputEditView.this.xS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aun.getText()));
                }
                if (AlaLiveInputEditView.this.aun.getText().length() > AlaLiveInputEditView.this.aFQ.length()) {
                    AlaLiveInputEditView.this.aun.setText(AlaLiveInputEditView.this.aFQ);
                    AlaLiveInputEditView.this.aun.setSelection(AlaLiveInputEditView.this.aun.getText().length());
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
        this.auv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aFO != null) {
                    AlaLiveInputEditView.this.aFO.dx(AlaLiveInputEditView.this.aun.getText().toString());
                }
                AlaLiveInputEditView.this.xS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aun.getText()));
                }
                if (AlaLiveInputEditView.this.aun.getText().length() > AlaLiveInputEditView.this.aFQ.length()) {
                    AlaLiveInputEditView.this.aun.setText(AlaLiveInputEditView.this.aFQ);
                    AlaLiveInputEditView.this.aun.setSelection(AlaLiveInputEditView.this.aun.getText().length());
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
        this.auv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.aFO != null) {
                    AlaLiveInputEditView.this.aFO.dx(AlaLiveInputEditView.this.aun.getText().toString());
                }
                AlaLiveInputEditView.this.xS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.mSendView != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aun.getText()));
                }
                if (AlaLiveInputEditView.this.aun.getText().length() > AlaLiveInputEditView.this.aFQ.length()) {
                    AlaLiveInputEditView.this.aun.setText(AlaLiveInputEditView.this.aFQ);
                    AlaLiveInputEditView.this.aun.setSelection(AlaLiveInputEditView.this.aun.getText().length());
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
        this.aun = (EditText) findViewById(a.g.edit_text);
        this.aun.setIncludeFontPadding(false);
        this.aun.addTextChangedListener(this.mTextWatcher);
        this.aun.setInputType(2);
        this.aun.setSingleLine(true);
        this.aun.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.aun.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.aFO != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.aun.getText())) {
                        AlaLiveInputEditView.this.aFO.dx(AlaLiveInputEditView.this.aun.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.mSendView = (TextView) findViewById(a.g.tv_send);
        this.mSendView.setOnClickListener(this.auv);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.aun, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.aFO = aVar;
    }

    public void xS() {
        this.aun.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            this.aun.setText(str);
            this.aun.setSelection(str.length());
        }
    }

    public void setHintText(String str) {
        this.aun.setHint(str);
    }

    public void setMaxText(String str) {
        this.aFQ = str;
    }

    public void setInputEditType(int i) {
        this.aun.setInputType(i);
    }

    public EditText getEditView() {
        return this.aun;
    }

    public TextView getTextView() {
        return this.mSendView;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.aun.requestFocus();
        } else {
            this.aun.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.aun.removeTextChangedListener(this.mTextWatcher);
        this.aun.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.aFP == null) {
            this.aFP = new GradientDrawable();
            this.aFP.setShape(0);
            this.aFP.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.aFP.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.aFP.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.aFP.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.aFP.clearColorFilter();
            this.mSendView.setTextColor(-1);
        } else {
            this.aFP.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.mSendView.setTextColor(-2130706433);
        }
        this.mSendView.setBackgroundDrawable(this.aFP);
        this.mSendView.setEnabled(z);
    }
}
