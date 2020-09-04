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
    private boolean aMS;
    private k aPb;
    private int aTU;
    private int aTV;
    private int aTW;
    private boolean aVl;
    private ArrayList<c> aVm;
    private b aWl;
    private b aWm;
    private AlaSmallGiftView aWn;
    private AlaSmallGiftView aWo;
    private b.a aWp;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.aVl = false;
        this.aWp = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
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
                if (cVar != null && cVar.aSX < cVar.aSW) {
                    a.this.i(cVar);
                    cVar.aTd = true;
                    if (a.this.aPb.a(cVar)) {
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
        this.aPb = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.aMS = z;
        this.aWn.setMode(z);
        this.aWo.setMode(z);
    }

    private void initData() {
        this.aVm = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aTU = (int) resources.getDimension(a.e.sdk_ds650);
        this.aTV = resources.getDimensionPixelOffset(a.e.sdk_ds12) + (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aWn = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aWo = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aWl = new b(this.aWn);
        this.aWl.a(this.aWp);
        this.aWm = new b(this.aWo);
        this.aWm.a(this.aWp);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aPb.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aTU, this.aTV);
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aTV);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.aTW;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void em(int i) {
        this.aTW = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.aTW;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void Fq() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aWl != null) {
            this.aWl.Fq();
        }
        if (this.aWm != null) {
            this.aWm.Fq();
        }
    }

    public void Ez() {
        this.aVl = true;
        if (this.aWl != null) {
            this.aWl.Ez();
        }
        if (this.aWm != null) {
            this.aWm.Ez();
        }
        this.aPb.EB();
    }

    public void EA() {
        this.aVl = false;
        this.aPb.M(this.mRootView);
        if (this.aWl != null) {
            this.aWl.EA();
        }
        if (this.aWm != null) {
            this.aWm.EA();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aWl.z(cVar) && !this.aWm.z(cVar)) {
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
        Iterator<c> it = this.aVm.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aST) && cVar.aST.equals(cVar2.aST) && Math.abs(cVar2.Gi() - cVar.Gi()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.aSW <= 99;
    }

    public static void d(c cVar, c cVar2) {
        r.a(cVar, cVar2);
        cVar.aSW += cVar2.aSW;
        cVar.ae(cVar2.Gi());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.aVm.add(cVar);
        if (cVar.aSY) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aDY, cVar.aDZ, cVar.giftId, "");
        }
        try {
            Fj();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Fm();
    }

    public void s(c cVar) {
        if (this.aVl) {
            t(cVar);
        } else if (!this.aWl.HR() && this.aWl.w(cVar)) {
            this.aWl.y(cVar);
        } else if (!this.aWm.HR() && this.aWm.w(cVar)) {
            this.aWm.y(cVar);
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
            if (i >= this.aVm.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.aVm.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.aVm.add(cVar);
        } else {
            this.aVm.add(i, cVar);
        }
        try {
            Fj();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Fj() {
        if (this.aVm != null) {
            int i = com.baidu.live.w.a.Nk().beJ != null ? com.baidu.live.w.a.Nk().beJ.aHg : 0;
            if (i > 0 && this.aVm.size() >= i) {
                Collections.sort(this.aVm, new c.a());
                ArrayList arrayList = new ArrayList(this.aVm.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.aVm.clear();
                this.aVm.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        if (!this.aVm.isEmpty() && !this.aVl) {
            if (this.aWl.isReady() || this.aWm.isReady()) {
                c remove = this.aVm.remove(0);
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
        if (this.aWl.isReady()) {
            this.aWl.x(cVar);
        } else if (this.aWm.isReady()) {
            this.aWm.x(cVar);
        }
        if (cVar.aSY) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aDY, cVar.aDZ, cVar.giftId, "");
        }
    }

    public boolean HC() {
        return this.aVm.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aSY) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aSX);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Gi());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aTd) {
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
        this.aVl = false;
        if (this.aVm != null) {
            this.aVm.clear();
        }
        if (this.aWl != null) {
            this.aWl.onDestroy();
        }
        if (this.aWm != null) {
            this.aWm.onDestroy();
        }
        this.mContext = null;
    }
}
