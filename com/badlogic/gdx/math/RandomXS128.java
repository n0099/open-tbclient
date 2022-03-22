package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes3.dex */
public class RandomXS128 extends Random {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double NORM_DOUBLE = 1.1102230246251565E-16d;
    public static final double NORM_FLOAT = 5.960464477539063E-8d;
    public transient /* synthetic */ FieldHolder $fh;
    public long seed0;
    public long seed1;

    public RandomXS128() {
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
        setSeed(new Random().nextLong());
    }

    public static final long murmurHash3(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }
        return invokeJ.longValue;
    }

    public long getState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == 0 ? this.seed0 : this.seed1 : invokeI.longValue;
    }

    @Override // java.util.Random
    public final int next(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? (int) (nextLong() & ((1 << i) - 1)) : invokeI.intValue;
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (nextLong() & 1) != 0 : invokeV.booleanValue;
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            int length = bArr.length;
            while (length != 0) {
                int i = length < 8 ? length : 8;
                long nextLong = nextLong();
                while (true) {
                    int i2 = i - 1;
                    if (i != 0) {
                        length--;
                        bArr[length] = (byte) nextLong;
                        nextLong >>= 8;
                        i = i2;
                    }
                }
            }
        }
    }

    @Override // java.util.Random
    public double nextDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (nextLong() >>> 11) * 1.1102230246251565E-16d : invokeV.doubleValue;
    }

    @Override // java.util.Random
    public float nextFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (float) ((nextLong() >>> 40) * 5.960464477539063E-8d) : invokeV.floatValue;
    }

    @Override // java.util.Random
    public int nextInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) nextLong() : invokeV.intValue;
    }

    @Override // java.util.Random
    public long nextLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long j = this.seed0;
            long j2 = this.seed1;
            this.seed0 = j2;
            long j3 = j ^ (j << 23);
            long j4 = ((j3 >>> 17) ^ (j3 ^ j2)) ^ (j2 >>> 26);
            this.seed1 = j4;
            return j4 + j2;
        }
        return invokeV.longValue;
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            if (j == 0) {
                j = Long.MIN_VALUE;
            }
            long murmurHash3 = murmurHash3(j);
            setState(murmurHash3, murmurHash3(murmurHash3));
        }
    }

    public void setState(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.seed0 = j;
            this.seed1 = j2;
        }
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? (int) nextLong(i) : invokeI.intValue;
    }

    public RandomXS128(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setSeed(j);
    }

    public RandomXS128(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setState(j, j2);
    }

    public long nextLong(long j) {
        InterceptResult invokeJ;
        long nextLong;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (j > 0) {
                do {
                    nextLong = nextLong() >>> 1;
                    j2 = nextLong % j;
                } while ((nextLong - j2) + (j - 1) < 0);
                return j2;
            }
            throw new IllegalArgumentException("n must be positive");
        }
        return invokeJ.longValue;
    }
}
