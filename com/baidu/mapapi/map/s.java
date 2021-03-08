package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
import javax.microedition.khronos.opengles.GL10;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class s implements com.baidu.mapsdkplatform.comapi.map.l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextureMapView f2078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TextureMapView textureMapView) {
        this.f2078a = textureMapView;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a() {
        ac acVar;
        ac acVar2;
        ac acVar3;
        ac acVar4;
        ac acVar5;
        float f;
        ac acVar6;
        float f2;
        SparseArray sparseArray;
        ac acVar7;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        ac acVar8;
        acVar = this.f2078a.b;
        if (acVar != null) {
            acVar2 = this.f2078a.b;
            if (acVar2.b() == null) {
                return;
            }
            acVar3 = this.f2078a.b;
            float f3 = acVar3.b().E().f2214a;
            acVar4 = this.f2078a.b;
            if (f3 < acVar4.b().b) {
                acVar8 = this.f2078a.b;
                f = acVar8.b().b;
            } else {
                acVar5 = this.f2078a.b;
                if (f3 > acVar5.b().f2221a) {
                    acVar6 = this.f2078a.b;
                    f = acVar6.b().f2221a;
                } else {
                    f = f3;
                }
            }
            f2 = this.f2078a.q;
            if (Math.abs(f2 - f) > 0.0f) {
                sparseArray = TextureMapView.p;
                int intValue = ((Integer) sparseArray.get(Math.round(f))).intValue();
                acVar7 = this.f2078a.b;
                int i = (int) (intValue / acVar7.b().E().m);
                imageView = this.f2078a.n;
                imageView.setPadding(i / 2, 0, i / 2, 0);
                String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", Integer.valueOf(intValue));
                textView = this.f2078a.l;
                textView.setText(format);
                textView2 = this.f2078a.m;
                textView2.setText(format);
                this.f2078a.q = f;
            }
            this.f2078a.b();
            this.f2078a.requestLayout();
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
