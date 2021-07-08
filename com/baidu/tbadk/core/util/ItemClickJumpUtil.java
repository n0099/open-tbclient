package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.h3.h0.m;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\u001a5\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e\"\u0016\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e\"\u0016\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e\"\u0016\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000e\"\u0016\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e\"\u0016\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000e\"\u0016\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000e\"\u0016\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000e\"\u0016\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000e\"\u0016\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000e\"\u0016\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000e\"\u0016\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u000e\"\u0016\u0010\u001b\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u000e¨\u0006\u001c"}, d2 = {"", "itemForumName", Transition.MATCH_ITEM_ID_STR, "", "source", "itemPosition", "", "itemClickJump", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "jumpToFrs", "(Ljava/lang/String;Ljava/lang/Integer;)V", "jumpToItemDetailPage", "(Ljava/lang/String;I)V", "FRS_CALL_FROM_BY_ITEM_POSITION_CONCERN", "I", "FRS_CALL_FROM_BY_ITEM_POSITION_FRS_FEED", "FRS_CALL_FROM_BY_ITEM_POSITION_FRS_OTHER_TAB", "FRS_CALL_FROM_BY_ITEM_POSITION_ITEM_DIRECT_SEARCH", "FRS_CALL_FROM_BY_ITEM_POSITION_NATIVE_CHANNEL", "FRS_CALL_FROM_BY_ITEM_POSITION_PB_ABSTRACT", "FRS_CALL_FROM_BY_ITEM_POSITION_PB_FIRST_FLOOR", "FRS_CALL_FROM_BY_ITEM_POSITION_RECOMMEND", "ITEM_SOURCE_CONCERN", "ITEM_SOURCE_DIRECT_SEARCH", "ITEM_SOURCE_FRS", "ITEM_SOURCE_HOME_PAGE", "ITEM_SOURCE_PB", "ITEM_SOURCE_PB_FIRST_FLOOR", "tbadkcore_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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
    public static final int ITEM_SOURCE_FRS = 10;
    public static final int ITEM_SOURCE_HOME_PAGE = 1;
    public static final int ITEM_SOURCE_PB = 3;
    public static final int ITEM_SOURCE_PB_FIRST_FLOOR = 9;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmOverloads
    public static final void itemClickJump(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, str, str2, i2) == null) {
            itemClickJump$default(str, str2, i2, null, 8, null);
        }
    }

    @JvmOverloads
    public static final void itemClickJump(String str, String str2, int i2, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, str, str2, i2, num) == null) {
            if (str == null || str.length() == 0) {
                jumpToItemDetailPage(str2, i2);
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
            TbadkApplication inst = TbadkApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkApplication.getInst()");
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(inst.getContext()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ITEM);
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
            MessageManager messageManager = MessageManager.getInstance();
            TbadkApplication inst = TbadkApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkApplication.getInst()");
            messageManager.sendMessage(new CustomMessage(2002015, new m(inst.getApplicationContext(), "GameItemDetailsPage", hashMap)));
        }
    }
}
