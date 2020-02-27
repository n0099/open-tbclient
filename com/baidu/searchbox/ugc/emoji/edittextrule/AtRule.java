package com.baidu.searchbox.ugc.emoji.edittextrule;

import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/* loaded from: classes13.dex */
public class AtRule extends HighlightAndDeleteRule {
    private static final String AT_PATTERN = "@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+";
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "AtRule";
    private final Map<String, AtUserInfoItem> mUserInfoMap;

    public AtRule(EditText editText) {
        super(editText);
        this.mUserInfoMap = new HashMap();
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public Pattern getMatchPattern() {
        try {
            return Pattern.compile(AT_PATTERN);
        } catch (PatternSyntaxException e) {
            return null;
        }
    }

    public void setRuleFromUserInfoList(List<AtUserInfoItem> list) {
        updateUserInfoMapFromList(list);
    }

    public void addAtItem(AtUserInfoItem atUserInfoItem) {
        if (atUserInfoItem != null && !this.mUserInfoMap.containsKey(atUserInfoItem.nickname)) {
            this.mUserInfoMap.put(atUserInfoItem.nickname, atUserInfoItem);
        }
    }

    public void obtainUserInfoList(List<AtUserInfoItem> list) {
        if (list != null) {
            list.clear();
            for (Map.Entry<String, AtUserInfoItem> entry : this.mUserInfoMap.entrySet()) {
                list.add(entry.getValue());
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.HighlightAndDeleteRule
    protected void beforeDeletePatternText(String str) {
        if (this.mUserInfoMap != null && str != null) {
            boolean z = false;
            Iterator<BasePatternRule.Range> it = this.mRangeList.iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    if (!it.next().mText.equals(str)) {
                        z = z2;
                    } else if (!z2) {
                        z = true;
                    } else {
                        return;
                    }
                } else {
                    this.mUserInfoMap.remove(str);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule
    public void updateRangeList(String str) {
        int indexOf;
        if (str != null) {
            if (this.mRangeList != null) {
                this.mRangeList.clear();
            }
            Pattern matchPattern = getMatchPattern();
            if (matchPattern != null) {
                Matcher matcher = matchPattern.matcher(str);
                int i = -1;
                while (matcher.find()) {
                    try {
                        String group = matcher.group();
                        if (!TextUtils.isEmpty(group) && (this.mUserInfoMap == null || this.mUserInfoMap.containsKey(group))) {
                            if (i != -1) {
                                indexOf = str.indexOf(group, i);
                            } else {
                                indexOf = str.indexOf(group);
                            }
                            i = group.length() + indexOf;
                            if (this.mRangeList != null) {
                                this.mRangeList.add(new BasePatternRule.Range(indexOf, i, group));
                            }
                        }
                    } catch (IllegalStateException e) {
                        if (DEBUG) {
                            Log.e(TAG, "字符匹配异常");
                            throw new IllegalStateException("AtRule: updateRangeList  pattern = " + matchPattern + " text = " + str);
                        }
                        return;
                    }
                }
            }
        }
    }

    private void updateUserInfoMapFromList(List<AtUserInfoItem> list) {
        if (list != null && this.mUserInfoMap != null) {
            this.mUserInfoMap.clear();
            for (AtUserInfoItem atUserInfoItem : list) {
                if (!TextUtils.isEmpty(atUserInfoItem.nickname)) {
                    this.mUserInfoMap.put(atUserInfoItem.nickname, atUserInfoItem);
                }
            }
        }
    }
}
