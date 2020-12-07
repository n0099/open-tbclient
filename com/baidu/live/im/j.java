package com.baidu.live.im;

import android.view.View;
import java.util.List;
/* loaded from: classes4.dex */
public interface j {
    void Nc();

    void a(String str, String str2, boolean z, String str3, String str4);

    View getView();

    void onKeyboardVisibilityChanged(boolean z);

    void setMsgData(List<com.baidu.live.im.data.b> list);

    void setNeedTopAlphaShade(boolean z);
}
