package com.baidu.browser.webpool;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class BdWebPoolBackForwardList {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdWebPoolBackForwardList";
    private int mCurIndex = -1;
    private List mArray = new ArrayList();

    public void addItem(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
        if (bdWebPoolBackForwardListItem != null) {
            this.mArray.add(bdWebPoolBackForwardListItem);
        }
    }

    public void setItem(int i, BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
        if (bdWebPoolBackForwardListItem != null && i >= 0 && i < this.mArray.size()) {
            this.mArray.set(i, bdWebPoolBackForwardListItem);
        }
    }

    public void removeItem(int i) {
        if (i >= 0 && i < this.mArray.size()) {
            this.mArray.remove(i);
        }
    }

    public void removeItem(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
        if (bdWebPoolBackForwardListItem != null) {
            this.mArray.remove(bdWebPoolBackForwardListItem);
        }
    }

    public int getCurIndex() {
        return this.mCurIndex;
    }

    public BdWebPoolBackForwardListItem getCurItem() {
        try {
            return getItem(this.mCurIndex);
        } catch (Exception e) {
            return null;
        }
    }

    public BdWebPoolBackForwardListItem getItem(int i) {
        if (i >= 0 && i < this.mArray.size()) {
            return (BdWebPoolBackForwardListItem) this.mArray.get(i);
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public int getItemIndex(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
        return this.mArray.indexOf(bdWebPoolBackForwardListItem);
    }

    public int getSize() {
        return this.mArray.size();
    }

    public boolean canGoBackOrForward(int i) {
        int i2 = this.mCurIndex + i;
        return i2 >= 0 && i2 < this.mArray.size();
    }

    public boolean canGoBack() {
        return canGoBackOrForward(-1);
    }

    public boolean canGoForward() {
        return canGoBackOrForward(1);
    }

    public void goBackOrForward(int i) {
        if (canGoBackOrForward(i)) {
            this.mCurIndex += i;
        }
    }

    public void goBack() {
        if (canGoBack()) {
            this.mCurIndex--;
        }
    }

    public void goForward() {
        if (canGoForward()) {
            this.mCurIndex++;
        }
    }

    public void goToFirst() {
        this.mCurIndex = 0;
    }

    public void goToLast() {
        this.mCurIndex = this.mArray.size() - 1;
    }

    public void goToIndex(int i) {
        this.mCurIndex = i;
    }

    public void clear() {
        this.mArray.clear();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(getSize()) + "\n");
        for (BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem : this.mArray) {
            if (bdWebPoolBackForwardListItem != null) {
                stringBuffer.append(bdWebPoolBackForwardListItem.getUrl());
                stringBuffer.append(", ");
                stringBuffer.append(bdWebPoolBackForwardListItem.getWebView());
                stringBuffer.append(", ");
                stringBuffer.append(bdWebPoolBackForwardListItem.getIndex());
                stringBuffer.append(", ");
                stringBuffer.append(bdWebPoolBackForwardListItem.getLoadStatus());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }
}
