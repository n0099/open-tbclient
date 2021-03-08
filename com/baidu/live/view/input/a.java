package com.baidu.live.view.input;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0238a {
        boolean Kk();

        void Km();

        void Kn();

        void Ko();

        boolean Kp();

        int Kq();

        boolean Kr();

        void t(String str, boolean z);
    }

    boolean LZ();

    boolean Ma();

    boolean Mb();

    void Mc();

    void Md();

    void Mj();

    void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData);

    void destroy();

    int getQuickInputPanelExpandHeight();

    View getTextView();

    View getView();

    boolean hasText();

    void hide();

    void setEditText(String str);

    void setFromDailyTask(boolean z, String str);

    void setQuickInputPanelVisible(boolean z);

    void show();
}
