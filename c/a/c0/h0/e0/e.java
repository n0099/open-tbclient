package c.a.c0.h0.e0;

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
    public final TextView f2143f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f2144g;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f2145e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f2146f;

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
            this.f2146f = eVar;
            this.f2145e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.c0.d.c.c(this.f2145e.f38221f.f38229d, this.f2146f.getContext());
                c.a.c0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.CLICK).f(ClogBuilder.Area.BUTTON).m(this.f2145e.f38219d.f2227b));
                c.a.c0.h0.c0.b bVar = this.f2146f.f2138d;
                if (bVar != null) {
                    bVar.b(this.f2145e);
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
        this.f2144g = (TextView) a(c.a.c0.b.e.feed_ad_operate_command_app_name);
        this.f2143f = (TextView) a(c.a.c0.b.e.nad_feed_ad_operate_command_button);
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b() instanceof AdBaseModel)) {
            this.f2144g.setTextColor(getResources().getColor(c.a.c0.b.b.NAD_FC1));
            this.f2143f.setTextColor(getResources().getColor(c.a.c0.b.b.NAD_FC13));
            if (this.f2143f.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) this.f2143f.getBackground()).setColor(getResources().getColor(c.a.c0.b.b.NAD_GC52));
                ((GradientDrawable) this.f2143f.getBackground()).setStroke(2, getResources().getColor(c.a.c0.b.b.NAD_GC53));
                return;
            }
            this.f2143f.setBackground(getResources().getDrawable(c.a.c0.b.d.nad_progress_button_bg));
        }
    }

    @Override // c.a.c0.h0.e0.b
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            b.d(adBaseModel);
            k();
            String str = adBaseModel.f38221f.f38227b.a;
            if (!TextUtils.isEmpty(str)) {
                this.f2144g.setText(str);
                this.f2144g.setVisibility(0);
            } else {
                this.f2144g.setVisibility(8);
            }
            this.f2143f.setText(adBaseModel.f38221f.f38228c);
            if (!TextUtils.isEmpty(adBaseModel.f38221f.f38229d)) {
                this.f2143f.setVisibility(0);
                this.f2143f.setOnClickListener(new a(this, adBaseModel));
                return;
            }
            this.f2143f.setVisibility(8);
        }
    }
}
