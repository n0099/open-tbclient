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
/* loaded from: classes4.dex */
public class u implements com.baidu.mapsdkplatform.comapi.map.l {
    final /* synthetic */ WearMapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WearMapView wearMapView) {
        this.a = wearMapView;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a() {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        float f;
        SparseArray sparseArray;
        com.baidu.mapsdkplatform.comapi.map.j jVar4;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        jVar = this.a.e;
        if (jVar != null) {
            jVar2 = this.a.e;
            if (jVar2.a() == null) {
                return;
            }
            jVar3 = this.a.e;
            float f2 = jVar3.a().E().a;
            f = this.a.z;
            if (f != f2) {
                sparseArray = WearMapView.w;
                int intValue = ((Integer) sparseArray.get((int) f2)).intValue();
                jVar4 = this.a.e;
                int i = (int) (intValue / jVar4.a().E().m);
                imageView = this.a.q;
                imageView.setPadding(i / 2, 0, i / 2, 0);
                String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", Integer.valueOf(intValue));
                textView = this.a.o;
                textView.setText(format);
                textView2 = this.a.p;
                textView2.setText(format);
                this.a.z = f2;
            }
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
