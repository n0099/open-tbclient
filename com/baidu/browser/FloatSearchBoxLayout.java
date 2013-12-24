package com.baidu.browser;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdUtil;
/* loaded from: classes.dex */
public class FloatSearchBoxLayout extends RelativeLayout implements View.OnClickListener, View.OnFocusChangeListener, TextView.OnEditorActionListener, BdNoProGuard {
    private EditText input;
    private String mCurUrl;

    public void setHandlerFromActivity(Handler handler) {
    }

    public FloatSearchBoxLayout(Context context) {
        super(context);
    }

    public FloatSearchBoxLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setVoiceViewScrolledUp() {
    }

    public void setUIId(int i) {
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.input = (EditText) findViewById(getContext().getResources().getIdentifier("SearchTextInput", "id", getContext().getPackageName()));
        this.input.setOnEditorActionListener(this);
        this.input.setOnFocusChangeListener(this);
        this.input.setImeOptions(2);
        ((ImageView) findViewById(getContext().getResources().getIdentifier("go_btn", "id", getContext().getPackageName()))).setOnClickListener(this);
    }

    public void setStopLoadingOnClickListener(View.OnClickListener onClickListener) {
    }

    public String getInputText() {
        if (this.input != null) {
            return this.input.getText().toString();
        }
        return null;
    }

    public void setGoSearchOnClickListener(View.OnClickListener onClickListener) {
    }

    public void setLoadingProgress(int i) {
        ((ProgressBar) findViewById(getContext().getResources().getIdentifier("loadbar", "id", getContext().getPackageName()))).setProgress(i);
    }

    public void hideStopLoadingIcon() {
    }

    public void showStopLoadingIcon() {
    }

    public void setGridViewScrolledDown(boolean z) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        loadKeyword();
    }

    private void loadKeyword() {
        String str;
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            str = this.mCurUrl;
        } else {
            str = BdUtil.composeUrl(inputText);
        }
        BdLog.d(str);
        if (str != null && str.length() > 0) {
            Browser.getInstance(BrowserActivity.mySelf).loadUrl(str);
        } else {
            Toast.makeText(getContext(), getContext().getResources().getIdentifier("browser_load_empty_tip", "string", getContext().getPackageName()), 1).show();
        }
    }

    public void setUrlTitle(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.input.setText(str2);
        } else if (!TextUtils.isEmpty(str)) {
            this.input.setText(str);
            this.mCurUrl = str;
        } else {
            this.input.setText(getContext().getString(getContext().getResources().getIdentifier("browser_tab_default_text", "string", getContext().getPackageName())));
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent != null) {
            if (keyEvent.getKeyCode() == 66) {
                loadKeyword();
                return true;
            }
            return true;
        }
        loadKeyword();
        return true;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.equals(this.input)) {
            if (z) {
                if (this.input.getText().length() != 0) {
                    this.input.selectAll();
                }
                ((InputMethodManager) getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
                return;
            }
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.input.getWindowToken(), 0);
        }
    }
}
