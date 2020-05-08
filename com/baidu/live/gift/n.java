package com.baidu.live.gift;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class n {
    public static boolean a(Context context, g gVar, int i, com.baidu.live.data.n nVar) {
        if (context == null || gVar == null || i <= 0 || nVar == null) {
            return false;
        }
        return true;
    }

    public static boolean a(TbPageContext tbPageContext, com.baidu.live.data.n nVar, g gVar, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || gVar == null || nVar == null || nVar.mLiveInfo == null || nVar.aqD == null) {
            return false;
        }
        if (gVar.wu()) {
            if (gVar.wq() == 6 && nVar.aqD.levelId < 3) {
                return false;
            }
            if (gVar.wq() == 7 && nVar.aqD.levelId < 7) {
                return false;
            }
            if (gVar.wq() == 8 && nVar.aqD.levelId < 13) {
                return false;
            }
            if (gVar.wq() == 9 && nVar.aqD.levelId < 22) {
                return false;
            }
            if (gVar.wq() == 10 && nVar.aqD.levelId < 29) {
                return false;
            }
            if (gVar.wq() == 11 && nVar.aqD.levelId < 39) {
                return false;
            }
            if (gVar.wq() == 12 && nVar.aqD.levelId < 47) {
                return false;
            }
        }
        if (a(tbPageContext.getPageActivity(), gVar, 1, nVar)) {
            if (gVar.wf()) {
                if (TbadkCoreApplication.getInst().currentAccountFlowerNum <= 0 || TbadkCoreApplication.getInst().currentAccountFlowerNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                    BdUtilHelper.showToast(tbPageContext.getPageActivity(), tbPageContext.getPageActivity().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                u.b(gVar, 1, nVar.aqk.userId + "", nVar.aqk.userName, nVar.mLiveInfo.live_id + "", nVar.mLiveInfo.room_id + "", nVar.mLiveInfo.appId + "", nVar.mLiveInfo.feed_id + "", str, 0L);
                a(gVar, nVar.mLiveInfo.feed_id, nVar.mLiveInfo.live_id + "", str);
            } else if (TbadkCoreApplication.getInst().currentAccountTdouNum <= 0 || TbadkCoreApplication.getInst().currentAccountTdouNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                a(tbPageContext, str);
                return false;
            } else {
                u.b(gVar, 1, nVar.aqk.userId + "", nVar.aqk.userName, nVar.mLiveInfo.live_id + "", nVar.mLiveInfo.room_id + "", nVar.mLiveInfo.appId + "", nVar.mLiveInfo.feed_id + "", str, 0L);
                a(gVar, nVar.mLiveInfo.feed_id, nVar.mLiveInfo.live_id + "", str);
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
                alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, gVar.vU());
                alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, gVar.vV());
                alaStaticItem.addParams("other_params", str3);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
