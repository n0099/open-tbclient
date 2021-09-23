package c.a.q0.f1.o;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.d0;
import c.a.q0.s.q.d2;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13293a;

    /* renamed from: b  reason: collision with root package name */
    public TiebaPlusInfo f13294b;

    /* renamed from: c  reason: collision with root package name */
    public TiePlusStat.ThreadType f13295c;

    /* renamed from: d  reason: collision with root package name */
    public String f13296d;

    /* renamed from: e  reason: collision with root package name */
    public String f13297e;

    /* renamed from: f  reason: collision with root package name */
    public TiePlusStat.StatType f13298f;

    /* renamed from: g  reason: collision with root package name */
    public TiePlusStat.LandingType f13299g;

    /* renamed from: h  reason: collision with root package name */
    public d2 f13300h;

    /* renamed from: i  reason: collision with root package name */
    public int f13301i;

    /* renamed from: c.a.q0.f1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0660a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13302a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1580355337, "Lc/a/q0/f1/o/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1580355337, "Lc/a/q0/f1/o/a$a;");
                    return;
                }
            }
            int[] iArr = new int[TiePlusStat.Locate.values().length];
            f13302a = iArr;
            try {
                iArr[TiePlusStat.Locate.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13302a[TiePlusStat.Locate.FRS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13302a[TiePlusStat.Locate.PB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13302a[TiePlusStat.Locate.PB_COMMENT.ordinal()] = 4;
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
        this.f13301i = -1;
    }

    @NonNull
    public static a c(int i2, @NonNull TiebaPlusInfo tiebaPlusInfo, @NonNull d2 d2Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, tiebaPlusInfo, d2Var)) == null) {
            a aVar = new a();
            aVar.f13293a = TiePlusStat.a(tiebaPlusInfo, null);
            aVar.f13299g = TiePlusStat.LandingType.create(i2);
            aVar.f13294b = tiebaPlusInfo;
            aVar.f13295c = TiePlusStat.ThreadType.create(d2Var);
            aVar.f13296d = d2Var.s1();
            aVar.f13297e = String.valueOf(d2Var.T());
            aVar.f13300h = d2Var;
            return aVar;
        }
        return (a) invokeILL.objValue;
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
            this.f13301i = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    @NonNull
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.valueOf(this.f13300h.R()) : (String) invokeV.objValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d0.b(!TextUtils.isEmpty(this.f13297e));
            return this.f13297e;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.LandingType f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13299g : (TiePlusStat.LandingType) invokeV.objValue;
    }

    public int g(@NonNull TiePlusStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, locate)) == null) {
            int i2 = C0660a.f13302a[locate.ordinal()];
            if (i2 == 1 || i2 == 2) {
                return i().T1;
            }
            if (i2 == 3 || i2 == 4) {
                return this.f13301i;
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
            d0.a(this.f13298f);
            return this.f13298f;
        }
        return (TiePlusStat.StatType) invokeV.objValue;
    }

    @NonNull
    public d2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13300h : (d2) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.ThreadType j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13295c : (TiePlusStat.ThreadType) invokeV.objValue;
    }

    @NonNull
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f13296d : (String) invokeV.objValue;
    }

    @NonNull
    public TiebaPlusInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f13294b : (TiebaPlusInfo) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f13293a : invokeV.intValue;
    }

    public void n(@NonNull TiePlusStat.StatType statType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, statType) == null) {
            this.f13298f = statType;
        }
    }
}
