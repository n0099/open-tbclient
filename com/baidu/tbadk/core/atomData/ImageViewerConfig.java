package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.switchs.IdentifyImageSwitch;
import com.baidu.tieba.ch5;
import com.baidu.tieba.hx4;
import com.baidu.tieba.ix4;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
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
    public static final String IS_IDENTIFY_IMAGE = "is_identify_image";
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

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList a;
        public int b;
        public String c;
        public String d;
        public String e;
        public boolean f;
        public String g;
        public boolean h;
        public ConcurrentHashMap i;
        public boolean j;
        public boolean k;
        public boolean l;
        public ThreadData m;
        public String n;
        public String o;
        public String p;
        public boolean q;
        public Rect r;
        public RectF s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;

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
            this.b = 0;
            this.d = "";
            this.e = "";
            this.l = false;
            this.q = true;
            this.t = true;
            this.w = true;
        }

        public Builder A(ArrayList arrayList) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
                this.a = arrayList;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder B(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder C(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder D(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.n = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder E(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.b = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder F(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder G(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.q = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder H(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.u = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder I(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.h = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder J(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.l = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder K(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.j = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder L(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.t = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder M(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.g = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder N(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.k = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder O(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.o = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder Q(ThreadData threadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, threadData)) == null) {
                this.m = threadData;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder R(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.e = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public void setNeedRequestAd(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
                this.w = z;
            }
        }

        public ImageViewerConfig x(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
                return new ImageViewerConfig(context, this, null);
            }
            return (ImageViewerConfig) invokeL.objValue;
        }

        public Builder y(ConcurrentHashMap concurrentHashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, concurrentHashMap)) == null) {
                this.i = concurrentHashMap;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder z(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                this.p = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder P(Rect rect, RectF rectF) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, rect, rectF)) == null) {
                this.r = rect;
                this.s = rectF;
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
        if (builder.a != null && builder.a.size() > 0) {
            intent.putExtra(IS_DATA_VALID, DATA_VALID);
            intent.putStringArrayListExtra("url", builder.a);
            intent.putExtra("index", builder.b);
            intent.putExtra("is_pv", true);
            intent.putExtra(PV_TYPE, "pb");
            intent.putExtra(PARAM_IS_CDN, builder.f);
            intent.putExtra("fname", builder.c);
            intent.putExtra("fid", builder.d);
            intent.putExtra("tid", builder.e);
            intent.putExtra(LAST_ID, builder.g);
            intent.putExtra(REVERSE_MODE, builder.h);
            intent.putExtra(ASSIST_URLS, builder.i);
            intent.putExtra(IS_SHOW_AD, builder.j);
            intent.putExtra(NEED_BROADCAST, builder.k);
            intent.putExtra(SEE_HOST, builder.l);
            intent.putExtra(NEED_REQUEST_AD, builder.w);
            int size = builder.a.size();
            for (int i4 = 0; i4 < size; i4++) {
                String str = (String) builder.a.get(i4);
                if (!StringUtils.isNull(str)) {
                    ImageUrlData imageUrlData = builder.i != null ? (ImageUrlData) builder.i.get(str) : null;
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
        if (builder.m != null) {
            intent.putExtra(IS_BJH, builder.m.isUgcThreadType());
            if (builder.m.isUgcThreadType()) {
                intent.putExtra(PARAM_IS_CDN, true);
            }
            intent.putExtra("nid", builder.m.getNid());
            intent.putExtra("card_type", builder.m.getRecomCardType());
            intent.putExtra("recom_source", builder.m.mRecomSource);
            intent.putExtra("ab_tag", builder.m.mRecomAbTag);
            intent.putExtra("weight", builder.m.mRecomWeight);
            intent.putExtra("extra", builder.m.mRecomExtra);
            if (builder.m.isVideoWorksInfo()) {
                intent.putExtra(IS_VIDEO_WORKS_INFO, true);
            }
        }
        if (!TextUtils.isEmpty(builder.o)) {
            intent.putExtra("post_id", builder.o);
        }
        if (!TextUtils.isEmpty(builder.p)) {
            intent.putExtra(IntentConfig.BJH_POST_ID, builder.p);
        }
        intent.putExtra(IS_CAN_DRAG, builder.q);
        if (builder.r != null && builder.s != null) {
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                i = UtilHelper.getStatusBarHeight();
            } else {
                i = 0;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put((int) builder.s.left);
            float f = i;
            jSONArray.put((int) (builder.s.top - f));
            jSONArray.put((int) builder.s.right);
            jSONArray.put((int) (builder.s.bottom - f));
            jSONArray.put(builder.r.left);
            jSONArray.put(builder.r.top - i);
            jSONArray.put(builder.r.right);
            jSONArray.put(builder.r.bottom - i);
            intent.putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, jSONArray.toString());
        }
        intent.putExtra(IS_SHOW_HOST, builder.t);
        if (builder.u) {
            intent.putExtra(IS_DYNAMIC_CARD, true);
            intent.putExtra(IS_SHOW_BOTTOM_CONTAINER, false);
            intent.putExtra(IS_SHOW_HOST, false);
        }
        intent.putExtra(IS_IDENTIFY_IMAGE, IdentifyImageSwitch.isOn());
        intent.putExtra(IS_FROM_AI_APP, builder.v);
        intent.putExtra("from_forum_id", builder.n);
        intent.putExtra("skin_type", TbadkCoreApplication.getInst().getSkinType());
        intent.putExtra(IS_YOUNGSTER_MODE, false);
        intent.putExtra(TiebaStatic.Params.WISE_SAMPLE_ID, ch5.c());
        if (hx4.a() != null && hx4.a().a != null) {
            intent.putExtra(REMIND_LIVE_DATA, hx4.a().a);
        }
        if (ix4.b() != null) {
            intent.putExtra(REMIND_LIVE_FREQUENCY, ix4.b().a());
        }
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
