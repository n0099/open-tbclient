package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import c.a.e.h.j.g.c;
import c.a.e.h.j.g.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class PluginSettingIOService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ENABLE = "key_enable";
    public static final String KEY_FORBIDDEN = "key_forbidden";
    public static final String KEY_FORBIDDEN_FEATURE = "key_forbidden_feature";
    public static final String KEY_INSTALL_STATUS = "key_install_status";
    public static final String KEY_SETTING_NAME = "key_setting_name";
    public static final String KEY_VERSION = "key_version";
    public static final int MSG_CONNECT_CLIENT = 1;
    public static final int MSG_DISCONNECT_CLIENT = 2;
    public static final int MSG_ENABLE_ALL = 8;
    public static final int MSG_ENABLE_SETTING = 9;
    public static final int MSG_FORBIDDEN_FEATURES = 12;
    public static final int MSG_FORBIDDEN_SETTING = 6;
    public static final int MSG_INSTALL_STATUS = 11;
    public static final int MSG_REMOVE_SETTING = 7;
    public static final int MSG_SET_VERSION = 10;
    public static final int MSG_UPDATE_SETTINGS = 5;
    public static final int MSG_WRITE_SETTINGS = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Messenger> mClients;
    public Messenger mMessenger;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginSettingIOService f36129a;

        public a(PluginSettingIOService pluginSettingIOService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginSettingIOService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36129a = pluginSettingIOService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Serializable serializable;
            Bundle data;
            Bundle data2;
            Bundle data3;
            Bundle data4;
            Bundle data5;
            Bundle data6;
            Bundle data7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1:
                        this.f36129a.mClients.add(message.replyTo);
                        return;
                    case 2:
                        this.f36129a.mClients.remove(message.replyTo);
                        return;
                    case 3:
                    case 5:
                    default:
                        return;
                    case 4:
                        Bundle data8 = message.getData();
                        if (data8 == null || (serializable = data8.getSerializable("plugin_settings")) == null || !(serializable instanceof PluginSettings)) {
                            return;
                        }
                        PluginSettings pluginSettings = (PluginSettings) data8.getSerializable("plugin_settings");
                        this.f36129a.save(pluginSettings, null);
                        this.f36129a.sendUpdateMsg(pluginSettings);
                        return;
                    case 6:
                        if (c.b().d() == null || (data = message.getData()) == null) {
                            return;
                        }
                        boolean z = data.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                        PluginSetting findPluginSetting = c.b().d().findPluginSetting(data.getString(PluginSettingIOService.KEY_SETTING_NAME));
                        if (findPluginSetting != null) {
                            findPluginSetting.forbidden = z;
                            this.f36129a.save(c.b().d(), null);
                            this.f36129a.sendUpdateMsg(6, data);
                            return;
                        }
                        return;
                    case 7:
                        if (c.b().d() == null || (data2 = message.getData()) == null) {
                            return;
                        }
                        c.b().d().removePluginSetting(data2.getString(PluginSettingIOService.KEY_SETTING_NAME));
                        this.f36129a.save(c.b().d(), null);
                        this.f36129a.sendUpdateMsg(7, data2);
                        return;
                    case 8:
                        if (c.b().d() == null || (data3 = message.getData()) == null) {
                            return;
                        }
                        c.b().d().setAllPluginEnable(data3.getBoolean(PluginSettingIOService.KEY_ENABLE));
                        this.f36129a.save(c.b().d(), null);
                        this.f36129a.sendUpdateMsg(8, data3);
                        return;
                    case 9:
                        if (c.b().d() == null || (data4 = message.getData()) == null) {
                            return;
                        }
                        boolean z2 = data4.getBoolean(PluginSettingIOService.KEY_ENABLE);
                        PluginSetting findPluginSetting2 = c.b().d().findPluginSetting(data4.getString(PluginSettingIOService.KEY_SETTING_NAME));
                        if (findPluginSetting2 != null) {
                            findPluginSetting2.enable = z2;
                            this.f36129a.save(c.b().d(), null);
                            this.f36129a.sendUpdateMsg(9, data4);
                            return;
                        }
                        return;
                    case 10:
                        if (c.b().d() == null || (data5 = message.getData()) == null) {
                            return;
                        }
                        c.b().d().setContainerSetting(data5.getString("key_version"));
                        this.f36129a.save(c.b().d(), null);
                        this.f36129a.sendUpdateMsg(10, data5);
                        return;
                    case 11:
                        if (c.b().d() == null || (data6 = message.getData()) == null) {
                            return;
                        }
                        int i2 = data6.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                        PluginSetting findPluginSetting3 = c.b().d().findPluginSetting(data6.getString(PluginSettingIOService.KEY_SETTING_NAME));
                        if (findPluginSetting3 != null) {
                            findPluginSetting3.installStatus = i2;
                            this.f36129a.save(c.b().d(), null);
                            this.f36129a.sendUpdateMsg(11, data6);
                            return;
                        }
                        return;
                    case 12:
                        if (c.b().d() == null || (data7 = message.getData()) == null) {
                            return;
                        }
                        c.b().d().setForbiddenFeatures(data7.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
                        this.f36129a.save(c.b().d(), null);
                        this.f36129a.sendUpdateMsg(12, data7);
                        return;
                }
            }
        }
    }

    public PluginSettingIOService() {
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
        this.mClients = new ArrayList<>();
        this.mMessenger = new Messenger(new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(PluginSettings pluginSettings, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, pluginSettings, eVar) == null) {
            c.b().h(pluginSettings, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMsg(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, bundle) == null) {
            Iterator<Messenger> it = this.mClients.iterator();
            while (it.hasNext()) {
                Messenger next = it.next();
                Message obtain = Message.obtain(null, i2, null);
                if (obtain != null) {
                    obtain.setData(bundle);
                    try {
                        next.send(obtain);
                    } catch (RemoteException | Exception unused) {
                    }
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) ? this.mMessenger.getBinder() : (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mClients.clear();
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMsg(PluginSettings pluginSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, pluginSettings) == null) {
            Iterator<Messenger> it = this.mClients.iterator();
            while (it.hasNext()) {
                Messenger next = it.next();
                Message obtain = Message.obtain(null, 5, null);
                if (obtain != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("plugin_settings", pluginSettings);
                    obtain.setData(bundle);
                    try {
                        next.send(obtain);
                    } catch (RemoteException unused) {
                    }
                }
            }
        }
    }
}
