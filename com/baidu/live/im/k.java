package com.baidu.live.im;

import java.util.Map;
/* loaded from: classes4.dex */
public interface k {

    /* loaded from: classes4.dex */
    public interface a {
        boolean KS();

        void KT();

        void KU();

        void KV();

        boolean KW();

        int KX();

        void hu(String str);
    }

    void Cn();

    j KP();

    com.baidu.live.view.input.a KQ();

    int KR();

    void a(a aVar);

    void a(boolean z, int i, int i2, String str);

    void b(String str, String str2, String str3, String str4, String str5, boolean z);

    void g(Map<String, Integer> map);

    int getImMsgListViewHeight();

    int getImMsgListViewTop();

    void onDestroy();

    void setFromMaster(boolean z);

    void setLogData(String str, String str2);
}
