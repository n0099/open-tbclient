package c.a.c0.h0.e0;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.c0.g.f.i;
import c.a.c0.g.f.j;
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
public class f extends c.a.c0.h0.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f2147f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f2148g;

    /* renamed from: h  reason: collision with root package name */
    public final i<?> f2149h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.c0.g.f.d f2150i;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f2151e;

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
            this.f2151e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f2151e.f2150i == null) {
                return;
            }
            this.f2151e.f2150i.o();
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f2152b;

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
            this.f2152b = fVar;
            this.a = adBaseModel;
        }

        @Override // c.a.c0.g.f.j
        public void a(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                f fVar = this.f2152b;
                if (fVar.f2139e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f2152b.f2139e.e(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void b(c.a.c0.g.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                f fVar = this.f2152b;
                if (fVar.f2139e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f2152b.f2139e.c(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void c(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                f fVar = this.f2152b;
                if (fVar.f2139e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f2152b.f2139e.a(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void d(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                f fVar = this.f2152b;
                if (fVar.f2139e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f2152b.f2139e.c(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void e(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                f fVar = this.f2152b;
                if (fVar.f2139e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f2152b.f2139e.a(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void f(c.a.c0.g.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                f fVar = this.f2152b;
                if (fVar.f2139e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f2152b.f2139e.g(this.a, f2);
            }
        }

        @Override // c.a.c0.g.f.j
        public void g(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                f fVar = this.f2152b;
                if (fVar.f2139e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f2152b.f2139e.b(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void h(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                f fVar = this.f2152b;
                if (fVar.f2139e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f2152b.f2139e.f(this.a);
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
        this.f2147f = (TextView) a(c.a.c0.b.e.feed_ad_operate_download_app_name);
        this.f2148g = (RelativeLayout) a(c.a.c0.b.e.nad_feed_ad_operate_progress_button);
        view.setBackgroundColor(0);
        this.f2149h = c.a.c0.g.j.c.a(this.f2148g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.f2148g.setOnClickListener(new a(this));
        m();
    }

    @Override // c.a.c0.h0.e0.b
    public void e() {
        c.a.c0.g.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f2150i) == null) {
            return;
        }
        dVar.m();
        this.f2150i = null;
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f2147f) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(c.a.c0.b.b.NAD_FC1));
    }

    public final boolean n(c.a.c0.g.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.c0.p.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.f38224i) == null || !TextUtils.equals(aVar.f1944g, cVar.f2213b) || !TextUtils.equals(aVar.d(), cVar.f2214c)) ? false : true : invokeLL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || this.f2147f == null) {
            return;
        }
        this.f2147f.setTextColor(getResources().getColor(adBaseModel.f38217b ? c.a.c0.b.b.NAD_FC4 : c.a.c0.b.b.NAD_FC1));
    }

    @Override // c.a.c0.h0.e0.b
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (c.a.c0.h0.e0.b.c(adBaseModel) && adBaseModel.f38221f != null) {
                m();
                String str = adBaseModel.f38221f.f38227b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f2147f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f38219d.f2227b)) {
                    return;
                }
                this.f2150i = new c.a.c0.g.f.d(c.a.c0.g.d.a.b(adBaseModel), this.f2149h);
                c.a.c0.h0.c0.a aVar = this.f2139e;
                if (aVar != null) {
                    aVar.d(adBaseModel);
                }
                this.f2150i.q(new b(this, adBaseModel));
                return;
            }
            i(8);
        }
    }
}
