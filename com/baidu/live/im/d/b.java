package com.baidu.live.im.d;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes11.dex */
public interface b {

    /* loaded from: classes11.dex */
    public interface a {
        void H(String str, int i);
    }

    void LG();

    void LH();

    @NonNull
    View getView();

    void setCallback(a aVar);

    void setData(List<String> list);
}
