package com.baidu.searchbox.live.host2live.video;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "Lkotlin/Any;", "", "destroyLive", "()V", "", "Lcom/baidu/searchbox/live/host2live/video/ScrollDir;", "dirs", "", "enable", "enablePageScroll", "(Ljava/util/List;Z)V", "finishActivity", "scrollToNext", MapBundleKey.MapObjKey.OBJ_DIR, "scrollToNextNoDelete", "(Lcom/baidu/searchbox/live/host2live/video/ScrollDir;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ILiveToListInvokeAbility {
    void destroyLive();

    void enablePageScroll(List<? extends ScrollDir> list, boolean z);

    void finishActivity();

    void scrollToNext();

    void scrollToNextNoDelete(ScrollDir scrollDir);
}
