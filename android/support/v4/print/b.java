package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
/* loaded from: classes.dex */
final class b implements d {
    private final e aS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.aS = new e(context);
    }

    @Override // android.support.v4.print.d
    public void setScaleMode(int i) {
        this.aS.setScaleMode(i);
    }

    @Override // android.support.v4.print.d
    public int getScaleMode() {
        return this.aS.getScaleMode();
    }

    @Override // android.support.v4.print.d
    public void setColorMode(int i) {
        this.aS.setColorMode(i);
    }

    @Override // android.support.v4.print.d
    public int getColorMode() {
        return this.aS.getColorMode();
    }

    @Override // android.support.v4.print.d
    public void setOrientation(int i) {
        this.aS.setOrientation(i);
    }

    @Override // android.support.v4.print.d
    public int getOrientation() {
        return this.aS.getOrientation();
    }

    @Override // android.support.v4.print.d
    public void printBitmap(String str, Bitmap bitmap) {
        this.aS.printBitmap(str, bitmap);
    }

    @Override // android.support.v4.print.d
    public void printBitmap(String str, Uri uri) {
        this.aS.printBitmap(str, uri);
    }
}
