package com.baidu.searchbox.live.service;

import android.content.Intent;
import android.view.View;
import com.baidu.live.arch.api.IService;
import com.baidu.searchbox.live.frame.IntentData;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/live/service/ILivePageInfoInterface;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "", "finishActivity", "()V", "Landroid/view/View;", "getLiveRootView", "()Landroid/view/View;", "Landroid/content/Intent;", "getSchemeIntent", "()Landroid/content/Intent;", "Lcom/baidu/searchbox/live/frame/IntentData;", "getSchemeIntentData", "()Lcom/baidu/searchbox/live/frame/IntentData;", "", "isInsertVideo", "()Z", "scrollToNext", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ILivePageInfoInterface extends IService {
    void finishActivity();

    View getLiveRootView();

    Intent getSchemeIntent();

    IntentData getSchemeIntentData();

    boolean isInsertVideo();

    void scrollToNext();
}
