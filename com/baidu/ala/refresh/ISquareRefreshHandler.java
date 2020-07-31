package com.baidu.ala.refresh;
/* loaded from: classes4.dex */
public interface ISquareRefreshHandler {
    boolean isForeGround(int i);

    void markDataLoaded(int i);

    void markHasReaded();

    void startRefresh(int i);
}
