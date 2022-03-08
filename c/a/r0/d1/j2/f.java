package c.a.r0.d1.j2;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.y3.m;
import c.a.r0.y3.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15753b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f15754c;

    /* renamed from: d  reason: collision with root package name */
    public h f15755d;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof y) || this.a.f15754c.getErrorCode() != 0) {
                    if (AntiHelper.m(this.a.f15754c.getErrorCode(), this.a.f15754c.getErrorString())) {
                        AntiHelper.u(this.a.a.getPageActivity(), this.a.f15754c.getErrorString());
                    } else {
                        this.a.a.showToast(this.a.f15754c.getErrorString());
                    }
                } else if (this.a.f15755d != null) {
                    this.a.f15755d.a();
                }
            }
        }
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f15753b = str;
    }

    public void d() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (likeModel = this.f15754c) == null) {
            return;
        }
        likeModel.J();
    }

    public final void e(m mVar, int i2, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, i2, hVar) == null) || this.a == null || mVar == null) {
            return;
        }
        this.f15755d = hVar;
        if (this.f15754c == null) {
            f();
        }
        if (this.f15754c.L()) {
            TbPageContext<?> tbPageContext = this.a;
            tbPageContext.showToast(tbPageContext.getString(R.string.Waiting));
            return;
        }
        this.f15754c.N(mVar.f25083g, mVar.f25081e);
        k(i2 + 1);
    }

    public final void f() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f15754c = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
    }

    public void g(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mVar) == null) || this.a == null || mVar == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(mVar.f25083g, null)));
        j();
    }

    public void h(m mVar, int i2, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, mVar, i2, hVar) == null) || mVar == null || mVar.f25085i) {
            return;
        }
        e(mVar, i2, hVar);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g.a(3, -1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g.a(2, -1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            g.a(1, i2);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            g.b(this.f15753b, i2);
        }
    }
}
