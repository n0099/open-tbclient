package c.a.r0.a.c2.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import c.a.r0.a.c;
import c.a.r0.a.d;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends SwanAppAlertDialog.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f5421f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5421f = context;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
    public SwanAppAlertDialog c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f39292e = this.f5421f.getResources().getDimensionPixelSize(d.aiapps_action_sheet_list_item);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f39292e);
            layoutParams.addRule(12);
            this.a.t.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f5421f.getResources().getDimensionPixelSize(d.aiapps_action_sheet_bottom_divider));
            layoutParams2.addRule(2, this.a.t.getId());
            this.a.f39308h.setLayoutParams(layoutParams2);
            o(c.aiapps_action_sheet_split_color);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(2, this.a.f39308h.getId());
            this.a.u.setLayoutParams(layoutParams3);
            return super.c();
        }
        return (SwanAppAlertDialog) invokeV.objValue;
    }
}
