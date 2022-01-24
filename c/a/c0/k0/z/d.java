package c.a.c0.k0.z;

import android.view.View;
import c.a.c0.s.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uitemplate.SimpleFeedAdInfoView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public final SimpleFeedAdInfoView f2180j;

    /* loaded from: classes.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f2181b;

        public a(d dVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2181b = dVar;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d dVar = this.f2181b;
                dVar.q(ClogBuilder.LogType.FREE_CLICK.type, dVar.f2176c, str, this.a.f37044d.f2233b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, View view) {
        super(i2, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2180j = (SimpleFeedAdInfoView) view.findViewById(c.a.c0.d.e.feed_ad_operate_app_info_view);
        m();
    }

    private void m() {
        SimpleFeedAdInfoView simpleFeedAdInfoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (simpleFeedAdInfoView = this.f2180j) == null) {
            return;
        }
        simpleFeedAdInfoView.initSkin();
    }

    public final void q(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.s(str);
            clogBuilder.q(str2);
            clogBuilder.m(str4);
            clogBuilder.g(str3);
            c.a.c0.a0.a.b(clogBuilder);
        }
    }

    @Override // c.a.c0.k0.z.f, c.a.c0.k0.z.b
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            m();
            SimpleFeedAdInfoView simpleFeedAdInfoView = this.f2180j;
            if (simpleFeedAdInfoView != null) {
                simpleFeedAdInfoView.update(adBaseModel);
                o oVar = adBaseModel.l;
                if (oVar == null || oVar.f2260i) {
                    this.f2180j.setBackground(getResources().getDrawable(c.a.c0.d.d.nad_operate_download_bg));
                }
                this.f2180j.setAfterListener(new a(this, adBaseModel));
            }
        }
    }
}
