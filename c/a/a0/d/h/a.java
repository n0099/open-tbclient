package c.a.a0.d.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import c.a.a0.g.c;
import c.a.a0.s.i;
import c.a.a0.s.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends c.a.a0.l0.u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;

    /* renamed from: b  reason: collision with root package name */
    public View f1108b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f1109c;

    public a(AdBaseModel adBaseModel, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adBaseModel, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adBaseModel;
        this.f1108b = view;
    }

    @Override // c.a.a0.l0.u.a
    public void b(@NonNull o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            Toast.makeText(c.a.a0.h.a.b(), "on click : operator btn", 1).show();
            if (oVar.f1555b) {
                c.b(oVar.a);
                g(ClogBuilder.LogType.CLICK, "button", this.a);
            }
            View.OnClickListener onClickListener = this.f1109c;
            if (onClickListener != null) {
                onClickListener.onClick(this.f1108b);
            }
        }
    }

    public final void g(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, str, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f27543f) == null || TextUtils.isEmpty(iVar.f1549d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(logType);
        clogBuilder.h(str);
        clogBuilder.n(adBaseModel.f27543f.f1549d);
        c.a.a0.a0.a.b(clogBuilder);
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f1109c = onClickListener;
        }
    }
}
