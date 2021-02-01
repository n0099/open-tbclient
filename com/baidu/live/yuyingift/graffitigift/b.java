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
/* loaded from: classes11.dex */
public class b {
    private c bZU;
    private AlaGiftGraffitiShowView bZV;
    private a bZW;
    private PointF bge;
    private Context mContext;
    private boolean mIsReady = true;
    private int bgc = 0;
    private int bgd = 0;
    private Handler mHandler = new Handler();
    private Runnable bgg = new Runnable() { // from class: com.baidu.live.yuyingift.graffitigift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.Hx();
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bZV = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.mIsReady;
    }

    public void n(c cVar) {
        if (cVar != null && cVar.bcO.aWe != null) {
            this.mIsReady = false;
            this.bZU = o(cVar);
            this.bZV.setOffsetY(this.bgd);
            if (this.bZU.bcO.aWe.aXk == 0) {
                this.bZV.Hw();
                Hy();
            } else {
                HA();
            }
            this.bZV.setGiftItem(this.bZU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy() {
        if (this.bZU == null || this.bZU.bcO.aWe == null) {
            this.bgc = 0;
            return;
        }
        if (this.bgc < this.bZU.bcO.aWe.aXm.size()) {
            List<PointF> list = this.bZU.bcO.aWe.aXm;
            int i = this.bgc;
            this.bgc = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bZV.getContext());
            tbImageView.startLoad(dn(this.bgc - 1), 10, false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bZV.d(tbImageView, (int) pointF.x, (int) pointF.y, this.bZU.bcO.aWe.aXo.left, (int) this.bge.y);
            if (aS(this.mContext) && HB()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.graffitigift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Hy();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bgg, 2000L);
    }

    private String dn(int i) {
        if (Hz()) {
            int i2 = -1;
            if (this.bZU != null && this.bZU.aXp != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.bZU.aXp.size()) {
                        l lVar = this.bZU.aXp.get(i4);
                        if (i2 < i && i <= lVar.ER() + i2) {
                            return lVar.EQ();
                        }
                        i2 += lVar.ER();
                        i3 = i4 + 1;
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
        if (this.bZU == null || this.bZU.bcO == null) {
            return null;
        }
        return this.bZU.bcO.getThumbnail_url();
    }

    private boolean Hz() {
        return (this.bZU == null || this.bZU.aXp == null || this.bZU.aXp.size() <= 0) ? false : true;
    }

    private c o(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.bcO = new g(cVar.bcO);
        k kVar = cVar.bcO.aWe;
        if (kVar.aXp != null && kVar.aXp.size() > 0 && clone.aXp != null) {
            clone.aXp.addAll(kVar.aXp);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.aXl;
        clone.bcO.aWe.aXk = kVar.aXk;
        clone.bcO.aWe.aXn = kVar.aXn;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.bcO.aWe.aXe = screenDimensions[0];
        clone.bcO.aWe.aXf = screenDimensions[1];
        float ceil = (kVar.aXo.left * f) + ((float) Math.ceil((clone.bcO.aWe.aXe - (kVar.aXe * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.bcO.aWe.aXf - (kVar.aXf * f)) / 2.0d)) + (kVar.aXo.top * f);
        float width = kVar.aXo.width() * f;
        float height = kVar.aXo.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.bcO.aWe.aXo = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.aXm.get(0);
        this.bge = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bge.x, this.bge.y);
        Iterator<PointF> it = kVar.aXm.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bge = this.bge.y > pointF4.y ? pointF4 : this.bge;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.bcO.aWe.aXm = arrayList;
                this.bgd = (int) ((((rect.top + this.bge.y) - (i / 2)) - this.bZV.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void HA() {
        this.bZV.Hw();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bZU.bcO.aWe.aXm.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bZV.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.startLoad(dn(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bZU.bcO.aWe.aXm.get(i);
            this.bZV.d(tbImageView, (int) pointF.x, (int) pointF.y, this.bZU.bcO.aWe.aXo.left, (int) this.bge.y);
        }
        this.mHandler.removeCallbacks(this.bgg);
        this.mHandler.postDelayed(this.bgg, 5000L);
    }

    public void a(a aVar) {
        this.bZW = aVar;
    }

    public void Hx() {
        this.bgc = 0;
        this.mIsReady = true;
        if (this.bZV != null) {
            this.bZV.Hw();
        }
        if (this.bZW != null) {
            this.bZW.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bZV != null) {
            this.bZV.Hw();
            this.bZV = null;
        }
        this.bZW = null;
    }

    private boolean aS(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean HB() {
        return (this.bZU == null || this.bZU.userId == null || !this.bZU.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void EL() {
        if (HB()) {
            Hx();
        }
    }
}
