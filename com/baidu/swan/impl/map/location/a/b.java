package com.baidu.swan.impl.map.location.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.u.b.n;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.apps.x.a.g;
import com.baidu.swan.impl.map.a.b.d;
import com.baidu.swan.impl.map.location.b.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends com.baidu.swan.impl.map.a.a<g> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<d> bpx;
    private String bpy;
    private String bpz;

    public static b Vf() {
        return new b();
    }

    private boolean b(final Context context, final g gVar, final com.baidu.swan.apps.x.b bVar, final com.baidu.swan.apps.ae.b bVar2) {
        c.i("map", "WalkNavigationAction start");
        if (!gVar.isValid()) {
            c.e("map", "model is invalid");
            return false;
        }
        final String str = gVar.callBack;
        if (TextUtils.isEmpty(str)) {
            c.e("map", "cb is empty");
            return false;
        }
        this.bpy = gVar.aAJ;
        if (DEBUG) {
            Log.e("WalkNavigationAction", "mGuideDownloadKey = " + this.bpy);
        }
        this.bpz = gVar.aAK;
        if (DEBUG) {
            Log.e("WalkNavigationAction", "mGuideIconPath = " + this.bpz);
        }
        if (com.baidu.swan.apps.storage.b.hG(this.bpz) == PathType.BD_FILE) {
            this.bpz = com.baidu.swan.apps.storage.b.aE(this.bpz, com.baidu.swan.apps.ae.b.Mo());
        }
        if (!SwanAppNetworkUtils.isNetworkConnected(context)) {
            c.w("map", "no network");
            bVar.d(str, 1003, "no network");
            return false;
        }
        this.bpx = new WeakReference<>(e.GF().As());
        com.baidu.swan.impl.map.a.b.d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.location.a.b.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                c.w("map", "location permission success");
                b.this.a(context, gVar, bVar, bVar2, str);
            }

            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onFail() {
                c.w("map", "location permission fail");
                bVar2.Mh().c("mapp_location", new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.impl.map.location.a.b.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: c */
                    public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                        if (eVar != null && (eVar.forbidden || !eVar.Nu())) {
                            bVar.d(str, PointerIconCompat.TYPE_VERTICAL_TEXT, "location is not authorized");
                        } else {
                            bVar.d(str, 1010, "no location permission");
                        }
                    }
                });
            }
        });
        c.i("map", "WalkNavigationAction end");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.apps.x.a.c cVar, final com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, final String str) {
        bVar2.Mh().a((Activity) context, "mapp_camera", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.impl.map.location.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void D(Boolean bool) {
                if (bool.booleanValue()) {
                    b.this.a(context, bVar, (g) cVar);
                    return;
                }
                c.w("map", "camera permission fail");
                bVar.d(str, 1011, "camera is not authorized");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.apps.x.b bVar, final g gVar) {
        c.i("map", "handleAuthorized camera start");
        if (com.baidu.swan.apps.camera.a.xF().aM(context)) {
            c.e("map", "has camera authorize");
            a(context, gVar, bVar);
            return;
        }
        e.GF().a(1, new String[]{"android.permission.CAMERA"}, new a.InterfaceC0111a() { // from class: com.baidu.swan.impl.map.location.a.b.3
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0111a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    bVar.d(gVar.callBack, 1001, "no camera permission");
                    c.e("map", "handleAuthorized camera end, failure");
                    return;
                }
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (iArr[i2] == -1) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    bVar.d(gVar.callBack, 1012, "no camera permission");
                    c.e("map", "handleAuthorized camera end, failure");
                    return;
                }
                c.e("map", "has camera authorize");
                b.this.a(context, gVar, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final g gVar, final com.baidu.swan.apps.x.b bVar) {
        com.baidu.swan.apps.u.a.ED().a(CoordinateType.GCJ02, true, true, new n.a() { // from class: com.baidu.swan.impl.map.location.a.b.4
            @Override // com.baidu.swan.apps.u.b.n.a
            public void a(com.baidu.swan.apps.scheme.actions.e.b bVar2) {
                c.i("map", "get location ok ");
                b.this.a(com.baidu.swan.apps.ae.b.Md().getActivity(), new LatLng(bVar2.latitude, bVar2.longitude), bVar, gVar);
            }

            @Override // com.baidu.swan.apps.u.b.n.a
            public void cC(int i) {
                c.i("map", "get location error " + i);
                bVar.d(gVar.callBack, PointerIconCompat.TYPE_CROSSHAIR, "get location fail");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, LatLng latLng, final com.baidu.swan.apps.x.b bVar, final g gVar) {
        com.baidu.swan.impl.map.location.b.b.a(activity, latLng, new LatLng(gVar.aAI.latitude, gVar.aAI.longitude), new b.a() { // from class: com.baidu.swan.impl.map.location.a.b.5
            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void Vg() {
                c.i("map", "walk navigation onPrepareStart ");
                SDKInitializer.setCoordType(CoordType.BD09LL);
            }

            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void Vh() {
                Bundle bundle;
                c.i("map", "walk navigation onPrepareSuccess ");
                com.baidu.swan.apps.core.d.d As = e.GF().As();
                if (b.this.bpx == null || As != b.this.bpx.get()) {
                    bVar.d(gVar.callBack, 1001, "open navigation canceled on another page");
                    return;
                }
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (TextUtils.isEmpty(b.this.bpy) && TextUtils.isEmpty(b.this.bpz)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("guideKey", b.this.bpy);
                    bundle.putString("guideIcon", b.this.bpz);
                }
                com.baidu.swan.impl.map.location.b.a.D(bundle).UK();
                bVar.e(gVar.callBack, null);
            }

            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void kl(String str) {
                c.i("map", "walk navigation onPrepareFailed ");
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (str.contains("the distance is less than 30 meters")) {
                    bVar.d(gVar.callBack, 1005, "the distance is less than 30 meters");
                } else if (str.contains("the distance is longer than 50 kilometers")) {
                    bVar.d(gVar.callBack, PointerIconCompat.TYPE_CELL, "the distance is longer than 50 kilometers");
                } else {
                    bVar.d(gVar.callBack, 1004, "prepare route error");
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, g gVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return b(context, gVar, bVar, bVar2);
    }
}
