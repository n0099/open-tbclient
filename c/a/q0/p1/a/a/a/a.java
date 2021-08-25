package c.a.q0.p1.a.a.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import c.a.p0.c.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class a extends c.a.p0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // c.a.p0.c.a, c.a.p0.c.d
    public f b(Object obj, HashMap<String, String> hashMap, String str) {
        InterceptResult invokeLLL;
        Map.Entry<String, String> next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, hashMap, str)) == null) {
            Context baseContext = TbadkCoreApplication.getInst().getBaseContext();
            f fVar = new f();
            if (obj instanceof c.a.q0.o1.o.j.a) {
                c.a.q0.o1.o.j.a aVar = (c.a.q0.o1.o.j.a) obj;
                Intent intent = new Intent(baseContext, AlarmReceiver.class);
                Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext() && (next = it.next()) != null) {
                    intent.putExtra(next.getKey(), next.getValue());
                    if ("task_id".equals(next.getKey())) {
                        i2 = Integer.parseInt(next.getValue());
                    }
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                intent.setData(Uri.parse(currentAccount));
                fVar.f12952a = PendingIntent.getBroadcast(baseContext, i2, intent, 536870912) != null;
                aVar.m(true);
                aVar.l(fVar.f12952a);
            }
            return fVar;
        }
        return (f) invokeLLL.objValue;
    }

    @Override // c.a.p0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interview/checkInterviewNoticeStatus" : (String) invokeV.objValue;
    }
}
