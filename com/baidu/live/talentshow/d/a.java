package com.baidu.live.talentshow.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public interface a {
    boolean TR();

    boolean TS();

    boolean TT();

    int a(com.baidu.live.talentshow.d.a.b bVar);

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    int bh(long j);

    View bi(long j);

    boolean bj(long j);

    String bk(long j);

    long fI(int i);

    void init(Context context);

    boolean isFull();

    void onBackground();

    void onDestroy();

    void onForeground();

    void setLiveShowData(w wVar);

    void setMute(boolean z);
}
