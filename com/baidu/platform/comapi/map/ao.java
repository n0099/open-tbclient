package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ao extends InnerOverlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao() {
        super(30);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean addedToMapView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AppBaseMap appBaseMap = this.mBaseMap;
            if (appBaseMap == null) {
                return false;
            }
            long AddLayer = appBaseMap.AddLayer(2, 0, MapController.STREETPOPUP_LAYER_TAG);
            this.mLayerID = AddLayer;
            if (AddLayer == 0) {
                return false;
            }
            this.mBaseMap.SetLayersClickable(AddLayer, true);
            this.mBaseMap.ShowLayers(this.mLayerID, false);
            return true;
        }
        return invokeV.booleanValue;
    }
}
