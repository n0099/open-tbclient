package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
/* loaded from: classes.dex */
final class b implements d {
    private final e aR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.aR = new e(context);
    }

    @Override // android.support.v4.print.d
    public void setScaleMode(int i) {
        this.aR.setScaleMode(i);
    }

    @Override // android.support.v4.print.d
    public int getScaleMode() {
        return this.aR.getScaleMode();
    }

    @Override // android.support.v4.print.d
    public void setColorMode(int i) {
        this.aR.setColorMode(i);
    }

    @Override // android.support.v4.print.d
    public int getColorMode() {
        return this.aR.getColorMode();
    }

    @Override // android.support.v4.print.d
    public void setOrientation(int i) {
        this.aR.setOrientation(i);
    }

    @Override // android.support.v4.print.d
    public int getOrientation() {
        return this.aR.getOrientation();
    }

    @Override // android.support.v4.print.d
    public void printBitmap(String str, Bitmap bitmap) {
        this.aR.printBitmap(str, bitmap);
    }

    @Override // android.support.v4.print.d
    public void printBitmap(String str, Uri uri) {
        this.aR.printBitmap(str, uri);
    }
}
