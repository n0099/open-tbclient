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
    private boolean aWX;
    private j bac;
    private int bfF;
    private int bfG;
    private int bfH;
    private boolean bhv;
    private ArrayList<c> bhw;
    private AlaSmallGiftView biA;
    private b.a biB;
    private b bix;
    private b biy;
    private AlaSmallGiftView biz;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.bhv = false;
        this.biB = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null) {
                    a.this.j(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void Ik() {
                if (!a.this.Ij()) {
                    a.this.FM();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void w(c cVar) {
                if (cVar != null && cVar.bew < cVar.bev) {
                    a.this.j(cVar);
                    cVar.beF = true;
                    if (a.this.bac.a(cVar)) {
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
        this.bac = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.aWX = z;
        this.biz.setMode(z);
        this.biA.setMode(z);
    }

    private void initData() {
        this.bhw = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.bfF = (int) resources.getDimension(a.d.sdk_ds650);
        this.bfG = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_small_gift_panel_layout, (ViewGroup) null);
        this.biz = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift1);
        this.biA = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift2);
        this.bix = new b(this.biz);
        this.bix.a(this.biB);
        this.biy = new b(this.biA);
        this.biy.a(this.biB);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.bac.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bfF, this.bfG);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.bfG);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.bfH;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void dl(int i) {
        this.bfH = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.bfH;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void FQ() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.bix != null) {
            this.bix.FQ();
        }
        if (this.biy != null) {
            this.biy.FQ();
        }
    }

    public void EH() {
        this.bhv = true;
        if (this.bix != null) {
            this.bix.EH();
        }
        if (this.biy != null) {
            this.biy.EH();
        }
        this.bac.EJ();
    }

    public void EI() {
        this.bhv = false;
        this.bac.M(this.mRootView);
        if (this.bix != null) {
            this.bix.EI();
        }
        if (this.biy != null) {
            this.biy.EI();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bep;
            if (!cVar.beB && !cVar.beC) {
                if (cVar.bey || cVar.beo) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DU());
                        jSONObject.putOpt("gift_name", gVar.DV());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bev));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bey ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.bix.A(cVar)) {
                z = true;
            } else if (this.biy.A(cVar)) {
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
        Iterator<c> it = this.bhw.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.beq) && cVar.beq.equals(cVar2.beq) && Math.abs(cVar2.GI() - cVar.GI()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.bev <= 99;
    }

    public static void d(c cVar, c cVar2) {
        w.a(cVar, cVar2);
        cVar.bev += cVar2.bev;
        cVar.aS(cVar2.GI());
    }

    private void s(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            t(cVar);
            return;
        }
        this.bhw.add(cVar);
        if (cVar.bey) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
        try {
            FK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FM();
    }

    public void t(c cVar) {
        if (this.bhv) {
            u(cVar);
        } else if (!this.bix.Iy() && this.bix.x(cVar)) {
            this.bix.z(cVar);
        } else if (!this.biy.Iy() && this.biy.x(cVar)) {
            this.biy.z(cVar);
        } else {
            u(cVar);
            FM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bhw.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.bhw.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.bhw.add(cVar);
        } else {
            this.bhw.add(i, cVar);
        }
        try {
            FK();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void FK() {
        if (this.bhw != null) {
            int i = com.baidu.live.ae.a.Qm().bwx != null ? com.baidu.live.ae.a.Qm().bwx.aOw : 0;
            if (i > 0 && this.bhw.size() >= i) {
                Collections.sort(this.bhw, new c.a());
                ArrayList arrayList = new ArrayList(this.bhw.subList(0, Math.max((int) (i * 0.7f), 1)));
                if (this.bhw.removeAll(arrayList)) {
                    Iterator<c> it = this.bhw.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        l.a(next.giftId, next.userId, next.msgId, next.bey);
                    }
                }
                this.bhw.clear();
                this.bhw.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (!this.bhw.isEmpty() && !this.bhv) {
            if (this.bix.isReady() || this.biy.isReady()) {
                c remove = this.bhw.remove(0);
                if (remove != null) {
                    remove.aS(System.currentTimeMillis());
                    o(remove);
                    FM();
                    return;
                }
                FM();
            }
        }
    }

    private void o(c cVar) {
        if (this.bix.isReady()) {
            this.bix.y(cVar);
        } else if (this.biy.isReady()) {
            this.biy.y(cVar);
        }
        if (cVar.bey) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
    }

    public boolean Ij() {
        return this.bhw.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(c cVar) {
        if (cVar != null && cVar.bey) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bew);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.GI());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.beF) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    public View EM() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.bhv = false;
        if (this.bhw != null) {
            this.bhw.clear();
        }
        if (this.bix != null) {
            this.bix.onDestroy();
        }
        if (this.biy != null) {
            this.biy.onDestroy();
        }
        this.mContext = null;
    }

    public int getCacheSize() {
        if (this.bhw != null) {
            return this.bhw.size();
        }
        return 0;
    }

    public void clearCache() {
        if (this.bhw != null) {
            this.bhw.clear();
        }
    }
}
