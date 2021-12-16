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
    public final TextView f1720f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f1721g;

    /* renamed from: h  reason: collision with root package name */
    public final i<?> f1722h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.c0.g.f.d f1723i;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f1724e;

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
            this.f1724e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f1724e.f1723i == null) {
                return;
            }
            this.f1724e.f1723i.o();
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f1725b;

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
            this.f1725b = fVar;
            this.a = adBaseModel;
        }

        @Override // c.a.c0.g.f.j
        public void a(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                f fVar = this.f1725b;
                if (fVar.f1712e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1725b.f1712e.e(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void b(c.a.c0.g.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                f fVar = this.f1725b;
                if (fVar.f1712e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1725b.f1712e.c(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void c(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                f fVar = this.f1725b;
                if (fVar.f1712e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1725b.f1712e.a(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void d(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                f fVar = this.f1725b;
                if (fVar.f1712e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1725b.f1712e.c(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void e(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                f fVar = this.f1725b;
                if (fVar.f1712e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1725b.f1712e.a(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void f(c.a.c0.g.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                f fVar = this.f1725b;
                if (fVar.f1712e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1725b.f1712e.g(this.a, f2);
            }
        }

        @Override // c.a.c0.g.f.j
        public void g(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                f fVar = this.f1725b;
                if (fVar.f1712e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1725b.f1712e.b(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void h(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                f fVar = this.f1725b;
                if (fVar.f1712e == null || !fVar.n(aVar, this.a)) {
                    return;
                }
                this.f1725b.f1712e.f(this.a);
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
        this.f1720f = (TextView) a(c.a.c0.b.e.feed_ad_operate_download_app_name);
        this.f1721g = (RelativeLayout) a(c.a.c0.b.e.nad_feed_ad_operate_progress_button);
        view.setBackgroundColor(0);
        this.f1722h = c.a.c0.g.j.c.a(this.f1721g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.f1721g.setOnClickListener(new a(this));
        m();
    }

    @Override // c.a.c0.h0.e0.b
    public void e() {
        c.a.c0.g.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f1723i) == null) {
            return;
        }
        dVar.m();
        this.f1723i = null;
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f1720f) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(c.a.c0.b.b.NAD_FC1));
    }

    public final boolean n(c.a.c0.g.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.c0.p.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.f38068i) == null || !TextUtils.equals(aVar.f1517g, cVar.f1786b) || !TextUtils.equals(aVar.d(), cVar.f1787c)) ? false : true : invokeLL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || this.f1720f == null) {
            return;
        }
        this.f1720f.setTextColor(getResources().getColor(adBaseModel.f38061b ? c.a.c0.b.b.NAD_FC4 : c.a.c0.b.b.NAD_FC1));
    }

    @Override // c.a.c0.h0.e0.b
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (c.a.c0.h0.e0.b.c(adBaseModel) && adBaseModel.f38065f != null) {
                m();
                String str = adBaseModel.f38065f.f38071b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f1720f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f38063d.f1800b)) {
                    return;
                }
                this.f1723i = new c.a.c0.g.f.d(c.a.c0.g.d.a.b(adBaseModel), this.f1722h);
                c.a.c0.h0.c0.a aVar = this.f1712e;
                if (aVar != null) {
                    aVar.d(adBaseModel);
                }
                this.f1723i.q(new b(this, adBaseModel));
                return;
            }
            i(8);
        }
    }
}
