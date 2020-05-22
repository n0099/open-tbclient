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
    private EditText aUk;
    private View.OnClickListener aUv;
    private TextView bjq;
    private b.a bjr;
    private GradientDrawable bjs;
    private String bjt;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.aUv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bjr != null) {
                    AlaLiveInputEditView.this.bjr.eW(AlaLiveInputEditView.this.aUk.getText().toString());
                }
                AlaLiveInputEditView.this.El();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bjq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aUk.getText()));
                }
                if (AlaLiveInputEditView.this.aUk.getText() != null && AlaLiveInputEditView.this.bjt != null && AlaLiveInputEditView.this.aUk.getText().length() > AlaLiveInputEditView.this.bjt.length()) {
                    AlaLiveInputEditView.this.aUk.setText(AlaLiveInputEditView.this.bjt);
                    AlaLiveInputEditView.this.aUk.setSelection(AlaLiveInputEditView.this.aUk.getText().length());
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
        this.aUv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bjr != null) {
                    AlaLiveInputEditView.this.bjr.eW(AlaLiveInputEditView.this.aUk.getText().toString());
                }
                AlaLiveInputEditView.this.El();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.bjq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aUk.getText()));
                }
                if (AlaLiveInputEditView.this.aUk.getText() != null && AlaLiveInputEditView.this.bjt != null && AlaLiveInputEditView.this.aUk.getText().length() > AlaLiveInputEditView.this.bjt.length()) {
                    AlaLiveInputEditView.this.aUk.setText(AlaLiveInputEditView.this.bjt);
                    AlaLiveInputEditView.this.aUk.setSelection(AlaLiveInputEditView.this.aUk.getText().length());
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
        this.aUv = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.bjr != null) {
                    AlaLiveInputEditView.this.bjr.eW(AlaLiveInputEditView.this.aUk.getText().toString());
                }
                AlaLiveInputEditView.this.El();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.bjq != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.aUk.getText()));
                }
                if (AlaLiveInputEditView.this.aUk.getText() != null && AlaLiveInputEditView.this.bjt != null && AlaLiveInputEditView.this.aUk.getText().length() > AlaLiveInputEditView.this.bjt.length()) {
                    AlaLiveInputEditView.this.aUk.setText(AlaLiveInputEditView.this.bjt);
                    AlaLiveInputEditView.this.aUk.setSelection(AlaLiveInputEditView.this.aUk.getText().length());
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
        this.aUk = (EditText) findViewById(a.g.edit_text);
        this.aUk.setIncludeFontPadding(false);
        this.aUk.addTextChangedListener(this.mTextWatcher);
        this.aUk.setInputType(2);
        this.aUk.setSingleLine(true);
        this.aUk.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.aUk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.bjr != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.aUk.getText())) {
                        AlaLiveInputEditView.this.bjr.eW(AlaLiveInputEditView.this.aUk.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.bjq = (TextView) findViewById(a.g.tv_send);
        this.bjq.setOnClickListener(this.aUv);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.aUk, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.bjr = aVar;
    }

    public void El() {
        this.aUk.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.aUk.setText(str);
                this.aUk.setSelection(str.length());
            } catch (Exception e) {
                this.aUk.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.aUk.setHint(str);
    }

    public void setMaxText(String str) {
        this.bjt = str;
    }

    public void setInputEditType(int i) {
        this.aUk.setInputType(i);
    }

    public EditText getEditView() {
        return this.aUk;
    }

    public TextView getTextView() {
        return this.bjq;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.aUk.requestFocus();
        } else {
            this.aUk.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.aUk.removeTextChangedListener(this.mTextWatcher);
        this.aUk.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.bjs == null) {
            this.bjs = new GradientDrawable();
            this.bjs.setShape(0);
            this.bjs.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.bjs.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.bjs.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.bjs.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.bjs.clearColorFilter();
            this.bjq.setTextColor(-1);
        } else {
            this.bjs.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.bjq.setTextColor(-2130706433);
        }
        this.bjq.setBackgroundDrawable(this.bjs);
        this.bjq.setEnabled(z);
    }
}
