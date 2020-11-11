package com.baidu.live.im;

import android.view.View;
import java.util.List;
/* loaded from: classes4.dex */
public interface j {
    void LI();

    void b(String str, String str2, boolean z, String str3);

    View getView();

    void onKeyboardVisibilityChanged(boolean z);

    void setMsgData(List<com.baidu.live.im.data.a> list);

    void setNeedTopAlphaShade(boolean z);
}
