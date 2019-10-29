package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.j;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private j XJ;
    private b adb;
    private AlaGiftGraffitiShowView adc;
    private Context mContext;
    private boolean acZ = false;
    private boolean Xe = false;
    private b.a ade = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.pV();
        }
    };
    private ArrayList<d> ada = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.XJ = jVar;
        initView();
    }

    private void initView() {
        this.adc = new AlaGiftGraffitiShowView(this.mContext);
        this.adb = new b(this.adc, this.mContext);
        this.adb.a(this.ade);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.adc.setLayoutParams(layoutParams);
        this.XJ.J(this.adc);
    }

    public void px() {
        this.acZ = false;
        this.XJ.J(this.adc);
        pV();
    }

    public void e(d dVar) {
        if (dVar != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
            if (dVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.ada.add(0, dVar);
            } else {
                this.ada.add(dVar);
            }
            pV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV() {
        if (!this.ada.isEmpty() && !this.acZ && this.adb.isReady()) {
            d remove = this.ada.remove(0);
            if (remove != null) {
                remove.z(System.currentTimeMillis());
                i(remove);
                pV();
                return;
            }
            pV();
        }
    }

    private void i(d dVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.Xe) && this.adb.isReady()) {
            this.adb.j(dVar);
        }
    }

    public void pw() {
        this.acZ = true;
    }

    public void onDestroy() {
        if (this.adb != null) {
            this.adb.destory();
        }
        this.acZ = false;
    }

    public void ri() {
        if (this.adb != null) {
            this.adb.ri();
        }
    }

    public void aj(boolean z) {
        this.Xe = z;
    }
}
