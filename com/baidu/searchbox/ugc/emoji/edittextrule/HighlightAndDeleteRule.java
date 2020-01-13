package com.baidu.searchbox.ugc.emoji.edittextrule;

import android.text.Editable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule;
/* loaded from: classes12.dex */
public abstract class HighlightAndDeleteRule extends BasePatternRule {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "HighlightAndDeleteRule";
    protected EditText mEditText;
    protected int mHighlightColor = AppRuntime.getAppContext().getResources().getColor(R.color.ugc_highlight_text_color);

    protected abstract void beforeDeletePatternText(String str);

    public HighlightAndDeleteRule(EditText editText) {
        this.mEditText = editText;
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule, com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void onSelectionChanged(int i, int i2) {
        BasePatternRule.Range intersectMatchRange;
        super.onSelectionChanged(i, i2);
        if (this.mEditText != null) {
            int min = Math.min(i, i2);
            int max = Math.max(i, i2);
            BasePatternRule.Range containMatchRange = getContainMatchRange(min, max);
            if ((containMatchRange == null || !containMatchRange.isEqual(min, max)) && (intersectMatchRange = getIntersectMatchRange(min, max)) != null) {
                try {
                    if (min == max) {
                        this.mEditText.setSelection(intersectMatchRange.getAnchorPosition(min));
                        return;
                    }
                    if (max < intersectMatchRange.mTo) {
                        this.mEditText.setSelection(min, intersectMatchRange.mTo);
                    }
                    if (min > intersectMatchRange.mFrom) {
                        this.mEditText.setSelection(intersectMatchRange.mFrom, max);
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (DEBUG) {
                        Log.e(TAG, "onSelectionChanged-setSelection: 设置光标时数组越界异常");
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule, com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public boolean onDelete() {
        if (this.mEditText == null) {
            return super.onDelete();
        }
        int selectionStart = this.mEditText.getSelectionStart();
        int selectionEnd = this.mEditText.getSelectionEnd();
        int min = Math.min(selectionStart, selectionEnd);
        BasePatternRule.Range containMatchRange = getContainMatchRange(min, Math.max(selectionStart, selectionEnd));
        if (containMatchRange == null) {
            return super.onDelete();
        }
        if (min == containMatchRange.mFrom) {
            return super.onDelete();
        }
        try {
            this.mEditText.setSelection(containMatchRange.mTo, containMatchRange.mFrom);
        } catch (IndexOutOfBoundsException e) {
            if (DEBUG) {
                Log.e(TAG, "onDelete-setSelection: 设置光标时数组越界异常");
            }
        }
        return true;
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule, com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.beforeTextChanged(charSequence, i, i2, i3);
        if (this.mRangeList != null) {
            if (this.mEditText != null) {
                Editable text = this.mEditText.getText();
                if (!TextUtils.isEmpty(text)) {
                    try {
                        for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) text.getSpans(i, i + i2, ForegroundColorSpan.class)) {
                            text.removeSpan(foregroundColorSpan);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        if (DEBUG) {
                            Log.e(TAG, "beforeTextChanged-getSpans: 删除原有颜色时数组越界异常");
                        }
                    }
                }
            }
            for (int i4 = 0; i4 < this.mRangeList.size(); i4++) {
                BasePatternRule.Range range = this.mRangeList.get(i4);
                if (range.isContainedBy(i, i + i2)) {
                    try {
                        beforeDeletePatternText(charSequence.subSequence(range.mFrom, range.mTo).toString());
                    } catch (IndexOutOfBoundsException e2) {
                        if (DEBUG) {
                            Log.e(TAG, "beforeTextChanged-subSequence: 获取删除字符串失败，数组越界异常");
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule, com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!(this instanceof TopicRule)) {
            highLightMatchString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleTopicHighLight() {
    }

    public void setHighlightColor(int i) {
        this.mHighlightColor = i;
    }

    public void highLightMatchString() {
        if (this.mEditText != null) {
            Editable text = this.mEditText.getText();
            if (!TextUtils.isEmpty(text)) {
                updateRangeList(text.toString());
                for (BasePatternRule.Range range : this.mRangeList) {
                    try {
                        text.setSpan(new ForegroundColorSpan(this.mHighlightColor), range.mFrom, range.mTo, 33);
                    } catch (IndexOutOfBoundsException e) {
                        if (DEBUG) {
                            Log.e(TAG, "highLightMatchString-setSpan: 设置高亮文字时数组越界异常 ");
                        }
                    }
                }
            }
        }
    }

    private BasePatternRule.Range getContainMatchRange(int i, int i2) {
        if (this.mRangeList == null) {
            return null;
        }
        for (BasePatternRule.Range range : this.mRangeList) {
            if (range.isContains(i, i2)) {
                return range;
            }
        }
        return null;
    }

    private BasePatternRule.Range getIntersectMatchRange(int i, int i2) {
        if (this.mRangeList == null) {
            return null;
        }
        for (BasePatternRule.Range range : this.mRangeList) {
            if (range.isInterSect(i, i2)) {
                return range;
            }
        }
        return null;
    }
}
