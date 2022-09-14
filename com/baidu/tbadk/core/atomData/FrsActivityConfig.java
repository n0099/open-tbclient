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
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.md8;
import com.baidu.tieba.nh5;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.xs6;
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
    public static final String KEY_ACHIEVEMENT_URL = "key_achievement_url";
    public static final String KEY_FPS_FRS = "BaToFrs_frs_tran";
    public static final String KEY_FPS_FRS_FROM = "BaToFrs";
    public static final String KEY_FPS_FRS_PAGE = "frs";
    public static final String KEY_FPS_FRS_TYPE = "tran";
    public static final String KEY_REFRESH = "refresh_all";
    public static final String NAME = "name";
    public static final int READ_CHAT = 1;
    public static final int READ_REPLYORAT = 0;
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
    }

    public FrsActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? createBackSpecialCfg(str, str2, z, z2, false) : (FrsActivityConfig) invokeCommon.objValue;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) ? createBackSpecialCfg(str, str2, false, false) : (FrsActivityConfig) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public void preJump() {
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
            int i = -1;
            FrsRequestData frsRequestData = new FrsRequestData();
            if (FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(stringExtra2)) {
                i = 3;
            } else if (FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(stringExtra2)) {
                i = 6;
            }
            if (UbsABTestHelper.isFrsNewAreaTabSortTestA() && FrsTabTestHelper.HAVE_NOT_RECORD_SORT != FrsTabTestHelper.getFrsNewAreaTabSort()) {
                frsRequestData.L(xs6.d(FrsTabTestHelper.getFrsNewAreaTabSort()));
            }
            frsRequestData.setSortType(xs6.d(i));
            if (i == 5) {
                frsRequestData.O(1);
            } else {
                frsRequestData.O(0);
            }
            frsRequestData.z("forum_name", dj.getUrlEncode(stringExtra));
            frsRequestData.z("client_type", "2");
            frsRequestData.setPn(1);
            frsRequestData.setCallFrom(intExtra);
            xs6.e(i, frsRequestData);
            frsRequestData.W("2");
            frsRequestData.X("-2");
            frsRequestData.Q(stringExtra);
            frsRequestData.e0(1);
            frsRequestData.I(0);
            frsRequestData.d0(ej.k(TbadkCoreApplication.getInst()));
            frsRequestData.c0(ej.i(TbadkCoreApplication.getInst()));
            frsRequestData.b0(ej.h(TbadkCoreApplication.getInst()));
            frsRequestData.g0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            if (uri != null) {
                frsRequestData.a0(uri.toString());
            }
            frsRequestData.S(null);
            frsRequestData.f0(stringExtra3);
            frsRequestData.R(dh.g(nh5.a(), 0L));
            frsRequestData.setStType(stringExtra2);
            frsRequestData.N(1);
            frsRequestData.setNeedCache(true);
            frsRequestData.setUpdateType(3);
            frsRequestData.M(longExtra);
            xs6.e(i, frsRequestData);
            frsRequestData.U(1);
            frsRequestData.setPushTid(intent.getStringExtra(MainTabActivityConfig.PUSH_TID));
            if (ThreadData.isRecAppLoaded.get() && md8.l().b() != null) {
                int d = md8.l().b().d(stringExtra, false);
                int e = md8.l().b().e(stringExtra, false);
                if (frsRequestData.E() == 1) {
                    d++;
                } else if (frsRequestData.E() == 2) {
                    e++;
                }
                frsRequestData.Y(d);
                frsRequestData.T(e);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, frsRequestData);
            frsNetModel.setUniqueId(this.mPageId);
            frsNetModel.b0(frsNetModel);
            TbadkCoreApplication.getInst().getFrsModeArray().put(this.mPageId.getId(), frsNetModel);
            frsNetModel.loadData();
            frsRequestData.setPushTid(null);
        }
    }

    public void setAchievementUrl(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_ACHIEVEMENT_URL, str);
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
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(FRS_CALL_FROM_BY_ITEM_POSITION, i);
    }

    public void setPushTid(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(MainTabActivityConfig.PUSH_TID, str);
    }

    public void setUri(Uri uri) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, uri) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(IntentConfig.KEY_URI, uri);
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

    public FrsActivityConfig createNormalCfg(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, str, str2, z)) == null) ? createBackSpecialCfg(str, str2, false, false, z) : (FrsActivityConfig) invokeLLZ.objValue;
    }
}
