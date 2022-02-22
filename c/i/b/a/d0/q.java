package c.i.b.a.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes9.dex */
public interface q {

    /* loaded from: classes9.dex */
    public static class a implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f29364b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            this(i2, new Random());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (Random) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static int[] e(int i2, Random random) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, random)) == null) {
                int[] iArr = new int[i2];
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = i3 + 1;
                    int nextInt = random.nextInt(i4);
                    iArr[i3] = iArr[nextInt];
                    iArr[nextInt] = i3;
                    i3 = i4;
                }
                return iArr;
            }
            return (int[]) invokeIL.objValue;
        }

        @Override // c.i.b.a.d0.q
        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                int i3 = this.f29364b[i2] - 1;
                if (i3 >= 0) {
                    return this.a[i3];
                }
                return -1;
            }
            return invokeI.intValue;
        }

        @Override // c.i.b.a.d0.q
        public int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int i3 = this.f29364b[i2] + 1;
                int[] iArr = this.a;
                if (i3 < iArr.length) {
                    return iArr[i3];
                }
                return -1;
            }
            return invokeI.intValue;
        }

        @Override // c.i.b.a.d0.q
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int[] iArr = this.a;
                if (iArr.length > 0) {
                    return iArr[iArr.length - 1];
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // c.i.b.a.d0.q
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int[] iArr = this.a;
                if (iArr.length > 0) {
                    return iArr[0];
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // c.i.b.a.d0.q
        public int getLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.length : invokeV.intValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(int i2, Random random) {
            this(e(i2, random), random);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), random};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((int[]) objArr2[0], (Random) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public a(int[] iArr, Random random) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, random};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.a = iArr;
            this.f29364b = new int[iArr.length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                this.f29364b[iArr[i4]] = i4;
            }
        }
    }

    int a(int i2);

    int b(int i2);

    int c();

    int d();

    int getLength();
}
