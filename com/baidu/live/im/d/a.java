package com.baidu.live.im.d;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.List;
/* loaded from: classes10.dex */
public interface a {

    /* renamed from: com.baidu.live.im.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0186a {
        void H(String str, int i);

        void LI();
    }

    AlphaGradientHListView getListView();

    @NonNull
    View getView();

    void setCallback(InterfaceC0186a interfaceC0186a);

    void setData(List<String> list);

    void setInVisible();

    void setTextColor(int i);
}
