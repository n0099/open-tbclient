package c.a.p0.a.l2;

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
    public String f7267a;

    /* renamed from: b  reason: collision with root package name */
    public String f7268b;

    /* renamed from: c  reason: collision with root package name */
    public String f7269c;

    /* renamed from: d  reason: collision with root package name */
    public String f7270d;

    /* renamed from: e  reason: collision with root package name */
    public long f7271e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7272f;

    /* renamed from: g  reason: collision with root package name */
    public long f7273g;

    /* renamed from: h  reason: collision with root package name */
    public long f7274h;

    /* renamed from: i  reason: collision with root package name */
    public int f7275i;

    /* renamed from: c.a.p0.a.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0285a implements Comparator<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0285a() {
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
                int length = aVar2.f7268b.length() - aVar.f7268b.length();
                if (length != 0) {
                    return length;
                }
                int length2 = aVar2.f7267a.length() - aVar.f7267a.length();
                if (length2 != 0) {
                    return length2;
                }
                int hashCode = aVar2.f7269c.hashCode() - aVar.f7269c.hashCode();
                if (hashCode != 0) {
                    return hashCode;
                }
                if (aVar2.f7270d == null) {
                    return -1;
                }
                return aVar.f7270d == null ? 1 : 0;
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
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f7267a)) {
                if (!this.f7267a.startsWith(".")) {
                    return str.equals(this.f7267a);
                }
                if (str.endsWith(this.f7267a.substring(1))) {
                    int length = this.f7267a.length();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(this.f7267a) || TextUtils.isEmpty(this.f7268b) || TextUtils.isEmpty(this.f7269c) || !TextUtils.equals(this.f7267a, aVar.f7267a) || !TextUtils.equals(this.f7268b, aVar.f7268b) || !TextUtils.equals(this.f7269c, aVar.f7269c)) ? false : true : invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f7268b) || !str.startsWith(this.f7268b)) {
                return false;
            }
            int length = this.f7268b.length();
            return this.f7268b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "domain: " + this.f7267a + "; path: " + this.f7268b + "; name: " + this.f7269c + "; value: " + this.f7270d + "; expires: " + this.f7271e + "; secure: " + this.f7272f;
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
        this.f7267a = str;
        this.f7268b = str2;
        this.f7271e = -1L;
    }
}
