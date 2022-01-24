package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.i.j.a;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes9.dex */
public class PluginPackageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static int q = 43;
    public static volatile PluginPackageManager r;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Hashtable<String, h> f31250b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31251c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31252d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31253e;

    /* renamed from: f  reason: collision with root package name */
    public long f31254f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31255g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31256h;

    /* renamed from: i  reason: collision with root package name */
    public int f31257i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.i.j.c f31258j;
    public boolean k;
    public BroadcastReceiver l;
    public a.c m;
    public c.a.d.i.j.e.a n;
    public c.a.d.i.j.d.a o;
    public CustomMessageListener p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public int f31259b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f31260c;

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
            this.f31260c = pluginPackageManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f31260c.f31255g && l.z()) {
                if (this.f31259b < 3) {
                    PluginPackageManager pluginPackageManager = this.f31260c;
                    pluginPackageManager.L(pluginPackageManager.k);
                    this.f31259b++;
                    this.a = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.a > 60000) {
                    PluginPackageManager pluginPackageManager2 = this.f31260c;
                    pluginPackageManager2.L(pluginPackageManager2.k);
                    this.f31259b = 0;
                    this.a = System.currentTimeMillis();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
                PluginSetting h2 = c.a.d.i.j.f.c.j().h(stringExtra);
                if (h2 == null) {
                    h2 = new PluginSetting();
                    h2.forbidden = false;
                }
                if (this.this$0.f31251c) {
                    str2 = "load_lowversion";
                    if (this.installFailRetryMap.containsKey(h2.packageName)) {
                        c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
                        StringBuilder sb = new StringBuilder();
                        str3 = "plugin_load";
                        sb.append("retry_at_num_");
                        str4 = "-";
                        sb.append(this.installFailRetryMap.get(h2.packageName));
                        b2.m("plugin_install", "re_install_success", stringExtra, sb.toString());
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
                        if (this.this$0.f31251c) {
                            c.a.d.i.h.a.b().d("plugin_install_suc", stringExtra, h2, "");
                            c.a.d.i.h.a b3 = c.a.d.i.h.a.b();
                            b3.m("plugin_install", "plugin_install_suc", stringExtra, "flag=" + stringExtra6 + "_fail=" + h2.install_fail_count);
                            if (intExtra < PluginPackageManager.q) {
                                c.a.d.i.h.a.b().i("plugin_launch_lowversion", stringExtra);
                                c.a.d.i.h.a b4 = c.a.d.i.h.a.b();
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
                                b4.m(str3, str2, stringExtra, sb2.toString());
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
                        this.this$0.n(h2);
                        c.a.d.i.j.f.c.j().w(stringExtra, h2, this.this$0.f31251c);
                        boolean z = !h2.isPatch && TextUtils.isEmpty(h2.replaceMethodClasses);
                        if (!TextUtils.isEmpty(h2.requireLoad) && h2.requireLoad.equals("0") && !z) {
                            PluginCenter.getInstance().launch(h2.packageName);
                        }
                        this.this$0.r(stringExtra, true, null);
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
                if (this.this$0.f31251c) {
                }
                h2.tempMd5 = "";
                h2.url = "";
                h2.install_fail_count = 0;
                h2.hasRes = intent.getBooleanExtra("has_res", false);
                h2.isThird = intent.getBooleanExtra("is_third", false);
                h2.isPatch = intent.getBooleanExtra("is_patch", false);
                h2.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                h2.setInjectClassloader(booleanExtra);
                this.this$0.n(h2);
                c.a.d.i.j.f.c.j().w(stringExtra, h2, this.this$0.f31251c);
                if (h2.isPatch) {
                }
                if (!TextUtils.isEmpty(h2.requireLoad)) {
                    PluginCenter.getInstance().launch(h2.packageName);
                }
                this.this$0.r(stringExtra, true, null);
            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                String stringExtra7 = intent.getStringExtra("install_src_file");
                if (stringExtra7 == null) {
                    return;
                }
                String substring = stringExtra7.substring(stringExtra7.lastIndexOf("/") + 1, stringExtra7.lastIndexOf(Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
                String stringExtra8 = intent.getStringExtra("fail_reason");
                String stringExtra9 = intent.getStringExtra("install_comment");
                String stringExtra10 = intent.getStringExtra("package_name");
                String stringExtra11 = intent.getStringExtra("install_flag");
                if (TextUtils.isEmpty(stringExtra10)) {
                    pluginSetting = null;
                } else {
                    PluginSetting h3 = c.a.d.i.j.f.c.j().h(stringExtra10);
                    if ("apk_not_exist".equals(stringExtra8) && h3 != null && h3.installStatus == 0 && h3.tempVersionCode == 0) {
                        c.a.d.i.h.a b5 = c.a.d.i.h.a.b();
                        b5.m("plugin_install", "intercept_apk_not_exist", stringExtra10, stringExtra11 + "_" + stringExtra7);
                        return;
                    } else if ("assets_not_found".equals(stringExtra8)) {
                        c.a.d.i.h.a b6 = c.a.d.i.h.a.b();
                        b6.m("plugin_install", "assets_not_found", stringExtra10, stringExtra11 + "_" + stringExtra9);
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
                        if (this.this$0.f31251c) {
                            int i2 = pluginSetting.install_fail_count + 1;
                            pluginSetting.install_fail_count = i2;
                            if (i2 >= 5) {
                                this.this$0.n(pluginSetting);
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = "";
                                pluginSetting.tempMd5 = "";
                                pluginSetting.install_fail_count = 0;
                                pluginSetting.installStatus = 0;
                            }
                            if (pluginSetting.install_fail_count >= c.a.d.f.n.m.a.o().q("alert_plugin", 3)) {
                                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                                bdStatisticsManager.alert("alert_plugin", "package name = " + stringExtra10 + "; fail count = " + pluginSetting.install_fail_count);
                            }
                        }
                        c.a.d.i.j.f.c.j().w(stringExtra10, pluginSetting, this.this$0.f31251c);
                    }
                }
                this.this$0.r(substring, false, stringExtra8);
                if (this.this$0.f31251c) {
                    if (stringExtra9 != null) {
                        String lowerCase = stringExtra9.toLowerCase(Locale.getDefault());
                        if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                            stringExtra8 = "rom_size";
                        } else if (!lowerCase.contains("read-only_file_system") && !lowerCase.contains("read-only file system")) {
                            if (!lowerCase.contains("permission_denied") && !lowerCase.contains("permission denied")) {
                                if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    c.a.d.i.h.a.b().i("plugin_fsync_failed", stringExtra10);
                                    stringExtra8 = "fsync_failed";
                                }
                            } else {
                                c.a.d.i.h.a.b().i("plugin_permission_denied", stringExtra10);
                                stringExtra8 = "permission_denied";
                            }
                        } else {
                            c.a.d.i.h.a.b().i("plugin_read_file_sys", stringExtra10);
                            stringExtra8 = "read_file_system";
                        }
                    }
                    if ("rom_size".equals(stringExtra8)) {
                        c.a.d.i.h.a.b().i("plugin_rom_small", stringExtra10);
                    }
                    c.a.d.i.h.a.b().e("plugin_install_fail", stringExtra10, pluginSetting, stringExtra8);
                    c.a.d.i.h.a b7 = c.a.d.i.h.a.b();
                    b7.p("plugin_install", stringExtra8, stringExtra10, stringExtra9 + "_flag=" + stringExtra11);
                }
            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                String stringExtra12 = intent.getStringExtra("package_name");
                PluginSetting h4 = c.a.d.i.j.f.c.j().h(stringExtra12);
                if (h4 != null) {
                    c.a.d.i.j.f.c.j().u(stringExtra12, true);
                    if (h4.versionCode < PluginPackageManager.q) {
                        c.a.d.i.h.a.b().i("plugin_launch_lowversion", stringExtra12);
                        c.a.d.i.h.a b8 = c.a.d.i.h.a.b();
                        b8.m("plugin_load", "load_lowversion", stringExtra12, "broadcast_cancel-" + h4.apkPath + "-" + h4.versionCode + "-" + h4.forbidden + "-" + h4.tempVersionCode + "-" + h4.installStatus);
                    }
                    str = null;
                } else {
                    str = null;
                    c.a.d.i.h.a.b().m("plugin_install", "install_cancel_settingnull", stringExtra12, null);
                }
                this.this$0.r(stringExtra12, true, str);
            } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                String stringExtra13 = intent.getStringExtra("fail_reason");
                String stringExtra14 = intent.getStringExtra("package_name");
                if (TextUtils.isEmpty(stringExtra14)) {
                    return;
                }
                PluginSetting h5 = c.a.d.i.j.f.c.j().h(stringExtra14);
                if (h5 == null) {
                    h5 = new PluginSetting();
                    h5.packageName = stringExtra14;
                }
                h5.enable = false;
                if (this.this$0.f31251c && "low_version_code".equals(stringExtra13)) {
                    this.this$0.n(h5);
                    h5.tempVersionCode = 0;
                    h5.url = "";
                    h5.tempMd5 = "";
                    h5.install_fail_count = 0;
                    h5.installStatus = 0;
                }
                c.a.d.i.j.f.c.j().w(stringExtra14, h5, this.this$0.f31251c);
                if ("low_version_code".equals(stringExtra13)) {
                    c.a.d.i.h.a.b().i("plugin_low_version_code", stringExtra14);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
                if (this.this$0.f31251c) {
                    this.this$0.o(string, str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginPackageManager a;

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
            this.a = pluginPackageManager;
        }

        @Override // c.a.d.i.j.a.c
        public void a(String str, String str2) {
            PluginSetting h2;
            String[] split;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (h2 = c.a.d.i.j.f.c.j().h(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(h2.apkPath) && h2.apkPath.equals(str2)) {
                c.a.d.i.h.a.b().m("plugin_setting", "del_unuse_plugin_setting", h2.packageName, "apkpath-" + h2.apkPath + "-forbidden-" + h2.forbidden + "-enable-" + h2.enable + "-abandonapkpath-" + h2.getAbandon_apk_path() + "-versioncode-" + h2.versionCode);
                c.a.d.i.j.f.c.j().o(str);
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
                c.a.d.i.j.f.c.j().s(str, str3, this.a.f31251c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f31261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f31262f;

        public e(PluginPackageManager pluginPackageManager, boolean z) {
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
            this.f31262f = pluginPackageManager;
            this.f31261e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d.i.j.e.d.a().c(c.a.d.i.j.f.c.j().k(), this.f31261e, this.f31262f.n);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements c.a.d.i.j.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements c.a.d.i.j.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, Long> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PluginPackageManager f31263b;

        public g(PluginPackageManager pluginPackageManager) {
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
            this.f31263b = pluginPackageManager;
            this.a = new HashMap();
        }

        @Override // c.a.d.i.j.d.a
        public void a(BdFileDownloadData bdFileDownloadData, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, bdFileDownloadData, i2, str, str2) == null) {
                if (this.f31263b.f31258j != null) {
                    bdFileDownloadData.setStatusMsg(str);
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(i2);
                    this.f31263b.f31258j.a(bdFileDownloadData);
                }
                this.f31263b.F();
                if (bdFileDownloadData == null) {
                    return;
                }
                if (!this.a.containsKey(bdFileDownloadData.getId())) {
                    this.a.put(bdFileDownloadData.getId(), Long.valueOf(System.currentTimeMillis()));
                }
                c.a.d.i.h.a.b().n("plugin_download_fail", bdFileDownloadData.getId(), String.valueOf(i2), str2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.d.i.g.b f31264b;

        /* renamed from: c  reason: collision with root package name */
        public String f31265c;

        public /* synthetic */ h(PluginPackageManager pluginPackageManager, b bVar) {
            this(pluginPackageManager);
        }

        public h(PluginPackageManager pluginPackageManager) {
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
        this.f31250b = null;
        this.f31251c = false;
        this.f31252d = false;
        this.f31253e = false;
        this.f31254f = 0L;
        this.f31255g = false;
        this.f31256h = false;
        this.f31257i = 0;
        this.l = new b(this);
        new c(this);
        this.m = new d(this);
        this.n = new f(this);
        this.o = new g(this);
        this.p = new a(this, 2000994);
        this.a = BdBaseApplication.getInst();
        this.f31250b = new Hashtable<>();
        H();
    }

    public static final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? q : invokeV.intValue;
    }

    public static PluginPackageManager u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (r == null) {
                synchronized (PluginPackageManager.class) {
                    if (r == null) {
                        r = new PluginPackageManager();
                    }
                }
            }
            return r;
        }
        return (PluginPackageManager) invokeV.objValue;
    }

    public boolean A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PluginSetting h2 = c.a.d.i.j.f.c.j().h(str);
            if (h2 == null) {
                return true;
            }
            return h2.forbidden;
        }
        return invokeL.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31251c : invokeV.booleanValue;
    }

    public boolean C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? l(str) : invokeL.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31256h : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31252d : invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f31251c) {
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public void G(String str, c.a.d.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bVar) == null) {
            boolean C = C(str);
            boolean B = c.a.d.i.g.c.y().B(str);
            if (C && !B) {
                bVar.a(str);
            } else {
                h hVar = new h(this, null);
                hVar.f31265c = str;
                hVar.a = System.currentTimeMillis();
                hVar.f31264b = bVar;
                synchronized (this) {
                    if (this.f31250b.size() < 1000) {
                        this.f31250b.put(str, hVar);
                    } else {
                        BdLog.e("packageaction count is morethan 1000");
                    }
                }
            }
            m();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                intentFilter.addAction("com.baidu.adp.plugin.deleted");
                this.a.registerReceiver(this.l, intentFilter);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void I(c.a.d.i.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f31258j = cVar;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void K(PluginNetConfigInfos.PluginConfig pluginConfig, c.a.d.i.j.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, pluginConfig, cVar) == null) || pluginConfig == null || TextUtils.isEmpty(pluginConfig.package_name)) {
            return;
        }
        PluginNetConfigInfos.Newest newest = pluginConfig.newest;
        if (newest == null || newest.version_code <= 0 || TextUtils.isEmpty(newest.url)) {
            if (cVar != null) {
                cVar.a(new BdFileDownloadData(pluginConfig.package_name));
            }
            if (pluginConfig.newest == null) {
                return;
            }
        }
        PluginSetting h2 = c.a.d.i.j.f.c.j().h(pluginConfig.package_name);
        if (h2 == null) {
            h2 = new PluginSetting();
            h2.packageName = pluginConfig.package_name;
        }
        PluginNetConfigInfos.Newest newest2 = pluginConfig.newest;
        h2.tempMd5 = newest2.md5;
        h2.tempVersionCode = newest2.version_code;
        h2.url = newest2.url;
        h2.size = newest2.size;
        c.a.d.i.j.f.c.j().l(h2.packageName, h2);
        this.f31258j = cVar;
        q(h2, this.o, true);
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && this.f31251c) {
            c.a.d.f.m.e.a().postDelayed(new e(this, z), 1500L);
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            c.a.d.i.j.f.c.j().v(str);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.d.i.j.d.c.b().a(str);
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            PluginSetting h2 = c.a.d.i.j.f.c.j().h(str);
            return h2 != null && h2.enable;
        }
        return invokeL.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                Iterator<Map.Entry<String, h>> it = this.f31250b.entrySet().iterator();
                while (it.hasNext()) {
                    h value = it.next().getValue();
                    if (value != null && currentTimeMillis - value.a >= 600000) {
                        if (value.f31264b != null) {
                            value.f31264b.b(value.f31265c, "plugin install time out");
                        }
                        it.remove();
                    }
                }
            }
        }
    }

    public final void n(PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, pluginSetting) == null) && this.f31251c) {
            c.a.d.i.j.b.e().d(pluginSetting);
        }
    }

    public final void o(String str, String str2) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) || TextUtils.isEmpty(str) || (h2 = c.a.d.i.j.f.c.j().h(str)) == null) {
            return;
        }
        if (h2.installStatus == c.a.d.i.j.f.a.a && TextUtils.isEmpty(str2)) {
            c.a.d.i.h.a.b().o("plugin_del_unuse", "server forbidden", str);
            p(str);
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
            c.a.d.i.j.a.h().f(arrayList, this.m);
        }
    }

    public final void p(String str) {
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || TextUtils.isEmpty(str) || (h2 = c.a.d.i.j.f.c.j().h(str)) == null) {
            return;
        }
        ArrayList<a.b> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(h2.getAbandon_apk_path())) {
            for (String str2 : h2.getAbandon_apk_path().split(",")) {
                arrayList.add(new a.b(str, str2));
            }
        }
        arrayList.add(new a.b(str, h2.apkPath));
        c.a.d.i.j.a.h().f(arrayList, this.m);
    }

    public final void q(PluginSetting pluginSetting, c.a.d.i.j.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048595, this, pluginSetting, aVar, z) == null) && this.f31251c && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.f(pluginSetting));
            bdFileDownloadData.setPath(Util.h(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            bdFileDownloadData.setSize(pluginSetting.size);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (Util.q(pluginSetting.size)) {
                if (z) {
                    c.a.d.i.j.d.c.b().e(bdFileDownloadData, aVar);
                    return;
                } else {
                    c.a.d.i.j.d.c.b().d(bdFileDownloadData, aVar);
                    return;
                }
            }
            if (aVar != null) {
                bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(-1);
                aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
            }
            c.a.d.i.h.a.b().o("plugin_download", "rom too small", pluginSetting.packageName);
        }
    }

    public final void r(String str, boolean z, String str2) {
        h remove;
        c.a.d.i.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) || StringUtils.isNull(str) || (remove = this.f31250b.remove(str)) == null || (bVar = remove.f31264b) == null) {
            return;
        }
        if (z) {
            bVar.a(str);
        } else {
            bVar.b(remove.f31265c, str2);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            c.a.d.i.j.f.c.j().i(str);
        }
    }

    public PluginSetting v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return c.a.d.i.j.f.c.j().h(str);
        }
        return (PluginSetting) invokeL.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f31257i : invokeV.intValue;
    }

    public boolean x(String str) {
        InterceptResult invokeL;
        PluginNetConfigInfos.Newest newest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int i2 = -1;
            PluginNetConfigInfos b2 = c.a.d.i.j.e.d.a().b();
            if (b2 != null) {
                PluginNetConfigInfos.PluginConfig pluginConfig = b2.getPluginConfig(str);
                if (pluginConfig != null && pluginConfig.enable == 1) {
                    return false;
                }
                if (pluginConfig != null && (newest = pluginConfig.newest) != null) {
                    i2 = newest.version_code;
                }
            }
            PluginSetting h2 = c.a.d.i.j.f.c.j().h(str);
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

    public boolean y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? c.a.d.i.j.d.c.b().c(str) : invokeL.booleanValue;
    }

    public boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            if (c.a.d.i.j.f.c.j().k() == null) {
                return false;
            }
            return c.a.d.i.j.f.c.j().k().isFeatureForbidden(str);
        }
        return invokeL.booleanValue;
    }
}
