package com.baidu.searchbox.ugc.webjs;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.publisher.base.PublisherConfig;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.activity.AskPublishActivity;
import com.baidu.searchbox.ugc.activity.ForwardPublishActivity;
import com.baidu.searchbox.ugc.activity.LocalAlbumActivity;
import com.baidu.searchbox.ugc.activity.QuestionsPublishActivity;
import com.baidu.searchbox.ugc.activity.ReplyPublishActivity;
import com.baidu.searchbox.ugc.activity.TextImagePublishActivity;
import com.baidu.searchbox.ugc.activity.VideoPublishActivity;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.model.AtSelectEvent;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.TopicItem;
import com.baidu.searchbox.ugc.model.TopicSelectEvent;
import com.baidu.searchbox.ugc.model.UgcTagItem;
import com.baidu.searchbox.ugc.model.UgcTagSelectEvent;
import com.baidu.searchbox.ugc.publishmenu.ItemInfo;
import com.baidu.searchbox.ugc.publishmenu.PublishMenuDialog;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.FastPublishUtils;
import com.baidu.searchbox.ugc.utils.UgcDataUtil;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.view.ReplyPublishDialog;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class UnitedSchemeUGCDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String MODULE_UGC = "ugc";
    public static final int REQ_CODE_PUBLISH = 101;
    public static final String SCHEMA_PATH_VOTE_CALLBACK = "voteCallback";
    public static final String SCHEME_PATH_ADD_TOPIC = "addTopic";
    public static final String SCHEME_PATH_GET_AT_INFO = "getAtInfo";
    private static final String SCHEME_PATH_GET_TAG_INFO = "getTagInfo";
    public static final String SCHEME_PATH_PUBLISH = "publish";
    private static final String VOTE_URL_CODE = "249";
    private static String sUgcCallback;
    private String mCallback;
    private Context mContext;
    private static final String TAG = UnitedSchemeUGCDispatcher.class.getSimpleName();
    private static final boolean DEBUG = AppConfig.isDebug();
    public static HashMap<String, CallbackHandler> sSchemeCallbackHandlerMap = new HashMap<>();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "ugc";
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        char c = 65535;
        if (DEBUG) {
            Log.e(TAG, "invoke params==" + unitedSchemeEntity.getParam("params"));
        }
        if (context instanceof Activity) {
            this.mContext = context;
        } else {
            Context rnActivity = UgcRuntime.getUgcInterface().getRnActivity(context);
            if (rnActivity != null) {
                this.mContext = rnActivity;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        this.mCallback = unitedSchemeEntity.getParam(BuyTBeanActivityConfig.CALLBACK);
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            String param = unitedSchemeEntity.getParam("params");
            switch (path.hashCode()) {
                case -1246125810:
                    if (path.equals(SCHEME_PATH_ADD_TOPIC)) {
                        c = 1;
                        break;
                    }
                    break;
                case -512461006:
                    if (path.equals(SCHEME_PATH_GET_TAG_INFO)) {
                        c = 3;
                        break;
                    }
                    break;
                case -235365105:
                    if (path.equals("publish")) {
                        c = 0;
                        break;
                    }
                    break;
                case 287487607:
                    if (path.equals(SCHEME_PATH_GET_AT_INFO)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1156140367:
                    if (path.equals(SCHEMA_PATH_VOTE_CALLBACK)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    try {
                        if (sSchemeCallbackHandlerMap != null) {
                            sSchemeCallbackHandlerMap.put(path, callbackHandler);
                        }
                        UgcSchemeModel parserSchemeModel = UgcSchemeModel.parserSchemeModel(new JSONObject(param));
                        sUgcCallback = parserSchemeModel.ugcCallback;
                        if (!TextUtils.isEmpty(parserSchemeModel.publishType)) {
                            gotoActivity(parserSchemeModel, -1);
                            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                            return true;
                        }
                        showPublishMenuDialog(this.mContext, parserSchemeModel, -1);
                        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        break;
                    }
                case 1:
                    try {
                        if (this.mContext instanceof Activity) {
                            ((Activity) this.mContext).finish();
                        }
                        JSONObject jSONObject = new JSONObject(param);
                        String string = jSONObject.getString("id");
                        String string2 = jSONObject.getString("name");
                        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        TopicSelectEvent topicSelectEvent = new TopicSelectEvent();
                        topicSelectEvent.mTopicItem = new TopicItem(string2, string);
                        EventBusWrapper.post(topicSelectEvent);
                        return true;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        break;
                    }
                case 2:
                    try {
                        if (this.mContext instanceof Activity) {
                            ((Activity) this.mContext).finish();
                        }
                        JSONObject jSONObject2 = new JSONObject(param);
                        String string3 = jSONObject2.getString("uk");
                        String string4 = jSONObject2.getString("name");
                        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        AtSelectEvent atSelectEvent = new AtSelectEvent();
                        atSelectEvent.mAtUserInfoItem = new AtUserInfoItem(string4, string3);
                        EventBusWrapper.post(atSelectEvent);
                        return true;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        break;
                    }
                case 3:
                    try {
                        if (this.mContext instanceof Activity) {
                            ((Activity) this.mContext).finish();
                        }
                        JSONObject jSONObject3 = new JSONObject(param);
                        String optString = jSONObject3.optString("id");
                        String optString2 = jSONObject3.optString("name");
                        String optString3 = jSONObject3.optString("type");
                        String optString4 = jSONObject3.optString("opt");
                        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        UgcTagSelectEvent ugcTagSelectEvent = new UgcTagSelectEvent();
                        ugcTagSelectEvent.tagItem = new UgcTagItem(optString, optString2, optString3, optString4);
                        EventBusWrapper.post(ugcTagSelectEvent);
                        return true;
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        break;
                    }
                case 4:
                    try {
                        handleCallback(sUgcCallback, HttpRequestPublishModule.generateCallbackResult(new JSONObject(param).optJSONObject("data")));
                        break;
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                        break;
                    }
                default:
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                    break;
            }
            return false;
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    public void showPublishMenuDialog(Context context, final UgcSchemeModel ugcSchemeModel, final int i) {
        if (ugcSchemeModel.iconList != null && ugcSchemeModel.iconList.size() != 0) {
            final PublishMenuDialog publishMenuDialog = new PublishMenuDialog(context);
            publishMenuDialog.setData(ugcSchemeModel.iconList);
            publishMenuDialog.setOnItemClickListener(new PublishMenuDialog.OnItemClickListener() { // from class: com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher.1
                @Override // com.baidu.searchbox.ugc.publishmenu.PublishMenuDialog.OnItemClickListener
                public void onItemClick(ItemInfo itemInfo) {
                    publishMenuDialog.dismiss();
                    UnitedSchemeUGCDispatcher.this.handleMenuItemClick(ugcSchemeModel, itemInfo, i);
                }
            });
            publishMenuDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    UnitedSchemeUGCDispatcher.cleanSchemeHandlerMap();
                }
            });
            publishMenuDialog.show();
            UgcUBCUtils.ugcPvStatistics(0, UgcUBCUtils.mLayerPage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMenuItemClick(UgcSchemeModel ugcSchemeModel, ItemInfo itemInfo, int i) {
        JSONObject optJSONObject;
        if (ugcSchemeModel != null && itemInfo != null) {
            if (ugcSchemeModel.iconInfoObjs != null && (optJSONObject = ugcSchemeModel.iconInfoObjs.optJSONObject(itemInfo.type)) != null) {
                IconsInfo iconsInfo = new IconsInfo();
                iconsInfo.enable = optJSONObject.optString("enabled");
                iconsInfo.msg = optJSONObject.optString("message");
                if (iconsInfo.needShowErrorMsg()) {
                    UniversalToast.makeText(this.mContext, iconsInfo.msg).showToast();
                    return;
                }
            }
            if (TextUtils.equals(itemInfo.type, "12")) {
                if (!TextUtils.isEmpty(ugcSchemeModel.voteSchema)) {
                    BaseRouter.invokeScheme(this.mContext, Uri.parse(ugcSchemeModel.voteSchema), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
                }
            } else {
                ugcSchemeModel.publishType = itemInfo.type;
                gotoActivity(ugcSchemeModel, i);
            }
            if (!TextUtils.isEmpty(itemInfo.toUbcType())) {
                UgcUBCUtils.clickLayerBtnStatistics(itemInfo.toUbcType(), UgcDataUtil.parseInterestIdFormTarget(ugcSchemeModel.target));
            }
        }
    }

    private void gotoActivity(UgcSchemeModel ugcSchemeModel, int i) {
        if (!TextUtils.isEmpty(ugcSchemeModel.publishType)) {
            String str = ugcSchemeModel.publishType;
            String draftKey = DraftUtils.getDraftKey(ugcSchemeModel);
            char c = 65535;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c = 1;
                        break;
                    }
                    break;
                case 49:
                    if (str.equals("1")) {
                        c = 2;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c = 3;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        c = 4;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        c = 5;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        c = 7;
                        break;
                    }
                    break;
                case 56:
                    if (str.equals("8")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1567:
                    if (str.equals("10")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1568:
                    if (str.equals("11")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1571:
                    if (str.equals("14")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    openImageTextPublishActivity(this.mContext, ugcSchemeModel, i);
                    break;
                case 2:
                    openVideoAlbumPublishActivity(this.mContext, ugcSchemeModel);
                    break;
                case 3:
                    if (PublisherConfig.getPublisherVersion() == 1) {
                        openVideoCameraActivity(this.mContext, ugcSchemeModel);
                        break;
                    } else {
                        UgcRuntime.getUgcInterface().openVideoPublisherActivity(this.mContext, ugcSchemeModel);
                        break;
                    }
                case 4:
                    openPhotoAlbumPublishActivity(this.mContext, ugcSchemeModel);
                    break;
                case 5:
                    openForwardPublishActivity(this.mContext, ugcSchemeModel);
                    break;
                case 6:
                    FastPublishUtils.gotoFastPublish(ugcSchemeModel);
                    break;
                case 7:
                    openAnswerPublishActivity(this.mContext, ugcSchemeModel);
                    break;
                case '\b':
                    DraftData draft = DraftUtils.getDraft(draftKey);
                    if (draft != null && ((draft.images != null && draft.images.size() > 0) || (draft.video != null && !TextUtils.isEmpty(draft.video)))) {
                        Intent intent = new Intent(this.mContext, ReplyPublishActivity.class);
                        ugcSchemeModel.type = Integer.parseInt(str);
                        intent.putExtra("data", ugcSchemeModel);
                        if (this.mContext instanceof Activity) {
                            ((Activity) this.mContext).startActivityForResult(intent, 101);
                            ((Activity) this.mContext).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
                            break;
                        }
                    } else {
                        ReplyPublishDialog replyPublishDialog = new ReplyPublishDialog();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("data", ugcSchemeModel);
                        replyPublishDialog.setArguments(bundle);
                        if (this.mContext instanceof FragmentActivity) {
                            replyPublishDialog.show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "");
                            break;
                        }
                    }
                    break;
                case '\t':
                    DraftUtils.isShowDraft(draftKey, ugcSchemeModel.publishType);
                    Intent intent2 = new Intent(this.mContext, AskPublishActivity.class);
                    ugcSchemeModel.type = Integer.parseInt(str);
                    intent2.putExtra("data", ugcSchemeModel);
                    if (this.mContext instanceof Activity) {
                        ((Activity) this.mContext).startActivityForResult(intent2, 101);
                        ((Activity) this.mContext).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
                        break;
                    }
                    break;
            }
            UgcUBCUtils.enterUGCPage();
        }
    }

    public void openPublisher(UgcSchemeModel ugcSchemeModel, int i) {
        if (ugcSchemeModel.iconList != null && ugcSchemeModel.iconList.size() > 0) {
            showPublishMenuDialog(this.mContext, ugcSchemeModel, i);
        } else {
            gotoActivity(ugcSchemeModel, i);
        }
    }

    public static void openImageTextPublishActivity(Context context, UgcSchemeModel ugcSchemeModel, int i) {
        DraftUtils.isShowDraft(DraftUtils.getDraftKey(ugcSchemeModel), ugcSchemeModel.publishType);
        Intent intent = new Intent(context, TextImagePublishActivity.class);
        ugcSchemeModel.type = Integer.parseInt(ugcSchemeModel.publishType);
        intent.putExtra("data", ugcSchemeModel);
        if (i != -1) {
            intent.putExtra("customLayoutResourceId", i);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 101);
            ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
        }
    }

    public static void openVideoCameraActivity(Context context, UgcSchemeModel ugcSchemeModel) {
        if (DraftUtils.isShowDraft(DraftUtils.getDraftKey(ugcSchemeModel), ugcSchemeModel.publishType) && !ugcSchemeModel.isFollowVideo) {
            Intent intent = new Intent(context, VideoPublishActivity.class);
            intent.putExtra("data", ugcSchemeModel);
            if (context instanceof Activity) {
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
                return;
            }
            return;
        }
        ugcSchemeModel.launchFrom = "menu";
        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (iPublisherSboxVideoInterface != null) {
            iPublisherSboxVideoInterface.invokeVideoCapture(ugcSchemeModel, context);
        }
        UgcRuntime.getUgcInterface().postInterruptedEventToApp();
    }

    public static void openPhotoAlbumPublishActivity(Context context, UgcSchemeModel ugcSchemeModel) {
        if (DraftUtils.isShowDraft(DraftUtils.getDraftKey(ugcSchemeModel), ugcSchemeModel.publishType)) {
            Intent intent = new Intent(context, TextImagePublishActivity.class);
            intent.putExtra("data", ugcSchemeModel);
            if (context instanceof Activity) {
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
                return;
            }
            return;
        }
        Intent intent2 = new Intent(context, LocalAlbumActivity.class);
        ugcSchemeModel.from = 0;
        ugcSchemeModel.launchFrom = "menu";
        intent2.putExtra("data", ugcSchemeModel);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent2, 101);
            ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
        }
    }

    public static void openVideoAlbumPublishActivity(Context context, UgcSchemeModel ugcSchemeModel) {
        if (DraftUtils.isShowDraft(DraftUtils.getDraftKey(ugcSchemeModel), ugcSchemeModel.publishType)) {
            Intent intent = new Intent(context, VideoPublishActivity.class);
            intent.putExtra("data", ugcSchemeModel);
            if (context instanceof Activity) {
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
                return;
            }
            return;
        }
        Intent intent2 = new Intent(context, LocalAlbumActivity.class);
        ugcSchemeModel.from = 1;
        ugcSchemeModel.launchFrom = "menu";
        intent2.putExtra("data", ugcSchemeModel);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent2, 101);
            ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
        }
    }

    public static void openForwardPublishActivity(Context context, UgcSchemeModel ugcSchemeModel) {
        DraftUtils.isShowDraft(DraftUtils.getDraftKey(ugcSchemeModel), ugcSchemeModel.publishType);
        Intent intent = new Intent(context, ForwardPublishActivity.class);
        ugcSchemeModel.type = Integer.parseInt(ugcSchemeModel.publishType);
        intent.putExtra("data", ugcSchemeModel);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 101);
            ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
        }
    }

    public static void openAnswerPublishActivity(Context context, UgcSchemeModel ugcSchemeModel) {
        Intent intent = new Intent(context, QuestionsPublishActivity.class);
        intent.putExtra("data", ugcSchemeModel);
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
        }
    }

    public static void cleanSchemeHandlerMap() {
        if (sSchemeCallbackHandlerMap != null) {
            for (Map.Entry<String, CallbackHandler> entry : sSchemeCallbackHandlerMap.entrySet()) {
                entry.setValue(null);
            }
            sSchemeCallbackHandlerMap.clear();
        }
    }

    public static void handleCallback(String str, String str2) {
        CallbackHandler callbackHandler = sSchemeCallbackHandlerMap.get("publish");
        sSchemeCallbackHandlerMap.remove("publish");
        if (callbackHandler != null && str != null) {
            callbackHandler.handleSchemeDispatchCallback(str, str2);
        }
    }
}
