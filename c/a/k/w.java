package c.a.k;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.k.w0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class w extends c.a.k.a<c.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public MultiImgLayout f3590j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.s.q.a f3591k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w a;

        public a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wVar;
        }

        @Override // c.a.k.w0.a.b
        public boolean a(a.C0131a c0131a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0131a)) == null) {
                if (this.a.f3591k != null && this.a.f3591k.getThreadData() != null) {
                    c.a.r0.g0.m.a(this.a.f3591k.getThreadData().g0());
                    c.a.r0.g0.m.l(this.a.f3590j.mTitle, this.a.f3591k.getThreadData().g0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    c.a.r0.g0.m.l(this.a.f3590j.mAbstract, this.a.f3591k.getThreadData().g0(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().f12993g instanceof MultiImgLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().f12993g.getParent() == null) {
            this.f3590j = (MultiImgLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().f12993g;
        } else {
            this.f3590j = new MultiImgLayout(context);
        }
    }

    @Override // c.a.k.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3590j : (View) invokeV.objValue;
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
            this.f3590j.setSubClickListener(d0Var);
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            if (this.l != i2) {
                SkinManager.setBackgroundResource(f(), R.drawable.addresslist_item_bg);
                this.f3590j.mImageGroup.onChangeSkinType();
            }
            this.l = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.k.p
    /* renamed from: p */
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f3591k = aVar;
            this.f3590j.setFrom(this.m);
            this.f3590j.onBindDataToView(aVar);
        }
    }

    public void q(c.a.d.f.k.b<TbImageView> bVar) {
        MultiImgLayout multiImgLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (multiImgLayout = this.f3590j) == null) {
            return;
        }
        multiImgLayout.setConstrainImagePool(bVar);
    }

    public void r(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        MultiImgLayout multiImgLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (multiImgLayout = this.f3590j) == null) {
            return;
        }
        multiImgLayout.setConstrainLayoutPool(bVar);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.m = str;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f3590j.setFromCDN(z);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f3590j.setNeedFrsTabName(z);
        }
    }

    public void v(c.a.d.m.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f3590j.setPreloadSizeReadyCallback(bVar);
        }
    }
}
