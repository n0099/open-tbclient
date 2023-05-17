package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.af;
import com.baidu.platform.comjni.NativeComponent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes3.dex */
public class NABaseMap extends NativeComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;
    public long b;
    public volatile boolean c;
    public final ReadWriteLock d;
    public final Set<Long> e;

    private native boolean nativeAddBmLayerBelow(long j, long j2, long j3, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeAddItemData(long j, Bundle bundle, boolean z);

    private native long nativeAddLayer(long j, int i, int i2, String str);

    private native void nativeAddPopupData(long j, Bundle bundle);

    private native void nativeAddRtPopData(long j, Bundle bundle);

    private native void nativeAddStreetCustomMarker(long j, Bundle bundle, Bitmap bitmap);

    private native void nativeAttachDC(long j, long j2);

    private native boolean nativeBeginLocationLayerAnimation(long j);

    private native boolean nativeCleanCache(long j, int i);

    private native void nativeClearHeatMapLayerCache(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClearLayer(long j, long j2);

    private native void nativeClearLocationLayerData(long j, Bundle bundle);

    private native void nativeClearMistmapLayer(long j);

    private native void nativeClearUniversalLayer(long j);

    private native boolean nativeCloseCache(long j);

    private native void nativeCloseParticleEffect(long j, String str);

    private native long nativeCreate();

    private native long nativeCreateDuplicate(long j);

    private native int nativeDraw(long j);

    private native void nativeEnablePOIAnimation(long j, boolean z);

    private native void nativeEntrySearchTopic(long j, int i, String str, String str2);

    private native void nativeExitSearchTopic(long j);

    private native void nativeFocusTrafficUGCLabel(long j);

    private native String nativeGeoPt3ToScrPoint(long j, int i, int i2, int i3);

    private native String nativeGeoPtToScrPoint(long j, int i, int i2);

    public static native boolean nativeGet3DModelEnable(long j);

    private native float nativeGetAdapterZoomUnitsEx(long j);

    private native int nativeGetCacheSize(long j, int i);

    private native String nativeGetCityInfoByID(long j, int i);

    public static native boolean nativeGetDEMEnable(long j);

    public static native boolean nativeGetDrawHouseHeightEnable(long j);

    private native Bundle nativeGetDrawingMapStatus(long j);

    private native float nativeGetFZoomToBoundF(long j, Bundle bundle, Bundle bundle2);

    private native String nativeGetFocusedBaseIndoorMapInfo(long j);

    private native int nativeGetFontSizeLevel(long j);

    public static native long nativeGetLayerIDByTag(long j, String str);

    private native int nativeGetLayerPos(long j, long j2);

    private native boolean nativeGetMapBarData(long j, Bundle bundle);

    private native int nativeGetMapLanguage(long j);

    private native int nativeGetMapRenderType(long j);

    private native int nativeGetMapScene(long j);

    private native Bundle nativeGetMapStatus(long j, boolean z);

    public static native Bundle nativeGetMapStatusLimits(long j);

    private native boolean nativeGetMapStatusLimitsLevel(long j, int[] iArr);

    private native int nativeGetMapTheme(long j);

    private native String nativeGetNearlyObjID(long j, long j2, int i, int i2, int i3);

    public static native void nativeGetProjectionMatrix(long j, float[] fArr);

    private native String nativeGetProjectionPt(long j, String str);

    private native int nativeGetScaleLevel(long j, int i, int i2);

    public static native int nativeGetSkyboxStyle(long j);

    private native int nativeGetVMPMapCityInfo(long j, Bundle bundle);

    public static native void nativeGetViewMatrix(long j, float[] fArr);

    private native float nativeGetZoomToBound(long j, Bundle bundle, int i, int i2);

    private native float nativeGetZoomToBoundF(long j, Bundle bundle);

    private native boolean nativeImportMapTheme(long j, int i);

    private native boolean nativeInit(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeInitCustomStyle(long j, String str, String str2);

    private native void nativeInitHeatMapData(long j, long j2, Bundle bundle);

    private native int nativeInitLayerCallback(long j);

    private native boolean nativeInitWithBundle(long j, Bundle bundle, boolean z);

    private native long nativeInsertLayerAt(long j, int i, int i2, int i3, String str);

    private native boolean nativeIsAnimationRunning(long j);

    private native boolean nativeIsBaseIndoorMapMode(long j);

    private native boolean nativeIsEnableIndoor3D(long j);

    private native boolean nativeIsNaviMode(long j);

    private native boolean nativeIsPointInFocusBarBorder(long j, double d, double d2, double d3);

    private native boolean nativeIsPointInFocusIDRBorder(long j, double d, double d2);

    private native boolean nativeIsStreetArrowShown(long j);

    private native boolean nativeIsStreetCustomMarkerShown(long j);

    private native boolean nativeIsStreetPOIMarkerShown(long j);

    private native boolean nativeIsStreetRoadClickable(long j);

    private native boolean nativeLayersIsShow(long j, long j2);

    private native boolean nativeMoveLayerBelowTo(long j, long j2, int i);

    private native void nativeMoveToScrPoint(long j, int i, int i2);

    private native void nativeNewSetMapStatus(long j, Bundle bundle);

    private native void nativeOnBackground(long j);

    private native void nativeOnForeground(long j);

    private native String nativeOnHotcityGet(long j);

    private native void nativeOnPause(long j);

    private native boolean nativeOnRecordAdd(long j, int i);

    private native String nativeOnRecordGetAll(long j);

    private native String nativeOnRecordGetAt(long j, int i);

    private native boolean nativeOnRecordImport(long j, boolean z, boolean z2);

    private native boolean nativeOnRecordReload(long j, int i, boolean z);

    private native boolean nativeOnRecordRemove(long j, int i, boolean z);

    private native boolean nativeOnRecordStart(long j, int i, boolean z, int i2);

    private native boolean nativeOnRecordSuspend(long j, int i, boolean z, int i2);

    private native void nativeOnResume(long j);

    private native String nativeOnSchcityGet(long j, String str);

    private native boolean nativeOnUsrcityMsgInterval(long j, int i);

    private native int nativeOnWifiRecordAdd(long j, int i);

    private native boolean nativePerformAction(long j, String str);

    private native int nativeQueryInterface(long j);

    private native void nativeRecycleMemory(long j, int i);

    private native int nativeRelease(long j);

    private native boolean nativeRemoveBmLayer(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeRemoveItemData(long j, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeRemoveLayer(long j, long j2);

    private native void nativeRemoveStreetAllCustomMarker(long j);

    private native void nativeRemoveStreetCustomMaker(long j, String str);

    public static native void nativeRenderClearShaderCache(String str);

    public static native void nativeRenderInit(long j, int i, int i2, Surface surface, int i3);

    private native void nativeRenderResize(long j, int i, int i2);

    private native void nativeResetImageRes(long j);

    private native boolean nativeResumeCache(long j);

    private native boolean nativeSaveCache(long j);

    private native void nativeSaveScreenToLocal(long j, String str, String str2);

    private native String nativeScrPtToGeoPoint(long j, int i, int i2);

    public static native void nativeSet3DModelEnable(long j, boolean z);

    private native void nativeSetAllStreetCustomMarkerVisibility(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetCustomStyleEnable(long j, boolean z);

    private native void nativeSetCustomVMPDataRoot(long j, String str);

    public static native void nativeSetDEMEnable(long j, boolean z);

    private native void nativeSetDpiScale(long j, float f);

    public static native void nativeSetDrawHouseHeightEnable(long j, boolean z);

    private native void nativeSetEnableIndoor3D(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeSetFocus(long j, long j2, long j3, boolean z, Bundle bundle);

    private native void nativeSetFontSizeLevel(long j, int i);

    private native void nativeSetHeatMapFrameAnimationIndex(long j, long j2, int i);

    private native boolean nativeSetItsPreTime(long j, int i, int i2, int i3);

    private native boolean nativeSetLayerSceneMode(long j, long j2, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetLayersClickable(long j, long j2, boolean z);

    private native void nativeSetLocationLayerData(long j, Bundle bundle);

    private native int nativeSetMapControlMode(long j, int i);

    private native void nativeSetMapLanguage(long j, int i);

    private native boolean nativeSetMapScene(long j, int i);

    private native void nativeSetMapStatus(long j, Bundle bundle);

    public static native void nativeSetMapStatusLimits(long j, Bundle bundle);

    private native boolean nativeSetMapStatusLimitsLevel(long j, int i, int i2);

    private native boolean nativeSetMapTheme(long j, int i, Bundle bundle);

    private native boolean nativeSetMapThemeScene(long j, int i, int i2, Bundle bundle);

    public static native void nativeSetMaxAndMinZoomLevel(long j, Bundle bundle);

    private native void nativeSetRecommendPOIScene(long j, int i);

    public static native void nativeSetSkyboxStyle(long j, int i);

    private native void nativeSetStreetArrowShow(long j, boolean z);

    private native void nativeSetStreetMarkerClickable(long j, String str, boolean z);

    private native void nativeSetStreetRoadClickable(long j, boolean z);

    private native void nativeSetStyleMode(long j, int i);

    private native void nativeSetTargetStreetCustomMarkerVisibility(long j, boolean z, String str);

    private native boolean nativeSetTestSwitch(long j, boolean z);

    private native void nativeSetTrafficUGCData(long j, String str);

    private native void nativeSetUniversalFilter(long j, String str);

    private native void nativeSetUseCustomVMP(long j, boolean z);

    private native void nativeShowBaseIndoorMap(long j, boolean z);

    private native void nativeShowFootMarkGrid(long j, boolean z, String str);

    private native void nativeShowHotMap(long j, boolean z, int i);

    private native void nativeShowHotMapWithUid(long j, boolean z, int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeShowLayers(long j, long j2, boolean z);

    private native void nativeShowMistMap(long j, boolean z, String str);

    private native boolean nativeShowParticleEffect(long j, int i);

    private native boolean nativeShowParticleEffectByName(long j, String str, boolean z);

    private native boolean nativeShowParticleEffectByType(long j, int i);

    private native void nativeShowSatelliteMap(long j, boolean z);

    private native void nativeShowStreetPOIMarker(long j, boolean z);

    private native void nativeShowStreetRoadMap(long j, boolean z);

    private native void nativeShowTrafficMap(long j, boolean z);

    private native void nativeShowTrafficUGCMap(long j, boolean z);

    private native void nativeShowUniversalLayer(long j, Bundle bundle);

    private native void nativeStartHeatMapFrameAnimation(long j, long j2);

    private native void nativeStartIndoorAnimation(long j);

    private native void nativeStopHeatMapFrameAnimation(long j, long j2);

    private native void nativeSurfaceDestroyed(long j, Surface surface);

    private native boolean nativeSwitchBaseIndoorMapFloor(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeSwitchLayer(long j, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSyncClearLayer(long j, long j2);

    private native void nativeUnFocusTrafficUGCLabel(long j);

    private native void nativeUpdateBaseLayers(long j);

    private native void nativeUpdateDrawFPS(long j);

    private native void nativeUpdateFootMarkGrid(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeUpdateLayers(long j, long j2);

    private native String nativeworldPointToScreenPoint(long j, float f, float f2, float f3);

    public native void nativeAddOneOverlayItem(long j, Bundle bundle);

    public native void nativeAddOverlayItems(long j, Bundle[] bundleArr, int i);

    public native boolean nativeAddTileOverlay(long j, Bundle bundle);

    public native boolean nativeCleanSDKTileDataCache(long j, long j2);

    public native void nativeRemoveOneOverlayItem(long j, Bundle bundle);

    public native void nativeUpdateOneOverlayItem(long j, Bundle bundle);

    public native boolean nativeUpdateSDKTile(long j, Bundle bundle);

    @Deprecated
    public void renderDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
        }
    }

    public NABaseMap() {
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
        this.a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.c = false;
        this.d = new ReentrantReadWriteLock(true);
        this.e = new CopyOnWriteArraySet();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                if (this.a != null) {
                    if (this.a.getQueue() != null) {
                        this.a.getQueue().clear();
                    }
                    this.a.shutdown();
                    this.a.awaitTermination(100L, TimeUnit.MILLISECONDS);
                    this.a.shutdownNow();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void renderClearShaderCache(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65729, null, str) == null) {
            nativeRenderClearShaderCache(str);
        }
    }

    public void addOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bundle) != null) || !b()) {
            return;
        }
        this.a.submit(new d(this, bundle));
    }

    public void addPopupData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            nativeAddPopupData(this.b, bundle);
        }
    }

    public void addRtPopData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            nativeAddRtPopData(this.b, bundle);
        }
    }

    public boolean cleanCache(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return nativeCleanCache(this.b, i);
        }
        return invokeI.booleanValue;
    }

    public void clearHeatMapLayerCache(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            long j2 = this.b;
            if (j2 != 0) {
                nativeClearHeatMapLayerCache(j2, j);
            }
        }
    }

    public void clearLayer(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048587, this, j) != null) || !b()) {
            return;
        }
        this.a.submit(new p(this, j));
    }

    public void clearLocationLayerData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            nativeClearLocationLayerData(this.b, bundle);
        }
    }

    public void clearSDKLayer(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048590, this, j) != null) || !b()) {
            return;
        }
        this.a.submit(new o(this, j));
    }

    public void closeParticleEffect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            nativeCloseParticleEffect(this.b, str);
        }
    }

    public long createByDuplicate(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
            long nativeCreateDuplicate = nativeCreateDuplicate(j);
            this.b = nativeCreateDuplicate;
            if (nativeCreateDuplicate != 0) {
                nativeInitLayerCallback(nativeCreateDuplicate);
            }
            return this.b;
        }
        return invokeJ.longValue;
    }

    public void enablePOIAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            long j = this.b;
            if (j != 0) {
                nativeEnablePOIAnimation(j, z);
            }
        }
    }

    public int getCacheSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            return nativeGetCacheSize(this.b, i);
        }
        return invokeI.intValue;
    }

    public String getCityInfoByID(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            return nativeGetCityInfoByID(this.b, i);
        }
        return (String) invokeI.objValue;
    }

    public long getLayerIDByTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            long j = this.b;
            if (j == 0) {
                return 0L;
            }
            return nativeGetLayerIDByTag(j, str);
        }
        return invokeL.longValue;
    }

    public boolean getMapBarData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, bundle)) == null) {
            return nativeGetMapBarData(this.b, bundle);
        }
        return invokeL.booleanValue;
    }

    public Bundle getMapStatus(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048620, this, z)) == null) {
            return nativeGetMapStatus(this.b, z);
        }
        return (Bundle) invokeZ.objValue;
    }

    public boolean getMapStatusLimitsLevel(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, iArr)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGetMapStatusLimitsLevel(j, iArr);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void getProjectMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, fArr) == null) {
            long j = this.b;
            if (j != 0) {
                nativeGetProjectionMatrix(j, fArr);
            }
        }
    }

    public String getProjectionPt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            return nativeGetProjectionPt(this.b, str);
        }
        return (String) invokeL.objValue;
    }

    public int getVMPMapCityInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, bundle)) == null) {
            return nativeGetVMPMapCityInfo(this.b, bundle);
        }
        return invokeL.intValue;
    }

    public void getViewMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, fArr) == null) {
            long j = this.b;
            if (j != 0) {
                nativeGetViewMatrix(j, fArr);
            }
        }
    }

    public float getZoomToBoundF(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, bundle)) == null) {
            return nativeGetZoomToBoundF(this.b, bundle);
        }
        return invokeL.floatValue;
    }

    public boolean importMapTheme(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i)) == null) {
            return nativeImportMapTheme(this.b, i);
        }
        return invokeI.booleanValue;
    }

    public boolean onRecordAdd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048664, this, i)) == null) {
            return nativeOnRecordAdd(this.b, i);
        }
        return invokeI.booleanValue;
    }

    public String onRecordGetAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048666, this, i)) == null) {
            return nativeOnRecordGetAt(this.b, i);
        }
        return (String) invokeI.objValue;
    }

    public String onSchcityGet(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, str)) == null) {
            return nativeOnSchcityGet(this.b, str);
        }
        return (String) invokeL.objValue;
    }

    public boolean onUsrcityMsgInterval(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i)) == null) {
            return nativeOnUsrcityMsgInterval(this.b, i);
        }
        return invokeI.booleanValue;
    }

    public int onWifiRecordAdd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048675, this, i)) == null) {
            return nativeOnWifiRecordAdd(this.b, i);
        }
        return invokeI.intValue;
    }

    public boolean performAction(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, str)) == null) {
            return nativePerformAction(this.b, str);
        }
        return invokeL.booleanValue;
    }

    public void recycleMemory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i) == null) {
            long j = this.b;
            if (j != 0) {
                nativeRecycleMemory(j, i);
            }
        }
    }

    public void removeBmLayer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048678, this, j) == null) {
            nativeRemoveBmLayer(this.b, j);
        }
    }

    public boolean removeItemData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, bundle)) == null) {
            if (!b()) {
                return false;
            }
            this.a.submit(new c(this, bundle));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeLayer(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048680, this, j) != null) || !b()) {
            return;
        }
        this.a.submit(new m(this, j));
    }

    public void removeOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048681, this, bundle) != null) || !b()) {
            return;
        }
        this.a.submit(new g(this, bundle));
    }

    public void removeOneOverlayItems(Bundle[] bundleArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048682, this, bundleArr) == null) && bundleArr != null && b()) {
            this.a.submit(new h(this, bundleArr));
        }
    }

    public void removeStreetCustomMaker(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            nativeRemoveStreetCustomMaker(this.b, str);
        }
    }

    public void set3DModelEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSet3DModelEnable(j, z);
            }
        }
    }

    public void setAllStreetCustomMarkerVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetAllStreetCustomMarkerVisibility(j, z);
            }
        }
    }

    public void setCallback(af afVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, afVar) == null) {
            BaseMapCallback.setMapCallback(this.b, afVar);
        }
    }

    public void setCustomStyleEnable(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048697, this, z) != null) || !b()) {
            return;
        }
        this.a.submit(new j(this, z));
    }

    public void setDEMEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetDEMEnable(j, z);
            }
        }
    }

    public void setDpiScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048699, this, f) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetDpiScale(j, f);
            }
        }
    }

    public void setDrawHouseHeightEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetDrawHouseHeightEnable(j, z);
            }
        }
    }

    public void setEnableIndoor3D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetEnableIndoor3D(j, z);
            }
        }
    }

    public void setFontSizeLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048703, this, i) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetFontSizeLevel(j, i);
            }
        }
    }

    public void setLocationLayerData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            nativeSetLocationLayerData(this.b, bundle);
        }
    }

    public int setMapControlMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048709, this, i)) == null) {
            return nativeSetMapControlMode(this.b, i);
        }
        return invokeI.intValue;
    }

    public void setMapLanguage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048710, this, i) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetMapLanguage(j, i);
            }
        }
    }

    public void setMapScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i) == null) {
            nativeSetMapScene(this.b, i);
        }
    }

    public void setMapStatus(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            nativeSetMapStatus(this.b, bundle);
        }
    }

    public void setMapStatusLimits(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, bundle) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetMapStatusLimits(j, bundle);
            }
        }
    }

    public void setMaxAndMinZoomLevel(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, bundle) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetMaxAndMinZoomLevel(j, bundle);
            }
        }
    }

    public void setNewMapStatus(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, bundle) == null) {
            nativeNewSetMapStatus(this.b, bundle);
        }
    }

    public void setRecommendPOIScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i) == null) {
            nativeSetRecommendPOIScene(this.b, i);
        }
    }

    public void setSkyboxStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetSkyboxStyle(j, i);
            }
        }
    }

    public void setStreetArrowShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z) == null) {
            nativeSetStreetArrowShow(this.b, z);
        }
    }

    public void setStreetRoadClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z) == null) {
            nativeSetStreetRoadClickable(this.b, z);
        }
    }

    public void setStyleMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048724, this, i) == null) {
            nativeSetStyleMode(this.b, i);
        }
    }

    public boolean setTestSwitch(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048726, this, z)) == null) {
            return nativeSetTestSwitch(this.b, z);
        }
        return invokeZ.booleanValue;
    }

    public void setTrafficUGCData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, str) == null) {
            nativeSetTrafficUGCData(this.b, str);
        }
    }

    public void setUniversalFilter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, str) == null) {
            nativeSetUniversalFilter(this.b, str);
        }
    }

    public void showBaseIndoorMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z) == null) {
            nativeShowBaseIndoorMap(this.b, z);
        }
    }

    public boolean showParticleEffect(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048735, this, i)) == null) {
            return nativeShowParticleEffect(this.b, i);
        }
        return invokeI.booleanValue;
    }

    public boolean showParticleEffectByType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048737, this, i)) == null) {
            return nativeShowParticleEffectByType(this.b, i);
        }
        return invokeI.booleanValue;
    }

    public void showSatelliteMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z) == null) {
            nativeShowSatelliteMap(this.b, z);
        }
    }

    public void showStreetPOIMarker(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048739, this, z) == null) {
            long j = this.b;
            if (j != 0) {
                nativeShowStreetPOIMarker(j, z);
            }
        }
    }

    public void showStreetRoadMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z) == null) {
            nativeShowStreetRoadMap(this.b, z);
        }
    }

    public void showTrafficMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z) == null) {
            nativeShowTrafficMap(this.b, z);
        }
    }

    public void showTrafficUGCMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z) == null) {
            nativeShowTrafficUGCMap(this.b, z);
        }
    }

    public void showUniversalLayer(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, bundle) == null) {
            nativeShowUniversalLayer(this.b, bundle);
        }
    }

    public void startHeatMapFrameAnimation(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048744, this, j) == null) {
            long j2 = this.b;
            if (j2 != 0) {
                nativeStartHeatMapFrameAnimation(j2, j);
            }
        }
    }

    public void stopHeatMapFrameAnimation(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048746, this, j) == null) {
            long j2 = this.b;
            if (j2 != 0) {
                nativeStopHeatMapFrameAnimation(j2, j);
            }
        }
    }

    public void surfaceDestroyed(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, surface) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSurfaceDestroyed(j, surface);
            }
        }
    }

    public void updateLayers(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048754, this, j) != null) || !b()) {
            return;
        }
        this.a.submit(new l(this, j));
    }

    public void updateOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048755, this, bundle) != null) || !b()) {
            return;
        }
        this.a.submit(new f(this, bundle));
    }

    public long addLayer(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str)) == null) {
            long nativeAddLayer = nativeAddLayer(this.b, i, i2, str);
            this.e.remove(Long.valueOf(nativeAddLayer));
            return nativeAddLayer;
        }
        return invokeIIL.longValue;
    }

    public void entrySearchTopic(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048600, this, i, str, str2) == null) {
            long j = this.b;
            if (j != 0) {
                nativeEntrySearchTopic(j, i, str, str2);
            }
        }
    }

    public String geoPt3ToScrPoint(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048603, this, i, i2, i3)) == null) {
            return nativeGeoPt3ToScrPoint(this.b, i, i2, i3);
        }
        return (String) invokeIII.objValue;
    }

    public float getZoomToBound(Bundle bundle, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048633, this, bundle, i, i2)) == null) {
            return nativeGetZoomToBound(this.b, bundle, i, i2);
        }
        return invokeLII.floatValue;
    }

    public boolean setItsPreTime(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048705, this, i, i2, i3)) == null) {
            return nativeSetItsPreTime(this.b, i, i2, i3);
        }
        return invokeIII.booleanValue;
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048716, this, i, i2, bundle)) == null) {
            return nativeSetMapThemeScene(this.b, i, i2, bundle);
        }
        return invokeIIL.booleanValue;
    }

    public void showHotMap(boolean z, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048732, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
            nativeShowHotMapWithUid(this.b, z, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, this, j)) == null) {
            if (this.e.contains(Long.valueOf(j)) && j != 0) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public void addItemData(Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, z) != null) || !b()) {
            return;
        }
        this.a.submit(new r(this, bundle, z));
    }

    public void addOverlayItems(Bundle[] bundleArr, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048580, this, bundleArr, i) != null) || !b()) {
            return;
        }
        this.a.submit(new e(this, bundleArr, i));
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bundle, bitmap) == null) {
            long j = this.b;
            if (j != 0) {
                nativeAddStreetCustomMarker(j, bundle, bitmap);
            }
        }
    }

    public String geoPtToScrPoint(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048604, this, i, i2)) == null) {
            return nativeGeoPtToScrPoint(this.b, i, i2);
        }
        return (String) invokeII.objValue;
    }

    public float getFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, bundle, bundle2)) == null) {
            return nativeGetFZoomToBoundF(this.b, bundle, bundle2);
        }
        return invokeLL.floatValue;
    }

    public int getScaleLevel(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048628, this, i, i2)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGetScaleLevel(j, i, i2);
            }
            return -1;
        }
        return invokeII.intValue;
    }

    public boolean initCustomStyle(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, str, str2)) == null) {
            if (!b()) {
                return false;
            }
            this.a.submit(new i(this, str, str2));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void initHeatMapData(long j, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048638, this, j, bundle) == null) {
            long j2 = this.b;
            if (j2 != 0) {
                nativeInitHeatMapData(j2, j, bundle);
            }
        }
    }

    public boolean initWithOptions(Bundle bundle, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048639, this, bundle, z)) == null) {
            long j = this.b;
            if (j != 0 && nativeInitWithBundle(j, bundle, z)) {
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void moveToScrPoint(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048652, this, i, i2) == null) {
            nativeMoveToScrPoint(this.b, i, i2);
        }
    }

    public boolean onRecordImport(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048667, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return nativeOnRecordImport(this.b, z, z2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean onRecordReload(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048668, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return nativeOnRecordReload(this.b, i, z);
        }
        return invokeCommon.booleanValue;
    }

    public boolean onRecordRemove(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048669, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return nativeOnRecordRemove(this.b, i, z);
        }
        return invokeCommon.booleanValue;
    }

    public void renderResize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048688, this, i, i2) == null) {
            long j = this.b;
            if (j != 0) {
                nativeRenderResize(j, i, i2);
            }
        }
    }

    public void saveScreenToLocal(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048692, this, str, str2) == null) {
            nativeSaveScreenToLocal(this.b, str, str2);
        }
    }

    public String scrPtToGeoPoint(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048693, this, i, i2)) == null) {
            return nativeScrPtToGeoPoint(this.b, i, i2);
        }
        return (String) invokeII.objValue;
    }

    public void setHeatMapFrameAnimationIndex(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048704, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            long j2 = this.b;
            if (j2 != 0) {
                nativeSetHeatMapFrameAnimationIndex(j2, j, i);
            }
        }
    }

    public boolean setLayerSceneMode(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048706, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            return nativeSetLayerSceneMode(this.b, j, i);
        }
        return invokeCommon.booleanValue;
    }

    public boolean setMapStatusLimitsLevel(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048714, this, i, i2)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeSetMapStatusLimitsLevel(j, i, i2);
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048715, this, i, bundle)) == null) {
            return nativeSetMapTheme(this.b, i, bundle);
        }
        return invokeIL.booleanValue;
    }

    public void setStreetMarkerClickable(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048722, this, str, z) == null) {
            nativeSetStreetMarkerClickable(this.b, str, z);
        }
    }

    public void setTargetStreetCustomMarkerVisibility(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048725, this, z, str) == null) {
            long j = this.b;
            if (j != 0) {
                nativeSetTargetStreetCustomMarkerVisibility(j, z, str);
            }
        }
    }

    public void showFootMarkGrid(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048730, this, z, str) == null) {
            long j = this.b;
            if (j != 0) {
                nativeShowFootMarkGrid(j, z, str);
            }
        }
    }

    public void showHotMap(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048731, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            nativeShowHotMap(this.b, z, i);
        }
    }

    public void showMistMap(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048734, this, z, str) == null) {
            nativeShowMistMap(this.b, z, str);
        }
    }

    public boolean showParticleEffectByName(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048736, this, str, z)) == null) {
            return nativeShowParticleEffectByName(this.b, str, z);
        }
        return invokeLZ.booleanValue;
    }

    public boolean switchBaseIndoorMapFloor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048748, this, str, str2)) == null) {
            return nativeSwitchBaseIndoorMapFloor(this.b, str, str2);
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (!this.a.isShutdown() && !this.a.isTerminated()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void beginLocationLayerAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            nativeBeginLocationLayerAnimation(this.b);
        }
    }

    public void clearMistmapLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            nativeClearMistmapLayer(this.b);
        }
    }

    public void clearUniversalLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            nativeClearUniversalLayer(this.b);
        }
    }

    public boolean closeCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return nativeCloseCache(this.b);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            long nativeCreate = nativeCreate();
            this.b = nativeCreate;
            nativeInitLayerCallback(nativeCreate);
            return this.b;
        }
        return invokeV.longValue;
    }

    public long createDuplicate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return nativeCreateDuplicate(this.b);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.b != 0) {
                this.c = true;
                a();
                int nativeRelease = nativeRelease(this.b);
                this.b = 0L;
                return nativeRelease;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int draw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeDraw(j);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void exitSearchTopic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            long j = this.b;
            if (j != 0) {
                nativeExitSearchTopic(j);
            }
        }
    }

    public void focusTrafficUGCLabel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            nativeFocusTrafficUGCLabel(this.b);
        }
    }

    public boolean get3DModelEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGet3DModelEnable(j);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public float getAdapterZoomUnitsEx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return nativeGetAdapterZoomUnitsEx(this.b);
        }
        return invokeV.floatValue;
    }

    public boolean getDEMEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            long j = this.b;
            if (j != 0) {
                nativeGetDEMEnable(j);
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getDrawHouseHeightEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGetDrawHouseHeightEnable(j);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Bundle getDrawingMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return nativeGetDrawingMapStatus(this.b);
        }
        return (Bundle) invokeV.objValue;
    }

    public String getFocusedBaseIndoorMapInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGetFocusedBaseIndoorMapInfo(j);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getFontSizeLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGetFontSizeLevel(j);
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int getMapLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGetMapLanguage(j);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getMapRenderType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return nativeGetMapRenderType(this.b);
        }
        return invokeV.intValue;
    }

    public int getMapScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return nativeGetMapScene(this.b);
        }
        return invokeV.intValue;
    }

    public Bundle getMapStatusLimits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGetMapStatusLimits(j);
            }
            return null;
        }
        return (Bundle) invokeV.objValue;
    }

    public int getMapTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return nativeGetMapTheme(this.b);
        }
        return invokeV.intValue;
    }

    public long getNativeMapPointer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public int getSkyboxStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeGetSkyboxStyle(j);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isAnimationRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return nativeIsAnimationRunning(this.b);
        }
        return invokeV.booleanValue;
    }

    public boolean isBaseIndoorMapMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            long j = this.b;
            if (j != 0 && nativeIsBaseIndoorMapMode(j)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableIndoor3D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeIsEnableIndoor3D(j);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isNaviMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return nativeIsNaviMode(this.b);
        }
        return invokeV.booleanValue;
    }

    public boolean isStreetArrowShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return nativeIsStreetArrowShown(this.b);
        }
        return invokeV.booleanValue;
    }

    public boolean isStreetCustomMarkerShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return nativeIsStreetCustomMarkerShown(this.b);
        }
        return invokeV.booleanValue;
    }

    public boolean isStreetPOIMarkerShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            long j = this.b;
            if (j != 0 && nativeIsStreetPOIMarkerShown(j)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isStreetRoadClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return nativeIsStreetRoadClickable(this.b);
        }
        return invokeV.booleanValue;
    }

    public void onBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            long j = this.b;
            if (j != 0) {
                nativeOnBackground(j);
            }
        }
    }

    public void onForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            long j = this.b;
            if (j != 0) {
                nativeOnForeground(j);
            }
        }
    }

    public String onHotcityGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return nativeOnHotcityGet(this.b);
        }
        return (String) invokeV.objValue;
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            long j = this.b;
            if (j != 0) {
                nativeOnPause(j);
            }
        }
    }

    public String onRecordGetAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return nativeOnRecordGetAll(this.b);
        }
        return (String) invokeV.objValue;
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            long j = this.b;
            if (j != 0) {
                nativeOnResume(j);
            }
        }
    }

    public void removeStreetAllCustomMarker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            nativeRemoveStreetAllCustomMarker(this.b);
        }
    }

    @Deprecated
    public int renderRender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            long j = this.b;
            if (j != 0) {
                return nativeDraw(j);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void resetImageRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            long j = this.b;
            if (j != 0) {
                nativeResetImageRes(j);
            }
        }
    }

    public boolean resumeCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return nativeResumeCache(this.b);
        }
        return invokeV.booleanValue;
    }

    public boolean saveCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            try {
                return nativeSaveCache(this.b);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void startIndoorAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            nativeStartIndoorAnimation(this.b);
        }
    }

    public void unFocusTrafficUGCLabel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            nativeUnFocusTrafficUGCLabel(this.b);
        }
    }

    public void updateBaseLayers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            nativeUpdateBaseLayers(this.b);
        }
    }

    public void updateDrawFPS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            long j = this.b;
            if (j != 0) {
                nativeUpdateDrawFPS(j);
            }
        }
    }

    public void updateFootMarkGrid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            nativeUpdateFootMarkGrid(this.b);
        }
    }

    public boolean addBmLayerBelow(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            return nativeAddBmLayerBelow(this.b, j, j2, i, i2);
        }
        return invokeCommon.booleanValue;
    }

    public float getZoomToBound(long j, Bundle bundle, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048632, this, new Object[]{Long.valueOf(j), bundle, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            return nativeGetZoomToBound(j, bundle, i, i2);
        }
        return invokeCommon.floatValue;
    }

    public void renderInit(int i, int i2, Surface surface, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048686, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), surface, Integer.valueOf(i3)}) == null) {
            long j = this.b;
            if (j != 0) {
                nativeRenderInit(j, i, i2, surface, i3);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE] complete} */
    public String getNearlyObjID(long j, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            boolean z = false;
            try {
                z = this.d.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (z) {
                    if (a(j)) {
                        if (z) {
                            this.d.readLock().unlock();
                        }
                        return "";
                    }
                    String nativeGetNearlyObjID = nativeGetNearlyObjID(this.b, j, i, i2, i3);
                    if (z) {
                        this.d.readLock().unlock();
                    }
                    return nativeGetNearlyObjID;
                }
                if (z) {
                    this.d.readLock().unlock();
                }
                return "";
            } catch (Exception unused) {
                if (z) {
                    this.d.readLock().unlock();
                }
                return "";
            } catch (Throwable th) {
                if (z) {
                    this.d.readLock().unlock();
                }
                throw th;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public boolean init(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048636, this, new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            long j = this.b;
            if (j != 0 && nativeInit(j, str, str2, str3, str4, str5, str6, str7, i, i2, i3, i4, i5, i6, i7, z, z2)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean isPointInFocusBarBorder(double d, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048644, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            long j = this.b;
            if (j != 0 && nativeIsPointInFocusBarBorder(j, d, d2, d3)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean onRecordStart(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048670, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return nativeOnRecordStart(this.b, i, z, i2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean onRecordSuspend(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048671, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return nativeOnRecordSuspend(this.b, i, z, i2);
        }
        return invokeCommon.booleanValue;
    }

    public String worldPointToScreenPoint(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048756, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return nativeworldPointToScreenPoint(this.b, f, f2, f3);
        }
        return (String) invokeCommon.objValue;
    }

    public boolean isPointInFocusIDRBorder(double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048645, this, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            long j = this.b;
            if (j != 0 && nativeIsPointInFocusIDRBorder(j, d, d2)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean moveLayerBelowTo(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048651, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            long j2 = this.b;
            if (j2 != 0) {
                return nativeMoveLayerBelowTo(j2, j, i);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void setLayersClickable(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048707, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) != null) || !b()) {
            return;
        }
        this.a.submit(new k(this, j, z));
    }

    public void showLayers(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048733, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) != null) || !b()) {
            return;
        }
        this.a.submit(new b(this, j, z));
    }

    public boolean switchLayer(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048749, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (!b()) {
                return false;
            }
            this.a.submit(new n(this, j, j2));
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean layersIsShow(long j) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048650, this, j)) == null) {
            boolean z2 = false;
            try {
                z = this.d.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
                if (z) {
                    try {
                        if (a(j)) {
                            if (z) {
                                this.d.readLock().unlock();
                            }
                            return false;
                        }
                        boolean nativeLayersIsShow = nativeLayersIsShow(this.b, j);
                        if (z) {
                            this.d.readLock().unlock();
                        }
                        return nativeLayersIsShow;
                    } catch (Exception unused) {
                        if (z) {
                            this.d.readLock().unlock();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        z2 = z;
                        if (z2) {
                            this.d.readLock().unlock();
                        }
                        throw th;
                    }
                }
                if (z) {
                    this.d.readLock().unlock();
                }
                return false;
            } catch (Exception unused2) {
                z = false;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeJ.booleanValue;
        }
    }

    public void setFocus(long j, long j2, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048702, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), bundle}) != null) || !b()) {
            return;
        }
        this.a.submit(new q(this, j, j2, z, bundle));
    }
}
