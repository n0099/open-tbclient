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
    public static boolean a(Context context, g gVar, int i, com.baidu.live.data.w wVar) {
        if (context == null || gVar == null || i <= 0 || wVar == null) {
            return false;
        }
        return true;
    }

    public static boolean a(TbPageContext tbPageContext, com.baidu.live.data.w wVar, g gVar, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || gVar == null || wVar == null || wVar.mLiveInfo == null || wVar.aIA == null) {
            return false;
        }
        if (gVar.FS()) {
            if (gVar.FO() == 6 && wVar.aIA.levelId < 3) {
                return false;
            }
            if (gVar.FO() == 7 && wVar.aIA.levelId < 7) {
                return false;
            }
            if (gVar.FO() == 8 && wVar.aIA.levelId < 13) {
                return false;
            }
            if (gVar.FO() == 9 && wVar.aIA.levelId < 22) {
                return false;
            }
            if (gVar.FO() == 10 && wVar.aIA.levelId < 29) {
                return false;
            }
            if (gVar.FO() == 11 && wVar.aIA.levelId < 39) {
                return false;
            }
            if (gVar.FO() == 12 && wVar.aIA.levelId < 47) {
                return false;
            }
        }
        if (a(tbPageContext.getPageActivity(), gVar, 1, wVar)) {
            if (gVar.FC()) {
                if (TbadkCoreApplication.getInst().currentAccountFlowerNum <= 0 || TbadkCoreApplication.getInst().currentAccountFlowerNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                    BdUtilHelper.showToast(tbPageContext.getPageActivity(), tbPageContext.getPageActivity().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                ab.b(gVar, 1, wVar.aIe.userId + "", wVar.aIe.userName, wVar.mLiveInfo.live_id + "", wVar.mLiveInfo.room_id + "", wVar.mLiveInfo.appId + "", wVar.mLiveInfo.feed_id + "", str, 0L);
                a(gVar, wVar.mLiveInfo.feed_id, wVar.mLiveInfo.live_id + "", str);
            } else if (TbadkCoreApplication.getInst().currentAccountTdouNum <= 0 || TbadkCoreApplication.getInst().currentAccountTdouNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                a(tbPageContext, str);
                return false;
            } else {
                ab.b(gVar, 1, wVar.aIe.userId + "", wVar.aIe.userName, wVar.mLiveInfo.live_id + "", wVar.mLiveInfo.room_id + "", wVar.mLiveInfo.appId + "", wVar.mLiveInfo.feed_id + "", str, 0L);
                a(gVar, wVar.mLiveInfo.feed_id, wVar.mLiveInfo.live_id + "", str);
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
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SUCCESS);
                alaStaticItem.addParams("gifts_value", gVar.getPrice());
                alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, gVar.Fs());
                alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, gVar.Ft());
                alaStaticItem.addParams("other_params", str3);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
