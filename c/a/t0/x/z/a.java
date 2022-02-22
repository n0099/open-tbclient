package c.a.t0.x.z;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import c.a.t0.x.m;
import c.a.t0.x.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, (String) null, 4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.l = 2;
        this.n = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.k = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 80;
        ((View) this.k).setLayoutParams(layoutParams);
    }

    public void f(int i2) {
        n nVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (nVar = this.k) != null && (nVar instanceof TextView)) {
            ((TextView) nVar).setText(i2);
        }
    }

    public void g(@ColorRes int i2) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (nVar = this.k) == null) {
            return;
        }
        ((SendView) nVar).setTextColor(i2);
    }
}
