package com.baidu.searchbox.schemedispatch.monitor;

import android.content.Context;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
/* loaded from: classes4.dex */
public interface IGlobalCheck {
    SchemeCheckInfo adCheckSchemeInGlobalWhiteList(String str, String str2, SchemeStatisticField schemeStatisticField);

    SchemeCheckInfo checkSchemeInGlobalWhiteList(Context context, String str, String str2, String str3, SchemeStatisticField schemeStatisticField);
}
