package c.a.b0.h0;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;

    /* renamed from: b  reason: collision with root package name */
    public View f1646b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f1647c;

    public a(AdBaseModel adBaseModel, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adBaseModel, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adBaseModel;
        this.f1646b = view;
    }

    @Override // c.a.b0.h0.i
    public void a(AdOperator adOperator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adOperator) == null) {
            Toast.makeText(c.a.b0.e.a.b(), "on click : operator btn", 1).show();
            if (adOperator.a == AdOperator.TYPE.CHECK) {
                c.a.b0.d.c.b(adOperator.f37584d);
                f(ClogBuilder.LogType.CLICK, "button", this.a);
            }
            View.OnClickListener onClickListener = this.f1647c;
            if (onClickListener != null) {
                onClickListener.onClick(this.f1646b);
            }
        }
    }

    public final void f(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        c.a.b0.p.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, str, adBaseModel) == null) || adBaseModel == null || (jVar = adBaseModel.f37574d) == null || TextUtils.isEmpty(jVar.f1782b)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(logType);
        clogBuilder.g(str);
        clogBuilder.m(adBaseModel.f37574d.f1782b);
        c.a.b0.x.a.b(clogBuilder);
    }

    public void g(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f1647c = onClickListener;
        }
    }
}
