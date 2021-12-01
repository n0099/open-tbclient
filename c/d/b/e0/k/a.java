package c.d.b.e0.k;

import c.d.b.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import okio.ByteString;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f28203d;

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f28204e;

    /* renamed from: f  reason: collision with root package name */
    public static final ByteString f28205f;

    /* renamed from: g  reason: collision with root package name */
    public static final ByteString f28206g;

    /* renamed from: h  reason: collision with root package name */
    public static final ByteString f28207h;

    /* renamed from: i  reason: collision with root package name */
    public static final ByteString f28208i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteString a;

    /* renamed from: b  reason: collision with root package name */
    public final ByteString f28209b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28210c;

    /* renamed from: c.d.b.e0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1565a {
        void a(r rVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1090404814, "Lc/d/b/e0/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1090404814, "Lc/d/b/e0/k/a;");
                return;
            }
        }
        f28203d = ByteString.encodeUtf8(":");
        f28204e = ByteString.encodeUtf8(":status");
        f28205f = ByteString.encodeUtf8(":method");
        f28206g = ByteString.encodeUtf8(":path");
        f28207h = ByteString.encodeUtf8(":scheme");
        f28208i = ByteString.encodeUtf8(":authority");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ByteString) objArr2[0], (ByteString) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a.equals(aVar.a) && this.f28209b.equals(aVar.f28209b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.a.hashCode()) * 31) + this.f28209b.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.d.b.e0.e.q("%s: %s", this.a.utf8(), this.f28209b.utf8()) : (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteString, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ByteString) objArr2[0], (ByteString) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public a(ByteString byteString, ByteString byteString2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteString, byteString2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = byteString;
        this.f28209b = byteString2;
        this.f28210c = byteString.size() + 32 + byteString2.size();
    }
}
