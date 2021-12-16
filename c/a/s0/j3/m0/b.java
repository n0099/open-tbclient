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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f18494i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f18495j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f18496k;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.j3.i0.b.g f18497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f18498f;

        public a(b bVar, c.a.s0.j3.i0.b.g gVar) {
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
            this.f18498f = bVar;
            this.f18497e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f18498f.f18518b.getContext();
                c.a.s0.j3.i0.b.g gVar = this.f18497e;
                String str = gVar.f18406d;
                String str2 = gVar.f18408f;
                AdvertAppInfo advertAppInfo = this.f18498f.f18520d;
                z.d(context, str, str2, advertAppInfo != null ? advertAppInfo.k4 : "", this.f18497e.f18412j);
                c.a.s0.j3.l0.c cVar = this.f18498f.f18519c;
                if (cVar != null) {
                    cVar.i(302);
                    c.a.s0.j3.l0.e.b().d(this.f18498f.f18519c);
                }
                c.a.s0.x1.o.h.b bVar = this.f18498f.f18521e;
                if (bVar != null) {
                    c.a.s0.x1.o.h.c.h(bVar);
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

    @Override // c.a.s0.j3.m0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.f18495j, R.color.CAM_X0620, 1);
            SkinManager.setViewTextColor(this.f18496k, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f18496k, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.s0.j3.m0.g
    public void d(c.a.s0.j3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            super.d(gVar);
            this.f18494i.startLoad(gVar.f18405c, 10, false);
            this.f18495j.setText(gVar.f18404b);
            this.f18496k.setText(gVar.f18407e);
            this.f18518b.setOnClickListener(new a(this, gVar));
            c();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f18494i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f18494i.setDefaultBgResource(R.color.CAM_X0205);
            this.f18494i.setIsRound(true);
            this.f18495j = (TextView) b(R.id.user_name);
            this.f18496k = (TextView) b(R.id.action);
        }
    }
}
