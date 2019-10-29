package com.baidu.ala.refresh;
/* loaded from: classes6.dex */
public interface ISquareRefreshHandler {
    boolean isForeGround(int i);

    void markDataLoaded(int i);

    void markHasReaded();

    void startRefresh(int i);
}
