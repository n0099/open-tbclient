package cn.jingling.lib.filters;

import android.content.Context;
import com.baidu.zeus.bouncycastle.DERTags;
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

    public Curve(Context context, String str) {
        try {
            makeCurve(context.getAssets().open(str));
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
        this.mCurveRed = new int[256];
        this.mCurveGreen = new int[256];
        this.mCurveBlue = new int[256];
        for (int i = 0; i < 128; i++) {
            this.mCurveRed[i] = (int) (0.7559d * i);
            this.mCurveGreen[i] = (int) (i * 1.252d);
            this.mCurveBlue[i] = (int) (i * 1.252d);
        }
        for (int i2 = DERTags.TAGGED; i2 < 256; i2++) {
            this.mCurveRed[i2] = (int) ((1.2422d * i2) - 62.0d);
            this.mCurveGreen[i2] = (int) ((i2 * 0.75d) + 63.0d);
            this.mCurveBlue[i2] = (int) ((i2 * 0.75d) + 63.0d);
        }
    }

    private void makeCurve(InputStream inputStream) {
        this.mCurveRed = new int[256];
        this.mCurveGreen = new int[256];
        this.mCurveBlue = new int[256];
        try {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
            for (int i = 0; i < 256; i++) {
                this.mCurveRed[i] = dataInputStream.readByte();
                if (this.mCurveRed[i] < 0) {
                    int[] iArr = this.mCurveRed;
                    iArr[i] = iArr[i] + 256;
                }
            }
            for (int i2 = 0; i2 < 256; i2++) {
                this.mCurveGreen[i2] = dataInputStream.readByte();
                if (this.mCurveGreen[i2] < 0) {
                    int[] iArr2 = this.mCurveGreen;
                    iArr2[i2] = iArr2[i2] + 256;
                }
            }
            for (int i3 = 0; i3 < 256; i3++) {
                this.mCurveBlue[i3] = dataInputStream.readByte();
                if (this.mCurveBlue[i3] < 0) {
                    int[] iArr3 = this.mCurveBlue;
                    iArr3[i3] = iArr3[i3] + 256;
                }
            }
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
