package com.baidu.searchbox.ui.view;

import android.content.Context;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes10.dex */
public class BadgeFactory {
    public static BadgeView createDot(Context context) {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setId(R.id.badge_view);
        badgeView.setHideOnNull(false);
        badgeView.setBadgeGravity(53);
        badgeView.setBadgeCount("");
        badgeView.setWidthAndHeight(7, 7);
        badgeView.setBadgeMargin(5, 10, 0, 0);
        badgeView.setBackground(context.getResources().getDrawable(R.drawable.common_badge));
        return badgeView;
    }

    public static BadgeView createDot(Context context, int i, int i2, int i3, int i4) {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setId(R.id.badge_view);
        badgeView.setHideOnNull(false);
        badgeView.setBadgeGravity(53);
        badgeView.setBadgeCount("");
        badgeView.setWidthAndHeight(7, 7);
        badgeView.setBadgeMargin(i, i2, i3, i4);
        badgeView.setBackground(context.getResources().getDrawable(R.drawable.common_badge));
        return badgeView;
    }

    private static BadgeView createRoundRectangle(Context context) {
        BadgeView badgeView = new BadgeView(context);
        badgeView.setBadgeCount(0);
        return badgeView;
    }

    public static BadgeView createMainTabBadge(Context context, boolean z) {
        BadgeView createRoundRectangle = createRoundRectangle(context);
        createRoundRectangle.setTextSize(1, 10.0f);
        if (z) {
            createRoundRectangle.setBadgeMargin(13, 5, 0, 0);
        } else {
            createRoundRectangle.setBadgeMargin(13, 3, 0, 0);
        }
        createRoundRectangle.setBadgeGravity(49);
        createRoundRectangle.setBackground(context.getResources().getDrawable(R.drawable.common_badge_default_bg));
        return createRoundRectangle;
    }

    public static BadgeView createMainTabBadge(Context context, int i, int i2, int i3, int i4, int i5) {
        BadgeView createRoundRectangle = createRoundRectangle(context);
        createRoundRectangle.setBadgeCount("");
        createRoundRectangle.setTextSize(1, i);
        createRoundRectangle.setBadgeMargin(i2, i3, i4, i5);
        createRoundRectangle.setBadgeGravity(49);
        createRoundRectangle.setBackground(context.getResources().getDrawable(R.drawable.common_badge_default_bg));
        return createRoundRectangle;
    }

    public static BadgeView createTopMainTabBadge(Context context, int i) {
        BadgeView createRoundRectangle = createRoundRectangle(context);
        createRoundRectangle.setBadgeCount("10+");
        createRoundRectangle.setTextSize(1, 10.0f);
        createRoundRectangle.setBadgeMargin(DeviceUtil.ScreenInfo.px2dp(context, i) - 12, 3, 0, 0);
        createRoundRectangle.setBadgeGravity(51);
        createRoundRectangle.setBackground(context.getResources().getDrawable(R.drawable.common_badge_default_bg));
        return createRoundRectangle;
    }

    public static BadgeView createMenuBadge(Context context) {
        BadgeView createRoundRectangle = createRoundRectangle(context);
        createRoundRectangle.setTextSize(1, 10.0f);
        createRoundRectangle.setBadgeGravity(53);
        createRoundRectangle.setBackground(context.getResources().getDrawable(R.drawable.common_badge_default_bg));
        return createRoundRectangle;
    }
}
