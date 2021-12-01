package c.a.r0.q2.z;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.q2.l;
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
/* loaded from: classes6.dex */
public class f extends c.a.d.m.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f22565f;

    /* renamed from: g  reason: collision with root package name */
    public b f22566g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f22567h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f22568i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22569e;

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
            this.f22569e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f22569e.f22565f.getContext());
                if (this.f22569e.f22566g != null) {
                    this.f22569e.f22566g.resetLoadMoreFlag(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f22568i = new a(this);
        this.f22565f = baseFragment;
        this.f22566g = bVar;
    }

    @Override // c.a.d.m.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f22565f.getContext()).inflate(c.a.r0.q2.j.login_see_more_layout, (ViewGroup) null);
            this.f2914e = inflate;
            this.f22567h = (TBSpecificationBtn) inflate.findViewById(c.a.r0.q2.i.login_button);
            c.a.q0.s.g0.n.a aVar = new c.a.q0.s.g0.n.a();
            BaseFragment baseFragment = this.f22565f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f22567h.setText(this.f22565f.getContext().getResources().getString(l.login_see_more));
            }
            this.f22567h.setTextSize(c.a.r0.q2.g.tbds42);
            this.f22567h.setConfig(aVar);
            this.f22567h.setOnClickListener(this.f22568i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f2914e;
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
            c.a.q0.w0.a.a(this.f22565f.getPageContext(), this.f2914e);
            TBSpecificationBtn tBSpecificationBtn = this.f22567h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2914e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f22567h.setOnClickListener(onClickListener);
        }
    }
}
