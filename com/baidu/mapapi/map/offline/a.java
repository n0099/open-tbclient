package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.o;
import com.baidu.mapsdkplatform.comapi.map.s;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements s {
    public final /* synthetic */ MKOfflineMap a;

    public a(MKOfflineMap mKOfflineMap) {
        this.a = mKOfflineMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.s
    public void a(int i, int i2) {
        MKOfflineMapListener mKOfflineMapListener;
        MKOfflineMapListener mKOfflineMapListener2;
        MKOfflineMapListener mKOfflineMapListener3;
        MKOfflineMapListener mKOfflineMapListener4;
        o oVar;
        if (i != 4) {
            if (i == 6) {
                mKOfflineMapListener2 = this.a.c;
                mKOfflineMapListener2.onGetOfflineMapState(6, i2);
                return;
            } else if (i != 8) {
                if (i == 10) {
                    mKOfflineMapListener4 = this.a.c;
                    mKOfflineMapListener4.onGetOfflineMapState(2, i2);
                    return;
                } else if (i == 12) {
                    oVar = this.a.b;
                    oVar.a(true, false);
                    return;
                } else {
                    return;
                }
            } else {
                int i3 = i2 >> 8;
                mKOfflineMapListener3 = this.a.c;
                mKOfflineMapListener3.onGetOfflineMapState(0, i3);
                return;
            }
        }
        ArrayList<MKOLUpdateElement> allUpdateInfo = this.a.getAllUpdateInfo();
        if (allUpdateInfo != null) {
            for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                if (mKOLUpdateElement.update) {
                    mKOfflineMapListener = this.a.c;
                    mKOfflineMapListener.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                }
            }
        }
    }
}
