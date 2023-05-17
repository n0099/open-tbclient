package com.baidu.searchbox.ui.bubble;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BubbleHistory {
    public static BubbleHistory sInstance;
    public List<String> mBubbleHistoryTxtList = new ArrayList();
    public List<String> mOpHisList = new ArrayList();

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

    public static void release() {
        List<String> list;
        BubbleHistory bubbleHistory = sInstance;
        if (bubbleHistory != null && (list = bubbleHistory.mBubbleHistoryTxtList) != null && bubbleHistory.mOpHisList != null) {
            list.clear();
            sInstance.mOpHisList.clear();
            BubbleHistory bubbleHistory2 = sInstance;
            bubbleHistory2.mBubbleHistoryTxtList = null;
            bubbleHistory2.mOpHisList = null;
        }
    }

    public List getBubbleHistory() {
        return this.mBubbleHistoryTxtList;
    }

    public List getBubbleOpHistory() {
        return this.mOpHisList;
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
}
