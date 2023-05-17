package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes3.dex */
public class AppBaseMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public NABaseMap b;
    public final ReadWriteLock c;

    public void Remo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
        }
    }

    public AppBaseMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = null;
        this.c = new ReentrantReadWriteLock(true);
        this.b = new NABaseMap();
    }

    public boolean Create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                this.c.writeLock().lock();
                this.a = this.b.create();
                return true;
            } finally {
                this.c.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public void OnBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            try {
                this.c.readLock().lock();
                if (this.a != 0) {
                    this.b.onBackground();
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void OnForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            try {
                this.c.readLock().lock();
                if (this.a != 0) {
                    this.b.onForeground();
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void OnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            try {
                this.c.readLock().lock();
                if (this.a != 0) {
                    this.b.onPause();
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void OnResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            try {
                this.c.readLock().lock();
                if (this.a != 0) {
                    this.b.onResume();
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public boolean Release() {
        boolean z;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            try {
                this.c.writeLock().lock();
                if (this.a != 0) {
                    BaseMapCallback.release(this.a);
                    this.b.dispose();
                    this.a = 0L;
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.c.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean releaseFromOfflineMap() {
        boolean z;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            try {
                this.c.writeLock().lock();
                if (this.a != 0) {
                    this.b.dispose();
                    this.a = 0L;
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.c.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public int renderRender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            try {
                this.c.readLock().lock();
                return this.b.renderRender();
            } finally {
                this.c.readLock().unlock();
            }
        }
        return invokeV.intValue;
    }

    public static void renderClearShaderCache(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            NABaseMap.renderClearShaderCache(str);
        }
    }

    public void AddItemData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            AddItemData(bundle, false);
        }
    }

    public void AddPopupData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.b.addPopupData(bundle);
        }
    }

    public void AddRtPopData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.b.addRtPopData(bundle);
        }
    }

    public boolean CleanCache(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.b.cleanCache(i);
        }
        return invokeI.booleanValue;
    }

    public void ClearLayer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.b.clearLayer(j);
        }
    }

    public void ClearLocationLayerData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            this.b.clearLocationLayerData(bundle);
        }
    }

    public void ClearSDKLayer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.b.clearSDKLayer(j);
        }
    }

    public boolean CreateByDuplicate(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) {
            long createByDuplicate = this.b.createByDuplicate(j);
            this.a = createByDuplicate;
            if (createByDuplicate != 0) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public int GetCacheSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            return this.b.getCacheSize(i);
        }
        return invokeI.intValue;
    }

    public String GetCityInfoByID(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            return this.b.getCityInfoByID(i);
        }
        return (String) invokeI.objValue;
    }

    public Bundle GetMapStatus(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            return this.b.getMapStatus(z);
        }
        return (Bundle) invokeZ.objValue;
    }

    public int GetVMPMapCityInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, bundle)) == null) {
            return this.b.getVMPMapCityInfo(bundle);
        }
        return invokeL.intValue;
    }

    public float GetZoomToBoundF(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bundle)) == null) {
            return this.b.getZoomToBoundF(bundle);
        }
        return invokeL.floatValue;
    }

    public boolean LayersIsShow(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048616, this, j)) == null) {
            return this.b.layersIsShow(j);
        }
        return invokeJ.booleanValue;
    }

    public boolean OnRecordAdd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
            return this.b.onRecordAdd(i);
        }
        return invokeI.booleanValue;
    }

    public String OnRecordGetAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i)) == null) {
            return this.b.onRecordGetAt(i);
        }
        return (String) invokeI.objValue;
    }

    public String OnSchcityGet(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            return this.b.onSchcityGet(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean OnUsrcityMsgInterval(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i)) == null) {
            return this.b.onUsrcityMsgInterval(i);
        }
        return invokeI.booleanValue;
    }

    public int OnWifiRecordAdd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i)) == null) {
            return this.b.onWifiRecordAdd(i);
        }
        return invokeI.intValue;
    }

    public boolean RemoveItemData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, bundle)) == null) {
            return this.b.removeItemData(bundle);
        }
        return invokeL.booleanValue;
    }

    public void RemoveLayer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048637, this, j) == null) {
            this.b.removeLayer(j);
        }
    }

    public void RemoveStreetCustomMaker(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.b.removeStreetCustomMaker(str);
        }
    }

    public void SetAllStreetCustomMarkerVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048645, this, z) == null) && this.a != 0) {
            this.b.setAllStreetCustomMarkerVisibility(z);
        }
    }

    public boolean SetCallback(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, aVar)) == null) {
            if (aVar != null) {
                long j = this.a;
                if (j != 0 && BaseMapCallback.setMapCallback(j, aVar)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void SetLocationLayerData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, bundle) == null) {
            this.b.setLocationLayerData(bundle);
        }
    }

    public int SetMapControlMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i)) == null) {
            return this.b.setMapControlMode(i);
        }
        return invokeI.intValue;
    }

    public void SetMapStatus(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, bundle) == null) {
            this.b.setMapStatus(bundle);
        }
    }

    public void SetNewMapStatus(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, bundle) == null) {
            this.b.setNewMapStatus(bundle);
        }
    }

    public boolean SetSDKLayerCallback(com.baidu.mapsdkplatform.comjni.a.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, aVar)) == null) {
            if (aVar != null) {
                long j = this.a;
                if (j != 0 && BaseMapCallback.setMapSDKCallback(j, aVar)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void SetStreetArrowShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.b.setStreetArrowShow(z);
        }
    }

    public void SetStreetRoadClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.b.setStreetRoadClickable(z);
        }
    }

    public void SetStyleMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i) == null) {
            this.b.setStyleMode(i);
        }
    }

    public void ShowBaseIndoorMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z) == null) {
            this.b.showBaseIndoorMap(z);
        }
    }

    public void ShowSatelliteMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
            this.b.showSatelliteMap(z);
        }
    }

    public void ShowStreetPOIMarker(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048667, this, z) == null) && this.a != 0) {
            this.b.showStreetPOIMarker(z);
        }
    }

    public void ShowStreetRoadMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
            this.b.showStreetRoadMap(z);
        }
    }

    public void ShowTrafficMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.b.showTrafficMap(z);
        }
    }

    public void UpdateLayers(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048673, this, j) == null) {
            this.b.updateLayers(j);
        }
    }

    public void addOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
            this.b.addOneOverlayItem(bundle);
        }
    }

    public boolean addSDKTileData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, bundle)) == null) {
            return this.b.nativeAddTileOverlay(this.a, bundle);
        }
        return invokeL.booleanValue;
    }

    public boolean cleanSDKTileDataCache(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048678, this, j)) == null) {
            return this.b.nativeCleanSDKTileDataCache(this.a, j);
        }
        return invokeJ.booleanValue;
    }

    public void clearHeatMapLayerCache(long j) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048679, this, j) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.clearHeatMapLayerCache(j);
    }

    public void closeParticleEffect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, str) == null) {
            this.b.closeParticleEffect(str);
        }
    }

    public void enablePOIAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z) == null) {
            try {
                this.c.readLock().lock();
                this.b.enablePOIAnimation(z);
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void entrySearchTopic(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i) == null) {
            this.b.entrySearchTopic(i, "", "");
        }
    }

    public long getLayerIDByTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, str)) == null) {
            NABaseMap nABaseMap = this.b;
            if (nABaseMap == null) {
                return 0L;
            }
            return nABaseMap.getLayerIDByTag(str);
        }
        return invokeL.longValue;
    }

    public boolean getMapBarData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, bundle)) == null) {
            return this.b.getMapBarData(bundle);
        }
        return invokeL.booleanValue;
    }

    public boolean getMapStatusLimitsLevel(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048697, this, iArr)) == null) {
            return this.b.getMapStatusLimitsLevel(iArr);
        }
        return invokeL.booleanValue;
    }

    public String getProjectionPt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, str)) == null) {
            return this.b.getProjectionPt(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean importMapTheme(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048704, this, i)) == null) {
            return this.b.importMapTheme(i);
        }
        return invokeI.booleanValue;
    }

    public boolean performAction(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048712, this, str)) == null) {
            return this.b.performAction(str);
        }
        return invokeL.booleanValue;
    }

    public void recycleMemory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048713, this, i) == null) {
            this.b.recycleMemory(i);
        }
    }

    public void removeBmLayer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048715, this, j) == null) {
            this.b.removeBmLayer(j);
        }
    }

    public void removeOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            this.b.removeOneOverlayItem(bundle);
        }
    }

    public void removeOverlayItems(Bundle[] bundleArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, bundleArr) == null) {
            this.b.removeOneOverlayItems(bundleArr);
        }
    }

    public void set3DModelEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z) == null) {
            this.b.set3DModelEnable(z);
        }
    }

    public void setCustomStyleEnable(boolean z) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048724, this, z) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.setCustomStyleEnable(z);
    }

    public void setDEMEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z) == null) {
            this.b.setDEMEnable(z);
        }
    }

    public void setDpiScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048726, this, f) == null) {
            this.b.setDpiScale(f);
        }
    }

    public void setDrawHouseHeightEnable(boolean z) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048727, this, z) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.setDrawHouseHeightEnable(z);
    }

    public void setEnableIndoor3D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z) == null) {
            this.b.setEnableIndoor3D(z);
        }
    }

    public void setFontSizeLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048729, this, i) == null) {
            this.b.setFontSizeLevel(i);
        }
    }

    public void setMapLanguage(int i) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048731, this, i) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.setMapLanguage(i);
    }

    public void setMapScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048732, this, i) == null) {
            this.b.setMapScene(i);
        }
    }

    public void setMapStatusLimits(Bundle bundle) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048733, this, bundle) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.setMapStatusLimits(bundle);
    }

    public void setMaxAndMinZoomLevel(Bundle bundle) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048737, this, bundle) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.setMaxAndMinZoomLevel(bundle);
    }

    public void setRecommendPOIScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048738, this, i) == null) {
            this.b.setRecommendPOIScene(i);
        }
    }

    public void setSkyboxStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048739, this, i) == null) {
            this.b.setSkyboxStyle(i);
        }
    }

    public boolean setTestSwitch(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048740, this, z)) == null) {
            return this.b.setTestSwitch(z);
        }
        return invokeZ.booleanValue;
    }

    public void setTrafficUGCData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, str) == null) {
            this.b.setTrafficUGCData(str);
        }
    }

    public void setUniversalFilter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, str) == null) {
            this.b.setUniversalFilter(str);
        }
    }

    public boolean showParticleEffect(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048744, this, i)) == null) {
            return this.b.showParticleEffect(i);
        }
        return invokeI.booleanValue;
    }

    public boolean showParticleEffectByType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048746, this, i)) == null) {
            return this.b.showParticleEffectByType(i);
        }
        return invokeI.booleanValue;
    }

    public void showTrafficUGCMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z) == null) {
            this.b.showTrafficUGCMap(z);
        }
    }

    public void showUniversalLayer(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, bundle) == null) {
            this.b.showUniversalLayer(bundle);
        }
    }

    public void startHeatMapFrameAnimation(long j) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048749, this, j) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.startHeatMapFrameAnimation(j);
    }

    public void stopHeatMapFrameAnimation(long j) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048750, this, j) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.stopHeatMapFrameAnimation(j);
    }

    public void surfaceDestroyed(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, surface) == null) {
            try {
                this.c.readLock().lock();
                this.b.surfaceDestroyed(surface);
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void updateOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, bundle) == null) {
            this.b.updateOneOverlayItem(bundle);
        }
    }

    public boolean updateSDKTile(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048757, this, bundle)) == null) {
            return this.b.nativeUpdateSDKTile(this.a, bundle);
        }
        return invokeL.booleanValue;
    }

    public void AddItemData(Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, z) == null) {
            this.b.addItemData(bundle, z);
        }
    }

    public void AddStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, bundle, bitmap) == null) && this.a != 0) {
            this.b.addStreetCustomMarker(bundle, bitmap);
        }
    }

    public String GeoPtToScrPoint(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) {
            return this.b.geoPtToScrPoint(i, i2);
        }
        return (String) invokeII.objValue;
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, bundle, bundle2)) == null) {
            return this.b.getFZoomToBoundF(bundle, bundle2);
        }
        return invokeLL.floatValue;
    }

    public void MoveToScrPoint(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048617, this, i, i2) == null) {
            this.b.moveToScrPoint(i, i2);
        }
    }

    public boolean OnRecordImport(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return this.b.onRecordImport(z, z2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean OnRecordReload(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return this.b.onRecordReload(i, z);
        }
        return invokeCommon.booleanValue;
    }

    public boolean OnRecordRemove(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return this.b.onRecordRemove(i, z);
        }
        return invokeCommon.booleanValue;
    }

    public void SaveScreenToLocal(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, str, str2) == null) {
            this.b.saveScreenToLocal(str, str2);
        }
    }

    public String ScrPtToGeoPoint(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048644, this, i, i2)) == null) {
            return this.b.scrPtToGeoPoint(i, i2);
        }
        return (String) invokeII.objValue;
    }

    public boolean SetLayerSceneMode(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048649, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            return this.b.setLayerSceneMode(j, i);
        }
        return invokeCommon.booleanValue;
    }

    public void SetLayersClickable(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.b.setLayersClickable(j, z);
        }
    }

    public void SetStreetMarkerClickable(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048657, this, str, z) == null) {
            this.b.setStreetMarkerClickable(str, z);
        }
    }

    public void SetTargetStreetCustomMarkerVisibility(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048660, this, z, str) == null) && this.a != 0) {
            this.b.setTargetStreetCustomMarkerVisibility(z, str);
        }
    }

    public void ShowHotMap(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048662, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.b.showHotMap(z, i);
        }
    }

    public void ShowLayers(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048664, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && this.a != 0) {
            this.b.showLayers(j, z);
        }
    }

    public void ShowMistMap(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048665, this, z, str) == null) {
            this.b.showMistMap(z, str);
        }
    }

    public boolean SwitchBaseIndoorMapFloor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048671, this, str, str2)) == null) {
            return this.b.switchBaseIndoorMapFloor(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean SwitchLayer(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048672, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return this.b.switchLayer(j, j2);
        }
        return invokeCommon.booleanValue;
    }

    public void addOverlayItems(Bundle[] bundleArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048676, this, bundleArr, i) == null) {
            this.b.addOverlayItems(bundleArr, i);
        }
    }

    public int getScaleLevel(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048701, this, i, i2)) == null) {
            return this.b.getScaleLevel(i, i2);
        }
        return invokeII.intValue;
    }

    public boolean initCustomStyle(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048705, this, str, str2)) == null) {
            NABaseMap nABaseMap = this.b;
            if (nABaseMap == null) {
                return false;
            }
            return nABaseMap.initCustomStyle(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public void initHeatMapData(long j, Bundle bundle) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJL(1048706, this, j, bundle) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.initHeatMapData(j, bundle);
    }

    public boolean initWithOptions(Bundle bundle, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048707, this, bundle, z)) == null) {
            if (this.a != 0 && this.b.initWithOptions(bundle, z)) {
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public boolean moveLayerBelowTo(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048711, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            return this.b.moveLayerBelowTo(j, i);
        }
        return invokeCommon.booleanValue;
    }

    public void renderResize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048721, this, i, i2) == null) {
            try {
                this.c.readLock().lock();
                this.b.renderResize(i, i2);
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void resize(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048722, this, i, i2) == null) && this.a != 0) {
            this.b.renderResize(i, i2);
        }
    }

    public void setHeatMapFrameAnimationIndex(long j, int i) {
        NABaseMap nABaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048730, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) != null) || (nABaseMap = this.b) == null) {
            return;
        }
        nABaseMap.setHeatMapFrameAnimationIndex(j, i);
    }

    public boolean setMapStatusLimitsLevel(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048734, this, i, i2)) == null) {
            return this.b.setMapStatusLimitsLevel(i, i2);
        }
        return invokeII.booleanValue;
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048735, this, i, bundle)) == null) {
            return this.b.setMapTheme(i, bundle);
        }
        return invokeIL.booleanValue;
    }

    public void showFootMarkGrid(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048743, this, z, str) == null) {
            this.b.showFootMarkGrid(z, str);
        }
    }

    public boolean showParticleEffectByName(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048745, this, str, z)) == null) {
            return this.b.showParticleEffectByName(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public long AddLayer(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str)) == null) {
            return this.b.addLayer(i, i2, str);
        }
        return invokeIIL.longValue;
    }

    public float GetZoomToBound(Bundle bundle, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048606, this, bundle, i, i2)) == null) {
            return this.b.getZoomToBound(bundle, i, i2);
        }
        return invokeLII.floatValue;
    }

    public boolean SetItsPreTime(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048648, this, i, i2, i3)) == null) {
            return this.b.setItsPreTime(i, i2, i3);
        }
        return invokeIII.booleanValue;
    }

    public void ShowHotMap(boolean z, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
            this.b.showHotMap(z, i, str);
        }
    }

    public void entryFeedTopic(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048683, this, i, str, str2) == null) {
            this.b.entrySearchTopic(i, str, str2);
        }
    }

    public String geoPt3ToScrPoint(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048687, this, i, i2, i3)) == null) {
            return this.b.geoPt3ToScrPoint(i, i2, i3);
        }
        return (String) invokeIII.objValue;
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048736, this, i, i2, bundle)) == null) {
            return this.b.setMapThemeScene(i, i2, bundle);
        }
        return invokeIIL.booleanValue;
    }

    public void BeginLocationLayerAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.beginLocationLayerAnimation();
        }
    }

    public void ClearMistmapLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.clearMistmapLayer();
        }
    }

    public boolean CloseCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b.closeCache();
        }
        return invokeV.booleanValue;
    }

    public long CreateDuplicate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b.createDuplicate();
        }
        return invokeV.longValue;
    }

    public int Draw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.a != 0) {
                return this.b.draw();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public float GetAdapterZoomUnitsEx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.b.getAdapterZoomUnitsEx();
        }
        return invokeV.floatValue;
    }

    public Bundle GetDrawingMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b.getDrawingMapStatus();
        }
        return (Bundle) invokeV.objValue;
    }

    public String GetFocusedBaseIndoorMapInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.a != 0) {
                return this.b.getFocusedBaseIndoorMapInfo();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long GetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public int GetMapRenderType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.b.getMapRenderType();
        }
        return invokeV.intValue;
    }

    public Bundle GetMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.b.getMapStatus(true);
        }
        return (Bundle) invokeV.objValue;
    }

    public boolean IsBaseIndoorMapMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.a != 0 && this.b.isBaseIndoorMapMode()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean IsStreetArrowShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.b.isStreetArrowShown();
        }
        return invokeV.booleanValue;
    }

    public boolean IsStreetCustomMarkerShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.b.isStreetCustomMarkerShown();
        }
        return invokeV.booleanValue;
    }

    public boolean IsStreetPOIMarkerShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.a != 0 && this.b.isStreetPOIMarkerShown()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean IsStreetRoadClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.b.isStreetRoadClickable();
        }
        return invokeV.booleanValue;
    }

    public String OnHotcityGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.b.onHotcityGet();
        }
        return (String) invokeV.objValue;
    }

    public String OnRecordGetAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.b.onRecordGetAll();
        }
        return (String) invokeV.objValue;
    }

    public void RemoveStreetAllCustomMarker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.b.removeStreetAllCustomMarker();
        }
    }

    public void ResetImageRes() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.a != 0) {
            this.b.resetImageRes();
        }
    }

    public boolean ResumeCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.b.resumeCache();
        }
        return invokeV.booleanValue;
    }

    public boolean SaveCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            try {
                return this.b.saveCache();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void StartIndoorAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            this.b.startIndoorAnimation();
        }
    }

    public void clearUniversalLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            this.b.clearUniversalLayer();
        }
    }

    public void exitSearchTopic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            this.b.exitSearchTopic();
        }
    }

    public void focusTrafficUGCLabel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            this.b.focusTrafficUGCLabel();
        }
    }

    public boolean get3DModelEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.b.get3DModelEnable();
        }
        return invokeV.booleanValue;
    }

    public boolean getDEMEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.b.getDEMEnable();
        }
        return invokeV.booleanValue;
    }

    public boolean getDrawHouseHeightEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            NABaseMap nABaseMap = this.b;
            if (nABaseMap == null) {
                return false;
            }
            return nABaseMap.getDrawHouseHeightEnable();
        }
        return invokeV.booleanValue;
    }

    public int getFontSizeLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.b.getFontSizeLevel();
        }
        return invokeV.intValue;
    }

    public int getMapLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            NABaseMap nABaseMap = this.b;
            if (nABaseMap == null) {
                return 0;
            }
            return nABaseMap.getMapLanguage();
        }
        return invokeV.intValue;
    }

    public int getMapScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.b.getMapScene();
        }
        return invokeV.intValue;
    }

    public Bundle getMapStatusLimits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            NABaseMap nABaseMap = this.b;
            if (nABaseMap == null) {
                return null;
            }
            return nABaseMap.getMapStatusLimits();
        }
        return (Bundle) invokeV.objValue;
    }

    public int getMapTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.b.getMapTheme();
        }
        return invokeV.intValue;
    }

    public float[] getProjectionMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            NABaseMap nABaseMap = this.b;
            if (nABaseMap == null) {
                return null;
            }
            float[] fArr = new float[16];
            nABaseMap.getProjectMatrix(fArr);
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public int getSkyboxStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.b.getSkyboxStyle();
        }
        return invokeV.intValue;
    }

    public float[] getViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            NABaseMap nABaseMap = this.b;
            if (nABaseMap == null) {
                return null;
            }
            float[] fArr = new float[16];
            nABaseMap.getViewMatrix(fArr);
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public boolean isAnimationRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            return this.b.isAnimationRunning();
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableIndoor3D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            return this.b.isEnableIndoor3D();
        }
        return invokeV.booleanValue;
    }

    public boolean isNaviMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            return this.b.isNaviMode();
        }
        return invokeV.booleanValue;
    }

    public void renderDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            try {
                this.c.readLock().lock();
                this.b.renderDone();
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void unFocusTrafficUGCLabel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            this.b.unFocusTrafficUGCLabel();
        }
    }

    public void updateBaseLayers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.b.updateBaseLayers();
        }
    }

    public void updateDrawFPS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            this.b.updateDrawFPS();
        }
    }

    public void updateFootMarkGrid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            this.b.updateFootMarkGrid();
        }
    }

    public String GetNearlyObjID(long j, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            return this.b.getNearlyObjID(j, i, i2, i3);
        }
        return (String) invokeCommon.objValue;
    }

    public void SetFocus(long j, long j2, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), bundle}) == null) {
            this.b.setFocus(j, j2, z, bundle);
        }
    }

    public boolean addBmLayerBelow(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048674, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            return this.b.addBmLayerBelow(j, j2, i, i2);
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public boolean Init(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.a != 0 && this.b.init(str, str2, str3, str4, str5, str6, str7, i, i2, i3, i4, i5, i6, i7, z, z2)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean IsPointInFocusBarBorder(double d, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            if (this.a != 0 && this.b.isPointInFocusBarBorder(d, d2, d3)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean IsPointInFocusIDRBorder(double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            if (this.a != 0 && this.b.isPointInFocusIDRBorder(d, d2)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean OnRecordStart(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return this.b.onRecordStart(i, z, i2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean OnRecordSuspend(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return this.b.onRecordSuspend(i, z, i2);
        }
        return invokeCommon.booleanValue;
    }

    public String worldPointToScreenPoint(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048758, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return this.b.worldPointToScreenPoint(f, f2, f3);
        }
        return (String) invokeCommon.objValue;
    }

    public void renderInit(int i, int i2, Surface surface, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048719, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), surface, Integer.valueOf(i3)}) == null) {
            try {
                this.c.readLock().lock();
                this.b.renderInit(i, i2, surface, i3);
            } finally {
                this.c.readLock().unlock();
            }
        }
    }
}
