package c.a.u0.e1.q1.c;

import android.view.View;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.accelerator.ui.AcceleratorFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AcceleratorFragment f16930e;

    public h(AcceleratorFragment acceleratorFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {acceleratorFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16930e = acceleratorFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f16930e.f43420g != null && this.f16930e.f43420g.getItemData() != null) {
                TbSingleton.getInstance().removeAcceleratorServer(String.valueOf(this.f16930e.f43420g.getItemData().itemId));
            }
            this.f16930e.Q();
            this.f16930e.getActivity().finish();
        }
    }
}
