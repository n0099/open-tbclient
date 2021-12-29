package c.a.t0.j3.m0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.t0.j3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f18985i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f18986j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f18987k;
    public CountDownTextView l;
    public boolean m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.j3.i0.b.g f18988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18989f;

        public a(e eVar, c.a.t0.j3.i0.b.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18989f = eVar;
            this.f18988e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f18989f.f18992b.getContext();
                String str = this.f18988e.f18880d;
                AdvertAppInfo advertAppInfo = this.f18989f.f18994d;
                z.d(context, str, null, advertAppInfo != null ? advertAppInfo.m4 : "", this.f18988e.f18886j);
                c.a.t0.j3.l0.c cVar = this.f18989f.f18993c;
                if (cVar != null) {
                    cVar.i(302);
                    c.a.t0.j3.l0.e.b().d(this.f18989f.f18993c);
                }
                c.a.t0.x1.o.h.b bVar = this.f18989f.f18995e;
                if (bVar != null) {
                    c.a.t0.x1.o.h.c.h(bVar);
                }
                this.f18989f.a(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(View view, String str) {
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
        n();
    }

    @Override // c.a.t0.j3.m0.g
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.m = z;
            CountDownTextView countDownTextView = this.l;
            if (countDownTextView != null) {
                countDownTextView.setEnableTimeoutListener(z);
            }
        }
    }

    @Override // c.a.t0.j3.m0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f18986j, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.f18987k, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f18987k, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.t0.j3.m0.g
    public void d(c.a.t0.j3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.d(gVar);
            this.f18985i.startLoad(gVar.f18879c, 10, false);
            this.f18986j.setText(gVar.f18878b);
            this.f18987k.setText(gVar.f18881e);
            this.f18992b.setOnClickListener(new a(this, gVar));
            this.l.update(gVar.f18884h);
            c();
        }
    }

    @Override // c.a.t0.j3.m0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e();
            this.l.startCountDown();
        }
    }

    @Override // c.a.t0.j3.m0.g
    public void m(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            super.m(cVar);
            this.l.setTimeoutListener(cVar);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f18985i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f18985i.setDefaultBgResource(R.color.CAM_X0205);
            this.f18985i.setIsRound(true);
            this.f18986j = (TextView) b(R.id.user_name);
            this.l = (CountDownTextView) b(R.id.count_down_text);
            this.f18987k = (TextView) b(R.id.action);
        }
    }
}
