package cn.jingling.lib.filters;

import android.content.Context;
import com.baidu.browser.webpool.BdWebPoolView;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class ByteCurve {
    byte[] mCurveRed = null;
    byte[] mCurveGreen = null;
    byte[] mCurveBlue = null;

    public ByteCurve(Context context, String str) {
        try {
            makeCurve(context.getAssets().open(str));
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

    private void makeCurve(InputStream inputStream) {
        this.mCurveRed = new byte[256];
        this.mCurveGreen = new byte[256];
        this.mCurveBlue = new byte[256];
        try {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
            for (int i = 0; i < 256; i++) {
                this.mCurveRed[i] = dataInputStream.readByte();
                if (this.mCurveRed[i] < 0) {
                    byte[] bArr = this.mCurveRed;
                    bArr[i] = (byte) (bArr[i] + BdWebPoolView.PAGE_MAGNITUDE_UNDEFINE);
                }
            }
            for (int i2 = 0; i2 < 256; i2++) {
                this.mCurveGreen[i2] = dataInputStream.readByte();
                if (this.mCurveGreen[i2] < 0) {
                    byte[] bArr2 = this.mCurveGreen;
                    bArr2[i2] = (byte) (bArr2[i2] + BdWebPoolView.PAGE_MAGNITUDE_UNDEFINE);
                }
            }
            for (int i3 = 0; i3 < 256; i3++) {
                this.mCurveBlue[i3] = dataInputStream.readByte();
                if (this.mCurveBlue[i3] < 0) {
                    byte[] bArr3 = this.mCurveBlue;
                    bArr3[i3] = (byte) (bArr3[i3] + BdWebPoolView.PAGE_MAGNITUDE_UNDEFINE);
                }
            }
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
