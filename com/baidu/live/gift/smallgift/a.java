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
/* loaded from: classes10.dex */
public class a {
    private boolean aSt;
    private j aVu;
    private int baW;
    private int baX;
    private int baY;
    private boolean bcL;
    private ArrayList<c> bcM;
    private b bdL;
    private b bdM;
    private AlaSmallGiftView bdN;
    private AlaSmallGiftView bdO;
    private b.a bdP;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.bcL = false;
        this.bdP = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null) {
                    a.this.j(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void GR() {
                if (!a.this.GQ()) {
                    a.this.Et();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void w(c cVar) {
                if (cVar != null && cVar.aZN < cVar.aZM) {
                    a.this.j(cVar);
                    cVar.aZW = true;
                    if (a.this.aVu.a(cVar)) {
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
        this.aVu = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.aSt = z;
        this.bdN.setMode(z);
        this.bdO.setMode(z);
    }

    private void initData() {
        this.bcM = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.baW = (int) resources.getDimension(a.d.sdk_ds650);
        this.baX = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_small_gift_panel_layout, (ViewGroup) null);
        this.bdN = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift1);
        this.bdO = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift2);
        this.bdL = new b(this.bdN);
        this.bdL.a(this.bdP);
        this.bdM = new b(this.bdO);
        this.bdM.a(this.bdP);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aVu.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.baW, this.baX);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.baX);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.baY;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void df(int i) {
        this.baY = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.baY;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void Ex() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.bdL != null) {
            this.bdL.Ex();
        }
        if (this.bdM != null) {
            this.bdM.Ex();
        }
    }

    public void Do() {
        this.bcL = true;
        if (this.bdL != null) {
            this.bdL.Do();
        }
        if (this.bdM != null) {
            this.bdM.Do();
        }
        this.aVu.Dq();
    }

    public void Dp() {
        this.bcL = false;
        this.aVu.M(this.mRootView);
        if (this.bdL != null) {
            this.bdL.Dp();
        }
        if (this.bdM != null) {
            this.bdM.Dp();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aZH;
            if (!cVar.aZS && !cVar.aZT) {
                if (cVar.aZP || cVar.aZG) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.CC());
                        jSONObject.putOpt("gift_name", gVar.CD());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aZM));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aZP ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.bdL.A(cVar)) {
                z = true;
            } else if (this.bdM.A(cVar)) {
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
        Iterator<c> it = this.bcM.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aZI) && cVar.aZI.equals(cVar2.aZI) && Math.abs(cVar2.Fp() - cVar.Fp()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.aZM <= 99;
    }

    public static void d(c cVar, c cVar2) {
        w.a(cVar, cVar2);
        cVar.aZM += cVar2.aZM;
        cVar.aP(cVar2.Fp());
    }

    private void s(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            t(cVar);
            return;
        }
        this.bcM.add(cVar);
        if (cVar.aZP) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
        try {
            Er();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Et();
    }

    public void t(c cVar) {
        if (this.bcL) {
            u(cVar);
        } else if (!this.bdL.Hf() && this.bdL.x(cVar)) {
            this.bdL.z(cVar);
        } else if (!this.bdM.Hf() && this.bdM.x(cVar)) {
            this.bdM.z(cVar);
        } else {
            u(cVar);
            Et();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bcM.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.bcM.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.bcM.add(cVar);
        } else {
            this.bcM.add(i, cVar);
        }
        try {
            Er();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Er() {
        if (this.bcM != null) {
            int i = com.baidu.live.af.a.OJ().bru != null ? com.baidu.live.af.a.OJ().bru.aKj : 0;
            if (i > 0 && this.bcM.size() >= i) {
                Collections.sort(this.bcM, new c.a());
                ArrayList arrayList = new ArrayList(this.bcM.subList(0, Math.max((int) (i * 0.7f), 1)));
                if (this.bcM.removeAll(arrayList)) {
                    Iterator<c> it = this.bcM.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        l.a(next.giftId, next.userId, next.msgId, next.aZP);
                    }
                }
                this.bcM.clear();
                this.bcM.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Et() {
        if (!this.bcM.isEmpty() && !this.bcL) {
            if (this.bdL.isReady() || this.bdM.isReady()) {
                c remove = this.bcM.remove(0);
                if (remove != null) {
                    remove.aP(System.currentTimeMillis());
                    o(remove);
                    Et();
                    return;
                }
                Et();
            }
        }
    }

    private void o(c cVar) {
        if (this.bdL.isReady()) {
            this.bdL.y(cVar);
        } else if (this.bdM.isReady()) {
            this.bdM.y(cVar);
        }
        if (cVar.aZP) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
    }

    public boolean GQ() {
        return this.bcM.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(c cVar) {
        if (cVar != null && cVar.aZP) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aZN);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Fp());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aZW) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    public View Dt() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.bcL = false;
        if (this.bcM != null) {
            this.bcM.clear();
        }
        if (this.bdL != null) {
            this.bdL.onDestroy();
        }
        if (this.bdM != null) {
            this.bdM.onDestroy();
        }
        this.mContext = null;
    }
}
