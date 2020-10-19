package com.baidu.live.gift.smallgift;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
import com.baidu.live.gift.r;
import com.baidu.live.gift.smallgift.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcDebugItem;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean aRV;
    private k aUo;
    private int aZu;
    private int aZv;
    private int aZw;
    private boolean baY;
    private ArrayList<c> baZ;
    private b bbZ;
    private b bca;
    private AlaSmallGiftView bcb;
    private AlaSmallGiftView bcc;
    private b.a bcd;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.baY = false;
        this.bcd = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void Jc() {
                if (!a.this.Jb()) {
                    a.this.GI();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.aYu < cVar.aYt) {
                    a.this.i(cVar);
                    cVar.aYA = true;
                    if (a.this.aUo.a(cVar)) {
                        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            cVar.priority = 10;
                        } else {
                            cVar.priority = 8;
                        }
                    } else if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        cVar.priority = 4;
                    } else {
                        cVar.priority = 2;
                    }
                    a.this.t(cVar);
                }
            }
        };
        this.mContext = context;
        this.aUo = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.aRV = z;
        this.bcb.setMode(z);
        this.bcc.setMode(z);
    }

    private void initData() {
        this.baZ = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aZu = (int) resources.getDimension(a.e.sdk_ds650);
        this.aZv = resources.getDimensionPixelOffset(a.e.sdk_ds12) + (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.bcb = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.bcc = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.bbZ = new b(this.bcb);
        this.bbZ.a(this.bcd);
        this.bca = new b(this.bcc);
        this.bca.a(this.bcd);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aUo.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aZu, this.aZv);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            } else {
                layoutParams.addRule(12, 0);
            }
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aZv);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.aZw;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void ev(int i) {
        this.aZw = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.aZw;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void GM() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.bbZ != null) {
            this.bbZ.GM();
        }
        if (this.bca != null) {
            this.bca.GM();
        }
    }

    public void FM() {
        this.baY = true;
        if (this.bbZ != null) {
            this.bbZ.FM();
        }
        if (this.bca != null) {
            this.bca.FM();
        }
        this.aUo.FO();
    }

    public void FN() {
        this.baY = false;
        this.aUo.M(this.mRootView);
        if (this.bbZ != null) {
            this.bbZ.FN();
        }
        if (this.bca != null) {
            this.bca.FN();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aYo;
            if (!cVar.aYy && !cVar.aYz) {
                if (cVar.aYv || cVar.aYn) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fd());
                        jSONObject.putOpt("gift_name", gVar.Fe());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aYt));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aYv ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.bbZ.z(cVar)) {
                z = true;
            } else if (this.bca.z(cVar)) {
                z = true;
            }
            c(cVar, true);
            if (!z) {
                q(cVar);
            }
        }
    }

    private void q(c cVar) {
        boolean z;
        boolean z2 = false;
        Iterator<c> it = this.baZ.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (c(next, cVar)) {
                z = true;
                d(next, cVar);
            }
            z2 = z;
        }
        if (!z) {
            r(cVar);
        }
    }

    public static boolean c(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.aYp) && cVar.aYp.equals(cVar2.aYp) && Math.abs(cVar2.HE() - cVar.HE()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.aYt <= 99;
    }

    public static void d(c cVar, c cVar2) {
        r.a(cVar, cVar2);
        cVar.aYt += cVar2.aYt;
        cVar.af(cVar2.HE());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.baZ.add(cVar);
        if (cVar.aYv) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aHY, cVar.aHZ, cVar.giftId, "");
        }
        try {
            GF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GI();
    }

    public void s(c cVar) {
        if (this.baY) {
            t(cVar);
        } else if (!this.bbZ.Jq() && this.bbZ.w(cVar)) {
            this.bbZ.y(cVar);
        } else if (!this.bca.Jq() && this.bca.w(cVar)) {
            this.bca.y(cVar);
        } else {
            t(cVar);
            GI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.baZ.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.baZ.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.baZ.add(cVar);
        } else {
            this.baZ.add(i, cVar);
        }
        try {
            GF();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GF() {
        if (this.baZ != null) {
            int i = com.baidu.live.x.a.OS().blo != null ? com.baidu.live.x.a.OS().blo.aLB : 0;
            if (i > 0 && this.baZ.size() >= i) {
                Collections.sort(this.baZ, new c.a());
                ArrayList arrayList = new ArrayList(this.baZ.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.baZ.clear();
                this.baZ.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI() {
        if (!this.baZ.isEmpty() && !this.baY) {
            if (this.bbZ.isReady() || this.bca.isReady()) {
                c remove = this.baZ.remove(0);
                if (remove != null) {
                    remove.af(System.currentTimeMillis());
                    n(remove);
                    GI();
                    return;
                }
                GI();
            }
        }
    }

    private void n(c cVar) {
        if (this.bbZ.isReady()) {
            this.bbZ.x(cVar);
        } else if (this.bca.isReady()) {
            this.bca.x(cVar);
        }
        if (cVar.aYv) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aHY, cVar.aHZ, cVar.giftId, "");
        }
    }

    public boolean Jb() {
        return this.baZ.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aYv) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aYu);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.HE());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aYA) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View FR() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.baY = false;
        if (this.baZ != null) {
            this.baZ.clear();
        }
        if (this.bbZ != null) {
            this.bbZ.onDestroy();
        }
        if (this.bca != null) {
            this.bca.onDestroy();
        }
        this.mContext = null;
    }
}
