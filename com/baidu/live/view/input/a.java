package com.baidu.live.view.input;

import android.view.View;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.baidu.live.view.input.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0184a {
        boolean CC();

        void CE();

        void CF();

        boolean CG();

        int CH();

        void r(String str, boolean z);
    }

    boolean Ei();

    boolean Ej();

    void Ek();

    void Eo();

    void a(List<String> list, Map<String, Integer> map);

    int getQuickInputPanelExpandHeight();

    View getView();

    boolean hasText();

    void hide();

    void setEditText(String str);

    void setQuickInputPanelVisible(boolean z);

    void show();
}
