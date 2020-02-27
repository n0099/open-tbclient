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
import com.baidu.searchbox.ugc.model.LinkInfoItem;
import com.baidu.searchbox.ugc.view.CenterAlignImageSpan;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class LinkRule extends HighlightAndDeleteRule {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "LinkRule";
    private final List<LinkInfoItem> mLinkInfoItemList;
    private List<BasePatternRule.Range> mRangeListOriginal;

    public LinkRule(EditText editText) {
        super(editText);
        this.mLinkInfoItemList = new ArrayList();
        this.mRangeListOriginal = new ArrayList();
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public Pattern getMatchPattern() {
        return null;
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.HighlightAndDeleteRule
    protected void beforeDeletePatternText(String str) {
        if (!TextUtils.isEmpty(str) && this.mRangeList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mRangeList.size()) {
                    if (!str.equals(this.mRangeList.get(i2).mText)) {
                        i = i2 + 1;
                    } else {
                        this.mRangeList.remove(i2);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void initRangeList(String str, List<BasePatternRule.Range> list) {
        if (str != null && this.mLinkInfoItemList != null) {
            list.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mLinkInfoItemList.size()) {
                    int indexOf = str.indexOf(this.mLinkInfoItemList.get(i2).linkKey);
                    while (true) {
                        int i3 = indexOf;
                        if (i3 != -1) {
                            list.add(new BasePatternRule.Range(i3, i3 + this.mLinkInfoItemList.get(i2).linkKey.length(), this.mLinkInfoItemList.get(i2).linkKey));
                            indexOf = str.indexOf(this.mLinkInfoItemList.get(i2).linkKey, i3 + 1);
                        }
                    }
                    i = i2 + 1;
                } else {
                    reorderRangelist(list);
                    return;
                }
            }
        }
    }

    private void reorderRangelist(List<BasePatternRule.Range> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int i2 = 0; i2 < list.size() - 1; i2++) {
                if (list.get(i2).mFrom > list.get(i2 + 1).mFrom) {
                    int i3 = list.get(i2).mFrom;
                    list.get(i2).mFrom = list.get(i2 + 1).mFrom;
                    list.get(i2 + 1).mFrom = i3;
                    int i4 = list.get(i2).mTo;
                    list.get(i2).mTo = list.get(i2 + 1).mTo;
                    list.get(i2 + 1).mTo = i4;
                    String str = list.get(i2).mText;
                    list.get(i2).mText = list.get(i2 + 1).mText;
                    list.get(i2 + 1).mText = str;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule
    public void updateRangeList(String str) {
    }

    public void formatLinkStrRange() {
        if (this.mEditText != null && this.mLinkInfoItemList != null && this.mLinkInfoItemList.size() > 0) {
            Editable text = this.mEditText.getText();
            if (!TextUtils.isEmpty(text)) {
                String obj = text.toString();
                initRangeList(obj, this.mRangeListOriginal);
                this.mEditText.setText(converStrListToString(getReplacedStrList(obj)));
                highLight();
            }
        }
    }

    public String formatReferenceTitle(String str) {
        if (TextUtils.isEmpty(str) || this.mLinkInfoItemList == null || this.mLinkInfoItemList.size() <= 0) {
            return null;
        }
        String converStrListToString = converStrListToString(getReplacedStrList(str));
        if (TextUtils.isEmpty(converStrListToString) || converStrListToString.length() <= 2) {
            return null;
        }
        return converStrListToString.substring(2, converStrListToString.length());
    }

    private List<String> getReplacedStrList(String str) {
        String firstReplaceContent;
        int length;
        initRangeList(str, this.mRangeList);
        List<String> initContentStrList = initContentStrList(str);
        List<Integer> initInsertPosList = initInsertPosList();
        for (int i = 0; i < initInsertPosList.size(); i++) {
            try {
                firstReplaceContent = getFirstReplaceContent(i);
                length = this.mRangeList.get(i).mText.length();
            } catch (IndexOutOfBoundsException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(firstReplaceContent)) {
                return null;
            }
            initContentStrList.add(initInsertPosList.get(i).intValue(), firstReplaceContent);
            for (int i2 = 0; i2 < length; i2++) {
                initContentStrList.remove(initInsertPosList.get(i).intValue() - length);
            }
            for (int i3 = i + 1; i3 < initInsertPosList.size(); i3++) {
                initInsertPosList.set(i3, Integer.valueOf(initInsertPosList.get(i3).intValue() - length));
            }
            this.mRangeList.get(i).mText = firstReplaceContent;
            this.mRangeList.get(i).mFrom = this.mRangeList.get(i).mTo - length;
            this.mRangeList.get(i).mTo += firstReplaceContent.length() - length;
            int i4 = i + 1;
            while (true) {
                int i5 = i4;
                if (i5 < this.mRangeList.size()) {
                    this.mRangeList.get(i5).mFrom += firstReplaceContent.length() - length;
                    this.mRangeList.get(i5).mTo += firstReplaceContent.length() - length;
                    i4 = i5 + 1;
                }
            }
        }
        return initContentStrList;
    }

    public String formatInputStr(String str) {
        String secondReplaceContent;
        int length;
        if (!TextUtils.isEmpty(str) && this.mRangeList != null && this.mRangeList.size() > 0 && this.mLinkInfoItemList != null) {
            List<String> initContentStrList = initContentStrList(str);
            List<Integer> initInsertPosList = initInsertPosList();
            for (int i = 0; i < initInsertPosList.size(); i++) {
                try {
                    secondReplaceContent = getSecondReplaceContent(i);
                    length = this.mRangeList.get(i).mText.length();
                } catch (IndexOutOfBoundsException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(secondReplaceContent) && length != 0) {
                    initContentStrList.add(initInsertPosList.get(i).intValue(), secondReplaceContent);
                    for (int i2 = 0; i2 < length; i2++) {
                        initContentStrList.remove(initInsertPosList.get(i).intValue() - length);
                    }
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3;
                        if (i4 < initInsertPosList.size()) {
                            initInsertPosList.set(i4, Integer.valueOf(initInsertPosList.get(i4).intValue() - length));
                            i3 = i4 + 1;
                        }
                    }
                } else {
                    return str;
                }
            }
            return converStrListToString(initContentStrList);
        }
        return str;
    }

    private List<String> initContentStrList(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            arrayList.add(String.valueOf(str.charAt(i)));
        }
        return arrayList;
    }

    private List<Integer> initInsertPosList() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mRangeList.size()) {
                arrayList.add(Integer.valueOf(this.mRangeList.get(i2).mTo + i2));
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    private String converStrListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            try {
                sb.append(str);
            } catch (IndexOutOfBoundsException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    private String getFirstReplaceContent(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mLinkInfoItemList.size()) {
                return "";
            }
            if (!this.mRangeList.get(i).mText.equals(this.mLinkInfoItemList.get(i3).linkKey)) {
                i2 = i3 + 1;
            } else {
                return "ic" + this.mLinkInfoItemList.get(i3).linkTitle;
            }
        }
    }

    private String getSecondReplaceContent(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mLinkInfoItemList.size()) {
                return "";
            }
            if (!this.mRangeListOriginal.get(i).mText.substring(1, this.mRangeListOriginal.get(i).mText.length() - 1).equals(this.mLinkInfoItemList.get(i3).linkKey.substring(1, this.mLinkInfoItemList.get(i3).linkKey.length() - 1))) {
                i2 = i3 + 1;
            } else {
                return this.mLinkInfoItemList.get(i3).linkUrl;
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.edittextrule.HighlightAndDeleteRule, com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule, com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.mEditText != null && this.mRangeList != null && this.mRangeList.size() > 0) {
            for (BasePatternRule.Range range : this.mRangeList) {
                if (range.isAfter(i)) {
                    if (i2 == 0 && i3 >= 1) {
                        range.mFrom += i3;
                        range.mTo += i3;
                    } else if (i2 >= 1 && i3 == 0) {
                        range.mFrom -= i2;
                        range.mTo -= i2;
                    }
                }
            }
            highLight();
        }
    }

    private void highLight() {
        int i;
        if (this.mEditText != null) {
            Editable text = this.mEditText.getText();
            if (!TextUtils.isEmpty(text)) {
                for (int i2 = 0; i2 < this.mRangeList.size(); i2++) {
                    try {
                        text.setSpan(new ForegroundColorSpan(this.mHighlightColor), this.mRangeList.get(i2).mFrom, this.mRangeList.get(i2).mTo, 33);
                        String str = "";
                        int i3 = 0;
                        while (true) {
                            if (i3 < this.mLinkInfoItemList.size()) {
                                if (!this.mRangeList.get(i2).mText.substring(2, this.mRangeList.get(i2).mText.length()).equals(this.mLinkInfoItemList.get(i3).linkTitle)) {
                                    i3++;
                                } else {
                                    str = this.mLinkInfoItemList.get(i3).linkResType;
                                }
                            }
                        }
                        char c = 65535;
                        switch (str.hashCode()) {
                            case 3683:
                                if (str.equals("sv")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 1917251572:
                                if (str.equals("img_txt")) {
                                    c = 1;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                i = R.drawable.ugc_publish_content_video_link_icon;
                                break;
                            case 1:
                                i = R.drawable.ugc_publish_content_link_icon;
                                break;
                            default:
                                i = R.drawable.ugc_publish_content_link_icon;
                                break;
                        }
                        text.setSpan(new CenterAlignImageSpan(AppRuntime.getAppContext(), i), this.mRangeList.get(i2).mFrom, this.mRangeList.get(i2).mFrom + 2, 34);
                    } catch (IndexOutOfBoundsException e) {
                        if (DEBUG) {
                            Log.e(TAG, "highLight-setSpan: 设置高亮文字时数组越界异常 ");
                        }
                    }
                }
            }
        }
    }

    public void setLinkInfoItemList(List<LinkInfoItem> list) {
        this.mLinkInfoItemList.clear();
        this.mLinkInfoItemList.addAll(list);
    }
}
