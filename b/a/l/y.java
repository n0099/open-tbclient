package b.a.l;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.l.v0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class y extends b.a.l.a<b.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MutiImgSingleVerticalLayout j;
    public b.a.q0.s.q.a k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f3297a;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3297a = yVar;
        }

        @Override // b.a.l.v0.a.b
        public boolean a(a.C0090a c0090a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0090a)) == null) {
                if (this.f3297a.k != null && this.f3297a.k.getThreadData() != null) {
                    b.a.r0.b0.m.a(this.f3297a.k.getThreadData().f0());
                    y yVar = this.f3297a;
                    b.a.r0.b0.m.l(yVar.j.mTitle, yVar.k.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    y yVar2 = this.f3297a;
                    b.a.r0.b0.m.l(yVar2.j.mAbstract, yVar2.k.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Context context) {
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().f13375i instanceof MutiImgSingleVerticalLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().f13375i.getParent() == null) {
            this.j = (MutiImgSingleVerticalLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().f13375i;
        } else {
            this.j = new MutiImgSingleVerticalLayout(context);
        }
    }

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    @Override // b.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(1, new a(this));
        }
    }

    @Override // b.a.l.a
    public void k(b.a.r0.b0.c0<b.a.q0.s.q.a> c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0Var) == null) {
            this.j.setSubClickListener(c0Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: o */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.k = aVar;
            this.j.setFrom(this.m);
            this.j.onBindDataToView(aVar);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            this.l = i2;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.j.setFromCDN(z);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j.setNeedFrsTabName(z);
        }
    }
}
