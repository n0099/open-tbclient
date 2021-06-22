package com.baidu.sofire.i;

import android.graphics.Point;
import android.hardware.Camera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10342a = "a";

    public static Point a(Camera.Parameters parameters, Point point) {
        double d2;
        double d3;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            parameters.getPreviewSize();
            return new Point(640, 480);
        }
        ArrayList arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.baidu.sofire.i.a.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                int i2 = size3.height * size3.width;
                int i3 = size4.height * size4.width;
                if (i3 < i2) {
                    return -1;
                }
                return i3 > i2 ? 1 : 0;
            }
        });
        int i2 = point.x;
        int i3 = point.y;
        if (i2 > i3) {
            d2 = i2;
            d3 = i3;
        } else {
            d2 = i3;
            d3 = i2;
        }
        double d4 = d2 / d3;
        Camera.Size size = null;
        Iterator it = arrayList.iterator();
        double d5 = -1.0d;
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i4 = size2.width;
            int i5 = size2.height;
            int i6 = i4 * i5;
            if (i6 < 307200) {
                it.remove();
            } else if (i6 > 2073600) {
                it.remove();
            } else if (i5 % 4 == 0 && i4 % 4 == 0) {
                double abs = Math.abs((i4 > i5 ? i4 / i5 : i5 / i4) - d4);
                boolean z = false;
                if ((d5 == -1.0d && abs <= 0.25d) || (d5 >= abs && abs <= 0.25d)) {
                    z = true;
                }
                if (z) {
                    size = size2;
                    d5 = abs;
                }
            } else {
                it.remove();
            }
        }
        if (size != null) {
            return new Point(size.width, size.height);
        }
        parameters.getPreviewSize();
        return new Point(640, 480);
    }
}
