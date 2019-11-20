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
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private d acN;
    private AlaGiftGraffitiShowView acP;
    private PointF acS;
    private a acT;
    private Context mContext;
    private boolean acO = true;
    private int acQ = 0;
    private int acR = 0;
    private Handler mHandler = new Handler();
    private Runnable acU = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.rj();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.acP = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.acO;
    }

    public void j(d dVar) {
        if (dVar != null && dVar.aaz.Wq != null) {
            this.acO = false;
            this.acN = k(dVar);
            this.acP.setOffsetY(this.acR);
            if (this.acN.aaz.Wq.WV == 0) {
                this.acP.ri();
                rk();
            } else {
                rl();
            }
            this.acP.setGiftItem(this.acN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk() {
        if (this.acN == null || this.acN.aaz.Wq == null) {
            this.acQ = 0;
            return;
        }
        if (this.acQ < this.acN.aaz.Wq.WX.size()) {
            List<PointF> list = this.acN.aaz.Wq.WX;
            int i = this.acQ;
            this.acQ = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.acP.getContext());
            tbImageView.startLoad(this.acN.aaz.pf(), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.acP.b(tbImageView, (int) pointF.x, (int) pointF.y, this.acN.aaz.Wq.WZ.left, (int) this.acS.y);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.rk();
                }
            }, 30L);
            return;
        }
        this.mHandler.postDelayed(this.acU, 2000L);
    }

    private d k(d dVar) {
        int i;
        Rect rect;
        if (dVar == null) {
            return null;
        }
        d clone = dVar.clone();
        clone.aaz = new g(dVar.aaz);
        k kVar = dVar.aaz.Wq;
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.WW;
        clone.aaz.Wq.WV = kVar.WV;
        clone.aaz.Wq.WY = kVar.WY;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aaz.Wq.WP = screenDimensions[0];
        clone.aaz.Wq.WQ = screenDimensions[1];
        float ceil = (kVar.WZ.left * f) + ((float) Math.ceil((clone.aaz.Wq.WP - (kVar.WP * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aaz.Wq.WQ - (kVar.WQ * f)) / 2.0d)) + (kVar.WZ.top * f);
        float width = kVar.WZ.width() * f;
        float height = kVar.WZ.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aaz.Wq.WZ = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.WX.get(0);
        this.acS = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.acS.x, this.acS.y);
        Iterator<PointF> it = kVar.WX.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.acS = this.acS.y > pointF4.y ? pointF4 : this.acS;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aaz.Wq.WX = arrayList;
                this.acR = (int) ((((rect.top + this.acS.y) - (i / 2)) - this.acP.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void rl() {
        this.acP.ri();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.acN.aaz.Wq.WX.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.acP.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(this.acN.aaz.pf(), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.acN.aaz.Wq.WX.get(i);
            this.acP.b(tbImageView, (int) pointF.x, (int) pointF.y, this.acN.aaz.Wq.WZ.left, (int) this.acS.y);
        }
        this.mHandler.removeCallbacks(this.acU);
        this.mHandler.postDelayed(this.acU, 5000L);
    }

    public void a(a aVar) {
        this.acT = aVar;
    }

    public void rj() {
        this.acQ = 0;
        this.acO = true;
        if (this.acP != null) {
            this.acP.ri();
        }
        if (this.acT != null) {
            this.acT.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.acP != null) {
            this.acP.ri();
            this.acP = null;
        }
        this.acT = null;
    }
}
