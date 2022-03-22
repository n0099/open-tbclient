package c.a.o0.m0;

import android.view.View;
import c.a.d.f.p.n;
import c.a.o0.t.j;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static c f10435h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10436b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10437c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10438d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10439e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10440f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10441g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(856807388, "Lc/a/o0/m0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(856807388, "Lc/a/o0/m0/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10437c = true;
        this.f10438d = true;
        this.f10439e = true;
        this.f10440f = true;
        this.f10441g = true;
        this.a = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.f10436b = n.i(TbadkCoreApplication.getInst());
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f10435h == null) {
                synchronized (c.class) {
                    if (f10435h == null) {
                        f10435h = new c();
                    }
                }
            }
            return f10435h;
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
            int i = iArr[1];
            return i > 0 && i < this.f10436b - this.a;
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
            if (this.f10437c) {
                this.f10437c = false;
                f.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, valueOf, str, str2);
            }
        } else {
            this.f10437c = true;
        }
        if (b(novelInfoCardView)) {
            if (this.f10438d) {
                this.f10438d = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 4, valueOf, str, str2);
            }
        } else {
            this.f10438d = true;
        }
        if (b(novelInfoCardView.getNovelCoverPage())) {
            if (this.f10439e) {
                this.f10439e = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 3, valueOf, str, str2);
            }
        } else {
            this.f10439e = true;
        }
        if (jVar.i()) {
            if (b(novelInfoCardView.getNovelStateButton())) {
                if (this.f10441g) {
                    this.f10441g = false;
                    f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 2, valueOf, str, str2);
                    return;
                }
                return;
            }
            this.f10441g = true;
        } else if (b(novelInfoCardView.getNovelStateButton())) {
            if (this.f10440f) {
                this.f10440f = false;
                f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 1, valueOf, str, str2);
            }
        } else {
            this.f10440f = true;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f10435h = null;
            this.f10437c = true;
            this.f10438d = true;
            this.f10439e = true;
            this.f10440f = true;
            this.f10441g = true;
        }
    }
}
