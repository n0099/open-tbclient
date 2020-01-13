package com.baidu.searchbox.ugc.emoji.edittextrule;

import android.text.Editable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.emoji.EmojiconHandler;
import com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule;
import com.baidu.searchbox.ugc.model.TopicItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/* loaded from: classes12.dex */
public class TopicRule extends HighlightAndDeleteRule {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "TopicRule";
    public EmojiconHandler.AddTopicItemListener mAddTopicItemListener;
    private int mChangedEnd;
    private int mChangedStart;
    protected boolean mIsPaste;
    private String mPageTopicName;
    private final Map<String, TopicItem> mTargetTopicMap;
    protected int mTopicHighlightColor;
    protected TopicMapSizeChangeListener mTopicMapSizeChangeListener;
    private final StringBuilder mTopicPatternStrBuilder;

    /* loaded from: classes12.dex */
    public interface TopicMapSizeChangeListener {
        void onSizeChange(int i);
    }

    public TopicRule(EditText editText) {
        super(editText);
        this.mTargetTopicMap = new HashMap();
        this.mTopicPatternStrBuilder = new StringBuilder();
        this.mPageTopicName = "";
        this.mIsPaste = false;
        this.mChangedStart = -1;
        this.mChangedEnd = -1;
        this.mTopicHighlightColor = AppRuntime.getAppContext().getResources().getColor(R.color.ugc_highlight_text_color_topic);
        this.mAddTopicItemListener = new EmojiconHandler.AddTopicItemListener() { // from class: com.baidu.searchbox.ugc.emoji.edittextrule.TopicRule.1
            @Override // com.baidu.searchbox.ugc.emoji.EmojiconHandler.AddTopicItemListener
            public void onAddTopicItem(int i, int i2) {
                TopicRule.this.mChangedStart = i;
                TopicRule.this.mChangedEnd = i2;
                TopicRule.this.highLightMatchString();
            }
        };
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public Pattern getMatchPattern() {
        try {
            if (TextUtils.isEmpty(this.mTopicPatternStrBuilder)) {
                return null;
            }
            return Pattern.compile(this.mTopicPatternStrBuilder.toString());
        } catch (PatternSyntaxException e) {
            return null;
        }
    }

    public void setRuleFromTopicList(List<TopicItem> list) {
        updateTopicMapFromList(list);
        updateTopicPatternFromMap();
    }

    public void setIsPaste(boolean z) {
        this.mIsPaste = z;
    }

    public void addTopicItem(TopicItem topicItem) {
        if (topicItem != null && !this.mTargetTopicMap.containsKey(topicItem.name)) {
            this.mTargetTopicMap.put(topicItem.name, topicItem);
            if (this.mTopicMapSizeChangeListener != null) {
                this.mTopicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
            }
            addTopicPatternFromTopicItem(topicItem);
        }
    }

    public void obtainTopicList(List<TopicItem> list) {
        if (list != null) {
            list.clear();
            for (Map.Entry<String, TopicItem> entry : this.mTargetTopicMap.entrySet()) {
                list.add(entry.getValue());
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.HighlightAndDeleteRule
    protected void beforeDeletePatternText(String str) {
        if (this.mTargetTopicMap != null && str != null) {
            boolean z = false;
            for (int i = 0; i < this.mRangeList.size(); i++) {
                if (this.mRangeList.get(i).mText.equals(str)) {
                    if (!z) {
                        z = true;
                    } else {
                        return;
                    }
                }
            }
            this.mTargetTopicMap.remove(str);
            if (this.mTopicMapSizeChangeListener != null) {
                this.mTopicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
            }
            deletePatternStrBuilder(str);
        }
    }

    public void setPageTopicName(String str) {
        this.mPageTopicName = str;
    }

    public void setTopicMapSizeChangeListener(TopicMapSizeChangeListener topicMapSizeChangeListener) {
        this.mTopicMapSizeChangeListener = topicMapSizeChangeListener;
        this.mTopicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
    }

    public void setTopicHighlightColor(int i) {
        this.mTopicHighlightColor = i;
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.HighlightAndDeleteRule
    protected void handleTopicHighLight() {
        super.handleTopicHighLight();
        if (this.mTopicMapSizeChangeListener != null) {
            if (!this.mIsPaste) {
                EmojiconHandler.setAddTopicItemListener(this.mAddTopicItemListener);
                if (this.mTargetTopicMap.size() == 0) {
                    if (this.mRangeList != null) {
                        this.mRangeList.clear();
                    }
                    if (this.mChangedStart != -1 || this.mChangedEnd != -1) {
                        this.mChangedStart = -1;
                        this.mChangedEnd = -1;
                        return;
                    }
                    return;
                }
                return;
            }
            this.mIsPaste = false;
            return;
        }
        highLightMatchString();
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.HighlightAndDeleteRule, com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule, com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        handleTopicHighLight();
        if (this.mTopicMapSizeChangeListener != null && i <= this.mChangedStart && this.mTargetTopicMap.size() != 0) {
            this.mChangedStart += i3 - i2;
            this.mChangedEnd += i3 - i2;
            this.mAddTopicItemListener.onAddTopicItem(this.mChangedStart, this.mChangedEnd);
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.HighlightAndDeleteRule
    public void highLightMatchString() {
        Editable text;
        if (this.mEditText != null) {
            if (this.mTopicMapSizeChangeListener != null && this.mChangedStart != -1 && this.mChangedEnd != -1) {
                text = (Editable) this.mEditText.getText().subSequence(this.mChangedStart, this.mChangedEnd);
            } else {
                text = this.mEditText.getText();
            }
            if (!TextUtils.isEmpty(text)) {
                updateRangeList(text.toString());
                if (this.mTopicMapSizeChangeListener != null && this.mRangeList != null && this.mRangeList.size() > 0) {
                    BasePatternRule.Range range = this.mRangeList.get(0);
                    if (this.mChangedStart != -1 && this.mChangedEnd != -1 && this.mChangedStart < this.mChangedEnd) {
                        range.mFrom = this.mChangedStart;
                        range.mTo = this.mChangedEnd;
                    }
                }
                if (this.mRangeList != null) {
                    for (BasePatternRule.Range range2 : this.mRangeList) {
                        try {
                            this.mEditText.getText().setSpan(new ForegroundColorSpan(this.mTopicHighlightColor), range2.mFrom, range2.mTo, 33);
                        } catch (IndexOutOfBoundsException e) {
                            if (DEBUG) {
                                Log.e(TAG, "highLightMatchString-setSpan: 设置高亮文字时数组越界异常 ");
                            }
                        }
                    }
                }
            }
            if (this.mTopicMapSizeChangeListener == null && !TextUtils.isEmpty(this.mPageTopicName)) {
                if (!this.mIsPaste) {
                    highlightRange(this.mPageTopicName);
                } else {
                    this.mIsPaste = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule
    public void updateRangeList(String str) {
        Pattern matchPattern;
        int indexOf;
        if (str != null) {
            if (this.mRangeList != null) {
                this.mRangeList.clear();
            }
            if ((this.mTopicMapSizeChangeListener == null || this.mTargetTopicMap.size() != 0) && (matchPattern = getMatchPattern()) != null) {
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
                            i = group.length() + indexOf;
                            if (this.mRangeList != null) {
                                this.mRangeList.add(new BasePatternRule.Range(indexOf, i, group));
                            }
                            if (this.mTopicMapSizeChangeListener != null && this.mTargetTopicMap.size() == 1) {
                                return;
                            }
                        }
                    } catch (IllegalStateException e) {
                        if (DEBUG) {
                            Log.e(TAG, "字符匹配异常");
                            throw new IllegalStateException("TopicRule: updateRangeList  pattern = " + matchPattern + " text = " + str);
                        }
                        return;
                    }
                }
            }
        }
    }

    private void highlightRange(String str) {
        if (this.mEditText != null) {
            Editable text = this.mEditText.getText();
            if (!TextUtils.isEmpty(text)) {
                try {
                    text.setSpan(new ForegroundColorSpan(this.mHighlightColor), 0, str.length(), 33);
                } catch (IndexOutOfBoundsException e) {
                    if (DEBUG) {
                        Log.e(TAG, "highlightRange-setSpan: 设置高亮区域文字时数组越界异常");
                    }
                }
            }
        }
    }

    private void updateTopicMapFromList(List<TopicItem> list) {
        if (list != null) {
            if (this.mTargetTopicMap != null) {
                this.mTargetTopicMap.clear();
                if (this.mTopicMapSizeChangeListener != null) {
                    this.mTopicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
                }
            }
            for (TopicItem topicItem : list) {
                if (!TextUtils.isEmpty(topicItem.name) && this.mTargetTopicMap != null) {
                    this.mTargetTopicMap.put(topicItem.name, topicItem);
                    if (this.mTopicMapSizeChangeListener != null) {
                        this.mTopicMapSizeChangeListener.onSizeChange(this.mTargetTopicMap.size());
                    }
                }
            }
        }
    }

    private void updateTopicPatternFromMap() {
        this.mTopicPatternStrBuilder.delete(0, this.mTopicPatternStrBuilder.length());
        if (this.mTargetTopicMap != null) {
            for (Map.Entry<String, TopicItem> entry : this.mTargetTopicMap.entrySet()) {
                addTopicPatternFromTopicItem(entry.getValue());
            }
        }
    }

    private void addTopicPatternFromTopicItem(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.mTopicPatternStrBuilder)) {
                this.mTopicPatternStrBuilder.append("|");
            }
            this.mTopicPatternStrBuilder.append("(");
            this.mTopicPatternStrBuilder.append(str);
            this.mTopicPatternStrBuilder.append(")");
        }
    }

    private void addTopicPatternFromTopicItem(TopicItem topicItem) {
        if (topicItem != null) {
            addTopicPatternFromTopicItem(topicItem.name);
        }
    }

    private void deletePatternStrBuilder(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            int indexOf = this.mTopicPatternStrBuilder.indexOf("|(" + str + ")|");
            if (indexOf != -1) {
                this.mTopicPatternStrBuilder.delete(indexOf, (str2.length() + indexOf) - 1);
                return;
            }
            String str3 = "|(" + str + ")";
            int indexOf2 = this.mTopicPatternStrBuilder.indexOf(str3);
            if (indexOf2 != -1) {
                this.mTopicPatternStrBuilder.delete(indexOf2, str3.length() + indexOf2);
                return;
            }
            String str4 = "(" + str + ")|";
            int indexOf3 = this.mTopicPatternStrBuilder.indexOf(str4);
            if (indexOf3 != -1) {
                this.mTopicPatternStrBuilder.delete(indexOf3, str4.length() + indexOf3);
                return;
            }
            String str5 = "(" + str + ")";
            int indexOf4 = this.mTopicPatternStrBuilder.indexOf(str5);
            if (indexOf4 != -1) {
                this.mTopicPatternStrBuilder.delete(indexOf4, str5.length() + indexOf4);
            }
        }
    }
}
