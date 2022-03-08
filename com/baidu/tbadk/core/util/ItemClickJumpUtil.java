package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u001a3\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0017\u001a\u001f\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0019\u001a\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"FRS_CALL_FROM_BY_ITEM_POSITION_CONCERN", "", "FRS_CALL_FROM_BY_ITEM_POSITION_FRS_FEED", "FRS_CALL_FROM_BY_ITEM_POSITION_FRS_OTHER_TAB", "FRS_CALL_FROM_BY_ITEM_POSITION_ITEM_DIRECT_SEARCH", "FRS_CALL_FROM_BY_ITEM_POSITION_NATIVE_CHANNEL", "FRS_CALL_FROM_BY_ITEM_POSITION_PB_ABSTRACT", "FRS_CALL_FROM_BY_ITEM_POSITION_PB_FIRST_FLOOR", "FRS_CALL_FROM_BY_ITEM_POSITION_RECOMMEND", "ITEM_SOURCE_CONCERN", "ITEM_SOURCE_DIRECT_SEARCH", "ITEM_SOURCE_DOWNLOAD_MANAGER_PAGE", "ITEM_SOURCE_FRS", "ITEM_SOURCE_HOME_PAGE", "ITEM_SOURCE_PB", "ITEM_SOURCE_PB_FIRST_FLOOR", "itemClickJump", "", "itemForumName", "", Transition.MATCH_ITEM_ID_STR, "source", "itemPosition", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "jumpToFrs", "(Ljava/lang/String;Ljava/lang/Integer;)V", "jumpToItemDetailPage", "tbadkcore_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "ItemClickJumpUtil")
/* loaded from: classes5.dex */
public final class ItemClickJumpUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRS_CALL_FROM_BY_ITEM_POSITION_CONCERN = 2;
    public static final int FRS_CALL_FROM_BY_ITEM_POSITION_FRS_FEED = 10;
    public static final int FRS_CALL_FROM_BY_ITEM_POSITION_FRS_OTHER_TAB = 13;
    public static final int FRS_CALL_FROM_BY_ITEM_POSITION_ITEM_DIRECT_SEARCH = 8;
    public static final int FRS_CALL_FROM_BY_ITEM_POSITION_NATIVE_CHANNEL = 4;
    public static final int FRS_CALL_FROM_BY_ITEM_POSITION_PB_ABSTRACT = 3;
    public static final int FRS_CALL_FROM_BY_ITEM_POSITION_PB_FIRST_FLOOR = 9;
    public static final int FRS_CALL_FROM_BY_ITEM_POSITION_RECOMMEND = 1;
    public static final int ITEM_SOURCE_CONCERN = 2;
    public static final int ITEM_SOURCE_DIRECT_SEARCH = 8;
    public static final int ITEM_SOURCE_DOWNLOAD_MANAGER_PAGE = 15;
    public static final int ITEM_SOURCE_FRS = 10;
    public static final int ITEM_SOURCE_HOME_PAGE = 1;
    public static final int ITEM_SOURCE_PB = 3;
    public static final int ITEM_SOURCE_PB_FIRST_FLOOR = 9;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmOverloads
    public static final void itemClickJump(String str, String itemId, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, str, itemId, i2) == null) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            itemClickJump$default(str, itemId, i2, null, 8, null);
        }
    }

    @JvmOverloads
    public static final void itemClickJump(String str, String itemId, int i2, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, str, itemId, i2, num) == null) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            if (str == null || str.length() == 0) {
                jumpToItemDetailPage(itemId, i2);
            } else {
                jumpToFrs(str, num);
            }
        }
    }

    public static /* synthetic */ void itemClickJump$default(String str, String str2, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            num = null;
        }
        itemClickJump(str, str2, i2, num);
    }

    public static final void jumpToFrs(String str, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, num) == null) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(TbadkApplication.getInst().getContext()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ITEM);
            if (num != null) {
                createNormalCfg.setFrsCallFromByItemPosition(num.intValue());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    public static final void jumpToItemDetailPage(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2) == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("itemID", str);
            hashMap.put("source", Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
        }
    }
}
