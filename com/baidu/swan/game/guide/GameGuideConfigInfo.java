package com.baidu.swan.game.guide;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.airbnb.lottie.LottieComposition;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.f.j.o.a;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GameGuideConfigInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_APP_KEY = "app_key";
    public static final String KEY_APP_NAME = "app_name";
    public static final String KEY_BANNER_IMG_URL = "banner_img_url";
    public static final String KEY_BANNER_SUBTITLE = "banner_subtitle";
    public static final String KEY_BANNER_TITLE = "banner_title";
    public static final String KEY_BUTTON_TEXT = "button_text";
    public static final String KEY_CLOSE_INFO = "close_info";
    public static final String KEY_CONFIG_NAME = "config_name";
    public static final String KEY_CONTENT1 = "content1";
    public static final String KEY_CONTENT2 = "content2";
    public static final String KEY_DIALOG_INFO = "dialog_info";
    public static final String KEY_DOWNLOAD_BACKGROUND_COLOR = "download_before_click";
    public static final String KEY_DOWNLOAD_TEXT_COLOR = "download_after_click";
    public static final String KEY_EXIT_BACKGROUND_COLOR = "exit_before_click";
    public static final String KEY_EXIT_TEXT_COLOR = "exit_after_click";
    public static final String KEY_EXPIRATION_TIME = "expiration_time";
    public static final String KEY_GAMENOW_APK_ID = "gamenow_apk_id";
    public static final String KEY_GAMENOW_CHANNEL = "gamenow_channel";
    public static final String KEY_GAME_LIST = "game_list";
    public static final String KEY_GAME_RECOMMEND_TIPS = "game_recommend_tips";
    public static final String KEY_GUIDE_TIPS1 = "guide_tips1";
    public static final String KEY_GUIDE_TIPS2 = "guide_tips2";
    public static final String KEY_ICON_DONE_URL = "icon_done_url";
    public static final String KEY_ICON_NORMAL_URL = "icon_normal_url";
    public static final String KEY_ICON_URL = "icon_url";
    public static final String KEY_INSTALL_RESULT = "install_result";
    public static final String KEY_MAX_NUMS = "max_nums";
    public static final String KEY_MAX_NUMS_TIPS = "max_nums_tips";
    public static final String KEY_OPEN_INSTALL_BOOT = "open_install_boot";
    public static final String KEY_PACKAGE_EXPIRE = "package_expire";
    public static final String KEY_PER_COIN_NUM = "per_coin_num";
    public static final String KEY_POPUP_SELECTION = "popup_selection";
    public static final String KEY_PROGRESS_COLOR = "progress_color";
    public static final String KEY_STATUS = "status";
    public static final String KEY_TARGET = "target";
    public static final String KEY_TARGET_APP_DOWNLOAD_URL = "target_app_download_url";
    public static final String KEY_TARGET_APP_NAME = "target_app_name";
    public static final String KEY_TARGET_APP_PACKAGE_ID = "target_app_package_id";
    public static final String KEY_TARGET_TYPE = "target_type";
    public static final String KEY_TIPS = "tips";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VIEW_INFO = "view_info";
    public static final String TAG = "GameGuideConfigInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public CloseInfo closeInfo;
    public String configName;
    public DialogInfo dialogInfo;
    public long expirationTime;
    public String gamenowApkId;
    public String gamenowChannel;
    public boolean install_result;
    public int maxNums;
    public long packageExpire;
    public int perCoinNum;
    public int popupSelection;
    public int status;
    public String targetAppDownloadUrl;
    public String targetAppName;
    public String targetAppPackageId;
    public ViewInfo viewInfo;

    /* loaded from: classes4.dex */
    public static class CloseInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TARGET_TYPE_GAME = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String bannerImgUrl;
        public String bannerSubTitle;
        public String bannerTitle;
        public String buttonText;
        public String downloadBackgroundColor;
        public String downloadTextColor;
        public String exitBackgroundColor;
        public String exitTextColor;
        public ArrayList<RecommendGameInfo> gameList;
        public String gameRecommendTips;
        public String target;
        public int targetType;
        public int type;

        public CloseInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = -1;
            this.gameRecommendTips = "";
            this.buttonText = "";
            this.bannerImgUrl = "";
            this.bannerTitle = "";
            this.bannerSubTitle = "";
            this.targetType = 1;
            this.target = "";
            this.downloadBackgroundColor = "";
            this.downloadTextColor = "";
        }

        public static CloseInfo parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            int optInt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject != null && (optInt = jSONObject.optInt("type", -1)) >= 0) {
                    CloseInfo closeInfo = new CloseInfo();
                    closeInfo.type = optInt;
                    closeInfo.gameRecommendTips = jSONObject.optString(GameGuideConfigInfo.KEY_GAME_RECOMMEND_TIPS);
                    closeInfo.buttonText = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                    closeInfo.bannerImgUrl = jSONObject.optString(GameGuideConfigInfo.KEY_BANNER_IMG_URL);
                    closeInfo.bannerTitle = jSONObject.optString(GameGuideConfigInfo.KEY_BANNER_TITLE);
                    closeInfo.bannerSubTitle = jSONObject.optString(GameGuideConfigInfo.KEY_BANNER_SUBTITLE);
                    closeInfo.targetType = jSONObject.optInt(GameGuideConfigInfo.KEY_TARGET_TYPE, 1);
                    closeInfo.target = jSONObject.optString("target");
                    closeInfo.downloadBackgroundColor = jSONObject.optString(GameGuideConfigInfo.KEY_DOWNLOAD_BACKGROUND_COLOR);
                    closeInfo.downloadTextColor = jSONObject.optString(GameGuideConfigInfo.KEY_DOWNLOAD_TEXT_COLOR);
                    closeInfo.exitBackgroundColor = jSONObject.optString(GameGuideConfigInfo.KEY_EXIT_BACKGROUND_COLOR);
                    closeInfo.exitTextColor = jSONObject.optString(GameGuideConfigInfo.KEY_EXIT_TEXT_COLOR);
                    JSONArray optJSONArray = jSONObject.optJSONArray(GameGuideConfigInfo.KEY_GAME_LIST);
                    if (optJSONArray != null) {
                        closeInfo.gameList = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            RecommendGameInfo parse = RecommendGameInfo.parse(optJSONArray.optJSONObject(i2));
                            if (parse != null) {
                                closeInfo.gameList.add(parse);
                            }
                        }
                    }
                    return closeInfo;
                }
                return null;
            }
            return (CloseInfo) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class DialogInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String buttonText;
        public String content1;
        public String content2;
        public String guideTips1;
        public String guideTips2;
        public String iconUrl;
        public String maxNumsTips;
        public String target;
        public int targetType;

        public DialogInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.iconUrl = "";
            this.content1 = "";
            this.content2 = "";
            this.guideTips1 = "";
            this.guideTips2 = "";
            this.maxNumsTips = "";
            this.buttonText = "";
            this.targetType = 1;
            this.target = "";
        }

        public static DialogInfo parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                DialogInfo dialogInfo = new DialogInfo();
                dialogInfo.iconUrl = jSONObject.optString("icon_url");
                dialogInfo.content1 = jSONObject.optString(GameGuideConfigInfo.KEY_CONTENT1);
                dialogInfo.content2 = jSONObject.optString(GameGuideConfigInfo.KEY_CONTENT2);
                dialogInfo.guideTips1 = jSONObject.optString(GameGuideConfigInfo.KEY_GUIDE_TIPS1);
                dialogInfo.guideTips2 = jSONObject.optString(GameGuideConfigInfo.KEY_GUIDE_TIPS2);
                dialogInfo.maxNumsTips = jSONObject.optString(GameGuideConfigInfo.KEY_MAX_NUMS_TIPS);
                dialogInfo.buttonText = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                dialogInfo.targetType = jSONObject.optInt(GameGuideConfigInfo.KEY_TARGET_TYPE, 1);
                dialogInfo.target = jSONObject.optString("target");
                return dialogInfo;
            }
            return (DialogInfo) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class RecommendGameInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String appKey;
        public String appName;
        public String iconUrl;

        public RecommendGameInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static RecommendGameInfo parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                RecommendGameInfo recommendGameInfo = new RecommendGameInfo();
                recommendGameInfo.appName = jSONObject.optString("app_name");
                recommendGameInfo.appKey = jSONObject.optString("app_key");
                recommendGameInfo.iconUrl = jSONObject.optString("icon_url");
                return recommendGameInfo;
            }
            return (RecommendGameInfo) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ViewInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LottieComposition iconDoneLottie;
        public String iconDoneUrl;
        public Bitmap iconNormalImg;
        public String iconNormalUrl;
        public String progressColor;
        public String tips;

        public ViewInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.iconNormalUrl = "";
            this.iconDoneUrl = "";
            this.progressColor = "";
            this.tips = "";
        }

        public static ViewInfo parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                ViewInfo viewInfo = new ViewInfo();
                viewInfo.iconDoneUrl = jSONObject.optString(GameGuideConfigInfo.KEY_ICON_DONE_URL);
                viewInfo.iconNormalUrl = jSONObject.optString(GameGuideConfigInfo.KEY_ICON_NORMAL_URL);
                viewInfo.progressColor = jSONObject.optString(GameGuideConfigInfo.KEY_PROGRESS_COLOR);
                viewInfo.tips = jSONObject.optString("tips");
                return viewInfo;
            }
            return (ViewInfo) invokeL.objValue;
        }
    }

    public GameGuideConfigInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.status = 0;
        this.expirationTime = 0L;
        this.packageExpire = 0L;
        this.install_result = true;
        this.targetAppName = "";
        this.targetAppPackageId = "";
        this.targetAppDownloadUrl = "";
        this.gamenowApkId = "";
        this.popupSelection = 0;
        this.perCoinNum = 0;
        this.maxNums = 0;
    }

    public static GameGuideConfigInfo parseData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                if (k.f49133a) {
                    Log.d(TAG, "data 为空");
                }
                return null;
            }
            GameGuideConfigInfo gameGuideConfigInfo = new GameGuideConfigInfo();
            int optInt = jSONObject.optInt("status", 0);
            gameGuideConfigInfo.status = optInt;
            a.p(Boolean.valueOf(jSONObject.optBoolean(KEY_OPEN_INSTALL_BOOT, false)).booleanValue());
            gameGuideConfigInfo.expirationTime = jSONObject.optLong(KEY_EXPIRATION_TIME, 0L);
            gameGuideConfigInfo.packageExpire = jSONObject.optLong(KEY_PACKAGE_EXPIRE, 0L);
            gameGuideConfigInfo.install_result = jSONObject.optBoolean(KEY_INSTALL_RESULT, true);
            gameGuideConfigInfo.targetAppName = jSONObject.optString(KEY_TARGET_APP_NAME, "");
            gameGuideConfigInfo.targetAppPackageId = jSONObject.optString(KEY_TARGET_APP_PACKAGE_ID, "");
            gameGuideConfigInfo.targetAppDownloadUrl = jSONObject.optString(KEY_TARGET_APP_DOWNLOAD_URL, "");
            String optString = jSONObject.optString(KEY_GAMENOW_APK_ID, "");
            gameGuideConfigInfo.gamenowApkId = optString;
            if (TextUtils.equals(StringUtil.NULL_STRING, optString)) {
                gameGuideConfigInfo.gamenowApkId = "";
            }
            gameGuideConfigInfo.popupSelection = jSONObject.optInt(KEY_POPUP_SELECTION, 0);
            if (optInt == 0) {
                if (k.f49133a) {
                    Log.d(TAG, "配置数据标明不展示");
                }
                return gameGuideConfigInfo;
            }
            gameGuideConfigInfo.perCoinNum = jSONObject.optInt(KEY_PER_COIN_NUM, 0);
            gameGuideConfigInfo.maxNums = jSONObject.optInt(KEY_MAX_NUMS, 0);
            gameGuideConfigInfo.configName = jSONObject.optString(KEY_CONFIG_NAME, "");
            gameGuideConfigInfo.gamenowChannel = jSONObject.optString(KEY_GAMENOW_CHANNEL, "");
            if ((gameGuideConfigInfo.maxNums <= 0 && gameGuideConfigInfo.popupSelection != 2) || TextUtils.isEmpty(gameGuideConfigInfo.targetAppPackageId) || TextUtils.isEmpty(gameGuideConfigInfo.targetAppDownloadUrl) || TextUtils.isEmpty(gameGuideConfigInfo.targetAppName) || gameGuideConfigInfo.targetAppPackageId.equals(StringUtil.NULL_STRING) || gameGuideConfigInfo.targetAppDownloadUrl.equals(StringUtil.NULL_STRING) || gameGuideConfigInfo.targetAppName.equals(StringUtil.NULL_STRING)) {
                return null;
            }
            ViewInfo parse = ViewInfo.parse(jSONObject.optJSONObject(KEY_VIEW_INFO));
            gameGuideConfigInfo.viewInfo = parse;
            DialogInfo parse2 = DialogInfo.parse(jSONObject.optJSONObject(KEY_DIALOG_INFO));
            gameGuideConfigInfo.dialogInfo = parse2;
            JSONObject optJSONObject = jSONObject.optJSONObject(KEY_CLOSE_INFO);
            CloseInfo parse3 = CloseInfo.parse(optJSONObject);
            gameGuideConfigInfo.closeInfo = parse3;
            if ((gameGuideConfigInfo.popupSelection == 0 && (parse == null || parse2 == null || optJSONObject == null)) || ((gameGuideConfigInfo.popupSelection == 1 && (parse == null || parse2 == null)) || (gameGuideConfigInfo.popupSelection == 2 && parse3 == null))) {
                return null;
            }
            return gameGuideConfigInfo;
        }
        return (GameGuideConfigInfo) invokeL.objValue;
    }
}
