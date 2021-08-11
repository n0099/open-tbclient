package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ShareCallPacking {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_APP_PKG = "PKG";
    public static final String EXTRA_CALL_TYPE_SHARE = "call_type_share";
    public static final String EXTRA_FROM_APP_TPL = "extra_from_app_tpl";
    public static final String EXTRA_LOGIN_TYPE_SHARE = "login_type_share";
    public static final String EXTRA_SDK_VERSION = "SDK_VERSION";
    public static final String EXTRA_SESSION_ID = "extra_session_id";
    public static final String EXTRA_TRACE_ID = "extra_trace_id";
    public static final String EXTRA_V2_FACE_LOGIN_UIDS = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final String LOGIN_TYPE_SHARE_V1_CHOICE = "choice_share";
    public static final String LOGIN_TYPE_SHARE_V2_CHOICE = "choice_share_v2";
    public static final int REQUEST_CODE_V2_SHARE_ACCOUNT = 20001;
    public static final int SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION = 190;
    public static StatModel statModel;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static abstract class ShareLoginCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ShareLoginCallBack() {
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

        public void onFailed(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            }
        }

        public abstract void onSuccess();
    }

    /* loaded from: classes5.dex */
    public static class StatModel {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_ACCOUNT_APP = "account_app";
        public static final String KEY_ACCOUNT_TPL = "account_tpl";
        public static final String KEY_CALL_TYPE = "call_type";
        public static final String KEY_INDEX = "index";
        public static final String KEY_SHARE_VERSION = "share_version";
        public transient /* synthetic */ FieldHolder $fh;
        public String accountTpl;
        public String appName;
        public int index;
        public String shareVersion;

        public StatModel() {
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
    }

    public ShareCallPacking() {
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

    public void asyncMarkLoginState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            ThreadPoolService.getInstance().run(new TPRunnable(new Runnable(this, i2) { // from class: com.baidu.sapi2.share.ShareCallPacking.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ShareCallPacking this$0;
                public final /* synthetic */ int val$shareEvent;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
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
                    this.val$shareEvent = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.syncMarkLoginState(this.val$shareEvent);
                    }
                }
            }));
        }
    }

    public boolean checkPkgSign(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) ? ShareUtils.checkCalleeIdentity(context, str) : invokeLL.booleanValue;
    }

    public void onLoginActivityActivityResult(ShareLoginCallBack shareLoginCallBack, int i2, int i3, Intent intent, List<PassNameValuePair> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shareLoginCallBack, Integer.valueOf(i2), Integer.valueOf(i3), intent, list, str}) == null) {
            ShareUtils.onLoginActivityActivityResult(shareLoginCallBack, i2, i3, intent, this, list, str);
        }
    }

    public void startLoginShareActivityForResult(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, str, str2, str3, str4, list, str5, str6}) == null) {
            ShareUtils.startLoginShareActivityForResult(activity, str, str2, str3, str4, list, str5, str6);
        }
    }

    public void syncMarkLoginState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            new ShareStorage().syncSet(i2);
            ShareUtils.setShareStorageModel();
        }
    }
}
