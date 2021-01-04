package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RetrieveReportImpl implements IRetrieveReportTask {
    private static final String TAG = "RetrieveReportImpl";
    private static volatile RetrieveReportImpl instance;
    private Context mContext;

    public static RetrieveReportImpl getInstance(Context context) {
        if (instance == null) {
            synchronized (RetrieveReportImpl.class) {
                if (instance == null) {
                    instance = new RetrieveReportImpl(context);
                }
            }
        }
        return instance;
    }

    private RetrieveReportImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveReportTask
    public void reportDispatchCheckFail(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        reportAsyncRequest(new RetrieveTaskObj(str, "-1", str2, str3, str4, jSONObject == null ? "" : jSONObject.toString(), "", ""), null);
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveReportTask
    public void reportDispatch(String str, String str2, String str3, JSONObject jSONObject, String str4, IReportListener iReportListener) {
        reportAsyncRequest(new RetrieveTaskObj(str, "1", str2, str3, str4, jSONObject == null ? "" : jSONObject.toString(), "", ""), iReportListener);
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveReportTask
    public void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject, IReportListener iReportListener) {
        reportAsyncRequest(new RetrieveTaskObj(str, "2", str2, str3, "", jSONObject == null ? "" : jSONObject.toString(), "", ""), iReportListener);
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveReportTask
    public void reportTaskDone(String str, String str2, String str3, String str4, String str5, String str6, IReportListener iReportListener, String str7) {
        reportAsyncRequest(new RetrieveTaskObj(str, "4", str2, str3, str4, "", str6, str7), iReportListener);
    }

    public void reportAsyncRequest(final RetrieveTaskObj retrieveTaskObj, final IReportListener iReportListener) {
        TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.retrieve.RetrieveReportImpl.1
            @Override // java.lang.Runnable
            public void run() {
                RetrieveReportRequest retrieveReportRequest = new RetrieveReportRequest(RetrieveReportImpl.this.mContext, retrieveTaskObj.getType(), retrieveTaskObj.getValue(), retrieveTaskObj.getJobID(), retrieveTaskObj.getStatus(), retrieveTaskObj.getOrigin(), retrieveTaskObj.getFileMeta(), retrieveTaskObj.getFileid(), iReportListener);
                HttpHelper.executor(RetrieveReportImpl.this.mContext, retrieveReportRequest, retrieveReportRequest);
            }
        });
    }
}
