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
public class f extends b.a.e.l.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f19905f;

    /* renamed from: g  reason: collision with root package name */
    public b f19906g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f19907h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f19908i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f19909e;

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
            this.f19909e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f19909e.f19905f.getContext());
                if (this.f19909e.f19906g != null) {
                    this.f19909e.f19906g.resetLoadMoreFlag(true);
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
        this.f19908i = new a(this);
        this.f19905f = baseFragment;
        this.f19906g = bVar;
    }

    @Override // b.a.e.l.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f19905f.getContext()).inflate(b.a.r0.k2.j.login_see_more_layout, (ViewGroup) null);
            this.f2424e = inflate;
            this.f19907h = (TBSpecificationBtn) inflate.findViewById(b.a.r0.k2.i.login_button);
            b.a.q0.s.g0.n.a aVar = new b.a.q0.s.g0.n.a();
            BaseFragment baseFragment = this.f19905f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f19907h.setText(this.f19905f.getContext().getResources().getString(l.login_see_more));
            }
            this.f19907h.setTextSize(b.a.r0.k2.g.tbds42);
            this.f19907h.setConfig(aVar);
            this.f19907h.setOnClickListener(this.f19908i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f2424e;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.e.l.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            b.a.q0.w0.a.a(this.f19905f.getPageContext(), this.f2424e);
            TBSpecificationBtn tBSpecificationBtn = this.f19907h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2424e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f19907h.setOnClickListener(onClickListener);
        }
    }
}
