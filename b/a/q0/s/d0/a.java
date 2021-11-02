package b.a.q0.s.d0;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.a.d0.d;
import b.a.q0.t.g.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static a f12908i;
    public static CustomMessageListener j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12909a;

    /* renamed from: b  reason: collision with root package name */
    public int f12910b;

    /* renamed from: c  reason: collision with root package name */
    public int f12911c;

    /* renamed from: d  reason: collision with root package name */
    public int f12912d;

    /* renamed from: e  reason: collision with root package name */
    public int f12913e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f12914f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f12915g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.e.e.l.c<b.a.e.l.d.a> f12916h;

    /* renamed from: b.a.q0.s.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0674a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f12917a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0674a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12917a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                f.c(((ShareEvent) customResponsedMessage.getData()).channel);
                this.f12917a.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f12918a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12918a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null || this.f12918a.f12914f == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || this.f12918a.d(currentActivity) == null) {
                return;
            }
            TbSingleton.getInstance().setNewUserRedPackageData(this.f12918a.f12914f);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921532));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-80444904, "Lb/a/q0/s/d0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-80444904, "Lb/a/q0/s/d0/a;");
                return;
            }
        }
        j = new b(2921440);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12915g = new C0674a(this, 2921406);
        this.f12916h = new c(this);
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f12908i == null) {
                synchronized (a.class) {
                    if (f12908i == null) {
                        f12908i = new a();
                    }
                }
            }
            return f12908i;
        }
        return (a) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.q0.s.e0.b.j().C("task_share_thread_success_data_total_limit");
            b.a.q0.s.e0.b.j().C("task_share_thread_success_data_mission_id");
            b.a.q0.s.e0.b.j().C("task_share_thread_success_data_action_id");
            b.a.q0.s.e0.b.j().C("task_share_thread_success_data_specific_clear_time");
        }
    }

    public final TbPageContext d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.f12915g);
            MessageManager.getInstance().registerListener(j);
        }
    }

    public void g(MissionInfo missionInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, missionInfo) == null) || missionInfo == null || missionInfo.activityid.intValue() == 0 || missionInfo.missionid.intValue() == 0) {
            return;
        }
        this.f12911c = missionInfo.activityid.intValue();
        this.f12909a = missionInfo.missionid.intValue();
        this.f12910b = missionInfo.total_limit.intValue();
        this.f12913e = missionInfo.cleartype.intValue();
        this.f12912d = missionInfo.cleartime.intValue();
        b.a.q0.a.c cVar = new b.a.q0.a.c();
        cVar.X(this.f12912d);
        cVar.Y(this.f12913e);
        b.a.q0.s.e0.b.j().v("task_share_thread_success_data_total_limit", this.f12910b);
        b.a.q0.s.e0.b.j().v("task_share_thread_success_data_mission_id", this.f12909a);
        b.a.q0.s.e0.b.j().v("task_share_thread_success_data_action_id", this.f12911c);
        b.a.q0.s.e0.b.j().w("task_share_thread_success_data_specific_clear_time", cVar.c());
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(5);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            completeTaskReqMsg.extra = new d.g();
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public void i() {
        Activity currentActivity;
        TbPageContext d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d2 = d(currentActivity)) == null || !b.a.e.a.b.g().i("MainTabActivity")) {
            return;
        }
        d2.sendMessage(new CustomMessage(2002001, new UserTropicGiftBagActivityConfig(d2.getPageActivity())));
    }

    public void j(b.a.q0.a.b0.b bVar) {
        Activity currentActivity;
        TbPageContext d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        ActiveCenterData activeCenterData = bVar.f11685g;
        if ((activeCenterData != null && activeCenterData.is_new_window) || !bVar.f11680b || StringUtils.isNull(bVar.f11681c) || TbSingleton.getInstance().isNewUserRedPackageShowed() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d2 = d(currentActivity)) == null) {
            return;
        }
        this.f12914f = bVar.f11684f;
        b.a.e.e.l.d.h().k(this.f12914f.topPicUrl, 10, this.f12916h, 0, 0, d2.getUniqueId(), new Object[0]);
    }

    public void k() {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && TbadkCoreApplication.isLogin()) {
            int k2 = b.a.q0.s.e0.b.j().k("task_share_thread_success_data_mission_id", 0);
            int k3 = b.a.q0.s.e0.b.j().k("task_share_thread_success_data_action_id", 0);
            long l = b.a.q0.s.e0.b.j().l("task_share_thread_success_data_specific_clear_time", 0L);
            b.a.q0.a.c cVar = new b.a.q0.a.c();
            cVar.d0(l);
            if (cVar.M()) {
                c();
            } else if (k3 == 0 || k2 == 0 || (k = b.a.q0.s.e0.b.j().k("task_share_thread_success_data_total_limit", 0)) <= 0) {
            } else {
                b.a.q0.s.e0.b.j().v("task_share_thread_success_data_total_limit", k - 1);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(String.valueOf(k3), String.valueOf(k2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                h(jSONObject.toString());
            }
        }
    }
}
