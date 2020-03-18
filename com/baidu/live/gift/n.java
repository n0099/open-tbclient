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
    public static void showToast(Context context, int i) {
        BdUtilHelper.showToast(context, i);
    }

    public static boolean a(Context context, g gVar, int i, com.baidu.live.data.m mVar) {
        if (context == null || gVar == null || i <= 0 || mVar == null) {
            return false;
        }
        if (mVar.Yo.isBlock == 2) {
            showToast(context, a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (mVar.Yo.isBlock == 1) {
            showToast(context, a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.rI();
            return true;
        }
    }

    public static boolean a(TbPageContext tbPageContext, com.baidu.live.data.m mVar, g gVar, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || gVar == null || mVar == null || mVar.mLiveInfo == null || mVar.Yo == null) {
            return false;
        }
        if (gVar.sc()) {
            if (gVar.rY() == 6 && mVar.Yo.levelId < 3) {
                return false;
            }
            if (gVar.rY() == 7 && mVar.Yo.levelId < 7) {
                return false;
            }
            if (gVar.rY() == 8 && mVar.Yo.levelId < 13) {
                return false;
            }
            if (gVar.rY() == 9 && mVar.Yo.levelId < 22) {
                return false;
            }
            if (gVar.rY() == 10 && mVar.Yo.levelId < 29) {
                return false;
            }
            if (gVar.rY() == 11 && mVar.Yo.levelId < 39) {
                return false;
            }
            if (gVar.rY() == 12 && mVar.Yo.levelId < 47) {
                return false;
            }
        }
        if (a(tbPageContext.getPageActivity(), gVar, 1, mVar)) {
            if (gVar.rN()) {
                if (TbadkCoreApplication.getInst().currentAccountFlowerNum <= 0 || TbadkCoreApplication.getInst().currentAccountFlowerNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                    BdUtilHelper.showToast(tbPageContext.getPageActivity(), tbPageContext.getPageActivity().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                t.b(gVar, 1, mVar.Ya.userId + "", mVar.Ya.userName, mVar.mLiveInfo.live_id + "", mVar.mLiveInfo.room_id + "", mVar.mLiveInfo.appId + "", mVar.mLiveInfo.feed_id + "", str);
                a(gVar, mVar.mLiveInfo.feed_id, mVar.mLiveInfo.live_id + "", str);
            } else if (TbadkCoreApplication.getInst().currentAccountTdouNum <= 0 || TbadkCoreApplication.getInst().currentAccountTdouNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                a(tbPageContext, str);
                return false;
            } else {
                t.b(gVar, 1, mVar.Ya.userId + "", mVar.Ya.userName, mVar.mLiveInfo.live_id + "", mVar.mLiveInfo.room_id + "", mVar.mLiveInfo.appId + "", mVar.mLiveInfo.feed_id + "", str);
                a(gVar, mVar.mLiveInfo.feed_id, mVar.mLiveInfo.live_id + "", str);
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
                alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, gVar.rC());
                alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, gVar.rD());
                alaStaticItem.addParams("other_params", str3);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
