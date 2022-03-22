package c.d.a0.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes3.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.fun.module.csj.f0 a(TTNativeAd tTNativeAd) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tTNativeAd)) == null) {
            int imageMode = tTNativeAd.getImageMode();
            if (imageMode == 15) {
                i = R.layout.obfuscated_res_0x7f0d036c;
            } else if (imageMode == 16) {
                i = R.layout.obfuscated_res_0x7f0d036b;
            } else if (imageMode == 2) {
                i = R.layout.obfuscated_res_0x7f0d036a;
            } else if (imageMode == 3) {
                i = R.layout.obfuscated_res_0x7f0d0368;
            } else if (imageMode == 4) {
                i = R.layout.obfuscated_res_0x7f0d0367;
            } else if (imageMode != 5) {
                return null;
            } else {
                i = R.layout.obfuscated_res_0x7f0d0369;
            }
            com.fun.module.csj.f0 f0Var = (com.fun.module.csj.f0) LayoutInflater.from(FunAdSdk.getAppContext()).inflate(i, (ViewGroup) null);
            f0Var.a(tTNativeAd);
            return f0Var;
        }
        return (com.fun.module.csj.f0) invokeL.objValue;
    }
}
