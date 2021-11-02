package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
@RequiresApi(16)
/* loaded from: classes.dex */
public class NotificationCompatJellybean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    public static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    public static final String KEY_ACTION_INTENT = "actionIntent";
    public static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    public static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    public static final String KEY_CHOICES = "choices";
    public static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    public static final String KEY_EXTRAS = "extras";
    public static final String KEY_ICON = "icon";
    public static final String KEY_LABEL = "label";
    public static final String KEY_REMOTE_INPUTS = "remoteInputs";
    public static final String KEY_RESULT_KEY = "resultKey";
    public static final String KEY_SEMANTIC_ACTION = "semanticAction";
    public static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    public static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    public static Field sActionIconField;
    public static Field sActionIntentField;
    public static Field sActionTitleField;
    public static boolean sActionsAccessFailed;
    public static Field sActionsField;
    public static final Object sActionsLock;
    public static Field sExtrasField;
    public static boolean sExtrasFieldAccessFailed;
    public static final Object sExtrasLock;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1795690242, "Landroidx/core/app/NotificationCompatJellybean;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1795690242, "Landroidx/core/app/NotificationCompatJellybean;");
                return;
            }
        }
        sExtrasLock = new Object();
        sActionsLock = new Object();
    }

    public NotificationCompatJellybean() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            int size = list.size();
            SparseArray<Bundle> sparseArray = null;
            for (int i2 = 0; i2 < size; i2++) {
                Bundle bundle = list.get(i2);
                if (bundle != null) {
                    if (sparseArray == null) {
                        sparseArray = new SparseArray<>();
                    }
                    sparseArray.put(i2, bundle);
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static boolean ensureActionReflectionReadyLocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sActionsAccessFailed) {
                return false;
            }
            try {
                if (sActionsField == null) {
                    Class<?> cls = Class.forName("android.app.Notification$Action");
                    sActionIconField = cls.getDeclaredField("icon");
                    sActionTitleField = cls.getDeclaredField("title");
                    sActionIntentField = cls.getDeclaredField(KEY_ACTION_INTENT);
                    Field declaredField = Notification.class.getDeclaredField(NotificationCompat.WearableExtender.KEY_ACTIONS);
                    sActionsField = declaredField;
                    declaredField.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                sActionsAccessFailed = true;
            } catch (NoSuchFieldException unused2) {
                sActionsAccessFailed = true;
            }
            return true ^ sActionsAccessFailed;
        }
        return invokeV.booleanValue;
    }

    public static RemoteInput fromBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
            HashSet hashSet = new HashSet();
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next());
                }
            }
            return new RemoteInput(bundle.getString(KEY_RESULT_KEY), bundle.getCharSequence("label"), bundle.getCharSequenceArray(KEY_CHOICES), bundle.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), 0, bundle.getBundle("extras"), hashSet);
        }
        return (RemoteInput) invokeL.objValue;
    }

    public static RemoteInput[] fromBundleArray(Bundle[] bundleArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bundleArr)) == null) {
            if (bundleArr == null) {
                return null;
            }
            RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
            for (int i2 = 0; i2 < bundleArr.length; i2++) {
                remoteInputArr[i2] = fromBundle(bundleArr[i2]);
            }
            return remoteInputArr;
        }
        return (RemoteInput[]) invokeL.objValue;
    }

    public static NotificationCompat.Action getAction(Notification notification, int i2) {
        InterceptResult invokeLI;
        SparseArray sparseParcelableArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, notification, i2)) == null) {
            synchronized (sActionsLock) {
                try {
                    try {
                        Object[] actionObjectsLocked = getActionObjectsLocked(notification);
                        if (actionObjectsLocked != null) {
                            Object obj = actionObjectsLocked[i2];
                            Bundle extras = getExtras(notification);
                            return readAction(sActionIconField.getInt(obj), (CharSequence) sActionTitleField.get(obj), (PendingIntent) sActionIntentField.get(obj), (extras == null || (sparseParcelableArray = extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS)) == null) ? null : (Bundle) sparseParcelableArray.get(i2));
                        }
                    } catch (IllegalAccessException unused) {
                        sActionsAccessFailed = true;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (NotificationCompat.Action) invokeLI.objValue;
    }

    public static int getActionCount(Notification notification) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, notification)) == null) {
            synchronized (sActionsLock) {
                Object[] actionObjectsLocked = getActionObjectsLocked(notification);
                length = actionObjectsLocked != null ? actionObjectsLocked.length : 0;
            }
            return length;
        }
        return invokeL.intValue;
    }

    public static NotificationCompat.Action getActionFromBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bundle)) == null) {
            Bundle bundle2 = bundle.getBundle("extras");
            return new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable(KEY_ACTION_INTENT), bundle.getBundle("extras"), fromBundleArray(getBundleArrayFromBundle(bundle, KEY_REMOTE_INPUTS)), fromBundleArray(getBundleArrayFromBundle(bundle, KEY_DATA_ONLY_REMOTE_INPUTS)), bundle2 != null ? bundle2.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false) : false, bundle.getInt(KEY_SEMANTIC_ACTION), bundle.getBoolean(KEY_SHOWS_USER_INTERFACE), false);
        }
        return (NotificationCompat.Action) invokeL.objValue;
    }

    public static Object[] getActionObjectsLocked(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, notification)) == null) {
            synchronized (sActionsLock) {
                if (ensureActionReflectionReadyLocked()) {
                    try {
                        return (Object[]) sActionsField.get(notification);
                    } catch (IllegalAccessException unused) {
                        sActionsAccessFailed = true;
                        return null;
                    }
                }
                return null;
            }
        }
        return (Object[]) invokeL.objValue;
    }

    public static Bundle[] getBundleArrayFromBundle(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, bundle, str)) == null) {
            Parcelable[] parcelableArray = bundle.getParcelableArray(str);
            if (!(parcelableArray instanceof Bundle[]) && parcelableArray != null) {
                Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
                bundle.putParcelableArray(str, bundleArr);
                return bundleArr;
            }
            return (Bundle[]) parcelableArray;
        }
        return (Bundle[]) invokeLL.objValue;
    }

    public static Bundle getBundleForAction(NotificationCompat.Action action) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, action)) == null) {
            Bundle bundle2 = new Bundle();
            IconCompat iconCompat = action.getIconCompat();
            bundle2.putInt("icon", iconCompat != null ? iconCompat.getResId() : 0);
            bundle2.putCharSequence("title", action.getTitle());
            bundle2.putParcelable(KEY_ACTION_INTENT, action.getActionIntent());
            if (action.getExtras() != null) {
                bundle = new Bundle(action.getExtras());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
            bundle2.putBundle("extras", bundle);
            bundle2.putParcelableArray(KEY_REMOTE_INPUTS, toBundleArray(action.getRemoteInputs()));
            bundle2.putBoolean(KEY_SHOWS_USER_INTERFACE, action.getShowsUserInterface());
            bundle2.putInt(KEY_SEMANTIC_ACTION, action.getSemanticAction());
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle getExtras(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, notification)) == null) {
            synchronized (sExtrasLock) {
                if (sExtrasFieldAccessFailed) {
                    return null;
                }
                try {
                    if (sExtrasField == null) {
                        Field declaredField = Notification.class.getDeclaredField("extras");
                        if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                            sExtrasFieldAccessFailed = true;
                            return null;
                        }
                        declaredField.setAccessible(true);
                        sExtrasField = declaredField;
                    }
                    Bundle bundle = (Bundle) sExtrasField.get(notification);
                    if (bundle == null) {
                        bundle = new Bundle();
                        sExtrasField.set(notification, bundle);
                    }
                    return bundle;
                } catch (IllegalAccessException | NoSuchFieldException unused) {
                    sExtrasFieldAccessFailed = true;
                    return null;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static NotificationCompat.Action readAction(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        InterceptResult invokeCommon;
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), charSequence, pendingIntent, bundle})) == null) {
            if (bundle != null) {
                remoteInputArr = fromBundleArray(getBundleArrayFromBundle(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
                remoteInputArr2 = fromBundleArray(getBundleArrayFromBundle(bundle, EXTRA_DATA_ONLY_REMOTE_INPUTS));
                z = bundle.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
            } else {
                remoteInputArr = null;
                remoteInputArr2 = null;
                z = false;
            }
            return new NotificationCompat.Action(i2, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, 0, true, false);
        }
        return (NotificationCompat.Action) invokeCommon.objValue;
    }

    public static Bundle toBundle(RemoteInput remoteInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, remoteInput)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_RESULT_KEY, remoteInput.getResultKey());
            bundle.putCharSequence("label", remoteInput.getLabel());
            bundle.putCharSequenceArray(KEY_CHOICES, remoteInput.getChoices());
            bundle.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, remoteInput.getAllowFreeFormInput());
            bundle.putBundle("extras", remoteInput.getExtras());
            Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
            if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>(allowedDataTypes.size());
                for (String str : allowedDataTypes) {
                    arrayList.add(str);
                }
                bundle.putStringArrayList(KEY_ALLOWED_DATA_TYPES, arrayList);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle[] toBundleArray(RemoteInput[] remoteInputArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, remoteInputArr)) == null) {
            if (remoteInputArr == null) {
                return null;
            }
            Bundle[] bundleArr = new Bundle[remoteInputArr.length];
            for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
                bundleArr[i2] = toBundle(remoteInputArr[i2]);
            }
            return bundleArr;
        }
        return (Bundle[]) invokeL.objValue;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompat.Action action) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, builder, action)) == null) {
            IconCompat iconCompat = action.getIconCompat();
            builder.addAction(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
            Bundle bundle = new Bundle(action.getExtras());
            if (action.getRemoteInputs() != null) {
                bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, toBundleArray(action.getRemoteInputs()));
            }
            if (action.getDataOnlyRemoteInputs() != null) {
                bundle.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, toBundleArray(action.getDataOnlyRemoteInputs()));
            }
            bundle.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
            return bundle;
        }
        return (Bundle) invokeLL.objValue;
    }
}
