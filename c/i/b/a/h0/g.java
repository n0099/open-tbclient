package c.i.b.a.h0;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Uri a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f30587b;

    /* renamed from: c  reason: collision with root package name */
    public final long f30588c;

    /* renamed from: d  reason: collision with root package name */
    public final long f30589d;

    /* renamed from: e  reason: collision with root package name */
    public final long f30590e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30591f;

    /* renamed from: g  reason: collision with root package name */
    public final int f30592g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Uri uri, int i2) {
        this(uri, 0L, -1L, null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), (String) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (this.f30592g & i2) == i2 : invokeI.booleanValue;
    }

    public g b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            long j3 = this.f30590e;
            return c(j2, j3 != -1 ? j3 - j2 : -1L);
        }
        return (g) invokeJ.objValue;
    }

    public g c(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (j2 == 0 && this.f30590e == j3) ? this : new g(this.a, this.f30587b, this.f30588c + j2, this.f30589d + j2, j3, this.f30591f, this.f30592g) : (g) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "DataSpec[" + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + Arrays.toString(this.f30587b) + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f30588c + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f30589d + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f30590e + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f30591f + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f30592g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Uri uri, long j2, long j3, String str) {
        this(uri, j2, j2, j3, str, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, Long.valueOf(j2), Long.valueOf(j3), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Uri uri, long j2, long j3, String str, int i2) {
        this(uri, j2, j2, j3, str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, Long.valueOf(j2), Long.valueOf(j3), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Uri uri, long j2, long j3, long j4, String str, int i2) {
        this(uri, null, j2, j3, j4, str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (byte[]) objArr2[1], ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), (String) objArr2[5], ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public g(Uri uri, byte[] bArr, long j2, long j3, long j4, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, bArr, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        boolean z = true;
        c.i.b.a.i0.a.a(j2 >= 0);
        c.i.b.a.i0.a.a(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z = false;
        }
        c.i.b.a.i0.a.a(z);
        this.a = uri;
        this.f30587b = bArr;
        this.f30588c = j2;
        this.f30589d = j3;
        this.f30590e = j4;
        this.f30591f = str;
        this.f30592g = i2;
    }
}
