package b.a.r0.k2.z;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.k2.l;
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
/* loaded from: classes5.dex */
public class f extends b.a.e.m.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f21442f;

    /* renamed from: g  reason: collision with root package name */
    public b f21443g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f21444h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f21445i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f21446e;

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
            this.f21446e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f21446e.f21442f.getContext());
                if (this.f21446e.f21443g != null) {
                    this.f21446e.f21443g.resetLoadMoreFlag(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.f21445i = new a(this);
        this.f21442f = baseFragment;
        this.f21443g = bVar;
    }

    @Override // b.a.e.m.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f21442f.getContext()).inflate(b.a.r0.k2.j.login_see_more_layout, (ViewGroup) null);
            this.f2426e = inflate;
            this.f21444h = (TBSpecificationBtn) inflate.findViewById(b.a.r0.k2.i.login_button);
            b.a.q0.s.g0.n.a aVar = new b.a.q0.s.g0.n.a();
            BaseFragment baseFragment = this.f21442f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f21444h.setText(this.f21442f.getContext().getResources().getString(l.login_see_more));
            }
            this.f21444h.setTextSize(b.a.r0.k2.g.tbds42);
            this.f21444h.setConfig(aVar);
            this.f21444h.setOnClickListener(this.f21445i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f2426e;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.e.m.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            b.a.q0.v0.a.a(this.f21442f.getPageContext(), this.f2426e);
            TBSpecificationBtn tBSpecificationBtn = this.f21444h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2426e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f21444h.setOnClickListener(onClickListener);
        }
    }
}
