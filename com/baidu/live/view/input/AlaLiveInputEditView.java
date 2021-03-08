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
/* loaded from: classes10.dex */
public class AlaLiveInputEditView extends LinearLayout implements c {
    private String bWA;
    private TextView bWx;
    private c.a bWy;
    private GradientDrawable bWz;
    private EditText brV;
    private View.OnClickListener bso;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bWy != null) {
                    AlaLiveInputEditView.this.bWy.gF(AlaLiveInputEditView.this.brV.getText().toString());
                }
                AlaLiveInputEditView.this.Md();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bWx != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.brV.getText()));
                }
                try {
                    if (AlaLiveInputEditView.this.brV.getText() != null && !AlaLiveInputEditView.this.brV.getText().toString().isEmpty() && AlaLiveInputEditView.this.bWA != null && !AlaLiveInputEditView.this.bWA.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.brV.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bWA)) {
                        AlaLiveInputEditView.this.brV.setText(AlaLiveInputEditView.this.bWA);
                        AlaLiveInputEditView.this.brV.setSelection(AlaLiveInputEditView.this.brV.getText().length());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
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
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bWy != null) {
                    AlaLiveInputEditView.this.bWy.gF(AlaLiveInputEditView.this.brV.getText().toString());
                }
                AlaLiveInputEditView.this.Md();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bWx != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.brV.getText()));
                }
                try {
                    if (AlaLiveInputEditView.this.brV.getText() != null && !AlaLiveInputEditView.this.brV.getText().toString().isEmpty() && AlaLiveInputEditView.this.bWA != null && !AlaLiveInputEditView.this.bWA.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.brV.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bWA)) {
                        AlaLiveInputEditView.this.brV.setText(AlaLiveInputEditView.this.bWA);
                        AlaLiveInputEditView.this.brV.setSelection(AlaLiveInputEditView.this.brV.getText().length());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
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
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bWy != null) {
                    AlaLiveInputEditView.this.bWy.gF(AlaLiveInputEditView.this.brV.getText().toString());
                }
                AlaLiveInputEditView.this.Md();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bWx != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.brV.getText()));
                }
                try {
                    if (AlaLiveInputEditView.this.brV.getText() != null && !AlaLiveInputEditView.this.brV.getText().toString().isEmpty() && AlaLiveInputEditView.this.bWA != null && !AlaLiveInputEditView.this.bWA.isEmpty() && Integer.parseInt(AlaLiveInputEditView.this.brV.getText().toString()) > Integer.parseInt(AlaLiveInputEditView.this.bWA)) {
                        AlaLiveInputEditView.this.brV.setText(AlaLiveInputEditView.this.bWA);
                        AlaLiveInputEditView.this.brV.setSelection(AlaLiveInputEditView.this.brV.getText().length());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
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
        this.brV = (EditText) findViewById(a.f.edit_text);
        this.brV.setIncludeFontPadding(false);
        this.brV.addTextChangedListener(this.mTextWatcher);
        this.brV.setInputType(2);
        this.brV.setSingleLine(true);
        this.brV.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.brV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bWy != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.brV.getText())) {
                        AlaLiveInputEditView.this.bWy.gF(AlaLiveInputEditView.this.brV.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bWx = (TextView) findViewById(a.f.tv_send);
        this.bWx.setOnClickListener(this.bso);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.brV, Integer.valueOf(a.e.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(c.a aVar) {
        this.bWy = aVar;
    }

    public void Md() {
        this.brV.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.brV.setText(str);
                this.brV.setSelection(str.length());
            } catch (Exception e) {
                this.brV.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.brV.setHint(str);
    }

    public void setMaxText(String str) {
        this.bWA = str;
    }

    public void setInputEditType(int i) {
        this.brV.setInputType(i);
    }

    public EditText getEditView() {
        return this.brV;
    }

    public TextView getTextView() {
        return this.bWx;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.brV.requestFocus();
        } else {
            this.brV.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.brV.removeTextChangedListener(this.mTextWatcher);
        this.brV.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bWz == null) {
            this.bWz = new GradientDrawable();
            this.bWz.setShape(0);
            this.bWz.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds32));
            this.bWz.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bWz.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bWz.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bWz.clearColorFilter();
            this.bWx.setTextColor(-1);
        } else {
            this.bWz.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bWx.setTextColor(-2130706433);
        }
        this.bWx.setBackgroundDrawable(this.bWz);
        this.bWx.setEnabled(z);
    }
}
