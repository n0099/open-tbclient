package com.baidu.live.yuyingift.graffitigift;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
import com.baidu.live.gift.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.yuyingift.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private c bPC;
    private AlaGiftGraffitiShowView bPD;
    private a bPE;
    private PointF bce;
    private Context mContext;
    private boolean bca = true;
    private int bcc = 0;
    private int bcd = 0;
    private Handler mHandler = new Handler();
    private Runnable bcg = new Runnable() { // from class: com.baidu.live.yuyingift.graffitigift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.IB();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bPD = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.bca;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aZq.aTc != null) {
            this.bca = false;
            this.bPC = p(cVar);
            this.bPD.setOffsetY(this.bcd);
            if (this.bPC.aZq.aTc.aUi == 0) {
                this.bPD.IA();
                IC();
            } else {
                IE();
            }
            this.bPD.setGiftItem(this.bPC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IC() {
        if (this.bPC == null || this.bPC.aZq.aTc == null) {
            this.bcc = 0;
            return;
        }
        if (this.bcc < this.bPC.aZq.aTc.aUk.size()) {
            List<PointF> list = this.bPC.aZq.aTc.aUk;
            int i = this.bcc;
            this.bcc = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bPD.getContext());
            tbImageView.startLoad(eu(this.bcc - 1), 10, false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bPD.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bPC.aZq.aTc.aUm.left, (int) this.bce.y);
            if (ar(this.mContext) && IF()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.graffitigift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.IC();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bcg, 2000L);
    }

    private String eu(int i) {
        if (ID()) {
            if (this.bPC != null && this.bPC.aUn != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.bPC.aUn.size()) {
                        l lVar = this.bPC.aUn.get(i4);
                        if (i3 < i && i <= lVar.Gg() + i3) {
                            return lVar.Gf();
                        }
                        i3 += lVar.Gg();
                        i2 = i4 + 1;
                    } else {
                        return getThumbnailUrl();
                    }
                }
            } else {
                return getThumbnailUrl();
            }
        } else {
            return getThumbnailUrl();
        }
    }

    private String getThumbnailUrl() {
        if (this.bPC == null || this.bPC.aZq == null) {
            return null;
        }
        return this.bPC.aZq.getThumbnail_url();
    }

    private boolean ID() {
        return (this.bPC == null || this.bPC.aUn == null || this.bPC.aUn.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aZq = new g(cVar.aZq);
        k kVar = cVar.aZq.aTc;
        if (kVar.aUn != null && kVar.aUn.size() > 0 && clone.aUn != null) {
            clone.aUn.addAll(kVar.aUn);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.aUj;
        clone.aZq.aTc.aUi = kVar.aUi;
        clone.aZq.aTc.aUl = kVar.aUl;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aZq.aTc.aUc = screenDimensions[0];
        clone.aZq.aTc.aUd = screenDimensions[1];
        float ceil = (kVar.aUm.left * f) + ((float) Math.ceil((clone.aZq.aTc.aUc - (kVar.aUc * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aZq.aTc.aUd - (kVar.aUd * f)) / 2.0d)) + (kVar.aUm.top * f);
        float width = kVar.aUm.width() * f;
        float height = kVar.aUm.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aZq.aTc.aUm = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.aUk.get(0);
        this.bce = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bce.x, this.bce.y);
        Iterator<PointF> it = kVar.aUk.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bce = this.bce.y > pointF4.y ? pointF4 : this.bce;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aZq.aTc.aUk = arrayList;
                this.bcd = (int) ((((rect.top + this.bce.y) - (i / 2)) - this.bPD.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void IE() {
        this.bPD.IA();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bPC.aZq.aTc.aUk.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bPD.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.startLoad(eu(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bPC.aZq.aTc.aUk.get(i);
            this.bPD.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bPC.aZq.aTc.aUm.left, (int) this.bce.y);
        }
        this.mHandler.removeCallbacks(this.bcg);
        this.mHandler.postDelayed(this.bcg, 5000L);
    }

    public void a(a aVar) {
        this.bPE = aVar;
    }

    public void IB() {
        this.bcc = 0;
        this.bca = true;
        if (this.bPD != null) {
            this.bPD.IA();
        }
        if (this.bPE != null) {
            this.bPE.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bPD != null) {
            this.bPD.IA();
            this.bPD = null;
        }
        this.bPE = null;
    }

    private boolean ar(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean IF() {
        return (this.bPC == null || this.bPC.userId == null || !this.bPC.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void Ga() {
        if (IF()) {
            IB();
        }
    }
}
