package c.a.r0.h3.m0;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.h3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f17856i;

    /* renamed from: j  reason: collision with root package name */
    public RoundTbImageView f17857j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f17858k;
    public TextView l;
    public TextView m;
    public TextView n;
    public CountDownTextView o;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17859e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17859e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f17859e.f17875h) == null) {
                return;
            }
            onClickListener.onClick(view);
            this.f17859e.o.countStop();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.h3.i0.b.g f17860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f17861f;

        public c(d dVar, c.a.r0.h3.i0.b.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17861f = dVar;
            this.f17860e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f17860e.f17757d;
                if (z.C(this.f17861f.f17871d, str)) {
                    i2 = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.f17861f.f17871d;
                    i2 = z.e(this.f17861f.f17873f, str, advertAppInfo.V4() ? this.f17861f.f17871d.getDownloadId() : this.f17861f.f17871d.c4, advertAppInfo.j4, this.f17860e.f17763j);
                }
                if (i2 == 0) {
                    return;
                }
                AdvertAppInfo advertAppInfo2 = this.f17861f.f17871d;
                c.a.r0.h3.l0.c b2 = c.a.r0.h3.l0.g.b(advertAppInfo2, 2, advertAppInfo2.position);
                b2.h("VIDEO_FLOW_TAIL");
                c.a.r0.h3.l0.e.b().d(b2);
                c.a.r0.w1.o.h.c.h(c.a.r0.w1.o.h.c.e(this.f17861f.f17871d));
                this.f17861f.o.countStop();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o();
    }

    @Override // c.a.r0.h3.m0.g
    public void d(c.a.r0.h3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            super.d(gVar);
            if (gVar == null) {
                return;
            }
            this.f17857j.startLoad(gVar.f17756c, 30, false);
            this.f17858k.setText(gVar.f17755b);
            this.l.setText(gVar.f17762i);
            this.m.setText(gVar.f17758e);
            this.n.setOnClickListener(new b(this));
            this.o.setFormatString(this.f17873f.getResources().getString(R.string.ad_video_flow_count_down));
            this.f17856i.setOnClickListener(new c(this, gVar));
        }
    }

    @Override // c.a.r0.h3.m0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            this.o.update(5);
            this.o.startCountDown();
            AdvertAppInfo advertAppInfo = this.f17871d;
            c.a.r0.h3.l0.e.b().d(c.a.r0.h3.l0.g.b(advertAppInfo, 103, advertAppInfo.position));
        }
    }

    @Override // c.a.r0.h3.m0.g
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
            this.f17869b.setOnClickListener(new a(this));
            this.f17856i = (RelativeLayout) b(R.id.ad_container);
            this.f17857j = (RoundTbImageView) b(R.id.user_head);
            this.f17858k = (TextView) b(R.id.user_name);
            this.l = (TextView) b(R.id.user_content);
            this.m = (TextView) b(R.id.transform_btn);
            this.n = (TextView) b(R.id.replay_btn);
            this.o = (CountDownTextView) b(R.id.count_down_view);
        }
    }
}
