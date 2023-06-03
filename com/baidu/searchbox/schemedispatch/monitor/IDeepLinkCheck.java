package com.baidu.searchbox.schemedispatch.monitor;

import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/schemedispatch/monitor/IDeepLinkCheck;", "", "checkSchemeInDeepLinkWhiteList", "Lcom/baidu/searchbox/schemedispatch/monitor/bean/SchemeCheckInfo;", "originScheme", "", GetUserAttrInfoResult.KEY_DATA_FIELDS, "Lcom/baidu/searchbox/schemedispatch/SchemeStatisticField;", "lib-security-openapp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IDeepLinkCheck {
    SchemeCheckInfo checkSchemeInDeepLinkWhiteList(String str, SchemeStatisticField schemeStatisticField);
}
