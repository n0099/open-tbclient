package com.baidu.searchbox.download.apkcheck;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.apkcheck.ApkCheckerKt;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.ExternalStorageCallBack;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aM\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\u0007\u001a\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u000b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019H\u0002\u001a5\u0010\u001a\u001a\u00020\u000b2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\tH\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001aI\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"CHECKING_TOAST_DURATION_SECONDS", "", "CHECKING_TOAST_ROTATE_DURATION", "", "CHECKING_TOAST_ROTATE_PROPERTY", "", "CHECKING_TOAST_ROTATE_VALUE_END", "CHECKING_TOAST_ROTATE_VALUE_START", "isChecking", "", "checkApk", "", "activity", "Landroid/app/Activity;", "data", "Lcom/baidu/searchbox/download/model/CategoryInfoData;", "showCheckToast", "successCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "canInstall", "needDirectInstall", "onCheckFailed", "failedCallback", "Lkotlin/Function0;", "onCheckSuccess", "reqPermissionAndDelete", "showCheckingToast", "showRiskDialog", "startCheckApk", "lib-download_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApkCheckerKt {
    public static final int CHECKING_TOAST_DURATION_SECONDS = 30;
    public static final long CHECKING_TOAST_ROTATE_DURATION = 1000;
    public static final String CHECKING_TOAST_ROTATE_PROPERTY = "level";
    public static final int CHECKING_TOAST_ROTATE_VALUE_END = 10000;
    public static final int CHECKING_TOAST_ROTATE_VALUE_START = 0;
    public static boolean isChecking;

    /* renamed from: showRiskDialog$lambda-3  reason: not valid java name */
    public static final void m76showRiskDialog$lambda3(DialogInterface dialogInterface) {
    }

    public static final void onCheckSuccess(Function1<? super Boolean, Unit> function1, boolean z) {
        isChecking = false;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    /* renamed from: reqPermissionAndDelete$lambda-6  reason: not valid java name */
    public static final void m74reqPermissionAndDelete$lambda6(final CategoryInfoData data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "$data");
        if (z) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.tieba.ni1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        ApkCheckerKt.m75reqPermissionAndDelete$lambda6$lambda5(CategoryInfoData.this);
                    }
                }
            }, "reqPermissionAndDelete", 2);
        }
    }

    public static final boolean needDirectInstall(CategoryInfoData categoryInfoData) {
        if (!NetWorkUtils.isNetworkConnected()) {
            return true;
        }
        try {
            return true ^ new JSONObject(categoryInfoData.mExtraInfo).optBoolean(Downloads.Impl.COLUMN_NEED_CHECK_APK);
        } catch (Exception unused) {
            return true;
        }
    }

    public static final void onCheckFailed(Function0<Unit> function0) {
        isChecking = false;
        UniversalToast.makeText(AppRuntime.getAppContext()).setText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f05c3)).show();
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void reqPermissionAndDelete(final CategoryInfoData categoryInfoData) {
        DownloadHelper.checkExternalStorage(new File(categoryInfoData.mDownloadPath).getAbsolutePath(), true, new ExternalStorageCallBack() { // from class: com.baidu.tieba.fi1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
            public final void onResult(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    ApkCheckerKt.m74reqPermissionAndDelete$lambda6(CategoryInfoData.this, z);
                }
            }
        }, true);
    }

    /* renamed from: reqPermissionAndDelete$lambda-6$lambda-5  reason: not valid java name */
    public static final void m75reqPermissionAndDelete$lambda6$lambda5(CategoryInfoData data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        DownloadManagerExt.getInstance().deleteDownload(true, data.mId);
    }

    public static final void checkApk(final Activity activity, final CategoryInfoData categoryInfoData, final boolean z, final Function1<? super Boolean, Unit> function1) {
        if (activity == null || categoryInfoData == null || isChecking) {
            return;
        }
        isChecking = true;
        if (needDirectInstall(categoryInfoData)) {
            onCheckSuccess(function1, true);
        } else {
            DownloadHelper.checkExternalStorage(new File(categoryInfoData.mDownloadPath).getAbsolutePath(), true, new ExternalStorageCallBack() { // from class: com.baidu.tieba.ki1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
                public final void onResult(boolean z2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) {
                        ApkCheckerKt.m73checkApk$lambda0(activity, categoryInfoData, z, function1, z2);
                    }
                }
            }, true);
        }
    }

    public static final void startCheckApk(final Activity activity, final CategoryInfoData categoryInfoData, boolean z, final Function1<? super Boolean, Unit> function1) {
        final Function0<Unit> function0;
        if (z) {
            function0 = showCheckingToast(activity);
        } else {
            function0 = null;
        }
        FkApkInfoSearchRequestKt.checkApkStatus(categoryInfoData, new Function1<Boolean, Unit>() { // from class: com.baidu.searchbox.download.apkcheck.ApkCheckerKt$startCheckApk$1
            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2) {
                Function0<Unit> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                if (z2) {
                    ApkCheckerKt.showRiskDialog(activity, categoryInfoData);
                    return;
                }
                ApkCheckerKt.onCheckSuccess(function1, true);
                ApkCheckUBCManagerKt.apkCheckInstallEvent();
            }
        });
        ApkCheckUBCManagerKt.startApkCheckEvent();
    }

    public static /* synthetic */ void checkApk$default(Activity activity, CategoryInfoData categoryInfoData, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        checkApk(activity, categoryInfoData, z, function1);
    }

    public static /* synthetic */ void startCheckApk$default(Activity activity, CategoryInfoData categoryInfoData, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        startCheckApk(activity, categoryInfoData, z, function1);
    }

    /* renamed from: checkApk$lambda-0  reason: not valid java name */
    public static final void m73checkApk$lambda0(Activity activity, CategoryInfoData categoryInfoData, boolean z, Function1 function1, boolean z2) {
        if (z2) {
            startCheckApk(activity, categoryInfoData, z, function1);
        }
    }

    public static final Function0<Unit> showCheckingToast(Activity activity) {
        Drawable drawable = activity.getDrawable(R.drawable.obfuscated_res_0x7f080fc2);
        if (drawable != null) {
            RotateDrawable rotateDrawable = (RotateDrawable) drawable;
            final ObjectAnimator ofInt = ObjectAnimator.ofInt(rotateDrawable, "level", 0, 10000);
            ofInt.setDuration(1000L);
            ofInt.setRepeatCount(-1);
            ofInt.setRepeatMode(1);
            final UniversalToast makeText = UniversalToast.makeText(activity);
            makeText.setDuration(30);
            makeText.setLeftIcon(rotateDrawable);
            makeText.setTemplate(ToastTemplate.T2);
            makeText.setText(activity.getString(R.string.obfuscated_res_0x7f0f05d0));
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.baidu.searchbox.download.apkcheck.ApkCheckerKt$showCheckingToast$cancelAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UniversalToast.this.mutexDismiss();
                    ofInt.cancel();
                }
            };
            ofInt.start();
            makeText.show();
            return function0;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
    }

    public static final void showRiskDialog(final Activity activity, final CategoryInfoData categoryInfoData) {
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            BdAlertDialog.Builder message = new BdAlertDialog.Builder(activity).setTitle(R.string.obfuscated_res_0x7f0f05c6).setMessage(R.string.obfuscated_res_0x7f0f05c4);
            String string = activity.getString(R.string.obfuscated_res_0x7f0f0e89);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.no)");
            BdAlertDialog.Builder button = message.setButton(new BdAlertDialog.ButtonItem(string, new BdAlertDialog.OnItemClickListener() { // from class: com.baidu.searchbox.download.apkcheck.ApkCheckerKt$showRiskDialog$1
                @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
                public void onItemClick(View view2) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    ApkCheckUBCManagerKt.apkCheckCloseDialogEvent();
                }
            }));
            String string2 = activity.getString(R.string.obfuscated_res_0x7f0f05c5);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…ad_apk_check_risk_delete)");
            button.setButton(new BdAlertDialog.ButtonItem(string2, (int) R.color.obfuscated_res_0x7f0601f1, new BdAlertDialog.OnItemClickListener() { // from class: com.baidu.searchbox.download.apkcheck.ApkCheckerKt$showRiskDialog$2
                @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
                public void onItemClick(View view2) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Activity activity2 = activity;
                    if (!(activity2 instanceof IDeleteUnSafeApk)) {
                        ApkCheckerKt.reqPermissionAndDelete(categoryInfoData);
                    } else {
                        ((IDeleteUnSafeApk) activity2).delUnSafeApk(categoryInfoData);
                    }
                    UniversalToast.makeText(AppRuntime.getAppContext()).setText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f05c2)).show();
                    ApkCheckUBCManagerKt.apkCheckDelEvent();
                }
            })).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.mi1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                        ApkCheckerKt.m76showRiskDialog$lambda3(dialogInterface);
                    }
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pi1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                        ApkCheckerKt.isChecking = false;
                    }
                }
            }).create().show();
            ApkCheckUBCManagerKt.apkCheckDialogShowEvent();
            return;
        }
        isChecking = false;
    }
}
