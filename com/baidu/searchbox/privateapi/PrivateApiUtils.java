package com.baidu.searchbox.privateapi;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class PrivateApiUtils implements NoProGuard {
    public static final String SDK_VERSION_NAME = "REL";
    public static final int SDK_VERSION_P = 28;
    public static final String SO_FILE_NAME = "libprivate-p-master.so";

    public static void usePrivateApi() {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        String str = Build.VERSION.CODENAME;
        if (i == 28 && !TextUtils.isEmpty(str) && SDK_VERSION_NAME.equals(str)) {
            SoLoader.load(AppRuntime.getAppContext(), SO_FILE_NAME);
        }
    }

    public static String getMiuiChannel(String str) {
        try {
            return (String) Class.forName("miui.os.MiuiInit").getMethod("getMiuiChannelPath", String.class).invoke(null, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSystemProtertiesMethod(String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Method declaredMethod = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class);
        declaredMethod.setAccessible(true);
        return (String) declaredMethod.invoke(null, str);
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
