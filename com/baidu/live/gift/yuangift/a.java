package com.baidu.live.gift.yuangift;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c;
import com.baidu.live.data.ax;
import com.baidu.live.data.bl;
import com.baidu.live.data.q;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.b.b;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityConfig;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityOpaqueConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.data.BuyYinjiInfo;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.pay.PayManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.PageDialogHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements aa {
    private static volatile a aOd = null;
    private AlaDynamicGiftLayout aOe;
    private CashGiftHttpResponseMessage aOf;
    private boolean aOg;
    private String aOh;
    private WeakReference<Context> aOi;
    private String aOj;
    private Dialog aOk;
    private long aOl;
    HttpMessageListener aOm = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST) { // from class: com.baidu.live.gift.yuangift.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof CashGiftHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                a.this.aOf = (CashGiftHttpResponseMessage) httpResponsedMessage;
                a.this.aOl = a.this.aOf.dubi / 100;
                a.this.ae(a.this.currLiveId);
            }
        }
    };
    private long currLiveId;
    private String mOtherParams;
    private long mRoomId;
    private String mVid;

    public static a BA() {
        if (aOd == null) {
            synchronized (a.class) {
                if (aOd == null) {
                    aOd = new a();
                }
            }
        }
        return aOd;
    }

    @Override // com.baidu.live.gift.aa
    public void yy() {
        if (this.aOk != null && this.aOk.isShowing()) {
            Context context = this.aOk.getContext();
            if (context != null && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                } else if (activity.isFinishing()) {
                    return;
                }
            }
            try {
                this.aOk.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.aOe != null) {
            this.aOe.onDestroy();
        }
        this.aOe = null;
        this.aOk = null;
        BC();
    }

    @Override // com.baidu.live.gift.aa
    public void a(Context context, long j, String str, long j2, String str2, String str3) {
        bl blVar;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aOi = new WeakReference<>(context);
            this.aOj = str;
            this.mRoomId = j2;
            this.mVid = str2;
            this.mOtherParams = str3;
            this.currLiveId = j;
            ax axVar = com.baidu.live.v.a.Ge().aYP;
            if (axVar != null && (blVar = axVar.aAL) != null && blVar.aCr) {
                this.aOh = "no_show_trace_cash_gift_today_" + j.b(new Date());
                if (!c.uN().getBoolean(this.aOh, false)) {
                    if (this.aOk != null && this.aOk.isShowing()) {
                        if (this.aOf != null && this.aOf.aNY != null && b.Ah().eJ(this.aOf.previewGiftId + "") && b.Ah().eJ(this.aOf.aNY.xl())) {
                            try {
                                if (al(context)) {
                                    this.aOk.show();
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    BB();
                }
            }
        }
    }

    public void ap(String str, String str2) {
        JSONArray jSONArray;
        try {
            String string = c.uN().getString("show_trace_cash_gift", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str2, str);
            jSONObject.put(str, str2);
            jSONArray.put(jSONObject);
            c.uN().putString("show_trace_cash_gift", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final long j, final long j2, final String str, final String str2) {
        if (context != null && this.aOf != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                } else if (activity.isFinishing()) {
                    return;
                }
            }
            if (this.aOk != null && this.aOk.isShowing()) {
                try {
                    this.aOk.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            View inflate = LayoutInflater.from(context).inflate(a.h.dialog_oneyuan_gift, (ViewGroup) null);
            this.aOk = new Dialog(context, a.j.FlowerGuideDialogStyle);
            this.aOk.requestWindowFeature(1);
            this.aOk.setCancelable(true);
            this.aOk.setContentView(inflate);
            this.aOk.setCanceledOnTouchOutside(false);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.img_gift_bg);
            final ImageView imageView = (ImageView) inflate.findViewById(a.g.img_gift_switch_show);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aOg = !a.this.aOg;
                    c.uN().putBoolean(a.this.aOh, a.this.aOg);
                    if (a.this.aOg) {
                        imageView.setImageResource(a.f.icon_live_operatechoose_s);
                    } else {
                        imageView.setImageResource(a.f.icon_live_operatechoose_n);
                    }
                }
            });
            float dimensionPixelSize = (BdUtilHelper.getScreenDimensions(context)[0] * 1.0f) / context.getResources().getDimensionPixelSize(a.e.sdk_ds750);
            a(context, this.aOf.previewGiftId, (FrameLayout) inflate.findViewById(a.g.giftAnim_layout), dimensionPixelSize);
            inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IntentConfig payWalletActivityConfig;
                    LogManager.getYuanPackageLogger().doClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.aOl);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "oneyuanbag_clk").setContentExt(null, "popup", null));
                    if (ViewHelper.checkUpIsLogin(context)) {
                        String str3 = a.this.aOf.iconId;
                        String str4 = a.this.aOf.nonMemberT + "";
                        String str5 = (a.this.aOf.dubi / 100) + "";
                        String str6 = (a.this.aOf.nonMemberT / 1000) + "";
                        if (Build.VERSION.SDK_INT >= 28 && !com.baidu.live.utils.c.at(context)) {
                            payWalletActivityConfig = new PayWalletActivityOpaqueConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        } else {
                            payWalletActivityConfig = new PayWalletActivityConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        }
                        PayManager.getInstance().doPayByWallet(payWalletActivityConfig);
                        a.this.yy();
                    }
                }
            });
            this.aOk.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.yuangift.a.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onDismiss");
                    if (a.this.aOe != null) {
                        a.this.aOe.onDestroy();
                    }
                }
            });
            this.aOk.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.gift.yuangift.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onShow");
                    if (a.this.aOe != null) {
                        a.this.aOe.startAnim();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.i("YuanGiftHelper", "@@ doClose");
                    a.this.yy();
                    LogManager.getYuanPackageLogger().doCloseClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.aOl);
                }
            });
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.live.gift.yuangift.a.6
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str3, boolean z) {
                    if (context instanceof Activity) {
                        Activity activity2 = (Activity) context;
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (activity2.isDestroyed() || activity2.isFinishing()) {
                                return;
                            }
                        } else if (activity2.isFinishing()) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "YuanGiftDialog"));
                        LogManager.getYuanPackageLogger().doDisplayOneGiftBagLog(j + "", j2 + "", str, str2, a.this.aOl);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "oneyuanbag_show").setContentExt(null, "popup", null));
                        if (a.this.aOk != null && !a.this.aOk.isShowing()) {
                            a.this.aOk.show();
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            if (!TextUtils.isEmpty(this.aOf.aNZ)) {
                tbImageView.startLoad(this.aOf.aNZ, 12, false);
            }
        }
    }

    private void a(Context context, int i, ViewGroup viewGroup, float f) {
        int i2;
        try {
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(i + "", 1L, null, "", "", "", "", "", false, "", "", -1L);
            cVar.bx(false);
            com.baidu.live.gift.c fi = b.Ah().fi(i + "");
            if (fi != null && !ListUtils.isEmpty(fi.getDynamicGiftPicPathList())) {
                int i3 = fi.aDK.aDJ.repeatCount;
                fi.aDK.aDJ.repeatCount = BdStatsConstant.ErrorCode.ERR_LOG_FAST;
                if (this.aOe != null) {
                    this.aOe.onDestroy();
                }
                this.aOe = new AlaDynamicGiftLayout(context);
                int dimensionPixelSize = (int) (context.getResources().getDimensionPixelSize(a.e.sdk_ds480) * f);
                int i4 = fi.aDK.aDJ.width;
                int i5 = fi.aDK.aDJ.height;
                if (i5 > 0) {
                    float f2 = (dimensionPixelSize * 1.0f) / i5;
                    if (i4 >= i5) {
                        i2 = (int) (f2 * 1334.0f);
                    } else {
                        i2 = (int) (f2 * 750.0f);
                    }
                    viewGroup.getLayoutParams().width = (i4 * dimensionPixelSize) / i5;
                    viewGroup.getLayoutParams().height = dimensionPixelSize;
                    viewGroup.setLayoutParams(viewGroup.getLayoutParams());
                    viewGroup.addView(this.aOe, new ViewGroup.LayoutParams(-1, -1));
                    this.aOe.setData(fi, cVar, i2, dimensionPixelSize);
                    this.aOe.setBigGiftCallBack(new com.baidu.live.gift.biggift.b() { // from class: com.baidu.live.gift.yuangift.a.7
                        @Override // com.baidu.live.gift.biggift.b
                        public void l(com.baidu.live.gift.a.c cVar2) {
                        }

                        @Override // com.baidu.live.gift.biggift.b
                        public void bP(int i6) {
                        }

                        @Override // com.baidu.live.gift.biggift.b
                        public void m(com.baidu.live.gift.a.c cVar2) {
                            if (a.this.aOk != null && a.this.aOk.isShowing() && a.this.aOe != null) {
                                a.this.aOe.post(new Runnable() { // from class: com.baidu.live.gift.yuangift.a.7.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (a.this.aOe != null) {
                                            a.this.aOe.startAnim();
                                        }
                                    }
                                });
                            }
                        }
                    });
                    fi.aDK.aDJ.repeatCount = i3;
                }
            }
        } catch (OutOfMemoryError e) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
        }
    }

    private void BB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_HOST + "liveserver/liveActivity/cashgift");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(CashGiftHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.aOm);
        MessageManager.getInstance().sendMessage(new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST));
    }

    private void BC() {
        MessageManager.getInstance().unRegisterListener(this.aOm);
        MessageManager.getInstance().unRegisterTask(1021130);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ae(final long j) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        long j2;
        if (this.aOf != null) {
            final String b = j.b(new Date());
            final String str = "date_" + this.aOf.aOc;
            HashMap hashMap = new HashMap();
            hashMap.put("test_yuan_package", false);
            Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
            boolean booleanValue = process.containsKey("test_yuan_package") ? ((Boolean) process.get("test_yuan_package")).booleanValue() : false;
            String string = c.uN().getString("show_trace_cash_gift", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray2 = booleanValue ? null : jSONArray;
                if (jSONArray2 != null) {
                    HashSet hashSet = new HashSet();
                    int i = 0;
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                        if (optJSONObject != null) {
                            if (!TextUtils.isEmpty(optJSONObject.optString(b))) {
                                i++;
                            }
                            if (this.aOf.aBz == -1 || i < this.aOf.aBz) {
                                String optString = optJSONObject.optString(str);
                                if (!TextUtils.isEmpty(optString)) {
                                    hashSet.add(optString);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    if (this.aOf.aBA != -1) {
                        if (hashSet.size() <= this.aOf.aBA) {
                            if (hashSet.size() == this.aOf.aBA && i == 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                j2 = (!booleanValue ? 5 : this.aOf.aBB) * 1000;
                if (j2 <= 0) {
                    j2 = 180000;
                }
                LiveTimerManager.getInstance().addLiveTimerTask(this.aOj, j, new OnLiveTimerListener() { // from class: com.baidu.live.gift.yuangift.a.9
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        if (a.this.aOf != null && a.this.aOf.aNY != null && j == a.this.currLiveId) {
                            boolean eJ = b.Ah().eJ(a.this.aOf.previewGiftId + "");
                            boolean eJ2 = b.Ah().eJ(a.this.aOf.aNY.xl());
                            if (eJ && eJ2 && a.this.aOi != null && a.this.aOi.get() != null) {
                                Context context = (Context) a.this.aOi.get();
                                if (a.this.al(context)) {
                                    a.this.a(context, j, a.this.mRoomId, a.this.mVid, a.this.mOtherParams);
                                    a.this.ap(b, str);
                                }
                            }
                        }
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, j2, true);
            }
            jSONArray = null;
            if (booleanValue) {
            }
            if (jSONArray2 != null) {
            }
            j2 = (!booleanValue ? 5 : this.aOf.aBB) * 1000;
            if (j2 <= 0) {
            }
            LiveTimerManager.getInstance().addLiveTimerTask(this.aOj, j, new OnLiveTimerListener() { // from class: com.baidu.live.gift.yuangift.a.9
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    if (a.this.aOf != null && a.this.aOf.aNY != null && j == a.this.currLiveId) {
                        boolean eJ = b.Ah().eJ(a.this.aOf.previewGiftId + "");
                        boolean eJ2 = b.Ah().eJ(a.this.aOf.aNY.xl());
                        if (eJ && eJ2 && a.this.aOi != null && a.this.aOi.get() != null) {
                            Context context = (Context) a.this.aOi.get();
                            if (a.this.al(context)) {
                                a.this.a(context, j, a.this.mRoomId, a.this.mVid, a.this.mOtherParams);
                                a.this.ap(b, str);
                            }
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, j2, true);
        }
    }

    @Override // com.baidu.live.gift.aa
    public void a(int i, int i2, Intent intent, q qVar, String str) {
        if (25042 == i && intent != null && qVar != null && this.aOf != null) {
            a(intent.getIntExtra("result_code", -1), intent.getIntExtra("result_payinfo_status", -1), intent.getStringExtra("result_tbean_num"), this.aOf.aNY, qVar, str);
        }
    }

    private void a(int i, int i2, String str, g gVar, q qVar, String str2) {
        switch (i) {
            case 0:
                Log.i("LiveViewController", "@@ handlePayResult 成功");
                a(true, i2, str, gVar, qVar, str2);
                return;
            case 1:
                Log.i("LiveViewController", "@@ handlePayResult 取消");
                HashMap hashMap = new HashMap();
                hashMap.put("test_yuan_package_paysucc", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey("test_yuan_package_paysucc")) {
                    a(((Boolean) process.get("test_yuan_package_paysucc")).booleanValue(), i2, str, gVar, qVar, str2);
                    return;
                } else {
                    a(false, i2, str, gVar, qVar, str2);
                    return;
                }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                Log.i("LiveViewController", "@@ handlePayResult 其他");
                a(false, i2, str, gVar, qVar, str2);
                return;
            default:
                return;
        }
    }

    private void a(boolean z, int i, String str, g gVar, q qVar, String str2) {
        if (z) {
            BuyYinjiInfo buyYinjiInfo = new BuyYinjiInfo();
            buyYinjiInfo.setTBeanNum(str);
            buyYinjiInfo.setStatus(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS, buyYinjiInfo));
            BdUtilHelper.getCustomToast().showToast("购买成功", 0);
            if (qVar.mLiveInfo.live_id == this.currLiveId && gVar != null) {
                gVar.setSceneFrom(com.baidu.live.utils.q.Id());
                a(gVar, 1L, qVar, str2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098));
                return;
            }
            return;
        }
        BdUtilHelper.getCustomToast().showToast("购买失败", 0);
        yy();
    }

    private void a(g gVar, long j, q qVar, String str) {
        b.Ah();
        b.b(gVar, j, qVar.avj.userId + "", qVar.avj.userName, qVar.mLiveInfo.live_id + "", qVar.mLiveInfo.room_id + "", qVar.mLiveInfo.appId + "", qVar.mLiveInfo.feed_id + "", str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean al(Context context) {
        return UtilHelper.getRealScreenOrientation(context) != 2;
    }

    @Override // com.baidu.live.gift.aa
    public void ya() {
        if (this.aOk != null && this.aOk.isShowing() && UtilHelper.getRealScreenOrientation(this.aOk.getContext()) == 2) {
            yy();
        }
    }
}
