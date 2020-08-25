package com.baidu.live.view.input;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0199a {
        boolean Ji();

        void Jk();

        void Jl();

        boolean Jm();

        int Jn();

        void r(String str, boolean z);
    }

    void KF();

    boolean Kw();

    boolean Kx();

    boolean Ky();

    void Kz();

    void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData);

    int getQuickInputPanelExpandHeight();

    View getView();

    boolean hasText();

    void hide();

    void setEditText(String str);

    void setQuickInputPanelVisible(boolean z);

    void show();
}
