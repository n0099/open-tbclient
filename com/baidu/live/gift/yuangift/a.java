package com.baidu.live.gift.yuangift;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
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
import com.baidu.live.d;
import com.baidu.live.data.bq;
import com.baidu.live.data.cm;
import com.baidu.live.data.x;
import com.baidu.live.gift.ai;
import com.baidu.live.gift.biggift.c;
import com.baidu.live.gift.c.b;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout;
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
import com.baidu.live.utils.k;
import com.baidu.live.utils.q;
import com.baidu.tieba.recapp.lego.model.FormCard;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements ai {
    private static volatile a bka = null;
    private c bkb;
    private CashGiftHttpResponseMessage bkc;
    private boolean bkd;
    private String bke;
    private WeakReference<Context> bkf;
    private String bkg;
    private Dialog bkh;
    private long bki;
    private boolean bkj;
    HttpMessageListener bkk = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST) { // from class: com.baidu.live.gift.yuangift.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof CashGiftHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                a.this.bkc = (CashGiftHttpResponseMessage) httpResponsedMessage;
                a.this.bki = a.this.bkc.dubi / 100;
                a.this.aQ(a.this.currLiveId);
            }
        }
    };
    private long currLiveId;
    private String mOtherParams;
    private long mRoomId;
    private String mVid;

    @Override // com.baidu.live.gift.ai
    public void bD(boolean z) {
        this.bkj = z;
        if (this.bkj) {
            If();
        }
    }

    public static a Lr() {
        if (bka == null) {
            synchronized (a.class) {
                if (bka == null) {
                    bka = new a();
                }
            }
        }
        return bka;
    }

    @Override // com.baidu.live.gift.ai
    public void If() {
        if (this.bkh != null && this.bkh.isShowing()) {
            Context context = this.bkh.getContext();
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
                this.bkh.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.bkb != null) {
            this.bkb.onDestroy();
        }
        this.bkb = null;
        this.bkh = null;
        Lt();
    }

    @Override // com.baidu.live.gift.ai
    public void a(Context context, long j, String str, long j2, String str2, String str3) {
        cm cmVar;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && !TbadkCoreApplication.getInst().isMobileBaidu() && !this.bkj) {
            this.bkf = new WeakReference<>(context);
            this.bkg = str;
            this.mRoomId = j2;
            this.mVid = str2;
            this.mOtherParams = str3;
            this.currLiveId = j;
            bq bqVar = com.baidu.live.af.a.SE().bCb;
            if (bqVar != null && (cmVar = bqVar.aRE) != null && cmVar.aUc) {
                this.bke = "no_show_trace_cash_gift_today_" + k.b(new Date());
                if (!d.Ba().getBoolean(this.bke, false)) {
                    if (this.bkh != null && this.bkh.isShowing()) {
                        if (this.bkc != null && this.bkc.bjX != null && b.JW().gV(this.bkc.previewGiftId + "") && b.JW().gV(this.bkc.bjX.Gx())) {
                            try {
                                if (aU(context)) {
                                    this.bkh.show();
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
                    Ls();
                }
            }
        }
    }

    public void ay(String str, String str2) {
        JSONArray jSONArray;
        try {
            String string = d.Ba().getString("show_trace_cash_gift", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str2, str);
            jSONObject.put(str, str2);
            jSONArray.put(jSONObject);
            d.Ba().putString("show_trace_cash_gift", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final long j, final long j2, final String str, final String str2) {
        if (context != null && this.bkc != null) {
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
            if (this.bkh != null && this.bkh.isShowing()) {
                try {
                    this.bkh.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            View inflate = LayoutInflater.from(context).inflate(a.g.dialog_oneyuan_gift, (ViewGroup) null);
            this.bkh = new Dialog(context, a.i.FlowerGuideDialogStyle);
            this.bkh.requestWindowFeature(1);
            this.bkh.setCancelable(true);
            this.bkh.setContentView(inflate);
            this.bkh.setCanceledOnTouchOutside(false);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.img_gift_bg);
            final ImageView imageView = (ImageView) inflate.findViewById(a.f.img_gift_switch_show);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bkd = !a.this.bkd;
                    d.Ba().putBoolean(a.this.bke, a.this.bkd);
                    if (a.this.bkd) {
                        imageView.setImageResource(a.e.icon_live_operatechoose_s);
                    } else {
                        imageView.setImageResource(a.e.icon_live_operatechoose_n);
                    }
                }
            });
            float dimensionPixelSize = (BdUtilHelper.getScreenDimensions(context)[0] * 1.0f) / context.getResources().getDimensionPixelSize(a.d.sdk_ds750);
            a(context, this.bkc.previewGiftId, (FrameLayout) inflate.findViewById(a.f.giftAnim_layout), dimensionPixelSize);
            inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IntentConfig payWalletActivityConfig;
                    LogManager.getYuanPackageLogger().doClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.bki);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "oneyuanbag_clk").setContentExt(null, "popup", null));
                    if (ViewHelper.checkUpIsLogin(context)) {
                        String str3 = a.this.bkc.iconId;
                        String str4 = a.this.bkc.nonMemberT + "";
                        String str5 = (a.this.bkc.dubi / 100) + "";
                        String str6 = (a.this.bkc.nonMemberT / 1000) + "";
                        if (Build.VERSION.SDK_INT >= 28 && !com.baidu.live.utils.d.bl(context)) {
                            payWalletActivityConfig = new PayWalletActivityOpaqueConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        } else {
                            payWalletActivityConfig = new PayWalletActivityConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        }
                        PayManager.getInstance().doPayByWallet(payWalletActivityConfig);
                        a.this.If();
                    }
                }
            });
            this.bkh.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.yuangift.a.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onDismiss");
                    if (a.this.bkb != null) {
                        a.this.bkb.onDestroy();
                    }
                }
            });
            this.bkh.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.gift.yuangift.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onShow");
                    if (a.this.bkb != null) {
                        a.this.bkb.startAnim();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.yuangift.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.i("YuanGiftHelper", "@@ doClose");
                    a.this.If();
                    LogManager.getYuanPackageLogger().doCloseClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.bki);
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
                        LogManager.getYuanPackageLogger().doDisplayOneGiftBagLog(j + "", j2 + "", str, str2, a.this.bki);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "oneyuanbag_show").setContentExt(null, "popup", null));
                        if (a.this.bkh != null && !a.this.bkh.isShowing()) {
                            a.this.bkh.show();
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            if (!TextUtils.isEmpty(this.bkc.bjY)) {
                tbImageView.startLoad(this.bkc.bjY, 12, false);
            }
        }
    }

    private void a(Context context, int i, ViewGroup viewGroup, float f) {
        int i2;
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(i + "", 1L, null, "", "", "", "", "", false, "", "", -1L);
        cVar.bW(false);
        com.baidu.live.gift.c hA = b.JW().hA(i + "");
        if (hA != null) {
            if (this.bkb != null) {
                this.bkb.onDestroy();
                this.bkb = null;
            }
            if (!a(context, viewGroup, f, hA, cVar)) {
                try {
                    if (!ListUtils.isEmpty(hA.getDynamicGiftPicPathList())) {
                        int i3 = hA.aXb.aWZ.repeatCount;
                        hA.aXb.aWZ.repeatCount = BdStatsConstant.ErrorCode.ERR_LOG_FAST;
                        this.bkb = new AlaDynamicGiftLayout(context);
                        int dimensionPixelSize = (int) (context.getResources().getDimensionPixelSize(a.d.sdk_ds480) * f);
                        int i4 = hA.aXb.aWZ.width;
                        int i5 = hA.aXb.aWZ.height;
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
                            viewGroup.addView((View) this.bkb, new ViewGroup.LayoutParams(-1, -1));
                            ((AlaDynamicGiftLayout) this.bkb).setData(hA, cVar, i2, dimensionPixelSize);
                            this.bkb.setBigGiftCallBack(new com.baidu.live.gift.biggift.b() { // from class: com.baidu.live.gift.yuangift.a.7
                                @Override // com.baidu.live.gift.biggift.b
                                public void m(com.baidu.live.gift.a.c cVar2) {
                                }

                                @Override // com.baidu.live.gift.biggift.b
                                public void eo(int i6) {
                                }

                                @Override // com.baidu.live.gift.biggift.b
                                public void a(int i6, String str, com.baidu.live.gift.a.c cVar2) {
                                }

                                @Override // com.baidu.live.gift.biggift.b
                                public void n(com.baidu.live.gift.a.c cVar2) {
                                    if (a.this.bkh != null && a.this.bkh.isShowing() && a.this.bkb != null) {
                                        ((View) a.this.bkb).post(new Runnable() { // from class: com.baidu.live.gift.yuangift.a.7.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                if (a.this.bkb != null) {
                                                    a.this.bkb.startAnim();
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                            hA.aXb.aWZ.repeatCount = i3;
                        }
                    }
                } catch (OutOfMemoryError e) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                }
            }
        }
    }

    private boolean a(Context context, ViewGroup viewGroup, float f, com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (com.baidu.live.alphavideo.a.CC().CD() && cVar.aXb.Gb() && !TextUtils.isEmpty(cVar.Ge())) {
            int[] ht = ht(cVar.Ge());
            int dimensionPixelSize = (int) (context.getResources().getDimensionPixelSize(a.d.sdk_ds480) * f);
            int i = (ht[0] * dimensionPixelSize) / ht[1];
            viewGroup.getLayoutParams().width = i;
            viewGroup.getLayoutParams().height = dimensionPixelSize;
            viewGroup.setLayoutParams(viewGroup.getLayoutParams());
            this.bkb = new AlaDynamicVideoGiftLayout(context);
            ((AlaDynamicVideoGiftLayout) this.bkb).setLooping(true);
            ((AlaDynamicVideoGiftLayout) this.bkb).setData(cVar, cVar2, i, dimensionPixelSize);
            viewGroup.addView((View) this.bkb, new ViewGroup.LayoutParams(-1, -1));
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] ht(String str) {
        int i;
        int i2;
        int i3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            i = Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue();
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                i2 = 0;
                if (i > 0) {
                }
                if (i2 <= 0) {
                }
                mediaMetadataRetriever.release();
                return new int[]{i3, i2};
            }
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        if (i > 0) {
            i3 = FormCard.WIDTH_DEFAULT_SIZE;
        } else {
            i3 = i / 2;
        }
        if (i2 <= 0) {
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        mediaMetadataRetriever.release();
        return new int[]{i3, i2};
    }

    private void Ls() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_HOST + "liveserver/liveActivity/cashgift");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(CashGiftHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bkk);
        MessageManager.getInstance().sendMessage(new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST));
    }

    private void Lt() {
        MessageManager.getInstance().unRegisterListener(this.bkk);
        MessageManager.getInstance().unRegisterTask(1021130);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aQ(final long j) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        long j2;
        if (this.bkc != null) {
            final String b2 = k.b(new Date());
            final String str = "date_" + this.bkc.bjZ;
            HashMap hashMap = new HashMap();
            hashMap.put("test_yuan_package", false);
            Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
            boolean booleanValue = process.containsKey("test_yuan_package") ? ((Boolean) process.get("test_yuan_package")).booleanValue() : false;
            String string = d.Ba().getString("show_trace_cash_gift", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray2 = !booleanValue ? null : jSONArray;
                if (jSONArray2 != null) {
                    HashSet hashSet = new HashSet();
                    int i = 0;
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                        if (optJSONObject != null) {
                            if (!TextUtils.isEmpty(optJSONObject.optString(b2))) {
                                i++;
                            }
                            if (this.bkc.aSZ == -1 || i < this.bkc.aSZ) {
                                String optString = optJSONObject.optString(str);
                                if (!TextUtils.isEmpty(optString)) {
                                    hashSet.add(optString);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    if (this.bkc.aTa != -1) {
                        if (hashSet.size() <= this.bkc.aTa) {
                            if (hashSet.size() == this.bkc.aTa && i == 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                j2 = (!booleanValue ? 5 : this.bkc.aSf) * 1000;
                if (j2 <= 0) {
                    j2 = 180000;
                }
                LiveTimerManager.getInstance().addLiveTimerTask(this.bkg, j, new OnLiveTimerListener() { // from class: com.baidu.live.gift.yuangift.a.9
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        if (a.this.bkc != null && a.this.bkc.bjX != null && j == a.this.currLiveId) {
                            boolean gV = b.JW().gV(a.this.bkc.previewGiftId + "");
                            boolean gV2 = b.JW().gV(a.this.bkc.bjX.Gx());
                            if (gV && gV2 && a.this.bkf != null && a.this.bkf.get() != null) {
                                Context context = (Context) a.this.bkf.get();
                                if (a.this.aU(context)) {
                                    a.this.a(context, j, a.this.mRoomId, a.this.mVid, a.this.mOtherParams);
                                    a.this.ay(b2, str);
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
            if (!booleanValue) {
            }
            if (jSONArray2 != null) {
            }
            j2 = (!booleanValue ? 5 : this.bkc.aSf) * 1000;
            if (j2 <= 0) {
            }
            LiveTimerManager.getInstance().addLiveTimerTask(this.bkg, j, new OnLiveTimerListener() { // from class: com.baidu.live.gift.yuangift.a.9
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    if (a.this.bkc != null && a.this.bkc.bjX != null && j == a.this.currLiveId) {
                        boolean gV = b.JW().gV(a.this.bkc.previewGiftId + "");
                        boolean gV2 = b.JW().gV(a.this.bkc.bjX.Gx());
                        if (gV && gV2 && a.this.bkf != null && a.this.bkf.get() != null) {
                            Context context = (Context) a.this.bkf.get();
                            if (a.this.aU(context)) {
                                a.this.a(context, j, a.this.mRoomId, a.this.mVid, a.this.mOtherParams);
                                a.this.ay(b2, str);
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

    @Override // com.baidu.live.gift.ai
    public void a(int i, int i2, Intent intent, x xVar, String str) {
        if (25042 == i && intent != null && xVar != null && this.bkc != null) {
            a(intent.getIntExtra("result_code", -1), intent.getIntExtra("result_payinfo_status", -1), intent.getStringExtra("result_tbean_num"), this.bkc.bjX, xVar, str);
        }
    }

    private void a(int i, int i2, String str, g gVar, x xVar, String str2) {
        switch (i) {
            case 0:
                Log.i("LiveViewController", "@@ handlePayResult 成功");
                a(true, i2, str, gVar, xVar, str2);
                return;
            case 1:
                Log.i("LiveViewController", "@@ handlePayResult 取消");
                HashMap hashMap = new HashMap();
                hashMap.put("test_yuan_package_paysucc", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey("test_yuan_package_paysucc")) {
                    a(((Boolean) process.get("test_yuan_package_paysucc")).booleanValue(), i2, str, gVar, xVar, str2);
                    return;
                } else {
                    a(false, i2, str, gVar, xVar, str2);
                    return;
                }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                Log.i("LiveViewController", "@@ handlePayResult 其他");
                a(false, i2, str, gVar, xVar, str2);
                return;
            default:
                return;
        }
    }

    private void a(boolean z, int i, String str, g gVar, x xVar, String str2) {
        if (z) {
            BuyYinjiInfo buyYinjiInfo = new BuyYinjiInfo();
            buyYinjiInfo.setTBeanNum(str);
            buyYinjiInfo.setStatus(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS, buyYinjiInfo));
            BdUtilHelper.getCustomToast().showToast("购买成功", 0);
            if (xVar.mLiveInfo.live_id == this.currLiveId && gVar != null) {
                gVar.setSceneFrom(q.XG());
                a(gVar, 1L, xVar, str2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098));
                return;
            }
            return;
        }
        BdUtilHelper.getCustomToast().showToast("购买失败", 0);
        If();
    }

    private void a(g gVar, long j, x xVar, String str) {
        b.JW();
        b.a(gVar, j, xVar.aKu.userId + "", xVar.aKu.userName, xVar.mLiveInfo.live_id + "", xVar.mLiveInfo.room_id + "", xVar.mLiveInfo.appId + "", xVar.mLiveInfo.feed_id + "", str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(Context context) {
        return (UtilHelper.getRealScreenOrientation(context) == 2 || this.bkj) ? false : true;
    }

    @Override // com.baidu.live.gift.ai
    public void Hp() {
        if (this.bkh != null && this.bkh.isShowing() && UtilHelper.getRealScreenOrientation(this.bkh.getContext()) == 2) {
            If();
        }
    }
}
