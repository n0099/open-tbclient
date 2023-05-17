package com.baidu.searchbox.retrieve.debug.provider;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import java.util.ArrayList;
import java.util.List;
@DebugInfoProvider(enable = false, type = "Debug_Fetures")
/* loaded from: classes4.dex */
public class FetchDebugConfigProvider extends DebugDataGroupProvider {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String DEBUG_TITLE = "YaLog回捞上传测试";
    public static final String INTENT_START_DEBUG_ACTIVITY = "com.baidu.searchbox.retrieve.debug.provicer.DEBUG_YALOG_ACTIVITY";
    public static final String ITEM_YA_LOG_DEBUG_ACTIVITY = "进入YaLog文件上传Debug页面";
    public static final String TAG = "FetchLogProvider";
    public View.OnClickListener lcpOnlineListener = new View.OnClickListener() { // from class: com.baidu.searchbox.retrieve.debug.provider.FetchDebugConfigProvider.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            if (FetchDebugConfigProvider.DEBUG) {
                Log.d(FetchDebugConfigProvider.TAG, "switch to LCP online env");
            }
            Context context = view2.getContext();
            boolean isDebug = FetchTaskManager.getInstance().isDebug();
            FetchTaskManager.getInstance().setDebug(!isDebug);
            StringBuilder sb = new StringBuilder();
            sb.append("已切换至");
            if (isDebug) {
                str = "线上环境";
            } else {
                str = "线下环境";
            }
            sb.append(str);
            sb.append(" 重启APP生效");
            Toast.makeText(context, sb.toString(), 1).show();
        }
    };
    public View.OnClickListener mDebugActivityListener = new View.OnClickListener() { // from class: com.baidu.searchbox.retrieve.debug.provider.FetchDebugConfigProvider.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), new Intent(FetchDebugConfigProvider.INTENT_START_DEBUG_ACTIVITY));
        }
    };

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public String getGroupName() {
        return DEBUG_TITLE;
    }

    private List<DebugItemInfo> getLcpOperationInfo() {
        String str;
        ArrayList arrayList = new ArrayList();
        if (FetchTaskManager.getInstance().isDebug()) {
            str = "线下环境";
        } else {
            str = "线上环境";
        }
        arrayList.add(new TextItemInfo(null, str, this.lcpOnlineListener));
        arrayList.add(new TextItemInfo(null, ITEM_YA_LOG_DEBUG_ACTIVITY, this.mDebugActivityListener));
        return arrayList;
    }

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public List<DebugItemInfo> getChildItemList() {
        return getLcpOperationInfo();
    }
}
