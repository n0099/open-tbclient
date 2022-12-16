package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&¢\u0006\u0004\b\u0010\u0010\u0011J=\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/net/update/v2/SimpleSyncListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "Landroid/content/Context;", "context", "", "module", "action", "Lcom/baidu/searchbox/net/update/CommandPostData;", "postData", "", "addPostData", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/net/update/CommandPostData;)V", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "value", "", "executeBusinessCommand", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/net/update/v2/ActionData;)Z", "executeCommand", "version", "isOffline", "(Ljava/lang/String;)Z", "setLocationVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "Companion", "lib-update-api_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class SimpleSyncListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String DEFAULT_VERSION = "0";
    public static final String DEFAULT_VERSION_OFFLINE = "-1";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1771537473, "Lcom/baidu/searchbox/net/update/v2/SimpleSyncListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1771537473, "Lcom/baidu/searchbox/net/update/v2/SimpleSyncListener;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public abstract boolean executeBusinessCommand(Context context, String str, String str2, ActionData<JSONObject> actionData);

    public abstract void setLocationVersion(String str, String str2, String str3);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/net/update/v2/SimpleSyncListener$Companion;", "", "DEFAULT_VERSION", "Ljava/lang/String;", "DEFAULT_VERSION_OFFLINE", "<init>", "()V", "lib-update-api_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SimpleSyncListener() {
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

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) && commandPostData != null && commandPostData.getVersion() != null && str2 != null) {
            commandPostData.getVersion().put(str2, getLocalVersion(context, str, str2));
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2, actionData)) == null) {
            if (context != null && str != null && str2 != null) {
                synchronized (this) {
                    if (executeBusinessCommand(context, str, str2, actionData)) {
                        if (actionData != null) {
                            str3 = actionData.version;
                        } else {
                            str3 = null;
                        }
                        setLocationVersion(str, str2, str3);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean isOffline(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return Intrinsics.areEqual("-1", str);
        }
        return invokeL.booleanValue;
    }
}
