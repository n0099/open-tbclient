package com.baidu.live.view.input;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0239a {
        boolean ME();

        void MG();

        void MH();

        void MI();

        boolean MJ();

        int MK();

        boolean ML();

        void t(String str, boolean z);
    }

    void OD();

    boolean Ot();

    boolean Ou();

    boolean Ov();

    void Ow();

    void Ox();

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
