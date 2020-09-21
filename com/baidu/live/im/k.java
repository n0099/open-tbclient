package com.baidu.live.im;

import java.util.Map;
/* loaded from: classes4.dex */
public interface k {

    /* loaded from: classes4.dex */
    public interface a {
        boolean JM();

        void JN();

        void JO();

        void JP();

        boolean JQ();

        int JR();

        void hd(String str);
    }

    void Bq();

    j JJ();

    com.baidu.live.view.input.a JK();

    int JL();

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
