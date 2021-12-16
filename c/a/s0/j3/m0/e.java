package c.a.s0.j3.m0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.s0.j3.z;
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
    public HeadImageView f18511i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f18512j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f18513k;
    public CountDownTextView l;
    public boolean m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.j3.i0.b.g f18514e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18515f;

        public a(e eVar, c.a.s0.j3.i0.b.g gVar) {
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
            this.f18515f = eVar;
            this.f18514e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f18515f.f18518b.getContext();
                String str = this.f18514e.f18406d;
                AdvertAppInfo advertAppInfo = this.f18515f.f18520d;
                z.d(context, str, null, advertAppInfo != null ? advertAppInfo.k4 : "", this.f18514e.f18412j);
                c.a.s0.j3.l0.c cVar = this.f18515f.f18519c;
                if (cVar != null) {
                    cVar.i(302);
                    c.a.s0.j3.l0.e.b().d(this.f18515f.f18519c);
                }
                c.a.s0.x1.o.h.b bVar = this.f18515f.f18521e;
                if (bVar != null) {
                    c.a.s0.x1.o.h.c.h(bVar);
                }
                this.f18515f.a(false);
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

    @Override // c.a.s0.j3.m0.g
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

    @Override // c.a.s0.j3.m0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f18512j, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.f18513k, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f18513k, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.s0.j3.m0.g
    public void d(c.a.s0.j3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.d(gVar);
            this.f18511i.startLoad(gVar.f18405c, 10, false);
            this.f18512j.setText(gVar.f18404b);
            this.f18513k.setText(gVar.f18407e);
            this.f18518b.setOnClickListener(new a(this, gVar));
            this.l.update(gVar.f18410h);
            c();
        }
    }

    @Override // c.a.s0.j3.m0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e();
            this.l.startCountDown();
        }
    }

    @Override // c.a.s0.j3.m0.g
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
            this.f18511i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f18511i.setDefaultBgResource(R.color.CAM_X0205);
            this.f18511i.setIsRound(true);
            this.f18512j = (TextView) b(R.id.user_name);
            this.l = (CountDownTextView) b(R.id.count_down_text);
            this.f18513k = (TextView) b(R.id.action);
        }
    }
}
