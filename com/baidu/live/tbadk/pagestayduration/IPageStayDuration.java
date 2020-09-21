package com.baidu.live.tbadk.pagestayduration;

import java.util.List;
@Deprecated
/* loaded from: classes4.dex */
public interface IPageStayDuration {
    String getCurrentPageKey();

    List<String> getCurrentPageSourceKeyList();

    List<String> getNextPageSourceKeyList();

    PageStayDurationItem getPageStayDurationItem();

    PageStayDurationFilter getPageStayFilter();
}
