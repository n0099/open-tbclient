package c.a.d.j.j.g;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f2518b;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<String, PluginStatus> a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedHashMap<>(10);
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f2518b == null) {
                synchronized (a.class) {
                    if (f2518b == null) {
                        f2518b = new a();
                    }
                }
            }
            return f2518b;
        }
        return (a) invokeV.objValue;
    }

    public List<PluginStatus> a() {
        InterceptResult invokeV;
        ArrayList arrayList;
        PluginStatus value;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.a) {
                arrayList = new ArrayList(this.a.size());
                for (Map.Entry<String, PluginStatus> entry : this.a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.f23879b == PluginPackageManager.PluginStatus.ERROR) {
                        arrayList.add(value);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public PluginStatus c(String str) {
        InterceptResult invokeL;
        PluginStatus pluginStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null || TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (this.a) {
                pluginStatus = this.a.get(str);
                if (pluginStatus == null) {
                    pluginStatus = new PluginStatus();
                    pluginStatus.a = str;
                    this.a.put(str, pluginStatus);
                }
            }
            return pluginStatus;
        }
        return (PluginStatus) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, String str2, String str3) {
        String string;
        String string2;
        String str4;
        String str5;
        PluginStatus c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            int i = 1;
            if ("rom_size".equals(str2)) {
                str5 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e86);
                str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e83);
            } else if ("plugin_install_retry_timeout".equals(str2) || "plugin_install_timeout".equals(str2)) {
                return;
            } else {
                if (str3 != null) {
                    String lowerCase = str3.toLowerCase(Locale.getDefault());
                    if (!lowerCase.contains("no_space_left_on_device") && !lowerCase.contains("no space left on device")) {
                        if (!lowerCase.contains("read-only_file_system") && !lowerCase.contains("read-only file system")) {
                            if (!lowerCase.contains("permission_denied") && !lowerCase.contains("permission denied")) {
                                if (!lowerCase.contains("fsync_failed") && !lowerCase.contains("fsync failed")) {
                                    string = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e89);
                                    string2 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e84);
                                } else {
                                    String string3 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e89);
                                    str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e84);
                                    str5 = string3;
                                    i = 5;
                                }
                            } else {
                                str5 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e85);
                                str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e82);
                                i = 4;
                            }
                        } else {
                            str5 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e85);
                            str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e82);
                            i = 3;
                        }
                        c2 = c(str);
                        if (c2 == null) {
                            c2 = new PluginStatus();
                        }
                        c2.f23879b = PluginPackageManager.PluginStatus.ERROR;
                        c2.f23881d = str5;
                        c2.f23882e = str4;
                        c2.f23880c = i;
                        c2.f23883f = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, c2));
                    }
                    str5 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e86);
                    str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e83);
                } else {
                    string = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e89);
                    string2 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e84);
                }
                String str6 = string;
                str4 = string2;
                str5 = str6;
                c2 = c(str);
                if (c2 == null) {
                }
                c2.f23879b = PluginPackageManager.PluginStatus.ERROR;
                c2.f23881d = str5;
                c2.f23882e = str4;
                c2.f23880c = i;
                c2.f23883f = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, c2));
            }
            i = 2;
            c2 = c(str);
            if (c2 == null) {
            }
            c2.f23879b = PluginPackageManager.PluginStatus.ERROR;
            c2.f23881d = str5;
            c2.f23882e = str4;
            c2.f23880c = i;
            c2.f23883f = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, c2));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            PluginStatus c2 = b().c(str);
            if (c2 != null) {
                c2.f23879b = PluginPackageManager.PluginStatus.NROMAL;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, c2));
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            PluginStatus c2 = c(str);
            if (c2 == null) {
                c2 = new PluginStatus();
            }
            c2.f23879b = PluginPackageManager.PluginStatus.ERROR;
            c2.f23880c = 100;
            c2.f23881d = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e89);
            c2.f23882e = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e84);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, c2));
        }
    }
}
