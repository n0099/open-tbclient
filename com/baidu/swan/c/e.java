package com.baidu.swan.c;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class e {
    public static String toMd5(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [69=4] */
    public static String e(File file, boolean z) {
        Throwable th;
        ReadableByteChannel readableByteChannel;
        ReadableByteChannel readableByteChannel2;
        String str = null;
        try {
            readableByteChannel2 = Channels.newChannel(new FileInputStream(file));
        } catch (IOException e) {
            readableByteChannel2 = null;
        } catch (Throwable th2) {
            th = th2;
            readableByteChannel = null;
        }
        try {
            str = a(readableByteChannel2, z);
            if (readableByteChannel2 != null && readableByteChannel2.isOpen()) {
                d.closeSafely(readableByteChannel2);
            }
        } catch (IOException e2) {
            if (readableByteChannel2 != null && readableByteChannel2.isOpen()) {
                d.closeSafely(readableByteChannel2);
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            readableByteChannel = readableByteChannel2;
            if (readableByteChannel != null && readableByteChannel.isOpen()) {
                d.closeSafely(readableByteChannel);
            }
            throw th;
        }
        return str;
    }

    public static String a(ReadableByteChannel readableByteChannel, boolean z) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.reset();
            byte[] bArr = new byte[8192];
            ByteBuffer allocate = ByteBuffer.allocate(8192);
            int i = 0;
            while (readableByteChannel.read(allocate) != -1) {
                i++;
                allocate.flip();
                messageDigest.update(allocate);
                allocate.clear();
            }
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
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
