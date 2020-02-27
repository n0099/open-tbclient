package com.baidu.live.tbadk.util;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class BdListViewHelper {
    public static final int NET_RERESHNEW_TOP_MARGIN = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), a.e.sdk_ds320);

    /* loaded from: classes3.dex */
    public enum HeadType {
        DEFAULT,
        HASTAB,
        HAS_NO_NETWORK_BAR,
        TIP
    }

    public static int getTopMarginWithType(HeadType headType) {
        Context context = TbadkCoreApplication.getInst().getContext();
        switch (headType) {
            case DEFAULT:
                return BdUtilHelper.getDimens(context, a.e.sdk_ds88) + UtilHelper.getLightStatusBarHeight();
            case HASTAB:
                return BdUtilHelper.getDimens(context, a.e.sdk_ds176) + UtilHelper.getLightStatusBarHeight();
            case HAS_NO_NETWORK_BAR:
                return BdUtilHelper.getDimens(context, a.e.sdk_ds168) + UtilHelper.getLightStatusBarHeight();
            case TIP:
                return BdUtilHelper.getDimens(context, a.e.sdk_ds56);
            default:
                return BdUtilHelper.getDimens(context, a.e.sdk_ds88) + UtilHelper.getLightStatusBarHeight();
        }
    }

    public static View initHeader(Context context, BdListView bdListView, HeadType headType) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, getTopMarginWithType(headType)));
        bdListView.addHeaderView(textView, 0);
        return textView;
    }

    public static void hasNetWork(View view, HeadType headType, boolean z) {
        if (view != null && headType != null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (z) {
                layoutParams.height = getTopMarginWithType(headType);
            } else if (HeadType.DEFAULT == headType) {
                layoutParams.height = BdUtilHelper.getDimens(context, a.e.sdk_ds170) + UtilHelper.getLightStatusBarHeight();
            } else {
                layoutParams.height = BdUtilHelper.getDimens(context, a.e.sdk_ds240) + UtilHelper.getLightStatusBarHeight();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static int getTopMarginWithTypeAndNetworkState(HeadType headType, boolean z) {
        Context context = TbadkCoreApplication.getInst().getContext();
        if (z) {
            return getTopMarginWithType(headType);
        }
        if (HeadType.DEFAULT == headType) {
            return BdUtilHelper.getDimens(context, a.e.sdk_ds170) + UtilHelper.getLightStatusBarHeight();
        }
        return BdUtilHelper.getDimens(context, a.e.sdk_ds240) + UtilHelper.getLightStatusBarHeight();
    }
}
