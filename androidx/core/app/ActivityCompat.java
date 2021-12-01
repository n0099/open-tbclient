package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    public static /* synthetic */ Interceptable $ic;
    public static PermissionCompatDelegate sDelegate;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity activity, @IntRange(from = 0) int i2, int i3, @Nullable Intent intent);

        boolean requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i2);
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SharedElementCallback mCallback;

        public SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sharedElementCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallback = sharedElementCallback;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, view, matrix, rectF)) == null) ? this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF) : (Parcelable) invokeLLL.objValue;
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, parcelable)) == null) ? this.mCallback.onCreateSnapshotView(context, parcelable) : (View) invokeLL.objValue;
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, map) == null) {
                this.mCallback.onMapSharedElements(list, map);
            }
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mCallback.onRejectSharedElements(list);
            }
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, list, list2, list3) == null) {
                this.mCallback.onSharedElementEnd(list, list2, list3);
            }
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, list, list2, list3) == null) {
                this.mCallback.onSharedElementStart(list, list2, list3);
            }
        }

        @Override // android.app.SharedElementCallback
        @RequiresApi(23)
        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048582, this, list, list2, onSharedElementsReadyListener) == null) {
                this.mCallback.onSharedElementsArrived(list, list2, new SharedElementCallback.OnSharedElementsReadyListener(this, onSharedElementsReadyListener) { // from class: androidx.core.app.ActivityCompat.SharedElementCallback21Impl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SharedElementCallback21Impl this$0;
                    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onSharedElementsReadyListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = onSharedElementsReadyListener;
                    }

                    @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
                    public void onSharedElementsReady() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$listener.onSharedElementsReady();
                        }
                    }
                });
            }
        }
    }

    public ActivityCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void finishAffinity(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                activity.finishAffinity();
            } else {
                activity.finish();
            }
        }
    }

    public static void finishAfterTransition(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, activity) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                activity.finishAfterTransition();
            } else {
                activity.finish();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sDelegate : (PermissionCompatDelegate) invokeV.objValue;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                return activity.getReferrer();
            }
            Intent intent = activity.getIntent();
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
            if (uri != null) {
                return uri;
            }
            String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
            if (stringExtra != null) {
                return Uri.parse(stringExtra);
            }
            return null;
        }
        return (Uri) invokeL.objValue;
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            activity.invalidateOptionsMenu();
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void postponeEnterTransition(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, activity) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        activity.postponeEnterTransition();
    }

    public static void recreate(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, activity) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                activity.recreate();
            } else if (i2 <= 23) {
                new Handler(activity.getMainLooper()).post(new Runnable(activity) { // from class: androidx.core.app.ActivityCompat.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Activity val$activity;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {activity};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$activity = activity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.val$activity.isFinishing() || ActivityRecreator.recreate(this.val$activity)) {
                            return;
                        }
                        this.val$activity.recreate();
                    }
                });
            } else if (ActivityRecreator.recreate(activity)) {
            } else {
                activity.recreate();
            }
        }
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, activity, dragEvent)) == null) ? DragAndDropPermissionsCompat.request(activity, dragEvent) : (DragAndDropPermissionsCompat) invokeLL.objValue;
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65545, null, activity, strArr, i2) == null) {
            PermissionCompatDelegate permissionCompatDelegate = sDelegate;
            if (permissionCompatDelegate == null || !permissionCompatDelegate.requestPermissions(activity, strArr, i2)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (activity instanceof RequestPermissionsRequestCodeValidator) {
                        ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i2);
                    }
                    activity.requestPermissions(strArr, i2);
                } else if (activity instanceof OnRequestPermissionsResultCallback) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(strArr, activity, i2) { // from class: androidx.core.app.ActivityCompat.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Activity val$activity;
                        public final /* synthetic */ String[] val$permissions;
                        public final /* synthetic */ int val$requestCode;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {strArr, activity, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$permissions = strArr;
                            this.val$activity = activity;
                            this.val$requestCode = i2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int[] iArr = new int[this.val$permissions.length];
                                PackageManager packageManager = this.val$activity.getPackageManager();
                                String packageName = this.val$activity.getPackageName();
                                int length = this.val$permissions.length;
                                for (int i3 = 0; i3 < length; i3++) {
                                    iArr[i3] = packageManager.checkPermission(this.val$permissions[i3], packageName);
                                }
                                ((OnRequestPermissionsResultCallback) this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, iArr);
                            }
                        }
                    });
                }
            }
        }
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity activity, @IdRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, activity, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return (T) activity.requireViewById(i2);
            }
            T t = (T) activity.findViewById(i2);
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException("ID does not reference a View inside this Activity");
        }
        return (T) invokeLI.objValue;
    }

    public static void setEnterSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, activity, sharedElementCallback) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        activity.setEnterSharedElementCallback(sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void setExitSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, activity, sharedElementCallback) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        activity.setExitSharedElementCallback(sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate permissionCompatDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, permissionCompatDelegate) == null) {
            sDelegate = permissionCompatDelegate;
        }
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, activity, str)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65551, null, activity, intent, i2, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                activity.startActivityForResult(intent, i2, bundle);
            } else {
                activity.startActivityForResult(intent, i2);
            }
        }
    }

    public static void startIntentSenderForResult(@NonNull Activity activity, @NonNull IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
            } else {
                activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
            }
        }
    }

    public static void startPostponedEnterTransition(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, activity) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        activity.startPostponedEnterTransition();
    }
}
