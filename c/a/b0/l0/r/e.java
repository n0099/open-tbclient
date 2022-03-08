package c.a.b0.l0.r;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f1871f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f1872g;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f1873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f1874f;

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
            this.f1874f = eVar;
            this.f1873e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.b0.f.c.c(this.f1873e.f35663h.f35668d, this.f1874f.getContext());
                c.a.b0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).g(ClogBuilder.Area.BUTTON).n(this.f1873e.f35661f.f1923d));
                c.a.b0.l0.p.b bVar = this.f1874f.f1864d;
                if (bVar != null) {
                    bVar.b(this.f1873e);
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
        this.f1872g = (TextView) a(R.id.feed_ad_operate_command_app_name);
        this.f1871f = (TextView) a(R.id.nad_feed_ad_operate_command_button);
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b() instanceof AdBaseModel)) {
            this.f1872g.setTextColor(getResources().getColor(R.color.NAD_FC1));
            this.f1871f.setTextColor(getResources().getColor(R.color.NAD_FC13));
            if (this.f1871f.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) this.f1871f.getBackground()).setColor(getResources().getColor(R.color.NAD_GC52));
                ((GradientDrawable) this.f1871f.getBackground()).setStroke(2, getResources().getColor(R.color.NAD_GC53));
                return;
            }
            this.f1871f.setBackground(getResources().getDrawable(R.drawable.nad_progress_button_bg));
        }
    }

    @Override // c.a.b0.l0.r.b
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            b.d(adBaseModel);
            k();
            String str = adBaseModel.f35663h.f35666b.a;
            if (!TextUtils.isEmpty(str)) {
                this.f1872g.setText(str);
                this.f1872g.setVisibility(0);
            } else {
                this.f1872g.setVisibility(8);
            }
            this.f1871f.setText(adBaseModel.f35663h.f35667c);
            if (!TextUtils.isEmpty(adBaseModel.f35663h.f35668d)) {
                this.f1871f.setVisibility(0);
                this.f1871f.setOnClickListener(new a(this, adBaseModel));
                return;
            }
            this.f1871f.setVisibility(8);
        }
    }
}
