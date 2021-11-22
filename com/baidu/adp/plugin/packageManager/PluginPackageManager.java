package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.i.j.a;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PluginPackageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static int u = 43;
    public static int v = 2;
    public static volatile PluginPackageManager w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f35282a;

    /* renamed from: b  reason: collision with root package name */
    public Hashtable<String, k> f35283b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35284c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35285d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35286e;

    /* renamed from: f  reason: collision with root package name */
    public String f35287f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35288g;

    /* renamed from: h  reason: collision with root package name */
    public long f35289h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35290i;
    public boolean j;
    public int k;
    public b.a.e.i.j.d l;
    public boolean m;
    public BroadcastReceiver n;
    public BroadcastReceiver o;
    public a.c p;
    public b.a.e.i.g.a q;
    public b.a.e.i.j.f.a r;
    public b.a.e.i.j.e.a s;
    public CustomMessageListener t;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class PluginStatus {
        public static final /* synthetic */ PluginStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PluginStatus DISABLE;
        public static final PluginStatus ERROR;
        public static final PluginStatus FORBIDDEN;
        public static final PluginStatus NROMAL;
        public static final PluginStatus UNINSTALLED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2104876248, "Lcom/baidu/adp/plugin/packageManager/PluginPackageManager$PluginStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2104876248, "Lcom/baidu/adp/plugin/packageManager/PluginPackageManager$PluginStatus;");
                    return;
                }
            }
            DISABLE = new PluginStatus("DISABLE", 0);
            FORBIDDEN = new PluginStatus("FORBIDDEN", 1);
            UNINSTALLED = new PluginStatus("UNINSTALLED", 2);
            NROMAL = new PluginStatus("NROMAL", 3);
            PluginStatus pluginStatus = new PluginStatus("ERROR", 4);
            ERROR = pluginStatus;
            $VALUES = new PluginStatus[]{DISABLE, FORBIDDEN, UNINSTALLED, NROMAL, pluginStatus};
        }

        public PluginStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PluginStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PluginStatus) Enum.valueOf(PluginStatus.class, str) : (PluginStatus) invokeL.objValue;
        }

        public static PluginStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PluginStatus[]) $VALUES.clone() : (PluginStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f35291a;

        /* renamed from: b  reason: collision with root package name */
        public int f35292b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f35293c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PluginPackageManager pluginPackageManager, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager, Integer.valueOf(i2)};
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
            this.f35293c = pluginPackageManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f35293c.f35290i && b.a.e.f.p.j.z()) {
                if (this.f35292b < 3) {
                    PluginPackageManager pluginPackageManager = this.f35293c;
                    pluginPackageManager.y0(pluginPackageManager.m);
                    this.f35292b++;
                    this.f35291a = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.f35291a > 60000) {
                    PluginPackageManager pluginPackageManager2 = this.f35293c;
                    pluginPackageManager2.y0(pluginPackageManager2.m);
                    this.f35292b = 0;
                    this.f35291a = System.currentTimeMillis();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, Integer> installFailRetryMap;
        public final /* synthetic */ PluginPackageManager this$0;

        public b(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pluginPackageManager;
            this.installFailRetryMap = new HashMap();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(Context context, Intent intent) {
            String str;
            PluginSetting pluginSetting;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.baidu.adp.plugin.installed".equals(action)) {
                String stringExtra = intent.getStringExtra("package_name");
                String stringExtra2 = intent.getStringExtra("install_dest_file");
                String stringExtra3 = intent.getStringExtra("version_name");
                int intExtra = intent.getIntExtra("version_code", 0);
                String stringExtra4 = intent.getStringExtra("require_load");
                boolean booleanExtra = intent.getBooleanExtra("is_inject_classloader", false);
                String stringExtra5 = intent.getStringExtra("cmd_range");
                String stringExtra6 = intent.getStringExtra("install_flag");
                PluginSetting h2 = b.a.e.i.j.g.d.k().h(stringExtra);
                if (h2 == null) {
                    h2 = new PluginSetting();
                    h2.forbidden = false;
                }
                if (this.this$0.f35284c) {
                    str2 = "load_lowversion";
                    if (this.installFailRetryMap.containsKey(h2.packageName)) {
                        b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                        StringBuilder sb = new StringBuilder();
                        str3 = "plugin_load";
                        sb.append("retry_at_num_");
                        str4 = "-";
                        sb.append(this.installFailRetryMap.get(h2.packageName));
                        b2.o("plugin_install", "re_install_success", stringExtra, sb.toString());
                        h2.packageName = stringExtra;
                        if (!TextUtils.equals(stringExtra2, h2.apkPath)) {
                            h2.addAbandonApk(h2.apkPath);
                        }
                        h2.apkPath = stringExtra2;
                        h2.setCmdRange(stringExtra5);
                        h2.enable = true;
                        h2.requireLoad = stringExtra4;
                        h2.version = stringExtra3;
                        h2.versionCode = intExtra;
                        h2.installStatus = 0;
                        h2.tempVersionCode = 0;
                        if (this.this$0.f35284c) {
                            b.a.e.i.h.a.b().d("plugin_install_suc", stringExtra, h2, "");
                            b.a.e.i.h.a b3 = b.a.e.i.h.a.b();
                            b3.o("plugin_install", "plugin_install_suc", stringExtra, "flag=" + stringExtra6 + "_fail=" + h2.install_fail_count);
                            if (intExtra < PluginPackageManager.u) {
                                b.a.e.i.h.a.b().i("plugin_launch_lowversion", stringExtra);
                                b.a.e.i.h.a b4 = b.a.e.i.h.a.b();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("broadcast_suc-");
                                sb2.append(h2.apkPath);
                                String str5 = str4;
                                sb2.append(str5);
                                sb2.append(h2.versionCode);
                                sb2.append(str5);
                                sb2.append(h2.forbidden);
                                sb2.append(str5);
                                sb2.append(h2.tempVersionCode);
                                sb2.append(str5);
                                sb2.append(h2.installStatus);
                                b4.o(str3, str2, stringExtra, sb2.toString());
                            }
                        }
                        h2.tempMd5 = "";
                        h2.url = "";
                        h2.install_fail_count = 0;
                        h2.hasRes = intent.getBooleanExtra("has_res", false);
                        h2.isThird = intent.getBooleanExtra("is_third", false);
                        h2.isPatch = intent.getBooleanExtra("is_patch", false);
                        h2.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                        h2.setInjectClassloader(booleanExtra);
                        this.this$0.B(h2);
                        b.a.e.i.j.g.d.k().B(stringExtra, h2, this.this$0.f35284c);
                        boolean z = !h2.isPatch && TextUtils.isEmpty(h2.replaceMethodClasses);
                        if (!TextUtils.isEmpty(h2.requireLoad) && h2.requireLoad.equals("0") && !z) {
                            PluginCenter.getInstance().launch(h2.packageName);
                        }
                        this.this$0.J(stringExtra, true, null);
                    }
                } else {
                    str2 = "load_lowversion";
                }
                str3 = "plugin_load";
                str4 = "-";
                h2.packageName = stringExtra;
                if (!TextUtils.equals(stringExtra2, h2.apkPath)) {
                }
                h2.apkPath = stringExtra2;
                h2.setCmdRange(stringExtra5);
                h2.enable = true;
                h2.requireLoad = stringExtra4;
                h2.version = stringExtra3;
                h2.versionCode = intExtra;
                h2.installStatus = 0;
                h2.tempVersionCode = 0;
                if (this.this$0.f35284c) {
                }
                h2.tempMd5 = "";
                h2.url = "";
                h2.install_fail_count = 0;
                h2.hasRes = intent.getBooleanExtra("has_res", false);
                h2.isThird = intent.getBooleanExtra("is_third", false);
                h2.isPatch = intent.getBooleanExtra("is_patch", false);
                h2.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                h2.setInjectClassloader(booleanExtra);
                this.this$0.B(h2);
                b.a.e.i.j.g.d.k().B(stringExtra, h2, this.this$0.f35284c);
                if (h2.isPatch) {
                }
                if (!TextUtils.isEmpty(h2.requireLoad)) {
                    PluginCenter.getInstance().launch(h2.packageName);
                }
                this.this$0.J(stringExtra, true, null);
            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                String stringExtra7 = intent.getStringExtra("install_src_file");
                if (stringExtra7 == null) {
                    return;
                }
                String substring = stringExtra7.substring(stringExtra7.lastIndexOf("/") + 1, stringExtra7.lastIndexOf(".apk"));
                String stringExtra8 = intent.getStringExtra("fail_reason");
                String stringExtra9 = intent.getStringExtra("install_comment");
                String stringExtra10 = intent.getStringExtra("package_name");
                String stringExtra11 = intent.getStringExtra("install_flag");
                if (TextUtils.isEmpty(stringExtra10)) {
                    pluginSetting = null;
                } else {
                    PluginSetting h3 = b.a.e.i.j.g.d.k().h(stringExtra10);
                    if ("apk_not_exist".equals(stringExtra8) && h3 != null && h3.installStatus == 0 && h3.tempVersionCode == 0) {
                        b.a.e.i.h.a b5 = b.a.e.i.h.a.b();
                        b5.o("plugin_install", "intercept_apk_not_exist", stringExtra10, stringExtra11 + "_" + stringExtra7);
                        return;
                    } else if ("assets_not_found".equals(stringExtra8)) {
                        b.a.e.i.h.a b6 = b.a.e.i.h.a.b();
                        b6.o("plugin_install", "assets_not_found", stringExtra10, stringExtra11 + "_" + stringExtra9);
                        return;
                    } else {
                        if (h3 == null) {
                            PluginSetting pluginSetting2 = new PluginSetting();
                            pluginSetting2.packageName = stringExtra10;
                            pluginSetting = pluginSetting2;
                        } else {
                            pluginSetting = h3;
                        }
                        pluginSetting.enable = false;
                        if (this.this$0.f35284c) {
                            int i2 = pluginSetting.install_fail_count + 1;
                            pluginSetting.install_fail_count = i2;
                            if (i2 >= 5) {
                                this.this$0.B(pluginSetting);
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = "";
                                pluginSetting.tempMd5 = "";
                                pluginSetting.install_fail_count = 0;
                                pluginSetting.installStatus = 0;
                            }
                            if (pluginSetting.install_fail_count >= b.a.e.f.n.m.a.o().q("alert_plugin", 3)) {
                                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                                bdStatisticsManager.alert("alert_plugin", "package name = " + stringExtra10 + "; fail count = " + pluginSetting.install_fail_count);
                            }
                        }
                        b.a.e.i.j.g.d.k().B(stringExtra10, pluginSetting, this.this$0.f35284c);
                    }
                }
                this.this$0.J(substring, false, stringExtra8);
                if (this.this$0.f35284c) {
                    if (stringExtra9 != null) {
                        String lowerCase = stringExtra9.toLowerCase(Locale.getDefault());
                        if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                            stringExtra8 = "rom_size";
                        } else if (!lowerCase.contains("read-only_file_system") && !lowerCase.contains("read-only file system")) {
                            if (!lowerCase.contains("permission_denied") && !lowerCase.contains("permission denied")) {
                                if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    b.a.e.i.h.a.b().i("plugin_fsync_failed", stringExtra10);
                                    stringExtra8 = "fsync_failed";
                                }
                            } else {
                                b.a.e.i.h.a.b().i("plugin_permission_denied", stringExtra10);
                                stringExtra8 = "permission_denied";
                            }
                        } else {
                            b.a.e.i.h.a.b().i("plugin_read_file_sys", stringExtra10);
                            stringExtra8 = "read_file_system";
                        }
                    }
                    if ("rom_size".equals(stringExtra8)) {
                        b.a.e.i.h.a.b().i("plugin_rom_small", stringExtra10);
                    }
                    b.a.e.i.h.a.b().e("plugin_install_fail", stringExtra10, pluginSetting, stringExtra8);
                    b.a.e.i.h.a b7 = b.a.e.i.h.a.b();
                    b7.r("plugin_install", stringExtra8, stringExtra10, stringExtra9 + "_flag=" + stringExtra11);
                }
            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                String stringExtra12 = intent.getStringExtra("package_name");
                PluginSetting h4 = b.a.e.i.j.g.d.k().h(stringExtra12);
                if (h4 != null) {
                    b.a.e.i.j.g.d.k().z(stringExtra12, true);
                    if (h4.versionCode < PluginPackageManager.u) {
                        b.a.e.i.h.a.b().i("plugin_launch_lowversion", stringExtra12);
                        b.a.e.i.h.a b8 = b.a.e.i.h.a.b();
                        b8.o("plugin_load", "load_lowversion", stringExtra12, "broadcast_cancel-" + h4.apkPath + "-" + h4.versionCode + "-" + h4.forbidden + "-" + h4.tempVersionCode + "-" + h4.installStatus);
                    }
                    str = null;
                } else {
                    str = null;
                    b.a.e.i.h.a.b().o("plugin_install", "install_cancel_settingnull", stringExtra12, null);
                }
                this.this$0.J(stringExtra12, true, str);
            } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                String stringExtra13 = intent.getStringExtra("fail_reason");
                String stringExtra14 = intent.getStringExtra("package_name");
                if (TextUtils.isEmpty(stringExtra14)) {
                    return;
                }
                PluginSetting h5 = b.a.e.i.j.g.d.k().h(stringExtra14);
                if (h5 == null) {
                    h5 = new PluginSetting();
                    h5.packageName = stringExtra14;
                }
                h5.enable = false;
                if (this.this$0.f35284c && "low_version_code".equals(stringExtra13)) {
                    this.this$0.B(h5);
                    h5.tempVersionCode = 0;
                    h5.url = "";
                    h5.tempMd5 = "";
                    h5.install_fail_count = 0;
                    h5.installStatus = 0;
                }
                b.a.e.i.j.g.d.k().B(stringExtra14, h5, this.this$0.f35284c);
                if ("low_version_code".equals(stringExtra13)) {
                    b.a.e.i.h.a.b().i("plugin_low_version_code", stringExtra14);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginPackageManager this$0;

        public c(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pluginPackageManager;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && "com.baidu.adp.plugin.currentpath".equals(intent.getAction())) {
                boolean z = true;
                Bundle resultExtras = getResultExtras(true);
                String string = resultExtras != null ? resultExtras.getString("package_name") : "";
                if (!TextUtils.isEmpty(string) && resultExtras != null) {
                    str = resultExtras.getString("current_path");
                } else if (intent.getExtras() != null) {
                    string = intent.getExtras().getString("package_name");
                    str = intent.getExtras().getString("current_path");
                } else {
                    str = "";
                }
                String pluginApkFilePath = PluginCenter.getInstance().getPlugin(string) != null ? PluginCenter.getInstance().getPlugin(string).getPluginApkFilePath() : "";
                if (!TextUtils.isEmpty(pluginApkFilePath)) {
                    if (TextUtils.isEmpty(str)) {
                        str = pluginApkFilePath;
                    } else {
                        String[] split = str.split(",");
                        int length = split.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                z = false;
                                break;
                            } else if (split[i2].equals(pluginApkFilePath)) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z) {
                            str = str + "," + pluginApkFilePath;
                        }
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("package_name", string);
                bundle.putString("current_path", str);
                setResultExtras(bundle);
                if (this.this$0.f35284c) {
                    this.this$0.E(string, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f35294a;

        public d(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35294a = pluginPackageManager;
        }

        @Override // b.a.e.i.j.a.c
        public void a(String str, String str2) {
            PluginSetting h2;
            String[] split;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (h2 = b.a.e.i.j.g.d.k().h(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(h2.apkPath) && h2.apkPath.equals(str2)) {
                b.a.e.i.h.a.b().o("plugin_setting", "del_unuse_plugin_setting", h2.packageName, "apkpath-" + h2.apkPath + "-forbidden-" + h2.forbidden + "-enable-" + h2.enable + "-abandonapkpath-" + h2.getAbandon_apk_path() + "-versioncode-" + h2.versionCode);
                b.a.e.i.j.g.d.k().q(str);
            } else if (!TextUtils.isEmpty(h2.getAbandon_apk_path())) {
                String str3 = "";
                for (String str4 : h2.getAbandon_apk_path().split(",")) {
                    if (!str2.equals(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str3 = str3 + ",";
                        }
                        str3 = str3 + str4;
                    }
                }
                b.a.e.i.j.g.d.k().u(str, str3, this.f35294a.f35284c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f35295a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f35296b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f35297e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35297e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.e.i.h.b.e("PluginPackageManager_loadAllPlugins", "load_plugin#3");
                    e eVar = this.f35297e;
                    eVar.f35296b.m0(eVar.f35295a);
                }
            }
        }

        public e(PluginPackageManager pluginPackageManager, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35296b = pluginPackageManager;
            this.f35295a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                Object d2 = b.a.e.f.b.a.a.d(Looper.getMainLooper(), "sThreadLocal");
                if (d2 instanceof ThreadLocal) {
                    ((ThreadLocal) d2).set(Looper.getMainLooper());
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    b.a.e.i.h.b.e("PluginPackageManager_loadAllPlugins", "load_plugin#2");
                    this.f35296b.m0(this.f35295a);
                    return null;
                }
                b.a.e.i.h.a.b().g("plugin_asyncinit_fail");
                b.a.e.f.m.e.a().post(new a(this));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements b.a.e.i.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f35298a;

        public f(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35298a = pluginPackageManager;
        }

        @Override // b.a.e.i.g.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (PluginPackageManager.O().c0()) {
                        PluginSettings l = b.a.e.i.j.g.d.k().l();
                        b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.f35298a.f35287f);
                        sb.append("-");
                        sb.append(l != null ? l.getContainerVersion() : "");
                        b2.o("plugin_setting", "version_update_suc", null, sb.toString());
                    }
                    b.a.e.i.j.g.d.k().w(this.f35298a.f35287f);
                    if (PluginPackageManager.O().c0()) {
                        b.a.e.i.h.a.b().k("plugin_install", System.currentTimeMillis() - this.f35298a.f35289h);
                    }
                } else if (PluginPackageManager.O().c0()) {
                    PluginSettings l2 = b.a.e.i.j.g.d.k().l();
                    b.a.e.i.h.a b3 = b.a.e.i.h.a.b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f35298a.f35287f);
                    sb2.append("-");
                    sb2.append(l2 != null ? l2.getContainerVersion() : "");
                    b3.o("plugin_setting", "version_update_fail", null, sb2.toString());
                }
                this.f35298a.l0();
                this.f35298a.y0(true);
            }
        }

        @Override // b.a.e.i.g.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                b.a.e.i.j.g.d.k().z(str, true);
                PluginSetting h2 = b.a.e.i.j.g.d.k().h(str);
                if (h2 == null || h2.versionCode >= PluginPackageManager.u) {
                    return;
                }
                b.a.e.i.h.a.b().i("plugin_launch_lowversion", str);
                b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                b2.o("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + h2.apkPath + "-" + h2.versionCode + "-" + h2.forbidden + "-" + h2.tempVersionCode + "-" + h2.installStatus);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f35299e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f35300f;

        public g(PluginPackageManager pluginPackageManager, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35300f = pluginPackageManager;
            this.f35299e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.e.i.j.f.d.c().e(b.a.e.i.j.g.d.k().l(), this.f35299e, this.f35300f.r);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f35301a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PluginPackageManager pluginPackageManager, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager, Integer.valueOf(i2)};
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
            this.f35301a = pluginPackageManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            PluginSettings l;
            PluginNetConfigInfos d2;
            List<PluginNetConfigInfos.PluginConfig> configs;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (data = customResponsedMessage.getData()) == null || !(data instanceof PluginNetConfigInfos.PluginConfig) || (l = b.a.e.i.j.g.d.k().l()) == null) {
                return;
            }
            if (l != null) {
                PluginPackageManager pluginPackageManager = this.f35301a;
                if (pluginPackageManager.z(pluginPackageManager.f35287f, l.getContainerVersion())) {
                    return;
                }
            }
            PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
            if (TextUtils.isEmpty(pluginConfig.package_name) || (d2 = b.a.e.i.j.f.d.c().d()) == null || (configs = d2.getConfigs()) == null) {
                return;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= configs.size()) {
                    z = true;
                    break;
                } else if (configs.get(i2).package_name.equals(pluginConfig.package_name)) {
                    configs.set(i2, pluginConfig);
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                configs.add(pluginConfig);
            }
            this.f35301a.p0(b.a.e.i.j.f.d.c().g(b.a.e.i.j.g.d.k().l()), pluginConfig);
            b.a.e.i.j.g.d.k().x(this.f35301a.N(configs));
            this.f35301a.D();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements b.a.e.i.j.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f35302a;

        public i(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35302a = pluginPackageManager;
        }

        @Override // b.a.e.i.j.f.a
        public void a(boolean z, b.a.e.i.j.f.c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), cVar, pluginNetConfigInfos, str}) == null) {
                if (PluginPackageManager.v != 1) {
                    if (z && pluginNetConfigInfos != null) {
                        if (pluginNetConfigInfos.getConfigs() == null || pluginNetConfigInfos.getConfigs().size() <= 0) {
                            str2 = "";
                        } else {
                            List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                            this.f35302a.q0(cVar, configs);
                            str2 = this.f35302a.N(configs);
                        }
                        b.a.e.i.j.g.d.k().x(str2);
                        this.f35302a.m = false;
                        if (this.f35302a.f35284c) {
                            MessageManager.getInstance().unRegisterListener(this.f35302a.t);
                        }
                    } else {
                        if (!b.a.e.f.p.k.isEmpty(str)) {
                            b.a.e.i.h.a.b().o("plugin_syncConfig", "plugin_syncConfigs_fail", null, str);
                        }
                        this.f35302a.m = true;
                        this.f35302a.h0();
                    }
                }
                this.f35302a.D();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements b.a.e.i.j.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Long> f35303a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f35304b;

        /* loaded from: classes6.dex */
        public class a implements b.a.e.i.g.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BdFileDownloadData f35305a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ j f35306b;

            public a(j jVar, BdFileDownloadData bdFileDownloadData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, bdFileDownloadData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35306b = jVar;
                this.f35305a = bdFileDownloadData;
            }

            @Override // b.a.e.i.g.b
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f35306b.f35304b.l == null) {
                    return;
                }
                this.f35306b.f35304b.l.c(this.f35305a, 0, "");
            }

            @Override // b.a.e.i.g.b
            public void b(String str, String str2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.f35306b.f35304b.l == null) {
                    return;
                }
                this.f35306b.f35304b.l.c(this.f35305a, -1, "rom_size".equals(str2) ? BdBaseApplication.getInst().getString(R.string.rom_too_small) : "");
            }
        }

        public j(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35304b = pluginPackageManager;
            this.f35303a = new HashMap();
        }

        @Override // b.a.e.i.j.e.a
        public void a(BdFileDownloadData bdFileDownloadData) {
            String id;
            PluginSetting h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) {
                if (this.f35304b.l != null) {
                    this.f35304b.l.a(bdFileDownloadData);
                }
                if (bdFileDownloadData == null || (h2 = b.a.e.i.j.g.d.k().h((id = bdFileDownloadData.getId()))) == null) {
                    return;
                }
                b.a.e.i.j.g.d.k().y(id, b.a.e.i.j.g.b.f2311a);
                if (this.f35303a.containsKey(id)) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f35303a.get(id).longValue();
                    b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                    b2.o("plugin_download", "re-download-success", id, "costTimes:" + String.valueOf(currentTimeMillis));
                    this.f35303a.remove(id);
                }
                b.a.e.i.h.a.b().t("plugin_download", bdFileDownloadData.getId());
                if (Util.u(h2.size)) {
                    if (this.f35304b.l != null) {
                        k kVar = new k(this.f35304b, null);
                        kVar.f35309c = id;
                        kVar.f35307a = System.currentTimeMillis();
                        kVar.f35308b = new a(this, bdFileDownloadData);
                        this.f35304b.f35283b.put(id, kVar);
                    }
                    this.f35304b.X(Util.l(h2), h2.packageName, "install_from_download");
                    return;
                }
                b.a.e.i.g.d.q(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.g()));
                if (this.f35304b.l != null) {
                    this.f35304b.l.c(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
                }
            }
        }

        @Override // b.a.e.i.j.e.a
        public boolean b(BdFileDownloadData bdFileDownloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdFileDownloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // b.a.e.i.j.e.a
        public boolean c(BdFileDownloadData bdFileDownloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // b.a.e.i.j.e.a
        public void d(BdFileDownloadData bdFileDownloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bdFileDownloadData) == null) || this.f35304b.l == null) {
                return;
            }
            this.f35304b.l.d(bdFileDownloadData);
        }

        @Override // b.a.e.i.j.e.a
        public void e(BdFileDownloadData bdFileDownloadData, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048580, this, bdFileDownloadData, i2, str, str2) == null) {
                if (this.f35304b.l != null) {
                    bdFileDownloadData.setStatusMsg(str);
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(i2);
                    this.f35304b.l.b(bdFileDownloadData);
                }
                this.f35304b.h0();
                if (bdFileDownloadData == null) {
                    return;
                }
                if (!this.f35303a.containsKey(bdFileDownloadData.getId())) {
                    this.f35303a.put(bdFileDownloadData.getId(), Long.valueOf(System.currentTimeMillis()));
                }
                b.a.e.i.h.a.b().p("plugin_download_fail", bdFileDownloadData.getId(), String.valueOf(i2), str2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f35307a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.e.i.g.b f35308b;

        /* renamed from: c  reason: collision with root package name */
        public String f35309c;

        public /* synthetic */ k(PluginPackageManager pluginPackageManager, b bVar) {
            this(pluginPackageManager);
        }

        public k(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(141280101, "Lcom/baidu/adp/plugin/packageManager/PluginPackageManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(141280101, "Lcom/baidu/adp/plugin/packageManager/PluginPackageManager;");
        }
    }

    public PluginPackageManager() {
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
        this.f35283b = null;
        this.f35284c = false;
        this.f35285d = false;
        this.f35286e = false;
        this.f35289h = 0L;
        this.f35290i = false;
        this.j = false;
        this.k = 0;
        this.n = new b(this);
        this.o = new c(this);
        this.p = new d(this);
        this.q = new f(this);
        this.r = new i(this);
        this.s = new j(this);
        this.t = new a(this, 2000994);
        this.f35282a = BdBaseApplication.getInst();
        this.f35283b = new Hashtable<>();
        s0();
    }

    public static final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? u : invokeV.intValue;
    }

    public static PluginPackageManager O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (w == null) {
                synchronized (PluginPackageManager.class) {
                    if (w == null) {
                        w = new PluginPackageManager();
                    }
                }
            }
            return w;
        }
        return (PluginPackageManager) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                Iterator<Map.Entry<String, k>> it = this.f35283b.entrySet().iterator();
                while (it.hasNext()) {
                    k value = it.next().getValue();
                    if (value != null && currentTimeMillis - value.f35307a >= 600000) {
                        if (value.f35308b != null) {
                            value.f35308b.b(value.f35309c, "plugin install time out");
                        }
                        it.remove();
                    }
                }
            }
        }
    }

    public final void B(PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pluginSetting) == null) && this.f35284c) {
            b.a.e.i.j.c.e().d(pluginSetting);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f35290i) {
            b.a.e.i.j.b.d().c(this.f35284c);
        }
    }

    public final void D() {
        PluginSettings l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (l = b.a.e.i.j.g.d.k().l()) == null) {
            return;
        }
        ArrayList<PluginSetting> arrayList = new ArrayList<>();
        for (Map.Entry<String, PluginSetting> entry : l.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null) {
                W(value, arrayList);
            }
        }
        Iterator<PluginSetting> it = arrayList.iterator();
        while (it.hasNext()) {
            PluginSetting next = it.next();
            if (next != null) {
                r0(next);
            }
        }
    }

    public final void E(String str, String str2) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || TextUtils.isEmpty(str) || (h2 = b.a.e.i.j.g.d.k().h(str)) == null) {
            return;
        }
        if (h2.installStatus == b.a.e.i.j.g.b.f2312b && TextUtils.isEmpty(str2)) {
            b.a.e.i.h.a.b().q("plugin_del_unuse", "server forbidden", str);
            F(str);
        } else if (!TextUtils.isEmpty(h2.getAbandon_apk_path())) {
            String[] split = str2.split(",");
            String[] split2 = h2.getAbandon_apk_path().split(",");
            HashMap hashMap = new HashMap();
            ArrayList<a.b> arrayList = new ArrayList<>();
            for (String str3 : split) {
                hashMap.put(str3, "");
            }
            for (String str4 : split2) {
                if (hashMap.get(str4) == null) {
                    arrayList.add(new a.b(str, str4));
                }
            }
            b.a.e.i.j.a.h().f(arrayList, this.p);
        }
    }

    public final void F(String str) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str) || (h2 = b.a.e.i.j.g.d.k().h(str)) == null) {
            return;
        }
        ArrayList<a.b> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(h2.getAbandon_apk_path())) {
            for (String str2 : h2.getAbandon_apk_path().split(",")) {
                arrayList.add(new a.b(str, str2));
            }
        }
        arrayList.add(new a.b(str, h2.apkPath));
        b.a.e.i.j.a.h().f(arrayList, this.p);
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f35284c) {
            b.a.e.i.j.g.d.k().v(false);
        }
    }

    public final void H(PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pluginSetting) == null) {
            I(pluginSetting, this.s, false);
        }
    }

    public final void I(PluginSetting pluginSetting, b.a.e.i.j.e.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, pluginSetting, aVar, z) == null) && this.f35284c && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.j(pluginSetting));
            bdFileDownloadData.setPath(Util.l(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            bdFileDownloadData.setSize(pluginSetting.size);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (Util.u(pluginSetting.size)) {
                if (z) {
                    b.a.e.i.j.e.c.b().f(bdFileDownloadData, aVar);
                    return;
                } else {
                    b.a.e.i.j.e.c.b().e(bdFileDownloadData, aVar);
                    return;
                }
            }
            if (aVar != null) {
                bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(-1);
                aVar.e(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
            }
            b.a.e.i.h.a.b().q("plugin_download", "rom too small", pluginSetting.packageName);
        }
    }

    public final void J(String str, boolean z, String str2) {
        k remove;
        b.a.e.i.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) || StringUtils.isNull(str) || (remove = this.f35283b.remove(str)) == null || (bVar = remove.f35308b) == null) {
            return;
        }
        if (z) {
            bVar.a(str);
        } else {
            bVar.b(remove.f35309c, str2);
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            b.a.e.i.j.g.d.k().i(str);
        }
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35287f : (String) invokeV.objValue;
    }

    public final String N(List<PluginNetConfigInfos.PluginConfig> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
            String str = "";
            if (list == null) {
                return "";
            }
            for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
                if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                    String str2 = pluginConfig.forbidden_features;
                    if (!TextUtils.isEmpty(str2)) {
                        str = TextUtils.isEmpty(str) ? str2 : str + "," + str2;
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public PluginSetting P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return b.a.e.i.j.g.d.k().h(str);
        }
        return (PluginSetting) invokeL.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : invokeV.intValue;
    }

    public PluginNetConfigInfos.PluginConfig R(String str) {
        InterceptResult invokeL;
        PluginNetConfigInfos d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (d2 = b.a.e.i.j.f.d.c().d()) == null) {
                return null;
            }
            return d2.getPluginConfig(str);
        }
        return (PluginNetConfigInfos.PluginConfig) invokeL.objValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PluginSettings l = b.a.e.i.j.g.d.k().l();
            if (l != null && l.getPlugins() != null && l.getPlugins().size() != 0) {
                for (Map.Entry<String, PluginSetting> entry : l.getPlugins().entrySet()) {
                    PluginSetting value = entry.getValue();
                    if (value != null && T(value.packageName)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean T(String str) {
        InterceptResult invokeL;
        PluginNetConfigInfos.Newest newest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int i2 = -1;
            PluginNetConfigInfos d2 = b.a.e.i.j.f.d.c().d();
            if (d2 != null) {
                PluginNetConfigInfos.PluginConfig pluginConfig = d2.getPluginConfig(str);
                if (pluginConfig != null && pluginConfig.enable == 1) {
                    return false;
                }
                if (pluginConfig != null && (newest = pluginConfig.newest) != null) {
                    i2 = newest.version_code;
                }
            }
            PluginSetting h2 = b.a.e.i.j.g.d.k().h(str);
            if (h2 != null) {
                int i3 = h2.versionCode;
                if (i3 < i2 || i3 < h2.tempVersionCode) {
                    return true;
                }
            } else if (i2 > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void U(String str, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.f35284c = z;
            this.f35285d = z2;
            this.f35286e = z3;
            this.f35287f = str;
            try {
                BdBaseApplication inst = BdBaseApplication.getInst();
                u = b.a.e.f.m.b.e(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), u);
            } catch (Throwable unused) {
            }
            b.a.e.i.j.g.d.k().p(null);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().registerListener(2000987, new h(this, 0));
        }
    }

    public final void W(PluginSetting pluginSetting, ArrayList<PluginSetting> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, pluginSetting, arrayList) == null) || arrayList == null || pluginSetting == null) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            PluginSetting pluginSetting2 = arrayList.get(i2);
            if (pluginSetting2 != null && pluginSetting2.priority > pluginSetting.priority) {
                break;
            }
            i2++;
        }
        arrayList.add(i2, pluginSetting);
    }

    public void X(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048597, this, str, str2, str3) == null) && this.f35284c) {
            b.a.e.i.h.a.b().d("plugin_install", str2, null, str3);
            if (!Util.u(new File(str).length())) {
                b.a.e.i.g.d.q(str, str2, "rom_size", String.valueOf(Util.g()));
            } else if (str != null) {
                if (new File(str).exists()) {
                    b.a.e.i.g.c.B().F(this.f35282a, str);
                    return;
                }
                b.a.e.i.h.a.b().o("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting h2 = b.a.e.i.j.g.d.k().h(str2);
                if (h2 != null) {
                    h2.tempVersionCode = 0;
                    h2.url = "";
                    h2.tempMd5 = "";
                    h2.install_fail_count = 0;
                    h2.installStatus = 0;
                    h2.size = 0;
                    b.a.e.i.j.g.d.k().m(str2, h2);
                }
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.f35284c) {
            b.a.e.i.g.c.B().E(this.f35282a, this.q);
        }
    }

    public boolean Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? b.a.e.i.j.e.c.b().c(str) : invokeL.booleanValue;
    }

    public boolean a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (b.a.e.i.j.g.d.k().l() == null) {
                return false;
            }
            return b.a.e.i.j.g.d.k().l().isFeatureForbidden(str);
        }
        return invokeL.booleanValue;
    }

    public boolean b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            PluginSetting h2 = b.a.e.i.j.g.d.k().h(str);
            if (h2 == null) {
                return true;
            }
            return h2.forbidden;
        }
        return invokeL.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f35284c : invokeV.booleanValue;
    }

    public boolean d0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? y(str) : invokeL.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f35285d : invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? S() && !this.f35288g : invokeV.booleanValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.f35284c) {
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().registerListener(this.t);
        }
    }

    public void i0(b.a.e.i.j.e.b bVar, b.a.e.i.j.f.b bVar2, boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{bVar, bVar2, Boolean.valueOf(z), obj}) == null) {
            b.a.e.i.h.b.e("PluginPackageManager_loadAllPlugins", ProgressInfo.JSON_KEY_BEGIN);
            if (this.f35290i) {
                b.a.e.i.h.a.b().g("plugin_pkgmanager_recreate");
            }
            b.a.e.i.j.e.c.b().d(bVar);
            b.a.e.i.j.f.d.c().f(bVar2);
            this.f35290i = true;
            PluginSettings l = b.a.e.i.j.g.d.k().l();
            if (l != null && (l == null || !z(this.f35287f, l.getContainerVersion()))) {
                b.a.e.i.h.b.e("PluginPackageManager_loadAllPlugins", "load_plugin");
                if ((b.a.e.f.b.a.a.d(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
                    e eVar = new e(this, obj);
                    eVar.setPriority(4);
                    eVar.execute(new Void[0]);
                } else {
                    b.a.e.i.h.b.e("PluginPackageManager_loadAllPlugins", "load_plugin#1");
                    m0(obj);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("install_buildin_plugin-");
                sb.append(this.f35287f);
                sb.append("-");
                sb.append(l == null ? "settings_is_null" : l.getContainerVersion());
                b.a.e.i.h.b.e("PluginPackageManager_loadAllPlugins", sb.toString());
                this.f35289h = System.currentTimeMillis();
                if (O().c0()) {
                    b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f35287f);
                    sb2.append("-");
                    sb2.append(l == null ? "" : l.getContainerVersion());
                    b2.o("plugin_setting", "version_update", null, sb2.toString());
                }
                G();
                Y();
            }
            t0();
            V();
            b.a.e.i.h.b.e("PluginPackageManager_loadAllPlugins", "end");
        }
    }

    public final void j0(PluginSettings pluginSettings) {
        List<PluginSetting> pluginSettingsSortLoadPriorty;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, pluginSettings) == null) || pluginSettings == null || pluginSettings.getPlugins() == null || (pluginSettingsSortLoadPriorty = pluginSettings.getPluginSettingsSortLoadPriorty()) == null) {
            return;
        }
        for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || pluginSettings.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                try {
                    if (!Util.q()) {
                        return;
                    }
                    Plugin.c launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                    if (launch != null && !launch.f35269a) {
                        b.a.e.i.h.a.b().g("patch_launch_failed");
                    }
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                    b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                    String str = pluginSetting.packageName;
                    b2.r("plugin_load", "plugin_patch_hook_failed", str, "exception : " + th.getMessage());
                    return;
                }
            }
        }
    }

    public void k0() {
        PluginSettings l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (l = b.a.e.i.j.g.d.k().l()) == null || z(this.f35287f, l.getContainerVersion())) {
            return;
        }
        j0(l);
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            b.a.e.i.h.b.e("PluginPackageManager_loadPlugin", ProgressInfo.JSON_KEY_BEGIN);
            PluginSettings l = b.a.e.i.j.g.d.k().l();
            if (l == null) {
                b.a.e.i.h.b.e("PluginPackageManager_loadPlugin", "PluginSettings_is_null");
                return;
            }
            int i2 = 0;
            StringBuilder sb = new StringBuilder();
            List<PluginSetting> pluginSettingsSortLoadPriorty = l.getPluginSettingsSortLoadPriorty();
            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                    if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                        if (!pluginSetting.isPatch || this.k <= 0) {
                            if (pluginSetting.enable && pluginSetting.installStatus != b.a.e.i.j.g.b.f2312b) {
                                b.a.e.i.h.b.e("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch");
                                if (!this.f35286e || "com.baidu.tieba.pluginCore".equals(pluginSetting.packageName) || "com.baidu.tieba.pluginExtend".equals(pluginSetting.packageName)) {
                                    Plugin.c launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                                    Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                                    if (!launch.f35269a && (plugin2 == null || !plugin2.isLoaded())) {
                                        b.a.e.i.h.b.e("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_fail-reason_" + launch.f35270b + "-comment_" + launch.f35271c);
                                    } else {
                                        b.a.e.i.h.b.e("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_success");
                                    }
                                    if (!launch.f35269a && plugin2 != null && !plugin2.isLoaded()) {
                                        i2++;
                                        if (O().c0()) {
                                            if (sb.length() > 0) {
                                                sb.append(",");
                                            }
                                            sb.append(pluginSetting.packageName);
                                            sb.append("-");
                                            sb.append(pluginSetting.apkPath);
                                            sb.append("-");
                                            sb.append(pluginSetting.forbidden);
                                            sb.append("-");
                                            sb.append(pluginSetting.enable);
                                            sb.append("-");
                                            sb.append(pluginSetting.installStatus);
                                            sb.append("-");
                                            sb.append(pluginSetting.versionCode);
                                            sb.append("-");
                                            sb.append(pluginSetting.install_fail_count);
                                            sb.append("-");
                                            sb.append(pluginSetting.getAbandon_apk_path());
                                            sb.append("-");
                                            sb.append(launch.f35270b);
                                            sb.append("-");
                                            sb.append(launch.f35271c);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (O().c0() && i2 > 0) {
                    b.a.e.i.h.a.b().o("plugin_load", "load_allplugin", null, sb.toString());
                }
                b.a.e.i.h.b.e("PluginPackageManager_loadPlugin", "end");
                return;
            }
            b.a.e.i.h.b.e("PluginPackageManager_loadPlugin", "PluginSetting_list_is_null");
        }
    }

    public final void m0(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, obj) == null) {
            l0();
            if (obj != null) {
                synchronized (obj) {
                    obj.notify();
                }
            }
            if (Build.VERSION.SDK_INT <= 10) {
                return;
            }
            y0(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PluginSettings l = b.a.e.i.j.g.d.k().l();
            if (l != null && l.getPlugins() != null && !z(this.f35287f, l.getContainerVersion())) {
                for (PluginSetting pluginSetting : l.getPlugins().values()) {
                    if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || l.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                        return true;
                    }
                    while (r2.hasNext()) {
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o0(String str, b.a.e.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, str, bVar) == null) {
            boolean d0 = d0(str);
            boolean H = b.a.e.i.g.c.B().H(str);
            if (d0 && !H) {
                bVar.a(str);
            } else {
                k kVar = new k(this, null);
                kVar.f35309c = str;
                kVar.f35307a = System.currentTimeMillis();
                kVar.f35308b = bVar;
                synchronized (this) {
                    if (this.f35283b.size() < 1000) {
                        this.f35283b.put(str, kVar);
                    } else {
                        BdLog.e("packageaction count is morethan 1000");
                    }
                }
            }
            A();
        }
    }

    public final void p0(b.a.e.i.j.f.c cVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        int i2;
        List<BasicNameValuePair> a2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048615, this, cVar, pluginConfig) == null) || pluginConfig == null || TextUtils.isEmpty(pluginConfig.package_name)) {
            return;
        }
        PluginSetting h2 = b.a.e.i.j.g.d.k().h(pluginConfig.package_name);
        boolean z = false;
        if (h2 == null) {
            h2 = new PluginSetting();
            h2.enable = false;
            h2.packageName = pluginConfig.package_name;
        }
        if (h2.installStatus == b.a.e.i.j.g.b.f2311a) {
            String l = Util.l(h2);
            if (!new File(l).exists() && this.f35284c) {
                b.a.e.i.h.a.b().o("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, l);
            }
        }
        h2.priority = pluginConfig.priority;
        h2.load_priority = pluginConfig.load_priority;
        String str = pluginConfig.ext;
        h2.ext = str;
        h2.rollback = 0;
        if (!TextUtils.isEmpty(str) && h2.ext.contains("rollback")) {
            try {
                h2.rollback = new JSONObject(h2.ext).getInt("rollback");
            } catch (Throwable unused) {
                b.a.e.i.h.a.b().o("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
            }
        }
        String str2 = null;
        if (pluginConfig.forbidden == 1) {
            b.a.e.i.h.a.b().o("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
            b.a.e.i.j.g.d.k().z(pluginConfig.package_name, false);
            b.a.e.i.j.g.d.k().y(pluginConfig.package_name, b.a.e.i.j.g.b.f2312b);
        } else {
            PluginNetConfigInfos.Newest newest = pluginConfig.newest;
            if (newest != null && newest.version_code < u && this.f35284c) {
                b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                String str3 = pluginConfig.package_name;
                b2.o("plugin_install", "server_config_versionlower", str3, u + "_" + h2.versionCode + "_" + pluginConfig.newest.version_code);
            }
            if (pluginConfig.enable == 1) {
                PluginNetConfigInfos.Newest newest2 = pluginConfig.newest;
                if (newest2 != null && (i3 = newest2.version_code) > (i4 = h2.versionCode)) {
                    h2.enable = false;
                    if (i3 > h2.tempVersionCode && i3 > i4) {
                        h2.tempVersionCode = i3;
                        h2.url = newest2.url;
                        h2.tempMd5 = newest2.md5;
                        h2.install_fail_count = 0;
                        h2.installStatus = 0;
                        h2.size = newest2.size;
                        int i5 = newest2.download_type;
                        if (i5 == b.a.e.i.j.g.a.f2309a) {
                            h2.installStatus = b.a.e.i.j.g.b.f2313c;
                        } else if (i5 == b.a.e.i.j.g.a.f2310b) {
                            h2.installStatus = b.a.e.i.j.g.b.f2314d;
                        }
                    } else if (h2.rollback > 0) {
                        h2.tempVersionCode = 0;
                        h2.url = null;
                        h2.tempMd5 = null;
                        h2.installStatus = 0;
                        z = true;
                    }
                    b.a.e.i.j.g.d.k().m(pluginConfig.package_name, h2);
                } else if (h2.rollback > 0) {
                    h2.tempVersionCode = 0;
                    h2.url = null;
                    h2.tempMd5 = null;
                    h2.installStatus = 0;
                    b.a.e.i.j.g.d.k().z(pluginConfig.package_name, false);
                    b.a.e.i.j.g.d.k().m(pluginConfig.package_name, h2);
                    z = true;
                } else {
                    if (cVar != null && (a2 = cVar.a()) != null) {
                        Iterator it = new ArrayList(a2).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it.next();
                            if (basicNameValuePair != null && TextUtils.equals(basicNameValuePair.getName(), pluginConfig.package_name)) {
                                str2 = basicNameValuePair.getValue();
                                break;
                            }
                        }
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (pluginConfig.newest == null) {
                        b.a.e.i.h.a b3 = b.a.e.i.h.a.b();
                        String str4 = pluginConfig.package_name;
                        b3.o("plugin_setting", "server_disable_plugin_nonewest", str4, "up-" + str2 + "-set-" + h2.versionCode + "-" + h2.apkPath);
                    } else {
                        b.a.e.i.h.a b4 = b.a.e.i.h.a.b();
                        String str5 = pluginConfig.package_name;
                        b4.o("plugin_setting", "server_disable_plugin_newestversionlow", str5, "up-" + str2 + "-config-" + pluginConfig.newest.version_code + "-set-" + h2.versionCode);
                    }
                    b.a.e.i.j.g.d.k().z(pluginConfig.package_name, false);
                    b.a.e.i.j.g.d.k().y(pluginConfig.package_name, b.a.e.i.j.g.b.f2312b);
                }
            } else {
                if (h2.versionCode == 0) {
                    h2.enable = false;
                } else {
                    h2.enable = true;
                }
                PluginNetConfigInfos.Newest newest3 = pluginConfig.newest;
                if (newest3 != null && (i2 = newest3.version_code) > h2.tempVersionCode && i2 > h2.versionCode) {
                    h2.tempVersionCode = i2;
                    h2.url = newest3.url;
                    h2.tempMd5 = newest3.md5;
                    h2.install_fail_count = 0;
                    h2.installStatus = 0;
                    h2.size = newest3.size;
                    int i6 = newest3.download_type;
                    if (i6 == b.a.e.i.j.g.a.f2309a) {
                        h2.installStatus = b.a.e.i.j.g.b.f2313c;
                    } else if (i6 == b.a.e.i.j.g.a.f2310b) {
                        h2.installStatus = b.a.e.i.j.g.b.f2314d;
                    }
                } else if (h2.rollback > 0) {
                    h2.tempVersionCode = 0;
                    h2.url = null;
                    h2.tempMd5 = null;
                    h2.installStatus = 0;
                    z = true;
                }
                b.a.e.i.j.g.d.k().m(pluginConfig.package_name, h2);
            }
        }
        if (h2.rollback <= 0 || !z) {
            return;
        }
        b.a.e.i.g.c.B().R(h2.packageName, h2.rollback);
    }

    public final void q0(b.a.e.i.j.f.c cVar, List<PluginNetConfigInfos.PluginConfig> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, cVar, list) == null) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
                p0(cVar, pluginConfig);
            }
        }
    }

    public final void r0(PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, pluginSetting) == null) || pluginSetting == null || TextUtils.isEmpty(pluginSetting.packageName)) {
            return;
        }
        if (pluginSetting.versionCode <= 0) {
            pluginSetting.enable = false;
            b.a.e.i.j.g.d.k().z(pluginSetting.packageName, false);
        }
        int i2 = pluginSetting.installStatus;
        if (i2 != b.a.e.i.j.g.b.f2312b) {
            int i3 = pluginSetting.versionCode;
            int i4 = pluginSetting.tempVersionCode;
            if (i3 < i4) {
                if (i2 == b.a.e.i.j.g.b.f2311a) {
                    X(Util.l(pluginSetting), pluginSetting.packageName, "install_from_setting");
                    return;
                } else if ((i2 == b.a.e.i.j.g.b.f2314d && b.a.e.f.p.j.H()) || pluginSetting.installStatus == b.a.e.i.j.g.b.f2313c) {
                    H(pluginSetting);
                    return;
                } else {
                    return;
                }
            }
            if (i3 == i4 && i3 > 0 && !pluginSetting.enable) {
                pluginSetting.enable = true;
                pluginSetting.tempMd5 = "";
                pluginSetting.url = "";
                pluginSetting.tempVersionCode = 0;
                b.a.e.i.j.g.d.k().m(pluginSetting.packageName, pluginSetting);
            }
            if (!pluginSetting.enable || pluginSetting.versionCode <= 0) {
                return;
            }
            b.a.e.i.j.g.d.k().j(pluginSetting.packageName);
            if (pluginSetting.versionCode < u) {
                b.a.e.i.h.a.b().i("plugin_launch_lowversion", pluginSetting.packageName);
                b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                String str = pluginSetting.packageName;
                b2.o("plugin_load", "load_lowversion", str, "set_by_config-" + pluginSetting.apkPath + "-" + pluginSetting.versionCode + "-" + pluginSetting.forbidden + "-" + pluginSetting.tempVersionCode + "-" + pluginSetting.installStatus);
            }
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                intentFilter.addAction("com.baidu.adp.plugin.deleted");
                this.f35282a.registerReceiver(this.n, intentFilter);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.currentpath");
                if (this.f35284c) {
                    intentFilter.setPriority(1);
                } else {
                    intentFilter.setPriority(1000);
                }
                this.f35282a.registerReceiver(this.o, intentFilter);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (this.f35284c) {
                for (Map.Entry<String, PluginSetting> entry : b.a.e.i.j.g.d.k().l().getPlugins().entrySet()) {
                    PluginSetting value = entry.getValue();
                    if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == b.a.e.i.j.g.b.f2312b)) {
                        Intent intent = new Intent("com.baidu.adp.plugin.currentpath");
                        Bundle bundle = new Bundle();
                        bundle.putString("package_name", value.packageName);
                        bundle.putString("current_path", "");
                        intent.putExtras(bundle);
                        this.f35282a.sendOrderedBroadcast(intent, null);
                    }
                }
            }
        }
    }

    public void u0(b.a.e.i.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.k = i2;
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f35288g = true;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.e.i.j.e.c.b().a(str);
    }

    public void x0(PluginNetConfigInfos.PluginConfig pluginConfig, b.a.e.i.j.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048624, this, pluginConfig, dVar) == null) || pluginConfig == null || TextUtils.isEmpty(pluginConfig.package_name)) {
            return;
        }
        PluginNetConfigInfos.Newest newest = pluginConfig.newest;
        if (newest == null || newest.version_code <= 0 || TextUtils.isEmpty(newest.url)) {
            if (dVar != null) {
                dVar.b(new BdFileDownloadData(pluginConfig.package_name));
            }
            if (pluginConfig.newest == null) {
                return;
            }
        }
        PluginSetting h2 = b.a.e.i.j.g.d.k().h(pluginConfig.package_name);
        if (h2 == null) {
            h2 = new PluginSetting();
            h2.packageName = pluginConfig.package_name;
        }
        PluginNetConfigInfos.Newest newest2 = pluginConfig.newest;
        h2.tempMd5 = newest2.md5;
        h2.tempVersionCode = newest2.version_code;
        h2.url = newest2.url;
        h2.size = newest2.size;
        b.a.e.i.j.g.d.k().m(h2.packageName, h2);
        this.l = dVar;
        I(h2, this.s, true);
    }

    public boolean y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            PluginSetting h2 = b.a.e.i.j.g.d.k().h(str);
            return h2 != null && h2.enable;
        }
        return invokeL.booleanValue;
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048626, this, z) == null) && this.f35284c) {
            b.a.e.f.m.e.a().postDelayed(new g(this, z), 1500L);
        }
    }

    public final boolean z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048627, this, str, str2)) == null) ? TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.c(str2, str) != Util.VersionCompare.EQUAL : invokeLL.booleanValue;
    }

    public void z0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            b.a.e.i.j.g.d.k().A(str);
        }
    }
}
