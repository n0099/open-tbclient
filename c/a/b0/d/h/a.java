package c.a.b0.d.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import c.a.b0.f.c;
import c.a.b0.s.i;
import c.a.b0.s.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends c.a.b0.l0.s.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;

    /* renamed from: b  reason: collision with root package name */
    public View f1466b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f1467c;

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
        this.f1466b = view;
    }

    @Override // c.a.b0.l0.s.a
    public void b(@NonNull o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            Toast.makeText(c.a.b0.h.a.b(), "on click : operator btn", 1).show();
            if (oVar.f1931b) {
                c.b(oVar.a);
                g(ClogBuilder.LogType.CLICK, "button", this.a);
            }
            View.OnClickListener onClickListener = this.f1467c;
            if (onClickListener != null) {
                onClickListener.onClick(this.f1466b);
            }
        }
    }

    public final void g(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, str, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f35661f) == null || TextUtils.isEmpty(iVar.f1923d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(logType);
        clogBuilder.h(str);
        clogBuilder.n(adBaseModel.f35661f.f1923d);
        c.a.b0.a0.a.b(clogBuilder);
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f1467c = onClickListener;
        }
    }
}
