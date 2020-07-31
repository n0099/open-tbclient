package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import javax.microedition.khronos.opengles.GL10;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class k implements com.baidu.mapsdkplatform.comapi.map.l {
    final /* synthetic */ MapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MapView mapView) {
        this.a = mapView;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a() {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        com.baidu.mapsdkplatform.comapi.map.j jVar4;
        com.baidu.mapsdkplatform.comapi.map.j jVar5;
        float f;
        com.baidu.mapsdkplatform.comapi.map.j jVar6;
        float f2;
        SparseArray sparseArray;
        com.baidu.mapsdkplatform.comapi.map.j jVar7;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        com.baidu.mapsdkplatform.comapi.map.j jVar8;
        jVar = this.a.d;
        if (jVar != null) {
            jVar2 = this.a.d;
            if (jVar2.a() == null) {
                return;
            }
            jVar3 = this.a.d;
            float f3 = jVar3.a().E().a;
            jVar4 = this.a.d;
            if (f3 < jVar4.a().b) {
                jVar8 = this.a.d;
                f = jVar8.a().b;
            } else {
                jVar5 = this.a.d;
                if (f3 > jVar5.a().a) {
                    jVar6 = this.a.d;
                    f = jVar6.a().a;
                } else {
                    f = f3;
                }
            }
            f2 = this.a.t;
            if (Math.abs(f2 - f) > 0.0f) {
                sparseArray = MapView.p;
                int intValue = ((Integer) sparseArray.get(Math.round(f))).intValue();
                jVar7 = this.a.d;
                int i = (int) (intValue / jVar7.a().E().m);
                imageView = this.a.n;
                imageView.setPadding(i / 2, 0, i / 2, 0);
                String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", Integer.valueOf(intValue));
                textView = this.a.l;
                textView.setText(format);
                textView2 = this.a.m;
                textView2.setText(format);
                this.a.t = f;
            }
            this.a.b();
            this.a.requestLayout();
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
