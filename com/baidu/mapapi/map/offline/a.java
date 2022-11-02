package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.o;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ MKOfflineMap a;

    public a(MKOfflineMap mKOfflineMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mKOfflineMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mKOfflineMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.s
    public void a(int i, int i2) {
        MKOfflineMapListener mKOfflineMapListener;
        MKOfflineMapListener mKOfflineMapListener2;
        MKOfflineMapListener mKOfflineMapListener3;
        MKOfflineMapListener mKOfflineMapListener4;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
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
}
