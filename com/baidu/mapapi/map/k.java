package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class k implements com.baidu.mapsdkplatform.comapi.map.l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView f7079a;

    public k(MapView mapView) {
        this.f7079a = mapView;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a() {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        com.baidu.mapsdkplatform.comapi.map.j jVar4;
        com.baidu.mapsdkplatform.comapi.map.j jVar5;
        com.baidu.mapsdkplatform.comapi.map.j jVar6;
        float f2;
        SparseArray sparseArray;
        com.baidu.mapsdkplatform.comapi.map.j jVar7;
        ImageView imageView;
        String format;
        TextView textView;
        TextView textView2;
        com.baidu.mapsdkplatform.comapi.map.j jVar8;
        jVar = this.f7079a.f6923d;
        if (jVar != null) {
            jVar2 = this.f7079a.f6923d;
            if (jVar2.a() == null) {
                return;
            }
            jVar3 = this.f7079a.f6923d;
            float f3 = jVar3.a().E().f7570a;
            jVar4 = this.f7079a.f6923d;
            if (f3 < jVar4.a().f7614b) {
                jVar8 = this.f7079a.f6923d;
                f3 = jVar8.a().f7614b;
            } else {
                jVar5 = this.f7079a.f6923d;
                if (f3 > jVar5.a().f7613a) {
                    jVar6 = this.f7079a.f6923d;
                    f3 = jVar6.a().f7613a;
                }
            }
            f2 = this.f7079a.t;
            if (Math.abs(f2 - f3) > 0.0f) {
                sparseArray = MapView.p;
                int intValue = ((Integer) sparseArray.get(Math.round(f3))).intValue();
                jVar7 = this.f7079a.f6923d;
                imageView = this.f7079a.n;
                int i = ((int) (intValue / jVar7.a().E().m)) / 2;
                imageView.setPadding(i, 0, i, 0);
                Object[] objArr = new Object[1];
                if (intValue >= 1000) {
                    objArr[0] = Integer.valueOf(intValue / 1000);
                    format = String.format(" %d公里 ", objArr);
                } else {
                    objArr[0] = Integer.valueOf(intValue);
                    format = String.format(" %d米 ", objArr);
                }
                textView = this.f7079a.l;
                textView.setText(format);
                textView2 = this.f7079a.m;
                textView2.setText(format);
                this.f7079a.t = f3;
            }
            this.f7079a.b();
            this.f7079a.requestLayout();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(Bitmap bitmap) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(MotionEvent motionEvent) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(GeoPoint geoPoint) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(ab abVar) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(String str) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(GL10 gl10, ab abVar) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(boolean z) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b() {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b(GeoPoint geoPoint) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b(ab abVar) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public boolean b(String str) {
        return false;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c() {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c(GeoPoint geoPoint) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c(ab abVar) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void d() {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void d(GeoPoint geoPoint) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void e() {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void e(GeoPoint geoPoint) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void f() {
    }
}
