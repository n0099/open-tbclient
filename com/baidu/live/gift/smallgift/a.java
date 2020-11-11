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
    private boolean aUj;
    private j aXb;
    private int bck;
    private int bcl;
    private int bcm;
    private boolean bdE;
    private ArrayList<c> bdF;
    private b beI;
    private b beJ;
    private AlaSmallGiftView beK;
    private AlaSmallGiftView beL;
    private b.a beM;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.bdE = false;
        this.beM = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void JV() {
                if (!a.this.JU()) {
                    a.this.HF();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.bbj < cVar.bbi) {
                    a.this.i(cVar);
                    cVar.bbr = true;
                    if (a.this.aXb.a(cVar)) {
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
        this.aXb = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.aUj = z;
        this.beK.setMode(z);
        this.beL.setMode(z);
    }

    private void initData() {
        this.bdF = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.bck = (int) resources.getDimension(a.d.sdk_ds650);
        this.bcl = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_small_gift_panel_layout, (ViewGroup) null);
        this.beK = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift1);
        this.beL = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift2);
        this.beI = new b(this.beK);
        this.beI.a(this.beM);
        this.beJ = new b(this.beL);
        this.beJ.a(this.beM);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aXb.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bck, this.bcl);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.bcl);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.bcm;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void ew(int i) {
        this.bcm = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.bcm;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void HJ() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.beI != null) {
            this.beI.HJ();
        }
        if (this.beJ != null) {
            this.beJ.HJ();
        }
    }

    public void GC() {
        this.bdE = true;
        if (this.beI != null) {
            this.beI.GC();
        }
        if (this.beJ != null) {
            this.beJ.GC();
        }
        this.aXb.GE();
    }

    public void GD() {
        this.bdE = false;
        this.aXb.M(this.mRootView);
        if (this.beI != null) {
            this.beI.GD();
        }
        if (this.beJ != null) {
            this.beJ.GD();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bbc;
            if (!cVar.bbn && !cVar.bbo) {
                if (cVar.bbk || cVar.bbb) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.FT());
                        jSONObject.putOpt("gift_name", gVar.FU());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bbi));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bbk ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.beI.z(cVar)) {
                z = true;
            } else if (this.beJ.z(cVar)) {
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
        Iterator<c> it = this.bdF.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.bbd) && cVar.bbd.equals(cVar2.bbd) && Math.abs(cVar2.IA() - cVar.IA()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.bbi <= 99;
    }

    public static void d(c cVar, c cVar2) {
        v.a(cVar, cVar2);
        cVar.bbi += cVar2.bbi;
        cVar.as(cVar2.IA());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.bdF.add(cVar);
        if (cVar.bbk) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
        try {
            HC();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HF();
    }

    public void s(c cVar) {
        if (this.bdE) {
            t(cVar);
        } else if (!this.beI.Kj() && this.beI.w(cVar)) {
            this.beI.y(cVar);
        } else if (!this.beJ.Kj() && this.beJ.w(cVar)) {
            this.beJ.y(cVar);
        } else {
            t(cVar);
            HF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bdF.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.bdF.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.bdF.add(cVar);
        } else {
            this.bdF.add(i, cVar);
        }
        try {
            HC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void HC() {
        if (this.bdF != null) {
            int i = com.baidu.live.aa.a.PQ().bod != null ? com.baidu.live.aa.a.PQ().bod.aNf : 0;
            if (i > 0 && this.bdF.size() >= i) {
                Collections.sort(this.bdF, new c.a());
                ArrayList arrayList = new ArrayList(this.bdF.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.bdF.clear();
                this.bdF.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HF() {
        if (!this.bdF.isEmpty() && !this.bdE) {
            if (this.beI.isReady() || this.beJ.isReady()) {
                c remove = this.bdF.remove(0);
                if (remove != null) {
                    remove.as(System.currentTimeMillis());
                    n(remove);
                    HF();
                    return;
                }
                HF();
            }
        }
    }

    private void n(c cVar) {
        if (this.beI.isReady()) {
            this.beI.x(cVar);
        } else if (this.beJ.isReady()) {
            this.beJ.x(cVar);
        }
        if (cVar.bbk) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
    }

    public boolean JU() {
        return this.bdF.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.bbk) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bbj);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.IA());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.bbr) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View GH() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.bdE = false;
        if (this.bdF != null) {
            this.bdF.clear();
        }
        if (this.beI != null) {
            this.beI.onDestroy();
        }
        if (this.beJ != null) {
            this.beJ.onDestroy();
        }
        this.mContext = null;
    }
}
