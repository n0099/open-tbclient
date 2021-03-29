package com.baidu.mobads.utils;

import android.telephony.CellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.List;
/* loaded from: classes2.dex */
public class y extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CellLocation f8580a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f8581c;

    public y(t tVar, CellLocation cellLocation) {
        this.f8581c = tVar;
        this.f8580a = cellLocation;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        try {
            Object a2 = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("cell");
            if (a2 != null) {
                List<String[]> list = (List) a2;
                t.f8564a = list;
                return list;
            }
        } catch (Throwable th) {
            q.a().e(th);
        }
        try {
            if (this.f8580a != null) {
                String[] strArr = new String[3];
                if (this.f8580a instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) this.f8580a;
                    strArr[0] = gsmCellLocation.getCid() + "";
                    strArr[1] = gsmCellLocation.getLac() + "";
                    strArr[2] = "0";
                } else {
                    String[] split = this.f8580a.toString().replace("[", "").replace("]", "").split(",");
                    strArr[0] = split[0];
                    strArr[1] = split[3];
                    strArr[2] = split[4];
                }
                t.f8564a.add(strArr);
            }
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a("cell", t.f8564a);
        } catch (Throwable unused) {
        }
        return t.f8564a;
    }
}
