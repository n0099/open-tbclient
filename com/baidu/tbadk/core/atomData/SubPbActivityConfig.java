package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class SubPbActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ICON_LIST = "icon_list";
    public static final String KEY_ANTI = "anti";
    public static final String KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM = "key_deleted_reason_info_is_gray_cale_forum";
    public static final String KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW = "key_deleted_reason_info_is_boom_grow";
    public static final String KEY_FORUM_HEAD_URL = "key_forum_head_url";
    public static final String KEY_FROM_FORUM_ID = "from_forum_id";
    public static final String KEY_FROM_FRS_FORUM_ID = "from_frs_forum_id";
    public static final String KEY_FROM_VIDEO_PAGE_ID = "key_from_video_page_id";
    public static final String KEY_HAS_FORUM_RULE = "key_has_forum_rule";
    public static final String KEY_HIGH_LIGHT_POST_ID = "high_light_post_id";
    public static final String KEY_IMG_URLS = "img_urls";
    public static final String KEY_IS_FROM_DYNAMIC = "key_is_from_dynamic";
    public static final String KEY_IS_FROM_SCHEMA = "is_from_schema";
    public static final String KEY_IS_JUMP_FROM_PB = "is_jump_from_pb";
    public static final String KEY_IS_JUMP_FROM_VIDEO_TAB = "is_jump_from_video_tab";
    public static final String KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD = "video_tab_child";
    public static final String KEY_IS_MANAGER = "key_is_manager";
    public static final String KEY_IS_OPEN_EDITOR = "key_is_open_editor";
    public static final String KEY_IS_SHOW_GO_TO_SUBJECT = "is_show_go_to_subject";
    public static final String KEY_IS_TIEBA_PLUS = "key_is_tieba_plus";
    public static final String KEY_IS_USE_SPID = "key_is_use_spid";
    public static final String KEY_MAIN_POST_MASK_VISIBLE = "key_main_post_mask_visible";
    public static final String KEY_OPEN_EDITOR_TIPS = "key_open_editor_tips";
    public static final String KEY_ORI_UGC_NID = "key_ori_ugc_nid";
    public static final String KEY_ORI_UGC_TID = "key_ori_ugc_tid";
    public static final String KEY_ORI_UGC_TOP_PID = "key_ori_ugc_top_pid";
    public static final String KEY_ORI_UGC_TYPE = "key_ori_ugc_type";
    public static final String KEY_ORI_UGC_VID = "key_ori_ugc_vid";
    public static final String KEY_PAGE_START_FROM = "page_start_from";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_REPLAY_NAME = "replay_name";
    public static final String KEY_REPLAY_POST_ID = "replay_post_id";
    public static final String KEY_SHOW_KEYBOARD = "show_keyboard";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_TAIL = "post_tail";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_TIEBA_PLUS_CANT_DELETE = "key_tieba_plus_cant_delete";
    public static final String KEY_TIEBA_PLUS_EXTRA_PARAM = "key_tieba_extra_param";
    public static final String KEY_TIEBA_PLUS_ORDER_ID = "key_tieba_plus_order_id";
    public static final String KEY_TIEBA_PLUS_TOKEN = "key_tieba_plus_token";
    public static final String KEY_USER_IDENTITY = "user_identity";
    public static final String KEY_USER_LEVEL = "key_user_level";
    public static final String KEY_WORKS_INFO_DATA = "key_works_info_data";
    public static final String SUB_KEY_IMG_CDN = "sub_img_cdn";
    public static final String SUB_KEY_IMG_OFFSET = "sub_img_offset";
    public static final String SUB_KEY_IMG_SRC = "sub_img_src";
    public static final String SUB_KEY_IMG_URL = "sub_img_url";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public SubPbActivityConfig addBigImageData(ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{arrayList, concurrentHashMap, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (concurrentHashMap != null && arrayList != null) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                ArrayList<String> arrayList2 = new ArrayList<>(concurrentHashMap.keySet());
                bundle.putStringArrayList(SUB_KEY_IMG_URL, arrayList2);
                bundle.putBoolean(SUB_KEY_IMG_CDN, z);
                bundle.putStringArrayList(SUB_KEY_IMG_SRC, arrayList);
                Iterator<String> it = arrayList2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        bundle.putSerializable(next, concurrentHashMap.get(next));
                    }
                }
                bundle.putInt(SUB_KEY_IMG_OFFSET, i2);
                intent.putExtra(KEY_IMG_URLS, bundle);
            }
            return this;
        }
        return (SubPbActivityConfig) invokeCommon.objValue;
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? createSubPbActivityConfig(str, str2, str3, z, null, false, null, 0, null, null, z2) : (SubPbActivityConfig) invokeCommon.objValue;
    }

    public void setBjhData(BaijiahaoData baijiahaoData) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baijiahaoData) == null) || (intent = getIntent()) == null || baijiahaoData == null) {
            return;
        }
        int i2 = baijiahaoData.oriUgcType;
        boolean z = true;
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            z = false;
        }
        intent.putExtra("key_is_from_dynamic", z);
        intent.putExtra("key_ori_ugc_nid", baijiahaoData.oriUgcNid);
        intent.putExtra("key_ori_ugc_tid", baijiahaoData.oriUgcTid);
        intent.putExtra("key_ori_ugc_type", baijiahaoData.oriUgcType);
        intent.putExtra("key_ori_ugc_vid", baijiahaoData.oriUgcVid);
    }

    public void setDeletedReasonInfoIsGrayCaleForum(int i2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, i2);
    }

    public void setDeletedReasonInfoIsIsBoomGrow(int i2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, i2);
    }

    public void setForumHeadUrl(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_FORUM_HEAD_URL, str);
    }

    public void setFromFrsForumId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_FROM_FRS_FORUM_ID, str);
    }

    public void setFromVideoPageUniqueId(BdUniqueId bdUniqueId) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("key_from_video_page_id", bdUniqueId);
    }

    public void setHasForumRule(int i2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_HAS_FORUM_RULE, i2);
    }

    public void setHighLightPostId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("high_light_post_id", str);
    }

    public void setIsFromeSchema(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_IS_FROM_SCHEMA, z);
    }

    public void setIsManager(int i2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_IS_MANAGER, i2);
    }

    public void setIsOpenEditor(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_IS_OPEN_EDITOR, z);
    }

    public void setKeyFromForumId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("from_forum_id", str);
    }

    public void setKeyIsUseSpid(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_IS_USE_SPID, z);
    }

    public void setKeyOriUgcTopPid(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_ORI_UGC_TOP_PID, str);
    }

    public void setKeyPageStartFrom(int i2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_PAGE_START_FROM, i2);
    }

    public void setMainPostMaskVisibly(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_MAIN_POST_MASK_VISIBLE, z);
    }

    public void setTiebaPlusData(boolean z, String str, String str2, String str3, boolean z2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), str, str2, str3, Boolean.valueOf(z2)}) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("key_is_tieba_plus", z);
        intent.putExtra("key_tieba_plus_order_id", str);
        intent.putExtra("key_tieba_plus_token", str2);
        intent.putExtra("key_tieba_extra_param", str3);
        intent.putExtra("key_tieba_plus_cant_delete", z2);
    }

    public void setUserLevel(int i2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_FORUM_HEAD_URL, i2);
    }

    public void setWorksInfoData(@Nullable WorksInfoData worksInfoData) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, worksInfoData) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_WORKS_INFO_DATA, (Serializable) worksInfoData);
    }

    public void showOpenEditorTips(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("key_open_editor_tips", str);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) ? createSubPbActivityConfig(str, str2, str3, z, null, false) : (SubPbActivityConfig) invokeCommon.objValue;
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, Boolean.valueOf(z2)})) == null) ? createSubPbActivityConfig(str, str2, str3, z, str4, z2, null, 0) : (SubPbActivityConfig) invokeCommon.objValue;
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, Boolean.valueOf(z2), str5, Integer.valueOf(i2)})) == null) ? createSubPbActivityConfig(str, str2, str3, z, str4, z2, str5, i2, null) : (SubPbActivityConfig) invokeCommon.objValue;
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i2, SmallTailInfo smallTailInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, Boolean.valueOf(z2), str5, Integer.valueOf(i2), smallTailInfo})) == null) ? createSubPbActivityConfig(str, str2, str3, z, str4, z2, str5, i2, null, null, false) : (SubPbActivityConfig) invokeCommon.objValue;
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i2, SmallTailInfo smallTailInfo, AntiData antiData, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, Boolean.valueOf(z2), str5, Integer.valueOf(i2), smallTailInfo, antiData, Boolean.valueOf(z3)})) == null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra(KEY_IS_JUMP_FROM_PB, z);
            intent.putExtra(KEY_SHOW_KEYBOARD, z2);
            intent.putExtra(KEY_REPLAY_NAME, str4);
            intent.putExtra(KEY_REPLAY_POST_ID, str5);
            intent.putExtra(KEY_USER_IDENTITY, i2);
            intent.putExtra(KEY_TAIL, smallTailInfo);
            intent.putExtra(KEY_ANTI, antiData);
            intent.putExtra(KEY_IS_SHOW_GO_TO_SUBJECT, z3);
            return this;
        }
        return (SubPbActivityConfig) invokeCommon.objValue;
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, boolean z2, String str4, boolean z3, String str5, int i2, SmallTailInfo smallTailInfo, AntiData antiData, boolean z4, ArrayList<IconData> arrayList, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), str4, Boolean.valueOf(z3), str5, Integer.valueOf(i2), smallTailInfo, antiData, Boolean.valueOf(z4), arrayList, Integer.valueOf(i3)})) == null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra(KEY_IS_JUMP_FROM_PB, z);
            intent.putExtra(KEY_SHOW_KEYBOARD, z3);
            intent.putExtra(KEY_REPLAY_NAME, str4);
            intent.putExtra(KEY_REPLAY_POST_ID, str5);
            intent.putExtra(KEY_USER_IDENTITY, i2);
            intent.putExtra(KEY_TAIL, smallTailInfo);
            intent.putExtra(KEY_ANTI, antiData);
            intent.putExtra(ICON_LIST, arrayList);
            intent.putExtra(KEY_IS_SHOW_GO_TO_SUBJECT, z4);
            intent.putExtra(KEY_IS_JUMP_FROM_VIDEO_TAB, z2);
            intent.putExtra(KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, i3);
            return this;
        }
        return (SubPbActivityConfig) invokeCommon.objValue;
    }
}
