package com.baidu.live.tbadk.pagestayduration;

import java.util.List;
@Deprecated
/* loaded from: classes10.dex */
public interface IPageStayDuration {
    String getCurrentPageKey();

    List<String> getCurrentPageSourceKeyList();

    List<String> getNextPageSourceKeyList();

    PageStayDurationItem getPageStayDurationItem();

    PageStayDurationFilter getPageStayFilter();
}
