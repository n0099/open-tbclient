package com.baidu.live.view.input;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0190a {
        boolean Dd();

        void Df();

        void Dg();

        boolean Dh();

        int Di();

        void r(String str, boolean z);
    }

    boolean EK();

    boolean EL();

    boolean EM();

    void EN();

    void ES();

    void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData);

    int getQuickInputPanelExpandHeight();

    View getView();

    boolean hasText();

    void hide();

    void setEditText(String str);

    void setQuickInputPanelVisible(boolean z);

    void show();
}
