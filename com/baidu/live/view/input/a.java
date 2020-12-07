package com.baidu.live.view.input;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0239a {
        boolean Nh();

        void Nj();

        void Nk();

        boolean Nl();

        int Nm();

        void t(String str, boolean z);
    }

    boolean OO();

    boolean OP();

    boolean OQ();

    void OR();

    void OS();

    void OX();

    void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData);

    int getQuickInputPanelExpandHeight();

    View getView();

    boolean hasText();

    void hide();

    void setEditText(String str);

    void setQuickInputPanelVisible(boolean z);

    void show();
}
