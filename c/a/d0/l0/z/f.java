package c.a.d0.l0.z;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d0.j.f.i;
import c.a.d0.j.f.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends c.a.d0.l0.z.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f3060f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f3061g;

    /* renamed from: h  reason: collision with root package name */
    public final i<?> f3062h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d0.j.f.d f3063i;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f3064e;

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
            this.f3064e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3064e.f3063i == null) {
                return;
            }
            this.f3064e.f3063i.o();
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f3065b;

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
            this.f3065b = fVar;
            this.a = adBaseModel;
        }

        @Override // c.a.d0.j.f.j
        public void a(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                f fVar = this.f3065b;
                if (fVar.f3050e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f3065b.f3050e.e(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void b(c.a.d0.j.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                f fVar = this.f3065b;
                if (fVar.f3050e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f3065b.f3050e.c(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void c(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                f fVar = this.f3065b;
                if (fVar.f3050e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f3065b.f3050e.a(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void d(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                f fVar = this.f3065b;
                if (fVar.f3050e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f3065b.f3050e.c(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void e(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                f fVar = this.f3065b;
                if (fVar.f3050e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f3065b.f3050e.a(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void f(c.a.d0.j.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                f fVar = this.f3065b;
                if (fVar.f3050e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f3065b.f3050e.g(this.a, f2);
            }
        }

        @Override // c.a.d0.j.f.j
        public void g(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                f fVar = this.f3065b;
                if (fVar.f3050e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f3065b.f3050e.b(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void h(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                f fVar = this.f3065b;
                if (fVar.f3050e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f3065b.f3050e.f(this.a);
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
        this.f3060f = (TextView) a(c.a.d0.d.e.feed_ad_operate_download_app_name);
        this.f3061g = (RelativeLayout) a(c.a.d0.d.e.nad_feed_ad_operate_progress_button);
        view.setBackgroundColor(0);
        this.f3062h = c.a.d0.j.j.c.a(this.f3061g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.f3061g.setOnClickListener(new a(this));
        m();
    }

    @Override // c.a.d0.l0.z.b
    public void e() {
        c.a.d0.j.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f3063i) == null) {
            return;
        }
        dVar.m();
        this.f3063i = null;
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f3060f) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(c.a.d0.d.b.NAD_FC1));
    }

    public final boolean n(c.a.d0.j.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.d0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.l) == null || !TextUtils.equals(aVar.f2802g, cVar.f3076c) || !TextUtils.equals(aVar.d(), cVar.f3077d)) ? false : true : invokeLL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || this.f3060f == null) {
            return;
        }
        this.f3060f.setTextColor(getResources().getColor(adBaseModel.f37254b ? c.a.d0.d.b.NAD_FC4 : c.a.d0.d.b.NAD_FC1));
    }

    @Override // c.a.d0.l0.z.b
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (c.a.d0.l0.z.b.c(adBaseModel) && adBaseModel.f37260h != null) {
                m();
                String str = adBaseModel.f37260h.f37263b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f3060f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f37258f.f3093d)) {
                    return;
                }
                this.f3063i = new c.a.d0.j.f.d(c.a.d0.j.d.a.b(adBaseModel), this.f3062h);
                c.a.d0.l0.x.a aVar = this.f3050e;
                if (aVar != null) {
                    aVar.d(adBaseModel);
                }
                this.f3063i.q(new b(this, adBaseModel));
                return;
            }
            i(8);
        }
    }
}
