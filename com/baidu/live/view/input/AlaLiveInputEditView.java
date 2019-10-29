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
    private EditText aii;
    private View.OnClickListener air;
    private TextView ati;
    private b.a atj;
    private GradientDrawable atk;
    private String atl;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.air = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.atj != null) {
                    AlaLiveInputEditView.this.atj.cs(AlaLiveInputEditView.this.aii.getText().toString());
                }
                AlaLiveInputEditView.this.tH();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.ati != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aii.getText()));
                }
                if (AlaLiveInputEditView.this.aii.getText().length() > AlaLiveInputEditView.this.atl.length()) {
                    AlaLiveInputEditView.this.aii.setText(AlaLiveInputEditView.this.atl);
                    AlaLiveInputEditView.this.aii.setSelection(AlaLiveInputEditView.this.aii.getText().length());
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
        this.air = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.atj != null) {
                    AlaLiveInputEditView.this.atj.cs(AlaLiveInputEditView.this.aii.getText().toString());
                }
                AlaLiveInputEditView.this.tH();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.ati != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aii.getText()));
                }
                if (AlaLiveInputEditView.this.aii.getText().length() > AlaLiveInputEditView.this.atl.length()) {
                    AlaLiveInputEditView.this.aii.setText(AlaLiveInputEditView.this.atl);
                    AlaLiveInputEditView.this.aii.setSelection(AlaLiveInputEditView.this.aii.getText().length());
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
        this.air = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.atj != null) {
                    AlaLiveInputEditView.this.atj.cs(AlaLiveInputEditView.this.aii.getText().toString());
                }
                AlaLiveInputEditView.this.tH();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.ati != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aii.getText()));
                }
                if (AlaLiveInputEditView.this.aii.getText().length() > AlaLiveInputEditView.this.atl.length()) {
                    AlaLiveInputEditView.this.aii.setText(AlaLiveInputEditView.this.atl);
                    AlaLiveInputEditView.this.aii.setSelection(AlaLiveInputEditView.this.aii.getText().length());
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
        this.aii = (EditText) findViewById(a.g.edit_text);
        this.aii.setIncludeFontPadding(false);
        this.aii.addTextChangedListener(this.mTextWatcher);
        this.aii.setInputType(2);
        this.aii.setSingleLine(true);
        this.aii.setImeOptions(268435460);
        this.aii.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.atj != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.aii.getText())) {
                        AlaLiveInputEditView.this.atj.cs(AlaLiveInputEditView.this.aii.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.ati = (TextView) findViewById(a.g.tv_send);
        this.ati.setOnClickListener(this.air);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.aii, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.atj = aVar;
    }

    public void tH() {
        this.aii.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            this.aii.setText(str);
            this.aii.setSelection(str.length());
        }
    }

    public void setHintText(String str) {
        this.aii.setHint(str);
    }

    public void setMaxText(String str) {
        this.atl = str;
    }

    public void setInputEditType(int i) {
        this.aii.setInputType(i);
    }

    public EditText getEditView() {
        return this.aii;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.aii.requestFocus();
        } else {
            this.aii.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendEnabled(boolean z) {
        if (this.atk == null) {
            this.atk = new GradientDrawable();
            this.atk.setShape(0);
            this.atk.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.atk.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.atk.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.atk.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.atk.clearColorFilter();
            this.ati.setTextColor(-1);
        } else {
            this.atk.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.ati.setTextColor(-2130706433);
        }
        this.ati.setBackgroundDrawable(this.atk);
        this.ati.setEnabled(z);
    }
}
