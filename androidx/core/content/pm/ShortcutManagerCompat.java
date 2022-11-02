package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ShortcutManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    @VisibleForTesting
    public static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    public static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1061886600, "Landroidx/core/content/pm/ShortcutManagerCompat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1061886600, "Landroidx/core/content/pm/ShortcutManagerCompat;");
        }
    }

    public ShortcutManagerCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean addDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, list)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                ArrayList arrayList = new ArrayList();
                for (ShortcutInfoCompat shortcutInfoCompat : list) {
                    arrayList.add(shortcutInfoCompat.toShortcutInfo());
                }
                if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                    return false;
                }
            }
            getShortcutInfoSaverInstance(context).addShortcuts(list);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean updateShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, list)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                ArrayList arrayList = new ArrayList();
                for (ShortcutInfoCompat shortcutInfoCompat : list) {
                    arrayList.add(shortcutInfoCompat.toShortcutInfo());
                }
                if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList)) {
                    return false;
                }
            }
            getShortcutInfoSaverInstance(context).addShortcuts(list);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        InterceptResult invokeLL;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, shortcutInfoCompat)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                intent = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo());
            } else {
                intent = null;
            }
            if (intent == null) {
                intent = new Intent();
            }
            return shortcutInfoCompat.addToIntent(intent);
        }
        return (Intent) invokeLL.objValue;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                List<ShortcutInfo> dynamicShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
                ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
                for (ShortcutInfo shortcutInfo : dynamicShortcuts) {
                    arrayList.add(new ShortcutInfoCompat.Builder(context, shortcutInfo).build());
                }
                return arrayList;
            }
            try {
                return getShortcutInfoSaverInstance(context).getShortcuts();
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        return (List) invokeL.objValue;
    }

    public static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (sShortcutInfoCompatSaver == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
                    } catch (Exception unused) {
                    }
                }
                if (sShortcutInfoCompatSaver == null) {
                    sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
                }
            }
            return sShortcutInfoCompatSaver;
        }
        return (ShortcutInfoCompatSaver) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isRequestPinShortcutSupported(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
            }
            if (ContextCompat.checkSelfPermission(context, INSTALL_SHORTCUT_PERMISSION) != 0) {
                return false;
            }
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0)) {
                String str = resolveInfo.activityInfo.permission;
                if (TextUtils.isEmpty(str) || INSTALL_SHORTCUT_PERMISSION.equals(str)) {
                    return true;
                }
                while (r4.hasNext()) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void removeAllDynamicShortcuts(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
            }
            getShortcutInfoSaverInstance(context).removeAllShortcuts();
        }
    }

    public static void removeDynamicShortcuts(@NonNull Context context, @NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, list) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
            }
            getShortcutInfoSaverInstance(context).removeShortcuts(list);
        }
    }

    public static boolean requestPinShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat, @Nullable IntentSender intentSender) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, shortcutInfoCompat, intentSender)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
            }
            if (!isRequestPinShortcutSupported(context)) {
                return false;
            }
            Intent addToIntent = shortcutInfoCompat.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
            if (intentSender == null) {
                context.sendBroadcast(addToIntent);
                return true;
            }
            context.sendOrderedBroadcast(addToIntent, null, new BroadcastReceiver(intentSender) { // from class: androidx.core.content.pm.ShortcutManagerCompat.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IntentSender val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {intentSender};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$callback = intentSender;
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) {
                        try {
                            this.val$callback.sendIntent(context2, 0, null, null, null);
                        } catch (IntentSender.SendIntentException unused) {
                        }
                    }
                }
            }, null, -1, null, null);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
