package c.a.p0.w2.r;

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

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f20546b;

    /* renamed from: c  reason: collision with root package name */
    public b f20547c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f20548d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f20549e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.a.f20546b.getContext());
                if (this.a.f20547c != null) {
                    this.a.f20547c.k0(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void k0(boolean z);
    }

    public g(BaseFragment baseFragment, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20549e = new a(this);
        this.f20546b = baseFragment;
        this.f20547c = bVar;
    }

    @Override // c.a.d.o.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f20546b.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0530, (ViewGroup) null);
            this.a = inflate;
            this.f20548d = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f091337);
            c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
            BaseFragment baseFragment = this.f20546b;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f20548d.setText(this.f20546b.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0a56));
            }
            this.f20548d.setTextSize(R.dimen.tbds42);
            this.f20548d.setConfig(aVar);
            this.f20548d.setOnClickListener(this.f20549e);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.o.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            c.a.o0.w0.a.a(this.f20546b.getPageContext(), this.a);
            TBSpecificationBtn tBSpecificationBtn = this.f20548d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f20548d.setOnClickListener(onClickListener);
        }
    }
}
