package com.baidu.searchbox.live.interfaces.service;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0013J'\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService;", "Lkotlin/Any;", "", "getNickNamePortraitType", "()I", "nickNameDialogStatus", "Landroid/app/Activity;", "activity", "", "source", GroupInfoActivityConfig.REQUEST_CODE, "", "showNickNameDialog", "(Landroid/app/Activity;Ljava/lang/String;I)V", "type", "Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$INickNameGuideDialogListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showNickNameGuideDialog", "(Landroid/app/Activity;ILjava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$INickNameGuideDialogListener;)V", "(Landroid/app/Activity;ILjava/lang/String;I)V", "Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$INickNamePortraitDialogCallback;", "callBack", "showNicknamePortraitDialog", "(Landroid/app/Activity;ILcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$INickNamePortraitDialogCallback;)V", "Companion", "INickNameGuideDialogListener", "INickNamePortraitDialogCallback", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LiveNickNameService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$INickNameGuideDialogListener;", "Lkotlin/Any;", "", "var1", "", "dismissByModifySuccess", "(Z)V", "", "var2", "isShowSuccess", "(ZI)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface INickNameGuideDialogListener {
        void dismissByModifySuccess(boolean z);

        void isShowSuccess(boolean z, int i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$INickNamePortraitDialogCallback;", "Lkotlin/Any;", "", "onDialogDismiss", "()V", "", "var1", "", "var2", "onDialogShow", "(ZI)V", "onNicknameModifyResult", "(Z)V", "onPortraitModifyResult", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface INickNamePortraitDialogCallback {
        void onDialogDismiss();

        void onDialogShow(boolean z, int i);

        void onNicknameModifyResult(boolean z);

        void onPortraitModifyResult(boolean z);
    }

    int getNickNamePortraitType();

    int nickNameDialogStatus();

    void showNickNameDialog(Activity activity, String str, int i);

    void showNickNameGuideDialog(Activity activity, int i, String str, int i2);

    void showNickNameGuideDialog(Activity activity, int i, String str, INickNameGuideDialogListener iNickNameGuideDialogListener);

    void showNicknamePortraitDialog(Activity activity, int i, INickNamePortraitDialogCallback iNickNamePortraitDialogCallback);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$Companion;", "", "NICKNAME_DIALOG_TYPE_DISTRIBUTE", "I", "getNICKNAME_DIALOG_TYPE_DISTRIBUTE", "()I", "setNICKNAME_DIALOG_TYPE_DISTRIBUTE", "(I)V", "NICKNAME_DIALOG_TYPE_RECOMMEND", "getNICKNAME_DIALOG_TYPE_RECOMMEND", "setNICKNAME_DIALOG_TYPE_RECOMMEND", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static int NICKNAME_DIALOG_TYPE_DISTRIBUTE;
        public static int NICKNAME_DIALOG_TYPE_RECOMMEND;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1794427778, "Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1794427778, "Lcom/baidu/searchbox/live/interfaces/service/LiveNickNameService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_NICK_NAME);
            NICKNAME_DIALOG_TYPE_RECOMMEND = 1;
        }

        public Companion() {
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

        public final int getNICKNAME_DIALOG_TYPE_DISTRIBUTE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return NICKNAME_DIALOG_TYPE_DISTRIBUTE;
            }
            return invokeV.intValue;
        }

        public final int getNICKNAME_DIALOG_TYPE_RECOMMEND() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return NICKNAME_DIALOG_TYPE_RECOMMEND;
            }
            return invokeV.intValue;
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return SERVICE_REFERENCE;
            }
            return (ServiceReference) invokeV.objValue;
        }

        public final void setNICKNAME_DIALOG_TYPE_DISTRIBUTE(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                NICKNAME_DIALOG_TYPE_DISTRIBUTE = i;
            }
        }

        public final void setNICKNAME_DIALOG_TYPE_RECOMMEND(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                NICKNAME_DIALOG_TYPE_RECOMMEND = i;
            }
        }
    }
}
