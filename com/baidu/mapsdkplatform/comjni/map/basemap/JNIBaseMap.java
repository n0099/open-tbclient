package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class JNIBaseMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f42331a;

    public JNIBaseMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static native int MapProc(long j2, int i2, int i3, int i4);

    public static native void SetMapCustomEnable(long j2, boolean z);

    public native long AddLayer(long j2, int i2, int i3, String str);

    public native void ClearLayer(long j2, long j3);

    public native long Create();

    public native long CreateDuplicate(long j2);

    public native String GeoPtToScrPoint(long j2, int i2, int i3);

    public native boolean GetBaiduHotMapCityInfo(long j2);

    public native Bundle GetMapStatus(long j2);

    public native String GetNearlyObjID(long j2, long j3, int i2, int i3, int i4);

    public native int[] GetScreenBuf(long j2, int[] iArr, int i2, int i3);

    public native float GetZoomToBound(long j2, Bundle bundle);

    public native boolean Init(long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public native boolean IsBaseIndoorMapMode(long j2);

    public native boolean LayersIsShow(long j2, long j3);

    public native void OnBackground(long j2);

    public native void OnForeground(long j2);

    public native String OnHotcityGet(long j2);

    public native void OnPause(long j2);

    public native boolean OnRecordAdd(long j2, int i2);

    public native String OnRecordGetAll(long j2);

    public native String OnRecordGetAt(long j2, int i2);

    public native boolean OnRecordImport(long j2, boolean z, boolean z2);

    public native boolean OnRecordReload(long j2, int i2, boolean z);

    public native boolean OnRecordRemove(long j2, int i2, boolean z);

    public native boolean OnRecordStart(long j2, int i2, boolean z, int i3);

    public native boolean OnRecordSuspend(long j2, int i2, boolean z, int i3);

    public native void OnResume(long j2);

    public native String OnSchcityGet(long j2, String str);

    public native void PostStatInfo(long j2);

    public native int Release(long j2);

    public native void ResetImageRes(long j2);

    public native void SaveScreenToLocal(long j2, String str, Bundle bundle);

    public native String ScrPtToGeoPoint(long j2, int i2, int i3);

    public native int SetCallback(long j2, BaseMapCallback baseMapCallback);

    public native int SetMapControlMode(long j2, int i2);

    public native void SetMapStatus(long j2, Bundle bundle);

    public native void ShowBaseIndoorMap(long j2, boolean z);

    public native void ShowHotMap(long j2, boolean z);

    public native void ShowLayers(long j2, long j3, boolean z);

    public native void ShowSatelliteMap(long j2, boolean z);

    public native void ShowTrafficMap(long j2, boolean z);

    public native boolean SwitchBaseIndoorMapFloor(long j2, String str, String str2);

    public native boolean SwitchLayer(long j2, long j3, long j4);

    public native void UpdateLayers(long j2, long j3);

    public native void addOneOverlayItem(long j2, Bundle bundle);

    public native void addOverlayItems(long j2, Bundle[] bundleArr, int i2);

    public native boolean addtileOverlay(long j2, Bundle bundle);

    public native boolean cleanSDKTileDataCache(long j2, long j3);

    public native void clearHeatMapLayerCache(long j2);

    public native void enableDrawHouseHeight(long j2, boolean z);

    public native String getCompassPosition(long j2, long j3);

    public native Bundle getDrawingMapStatus(long j2);

    public native Bundle getMapStatusLimits(long j2);

    public native void getProjectionMatrix(long j2, float[] fArr, int i2);

    public native void getViewMatrix(long j2, float[] fArr, int i2);

    public native String getfocusedBaseIndoorMapInfo(long j2);

    public native boolean isDrawHouseHeightEnable(long j2);

    public native void removeOneOverlayItem(long j2, Bundle bundle);

    public native void resetBackgroundTransparent(long j2);

    public native void setBackgroundTransparent(long j2);

    public native void setCustomTrafficColor(long j2, long j3, long j4, long j5, long j6, boolean z);

    public native void setMapStatusLimits(long j2, Bundle bundle);

    public native void updateOneOverlayItem(long j2, Bundle bundle);

    public native boolean updateSDKTile(long j2, Bundle bundle);
}
