package c.a.q0.x2.m0;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.q0.x2.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f29002i;

    /* renamed from: j  reason: collision with root package name */
    public RoundTbImageView f29003j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public CountDownTextView o;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29004e;

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
            this.f29004e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f29004e.f29021h) == null) {
                return;
            }
            onClickListener.onClick(view);
            this.f29004e.o.countStop();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.x2.i0.b.g f29005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f29006f;

        public c(d dVar, c.a.q0.x2.i0.b.g gVar) {
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
            this.f29006f = dVar;
            this.f29005e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f29005e.f28894d;
                if (z.B(this.f29006f.f29017d, str)) {
                    i2 = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.f29006f.f29017d;
                    i2 = z.e(this.f29006f.f29019f, str, advertAppInfo.F4() ? this.f29006f.f29017d.getDownloadId() : this.f29006f.f29017d.T3, advertAppInfo.a4);
                }
                if (i2 == 0) {
                    return;
                }
                AdvertAppInfo advertAppInfo2 = this.f29006f.f29017d;
                c.a.q0.x2.l0.c b2 = c.a.q0.x2.l0.g.b(advertAppInfo2, 2, advertAppInfo2.position);
                b2.h("VIDEO_FLOW_TAIL");
                c.a.q0.x2.l0.e.b().d(b2);
                c.a.q0.o1.o.h.c.h(c.a.q0.o1.o.h.c.e(this.f29006f.f29017d));
                this.f29006f.o.countStop();
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

    @Override // c.a.q0.x2.m0.g
    public void d(c.a.q0.x2.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            super.d(gVar);
            if (gVar == null) {
                return;
            }
            this.f29003j.startLoad(gVar.f28893c, 30, false);
            this.k.setText(gVar.f28892b);
            this.l.setText(gVar.f28899i);
            this.m.setText(gVar.f28895e);
            this.n.setOnClickListener(new b(this));
            this.o.setFormatString(this.f29019f.getResources().getString(R.string.ad_video_flow_count_down));
            this.f29002i.setOnClickListener(new c(this, gVar));
        }
    }

    @Override // c.a.q0.x2.m0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            this.o.update(5);
            this.o.startCountDown();
            AdvertAppInfo advertAppInfo = this.f29017d;
            c.a.q0.x2.l0.e.b().d(c.a.q0.x2.l0.g.b(advertAppInfo, 103, advertAppInfo.position));
        }
    }

    @Override // c.a.q0.x2.m0.g
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
            this.f29015b.setOnClickListener(new a(this));
            this.f29002i = (RelativeLayout) b(R.id.ad_container);
            this.f29003j = (RoundTbImageView) b(R.id.user_head);
            this.k = (TextView) b(R.id.user_name);
            this.l = (TextView) b(R.id.user_content);
            this.m = (TextView) b(R.id.transform_btn);
            this.n = (TextView) b(R.id.replay_btn);
            this.o = (CountDownTextView) b(R.id.count_down_view);
        }
    }
}
