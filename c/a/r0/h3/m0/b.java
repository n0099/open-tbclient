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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f17845i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f17846j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f17847k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.h3.i0.b.g f17848e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17849f;

        public a(b bVar, c.a.r0.h3.i0.b.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17849f = bVar;
            this.f17848e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f17849f.f17869b.getContext();
                c.a.r0.h3.i0.b.g gVar = this.f17848e;
                String str = gVar.f17757d;
                String str2 = gVar.f17759f;
                AdvertAppInfo advertAppInfo = this.f17849f.f17871d;
                z.d(context, str, str2, advertAppInfo != null ? advertAppInfo.j4 : "", this.f17848e.f17763j);
                c.a.r0.h3.l0.c cVar = this.f17849f.f17870c;
                if (cVar != null) {
                    cVar.i(302);
                    c.a.r0.h3.l0.e.b().d(this.f17849f.f17870c);
                }
                c.a.r0.w1.o.h.b bVar = this.f17849f.f17872e;
                if (bVar != null) {
                    c.a.r0.w1.o.h.c.h(bVar);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, String str) {
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
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.f17846j, R.color.CAM_X0620, 1);
            SkinManager.setViewTextColor(this.f17847k, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f17847k, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.r0.h3.m0.g
    public void d(c.a.r0.h3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            super.d(gVar);
            this.f17845i.startLoad(gVar.f17756c, 10, false);
            this.f17846j.setText(gVar.f17755b);
            this.f17847k.setText(gVar.f17758e);
            this.f17869b.setOnClickListener(new a(this, gVar));
            c();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f17845i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f17845i.setDefaultBgResource(R.color.CAM_X0205);
            this.f17845i.setIsRound(true);
            this.f17846j = (TextView) b(R.id.user_name);
            this.f17847k = (TextView) b(R.id.action);
        }
    }
}
