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

    /* renamed from: a  reason: collision with root package name */
    public String f5471a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5472b;

    /* renamed from: c  reason: collision with root package name */
    public List<IEditTextPasteFilter> f5473c;
    public boolean isAlwaysShow;
    public int off;

    public PluginEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5471a = getClass().getSimpleName();
        this.isAlwaysShow = false;
        this.f5472b = true;
        this.f5473c = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f5473c.addAll(parseEditTextPasteFilter);
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        if (iEditTextPasteFilter != null) {
            this.f5473c.add(iEditTextPasteFilter);
        }
    }

    public List<IEditTextPasteFilter> getEditTextPasteFilters() {
        return this.f5473c;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z || this.isAlwaysShow) {
            return;
        }
        RimGlobalUtils.hideInputMethod(getContext(), this);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        String str;
        if (i == 16908322) {
            String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.f5473c);
            try {
                int selectionStart = getSelectionStart();
                int selectionEnd = getSelectionEnd();
                LogUtil.d(this.f5471a, "\tstart:" + selectionStart + "\tend:" + selectionEnd);
                Editable editableText = getEditableText();
                if (editableText != null) {
                    String obj = editableText.toString();
                    if (!TextUtils.isEmpty(obj)) {
                        int length = obj.length();
                        String substring = obj.substring(0, selectionStart);
                        String substring2 = obj.substring(selectionEnd, length);
                        if (TextUtils.isEmpty(substring)) {
                            str = "";
                        } else {
                            str = "" + substring;
                        }
                        if (!TextUtils.isEmpty(applyEditTextPasteFilters)) {
                            str = str + applyEditTextPasteFilters;
                        }
                        if (TextUtils.isEmpty(substring2)) {
                            applyEditTextPasteFilters = str;
                        } else {
                            applyEditTextPasteFilters = str + substring2;
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
            } catch (Exception e2) {
                LogUtil.d(this.f5471a, e2.getMessage());
                return super.onTextContextMenuItem(i);
            }
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.f5472b) {
            RimGlobalUtils.showInputMethod(getContext(), view);
            return true;
        }
        return true;
    }

    public void setMyHint(CharSequence charSequence, int i) {
        SpannableString spannableString = new SpannableString(charSequence.toString());
        spannableString.setSpan(new AbsoluteSizeSpan(i), 0, spannableString.length(), 33);
        setHint(new SpannedString(spannableString));
    }

    public void setMyHintTextSize(int i) {
        setMyHint(getHint(), i);
    }

    public void setShowInputMethod(boolean z) {
        this.isAlwaysShow = z;
    }

    public void setShowSystemMethodFlag(boolean z) {
        this.f5472b = z;
    }

    public PluginEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5471a = getClass().getSimpleName();
        this.isAlwaysShow = false;
        this.f5472b = true;
        this.f5473c = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f5473c.addAll(parseEditTextPasteFilter);
    }

    public PluginEditText(Context context) {
        this(context, null);
    }
}
