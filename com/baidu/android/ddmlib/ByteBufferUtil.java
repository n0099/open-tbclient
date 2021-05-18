package com.baidu.android.ddmlib;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public class ByteBufferUtil {
    @NonNull
    public static String getString(@NonNull ByteBuffer byteBuffer, int i2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = byteBuffer.getChar();
        }
        return new String(cArr);
    }

    @NonNull
    public static ByteBuffer mapFile(@NonNull File file, long j, @NonNull ByteOrder byteOrder) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, j, file.length() - j);
            map.order(byteOrder);
            return map;
        } finally {
            fileInputStream.close();
        }
    }

    public static void putString(@NonNull ByteBuffer byteBuffer, @NonNull String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            byteBuffer.putChar(str.charAt(i2));
        }
    }
}
