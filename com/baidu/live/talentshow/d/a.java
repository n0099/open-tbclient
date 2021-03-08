package com.baidu.live.talentshow.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.ab;
/* loaded from: classes10.dex */
public interface a {
    boolean SN();

    boolean SO();

    boolean SP();

    int a(com.baidu.live.talentshow.d.a.b bVar);

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    int bl(long j);

    View bm(long j);

    boolean bn(long j);

    String bo(long j);

    long ei(int i);

    void init(Context context);

    boolean isFull();

    void onBackground();

    void onDestroy();

    void onForeground();

    void setLiveShowData(ab abVar);

    void setMute(boolean z);
}
