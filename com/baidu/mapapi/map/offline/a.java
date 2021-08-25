package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.v;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MKOfflineMap f41579a;

    public a(MKOfflineMap mKOfflineMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mKOfflineMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41579a = mKOfflineMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.v
    public void a(int i2, int i3) {
        MKOfflineMapListener mKOfflineMapListener;
        MKOfflineMapListener mKOfflineMapListener2;
        MKOfflineMapListener mKOfflineMapListener3;
        r rVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (i2 == 4) {
                ArrayList<MKOLUpdateElement> allUpdateInfo = this.f41579a.getAllUpdateInfo();
                if (allUpdateInfo != null) {
                    for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                        if (mKOLUpdateElement.update) {
                            mKOfflineMapListener = this.f41579a.f41578c;
                            mKOfflineMapListener.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                        }
                    }
                    return;
                }
                return;
            }
            int i4 = 6;
            if (i2 == 6) {
                mKOfflineMapListener2 = this.f41579a.f41578c;
            } else if (i2 == 8) {
                int i5 = i3 >> 8;
                mKOfflineMapListener3 = this.f41579a.f41578c;
                mKOfflineMapListener3.onGetOfflineMapState(0, i5);
                return;
            } else if (i2 != 10) {
                if (i2 != 12) {
                    return;
                }
                rVar = this.f41579a.f41577b;
                rVar.a(true, false);
                return;
            } else {
                mKOfflineMapListener2 = this.f41579a.f41578c;
                i4 = 2;
            }
            mKOfflineMapListener2.onGetOfflineMapState(i4, i3);
        }
    }
}
