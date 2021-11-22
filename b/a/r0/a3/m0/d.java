package b.a.r0.a3.m0;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.r0.a3.z;
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
    public RelativeLayout f15860i;
    public RoundTbImageView j;
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
        public final /* synthetic */ d f15861e;

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
            this.f15861e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f15861e.f15877h) == null) {
                return;
            }
            onClickListener.onClick(view);
            this.f15861e.o.countStop();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.a3.i0.b.g f15862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f15863f;

        public c(d dVar, b.a.r0.a3.i0.b.g gVar) {
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
            this.f15863f = dVar;
            this.f15862e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f15862e.f15755d;
                if (z.B(this.f15863f.f15873d, str)) {
                    i2 = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.f15863f.f15873d;
                    i2 = z.e(this.f15863f.f15875f, str, advertAppInfo.T4() ? this.f15863f.f15873d.getDownloadId() : this.f15863f.f15873d.Y3, advertAppInfo.f4);
                }
                if (i2 == 0) {
                    return;
                }
                AdvertAppInfo advertAppInfo2 = this.f15863f.f15873d;
                b.a.r0.a3.l0.c b2 = b.a.r0.a3.l0.g.b(advertAppInfo2, 2, advertAppInfo2.position);
                b2.h("VIDEO_FLOW_TAIL");
                b.a.r0.a3.l0.e.b().d(b2);
                b.a.r0.q1.o.h.c.h(b.a.r0.q1.o.h.c.e(this.f15863f.f15873d));
                this.f15863f.o.countStop();
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

    @Override // b.a.r0.a3.m0.g
    public void d(b.a.r0.a3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            super.d(gVar);
            if (gVar == null) {
                return;
            }
            this.j.startLoad(gVar.f15754c, 30, false);
            this.k.setText(gVar.f15753b);
            this.l.setText(gVar.f15760i);
            this.m.setText(gVar.f15756e);
            this.n.setOnClickListener(new b(this));
            this.o.setFormatString(this.f15875f.getResources().getString(R.string.ad_video_flow_count_down));
            this.f15860i.setOnClickListener(new c(this, gVar));
        }
    }

    @Override // b.a.r0.a3.m0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            this.o.update(5);
            this.o.startCountDown();
            AdvertAppInfo advertAppInfo = this.f15873d;
            b.a.r0.a3.l0.e.b().d(b.a.r0.a3.l0.g.b(advertAppInfo, 103, advertAppInfo.position));
        }
    }

    @Override // b.a.r0.a3.m0.g
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
            this.f15871b.setOnClickListener(new a(this));
            this.f15860i = (RelativeLayout) b(R.id.ad_container);
            this.j = (RoundTbImageView) b(R.id.user_head);
            this.k = (TextView) b(R.id.user_name);
            this.l = (TextView) b(R.id.user_content);
            this.m = (TextView) b(R.id.transform_btn);
            this.n = (TextView) b(R.id.replay_btn);
            this.o = (CountDownTextView) b(R.id.count_down_view);
        }
    }
}
