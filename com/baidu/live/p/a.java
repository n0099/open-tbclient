package com.baidu.live.p;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static Map<Long, Boolean> bvL = new HashMap();
    private static Set<Long> bvM = new HashSet();
    private static int bvN = 0;
    private static boolean bvO = true;

    public static void e(long j, boolean z) {
        bvL.clear();
        bvL.put(Long.valueOf(j), Boolean.valueOf(z));
        if (TbadkCoreApplication.getCurrentAccountId() > 0 && !bvM.contains(Long.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "defaultname"));
            bvM.add(Long.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    public static void cJ(boolean z) {
        bvO = z;
    }

    public static void c(long j, int i) {
        if (d(j, i)) {
            if (i == 0) {
                be(j);
            } else {
                e(j, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(long j, int i) {
        boolean z;
        boolean z2 = true;
        if (TbadkCoreApplication.isLogin() && bvO) {
            if (isDebug()) {
                return true;
            }
            if (bvL.containsKey(Long.valueOf(j)) && bvL.get(Long.valueOf(j)).booleanValue()) {
                if ((!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isMobileBaidu()) || UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2 || com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNs == null || com.baidu.live.ae.a.Qj().buX.aNs.aQk == 0) {
                    return false;
                }
                if (i == 0) {
                    z = bvL.get(Long.valueOf(j)).booleanValue();
                } else if (i == 1) {
                    z = com.baidu.live.ae.a.Qj().buX.aNs.aQl == 1;
                } else if (i == 2) {
                    z = com.baidu.live.ae.a.Qj().buX.aNs.aQm == 1;
                } else if (i == 3) {
                    z = com.baidu.live.ae.a.Qj().buX.aNs.aQn == 1;
                } else if (i == 4) {
                    z = com.baidu.live.ae.a.Qj().buX.aNs.aQp == 1;
                } else if (i == 5) {
                    z = com.baidu.live.ae.a.Qj().buX.aNs.aQo == 1;
                } else if (i == 6) {
                    z = com.baidu.live.ae.a.Qj().buX.aNs.aQq == 1;
                } else if (i == 7) {
                    z = com.baidu.live.ae.a.Qj().buX.aNs.aQr == 1;
                } else if (i == 8) {
                    z = com.baidu.live.ae.a.Qj().buX.aNs.aQs == 1;
                } else {
                    z = false;
                }
                if (z) {
                    int i2 = com.baidu.live.ae.a.Qj().buX.aNs.aQu;
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    String string = d.xc().getString("modify_nickame_show_every_days", "");
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            String b2 = k.b(new Date());
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            if (simpleDateFormat.parse(b2).getTime() - simpleDateFormat.parse(string).getTime() < i2 * 1000 * 60 * 60 * 24) {
                                z2 = false;
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return z2;
                    }
                }
                z2 = z;
                return z2;
            }
            return false;
        }
        return false;
    }

    private static void be(final long j) {
        if (com.baidu.live.ae.a.Qj().buX.aNs != null) {
            long j2 = com.baidu.live.ae.a.Qj().buX.aNs.aQt * 1000;
            if (isDebug()) {
                Log.i("ModifyNicknameHelper", "@@ ModifyNickname dealWatch debug duration =" + j2);
                j2 = 10000;
            }
            LiveTimerManager.getInstance().removeLiveTimerTask("ModifyNickname", false);
            LiveTimerManager.getInstance().addLiveTimerTask("ModifyNickname", j, new OnLiveTimerListener() { // from class: com.baidu.live.p.a.1
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    if (a.d(j, 0)) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            a.dL(0);
                        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                            a.dM(0);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, j2, false);
        }
    }

    private static void e(long j, int i) {
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            dL(i);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            dM(i);
        }
    }

    private static void OJ() {
        d.xc().putString("modify_nickame_show_every_days", k.b(new Date()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dL(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", "设置专属昵称");
            jSONObject.put("subtitle", "让主播更好地认识你");
            jSONObject.put(TrackReferenceTypeBox.TYPE1, "输入昵称");
            jSONObject.put("from", "live");
            String dN = dN(i);
            JSONObject jSONObject2 = new JSONObject();
            if (dN == null) {
                dN = "";
            }
            jSONObject2.put("source", dN);
            jSONObject.put("extra", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doProcessGeneric(ExtraParamsManager.KEY_SHOW_MODIFY_NICKNAME_DIALOG, jSONObject, JSONObject.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dM(int i) {
        bvN = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913235));
    }

    public static void r(Activity activity) {
        HashMap hashMap = new HashMap();
        hashMap.put(PushConstants.INTENT_ACTIVITY_NAME, activity);
        hashMap.put(GroupInfoActivityConfig.REQUEST_CODE, Integer.valueOf((int) RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ExtraParamsManager.KEY_SHOW_MODIFY_NICKNAME_DIALOG, hashMap);
        ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap2);
    }

    private static String dN(int i) {
        switch (i) {
            case 0:
                return "read";
            case 1:
                return "like";
            case 2:
                return "comment";
            case 3:
                return "free_gift";
            case 4:
                return "pay_gift";
            case 5:
                return "follow";
            case 6:
                return "pay_msg";
            case 7:
                return "lovegroup";
            case 8:
                return "redpacket";
            default:
                return "";
        }
    }

    public static void K(Context context, String str) {
        if (isDebug()) {
            BdUtilHelper.showToast(context, str);
        }
        if (!TextUtils.isEmpty(str)) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                L(context, str);
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                M(context, str);
            }
        }
    }

    private static void L(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("new_nickname");
            String optString = new JSONObject(jSONObject.optString("extra")).optString("source");
            if (jSONObject.has("op_type")) {
                int optInt = jSONObject.optInt("op_type");
                if (optInt == 0) {
                    OJ();
                    LiveTimerManager.getInstance().removeLiveTimerTask("ModifyNickname", false);
                    UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", SdkStaticKeys.RENAME_SHOW);
                    ubcStatisticItem.setContentExt(optString, UbcStatConstant.SubPage.POPUP, null);
                    UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
                } else if (optInt == 1) {
                    Log.i("ModifyNicknameHelper", "@@ ModifyNickname noticeModifyNickname success");
                    OK();
                    UbcStatisticItem ubcStatisticItem2 = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "renamed");
                    ubcStatisticItem2.setContentExt(optString, null, null);
                    UbcStatisticManager.getInstance().logEvent(ubcStatisticItem2);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void M(Context context, String str) {
        String dN = dN(bvN);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("action");
            int optInt = jSONObject.optInt(TiebaInitialize.LogFields.ERROR_CODE);
            if (TextUtils.equals(optString, "show")) {
                LiveTimerManager.getInstance().removeLiveTimerTask("ModifyNickname", false);
                if (optInt == 0) {
                    OJ();
                    UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", SdkStaticKeys.RENAME_SHOW);
                    ubcStatisticItem.setContentExt(dN, UbcStatConstant.SubPage.POPUP, null);
                    UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913236));
            } else if (TextUtils.equals(optString, "modify")) {
                if (optInt == 0) {
                    OK();
                    UbcStatisticItem ubcStatisticItem2 = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "renamed");
                    ubcStatisticItem2.setContentExt(dN, null, null);
                    UbcStatisticManager.getInstance().logEvent(ubcStatisticItem2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913236));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void OK() {
        HttpMessage httpMessage = new HttpMessage(1021125);
        httpMessage.addParam("no_cache", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static boolean isDebug() {
        HashMap hashMap = new HashMap();
        hashMap.put("test_showModifyNickNameDialog", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process.containsKey("test_showModifyNickNameDialog")) {
            return ((Boolean) process.get("test_showModifyNickNameDialog")).booleanValue();
        }
        return false;
    }
}
