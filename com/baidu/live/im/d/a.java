package com.baidu.live.im.d;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.List;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.baidu.live.im.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0194a {
        void E(String str, int i);

        void Ov();
    }

    AlphaGradientHListView getListView();

    @NonNull
    View getView();

    void setCallback(InterfaceC0194a interfaceC0194a);

    void setData(List<String> list);

    void setInVisible();

    void setTextColor(int i);
}
