package com.baidu.live.gift.b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.i;
import com.baidu.live.gift.g;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
/* loaded from: classes6.dex */
public class c {
    public static void showToast(Context context, int i) {
        BdUtilHelper.showToast(context, i);
    }

    public static boolean a(Context context, g gVar, int i, i iVar) {
        if (context == null || gVar == null || i <= 0 || iVar == null) {
            return false;
        }
        if (iVar.Pj.isBlock == 2) {
            showToast(context, a.i.sdk_live_room_forbid_forever_tip);
            return false;
        } else if (iVar.Pj.isBlock == 1) {
            showToast(context, a.i.sdk_live_room_forbid_this_tip);
            return false;
        } else {
            gVar.pi();
            return true;
        }
    }

    public static boolean a(TbPageContext tbPageContext, i iVar, g gVar, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || gVar == null || iVar == null || iVar.mLiveInfo == null || iVar.Pj == null) {
            return false;
        }
        if (gVar.ps()) {
            if (gVar.pp() == 6 && iVar.Pj.levelId < 3) {
                return false;
            }
            if (gVar.pp() == 7 && iVar.Pj.levelId < 7) {
                return false;
            }
            if (gVar.pp() == 8 && iVar.Pj.levelId < 13) {
                return false;
            }
            if (gVar.pp() == 9 && iVar.Pj.levelId < 22) {
                return false;
            }
            if (gVar.pp() == 10 && iVar.Pj.levelId < 29) {
                return false;
            }
            if (gVar.pp() == 11 && iVar.Pj.levelId < 39) {
                return false;
            }
            if (gVar.pp() == 12 && iVar.Pj.levelId < 47) {
                return false;
            }
        }
        if (a(tbPageContext.getPageActivity(), gVar, 1, iVar)) {
            if (gVar.pm()) {
                if (TbadkCoreApplication.getInst().currentAccountFlowerNum <= 0 || TbadkCoreApplication.getInst().currentAccountFlowerNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                    BdUtilHelper.showToast(tbPageContext.getPageActivity(), tbPageContext.getPageActivity().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                b.rd().b(gVar, 1, iVar.OR.userId + "", iVar.OR.userName, iVar.mLiveInfo.live_id + "", iVar.mLiveInfo.room_id + "", iVar.mLiveInfo.appId + "", iVar.mLiveInfo.feed_id + "", str);
                a(gVar, iVar.mLiveInfo.feed_id, iVar.mLiveInfo.live_id + "", str);
            } else if (TbadkCoreApplication.getInst().currentAccountTdouNum <= 0 || TbadkCoreApplication.getInst().currentAccountTdouNum < JavaTypesHelper.toLong(gVar.getPrice(), 0L) * 1) {
                a(tbPageContext, str);
                return false;
            } else {
                b.rd().b(gVar, 1, iVar.OR.userId + "", iVar.OR.userName, iVar.mLiveInfo.live_id + "", iVar.mLiveInfo.room_id + "", iVar.mLiveInfo.appId + "", iVar.mLiveInfo.feed_id + "", str);
                a(gVar, iVar.mLiveInfo.feed_id, iVar.mLiveInfo.live_id + "", str);
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
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SUCCESS);
            alaStaticItem.addParams("gifts_value", gVar.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, gVar.pc());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, gVar.pd());
            alaStaticItem.addParams("other_params", str3);
            alaStaticItem.addParams("feed_id", str);
            alaStaticItem.addParams("live_id", str2);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }
}
