package com.baidu.fsg.base.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PluginEditText extends EditText implements View.OnTouchListener {
    private String a;
    private boolean b;
    private List<IEditTextPasteFilter> c;
    protected boolean isAlwaysShow;
    protected int off;

    /* JADX INFO: Access modifiers changed from: protected */
    public void setShowSystemMethodFlag(boolean z) {
        this.b = z;
    }

    public PluginEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = getClass().getSimpleName();
        this.isAlwaysShow = false;
        this.b = true;
        this.c = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.c.addAll(parseEditTextPasteFilter);
        }
    }

    public PluginEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getClass().getSimpleName();
        this.isAlwaysShow = false;
        this.b = true;
        this.c = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.c.addAll(parseEditTextPasteFilter);
        }
    }

    public PluginEditText(Context context) {
        this(context, null);
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        if (iEditTextPasteFilter != null) {
            this.c.add(iEditTextPasteFilter);
        }
    }

    public List<IEditTextPasteFilter> getEditTextPasteFilters() {
        return this.c;
    }

    public void setMyHint(CharSequence charSequence, int i) {
        SpannableString spannableString = new SpannableString(charSequence.toString());
        spannableString.setSpan(new AbsoluteSizeSpan(i), 0, spannableString.length(), 33);
        setHint(new SpannedString(spannableString));
    }

    public void setMyHintTextSize(int i) {
        setMyHint(getHint(), i);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i == 16908322) {
            String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.c);
            try {
                int selectionStart = getSelectionStart();
                int selectionEnd = getSelectionEnd();
                LogUtil.d(this.a, "\tstart:" + selectionStart + "\tend:" + selectionEnd);
                Editable editableText = getEditableText();
                if (editableText != null) {
                    String obj = editableText.toString();
                    if (!TextUtils.isEmpty(obj)) {
                        int length = obj.length();
                        String substring = obj.substring(0, selectionStart);
                        String substring2 = obj.substring(selectionEnd, length);
                        String str = TextUtils.isEmpty(substring) ? "" : "" + substring;
                        applyEditTextPasteFilters = !TextUtils.isEmpty(applyEditTextPasteFilters) ? str + applyEditTextPasteFilters : str;
                        if (!TextUtils.isEmpty(substring2)) {
                            applyEditTextPasteFilters = applyEditTextPasteFilters + substring2;
                        }
                    }
                    if (!TextUtils.isEmpty(applyEditTextPasteFilters)) {
                        applyEditTextPasteFilters = applyEditTextPasteFilters.replace(" ", "");
                    }
                    setText("");
                    setText(applyEditTextPasteFilters);
                    setSelection(getEditableText().length());
                    requestFocus();
                    return true;
                }
                return super.onTextContextMenuItem(i);
            } catch (Exception e) {
                if (e != null) {
                    LogUtil.d(this.a, e.getMessage());
                }
                return super.onTextContextMenuItem(i);
            }
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z && !this.isAlwaysShow) {
            RimGlobalUtils.hideInputMethod(getContext(), this);
        }
    }

    public void setShowInputMethod(boolean z) {
        this.isAlwaysShow = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.b) {
            RimGlobalUtils.showInputMethod(getContext(), view);
            return true;
        }
        return true;
    }
}
