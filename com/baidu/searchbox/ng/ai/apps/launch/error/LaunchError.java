package com.baidu.searchbox.ng.ai.apps.launch.error;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import com.baidu.searchbox.ng.ai.apps.statistic.search.SearchFlowEvent;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsErrorDialog;
/* loaded from: classes2.dex */
public class LaunchError {
    private static boolean isShowing = false;

    public static void showErrorDialog(Context context, @NonNull ErrCode errCode) {
        if (context != null && !isShowing) {
            AiAppsErrorDialog.newBuilder().setTitle(R.string.aiapps_open_failed_title).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.searchbox.ng.ai.apps.launch.error.LaunchError.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = LaunchError.isShowing = false;
                }
            }).setMessage(String.format(context.getResources().getString(R.string.aiapps_open_failed_msg), AiAppsUtils.getVersionName(), AiAppsSwanCoreManager.getSwanCoreVersionString(AiAppsCoreRuntime.getInstance().getSwanCoreVersion()), String.valueOf(errCode.code()))).setPositiveButton(R.string.aiapps_open_failed_button, (DialogInterface.OnClickListener) null).show();
            isShowing = true;
            AiAppsSearchFlowUBC.addEvent(new SearchFlowEvent(SearchFlowEvent.ID_NOT_REACH, System.currentTimeMillis(), SearchFlowEvent.ERR_TYPE_SWAN_ERR, "", SearchFlowEvent.EventType.END));
        }
    }
}
