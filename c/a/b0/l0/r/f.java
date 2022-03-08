package c.a.b0.l0.r;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.b0.j.f.i;
import c.a.b0.j.f.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends c.a.b0.l0.r.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f1875f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f1876g;

    /* renamed from: h  reason: collision with root package name */
    public final i<?> f1877h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.b0.j.f.d f1878i;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f1879e;

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
            this.f1879e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f1879e.f1878i == null) {
                return;
            }
            this.f1879e.f1878i.o();
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f1880b;

        public b(f fVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1880b = fVar;
            this.a = adBaseModel;
        }

        @Override // c.a.b0.j.f.j
        public void a(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                f fVar = this.f1880b;
                if (fVar.f1865e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1880b.f1865e.e(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void b(c.a.b0.j.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                f fVar = this.f1880b;
                if (fVar.f1865e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1880b.f1865e.c(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void c(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                f fVar = this.f1880b;
                if (fVar.f1865e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1880b.f1865e.a(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void d(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                f fVar = this.f1880b;
                if (fVar.f1865e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1880b.f1865e.c(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void e(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                f fVar = this.f1880b;
                if (fVar.f1865e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1880b.f1865e.a(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void f(c.a.b0.j.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                f fVar = this.f1880b;
                if (fVar.f1865e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1880b.f1865e.g(this.a, f2);
            }
        }

        @Override // c.a.b0.j.f.j
        public void g(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                f fVar = this.f1880b;
                if (fVar.f1865e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1880b.f1865e.b(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void h(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                f fVar = this.f1880b;
                if (fVar.f1865e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1880b.f1865e.f(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i2, View view) {
        super(i2, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1875f = (TextView) a(R.id.feed_ad_operate_download_app_name);
        this.f1876g = (RelativeLayout) a(R.id.nad_feed_ad_operate_progress_button);
        view.setBackgroundColor(0);
        this.f1877h = c.a.b0.j.j.c.a(this.f1876g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.f1876g.setOnClickListener(new a(this));
        m();
    }

    @Override // c.a.b0.l0.r.b
    public void e() {
        c.a.b0.j.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f1878i) == null) {
            return;
        }
        dVar.m();
        this.f1878i = null;
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f1875f) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.NAD_FC1));
    }

    public final boolean n(c.a.b0.j.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.b0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.l) == null || !TextUtils.equals(aVar.f1617g, cVar.f1906c) || !TextUtils.equals(aVar.d(), cVar.f1907d)) ? false : true : invokeLL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || this.f1875f == null) {
            return;
        }
        this.f1875f.setTextColor(getResources().getColor(adBaseModel.f35657b ? R.color.NAD_FC4 : R.color.NAD_FC1));
    }

    @Override // c.a.b0.l0.r.b
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (c.a.b0.l0.r.b.c(adBaseModel) && adBaseModel.f35663h != null) {
                m();
                String str = adBaseModel.f35663h.f35666b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f1875f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f35661f.f1923d)) {
                    return;
                }
                this.f1878i = new c.a.b0.j.f.d(c.a.b0.j.d.a.b(adBaseModel), this.f1877h);
                c.a.b0.l0.p.a aVar = this.f1865e;
                if (aVar != null) {
                    aVar.d(adBaseModel);
                }
                this.f1878i.q(new b(this, adBaseModel));
                return;
            }
            i(8);
        }
    }
}
