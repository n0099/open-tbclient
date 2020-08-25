package com.baidu.live.im.b;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.data.br;
import java.util.Map;
/* loaded from: classes7.dex */
public interface c {
    void f(Map<String, Integer> map);

    br getSelectInfo();

    @NonNull
    View getView();

    void setCallback(e eVar);

    void setData(br[] brVarArr, Map<String, Integer> map, int i);

    void setSelectEnabled(boolean z);

    void setSelectId(String str);

    void setSelectPos(int i);

    void setSwitchStatus(boolean z);
}
