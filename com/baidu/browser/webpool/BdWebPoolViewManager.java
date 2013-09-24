package com.baidu.browser.webpool;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdMemUtil;
import com.baidu.browser.webkit.BdWebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class BdWebPoolViewManager {
    public static final int BACKUP_WEBVIEW_COUNT_THRESHOD = 4;
    public static final int BIG_WEBVIEW_COUNT_THRESHOD = 8;
    public static final int DEFAULT_NUM_PER_CREATE = 1;
    public static final float LOW_MEMORY_THRESHOD = 40960.0f;
    public static final int RECYCLE_WEBVIEW_COUNT_PER_WINDOW_THRESHOD = 4;
    public static final int SMALL_WEBVIEW_COUNT_THRESHOD = 16;
    private static BdWebPoolViewManager sInstance;
    public static Comparator<BdWebPoolView> sLastVisitTimeComparator = new Comparator<BdWebPoolView>() { // from class: com.baidu.browser.webpool.BdWebPoolViewManager.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(BdWebPoolView bdWebPoolView, BdWebPoolView bdWebPoolView2) {
            return (int) (bdWebPoolView.getLastVisitTime() - bdWebPoolView2.getLastVisitTime());
        }
    };
    private int mUsedWebViewCount;
    private List<BdWebPoolCustomView> mIdleWebViews = new ArrayList(1);
    private Map<BdWebPoolView, List<BdWebPoolCustomView>> mUsedWebViews = new HashMap();
    private List<BdWebPoolCustomView> mBackupWebViews = new ArrayList(1);

    public static BdWebPoolViewManager getInstance() {
        if (sInstance == null) {
            sInstance = new BdWebPoolViewManager();
        }
        return sInstance;
    }

    private BdWebPoolViewManager() {
    }

    public BdWebPoolCustomView getIdleWebView(Context context, BdWebPoolView bdWebPoolView) {
        BdWebPoolCustomView bdWebPoolCustomView;
        if (isLowMemory()) {
            freeMemory();
        }
        BdWebPoolCustomView bdWebPoolCustomView2 = null;
        if (this.mIdleWebViews.size() > 0) {
            bdWebPoolCustomView2 = this.mIdleWebViews.remove(0);
        } else if (bdWebPoolView.isCanUseBackupWebView() && this.mBackupWebViews.size() > 0) {
            BdLog.i("fetch backup webview.");
            bdWebPoolCustomView2 = this.mBackupWebViews.remove(0);
        }
        if (bdWebPoolCustomView2 == null) {
            for (int i = 0; i < 1; i++) {
                createWebView(context);
            }
            bdWebPoolCustomView = this.mIdleWebViews.remove(0);
        } else {
            bdWebPoolCustomView = bdWebPoolCustomView2;
        }
        this.mUsedWebViewCount++;
        bdWebPoolCustomView.setWebPoolView(bdWebPoolView);
        List<BdWebPoolCustomView> list = this.mUsedWebViews.get(bdWebPoolView);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(bdWebPoolCustomView);
        this.mUsedWebViews.put(bdWebPoolView, list);
        return bdWebPoolCustomView;
    }

    public int getUsedWebViewCount() {
        BdLog.i("UsedWebViewCount: " + this.mUsedWebViewCount);
        return this.mUsedWebViewCount;
    }

    private void createWebView(Context context) {
        this.mIdleWebViews.add(new BdWebPoolCustomView(context, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onWebViewDestory(BdWebPoolView bdWebPoolView, BdWebView bdWebView) {
        this.mUsedWebViewCount--;
        List<BdWebPoolCustomView> list = this.mUsedWebViews.get(bdWebPoolView);
        list.remove(bdWebView);
        if (list.size() == 0) {
            this.mUsedWebViews.remove(bdWebPoolView);
        }
    }

    private boolean isLowMemory() {
        Map<String, Long> sysMemoryInfo = BdMemUtil.getSysMemoryInfo();
        long longValue = sysMemoryInfo.get(BdMemUtil.FIELDS_SYS_MEMINFO[0]).longValue();
        long longValue2 = sysMemoryInfo.get(BdMemUtil.FIELDS_SYS_MEMINFO[1]).longValue();
        long longValue3 = sysMemoryInfo.get(BdMemUtil.FIELDS_SYS_MEMINFO[2]).longValue();
        long longValue4 = sysMemoryInfo.get(BdMemUtil.FIELDS_SYS_MEMINFO[3]).longValue();
        long j = longValue2 + longValue3 + longValue4;
        BdLog.i(String.valueOf(longValue2) + "," + longValue3 + "," + longValue4);
        BdLog.i(String.valueOf(longValue) + "," + j);
        if (((float) j) < 40960.0f) {
            BdLog.w("app is low memory.");
            return true;
        }
        return false;
    }

    private void recycleSinglePool(int i) {
        int i2 = 0;
        BdWebPoolView bdWebPoolView = null;
        ArrayList arrayList = new ArrayList(this.mUsedWebViews.keySet());
        Collections.sort(arrayList, sLastVisitTimeComparator);
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= this.mUsedWebViews.size()) {
                break;
            }
            if (bdWebPoolView == null) {
                bdWebPoolView = getLeastUsedPool(arrayList, -1);
            } else {
                bdWebPoolView = getLeastUsedPool(arrayList, arrayList.indexOf(bdWebPoolView));
            }
            if (bdWebPoolView != null) {
                BdLog.i("find recycle pool: " + bdWebPoolView);
                i = bdWebPoolView.recycleBgWebViews(i);
                if (i <= 0) {
                    break;
                }
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        if (i > 0) {
            BdLog.w("still remian " + i + " webview not to recycle.");
        }
    }

    private void recycleMultiPool(int i) {
        BdLog.i("Pool Size: " + this.mUsedWebViews.size());
        ArrayList arrayList = new ArrayList(this.mUsedWebViews.keySet());
        Collections.sort(arrayList, sLastVisitTimeComparator);
        recycleMultiPool(arrayList, i, true);
    }

    private void recycleMultiPool(List<BdWebPoolView> list, int i, boolean z) {
        BdWebPoolView bdWebPoolView = null;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= this.mUsedWebViews.size()) {
                break;
            }
            if (bdWebPoolView == null) {
                bdWebPoolView = getLeastUsedPool(list, -1);
            } else {
                bdWebPoolView = getLeastUsedPool(list, list.indexOf(bdWebPoolView));
            }
            if (bdWebPoolView != null) {
                BdLog.i("find recycle pool: " + bdWebPoolView);
                if (z) {
                    i = bdWebPoolView.recycleBgWebViewsWithLimit(i);
                } else {
                    i = bdWebPoolView.recycleBgWebViews(i);
                }
                if (i <= 0) {
                    break;
                }
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        if (i > 0) {
            BdLog.w("still remian " + i + " webview to recycle.");
            if (z) {
                recycleMultiPool(list, i, false);
            }
        }
    }

    public BdWebPoolView getLeastUsedPool(List<BdWebPoolView> list, int i) {
        BdWebPoolView bdWebPoolView = null;
        int i2 = i + 1;
        while (true) {
            if (i2 < list.size()) {
                bdWebPoolView = list.get(i2);
                if (bdWebPoolView.isForeground()) {
                    i2++;
                } else {
                    BdLog.i("LeastUsedPool in pos: " + i2);
                    break;
                }
            } else {
                break;
            }
        }
        return bdWebPoolView;
    }

    public void detectPoolUseCondition(byte b) {
        if (isUseMutiPool()) {
            detectPoolUseConditionInMultiPool(b);
        } else {
            detectPoolUseConditionInSinglePool(b);
        }
    }

    private void detectPoolUseConditionInMultiPool(byte b) {
        int usedWebViewCount = getInstance().getUsedWebViewCount();
        int i = 0;
        if (b == 1 && usedWebViewCount > 8) {
            i = usedWebViewCount - 8;
        } else if (b == 2 && usedWebViewCount > 16) {
            i = usedWebViewCount / 2;
        }
        BdLog.i("recycleCount: " + i);
        if (i > 0) {
            recycleMultiPool(i);
        }
    }

    private void detectPoolUseConditionInSinglePool(byte b) {
        int usedWebViewCount = getInstance().getUsedWebViewCount();
        int i = 0;
        if (b == 1 && usedWebViewCount > 8) {
            i = usedWebViewCount - 8;
        } else if (b == 2 && usedWebViewCount > 16) {
            i = usedWebViewCount - 16;
        }
        BdLog.i("recycleCount: " + i);
        if (i > 0) {
            recycleSinglePool(i);
        }
    }

    private boolean isUseMutiPool() {
        int size = this.mUsedWebViews.size();
        if (size > 1) {
            int i = 0;
            for (BdWebPoolView bdWebPoolView : this.mUsedWebViews.keySet()) {
                if (bdWebPoolView.isBlankView()) {
                    i++;
                }
            }
            return size - i > 1;
        }
        return false;
    }

    private void freeMemory() {
        for (BdWebPoolView bdWebPoolView : this.mUsedWebViews.keySet()) {
            bdWebPoolView.freeMemory();
        }
    }

    public void reuseWebView(BdWebPoolCustomView bdWebPoolCustomView) {
        this.mBackupWebViews.add(bdWebPoolCustomView);
        BdLog.i("[5583]" + this.mBackupWebViews.size());
        if (this.mBackupWebViews.size() > 8) {
            while (this.mBackupWebViews.size() > 4) {
                this.mBackupWebViews.remove(0).destroy();
            }
        }
    }
}
