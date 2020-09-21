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
/* loaded from: classes3.dex */
public class d implements b {
    final /* synthetic */ InnerPanoramaView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InnerPanoramaView innerPanoramaView) {
        this.a = innerPanoramaView;
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
            panoramaViewListener5 = this.a.e;
            if (panoramaViewListener5 != null) {
                String a = this.a.a(103);
                panoramaViewListener6 = this.a.e;
                panoramaViewListener6.onLoadPanoramaError(a);
            }
        } else {
            panoramaViewListener = this.a.e;
            if (panoramaViewListener != null) {
                str = this.a.f;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        str3 = this.a.f;
                        JSONObject jSONObject = new JSONObject(str3);
                        String optString = jSONObject.optString("Type");
                        this.a.k = jSONObject.optString("ID");
                        int optInt = jSONObject.optInt("X");
                        int optInt2 = jSONObject.optInt("Y");
                        bVar = this.a.g;
                        if (bVar != null) {
                            z3 = this.a.l;
                            if (!z3) {
                                InnerPanoramaView innerPanoramaView = this.a;
                                bVar11 = this.a.g;
                                innerPanoramaView.a(bVar11);
                                this.a.l = true;
                            }
                            InnerPanoramaView innerPanoramaView2 = this.a;
                            bVar5 = this.a.g;
                            double d7 = bVar5.mLongitude;
                            bVar6 = this.a.g;
                            String a2 = innerPanoramaView2.a(d7, bVar6.mLatitude, optInt, optInt2);
                            if (!TextUtils.isEmpty(a2) && "street".equals(optString)) {
                                this.a.d(a2);
                            } else {
                                InnerPanoramaView innerPanoramaView3 = this.a;
                                bVar7 = this.a.g;
                                innerPanoramaView3.m = bVar7.b;
                                InnerPanoramaView innerPanoramaView4 = this.a;
                                bVar8 = this.a.g;
                                innerPanoramaView4.n = bVar8.a;
                                InnerPanoramaView innerPanoramaView5 = this.a;
                                bVar9 = this.a.g;
                                innerPanoramaView5.o = bVar9.mLongitude;
                                InnerPanoramaView innerPanoramaView6 = this.a;
                                bVar10 = this.a.g;
                                innerPanoramaView6.p = bVar10.mLatitude;
                                this.a.g = null;
                                this.a.l = false;
                                this.a.f();
                            }
                        } else {
                            str4 = this.a.n;
                            if (str4 != null) {
                                d = this.a.o;
                                if (d != 0.0d) {
                                    d2 = this.a.p;
                                    if (d2 != 0.0d && "street".equals(optString)) {
                                        InnerPanoramaView innerPanoramaView7 = this.a;
                                        d3 = this.a.o;
                                        d4 = this.a.p;
                                        String a3 = innerPanoramaView7.a(d3, d4, optInt, optInt2);
                                        if (!TextUtils.isEmpty(a3)) {
                                            InnerPanoramaView innerPanoramaView8 = this.a;
                                            Context context = this.a.b;
                                            z2 = this.a.m;
                                            str5 = this.a.n;
                                            innerPanoramaView8.g = new com.baidu.pano.platform.comapi.a.b(context, z2, str5);
                                            bVar2 = this.a.g;
                                            d5 = this.a.o;
                                            d6 = this.a.p;
                                            bVar2.setMarkerPosition(new Point(d5, d6));
                                            bVar3 = this.a.g;
                                            bVar3.setMarkerHeight(2.0f);
                                            InnerPanoramaView innerPanoramaView9 = this.a;
                                            bVar4 = this.a.g;
                                            innerPanoramaView9.a(bVar4);
                                            this.a.d(a3);
                                        }
                                    }
                                }
                            }
                        }
                        panoramaViewListener3 = this.a.e;
                        panoramaViewListener3.onLoadPanoramaEnd(jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                        panoramaViewListener2 = this.a.e;
                        str2 = this.a.f;
                        panoramaViewListener2.onLoadPanoramaEnd(str2);
                    }
                } else {
                    String a4 = this.a.a(201);
                    panoramaViewListener4 = this.a.e;
                    panoramaViewListener4.onLoadPanoramaEnd(a4);
                }
            }
        }
        this.a.s = true;
        if (!BMapManager.isIllegalPanoSDKUser()) {
            Bundle bundle = new Bundle();
            bundle.putString("text", "未认证key");
            bundle.putFloat("fontsize", 36.0f);
            bundle.putInt("fontcolor", SupportMenu.CATEGORY_MASK);
            bundle.putInt("bgcolor", -1);
            bundle.putLong("padding", 16L);
            this.a.a.c(bundle);
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void d() {
        PanoramaViewListener panoramaViewListener;
        panoramaViewListener = this.a.e;
        panoramaViewListener.onMoveStart();
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void e() {
        PanoramaViewListener panoramaViewListener;
        panoramaViewListener = this.a.e;
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
            panoramaViewListener = this.a.e;
            if (panoramaViewListener != null) {
                String a = this.a.a(101);
                panoramaViewListener2 = this.a.e;
                panoramaViewListener2.onLoadPanoramaError(a);
            }
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void c() {
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        panoramaViewListener = this.a.e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.a.e;
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
            panoramaViewListener3 = this.a.e;
            if (panoramaViewListener3 != null) {
                String a = this.a.a(102);
                panoramaViewListener4 = this.a.e;
                panoramaViewListener4.onLoadPanoramaError(a);
            }
        } else if (str != null) {
            InnerPanoramaView innerPanoramaView = this.a;
            e = this.a.e(str);
            innerPanoramaView.f = e;
            this.a.f(str);
            panoramaViewListener = this.a.e;
            if (panoramaViewListener != null) {
                panoramaViewListener2 = this.a.e;
                str2 = this.a.f;
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
        handler = this.a.w;
        if (handler.hasMessages(1001)) {
            handler3 = this.a.w;
            handler3.removeMessages(1001);
        }
        Message message = new Message();
        message.what = 1001;
        message.obj = str;
        handler2 = this.a.w;
        handler2.sendMessage(message);
        panoramaViewListener = this.a.e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.a.e;
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
        statisticsCallback = this.a.q;
        if (statisticsCallback != null) {
            statisticsCallback2 = this.a.q;
            statisticsCallback2.onCallback(StatisticsEvent.ON_POI_MARKER_CLICK);
        }
        if (com.baidu.pano.platform.c.e.c(this.a.getContext())) {
            str = this.a.j;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.a.k;
                if (!TextUtils.isEmpty(str2)) {
                    str3 = this.a.j;
                    str4 = this.a.k;
                    if (!str3.equals(str4)) {
                        panoramaView = this.a.h;
                        str5 = this.a.i;
                        panoramaView.setPanoramaByUid(str5, PanoramaView.PANOTYPE_STREET);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        panoramaViewListener = this.a.e;
        if (panoramaViewListener != null) {
            String a = this.a.a(102);
            panoramaViewListener2 = this.a.e;
            panoramaViewListener2.onLoadPanoramaError(a);
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
        statisticsCallback = this.a.q;
        if (statisticsCallback != null) {
            statisticsCallback2 = this.a.q;
            statisticsCallback2.onCallback(StatisticsEvent.ON_POI_ENTRANCE_CLICK);
        }
        if (com.baidu.pano.platform.c.e.c(this.a.getContext())) {
            panoramaView = this.a.h;
            if (panoramaView != null) {
                str = this.a.i;
                if (!TextUtils.isEmpty(str)) {
                    this.a.g = null;
                    this.a.l = false;
                    this.a.f();
                    panoramaView2 = this.a.h;
                    str2 = this.a.i;
                    panoramaView2.setPanoramaByUid(str2, PanoramaView.PANOTYPE_INTERIOR);
                    return;
                }
                return;
            }
            return;
        }
        panoramaViewListener = this.a.e;
        if (panoramaViewListener != null) {
            String a = this.a.a(102);
            panoramaViewListener2 = this.a.e;
            panoramaViewListener2.onLoadPanoramaError(a);
        }
    }

    @Override // com.baidu.pano.platform.comapi.map.b
    public void a(String str, int i, byte[] bArr, int i2) {
        PanoramaViewListener panoramaViewListener;
        PanoramaViewListener panoramaViewListener2;
        panoramaViewListener = this.a.e;
        if (panoramaViewListener != null) {
            panoramaViewListener2 = this.a.e;
            panoramaViewListener2.onMessage(str, i);
        }
    }
}
