package com.baidu.mobads.utils;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class x extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TelephonyManager f8578a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f8579c;

    public x(t tVar, TelephonyManager telephonyManager) {
        this.f8579c = tVar;
        this.f8578a = telephonyManager;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        String str;
        String str2;
        try {
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            String simOperatorName = this.f8578a.getSimOperatorName();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(simOperatorName)) {
                sb.append(simOperatorName);
            } else {
                String networkOperatorName = this.f8578a.getNetworkOperatorName();
                if (TextUtils.isEmpty(networkOperatorName)) {
                    String unused = t.k = "";
                    str2 = t.k;
                    return str2;
                }
                sb.append(networkOperatorName);
            }
            sb.append("_");
            String simOperator = this.f8578a.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                sb.append(simOperator);
            }
            if (sb.length() > 1) {
                String unused2 = t.k = commonUtils.getTextEncoder(sb.toString());
            }
        } catch (Throwable unused3) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("Get operator failed", "");
        }
        str = t.k;
        return str;
    }
}
