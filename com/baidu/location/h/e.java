package com.baidu.location.h;

import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class e {
    private static e Yu = null;
    private static final double[][] Yv = {new double[]{120.0618433387417d, 52.99310228080341d}, new double[]{114.4030602114635d, 47.79652316426919d}, new double[]{119.3643163114595d, 47.0727538006688d}, new double[]{111.7970645774334d, 45.24511711870672d}, new double[]{104.9683464256928d, 41.86250415619769d}, new double[]{97.59908065334047d, 43.22977087596662d}, new double[]{90.17261155579693d, 47.84045461669d}, new double[]{87.0887631003547d, 49.35214107249469d}, new double[]{83.03712288618132d, 47.19159646925913d}, new double[]{72.99264485060895d, 39.20573694893438d}, new double[]{78.45303593116243d, 31.72421462055291d}, new double[]{85.9177987174293d, 27.93063907621388d}, new double[]{92.09912961486889d, 27.71669293109786d}, new double[]{95.27333193620382d, 28.98784762533811d}, new double[]{98.44114544032976d, 27.28076394915907d}, new double[]{97.50681546607404d, 24.71427385929992d}, new double[]{97.52260341956044d, 23.71326829445317d}, new double[]{100.0708944887605d, 21.1767365339876d}, new double[]{101.9206763604854d, 21.13303015980818d}, new double[]{105.2746400703396d, 23.11902125989214d}, new double[]{107.2643282303716d, 21.45413888071461d}, new double[]{108.3761342632019d, 17.31459516935326d}, new double[]{113.0483020881062d, 16.81442875978696d}, new double[]{122.2284167146931d, 21.66374045582697d}, new double[]{123.9556508773411d, 35.66412873804383d}, new double[]{124.2746994608336d, 39.77355430531934d}, new double[]{130.842836734007d, 42.33514430285174d}, new double[]{132.9368688827846d, 44.59499883995769d}, new double[]{135.3461562047301d, 48.60080399436555d}, new double[]{131.7265723825281d, 48.00330291274656d}, new double[]{124.4850194031389d, 54.244770450984d}, new double[]{120.0618433387417d, 52.99310228080341d}};
    private LinkedList<b> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        double a;
        double b;

        a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    /* loaded from: classes2.dex */
    class b {
        a Yx;
        a Yy;

        b(a aVar, a aVar2) {
            this.Yx = aVar;
            this.Yy = aVar2;
        }

        double a(a aVar) {
            a aVar2 = new a(this.Yy.a - this.Yx.a, this.Yy.b - this.Yx.b);
            a aVar3 = new a(aVar.a - this.Yx.a, aVar.b - this.Yx.b);
            return (aVar2.a * aVar3.b) - (aVar2.b * aVar3.a);
        }

        boolean b(a aVar) {
            return e.this.h(a(aVar)) == 0 && aVar.a < Math.max(this.Yx.a, this.Yy.a) + 1.0E-8d && aVar.a > Math.min(this.Yx.a, this.Yy.a) - 1.0E-8d && aVar.b < Math.max(this.Yx.b, this.Yy.b) + 1.0E-8d && aVar.b > Math.min(this.Yx.b, this.Yy.b) - 1.0E-8d;
        }
    }

    private e() {
        this.c = null;
        int length = Yv.length;
        this.c = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length - 1) {
                return;
            }
            this.c.add(new b(new a(Yv[i2][0] * 100000.0d, Yv[i2][1] * 100000.0d), new a(Yv[i2 + 1][0] * 100000.0d, Yv[i2 + 1][1] * 100000.0d)));
            i = i2 + 1;
        }
    }

    public static e rh() {
        if (Yu == null) {
            Yu = new e();
        }
        return Yu;
    }

    public boolean g(double d, double d2) {
        try {
            a aVar = new a(100000.0d * d, 100000.0d * d2);
            int i = 0;
            Iterator<b> it = this.c.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.b(aVar)) {
                    return true;
                }
                int h = h(next.a(aVar));
                int h2 = h(next.Yx.b - aVar.b);
                int h3 = h(next.Yy.b - aVar.b);
                int i2 = (h <= 0 || h2 > 0 || h3 <= 0) ? i : i + 1;
                if (h < 0 && h3 <= 0 && h2 > 0) {
                    i2--;
                }
                i = i2;
            }
            return i != 0;
        } catch (Exception e) {
            return true;
        }
    }

    int h(double d) {
        if (d < (-1.0E-8d)) {
            return -1;
        }
        return d > 1.0E-8d ? 1 : 0;
    }
}
