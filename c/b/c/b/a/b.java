package c.b.c.b.a;

import android.app.ActivityManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, processErrorStateInfo)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("|------------- processErrorStateInfo--------------|\n");
            sb.append("condition: " + processErrorStateInfo.condition + StringUtils.LF);
            sb.append("processName: " + processErrorStateInfo.processName + StringUtils.LF);
            sb.append("pid: " + processErrorStateInfo.pid + StringUtils.LF);
            sb.append("uid: " + processErrorStateInfo.uid + StringUtils.LF);
            sb.append("tag: " + processErrorStateInfo.tag + StringUtils.LF);
            sb.append("shortMsg : " + processErrorStateInfo.shortMsg + StringUtils.LF);
            sb.append("longMsg : " + processErrorStateInfo.longMsg + StringUtils.LF);
            sb.append("-----------------------end----------------------------");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
