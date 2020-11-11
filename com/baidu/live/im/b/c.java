package com.baidu.live.im.b;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.data.cg;
import java.util.Map;
/* loaded from: classes4.dex */
public interface c {
    void f(Map<String, Integer> map);

    cg getSelectInfo();

    @NonNull
    View getView();

    void setCallback(e eVar);

    void setData(cg[] cgVarArr, Map<String, Integer> map, int i);

    void setSelectEnabled(boolean z);

    void setSelectId(String str);

    void setSelectPos(int i);

    void setSwitchStatus(boolean z);
}
