package com.baidu.pano.platform.comapi.map;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import com.baidu.lbsapi.BMapManager;
import com.baidu.lbsapi.model.StatisticsEvent;
import com.baidu.lbsapi.panoramaview.PanoramaView;
import com.baidu.lbsapi.panoramaview.PanoramaViewListener;
import com.baidu.lbsapi.panoramaview.StatisticsCallback;
import com.baidu.lbsapi.tools.Point;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InnerPanoramaView f2683a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InnerPanoramaView innerPanoramaView) {
        this.f2683a = innerPanoramaView;
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
        double d;
        double d2;
        double d3;
        double d4;
        boolean z2;
        String str5;
        com.baidu.pano.platform.comapi.a.b bVar2;
        double d5;
        double d6;
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
            panoramaViewListener5 = this.f2683a.e;
            if (panoramaViewListener5 != null) {
                String a2 = this.f2683a.a(103);
                panoramaViewListener6 = this.f2683a.e;
                panoramaViewListener6.onLoadPanoramaError(a2);
            }
        } else {
            panoramaViewListener = this.f2683a.e;
            if (panoramaViewListener != null) {
                str = this.f2683a.f;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        str3 = this.f2683a.f;
                        JSONObject jSONObject = new JSONObject(str3);
                        String optString = jSONObject.optString("Type");
                        this.f2683a.k = jSONObject.optString("ID");
                        int optInt = jSONObject.optInt("X");
                        int optInt2 = jSONObject.optInt("Y");
                        bVar = this.f2683a.g;
                        if (bVar != null) {
                            z3 = this.f2683a.l;
                            if (!z3) {
                                InnerPanoramaView innerPanoramaView = this.f2683a;
                                bVar11 = this.f2683a.g;
                                innerPanoramaView.a(bVar11);
                                this.f2683a.l = true;
                            }
                            InnerPanoramaView innerPanoramaView2 = this.f2683a;
                            bVar5 = this.f2683a.g;
                            double d7 = bVar5.mLongitude;
                            bVar6 = this.f2683a.g;
                            String a3 = innerPanoramaView2.a(d7, bVar6.mLatitude, optInt, optInt2);
                            if (!TextUtils.isEmpty(a3) && "street".equals(optString)) {
                                this.f2683a.d(a3);
                            } else {
                                InnerPanoramaView innerPanoramaView3 = this.f2683a;
                                bVar7 = this.f2683a.g;
                                innerPanoramaView3.m = bVar7.b;
                                InnerPanoramaView innerPanoramaView4 = this.f2683a;
                                bVar8 = this.f2683a.g;
                                innerPanoramaView4.n = bVar8.f2679a;
                                InnerPanoramaView innerPanoramaView5 = this.f2683a;
                                bVar9 = this.f2683a.g;
                                innerPanoramaView5.o = bVar9.mLongitude;
                                InnerPanoramaView innerPanoramaView6 = this.f2683a;
                                bVar10 = this.f2683a.g;
                                innerPanoramaView6.p = bVar10.mLatitude;
                                this.f2683a.g = null;
                                this.f2683a.l = false;
                                this.f2683a.f();
                            }
                        } else {
                            str4 = this.f2683a.n;
                            if (str4 != null) {
                                d = this.f2683a.o;
                                if (d != 0.0d) {
                                    d2 = this.f2683a.p;
                                    if (d2 != 0.0d && "street".equals(optString)) {
                                        InnerPanoramaView innerPanoramaView7 = this.f2683a;
                                        d3 = this.f2683a.o;
                                        d4 = this.f2683a.p;
                                        String a4 = innerPanoramaView7.a(d3, d4, optInt, optInt2);
                                        if (!TextUtils.isEmpty(a4)) {
                                            InnerPanoramaView innerPanoramaView8 = this.f2683a;
                                            Context context = this.f2683a.b;
                                            z2 = this.f2683a.m;
                                            str5 = this.f2683a.n;
                                            innerPanoramaView8.g = new com.baidu.pano.platform.comapi.a.b(context, z2, str5);
                                            bVar2 = this.f2683a.g;
                                            d5 = this.f2683a.o;
                                            d6 = this.f2683a.p;
                                            bVar2.setMarkerPosition(new Point(d5, d6));
                                            bVar3 = this.f2683a.g;
                                            bVar3.setMarkerHeight(2.0f);
                                            InnerPanoramaView innerPanoramaView9 = this.f2683a;
                                            bVar4 = this.f2683a.g;
                                            innerPanoramaView9.a(bVar4);
                                            this.f2683a.d(a4);
                                        }
                                    }
                                }
                            }
                        }
                        panoramaViewListener3 = this.f2683a.e;
                        panoramaViewListener3.onLoadPanoramaEnd(jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                        panoramaViewListener2 = this.f2683a.e;
                        str2 = this.f2683a.f;
                        panoramaViewListener2.onLoadPanoramaEnd(str2);
                    }
                } else {
                    String a5 = this.f2683a.a(201);
                    panoramaViewListener4 = this.f2683a.e;
                    panoramaViewListener4.onLoadPanoramaEnd(a5);
                }
            }
        }
        this.f2683a.s = true;
        if (!BMapManager.isIllegalPanoSDKUser()) {
            Bundle bundle = new Bundle();
            bundle.putString("text", "未认证key");
            bundle.putFloat("fontsize", 36.0f);
            bundle.putInt("fontcolor", SupportMenu.CATEGORY_MASK);
            bundle.putInt("bgcolor", -1);
            bundle.putLong("padding", 16L);
            this.f2683a.f2680a.c(bundle);
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void d() {
        PanoramaViewListener panoramaViewListener;
        panoramaViewListener = this.f2683a.e;
        panoramaViewListener.onMoveStart();
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void e() {
        PanoramaViewListener panoramaViewListener;
        panoramaViewListener = this.f2683a.e;
        panoramaViewListener.onMoveEnd();
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a() {
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a(boolean z) {
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        if (!z) {
            panoramaViewListener = this.f2683a.e;
            if (panoramaViewListener != null) {
                String a2 = this.f2683a.a(101);
                panoramaViewListener2 = this.f2683a.e;
                panoramaViewListener2.onLoadPanoramaError(a2);
            }
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void c() {
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        panoramaViewListener = this.f2683a.e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.f2683a.e;
            panoramaViewListener2.onLoadPanoramaBegin();
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a(String str, boolean z) {
        String e;
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        String str2;
        PanoramaViewListener panoramaViewListener3;
        PanoramaViewListener panoramaViewListener4;
        if (!z) {
            panoramaViewListener3 = this.f2683a.e;
            if (panoramaViewListener3 != null) {
                String a2 = this.f2683a.a(102);
                panoramaViewListener4 = this.f2683a.e;
                panoramaViewListener4.onLoadPanoramaError(a2);
            }
        } else if (str != null) {
            InnerPanoramaView innerPanoramaView = this.f2683a;
            e = this.f2683a.e(str);
            innerPanoramaView.f = e;
            this.f2683a.f(str);
            panoramaViewListener = this.f2683a.e;
            if (panoramaViewListener != null) {
                panoramaViewListener2 = this.f2683a.e;
                str2 = this.f2683a.f;
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
        handler = this.f2683a.w;
        if (handler.hasMessages(1001)) {
            handler3 = this.f2683a.w;
            handler3.removeMessages(1001);
        }
        Message message = new Message();
        message.what = 1001;
        message.obj = str;
        handler2 = this.f2683a.w;
        handler2.sendMessage(message);
        panoramaViewListener = this.f2683a.e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.f2683a.e;
            panoramaViewListener2.onCustomMarkerClick(str);
        }
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
        statisticsCallback = this.f2683a.q;
        if (statisticsCallback != null) {
            statisticsCallback2 = this.f2683a.q;
            statisticsCallback2.onCallback(StatisticsEvent.ON_POI_MARKER_CLICK);
        }
        if (com.baidu.pano.platform.c.e.c(this.f2683a.getContext())) {
            str = this.f2683a.j;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.f2683a.k;
                if (!TextUtils.isEmpty(str2)) {
                    str3 = this.f2683a.j;
                    str4 = this.f2683a.k;
                    if (!str3.equals(str4)) {
                        panoramaView = this.f2683a.h;
                        str5 = this.f2683a.i;
                        panoramaView.setPanoramaByUid(str5, PanoramaView.PANOTYPE_STREET);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        panoramaViewListener = this.f2683a.e;
        if (panoramaViewListener != null) {
            String a2 = this.f2683a.a(102);
            panoramaViewListener2 = this.f2683a.e;
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
        statisticsCallback = this.f2683a.q;
        if (statisticsCallback != null) {
            statisticsCallback2 = this.f2683a.q;
            statisticsCallback2.onCallback(StatisticsEvent.ON_POI_ENTRANCE_CLICK);
        }
        if (com.baidu.pano.platform.c.e.c(this.f2683a.getContext())) {
            panoramaView = this.f2683a.h;
            if (panoramaView != null) {
                str = this.f2683a.i;
                if (!TextUtils.isEmpty(str)) {
                    this.f2683a.g = null;
                    this.f2683a.l = false;
                    this.f2683a.f();
                    panoramaView2 = this.f2683a.h;
                    str2 = this.f2683a.i;
                    panoramaView2.setPanoramaByUid(str2, PanoramaView.PANOTYPE_INTERIOR);
                    return;
                }
                return;
            }
            return;
        }
        panoramaViewListener = this.f2683a.e;
        if (panoramaViewListener != null) {
            String a2 = this.f2683a.a(102);
            panoramaViewListener2 = this.f2683a.e;
            panoramaViewListener2.onLoadPanoramaError(a2);
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a(String str, int i, byte[] bArr, int i2) {
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        panoramaViewListener = this.f2683a.e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.f2683a.e;
            panoramaViewListener2.onMessage(str, i);
        }
    }
}
