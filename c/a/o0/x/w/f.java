package c.a.o0.x.w;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import c.a.o0.x.m;
import c.a.o0.x.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.pb.PbNewInputContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
        this.l = 3;
        PbNewInputContainer pbNewInputContainer = new PbNewInputContainer(context);
        this.k = pbNewInputContainer;
        pbNewInputContainer.setTransLink(!z);
        this.r = ((PbNewInputContainer) this.k).getInputView();
        ((PbNewInputContainer) this.k).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.k).updateLocationVisibility(z2);
        this.n = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void g(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, textWatcher) == null) {
            this.r.addTextChangedListener(textWatcher);
        }
    }

    public void h(int i2) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (nVar = this.k) == null) {
            return;
        }
        ((PbNewInputContainer) nVar).applyType(i2);
    }

    public EditText i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : (EditText) invokeV.objValue;
    }

    public void j(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, textWatcher) == null) {
            this.r.removeTextChangedListener(textWatcher);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.k == null || StringUtils.isNull(str)) {
            return;
        }
        ((PbNewInputContainer) this.k).setDefaultHint(str);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.k == null || StringUtils.isNull(str)) {
            return;
        }
        ((PbNewInputContainer) this.k).setHint(str);
    }

    public void m(int i2) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (nVar = this.k) == null) {
            return;
        }
        ((PbNewInputContainer) nVar).setType(i2);
    }
}
