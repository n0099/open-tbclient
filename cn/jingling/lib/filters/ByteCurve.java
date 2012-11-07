package cn.jingling.lib.filters;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class ByteCurve {
    byte[] mCurveRed = null;
    byte[] mCurveGreen = null;
    byte[] mCurveBlue = null;

    public ByteCurve(Context cx, String file) {
        try {
            makeCurve(cx.getAssets().open(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getCurveRed() {
        return this.mCurveRed;
    }

    public byte[] getCurveGreen() {
        return this.mCurveGreen;
    }

    public byte[] getCurveBlue() {
        return this.mCurveBlue;
    }

    private void makeCurve(InputStream iStream) {
        this.mCurveRed = new byte[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        this.mCurveGreen = new byte[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        this.mCurveBlue = new byte[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(iStream));
            for (int i = 0; i < 256; i++) {
                this.mCurveRed[i] = in.readByte();
                if (this.mCurveRed[i] < 0) {
                    byte[] bArr = this.mCurveRed;
                    bArr[i] = (byte) (bArr[i] + 256);
                }
            }
            for (int i2 = 0; i2 < 256; i2++) {
                this.mCurveGreen[i2] = in.readByte();
                if (this.mCurveGreen[i2] < 0) {
                    byte[] bArr2 = this.mCurveGreen;
                    bArr2[i2] = (byte) (bArr2[i2] + 256);
                }
            }
            for (int i3 = 0; i3 < 256; i3++) {
                this.mCurveBlue[i3] = in.readByte();
                if (this.mCurveBlue[i3] < 0) {
                    byte[] bArr3 = this.mCurveBlue;
                    bArr3[i3] = (byte) (bArr3[i3] + 256);
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
