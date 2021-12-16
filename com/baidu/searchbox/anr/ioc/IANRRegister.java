package com.baidu.searchbox.anr.ioc;

import android.content.Context;
import com.baidu.searchbox.anr.impl.ANRInfo;
/* loaded from: classes10.dex */
public interface IANRRegister {
    boolean checkEnable();

    void onANR(Context context, ANRInfo aNRInfo);
}
