package c.a.q0.s.h;

import android.text.TextUtils;
import c.a.d.m.d;
import c.a.d.m.e;
import c.a.d.m.i;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(IconStampData iconStampData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iconStampData)) == null) {
            if (iconStampData == null) {
                return false;
            }
            String c2 = c(iconStampData.stampType);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            return !StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(c2)) && new File(i.b(c2)).exists();
        }
        return invokeL.booleanValue;
    }

    public static void b(boolean z) {
        String c2;
        String c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            if (z) {
                c2 = c(1);
                c3 = c(3);
            } else {
                c2 = c(2);
                c3 = c(4);
            }
            if (TextUtils.isEmpty(c2) || TextUtils.isEmpty(c3)) {
                return;
            }
            String str = BdBaseApplication.getInst().getResHashMap().get(c3);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(c2)) || StringUtils.isNull(str)) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(e.a);
                requestParams.setRunNode("aps");
                ArrayList arrayList = new ArrayList();
                arrayList.add("com.baidu.tieba.resloader." + c2);
                arrayList.add("com.baidu.tieba.resloader." + c3);
                requestParams.addChannel(new d(arrayList, (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
            }
        }
    }

    public static String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return "reply_7_times.mp4";
                    }
                    return "post_7_times.mp4";
                }
                return "reply_1_times.mp4";
            }
            return "post_1_times.mp4";
        }
        return (String) invokeI.objValue;
    }
}
