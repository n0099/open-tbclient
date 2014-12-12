package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
/* loaded from: classes.dex */
interface d {
    int getColorMode();

    int getOrientation();

    int getScaleMode();

    void printBitmap(String str, Bitmap bitmap);

    void printBitmap(String str, Uri uri);

    void setColorMode(int i);

    void setOrientation(int i);

    void setScaleMode(int i);
}
