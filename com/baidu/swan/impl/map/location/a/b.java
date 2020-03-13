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
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.w.b.f;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.apps.z.a.g;
import com.baidu.swan.impl.map.a.b.d;
import com.baidu.swan.impl.map.location.b.b;
import com.baidu.webkit.sdk.PermissionRequest;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class b extends com.baidu.swan.impl.map.a.a<g> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<d> cxv;
    private String cxw;
    private String cxx;

    public static b aso() {
        return new b();
    }

    private boolean b(final Context context, final g gVar, final com.baidu.swan.apps.z.b bVar, final e eVar) {
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
        this.cxw = gVar.bAj;
        if (DEBUG) {
            Log.e("WalkNavigationAction", "mGuideDownloadKey = " + this.cxw);
        }
        this.cxx = gVar.bAk;
        if (DEBUG) {
            Log.e("WalkNavigationAction", "mGuideIconPath = " + this.cxx);
        }
        if (com.baidu.swan.apps.storage.b.ma(this.cxx) == PathType.BD_FILE) {
            this.cxx = com.baidu.swan.apps.storage.b.bp(this.cxx, e.acH());
        }
        if (!SwanAppNetworkUtils.isNetworkConnected(context)) {
            c.w("map", "no network");
            bVar.g(str, 1003, "no network");
            return false;
        }
        this.cxv = new WeakReference<>(f.WS().Oo());
        com.baidu.swan.impl.map.a.b.d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.location.a.b.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                c.w("map", "location permission success");
                b.this.a(context, gVar, bVar, eVar, str);
            }

            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onFail() {
                c.w("map", "location permission fail");
                eVar.acP().d("mapp_location", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.impl.map.location.a.b.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: c */
                    public void D(com.baidu.swan.apps.setting.oauth.e eVar2) {
                        if (eVar2 != null && (eVar2.forbidden || !eVar2.aeo())) {
                            bVar.g(str, 1009, "location is not authorized");
                        } else {
                            bVar.g(str, 1010, "no location permission");
                        }
                    }
                });
            }
        });
        c.i("map", "WalkNavigationAction end");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.apps.z.a.c cVar, final com.baidu.swan.apps.z.b bVar, e eVar, final String str) {
        eVar.acP().b((Activity) context, PermissionProxy.SCOPE_ID_CAMERA, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.impl.map.location.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    b.this.a(context, bVar, (g) cVar);
                    return;
                }
                c.w("map", "camera permission fail");
                bVar.g(str, 1011, "camera is not authorized");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.apps.z.b bVar, final g gVar) {
        c.i("map", "handleAuthorized camera start");
        if (com.baidu.swan.apps.camera.a.Kg().bH(context)) {
            c.e("map", "has camera authorize");
            a(context, gVar, bVar);
            return;
        }
        f.WS().a(1, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new c.a() { // from class: com.baidu.swan.impl.map.location.a.b.3
            @Override // com.baidu.swan.apps.af.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    bVar.g(gVar.callBack, 1001, "no camera permission");
                    com.baidu.swan.apps.console.c.e("map", "handleAuthorized camera end, failure");
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
                    bVar.g(gVar.callBack, 1012, "no camera permission");
                    com.baidu.swan.apps.console.c.e("map", "handleAuthorized camera end, failure");
                    return;
                }
                com.baidu.swan.apps.console.c.e("map", "has camera authorize");
                b.this.a(context, gVar, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final g gVar, final com.baidu.swan.apps.z.b bVar) {
        com.baidu.swan.apps.w.a.Up().a("gcj02", true, true, new f.a() { // from class: com.baidu.swan.impl.map.location.a.b.4
            @Override // com.baidu.swan.apps.w.b.f.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar2) {
                com.baidu.swan.apps.console.c.i("map", "get location ok ");
                b.this.a(e.acF().getActivity(), new LatLng(bVar2.latitude, bVar2.longitude), bVar, gVar);
            }

            @Override // com.baidu.swan.apps.w.b.f.a
            public void onFailed(int i) {
                com.baidu.swan.apps.console.c.i("map", "get location error " + i);
                bVar.g(gVar.callBack, 1007, "get location fail");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, LatLng latLng, final com.baidu.swan.apps.z.b bVar, final g gVar) {
        com.baidu.swan.impl.map.location.b.b.a(activity, latLng, new LatLng(gVar.bAi.latitude, gVar.bAi.longitude), new b.a() { // from class: com.baidu.swan.impl.map.location.a.b.5
            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void asp() {
                com.baidu.swan.apps.console.c.i("map", "walk navigation onPrepareStart ");
                SDKInitializer.setCoordType(CoordType.BD09LL);
            }

            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void asq() {
                Bundle bundle;
                com.baidu.swan.apps.console.c.i("map", "walk navigation onPrepareSuccess ");
                com.baidu.swan.apps.core.d.d Oo = com.baidu.swan.apps.y.f.WS().Oo();
                if (b.this.cxv == null || Oo != b.this.cxv.get()) {
                    bVar.g(gVar.callBack, 1001, "open navigation canceled on another page");
                    return;
                }
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (TextUtils.isEmpty(b.this.cxw) && TextUtils.isEmpty(b.this.cxx)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("guideKey", b.this.cxw);
                    bundle.putString("guideIcon", b.this.cxx);
                }
                com.baidu.swan.impl.map.location.b.a.W(bundle).arS();
                bVar.c(gVar.callBack, null);
            }

            @Override // com.baidu.swan.impl.map.location.b.b.a
            public void qc(String str) {
                com.baidu.swan.apps.console.c.i("map", "walk navigation onPrepareFailed ");
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (str.contains("the distance is less than 30 meters")) {
                    bVar.g(gVar.callBack, 1005, "the distance is less than 30 meters");
                } else if (str.contains("the distance is longer than 50 kilometers")) {
                    bVar.g(gVar.callBack, 1006, "the distance is longer than 50 kilometers");
                } else {
                    bVar.g(gVar.callBack, 1004, "prepare route error");
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, g gVar, com.baidu.swan.apps.z.b bVar, e eVar, JSONObject jSONObject) {
        return b(context, gVar, bVar, eVar);
    }
}
