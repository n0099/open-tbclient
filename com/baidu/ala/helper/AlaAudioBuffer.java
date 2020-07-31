package com.baidu.ala.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class AlaAudioBuffer {
    private static final boolean VERBOSE = false;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private static final String TAG = AlaAudioBuffer.class.getSimpleName();
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public synchronized int write(byte[] bArr, int i, int i2) throws IOException {
        this.baos.write(bArr, i, i2);
        return 0;
    }

    public synchronized byte[] read(int i) {
        byte[] subarray;
        if (this.baos.size() < i) {
            subarray = null;
        } else {
            subarray = subarray(this.baos.toByteArray(), 0, i);
        }
        return subarray;
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        synchronized (this) {
            if (this.baos.size() < i2) {
                i3 = -1;
            } else {
                System.arraycopy(this.baos.toByteArray(), 0, bArr, 0, i2);
            }
        }
        return i3;
    }

    public synchronized void delete(int i) throws IOException {
        if (i > 0) {
            if (this.baos.size() < i) {
                this.baos.reset();
            } else {
                byte[] subarray = subarray(this.baos.toByteArray(), i, this.baos.size());
                printLog("AudioBuffer delete buff size " + subarray.length);
                this.baos.reset();
                this.baos.write(subarray);
            }
        }
    }

    public synchronized int size() {
        return this.baos.size();
    }

    public static byte[] subarray(byte[] bArr, int i, int i2) {
        printLog("AudioBuffer subarray buff  " + i + " " + i2);
        if (bArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > bArr.length) {
            i2 = bArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            printLog("AudioBuffer subarray buff  return null");
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }

    public static void printLog(String str) {
    }
}
