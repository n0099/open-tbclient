package com.baidu.live.im;

import java.util.Map;
/* loaded from: classes3.dex */
public interface k {

    /* loaded from: classes3.dex */
    public interface a {
        boolean Dd();

        void De();

        void Df();

        void Dg();

        boolean Dh();

        int Di();

        void fw(String str);
    }

    void Cz();

    j Da();

    com.baidu.live.view.input.a Db();

    int Dc();

    void a(a aVar);

    void a(String str, String str2, String str3, String str4, String str5, boolean z);

    void a(boolean z, int i, int i2, String str);

    void f(Map<String, Integer> map);

    int getImMsgListViewHeight();

    int getImMsgListViewTop();

    void onDestroy();

    void setFromMaster(boolean z);

    void setLogData(String str, String str2);
}
