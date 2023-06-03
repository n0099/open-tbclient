package com.baidu.searchbox.schemedispatch.monitor;

import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
/* loaded from: classes4.dex */
public interface IFeedCheck {
    SchemeCheckInfo adCheckSchemeInFeedWhiteList(String str, String str2, SchemeStatisticField schemeStatisticField);

    SchemeCheckInfo checkSchemeInFeedWhiteList(String str, String str2, String str3);
}
