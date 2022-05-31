package com.baidu.searchbox.taskmanager;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.util.AppLaunchInfoFetcher;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tblauncher.SchemaRouteActivity;
import com.baidu.tieba.yunpush.YunPushProxyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ac5;
import com.repackage.nb;
import com.repackage.nr4;
import com.repackage.uq7;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class TaskManagerLaunchFetchListener implements AppLaunchInfoFetcher.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TaskManagerLaunchFetchListener() {
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

    @Override // com.baidu.tbadk.util.AppLaunchInfoFetcher.a
    public void onFinish(ac5 ac5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ac5Var) == null) || ac5Var == null) {
            return;
        }
        Intent intent = ac5Var.b;
        boolean z = false;
        if (intent != null) {
            String action = intent.getAction();
            Set<String> categories = intent.getCategories();
            if (action != null && categories != null && TextUtils.equals(action, "android.intent.action.MAIN") && categories.contains("android.intent.category.LAUNCHER")) {
                nr4.a().b = true;
                z = true;
            }
            String className = intent.getComponent() != null ? intent.getComponent().getClassName() : "";
            if (TextUtils.equals(className, SchemaRouteActivity.class.getName())) {
                String dataString = intent.getDataString();
                if (!TextUtils.isEmpty(dataString) && dataString.contains(PbModel.UNIDISPATCH_PB)) {
                    z = uq7.a().b();
                    nr4.a().a = z;
                }
            }
            if (TextUtils.equals(className, YunPushProxyActivity.class.getName())) {
                if (Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(intent.getDataString()).find()) {
                    z = uq7.a().b();
                    nr4.a().a = z;
                }
            }
        }
        if (z) {
            return;
        }
        nb.b().d();
    }
}
