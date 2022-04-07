package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bm;
import com.repackage.cm;
import com.repackage.em;
import com.repackage.fm;
import com.repackage.gm;
import com.repackage.hm;
import com.repackage.im;
import com.repackage.kh;
import com.repackage.lm;
import com.repackage.mi;
import com.repackage.mm;
import com.repackage.om;
import com.repackage.pg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginPackageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static int n = 43;
    public static volatile PluginPackageManager o;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Hashtable<String, h> b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long f;
    public boolean g;
    public boolean h;
    public int i;
    public boolean j;
    public BroadcastReceiver k;
    public fm.c l;
    public im m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
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

        public PluginStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public int b;
        public final /* synthetic */ PluginPackageManager c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PluginPackageManager pluginPackageManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pluginPackageManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.c.g && mi.z()) {
                if (this.b < 3) {
                    PluginPackageManager pluginPackageManager = this.c;
                    pluginPackageManager.z(pluginPackageManager.j);
                    this.b++;
                    this.a = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.a > 60000) {
                    PluginPackageManager pluginPackageManager2 = this.c;
                    pluginPackageManager2.z(pluginPackageManager2.j);
                    this.b = 0;
                    this.a = System.currentTimeMillis();
                }
            }
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pluginPackageManager;
            this.installFailRetryMap = new HashMap();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
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
                PluginSetting g = om.h().g(stringExtra);
                if (g == null) {
                    g = new PluginSetting();
                    g.forbidden = false;
                }
                if (this.this$0.c) {
                    str2 = "load_lowversion";
                    if (this.installFailRetryMap.containsKey(g.packageName)) {
                        em b = em.b();
                        StringBuilder sb = new StringBuilder();
                        str3 = "plugin_load";
                        sb.append("retry_at_num_");
                        str4 = "-";
                        sb.append(this.installFailRetryMap.get(g.packageName));
                        b.m("plugin_install", "re_install_success", stringExtra, sb.toString());
                        g.packageName = stringExtra;
                        if (!TextUtils.equals(stringExtra2, g.apkPath)) {
                            g.addAbandonApk(g.apkPath);
                        }
                        g.apkPath = stringExtra2;
                        g.setCmdRange(stringExtra5);
                        g.enable = true;
                        g.requireLoad = stringExtra4;
                        g.version = stringExtra3;
                        g.versionCode = intExtra;
                        g.installStatus = 0;
                        g.tempVersionCode = 0;
                        if (this.this$0.c) {
                            em.b().d("plugin_install_suc", stringExtra, g, "");
                            em b2 = em.b();
                            b2.m("plugin_install", "plugin_install_suc", stringExtra, "flag=" + stringExtra6 + "_fail=" + g.install_fail_count);
                            if (intExtra < PluginPackageManager.n) {
                                em.b().i("plugin_launch_lowversion", stringExtra);
                                em b3 = em.b();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("broadcast_suc-");
                                sb2.append(g.apkPath);
                                String str5 = str4;
                                sb2.append(str5);
                                sb2.append(g.versionCode);
                                sb2.append(str5);
                                sb2.append(g.forbidden);
                                sb2.append(str5);
                                sb2.append(g.tempVersionCode);
                                sb2.append(str5);
                                sb2.append(g.installStatus);
                                b3.m(str3, str2, stringExtra, sb2.toString());
                            }
                        }
                        g.tempMd5 = "";
                        g.url = "";
                        g.install_fail_count = 0;
                        g.hasRes = intent.getBooleanExtra("has_res", false);
                        g.isThird = intent.getBooleanExtra("is_third", false);
                        g.isPatch = intent.getBooleanExtra("is_patch", false);
                        g.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                        g.setInjectClassloader(booleanExtra);
                        this.this$0.k(g);
                        om.h().r(stringExtra, g, this.this$0.c);
                        boolean z = !g.isPatch && TextUtils.isEmpty(g.replaceMethodClasses);
                        if (!TextUtils.isEmpty(g.requireLoad) && g.requireLoad.equals("0") && !z) {
                            PluginCenter.getInstance().launch(g.packageName);
                        }
                        this.this$0.n(stringExtra, true, null);
                    }
                } else {
                    str2 = "load_lowversion";
                }
                str3 = "plugin_load";
                str4 = "-";
                g.packageName = stringExtra;
                if (!TextUtils.equals(stringExtra2, g.apkPath)) {
                }
                g.apkPath = stringExtra2;
                g.setCmdRange(stringExtra5);
                g.enable = true;
                g.requireLoad = stringExtra4;
                g.version = stringExtra3;
                g.versionCode = intExtra;
                g.installStatus = 0;
                g.tempVersionCode = 0;
                if (this.this$0.c) {
                }
                g.tempMd5 = "";
                g.url = "";
                g.install_fail_count = 0;
                g.hasRes = intent.getBooleanExtra("has_res", false);
                g.isThird = intent.getBooleanExtra("is_third", false);
                g.isPatch = intent.getBooleanExtra("is_patch", false);
                g.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                g.setInjectClassloader(booleanExtra);
                this.this$0.k(g);
                om.h().r(stringExtra, g, this.this$0.c);
                if (g.isPatch) {
                }
                if (!TextUtils.isEmpty(g.requireLoad)) {
                    PluginCenter.getInstance().launch(g.packageName);
                }
                this.this$0.n(stringExtra, true, null);
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
                    PluginSetting g2 = om.h().g(stringExtra10);
                    if ("apk_not_exist".equals(stringExtra8) && g2 != null && g2.installStatus == 0 && g2.tempVersionCode == 0) {
                        em b4 = em.b();
                        b4.m("plugin_install", "intercept_apk_not_exist", stringExtra10, stringExtra11 + "_" + stringExtra7);
                        return;
                    } else if ("assets_not_found".equals(stringExtra8)) {
                        em b5 = em.b();
                        b5.m("plugin_install", "assets_not_found", stringExtra10, stringExtra11 + "_" + stringExtra9);
                        return;
                    } else {
                        if (g2 == null) {
                            PluginSetting pluginSetting2 = new PluginSetting();
                            pluginSetting2.packageName = stringExtra10;
                            pluginSetting = pluginSetting2;
                        } else {
                            pluginSetting = g2;
                        }
                        pluginSetting.enable = false;
                        if (this.this$0.c) {
                            int i = pluginSetting.install_fail_count + 1;
                            pluginSetting.install_fail_count = i;
                            if (i >= 5) {
                                this.this$0.k(pluginSetting);
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = "";
                                pluginSetting.tempMd5 = "";
                                pluginSetting.install_fail_count = 0;
                                pluginSetting.installStatus = 0;
                            }
                            if (pluginSetting.install_fail_count >= kh.o().q("alert_plugin", 3)) {
                                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                                bdStatisticsManager.alert("alert_plugin", "package name = " + stringExtra10 + "; fail count = " + pluginSetting.install_fail_count);
                            }
                        }
                        om.h().r(stringExtra10, pluginSetting, this.this$0.c);
                    }
                }
                this.this$0.n(substring, false, stringExtra8);
                if (this.this$0.c) {
                    if (stringExtra9 != null) {
                        String lowerCase = stringExtra9.toLowerCase(Locale.getDefault());
                        if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                            stringExtra8 = "rom_size";
                        } else if (!lowerCase.contains("read-only_file_system") && !lowerCase.contains("read-only file system")) {
                            if (!lowerCase.contains("permission_denied") && !lowerCase.contains("permission denied")) {
                                if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    em.b().i("plugin_fsync_failed", stringExtra10);
                                    stringExtra8 = "fsync_failed";
                                }
                            } else {
                                em.b().i("plugin_permission_denied", stringExtra10);
                                stringExtra8 = "permission_denied";
                            }
                        } else {
                            em.b().i("plugin_read_file_sys", stringExtra10);
                            stringExtra8 = "read_file_system";
                        }
                    }
                    if ("rom_size".equals(stringExtra8)) {
                        em.b().i("plugin_rom_small", stringExtra10);
                    }
                    em.b().e("plugin_install_fail", stringExtra10, pluginSetting, stringExtra8);
                    em b6 = em.b();
                    b6.p("plugin_install", stringExtra8, stringExtra10, stringExtra9 + "_flag=" + stringExtra11);
                }
            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                String stringExtra12 = intent.getStringExtra("package_name");
                PluginSetting g3 = om.h().g(stringExtra12);
                if (g3 != null) {
                    om.h().q(stringExtra12, true);
                    if (g3.versionCode < PluginPackageManager.n) {
                        em.b().i("plugin_launch_lowversion", stringExtra12);
                        em b7 = em.b();
                        b7.m("plugin_load", "load_lowversion", stringExtra12, "broadcast_cancel-" + g3.apkPath + "-" + g3.versionCode + "-" + g3.forbidden + "-" + g3.tempVersionCode + "-" + g3.installStatus);
                    }
                    str = null;
                } else {
                    str = null;
                    em.b().m("plugin_install", "install_cancel_settingnull", stringExtra12, null);
                }
                this.this$0.n(stringExtra12, true, str);
            } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                String stringExtra13 = intent.getStringExtra("fail_reason");
                String stringExtra14 = intent.getStringExtra("package_name");
                if (TextUtils.isEmpty(stringExtra14)) {
                    return;
                }
                PluginSetting g4 = om.h().g(stringExtra14);
                if (g4 == null) {
                    g4 = new PluginSetting();
                    g4.packageName = stringExtra14;
                }
                g4.enable = false;
                if (this.this$0.c && "low_version_code".equals(stringExtra13)) {
                    this.this$0.k(g4);
                    g4.tempVersionCode = 0;
                    g4.url = "";
                    g4.tempMd5 = "";
                    g4.install_fail_count = 0;
                    g4.installStatus = 0;
                }
                om.h().r(stringExtra14, g4, this.this$0.c);
                if ("low_version_code".equals(stringExtra13)) {
                    em.b().i("plugin_low_version_code", stringExtra14);
                }
            }
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                z = false;
                                break;
                            } else if (split[i].equals(pluginApkFilePath)) {
                                break;
                            } else {
                                i++;
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
                if (this.this$0.c) {
                    this.this$0.l(string, str);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements fm.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginPackageManager;
        }

        @Override // com.repackage.fm.c
        public void a(String str, String str2) {
            PluginSetting g;
            String[] split;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (g = om.h().g(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(g.apkPath) && g.apkPath.equals(str2)) {
                em.b().m("plugin_setting", "del_unuse_plugin_setting", g.packageName, "apkpath-" + g.apkPath + "-forbidden-" + g.forbidden + "-enable-" + g.enable + "-abandonapkpath-" + g.getAbandon_apk_path() + "-versioncode-" + g.versionCode);
                om.h().l(str);
            } else if (!TextUtils.isEmpty(g.getAbandon_apk_path())) {
                String str3 = "";
                for (String str4 : g.getAbandon_apk_path().split(",")) {
                    if (!str2.equals(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str3 = str3 + ",";
                        }
                        str3 = str3 + str4;
                    }
                }
                om.h().o(str, str3, this.a.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PluginPackageManager b;

        public e(PluginPackageManager pluginPackageManager, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pluginPackageManager;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lm.a().b(om.h().i(), this.a, this.b.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements im {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements hm {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(PluginPackageManager pluginPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            new HashMap();
        }
    }

    /* loaded from: classes.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public bm b;
        public String c;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = 0L;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.k = new b(this);
        new c(this);
        this.l = new d(this);
        this.m = new f(this);
        new g(this);
        new a(this, 2000994);
        this.a = BdBaseApplication.getInst();
        this.b = new Hashtable<>();
        y();
    }

    public static final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? n : invokeV.intValue;
    }

    public static PluginPackageManager p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (o == null) {
                synchronized (PluginPackageManager.class) {
                    if (o == null) {
                        o = new PluginPackageManager();
                    }
                }
            }
            return o;
        }
        return (PluginPackageManager) invokeV.objValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PluginSetting g2 = om.h().g(str);
            return g2 != null && g2.enable;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                Iterator<Map.Entry<String, h>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    h value = it.next().getValue();
                    if (value != null && currentTimeMillis - value.a >= 600000) {
                        if (value.b != null) {
                            value.b.b(value.c, "plugin install time out");
                        }
                        it.remove();
                    }
                }
            }
        }
    }

    public final void k(PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pluginSetting) == null) && this.c) {
            gm.e().d(pluginSetting);
        }
    }

    public final void l(String str, String str2) {
        PluginSetting g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || TextUtils.isEmpty(str) || (g2 = om.h().g(str)) == null) {
            return;
        }
        if (g2.installStatus == mm.a && TextUtils.isEmpty(str2)) {
            em.b().o("plugin_del_unuse", "server forbidden", str);
            m(str);
        } else if (!TextUtils.isEmpty(g2.getAbandon_apk_path())) {
            String[] split = str2.split(",");
            String[] split2 = g2.getAbandon_apk_path().split(",");
            HashMap hashMap = new HashMap();
            ArrayList<fm.b> arrayList = new ArrayList<>();
            for (String str3 : split) {
                hashMap.put(str3, "");
            }
            for (String str4 : split2) {
                if (hashMap.get(str4) == null) {
                    arrayList.add(new fm.b(str, str4));
                }
            }
            fm.h().f(arrayList, this.l);
        }
    }

    public final void m(String str) {
        PluginSetting g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str) || (g2 = om.h().g(str)) == null) {
            return;
        }
        ArrayList<fm.b> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(g2.getAbandon_apk_path())) {
            for (String str2 : g2.getAbandon_apk_path().split(",")) {
                arrayList.add(new fm.b(str, str2));
            }
        }
        arrayList.add(new fm.b(str, g2.apkPath));
        fm.h().f(arrayList, this.l);
    }

    public final void n(String str, boolean z, String str2) {
        h remove;
        bm bmVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) || StringUtils.isNull(str) || (remove = this.b.remove(str)) == null || (bmVar = remove.b) == null) {
            return;
        }
        if (z) {
            bmVar.a(str);
        } else {
            bmVar.b(remove.c, str2);
        }
    }

    public PluginSetting q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return om.h().g(str);
        }
        return (PluginSetting) invokeL.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : invokeV.intValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (om.h().i() == null) {
                return false;
            }
            return om.h().i().isFeatureForbidden(str);
        }
        return invokeL.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? i(str) : invokeL.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public void x(String str, bm bmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, bmVar) == null) {
            boolean u = u(str);
            boolean B = cm.y().B(str);
            if (u && !B) {
                bmVar.a(str);
            } else {
                h hVar = new h(this, null);
                hVar.c = str;
                hVar.a = System.currentTimeMillis();
                hVar.b = bmVar;
                synchronized (this) {
                    if (this.b.size() < 1000) {
                        this.b.put(str, hVar);
                    } else {
                        BdLog.e("packageaction count is morethan 1000");
                    }
                }
            }
            j();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                intentFilter.addAction("com.baidu.adp.plugin.deleted");
                this.a.registerReceiver(this.k, intentFilter);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && this.c) {
            pg.a().postDelayed(new e(this, z), 1500L);
        }
    }
}
