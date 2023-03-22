package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.net.update.v2.SimpleAsyncListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/net/update/v2/SimpleAsyncListener;", "Lcom/baidu/searchbox/net/update/v2/SimpleSyncListener;", "()V", "executeCommand", "", "context", "Landroid/content/Context;", "module", "", "action", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "lib-update-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SimpleAsyncListener extends SimpleSyncListener {
    /* renamed from: executeCommand$lambda-1  reason: not valid java name */
    public static final void m43executeCommand$lambda1(Context context, String str, String str2, SimpleAsyncListener this$0, ActionData actionData) {
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (context != null && str != null && str2 != null) {
            synchronized (this$0) {
                if (this$0.executeBusinessCommand(context, str, str2, actionData)) {
                    if (actionData != null) {
                        str3 = actionData.version;
                    } else {
                        str3 = null;
                    }
                    this$0.setLocationVersion(str, str2, str3);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.SimpleSyncListener, com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(final Context context, final String str, final String str2, final ActionData<JSONObject> actionData) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.cl1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SimpleAsyncListener.m43executeCommand$lambda1(context, str, str2, this, actionData);
                }
            }
        };
        ExecutorUtilsExt.postOnElastic(runnable, str + '_' + str2, 1);
        return true;
    }
}
