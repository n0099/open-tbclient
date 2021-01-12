package com.baidu.live.im.b;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.live.data.ck;
import java.util.Map;
/* loaded from: classes10.dex */
public interface c {
    void f(Map<String, Integer> map);

    ck getSelectInfo();

    @NonNull
    View getView();

    void setCallback(e eVar);

    void setData(ck[] ckVarArr, Map<String, Integer> map, int i);

    void setSelectEnabled(boolean z);

    void setSelectId(String str);

    void setSelectPos(int i);

    void setSwitchStatus(boolean z);
}
