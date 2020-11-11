package com.baidu.live.im;

import java.util.Map;
/* loaded from: classes4.dex */
public interface k {

    /* loaded from: classes4.dex */
    public interface a {
        boolean LM();

        void LN();

        void LO();

        void LP();

        boolean LQ();

        int LR();

        void hJ(String str);
    }

    void CM();

    j LJ();

    com.baidu.live.view.input.a LK();

    int LL();

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
