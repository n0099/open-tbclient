package com.baidu.searchbox.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BadgeFactory {
    public static BadgeView createBadgeView(Context context, BadgeView.Type type) {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setId(R.id.obfuscated_res_0x7f090331);
        badgeView.setType(type);
        badgeView.setIncludeFontPadding(false);
        return badgeView;
    }

    @Deprecated
    public static BadgeView createMainTabBadge(Context context, boolean z) {
        BadgeView createBadgeView;
        if (z) {
            createBadgeView = createBadgeView(context, BadgeView.Type.SMALL_TEXT, 49, 13, 5, 0, 0);
        } else {
            createBadgeView = createBadgeView(context, BadgeView.Type.SMALL_TEXT, 49, 13, 3, 0, 0);
        }
        createBadgeView.setId(R.id.obfuscated_res_0x7f090331);
        return createBadgeView;
    }

    @SuppressLint({"SetTextI18n"})
    @Deprecated
    public static BadgeView createTopMainTabBadge(Context context, int i) {
        BadgeView createBadgeView = createBadgeView(context, BadgeView.Type.SMALL_TEXT, 51, DeviceUtil.ScreenInfo.px2dp(context, i) - 12, 3, 0, 0);
        createBadgeView.setId(R.id.obfuscated_res_0x7f090331);
        createBadgeView.setText("10+");
        return createBadgeView;
    }

    public static BadgeView createBadgeView(Context context, BadgeView.Type type, int i, int i2, int i3, int i4, int i5) {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setId(R.id.obfuscated_res_0x7f090331);
        badgeView.setType(type);
        badgeView.setIncludeFontPadding(false);
        badgeView.setBadgeMargin(i2, i3, i4, i5);
        return badgeView;
    }

    public static BadgeView createBadgeViewInPx(Context context, BadgeView.Type type, int i, int i2, int i3, int i4, int i5) {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setId(R.id.obfuscated_res_0x7f090331);
        badgeView.setType(type);
        badgeView.setIncludeFontPadding(false);
        badgeView.setBadgeMarginInPx(i2, i3, i4, i5);
        return badgeView;
    }

    @Deprecated
    public static BadgeView createDot(Context context) {
        return createBadgeView(context, BadgeView.Type.DOT, 53, 5, 10, 0, 0);
    }

    public static BadgeView createMenuBadge(Context context) {
        return createBadgeView(context, BadgeView.Type.SMALL_TEXT, 53, 0, 0, 0, 0);
    }

    @Deprecated
    public static BadgeView createDot(Context context, int i, int i2, int i3, int i4) {
        return createBadgeView(context, BadgeView.Type.DOT, 53, i, i2, i3, i4);
    }

    @Deprecated
    public static BadgeView createMainTabBadge(Context context, int i, int i2, int i3, int i4, int i5) {
        return createBadgeView(context, BadgeView.Type.SMALL_TEXT, 49, i2, i3, i4, i5);
    }
}
