package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class LocationOverlay extends InnerOverlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AppBaseMap a;

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean getDefaultShowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getLayerTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "location" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationOverlay() {
        super(7);
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

    public void beginLocationLayerAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.BeginLocationLayerAnimation();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationOverlay(AppBaseMap appBaseMap) {
        super(7, appBaseMap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {appBaseMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (AppBaseMap) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = appBaseMap;
    }

    public void clearLocationLayerData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putLong("locationaddr", this.mLayerID);
            this.a.ClearLocationLayerData(bundle);
        }
    }

    public void setLocationLayerData(List<OverlayLocationData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, list) == null) && list != null && list.size() > 0 && this.mLayerID != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("locationaddr", this.mLayerID);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                OverlayLocationData overlayLocationData = list.get(i);
                if (overlayLocationData.getImage() == null) {
                    return;
                }
                ParcelItem parcelItem = new ParcelItem();
                Bitmap image = overlayLocationData.getImage();
                Bundle bundle2 = new Bundle();
                ByteBuffer allocate = ByteBuffer.allocate(image.getWidth() * image.getHeight() * 4);
                image.copyPixelsToBuffer(allocate);
                byte[] array = allocate.array();
                bundle2.putByteArray("imgbin", array);
                bundle2.putInt("w", overlayLocationData.getImgWidth());
                bundle2.putInt("h", overlayLocationData.getImgHeight());
                bundle2.putInt("rotation", overlayLocationData.isRotation());
                bundle2.putString("name", overlayLocationData.getImgName() + "_" + Arrays.hashCode(array));
                parcelItem.setBundle(bundle2);
                arrayList.add(parcelItem);
            }
            if (arrayList.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    parcelItemArr[i2] = (ParcelItem) arrayList.get(i2);
                }
                bundle.putParcelableArray("imagedata", parcelItemArr);
            }
            this.a.SetLocationLayerData(bundle);
        }
    }
}
