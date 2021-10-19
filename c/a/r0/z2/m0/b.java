package c.a.r0.z2.m0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.r0.z2.z;
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
/* loaded from: classes4.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f29810i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f29811j;
    public TextView k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.z2.i0.b.g f29812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f29813f;

        public a(b bVar, c.a.r0.z2.i0.b.g gVar) {
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
            this.f29813f = bVar;
            this.f29812e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f29813f.f29833b.getContext();
                c.a.r0.z2.i0.b.g gVar = this.f29812e;
                String str = gVar.f29707d;
                String str2 = gVar.f29709f;
                AdvertAppInfo advertAppInfo = this.f29813f.f29835d;
                z.d(context, str, str2, advertAppInfo != null ? advertAppInfo.e4 : "");
                c.a.r0.z2.l0.c cVar = this.f29813f.f29834c;
                if (cVar != null) {
                    cVar.i(302);
                    c.a.r0.z2.l0.e.b().d(this.f29813f.f29834c);
                }
                c.a.r0.q1.o.h.b bVar = this.f29813f.f29836e;
                if (bVar != null) {
                    c.a.r0.q1.o.h.c.h(bVar);
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

    @Override // c.a.r0.z2.m0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.f29811j, R.color.CAM_X0620, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.k, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.r0.z2.m0.g
    public void d(c.a.r0.z2.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            super.d(gVar);
            this.f29810i.startLoad(gVar.f29706c, 10, false);
            this.f29811j.setText(gVar.f29705b);
            this.k.setText(gVar.f29708e);
            this.f29833b.setOnClickListener(new a(this, gVar));
            c();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f29810i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f29810i.setDefaultBgResource(R.color.CAM_X0205);
            this.f29810i.setIsRound(true);
            this.f29811j = (TextView) b(R.id.user_name);
            this.k = (TextView) b(R.id.action);
        }
    }
}
