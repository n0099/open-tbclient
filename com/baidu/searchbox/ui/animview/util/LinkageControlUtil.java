package com.baidu.searchbox.ui.animview.util;

import android.util.Log;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class LinkageControlUtil {
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static final String TAG = "LinkageControlUtil";
    public static WeakReference<Object> sBindObj;
    public static WeakReference<ILinkageOpr> sLinkageOpr;

    /* loaded from: classes4.dex */
    public interface ILinkageOpr {
        void disableLinkageScroll();

        void enableLinkageScroll();

        boolean isLinakgeControlling();
    }

    public static void notifyDisableLinkageScroll() {
        WeakReference<ILinkageOpr> weakReference = sLinkageOpr;
        if (weakReference != null && weakReference.get() != null && isPraiseOptimized() && sLinkageOpr.get().isLinakgeControlling()) {
            sLinkageOpr.get().disableLinkageScroll();
        }
    }

    public static void notifyEnableLinkageScroll() {
        WeakReference<ILinkageOpr> weakReference = sLinkageOpr;
        if (weakReference != null && weakReference.get() != null) {
            sLinkageOpr.get().enableLinkageScroll();
        }
    }

    public static void stop() {
        notifyEnableLinkageScroll();
        WeakReference<Object> weakReference = sBindObj;
        if (weakReference != null && weakReference.get() != null) {
            BdEventBus.Companion.getDefault().unregister(sBindObj.get());
        }
    }

    public static boolean isPraiseOptimized() {
        if (ComboPraiseRuntime.getContext() == null) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseOptimized ab switch is false");
                return false;
            }
            return false;
        }
        boolean isPraiseOptimized = ComboPraiseRuntime.getContext().isPraiseOptimized();
        if (DEBUG) {
            Log.d(TAG, "isPraiseOptimized ab switch is " + isPraiseOptimized);
        }
        return isPraiseOptimized;
    }

    public static void start(Object obj, ILinkageOpr iLinkageOpr) {
        if (iLinkageOpr != null && obj != null) {
            sBindObj = new WeakReference<>(obj);
            sLinkageOpr = new WeakReference<>(iLinkageOpr);
            BdEventBus.Companion.getDefault().lazyRegister(obj, CoolPraiseView.PraiseAnimState.class, 1, new Action<CoolPraiseView.PraiseAnimState>() { // from class: com.baidu.searchbox.ui.animview.util.LinkageControlUtil.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.bdeventbus.Action
                public void call(CoolPraiseView.PraiseAnimState praiseAnimState) {
                    int animState;
                    if (praiseAnimState != null && (animState = praiseAnimState.getAnimState()) != 1 && animState != 3) {
                        LinkageControlUtil.notifyEnableLinkageScroll();
                    }
                }
            });
        }
    }
}
