package com.baidu.mobads.utils;

import android.telephony.CellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.List;
/* loaded from: classes4.dex */
class y extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CellLocation f2499a;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, CellLocation cellLocation) {
        this.c = tVar;
        this.f2499a = cellLocation;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        try {
            Object a2 = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("cell");
            if (a2 != null) {
                t.f2494a = (List) a2;
                return t.f2494a;
            }
        } catch (Throwable th) {
            q.a().e(th);
        }
        try {
            if (this.f2499a != null) {
                String[] strArr = new String[3];
                if (this.f2499a instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) this.f2499a;
                    strArr[0] = gsmCellLocation.getCid() + "";
                    strArr[1] = gsmCellLocation.getLac() + "";
                    strArr[2] = "0";
                } else {
                    String[] split = this.f2499a.toString().replace("[", "").replace("]", "").split(",");
                    strArr[0] = split[0];
                    strArr[1] = split[3];
                    strArr[2] = split[4];
                }
                t.f2494a.add(strArr);
            }
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a("cell", t.f2494a);
        } catch (Throwable th2) {
        }
        return t.f2494a;
    }
}
