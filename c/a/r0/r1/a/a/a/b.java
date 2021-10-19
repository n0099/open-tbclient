package c.a.r0.r1.a.a.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import c.a.q0.c.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends c.a.q0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.q0.c.a, c.a.q0.c.d
    public f b(Object obj, HashMap<String, String> hashMap, String str) {
        InterceptResult invokeLLL;
        Map.Entry<String, String> next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, hashMap, str)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            f fVar = new f();
            if (obj instanceof c.a.r0.q1.o.j.a) {
                c.a.r0.q1.o.j.a aVar = (c.a.r0.q1.o.j.a) obj;
                boolean c2 = aVar.c();
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent(context, AlarmReceiver.class);
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                intent.putExtra("uid", TbadkCoreApplication.getCurrentAccount());
                intent.setData(Uri.parse(currentAccount));
                long j2 = 0;
                Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext() && (next = it.next()) != null) {
                    intent.putExtra(next.getKey(), next.getValue());
                    if ("task_id".equals(next.getKey())) {
                        i2 = Integer.parseInt(next.getValue());
                    } else if ("s_time".equals(next.getKey())) {
                        j2 = Long.parseLong(next.getValue()) * 1000;
                    }
                }
                StatisticItem statisticItem = new StatisticItem(aVar.i());
                statisticItem.param("obj_id", "");
                if (c2) {
                    statisticItem.param("obj_type", "2");
                    BdToast.c(context, context.getString(R.string.interview_close_tip)).q();
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, 536870912);
                    if (broadcast != null) {
                        alarmManager.cancel(broadcast);
                        broadcast.cancel();
                    }
                    fVar.f12805a = false;
                } else {
                    statisticItem.param("obj_type", "1");
                    BdToast.c(context, context.getString(R.string.interview_open_tip)).q();
                    alarmManager.set(0, j2, PendingIntent.getBroadcast(context, i2, intent, 134217728));
                    fVar.f12805a = true;
                }
                TiebaStatic.log(statisticItem);
                aVar.l(fVar.f12805a);
            }
            return fVar;
        }
        return (f) invokeLLL.objValue;
    }

    @Override // c.a.q0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interview/registerInterviewNotice" : (String) invokeV.objValue;
    }
}
