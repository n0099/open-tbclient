package c.a.k;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.k.w0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class z extends c.a.k.a<c.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public MutiImgTextLayout f3597j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.s.q.a f3598k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z a;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zVar;
        }

        @Override // c.a.k.w0.a.b
        public boolean a(a.C0131a c0131a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0131a)) == null) {
                if (this.a.f3598k != null && this.a.f3598k.getThreadData() != null) {
                    c.a.r0.g0.m.a(this.a.f3598k.getThreadData().g0());
                    c.a.r0.g0.m.l(this.a.f3597j.mTitle, this.a.f3598k.getThreadData().g0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    c.a.r0.g0.m.l(this.a.f3597j.mAbstract, this.a.f3598k.getThreadData().g0(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Context context) {
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
        this.l = 3;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().f12994h instanceof MutiImgTextLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().f12994h.getParent() == null) {
            this.f3597j = (MutiImgTextLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().f12994h;
        } else {
            this.f3597j = new MutiImgTextLayout(context);
        }
        this.f3597j.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // c.a.k.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3597j : (View) invokeV.objValue;
    }

    @Override // c.a.k.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(1, new a(this));
        }
    }

    @Override // c.a.k.a
    public void k(c.a.r0.g0.d0<c.a.q0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d0Var) == null) {
            this.f3597j.setSubClickListener(d0Var);
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            this.l = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.k.p
    /* renamed from: p */
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f3598k = aVar;
            this.f3597j.setFrom(this.m);
            this.f3597j.onBindDataToView(aVar);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f3597j.setFromCDN(z);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f3597j.setNeedFrsTabName(z);
        }
    }
}
