package cn.jingling.lib.filters;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class Curve {
    int[] mCurveRed = null;
    int[] mCurveGreen = null;
    int[] mCurveBlue = null;

    public Curve() {
        makeCurve();
    }

    public Curve(Context cx, String file) {
        try {
            makeCurve(cx.getAssets().open(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getCurveRed() {
        return this.mCurveRed;
    }

    public int[] getCurveGreen() {
        return this.mCurveGreen;
    }

    public int[] getCurveBlue() {
        return this.mCurveBlue;
    }

    private void makeCurve() {
        this.mCurveRed = new int[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        this.mCurveGreen = new int[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        this.mCurveBlue = new int[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        for (int i = 0; i < 128; i++) {
            this.mCurveRed[i] = (int) (0.7559d * i);
            this.mCurveGreen[i] = (int) (i * 1.252d);
            this.mCurveBlue[i] = (int) (i * 1.252d);
        }
        for (int i2 = AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER; i2 < 256; i2++) {
            this.mCurveRed[i2] = (int) ((1.2422d * i2) - 62.0d);
            this.mCurveGreen[i2] = (int) ((i2 * 0.75d) + 63.0d);
            this.mCurveBlue[i2] = (int) ((i2 * 0.75d) + 63.0d);
        }
    }

    private void makeCurve(InputStream iStream) {
        this.mCurveRed = new int[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        this.mCurveGreen = new int[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        this.mCurveBlue = new int[AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT];
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(iStream));
            for (int i = 0; i < 256; i++) {
                this.mCurveRed[i] = in.readByte();
                if (this.mCurveRed[i] < 0) {
                    int[] iArr = this.mCurveRed;
                    iArr[i] = iArr[i] + AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
                }
            }
            for (int i2 = 0; i2 < 256; i2++) {
                this.mCurveGreen[i2] = in.readByte();
                if (this.mCurveGreen[i2] < 0) {
                    int[] iArr2 = this.mCurveGreen;
                    iArr2[i2] = iArr2[i2] + AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
                }
            }
            for (int i3 = 0; i3 < 256; i3++) {
                this.mCurveBlue[i3] = in.readByte();
                if (this.mCurveBlue[i3] < 0) {
                    int[] iArr3 = this.mCurveBlue;
                    iArr3[i3] = iArr3[i3] + AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
