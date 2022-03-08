package c.a.q0.e1.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.e0;
import c.a.q0.r.r.e2;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TiebaPlusInfo f12463b;

    /* renamed from: c  reason: collision with root package name */
    public TiePlusStat.ThreadType f12464c;

    /* renamed from: d  reason: collision with root package name */
    public String f12465d;

    /* renamed from: e  reason: collision with root package name */
    public String f12466e;

    /* renamed from: f  reason: collision with root package name */
    public TiePlusStat.StatType f12467f;

    /* renamed from: g  reason: collision with root package name */
    public TiePlusStat.LandingType f12468g;

    /* renamed from: h  reason: collision with root package name */
    public TiePlusStat.CardBtnType f12469h;

    /* renamed from: i  reason: collision with root package name */
    public TiePlusStat.RichTextType f12470i;

    /* renamed from: j  reason: collision with root package name */
    public e2 f12471j;
    public int k;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(255758068, "Lc/a/q0/e1/p/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(255758068, "Lc/a/q0/e1/p/b$a;");
                    return;
                }
            }
            int[] iArr = new int[TiePlusStat.Locate.values().length];
            a = iArr;
            try {
                iArr[TiePlusStat.Locate.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TiePlusStat.Locate.FRS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TiePlusStat.Locate.PB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TiePlusStat.Locate.PB_COMMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b() {
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
        this.f12469h = null;
        this.f12470i = TiePlusStat.RichTextType.LINK;
        this.k = -1;
    }

    @NonNull
    public static b c(int i2, @NonNull TiebaPlusInfo tiebaPlusInfo, @NonNull e2 e2Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, tiebaPlusInfo, e2Var)) == null) {
            int intValue = tiebaPlusInfo.jump_type.intValue();
            b bVar = new b();
            bVar.a = TiePlusStat.a(tiebaPlusInfo, null);
            bVar.f12468g = TiePlusStat.LandingType.create(intValue);
            bVar.f12470i = TiePlusStat.RichTextType.create(i2);
            bVar.f12469h = TiePlusStat.CardBtnType.create(i2, intValue);
            bVar.f12463b = tiebaPlusInfo;
            bVar.f12464c = TiePlusStat.ThreadType.create(e2Var);
            bVar.f12465d = e2Var.w1();
            bVar.f12466e = String.valueOf(e2Var.U());
            bVar.f12471j = e2Var;
            return bVar;
        }
        return (b) invokeILL.objValue;
    }

    @NonNull
    public b a(@Nullable PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, postData)) == null) ? this : (b) invokeL.objValue;
    }

    public b b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.k = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public TiePlusStat.CardBtnType d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12469h : (TiePlusStat.CardBtnType) invokeV.objValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? String.valueOf(this.f12471j.R()) : (String) invokeV.objValue;
    }

    @NonNull
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e0.c(!TextUtils.isEmpty(this.f12466e));
            return this.f12466e;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.LandingType g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12468g : (TiePlusStat.LandingType) invokeV.objValue;
    }

    public TiePlusStat.RichTextType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12470i : (TiePlusStat.RichTextType) invokeV.objValue;
    }

    public int i(@NonNull TiePlusStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, locate)) == null) {
            int i2 = a.a[locate.ordinal()];
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
            e0.b(this.f12467f);
            return this.f12467f;
        }
        return (TiePlusStat.StatType) invokeV.objValue;
    }

    @NonNull
    public e2 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f12471j : (e2) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.ThreadType l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f12464c : (TiePlusStat.ThreadType) invokeV.objValue;
    }

    @NonNull
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12465d : (String) invokeV.objValue;
    }

    @NonNull
    public TiebaPlusInfo n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f12463b : (TiebaPlusInfo) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : invokeV.intValue;
    }

    public void p(TiePlusStat.RichTextType richTextType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, richTextType) == null) {
            this.f12470i = richTextType;
        }
    }

    public void q(@NonNull TiePlusStat.StatType statType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, statType) == null) {
            this.f12467f = statType;
        }
    }

    public void r(TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tiebaPlusInfo) == null) {
            this.f12463b = tiebaPlusInfo;
        }
    }
}
