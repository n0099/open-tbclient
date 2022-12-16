package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PersonalChatUtil;
import com.baidu.tieba.ag5;
import com.baidu.tieba.ry4;
import com.baidu.tieba.sp4;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.vq4;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class UrlSchemaJumpHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_APP_JUMP_BLACK_LIST = "ad_scheme_blacklist";
    public static final List<String> SCHEMA_BLACK_LIST;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface CheckSchemeFlutterCallBack {
        void toJump();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2142095601, "Lcom/baidu/tbadk/core/util/UrlSchemaJumpHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2142095601, "Lcom/baidu/tbadk/core/util/UrlSchemaJumpHelper;");
                return;
            }
        }
        SCHEMA_BLACK_LIST = new ArrayList();
    }

    public UrlSchemaJumpHelper() {
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

    public static void checkFlutterInit(CheckSchemeFlutterCallBack checkSchemeFlutterCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, checkSchemeFlutterCallBack) == null) {
            MessageTask findTask = MessageManager.getInstance().findTask(2002015);
            if (vq4.c().contains("-Flutter") && findTask == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921674, new ag5(checkSchemeFlutterCallBack) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CheckSchemeFlutterCallBack val$callBack;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {checkSchemeFlutterCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callBack = checkSchemeFlutterCallBack;
                    }

                    @Override // com.baidu.tieba.ag5
                    public void onFail() {
                        CheckSchemeFlutterCallBack checkSchemeFlutterCallBack2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (checkSchemeFlutterCallBack2 = this.val$callBack) != null) {
                            checkSchemeFlutterCallBack2.toJump();
                        }
                    }

                    @Override // com.baidu.tieba.ag5
                    public void onSuccess() {
                        CheckSchemeFlutterCallBack checkSchemeFlutterCallBack2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (checkSchemeFlutterCallBack2 = this.val$callBack) != null) {
                            checkSchemeFlutterCallBack2.toJump();
                        }
                    }
                }));
            } else if (checkSchemeFlutterCallBack != null) {
                checkSchemeFlutterCallBack.toJump();
            }
        }
    }

    public static boolean isHitBlackList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null) {
                return false;
            }
            ensureBlackList();
            for (String str2 : SCHEMA_BLACK_LIST) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void ensureBlackList() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || !ListUtils.isEmpty(SCHEMA_BLACK_LIST)) {
            return;
        }
        String r = ry4.l().r(KEY_APP_JUMP_BLACK_LIST, null);
        if (TextUtils.isEmpty(r)) {
            return;
        }
        try {
            setBlackList(new JSONArray(r));
        } catch (JSONException e) {
            BdLog.e(e);
        }
    }

    public static void jumpDispatchOrderPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(str, context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheme = str;
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Uri parse = Uri.parse(this.val$scheme);
                        String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_AUDIO_ROOM_ID);
                        String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_AUDIO_USER_UK);
                        HashMap hashMap = new HashMap();
                        hashMap.put("room_id", queryParameter);
                        hashMap.put("user_uk", queryParameter2);
                        hashMap.put("animated", Boolean.FALSE);
                        hashMap.put("swipeback", Boolean.FALSE);
                        hashMap.put("present", Boolean.TRUE);
                        hashMap.put("isFromNative", "1");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "DispatchOrder", hashMap)));
                    }
                }
            });
        }
    }

    public static void jumpGameAlbum(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "GameGodAlbum", new HashMap())));
                    }
                }
            });
        }
    }

    public static void jumpGameGodsPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(str, context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheme = str;
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Uri parse = Uri.parse(this.val$scheme);
                        String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_GAME_ID);
                        String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_GOD_ID);
                        String queryParameter3 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_OPEN_PAY);
                        String queryParameter4 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_FROM_NATIVE);
                        String queryParameter5 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_AUDIO_ROOM_ID);
                        HashMap hashMap = new HashMap();
                        hashMap.put("game_id", queryParameter);
                        hashMap.put("god_id", queryParameter2);
                        hashMap.put("swipeback", Boolean.FALSE);
                        hashMap.put("isFromNative", queryParameter4);
                        if (TextUtils.isEmpty(queryParameter3)) {
                            queryParameter3 = "1";
                        }
                        hashMap.put("open_pay", queryParameter3);
                        if (queryParameter5 == null) {
                            queryParameter5 = "";
                        }
                        hashMap.put("room_id", queryParameter5);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "GameGodsDetailPage", hashMap)));
                    }
                }
            });
        }
    }

    public static void jumpGameOrderCommentPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(str, context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheme = str;
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Uri parse = Uri.parse(this.val$scheme);
                        String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_ORDER_ID);
                        String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_ORDER_STATUS);
                        String queryParameter3 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_GAME_ID);
                        String queryParameter4 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_GAME_NAME);
                        String queryParameter5 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_PLAY_TIMES);
                        String queryParameter6 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_ORDER_AMOUNT);
                        String queryParameter7 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_PLAY_PRICE);
                        String queryParameter8 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_UNIT);
                        String queryParameter9 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_AVATAR);
                        String queryParameter10 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_USER_NAME);
                        HashMap hashMap = new HashMap();
                        hashMap.put("order_id", queryParameter);
                        hashMap.put("order_status", queryParameter2);
                        hashMap.put("game_name", queryParameter4);
                        hashMap.put("game_id", queryParameter3);
                        hashMap.put("play_times", queryParameter5);
                        hashMap.put("order_amount", queryParameter6);
                        hashMap.put("play_price", queryParameter7);
                        hashMap.put("unit", queryParameter8);
                        hashMap.put("avatar", queryParameter9);
                        hashMap.put("user_name", queryParameter10);
                        hashMap.put("swipeback", Boolean.FALSE);
                        hashMap.put("transparent", Boolean.TRUE);
                        hashMap.put("isFromNative", "1");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "GameOrderComment", hashMap)));
                    }
                }
            });
        }
    }

    public static void jumpGameOrderPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(str, context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheme = str;
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Uri parse = Uri.parse(this.val$scheme);
                        String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_ORDER_ID);
                        String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_IS_GOD);
                        HashMap hashMap = new HashMap();
                        hashMap.put("order_id", queryParameter);
                        hashMap.put(IMUserExtraData.KEY_IS_GOD, queryParameter2);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "GameOrderDetail", hashMap)));
                    }
                }
            });
        }
    }

    public static void jumpGamePlayPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(str, context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheme = str;
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String queryParameter = Uri.parse(this.val$scheme).getQueryParameter(BdUniDispatchSchemeController.PARAM_BAR_NAME);
                        HashMap hashMap = new HashMap();
                        hashMap.put("bar_name", queryParameter);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "GamePlayPage", hashMap)));
                    }
                }
            });
        }
    }

    public static void jumpGameSkillDetail(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(str, context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheme = str;
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Uri parse = Uri.parse(this.val$scheme);
                        String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_GAME_ID);
                        String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_GOD_ID);
                        String queryParameter3 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_SKILL_ID);
                        HashMap hashMap = new HashMap();
                        hashMap.put("game_id", queryParameter);
                        hashMap.put("god_id", queryParameter2);
                        hashMap.put("skill_id", queryParameter3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "GameSkillDetail", hashMap)));
                    }
                }
            });
        }
    }

    public static void jumpMessageCenterPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(context)));
        }
    }

    public static void jumpNativeH5Page(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) && !StringUtils.isNull(str)) {
            sp4.o(context, Uri.parse(str).getQueryParameter("url"));
        }
    }

    public static void jumpUnPaidListPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(str, context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheme = str;
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String queryParameter = Uri.parse(this.val$scheme).getQueryParameter(BdUniDispatchSchemeController.PARAM_AUDIO_ROOM_ID);
                        HashMap hashMap = new HashMap();
                        hashMap.put("room_id", queryParameter);
                        hashMap.put("animated", Boolean.FALSE);
                        hashMap.put("swipeback", Boolean.FALSE);
                        hashMap.put("present", Boolean.TRUE);
                        hashMap.put("isFromNative", "1");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "UnPaidListPage", hashMap)));
                    }
                }
            });
        }
    }

    public static void jumpUnPaidOrderPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) {
            checkFlutterInit(new CheckSchemeFlutterCallBack(str, context) { // from class: com.baidu.tbadk.core.util.UrlSchemaJumpHelper.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheme = str;
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.UrlSchemaJumpHelper.CheckSchemeFlutterCallBack
                public void toJump() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Uri parse = Uri.parse(this.val$scheme);
                        String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_AUDIO_ROOM_ID);
                        String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_AUDIO_ORDER_INDEX);
                        HashMap hashMap = new HashMap();
                        hashMap.put("room_id", queryParameter);
                        hashMap.put("index", queryParameter2);
                        hashMap.put("animated", Boolean.FALSE);
                        hashMap.put("swipeback", Boolean.FALSE);
                        hashMap.put("present", Boolean.TRUE);
                        hashMap.put("isFromNative", "1");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.val$context, "UnPaidOrder", hashMap)));
                    }
                }
            });
        }
    }

    public static boolean tryDeeplinkFromWebview(String str, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, context)) == null) {
            if (TextUtils.isEmpty(str) || isHitBlackList(str) || launchApplication(context, str) != 1000) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void jumpPersonChat(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65550, null, context, str, z) == null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_USER_ID);
            String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_KEY_URI);
            String queryParameter3 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_USER_NAMESHOW);
            String queryParameter4 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_USER_PORTRAIT);
            String queryParameter5 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_TEAM_ID);
            String queryParameter6 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_GAME_ID);
            String queryParameter7 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_DEFAULT_DRAFT);
            if (z) {
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + queryParameter2);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                httpMessage.addParam(BdUniDispatchSchemeController.PARAM_TEAM_ID, queryParameter5);
                httpMessage.addParam(BdUniDispatchSchemeController.PARAM_GAME_ID, queryParameter6);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            PersonalChatUtil.a(context, xg.g(queryParameter, 0L), queryParameter3, queryParameter4, queryParameter7);
        }
    }

    public static void jumpPostDetailPage(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65551, null, context, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(Uri.parse(str).getQueryParameter("id"), null, "allthread");
        createNormalCfg.setVideo_source("push");
        createNormalCfg.setStartFrom(25);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public static int launchApplication(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, str)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                intent.setData(Uri.parse(str));
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                        return 1004;
                    }
                    context.startActivity(intent);
                    return 1000;
                } catch (Exception unused) {
                    return 1006;
                }
            } catch (Exception unused2) {
                return 1003;
            }
        }
        return invokeLL.intValue;
    }

    public static void setBlackList(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, jSONArray) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList(jSONArray.length());
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        arrayList.add(optString);
                    }
                }
                synchronized (SCHEMA_BLACK_LIST) {
                    SCHEMA_BLACK_LIST.clear();
                    SCHEMA_BLACK_LIST.addAll(arrayList);
                }
                ry4.l().z(KEY_APP_JUMP_BLACK_LIST, jSONArray.toString());
                return;
            }
            ry4.l().E(KEY_APP_JUMP_BLACK_LIST);
            SCHEMA_BLACK_LIST.clear();
        }
    }
}
