package com.baidu.spswitch.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.vip.IVipUserInfoManager;
import com.baidu.searchbox.vip.VipUserInfoChangedEvent;
import com.baidu.searchbox.vip.models.VipUserInfoKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* loaded from: classes4.dex */
public class EmotionVipHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOGIN_SOURCE = "hudong_huiyuanemoji";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface OnBuyVipListener {
        void onResult(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface OnVipCheckListener {
        void onResult(boolean z);
    }

    public EmotionVipHelper() {
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

    public static boolean hasDuVip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            IVipUserInfoManager iVipUserInfoManager = (IVipUserInfoManager) ServiceManager.getService(IVipUserInfoManager.Companion.getSERVICE_REFERENCE());
            if (iVipUserInfoManager == null) {
                return false;
            }
            return iVipUserInfoManager.getHasDuVip();
        }
        return invokeV.booleanValue;
    }

    public static boolean hasSpokesManVip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            IVipUserInfoManager iVipUserInfoManager = (IVipUserInfoManager) ServiceManager.getService(IVipUserInfoManager.Companion.getSERVICE_REFERENCE());
            if (iVipUserInfoManager == null) {
                return false;
            }
            return iVipUserInfoManager.getHasVipUnionType(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN);
        }
        return invokeV.booleanValue;
    }

    public static boolean getLoginState(BoxAccountManager boxAccountManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, boxAccountManager)) == null) {
            if (boxAccountManager == null) {
                boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            }
            return boxAccountManager.isLogin(2);
        }
        return invokeL.booleanValue;
    }

    public static Object listenVipStatusIfNeed(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, runnable)) == null) {
            Object obj = new Object();
            BdEventBus.Companion.getDefault().register(obj, VipUserInfoChangedEvent.class, 1, new Action<VipUserInfoChangedEvent>(obj, runnable) { // from class: com.baidu.spswitch.utils.EmotionVipHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object val$obj;
                public final /* synthetic */ Runnable val$r;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {obj, runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$obj = obj;
                    this.val$r = runnable;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.bdeventbus.Action
                public void call(VipUserInfoChangedEvent vipUserInfoChangedEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, vipUserInfoChangedEvent) == null) {
                        BdEventBus.Companion.getDefault().unregister(this.val$obj);
                        this.val$r.run();
                    }
                }
            });
            return obj;
        }
        return invokeL.objValue;
    }

    public static void doBuyVip(@Nullable Context context, @Nullable String str, @Nullable String str2, @NonNull OnBuyVipListener onBuyVipListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, context, str, str2, onBuyVipListener) == null) {
            IVipUserInfoManager iVipUserInfoManager = (IVipUserInfoManager) ServiceManager.getService(IVipUserInfoManager.Companion.getSERVICE_REFERENCE());
            if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && iVipUserInfoManager != null) {
                iVipUserInfoManager.requestCommonBuyVip(context, str2, new Function1<String, Unit>(str, onBuyVipListener) { // from class: com.baidu.spswitch.utils.EmotionVipHelper.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$auth;
                    public final /* synthetic */ OnBuyVipListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, onBuyVipListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$auth = str;
                        this.val$listener = onBuyVipListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(String str3) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3)) == null) {
                            if (TextUtils.equals(this.val$auth, "3") && TextUtils.equals(str3, String.valueOf(4))) {
                                this.val$listener.onResult(true);
                                return null;
                            } else if (TextUtils.equals(this.val$auth, "2") && (TextUtils.equals(str3, String.valueOf(1)) || TextUtils.equals(str3, String.valueOf(4)))) {
                                this.val$listener.onResult(true);
                                return null;
                            } else {
                                this.val$listener.onResult(false);
                                return null;
                            }
                        }
                        return (Unit) invokeL.objValue;
                    }
                }, new Function2<String, Integer, Unit>(onBuyVipListener) { // from class: com.baidu.spswitch.utils.EmotionVipHelper.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OnBuyVipListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {onBuyVipListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = onBuyVipListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function2
                    public Unit invoke(String str3, Integer num) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, num)) == null) {
                            this.val$listener.onResult(false);
                            return null;
                        }
                        return (Unit) invokeLL.objValue;
                    }
                });
            } else {
                onBuyVipListener.onResult(false);
            }
        }
    }

    public static void doCheckVip(Context context, String str, @NonNull OnVipCheckListener onVipCheckListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, onVipCheckListener) == null) {
            if (TextUtils.equals(str, "1")) {
                onVipCheckListener.onResult(true);
                return;
            }
            BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            if (boxAccountManager == null) {
                return;
            }
            if (getLoginState(boxAccountManager)) {
                onVipCheckListener.onResult(hasDuOrSpokesmanVip(str));
                return;
            }
            boxAccountManager.showLoginComponentDialog(context, AccountComponentConfig.getDefaulgParamsBuilder().setLoginSrc(LOGIN_SOURCE).setSupportGuest(true).build(), new ILoginResultListener(listenVipStatusIfNeed(new Runnable(boxAccountManager, onVipCheckListener, str) { // from class: com.baidu.spswitch.utils.EmotionVipHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BoxAccountManager val$accountManager;
                public final /* synthetic */ String val$auth;
                public final /* synthetic */ OnVipCheckListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {boxAccountManager, onVipCheckListener, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$accountManager = boxAccountManager;
                    this.val$listener = onVipCheckListener;
                    this.val$auth = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    OnVipCheckListener onVipCheckListener2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && EmotionVipHelper.getLoginState(this.val$accountManager) && (onVipCheckListener2 = this.val$listener) != null) {
                        onVipCheckListener2.onResult(EmotionVipHelper.hasDuOrSpokesmanVip(this.val$auth));
                    }
                }
            })) { // from class: com.baidu.spswitch.utils.EmotionVipHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object val$obj;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$obj = r6;
                }

                @Override // com.baidu.searchbox.account.ILoginResultListener
                public void onResult(int i) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) && this.val$obj != null && i != 0) {
                        BdEventBus.Companion.getDefault().unregister(this.val$obj);
                    }
                }
            });
        }
    }

    public static boolean hasDuOrSpokesmanVip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.equals(str, "3")) {
                return hasSpokesManVip();
            }
            if (!TextUtils.equals(str, "2")) {
                return false;
            }
            if (!hasDuVip() && !hasSpokesManVip()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
