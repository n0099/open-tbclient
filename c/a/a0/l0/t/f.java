package c.a.a0.l0.t;

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
public class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f1504f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f1505g;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f1506b;

        public a(f fVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1506b = fVar;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.a0.g.c.c(this.a.f27545h.f27548d, this.f1506b.getContext());
                c.a.a0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).g(ClogBuilder.Area.BUTTON).n(this.a.f27543f.f1549d));
                c.a.a0.l0.r.b bVar = this.f1506b.f1499d;
                if (bVar != null) {
                    bVar.b(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i, View view) {
        super(i, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1505g = (TextView) a(R.id.obfuscated_res_0x7f090980);
        this.f1504f = (TextView) a(R.id.obfuscated_res_0x7f0914b9);
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b() instanceof AdBaseModel)) {
            this.f1505g.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06024e));
            this.f1504f.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06025c));
            if (this.f1504f.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) this.f1504f.getBackground()).setColor(getResources().getColor(R.color.obfuscated_res_0x7f0602d8));
                ((GradientDrawable) this.f1504f.getBackground()).setStroke(2, getResources().getColor(R.color.obfuscated_res_0x7f0602d9));
                return;
            }
            this.f1504f.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dcb));
        }
    }

    @Override // c.a.a0.l0.t.c
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            c.d(adBaseModel);
            k();
            String str = adBaseModel.f27545h.f27546b.a;
            if (!TextUtils.isEmpty(str)) {
                this.f1505g.setText(str);
                this.f1505g.setVisibility(0);
            } else {
                this.f1505g.setVisibility(8);
            }
            this.f1504f.setText(adBaseModel.f27545h.f27547c);
            if (!TextUtils.isEmpty(adBaseModel.f27545h.f27548d)) {
                this.f1504f.setVisibility(0);
                this.f1504f.setOnClickListener(new a(this, adBaseModel));
                return;
            }
            this.f1504f.setVisibility(8);
        }
    }
}
