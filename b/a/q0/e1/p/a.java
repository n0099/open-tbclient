package b.a.q0.e1.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c1.c0;
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
    public int f13159a;

    /* renamed from: b  reason: collision with root package name */
    public TiebaPlusInfo f13160b;

    /* renamed from: c  reason: collision with root package name */
    public TiePlusStat.ThreadType f13161c;

    /* renamed from: d  reason: collision with root package name */
    public String f13162d;

    /* renamed from: e  reason: collision with root package name */
    public String f13163e;

    /* renamed from: f  reason: collision with root package name */
    public TiePlusStat.StatType f13164f;

    /* renamed from: g  reason: collision with root package name */
    public TiePlusStat.LandingType f13165g;

    /* renamed from: h  reason: collision with root package name */
    public TiePlusStat.CardBtnType f13166h;

    /* renamed from: i  reason: collision with root package name */
    public TiePlusStat.RichTextType f13167i;
    public d2 j;
    public int k;

    /* renamed from: b.a.q0.e1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C0689a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13168a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(766262454, "Lb/a/q0/e1/p/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(766262454, "Lb/a/q0/e1/p/a$a;");
                    return;
                }
            }
            int[] iArr = new int[TiePlusStat.Locate.values().length];
            f13168a = iArr;
            try {
                iArr[TiePlusStat.Locate.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13168a[TiePlusStat.Locate.FRS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13168a[TiePlusStat.Locate.PB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13168a[TiePlusStat.Locate.PB_COMMENT.ordinal()] = 4;
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
        this.f13166h = null;
        this.f13167i = TiePlusStat.RichTextType.LINK;
        this.k = -1;
    }

    @NonNull
    public static a c(int i2, @NonNull TiebaPlusInfo tiebaPlusInfo, @NonNull d2 d2Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, tiebaPlusInfo, d2Var)) == null) {
            int intValue = tiebaPlusInfo.jump_type.intValue();
            a aVar = new a();
            aVar.f13159a = TiePlusStat.a(tiebaPlusInfo, null);
            aVar.f13165g = TiePlusStat.LandingType.create(intValue);
            aVar.f13167i = TiePlusStat.RichTextType.create(i2);
            aVar.f13166h = TiePlusStat.CardBtnType.create(i2, intValue);
            aVar.f13160b = tiebaPlusInfo;
            aVar.f13161c = TiePlusStat.ThreadType.create(d2Var);
            aVar.f13162d = d2Var.t1();
            aVar.f13163e = String.valueOf(d2Var.T());
            aVar.j = d2Var;
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
            this.k = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public TiePlusStat.CardBtnType d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13166h : (TiePlusStat.CardBtnType) invokeV.objValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? String.valueOf(this.j.R()) : (String) invokeV.objValue;
    }

    @NonNull
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c0.c(!TextUtils.isEmpty(this.f13163e));
            return this.f13163e;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.LandingType g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13165g : (TiePlusStat.LandingType) invokeV.objValue;
    }

    public TiePlusStat.RichTextType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13167i : (TiePlusStat.RichTextType) invokeV.objValue;
    }

    public int i(@NonNull TiePlusStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, locate)) == null) {
            int i2 = C0689a.f13168a[locate.ordinal()];
            if (i2 == 1 || i2 == 2) {
                return k().T1;
            }
            if (i2 == 3 || i2 == 4) {
                return this.k;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @NonNull
    public TiePlusStat.StatType j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c0.b(this.f13164f);
            return this.f13164f;
        }
        return (TiePlusStat.StatType) invokeV.objValue;
    }

    @NonNull
    public d2 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (d2) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.ThreadType l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f13161c : (TiePlusStat.ThreadType) invokeV.objValue;
    }

    @NonNull
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f13162d : (String) invokeV.objValue;
    }

    @NonNull
    public TiebaPlusInfo n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f13160b : (TiebaPlusInfo) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f13159a : invokeV.intValue;
    }

    public void p(@NonNull TiePlusStat.StatType statType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, statType) == null) {
            this.f13164f = statType;
        }
    }

    public void q(TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tiebaPlusInfo) == null) {
            this.f13160b = tiebaPlusInfo;
        }
    }
}
