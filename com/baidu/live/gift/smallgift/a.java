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
    private boolean aXg;
    private j bah;
    private int bfM;
    private int bfN;
    private int bfO;
    private boolean bhC;
    private ArrayList<c> bhD;
    private b biE;
    private b biF;
    private AlaSmallGiftView biG;
    private AlaSmallGiftView biH;
    private b.a biI;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.bhC = false;
        this.biI = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null) {
                    a.this.j(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void KM() {
                if (!a.this.KL()) {
                    a.this.Io();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void w(c cVar) {
                if (cVar != null && cVar.beD < cVar.beC) {
                    a.this.j(cVar);
                    cVar.beM = true;
                    if (a.this.bah.a(cVar)) {
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
        this.bah = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.aXg = z;
        this.biG.setMode(z);
        this.biH.setMode(z);
    }

    private void initData() {
        this.bhD = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.bfM = (int) resources.getDimension(a.d.sdk_ds650);
        this.bfN = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_small_gift_panel_layout, (ViewGroup) null);
        this.biG = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift1);
        this.biH = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift2);
        this.biE = new b(this.biG);
        this.biE.a(this.biI);
        this.biF = new b(this.biH);
        this.biF.a(this.biI);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.bah.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bfM, this.bfN);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.bfN);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.bfO;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void eL(int i) {
        this.bfO = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.bfO;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void Is() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.biE != null) {
            this.biE.Is();
        }
        if (this.biF != null) {
            this.biF.Is();
        }
    }

    public void Hj() {
        this.bhC = true;
        if (this.biE != null) {
            this.biE.Hj();
        }
        if (this.biF != null) {
            this.biF.Hj();
        }
        this.bah.Hl();
    }

    public void Hk() {
        this.bhC = false;
        this.bah.M(this.mRootView);
        if (this.biE != null) {
            this.biE.Hk();
        }
        if (this.biF != null) {
            this.biF.Hk();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bex;
            if (!cVar.beI && !cVar.beJ) {
                if (cVar.beF || cVar.bew) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Gx());
                        jSONObject.putOpt("gift_name", gVar.Gy());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.beC));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.beF ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.biE.A(cVar)) {
                z = true;
            } else if (this.biF.A(cVar)) {
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
        Iterator<c> it = this.bhD.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.bey) && cVar.bey.equals(cVar2.bey) && Math.abs(cVar2.Jk() - cVar.Jk()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.beC <= 99;
    }

    public static void d(c cVar, c cVar2) {
        w.a(cVar, cVar2);
        cVar.beC += cVar2.beC;
        cVar.aP(cVar2.Jk());
    }

    private void s(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            t(cVar);
            return;
        }
        this.bhD.add(cVar);
        if (cVar.beF) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
        try {
            Im();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Io();
    }

    public void t(c cVar) {
        if (this.bhC) {
            u(cVar);
        } else if (!this.biE.La() && this.biE.x(cVar)) {
            this.biE.z(cVar);
        } else if (!this.biF.La() && this.biF.x(cVar)) {
            this.biF.z(cVar);
        } else {
            u(cVar);
            Io();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bhD.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.bhD.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.bhD.add(cVar);
        } else {
            this.bhD.add(i, cVar);
        }
        try {
            Im();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Im() {
        if (this.bhD != null) {
            int i = com.baidu.live.af.a.SE().bwi != null ? com.baidu.live.af.a.SE().bwi.aOW : 0;
            if (i > 0 && this.bhD.size() >= i) {
                Collections.sort(this.bhD, new c.a());
                ArrayList arrayList = new ArrayList(this.bhD.subList(0, Math.max((int) (i * 0.7f), 1)));
                if (this.bhD.removeAll(arrayList)) {
                    Iterator<c> it = this.bhD.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        l.a(next.giftId, next.userId, next.msgId, next.beF);
                    }
                }
                this.bhD.clear();
                this.bhD.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        if (!this.bhD.isEmpty() && !this.bhC) {
            if (this.biE.isReady() || this.biF.isReady()) {
                c remove = this.bhD.remove(0);
                if (remove != null) {
                    remove.aP(System.currentTimeMillis());
                    o(remove);
                    Io();
                    return;
                }
                Io();
            }
        }
    }

    private void o(c cVar) {
        if (this.biE.isReady()) {
            this.biE.y(cVar);
        } else if (this.biF.isReady()) {
            this.biF.y(cVar);
        }
        if (cVar.beF) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
    }

    public boolean KL() {
        return this.bhD.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(c cVar) {
        if (cVar != null && cVar.beF) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.beD);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Jk());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.beM) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    public View Ho() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.bhC = false;
        if (this.bhD != null) {
            this.bhD.clear();
        }
        if (this.biE != null) {
            this.biE.onDestroy();
        }
        if (this.biF != null) {
            this.biF.onDestroy();
        }
        this.mContext = null;
    }
}
