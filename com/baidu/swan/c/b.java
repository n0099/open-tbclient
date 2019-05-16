package com.baidu.swan.c;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class b {
    public static String toMd5(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [69=4] */
    public static String b(File file, boolean z) {
        ReadableByteChannel readableByteChannel;
        Throwable th;
        String str = null;
        try {
            readableByteChannel = Channels.newChannel(new FileInputStream(file));
        } catch (IOException e) {
            readableByteChannel = null;
        } catch (Throwable th2) {
            readableByteChannel = null;
            th = th2;
        }
        try {
            str = a(readableByteChannel, z);
            if (readableByteChannel != null && readableByteChannel.isOpen()) {
                try {
                    readableByteChannel.close();
                } catch (IOException e2) {
                }
            }
        } catch (IOException e3) {
            if (readableByteChannel != null && readableByteChannel.isOpen()) {
                try {
                    readableByteChannel.close();
                } catch (IOException e4) {
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            if (readableByteChannel != null && readableByteChannel.isOpen()) {
                try {
                    readableByteChannel.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        return str;
    }

    public static String a(ReadableByteChannel readableByteChannel, boolean z) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            byte[] bArr = new byte[8192];
            ByteBuffer allocate = ByteBuffer.allocate(8192);
            int i = 0;
            while (readableByteChannel.read(allocate) != -1) {
                i++;
                allocate.flip();
                Log.i("SwanAppMD5Utils", "read buffer: " + bArr.length);
                messageDigest.update(allocate);
                Log.i("SwanAppMD5Utils", "read buffer ok ");
                allocate.clear();
            }
            Log.i("SwanAppMD5Utils", "read end: " + i);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }
}
