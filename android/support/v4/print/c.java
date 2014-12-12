package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
/* loaded from: classes.dex */
final class c implements d {
    int aS;
    int mOrientation;
    int mScaleMode;

    private c() {
        this.mScaleMode = 2;
        this.aS = 2;
        this.mOrientation = 1;
    }

    @Override // android.support.v4.print.d
    public void setScaleMode(int i) {
        this.mScaleMode = i;
    }

    @Override // android.support.v4.print.d
    public int getColorMode() {
        return this.aS;
    }

    @Override // android.support.v4.print.d
    public void setColorMode(int i) {
        this.aS = i;
    }

    @Override // android.support.v4.print.d
    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    @Override // android.support.v4.print.d
    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // android.support.v4.print.d
    public int getScaleMode() {
        return this.mScaleMode;
    }

    @Override // android.support.v4.print.d
    public void printBitmap(String str, Bitmap bitmap) {
    }

    @Override // android.support.v4.print.d
    public void printBitmap(String str, Uri uri) {
    }
}
