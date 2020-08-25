package com.baidu.live.im;

import java.util.Map;
/* loaded from: classes7.dex */
public interface k {

    /* loaded from: classes7.dex */
    public interface a {
        boolean Ji();

        void Jj();

        void Jk();

        void Jl();

        boolean Jm();

        int Jn();

        void gQ(String str);
    }

    void Bb();

    j Jf();

    com.baidu.live.view.input.a Jg();

    int Jh();

    void a(a aVar);

    void a(String str, String str2, String str3, String str4, String str5, boolean z);

    void a(boolean z, int i, int i2, String str);

    void g(Map<String, Integer> map);

    int getImMsgListViewHeight();

    int getImMsgListViewTop();

    void onDestroy();

    void setFromMaster(boolean z);

    void setLogData(String str, String str2);
}
