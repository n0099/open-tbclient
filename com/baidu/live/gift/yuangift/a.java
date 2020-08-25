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
import com.baidu.live.data.be;
import com.baidu.live.data.bt;
import com.baidu.live.data.r;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.b.b;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import com.baidu.live.gift.g;
import com.baidu.live.sdk.a;
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
import com.baidu.live.utils.j;
import com.baidu.live.utils.p;
import com.baidu.platform.comapi.map.MapController;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements aa {
    private static volatile a aXp = null;
    private AlaDynamicGiftLayout aXq;
    private CashGiftHttpResponseMessage aXr;
    private boolean aXs;
    private String aXt;
    private WeakReference<Context> aXu;
    private String aXv;
    private Dialog aXw;
    private long aXx;
    private boolean aXy;
    HttpMessageListener aXz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST) { // from class: com.baidu.live.gift.yuangift.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof CashGiftHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                a.this.aXr = (CashGiftHttpResponseMessage) httpResponsedMessage;
                a.this.aXx = a.this.aXr.dubi / 100;
                a.this.af(a.this.currLiveId);
            }
        }
    };
    private long currLiveId;
    private String mOtherParams;
    private long mRoomId;
    private String mVid;

    @Override // com.baidu.live.gift.aa
    public void bm(boolean z) {
        this.aXy = z;
        if (this.aXy) {
            Fd();
        }
    }

    public static a If() {
        if (aXp == null) {
            synchronized (a.class) {
                if (aXp == null) {
                    aXp = new a();
                }
            }
        }
        return aXp;
    }

    @Override // com.baidu.live.gift.aa
    public void Fd() {
        if (this.aXw != null && this.aXw.isShowing()) {
            Context context = this.aXw.getContext();
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
                this.aXw.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.aXq != null) {
            this.aXq.onDestroy();
        }
        this.aXq = null;
        this.aXw = null;
        Ih();
    }

    @Override // com.baidu.live.gift.aa
    public void a(Context context, long j, String str, long j2, String str2, String str3) {
        bt btVar;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && !TbadkCoreApplication.getInst().isMobileBaidu() && !this.aXy) {
            this.aXu = new WeakReference<>(context);
            this.aXv = str;
            this.mRoomId = j2;
            this.mVid = str2;
            this.mOtherParams = str3;
            this.currLiveId = j;
            be beVar = com.baidu.live.w.a.Nk().bka;
            if (beVar != null && (btVar = beVar.aJB) != null && btVar.aLm) {
                this.aXt = "no_show_trace_cash_gift_today_" + j.b(new Date());
                if (!c.AD().getBoolean(this.aXt, false)) {
                    if (this.aXw != null && this.aXw.isShowing()) {
                        if (this.aXr != null && this.aXr.aXk != null && b.GM().gi(this.aXr.previewGiftId + "") && b.GM().gi(this.aXr.aXk.DR())) {
                            try {
                                if (ap(context)) {
                                    this.aXw.show();
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
                    Ig();
                }
            }
        }
    }

    public void at(String str, String str2) {
        JSONArray jSONArray;
        try {
            String string = c.AD().getString("show_trace_cash_gift", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str2, str);
            jSONObject.put(str, str2);
            jSONArray.put(jSONObject);
            c.AD().putString("show_trace_cash_gift", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final long j, final long j2, final String str, final String str2) {
        if (context != null && this.aXr != null) {
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
            if (this.aXw != null && this.aXw.isShowing()) {
                try {
                    this.aXw.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            View inflate = LayoutInflater.from(context).inflate(a.h.dialog_oneyuan_gift, (ViewGroup) null);
            this.aXw = new Dialog(context, a.j.FlowerGuideDialogStyle);
            this.aXw.requestWindowFeature(1);
            this.aXw.setCancelable(true);
            this.aXw.setContentView(inflate);
            this.aXw.setCanceledOnTouchOutside(false);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.img_gift_bg);
            final ImageView imageView = (ImageView) inflate.findViewById(a.g.img_gift_switch_show);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aXs = !a.this.aXs;
                    c.AD().putBoolean(a.this.aXt, a.this.aXs);
                    if (a.this.aXs) {
                        imageView.setImageResource(a.f.icon_live_operatechoose_s);
                    } else {
                        imageView.setImageResource(a.f.icon_live_operatechoose_n);
                    }
                }
            });
            float dimensionPixelSize = (BdUtilHelper.getScreenDimensions(context)[0] * 1.0f) / context.getResources().getDimensionPixelSize(a.e.sdk_ds750);
            a(context, this.aXr.previewGiftId, (FrameLayout) inflate.findViewById(a.g.giftAnim_layout), dimensionPixelSize);
            inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IntentConfig payWalletActivityConfig;
                    LogManager.getYuanPackageLogger().doClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.aXx);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "oneyuanbag_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    if (ViewHelper.checkUpIsLogin(context)) {
                        String str3 = a.this.aXr.iconId;
                        String str4 = a.this.aXr.nonMemberT + "";
                        String str5 = (a.this.aXr.dubi / 100) + "";
                        String str6 = (a.this.aXr.nonMemberT / 1000) + "";
                        if (Build.VERSION.SDK_INT >= 28 && !com.baidu.live.utils.c.ax(context)) {
                            payWalletActivityConfig = new PayWalletActivityOpaqueConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        } else {
                            payWalletActivityConfig = new PayWalletActivityConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        }
                        PayManager.getInstance().doPayByWallet(payWalletActivityConfig);
                        a.this.Fd();
                    }
                }
            });
            this.aXw.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.yuangift.a.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onDismiss");
                    if (a.this.aXq != null) {
                        a.this.aXq.onDestroy();
                    }
                }
            });
            this.aXw.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.gift.yuangift.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onShow");
                    if (a.this.aXq != null) {
                        a.this.aXq.startAnim();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.i("YuanGiftHelper", "@@ doClose");
                    a.this.Fd();
                    LogManager.getYuanPackageLogger().doCloseClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.aXx);
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
                        LogManager.getYuanPackageLogger().doDisplayOneGiftBagLog(j + "", j2 + "", str, str2, a.this.aXx);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "oneyuanbag_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                        if (a.this.aXw != null && !a.this.aXw.isShowing()) {
                            a.this.aXw.show();
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            if (!TextUtils.isEmpty(this.aXr.aXl)) {
                tbImageView.startLoad(this.aXr.aXl, 12, false);
            }
        }
    }

    private void a(Context context, int i, ViewGroup viewGroup, float f) {
        int i2;
        try {
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(i + "", 1L, null, "", "", "", "", "", false, "", "", -1L);
            cVar.bF(false);
            com.baidu.live.gift.c gI = b.GM().gI(i + "");
            if (gI != null && !ListUtils.isEmpty(gI.getDynamicGiftPicPathList())) {
                int i3 = gI.aML.aMK.repeatCount;
                gI.aML.aMK.repeatCount = BdStatsConstant.ErrorCode.ERR_LOG_FAST;
                if (this.aXq != null) {
                    this.aXq.onDestroy();
                }
                this.aXq = new AlaDynamicGiftLayout(context);
                int dimensionPixelSize = (int) (context.getResources().getDimensionPixelSize(a.e.sdk_ds480) * f);
                int i4 = gI.aML.aMK.width;
                int i5 = gI.aML.aMK.height;
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
                    viewGroup.addView(this.aXq, new ViewGroup.LayoutParams(-1, -1));
                    this.aXq.setData(gI, cVar, i2, dimensionPixelSize);
                    this.aXq.setBigGiftCallBack(new com.baidu.live.gift.biggift.b() { // from class: com.baidu.live.gift.yuangift.a.7
                        @Override // com.baidu.live.gift.biggift.b
                        public void l(com.baidu.live.gift.a.c cVar2) {
                        }

                        @Override // com.baidu.live.gift.biggift.b
                        public void dQ(int i6) {
                        }

                        @Override // com.baidu.live.gift.biggift.b
                        public void m(com.baidu.live.gift.a.c cVar2) {
                            if (a.this.aXw != null && a.this.aXw.isShowing() && a.this.aXq != null) {
                                a.this.aXq.post(new Runnable() { // from class: com.baidu.live.gift.yuangift.a.7.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (a.this.aXq != null) {
                                            a.this.aXq.startAnim();
                                        }
                                    }
                                });
                            }
                        }
                    });
                    gI.aML.aMK.repeatCount = i3;
                }
            }
        } catch (OutOfMemoryError e) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
        }
    }

    private void Ig() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_HOST + "liveserver/liveActivity/cashgift");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(CashGiftHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.aXz);
        MessageManager.getInstance().sendMessage(new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST));
    }

    private void Ih() {
        MessageManager.getInstance().unRegisterListener(this.aXz);
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
    public void af(final long j) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        long j2;
        if (this.aXr != null) {
            final String b = j.b(new Date());
            final String str = "date_" + this.aXr.aXo;
            HashMap hashMap = new HashMap();
            hashMap.put("test_yuan_package", false);
            Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
            boolean booleanValue = process.containsKey("test_yuan_package") ? ((Boolean) process.get("test_yuan_package")).booleanValue() : false;
            String string = c.AD().getString("show_trace_cash_gift", "");
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
                            if (this.aXr.aKo == -1 || i < this.aXr.aKo) {
                                String optString = optJSONObject.optString(str);
                                if (!TextUtils.isEmpty(optString)) {
                                    hashSet.add(optString);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    if (this.aXr.aKp != -1) {
                        if (hashSet.size() <= this.aXr.aKp) {
                            if (hashSet.size() == this.aXr.aKp && i == 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                j2 = (!booleanValue ? 5 : this.aXr.aKq) * 1000;
                if (j2 <= 0) {
                    j2 = 180000;
                }
                LiveTimerManager.getInstance().addLiveTimerTask(this.aXv, j, new OnLiveTimerListener() { // from class: com.baidu.live.gift.yuangift.a.9
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        if (a.this.aXr != null && a.this.aXr.aXk != null && j == a.this.currLiveId) {
                            boolean gi = b.GM().gi(a.this.aXr.previewGiftId + "");
                            boolean gi2 = b.GM().gi(a.this.aXr.aXk.DR());
                            if (gi && gi2 && a.this.aXu != null && a.this.aXu.get() != null) {
                                Context context = (Context) a.this.aXu.get();
                                if (a.this.ap(context)) {
                                    a.this.a(context, j, a.this.mRoomId, a.this.mVid, a.this.mOtherParams);
                                    a.this.at(b, str);
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
            j2 = (!booleanValue ? 5 : this.aXr.aKq) * 1000;
            if (j2 <= 0) {
            }
            LiveTimerManager.getInstance().addLiveTimerTask(this.aXv, j, new OnLiveTimerListener() { // from class: com.baidu.live.gift.yuangift.a.9
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    if (a.this.aXr != null && a.this.aXr.aXk != null && j == a.this.currLiveId) {
                        boolean gi = b.GM().gi(a.this.aXr.previewGiftId + "");
                        boolean gi2 = b.GM().gi(a.this.aXr.aXk.DR());
                        if (gi && gi2 && a.this.aXu != null && a.this.aXu.get() != null) {
                            Context context = (Context) a.this.aXu.get();
                            if (a.this.ap(context)) {
                                a.this.a(context, j, a.this.mRoomId, a.this.mVid, a.this.mOtherParams);
                                a.this.at(b, str);
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
    public void a(int i, int i2, Intent intent, r rVar, String str) {
        if (25042 == i && intent != null && rVar != null && this.aXr != null) {
            a(intent.getIntExtra("result_code", -1), intent.getIntExtra("result_payinfo_status", -1), intent.getStringExtra("result_tbean_num"), this.aXr.aXk, rVar, str);
        }
    }

    private void a(int i, int i2, String str, g gVar, r rVar, String str2) {
        switch (i) {
            case 0:
                Log.i("LiveViewController", "@@ handlePayResult 成功");
                a(true, i2, str, gVar, rVar, str2);
                return;
            case 1:
                Log.i("LiveViewController", "@@ handlePayResult 取消");
                HashMap hashMap = new HashMap();
                hashMap.put("test_yuan_package_paysucc", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey("test_yuan_package_paysucc")) {
                    a(((Boolean) process.get("test_yuan_package_paysucc")).booleanValue(), i2, str, gVar, rVar, str2);
                    return;
                } else {
                    a(false, i2, str, gVar, rVar, str2);
                    return;
                }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                Log.i("LiveViewController", "@@ handlePayResult 其他");
                a(false, i2, str, gVar, rVar, str2);
                return;
            default:
                return;
        }
    }

    private void a(boolean z, int i, String str, g gVar, r rVar, String str2) {
        if (z) {
            BuyYinjiInfo buyYinjiInfo = new BuyYinjiInfo();
            buyYinjiInfo.setTBeanNum(str);
            buyYinjiInfo.setStatus(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS, buyYinjiInfo));
            BdUtilHelper.getCustomToast().showToast("购买成功", 0);
            if (rVar.mLiveInfo.live_id == this.currLiveId && gVar != null) {
                gVar.setSceneFrom(p.Pp());
                a(gVar, 1L, rVar, str2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098));
                return;
            }
            return;
        }
        BdUtilHelper.getCustomToast().showToast("购买失败", 0);
        Fd();
    }

    private void a(g gVar, long j, r rVar, String str) {
        b.GM();
        b.b(gVar, j, rVar.aDE.userId + "", rVar.aDE.userName, rVar.mLiveInfo.live_id + "", rVar.mLiveInfo.room_id + "", rVar.mLiveInfo.appId + "", rVar.mLiveInfo.feed_id + "", str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ap(Context context) {
        return (UtilHelper.getRealScreenOrientation(context) == 2 || this.aXy) ? false : true;
    }

    @Override // com.baidu.live.gift.aa
    public void EF() {
        if (this.aXw != null && this.aXw.isShowing() && UtilHelper.getRealScreenOrientation(this.aXw.getContext()) == 2) {
            Fd();
        }
    }
}
