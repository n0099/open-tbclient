package b.f.b.a.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ABTestConstants;
import com.dxmpay.apollon.armor.SecurePay;
/* loaded from: classes6.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f30755d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30756a;

    /* renamed from: b  reason: collision with root package name */
    public long f30757b;

    /* renamed from: c  reason: collision with root package name */
    public int f30758c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-948355676, "Lb/f/b/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-948355676, "Lb/f/b/a/b/a;");
                return;
            }
        }
        f30755d = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, 100000000};
    }

    public a(String str, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30756a = str;
        this.f30757b = j;
        this.f30758c = i2;
    }

    public static byte[] c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // b.f.b.a.b.b
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            byte[] bArr = new byte[8];
            long j = this.f30757b;
            for (int i2 = 7; i2 >= 0; i2--) {
                bArr[i2] = (byte) (255 & j);
                j >>= 8;
            }
            SecurePay securePay = SecurePay.getInstance();
            byte[] c2 = c(this.f30756a);
            int[] iArr = f30755d;
            int i3 = this.f30758c;
            return securePay.getDyKey(c2, bArr, iArr[i3], i3);
        }
        return (String) invokeL.objValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f30757b = j;
            String str = "+++++++++HotpToken movingFactor is " + this.f30757b;
        }
    }
}
