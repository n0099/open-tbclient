package com.baidu.searchbox.download.center.clearcache;

import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.retrieve.log.bean.FetchLogBean;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class DiskFetchLogJob extends IFetchJob {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static String DISK_CMD = "baiduboxapp_write_disk_tree_file_cmd";
    public static String DISK_MARK_CMD = "baiduboxapp_write_disk_tree_mark_cmd";
    public static String DISK_UNMARK_CMD = "baiduboxapp_write_disk_tree_unmark_cmd";
    public static final String TAG = "DiskFetchLogJob";

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        return "flow";
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        FetchLogBean parseJsonContent = FetchLog.parseJsonContent(jSONObject);
        if (parseJsonContent == null) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "data " + jSONObject);
        }
        if (parseJsonContent.getSpace() != null) {
            if (parseJsonContent.getSpace().contains(DISK_MARK_CMD)) {
                DiskManager.INSTANCE.setMark(true);
            }
            if (parseJsonContent.getSpace().contains(DISK_UNMARK_CMD)) {
                DiskManager.INSTANCE.setMark(false);
            }
            if (parseJsonContent.getSpace().contains(DISK_CMD)) {
                ClearCacheUbcController.reportBaiduFile(ClearCacheUbcController.REPORT_FILE_TYPE_FISHING_BACK);
            }
        }
    }
}
