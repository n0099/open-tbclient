package com.baidu.tbadk.ala;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, AlaLivePlayerData alaLivePlayerData);

        void onFirstFrame(int i, int i2, int i3);
    }

    void a(a aVar);

    boolean a(int i, String str, LinearLayout.LayoutParams layoutParams);

    void destroy();

    void setAudioMute(boolean z);

    void setRenderVideoModel(int i, int i2);

    void stop();

    View uW();
}
