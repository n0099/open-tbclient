package com.baidu.live.im.b;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.live.data.cr;
import java.util.Map;
/* loaded from: classes11.dex */
public interface c {
    void f(Map<String, Integer> map);

    cr getSelectInfo();

    @NonNull
    View getView();

    void setCallback(e eVar);

    void setData(cr[] crVarArr, Map<String, Integer> map, int i);

    void setSelectEnabled(boolean z);

    void setSelectId(String str);

    void setSelectPos(int i);

    void setSwitchStatus(boolean z);
}
