package c.a.u0.u2.z;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.u0.u2.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g extends c.a.d.o.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f24189f;

    /* renamed from: g  reason: collision with root package name */
    public b f24190g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f24191h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f24192i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24193e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24193e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f24193e.f24189f.getContext());
                if (this.f24193e.f24190g != null) {
                    this.f24193e.f24190g.resetLoadMoreFlag(true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void resetLoadMoreFlag(boolean z);
    }

    public g(BaseFragment baseFragment, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24192i = new a(this);
        this.f24189f = baseFragment;
        this.f24190g = bVar;
    }

    @Override // c.a.d.o.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f24189f.getContext()).inflate(c.a.u0.u2.j.login_see_more_layout, (ViewGroup) null);
            this.f2453e = inflate;
            this.f24191h = (TBSpecificationBtn) inflate.findViewById(c.a.u0.u2.i.login_button);
            c.a.t0.s.l0.n.a aVar = new c.a.t0.s.l0.n.a();
            BaseFragment baseFragment = this.f24189f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f24191h.setText(this.f24189f.getContext().getResources().getString(l.login_see_more));
            }
            this.f24191h.setTextSize(c.a.u0.u2.g.tbds42);
            this.f24191h.setConfig(aVar);
            this.f24191h.setOnClickListener(this.f24192i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f2453e;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.o.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c.a.t0.x0.a.a(this.f24189f.getPageContext(), this.f2453e);
            TBSpecificationBtn tBSpecificationBtn = this.f24191h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2453e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f24191h.setOnClickListener(onClickListener);
        }
    }
}
