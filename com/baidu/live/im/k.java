package com.baidu.live.im;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.w;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface k {

    /* loaded from: classes4.dex */
    public interface a {
        boolean Nh();

        void Ni();

        void Nj();

        void Nk();

        boolean Nl();

        int Nm();

        void id(String str);
    }

    void DN();

    j Nd();

    com.baidu.live.view.input.a Ne();

    com.baidu.live.view.input.b Nf();

    int Ng();

    void a(ViewGroup viewGroup, w wVar, List<String> list, RelativeLayout.LayoutParams layoutParams);

    void a(a aVar);

    void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6);

    void a(boolean z, int i, int i2, String str);

    void g(Map<String, Integer> map);

    int getImMsgListViewHeight();

    int getImMsgListViewTop();

    void onDestroy();

    void setFromMaster(boolean z);

    void setLogData(String str, String str2);
}
