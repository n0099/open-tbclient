package c.a.c0.d.p;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import c.a.c0.f.d;
import c.a.c0.s.i;
import c.a.c0.s.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends c.a.c0.k0.a0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;

    /* renamed from: b  reason: collision with root package name */
    public View f1808b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f1809c;

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
        this.f1808b = view;
    }

    @Override // c.a.c0.k0.a0.a
    public void b(@NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            Toast.makeText(c.a.c0.h.a.b(), "on click : operator btn", 1).show();
            if (kVar.f2240b) {
                d.b(kVar.a);
                g(ClogBuilder.LogType.CLICK, "button", this.a);
            }
            View.OnClickListener onClickListener = this.f1809c;
            if (onClickListener != null) {
                onClickListener.onClick(this.f1808b);
            }
        }
    }

    public final void g(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, str, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f37044d) == null || TextUtils.isEmpty(iVar.f2233b)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(logType);
        clogBuilder.g(str);
        clogBuilder.m(adBaseModel.f37044d.f2233b);
        c.a.c0.a0.a.b(clogBuilder);
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f1809c = onClickListener;
        }
    }
}
