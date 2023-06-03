package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.player.model.ClaritySelectModel;
import com.baidu.searchbox.player.model.ClarityUrlList;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/player/utils/IClarityDependProvider;", "", "getDeviceStaticScore", "", "getMultiRateSwitchEnable", "", "getShortVideoVideoClarityStrategy", "Lcom/baidu/searchbox/player/model/ClaritySelectModel;", "list", "Lcom/baidu/searchbox/player/model/ClarityUrlList;", "sdClarityScore", "", BasicVideoParserKt.PREFERRED_CLARITY_RANK, "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IClarityDependProvider {
    String getDeviceStaticScore();

    boolean getMultiRateSwitchEnable();

    ClaritySelectModel getShortVideoVideoClarityStrategy(ClarityUrlList clarityUrlList, double d, int i);
}
