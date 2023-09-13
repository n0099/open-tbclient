package com.baidu.cyberplayer.sdk;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes3.dex */
public class RC4 {
    public static final int STATE_LENGTH = 256;
    public static final String TAG = "RC4";
    public byte[] workingKey;
    public byte[] engineState = null;
    public int x = 0;
    public int y = 0;

    /* loaded from: classes3.dex */
    public static class MyGZIPOutputStream extends GZIPOutputStream {
        public MyGZIPOutputStream(OutputStream outputStream) throws IOException {
            super(outputStream);
        }

        public void setLevel(int i) {
            ((GZIPOutputStream) this).def.setLevel(i);
        }
    }

    public RC4(String str) {
        this.workingKey = null;
        this.workingKey = str.getBytes();
    }

    public static byte[] kernelGzipCompress(byte[] bArr) throws IOException {
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MyGZIPOutputStream myGZIPOutputStream = new MyGZIPOutputStream(byteArrayOutputStream);
            myGZIPOutputStream.setLevel(9);
            myGZIPOutputStream.write(bArr);
            myGZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public byte[] decrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }

    public static byte[] kernelEncrypt(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        if (CyberPlayerManager.duplayerEncrypt(bArr, bArr.length, bArr2)) {
            return bArr2;
        }
        byte[] bArr3 = {26, 31, -22, -104, 118, 81, -16, 6, 90, -75, Byte.MIN_VALUE, ExifInterface.MARKER_SOI, 85, 92, 106, 114, -20, 34, 116, 13, -70, -77, 122, -71, -84, -25, -42, 99, ExifInterface.START_CODE, 100, 19, -37, -99, 32, -17, 70, -124, -24, -114, -120, 24, 73, -103, 3, -44, 1, 52, 91, 17, 40, -21, 66, -91, 21, 16, ExifInterface.MARKER_SOF5, 80, 49, 12, -123, 123, -92, 68, 102, Constants.SHORT_PING_CMD_TYPE, -6, -72, -89, -107, 10, 126, -102, -98, -52, ExifInterface.MARKER_SOF0, 120, -32, ExifInterface.MARKER_SOF9, -80, 98, 55, -85, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 47, -101, 84, -90, 121, 125, -28, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, ExifInterface.MARKER_SOF1, 83, -113, 61, -67, ExifInterface.MARKER_SOF7, -15, 22, -19, 94, 28, -46, 97, 43, ByteCompanionObject.MAX_VALUE, -9, 20, 112, ExifInterface.MARKER_SOF10, Constants.GZIP_CAST_TYPE, -68, -2, -112, -79, -47, -13, 109, 27, -116, -96, -115, -18, -100, 5, Base64.INTERNAL_PADDING, 67, 48, 82, -23, 88, -66, ExifInterface.MARKER_SOS, 50, 23, -4, -48, ExifInterface.MARKER_SOF6, ExifInterface.MARKER_SOF13, -29, -78, 115, -122, 69, -34, -86, 74, ExifInterface.MARKER_SOF14, -87, -1, -121, 124, 71, -126, 7, 62, 56, -94, 77, -110, -27, 30, -83, ExifInterface.MARKER_SOF2, 0, 18, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 104, 29, 78, 25, -41, 2, -65, -8, -3, 89, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, -56, 58, -45, 79, 14, 96, 72, -26, -14, -82, 15, 108, -30, -97, -108, -109, 54, -73, -11, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, ExifInterface.MARKER_SOF3, -33, 59, ExifInterface.MARKER_SOF15, 117, -95, 9, 87, 110, -125, -105, 86, 45, 60, -81, ExifInterface.MARKER_EOI, -43, ExifInterface.MARKER_APP1, ExifInterface.MARKER_SOF11, 63, -88, 76, -10, 8, 53, 93, 75, -60, 111, 105, -127, 103, -111, -93, QCodec.UNDERSCORE, 64, -69, -106, -7, 113, 4, -5, -74, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, -117, -12, -35, 51, 119, 65, 33, -36, 107, -119, 57, -118, -76, 37};
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (bArr3[i] + i2) & 255;
            byte b = bArr3[i];
            bArr3[i] = bArr3[i2];
            bArr3[i2] = b;
            bArr2[i3] = (byte) (bArr[i3] ^ bArr3[(bArr3[i] + bArr3[i2]) & 255]);
        }
        return bArr2;
    }

    private void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            CyberLog.e("RC4", "input buffer too short");
        } else if (i3 + i2 > bArr2.length) {
            CyberLog.e("RC4", "output buffer too short");
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = (this.x + 1) & 255;
                this.x = i5;
                byte[] bArr3 = this.engineState;
                int i6 = (bArr3[i5] + this.y) & 255;
                this.y = i6;
                byte b = bArr3[i5];
                bArr3[i5] = bArr3[i6];
                bArr3[i6] = b;
                bArr2[i4 + i3] = (byte) (bArr3[(bArr3[i5] + bArr3[i6]) & 255] ^ bArr[i4 + i]);
            }
        }
    }

    private void reset() {
        setKey(this.workingKey);
    }

    private void setKey(byte[] bArr) {
        this.x = 0;
        this.y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.engineState[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.engineState;
            i3 = ((bArr[i2] & 255) + bArr2[i4] + i3) & 255;
            byte b = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b;
            i2 = (i2 + 1) % bArr.length;
        }
    }
}
