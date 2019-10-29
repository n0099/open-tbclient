package com.baidu.swan.impl.map.location.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
    private WeakReference<d> bIH;
    private String bII;
    private String bIJ;

    public static b ZY() {
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
        this.bII = gVar.aUv;
        if (DEBUG) {
            Log.e("WalkNavigationAction", "mGuideDownloadKey = " + this.bII);
        }
        this.bIJ = gVar.aUw;
        if (DEBUG) {
            Log.e("WalkNavigationAction", "mGuideIconPath = " + this.bIJ);
        }
        if (com.baidu.swan.apps.storage.b.im(this.bIJ) == PathType.BD_FILE) {
            this.bIJ = com.baidu.swan.apps.storage.b.aL(this.bIJ, com.baidu.swan.apps.ae.b.Rk());
        }
        if (!SwanAppNetworkUtils.isNetworkConnected(context)) {
            c.w("map", "no network");
            bVar.f(str, 1003, "no network");
            return false;
        }
        this.bIH = new WeakReference<>(e.LD().Fr());
        com.baidu.swan.impl.map.a.b.d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.location.a.b.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                c.w("map", "location permission success");
                b.this.a(context, gVar, bVar, bVar2, str);
            }

            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onFail() {
                c.w("map", "location permission fail");
                bVar2.Rd().c("mapp_location", new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.impl.map.location.a.b.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: c */
                    public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                        if (eVar != null && (eVar.forbidden || !eVar.So())) {
                            bVar.f(str, 1009, "location is not authorized");
                        } else {
                            bVar.f(str, 1010, "no location permission");
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
        bVar2.Rd().a((Activity) context, "mapp_camera", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.impl.map.location.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void B(Boolean bool) {
                if (bool.booleanValue()) {
                    b.this.a(context, bVar, (g) cVar);
                    return;
                }
                c.w("map", "camera permission fail");
                bVar.f(str, 1011, "camera is not authorized");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.apps.x.b bVar, final g gVar) {
        c.i("map", "handleAuthorized camera start");
        if (com.baidu.swan.apps.camera.a.CD().aO(context)) {
            c.e("map", "has camera authorize");
            a(context, gVar, bVar);
            return;
        }
        e.LD().a(1, new String[]{"android.permission.CAMERA"}, new a.InterfaceC0152a() { // from class: com.baidu.swan.impl.map.location.a.b.3
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0152a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    bVar.f(gVar.callBack, 1001, "no camera permission");
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
                    bVar.f(gVar.callBack, 1012, "no camera permission");
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
        com.baidu.swan.apps.u.a.JB().a(CoordinateType.GCJ02, true, true, new n.a() { // from class: com.baidu.swan.impl.map.location.a.b.4
            @Override // com.baidu.swan.apps.u.b.n.a
            public void a(com.baidu.swan.apps.scheme.actions.e.b bVar2) {
                c.i("map", "get location ok ");
                b.this.a(com.baidu.swan.apps.ae.b.QZ().getActivity(), new LatLng(bVar2.latitude, bVar2.longitude), bVar, gVar);
            }

            @Override // com.baidu.swan.apps.u.b.n.a
            public void dy(int i) {
                c.i("map", "get location error " + i);
                bVar.f(gVar.callBack, 1007, "get location fail");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, LatLng latLng, final com.baidu.swan.apps.x.b bVar, final g gVar) {
        com.baidu.swan.impl.map.location.b.b.a(activity, latLng, new LatLng(gVar.aUu.latitude, gVar.aUu.longitude), new b.a() { // from class: com.baidu.swan.impl.map.location.a.b.5
            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void ZZ() {
                c.i("map", "walk navigation onPrepareStart ");
                SDKInitializer.setCoordType(CoordType.BD09LL);
            }

            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void aaa() {
                Bundle bundle;
                c.i("map", "walk navigation onPrepareSuccess ");
                com.baidu.swan.apps.core.d.d Fr = e.LD().Fr();
                if (b.this.bIH == null || Fr != b.this.bIH.get()) {
                    bVar.f(gVar.callBack, 1001, "open navigation canceled on another page");
                    return;
                }
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (TextUtils.isEmpty(b.this.bII) && TextUtils.isEmpty(b.this.bIJ)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("guideKey", b.this.bII);
                    bundle.putString("guideIcon", b.this.bIJ);
                }
                com.baidu.swan.impl.map.location.b.a.D(bundle).ZD();
                bVar.e(gVar.callBack, null);
            }

            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void kP(String str) {
                c.i("map", "walk navigation onPrepareFailed ");
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (str.contains("the distance is less than 30 meters")) {
                    bVar.f(gVar.callBack, 1005, "the distance is less than 30 meters");
                } else if (str.contains("the distance is longer than 50 kilometers")) {
                    bVar.f(gVar.callBack, 1006, "the distance is longer than 50 kilometers");
                } else {
                    bVar.f(gVar.callBack, 1004, "prepare route error");
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
