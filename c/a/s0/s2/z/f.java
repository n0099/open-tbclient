package c.a.s0.s2.z;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.s0.s2.l;
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
public class f extends c.a.d.m.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f23571f;

    /* renamed from: g  reason: collision with root package name */
    public b f23572g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f23573h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f23574i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23575e;

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
            this.f23575e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f23575e.f23571f.getContext());
                if (this.f23575e.f23572g != null) {
                    this.f23575e.f23572g.resetLoadMoreFlag(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void resetLoadMoreFlag(boolean z);
    }

    public f(BaseFragment baseFragment, b bVar) {
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
        this.f23574i = new a(this);
        this.f23571f = baseFragment;
        this.f23572g = bVar;
    }

    @Override // c.a.d.m.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f23571f.getContext()).inflate(c.a.s0.s2.j.login_see_more_layout, (ViewGroup) null);
            this.f2878e = inflate;
            this.f23573h = (TBSpecificationBtn) inflate.findViewById(c.a.s0.s2.i.login_button);
            c.a.r0.s.i0.n.a aVar = new c.a.r0.s.i0.n.a();
            BaseFragment baseFragment = this.f23571f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f23573h.setText(this.f23571f.getContext().getResources().getString(l.login_see_more));
            }
            this.f23573h.setTextSize(c.a.s0.s2.g.tbds42);
            this.f23573h.setConfig(aVar);
            this.f23573h.setOnClickListener(this.f23574i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f2878e;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.m.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c.a.r0.w0.a.a(this.f23571f.getPageContext(), this.f2878e);
            TBSpecificationBtn tBSpecificationBtn = this.f23573h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2878e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f23573h.setOnClickListener(onClickListener);
        }
    }
}
