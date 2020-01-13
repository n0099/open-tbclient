package com.baidu.searchbox.ugc.emoji.edittextrule;

import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes12.dex */
public abstract class BasePatternRule implements IEditTextPatternRule {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "BasePatternRule";
    protected char mPatternTag;
    protected PatternTagInputListener mPatternTagInputListener;
    protected final List<Range> mRangeList = new ArrayList();
    protected boolean mIsCallPatternTagInput = true;

    /* loaded from: classes12.dex */
    public interface PatternTagInputListener {
        void onPatternTagInput();
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void onSelectionChanged(int i, int i2) {
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public boolean onDelete() {
        return false;
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (1 == i3 && !TextUtils.isEmpty(charSequence)) {
            try {
                if (charSequence.toString().charAt(i) == this.mPatternTag && this.mPatternTagInputListener != null && this.mIsCallPatternTagInput) {
                    this.mPatternTagInputListener.onPatternTagInput();
                }
            } catch (IndexOutOfBoundsException e) {
                if (DEBUG) {
                    Log.e(TAG, "char转换失败");
                    throw new IndexOutOfBoundsException("BasePatternRule: onTextChanged");
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void afterTextChanged(Editable editable) {
    }

    public void setPatternTag(char c) {
        this.mPatternTag = c;
    }

    public void setPatternTagInputListener(PatternTagInputListener patternTagInputListener) {
        this.mPatternTagInputListener = patternTagInputListener;
    }

    public void setIsCallPatternTagInput(boolean z) {
        this.mIsCallPatternTagInput = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRangeList(String str) {
        int indexOf;
        if (str != null) {
            this.mRangeList.clear();
            Pattern matchPattern = getMatchPattern();
            if (matchPattern != null) {
                Matcher matcher = matchPattern.matcher(str);
                int i = -1;
                while (matcher.find()) {
                    try {
                        String group = matcher.group();
                        if (!TextUtils.isEmpty(group)) {
                            if (i != -1) {
                                indexOf = str.indexOf(group, i);
                            } else {
                                indexOf = str.indexOf(group);
                            }
                            int i2 = indexOf;
                            i = group.length() + i2;
                            this.mRangeList.add(new Range(i2, i, group));
                        }
                    } catch (IllegalStateException e) {
                        if (DEBUG) {
                            Log.e(TAG, "字符匹配异常");
                            throw new IllegalStateException("BasePatternRule: updateRangeList  pattern = " + matchPattern + " text = " + str);
                        }
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    protected class Range {
        int mFrom;
        String mText;
        int mTo;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Range(int i, int i2, String str) {
            this.mFrom = i;
            this.mTo = i2;
            this.mText = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInterSect(int i, int i2) {
            return (i > this.mFrom && i < this.mTo) || (i2 > this.mFrom && i2 < this.mTo);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isContainedBy(int i, int i2) {
            return i <= this.mFrom && i2 >= this.mTo;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isContains(int i, int i2) {
            return this.mFrom <= i && this.mTo >= i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEqual(int i, int i2) {
            return this.mFrom == i && this.mTo == i2;
        }

        boolean isBefore(int i) {
            return this.mTo <= i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isAfter(int i) {
            return this.mFrom >= i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getAnchorPosition(int i) {
            return (i - this.mFrom) - (this.mTo - i) >= 0 ? this.mTo : this.mFrom;
        }
    }
}
