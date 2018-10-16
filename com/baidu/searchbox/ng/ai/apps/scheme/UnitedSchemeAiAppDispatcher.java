package com.baidu.searchbox.ng.ai.apps.scheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.account.actions.GetBdussAction;
import com.baidu.searchbox.ng.ai.apps.data.action.GetRegionDataAction;
import com.baidu.searchbox.ng.ai.apps.form.GetFormIdAction;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.media.recorder.action.AudioRecordAction;
import com.baidu.searchbox.ng.ai.apps.media.video.action.SaveVideoAction;
import com.baidu.searchbox.ng.ai.apps.network.AigRequestAction;
import com.baidu.searchbox.ng.ai.apps.network.CancelRequestAction;
import com.baidu.searchbox.ng.ai.apps.network.RequestAction;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.ChooseImageAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.DownloadFileAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetImageInfoAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetLocalImgDataAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenDocumentAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.PerformancePanelAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.PostMsgAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.SaveImageAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.UbcFlowJarAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.UploadFileAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction.ShowToastAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions.RecommendProductsAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions.RecommendSimilarAction;
import com.baidu.searchbox.ng.ai.apps.setting.actions.AuthorizeAction;
import com.baidu.searchbox.ng.ai.apps.setting.actions.CheckSessionAction;
import com.baidu.searchbox.ng.ai.apps.setting.actions.GetPhoneNumAction;
import com.baidu.searchbox.ng.ai.apps.setting.actions.GetSettingAction;
import com.baidu.searchbox.ng.ai.apps.setting.actions.GetSwanIdAction;
import com.baidu.searchbox.ng.ai.apps.setting.actions.GetUserInfoAction;
import com.baidu.searchbox.ng.ai.apps.setting.actions.LoginAction;
import com.baidu.searchbox.ng.ai.apps.setting.actions.OpenSettingAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.ClearStorageAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.ClearStorageSyncAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.GetStorageAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.GetStorageSyncAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.RmStorageAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.RmStorageSyncAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.SetStorageAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.SetStorageSyncAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.StorageInfoAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.StorageInfoSyncAction;
import com.baidu.searchbox.ng.ai.apps.system.accelerometer.action.StartAccelerometerAction;
import com.baidu.searchbox.ng.ai.apps.system.accelerometer.action.StopAccelerometerAction;
import com.baidu.searchbox.ng.ai.apps.system.compass.action.StartCompassAction;
import com.baidu.searchbox.ng.ai.apps.system.compass.action.StopCompassAction;
import com.baidu.searchbox.ng.ai.apps.system.sysinfo.action.GetSysInfoAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class UnitedSchemeAiAppDispatcher extends UnitedSchemeBaseDispatcher {
    private static final boolean DEBUG = false;
    public static final String MODULE_AIAPP = "swan";
    public static final String MODULE_NAME = "swan";
    public static final String PATH_SEPARATOR = "/";
    private static final String TAG = UnitedSchemeAiAppDispatcher.class.getSimpleName();
    protected final Map<String, AiAppAction> mActionMap = new HashMap();

    public UnitedSchemeAiAppDispatcher() {
        initActionMap();
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty url");
            return false;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty Segment");
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path) || !path.startsWith("/")) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + path);
            return false;
        }
        String str = path;
        for (int size = pathSegments.size(); size > 0; size--) {
            String str2 = "/" + pathSegments.get(size - 1);
            if (str.isEmpty() || str.length() < str2.length()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str + " @ " + str2);
                return false;
            }
            AiAppAction aiAppAction = this.mActionMap.get(str);
            if (aiAppAction != null) {
                if (unitedSchemeEntity.isOnlyVerify()) {
                    return true;
                }
                return aiAppAction.handle(context, unitedSchemeEntity, callbackHandler, uri.getPath());
            }
            str = str.substring(0, str.length() - str2.length());
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "not support such action ：" + uri.getPath());
        return false;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    protected void initActionMap() {
        this.mActionMap.clear();
        regAction(new PostMsgAction(this));
        regAction(new RequestAction(this));
        regAction(new UploadFileAction(this));
        regAction(new DownloadFileAction(this));
        regAction(new CancelRequestAction(this));
        regAction(new OpenDocumentAction(this));
        regAction(new SetStorageAction(this));
        regAction(new SetStorageSyncAction(this));
        regAction(new GetStorageAction(this));
        regAction(new GetStorageSyncAction(this));
        regAction(new StorageInfoAction(this));
        regAction(new StorageInfoSyncAction(this));
        regAction(new RmStorageAction(this));
        regAction(new RmStorageSyncAction(this));
        regAction(new ClearStorageAction(this));
        regAction(new ClearStorageSyncAction(this));
        regAction(new LoginAction(this));
        regAction(new GetUserInfoAction(this));
        regAction(new GetSwanIdAction(this));
        regAction(new GetPhoneNumAction(this));
        regAction(new CheckSessionAction(this));
        regAction(new AuthorizeAction(this));
        regAction(new GetSettingAction(this));
        regAction(new OpenSettingAction(this));
        regAction(new GetImageInfoAction(this));
        regAction(new SaveImageAction(this));
        regAction(new ChooseImageAction(this));
        regAction(new GetRegionDataAction(this));
        regAction(new GetBdussAction(this));
        regAction(new UbcFlowJarAction(this));
        regAction(new StartCompassAction(this));
        regAction(new StopCompassAction(this));
        regAction(new StartAccelerometerAction(this));
        regAction(new StopAccelerometerAction(this));
        regAction(new AudioRecordAction(this));
        regAction(new RecommendSimilarAction(this));
        regAction(new RecommendProductsAction(this));
        regAction(new PerformancePanelAction(this));
        regAction(new SaveVideoAction(this));
        regAction(new GetSysInfoAction(this));
        regAction(new AigRequestAction(this));
        regAction(new WebSocketAction(this));
        regAction(new GetLocalImgDataAction(this));
        regAction(new ShowToastAction(this));
        regAction(new GetFormIdAction(this));
        AiAppsRuntime.getAiAppExtentSchemeRuntime().regAiAppExtentSchemeList(this);
    }

    public void regAction(AiAppAction aiAppAction) {
        this.mActionMap.put(aiAppAction.name, aiAppAction);
    }
}
