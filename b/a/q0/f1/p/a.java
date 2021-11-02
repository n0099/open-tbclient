package b.a.q0.f1.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.c0;
import b.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TiebaPlusInfo;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12451a;

    /* renamed from: b  reason: collision with root package name */
    public TiebaPlusInfo f12452b;

    /* renamed from: c  reason: collision with root package name */
    public TiePlusStat.ThreadType f12453c;

    /* renamed from: d  reason: collision with root package name */
    public String f12454d;

    /* renamed from: e  reason: collision with root package name */
    public String f12455e;

    /* renamed from: f  reason: collision with root package name */
    public TiePlusStat.StatType f12456f;

    /* renamed from: g  reason: collision with root package name */
    public TiePlusStat.LandingType f12457g;

    /* renamed from: h  reason: collision with root package name */
    public d2 f12458h;

    /* renamed from: i  reason: collision with root package name */
    public int f12459i;

    /* renamed from: b.a.q0.f1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C0656a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12460a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1041192009, "Lb/a/q0/f1/p/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1041192009, "Lb/a/q0/f1/p/a$a;");
                    return;
                }
            }
            int[] iArr = new int[TiePlusStat.Locate.values().length];
            f12460a = iArr;
            try {
                iArr[TiePlusStat.Locate.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12460a[TiePlusStat.Locate.FRS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12460a[TiePlusStat.Locate.PB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12460a[TiePlusStat.Locate.PB_COMMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
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
                return;
            }
        }
        this.f12459i = -1;
    }

    @NonNull
    public static a c(@NonNull TiebaPlusInfo tiebaPlusInfo, @NonNull d2 d2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tiebaPlusInfo, d2Var)) == null) {
            int intValue = tiebaPlusInfo.jump_type.intValue();
            a aVar = new a();
            aVar.f12451a = TiePlusStat.a(tiebaPlusInfo, null);
            aVar.f12457g = TiePlusStat.LandingType.create(intValue);
            aVar.f12452b = tiebaPlusInfo;
            aVar.f12453c = TiePlusStat.ThreadType.create(d2Var);
            aVar.f12454d = d2Var.s1();
            aVar.f12455e = String.valueOf(d2Var.T());
            aVar.f12458h = d2Var;
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    @NonNull
    public a a(@Nullable PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, postData)) == null) ? this : (a) invokeL.objValue;
    }

    public a b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f12459i = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    @NonNull
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.valueOf(this.f12458h.R()) : (String) invokeV.objValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c0.c(!TextUtils.isEmpty(this.f12455e));
            return this.f12455e;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.LandingType f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12457g : (TiePlusStat.LandingType) invokeV.objValue;
    }

    public int g(@NonNull TiePlusStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, locate)) == null) {
            int i2 = C0656a.f12460a[locate.ordinal()];
            if (i2 == 1 || i2 == 2) {
                return i().T1;
            }
            if (i2 == 3 || i2 == 4) {
                return this.f12459i;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @NonNull
    public TiePlusStat.StatType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c0.b(this.f12456f);
            return this.f12456f;
        }
        return (TiePlusStat.StatType) invokeV.objValue;
    }

    @NonNull
    public d2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12458h : (d2) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.ThreadType j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12453c : (TiePlusStat.ThreadType) invokeV.objValue;
    }

    @NonNull
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f12454d : (String) invokeV.objValue;
    }

    @NonNull
    public TiebaPlusInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f12452b : (TiebaPlusInfo) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12451a : invokeV.intValue;
    }

    public void n(@NonNull TiePlusStat.StatType statType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, statType) == null) {
            this.f12456f = statType;
        }
    }
}
