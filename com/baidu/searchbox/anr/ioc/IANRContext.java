package com.baidu.searchbox.anr.ioc;

import android.content.Context;
import com.baidu.searchbox.anr.impl.ANRInfo;
/* loaded from: classes11.dex */
public interface IANRContext {
    void onAppNotResponding(Context context, ANRInfo aNRInfo);
}
