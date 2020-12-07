package com.baidu.live.im.d;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.List;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        void E(String str, int i);
    }

    void Ow();

    void Ox();

    @NonNull
    View getView();

    void setCallback(a aVar);

    void setData(List<String> list);
}
