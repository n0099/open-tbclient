package com.baidu.live.view.input;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0230a {
        boolean IJ();

        void IL();

        void IM();

        void IN();

        boolean IO();

        int IP();

        boolean IQ();

        void t(String str, boolean z);
    }

    boolean KA();

    void KB();

    void KC();

    void KI();

    boolean Ky();

    boolean Kz();

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
