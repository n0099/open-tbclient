package c.a.p0.a.f2;

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
    public String f5302b;

    /* renamed from: c  reason: collision with root package name */
    public String f5303c;

    /* renamed from: d  reason: collision with root package name */
    public String f5304d;

    /* renamed from: e  reason: collision with root package name */
    public long f5305e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5306f;

    /* renamed from: g  reason: collision with root package name */
    public long f5307g;

    /* renamed from: h  reason: collision with root package name */
    public long f5308h;

    /* renamed from: i  reason: collision with root package name */
    public int f5309i;

    /* renamed from: c.a.p0.a.f2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0290a implements Comparator<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0290a() {
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
                int length = aVar2.f5302b.length() - aVar.f5302b.length();
                if (length != 0) {
                    return length;
                }
                int length2 = aVar2.a.length() - aVar.a.length();
                if (length2 != 0) {
                    return length2;
                }
                int hashCode = aVar2.f5303c.hashCode() - aVar.f5303c.hashCode();
                if (hashCode != 0) {
                    return hashCode;
                }
                if (aVar2.f5304d == null) {
                    return -1;
                }
                return aVar.f5304d == null ? 1 : 0;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f5302b) || TextUtils.isEmpty(this.f5303c) || !TextUtils.equals(this.a, aVar.a) || !TextUtils.equals(this.f5302b, aVar.f5302b) || !TextUtils.equals(this.f5303c, aVar.f5303c)) ? false : true : invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f5302b) || !str.startsWith(this.f5302b)) {
                return false;
            }
            int length = this.f5302b.length();
            return this.f5302b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "domain: " + this.a + "; path: " + this.f5302b + "; name: " + this.f5303c + "; value: " + this.f5304d + "; expires: " + this.f5305e + "; secure: " + this.f5306f;
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
        this.f5302b = str2;
        this.f5305e = -1L;
    }
}
