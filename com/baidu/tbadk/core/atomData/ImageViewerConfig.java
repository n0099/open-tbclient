package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.a95;
import com.baidu.tieba.b95;
import com.baidu.tieba.mw5;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class ImageViewerConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ABTEST = "abtest";
    public static final String ACCOUNT_BDUSS = "account_bduss";
    public static final String ACCOUNT_STOKEN = "account_stoken";
    public static final String ACCOUNT_TBS = "account_tbs";
    public static final String ASSIST_URLS = "assist_urls";
    public static final String DATA_NOT_VALID = "data_not_valid";
    public static final String DATA_VALID = "data_valid";
    public static final String FORUM_ID = "fid";
    public static final String FORUM_NAME = "fname";
    public static final String FROM_CONCERN = "concern";
    public static final String FROM_DISCOVER_BEAUTY = "discover_beauty";
    public static final String FROM_FRS = "frs";
    public static final String FROM_GAME_VIDEO = "game_video";
    public static final String FROM_HOME = "index";
    public static final String FROM_HOT_TOPIC = "hot_topic";
    public static final String FROM_OTHER = "other";
    public static final String FROM_PB = "pb";
    public static final String FROM_PORTRAIT = "portrait";
    public static final String FROM_VIDEO_TAB = "video_tab";
    public static final String INDEX = "index";
    public static final String IS_BJH = "is_bjh";
    public static final String IS_CAN_DRAG = "is_can_drag";
    public static final String IS_DATA_VALID = "is_data_valid";
    public static final String IS_DYNAMIC_CARD = "is_dynamic_card";
    public static final String IS_FROM_AI_APP = "is_from_ai_app";
    public static final String IS_GODREPLY_IMAGE = "is_godreply_image";
    public static final String IS_LOGIN = "is_login";
    public static final String IS_PV = "is_pv";
    public static final String IS_SHOW_AD = "is_show_ad";
    public static final String IS_SHOW_BOTTOM_CONTAINER = "is_show_bottom_container";
    public static final String IS_SHOW_HOST = "is_show_host";
    public static final String IS_VIDEO_WORKS_INFO = "is_video_works_info";
    public static final String IS_YOUNGSTER_MODE = "is_youngster_mode";
    public static final String KEY_FPS_IMAGE = "HomeToImgBrowser_image_tran";
    public static final String KEY_FPS_IMAGE_FROM = "HomeToImgBrowser";
    public static final String KEY_FPS_IMAGE_PAGE = "image";
    public static final String KEY_FPS_IMAGE_TYPE = "tran";
    public static final String KEY_IS_BROWSE_MODE = "key_is_browse_mode";
    public static final String KEY_PROFILE_VIRTUAL_IMAGE_INFO = "key_profile_virtual_image_info";
    public static final String LAST_ID = "last_id";
    public static final String NEED_BROADCAST = "need_broadcast";
    public static final String NEED_REQUEST_AD = "need_request_ad";
    public static final String PARAM_IS_CDN = "isCdn";
    public static final String PV_TYPE = "pv_type";
    public static final String REMIND_LIVE_DATA = "remind_live_data";
    public static final String REMIND_LIVE_FREQUENCY = "remind_live_frequency";
    public static final String REVERSE_MODE = "reverse_mode";
    public static final String SEE_HOST = "see_host";
    public static final String SKIN_TYPE = "skin_type";
    public static final String START_ACTIVITY_NORMAL = "start_activity_normal";
    public static final String START_ACTIVITY_TYPE = "start_activity_type";
    public static final String THREAD_ID = "tid";
    public static final String THREAD_TYPE = "thread_type";
    public static final String URL = "url";
    public static final String USER_ID = "user_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConcurrentHashMap<String, ImageUrlData> assistUrls;
        public String bjhPostId;
        public ArrayList<String> data;
        public RectF drawableRect;
        public String forumId;
        public String forumName;
        public String fromFormId;
        public int index;
        public boolean isCDN;
        public boolean isCanDrag;
        public boolean isDynamicCard;
        public boolean isFromAiApp;
        public boolean isReserve;
        public boolean isSeeHost;
        public boolean isShowAd;
        public boolean isShowHost;
        public String lastId;
        public boolean needBroadCaset;
        public boolean needRequestAd;
        public String postId;
        public ThreadData threadData;
        public String threadId;
        public Rect viewRect;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.index = 0;
            this.forumId = "";
            this.threadId = "";
            this.isSeeHost = false;
            this.isCanDrag = true;
            this.isShowHost = true;
            this.needRequestAd = true;
        }

        public ImageViewerConfig bulid(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return new ImageViewerConfig(context, this, null);
            }
            return (ImageViewerConfig) invokeL.objValue;
        }

        public Builder setAssistUrls(ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, concurrentHashMap)) == null) {
                this.assistUrls = concurrentHashMap;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBjhPostId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.bjhPostId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setData(ArrayList<String> arrayList) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
                this.data = arrayList;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setForumId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.forumId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setForumName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.forumName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFromForumId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.fromFormId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.index = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIsCDN(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.isCDN = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsCanDrag(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.isCanDrag = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsDynamicCard(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.isDynamicCard = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsFromAiApp(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.isFromAiApp = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsReserve(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.isReserve = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsSeeHost(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.isSeeHost = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsShowAd(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.isShowAd = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsShowHost(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.isShowHost = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setLastId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                this.lastId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNeedBroadCaset(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                this.needBroadCaset = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @Keep
        public void setNeedRequestAd(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
                this.needRequestAd = z;
            }
        }

        public Builder setPostId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                this.postId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setThreadData(ThreadData threadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, threadData)) == null) {
                this.threadData = threadData;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setThreadId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                this.threadId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSrcRectInScreen(Rect rect, RectF rectF) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, rect, rectF)) == null) {
                this.viewRect = rect;
                this.drawableRect = rectF;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewerConfig(Context context, Builder builder) {
        super(context);
        Intent intent;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (builder == null || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(START_ACTIVITY_TYPE, START_ACTIVITY_NORMAL);
        if (builder.data != null && builder.data.size() > 0) {
            intent.putExtra(IS_DATA_VALID, DATA_VALID);
            intent.putStringArrayListExtra("url", builder.data);
            intent.putExtra("index", builder.index);
            intent.putExtra("is_pv", true);
            intent.putExtra(PV_TYPE, "pb");
            intent.putExtra(PARAM_IS_CDN, builder.isCDN);
            intent.putExtra("fname", builder.forumName);
            intent.putExtra("fid", builder.forumId);
            intent.putExtra("tid", builder.threadId);
            intent.putExtra(LAST_ID, builder.lastId);
            intent.putExtra(REVERSE_MODE, builder.isReserve);
            intent.putExtra(ASSIST_URLS, builder.assistUrls);
            intent.putExtra(IS_SHOW_AD, builder.isShowAd);
            intent.putExtra(NEED_BROADCAST, builder.needBroadCaset);
            intent.putExtra(SEE_HOST, builder.isSeeHost);
            intent.putExtra(NEED_REQUEST_AD, builder.needRequestAd);
            int size = builder.data.size();
            for (int i4 = 0; i4 < size; i4++) {
                String str = (String) builder.data.get(i4);
                if (!StringUtils.isNull(str)) {
                    ImageUrlData imageUrlData = builder.assistUrls != null ? (ImageUrlData) builder.assistUrls.get(str) : null;
                    if (imageUrlData == null) {
                        imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = str;
                    }
                    imageUrlData.overAllIndex = i4 + 1;
                }
            }
            TbadkCoreApplication.getInst();
            intent.putExtra("is_login", TbadkCoreApplication.isLogin());
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                intent.putExtra("user_id", currentAccountObj.getID());
                intent.putExtra(ACCOUNT_BDUSS, currentAccountObj.getBDUSS());
                intent.putExtra(ACCOUNT_STOKEN, currentAccountObj.getStoken());
                intent.putExtra(ACCOUNT_TBS, currentAccountObj.getTbs());
            }
        } else {
            intent.putExtra(IS_DATA_VALID, DATA_NOT_VALID);
        }
        if (builder.threadData != null) {
            intent.putExtra(IS_BJH, builder.threadData.isUgcThreadType());
            if (builder.threadData.isUgcThreadType()) {
                intent.putExtra(PARAM_IS_CDN, true);
            }
            intent.putExtra("nid", builder.threadData.getNid());
            intent.putExtra("card_type", builder.threadData.getRecomCardType());
            intent.putExtra("recom_source", builder.threadData.mRecomSource);
            intent.putExtra("ab_tag", builder.threadData.mRecomAbTag);
            intent.putExtra("weight", builder.threadData.mRecomWeight);
            intent.putExtra("extra", builder.threadData.mRecomExtra);
            if (builder.threadData.isVideoWorksInfo()) {
                intent.putExtra(IS_VIDEO_WORKS_INFO, true);
            }
        }
        if (!TextUtils.isEmpty(builder.postId)) {
            intent.putExtra("post_id", builder.postId);
        }
        if (!TextUtils.isEmpty(builder.bjhPostId)) {
            intent.putExtra(IntentConfig.BJH_POST_ID, builder.bjhPostId);
        }
        intent.putExtra(IS_CAN_DRAG, builder.isCanDrag);
        if (builder.viewRect != null && builder.drawableRect != null) {
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                i = UtilHelper.getStatusBarHeight();
            } else {
                i = 0;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put((int) builder.drawableRect.left);
            float f = i;
            jSONArray.put((int) (builder.drawableRect.top - f));
            jSONArray.put((int) builder.drawableRect.right);
            jSONArray.put((int) (builder.drawableRect.bottom - f));
            jSONArray.put(builder.viewRect.left);
            jSONArray.put(builder.viewRect.top - i);
            jSONArray.put(builder.viewRect.right);
            jSONArray.put(builder.viewRect.bottom - i);
            intent.putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, jSONArray.toString());
        }
        intent.putExtra(IS_SHOW_HOST, builder.isShowHost);
        if (builder.isDynamicCard) {
            intent.putExtra(IS_DYNAMIC_CARD, true);
            intent.putExtra(IS_SHOW_BOTTOM_CONTAINER, false);
            intent.putExtra(IS_SHOW_HOST, false);
        }
        intent.putExtra(IS_FROM_AI_APP, builder.isFromAiApp);
        intent.putExtra("from_forum_id", builder.fromFormId);
        intent.putExtra("skin_type", TbadkCoreApplication.getInst().getSkinType());
        intent.putExtra(IS_YOUNGSTER_MODE, false);
        intent.putExtra(TiebaStatic.Params.WISE_SAMPLE_ID, mw5.c());
        if (a95.a() != null && a95.a().a != null) {
            intent.putExtra(REMIND_LIVE_DATA, a95.a().a);
        }
        if (b95.b() != null) {
            intent.putExtra(REMIND_LIVE_FREQUENCY, b95.b().a());
        }
        intent.putExtra(KEY_IS_BROWSE_MODE, PermissionUtil.isBrowseMode());
    }

    public /* synthetic */ ImageViewerConfig(Context context, Builder builder, a aVar) {
        this(context, builder);
    }

    public void setProfileVirtualImageInfo(ProfileVirtualImageInfo profileVirtualImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, profileVirtualImageInfo) == null) {
            getIntent().putExtra(KEY_PROFILE_VIRTUAL_IMAGE_INFO, ProfileVirtualImageInfo.getInstance());
        }
    }
}
