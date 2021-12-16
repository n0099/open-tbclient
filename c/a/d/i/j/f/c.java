package c.a.d.i.j.f;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.f;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettingIOService;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f2803g;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginSettings a;

    /* renamed from: b  reason: collision with root package name */
    public Messenger f2804b;

    /* renamed from: c  reason: collision with root package name */
    public Messenger f2805c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f2806d;

    /* renamed from: e  reason: collision with root package name */
    public e f2807e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Message> f2808f;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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
            this.a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Serializable serializable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    switch (message.what) {
                        case 5:
                            Bundle data = message.getData();
                            if (data != null && (serializable = data.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                                this.a.a = (PluginSettings) data.getSerializable("plugin_settings");
                            }
                            if (this.a.f2807e != null) {
                                this.a.f2807e.a(this.a.a);
                                this.a.f2807e = null;
                                return;
                            }
                            return;
                        case 6:
                            Bundle data2 = message.getData();
                            if (data2 != null) {
                                boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                                String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                                PluginSetting findPluginSetting = this.a.a.findPluginSetting(string);
                                if (findPluginSetting != null && findPluginSetting.forbidden != z) {
                                    findPluginSetting.forbidden = z;
                                }
                                if (z) {
                                    return;
                                }
                                PluginCenter.getInstance().launch(string);
                                return;
                            }
                            return;
                        case 7:
                            Bundle data3 = message.getData();
                            if (data3 != null) {
                                this.a.a.removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                                return;
                            }
                            return;
                        case 8:
                            Bundle data4 = message.getData();
                            if (data4 != null) {
                                this.a.a.setAllPluginEnable(data4.getBoolean(PluginSettingIOService.KEY_ENABLE));
                                return;
                            }
                            return;
                        case 9:
                            Bundle data5 = message.getData();
                            if (data5 != null) {
                                boolean z2 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                                PluginSetting findPluginSetting2 = this.a.a.findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
                                if (findPluginSetting2 != null && findPluginSetting2.enable != z2) {
                                    findPluginSetting2.enable = z2;
                                }
                                boolean z3 = false;
                                if (findPluginSetting2.isPatch && TextUtils.isEmpty(findPluginSetting2.replaceMethodClasses)) {
                                    z3 = true;
                                }
                                if (findPluginSetting2 == null || !findPluginSetting2.enable || TextUtils.isEmpty(findPluginSetting2.requireLoad) || !findPluginSetting2.requireLoad.equals("0") || z3) {
                                    return;
                                }
                                PluginCenter.getInstance().launch(findPluginSetting2.packageName);
                                return;
                            }
                            return;
                        case 10:
                            Bundle data6 = message.getData();
                            if (data6 != null) {
                                String string2 = data6.getString("key_version");
                                if ((!TextUtils.isEmpty(string2) || TextUtils.isEmpty(this.a.a.getContainerVersion())) && ((TextUtils.isEmpty(string2) || !TextUtils.isEmpty(this.a.a.getContainerVersion())) && (TextUtils.isEmpty(string2) || TextUtils.isEmpty(this.a.a.getContainerVersion()) || string2.equals(this.a.a.getContainerVersion())))) {
                                    return;
                                }
                                this.a.a.setContainerSetting(string2);
                                return;
                            }
                            return;
                        case 11:
                            Bundle data7 = message.getData();
                            if (data7 != null) {
                                int i2 = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                                PluginSetting findPluginSetting3 = this.a.a.findPluginSetting(data7.getString(PluginSettingIOService.KEY_SETTING_NAME));
                                if (findPluginSetting3 == null || findPluginSetting3.installStatus == i2) {
                                    return;
                                }
                                findPluginSetting3.installStatus = i2;
                                return;
                            }
                            return;
                        case 12:
                            Bundle data8 = message.getData();
                            if (data8 != null) {
                                this.a.a.setForbiddenFeatures(data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2809e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2809e = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f2809e.f2804b = new Messenger(iBinder);
                this.f2809e.r();
                if (this.f2809e.f2808f.size() > 0) {
                    Iterator it = this.f2809e.f2808f.iterator();
                    while (it.hasNext()) {
                        try {
                            this.f2809e.f2804b.send((Message) it.next());
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.f2809e.f2808f.clear();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f2809e.f2804b = null;
                this.f2809e.f2808f.clear();
            }
        }
    }

    public c() {
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
        this.a = new PluginSettings();
        this.f2805c = new Messenger(new a(this));
        this.f2806d = new b(this);
        this.f2808f = new ArrayList<>();
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f2803g == null) {
                synchronized (c.class) {
                    if (f2803g == null) {
                        f2803g = new c();
                    }
                }
            }
            return f2803g;
        }
        return (c) invokeV.objValue;
    }

    public String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            PluginSetting findPluginSettingByCmd = this.a.findPluginSettingByCmd(i2);
            if (findPluginSettingByCmd != null) {
                return findPluginSettingByCmd.packageName;
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public PluginSetting h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.a.findPluginSetting(str) : (PluginSetting) invokeL.objValue;
    }

    public void i(String str) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (h2 = h(str)) == null || h2.forbidden) {
            return;
        }
        h2.forbidden = true;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
        q(6, bundle);
    }

    public PluginSettings k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (PluginSettings) invokeV.objValue;
    }

    public void l(String str, PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, pluginSetting) == null) && this.a.insertOrUpdatePluginSetting(str, pluginSetting)) {
            p();
        }
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PluginSetting h2 = h(str);
            if (h2 == null) {
                return true;
            }
            return h2.forbidden;
        }
        return invokeL.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        List<ActivityManager.RunningServiceInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                list = ((ActivityManager) BdBaseApplication.getInst().getSystemService("activity")).getRunningServices(100);
            } catch (Exception unused) {
                c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("loc", c.class.getName() + "-isPluginIOServiceStart-getRunningServices");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
                list = null;
            }
            if (list != null) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : list) {
                    if (runningServiceInfo != null && runningServiceInfo.service != null && PluginSettingIOService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.a.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            q(7, bundle);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Message obtain = Message.obtain((Handler) null, 4);
            Bundle bundle = new Bundle();
            bundle.putSerializable("plugin_settings", this.a.m29clone());
            if (obtain != null) {
                obtain.setData(bundle);
                try {
                    if (this.f2804b != null && n()) {
                        this.f2804b.send(obtain);
                    }
                    this.f2808f.add(obtain);
                    f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.f2806d, 1);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void q(int i2, Bundle bundle) {
        Message obtain;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, bundle) == null) || (obtain = Message.obtain((Handler) null, i2)) == null) {
            return;
        }
        obtain.setData(bundle);
        try {
            if (this.f2804b != null && n()) {
                this.f2804b.send(obtain);
            }
            this.f2808f.add(obtain);
            f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.f2806d, 1);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public final void r() {
        Message obtain;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (obtain = Message.obtain(null, 1, null)) == null) {
            return;
        }
        try {
            obtain.replyTo = this.f2805c;
            this.f2804b.send(obtain);
        } catch (RemoteException unused) {
        } catch (Throwable unused2) {
            c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("loc", c.class.getName() + "-sendMsgConnect");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
        }
    }

    public void s(String str, String str2, boolean z) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048587, this, str, str2, z) == null) || (h2 = h(str)) == null) {
            return;
        }
        h2.setAbandon_apk_path(str2);
        if (z) {
            c.a.d.i.j.f.b.b().e(this.a.m29clone(), null);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(this.a.getContainerVersion()) || !this.a.getContainerVersion().equals(str)) {
                this.a.setContainerSetting(str);
                Bundle bundle = new Bundle();
                bundle.putString("key_version", str);
                q(10, bundle);
            }
        }
    }

    public void u(String str, boolean z) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) || (h2 = h(str)) == null || h2.enable == z) {
            return;
        }
        h2.enable = z;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
        q(9, bundle);
    }

    public void v(String str) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && (h2 = h(str)) != null && h2.forbidden) {
            h2.forbidden = false;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, false);
            q(6, bundle);
        }
    }

    public void w(String str, PluginSetting pluginSetting, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048591, this, str, pluginSetting, z) == null) && this.a.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            c.a.d.i.j.f.b.b().e(this.a.m29clone(), null);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || this.a.findPluginSetting(str) == null) {
            return;
        }
        o(str);
        t("");
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || this.a.findPluginSetting(str) == null) {
            return;
        }
        o(str);
        t("");
    }
}
