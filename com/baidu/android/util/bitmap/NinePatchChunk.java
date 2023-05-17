package com.baidu.android.util.bitmap;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes.dex */
public class NinePatchChunk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] mColor;
    public int[] mDivX;
    public int[] mDivY;
    public Rect mPaddings;

    public NinePatchChunk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPaddings = new Rect();
    }

    public static void checkDivCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            if (i != 0 && (i & 1) == 0) {
                return;
            }
            throw new RuntimeException("invalid nine-patch: " + i);
        }
    }

    public static NinePatchChunk deserialize(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr != null && bArr.length != 0) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                order.get();
                NinePatchChunk ninePatchChunk = new NinePatchChunk();
                ninePatchChunk.mDivX = new int[order.get()];
                ninePatchChunk.mDivY = new int[order.get()];
                ninePatchChunk.mColor = new int[order.get()];
                checkDivCount(ninePatchChunk.mDivX.length);
                checkDivCount(ninePatchChunk.mDivY.length);
                order.getInt();
                order.getInt();
                ninePatchChunk.mPaddings.left = order.getInt();
                ninePatchChunk.mPaddings.right = order.getInt();
                ninePatchChunk.mPaddings.top = order.getInt();
                ninePatchChunk.mPaddings.bottom = order.getInt();
                order.getInt();
                readIntArray(ninePatchChunk.mDivX, order);
                readIntArray(ninePatchChunk.mDivY, order);
                readIntArray(ninePatchChunk.mColor, order);
                return ninePatchChunk;
            }
            return null;
        }
        return (NinePatchChunk) invokeL.objValue;
    }

    public static void readIntArray(int[] iArr, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, iArr, byteBuffer) == null) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = byteBuffer.getInt();
            }
        }
    }
}
