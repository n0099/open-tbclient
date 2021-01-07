package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import com.baidu.platform.comapi.map.ac;
import com.baidu.platform.comjni.NativeComponent;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes3.dex */
public class NABaseMap extends NativeComponent {

    /* renamed from: b  reason: collision with root package name */
    private long f4724b;

    /* renamed from: a  reason: collision with root package name */
    private ThreadPoolExecutor f4723a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private final ReadWriteLock c = new ReentrantReadWriteLock(true);
    private final Set<Long> d = new HashSet();

    private void a() {
        try {
            if (this.f4723a != null) {
                if (this.f4723a.getQueue() != null) {
                    this.f4723a.getQueue().clear();
                }
                this.f4723a.shutdownNow();
                this.f4723a.awaitTermination(20L, TimeUnit.MILLISECONDS);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j) {
        return this.d.contains(Long.valueOf(j)) && j != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        return (this.f4723a.isShutdown() || this.f4723a.isTerminated()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeAddItemData(long j, Bundle bundle);

    private native long nativeAddLayer(long j, int i, int i2, String str);

    private native void nativeAddPopupData(long j, Bundle bundle);

    private native void nativeAddRtPopData(long j, Bundle bundle);

    private native void nativeAddStreetCustomMarker(long j, Bundle bundle, Bitmap bitmap);

    private native void nativeAttachDC(long j, long j2);

    private native boolean nativeBeginLocationLayerAnimation(long j);

    private native boolean nativeCleanCache(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClearLayer(long j, long j2);

    private native void nativeClearLocationLayerData(long j, Bundle bundle);

    private native void nativeClearMistmapLayer(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClearSDKLayer(long j, long j2);

    private native void nativeClearUniversalLayer(long j);

    private native boolean nativeCloseCache(long j);

    private native void nativeCloseParticleEffect(long j, String str);

    private native long nativeCreate();

    private native long nativeCreateDuplicate(long j);

    private native int nativeDraw(long j);

    private native void nativeEnablePOIAnimation(long j, boolean z);

    private native void nativeEntrySearchTopic(long j, int i);

    private native void nativeExitSearchTopic(long j);

    private native void nativeFocusTrafficUGCLabel(long j);

    private native String nativeGeoPtToScrPoint(long j, int i, int i2);

    private native float nativeGetAdapterZoomUnitsEx(long j);

    private native int nativeGetCacheSize(long j, int i);

    private native String nativeGetCityInfoByID(long j, int i);

    private static native boolean nativeGetDEMEnable(long j);

    private static native boolean nativeGetDrawHouseHeightEnable(long j);

    private native Bundle nativeGetDrawingMapStatus(long j);

    private native float nativeGetFZoomToBoundF(long j, Bundle bundle, Bundle bundle2);

    private native String nativeGetFocusedBaseIndoorMapInfo(long j);

    private static native long nativeGetLayerIDByTag(long j, String str);

    private native int nativeGetLayerPos(long j, long j2);

    private native boolean nativeGetMapBarData(long j, Bundle bundle);

    private native int nativeGetMapRenderType(long j);

    private native int nativeGetMapScene(long j);

    private native Bundle nativeGetMapStatus(long j, boolean z);

    private static native Bundle nativeGetMapStatusLimits(long j);

    private native int nativeGetMapTheme(long j);

    private native String nativeGetNearlyObjID(long j, long j2, int i, int i2, int i3);

    private static native void nativeGetProjectionMatrix(long j, float[] fArr);

    private native String nativeGetProjectionPt(long j, String str);

    private native int nativeGetScaleLevel(long j, int i, int i2);

    private native int nativeGetVMPMapCityInfo(long j, Bundle bundle);

    private static native void nativeGetViewMatrix(long j, float[] fArr);

    private native float nativeGetZoomToBound(long j, Bundle bundle, int i, int i2);

    private native float nativeGetZoomToBoundF(long j, Bundle bundle);

    private native boolean nativeImportMapTheme(long j, int i);

    private native boolean nativeInit(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2);

    private native boolean nativeInitCustomStyle(long j, String str, String str2);

    private native int nativeInitLayerCallback(long j);

    private native long nativeInsertLayerAt(long j, int i, int i2, int i3, String str);

    private native boolean nativeIsAnimationRunning(long j);

    private native boolean nativeIsBaseIndoorMapMode(long j);

    private native boolean nativeIsNaviMode(long j);

    private native boolean nativeIsPointInFocusBarBorder(long j, double d, double d2, double d3);

    private native boolean nativeIsPointInFocusIDRBorder(long j, double d, double d2);

    private native boolean nativeIsStreetArrowShown(long j);

    private native boolean nativeIsStreetCustomMarkerShown(long j);

    private native boolean nativeIsStreetPOIMarkerShown(long j);

    private native boolean nativeIsStreetRoadClickable(long j);

    private native boolean nativeLayersIsShow(long j, long j2);

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

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeRemoveItemData(long j, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeRemoveLayer(long j, long j2);

    private native void nativeRemoveStreetAllCustomMarker(long j);

    private native void nativeRemoveStreetCustomMaker(long j, String str);

    private static native void nativeRenderClearShaderCache(String str);

    private static native void nativeRenderInit(long j, int i, int i2, Surface surface, int i3);

    private native void nativeRenderResize(long j, int i, int i2);

    private native void nativeResetImageRes(long j);

    private native boolean nativeResumeCache(long j);

    private native boolean nativeSaveCache(long j);

    private native void nativeSaveScreenToLocal(long j, String str, String str2);

    private native String nativeScrPtToGeoPoint(long j, int i, int i2);

    private native void nativeSetAllStreetCustomMarkerVisibility(long j, boolean z);

    private native void nativeSetCustomStyleEnable(long j, boolean z);

    private static native void nativeSetDEMEnable(long j, boolean z);

    private static native void nativeSetDrawHouseHeightEnable(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeSetFocus(long j, long j2, long j3, boolean z, Bundle bundle);

    private native boolean nativeSetItsPreTime(long j, int i, int i2, int i3);

    private native boolean nativeSetLayerSceneMode(long j, long j2, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetLayersClickable(long j, long j2, boolean z);

    private native void nativeSetLocationLayerData(long j, Bundle bundle);

    private native int nativeSetMapControlMode(long j, int i);

    private native boolean nativeSetMapScene(long j, int i);

    private native void nativeSetMapStatus(long j, Bundle bundle);

    private static native void nativeSetMapStatusLimits(long j, Bundle bundle);

    private native boolean nativeSetMapTheme(long j, int i, Bundle bundle);

    private native boolean nativeSetMapThemeScene(long j, int i, int i2, Bundle bundle);

    private static native void nativeSetMaxAndMinZoomLevel(long j, Bundle bundle);

    private native void nativeSetRecommendPOIScene(long j, int i);

    private native void nativeSetStreetArrowShow(long j, boolean z);

    private native void nativeSetStreetMarkerClickable(long j, String str, boolean z);

    private native void nativeSetStreetRoadClickable(long j, boolean z);

    private native void nativeSetStyleMode(long j, int i);

    private native void nativeSetTargetStreetCustomMarkerVisibility(long j, boolean z, String str);

    private native boolean nativeSetTestSwitch(long j, boolean z);

    private native void nativeSetTrafficUGCData(long j, String str);

    private native void nativeSetUniversalFilter(long j, String str);

    private native void nativeShowBaseIndoorMap(long j, boolean z);

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

    private native void nativeStartIndoorAnimation(long j);

    private native boolean nativeSwitchBaseIndoorMapFloor(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeSwitchLayer(long j, long j2, long j3);

    private native void nativeUnFocusTrafficUGCLabel(long j);

    private native void nativeUpdateDrawFPS(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeUpdateLayers(long j, long j2);

    private native String nativeworldPointToScreenPoint(long j, float f, float f2, float f3);

    public static void renderClearShaderCache(String str) {
        nativeRenderClearShaderCache(str);
    }

    public void addItemData(Bundle bundle) {
        if (b()) {
            this.f4723a.submit(new o(this, bundle));
        }
    }

    public long addLayer(int i, int i2, String str) {
        long nativeAddLayer = nativeAddLayer(this.f4724b, i, i2, str);
        boolean z = false;
        try {
            z = this.c.writeLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z) {
                this.d.remove(Long.valueOf(nativeAddLayer));
            }
            if (z) {
                this.c.writeLock().unlock();
            }
        } catch (Exception e) {
            if (z) {
                this.c.writeLock().unlock();
            }
        } catch (Throwable th) {
            if (z) {
                this.c.writeLock().unlock();
            }
            throw th;
        }
        return nativeAddLayer;
    }

    public void addOneOverlayItem(Bundle bundle) {
        if (b()) {
            this.f4723a.submit(new d(this, bundle));
        }
    }

    public void addOverlayItems(Bundle[] bundleArr, int i) {
        if (b()) {
            this.f4723a.submit(new e(this, bundleArr, i));
        }
    }

    public void addPopupData(Bundle bundle) {
        nativeAddPopupData(this.f4724b, bundle);
    }

    public void addRtPopData(Bundle bundle) {
        nativeAddRtPopData(this.f4724b, bundle);
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (this.f4724b != 0) {
            nativeAddStreetCustomMarker(this.f4724b, bundle, bitmap);
        }
    }

    public void beginLocationLayerAnimation() {
        nativeBeginLocationLayerAnimation(this.f4724b);
    }

    public boolean cleanCache(int i) {
        return nativeCleanCache(this.f4724b, i);
    }

    public void clearLayer(long j) {
        if (b()) {
            this.f4723a.submit(new m(this, j));
        }
    }

    public void clearLocationLayerData(Bundle bundle) {
        nativeClearLocationLayerData(this.f4724b, bundle);
    }

    public void clearMistmapLayer() {
        nativeClearMistmapLayer(this.f4724b);
    }

    public void clearSDKLayer(long j) {
        if (b()) {
            this.f4723a.submit(new l(this, j));
        }
    }

    public void clearUniversalLayer() {
        nativeClearUniversalLayer(this.f4724b);
    }

    public boolean closeCache() {
        return nativeCloseCache(this.f4724b);
    }

    public void closeParticleEffect(String str) {
        nativeCloseParticleEffect(this.f4724b, str);
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.f4724b = nativeCreate();
        nativeInitLayerCallback(this.f4724b);
        return this.f4724b;
    }

    public long createByDuplicate(long j) {
        this.f4724b = nativeCreateDuplicate(j);
        if (this.f4724b != 0) {
            nativeInitLayerCallback(this.f4724b);
        }
        return this.f4724b;
    }

    public long createDuplicate() {
        return nativeCreateDuplicate(this.f4724b);
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.f4724b != 0) {
            a();
            int nativeRelease = nativeRelease(this.f4724b);
            this.f4724b = 0L;
            return nativeRelease;
        }
        return 0;
    }

    public int draw() {
        if (this.f4724b != 0) {
            return nativeDraw(this.f4724b);
        }
        return 0;
    }

    public void enablePOIAnimation(boolean z) {
        if (this.f4724b != 0) {
            nativeEnablePOIAnimation(this.f4724b, z);
        }
    }

    public void entrySearchTopic(int i) {
        if (this.f4724b != 0) {
            nativeEntrySearchTopic(this.f4724b, i);
        }
    }

    public void exitSearchTopic() {
        if (this.f4724b != 0) {
            nativeExitSearchTopic(this.f4724b);
        }
    }

    public void focusTrafficUGCLabel() {
        nativeFocusTrafficUGCLabel(this.f4724b);
    }

    public String geoPtToScrPoint(int i, int i2) {
        return nativeGeoPtToScrPoint(this.f4724b, i, i2);
    }

    public float getAdapterZoomUnitsEx() {
        return nativeGetAdapterZoomUnitsEx(this.f4724b);
    }

    public int getCacheSize(int i) {
        return nativeGetCacheSize(this.f4724b, i);
    }

    public String getCityInfoByID(int i) {
        return nativeGetCityInfoByID(this.f4724b, i);
    }

    public boolean getDEMEnable() {
        if (this.f4724b != 0) {
            nativeGetDEMEnable(this.f4724b);
            return false;
        }
        return false;
    }

    public boolean getDrawHouseHeightEnable() {
        if (this.f4724b != 0) {
            return nativeGetDrawHouseHeightEnable(this.f4724b);
        }
        return false;
    }

    public Bundle getDrawingMapStatus() {
        return nativeGetDrawingMapStatus(this.f4724b);
    }

    public float getFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        return nativeGetFZoomToBoundF(this.f4724b, bundle, bundle2);
    }

    public String getFocusedBaseIndoorMapInfo() {
        if (this.f4724b != 0) {
            return nativeGetFocusedBaseIndoorMapInfo(this.f4724b);
        }
        return null;
    }

    public long getLayerIDByTag(String str) {
        if (this.f4724b != 0) {
            return nativeGetLayerIDByTag(this.f4724b, str);
        }
        return 0L;
    }

    public boolean getMapBarData(Bundle bundle) {
        return nativeGetMapBarData(this.f4724b, bundle);
    }

    public int getMapRenderType() {
        return nativeGetMapRenderType(this.f4724b);
    }

    public int getMapScene() {
        return nativeGetMapScene(this.f4724b);
    }

    public Bundle getMapStatus(boolean z) {
        return nativeGetMapStatus(this.f4724b, z);
    }

    public Bundle getMapStatusLimits() {
        if (this.f4724b != 0) {
            return nativeGetMapStatusLimits(this.f4724b);
        }
        return null;
    }

    public int getMapTheme() {
        return nativeGetMapTheme(this.f4724b);
    }

    public long getNativeMapPointer() {
        return this.f4724b;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x0070
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public java.lang.String getNearlyObjID(long r12, int r14, int r15, int r16) {
        /*
            r11 = this;
            r0 = 0
            java.util.concurrent.locks.ReadWriteLock r1 = r11.c     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L5e
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L5e
            r2 = 2000(0x7d0, double:9.88E-321)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L5e
            boolean r9 = r1.tryLock(r2, r4)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L5e
            if (r9 == 0) goto L3e
            boolean r0 = r11.a(r12)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L74
            if (r0 == 0) goto L26
            java.lang.String r0 = ""
            if (r9 == 0) goto L25
            java.util.concurrent.locks.ReadWriteLock r1 = r11.c
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
        L25:
            return r0
        L26:
            long r2 = r11.f4724b     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L74
            r1 = r11
            r4 = r12
            r6 = r14
            r7 = r15
            r8 = r16
            java.lang.String r0 = r1.nativeGetNearlyObjID(r2, r4, r6, r7, r8)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L74
            if (r9 == 0) goto L25
            java.util.concurrent.locks.ReadWriteLock r1 = r11.c
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            goto L25
        L3e:
            java.lang.String r0 = ""
            if (r9 == 0) goto L25
            java.util.concurrent.locks.ReadWriteLock r1 = r11.c
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            goto L25
        L4d:
            r1 = move-exception
            r1 = r0
        L4f:
            java.lang.String r0 = ""
            if (r1 == 0) goto L25
            java.util.concurrent.locks.ReadWriteLock r1 = r11.c
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            goto L25
        L5e:
            r1 = move-exception
            r2 = r1
            r9 = r0
        L61:
            if (r9 == 0) goto L6c
            java.util.concurrent.locks.ReadWriteLock r0 = r11.c
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
        L6c:
            throw r2
        L6d:
            r0 = move-exception
            r2 = r0
            goto L61
        L70:
            r0 = move-exception
            r2 = r0
            r9 = r1
            goto L61
        L74:
            r0 = move-exception
            r1 = r9
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.getNearlyObjID(long, int, int, int):java.lang.String");
    }

    public void getProjectMatrix(float[] fArr) {
        if (this.f4724b != 0) {
            nativeGetProjectionMatrix(this.f4724b, fArr);
        }
    }

    public String getProjectionPt(String str) {
        return nativeGetProjectionPt(this.f4724b, str);
    }

    public int getScaleLevel(int i, int i2) {
        if (this.f4724b != 0) {
            return nativeGetScaleLevel(this.f4724b, i, i2);
        }
        return -1;
    }

    public int getVMPMapCityInfo(Bundle bundle) {
        return nativeGetVMPMapCityInfo(this.f4724b, bundle);
    }

    public void getViewMatrix(float[] fArr) {
        if (this.f4724b != 0) {
            nativeGetViewMatrix(this.f4724b, fArr);
        }
    }

    public float getZoomToBound(long j, Bundle bundle, int i, int i2) {
        return nativeGetZoomToBound(j, bundle, i, i2);
    }

    public float getZoomToBound(Bundle bundle, int i, int i2) {
        return nativeGetZoomToBound(this.f4724b, bundle, i, i2);
    }

    public float getZoomToBoundF(Bundle bundle) {
        return nativeGetZoomToBoundF(this.f4724b, bundle);
    }

    public boolean importMapTheme(int i) {
        return nativeImportMapTheme(this.f4724b, i);
    }

    public boolean init(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        return this.f4724b != 0 && nativeInit(this.f4724b, str, str2, str3, str4, str5, str6, str7, i, i2, i3, i4, i5, i6, i7, z, z2);
    }

    public boolean initCustomStyle(String str, String str2) {
        if (this.f4724b != 0) {
            return nativeInitCustomStyle(this.f4724b, str, str2);
        }
        return false;
    }

    public boolean isAnimationRunning() {
        return nativeIsAnimationRunning(this.f4724b);
    }

    public boolean isBaseIndoorMapMode() {
        return this.f4724b != 0 && nativeIsBaseIndoorMapMode(this.f4724b);
    }

    public boolean isNaviMode() {
        return nativeIsNaviMode(this.f4724b);
    }

    public boolean isPointInFocusBarBorder(double d, double d2, double d3) {
        return this.f4724b != 0 && nativeIsPointInFocusBarBorder(this.f4724b, d, d2, d3);
    }

    public boolean isPointInFocusIDRBorder(double d, double d2) {
        return this.f4724b != 0 && nativeIsPointInFocusIDRBorder(this.f4724b, d, d2);
    }

    public boolean isStreetArrowShown() {
        return nativeIsStreetArrowShown(this.f4724b);
    }

    public boolean isStreetCustomMarkerShown() {
        return nativeIsStreetCustomMarkerShown(this.f4724b);
    }

    public boolean isStreetPOIMarkerShown() {
        return this.f4724b != 0 && nativeIsStreetPOIMarkerShown(this.f4724b);
    }

    public boolean isStreetRoadClickable() {
        return nativeIsStreetRoadClickable(this.f4724b);
    }

    public boolean layersIsShow(long j) {
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3 = false;
        try {
            z2 = this.c.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (z2) {
                try {
                    if (!a(j)) {
                        z3 = nativeLayersIsShow(this.f4724b, j);
                        if (z2) {
                            this.c.readLock().unlock();
                        }
                    } else if (z2) {
                        this.c.readLock().unlock();
                    }
                } catch (Exception e) {
                    if (z2) {
                        this.c.readLock().unlock();
                    }
                    return z3;
                } catch (Throwable th2) {
                    th = th2;
                    z = z2;
                    if (z) {
                        this.c.readLock().unlock();
                    }
                    throw th;
                }
            } else if (z2) {
                this.c.readLock().unlock();
            }
        } catch (Exception e2) {
            z2 = false;
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
        return z3;
    }

    public void moveToScrPoint(int i, int i2) {
        nativeMoveToScrPoint(this.f4724b, i, i2);
    }

    public native void nativeAddOneOverlayItem(long j, Bundle bundle);

    public native void nativeAddOverlayItems(long j, Bundle[] bundleArr, int i);

    public native boolean nativeAddTileOverlay(long j, Bundle bundle);

    public native boolean nativeCleanSDKTileDataCache(long j, long j2);

    public native void nativeRemoveOneOverlayItem(long j, Bundle bundle);

    public native void nativeUpdateOneOverlayItem(long j, Bundle bundle);

    public native boolean nativeUpdateSDKTile(long j, Bundle bundle);

    public void onBackground() {
        if (this.f4724b != 0) {
            nativeOnBackground(this.f4724b);
        }
    }

    public void onForeground() {
        if (this.f4724b != 0) {
            nativeOnForeground(this.f4724b);
        }
    }

    public String onHotcityGet() {
        return nativeOnHotcityGet(this.f4724b);
    }

    public void onPause() {
        if (this.f4724b != 0) {
            nativeOnPause(this.f4724b);
        }
    }

    public boolean onRecordAdd(int i) {
        return nativeOnRecordAdd(this.f4724b, i);
    }

    public String onRecordGetAll() {
        return nativeOnRecordGetAll(this.f4724b);
    }

    public String onRecordGetAt(int i) {
        return nativeOnRecordGetAt(this.f4724b, i);
    }

    public boolean onRecordImport(boolean z, boolean z2) {
        return nativeOnRecordImport(this.f4724b, z, z2);
    }

    public boolean onRecordReload(int i, boolean z) {
        return nativeOnRecordReload(this.f4724b, i, z);
    }

    public boolean onRecordRemove(int i, boolean z) {
        return nativeOnRecordRemove(this.f4724b, i, z);
    }

    public boolean onRecordStart(int i, boolean z, int i2) {
        return nativeOnRecordStart(this.f4724b, i, z, i2);
    }

    public boolean onRecordSuspend(int i, boolean z, int i2) {
        return nativeOnRecordSuspend(this.f4724b, i, z, i2);
    }

    public void onResume() {
        if (this.f4724b != 0) {
            nativeOnResume(this.f4724b);
        }
    }

    public String onSchcityGet(String str) {
        return nativeOnSchcityGet(this.f4724b, str);
    }

    public boolean onUsrcityMsgInterval(int i) {
        return nativeOnUsrcityMsgInterval(this.f4724b, i);
    }

    public int onWifiRecordAdd(int i) {
        return nativeOnWifiRecordAdd(this.f4724b, i);
    }

    public boolean performAction(String str) {
        return nativePerformAction(this.f4724b, str);
    }

    public void recycleMemory(int i) {
        if (this.f4724b != 0) {
            nativeRecycleMemory(this.f4724b, i);
        }
    }

    public boolean removeItemData(Bundle bundle) {
        if (b()) {
            this.f4723a.submit(new c(this, bundle));
            return true;
        }
        return false;
    }

    public void removeLayer(long j) {
        if (b()) {
            this.f4723a.submit(new j(this, j));
        }
    }

    public void removeOneOverlayItem(Bundle bundle) {
        if (b()) {
            this.f4723a.submit(new g(this, bundle));
        }
    }

    public void removeStreetAllCustomMarker() {
        nativeRemoveStreetAllCustomMarker(this.f4724b);
    }

    public void removeStreetCustomMaker(String str) {
        nativeRemoveStreetCustomMaker(this.f4724b, str);
    }

    @Deprecated
    public void renderDone() {
    }

    public void renderInit(int i, int i2, Surface surface, int i3) {
        if (this.f4724b != 0) {
            nativeRenderInit(this.f4724b, i, i2, surface, i3);
        }
    }

    @Deprecated
    public int renderRender() {
        if (this.f4724b != 0) {
            return nativeDraw(this.f4724b);
        }
        return 0;
    }

    public void renderResize(int i, int i2) {
        if (this.f4724b != 0) {
            nativeRenderResize(this.f4724b, i, i2);
        }
    }

    public void resetImageRes() {
        if (this.f4724b != 0) {
            nativeResetImageRes(this.f4724b);
        }
    }

    public boolean resumeCache() {
        return nativeResumeCache(this.f4724b);
    }

    public boolean saveCache() {
        try {
            return nativeSaveCache(this.f4724b);
        } catch (Throwable th) {
            return false;
        }
    }

    public void saveScreenToLocal(String str, String str2) {
        nativeSaveScreenToLocal(this.f4724b, str, str2);
    }

    public String scrPtToGeoPoint(int i, int i2) {
        return nativeScrPtToGeoPoint(this.f4724b, i, i2);
    }

    public void setAllStreetCustomMarkerVisibility(boolean z) {
        if (this.f4724b != 0) {
            nativeSetAllStreetCustomMarkerVisibility(this.f4724b, z);
        }
    }

    public void setCallback(ac acVar) {
        BaseMapCallback.setMapCallback(this.f4724b, acVar);
    }

    public void setCustomStyleEnable(boolean z) {
        if (this.f4724b != 0) {
            nativeSetCustomStyleEnable(this.f4724b, z);
        }
    }

    public void setDEMEnable(boolean z) {
        if (this.f4724b != 0) {
            nativeSetDEMEnable(this.f4724b, z);
        }
    }

    public void setDrawHouseHeightEnable(boolean z) {
        if (this.f4724b != 0) {
            nativeSetDrawHouseHeightEnable(this.f4724b, z);
        }
    }

    public void setFocus(long j, long j2, boolean z, Bundle bundle) {
        if (b()) {
            this.f4723a.submit(new n(this, j, j2, z, bundle));
        }
    }

    public boolean setItsPreTime(int i, int i2, int i3) {
        return nativeSetItsPreTime(this.f4724b, i, i2, i3);
    }

    public boolean setLayerSceneMode(long j, int i) {
        return nativeSetLayerSceneMode(this.f4724b, j, i);
    }

    public void setLayersClickable(long j, boolean z) {
        if (b()) {
            this.f4723a.submit(new h(this, j, z));
        }
    }

    public void setLocationLayerData(Bundle bundle) {
        nativeSetLocationLayerData(this.f4724b, bundle);
    }

    public int setMapControlMode(int i) {
        return nativeSetMapControlMode(this.f4724b, i);
    }

    public void setMapScene(int i) {
        nativeSetMapScene(this.f4724b, i);
    }

    public void setMapStatus(Bundle bundle) {
        nativeSetMapStatus(this.f4724b, bundle);
    }

    public void setMapStatusLimits(Bundle bundle) {
        if (this.f4724b != 0) {
            nativeSetMapStatusLimits(this.f4724b, bundle);
        }
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        return nativeSetMapTheme(this.f4724b, i, bundle);
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        return nativeSetMapThemeScene(this.f4724b, i, i2, bundle);
    }

    public void setMaxAndMinZoomLevel(Bundle bundle) {
        if (this.f4724b != 0) {
            nativeSetMaxAndMinZoomLevel(this.f4724b, bundle);
        }
    }

    public void setNewMapStatus(Bundle bundle) {
        nativeNewSetMapStatus(this.f4724b, bundle);
    }

    public void setRecommendPOIScene(int i) {
        nativeSetRecommendPOIScene(this.f4724b, i);
    }

    public void setStreetArrowShow(boolean z) {
        nativeSetStreetArrowShow(this.f4724b, z);
    }

    public void setStreetMarkerClickable(String str, boolean z) {
        nativeSetStreetMarkerClickable(this.f4724b, str, z);
    }

    public void setStreetRoadClickable(boolean z) {
        nativeSetStreetRoadClickable(this.f4724b, z);
    }

    public void setStyleMode(int i) {
        nativeSetStyleMode(this.f4724b, i);
    }

    public void setTargetStreetCustomMarkerVisibility(boolean z, String str) {
        if (this.f4724b != 0) {
            nativeSetTargetStreetCustomMarkerVisibility(this.f4724b, z, str);
        }
    }

    public boolean setTestSwitch(boolean z) {
        return nativeSetTestSwitch(this.f4724b, z);
    }

    public void setTrafficUGCData(String str) {
        nativeSetTrafficUGCData(this.f4724b, str);
    }

    public void setUniversalFilter(String str) {
        nativeSetUniversalFilter(this.f4724b, str);
    }

    public void showBaseIndoorMap(boolean z) {
        nativeShowBaseIndoorMap(this.f4724b, z);
    }

    public void showHotMap(boolean z, int i) {
        nativeShowHotMap(this.f4724b, z, i);
    }

    public void showHotMap(boolean z, int i, String str) {
        nativeShowHotMapWithUid(this.f4724b, z, i, str);
    }

    public void showLayers(long j, boolean z) {
        if (b()) {
            this.f4723a.submit(new b(this, j, z));
        }
    }

    public void showMistMap(boolean z, String str) {
        nativeShowMistMap(this.f4724b, z, str);
    }

    public boolean showParticleEffect(int i) {
        return nativeShowParticleEffect(this.f4724b, i);
    }

    public boolean showParticleEffectByName(String str, boolean z) {
        return nativeShowParticleEffectByName(this.f4724b, str, z);
    }

    public boolean showParticleEffectByType(int i) {
        return nativeShowParticleEffectByType(this.f4724b, i);
    }

    public void showSatelliteMap(boolean z) {
        nativeShowSatelliteMap(this.f4724b, z);
    }

    public void showStreetPOIMarker(boolean z) {
        if (this.f4724b != 0) {
            nativeShowStreetPOIMarker(this.f4724b, z);
        }
    }

    public void showStreetRoadMap(boolean z) {
        nativeShowStreetRoadMap(this.f4724b, z);
    }

    public void showTrafficMap(boolean z) {
        nativeShowTrafficMap(this.f4724b, z);
    }

    public void showTrafficUGCMap(boolean z) {
        nativeShowTrafficUGCMap(this.f4724b, z);
    }

    public void showUniversalLayer(Bundle bundle) {
        nativeShowUniversalLayer(this.f4724b, bundle);
    }

    public void startIndoorAnimation() {
        nativeStartIndoorAnimation(this.f4724b);
    }

    public boolean switchBaseIndoorMapFloor(String str, String str2) {
        return nativeSwitchBaseIndoorMapFloor(this.f4724b, str, str2);
    }

    public boolean switchLayer(long j, long j2) {
        if (b()) {
            this.f4723a.submit(new k(this, j, j2));
            return true;
        }
        return false;
    }

    public void unFocusTrafficUGCLabel() {
        nativeUnFocusTrafficUGCLabel(this.f4724b);
    }

    public void updateDrawFPS() {
        if (this.f4724b != 0) {
            nativeUpdateDrawFPS(this.f4724b);
        }
    }

    public void updateLayers(long j) {
        if (b()) {
            this.f4723a.submit(new i(this, j));
        }
    }

    public void updateOneOverlayItem(Bundle bundle) {
        if (b()) {
            this.f4723a.submit(new f(this, bundle));
        }
    }

    public String worldPointToScreenPoint(float f, float f2, float f3) {
        return nativeworldPointToScreenPoint(this.f4724b, f, f2, f3);
    }
}
