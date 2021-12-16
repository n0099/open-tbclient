package c.a.q0.a.j1.e.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
/* loaded from: classes.dex */
public interface d {
    Point a(Context context, Bitmap bitmap) throws Exception;

    Bitmap decodeRegion(Rect rect, int i2);

    Point init(Context context, Uri uri) throws Exception;

    boolean isReady();

    void recycle();
}
