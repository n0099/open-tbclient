package com.baidu.live.mix.interfaces;

import android.app.Activity;
import com.baidu.live.mix.MixLiveItemModel;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0019\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "Lkotlin/Any;", "", "pos", "templateId", "Lcom/baidu/live/mix/MixLiveItemModel;", "model", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "getCell", "(IILcom/baidu/live/mix/MixLiveItemModel;)Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "Lcom/baidu/live/mix/interfaces/MixLiveGestureInterface;", "getGestureInterface", "()Lcom/baidu/live/mix/interfaces/MixLiveGestureInterface;", "Lcom/baidu/live/mix/interfaces/MixLiveScrollInterface;", "getScrollInterface", "()Lcom/baidu/live/mix/interfaces/MixLiveScrollInterface;", "Landroid/app/Activity;", "activity", "", "onActivityCreate", "(Landroid/app/Activity;)V", "onActivityDestroy", "onActivityPause", "onActivityResume", "onActivityStart", "onActivityStop", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixLiveSingletonManagerInterface {
    MixLiveInterface getCell(int i, int i2, MixLiveItemModel mixLiveItemModel);

    MixLiveGestureInterface getGestureInterface();

    MixLiveScrollInterface getScrollInterface();

    void onActivityCreate(Activity activity);

    void onActivityDestroy(Activity activity);

    void onActivityPause(Activity activity);

    void onActivityResume(Activity activity);

    void onActivityStart(Activity activity);

    void onActivityStop(Activity activity);
}
