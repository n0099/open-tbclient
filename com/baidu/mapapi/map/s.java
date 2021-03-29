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
/* loaded from: classes2.dex */
public class s implements com.baidu.mapsdkplatform.comapi.map.l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextureMapView f7097a;

    public s(TextureMapView textureMapView) {
        this.f7097a = textureMapView;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a() {
        ac acVar;
        ac acVar2;
        ac acVar3;
        ac acVar4;
        ac acVar5;
        ac acVar6;
        float f2;
        SparseArray sparseArray;
        ac acVar7;
        ImageView imageView;
        String format;
        TextView textView;
        TextView textView2;
        ac acVar8;
        acVar = this.f7097a.f7024b;
        if (acVar != null) {
            acVar2 = this.f7097a.f7024b;
            if (acVar2.b() == null) {
                return;
            }
            acVar3 = this.f7097a.f7024b;
            float f3 = acVar3.b().E().f7570a;
            acVar4 = this.f7097a.f7024b;
            if (f3 < acVar4.b().f7614b) {
                acVar8 = this.f7097a.f7024b;
                f3 = acVar8.b().f7614b;
            } else {
                acVar5 = this.f7097a.f7024b;
                if (f3 > acVar5.b().f7613a) {
                    acVar6 = this.f7097a.f7024b;
                    f3 = acVar6.b().f7613a;
                }
            }
            f2 = this.f7097a.q;
            if (Math.abs(f2 - f3) > 0.0f) {
                sparseArray = TextureMapView.p;
                int intValue = ((Integer) sparseArray.get(Math.round(f3))).intValue();
                acVar7 = this.f7097a.f7024b;
                imageView = this.f7097a.n;
                int i = ((int) (intValue / acVar7.b().E().m)) / 2;
                imageView.setPadding(i, 0, i, 0);
                Object[] objArr = new Object[1];
                if (intValue >= 1000) {
                    objArr[0] = Integer.valueOf(intValue / 1000);
                    format = String.format(" %d公里 ", objArr);
                } else {
                    objArr[0] = Integer.valueOf(intValue);
                    format = String.format(" %d米 ", objArr);
                }
                textView = this.f7097a.l;
                textView.setText(format);
                textView2 = this.f7097a.m;
                textView2.setText(format);
                this.f7097a.q = f3;
            }
            this.f7097a.b();
            this.f7097a.requestLayout();
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
