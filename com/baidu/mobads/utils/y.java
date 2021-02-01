package com.baidu.mobads.utils;

import android.telephony.CellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationListener;
import java.util.List;
/* loaded from: classes5.dex */
class y extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CellLocation f3514a;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, CellLocation cellLocation) {
        this.c = tVar;
        this.f3514a = cellLocation;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        try {
            Object a2 = XAdSDKFoundationFacade.getInstance().getCommonUtils().a(TencentLiteLocationListener.CELL);
            if (a2 != null) {
                t.f3508a = (List) a2;
                return t.f3508a;
            }
        } catch (Throwable th) {
            q.a().e(th);
        }
        try {
            if (this.f3514a != null) {
                String[] strArr = new String[3];
                if (this.f3514a instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) this.f3514a;
                    strArr[0] = gsmCellLocation.getCid() + "";
                    strArr[1] = gsmCellLocation.getLac() + "";
                    strArr[2] = "0";
                } else {
                    String[] split = this.f3514a.toString().replace("[", "").replace("]", "").split(",");
                    strArr[0] = split[0];
                    strArr[1] = split[3];
                    strArr[2] = split[4];
                }
                t.f3508a.add(strArr);
            }
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a(TencentLiteLocationListener.CELL, t.f3508a);
        } catch (Throwable th2) {
        }
        return t.f3508a;
    }
}
