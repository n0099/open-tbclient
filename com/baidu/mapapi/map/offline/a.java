package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.v;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MKOfflineMap f7380a;

    public a(MKOfflineMap mKOfflineMap) {
        this.f7380a = mKOfflineMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.v
    public void a(int i2, int i3) {
        MKOfflineMapListener mKOfflineMapListener;
        MKOfflineMapListener mKOfflineMapListener2;
        MKOfflineMapListener mKOfflineMapListener3;
        r rVar;
        if (i2 == 4) {
            ArrayList<MKOLUpdateElement> allUpdateInfo = this.f7380a.getAllUpdateInfo();
            if (allUpdateInfo != null) {
                for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                    if (mKOLUpdateElement.update) {
                        mKOfflineMapListener = this.f7380a.f7379c;
                        mKOfflineMapListener.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                    }
                }
                return;
            }
            return;
        }
        int i4 = 6;
        if (i2 == 6) {
            mKOfflineMapListener2 = this.f7380a.f7379c;
        } else if (i2 == 8) {
            int i5 = i3 >> 8;
            mKOfflineMapListener3 = this.f7380a.f7379c;
            mKOfflineMapListener3.onGetOfflineMapState(0, i5);
            return;
        } else if (i2 != 10) {
            if (i2 != 12) {
                return;
            }
            rVar = this.f7380a.f7378b;
            rVar.a(true, false);
            return;
        } else {
            mKOfflineMapListener2 = this.f7380a.f7379c;
            i4 = 2;
        }
        mKOfflineMapListener2.onGetOfflineMapState(i4, i3);
    }
}
