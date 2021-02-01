package com.baidu.mobads.utils;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes5.dex */
class x extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TelephonyManager f3513a;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, TelephonyManager telephonyManager) {
        this.c = tVar;
        this.f3513a = telephonyManager;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        String str;
        String str2;
        try {
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            String simOperatorName = this.f3513a.getSimOperatorName();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(simOperatorName)) {
                sb.append(simOperatorName);
            } else {
                String networkOperatorName = this.f3513a.getNetworkOperatorName();
                if (TextUtils.isEmpty(networkOperatorName)) {
                    String unused = t.k = "";
                    str2 = t.k;
                    return str2;
                }
                sb.append(networkOperatorName);
            }
            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            String simOperator = this.f3513a.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                sb.append(simOperator);
            }
            if (sb.length() > 1) {
                String unused2 = t.k = commonUtils.getTextEncoder(sb.toString());
            }
        } catch (Throwable th) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("Get operator failed", "");
        }
        str = t.k;
        return str;
    }
}
