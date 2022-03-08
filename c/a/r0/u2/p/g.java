package c.a.r0.u2.p;

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
public class g extends c.a.d.o.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f24104f;

    /* renamed from: g  reason: collision with root package name */
    public b f24105g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f24106h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f24107i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24108e;

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
            this.f24108e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f24108e.f24104f.getContext());
                if (this.f24108e.f24105g != null) {
                    this.f24108e.f24105g.resetLoadMoreFlag(true);
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
        this.f24107i = new a(this);
        this.f24104f = baseFragment;
        this.f24105g = bVar;
    }

    @Override // c.a.d.o.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f24104f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
            this.f3082e = inflate;
            this.f24106h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
            c.a.q0.r.l0.n.a aVar = new c.a.q0.r.l0.n.a();
            BaseFragment baseFragment = this.f24104f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f24106h.setText(this.f24104f.getContext().getResources().getString(R.string.login_see_more));
            }
            this.f24106h.setTextSize(R.dimen.tbds42);
            this.f24106h.setConfig(aVar);
            this.f24106h.setOnClickListener(this.f24107i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f3082e;
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
            c.a.q0.w0.a.a(this.f24104f.getPageContext(), this.f3082e);
            TBSpecificationBtn tBSpecificationBtn = this.f24106h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f3082e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f24106h.setOnClickListener(onClickListener);
        }
    }
}
