package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
/* loaded from: classes.dex */
final class b implements d {
    private final e lW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.lW = new e(context);
    }

    @Override // android.support.v4.print.d
    public void setScaleMode(int i) {
        this.lW.setScaleMode(i);
    }

    @Override // android.support.v4.print.d
    public int getScaleMode() {
        return this.lW.getScaleMode();
    }

    @Override // android.support.v4.print.d
    public void setColorMode(int i) {
        this.lW.setColorMode(i);
    }

    @Override // android.support.v4.print.d
    public int getColorMode() {
        return this.lW.getColorMode();
    }

    @Override // android.support.v4.print.d
    public void setOrientation(int i) {
        this.lW.setOrientation(i);
    }

    @Override // android.support.v4.print.d
    public int getOrientation() {
        return this.lW.getOrientation();
    }

    @Override // android.support.v4.print.d
    public void printBitmap(String str, Bitmap bitmap) {
        this.lW.printBitmap(str, bitmap);
    }

    @Override // android.support.v4.print.d
    public void printBitmap(String str, Uri uri) {
        this.lW.printBitmap(str, uri);
    }
}
