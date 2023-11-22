package com.baidu.searchbox.taskmanager;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.tbadk.util.AppLaunchInfoFetcher;
import com.baidu.tieba.j35;
import com.baidu.tieba.nt5;
import com.baidu.tieba.ou9;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tblauncher.SchemaRouteActivity;
import com.baidu.tieba.yunpush.YunPushProxyActivity;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class TaskManagerLaunchFetchListener implements AppLaunchInfoFetcher.a {
    @Override // com.baidu.tbadk.util.AppLaunchInfoFetcher.a
    public void onFinish(nt5 nt5Var) {
        String str;
        if (nt5Var == null) {
            return;
        }
        Intent intent = nt5Var.b;
        boolean z = false;
        if (intent != null) {
            String action = intent.getAction();
            Set<String> categories = intent.getCategories();
            if (action != null && categories != null && TextUtils.equals(action, "android.intent.action.MAIN") && categories.contains("android.intent.category.LAUNCHER")) {
                j35.a().b = true;
                z = true;
            }
            if (intent.getComponent() != null) {
                str = intent.getComponent().getClassName();
            } else {
                str = "";
            }
            if (TextUtils.equals(str, SchemaRouteActivity.class.getName())) {
                String dataString = intent.getDataString();
                if (!TextUtils.isEmpty(dataString) && dataString.contains(PbModel.UNIDISPATCH_PB)) {
                    z = ou9.a().b();
                    j35.a().a = z;
                }
            }
            if (TextUtils.equals(str, YunPushProxyActivity.class.getName())) {
                if (Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(intent.getDataString()).find()) {
                    z = ou9.a().b();
                    j35.a().a = z;
                }
            }
        }
        if (!z) {
            IdleHandlerManager.getInstance().runIdleTaskImmediately();
        }
    }
}
