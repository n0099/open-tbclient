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
    private TextView bWc;
    private c.a bWd;
    private GradientDrawable bWe;
    private String bWf;
    private EditText brG;
    private View.OnClickListener brZ;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bWd != null) {
                    AlaLiveInputEditView.this.bWd.hn(AlaLiveInputEditView.this.brG.getText().toString());
                }
                AlaLiveInputEditView.this.Ox();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bWc != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.brG.getText()));
                }
                if (AlaLiveInputEditView.this.brG.getText() != null && !AlaLiveInputEditView.this.brG.getText().toString().isEmpty() && AlaLiveInputEditView.this.bWf != null && !AlaLiveInputEditView.this.bWf.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.brG.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bWf)) {
                    AlaLiveInputEditView.this.brG.setText(AlaLiveInputEditView.this.bWf);
                    AlaLiveInputEditView.this.brG.setSelection(AlaLiveInputEditView.this.brG.getText().length());
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
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bWd != null) {
                    AlaLiveInputEditView.this.bWd.hn(AlaLiveInputEditView.this.brG.getText().toString());
                }
                AlaLiveInputEditView.this.Ox();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bWc != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.brG.getText()));
                }
                if (AlaLiveInputEditView.this.brG.getText() != null && !AlaLiveInputEditView.this.brG.getText().toString().isEmpty() && AlaLiveInputEditView.this.bWf != null && !AlaLiveInputEditView.this.bWf.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.brG.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bWf)) {
                    AlaLiveInputEditView.this.brG.setText(AlaLiveInputEditView.this.bWf);
                    AlaLiveInputEditView.this.brG.setSelection(AlaLiveInputEditView.this.brG.getText().length());
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
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bWd != null) {
                    AlaLiveInputEditView.this.bWd.hn(AlaLiveInputEditView.this.brG.getText().toString());
                }
                AlaLiveInputEditView.this.Ox();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bWc != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.brG.getText()));
                }
                if (AlaLiveInputEditView.this.brG.getText() != null && !AlaLiveInputEditView.this.brG.getText().toString().isEmpty() && AlaLiveInputEditView.this.bWf != null && !AlaLiveInputEditView.this.bWf.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.brG.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bWf)) {
                    AlaLiveInputEditView.this.brG.setText(AlaLiveInputEditView.this.bWf);
                    AlaLiveInputEditView.this.brG.setSelection(AlaLiveInputEditView.this.brG.getText().length());
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
        this.brG = (EditText) findViewById(a.f.edit_text);
        this.brG.setIncludeFontPadding(false);
        this.brG.addTextChangedListener(this.mTextWatcher);
        this.brG.setInputType(2);
        this.brG.setSingleLine(true);
        this.brG.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.brG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bWd != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.brG.getText())) {
                        AlaLiveInputEditView.this.bWd.hn(AlaLiveInputEditView.this.brG.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bWc = (TextView) findViewById(a.f.tv_send);
        this.bWc.setOnClickListener(this.brZ);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.brG, Integer.valueOf(a.e.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(c.a aVar) {
        this.bWd = aVar;
    }

    public void Ox() {
        this.brG.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.brG.setText(str);
                this.brG.setSelection(str.length());
            } catch (Exception e) {
                this.brG.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.brG.setHint(str);
    }

    public void setMaxText(String str) {
        this.bWf = str;
    }

    public void setInputEditType(int i) {
        this.brG.setInputType(i);
    }

    public EditText getEditView() {
        return this.brG;
    }

    public TextView getTextView() {
        return this.bWc;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.brG.requestFocus();
        } else {
            this.brG.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.brG.removeTextChangedListener(this.mTextWatcher);
        this.brG.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bWe == null) {
            this.bWe = new GradientDrawable();
            this.bWe.setShape(0);
            this.bWe.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds32));
            this.bWe.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bWe.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bWe.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bWe.clearColorFilter();
            this.bWc.setTextColor(-1);
        } else {
            this.bWe.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bWc.setTextColor(-2130706433);
        }
        this.bWc.setBackgroundDrawable(this.bWe);
        this.bWc.setEnabled(z);
    }
}
