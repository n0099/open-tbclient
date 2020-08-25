package com.baidu.searchbox.suspensionball;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.suspensionwindow.SuspensionListener;
import com.baidu.searchbox.suspensionwindow.SuspensionWindow;
import com.baidu.ubc.Flow;
/* loaded from: classes3.dex */
public class SuspensionWindowController {
    private static Flow mFlow;
    private static long sClickTimeInterval = 1000;
    private static long sPreClickTime;

    private static void create(String str, int i, int i2, int i3) {
        if (!isCreated(str)) {
            final Context appContext = AppRuntime.getAppContext();
            final SuspensionBallView suspensionBallView = new SuspensionBallView(appContext);
            suspensionBallView.setImageResource(R.drawable.suspension_ball);
            suspensionBallView.setTag(R.id.tag_suspension_ball_key, str);
            SuspensionBallEntity entityByKey = SuspensionBallManager.getInstance().getEntityByKey(str);
            if (entityByKey != null) {
                entityByKey.mView = suspensionBallView;
            }
            suspensionBallView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionWindowController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - SuspensionWindowController.sPreClickTime > SuspensionWindowController.sClickTimeInterval) {
                        SuspensionBallManager.getInstance().onBallClick((String) SuspensionBallView.this.getTag(R.id.tag_suspension_ball_key));
                        long unused = SuspensionWindowController.sPreClickTime = currentTimeMillis;
                    }
                }
            });
            NightModeHelper.subscribeNightModeChangeEvent(str, new NightModeChangeListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionWindowController.2
                @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
                public void onNightModeChanged(boolean z) {
                    SuspensionBallView.this.setImageDrawable(appContext.getResources().getDrawable(R.drawable.suspension_ball));
                }
            });
            Rect ballAreaPadding = SuspensionBallManager.getInstance().getBallAreaPadding();
            SuspensionWindow.with(appContext, str).setView(suspensionBallView).setWidth(i3 * 2).setHeight(i3 * 2).setX(i - i3).setY((i2 - i3) - DeviceUtil.ScreenInfo.getStatusBarHeight()).setPadding(ballAreaPadding.left, ballAreaPadding.top, ballAreaPadding.right, ballAreaPadding.bottom).setMoveStyle(200L, null).setSuspensionListener(initSuspensionListener()).build();
        }
    }

    private static SuspensionListener initSuspensionListener() {
        return new SuspensionListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionWindowController.3
            @Override // com.baidu.searchbox.suspensionwindow.SuspensionListener
            public void onStateChange(String str, int i) {
            }

            @Override // com.baidu.searchbox.suspensionwindow.SuspensionListener
            public void onTouchChange(String str, int i, @Nullable Rect rect) {
                if (i == 4) {
                    SuspensionBallEntity entityByKey = SuspensionBallManager.getInstance().getEntityByKey(str);
                    if (entityByKey != null) {
                        if (entityByKey.clickTimes > 0) {
                            SuspensionBallUbc.dragSuspensionBall(SuspensionBallUbc.TYPE_HAVE_CLICK);
                        } else {
                            SuspensionBallUbc.dragSuspensionBall(SuspensionBallUbc.TYPE_NO_CLICK);
                        }
                    }
                    if (rect != null) {
                        int statusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
                        SuspensionBallManager.getInstance().setBallCenterXCoordinate(rect.left + SuspensionBallManager.getInstance().getBallRadius());
                        SuspensionBallManager.getInstance().setBallCenterYCoordinate(statusBarHeight + rect.top + SuspensionBallManager.getInstance().getBallRadius());
                    }
                } else if (i == 5) {
                    SuspensionBallUbc.cancelSuspensionBall(str, SuspensionBallUbc.SOURCE_DRAG);
                    SuspensionBallManager.getInstance().removeSuspensionBall(str);
                }
            }
        };
    }

    public static void show(String str) {
        if (!isCreated(str)) {
            create(str, SuspensionBallManager.getInstance().getBallCenterXCoordinate(), SuspensionBallManager.getInstance().getBallCenterYCoordinate(), SuspensionBallManager.getInstance().getBallRadius());
        }
        if (!isShowing(str)) {
            mFlow = SuspensionBallUbc.startSuspensionBallShow();
            SuspensionWindow.get(str).show();
        }
    }

    public static void hide(String str) {
        if (isShowing(str)) {
            if (mFlow != null) {
                SuspensionBallUbc.endUbcFlow(mFlow);
                mFlow = null;
            }
            SuspensionWindow.get(str).hide();
        }
    }

    public static void replace(String str, String str2) {
        if (isCreated(str)) {
            SuspensionWindow.get(str).setTag(str2);
        }
    }

    public static void destroy(String str) {
        if (!isDestroyed(str)) {
            if (mFlow != null) {
                SuspensionBallUbc.endUbcFlow(mFlow);
                mFlow = null;
            }
            SuspensionWindow.destroy(str);
            NightModeHelper.unsubscribeNightModeChangedEvent(str);
        }
    }

    public static boolean isCreated(String str) {
        return SuspensionWindow.get(str) != null;
    }

    public static boolean isShowing(String str) {
        return isCreated(str) && SuspensionWindow.get(str).isShowing();
    }

    public static boolean isDestroyed(String str) {
        return SuspensionWindow.get(str) == null;
    }
}
