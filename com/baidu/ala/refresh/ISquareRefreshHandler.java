package com.baidu.ala.refresh;
/* loaded from: classes3.dex */
public interface ISquareRefreshHandler {
    boolean isForeGround(int i2);

    void markDataLoaded(int i2);

    void markHasReaded();

    void startRefresh(int i2);
}
