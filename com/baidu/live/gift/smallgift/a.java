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
    private boolean aOK;
    private k aRd;
    private int aWj;
    private int aWk;
    private int aWl;
    private boolean aXE;
    private ArrayList<c> aXF;
    private b aYF;
    private b aYG;
    private AlaSmallGiftView aYH;
    private AlaSmallGiftView aYI;
    private b.a aYJ;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.aXE = false;
        this.aYJ = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void If() {
                if (!a.this.Ie()) {
                    a.this.FM();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.aVj < cVar.aVi) {
                    a.this.i(cVar);
                    cVar.aVp = true;
                    if (a.this.aRd.a(cVar)) {
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
        this.aRd = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.aOK = z;
        this.aYH.setMode(z);
        this.aYI.setMode(z);
    }

    private void initData() {
        this.aXF = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aWj = (int) resources.getDimension(a.e.sdk_ds650);
        this.aWk = resources.getDimensionPixelOffset(a.e.sdk_ds12) + (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aYH = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aYI = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aYF = new b(this.aYH);
        this.aYF.a(this.aYJ);
        this.aYG = new b(this.aYI);
        this.aYG.a(this.aYJ);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aRd.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aWj, this.aWk);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aWk);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.aWl;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void eq(int i) {
        this.aWl = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.aWl;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void FQ() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aYF != null) {
            this.aYF.FQ();
        }
        if (this.aYG != null) {
            this.aYG.FQ();
        }
    }

    public void EQ() {
        this.aXE = true;
        if (this.aYF != null) {
            this.aYF.EQ();
        }
        if (this.aYG != null) {
            this.aYG.EQ();
        }
        this.aRd.ES();
    }

    public void ER() {
        this.aXE = false;
        this.aRd.M(this.mRootView);
        if (this.aYF != null) {
            this.aYF.ER();
        }
        if (this.aYG != null) {
            this.aYG.ER();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aVd;
            if (!cVar.aVn && !cVar.aVo) {
                if (cVar.aVk || cVar.aVc) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Eh());
                        jSONObject.putOpt("gift_name", gVar.Ei());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aVi));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aVk ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.aYF.z(cVar)) {
                z = true;
            } else if (this.aYG.z(cVar)) {
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
        Iterator<c> it = this.aXF.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aVe) && cVar.aVe.equals(cVar2.aVe) && Math.abs(cVar2.GI() - cVar.GI()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.aVi <= 99;
    }

    public static void d(c cVar, c cVar2) {
        r.a(cVar, cVar2);
        cVar.aVi += cVar2.aVi;
        cVar.ad(cVar2.GI());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.aXF.add(cVar);
        if (cVar.aVk) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aEU, cVar.aEV, cVar.giftId, "");
        }
        try {
            FJ();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FM();
    }

    public void s(c cVar) {
        if (this.aXE) {
            t(cVar);
        } else if (!this.aYF.It() && this.aYF.w(cVar)) {
            this.aYF.y(cVar);
        } else if (!this.aYG.It() && this.aYG.w(cVar)) {
            this.aYG.y(cVar);
        } else {
            t(cVar);
            FM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.aXF.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.aXF.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.aXF.add(cVar);
        } else {
            this.aXF.add(i, cVar);
        }
        try {
            FJ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void FJ() {
        if (this.aXF != null) {
            int i = com.baidu.live.x.a.NN().bhy != null ? com.baidu.live.x.a.NN().bhy.aIx : 0;
            if (i > 0 && this.aXF.size() >= i) {
                Collections.sort(this.aXF, new c.a());
                ArrayList arrayList = new ArrayList(this.aXF.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.aXF.clear();
                this.aXF.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (!this.aXF.isEmpty() && !this.aXE) {
            if (this.aYF.isReady() || this.aYG.isReady()) {
                c remove = this.aXF.remove(0);
                if (remove != null) {
                    remove.ad(System.currentTimeMillis());
                    n(remove);
                    FM();
                    return;
                }
                FM();
            }
        }
    }

    private void n(c cVar) {
        if (this.aYF.isReady()) {
            this.aYF.x(cVar);
        } else if (this.aYG.isReady()) {
            this.aYG.x(cVar);
        }
        if (cVar.aVk) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aEU, cVar.aEV, cVar.giftId, "");
        }
    }

    public boolean Ie() {
        return this.aXF.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aVk) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aVj);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.GI());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aVp) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View EV() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.aXE = false;
        if (this.aXF != null) {
            this.aXF.clear();
        }
        if (this.aYF != null) {
            this.aYF.onDestroy();
        }
        if (this.aYG != null) {
            this.aYG.onDestroy();
        }
        this.mContext = null;
    }
}
