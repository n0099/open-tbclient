package c.g.a0.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.channel.csj.R;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.fun.module.csj.e0 a(TTNativeAd tTNativeAd) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tTNativeAd)) == null) {
            int imageMode = tTNativeAd.getImageMode();
            if (imageMode == 15) {
                i2 = R.layout.fun_csj_ad_native_vertical_video_view;
            } else if (imageMode == 16) {
                i2 = R.layout.fun_csj_ad_native_vertical_img_view;
            } else if (imageMode == 2) {
                i2 = R.layout.fun_csj_ad_native_small_img_view;
            } else if (imageMode == 3) {
                i2 = R.layout.fun_csj_ad_native_large_img_view;
            } else if (imageMode == 4) {
                i2 = R.layout.fun_csj_ad_native_group_img_view;
            } else if (imageMode != 5) {
                return null;
            } else {
                i2 = R.layout.fun_csj_ad_native_large_video_view;
            }
            com.fun.module.csj.e0 e0Var = (com.fun.module.csj.e0) LayoutInflater.from(FunAdSdk.getAppContext()).inflate(i2, (ViewGroup) null);
            e0Var.a(tTNativeAd);
            return e0Var;
        }
        return (com.fun.module.csj.e0) invokeL.objValue;
    }
}
