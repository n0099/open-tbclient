package c.a.s0.n0;

import android.view.View;
import c.a.d.f.p.n;
import c.a.s0.u.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.view.NovelInfoCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static c f13070h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13071b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13072c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13073d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13074e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13075f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13076g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-760962343, "Lc/a/s0/n0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-760962343, "Lc/a/s0/n0/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13072c = true;
        this.f13073d = true;
        this.f13074e = true;
        this.f13075f = true;
        this.f13076g = true;
        this.a = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.f13071b = n.i(TbadkCoreApplication.getInst());
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f13070h == null) {
                synchronized (c.class) {
                    if (f13070h == null) {
                        f13070h = new c();
                    }
                }
            }
            return f13070h;
        }
        return (c) invokeV.objValue;
    }

    public boolean b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            if (view == null) {
                return false;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            return i2 > 0 && i2 < this.f13071b - this.a;
        }
        return invokeL.booleanValue;
    }

    public void c(String str, String str2, j jVar, View view, NovelInfoCardView novelInfoCardView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jVar, view, novelInfoCardView) == null) || jVar == null || view == null || novelInfoCardView == null || novelInfoCardView.getVisibility() != 0) {
            return;
        }
        String valueOf = String.valueOf(jVar.h());
        if (b(view) && view.getVisibility() == 0) {
            if (this.f13072c) {
                this.f13072c = false;
                f.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, valueOf, str, str2);
            }
        } else {
            this.f13072c = true;
        }
        if (b(novelInfoCardView)) {
            if (this.f13073d) {
                this.f13073d = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 4, valueOf, str, str2);
            }
        } else {
            this.f13073d = true;
        }
        if (b(novelInfoCardView.getNovelCoverPage())) {
            if (this.f13074e) {
                this.f13074e = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 3, valueOf, str, str2);
            }
        } else {
            this.f13074e = true;
        }
        if (jVar.i()) {
            if (b(novelInfoCardView.getNovelStateButton())) {
                if (this.f13076g) {
                    this.f13076g = false;
                    f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 2, valueOf, str, str2);
                    return;
                }
                return;
            }
            this.f13076g = true;
        } else if (b(novelInfoCardView.getNovelStateButton())) {
            if (this.f13075f) {
                this.f13075f = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 1, valueOf, str, str2);
            }
        } else {
            this.f13075f = true;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f13070h = null;
            this.f13072c = true;
            this.f13073d = true;
            this.f13074e = true;
            this.f13075f = true;
            this.f13076g = true;
        }
    }
}
