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
    private TextView bHv;
    private b.a bHw;
    private GradientDrawable bHx;
    private String bHy;
    private EditText blg;
    private View.OnClickListener blx;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.blx = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bHw != null) {
                    AlaLiveInputEditView.this.bHw.hg(AlaLiveInputEditView.this.blg.getText().toString());
                }
                AlaLiveInputEditView.this.MG();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bHv != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.blg.getText()));
                }
                if (AlaLiveInputEditView.this.blg.getText() != null && AlaLiveInputEditView.this.bHy != null && AlaLiveInputEditView.this.blg.getText().length() > AlaLiveInputEditView.this.bHy.length()) {
                    AlaLiveInputEditView.this.blg.setText(AlaLiveInputEditView.this.bHy);
                    AlaLiveInputEditView.this.blg.setSelection(AlaLiveInputEditView.this.blg.getText().length());
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
        this.blx = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bHw != null) {
                    AlaLiveInputEditView.this.bHw.hg(AlaLiveInputEditView.this.blg.getText().toString());
                }
                AlaLiveInputEditView.this.MG();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bHv != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.blg.getText()));
                }
                if (AlaLiveInputEditView.this.blg.getText() != null && AlaLiveInputEditView.this.bHy != null && AlaLiveInputEditView.this.blg.getText().length() > AlaLiveInputEditView.this.bHy.length()) {
                    AlaLiveInputEditView.this.blg.setText(AlaLiveInputEditView.this.bHy);
                    AlaLiveInputEditView.this.blg.setSelection(AlaLiveInputEditView.this.blg.getText().length());
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
        this.blx = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bHw != null) {
                    AlaLiveInputEditView.this.bHw.hg(AlaLiveInputEditView.this.blg.getText().toString());
                }
                AlaLiveInputEditView.this.MG();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bHv != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.blg.getText()));
                }
                if (AlaLiveInputEditView.this.blg.getText() != null && AlaLiveInputEditView.this.bHy != null && AlaLiveInputEditView.this.blg.getText().length() > AlaLiveInputEditView.this.bHy.length()) {
                    AlaLiveInputEditView.this.blg.setText(AlaLiveInputEditView.this.bHy);
                    AlaLiveInputEditView.this.blg.setSelection(AlaLiveInputEditView.this.blg.getText().length());
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
        this.blg = (EditText) findViewById(a.g.edit_text);
        this.blg.setIncludeFontPadding(false);
        this.blg.addTextChangedListener(this.mTextWatcher);
        this.blg.setInputType(2);
        this.blg.setSingleLine(true);
        this.blg.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.blg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bHw != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.blg.getText())) {
                        AlaLiveInputEditView.this.bHw.hg(AlaLiveInputEditView.this.blg.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bHv = (TextView) findViewById(a.g.tv_send);
        this.bHv.setOnClickListener(this.blx);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.blg, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bHw = aVar;
    }

    public void MG() {
        this.blg.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.blg.setText(str);
                this.blg.setSelection(str.length());
            } catch (Exception e) {
                this.blg.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.blg.setHint(str);
    }

    public void setMaxText(String str) {
        this.bHy = str;
    }

    public void setInputEditType(int i) {
        this.blg.setInputType(i);
    }

    public EditText getEditView() {
        return this.blg;
    }

    public TextView getTextView() {
        return this.bHv;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.blg.requestFocus();
        } else {
            this.blg.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.blg.removeTextChangedListener(this.mTextWatcher);
        this.blg.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bHx == null) {
            this.bHx = new GradientDrawable();
            this.bHx.setShape(0);
            this.bHx.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.bHx.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bHx.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bHx.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bHx.clearColorFilter();
            this.bHv.setTextColor(-1);
        } else {
            this.bHx.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bHv.setTextColor(-2130706433);
        }
        this.bHv.setBackgroundDrawable(this.bHx);
        this.bHv.setEnabled(z);
    }
}
