package com.baidu.searchbox.ui.animview.util;

import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import java.lang.ref.WeakReference;
import rx.functions.b;
/* loaded from: classes14.dex */
public class LinkageControlUtil {
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final String TAG = "LinkageControlUtil";
    private static WeakReference<Object> sBindObj;
    private static WeakReference<ILinkageOpr> sLinkageOpr;

    /* loaded from: classes14.dex */
    public interface ILinkageOpr {
        void disableLinkageScroll();

        void enableLinkageScroll();

        boolean isLinakgeControlling();
    }

    public static boolean isPraiseOptimized() {
        if (ComboPraiseRuntime.getContext() == null) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseOptimized ab switch is false");
            }
            return false;
        }
        boolean isPraiseOptimized = ComboPraiseRuntime.getContext().isPraiseOptimized();
        if (DEBUG) {
            Log.d(TAG, "isPraiseOptimized ab switch is " + isPraiseOptimized);
            return isPraiseOptimized;
        }
        return isPraiseOptimized;
    }

    public static void start(Object obj, ILinkageOpr iLinkageOpr) {
        if (iLinkageOpr != null && obj != null) {
            sBindObj = new WeakReference<>(obj);
            sLinkageOpr = new WeakReference<>(iLinkageOpr);
            EventBusWrapper.lazyRegisterOnMainThread(obj, CoolPraiseView.PraiseAnimState.class, new b<CoolPraiseView.PraiseAnimState>() { // from class: com.baidu.searchbox.ui.animview.util.LinkageControlUtil.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(CoolPraiseView.PraiseAnimState praiseAnimState) {
                    if (praiseAnimState == null) {
                        return;
                    }
                    switch (praiseAnimState.getAnimState()) {
                        case 1:
                        case 3:
                            return;
                        case 2:
                        default:
                            LinkageControlUtil.notifyEnableLinkageScroll();
                            return;
                    }
                }
            });
        }
    }

    public static void notifyDisableLinkageScroll() {
        if (sLinkageOpr != null && sLinkageOpr.get() != null && isPraiseOptimized() && sLinkageOpr.get().isLinakgeControlling()) {
            sLinkageOpr.get().disableLinkageScroll();
        }
    }

    public static void notifyEnableLinkageScroll() {
        if (sLinkageOpr != null && sLinkageOpr.get() != null) {
            sLinkageOpr.get().enableLinkageScroll();
        }
    }

    public static void stop() {
        notifyEnableLinkageScroll();
        if (sBindObj != null && sBindObj.get() != null) {
            EventBusWrapper.unregister(sBindObj.get());
        }
    }
}
