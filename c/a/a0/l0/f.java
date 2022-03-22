package c.a.a0.l0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.LoadingProgressBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f1401b;

    /* renamed from: c  reason: collision with root package name */
    public LoadingProgressBar f1402c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f1403d;

    /* renamed from: e  reason: collision with root package name */
    public String f1404e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1405f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1406g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1407h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull Context context) {
        super(context, R.style.obfuscated_res_0x7f100130);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1404e = "";
        this.f1406g = false;
        this.f1407h = false;
        this.a = context;
        this.f1405f = a(context);
    }

    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? context instanceof Activity : invokeL.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1401b = findViewById(R.id.obfuscated_res_0x7f091adf);
            this.f1402c = (LoadingProgressBar) findViewById(R.id.obfuscated_res_0x7f09130d);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0913fb);
            this.f1403d = textView;
            textView.setText(this.f1404e);
            setCancelable(this.f1406g);
            setCanceledOnTouchOutside(this.f1407h);
            f();
        }
    }

    public f c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f1406g = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.f1407h = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f1404e = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final void f() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (context = this.a) == null) {
            return;
        }
        Resources resources = context.getResources();
        View view = this.f1401b;
        if (view != null) {
            view.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f080db2));
        }
        LoadingProgressBar loadingProgressBar = this.f1402c;
        if (loadingProgressBar != null) {
            loadingProgressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f080db5));
        }
        TextView textView = this.f1403d;
        if (textView != null) {
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0607f3));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d05a7);
            b();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f1405f) {
            try {
                super.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
