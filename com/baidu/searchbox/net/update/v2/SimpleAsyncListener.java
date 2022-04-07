package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/net/update/v2/SimpleAsyncListener;", "Lcom/baidu/searchbox/net/update/v2/SimpleSyncListener;", "Landroid/content/Context;", "context", "", "module", "action", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "value", "", "executeCommand", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/net/update/v2/ActionData;)Z", "<init>", "()V", "lib-update-api_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class SimpleAsyncListener extends SimpleSyncListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SimpleAsyncListener() {
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

    @Override // com.baidu.searchbox.net.update.v2.SimpleSyncListener, com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(final Context context, final String str, final String str2, final ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, str2, actionData)) == null) {
            Runnable runnable = new Runnable(this, context, str, str2, actionData) { // from class: com.baidu.searchbox.net.update.v2.SimpleAsyncListener$executeCommand$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ String $action;
                public final /* synthetic */ Context $context;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $module;
                public final /* synthetic */ ActionData $value;
                public final /* synthetic */ SimpleAsyncListener this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, str2, actionData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$context = context;
                    this.$module = str;
                    this.$action = str2;
                    this.$value = actionData;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.$context == null || this.$module == null || this.$action == null) {
                        return;
                    }
                    synchronized (this.this$0) {
                        if (this.this$0.executeBusinessCommand(this.$context, this.$module, this.$action, this.$value)) {
                            SimpleAsyncListener simpleAsyncListener = this.this$0;
                            String str3 = this.$module;
                            String str4 = this.$action;
                            ActionData actionData2 = this.$value;
                            simpleAsyncListener.setLocationVersion(str3, str4, actionData2 != null ? actionData2.version : null);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            };
            ExecutorUtilsExt.postOnElastic(runnable, str + '_' + str2, 1);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
