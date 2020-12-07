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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean aVA;
    private j aYB;
    private int bdZ;
    private int bea;
    private int beb;
    private boolean bfT;
    private ArrayList<c> bfU;
    private b bgW;
    private b bgX;
    private AlaSmallGiftView bgY;
    private AlaSmallGiftView bgZ;
    private b.a bha;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.bfT = false;
        this.bha = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void Ln() {
                if (!a.this.Lm()) {
                    a.this.IN();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.bcV < cVar.bcU) {
                    a.this.i(cVar);
                    cVar.bde = true;
                    if (a.this.aYB.a(cVar)) {
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
        this.aYB = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.aVA = z;
        this.bgY.setMode(z);
        this.bgZ.setMode(z);
    }

    private void initData() {
        this.bfU = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.bdZ = (int) resources.getDimension(a.d.sdk_ds650);
        this.bea = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_small_gift_panel_layout, (ViewGroup) null);
        this.bgY = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift1);
        this.bgZ = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift2);
        this.bgW = new b(this.bgY);
        this.bgW.a(this.bha);
        this.bgX = new b(this.bgZ);
        this.bgX.a(this.bha);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aYB.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bdZ, this.bea);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.bea);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.beb;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void eN(int i) {
        this.beb = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.beb;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void IR() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.bgW != null) {
            this.bgW.IR();
        }
        if (this.bgX != null) {
            this.bgX.IR();
        }
    }

    public void HI() {
        this.bfT = true;
        if (this.bgW != null) {
            this.bgW.HI();
        }
        if (this.bgX != null) {
            this.bgX.HI();
        }
        this.aYB.HK();
    }

    public void HJ() {
        this.bfT = false;
        this.aYB.M(this.mRootView);
        if (this.bgW != null) {
            this.bgW.HJ();
        }
        if (this.bgX != null) {
            this.bgX.HJ();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bcN;
            if (!cVar.bda && !cVar.bdb) {
                if (cVar.bcX || cVar.bcM) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.GX());
                        jSONObject.putOpt("gift_name", gVar.GY());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bcU));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bcX ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.bgW.z(cVar)) {
                z = true;
            } else if (this.bgX.z(cVar)) {
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
        Iterator<c> it = this.bfU.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.bcO) && cVar.bcO.equals(cVar2.bcO) && Math.abs(cVar2.JI() - cVar.JI()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.bcU <= 99;
    }

    public static void d(c cVar, c cVar2) {
        w.a(cVar, cVar2);
        cVar.bcU += cVar2.bcU;
        cVar.aQ(cVar2.JI());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.bfU.add(cVar);
        if (cVar.bcX) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
        try {
            IK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        IN();
    }

    public void s(c cVar) {
        if (this.bfT) {
            t(cVar);
        } else if (!this.bgW.LB() && this.bgW.w(cVar)) {
            this.bgW.y(cVar);
        } else if (!this.bgX.LB() && this.bgX.w(cVar)) {
            this.bgX.y(cVar);
        } else {
            t(cVar);
            IN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bfU.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.bfU.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.bfU.add(cVar);
        } else {
            this.bfU.add(i, cVar);
        }
        try {
            IK();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void IK() {
        if (this.bfU != null) {
            int i = com.baidu.live.ae.a.RB().brA != null ? com.baidu.live.ae.a.RB().brA.aOp : 0;
            if (i > 0 && this.bfU.size() >= i) {
                Collections.sort(this.bfU, new c.a());
                ArrayList arrayList = new ArrayList(this.bfU.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.bfU.clear();
                this.bfU.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        if (!this.bfU.isEmpty() && !this.bfT) {
            if (this.bgW.isReady() || this.bgX.isReady()) {
                c remove = this.bfU.remove(0);
                if (remove != null) {
                    remove.aQ(System.currentTimeMillis());
                    n(remove);
                    IN();
                    return;
                }
                IN();
            }
        }
    }

    private void n(c cVar) {
        if (this.bgW.isReady()) {
            this.bgW.x(cVar);
        } else if (this.bgX.isReady()) {
            this.bgX.x(cVar);
        }
        if (cVar.bcX) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
    }

    public boolean Lm() {
        return this.bfU.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.bcX) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bcV);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.JI());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.bde) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View HN() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.bfT = false;
        if (this.bfU != null) {
            this.bfU.clear();
        }
        if (this.bgW != null) {
            this.bgW.onDestroy();
        }
        if (this.bgX != null) {
            this.bgX.onDestroy();
        }
        this.mContext = null;
    }
}
