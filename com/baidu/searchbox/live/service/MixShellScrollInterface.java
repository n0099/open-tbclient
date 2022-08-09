package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u00012\u00020\u0002J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/live/service/MixShellScrollInterface;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "", CriusAttrConstants.POSITION, "", "model", "", "isFromUser", "", "onSelected", "(ILjava/lang/Object;Z)V", "isUp", "isScrollAway", "pageScrolledAction", "(IZZ)V", "state", "pageScrolledStateChangedAction", "(II)V", "pageStartScrolledOffsetAction", "(ZI)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixShellScrollInterface extends IService {
    void onSelected(int i, Object obj, boolean z);

    void pageScrolledAction(int i, boolean z, boolean z2);

    void pageScrolledStateChangedAction(int i, int i2);

    void pageStartScrolledOffsetAction(boolean z, int i);
}
