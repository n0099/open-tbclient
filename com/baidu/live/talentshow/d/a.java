package com.baidu.live.talentshow.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public interface a {
    boolean Rt();

    boolean Ru();

    boolean Rv();

    int a(com.baidu.live.talentshow.d.a.b bVar);

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    int aJ(long j);

    View aK(long j);

    boolean aL(long j);

    String aM(long j);

    long fk(int i);

    void init(Context context);

    boolean isFull();

    void onDestroy();

    void setLiveShowData(w wVar);

    void setMute(boolean z);
}
