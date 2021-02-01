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
import com.baidu.live.gift.j;
import com.baidu.live.gift.smallgift.b;
import com.baidu.live.gift.w;
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
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private boolean aVx;
    private j aYC;
    private int beb;
    private int bec;
    private int bed;
    private boolean bfU;
    private ArrayList<c> bfV;
    private b bgV;
    private b bgW;
    private AlaSmallGiftView bgX;
    private AlaSmallGiftView bgY;
    private b.a bgZ;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.bfU = false;
        this.bgZ = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null) {
                    a.this.j(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void Ih() {
                if (!a.this.Ig()) {
                    a.this.FJ();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void w(c cVar) {
                if (cVar != null && cVar.bcU < cVar.bcT) {
                    a.this.j(cVar);
                    cVar.bdd = true;
                    if (a.this.aYC.a(cVar)) {
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
                    a.this.u(cVar);
                }
            }
        };
        this.mContext = context;
        this.aYC = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.aVx = z;
        this.bgX.setMode(z);
        this.bgY.setMode(z);
    }

    private void initData() {
        this.bfV = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.beb = (int) resources.getDimension(a.d.sdk_ds650);
        this.bec = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_small_gift_panel_layout, (ViewGroup) null);
        this.bgX = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift1);
        this.bgY = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift2);
        this.bgV = new b(this.bgX);
        this.bgV.a(this.bgZ);
        this.bgW = new b(this.bgY);
        this.bgW.a(this.bgZ);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aYC.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.beb, this.bec);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            } else {
                layoutParams.addRule(12, 0);
            }
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds160);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.bec);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.bed;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void dk(int i) {
        this.bed = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.bed;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void FN() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.bgV != null) {
            this.bgV.FN();
        }
        if (this.bgW != null) {
            this.bgW.FN();
        }
    }

    public void EE() {
        this.bfU = true;
        if (this.bgV != null) {
            this.bgV.EE();
        }
        if (this.bgW != null) {
            this.bgW.EE();
        }
        this.aYC.EG();
    }

    public void EF() {
        this.bfU = false;
        this.aYC.M(this.mRootView);
        if (this.bgV != null) {
            this.bgV.EF();
        }
        if (this.bgW != null) {
            this.bgW.EF();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bcO;
            if (!cVar.bcZ && !cVar.bda) {
                if (cVar.bcW || cVar.bcN) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DR());
                        jSONObject.putOpt("gift_name", gVar.DS());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bcT));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bcW ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.bgV.A(cVar)) {
                z = true;
            } else if (this.bgW.A(cVar)) {
                z = true;
            }
            c(cVar, true);
            if (!z) {
                r(cVar);
            }
        }
    }

    private void r(c cVar) {
        boolean z;
        boolean z2 = false;
        Iterator<c> it = this.bfV.iterator();
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
            s(cVar);
        }
    }

    public static boolean c(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.bcP) && cVar.bcP.equals(cVar2.bcP) && Math.abs(cVar2.GF() - cVar.GF()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.bcT <= 99;
    }

    public static void d(c cVar, c cVar2) {
        w.a(cVar, cVar2);
        cVar.bcT += cVar2.bcT;
        cVar.aS(cVar2.GF());
    }

    private void s(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            t(cVar);
            return;
        }
        this.bfV.add(cVar);
        if (cVar.bcW) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
        try {
            FH();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FJ();
    }

    public void t(c cVar) {
        if (this.bfU) {
            u(cVar);
        } else if (!this.bgV.Iv() && this.bgV.x(cVar)) {
            this.bgV.z(cVar);
        } else if (!this.bgW.Iv() && this.bgW.x(cVar)) {
            this.bgW.z(cVar);
        } else {
            u(cVar);
            FJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bfV.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.bfV.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.bfV.add(cVar);
        } else {
            this.bfV.add(i, cVar);
        }
        try {
            FH();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void FH() {
        if (this.bfV != null) {
            int i = com.baidu.live.ae.a.Qj().buX != null ? com.baidu.live.ae.a.Qj().buX.aMW : 0;
            if (i > 0 && this.bfV.size() >= i) {
                Collections.sort(this.bfV, new c.a());
                ArrayList arrayList = new ArrayList(this.bfV.subList(0, Math.max((int) (i * 0.7f), 1)));
                if (this.bfV.removeAll(arrayList)) {
                    Iterator<c> it = this.bfV.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        l.a(next.giftId, next.userId, next.msgId, next.bcW);
                    }
                }
                this.bfV.clear();
                this.bfV.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (!this.bfV.isEmpty() && !this.bfU) {
            if (this.bgV.isReady() || this.bgW.isReady()) {
                c remove = this.bfV.remove(0);
                if (remove != null) {
                    remove.aS(System.currentTimeMillis());
                    o(remove);
                    FJ();
                    return;
                }
                FJ();
            }
        }
    }

    private void o(c cVar) {
        if (this.bgV.isReady()) {
            this.bgV.y(cVar);
        } else if (this.bgW.isReady()) {
            this.bgW.y(cVar);
        }
        if (cVar.bcW) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
    }

    public boolean Ig() {
        return this.bfV.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(c cVar) {
        if (cVar != null && cVar.bcW) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bcU);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.GF());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.bdd) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    public View EJ() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.bfU = false;
        if (this.bfV != null) {
            this.bfV.clear();
        }
        if (this.bgV != null) {
            this.bgV.onDestroy();
        }
        if (this.bgW != null) {
            this.bgW.onDestroy();
        }
        this.mContext = null;
    }

    public int getCacheSize() {
        if (this.bfV != null) {
            return this.bfV.size();
        }
        return 0;
    }

    public void clearCache() {
        if (this.bfV != null) {
            this.bfV.clear();
        }
    }
}
