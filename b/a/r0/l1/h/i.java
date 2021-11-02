package b.a.r0.l1.h;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static i f20146c = null;

    /* renamed from: d  reason: collision with root package name */
    public static long f20147d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f20148e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f20149a;

    /* renamed from: b  reason: collision with root package name */
    public c f20150b;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f20151a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
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
            this.f20151a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    this.f20151a.f20149a.sendMessageDelayed(this.f20151a.f20149a.obtainMessage(1), 30000L);
                    return;
                }
                this.f20151a.f20149a.removeMessages(1);
                this.f20151a.j();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends Handler {
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

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                i.i().f20149a.removeMessages(1);
                i.i().h();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Object, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(i iVar, a aVar) {
            this(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                LinkedList<ImMessageCenterPojo> h2 = j.f().h();
                if (h2 != null && h2.size() != 0) {
                    if (i.f20147d < 0) {
                        try {
                            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                            long unused = i.f20147d = statFs.getAvailableBlocks() * statFs.getBlockSize();
                            if (i.f20147d > 2147483648L) {
                                int unused2 = i.f20148e = 5000;
                            } else if (i.f20147d > 1073741824) {
                                int unused3 = i.f20148e = 3000;
                            } else {
                                int unused4 = i.f20148e = 1000;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2);
                        }
                    }
                    if (i.f20148e < 1000) {
                        int unused5 = i.f20148e = 1000;
                    }
                    try {
                        try {
                            h.d().f();
                            for (ImMessageCenterPojo imMessageCenterPojo : h2) {
                                if (isCancelled()) {
                                    h.d().b();
                                    return Boolean.FALSE;
                                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                                    b.a.r0.l1.h.c.h().n(imMessageCenterPojo.getGid(), i.f20148e);
                                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                                    m.t().q(imMessageCenterPojo.getGid(), i.f20148e);
                                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                                    l.t().q(imMessageCenterPojo.getGid(), i.f20148e);
                                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                                    d.f().l(imMessageCenterPojo.getGid(), i.f20148e);
                                }
                            }
                        } catch (Exception e3) {
                            BdLog.e(e3.getMessage());
                        }
                        h.d().b();
                        return Boolean.TRUE;
                    } finally {
                        h.d().b();
                    }
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2110430649, "Lb/a/r0/l1/h/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2110430649, "Lb/a/r0/l1/h/i;");
        }
    }

    public i() {
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
        this.f20149a = new b(null);
        this.f20150b = null;
        MessageManager.getInstance().registerListener(new a(this, 2001011));
    }

    public static i i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f20146c == null) {
                synchronized (i.class) {
                    if (f20146c == null) {
                        f20146c = new i();
                    }
                }
            }
            return f20146c;
        }
        return (i) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = this.f20150b;
            if (cVar != null) {
                cVar.cancel();
                this.f20150b = null;
            }
            c cVar2 = new c(this, null);
            this.f20150b = cVar2;
            cVar2.setParallel(TiebaIMConfig.getParallel());
            this.f20150b.setPriority(4);
            this.f20150b.execute(new String[0]);
        }
    }

    public final void j() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f20150b) == null) {
            return;
        }
        cVar.cancel();
        this.f20150b = null;
    }
}
