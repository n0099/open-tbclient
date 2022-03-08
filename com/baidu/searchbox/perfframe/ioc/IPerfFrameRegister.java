package com.baidu.searchbox.perfframe.ioc;

import android.content.Context;
import com.baidu.searchbox.perfframe.impl.PerfExpInfo;
/* loaded from: classes4.dex */
public interface IPerfFrameRegister {
    void onEvent(Context context, PerfExpInfo perfExpInfo);
}
