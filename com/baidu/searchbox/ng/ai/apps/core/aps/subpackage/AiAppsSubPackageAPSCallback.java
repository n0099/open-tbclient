package com.baidu.searchbox.ng.ai.apps.core.aps.subpackage;

import android.content.Context;
import com.baidu.b.a.c.a.a;
import com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsBaseApsCallback;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class AiAppsSubPackageAPSCallback extends AiAppsBaseApsCallback {
    private static final boolean DEBUG = false;
    private static final String KEY_VERSION = "version";
    private static final String TAG = "AiAppsSubPackageAPSCallback";
    private Context mContext;
    private SubPackageAPSInfo mSubPackageAPSInfo;

    public AiAppsSubPackageAPSCallback(Context context, SubPackageAPSInfo subPackageAPSInfo) {
        super(subPackageAPSInfo.mKey);
        this.mContext = context;
        this.mSubPackageAPSInfo = subPackageAPSInfo;
    }

    @Override // com.baidu.b.a.b.a.a.a
    protected Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsBaseApsCallback, com.baidu.b.a.b.a.a
    public Map<String, String> getCommonParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("version", this.mSubPackageAPSInfo.mAppVersion);
        return hashMap;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsBaseApsCallback, com.baidu.b.a.b.a.a
    public String getDownloadPath() {
        return GetSubPackageHelper.getSubPackageZipFolder(this.mSubPackageAPSInfo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onConfigurationChanged(a aVar) {
        GetSubPackageHelper.callbackDownloadError(this.mSubPackageAPSInfo, SubPackageAPSInfo.RESULT_APS_NO_PACKAGE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onUpdate(a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onNewItemAdded(a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onItemFiltered(a aVar) {
        GetSubPackageHelper.callbackDownloadError(this.mSubPackageAPSInfo, SubPackageAPSInfo.RESULT_APS_NO_PACKAGE);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFetchError(com.baidu.b.a.b.b.a aVar) {
        GetSubPackageHelper.callbackDownloadError(this.mSubPackageAPSInfo, SubPackageAPSInfo.RESULT_APS_DOWNLOAD_ERROR);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloading(com.baidu.b.a.b.b.a aVar) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadStart(String str) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadError(com.baidu.b.a.b.b.a aVar) {
        GetSubPackageHelper.callbackDownloadError(this.mSubPackageAPSInfo, SubPackageAPSInfo.RESULT_APS_DOWNLOAD_ERROR);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFileDownloaded(com.baidu.b.a.b.b.a aVar, a aVar2) {
        GetSubPackageHelper.downloadSubPackageSuccess(this.mSubPackageAPSInfo, aVar2);
    }
}
