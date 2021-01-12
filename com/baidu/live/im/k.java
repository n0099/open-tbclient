package com.baidu.live.im;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.x;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public interface k {

    /* loaded from: classes10.dex */
    public interface a {
        boolean IJ();

        void IK();

        void IL();

        void IM();

        void IN();

        boolean IO();

        int IP();

        boolean IQ();

        void gD(String str);
    }

    j IF();

    com.baidu.live.view.input.a IG();

    com.baidu.live.view.input.b IH();

    int II();

    void a(ViewGroup viewGroup, x xVar, List<String> list, RelativeLayout.LayoutParams layoutParams);

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

    void zh();
}
