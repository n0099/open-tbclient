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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private boolean aMQ;
    private k aOZ;
    private int aTS;
    private int aTT;
    private int aTU;
    private boolean aVj;
    private ArrayList<c> aVk;
    private b aWj;
    private b aWk;
    private AlaSmallGiftView aWl;
    private AlaSmallGiftView aWm;
    private b.a aWn;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.aVj = false;
        this.aWn = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void HD() {
                if (!a.this.HC()) {
                    a.this.Fm();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.aSV < cVar.aSU) {
                    a.this.i(cVar);
                    cVar.aTb = true;
                    if (a.this.aOZ.a(cVar)) {
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
        this.aOZ = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.aMQ = z;
        this.aWl.setMode(z);
        this.aWm.setMode(z);
    }

    private void initData() {
        this.aVk = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aTS = (int) resources.getDimension(a.e.sdk_ds650);
        this.aTT = resources.getDimensionPixelOffset(a.e.sdk_ds12) + (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aWl = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aWm = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aWj = new b(this.aWl);
        this.aWj.a(this.aWn);
        this.aWk = new b(this.aWm);
        this.aWk.a(this.aWn);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aOZ.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aTS, this.aTT);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aTT);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.aTU;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void em(int i) {
        this.aTU = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.aTU;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void Fq() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aWj != null) {
            this.aWj.Fq();
        }
        if (this.aWk != null) {
            this.aWk.Fq();
        }
    }

    public void Ez() {
        this.aVj = true;
        if (this.aWj != null) {
            this.aWj.Ez();
        }
        if (this.aWk != null) {
            this.aWk.Ez();
        }
        this.aOZ.EB();
    }

    public void EA() {
        this.aVj = false;
        this.aOZ.M(this.mRootView);
        if (this.aWj != null) {
            this.aWj.EA();
        }
        if (this.aWk != null) {
            this.aWk.EA();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aWj.z(cVar) && !this.aWk.z(cVar)) {
                z = false;
            }
            if (!z) {
                q(cVar);
            }
        }
    }

    private void q(c cVar) {
        boolean z;
        boolean z2 = false;
        Iterator<c> it = this.aVk.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aSR) && cVar.aSR.equals(cVar2.aSR) && Math.abs(cVar2.Gi() - cVar.Gi()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.aSU <= 99;
    }

    public static void d(c cVar, c cVar2) {
        r.a(cVar, cVar2);
        cVar.aSU += cVar2.aSU;
        cVar.ae(cVar2.Gi());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.aVk.add(cVar);
        if (cVar.aSW) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aDW, cVar.aDX, cVar.giftId, "");
        }
        try {
            Fj();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Fm();
    }

    public void s(c cVar) {
        if (this.aVj) {
            t(cVar);
        } else if (!this.aWj.HR() && this.aWj.w(cVar)) {
            this.aWj.y(cVar);
        } else if (!this.aWk.HR() && this.aWk.w(cVar)) {
            this.aWk.y(cVar);
        } else {
            t(cVar);
            Fm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.aVk.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.aVk.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.aVk.add(cVar);
        } else {
            this.aVk.add(i, cVar);
        }
        try {
            Fj();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Fj() {
        if (this.aVk != null) {
            int i = com.baidu.live.w.a.Nk().beH != null ? com.baidu.live.w.a.Nk().beH.aHe : 0;
            if (i > 0 && this.aVk.size() >= i) {
                Collections.sort(this.aVk, new c.a());
                ArrayList arrayList = new ArrayList(this.aVk.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.aVk.clear();
                this.aVk.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        if (!this.aVk.isEmpty() && !this.aVj) {
            if (this.aWj.isReady() || this.aWk.isReady()) {
                c remove = this.aVk.remove(0);
                if (remove != null) {
                    remove.ae(System.currentTimeMillis());
                    n(remove);
                    Fm();
                    return;
                }
                Fm();
            }
        }
    }

    private void n(c cVar) {
        if (this.aWj.isReady()) {
            this.aWj.x(cVar);
        } else if (this.aWk.isReady()) {
            this.aWk.x(cVar);
        }
        if (cVar.aSW) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aDW, cVar.aDX, cVar.giftId, "");
        }
    }

    public boolean HC() {
        return this.aVk.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aSW) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aSV);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Gi());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aTb) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View EE() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.aVj = false;
        if (this.aVk != null) {
            this.aVk.clear();
        }
        if (this.aWj != null) {
            this.aWj.onDestroy();
        }
        if (this.aWk != null) {
            this.aWk.onDestroy();
        }
        this.mContext = null;
    }
}
