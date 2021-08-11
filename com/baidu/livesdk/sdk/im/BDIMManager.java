package com.baidu.livesdk.sdk.im;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.im.ConnectListener;
import com.baidu.livesdk.api.im.FetchMsgByIdListener;
import com.baidu.livesdk.api.im.IMConnectParams;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.IMManager;
import com.baidu.livesdk.api.im.LoginListener;
import com.baidu.livesdk.api.im.LogoutListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BDIMManager implements IMManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public BDIMManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public IMConversation build(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) ? new BDIMConversation(context, BIMManager.getConversation(this.mContext, str, z, BIMManager.CATEGORY.STUDIO, str2, 2)) : (IMConversation) invokeCommon.objValue;
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void fetchMsgByMsgId(Context context, int i2, long j2, long j3, long j4, int i3, int i4, FetchMsgByIdListener fetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3), Integer.valueOf(i4), fetchMsgByIdListener}) == null) {
            BIMManager.fetchMsgByMsgid(context, i2, j2, j3, j4, i3, i4, new IFetchMsgByIdListener(this, fetchMsgByIdListener) { // from class: com.baidu.livesdk.sdk.im.BDIMManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMManager this$0;
                public final /* synthetic */ FetchMsgByIdListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fetchMsgByIdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = fetchMsgByIdListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
                public void onFetchMsgByIdResult(int i5, String str, String str2, int i6, long j5, long j6, long j7, int i7, int i8, long j8, ArrayList<ChatMsg> arrayList) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i5), str, str2, Integer.valueOf(i6), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Integer.valueOf(i7), Integer.valueOf(i8), Long.valueOf(j8), arrayList}) == null) || this.val$listener == null) {
                        return;
                    }
                    ArrayList<Object> arrayList2 = new ArrayList<>();
                    arrayList2.addAll(arrayList);
                    this.val$listener.onFetchMsgByIdResult(i5, str, str2, i6, j5, j6, j7, i7, i8, j8, arrayList2);
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void fetchMsgRequest(Context context, long j2, long j3, int i2, long j4, long j5, long j6, int i3, int i4, FetchMsgByIdListener fetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i3), Integer.valueOf(i4), fetchMsgByIdListener}) == null) {
            BIMManager.fetchMsgRequest(context, j2, j3, i2, j4, j5, j6, i3, i4, new IFetchMsgByIdListener(this, fetchMsgByIdListener) { // from class: com.baidu.livesdk.sdk.im.BDIMManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMManager this$0;
                public final /* synthetic */ FetchMsgByIdListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fetchMsgByIdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = fetchMsgByIdListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
                public void onFetchMsgByIdResult(int i5, String str, String str2, int i6, long j7, long j8, long j9, int i7, int i8, long j10, ArrayList<ChatMsg> arrayList) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i5), str, str2, Integer.valueOf(i6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Integer.valueOf(i7), Integer.valueOf(i8), Long.valueOf(j10), arrayList}) == null) || this.val$listener == null) {
                        return;
                    }
                    ArrayList<Object> arrayList2 = new ArrayList<>();
                    arrayList2.addAll(arrayList);
                    this.val$listener.onFetchMsgByIdResult(i5, str, str2, i6, j7, j8, j9, i7, i8, j10, arrayList2);
                }
            });
        }
    }

    public void init(long j2, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str}) == null) {
            BIMManager.init(this.mContext, j2, i2, str);
        }
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void login(String str, String str2, int i2, String str3, String str4, LoginListener loginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, loginListener}) == null) {
            BIMManager.login(str, str2, i2, str3, str4, new ILoginListener(this, loginListener) { // from class: com.baidu.livesdk.sdk.im.BDIMManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMManager this$0;
                public final /* synthetic */ LoginListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, loginListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = loginListener;
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLoginResult(int i3, String str5) {
                    LoginListener loginListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str5) == null) || (loginListener2 = this.val$listener) == null) {
                        return;
                    }
                    loginListener2.onLoginResult(i3, str5);
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLogoutResult(int i3, String str5, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), str5, Integer.valueOf(i4)}) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void logout(LogoutListener logoutListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, logoutListener) == null) {
            BIMManager.logout(new ILoginListener(this, logoutListener) { // from class: com.baidu.livesdk.sdk.im.BDIMManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMManager this$0;
                public final /* synthetic */ LogoutListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, logoutListener};
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
                    this.val$listener = logoutListener;
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLoginResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    }
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLogoutResult(int i2, String str, int i3) {
                    LogoutListener logoutListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) || (logoutListener2 = this.val$listener) == null) {
                        return;
                    }
                    logoutListener2.onLogoutResult(i2, str, i3);
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void produceLine(IMConnectParams iMConnectParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iMConnectParams) == null) {
            BIMManager.setProductLine(this.mContext, iMConnectParams.getPl(), iMConnectParams.getVersionName());
        }
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void registerConnectListener(ConnectListener connectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, connectListener) == null) {
            BIMManager.registerConnectListener(new IConnectListener(this, connectListener) { // from class: com.baidu.livesdk.sdk.im.BDIMManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMManager this$0;
                public final /* synthetic */ ConnectListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, connectListener};
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
                    this.val$listener = connectListener;
                }

                @Override // com.baidu.android.imsdk.account.IConnectListener
                public void onResult(int i2) {
                    ConnectListener connectListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || (connectListener2 = this.val$listener) == null) {
                        return;
                    }
                    connectListener2.onResult(i2);
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void tryConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BIMManager.tryConnection(this.mContext);
        }
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void unregisterConnectListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            BIMManager.unregisterConnectListener();
        }
    }
}
