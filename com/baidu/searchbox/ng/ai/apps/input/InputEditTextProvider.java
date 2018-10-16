package com.baidu.searchbox.ng.ai.apps.input;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class InputEditTextProvider {
    protected static final boolean DEBUG = false;
    private static InputEditTextProvider sInstance;
    private EditText mInputEditText;
    private InputEditTextController mInputEditTextController;
    private TextWatcher mTextWatcher;

    private InputEditTextProvider() {
    }

    public static InputEditTextProvider getInstance() {
        if (sInstance == null) {
            synchronized (InputEditTextProvider.class) {
                if (sInstance == null) {
                    sInstance = new InputEditTextProvider();
                }
            }
        }
        return sInstance;
    }

    public EditText createInputEditText(Context context) {
        this.mInputEditText = new EditText(context);
        return this.mInputEditText;
    }

    public EditText getInputEditText() {
        return this.mInputEditText;
    }

    public void destroyInputEditText() {
        this.mInputEditText = null;
    }

    public InputEditTextController getInputEditTextController() {
        return this.mInputEditTextController;
    }

    public void setInputEditTextController(InputEditTextController inputEditTextController) {
        this.mInputEditTextController = inputEditTextController;
    }

    public TextWatcher getTextWatcher() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
