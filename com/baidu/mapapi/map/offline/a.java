package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.v;
import java.util.ArrayList;
/* loaded from: classes8.dex */
class a implements v {
    final /* synthetic */ MKOfflineMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MKOfflineMap mKOfflineMap) {
        this.a = mKOfflineMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.v
    public void a(int i, int i2) {
        MKOfflineMapListener mKOfflineMapListener;
        MKOfflineMapListener mKOfflineMapListener2;
        MKOfflineMapListener mKOfflineMapListener3;
        MKOfflineMapListener mKOfflineMapListener4;
        r rVar;
        switch (i) {
            case 4:
                ArrayList<MKOLUpdateElement> allUpdateInfo = this.a.getAllUpdateInfo();
                if (allUpdateInfo != null) {
                    for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                        if (mKOLUpdateElement.update) {
                            mKOfflineMapListener3 = this.a.c;
                            mKOfflineMapListener3.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                        }
                    }
                    return;
                }
                return;
            case 5:
            case 7:
            case 9:
            case 11:
            default:
                return;
            case 6:
                mKOfflineMapListener4 = this.a.c;
                mKOfflineMapListener4.onGetOfflineMapState(6, i2);
                return;
            case 8:
                mKOfflineMapListener2 = this.a.c;
                mKOfflineMapListener2.onGetOfflineMapState(0, i2 >> 8);
                return;
            case 10:
                mKOfflineMapListener = this.a.c;
                mKOfflineMapListener.onGetOfflineMapState(2, i2);
                return;
            case 12:
                rVar = this.a.b;
                rVar.a(true, false);
                return;
        }
    }
}
