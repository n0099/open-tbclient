package c.a.t0.t2.z;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.t0.t2.l;
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
/* loaded from: classes8.dex */
public class g extends c.a.d.n.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f23691f;

    /* renamed from: g  reason: collision with root package name */
    public b f23692g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f23693h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f23694i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f23695e;

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
            this.f23695e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f23695e.f23691f.getContext());
                if (this.f23695e.f23692g != null) {
                    this.f23695e.f23692g.resetLoadMoreFlag(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f23694i = new a(this);
        this.f23691f = baseFragment;
        this.f23692g = bVar;
    }

    @Override // c.a.d.n.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f23691f.getContext()).inflate(c.a.t0.t2.j.login_see_more_layout, (ViewGroup) null);
            this.f3366e = inflate;
            this.f23693h = (TBSpecificationBtn) inflate.findViewById(c.a.t0.t2.i.login_button);
            c.a.s0.s.k0.n.a aVar = new c.a.s0.s.k0.n.a();
            BaseFragment baseFragment = this.f23691f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f23693h.setText(this.f23691f.getContext().getResources().getString(l.login_see_more));
            }
            this.f23693h.setTextSize(c.a.t0.t2.g.tbds42);
            this.f23693h.setConfig(aVar);
            this.f23693h.setOnClickListener(this.f23694i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f3366e;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.n.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c.a.s0.x0.a.a(this.f23691f.getPageContext(), this.f3366e);
            TBSpecificationBtn tBSpecificationBtn = this.f23693h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f3366e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f23693h.setOnClickListener(onClickListener);
        }
    }
}
