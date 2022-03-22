package c.a.p0.l3.n0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.p0.l3.a0;
import c.a.p0.l3.j0.b.h;
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
/* loaded from: classes2.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView i;
    public TextView j;
    public TextView k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f16310b;

        public a(b bVar, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16310b = bVar;
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f16310b.f16316b.getContext();
                h hVar = this.a;
                String str = hVar.f16244d;
                String str2 = hVar.f16246f;
                AdvertAppInfo advertAppInfo = this.f16310b.f16318d;
                a0.d(context, str, str2, advertAppInfo != null ? advertAppInfo.f29821h : "", this.a.j);
                c.a.p0.l3.m0.c cVar = this.f16310b.f16317c;
                if (cVar != null) {
                    cVar.i(302);
                    c.a.p0.l3.m0.e.b().d(this.f16310b.f16317c);
                }
                c.a.p0.b2.o.h.b bVar = this.f16310b.f16319e;
                if (bVar != null) {
                    c.a.p0.b2.o.h.c.h(bVar);
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
        n();
    }

    @Override // c.a.p0.l3.n0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0620, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f0811c4, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.p0.l3.n0.g
    public void d(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            super.d(hVar);
            this.i.J(hVar.f16243c, 10, false);
            this.j.setText(hVar.f16242b);
            this.k.setText(hVar.f16245e);
            this.f16316b.setOnClickListener(new a(this, hVar));
            c();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.obfuscated_res_0x7f0922c8);
            this.i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.i.setDefaultBgResource(R.color.CAM_X0205);
            this.i.setIsRound(true);
            this.j = (TextView) b(R.id.obfuscated_res_0x7f0922bb);
            this.k = (TextView) b(R.id.obfuscated_res_0x7f090054);
        }
    }
}
