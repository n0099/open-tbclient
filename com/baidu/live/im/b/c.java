package com.baidu.live.im.b;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.data.bp;
import java.util.Map;
/* loaded from: classes4.dex */
public interface c {
    void f(Map<String, Integer> map);

    bp getSelectInfo();

    @NonNull
    View getView();

    void setCallback(e eVar);

    void setData(bp[] bpVarArr, Map<String, Integer> map, int i);

    void setSelectEnabled(boolean z);

    void setSelectId(String str);

    void setSelectPos(int i);

    void setSwitchStatus(boolean z);
}
