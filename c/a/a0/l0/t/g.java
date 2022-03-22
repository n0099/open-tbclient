package c.a.a0.l0.t;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.a0.j.f.i;
import c.a.a0.j.f.j;
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
public class g extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f1507f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f1508g;

    /* renamed from: h  reason: collision with root package name */
    public final i<?> f1509h;
    public c.a.a0.j.f.d i;

    /* loaded from: classes.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.i == null) {
                return;
            }
            this.a.i.p();
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f1510b;

        public b(g gVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1510b = gVar;
            this.a = adBaseModel;
        }

        @Override // c.a.a0.j.f.j
        public void a(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                g gVar = this.f1510b;
                if (gVar.f1500e == null || !gVar.n(aVar, this.a)) {
                    return;
                }
                this.f1510b.f1500e.e(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void b(c.a.a0.j.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                g gVar = this.f1510b;
                if (gVar.f1500e == null || !gVar.n(aVar, this.a)) {
                    return;
                }
                this.f1510b.f1500e.c(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void c(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                g gVar = this.f1510b;
                if (gVar.f1500e == null || !gVar.n(aVar, this.a)) {
                    return;
                }
                this.f1510b.f1500e.a(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void d(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                g gVar = this.f1510b;
                if (gVar.f1500e == null || !gVar.n(aVar, this.a)) {
                    return;
                }
                this.f1510b.f1500e.c(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void e(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                g gVar = this.f1510b;
                if (gVar.f1500e == null || !gVar.n(aVar, this.a)) {
                    return;
                }
                this.f1510b.f1500e.a(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void f(c.a.a0.j.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                g gVar = this.f1510b;
                if (gVar.f1500e == null || !gVar.n(aVar, this.a)) {
                    return;
                }
                this.f1510b.f1500e.g(this.a, f2);
            }
        }

        @Override // c.a.a0.j.f.j
        public void g(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                g gVar = this.f1510b;
                if (gVar.f1500e == null || !gVar.n(aVar, this.a)) {
                    return;
                }
                this.f1510b.f1500e.b(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void h(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                g gVar = this.f1510b;
                if (gVar.f1500e == null || !gVar.n(aVar, this.a)) {
                    return;
                }
                this.f1510b.f1500e.f(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i, View view) {
        super(i, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1507f = (TextView) a(R.id.obfuscated_res_0x7f090981);
        this.f1508g = (RelativeLayout) a(R.id.obfuscated_res_0x7f0914ba);
        view.setBackgroundColor(0);
        this.f1509h = c.a.a0.j.j.c.a(this.f1508g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.f1508g.setOnClickListener(new a(this));
        m();
    }

    @Override // c.a.a0.l0.t.c
    public void e() {
        c.a.a0.j.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.i) == null) {
            return;
        }
        dVar.n();
        this.i = null;
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f1507f) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06024e));
    }

    public final boolean n(c.a.a0.j.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.a0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.l) == null || !TextUtils.equals(aVar.f1250g, cVar.f1533c) || !TextUtils.equals(aVar.d(), cVar.f1534d)) ? false : true : invokeLL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || this.f1507f == null) {
            return;
        }
        this.f1507f.setTextColor(getResources().getColor(adBaseModel.f27539b ? R.color.obfuscated_res_0x7f06027e : R.color.obfuscated_res_0x7f06024e));
    }

    @Override // c.a.a0.l0.t.c
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (c.c(adBaseModel) && adBaseModel.f27545h != null) {
                m();
                String str = adBaseModel.f27545h.f27546b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f1507f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f27543f.f1549d)) {
                    return;
                }
                this.i = new c.a.a0.j.f.d(c.a.a0.j.d.a.b(adBaseModel), this.f1509h);
                c.a.a0.l0.r.a aVar = this.f1500e;
                if (aVar != null) {
                    aVar.d(adBaseModel);
                }
                this.i.r(new b(this, adBaseModel));
                return;
            }
            i(8);
        }
    }
}
