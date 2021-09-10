package c.a.r0.j2.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g extends c.a.e.l.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f20746f;

    /* renamed from: g  reason: collision with root package name */
    public b f20747g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f20748h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f20749i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20750e;

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
            this.f20750e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f20750e.f20746f.getContext());
                if (this.f20750e.f20747g != null) {
                    this.f20750e.f20747g.resetLoadMoreFlag(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f20749i = new a(this);
        this.f20746f = baseFragment;
        this.f20747g = bVar;
    }

    @Override // c.a.e.l.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f20746f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
            this.f2963e = inflate;
            this.f20748h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
            c.a.q0.s.f0.n.a aVar = new c.a.q0.s.f0.n.a();
            BaseFragment baseFragment = this.f20746f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f20748h.setText(this.f20746f.getContext().getResources().getString(R.string.login_see_more));
            }
            this.f20748h.setTextSize(R.dimen.tbds42);
            this.f20748h.setConfig(aVar);
            this.f20748h.setOnClickListener(this.f20749i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f2963e;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.e.l.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c.a.q0.w0.a.a(this.f20746f.getPageContext(), this.f2963e);
            TBSpecificationBtn tBSpecificationBtn = this.f20748h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2963e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f20748h.setOnClickListener(onClickListener);
        }
    }
}
