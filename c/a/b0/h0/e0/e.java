package c.a.b0.h0.e0;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f1698f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f1699g;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f1700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f1701f;

        public a(e eVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1701f = eVar;
            this.f1700e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.b0.d.c.c(this.f1700e.f37576f.f37584d, this.f1701f.getContext());
                c.a.b0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.CLICK).f(ClogBuilder.Area.BUTTON).m(this.f1700e.f37574d.f1782b));
                c.a.b0.h0.c0.b bVar = this.f1701f.f1693d;
                if (bVar != null) {
                    bVar.b(this.f1700e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i2, View view) {
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
        this.f1699g = (TextView) a(c.a.b0.b.e.feed_ad_operate_command_app_name);
        this.f1698f = (TextView) a(c.a.b0.b.e.nad_feed_ad_operate_command_button);
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b() instanceof AdBaseModel)) {
            this.f1699g.setTextColor(getResources().getColor(c.a.b0.b.b.NAD_FC1));
            this.f1698f.setTextColor(getResources().getColor(c.a.b0.b.b.NAD_FC13));
            if (this.f1698f.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) this.f1698f.getBackground()).setColor(getResources().getColor(c.a.b0.b.b.NAD_GC52));
                ((GradientDrawable) this.f1698f.getBackground()).setStroke(2, getResources().getColor(c.a.b0.b.b.NAD_GC53));
                return;
            }
            this.f1698f.setBackground(getResources().getDrawable(c.a.b0.b.d.nad_progress_button_bg));
        }
    }

    @Override // c.a.b0.h0.e0.b
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            b.d(adBaseModel);
            k();
            String str = adBaseModel.f37576f.f37582b.a;
            if (!TextUtils.isEmpty(str)) {
                this.f1699g.setText(str);
                this.f1699g.setVisibility(0);
            } else {
                this.f1699g.setVisibility(8);
            }
            this.f1698f.setText(adBaseModel.f37576f.f37583c);
            if (!TextUtils.isEmpty(adBaseModel.f37576f.f37584d)) {
                this.f1698f.setVisibility(0);
                this.f1698f.setOnClickListener(new a(this, adBaseModel));
                return;
            }
            this.f1698f.setVisibility(8);
        }
    }
}
