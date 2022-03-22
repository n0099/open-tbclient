package c.a.p0.l3.n0;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.p0.l3.a0;
import c.a.p0.l3.j0.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout i;
    public RoundTbImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public CountDownTextView o;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.a.f16322h) == null) {
                return;
            }
            onClickListener.onClick(view);
            this.a.o.c();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f16312b;

        public c(d dVar, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16312b = dVar;
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.a.f16244d;
                if (a0.C(this.f16312b.f16318d, str)) {
                    i = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.f16312b.f16318d;
                    i = a0.e(this.f16312b.f16320f, str, advertAppInfo.i() ? this.f16312b.f16318d.getDownloadId() : this.f16312b.f16318d.a, advertAppInfo.f29821h, this.a.j);
                }
                if (i == 0) {
                    return;
                }
                AdvertAppInfo advertAppInfo2 = this.f16312b.f16318d;
                c.a.p0.l3.m0.c b2 = c.a.p0.l3.m0.g.b(advertAppInfo2, 2, advertAppInfo2.position);
                b2.h("VIDEO_FLOW_TAIL");
                c.a.p0.l3.m0.e.b().d(b2);
                c.a.p0.b2.o.h.c.h(c.a.p0.b2.o.h.c.e(this.f16312b.f16318d));
                this.f16312b.o.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(View view, String str) {
        super(view, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o();
    }

    @Override // c.a.p0.l3.n0.g
    public void d(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            super.d(hVar);
            if (hVar == null) {
                return;
            }
            this.j.J(hVar.f16243c, 30, false);
            this.k.setText(hVar.f16242b);
            this.l.setText(hVar.i);
            this.m.setText(hVar.f16245e);
            this.n.setOnClickListener(new b(this));
            this.o.setFormatString(this.f16320f.getResources().getString(R.string.obfuscated_res_0x7f0f00b4));
            this.i.setOnClickListener(new c(this, hVar));
        }
    }

    @Override // c.a.p0.l3.n0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            this.o.update(5);
            this.o.e();
            AdvertAppInfo advertAppInfo = this.f16318d;
            c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.b(advertAppInfo, 103, advertAppInfo.position));
        }
    }

    @Override // c.a.p0.l3.n0.g
    public void m(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.m(cVar);
            this.o.setTimeoutListener(cVar);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16316b.setOnClickListener(new a(this));
            this.i = (RelativeLayout) b(R.id.obfuscated_res_0x7f090094);
            this.j = (RoundTbImageView) b(R.id.obfuscated_res_0x7f0922a1);
            this.k = (TextView) b(R.id.obfuscated_res_0x7f0922bb);
            this.l = (TextView) b(R.id.obfuscated_res_0x7f09229d);
            this.m = (TextView) b(R.id.obfuscated_res_0x7f09213f);
            this.n = (TextView) b(R.id.obfuscated_res_0x7f091a47);
            this.o = (CountDownTextView) b(R.id.obfuscated_res_0x7f0906fa);
        }
    }
}
