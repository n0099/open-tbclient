package com.baidu.android.ddmlib;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/* loaded from: classes10.dex */
public class ByteBufferUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ByteBufferUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static String getString(@NonNull ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, byteBuffer, i2)) == null) {
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = byteBuffer.getChar();
            }
            return new String(cArr);
        }
        return (String) invokeLI.objValue;
    }

    @NonNull
    public static ByteBuffer mapFile(@NonNull File file, long j2, @NonNull ByteOrder byteOrder) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{file, Long.valueOf(j2), byteOrder})) == null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, j2, file.length() - j2);
                map.order(byteOrder);
                return map;
            } finally {
                fileInputStream.close();
            }
        }
        return (ByteBuffer) invokeCommon.objValue;
    }

    public static void putString(@NonNull ByteBuffer byteBuffer, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, byteBuffer, str) == null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                byteBuffer.putChar(str.charAt(i2));
            }
        }
    }
}
