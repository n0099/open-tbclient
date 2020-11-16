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
import com.baidu.live.gift.v;
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
    private boolean aSy;
    private j aVq;
    private int baA;
    private int baB;
    private int baz;
    private boolean bbT;
    private ArrayList<c> bbU;
    private b bcV;
    private b bcW;
    private AlaSmallGiftView bcX;
    private AlaSmallGiftView bcY;
    private b.a bcZ;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.bbT = false;
        this.bcZ = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void Jm() {
                if (!a.this.Jl()) {
                    a.this.GW();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.aZx < cVar.aZw) {
                    a.this.i(cVar);
                    cVar.aZF = true;
                    if (a.this.aVq.a(cVar)) {
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
        this.aVq = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.aSy = z;
        this.bcX.setMode(z);
        this.bcY.setMode(z);
    }

    private void initData() {
        this.bbU = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.baz = (int) resources.getDimension(a.d.sdk_ds650);
        this.baA = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_small_gift_panel_layout, (ViewGroup) null);
        this.bcX = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift1);
        this.bcY = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift2);
        this.bcV = new b(this.bcX);
        this.bcV.a(this.bcZ);
        this.bcW = new b(this.bcY);
        this.bcW.a(this.bcZ);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aVq.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.baz, this.baA);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.baA);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.baB;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void es(int i) {
        this.baB = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.baB;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void Ha() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.bcV != null) {
            this.bcV.Ha();
        }
        if (this.bcW != null) {
            this.bcW.Ha();
        }
    }

    public void FT() {
        this.bbT = true;
        if (this.bcV != null) {
            this.bcV.FT();
        }
        if (this.bcW != null) {
            this.bcW.FT();
        }
        this.aVq.FV();
    }

    public void FU() {
        this.bbT = false;
        this.aVq.M(this.mRootView);
        if (this.bcV != null) {
            this.bcV.FU();
        }
        if (this.bcW != null) {
            this.bcW.FU();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aZq;
            if (!cVar.aZB && !cVar.aZC) {
                if (cVar.aZy || cVar.aZp) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fk());
                        jSONObject.putOpt("gift_name", gVar.Fl());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aZw));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aZy ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.bcV.z(cVar)) {
                z = true;
            } else if (this.bcW.z(cVar)) {
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
        Iterator<c> it = this.bbU.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aZr) && cVar.aZr.equals(cVar2.aZr) && Math.abs(cVar2.HR() - cVar.HR()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.aZw <= 99;
    }

    public static void d(c cVar, c cVar2) {
        v.a(cVar, cVar2);
        cVar.aZw += cVar2.aZw;
        cVar.as(cVar2.HR());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.bbU.add(cVar);
        if (cVar.aZy) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
        try {
            GT();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GW();
    }

    public void s(c cVar) {
        if (this.bbT) {
            t(cVar);
        } else if (!this.bcV.JA() && this.bcV.w(cVar)) {
            this.bcV.y(cVar);
        } else if (!this.bcW.JA() && this.bcW.w(cVar)) {
            this.bcW.y(cVar);
        } else {
            t(cVar);
            GW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bbU.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.bbU.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.bbU.add(cVar);
        } else {
            this.bbU.add(i, cVar);
        }
        try {
            GT();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GT() {
        if (this.bbU != null) {
            int i = com.baidu.live.aa.a.Ph().bms != null ? com.baidu.live.aa.a.Ph().bms.aLu : 0;
            if (i > 0 && this.bbU.size() >= i) {
                Collections.sort(this.bbU, new c.a());
                ArrayList arrayList = new ArrayList(this.bbU.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.bbU.clear();
                this.bbU.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW() {
        if (!this.bbU.isEmpty() && !this.bbT) {
            if (this.bcV.isReady() || this.bcW.isReady()) {
                c remove = this.bbU.remove(0);
                if (remove != null) {
                    remove.as(System.currentTimeMillis());
                    n(remove);
                    GW();
                    return;
                }
                GW();
            }
        }
    }

    private void n(c cVar) {
        if (this.bcV.isReady()) {
            this.bcV.x(cVar);
        } else if (this.bcW.isReady()) {
            this.bcW.x(cVar);
        }
        if (cVar.aZy) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
    }

    public boolean Jl() {
        return this.bbU.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aZy) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aZx);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.HR());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aZF) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View FY() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.bbT = false;
        if (this.bbU != null) {
            this.bbU.clear();
        }
        if (this.bcV != null) {
            this.bcV.onDestroy();
        }
        if (this.bcW != null) {
            this.bcW.onDestroy();
        }
        this.mContext = null;
    }
}
