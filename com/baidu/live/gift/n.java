package com.baidu.live.gift;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
/* loaded from: classes4.dex */
public class n {
    public static boolean a(Context context, g gVar, int i, com.baidu.live.data.u uVar) {
        if (context == null || gVar == null || i <= 0 || uVar == null) {
            return false;
        }
        return true;
    }

    public static boolean a(TbPageContext tbPageContext, com.baidu.live.data.u uVar, g gVar, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || gVar == null || uVar == null || uVar.mLiveInfo == null || uVar.aFb == null) {
            return false;
        }
        if (gVar.EH()) {
            if (gVar.ED() == 6 && uVar.aFb.levelId < 3) {
                return false;
            }
            if (gVar.ED() == 7 && uVar.aFb.levelId < 7) {
                return false;
            }
            if (gVar.ED() == 8 && uVar.aFb.levelId < 13) {
                return false;
            }
            if (gVar.ED() == 9 && uVar.aFb.levelId < 22) {
                return false;
            }
            if (gVar.ED() == 10 && uVar.aFb.levelId < 29) {
                return false;
            }
            if (gVar.ED() == 11 && uVar.aFb.levelId < 39) {
                return false;
            }
            if (gVar.ED() == 12 && uVar.aFb.levelId < 47) {
                return false;
            }
        }
        if (a(tbPageContext.getPageActivity(), gVar, 1, uVar)) {
            if (gVar.Er()) {
                if (TbadkCoreApplication.getInst().currentAccountFlowerNum <= 0 || TbadkCoreApplication.getInst().currentAccountFlowerNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                    BdUtilHelper.showToast(tbPageContext.getPageActivity(), tbPageContext.getPageActivity().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                w.b(gVar, 1, uVar.aEz.userId + "", uVar.aEz.userName, uVar.mLiveInfo.live_id + "", uVar.mLiveInfo.room_id + "", uVar.mLiveInfo.appId + "", uVar.mLiveInfo.feed_id + "", str, 0L);
                a(gVar, uVar.mLiveInfo.feed_id, uVar.mLiveInfo.live_id + "", str);
            } else if (TbadkCoreApplication.getInst().currentAccountTdouNum <= 0 || TbadkCoreApplication.getInst().currentAccountTdouNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                a(tbPageContext, str);
                return false;
            } else {
                w.b(gVar, 1, uVar.aEz.userId + "", uVar.aEz.userName, uVar.mLiveInfo.live_id + "", uVar.mLiveInfo.room_id + "", uVar.mLiveInfo.appId + "", uVar.mLiveInfo.feed_id + "", str, 0L);
                a(gVar, uVar.mLiveInfo.feed_id, uVar.mLiveInfo.live_id + "", str);
            }
        }
        return true;
    }

    public static void a(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(tbPageContext.getPageActivity(), 0L, str, true, "quick_gift", true)));
        }
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private static void a(g gVar, String str, String str2, String str3) {
        if (gVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SUCCESS);
                alaStaticItem.addParams("gifts_value", gVar.getPrice());
                alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, gVar.Eh());
                alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, gVar.Ei());
                alaStaticItem.addParams("other_params", str3);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
