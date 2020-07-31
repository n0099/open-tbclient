package com.baidu.live.view.input;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0192a {
        boolean DF();

        void DH();

        void DI();

        boolean DJ();

        int DK();

        void r(String str, boolean z);
    }

    boolean ER();

    boolean ES();

    boolean ET();

    void EU();

    void Fa();

    void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData);

    int getQuickInputPanelExpandHeight();

    View getView();

    boolean hasText();

    void hide();

    void setEditText(String str);

    void setQuickInputPanelVisible(boolean z);

    void show();
}
