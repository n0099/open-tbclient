package c.a.p0.k3;

import android.content.Intent;
import android.net.Uri;
import c.a.d.f.m.g;
import c.a.d.f.p.n;
import c.a.p0.q4.h;
import c.a.p0.y2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f15965c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public e f15966b;

    /* renamed from: c.a.p0.k3.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1195a implements h.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15967b;

        public C1195a(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15967b = aVar;
            this.a = tbPageContext;
        }

        @Override // c.a.p0.q4.h.g
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.f15967b.f15966b == null) {
                return;
            }
            this.f15967b.f15966b.dismiss();
            this.f15967b.f15966b = null;
            this.f15967b.a = i;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.f15967b.a));
            this.f15967b.o(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements h.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15968b;

        public b(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15968b = aVar;
            this.a = tbPageContext;
        }

        @Override // c.a.p0.q4.h.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15968b.f15966b == null) {
                return;
            }
            this.f15968b.f15966b.dismiss();
            this.f15968b.f15966b = null;
            if (this.f15968b.a == 1 || this.f15968b.a == 2) {
                this.f15968b.h(this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.f15968b.i(this.a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.q4.h.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f15966b == null) {
                return;
            }
            this.a.f15966b.dismiss();
            this.a.f15966b = null;
            if (this.a.a != 1 && this.a.a != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f15965c == null) {
                synchronized (a.class) {
                    if (f15965c == null) {
                        f15965c = new a();
                    }
                }
            }
            return f15965c;
        }
        return (a) invokeV.objValue;
    }

    public final void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    public final void i(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + TbadkCoreApplication.getInst().getPackageName()));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                tbPageContext.getContext().startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String version = TbConfig.getVersion();
            if (version.equals(c.a.o0.r.j0.b.k().q("key_rate_version", ""))) {
                return;
            }
            c.a.o0.r.j0.b.k().y("key_rate_version", version);
            c.a.o0.r.j0.b.k().x("key_rate_version_time", new Date().getTime());
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - c.a.o0.r.j0.b.k().m("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
        if (k.h("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        c.a.o0.r.j0.b k2 = c.a.o0.r.j0.b.k();
        k2.u("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
        int l = k.l("key_rate_like_count" + currentAccount, 0) + 1;
        if (l < 3) {
            if (l == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                c.a.o0.r.j0.b k2 = c.a.o0.r.j0.b.k();
                k2.x("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                c.a.o0.r.j0.b k3 = c.a.o0.r.j0.b.k();
                k3.w("key_rate_like_count" + currentAccount, l);
                return;
            }
            c.a.o0.r.j0.b k4 = c.a.o0.r.j0.b.k();
            k4.w("key_rate_like_count" + currentAccount, l);
            return;
        }
        c.a.o0.r.j0.b k5 = c.a.o0.r.j0.b.k();
        if (Long.valueOf(new Date().getTime()).longValue() - k5.m("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            c.a.o0.r.j0.b k6 = c.a.o0.r.j0.b.k();
            k6.w("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        c.a.o0.r.j0.b k7 = c.a.o0.r.j0.b.k();
        k7.w("key_rate_like_count" + currentAccount, 0);
    }

    public void m(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        k(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        h hVar = new h(tbPageContext.getContext());
        hVar.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f0963));
        hVar.n(8);
        hVar.r(0);
        int f2 = n.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702fe);
        int f3 = n.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07023f);
        int f4 = n.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070286);
        hVar.w(R.dimen.obfuscated_res_0x7f0701f9);
        hVar.v(0, f2, 0, f4);
        hVar.p(0, 0, 0, f3);
        hVar.o(true);
        hVar.u(new C1195a(this, tbPageContext));
        e eVar = new e(tbPageContext.getContext(), hVar.j());
        this.f15966b = eVar;
        eVar.a(0.7f);
        g.j(this.f15966b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        h hVar = new h(tbPageContext.getContext());
        int i = this.a;
        if (i != 1 && i != 2) {
            hVar.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07a9));
            cVar = new h.c(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07a7), hVar);
        } else {
            hVar.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f081d));
            cVar = new h.c(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07a4), hVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        hVar.q(this.a);
        hVar.r(0);
        hVar.n(0);
        hVar.o(false);
        n.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702b4);
        int f2 = n.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        n.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702ce);
        hVar.v(0, n.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070269), 0, 0);
        hVar.p(0, f2, 0, f2);
        cVar.h(new b(this, tbPageContext));
        hVar.t(new c(this));
        hVar.s(arrayList);
        e eVar = new e(tbPageContext.getContext(), hVar.j());
        this.f15966b = eVar;
        eVar.a(0.7f);
        g.j(this.f15966b, tbPageContext);
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
