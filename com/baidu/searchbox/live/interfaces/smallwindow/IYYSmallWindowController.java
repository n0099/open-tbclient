package com.baidu.searchbox.live.interfaces.smallwindow;

import android.app.Activity;
import com.baidu.searchbox.live.interfaces.service.FloatingService;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0007J3\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController;", "Lkotlin/Any;", "", "closeSmallWindow", "()V", "", "getSmallWindowSwitch", "()Z", "", "", "params", "Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController$IPlayController;", "controller", "onChangeToSmallWindow", "(Ljava/util/Map;Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController$IPlayController;)V", "querySmallWindowPlayingStatus", "switchOn", "Landroid/app/Activity;", "activity", "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionResultListener;", "resultListener", "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionCancelListener;", "cancelListener", "setSmallWindowSwitch", "(ZLandroid/app/Activity;Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionResultListener;Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionCancelListener;)V", "IPlayController", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IYYSmallWindowController {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController$IPlayController;", "Lkotlin/Any;", "", "endPlay", "()V", "pausePlay", "resumePlay", "startPlay", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface IPlayController {
        void endPlay();

        void pausePlay();

        void resumePlay();

        void startPlay();
    }

    void closeSmallWindow();

    boolean getSmallWindowSwitch();

    void onChangeToSmallWindow(Map<String, String> map, IPlayController iPlayController);

    boolean querySmallWindowPlayingStatus();

    void setSmallWindowSwitch(boolean z, Activity activity, FloatingService.OnPermissionResultListener onPermissionResultListener, FloatingService.OnPermissionCancelListener onPermissionCancelListener);
}
