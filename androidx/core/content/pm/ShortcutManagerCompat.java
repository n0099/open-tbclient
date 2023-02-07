package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class ShortcutManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    public static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    public static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    @VisibleForTesting
    public static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    public static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    public static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    public static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    public static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ShortcutMatchFlags {
    }

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

    @RequiresApi(25)
    /* loaded from: classes.dex */
    public static class Api25Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api25Impl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String getShortcutInfoWithLowestRank(@NonNull List<ShortcutInfo> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
                int i = -1;
                String str = null;
                for (ShortcutInfo shortcutInfo : list) {
                    if (shortcutInfo.getRank() > i) {
                        str = shortcutInfo.getId();
                        i = shortcutInfo.getRank();
                    }
                }
                return str;
            }
            return (String) invokeL.objValue;
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

    @VisibleForTesting
    public static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return sShortcutInfoChangeListeners;
        }
        return (List) invokeV.objValue;
    }

    public static boolean addDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, list)) == null) {
            if (Build.VERSION.SDK_INT <= 29) {
                convertUriIconsToBitmapIcons(context, list);
            }
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
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onShortcutAdded(list);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getShortcuts(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, context, i)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                return ShortcutInfoCompat.fromShortcuts(context, ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getShortcuts(i));
            }
            if (i2 >= 25) {
                ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
                ArrayList arrayList = new ArrayList();
                if ((i & 1) != 0) {
                    arrayList.addAll(shortcutManager.getManifestShortcuts());
                }
                if ((i & 2) != 0) {
                    arrayList.addAll(shortcutManager.getDynamicShortcuts());
                }
                if ((i & 4) != 0) {
                    arrayList.addAll(shortcutManager.getPinnedShortcuts());
                }
                return ShortcutInfoCompat.fromShortcuts(context, arrayList);
            }
            if ((i & 2) != 0) {
                try {
                    return getShortcutInfoSaverInstance(context).getShortcuts();
                } catch (Exception unused) {
                }
            }
            return Collections.emptyList();
        }
        return (List) invokeLI.objValue;
    }

    public static boolean setDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, list)) == null) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(list);
            if (Build.VERSION.SDK_INT >= 25) {
                ArrayList arrayList = new ArrayList(list.size());
                for (ShortcutInfoCompat shortcutInfoCompat : list) {
                    arrayList.add(shortcutInfoCompat.toShortcutInfo());
                }
                if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(arrayList)) {
                    return false;
                }
            }
            getShortcutInfoSaverInstance(context).removeAllShortcuts();
            getShortcutInfoSaverInstance(context).addShortcuts(list);
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onAllShortcutsRemoved();
                shortcutInfoChangeListener.onShortcutAdded(list);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean updateShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, list)) == null) {
            if (Build.VERSION.SDK_INT <= 29) {
                convertUriIconsToBitmapIcons(context, list);
            }
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
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onShortcutUpdated(list);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @VisibleForTesting
    public static boolean convertUriIconToBitmapIcon(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        InterceptResult invokeLL;
        Bitmap decodeStream;
        IconCompat createWithBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, shortcutInfoCompat)) == null) {
            IconCompat iconCompat = shortcutInfoCompat.mIcon;
            if (iconCompat == null) {
                return false;
            }
            int i = iconCompat.mType;
            if (i != 6 && i != 4) {
                return true;
            }
            InputStream uriInputStream = shortcutInfoCompat.mIcon.getUriInputStream(context);
            if (uriInputStream == null || (decodeStream = BitmapFactory.decodeStream(uriInputStream)) == null) {
                return false;
            }
            if (i == 6) {
                createWithBitmap = IconCompat.createWithAdaptiveBitmap(decodeStream);
            } else {
                createWithBitmap = IconCompat.createWithBitmap(decodeStream);
            }
            shortcutInfoCompat.mIcon = createWithBitmap;
            return true;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        InterceptResult invokeLL;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, shortcutInfoCompat)) == null) {
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

    public static void removeDynamicShortcuts(@NonNull Context context, @NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, context, list) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
            }
            getShortcutInfoSaverInstance(context).removeShortcuts(list);
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onShortcutRemoved(list);
            }
        }
    }

    public static void removeLongLivedShortcuts(@NonNull Context context, @NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, list) == null) {
            if (Build.VERSION.SDK_INT < 30) {
                removeDynamicShortcuts(context, list);
                return;
            }
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(list);
            getShortcutInfoSaverInstance(context).removeShortcuts(list);
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onShortcutRemoved(list);
            }
        }
    }

    public static void reportShortcutUsed(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, context, str) == null) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(str);
            if (Build.VERSION.SDK_INT >= 25) {
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).reportShortcutUsed(str);
            }
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onShortcutUsageReported(Collections.singletonList(str));
            }
        }
    }

    @VisibleForTesting
    public static void convertUriIconsToBitmapIcons(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, list) == null) {
            for (ShortcutInfoCompat shortcutInfoCompat : new ArrayList(list)) {
                if (!convertUriIconToBitmapIcon(context, shortcutInfoCompat)) {
                    list.remove(shortcutInfoCompat);
                }
            }
        }
    }

    public static void disableShortcuts(@NonNull Context context, @NonNull List<String> list, @Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, context, list, charSequence) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
            }
            getShortcutInfoSaverInstance(context).removeShortcuts(list);
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onShortcutRemoved(list);
            }
        }
    }

    public static void enableShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, list) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                ArrayList arrayList = new ArrayList(list.size());
                for (ShortcutInfoCompat shortcutInfoCompat : list) {
                    arrayList.add(shortcutInfoCompat.mId);
                }
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).enableShortcuts(arrayList);
            }
            getShortcutInfoSaverInstance(context).addShortcuts(list);
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onShortcutAdded(list);
            }
        }
    }

    public static int getIconDimensionInternal(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        int i;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, context, z)) == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (Build.VERSION.SDK_INT >= 19 && activityManager != null && !activityManager.isLowRamDevice()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                i = 48;
            } else {
                i = 96;
            }
            int max = Math.max(1, i);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (z) {
                f = displayMetrics.xdpi;
            } else {
                f = displayMetrics.ydpi;
            }
            return (int) (max * (f / 160.0f));
        }
        return invokeLZ.intValue;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
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

    public static int getIconMaxHeight(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            Preconditions.checkNotNull(context);
            if (Build.VERSION.SDK_INT >= 25) {
                return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxHeight();
            }
            return getIconDimensionInternal(context, false);
        }
        return invokeL.intValue;
    }

    public static int getIconMaxWidth(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            Preconditions.checkNotNull(context);
            if (Build.VERSION.SDK_INT >= 25) {
                return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxWidth();
            }
            return getIconDimensionInternal(context, true);
        }
        return invokeL.intValue;
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            Preconditions.checkNotNull(context);
            if (Build.VERSION.SDK_INT >= 25) {
                return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
            }
            return 5;
        }
        return invokeL.intValue;
    }

    @VisibleForTesting
    public static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, list) == null) {
            sShortcutInfoChangeListeners = list;
        }
    }

    @VisibleForTesting
    public static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> shortcutInfoCompatSaver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, shortcutInfoCompatSaver) == null) {
            sShortcutInfoCompatSaver = shortcutInfoCompatSaver;
        }
    }

    public static String getShortcutInfoCompatWithLowestRank(@NonNull List<ShortcutInfoCompat> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, list)) == null) {
            int i = -1;
            String str = null;
            for (ShortcutInfoCompat shortcutInfoCompat : list) {
                if (shortcutInfoCompat.getRank() > i) {
                    str = shortcutInfoCompat.getId();
                    i = shortcutInfoCompat.getRank();
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isRateLimitingActive(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            Preconditions.checkNotNull(context);
            if (Build.VERSION.SDK_INT >= 25) {
                return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
            }
            if (getShortcuts(context, 3).size() == getMaxShortcutCountPerActivity(context)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void removeAllDynamicShortcuts(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
            }
            getShortcutInfoSaverInstance(context).removeAllShortcuts();
            for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                shortcutInfoChangeListener.onAllShortcutsRemoved();
            }
        }
    }

    public static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        InterceptResult invokeL;
        Bundle bundle;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (sShortcutInfoChangeListeners == null) {
                ArrayList arrayList = new ArrayList();
                if (Build.VERSION.SDK_INT >= 21) {
                    PackageManager packageManager = context.getPackageManager();
                    Intent intent = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
                    intent.setPackage(context.getPackageName());
                    for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 128)) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString(SHORTCUT_LISTENER_META_DATA_KEY)) != null) {
                            try {
                                arrayList.add((ShortcutInfoChangeListener) Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (sShortcutInfoChangeListeners == null) {
                    sShortcutInfoChangeListeners = arrayList;
                }
            }
            return sShortcutInfoChangeListeners;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, INVOKE]}, finally: {[INVOKE, INVOKE, INVOKE, CHECK_CAST, INVOKE, INVOKE, INVOKE, INVOKE, IF, INVOKE] complete} */
    public static boolean pushDynamicShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, shortcutInfoCompat)) == null) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(shortcutInfoCompat);
            int maxShortcutCountPerActivity = getMaxShortcutCountPerActivity(context);
            if (maxShortcutCountPerActivity == 0) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 29) {
                convertUriIconToBitmapIcon(context, shortcutInfoCompat);
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).pushDynamicShortcut(shortcutInfoCompat.toShortcutInfo());
            } else if (i >= 25) {
                ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
                if (shortcutManager.isRateLimitingActive()) {
                    return false;
                }
                List<ShortcutInfo> dynamicShortcuts = shortcutManager.getDynamicShortcuts();
                if (dynamicShortcuts.size() >= maxShortcutCountPerActivity) {
                    shortcutManager.removeDynamicShortcuts(Arrays.asList(Api25Impl.getShortcutInfoWithLowestRank(dynamicShortcuts)));
                }
                shortcutManager.addDynamicShortcuts(Arrays.asList(shortcutInfoCompat.toShortcutInfo()));
            }
            ShortcutInfoCompatSaver<?> shortcutInfoSaverInstance = getShortcutInfoSaverInstance(context);
            try {
                List<ShortcutInfoCompat> shortcuts = shortcutInfoSaverInstance.getShortcuts();
                if (shortcuts.size() >= maxShortcutCountPerActivity) {
                    shortcutInfoSaverInstance.removeShortcuts(Arrays.asList(getShortcutInfoCompatWithLowestRank(shortcuts)));
                }
                shortcutInfoSaverInstance.addShortcuts(Arrays.asList(shortcutInfoCompat));
                for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
                    shortcutInfoChangeListener.onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
                }
                reportShortcutUsed(context, shortcutInfoCompat.getId());
                return true;
            } catch (Exception unused) {
                for (ShortcutInfoChangeListener shortcutInfoChangeListener2 : getShortcutInfoListeners(context)) {
                    shortcutInfoChangeListener2.onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
                }
                reportShortcutUsed(context, shortcutInfoCompat.getId());
                return false;
            } catch (Throwable th) {
                for (ShortcutInfoChangeListener shortcutInfoChangeListener3 : getShortcutInfoListeners(context)) {
                    shortcutInfoChangeListener3.onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
                }
                reportShortcutUsed(context, shortcutInfoCompat.getId());
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean requestPinShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat, @Nullable IntentSender intentSender) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, context, shortcutInfoCompat, intentSender)) == null) {
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
