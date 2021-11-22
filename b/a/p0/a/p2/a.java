package b.a.p0.a.p2;

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
    public String f7819a;

    /* renamed from: b  reason: collision with root package name */
    public String f7820b;

    /* renamed from: c  reason: collision with root package name */
    public String f7821c;

    /* renamed from: d  reason: collision with root package name */
    public String f7822d;

    /* renamed from: e  reason: collision with root package name */
    public long f7823e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7824f;

    /* renamed from: g  reason: collision with root package name */
    public long f7825g;

    /* renamed from: h  reason: collision with root package name */
    public long f7826h;

    /* renamed from: i  reason: collision with root package name */
    public int f7827i;

    /* renamed from: b.a.p0.a.p2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0364a implements Comparator<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0364a() {
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
                int length = aVar2.f7820b.length() - aVar.f7820b.length();
                if (length != 0) {
                    return length;
                }
                int length2 = aVar2.f7819a.length() - aVar.f7819a.length();
                if (length2 != 0) {
                    return length2;
                }
                int hashCode = aVar2.f7821c.hashCode() - aVar.f7821c.hashCode();
                if (hashCode != 0) {
                    return hashCode;
                }
                if (aVar2.f7822d == null) {
                    return -1;
                }
                return aVar.f7822d == null ? 1 : 0;
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
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f7819a)) {
                if (!this.f7819a.startsWith(".")) {
                    return str.equals(this.f7819a);
                }
                if (str.endsWith(this.f7819a.substring(1))) {
                    int length = this.f7819a.length();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(this.f7819a) || TextUtils.isEmpty(this.f7820b) || TextUtils.isEmpty(this.f7821c) || !TextUtils.equals(this.f7819a, aVar.f7819a) || !TextUtils.equals(this.f7820b, aVar.f7820b) || !TextUtils.equals(this.f7821c, aVar.f7821c)) ? false : true : invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f7820b) || !str.startsWith(this.f7820b)) {
                return false;
            }
            int length = this.f7820b.length();
            return this.f7820b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "domain: " + this.f7819a + "; path: " + this.f7820b + "; name: " + this.f7821c + "; value: " + this.f7822d + "; expires: " + this.f7823e + "; secure: " + this.f7824f;
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
        this.f7819a = str;
        this.f7820b = str2;
        this.f7823e = -1L;
    }
}
