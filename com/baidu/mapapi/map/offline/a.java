package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.v;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MKOfflineMap f7090a;

    public a(MKOfflineMap mKOfflineMap) {
        this.f7090a = mKOfflineMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.v
    public void a(int i, int i2) {
        MKOfflineMapListener mKOfflineMapListener;
        MKOfflineMapListener mKOfflineMapListener2;
        MKOfflineMapListener mKOfflineMapListener3;
        r rVar;
        if (i == 4) {
            ArrayList<MKOLUpdateElement> allUpdateInfo = this.f7090a.getAllUpdateInfo();
            if (allUpdateInfo != null) {
                for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                    if (mKOLUpdateElement.update) {
                        mKOfflineMapListener = this.f7090a.f7089c;
                        mKOfflineMapListener.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                    }
                }
                return;
            }
            return;
        }
        int i3 = 6;
        if (i == 6) {
            mKOfflineMapListener2 = this.f7090a.f7089c;
        } else if (i == 8) {
            int i4 = i2 >> 8;
            mKOfflineMapListener3 = this.f7090a.f7089c;
            mKOfflineMapListener3.onGetOfflineMapState(0, i4);
            return;
        } else if (i != 10) {
            if (i != 12) {
                return;
            }
            rVar = this.f7090a.f7088b;
            rVar.a(true, false);
            return;
        } else {
            mKOfflineMapListener2 = this.f7090a.f7089c;
            i3 = 2;
        }
        mKOfflineMapListener2.onGetOfflineMapState(i3, i2);
    }
}
