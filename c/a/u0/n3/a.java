package c.a.u0.n3;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.r.z0;
import c.a.u0.t1.l.c.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.ScreenLockSyncSwitch;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.u0.n3.d> f19742b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.u0.n3.d f19743c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.u0.l4.c f19744d;

    /* renamed from: e  reason: collision with root package name */
    public int f19745e;

    /* renamed from: f  reason: collision with root package name */
    public int f19746f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19747g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f19748h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f19749i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f19750j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* renamed from: c.a.u0.n3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1219a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public HandlerC1219a(a aVar) {
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
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                this.a.q(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2012125 || customResponsedMessage.getCmd() == 2012121 || customResponsedMessage.getCmd() == 2012123) {
                this.a.r(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.n()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (this.a.f19744d.c()) {
                        this.a.p(remindRecommendMessage);
                    } else {
                        this.a.o(remindRecommendMessage);
                    }
                    if (remindRecommendMessage.isLocal) {
                        TiebaStatic.log(new StatisticItem("c10316").param("obj_type", 2).param("obj_locate", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10316").param("obj_type", 1).param("obj_locate", 1));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19751e;

        public f(a aVar) {
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
            this.f19751e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19751e.f19744d.e();
            }
        }
    }

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
                return;
            }
        }
        this.f19742b = new LinkedList();
        this.f19743c = null;
        this.f19748h = new HandlerC1219a(this);
        this.f19749i = new b(this, 0);
        this.f19750j = new c(this, 0);
        this.k = new d(this, 2005016);
        this.l = new e(this, 2001355);
        this.a = TbadkApplication.getInst().getApp();
        MessageManager.getInstance().registerListener(2016004, this.f19749i);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(2012125, this.f19750j);
        MessageManager.getInstance().registerListener(2012121, this.f19750j);
        MessageManager.getInstance().registerListener(2012123, this.f19750j);
        MessageManager.getInstance().registerListener(this.l);
        this.f19746f = 0;
        this.f19744d = new c.a.u0.l4.c();
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (m == null) {
                m = new a();
            }
            return m;
        }
        return (a) invokeV.objValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(TbadkCoreApplication.getCurrentAccount());
            sb.append("remind_recommend_server_switch");
            return TbadkSettings.getInst().loadInt(sb.toString(), 1) == 1;
        }
        return invokeV.booleanValue;
    }

    public void c(c.a.u0.n3.d dVar) {
        List<c.a.u0.n3.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (list = this.f19742b) == null) {
            return;
        }
        list.add(dVar);
    }

    public boolean d(ChatMessage chatMessage) {
        InterceptResult invokeL;
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) {
            if (chatMessage != null && (msgType = chatMessage.getMsgType()) != 6 && msgType != 22 && msgType != 23) {
                switch (msgType) {
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        if (!StringUtils.isNull(chatMessage.getContent()) && !StringUtils.isNull(chatMessage.getUserInfo().getUserName()) && !chatMessage.getUserInfo().getUserName().equalsIgnoreCase(TbadkCoreApplication.getCurrentAccountName())) {
                            return true;
                        }
                        break;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public c.a.u0.n3.d e(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            c.a.u0.n3.d dVar = new c.a.u0.n3.d();
            if (imMessageCenterPojo == null) {
                return dVar;
            }
            dVar.f19765i = imMessageCenterPojo.getUnread_count();
            dVar.f19766j = imMessageCenterPojo.getGid();
            dVar.f19764h = imMessageCenterPojo.getCustomGroupType();
            dVar.a = imMessageCenterPojo.getGroup_name();
            dVar.f19758b = imMessageCenterPojo.getLast_user_name();
            dVar.f19759c = imMessageCenterPojo.getNameShow();
            dVar.l = imMessageCenterPojo.getLast_content_time();
            if (dVar.f19764h == 1) {
                dVar.f19761e = dVar.f19758b + ":" + imMessageCenterPojo.getLast_content();
            } else {
                dVar.f19761e = imMessageCenterPojo.getLast_content();
            }
            dVar.s = c.a.d.f.m.b.g(imMessageCenterPojo.getTaskId(), 0L);
            return dVar;
        }
        return (c.a.u0.n3.d) invokeL.objValue;
    }

    public c.a.u0.n3.d f(ChatMessage chatMessage, int i2) {
        InterceptResult invokeLI;
        a.C1387a c1387a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, chatMessage, i2)) == null) {
            c.a.u0.n3.d dVar = new c.a.u0.n3.d();
            dVar.f19765i = 0;
            chatMessage.getMsgType();
            dVar.f19764h = i2;
            dVar.f19758b = chatMessage.getUserInfo().getUserName();
            dVar.f19759c = chatMessage.getUserInfo().getName_show();
            chatMessage.getRecordId();
            dVar.m = chatMessage.getMsgId();
            dVar.n = true;
            dVar.o = true;
            dVar.p = 1;
            dVar.s = chatMessage.getStatTaskId();
            dVar.t = chatMessage.getStatisticsServiceId();
            int i3 = dVar.f19764h;
            if (i3 == 1) {
                ImMessageCenterPojo i4 = c.a.u0.t1.k.b.o().i(chatMessage.getGroupId(), 1);
                if (i4 != null) {
                    dVar.a = i4.getGroup_name();
                    dVar.f19765i = i4.getUnread_count();
                    dVar.l = i4.getLast_content_time();
                }
                dVar.f19761e = dVar.f19758b + ":" + c.a.u0.t1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
                dVar.f19766j = chatMessage.getGroupId();
                if (!c.a.t0.t.d.d.d().p()) {
                    dVar.n = false;
                } else {
                    dVar.n = c.a.u0.t1.t.b.k().c(TbadkCoreApplication.getCurrentAccount(), dVar.f19766j);
                }
            } else if (i3 == 2) {
                dVar.f19766j = chatMessage.getUserInfo().getUserId();
                ImMessageCenterPojo i5 = c.a.u0.t1.k.b.o().i(dVar.f19766j, 2);
                if (i5 != null) {
                    dVar.f19765i = i5.getUnread_count();
                    dVar.l = i5.getLast_content_time();
                    dVar.o = i5.getIsFriend() == 1;
                    dVar.p = i5.getFollowStatus();
                }
                dVar.a = chatMessage.getUserInfo().getUserName();
                dVar.f19761e = c.a.u0.t1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
                if (dVar.o) {
                    if (!c.a.t0.t.d.d.d().r()) {
                        dVar.n = false;
                    } else {
                        dVar.n = c.a.u0.t1.t.e.j().c(TbadkCoreApplication.getCurrentAccount(), dVar.f19766j);
                    }
                } else if (!c.a.t0.t.d.d.d().r()) {
                    dVar.n = false;
                } else if (!c.a.t0.t.d.d.d().B()) {
                    dVar.n = false;
                } else {
                    dVar.n = c.a.u0.t1.t.e.j().c(TbadkCoreApplication.getCurrentAccount(), dVar.f19766j);
                }
            } else if (i3 == 4) {
                String userId = chatMessage.getUserInfo().getUserId();
                dVar.f19766j = userId;
                if (!TbConfig.IM_USER_ID_TBJX.equals(userId) && !"2807977073".equals(dVar.f19766j)) {
                    return null;
                }
                ImMessageCenterPojo i6 = c.a.u0.t1.k.b.o().i(dVar.f19766j, 4);
                if (i6 != null) {
                    dVar.f19765i = i6.getUnread_count();
                    dVar.l = i6.getLast_content_time();
                    dVar.o = i6.getIsFriend() == 1;
                    dVar.p = i6.getFollowStatus();
                }
                dVar.a = chatMessage.getUserInfo().getUserName();
                if (chatMessage.getMsgType() == 7) {
                    List<a.C1387a> a = c.a.u0.t1.l.c.a.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a != null && a.size() > 0 && (c1387a = a.get(0)) != null) {
                        dVar.f19760d = c1387a.a;
                        dVar.f19761e = c1387a.f22645b;
                        dVar.f19762f = c1387a.f22646c;
                        dVar.q = c1387a.f22647d;
                        dVar.s = c1387a.k;
                        dVar.t = c1387a.l;
                    }
                } else {
                    dVar.f19761e = c.a.u0.t1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
                }
                if (!c.a.t0.t.d.d.d().m()) {
                    dVar.n = false;
                }
            }
            return dVar;
        }
        return (c.a.u0.n3.d) invokeLI.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.t0.t.d.d.d().h() && c.a.t0.t.d.d.d().u() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public void h(c.a.u0.n3.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f19742b.remove(dVar);
    }

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("https?://tieba.baidu.com/p/(\\d+)\\?.*").matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final Intent k(Context context, z0 z0Var, String str) {
        InterceptResult invokeLLL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, z0Var, str)) == null) {
            if (context == null || z0Var == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(context, DealIntentService.class);
            if (!str.startsWith("http://tieba.baidu.com/p/") && !str.startsWith("http://tieba.baidu.com/p/")) {
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                    String substring2 = str.substring(str.lastIndexOf(":") + 1);
                    intent.putExtra(DealIntentService.KEY_CLASS, 1);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("id", substring2);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                    if (!str.contains("ftid=")) {
                        return null;
                    }
                    intent.putExtra(DealIntentService.KEY_CLASS, 29);
                    intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
                } else if (str.startsWith("pk_before:")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 6);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith("pk_after:")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 7);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith("vote")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 8);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 31);
                    String substring3 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
                    if (substring3.startsWith("pid=")) {
                        substring = substring3.substring(substring3.lastIndexOf("pid=") + 4);
                    } else {
                        substring = substring3.startsWith("http://") ? substring3.substring(substring3.lastIndexOf("p/") + 2) : "";
                    }
                    if (StringUtils.isNull(substring)) {
                        return null;
                    }
                    intent.putExtra("tid", substring);
                } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    return null;
                } else {
                    intent.putExtra(DealIntentService.KEY_CLASS, 0);
                    intent.putExtra("url", str);
                }
            } else {
                String substring4 = str.substring(str.lastIndexOf("/") + 1);
                intent.putExtra(DealIntentService.KEY_CLASS, 1);
                intent.putExtra("key_start_from", 7);
                intent.putExtra("id", substring4);
            }
            intent.putExtra("is_notify", true);
            intent.putExtra("link", str);
            intent.putExtra("message_id", z0Var.c());
            intent.putExtra("task_id", z0Var.e());
            if (!TextUtils.isEmpty(z0Var.d())) {
                intent.putExtra("stat", z0Var.d());
            }
            return intent;
        }
        return (Intent) invokeLLL.objValue;
    }

    public c.a.u0.n3.d l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19743c : (c.a.u0.n3.d) invokeV.objValue;
    }

    public List<c.a.u0.n3.d> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f19742b);
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void o(RemindRecommendMessage remindRecommendMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, remindRecommendMessage) == null) || remindRecommendMessage == null) {
            return;
        }
        c.a.u0.n3.d dVar = new c.a.u0.n3.d();
        dVar.f19765i = 0;
        dVar.f19766j = "-1";
        dVar.f19764h = 4;
        String str = remindRecommendMessage.name;
        dVar.a = str;
        dVar.f19758b = str;
        dVar.f19760d = remindRecommendMessage.title;
        dVar.f19762f = remindRecommendMessage.picture;
        dVar.q = remindRecommendMessage.url;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
        dVar.o = true;
        dVar.p = 1;
        dVar.s = 0L;
        if (remindRecommendMessage.isLocal) {
            dVar.r = "2";
        } else {
            dVar.r = "1";
        }
        c(dVar);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, remindRecommendMessage) == null) || remindRecommendMessage == null || (str = remindRecommendMessage.url) == null || str.length() <= 0) {
            return;
        }
        Intent k = k(this.a, new z0(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
        if (k == null) {
            return;
        }
        PendingIntent service = PendingIntent.getService(this.a, 0, k, 134217728);
        Context context = this.a;
        String str2 = remindRecommendMessage.name;
        String str3 = remindRecommendMessage.title;
        NotificationHelper.showNotification(context, 2000, str2, str3, str3, service, false);
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public void q(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof MemoryChangedMessage) || (data = ((MemoryChangedMessage) customResponsedMessage).getData()) == null || data.getUnread_count() > 0) {
            return;
        }
        h(e(data));
    }

    public List<ChatMessage> r(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, responsedMessage)) == null) {
            if (responsedMessage instanceof GroupMsgData) {
                GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
                int customType = groupMsgData.getGroupInfo().getCustomType();
                if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().isEmpty()) {
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(groupMsgData.getListMessage());
                v(linkedList, customType);
                return linkedList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f19742b.clear();
            this.f19743c = null;
        }
    }

    public final boolean t(ChatMessage chatMessage, c.a.u0.n3.d dVar) {
        InterceptResult invokeLL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, chatMessage, dVar)) == null) {
            if (dVar != null && !StringUtils.isNull(dVar.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(dVar.q))) != null && c.a.d.f.m.b.e(paramPair.get("lockWindow"), 0) == 1) {
                long j2 = dVar.s;
                String i2 = i(dVar.q);
                if (j2 == 0 || StringUtils.isNull(i2) || UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
                    return false;
                }
                if (!this.f19744d.c()) {
                    Activity b2 = c.a.d.a.b.f().b();
                    if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                        b2.finish();
                    }
                    chatMessage.setHasRead(true);
                    NotificationHelper.cancelNotification(this.a, 19);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(this.a, j2, i2)));
                }
                TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 1).param("obj_source", 2).param("tid", i2));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void u() {
        c.a.u0.n3.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            List<c.a.u0.n3.d> list = this.f19742b;
            if ((list == null || list.size() == 0) && this.f19743c == null) {
                return;
            }
            if (!this.f19744d.c() || this.f19746f == 1) {
                Activity b2 = c.a.d.a.b.f().b();
                if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                    b2.finish();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.a)));
                this.f19748h.postDelayed(new f(this), 1000L);
                List<c.a.u0.n3.d> list2 = this.f19742b;
                if (list2 == null || list2.size() <= 0 || (dVar = this.f19742b.get(0)) == null) {
                    return;
                }
                TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", dVar.m / 100).param("task_id", dVar.s));
            }
        }
    }

    public void v(List<ChatMessage> list, int i2) {
        c.a.u0.n3.d f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, list, i2) == null) || list == null || list.isEmpty()) {
            return;
        }
        boolean z = false;
        for (ChatMessage chatMessage : list) {
            if (chatMessage != null && d(chatMessage) && (f2 = f(chatMessage, i2)) != null && f2.f19765i > 0) {
                if (f2.n) {
                    if (i2 == 4) {
                        if (t(chatMessage, f2)) {
                            return;
                        }
                        c(f2);
                    } else {
                        this.f19743c = f2;
                    }
                    z = true;
                } else {
                    h(f2);
                }
            }
        }
        if (z) {
            u();
        }
    }
}
