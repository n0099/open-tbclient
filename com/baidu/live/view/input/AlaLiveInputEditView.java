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
/* loaded from: classes7.dex */
public class AlaLiveInputEditView extends LinearLayout implements b {
    private EditText bdg;
    private View.OnClickListener bdx;
    private TextView buE;
    private b.a buF;
    private GradientDrawable buG;
    private String buH;
    private TextWatcher mTextWatcher;

    public AlaLiveInputEditView(Context context) {
        super(context);
        this.bdx = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.buF != null) {
                    AlaLiveInputEditView.this.buF.gx(AlaLiveInputEditView.this.bdg.getText().toString());
                }
                AlaLiveInputEditView.this.KA();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.buE != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bdg.getText()));
                }
                if (AlaLiveInputEditView.this.bdg.getText() != null && AlaLiveInputEditView.this.buH != null && AlaLiveInputEditView.this.bdg.getText().length() > AlaLiveInputEditView.this.buH.length()) {
                    AlaLiveInputEditView.this.bdg.setText(AlaLiveInputEditView.this.buH);
                    AlaLiveInputEditView.this.bdg.setSelection(AlaLiveInputEditView.this.bdg.getText().length());
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
        this.bdx = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.buF != null) {
                    AlaLiveInputEditView.this.buF.gx(AlaLiveInputEditView.this.bdg.getText().toString());
                }
                AlaLiveInputEditView.this.KA();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AlaLiveInputEditView.this.buE != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bdg.getText()));
                }
                if (AlaLiveInputEditView.this.bdg.getText() != null && AlaLiveInputEditView.this.buH != null && AlaLiveInputEditView.this.bdg.getText().length() > AlaLiveInputEditView.this.buH.length()) {
                    AlaLiveInputEditView.this.bdg.setText(AlaLiveInputEditView.this.buH);
                    AlaLiveInputEditView.this.bdg.setSelection(AlaLiveInputEditView.this.bdg.getText().length());
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
        this.bdx = new View.OnClickListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveInputEditView.this.buF != null) {
                    AlaLiveInputEditView.this.buF.gx(AlaLiveInputEditView.this.bdg.getText().toString());
                }
                AlaLiveInputEditView.this.KA();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (AlaLiveInputEditView.this.buE != null) {
                    AlaLiveInputEditView.this.setSendEnabled(!TextUtils.isEmpty(AlaLiveInputEditView.this.bdg.getText()));
                }
                if (AlaLiveInputEditView.this.bdg.getText() != null && AlaLiveInputEditView.this.buH != null && AlaLiveInputEditView.this.bdg.getText().length() > AlaLiveInputEditView.this.buH.length()) {
                    AlaLiveInputEditView.this.bdg.setText(AlaLiveInputEditView.this.buH);
                    AlaLiveInputEditView.this.bdg.setSelection(AlaLiveInputEditView.this.bdg.getText().length());
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
        this.bdg = (EditText) findViewById(a.g.edit_text);
        this.bdg.setIncludeFontPadding(false);
        this.bdg.addTextChangedListener(this.mTextWatcher);
        this.bdg.setInputType(2);
        this.bdg.setSingleLine(true);
        this.bdg.setImeOptions(RouterCallback.CODE_ROUTER_NOT_REGISTER);
        this.bdg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.view.input.AlaLiveInputEditView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (AlaLiveInputEditView.this.buF != null && !TextUtils.isEmpty(AlaLiveInputEditView.this.bdg.getText())) {
                        AlaLiveInputEditView.this.buF.gx(AlaLiveInputEditView.this.bdg.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        this.buE = (TextView) findViewById(a.g.tv_send);
        this.buE.setOnClickListener(this.bdx);
        setSendEnabled(false);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.bdg, Integer.valueOf(a.f.sdk_cursor_edit_input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditViewConfirmCallBack(b.a aVar) {
        this.buF = aVar;
    }

    public void KA() {
        this.bdg.setText("");
    }

    public void setEditText(String str) {
        if (str != null) {
            try {
                this.bdg.setText(str);
                this.bdg.setSelection(str.length());
            } catch (Exception e) {
                this.bdg.setText(str);
            }
        }
    }

    public void setHintText(String str) {
        this.bdg.setHint(str);
    }

    public void setMaxText(String str) {
        this.buH = str;
    }

    public void setInputEditType(int i) {
        this.bdg.setInputType(i);
    }

    public EditText getEditView() {
        return this.bdg;
    }

    public TextView getTextView() {
        return this.buE;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.bdg.requestFocus();
        } else {
            this.bdg.clearFocus();
        }
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.bdg.removeTextChangedListener(this.mTextWatcher);
        this.bdg.addTextChangedListener(textWatcher);
    }

    public void setSendEnabled(boolean z) {
        if (this.buG == null) {
            this.buG = new GradientDrawable();
            this.buG.setShape(0);
            this.buG.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds32));
            this.buG.setGradientType(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.buG.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                this.buG.setColors(new int[]{-57754, -39399});
            }
        }
        if (z) {
            this.buG.clearColorFilter();
            this.buE.setTextColor(-1);
        } else {
            this.buG.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
            this.buE.setTextColor(-2130706433);
        }
        this.buE.setBackgroundDrawable(this.buG);
        this.buE.setEnabled(z);
    }
}
