package c.a.o0.a.l2;

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

    /* renamed from: a  reason: collision with root package name */
    public String f7231a;

    /* renamed from: b  reason: collision with root package name */
    public String f7232b;

    /* renamed from: c  reason: collision with root package name */
    public String f7233c;

    /* renamed from: d  reason: collision with root package name */
    public String f7234d;

    /* renamed from: e  reason: collision with root package name */
    public long f7235e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7236f;

    /* renamed from: g  reason: collision with root package name */
    public long f7237g;

    /* renamed from: h  reason: collision with root package name */
    public long f7238h;

    /* renamed from: i  reason: collision with root package name */
    public int f7239i;

    /* renamed from: c.a.o0.a.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0283a implements Comparator<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0283a() {
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
                int length = aVar2.f7232b.length() - aVar.f7232b.length();
                if (length != 0) {
                    return length;
                }
                int length2 = aVar2.f7231a.length() - aVar.f7231a.length();
                if (length2 != 0) {
                    return length2;
                }
                int hashCode = aVar2.f7233c.hashCode() - aVar.f7233c.hashCode();
                if (hashCode != 0) {
                    return hashCode;
                }
                if (aVar2.f7234d == null) {
                    return -1;
                }
                return aVar.f7234d == null ? 1 : 0;
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
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f7231a)) {
                if (!this.f7231a.startsWith(".")) {
                    return str.equals(this.f7231a);
                }
                if (str.endsWith(this.f7231a.substring(1))) {
                    int length = this.f7231a.length();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(this.f7231a) || TextUtils.isEmpty(this.f7232b) || TextUtils.isEmpty(this.f7233c) || !TextUtils.equals(this.f7231a, aVar.f7231a) || !TextUtils.equals(this.f7232b, aVar.f7232b) || !TextUtils.equals(this.f7233c, aVar.f7233c)) ? false : true : invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f7232b) || !str.startsWith(this.f7232b)) {
                return false;
            }
            int length = this.f7232b.length();
            return this.f7232b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "domain: " + this.f7231a + "; path: " + this.f7232b + "; name: " + this.f7233c + "; value: " + this.f7234d + "; expires: " + this.f7235e + "; secure: " + this.f7236f;
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
        this.f7231a = str;
        this.f7232b = str2;
        this.f7235e = -1L;
    }
}
