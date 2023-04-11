package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.df9;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.gg;
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.oi7;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.va9;
import com.baidu.tieba.yq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_IS_ONLIVING = "ala_is_living";
    public static final String BACK_SPECIAL = "back_special";
    public static final String FLAG = "flag";
    public static final String FLAG_SHOW_AD = "fun_ad";
    public static final String FOLLOWED_HAS_NEW = "followed_has_new";
    public static final String FROM = "from";
    public static final String FROM_PB_OR_PERSON = "from_pb_or_person";
    public static final String FROM_SHORT_CUT = "from_short_cut";
    public static final String FRS_CALL_FROM = "frs_call_from";
    public static final String FRS_CALL_FROM_BY_ITEM_POSITION = "frs_call_from_by_item_position";
    public static final int FRS_CALL_FROM_ENTERFORUM_FREQUENTLY = 4;
    public static final int FRS_CALL_FROM_ENTERFORUM_LIKE = 3;
    public static final int FRS_CALL_FROM_ENTER_FORUM_BUTTON = 14;
    public static final int FRS_CALL_FROM_HOME_LIVE_TAB = 15;
    public static final int FRS_CALL_FROM_ONE_KEY_SIGN = 6;
    public static final int FRS_CALL_FROM_PERSON_GUEST_LIKE = 9;
    public static final int FRS_CALL_FROM_PERSON_GUEST_SAME_FORUM = 8;
    public static final int FRS_CALL_FROM_PERSON_HOST = 7;
    public static final int FRS_CALL_FROM_PUSH = 13;
    public static final int FRS_CALL_FROM_SEARCH_SUG = 16;
    public static final int FRS_CALL_FROM_SQUARE = 5;
    public static final int FRS_CALL_FROM_TAB_RECOMMEND = 11;
    public static final int FRS_CALL_FROM_URL_JUMP = 12;
    public static final String FRS_CALL_SEARCH = "frs_call_search";
    public static final String FRS_CREATE_WITH_GAME = "create_with_game";
    public static final String FRS_FAKE_THREAD_ID = "frs_fake_thread_id";
    public static final String FRS_FROM_ENTERFORUM_RECOMMEND = "recom_flist";
    public static final String FRS_FROM_FLUTTER_BCASTEDIT = "bar_broadcast_edit";
    public static final String FRS_FROM_FOLLOWED_RECOMMEND = "followed_recommend_forumlist";
    public static final String FRS_FROM_FORUM_RULE_EDIT = "frs_from_forum_rule_edit";
    public static final String FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD = "frequently_forum_new_thread";
    public static final String FRS_FROM_FREQUENTLY_FORUM_POST_THREAD = "frequently_forum_post_thread";
    public static final String FRS_FROM_IM_REC_FORUM = "frs_from_im_rec_forum";
    public static final String FRS_FROM_ITEM = "frs_from_item";
    public static final String FRS_FROM_MANGA_COVER = "form_manga_cover";
    public static final String FRS_FROM_PB = "tb_pb";
    public static final String FRS_FROM_RECENTLY_VISITED = "from_recently_visited";
    public static final String FRS_FROM_RECOMMEND = "dimension_door";
    public static final String FRS_FROM_RECOMMEND_BAR_CAR = "recommend_bar_card_forum";
    public static final String FRS_FROM_SEARCH = "tb_searchlist";
    public static final String FRS_FROM_SEARCH_SUG = "frs_from_search_sug";
    public static final String FRS_FROM_SQUARE = "from_square";
    public static final String FRS_FROM_SQUARE_HOT = "from_square_hot";
    public static final String FRS_FROM_SQUARE_RECOMMEND = "from_square_recommend";
    public static final String FRS_FROM_SQUARE_TOP = "from_square_top";
    public static final String FRS_FROM_TAB_RECOMMEND_FORUM = "tab_recommend_forum";
    public static final String FRS_FROM_WRITESHARE = "tb_write_share";
    public static final String FRS_GAME_DEFAULT_TAB_ID = "frs_game_default_tab_id";
    public static final String FRS_HOT_THREAD_ID = "frs_hot_thread_id";
    public static final String FRS_PAGE_ID = "frs_page_id";
    public static final String FRS_PB_CARD_GIFT = "tb_pb_card_gift";
    public static final String GOOD = "good";
    public static final String IS_SHOW_IM_GROUP_LIST = "is_show_im_group_list";
    public static final String KEY_ACHIEVEMENT_URL = "key_achievement_url";
    public static final String KEY_FPS_FRS = "BaToFrs_frs_tran";
    public static final String KEY_FPS_FRS_FROM = "BaToFrs";
    public static final String KEY_FPS_FRS_PAGE = "frs";
    public static final String KEY_FPS_FRS_TYPE = "tran";
    public static final String KEY_JUMP_TAB_ID = "key_jump_tab_id";
    public static final String KEY_REFRESH = "refresh_all";
    public static final String LOCATE_ROOM_ID = "locate_roomid";
    public static final String NAME = "name";
    public static final int READ_CHAT = 1;
    public static final int READ_REPLYORAT = 0;
    public static final String ROOM_ID = "room_id";
    public static final String TOAST_DATA = "toast_data";
    public static final String YUELAOU_LOCATE = "yuelaou_locate";
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId mPageId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        BdUniqueId gen = BdUniqueId.gen();
        this.mPageId = gen;
        intent.putExtra(FRS_PAGE_ID, gen);
        df9.b("frs");
    }

    public FrsActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return createBackSpecialCfg(str, str2, z, z2, false);
        }
        return (FrsActivityConfig) invokeCommon.objValue;
    }

    public FrsActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            Intent intent = getIntent();
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra("back_special", z);
            intent.putExtra(GOOD, z2);
            intent.putExtra(FOLLOWED_HAS_NEW, z3);
            if (!(getContext() instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            return this;
        }
        return (FrsActivityConfig) invokeCommon.objValue;
    }

    public FrsActivityConfig createCfgForpersonalized(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3)) == null) {
            Intent intent = getIntent();
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra("back_special", false);
            intent.putExtra(GOOD, false);
            intent.putExtra("yuelaou_locate", str3);
            if (!(getContext() instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            return this;
        }
        return (FrsActivityConfig) invokeLLL.objValue;
    }

    public FrsActivityConfig createJumpLiveTabCfg(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, str, str2, z)) == null) {
            Intent intent = getIntent();
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra("back_special", false);
            intent.putExtra(GOOD, false);
            intent.putExtra(FOLLOWED_HAS_NEW, false);
            intent.putExtra(ALA_IS_ONLIVING, z);
            if (!(getContext() instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            return this;
        }
        return (FrsActivityConfig) invokeLLZ.objValue;
    }

    public FrsActivityConfig createNormalCfg(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            return createBackSpecialCfg(str, str2, false, false);
        }
        return (FrsActivityConfig) invokeLL.objValue;
    }

    public FrsActivityConfig createNormalCfg(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, str, str2, z)) == null) {
            return createBackSpecialCfg(str, str2, false, false, z);
        }
        return (FrsActivityConfig) invokeLLZ.objValue;
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public void preJump() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("name");
            String stringExtra2 = intent.getStringExtra("from");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            if (uri != null) {
                stringExtra = uri.getQueryParameter("name");
                stringExtra2 = uri.getQueryParameter("from");
                if (StringUtils.isNull(stringExtra)) {
                    stringExtra = uri.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
                }
            }
            int intExtra = intent.getIntExtra(FRS_CALL_FROM, 0);
            long longExtra = intent.getLongExtra(FRS_HOT_THREAD_ID, 0L);
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            if (TextUtils.isEmpty(stringExtra3)) {
                stringExtra3 = "";
            }
            int i2 = -1;
            FrsRequestData frsRequestData = new FrsRequestData();
            if (FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(stringExtra2)) {
                i2 = 3;
            } else if (FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(stringExtra2)) {
                i2 = 6;
            }
            if (UbsABTestHelper.isFrsNewAreaTabSortTestA() && FrsTabTestHelper.HAVE_NOT_RECORD_SORT != FrsTabTestHelper.getFrsNewAreaTabSort()) {
                frsRequestData.c0(oi7.d(FrsTabTestHelper.getFrsNewAreaTabSort()));
            }
            frsRequestData.setSortType(oi7.d(i2));
            if (i2 == 5) {
                frsRequestData.f0(1);
            } else {
                frsRequestData.f0(0);
            }
            frsRequestData.Q("forum_name", hi.getUrlEncode(stringExtra));
            frsRequestData.Q("client_type", "2");
            frsRequestData.setPn(1);
            frsRequestData.setCallFrom(intExtra);
            oi7.e(i2, frsRequestData);
            frsRequestData.n0("2");
            frsRequestData.o0("-2");
            frsRequestData.h0(stringExtra);
            frsRequestData.v0(1);
            frsRequestData.Z(0);
            frsRequestData.u0(ii.l(TbadkCoreApplication.getInst()));
            frsRequestData.t0(ii.j(TbadkCoreApplication.getInst()));
            frsRequestData.s0(ii.i(TbadkCoreApplication.getInst()));
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            frsRequestData.x0(i);
            if (uri != null) {
                frsRequestData.r0(uri.toString());
            }
            frsRequestData.j0(null);
            frsRequestData.w0(stringExtra3);
            frsRequestData.i0(gg.g(yq5.a(), 0L));
            frsRequestData.setStType(stringExtra2);
            frsRequestData.e0(1);
            frsRequestData.setNeedCache(true);
            frsRequestData.setUpdateType(3);
            frsRequestData.d0(longExtra);
            oi7.e(i2, frsRequestData);
            frsRequestData.l0(1);
            frsRequestData.setPushTid(intent.getStringExtra(MainTabActivityConfig.PUSH_TID));
            if (ThreadData.isRecAppLoaded.get() && va9.l().b() != null) {
                int d = va9.l().b().d(stringExtra, false);
                int e = va9.l().b().e(stringExtra, false);
                if (frsRequestData.V() == 1) {
                    d++;
                } else if (frsRequestData.V() == 2) {
                    e++;
                }
                frsRequestData.p0(d);
                frsRequestData.k0(e);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, frsRequestData);
            frsNetModel.setUniqueId(this.mPageId);
            frsNetModel.s0(frsNetModel);
            TbadkCoreApplication.getInst().getFrsModeArray().put(this.mPageId.getId(), frsNetModel);
            frsNetModel.loadData();
            frsRequestData.setPushTid(null);
        }
    }

    public void setAchievementUrl(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_ACHIEVEMENT_URL, str);
        }
    }

    public FrsActivityConfig setCallFrom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            getIntent().putExtra(FRS_CALL_FROM, i);
            return this;
        }
        return (FrsActivityConfig) invokeI.objValue;
    }

    public FrsActivityConfig setDefaultGameTabId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            getIntent().putExtra(FRS_GAME_DEFAULT_TAB_ID, i);
            return this;
        }
        return (FrsActivityConfig) invokeI.objValue;
    }

    public FrsActivityConfig setFakeThreadId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            getIntent().putExtra(FRS_FAKE_THREAD_ID, j);
            return this;
        }
        return (FrsActivityConfig) invokeJ.objValue;
    }

    public void setFrsCallFromByItemPosition(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra(FRS_CALL_FROM_BY_ITEM_POSITION, i);
        }
    }

    public void setGroupListLocateRoomId(long j) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048588, this, j) == null) && (intent = getIntent()) != null) {
            intent.putExtra(LOCATE_ROOM_ID, j);
        }
    }

    public void setIsShowImGroupList(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && (intent = getIntent()) != null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            intent.putExtra(IS_SHOW_IM_GROUP_LIST, z);
        }
    }

    public void setJumpTabId(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_JUMP_TAB_ID, i);
        }
    }

    public void setPushTid(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra(MainTabActivityConfig.PUSH_TID, str);
        }
    }

    public void setRoomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            getIntent().putExtra(LOCATE_ROOM_ID, j);
        }
    }

    public void setToastData(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra(TOAST_DATA, str);
        }
    }

    public void setUri(Uri uri) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, uri) == null) && (intent = getIntent()) != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }
}
