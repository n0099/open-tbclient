package c.a.d.f.n.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.n.o.g;
import c.a.d.f.p.r;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static volatile a f2960j;

    /* renamed from: k  reason: collision with root package name */
    public static final Handler f2961k;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2962b;

    /* renamed from: c  reason: collision with root package name */
    public String f2963c;

    /* renamed from: d  reason: collision with root package name */
    public Context f2964d;

    /* renamed from: e  reason: collision with root package name */
    public c f2965e;

    /* renamed from: f  reason: collision with root package name */
    public BdStatSwitchData f2966f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.f.n.m.b f2967g;

    /* renamed from: h  reason: collision with root package name */
    public b f2968h;

    /* renamed from: i  reason: collision with root package name */
    public r f2969i;

    /* renamed from: c.a.d.f.n.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class HandlerC0105a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0105a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof BdUploadStatMsgData) {
                    g.i().r(((BdUploadStatMsgData) obj).parentType);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

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
            this.this$0 = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Serializable serializableExtra;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.baidu.adp.stats.background".equals(action)) {
                BdStatisticsManager.getInstance().save();
                if (this.this$0.a) {
                    g.i().f();
                }
            } else if ("com.baidu.adp.stats.switch".equals(action)) {
                if (this.this$0.a) {
                    return;
                }
                this.this$0.p();
                g.i().s();
            } else if (!"com.baidu.adp.stats.updatecmd".equals(action) || this.this$0.a || (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) == null || !(serializableExtra instanceof BdUploadStatMsgData)) {
            } else {
                BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                if (bdUploadStatMsgData.parentType == null && bdUploadStatMsgData.childType == null) {
                    return;
                }
                String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.this$0.f2966f.putTmpSwitchConfData(str, bdUploadStatMsgData);
                this.this$0.l(bdUploadStatMsgData);
            }
        }

        public /* synthetic */ c(a aVar, HandlerC0105a handlerC0105a) {
            this(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public BdStatSwitchData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
                if (this.a.f2967g.a()) {
                    bdStatSwitchData.parserJson(this.a.f2967g.f2970b);
                }
                this.a.f2962b = false;
                if (this.a.a) {
                    a aVar = this.a;
                    if (aVar.t(aVar.f2967g.f2970b)) {
                        String w = this.a.w();
                        if (!TextUtils.isEmpty(w) && !w.equals(this.a.f2967g.f2970b)) {
                            this.a.f2962b = true;
                            bdStatSwitchData.parserJson(w);
                            this.a.f2967g.b(w);
                        }
                    }
                }
                return bdStatSwitchData;
            }
            return (BdStatSwitchData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdStatSwitchData) == null) {
                super.onPostExecute(bdStatSwitchData);
                if (bdStatSwitchData == null) {
                    return;
                }
                this.a.f2966f = bdStatSwitchData;
                if (this.a.a && this.a.f2962b && !BdBaseApplication.getInst().checkInterrupt()) {
                    this.a.z();
                    g.i().s();
                }
                b bVar = this.a.f2968h;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        public /* synthetic */ d(a aVar, HandlerC0105a handlerC0105a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1912721193, "Lc/a/d/f/n/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1912721193, "Lc/a/d/f/n/m/a;");
                return;
            }
        }
        f2961k = new HandlerC0105a(Looper.getMainLooper());
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
        this.f2962b = false;
        this.f2963c = null;
        this.f2966f = new BdStatSwitchData();
        this.f2967g = new c.a.d.f.n.m.b();
        this.f2968h = null;
    }

    public static a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f2960j == null) {
                synchronized (a.class) {
                    if (f2960j == null) {
                        f2960j = new a();
                    }
                }
            }
            return f2960j;
        }
        return (a) invokeV.objValue;
    }

    public void A(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rVar) == null) {
            this.f2969i = rVar;
        }
    }

    public boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return true;
            }
            return this.f2966f.smallFlowUpload(c.a.d.f.n.j.a.g(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean k(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, bdUploadStatMsgData)) == null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (this.f2966f.getTmpSwitchConfData(str) == null) {
                this.f2966f.putTmpSwitchConfData(str, bdUploadStatMsgData);
                y(bdUploadStatMsgData);
                l(bdUploadStatMsgData);
                return true;
            }
            long j2 = bdUploadStatMsgData.deadLineTime;
            if (0 == j2) {
                this.f2966f.rmTmpSwitchConfData(str);
                return false;
            } else if (0 < j2) {
                this.f2966f.putTmpSwitchConfData(str, bdUploadStatMsgData);
                y(bdUploadStatMsgData);
                l(bdUploadStatMsgData);
                return true;
            } else {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void l(BdUploadStatMsgData bdUploadStatMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUploadStatMsgData) == null) {
            long currentTimeMillis = bdUploadStatMsgData.deadLineTime - System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                return;
            }
            long j2 = currentTimeMillis - 3000;
            if (j2 > 0) {
                currentTimeMillis = j2;
            }
            Message obtainMessage = f2961k.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = bdUploadStatMsgData;
            f2961k.removeMessages(1);
            f2961k.sendMessageDelayed(obtainMessage, currentTimeMillis);
        }
    }

    public int m(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) ? TextUtils.isEmpty(str) ? i2 : this.f2966f.geUploadCycle(str, i2) : invokeLI.intValue;
    }

    public ArrayList<String> n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f2966f.getChiledTypes(str) : (ArrayList) invokeL.objValue;
    }

    public void p() {
        r rVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (rVar = this.f2969i) != null && rVar.isAgreePrivacyPolicy()) {
            d dVar = new d(this, null);
            dVar.setPriority(4);
            dVar.execute(new Object[0]);
        }
    }

    public int q(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) ? TextUtils.isEmpty(str) ? i2 : this.f2966f.getMaxAlertCount(str, i2) : invokeLI.intValue;
    }

    public void r(boolean z, String str, Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), str, context, bVar}) == null) {
            this.a = z;
            this.f2963c = str;
            this.f2964d = context;
            try {
                if (this.f2965e == null && context != null && !BdBaseApplication.getInst().checkInterrupt()) {
                    this.f2965e = new c(this, null);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("com.baidu.adp.stats.background");
                    intentFilter.addAction("com.baidu.adp.stats.switch");
                    intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                    intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                    this.f2964d.registerReceiver(this.f2965e, intentFilter);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.f2968h = bVar;
        }
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f2966f.isExactWriteFile(c.a.d.f.n.j.a.g(str));
        }
        return invokeL.booleanValue;
    }

    public final boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? TextUtils.isEmpty(str) || System.currentTimeMillis() - this.f2967g.a >= 86400000 : invokeL.booleanValue;
    }

    public boolean u(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return false;
            }
            return this.f2966f.isUpload(c.a.d.f.n.j.a.g(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return false;
            }
            return this.f2966f.isWrite(c.a.d.f.n.j.a.g(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public final String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (TextUtils.isEmpty(this.f2963c)) {
                return null;
            }
            try {
                c.a.d.f.j.a.g g2 = new c.a.d.f.j.b.a().g(this.f2963c, 3, -1, 30000, -1, null);
                if (g2 != null) {
                    return new String(g2.f2841h, "utf-8");
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean x(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return false;
            }
            return this.f2966f.onlyWifiUpload(c.a.d.f.n.j.a.g(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public final void y(BdUploadStatMsgData bdUploadStatMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bdUploadStatMsgData) == null) && this.a) {
            Intent intent = new Intent("com.baidu.adp.stats.updatecmd");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.f2964d.sendBroadcast(intent);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.a) {
            Intent intent = new Intent("com.baidu.adp.stats.switch");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.f2964d.sendBroadcast(intent);
        }
    }
}
