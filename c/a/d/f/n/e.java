package c.a.d.f.n;

import android.content.Context;
import c.a.d.f.p.l;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (l.H()) {
                return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
            }
            if (l.x()) {
                int f2 = l.f();
                StringBuilder sb = new StringBuilder();
                if (f2 == 1) {
                    sb.append('M');
                } else if (f2 == 2) {
                    sb.append('U');
                } else if (f2 != 3) {
                    sb.append('N');
                } else {
                    sb.append('T');
                }
                if (l.E()) {
                    sb.append("_WAP_");
                } else {
                    sb.append("_NET_");
                }
                if (l.u()) {
                    sb.append("3G");
                } else if (l.v()) {
                    sb.append("4G");
                } else if (l.t()) {
                    sb.append("2G");
                } else {
                    sb.append('N');
                }
                return sb.toString();
            }
            return "unknown";
        }
        return (String) invokeL.objValue;
    }
}
