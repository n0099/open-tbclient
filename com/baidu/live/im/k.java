package com.baidu.live.im;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.ab;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public interface k {

    /* loaded from: classes11.dex */
    public interface a {
        boolean Kh();

        void Ki();

        void Kj();

        void Kk();

        void Kl();

        boolean Km();

        int Kn();

        boolean Ko();

        void hb(String str);
    }

    j Kd();

    com.baidu.live.view.input.a Ke();

    com.baidu.live.view.input.b Kf();

    int Kg();

    void a(ViewGroup viewGroup, ab abVar, List<String> list, RelativeLayout.LayoutParams layoutParams);

    void a(a aVar);

    void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6);

    void a(boolean z, int i, int i2, String str);

    void g(Map<String, Integer> map);

    int getImMsgListViewHeight();

    int getImMsgListViewTop();

    View getTextView();

    void onDestroy();

    void setFromMaster(boolean z);

    void setLogData(String str, String str2);

    void zR();
}
