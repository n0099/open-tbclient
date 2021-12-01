package c.a.p0.a.p2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7472b;

    /* renamed from: c  reason: collision with root package name */
    public String f7473c;

    /* renamed from: d  reason: collision with root package name */
    public String f7474d;

    /* renamed from: e  reason: collision with root package name */
    public long f7475e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7476f;

    /* renamed from: g  reason: collision with root package name */
    public long f7477g;

    /* renamed from: h  reason: collision with root package name */
    public long f7478h;

    /* renamed from: i  reason: collision with root package name */
    public int f7479i;

    /* renamed from: c.a.p0.a.p2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0420a implements Comparator<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0420a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) {
                int length = aVar2.f7472b.length() - aVar.f7472b.length();
                if (length != 0) {
                    return length;
                }
                int length2 = aVar2.a.length() - aVar.a.length();
                if (length2 != 0) {
                    return length2;
                }
                int hashCode = aVar2.f7473c.hashCode() - aVar.f7473c.hashCode();
                if (hashCode != 0) {
                    return hashCode;
                }
                if (aVar2.f7474d == null) {
                    return -1;
                }
                return aVar.f7474d == null ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    public a() {
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

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a)) {
                if (!this.a.startsWith(".")) {
                    return str.equals(this.a);
                }
                if (str.endsWith(this.a.substring(1))) {
                    int length = this.a.length();
                    int length2 = str.length();
                    return length2 <= length + (-1) || str.charAt(length2 - length) == '.';
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f7472b) || TextUtils.isEmpty(this.f7473c) || !TextUtils.equals(this.a, aVar.a) || !TextUtils.equals(this.f7472b, aVar.f7472b) || !TextUtils.equals(this.f7473c, aVar.f7473c)) ? false : true : invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f7472b) || !str.startsWith(this.f7472b)) {
                return false;
            }
            int length = this.f7472b.length();
            return this.f7472b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "domain: " + this.a + "; path: " + this.f7472b + "; name: " + this.f7473c + "; value: " + this.f7474d + "; expires: " + this.f7475e + "; secure: " + this.f7476f;
        }
        return (String) invokeV.objValue;
    }

    public a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f7472b = str2;
        this.f7475e = -1L;
    }
}
