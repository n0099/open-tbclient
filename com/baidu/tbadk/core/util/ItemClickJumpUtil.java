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
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u001a?\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0018\u001a\u001d\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"FRS_CALL_FROM_BY_ITEM_POSITION_CONCERN", "", "FRS_CALL_FROM_BY_ITEM_POSITION_FRS_FEED", "FRS_CALL_FROM_BY_ITEM_POSITION_FRS_OTHER_TAB", "FRS_CALL_FROM_BY_ITEM_POSITION_ITEM_DIRECT_SEARCH", "FRS_CALL_FROM_BY_ITEM_POSITION_NATIVE_CHANNEL", "FRS_CALL_FROM_BY_ITEM_POSITION_PB_ABSTRACT", "FRS_CALL_FROM_BY_ITEM_POSITION_PB_FIRST_FLOOR", "FRS_CALL_FROM_BY_ITEM_POSITION_RECOMMEND", "ITEM_SOURCE_CONCERN", "ITEM_SOURCE_DIRECT_SEARCH", "ITEM_SOURCE_DOWNLOAD_MANAGER_PAGE", "ITEM_SOURCE_FRS", "ITEM_SOURCE_HOME_PAGE", "ITEM_SOURCE_PB", "ITEM_SOURCE_PB_FIRST_FLOOR", "itemClickJump", "", "itemForumName", "", Transition.MATCH_ITEM_ID_STR, "source", "itemPosition", "schemeLink", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;)V", "jumpToFrs", "(Ljava/lang/String;Ljava/lang/Integer;)V", "jumpToItemDetailPage", "tbadkcore_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "ItemClickJumpUtil")
/* loaded from: classes3.dex */
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
    public static final void itemClickJump(String str, String itemId, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, str, itemId, i) == null) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            itemClickJump$default(str, itemId, i, null, null, 24, null);
        }
    }

    @JvmOverloads
    public static final void itemClickJump(String str, String itemId, int i, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, str, itemId, i, num) == null) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            itemClickJump$default(str, itemId, i, num, null, 16, null);
        }
    }

    @JvmOverloads
    public static final void itemClickJump(String str, String itemId, int i, Integer num, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, itemId, Integer.valueOf(i), num, str2}) == null) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            boolean z2 = false;
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                UrlManager.getInstance().dealOneLink(str2);
                return;
            }
            if ((str == null || str.length() == 0) ? true : true) {
                jumpToItemDetailPage(itemId, i);
            } else {
                jumpToFrs(str, num);
            }
        }
    }

    public static /* synthetic */ void itemClickJump$default(String str, String str2, int i, Integer num, String str3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num = null;
        }
        if ((i2 & 16) != 0) {
            str3 = "";
        }
        itemClickJump(str, str2, i, num, str3);
    }

    public static final void jumpToFrs(String itemForumName, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, itemForumName, num) == null) {
            Intrinsics.checkNotNullParameter(itemForumName, "itemForumName");
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(TbadkApplication.getInst().getContext()).createNormalCfg(itemForumName, FrsActivityConfig.FRS_FROM_ITEM);
            if (num != null) {
                createNormalCfg.setFrsCallFromByItemPosition(num.intValue());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    public static final void jumpToItemDetailPage(String itemId, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, itemId, i) == null) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            HashMap hashMap = new HashMap(1);
            hashMap.put("itemID", itemId);
            hashMap.put("source", Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
        }
    }
}
