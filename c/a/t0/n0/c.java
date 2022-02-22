package c.a.t0.n0;

import android.view.View;
import c.a.d.f.p.n;
import c.a.t0.u.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.view.NovelInfoCardView;
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
    public static c f13337h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13338b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13339c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13340d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13341e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13342f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13343g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(981847992, "Lc/a/t0/n0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(981847992, "Lc/a/t0/n0/c;");
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
        this.f13339c = true;
        this.f13340d = true;
        this.f13341e = true;
        this.f13342f = true;
        this.f13343g = true;
        this.a = n.f(TbadkCoreApplication.getInst(), c.a.u0.a4.e.tbds144);
        this.f13338b = n.i(TbadkCoreApplication.getInst());
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f13337h == null) {
                synchronized (c.class) {
                    if (f13337h == null) {
                        f13337h = new c();
                    }
                }
            }
            return f13337h;
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
            return i2 > 0 && i2 < this.f13338b - this.a;
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
            if (this.f13339c) {
                this.f13339c = false;
                f.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, valueOf, str, str2);
            }
        } else {
            this.f13339c = true;
        }
        if (b(novelInfoCardView)) {
            if (this.f13340d) {
                this.f13340d = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 4, valueOf, str, str2);
            }
        } else {
            this.f13340d = true;
        }
        if (b(novelInfoCardView.getNovelCoverPage())) {
            if (this.f13341e) {
                this.f13341e = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 3, valueOf, str, str2);
            }
        } else {
            this.f13341e = true;
        }
        if (jVar.i()) {
            if (b(novelInfoCardView.getNovelStateButton())) {
                if (this.f13343g) {
                    this.f13343g = false;
                    f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 2, valueOf, str, str2);
                    return;
                }
                return;
            }
            this.f13343g = true;
        } else if (b(novelInfoCardView.getNovelStateButton())) {
            if (this.f13342f) {
                this.f13342f = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 1, valueOf, str, str2);
            }
        } else {
            this.f13342f = true;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f13337h = null;
            this.f13339c = true;
            this.f13340d = true;
            this.f13341e = true;
            this.f13342f = true;
            this.f13343g = true;
        }
    }
}
