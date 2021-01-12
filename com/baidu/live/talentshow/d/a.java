package com.baidu.live.talentshow.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.x;
/* loaded from: classes10.dex */
public interface a {
    boolean Rb();

    boolean Rc();

    boolean Rd();

    void Re();

    void Rf();

    int a(com.baidu.live.talentshow.d.a.b bVar);

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    int bh(long j);

    View bi(long j);

    boolean bj(long j);

    String bk(long j);

    long ed(int i);

    void init(Context context);

    boolean isFull();

    void onDestroy();

    void setLiveShowData(x xVar);

    void setMute(boolean z);
}
