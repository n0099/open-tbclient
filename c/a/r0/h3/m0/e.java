package c.a.r0.h3.m0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.r0.h3.z;
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
/* loaded from: classes6.dex */
public class e extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f17862i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f17863j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f17864k;
    public CountDownTextView l;
    public boolean m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.h3.i0.b.g f17865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17866f;

        public a(e eVar, c.a.r0.h3.i0.b.g gVar) {
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
            this.f17866f = eVar;
            this.f17865e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f17866f.f17869b.getContext();
                String str = this.f17865e.f17757d;
                AdvertAppInfo advertAppInfo = this.f17866f.f17871d;
                z.d(context, str, null, advertAppInfo != null ? advertAppInfo.j4 : "", this.f17865e.f17763j);
                c.a.r0.h3.l0.c cVar = this.f17866f.f17870c;
                if (cVar != null) {
                    cVar.i(302);
                    c.a.r0.h3.l0.e.b().d(this.f17866f.f17870c);
                }
                c.a.r0.w1.o.h.b bVar = this.f17866f.f17872e;
                if (bVar != null) {
                    c.a.r0.w1.o.h.c.h(bVar);
                }
                this.f17866f.a(false);
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

    @Override // c.a.r0.h3.m0.g
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

    @Override // c.a.r0.h3.m0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f17863j, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.f17864k, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f17864k, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.r0.h3.m0.g
    public void d(c.a.r0.h3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.d(gVar);
            this.f17862i.startLoad(gVar.f17756c, 10, false);
            this.f17863j.setText(gVar.f17755b);
            this.f17864k.setText(gVar.f17758e);
            this.f17869b.setOnClickListener(new a(this, gVar));
            this.l.update(gVar.f17761h);
            c();
        }
    }

    @Override // c.a.r0.h3.m0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e();
            this.l.startCountDown();
        }
    }

    @Override // c.a.r0.h3.m0.g
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
            this.f17862i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f17862i.setDefaultBgResource(R.color.CAM_X0205);
            this.f17862i.setIsRound(true);
            this.f17863j = (TextView) b(R.id.user_name);
            this.l = (CountDownTextView) b(R.id.count_down_text);
            this.f17864k = (TextView) b(R.id.action);
        }
    }
}
