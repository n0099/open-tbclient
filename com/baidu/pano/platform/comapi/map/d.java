package com.baidu.pano.platform.comapi.map;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.lbsapi.BMapManager;
import com.baidu.lbsapi.model.StatisticsEvent;
import com.baidu.lbsapi.panoramaview.PanoramaView;
import com.baidu.lbsapi.panoramaview.PanoramaViewListener;
import com.baidu.lbsapi.panoramaview.StatisticsCallback;
import com.baidu.lbsapi.tools.Point;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InnerPanoramaView f9485a;

    public d(InnerPanoramaView innerPanoramaView) {
        this.f9485a = innerPanoramaView;
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a() {
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a(boolean z) {
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        if (z) {
            return;
        }
        panoramaViewListener = this.f9485a.f9479e;
        if (panoramaViewListener != null) {
            String a2 = this.f9485a.a(101);
            panoramaViewListener2 = this.f9485a.f9479e;
            panoramaViewListener2.onLoadPanoramaError(a2);
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void b() {
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void b(boolean z) {
        PanoramaViewListener panoramaViewListener;
        String str;
        PanoramaViewListener panoramaViewListener2;
        String str2;
        String str3;
        com.baidu.pano.platform.comapi.a.b bVar;
        String str4;
        double d2;
        double d3;
        double d4;
        double d5;
        boolean z2;
        String str5;
        com.baidu.pano.platform.comapi.a.b bVar2;
        double d6;
        double d7;
        com.baidu.pano.platform.comapi.a.b bVar3;
        com.baidu.pano.platform.comapi.a.b bVar4;
        PanoramaViewListener panoramaViewListener3;
        boolean z3;
        com.baidu.pano.platform.comapi.a.b bVar5;
        com.baidu.pano.platform.comapi.a.b bVar6;
        com.baidu.pano.platform.comapi.a.b bVar7;
        com.baidu.pano.platform.comapi.a.b bVar8;
        com.baidu.pano.platform.comapi.a.b bVar9;
        com.baidu.pano.platform.comapi.a.b bVar10;
        com.baidu.pano.platform.comapi.a.b bVar11;
        PanoramaViewListener panoramaViewListener4;
        PanoramaViewListener panoramaViewListener5;
        PanoramaViewListener panoramaViewListener6;
        if (!z) {
            panoramaViewListener5 = this.f9485a.f9479e;
            if (panoramaViewListener5 != null) {
                String a2 = this.f9485a.a(103);
                panoramaViewListener6 = this.f9485a.f9479e;
                panoramaViewListener6.onLoadPanoramaError(a2);
            }
        } else {
            panoramaViewListener = this.f9485a.f9479e;
            if (panoramaViewListener != null) {
                str = this.f9485a.f9480f;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        str3 = this.f9485a.f9480f;
                        JSONObject jSONObject = new JSONObject(str3);
                        String optString = jSONObject.optString("Type");
                        this.f9485a.k = jSONObject.optString("ID");
                        int optInt = jSONObject.optInt("X");
                        int optInt2 = jSONObject.optInt("Y");
                        bVar = this.f9485a.f9481g;
                        if (bVar == null) {
                            str4 = this.f9485a.n;
                            if (str4 != null) {
                                d2 = this.f9485a.o;
                                if (d2 != 0.0d) {
                                    d3 = this.f9485a.p;
                                    if (d3 != 0.0d && "street".equals(optString)) {
                                        InnerPanoramaView innerPanoramaView = this.f9485a;
                                        d4 = this.f9485a.o;
                                        d5 = this.f9485a.p;
                                        String a3 = innerPanoramaView.a(d4, d5, optInt, optInt2);
                                        if (!TextUtils.isEmpty(a3)) {
                                            InnerPanoramaView innerPanoramaView2 = this.f9485a;
                                            Context context = BaseGLMapView.f9472b;
                                            z2 = this.f9485a.m;
                                            str5 = this.f9485a.n;
                                            innerPanoramaView2.f9481g = new com.baidu.pano.platform.comapi.a.b(context, z2, str5);
                                            bVar2 = this.f9485a.f9481g;
                                            d6 = this.f9485a.o;
                                            d7 = this.f9485a.p;
                                            bVar2.setMarkerPosition(new Point(d6, d7));
                                            bVar3 = this.f9485a.f9481g;
                                            bVar3.setMarkerHeight(2.0f);
                                            InnerPanoramaView innerPanoramaView3 = this.f9485a;
                                            bVar4 = this.f9485a.f9481g;
                                            innerPanoramaView3.a(bVar4);
                                            this.f9485a.d(a3);
                                        }
                                    }
                                }
                            }
                        } else {
                            z3 = this.f9485a.l;
                            if (!z3) {
                                InnerPanoramaView innerPanoramaView4 = this.f9485a;
                                bVar11 = this.f9485a.f9481g;
                                innerPanoramaView4.a(bVar11);
                                this.f9485a.l = true;
                            }
                            InnerPanoramaView innerPanoramaView5 = this.f9485a;
                            bVar5 = this.f9485a.f9481g;
                            double d8 = bVar5.mLongitude;
                            bVar6 = this.f9485a.f9481g;
                            String a4 = innerPanoramaView5.a(d8, bVar6.mLatitude, optInt, optInt2);
                            if (!TextUtils.isEmpty(a4) && "street".equals(optString)) {
                                this.f9485a.d(a4);
                            } else {
                                InnerPanoramaView innerPanoramaView6 = this.f9485a;
                                bVar7 = this.f9485a.f9481g;
                                innerPanoramaView6.m = bVar7.f9465b;
                                InnerPanoramaView innerPanoramaView7 = this.f9485a;
                                bVar8 = this.f9485a.f9481g;
                                innerPanoramaView7.n = bVar8.f9464a;
                                InnerPanoramaView innerPanoramaView8 = this.f9485a;
                                bVar9 = this.f9485a.f9481g;
                                innerPanoramaView8.o = bVar9.mLongitude;
                                InnerPanoramaView innerPanoramaView9 = this.f9485a;
                                bVar10 = this.f9485a.f9481g;
                                innerPanoramaView9.p = bVar10.mLatitude;
                                this.f9485a.f9481g = null;
                                this.f9485a.l = false;
                                this.f9485a.f();
                            }
                        }
                        panoramaViewListener3 = this.f9485a.f9479e;
                        panoramaViewListener3.onLoadPanoramaEnd(jSONObject.toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        panoramaViewListener2 = this.f9485a.f9479e;
                        str2 = this.f9485a.f9480f;
                        panoramaViewListener2.onLoadPanoramaEnd(str2);
                    }
                } else {
                    String a5 = this.f9485a.a(201);
                    panoramaViewListener4 = this.f9485a.f9479e;
                    panoramaViewListener4.onLoadPanoramaEnd(a5);
                }
            }
        }
        this.f9485a.s = true;
        if (BMapManager.isIllegalPanoSDKUser()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("text", "未认证key");
        bundle.putFloat("fontsize", 36.0f);
        bundle.putInt("fontcolor", -65536);
        bundle.putInt("bgcolor", -1);
        bundle.putLong("padding", 16L);
        this.f9485a.f9474a.c(bundle);
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void c() {
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        panoramaViewListener = this.f9485a.f9479e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.f9485a.f9479e;
            panoramaViewListener2.onLoadPanoramaBegin();
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void d() {
        PanoramaViewListener panoramaViewListener;
        panoramaViewListener = this.f9485a.f9479e;
        panoramaViewListener.onMoveStart();
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void e() {
        PanoramaViewListener panoramaViewListener;
        panoramaViewListener = this.f9485a.f9479e;
        panoramaViewListener.onMoveEnd();
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void f() {
        StatisticsCallback statisticsCallback;
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        String str;
        String str2;
        String str3;
        String str4;
        PanoramaView panoramaView;
        String str5;
        StatisticsCallback statisticsCallback2;
        statisticsCallback = this.f9485a.q;
        if (statisticsCallback != null) {
            statisticsCallback2 = this.f9485a.q;
            statisticsCallback2.onCallback(StatisticsEvent.ON_POI_MARKER_CLICK);
        }
        if (com.baidu.pano.platform.c.e.c(this.f9485a.getContext())) {
            str = this.f9485a.j;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            str2 = this.f9485a.k;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            str3 = this.f9485a.j;
            str4 = this.f9485a.k;
            if (str3.equals(str4)) {
                return;
            }
            panoramaView = this.f9485a.f9482h;
            str5 = this.f9485a.i;
            panoramaView.setPanoramaByUid(str5, 65538);
            return;
        }
        panoramaViewListener = this.f9485a.f9479e;
        if (panoramaViewListener != null) {
            String a2 = this.f9485a.a(102);
            panoramaViewListener2 = this.f9485a.f9479e;
            panoramaViewListener2.onLoadPanoramaError(a2);
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void g() {
        StatisticsCallback statisticsCallback;
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        PanoramaView panoramaView;
        String str;
        PanoramaView panoramaView2;
        String str2;
        StatisticsCallback statisticsCallback2;
        statisticsCallback = this.f9485a.q;
        if (statisticsCallback != null) {
            statisticsCallback2 = this.f9485a.q;
            statisticsCallback2.onCallback(StatisticsEvent.ON_POI_ENTRANCE_CLICK);
        }
        if (com.baidu.pano.platform.c.e.c(this.f9485a.getContext())) {
            panoramaView = this.f9485a.f9482h;
            if (panoramaView != null) {
                str = this.f9485a.i;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f9485a.f9481g = null;
                this.f9485a.l = false;
                this.f9485a.f();
                panoramaView2 = this.f9485a.f9482h;
                str2 = this.f9485a.i;
                panoramaView2.setPanoramaByUid(str2, 65537);
                return;
            }
            return;
        }
        panoramaViewListener = this.f9485a.f9479e;
        if (panoramaViewListener != null) {
            String a2 = this.f9485a.a(102);
            panoramaViewListener2 = this.f9485a.f9479e;
            panoramaViewListener2.onLoadPanoramaError(a2);
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a(String str, boolean z) {
        String e2;
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        String str2;
        PanoramaViewListener panoramaViewListener3;
        PanoramaViewListener panoramaViewListener4;
        if (!z) {
            panoramaViewListener3 = this.f9485a.f9479e;
            if (panoramaViewListener3 != null) {
                String a2 = this.f9485a.a(102);
                panoramaViewListener4 = this.f9485a.f9479e;
                panoramaViewListener4.onLoadPanoramaError(a2);
            }
        } else if (str != null) {
            InnerPanoramaView innerPanoramaView = this.f9485a;
            e2 = innerPanoramaView.e(str);
            innerPanoramaView.f9480f = e2;
            this.f9485a.f(str);
            panoramaViewListener = this.f9485a.f9479e;
            if (panoramaViewListener != null) {
                panoramaViewListener2 = this.f9485a.f9479e;
                str2 = this.f9485a.f9480f;
                panoramaViewListener2.onDescriptionLoadEnd(str2);
            }
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a(String str) {
        Handler handler;
        Handler handler2;
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        Handler handler3;
        handler = this.f9485a.t;
        if (handler.hasMessages(1001)) {
            handler3 = this.f9485a.t;
            handler3.removeMessages(1001);
        }
        Message message = new Message();
        message.what = 1001;
        message.obj = str;
        handler2 = this.f9485a.t;
        handler2.sendMessage(message);
        panoramaViewListener = this.f9485a.f9479e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.f9485a.f9479e;
            panoramaViewListener2.onCustomMarkerClick(str);
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a(String str, int i, byte[] bArr, int i2) {
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        panoramaViewListener = this.f9485a.f9479e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.f9485a.f9479e;
            panoramaViewListener2.onMessage(str, i);
        }
    }
}
