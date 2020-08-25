package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes20.dex */
public class l extends c {
    private Animator a = null;
    private long b = 0;
    private Interpolator c = null;
    private Animation.AnimationListener d = null;
    private int e = 1;
    private int f = 0;
    private Object[] g;

    @TargetApi(11)
    /* loaded from: classes20.dex */
    public class a implements TypeEvaluator {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            return new LatLng(latLng.latitude + (f * (latLng2.latitude - latLng.latitude)), latLng.longitude + (f * (latLng2.longitude - latLng.longitude)));
        }
    }

    @TargetApi(11)
    /* loaded from: classes20.dex */
    public class b implements TypeEvaluator {
        public b() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            return new Point((int) (point.x + ((point2.x - point.x) * f)), (int) (point.y + ((point2.y - point.y) * f)));
        }
    }

    public l(Point... pointArr) {
        this.g = pointArr;
    }

    public l(LatLng... latLngArr) {
        this.g = latLngArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofObject;
        if (marker.isFixed()) {
            if (!(this.g[0] instanceof Point)) {
                throw new ClassCastException("BDMapSDKException: if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
            ofObject = ObjectAnimator.ofObject(marker, "fixedScreenPosition", new b(), this.g);
        } else if (!(this.g[0] instanceof LatLng)) {
            throw new ClassCastException("BDMapSDKException: if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
        } else {
            ofObject = ObjectAnimator.ofObject(marker, "position", new a(), this.g);
        }
        if (ofObject != null) {
            ofObject.setRepeatCount(this.f);
            ofObject.setRepeatMode(c());
            ofObject.setDuration(this.b);
            if (this.c != null) {
                ofObject.setInterpolator(this.c);
            }
        }
        return ofObject;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        if (this.a == null) {
            return;
        }
        this.a.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    protected void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new m(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        this.a = a(marker);
        a(this.a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0 || i == -1) {
            this.f = i;
        }
    }

    public int c() {
        return this.e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }
}
