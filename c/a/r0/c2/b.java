package c.a.r0.c2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.myCollection.CollectUpdateReceiver;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeHttpResponseMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeRequestMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static b f16447b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f16448a;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                List<String> list = Collections.EMPTY_LIST;
                if (responsedMessage instanceof GetStoreRemindTimeHttpResponseMessage) {
                    list = ((GetStoreRemindTimeHttpResponseMessage) responsedMessage).getTimeList();
                } else if (responsedMessage instanceof GetStoreRemindTimeSocketResponseMessage) {
                    list = ((GetStoreRemindTimeSocketResponseMessage) responsedMessage).getTimeList();
                }
                if (list.isEmpty()) {
                    return;
                }
                c.a.q0.s.d0.b.j().x("collect_update_time_key", new JSONArray((Collection) list).toString());
                b.b().g();
            }
        }
    }

    /* renamed from: c.a.r0.c2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0791b implements Comparator<Calendar> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0791b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Calendar calendar, Calendar calendar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, calendar, calendar2)) == null) ? calendar.before(calendar2) ? -1 : 1 : invokeLL.intValue;
        }
    }

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
                return;
            }
        }
        this.f16448a = false;
        MessageManager.getInstance().registerListener(new a(this, CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, 309117));
        c.a.r0.j3.d0.a.g(309117, GetStoreRemindTimeSocketResponseMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, c.a.r0.j3.d0.a.a("c/f/livegroup/getStoreRemindTime", 309117));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GetStoreRemindTimeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f16447b == null) {
                synchronized (b.class) {
                    if (f16447b == null) {
                        f16447b = new b();
                    }
                }
            }
            return f16447b;
        }
        return (b) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long l = c.a.q0.s.d0.b.j().l("collect_request_time_key", -1L);
            if (l == -1) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - l;
            return currentTimeMillis > 0 && TimeUnit.MILLISECONDS.toDays(currentTimeMillis) >= 1;
        }
        return invokeV.booleanValue;
    }

    public final Calendar c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String p = c.a.q0.s.d0.b.j().p("collect_update_time_key", null);
            if (TextUtils.isEmpty(p)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Calendar calendar = Calendar.getInstance();
            try {
                JSONArray jSONArray = new JSONArray(p);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        Calendar calendar2 = (Calendar) calendar.clone();
                        calendar2.setTime(simpleDateFormat.parse(optString));
                        calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5));
                        arrayList.add(calendar2);
                    }
                }
            } catch (ParseException e2) {
                BdLog.e(e2.getMessage());
                e2.printStackTrace();
                return null;
            } catch (JSONException e3) {
                BdLog.e(e3.getMessage());
                return null;
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            Collections.sort(arrayList, new C0791b(this));
            Calendar calendar3 = (Calendar) arrayList.get(0);
            Calendar calendar4 = (Calendar) arrayList.get(arrayList.size() - 1);
            if (arrayList.size() == 1 || calendar3.after(calendar) || calendar4.before(calendar)) {
                return calendar3;
            }
            for (int i3 = 1; i3 < arrayList.size(); i3++) {
                Calendar calendar5 = (Calendar) arrayList.get(i3);
                if (!calendar5.before(calendar)) {
                    return calendar5;
                }
            }
            return null;
        }
        return (Calendar) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && a()) {
            MessageManager.getInstance().sendMessage(new GetStoreRemindTimeRequestMessage());
            h();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.f16448a) {
                z = false;
            }
            c.a.q0.s.d0.b.j().t("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), z);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f16448a = z;
        }
    }

    public void g() {
        Calendar c2;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (c2 = c()) == null || (context = TbadkCoreApplication.getInst().getContext()) == null) {
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(CollectUpdateReceiver.ACTION_NAME);
        intent.setPackage(context.getPackageName());
        Calendar calendar = Calendar.getInstance();
        calendar.set(14, 0);
        if (c2.before(calendar)) {
            c2.set(6, calendar.get(6) + 1);
        }
        alarmManager.set(1, c2.getTimeInMillis(), PendingIntent.getBroadcast(context, 0, intent, 134217728));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.q0.s.d0.b.j().w("collect_request_time_key", System.currentTimeMillis());
        }
    }
}
