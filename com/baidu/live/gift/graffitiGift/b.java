package com.baidu.live.gift.graffitiGift;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
import com.baidu.live.gift.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private c bfZ;
    private AlaGiftGraffitiShowView bgb;
    private PointF bge;
    private a bgf;
    private Context mContext;
    private boolean bga = true;
    private int bgc = 0;
    private int bgd = 0;
    private Handler mHandler = new Handler();
    private Runnable bgg = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.KB();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bgb = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.bga;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.bcN.aWg != null) {
            this.bga = false;
            this.bfZ = p(cVar);
            this.bgb.setOffsetY(this.bgd);
            if (this.bfZ.bcN.aWg.aXn == 0) {
                this.bgb.KA();
                KC();
            } else {
                KE();
            }
            this.bgb.setGiftItem(this.bfZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC() {
        if (this.bfZ == null || this.bfZ.bcN.aWg == null) {
            this.bgc = 0;
            return;
        }
        if (this.bgc < this.bfZ.bcN.aWg.aXp.size()) {
            List<PointF> list = this.bfZ.bcN.aWg.aXp;
            int i = this.bgc;
            this.bgc = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bgb.getContext());
            tbImageView.startLoad(eQ(this.bgc - 1), 10, false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bgb.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bfZ.bcN.aWg.aXr.left, (int) this.bge.y);
            if (aU(this.mContext) && KF()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.KC();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bgg, 2000L);
    }

    private String eQ(int i) {
        if (KD()) {
            if (this.bfZ != null && this.bfZ.aXs != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.bfZ.aXs.size()) {
                        l lVar = this.bfZ.aXs.get(i4);
                        if (i3 < i && i <= lVar.HV() + i3) {
                            return lVar.HU();
                        }
                        i3 += lVar.HV();
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
        if (this.bfZ == null || this.bfZ.bcN == null) {
            return null;
        }
        return this.bfZ.bcN.getThumbnail_url();
    }

    private boolean KD() {
        return (this.bfZ == null || this.bfZ.aXs == null || this.bfZ.aXs.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.bcN = new g(cVar.bcN);
        k kVar = cVar.bcN.aWg;
        if (kVar.aXs != null && kVar.aXs.size() > 0 && clone.aXs != null) {
            clone.aXs.addAll(kVar.aXs);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.aXo;
        clone.bcN.aWg.aXn = kVar.aXn;
        clone.bcN.aWg.aXq = kVar.aXq;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.bcN.aWg.aXh = screenDimensions[0];
        clone.bcN.aWg.aXi = screenDimensions[1];
        float ceil = (kVar.aXr.left * f) + ((float) Math.ceil((clone.bcN.aWg.aXh - (kVar.aXh * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.bcN.aWg.aXi - (kVar.aXi * f)) / 2.0d)) + (kVar.aXr.top * f);
        float width = kVar.aXr.width() * f;
        float height = kVar.aXr.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.bcN.aWg.aXr = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.aXp.get(0);
        this.bge = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bge.x, this.bge.y);
        Iterator<PointF> it = kVar.aXp.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bge = this.bge.y > pointF4.y ? pointF4 : this.bge;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.bcN.aWg.aXp = arrayList;
                this.bgd = (int) ((((rect.top + this.bge.y) - (i / 2)) - this.bgb.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void KE() {
        this.bgb.KA();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bfZ.bcN.aWg.aXp.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bgb.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.startLoad(eQ(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bfZ.bcN.aWg.aXp.get(i);
            this.bgb.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bfZ.bcN.aWg.aXr.left, (int) this.bge.y);
        }
        this.mHandler.removeCallbacks(this.bgg);
        this.mHandler.postDelayed(this.bgg, 5000L);
    }

    public void a(a aVar) {
        this.bgf = aVar;
    }

    public void KB() {
        this.bgc = 0;
        this.bga = true;
        if (this.bgb != null) {
            this.bgb.KA();
        }
        if (this.bgf != null) {
            this.bgf.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bgb != null) {
            this.bgb.KA();
            this.bgb = null;
        }
        this.bgf = null;
    }

    private boolean aU(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean KF() {
        return (this.bfZ == null || this.bfZ.userId == null || !this.bfZ.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void HP() {
        if (KF()) {
            KB();
        }
    }
}
