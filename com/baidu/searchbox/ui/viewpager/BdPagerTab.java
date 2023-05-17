package com.baidu.searchbox.ui.viewpager;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class BdPagerTab {
    public boolean mBoldWhenSelect;
    public int mIconResId;
    public String mId;
    public String mNewCount;
    public String mTitle;
    public int mTextSize = 20;
    public int mTextColor = -1;
    public int mSelTextColor = -1;
    public ColorStateList mColorStateList = null;
    public int mTabBackgroundResId = 0;
    public BdPagerTab mParentTab = null;
    public ArrayList<BdPagerTab> mSubTabs = null;
    public int mSelSubTabIndex = 0;
    public int mSubTabStartIndex = 0;
    public int mSubTabEndIndex = 0;
    public boolean mIsForPlaceholder = false;
    public boolean mIsNew = false;

    public ColorStateList getColorStateList() {
        return this.mColorStateList;
    }

    public int getIconResId() {
        return this.mIconResId;
    }

    public String getId() {
        return this.mId;
    }

    public String getNewCount() {
        return this.mNewCount;
    }

    public BdPagerTab getParentTab() {
        return this.mParentTab;
    }

    public int getSelSubTabIndex() {
        return this.mSelSubTabIndex;
    }

    public int getSelTextColor() {
        return this.mSelTextColor;
    }

    public int getSubTabCount() {
        ArrayList<BdPagerTab> arrayList = this.mSubTabs;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public int[] getSubTabIndexRange() {
        return new int[]{this.mSubTabStartIndex, this.mSubTabEndIndex};
    }

    public List<BdPagerTab> getSubTabs() {
        return this.mSubTabs;
    }

    public List<BdPagerTab> getSubTabsByRange() {
        int i = this.mSubTabStartIndex;
        int i2 = this.mSubTabEndIndex;
        if (i2 > i && i2 != 0 && i2 <= this.mSubTabs.size()) {
            return this.mSubTabs.subList(i, i2);
        }
        return this.mSubTabs;
    }

    public int getTabBackgroundResId() {
        return this.mTabBackgroundResId;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isBoldWhenSelect() {
        return this.mBoldWhenSelect;
    }

    public boolean isForPlaceholder() {
        return this.mIsForPlaceholder;
    }

    public boolean isNew() {
        return this.mIsNew;
    }

    public String toString() {
        return "title = " + this.mTitle + ", id = " + this.mId + ", obj = " + super.toString();
    }

    public BdPagerTab addSubTab(BdPagerTab bdPagerTab) {
        if (this.mSubTabs == null) {
            this.mSubTabs = new ArrayList<>();
        }
        if (bdPagerTab != null) {
            bdPagerTab.mParentTab = this;
            this.mSubTabs.add(bdPagerTab);
            this.mSubTabEndIndex = this.mSubTabs.size();
        }
        return this;
    }

    public BdPagerTab getSubTabAt(int i) {
        ArrayList<BdPagerTab> arrayList = this.mSubTabs;
        if (arrayList != null && i >= 0 && i < arrayList.size()) {
            return this.mSubTabs.get(i);
        }
        return null;
    }

    public BdPagerTab setBoldWhenSelect(boolean z) {
        this.mBoldWhenSelect = z;
        return this;
    }

    public BdPagerTab setColorStateList(ColorStateList colorStateList) {
        this.mColorStateList = colorStateList;
        return this;
    }

    public BdPagerTab setIconResId(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdPagerTab setId(String str) {
        this.mId = str;
        return this;
    }

    public void setIsForPlaceholder(boolean z) {
        this.mIsForPlaceholder = z;
    }

    public void setIsNew(boolean z) {
        this.mIsNew = z;
    }

    public void setNewCount(String str) {
        this.mNewCount = str;
    }

    public void setNewCountMax99(int i) {
        String valueOf;
        if (i <= 0) {
            this.mNewCount = "";
            return;
        }
        if (i > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(i);
        }
        this.mNewCount = valueOf;
    }

    public void setSelSubTabIndex(int i) {
        this.mSelSubTabIndex = i;
    }

    public BdPagerTab setSelTextColor(int i) {
        this.mSelTextColor = i;
        return this;
    }

    public BdPagerTab setTabBackgroundResId(int i) {
        this.mTabBackgroundResId = i;
        return this;
    }

    public BdPagerTab setTextColor(int i) {
        this.mTextColor = i;
        return this;
    }

    public BdPagerTab setTextSize(int i) {
        this.mTextSize = i;
        return this;
    }

    public BdPagerTab setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public String getFormatTitle() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mTitle)) {
            sb.append(this.mTitle);
        }
        BdPagerTab bdPagerTab = this.mParentTab;
        if (bdPagerTab != null) {
            while (bdPagerTab != null) {
                sb.insert(0, bdPagerTab.getTitle() + ",");
                bdPagerTab = bdPagerTab.getParentTab();
            }
        }
        if (sb.length() == 0) {
            sb.append(toString());
        }
        return sb.toString();
    }

    public boolean needSelected(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equalsIgnoreCase(this.mId)) {
            return true;
        }
        ArrayList<BdPagerTab> arrayList = this.mSubTabs;
        if (arrayList != null) {
            Iterator<BdPagerTab> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().needSelected(str)) {
                    this.mSelSubTabIndex = i;
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public void setSubTabIndexRange(int i, int i2) {
        this.mSubTabStartIndex = i;
        this.mSubTabEndIndex = i2;
    }
}
