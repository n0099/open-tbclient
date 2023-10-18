package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EditTextWrapper extends LinearLayout implements View.OnFocusChangeListener, TextWatcher {
    public static final int CLEAR_MARGIN = 8;
    public static final int EDITTEXT_MARGIN = 10;
    public ImageView mClear;
    public EditText mEditText;
    public View.OnFocusChangeListener mFocusListener;
    public TextView mTextView;
    public List<TextWatcher> mTextWatchers;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public EditTextWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextWatchers = new ArrayList();
        setOrientation(0);
        setGravity(16);
        TextView textView = new TextView(context);
        this.mTextView = textView;
        addView(textView, 0);
        EditText editText = new EditText(context, attributeSet);
        this.mEditText = editText;
        editText.setTextColor(getResources().getColor(com.baidu.tieba.R.color.edittext_wrapper_text));
        this.mEditText.setHintTextColor(getResources().getColor(com.baidu.tieba.R.color.edittext_wrapper_hint_text));
        this.mEditText.setId(0);
        this.mEditText.setBackgroundDrawable(null);
        this.mEditText.setOnFocusChangeListener(this);
        this.mTextWatchers.add(this);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.searchbox.ui.EditTextWrapper.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                for (TextWatcher textWatcher : EditTextWrapper.this.mTextWatchers) {
                    textWatcher.afterTextChanged(editable);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                for (TextWatcher textWatcher : EditTextWrapper.this.mTextWatchers) {
                    textWatcher.beforeTextChanged(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                for (TextWatcher textWatcher : EditTextWrapper.this.mTextWatchers) {
                    textWatcher.onTextChanged(charSequence, i, i2, i3);
                }
            }
        });
        addView(this.mEditText, 1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mEditText.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.weight = 1.0f;
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        this.mEditText.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.mClear = imageView;
        imageView.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f081387));
        this.mClear.setContentDescription(getResources().getString(com.baidu.tieba.R.string.edittext_wraper_clean));
        this.mClear.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.EditTextWrapper.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditTextWrapper.this.mEditText.setText("");
            }
        });
        addView(this.mClear, 2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mClear.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.rightMargin = 8;
        this.mClear.setLayoutParams(layoutParams2);
        this.mClear.setVisibility(4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.searchbox.common.res.R.styleable.EditTextWrapper, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        setLabel(resourceId);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        this.mTextWatchers.add(textWatcher);
    }

    public void setEditTextViewEnable(boolean z) {
        EditText editText = this.mEditText;
        if (editText != null) {
            editText.setEnabled(z);
        }
    }

    public void setLabel(int i) {
        if (i == 0) {
            this.mTextView.setVisibility(8);
            return;
        }
        this.mTextView.setVisibility(0);
        this.mTextView.setText(i);
    }

    public void setLabelColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.mEditText.setOnEditorActionListener(onEditorActionListener);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mFocusListener = onFocusChangeListener;
    }

    public void setSelection(int i) {
        this.mEditText.setSelection(i);
    }

    public void setText(CharSequence charSequence) {
        this.mEditText.setText(charSequence);
    }

    public String getText() {
        return this.mEditText.getText().toString().trim();
    }

    public EditText unwrap() {
        return this.mEditText;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view2, boolean z) {
        if (z && this.mEditText.getText().toString().length() > 0 && this.mEditText.isEnabled()) {
            this.mClear.setVisibility(0);
        } else {
            this.mClear.setVisibility(4);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.mFocusListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view2, z);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.mClear.setVisibility(0);
        } else {
            this.mClear.setVisibility(4);
        }
    }

    public void setLabel(String str) {
        if (str == null) {
            this.mTextView.setVisibility(8);
            return;
        }
        this.mTextView.setVisibility(0);
        this.mTextView.setText(str);
    }
}
