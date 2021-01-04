package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes15.dex */
public class AppBaseMap {

    /* renamed from: b  reason: collision with root package name */
    private NABaseMap f4719b;

    /* renamed from: a  reason: collision with root package name */
    private long f4718a = 0;
    private final ReadWriteLock c = new ReentrantReadWriteLock(true);

    public AppBaseMap() {
        this.f4719b = null;
        this.f4719b = new NABaseMap();
    }

    public static void renderClearShaderCache(String str) {
        NABaseMap.renderClearShaderCache(str);
    }

    public void AddItemData(Bundle bundle) {
        this.f4719b.addItemData(bundle);
    }

    public long AddLayer(int i, int i2, String str) {
        return this.f4719b.addLayer(i, i2, str);
    }

    public void AddPopupData(Bundle bundle) {
        this.f4719b.addPopupData(bundle);
    }

    public void AddRtPopData(Bundle bundle) {
        this.f4719b.addRtPopData(bundle);
    }

    public void AddStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (this.f4718a != 0) {
            this.f4719b.addStreetCustomMarker(bundle, bitmap);
        }
    }

    public void BeginLocationLayerAnimation() {
        this.f4719b.beginLocationLayerAnimation();
    }

    public boolean CleanCache(int i) {
        return this.f4719b.cleanCache(i);
    }

    public void ClearLayer(long j) {
        this.f4719b.clearLayer(j);
    }

    public void ClearLocationLayerData(Bundle bundle) {
        this.f4719b.clearLocationLayerData(bundle);
    }

    public void ClearMistmapLayer() {
        this.f4719b.clearMistmapLayer();
    }

    public void ClearSDKLayer(long j) {
        this.f4719b.clearSDKLayer(j);
    }

    public boolean CloseCache() {
        return this.f4719b.closeCache();
    }

    public boolean Create() {
        try {
            this.c.writeLock().lock();
            this.f4718a = this.f4719b.create();
            return true;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    public boolean CreateByDuplicate(long j) {
        this.f4718a = this.f4719b.createByDuplicate(j);
        return this.f4718a != 0;
    }

    public long CreateDuplicate() {
        return this.f4719b.createDuplicate();
    }

    public int Draw() {
        if (this.f4718a != 0) {
            return this.f4719b.draw();
        }
        return 0;
    }

    public String GeoPtToScrPoint(int i, int i2) {
        return this.f4719b.geoPtToScrPoint(i, i2);
    }

    public float GetAdapterZoomUnitsEx() {
        return this.f4719b.getAdapterZoomUnitsEx();
    }

    public int GetCacheSize(int i) {
        return this.f4719b.getCacheSize(i);
    }

    public String GetCityInfoByID(int i) {
        return this.f4719b.getCityInfoByID(i);
    }

    public Bundle GetDrawingMapStatus() {
        return this.f4719b.getDrawingMapStatus();
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        return this.f4719b.getFZoomToBoundF(bundle, bundle2);
    }

    public String GetFocusedBaseIndoorMapInfo() {
        if (this.f4718a != 0) {
            return this.f4719b.getFocusedBaseIndoorMapInfo();
        }
        return null;
    }

    public long GetId() {
        return this.f4718a;
    }

    public int GetMapRenderType() {
        return this.f4719b.getMapRenderType();
    }

    public Bundle GetMapStatus() {
        return this.f4719b.getMapStatus(true);
    }

    public Bundle GetMapStatus(boolean z) {
        return this.f4719b.getMapStatus(z);
    }

    public String GetNearlyObjID(long j, int i, int i2, int i3) {
        return this.f4719b.getNearlyObjID(j, i, i2, i3);
    }

    public int GetVMPMapCityInfo(Bundle bundle) {
        return this.f4719b.getVMPMapCityInfo(bundle);
    }

    public float GetZoomToBound(Bundle bundle, int i, int i2) {
        return this.f4719b.getZoomToBound(bundle, i, i2);
    }

    public float GetZoomToBoundF(Bundle bundle) {
        return this.f4719b.getZoomToBoundF(bundle);
    }

    public boolean Init(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        return this.f4718a != 0 && this.f4719b.init(str, str2, str3, str4, str5, str6, str7, i, i2, i3, i4, i5, i6, i7, z, z2);
    }

    public boolean IsBaseIndoorMapMode() {
        return this.f4718a != 0 && this.f4719b.isBaseIndoorMapMode();
    }

    public boolean IsPointInFocusBarBorder(double d, double d2, double d3) {
        return this.f4718a != 0 && this.f4719b.isPointInFocusBarBorder(d, d2, d3);
    }

    public boolean IsPointInFocusIDRBorder(double d, double d2) {
        return this.f4718a != 0 && this.f4719b.isPointInFocusIDRBorder(d, d2);
    }

    public boolean IsStreetArrowShown() {
        return this.f4719b.isStreetArrowShown();
    }

    public boolean IsStreetCustomMarkerShown() {
        return this.f4719b.isStreetCustomMarkerShown();
    }

    public boolean IsStreetPOIMarkerShown() {
        return this.f4718a != 0 && this.f4719b.isStreetPOIMarkerShown();
    }

    public boolean IsStreetRoadClickable() {
        return this.f4719b.isStreetRoadClickable();
    }

    public boolean LayersIsShow(long j) {
        return this.f4719b.layersIsShow(j);
    }

    public void MoveToScrPoint(int i, int i2) {
        this.f4719b.moveToScrPoint(i, i2);
    }

    public void OnBackground() {
        try {
            this.c.readLock().lock();
            if (this.f4718a != 0) {
                this.f4719b.onBackground();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void OnForeground() {
        try {
            this.c.readLock().lock();
            if (this.f4718a != 0) {
                this.f4719b.onForeground();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public String OnHotcityGet() {
        return this.f4719b.onHotcityGet();
    }

    public void OnPause() {
        try {
            this.c.readLock().lock();
            if (this.f4718a != 0) {
                this.f4719b.onPause();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public boolean OnRecordAdd(int i) {
        return this.f4719b.onRecordAdd(i);
    }

    public String OnRecordGetAll() {
        return this.f4719b.onRecordGetAll();
    }

    public String OnRecordGetAt(int i) {
        return this.f4719b.onRecordGetAt(i);
    }

    public boolean OnRecordImport(boolean z, boolean z2) {
        return this.f4719b.onRecordImport(z, z2);
    }

    public boolean OnRecordReload(int i, boolean z) {
        return this.f4719b.onRecordReload(i, z);
    }

    public boolean OnRecordRemove(int i, boolean z) {
        return this.f4719b.onRecordRemove(i, z);
    }

    public boolean OnRecordStart(int i, boolean z, int i2) {
        return this.f4719b.onRecordStart(i, z, i2);
    }

    public boolean OnRecordSuspend(int i, boolean z, int i2) {
        return this.f4719b.onRecordSuspend(i, z, i2);
    }

    public void OnResume() {
        try {
            this.c.readLock().lock();
            if (this.f4718a != 0) {
                this.f4719b.onResume();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public String OnSchcityGet(String str) {
        return this.f4719b.onSchcityGet(str);
    }

    public boolean OnUsrcityMsgInterval(int i) {
        return this.f4719b.onUsrcityMsgInterval(i);
    }

    public int OnWifiRecordAdd(int i) {
        return this.f4719b.onWifiRecordAdd(i);
    }

    public boolean Release() {
        ReadWriteLock readWriteLock;
        Lock writeLock;
        try {
            this.c.writeLock().lock();
            if (this.f4718a == 0) {
                return false;
            }
            BaseMapCallback.release(this.f4718a);
            this.f4719b.dispose();
            this.f4718a = 0L;
            return true;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    public void Remo() {
    }

    public boolean RemoveItemData(Bundle bundle) {
        return this.f4719b.removeItemData(bundle);
    }

    public void RemoveLayer(long j) {
        this.f4719b.removeLayer(j);
    }

    public void RemoveStreetAllCustomMarker() {
        this.f4719b.removeStreetAllCustomMarker();
    }

    public void RemoveStreetCustomMaker(String str) {
        this.f4719b.removeStreetCustomMaker(str);
    }

    public void ResetImageRes() {
        if (this.f4718a != 0) {
            this.f4719b.resetImageRes();
        }
    }

    public boolean ResumeCache() {
        return this.f4719b.resumeCache();
    }

    public boolean SaveCache() {
        try {
            return this.f4719b.saveCache();
        } catch (Throwable th) {
            return false;
        }
    }

    public void SaveScreenToLocal(String str, String str2) {
        this.f4719b.saveScreenToLocal(str, str2);
    }

    public String ScrPtToGeoPoint(int i, int i2) {
        return this.f4719b.scrPtToGeoPoint(i, i2);
    }

    public void SetAllStreetCustomMarkerVisibility(boolean z) {
        if (this.f4718a != 0) {
            this.f4719b.setAllStreetCustomMarkerVisibility(z);
        }
    }

    public boolean SetCallback(a aVar) {
        return (aVar == null || this.f4718a == 0 || !BaseMapCallback.setMapCallback(this.f4718a, aVar)) ? false : true;
    }

    public void SetFocus(long j, long j2, boolean z, Bundle bundle) {
        this.f4719b.setFocus(j, j2, z, bundle);
    }

    public boolean SetItsPreTime(int i, int i2, int i3) {
        return this.f4719b.setItsPreTime(i, i2, i3);
    }

    public boolean SetLayerSceneMode(long j, int i) {
        return this.f4719b.setLayerSceneMode(j, i);
    }

    public void SetLayersClickable(long j, boolean z) {
        this.f4719b.setLayersClickable(j, z);
    }

    public void SetLocationLayerData(Bundle bundle) {
        this.f4719b.setLocationLayerData(bundle);
    }

    public int SetMapControlMode(int i) {
        return this.f4719b.setMapControlMode(i);
    }

    public void SetMapStatus(Bundle bundle) {
        this.f4719b.setMapStatus(bundle);
    }

    public void SetNewMapStatus(Bundle bundle) {
        this.f4719b.setNewMapStatus(bundle);
    }

    public boolean SetSDKLayerCallback(com.baidu.mapsdkplatform.comjni.a.a.a aVar) {
        return (aVar == null || this.f4718a == 0 || !BaseMapCallback.setMapSDKCallback(this.f4718a, aVar)) ? false : true;
    }

    public void SetStreetArrowShow(boolean z) {
        this.f4719b.setStreetArrowShow(z);
    }

    public void SetStreetMarkerClickable(String str, boolean z) {
        this.f4719b.setStreetMarkerClickable(str, z);
    }

    public void SetStreetRoadClickable(boolean z) {
        this.f4719b.setStreetRoadClickable(z);
    }

    public void SetStyleMode(int i) {
        this.f4719b.setStyleMode(i);
    }

    public void SetTargetStreetCustomMarkerVisibility(boolean z, String str) {
        if (this.f4718a != 0) {
            this.f4719b.setTargetStreetCustomMarkerVisibility(z, str);
        }
    }

    public void ShowBaseIndoorMap(boolean z) {
        this.f4719b.showBaseIndoorMap(z);
    }

    public void ShowHotMap(boolean z, int i) {
        this.f4719b.showHotMap(z, i);
    }

    public void ShowHotMap(boolean z, int i, String str) {
        this.f4719b.showHotMap(z, i, str);
    }

    public void ShowLayers(long j, boolean z) {
        if (this.f4718a != 0) {
            this.f4719b.showLayers(j, z);
        }
    }

    public void ShowMistMap(boolean z, String str) {
        this.f4719b.showMistMap(z, str);
    }

    public void ShowSatelliteMap(boolean z) {
        this.f4719b.showSatelliteMap(z);
    }

    public void ShowStreetPOIMarker(boolean z) {
        if (this.f4718a != 0) {
            this.f4719b.showStreetPOIMarker(z);
        }
    }

    public void ShowStreetRoadMap(boolean z) {
        this.f4719b.showStreetRoadMap(z);
    }

    public void ShowTrafficMap(boolean z) {
        this.f4719b.showTrafficMap(z);
    }

    public void StartIndoorAnimation() {
        this.f4719b.startIndoorAnimation();
    }

    public boolean SwitchBaseIndoorMapFloor(String str, String str2) {
        return this.f4719b.switchBaseIndoorMapFloor(str, str2);
    }

    public boolean SwitchLayer(long j, long j2) {
        return this.f4719b.switchLayer(j, j2);
    }

    public void UpdateLayers(long j) {
        this.f4719b.updateLayers(j);
    }

    public void addOneOverlayItem(Bundle bundle) {
        this.f4719b.addOneOverlayItem(bundle);
    }

    public void addOverlayItems(Bundle[] bundleArr, int i) {
        this.f4719b.addOverlayItems(bundleArr, i);
    }

    public boolean addSDKTileData(Bundle bundle) {
        return this.f4719b.nativeAddTileOverlay(this.f4718a, bundle);
    }

    public boolean cleanSDKTileDataCache(long j) {
        return this.f4719b.nativeCleanSDKTileDataCache(this.f4718a, j);
    }

    public void clearUniversalLayer() {
        this.f4719b.clearUniversalLayer();
    }

    public void closeParticleEffect(String str) {
        this.f4719b.closeParticleEffect(str);
    }

    public void enablePOIAnimation(boolean z) {
        try {
            this.c.readLock().lock();
            this.f4719b.enablePOIAnimation(z);
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void entrySearchTopic(int i) {
        this.f4719b.entrySearchTopic(i);
    }

    public void exitSearchTopic() {
        this.f4719b.exitSearchTopic();
    }

    public void focusTrafficUGCLabel() {
        this.f4719b.focusTrafficUGCLabel();
    }

    public boolean getDEMEnable() {
        return this.f4719b.getDEMEnable();
    }

    public boolean getDrawHouseHeightEnable() {
        if (this.f4719b == null) {
            return false;
        }
        return this.f4719b.getDrawHouseHeightEnable();
    }

    public long getLayerIDByTag(String str) {
        if (this.f4719b == null) {
            return 0L;
        }
        return this.f4719b.getLayerIDByTag(str);
    }

    public boolean getMapBarData(Bundle bundle) {
        return this.f4719b.getMapBarData(bundle);
    }

    public int getMapScene() {
        return this.f4719b.getMapScene();
    }

    public Bundle getMapStatusLimits() {
        if (this.f4719b == null) {
            return null;
        }
        return this.f4719b.getMapStatusLimits();
    }

    public int getMapTheme() {
        return this.f4719b.getMapTheme();
    }

    public float[] getProjectionMatrix() {
        if (this.f4719b == null) {
            return null;
        }
        float[] fArr = new float[16];
        this.f4719b.getProjectMatrix(fArr);
        return fArr;
    }

    public String getProjectionPt(String str) {
        return this.f4719b.getProjectionPt(str);
    }

    public int getScaleLevel(int i, int i2) {
        return this.f4719b.getScaleLevel(i, i2);
    }

    public float[] getViewMatrix() {
        if (this.f4719b == null) {
            return null;
        }
        float[] fArr = new float[16];
        this.f4719b.getViewMatrix(fArr);
        return fArr;
    }

    public boolean importMapTheme(int i) {
        return this.f4719b.importMapTheme(i);
    }

    public boolean initCustomStyle(String str, String str2) {
        if (this.f4719b == null) {
            return false;
        }
        return this.f4719b.initCustomStyle(str, str2);
    }

    public boolean isAnimationRunning() {
        return this.f4719b.isAnimationRunning();
    }

    public boolean isNaviMode() {
        return this.f4719b.isNaviMode();
    }

    public boolean performAction(String str) {
        return this.f4719b.performAction(str);
    }

    public void recycleMemory(int i) {
        this.f4719b.recycleMemory(i);
    }

    public void removeOneOverlayItem(Bundle bundle) {
        this.f4719b.removeOneOverlayItem(bundle);
    }

    public void renderDone() {
        try {
            this.c.readLock().lock();
            this.f4719b.renderDone();
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void renderInit(int i, int i2, Surface surface, int i3) {
        try {
            this.c.readLock().lock();
            this.f4719b.renderInit(i, i2, surface, i3);
        } finally {
            this.c.readLock().unlock();
        }
    }

    public int renderRender() {
        try {
            this.c.readLock().lock();
            return this.f4719b.renderRender();
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void renderResize(int i, int i2) {
        try {
            this.c.readLock().lock();
            this.f4719b.renderResize(i, i2);
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void resize(int i, int i2) {
        if (this.f4718a != 0) {
            this.f4719b.renderResize(i, i2);
        }
    }

    public void setCustomStyleEnable(boolean z) {
        if (this.f4719b == null) {
            return;
        }
        this.f4719b.setCustomStyleEnable(z);
    }

    public void setDEMEnable(boolean z) {
        this.f4719b.setDEMEnable(z);
    }

    public void setDrawHouseHeightEnable(boolean z) {
        if (this.f4719b == null) {
            return;
        }
        this.f4719b.setDrawHouseHeightEnable(z);
    }

    public void setMapScene(int i) {
        this.f4719b.setMapScene(i);
    }

    public void setMapStatusLimits(Bundle bundle) {
        if (this.f4719b == null) {
            return;
        }
        this.f4719b.setMapStatusLimits(bundle);
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        return this.f4719b.setMapTheme(i, bundle);
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        return this.f4719b.setMapThemeScene(i, i2, bundle);
    }

    public void setMaxAndMinZoomLevel(Bundle bundle) {
        if (this.f4719b == null) {
            return;
        }
        this.f4719b.setMaxAndMinZoomLevel(bundle);
    }

    public void setRecommendPOIScene(int i) {
        this.f4719b.setRecommendPOIScene(i);
    }

    public boolean setTestSwitch(boolean z) {
        return this.f4719b.setTestSwitch(z);
    }

    public void setTrafficUGCData(String str) {
        this.f4719b.setTrafficUGCData(str);
    }

    public void setUniversalFilter(String str) {
        this.f4719b.setUniversalFilter(str);
    }

    public boolean showParticleEffect(int i) {
        return this.f4719b.showParticleEffect(i);
    }

    public boolean showParticleEffectByName(String str, boolean z) {
        return this.f4719b.showParticleEffectByName(str, z);
    }

    public boolean showParticleEffectByType(int i) {
        return this.f4719b.showParticleEffectByType(i);
    }

    public void showTrafficUGCMap(boolean z) {
        this.f4719b.showTrafficUGCMap(z);
    }

    public void showUniversalLayer(Bundle bundle) {
        this.f4719b.showUniversalLayer(bundle);
    }

    public void unFocusTrafficUGCLabel() {
        this.f4719b.unFocusTrafficUGCLabel();
    }

    public void updateDrawFPS() {
        this.f4719b.updateDrawFPS();
    }

    public void updateOneOverlayItem(Bundle bundle) {
        this.f4719b.updateOneOverlayItem(bundle);
    }

    public boolean updateSDKTile(Bundle bundle) {
        return this.f4719b.nativeUpdateSDKTile(this.f4718a, bundle);
    }

    public String worldPointToScreenPoint(float f, float f2, float f3) {
        return this.f4719b.worldPointToScreenPoint(f, f2, f3);
    }
}
