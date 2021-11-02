package b.a.l;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.l.v0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class n extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadGodReplyLayout l;
    public b.a.q0.s.q.a m;
    public StatisticItem n;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f3266e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3266e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3266e.c() == null) {
                return;
            }
            this.f3266e.c().a(view, this.f3266e.m);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f3267e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f3268f;

        public b(n nVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3268f = nVar;
            this.f3267e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f3268f.f3216f);
                String s1 = this.f3268f.m.getThreadData().s1();
                PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(s1, this.f3268f.m.getThreadData().v1().G() + "", 1, "other");
                createNormalCfg.setStartFrom(this.f3268f.f3215e.h());
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                this.f3268f.f3215e.n(new a.C0090a(1));
                this.f3267e.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f3269a;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3269a = nVar;
        }

        @Override // b.a.l.v0.a.b
        public boolean a(a.C0090a c0090a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0090a)) == null) {
                b.a.r0.b0.m.l(this.f3269a.l.getGodReplyContent(), this.f3269a.m.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        q(b.a.e.e.p.l.g(context, R.dimen.M_H_X003));
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().r instanceof ThreadGodReplyLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().r.getParent() == null) {
            this.l = (ThreadGodReplyLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().r;
        } else {
            this.l = new ThreadGodReplyLayout(context);
        }
        a aVar = new a(this);
        this.l.setAfterClickListener(aVar);
        this.l.setOnClickListener(new b(this, aVar));
    }

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // b.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(1, new c(this));
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.l.onChangeSkinType();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ThreadGodReplyLayout threadGodReplyLayout = this.l;
            return threadGodReplyLayout == null || threadGodReplyLayout.getVisibility() != 8;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: u */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.m = aVar;
            PostData v1 = aVar.getThreadData().v1();
            if (this.n != null && v1 != null && v1.t() != null && v1.t().getUserId() != null) {
                this.n.param("tid", aVar.getThreadData().E).param("post_id", v1.G()).param("uid", v1.t().getUserId());
                b.a.r0.b0.u.b().a(this.n);
            }
            this.l.setData(aVar.getThreadData());
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l.setFrom(str);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l.setFromCDN(z);
        }
    }

    public void x(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, statisticItem) == null) {
            this.n = statisticItem;
        }
    }
}
