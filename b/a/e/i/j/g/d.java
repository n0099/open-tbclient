package b.a.e.i.j.g;

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
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f2325g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PluginSettings f2326a;

    /* renamed from: b  reason: collision with root package name */
    public Messenger f2327b;

    /* renamed from: c  reason: collision with root package name */
    public Messenger f2328c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f2329d;

    /* renamed from: e  reason: collision with root package name */
    public f f2330e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Message> f2331f;

    /* loaded from: classes.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f2332a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f2333b;

        public a(d dVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2333b = dVar;
            this.f2332a = fVar;
        }

        @Override // b.a.e.i.j.g.f
        public void a(PluginSettings pluginSettings) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pluginSettings) == null) {
                if (pluginSettings != null) {
                    this.f2333b.f2326a = pluginSettings;
                }
                f fVar = this.f2332a;
                if (fVar != null) {
                    fVar.a(pluginSettings);
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2334a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
            this.f2334a = dVar;
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
                                this.f2334a.f2326a = (PluginSettings) data.getSerializable("plugin_settings");
                            }
                            if (this.f2334a.f2330e != null) {
                                this.f2334a.f2330e.a(this.f2334a.f2326a);
                                this.f2334a.f2330e = null;
                                return;
                            }
                            return;
                        case 6:
                            Bundle data2 = message.getData();
                            if (data2 != null) {
                                boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                                String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                                PluginSetting findPluginSetting = this.f2334a.f2326a.findPluginSetting(string);
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
                                this.f2334a.f2326a.removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                                return;
                            }
                            return;
                        case 8:
                            Bundle data4 = message.getData();
                            if (data4 != null) {
                                this.f2334a.f2326a.setAllPluginEnable(data4.getBoolean(PluginSettingIOService.KEY_ENABLE));
                                return;
                            }
                            return;
                        case 9:
                            Bundle data5 = message.getData();
                            if (data5 != null) {
                                boolean z2 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                                PluginSetting findPluginSetting2 = this.f2334a.f2326a.findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
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
                                if ((!TextUtils.isEmpty(string2) || TextUtils.isEmpty(this.f2334a.f2326a.getContainerVersion())) && ((TextUtils.isEmpty(string2) || !TextUtils.isEmpty(this.f2334a.f2326a.getContainerVersion())) && (TextUtils.isEmpty(string2) || TextUtils.isEmpty(this.f2334a.f2326a.getContainerVersion()) || string2.equals(this.f2334a.f2326a.getContainerVersion())))) {
                                    return;
                                }
                                this.f2334a.f2326a.setContainerSetting(string2);
                                return;
                            }
                            return;
                        case 11:
                            Bundle data7 = message.getData();
                            if (data7 != null) {
                                int i2 = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                                PluginSetting findPluginSetting3 = this.f2334a.f2326a.findPluginSetting(data7.getString(PluginSettingIOService.KEY_SETTING_NAME));
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
                                this.f2334a.f2326a.setForbiddenFeatures(data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
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
    public class c implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f2335e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2335e = dVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f2335e.f2327b = new Messenger(iBinder);
                this.f2335e.t();
                if (this.f2335e.f2331f.size() > 0) {
                    Iterator it = this.f2335e.f2331f.iterator();
                    while (it.hasNext()) {
                        try {
                            this.f2335e.f2327b.send((Message) it.next());
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.f2335e.f2331f.clear();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f2335e.f2327b = null;
                this.f2335e.f2331f.clear();
            }
        }
    }

    public d() {
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
        this.f2326a = new PluginSettings();
        this.f2328c = new Messenger(new b(this));
        this.f2329d = new c(this);
        this.f2331f = new ArrayList<>();
    }

    public static d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f2325g == null) {
                synchronized (d.class) {
                    if (f2325g == null) {
                        f2325g = new d();
                    }
                }
            }
            return f2325g;
        }
        return (d) invokeV.objValue;
    }

    public void A(String str) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (h2 = h(str)) != null && h2.forbidden) {
            h2.forbidden = false;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, false);
            s(6, bundle);
        }
    }

    public void B(String str, PluginSetting pluginSetting, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, pluginSetting, z) == null) && this.f2326a.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            b.a.e.i.j.g.c.b().h(this.f2326a.m9clone(), null);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f2326a.findPluginSetting(str) == null) {
            return;
        }
        q(str);
        w("");
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f2326a.findPluginSetting(str) == null) {
            return;
        }
        q(str);
        w("");
    }

    public String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            PluginSetting findPluginSettingByCmd = this.f2326a.findPluginSettingByCmd(i2);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f2326a.findPluginSetting(str) : (PluginSetting) invokeL.objValue;
    }

    public void i(String str) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (h2 = h(str)) == null || h2.forbidden) {
            return;
        }
        h2.forbidden = true;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
        s(6, bundle);
    }

    public void j(String str) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (h2 = h(str)) == null) {
            return;
        }
        h2.enable = true;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, true);
        s(9, bundle);
    }

    public PluginSettings l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2326a : (PluginSettings) invokeV.objValue;
    }

    public void m(String str, PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, pluginSetting) == null) && this.f2326a.insertOrUpdatePluginSetting(str, pluginSetting)) {
            r();
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            PluginSetting h2 = h(str);
            if (h2 == null) {
                return true;
            }
            return h2.forbidden;
        }
        return invokeL.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        List<ActivityManager.RunningServiceInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                list = ((ActivityManager) BdBaseApplication.getInst().getSystemService("activity")).getRunningServices(100);
            } catch (Exception unused) {
                b.a.e.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("loc", d.class.getName() + "-isPluginIOServiceStart-getRunningServices");
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

    public void p(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            b.a.e.i.j.g.c.b().g(new a(this, fVar));
            if (this.f2327b == null || !o()) {
                b.a.e.f.m.f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.f2329d, 1);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && this.f2326a.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            s(7, bundle);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Message obtain = Message.obtain((Handler) null, 4);
            Bundle bundle = new Bundle();
            bundle.putSerializable("plugin_settings", this.f2326a.m9clone());
            if (obtain != null) {
                obtain.setData(bundle);
                try {
                    if (this.f2327b != null && o()) {
                        this.f2327b.send(obtain);
                    }
                    this.f2331f.add(obtain);
                    b.a.e.f.m.f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.f2329d, 1);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void s(int i2, Bundle bundle) {
        Message obtain;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048591, this, i2, bundle) == null) || (obtain = Message.obtain((Handler) null, i2)) == null) {
            return;
        }
        obtain.setData(bundle);
        try {
            if (this.f2327b != null && o()) {
                this.f2327b.send(obtain);
            }
            this.f2331f.add(obtain);
            b.a.e.f.m.f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.f2329d, 1);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public final void t() {
        Message obtain;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (obtain = Message.obtain(null, 1, null)) == null) {
            return;
        }
        try {
            obtain.replyTo = this.f2328c;
            this.f2327b.send(obtain);
        } catch (RemoteException unused) {
        } catch (Throwable unused2) {
            b.a.e.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("loc", d.class.getName() + "-sendMsgConnect");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
        }
    }

    public void u(String str, String str2, boolean z) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048593, this, str, str2, z) == null) || (h2 = h(str)) == null) {
            return;
        }
        h2.setAbandon_apk_path(str2);
        if (z) {
            b.a.e.i.j.g.c.b().h(this.f2326a.m9clone(), null);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && this.f2326a.setAllPluginEnable(z)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            s(8, bundle);
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(this.f2326a.getContainerVersion()) || !this.f2326a.getContainerVersion().equals(str)) {
                this.f2326a.setContainerSetting(str);
                Bundle bundle = new Bundle();
                bundle.putString("key_version", str);
                s(10, bundle);
            }
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            String forbiddenFeatures = this.f2326a.getForbiddenFeatures();
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(forbiddenFeatures)) {
                return;
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(forbiddenFeatures) || !str.equals(forbiddenFeatures)) {
                this.f2326a.setForbiddenFeatures(str);
                Bundle bundle = new Bundle();
                bundle.putString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE, str);
                s(12, bundle);
            }
        }
    }

    public void y(String str, int i2) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048597, this, str, i2) == null) || (h2 = h(str)) == null || h2.installStatus == i2) {
            return;
        }
        h2.installStatus = i2;
        Bundle bundle = new Bundle();
        bundle.putInt(PluginSettingIOService.KEY_INSTALL_STATUS, i2);
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        s(11, bundle);
    }

    public void z(String str, boolean z) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, str, z) == null) || (h2 = h(str)) == null || h2.enable == z) {
            return;
        }
        h2.enable = z;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
        s(9, bundle);
    }
}
