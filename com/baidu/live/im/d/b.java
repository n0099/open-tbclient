package com.baidu.live.im.d;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes10.dex */
public interface b {

    /* loaded from: classes10.dex */
    public interface a {
        void H(String str, int i);
    }

    void LJ();

    void LK();

    @NonNull
    View getView();

    void setCallback(a aVar);

    void setData(List<String> list);
}
