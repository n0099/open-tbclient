package com.baidu.searchbox.player.interfaces;

import com.baidu.searchbox.player.context.IPlayerContext;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/player/interfaces/IFloatingPlayerContext;", "Lcom/baidu/searchbox/player/context/IPlayerContext;", "switchToFloating", "", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IFloatingPlayerContext extends IPlayerContext {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void switchToFloating(IFloatingPlayerContext iFloatingPlayerContext) {
        }
    }

    void switchToFloating();
}
