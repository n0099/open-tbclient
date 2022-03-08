package c.a.r0.d1.g1.c;

import android.view.View;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.accelerator.ui.AcceleratorFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AcceleratorFragment f15521e;

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
        this.f15521e = acceleratorFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f15521e.f41823g != null && this.f15521e.f41823g.getItemData() != null) {
                TbSingleton.getInstance().removeAcceleratorServer(String.valueOf(this.f15521e.f41823g.getItemData().itemId));
            }
            this.f15521e.Q();
            this.f15521e.getActivity().finish();
        }
    }
}
