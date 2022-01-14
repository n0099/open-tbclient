package c.a.t0.i3;

import android.content.Intent;
import android.net.Uri;
import c.a.d.f.p.n;
import c.a.t0.n4.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonInfoMoreDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f18172c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public PersonInfoMoreDialog f18173b;

    /* renamed from: c.a.t0.i3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1135a implements g.InterfaceC1243g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f18174b;

        public C1135a(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18174b = aVar;
            this.a = tbPageContext;
        }

        @Override // c.a.t0.n4.g.InterfaceC1243g
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f18174b.f18173b == null) {
                return;
            }
            this.f18174b.f18173b.dismiss();
            this.f18174b.f18173b = null;
            this.f18174b.a = i2;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.f18174b.a));
            this.f18174b.o(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f18175b;

        public b(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18175b = aVar;
            this.a = tbPageContext;
        }

        @Override // c.a.t0.n4.g.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18175b.f18173b == null) {
                return;
            }
            this.f18175b.f18173b.dismiss();
            this.f18175b.f18173b = null;
            if (this.f18175b.a == 1 || this.f18175b.a == 2) {
                this.f18175b.h(this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.f18175b.i(this.a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g.d {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.t0.n4.g.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f18173b == null) {
                return;
            }
            this.a.f18173b.dismiss();
            this.a.f18173b = null;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (f18172c == null) {
                synchronized (a.class) {
                    if (f18172c == null) {
                        f18172c = new a();
                    }
                }
            }
            return f18172c;
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
                intent.addFlags(268435456);
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
            if (version.equals(c.a.s0.s.h0.b.k().q("key_rate_version", ""))) {
                return;
            }
            c.a.s0.s.h0.b.k().y("key_rate_version", version);
            c.a.s0.s.h0.b.k().x("key_rate_version_time", new Date().getTime());
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - c.a.s0.s.h0.b.k().m("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.s0.s.h0.b k = c.a.s0.s.h0.b.k();
        if (k.h("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        c.a.s0.s.h0.b k2 = c.a.s0.s.h0.b.k();
        k2.u("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.s0.s.h0.b k = c.a.s0.s.h0.b.k();
        int l = k.l("key_rate_like_count" + currentAccount, 0) + 1;
        if (l < 3) {
            if (l == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                c.a.s0.s.h0.b k2 = c.a.s0.s.h0.b.k();
                k2.x("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                c.a.s0.s.h0.b k3 = c.a.s0.s.h0.b.k();
                k3.w("key_rate_like_count" + currentAccount, l);
                return;
            }
            c.a.s0.s.h0.b k4 = c.a.s0.s.h0.b.k();
            k4.w("key_rate_like_count" + currentAccount, l);
            return;
        }
        c.a.s0.s.h0.b k5 = c.a.s0.s.h0.b.k();
        if (Long.valueOf(new Date().getTime()).longValue() - k5.m("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            c.a.s0.s.h0.b k6 = c.a.s0.s.h0.b.k();
            k6.w("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        c.a.s0.s.h0.b k7 = c.a.s0.s.h0.b.k();
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
        g gVar = new g(tbPageContext.getContext());
        gVar.x(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        gVar.n(8);
        gVar.r(0);
        int f2 = n.f(tbPageContext.getContext(), R.dimen.ds86);
        int f3 = n.f(tbPageContext.getContext(), R.dimen.ds138);
        int f4 = n.f(tbPageContext.getContext(), R.dimen.ds27);
        gVar.w(R.dimen.ds28);
        gVar.v(0, f2, 0, f4);
        gVar.p(0, 0, 0, f3);
        gVar.o(true);
        gVar.u(new C1135a(this, tbPageContext));
        PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(tbPageContext.getContext(), gVar.j());
        this.f18173b = personInfoMoreDialog;
        personInfoMoreDialog.setWindowDimAmount(0.7f);
        c.a.d.f.m.g.j(this.f18173b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        g gVar = new g(tbPageContext.getContext());
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            gVar.x(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new g.c(tbPageContext.getContext().getString(R.string.go_score), gVar);
        } else {
            gVar.x(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new g.c(tbPageContext.getContext().getString(R.string.go_feedback), gVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        gVar.q(this.a);
        gVar.r(0);
        gVar.n(0);
        gVar.o(false);
        n.f(tbPageContext.getContext(), R.dimen.ds42);
        int f2 = n.f(tbPageContext.getContext(), R.dimen.ds32);
        n.f(tbPageContext.getContext(), R.dimen.ds51);
        gVar.v(0, n.f(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
        gVar.p(0, f2, 0, f2);
        cVar.h(new b(this, tbPageContext));
        gVar.t(new c(this));
        gVar.s(arrayList);
        PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(tbPageContext.getContext(), gVar.j());
        this.f18173b = personInfoMoreDialog;
        personInfoMoreDialog.setWindowDimAmount(0.7f);
        c.a.d.f.m.g.j(this.f18173b, tbPageContext);
        int i3 = this.a;
        if (i3 != 1 && i3 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
