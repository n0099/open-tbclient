package com.baidu.searchbox.ui.bubble;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class BubbleHistory {
    private static BubbleHistory sInstance;
    private List<String> mBubbleHistoryTxtList = new ArrayList();
    private List<String> mOpHisList = new ArrayList();

    private BubbleHistory() {
    }

    public static BubbleHistory getInstance() {
        if (sInstance == null) {
            synchronized (BubbleHistory.class) {
                if (sInstance == null) {
                    sInstance = new BubbleHistory();
                }
            }
        }
        return sInstance;
    }

    public synchronized void trackBubbleHistory(String str) {
        if (this.mBubbleHistoryTxtList != null) {
            this.mBubbleHistoryTxtList.add(str);
        }
    }

    public synchronized void trackBubbleOpHistory(String str) {
        if (this.mOpHisList != null) {
            this.mOpHisList.add(str);
        }
    }

    public List getBubbleHistory() {
        return this.mBubbleHistoryTxtList;
    }

    public List getBubbleOpHistory() {
        return this.mOpHisList;
    }

    public static void release() {
        if (sInstance != null && sInstance.mBubbleHistoryTxtList != null && sInstance.mOpHisList != null) {
            sInstance.mBubbleHistoryTxtList.clear();
            sInstance.mOpHisList.clear();
            sInstance.mBubbleHistoryTxtList = null;
            sInstance.mOpHisList = null;
        }
    }
}
