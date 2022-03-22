package c.a.p0.e0.f;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13762b;

    /* renamed from: c  reason: collision with root package name */
    public String f13763c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            SkinManager.setBackgroundShapeDrawable(this.a, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds5), R.color.cp_cont_b_alpha80, R.color.cp_cont_b_alpha80, i);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setDimAmount(0.0f);
                window.setContentView(R.layout.obfuscated_res_0x7f0d03c7);
                this.a = window.findViewById(R.id.obfuscated_res_0x7f09208a);
                this.f13762b = (TextView) window.findViewById(R.id.obfuscated_res_0x7f092093);
                if (!StringUtils.isNull(this.f13763c)) {
                    this.f13762b.setText(this.f13763c);
                }
                a(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
