package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.e1.b.e;
import c.a.o0.s.q.c2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.switchs.IdentifyImageSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
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
    public static final String LAST_ID = "last_id";
    public static final String NEED_BROADCAST = "need_broadcast";
    public static final String PARAM_IS_CDN = "isCdn";
    public static final String PV_TYPE = "pv_type";
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f47183a;

        /* renamed from: b  reason: collision with root package name */
        public int f47184b;

        /* renamed from: c  reason: collision with root package name */
        public String f47185c;

        /* renamed from: d  reason: collision with root package name */
        public String f47186d;

        /* renamed from: e  reason: collision with root package name */
        public String f47187e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f47188f;

        /* renamed from: g  reason: collision with root package name */
        public String f47189g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f47190h;

        /* renamed from: i  reason: collision with root package name */
        public ConcurrentHashMap<String, ImageUrlData> f47191i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f47192j;
        public boolean k;
        public boolean l;
        public c2 m;
        public String n;
        public String o;
        public boolean p;
        public Rect q;
        public RectF r;
        public boolean s;
        public boolean t;
        public boolean u;

        public b() {
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
            this.f47184b = 0;
            this.f47186d = "";
            this.f47187e = "";
            this.l = false;
            this.p = true;
            this.s = true;
        }

        public b A(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.n = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b B(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f47184b = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b C(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f47188f = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b D(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.p = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b E(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.t = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b F(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f47190h = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b G(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.l = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b H(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f47192j = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b I(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.s = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b J(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f47189g = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b K(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.k = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b L(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.o = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b M(Rect rect, RectF rectF) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, rect, rectF)) == null) {
                this.q = rect;
                this.r = rectF;
                return this;
            }
            return (b) invokeLL.objValue;
        }

        public b N(c2 c2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, c2Var)) == null) {
                this.m = c2Var;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b O(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f47187e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public ImageViewerConfig v(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) ? new ImageViewerConfig(context, this, null) : (ImageViewerConfig) invokeL.objValue;
        }

        public b w(ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, concurrentHashMap)) == null) {
                this.f47191i = concurrentHashMap;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b x(ArrayList<String> arrayList) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
                this.f47183a = arrayList;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b y(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.f47186d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b z(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                this.f47185c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public /* synthetic */ ImageViewerConfig(Context context, b bVar, a aVar) {
        this(context, bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewerConfig(Context context, b bVar) {
        super(context);
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
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
        if (bVar == null || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(START_ACTIVITY_TYPE, START_ACTIVITY_NORMAL);
        if (bVar.f47183a != null && bVar.f47183a.size() > 0) {
            intent.putExtra(IS_DATA_VALID, DATA_VALID);
            intent.putStringArrayListExtra("url", bVar.f47183a);
            intent.putExtra("index", bVar.f47184b);
            intent.putExtra("is_pv", true);
            intent.putExtra(PV_TYPE, "pb");
            intent.putExtra(PARAM_IS_CDN, bVar.f47188f);
            intent.putExtra("fname", bVar.f47185c);
            intent.putExtra("fid", bVar.f47186d);
            intent.putExtra("tid", bVar.f47187e);
            intent.putExtra(LAST_ID, bVar.f47189g);
            intent.putExtra(REVERSE_MODE, bVar.f47190h);
            intent.putExtra(ASSIST_URLS, bVar.f47191i);
            intent.putExtra(IS_SHOW_AD, bVar.f47192j);
            intent.putExtra(NEED_BROADCAST, bVar.k);
            intent.putExtra(SEE_HOST, bVar.l);
            int size = bVar.f47183a.size();
            for (int i4 = 0; i4 < size; i4++) {
                String str = (String) bVar.f47183a.get(i4);
                if (!StringUtils.isNull(str)) {
                    ImageUrlData imageUrlData = bVar.f47191i != null ? (ImageUrlData) bVar.f47191i.get(str) : null;
                    if (imageUrlData == null) {
                        imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = str;
                    }
                    imageUrlData.overAllIndex = i4 + 1;
                }
            }
            TbadkCoreApplication.getInst();
            intent.putExtra(IS_LOGIN, TbadkCoreApplication.isLogin());
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
        if (bVar.m != null) {
            intent.putExtra(IS_BJH, bVar.m.z2());
            if (bVar.m.z2()) {
                intent.putExtra(PARAM_IS_CDN, true);
            }
            intent.putExtra("nid", bVar.m.D0());
            intent.putExtra("card_type", bVar.m.O0());
            intent.putExtra("recom_source", bVar.m.U0);
            intent.putExtra("ab_tag", bVar.m.W0);
            intent.putExtra("weight", bVar.m.V0);
            intent.putExtra("extra", bVar.m.X0);
            if (bVar.m.B2()) {
                intent.putExtra(IS_VIDEO_WORKS_INFO, true);
            }
        }
        if (!TextUtils.isEmpty(bVar.o)) {
            intent.putExtra("post_id", bVar.o);
        }
        intent.putExtra(IS_CAN_DRAG, bVar.p);
        if (bVar.q != null && bVar.r != null) {
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            JSONArray jSONArray = new JSONArray();
            jSONArray.put((int) bVar.r.left);
            float f2 = statusBarHeight;
            jSONArray.put((int) (bVar.r.top - f2));
            jSONArray.put((int) bVar.r.right);
            jSONArray.put((int) (bVar.r.bottom - f2));
            jSONArray.put(bVar.q.left);
            jSONArray.put(bVar.q.top - statusBarHeight);
            jSONArray.put(bVar.q.right);
            jSONArray.put(bVar.q.bottom - statusBarHeight);
            intent.putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, jSONArray.toString());
        }
        intent.putExtra(IS_SHOW_HOST, bVar.s);
        if (bVar.t) {
            intent.putExtra(IS_DYNAMIC_CARD, true);
            intent.putExtra(IS_SHOW_BOTTOM_CONTAINER, false);
            intent.putExtra(IS_SHOW_HOST, false);
        }
        intent.putExtra(IS_IDENTIFY_IMAGE, IdentifyImageSwitch.isOn());
        intent.putExtra(IS_FROM_AI_APP, bVar.u);
        intent.putExtra("from_forum_id", bVar.n);
        intent.putExtra("skin_type", TbadkCoreApplication.getInst().getSkinType());
        intent.putExtra(IS_YOUNGSTER_MODE, e.d());
    }
}
