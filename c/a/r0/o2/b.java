package c.a.r0.o2;

import android.view.View;
import c.a.r0.q1.b.d;
import c.a.r0.q1.b.e;
/* loaded from: classes2.dex */
public interface b {
    void changePkView(long j2, long j3, int i2);

    d curFeedData(int i2);

    int curFeedType();

    e curHeadData();

    void destroy();

    View getRootView();

    void hideFeedEmpty(int i2);

    void hideFeedLoading(int i2);

    void hideFullEmpty();

    void hideFullLoading();

    void initViewPage();

    void onChangeSkinType();

    void pause();

    void refreshPkAndBless(e eVar);

    void resume();

    void showBlessView(long j2, long j3);

    void showFeedEmpty(boolean z, int i2);

    void showFeedLoading(int i2);

    void showFeedView(d dVar, boolean z, int i2);

    void showFullEmpty(boolean z);

    void showFullLoading();

    void showHasDeleteEmpty(boolean z);

    void showHeadView(e eVar);

    void stopPullRefresh();
}
