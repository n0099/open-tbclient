package androidx.cardview;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$style {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: Base_CardView */
    public static final int obfuscated_res_0x7f100016 = 2131755030;

    /* renamed from: CardView */
    public static final int obfuscated_res_0x7f1000fc = 2131755260;

    /* renamed from: CardView_Dark */
    public static final int obfuscated_res_0x7f1000fe = 2131755262;

    /* renamed from: CardView_Light */
    public static final int obfuscated_res_0x7f1000ff = 2131755263;
    public transient /* synthetic */ FieldHolder $fh;

    public R$style() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
