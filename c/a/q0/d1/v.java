package c.a.q0.d1;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.performance.speed.SpeedRuntime;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(boolean z) {
        InterceptResult invokeZ;
        Object d2;
        Intent intent;
        ComponentName component;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65536, null, z)) == null) {
            Object d3 = c.a.e.e.b.a.a.d(Looper.myQueue(), "mMessages");
            if (d3 != null && (d3 instanceof Message)) {
                Message message = (Message) d3;
                int i2 = 0;
                while (message != null) {
                    Object obj = message.obj;
                    if (obj == null || i2 >= 10) {
                        break;
                    }
                    i2++;
                    if (obj != null && (d2 = c.a.e.e.b.a.a.d(obj, "intent")) != null && (d2 instanceof Intent) && (component = (intent = (Intent) d2).getComponent()) != null) {
                        try {
                            Class.forName(component.getClassName());
                        } catch (Throwable unused) {
                            StatisticItem statisticItem = new StatisticItem("check_change_intent_tologo");
                            StringBuilder sb = new StringBuilder();
                            sb.append(i2 == 1);
                            sb.append("");
                            TiebaStatic.log(statisticItem.param("obj_param1", sb.toString()).param(TiebaStatic.Params.OBJ_PARAM2, component.getClassName()));
                            if (z && i2 == 1) {
                                intent.setClassName(TbadkCoreApplication.getInst(), SpeedRuntime.SPLASH_ACTIVITY_NAME);
                            }
                            return false;
                        }
                    }
                    Object d4 = c.a.e.e.b.a.a.d(message, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                    message = (d4 == null || !(d4 instanceof Message)) ? null : (Message) d4;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Object d2 = c.a.e.e.b.a.a.d(Looper.myQueue(), "mMessages");
            boolean z = false;
            if (d2 != null && (d2 instanceof Message)) {
                Message message = (Message) d2;
                int i2 = 0;
                while (message != null && message.obj != null && !z && i2 < 10) {
                    i2++;
                    z = c(message);
                    Object d3 = c.a.e.e.b.a.a.d(message, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                    message = (d3 == null || !(d3 instanceof Message)) ? null : (Message) d3;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static final boolean c(Message message) {
        InterceptResult invokeL;
        Object obj;
        Object d2;
        ComponentName component;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, message)) == null) ? (message == null || (obj = message.obj) == null || (d2 = c.a.e.e.b.a.a.d(obj, "intent")) == null || !(d2 instanceof Intent) || (component = ((Intent) d2).getComponent()) == null || !SpeedRuntime.SPLASH_ACTIVITY_NAME.equals(component.getClassName())) ? false : true : invokeL.booleanValue;
    }
}
