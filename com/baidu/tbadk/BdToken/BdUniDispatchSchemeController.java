package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad5;
import com.repackage.bh;
import com.repackage.fj4;
import com.repackage.jk4;
import com.repackage.li4;
import com.repackage.mi4;
import com.repackage.oi;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BdUniDispatchSchemeController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAIDU_BOX_APP = "shoubai";
    public static String HOST = "unidispatch";
    public static final String IS_NEW_SCHEMA = "is_new_schema";
    public static final String IS_NEW_SCHEMA_VALUE = "1";
    public static String NATIVE_PARAM_MAINTAB_LOCATE = "maintablocate";
    public static String NATIVE_PARAM_MAINTAB_SUBTAB = "maintab_subtab";
    public static String PARAM_BAR_NAME = "bar_name";
    public static String PARAM_CHUSHOU_ROOM_ID = "chuchou_third_room_id";
    public static String PARAM_CHUSHOU_THIRD_LIVE_TYPE = "chushou_third_live_type";
    public static String PARAM_DEFAULT_DRAFT = "draft";
    public static String PARAM_EXPAND_DATA = "expanddata";
    public static String PARAM_EXT_DATA = "extdata";
    public static String PARAM_FIELD_ID = "field_id";
    public static String PARAM_FORUM_ID = "forumId";
    public static String PARAM_FORUM_NAME = "forumName";
    public static String PARAM_FROM = "from";
    public static String PARAM_GAME_ID = "game_id";
    public static String PARAM_GOD_ID = "god_id";
    public static String PARAM_HOME_TAB_NAME_CAMEL = "homeTabName";
    public static String PARAM_HOT_TREND = "hotTrend";
    public static String PARAM_IS_GOD = "is_god";
    public static String PARAM_ITEM_ID = "item_id";
    public static String PARAM_ITEM_ID_CAMEL = "itemId";
    public static String PARAM_KEY_TYPE = "type";
    public static String PARAM_KEY_URI = "uri";
    public static String PARAM_KW = "kw";
    public static String PARAM_NEW_GOD_FROM = "newgod_from";
    public static String PARAM_OPEN_PAY = "open_pay";
    public static String PARAM_ORDER_ID = "order_id";
    public static String PARAM_ORI_UGC_NID = "ori_ugc_nid";
    public static String PARAM_ORI_UGC_TID = "ori_ugc_tid";
    public static String PARAM_ORI_UGC_TYPE = "ori_ugc_type";
    public static String PARAM_ORI_UGC_VID = "ori_ugc_vid";
    public static String PARAM_PORTRAIT = "portrait";
    public static String PARAM_QQ = "QQ";
    public static String PARAM_QUERY = "query";
    public static String PARAM_RANK_CODE_CAMEL = "rankCode";
    public static String PARAM_RANK_TYPE_CAMEL = "rankType";
    public static String PARAM_SCHEME_FROM = "schemefrom";
    public static String PARAM_SHOUBAI = "shoubai";
    public static String PARAM_SKILL_ID = "skill_id";
    public static String PARAM_SORT_TYPE_CAMEL = "sortType";
    public static String PARAM_SOURCE = "source";
    public static String PARAM_TAB_CODE = "tabCode";
    public static String PARAM_TAB_ID = "tab_id";
    public static String PARAM_TAB_ID_CAMEL = "tabId";
    public static String PARAM_TAB_NAME = "tab_name";
    public static String PARAM_TASK_ACTION_ID = "actionid";
    public static String PARAM_TASK_INFO = "taskInfo";
    public static String PARAM_TBSHAREH5 = "tbShareH5";
    public static String PARAM_TEAM_ID = "team_id";
    public static String PARAM_TID = "tid";
    public static String PARAM_TOKEN = "token";
    public static String PARAM_TOPIC_ID = "topic_id";
    public static String PARAM_URI = "param_uri";
    public static String PARAM_URL = "url";
    public static String PARAM_USER_ID = "uid";
    public static String PARAM_USER_NAMESHOW = "nameShow";
    public static String PARAM_USER_PORTRAIT = "portrait";
    public static String PARAM_USE_MAIN_STATE = "useMainState";
    public static String PARAM_VIDEO = "shipin";
    public static String PARAM_WISE = "wise";
    public static String PARAM_YY_URL = "yy_url";
    public static String PATH_ACTIVITY_PAGE = "/activitypage";
    public static String PATH_CATEGORY_LIST = "/categorylist";
    public static String PATH_CHUSHOU_ALA_ROOM = "/tiebachushou";
    public static String PATH_ENTER_FORUM = "/enterforum";
    public static String PATH_FRS = "/frs";
    public static String PATH_GO_TO_FORUM_RULE_DETAIL = "/forumRuleDetail";
    public static String PATH_HOMEPAGE = "/homepage";
    public static String PATH_HOME_TAB = "/hometab";
    public static String PATH_HOT_USER_RANK = "/hotuserrank";
    public static String PATH_ITEM_DETIALS_PAGE = "/itemDetailsPage";
    public static String PATH_MESSAGE_CENTER = "/messageCenter";
    public static String PATH_MINE_PAGE = "/minePage";
    public static String PATH_ONE_KEY_SIGN = "/onekeysign";
    public static String PATH_PB = "/pb";
    public static String PATH_RECOMMEND_FORUM = "/recommendforum";
    public static String PATH_SWAN_APP = "/minapp";
    public static String PATH_TIEBA_YY_ROOM = "/tiebayy";
    public static String PATH_TOPIC_DETAIL = "/topicdetail";
    public static String PATH_USER_CENTER = "/usercenter";
    public static String PATH_VIDEO_SYNTHESIS_PAGE = "/videoSynthesisPage";
    public static String PATH_VIDEO_TAB = "/videotab";
    public static String PATH_WEBVIEW = "/tbwebview";
    public static String SCHEME = "com.baidu.tieba";
    public static String SCHEME_FROM_H5 = "from_h5";
    public static String SCHEME_FROM_TB_TOKEN = "from_tb_token";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final BdUniDispatchSchemeController a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1042402702, "Lcom/baidu/tbadk/BdToken/BdUniDispatchSchemeController$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1042402702, "Lcom/baidu/tbadk/BdToken/BdUniDispatchSchemeController$c;");
                    return;
                }
            }
            a = new BdUniDispatchSchemeController(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-785506579, "Lcom/baidu/tbadk/BdToken/BdUniDispatchSchemeController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-785506579, "Lcom/baidu/tbadk/BdToken/BdUniDispatchSchemeController;");
        }
    }

    public /* synthetic */ BdUniDispatchSchemeController(a aVar) {
        this();
    }

    private void addStaticForShemeFormH5(String str, Uri uri, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, str, uri, str2) == null) {
            if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !StringHelper.equals(str2, SCHEME_FROM_TB_TOKEN)) {
                TiebaStatic.log(new StatisticItem("c13391").param("obj_type", uri.getQueryParameter("obj_type")).param("obj_source", uri.getQueryParameter("obj_source")));
            }
            if (str == null || str.contains("tbwebview") || uri == null) {
                return;
            }
            String queryParameter = uri.getQueryParameter(IS_NEW_SCHEMA);
            if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
                return;
            }
            UtilHelper.clearClipBoard();
        }
    }

    public static final BdUniDispatchSchemeController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a : (BdUniDispatchSchemeController) invokeV.objValue;
    }

    public static boolean isUniScheme(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) ? uri != null && SCHEME.equals(uri.getScheme()) && HOST.equals(uri.getHost()) : invokeL.booleanValue;
    }

    private void processActivityMissionInfo(String str, String str2, String str3, Uri uri) {
        String str4;
        String str5;
        String str6;
        String str7;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, this, str, str2, str3, uri) == null) {
            jk4.f().i(uri);
            if (oi.isEmpty(str)) {
                return;
            }
            li4 li4Var = new li4(str);
            li4Var.m0(str3);
            if (li4Var.d() == 0 || li4Var.q() == 0) {
                return;
            }
            TbSingleton.getInstance().setInvokeSource(li4Var.e());
            bh.f(String.valueOf(li4Var.d()));
            bh.i(String.valueOf(li4Var.q()));
            int i = StringHelper.equals(str2, SCHEME_FROM_TB_TOKEN) ? 2 : 1;
            String str8 = "";
            if (uri != null) {
                str8 = uri.getQueryParameter(PARAM_KW);
                str5 = uri.getQueryParameter(PARAM_TID);
                str6 = uri.getQueryParameter(PARAM_QUERY);
                str7 = uri.getQueryParameter("hightlight_anchor_pid");
                str4 = uri.getQueryParameter(TiebaStatic.Params.REFER);
            } else {
                str4 = "";
                str5 = str4;
                str6 = str5;
                str7 = str6;
            }
            if (li4Var.d() == 1111 && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                if (currentActivity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) currentActivity).showFloatingWindow();
                } else if (currentActivity instanceof BaseActivity) {
                    ((BaseActivity) currentActivity).showFloatingWindow();
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_NEW_SCHEME_PULL_UP).param("obj_source", li4Var.e()).param("obj_type", li4Var.d()).param("obj_param1", li4Var.q()).param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.OBJ_PARAM3, li4Var.s()).param("extra", li4Var.v()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fname", str8).param("tid", str5).param("query", str6).param("pid", str7).param(TiebaStatic.Params.REFER, str4).param("obj_locate", TbadkCoreApplication.getInst().getStartType()).param("obj_name", 1).param(TiebaStatic.Params.WISE_SAMPLE_ID, li4Var.G()));
            mi4.w().m(li4Var);
        }
    }

    private void processSchemeFrom(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && !TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            ad5.m().u(true);
            ad5.m().k();
        }
    }

    public void parseForumSquareScheme(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, uri, bVar) == null) && uri != null && isUniScheme(uri) && UrlSchemaHelper.SCHEMA_PATH_FROM_FORUM_SQUARE.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = PARAM_TAB_NAME;
            hashMap.put(str, uri.getQueryParameter(str));
            bVar.a(hashMap);
        }
    }

    public void parseFrsScheme(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, bVar) == null) && uri != null && isUniScheme(uri) && PATH_FRS.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = PARAM_KW;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = PARAM_TAB_ID;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = PARAM_TID;
            hashMap.put(str3, uri.getQueryParameter(str3));
            processSchemeFrom(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(PARAM_EXT_DATA);
            String queryParameter2 = uri.getQueryParameter(PARAM_SCHEME_FROM);
            processActivityMissionInfo(queryParameter, queryParameter2, uri.getQueryParameter(PARAM_TOKEN), uri);
            addStaticForShemeFormH5("", uri, queryParameter2);
            bVar.a(hashMap);
        }
    }

    public void parseMainTabScheme(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, bVar) == null) && uri != null && isUniScheme(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(PARAM_EXT_DATA);
            String queryParameter2 = uri.getQueryParameter(PARAM_SCHEME_FROM);
            String queryParameter3 = uri.getQueryParameter(PARAM_TOKEN);
            String queryParameter4 = uri.getQueryParameter(PARAM_TAB_NAME);
            String queryParameter5 = uri.getQueryParameter(PARAM_TAB_CODE);
            processActivityMissionInfo(queryParameter, queryParameter2, queryParameter3, uri);
            processSchemeFrom(uri.getQueryParameter(PARAM_FROM));
            addStaticForShemeFormH5("", uri, queryParameter2);
            fj4.c(uri);
            if (PATH_HOMEPAGE.equals(uri.getPath())) {
                hashMap.put(NATIVE_PARAM_MAINTAB_LOCATE, 2);
                String str = PARAM_NEW_GOD_FROM;
                hashMap.put(str, uri.getQueryParameter(str));
                String str2 = PARAM_FIELD_ID;
                hashMap.put(str2, uri.getQueryParameter(str2));
                hashMap.put(PARAM_TAB_NAME, queryParameter4);
            } else if (PATH_ENTER_FORUM.equals(uri.getPath())) {
                hashMap.put(NATIVE_PARAM_MAINTAB_LOCATE, 1);
                hashMap.put(NATIVE_PARAM_MAINTAB_SUBTAB, queryParameter4);
            } else if (PATH_RECOMMEND_FORUM.equals(uri.getPath())) {
                hashMap.put(NATIVE_PARAM_MAINTAB_LOCATE, 1);
                hashMap.put(NATIVE_PARAM_MAINTAB_SUBTAB, "1_recommend");
            } else if (PATH_ACTIVITY_PAGE.equals(uri.getPath())) {
                hashMap.put(NATIVE_PARAM_MAINTAB_LOCATE, 2);
                hashMap.put(PARAM_TAB_NAME, queryParameter4);
            } else if (PATH_MINE_PAGE.equals(uri.getPath())) {
                hashMap.put(NATIVE_PARAM_MAINTAB_LOCATE, 8);
            } else if (PATH_MESSAGE_CENTER.equals(uri.getPath())) {
                hashMap.put(NATIVE_PARAM_MAINTAB_LOCATE, 3);
            } else if (PATH_VIDEO_TAB.equals(uri.getPath())) {
                hashMap.put(NATIVE_PARAM_MAINTAB_LOCATE, 22);
                hashMap.put(NATIVE_PARAM_MAINTAB_SUBTAB, "22_recommend");
            } else if (PATH_HOME_TAB.equals(uri.getPath())) {
                hashMap.put(NATIVE_PARAM_MAINTAB_LOCATE, 2);
                hashMap.put(PARAM_TAB_CODE, queryParameter5);
            }
            bVar.a(hashMap);
        }
    }

    public void parsePbScheme(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, uri, bVar) == null) && uri != null && isUniScheme(uri) && PATH_PB.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = PARAM_TID;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = PARAM_ORI_UGC_NID;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = PARAM_ORI_UGC_TID;
            hashMap.put(str3, uri.getQueryParameter(str3));
            String str4 = PARAM_ORI_UGC_TYPE;
            hashMap.put(str4, uri.getQueryParameter(str4));
            String str5 = PARAM_ORI_UGC_VID;
            hashMap.put(str5, uri.getQueryParameter(str5));
            processSchemeFrom(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(PARAM_EXT_DATA);
            String queryParameter2 = uri.getQueryParameter(PARAM_SCHEME_FROM);
            processActivityMissionInfo(queryParameter, queryParameter2, uri.getQueryParameter(PARAM_TOKEN), uri);
            addStaticForShemeFormH5("", uri, queryParameter2);
            bVar.a(hashMap);
        }
    }

    public void parseTopicDetailScheme(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, uri, bVar) == null) && uri != null && isUniScheme(uri) && PATH_TOPIC_DETAIL.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = PARAM_TOPIC_ID;
            hashMap.put(str, uri.getQueryParameter(str));
            processSchemeFrom(uri.getQueryParameter(PARAM_FROM));
            processActivityMissionInfo(uri.getQueryParameter(PARAM_EXT_DATA), uri.getQueryParameter(PARAM_SCHEME_FROM), uri.getQueryParameter(PARAM_TOKEN), uri);
            bVar.a(hashMap);
        }
    }

    public void parseUserCenterScheme(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, uri, bVar) == null) && uri != null && isUniScheme(uri) && PATH_USER_CENTER.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = PARAM_PORTRAIT;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = PARAM_USE_MAIN_STATE;
            hashMap.put(str2, Boolean.valueOf(uri.getBooleanQueryParameter(str2, false)));
            processActivityMissionInfo(uri.getQueryParameter(PARAM_EXT_DATA), uri.getQueryParameter(PARAM_SCHEME_FROM), uri.getQueryParameter(PARAM_TOKEN), uri);
            bVar.a(hashMap);
        }
    }

    public void parseWebViewScheme(String str, Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, uri, bVar) == null) && uri != null && isUniScheme(uri) && PATH_WEBVIEW.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str2 = PARAM_URL;
            hashMap.put(str2, uri.getQueryParameter(str2));
            hashMap.put(PARAM_URI, uri);
            processSchemeFrom(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(PARAM_EXT_DATA);
            String queryParameter2 = uri.getQueryParameter(PARAM_SCHEME_FROM);
            processActivityMissionInfo(queryParameter, queryParameter2, uri.getQueryParameter(PARAM_TOKEN), uri);
            addStaticForShemeFormH5(str, uri, queryParameter2);
            bVar.a(hashMap);
        }
    }

    public BdUniDispatchSchemeController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void parseWebViewScheme(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, uri) == null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter(IS_NEW_SCHEMA);
        if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
            return;
        }
        UtilHelper.clearClipBoard();
    }
}
