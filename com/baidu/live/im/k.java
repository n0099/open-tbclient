package com.baidu.live.im;

import java.util.Map;
/* loaded from: classes4.dex */
public interface k {

    /* loaded from: classes4.dex */
    public interface a {
        boolean DF();

        void DG();

        void DH();

        void DI();

        boolean DJ();

        int DK();

        void fv(String str);
    }

    j DC();

    com.baidu.live.view.input.a DD();

    int DE();

    void a(a aVar);

    void a(String str, String str2, String str3, String str4, String str5, boolean z);

    void a(boolean z, int i, int i2, String str);

    void g(Map<String, Integer> map);

    int getImMsgListViewHeight();

    int getImMsgListViewTop();

    void onDestroy();

    void setFromMaster(boolean z);

    void setLogData(String str, String str2);

    void vD();
}
