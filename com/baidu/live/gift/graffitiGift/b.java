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
import com.baidu.live.gift.l;
import com.baidu.live.gift.m;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private c aQb;
    private AlaGiftGraffitiShowView aQd;
    private PointF aQg;
    private a aQh;
    private Context mContext;
    private boolean aQc = true;
    private int aQe = 0;
    private int aQf = 0;
    private Handler mHandler = new Handler();
    private Runnable aQi = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.Bq();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.aQd = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aQc;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aND.aIh != null) {
            this.aQc = false;
            this.aQb = p(cVar);
            this.aQd.setOffsetY(this.aQf);
            if (this.aQb.aND.aIh.aJi == 0) {
                this.aQd.Bp();
                Br();
            } else {
                Bt();
            }
            this.aQd.setGiftItem(this.aQb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Br() {
        if (this.aQb == null || this.aQb.aND.aIh == null) {
            this.aQe = 0;
            return;
        }
        if (this.aQe < this.aQb.aND.aIh.aJk.size()) {
            List<PointF> list = this.aQb.aND.aIh.aJk;
            int i = this.aQe;
            this.aQe = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.aQd.getContext());
            tbImageView.startLoad(cy(this.aQe - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.aQd.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aQb.aND.aIh.aJm.left, (int) this.aQg.y);
            if (al(this.mContext) && Bu()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Br();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.aQi, 2000L);
    }

    private String cy(int i) {
        if (Bs()) {
            if (this.aQb != null && this.aQb.aJn != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.aQb.aJn.size()) {
                        m mVar = this.aQb.aJn.get(i4);
                        if (i3 < i && i <= mVar.zj() + i3) {
                            return mVar.zi();
                        }
                        i3 += mVar.zj();
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
        if (this.aQb == null || this.aQb.aND == null) {
            return null;
        }
        return this.aQb.aND.getThumbnail_url();
    }

    private boolean Bs() {
        return (this.aQb == null || this.aQb.aJn == null || this.aQb.aJn.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aND = new g(cVar.aND);
        l lVar = cVar.aND.aIh;
        if (lVar.aJn != null && lVar.aJn.size() > 0 && clone.aJn != null) {
            clone.aJn.addAll(lVar.aJn);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aJj;
        clone.aND.aIh.aJi = lVar.aJi;
        clone.aND.aIh.aJl = lVar.aJl;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aND.aIh.aJc = screenDimensions[0];
        clone.aND.aIh.aJd = screenDimensions[1];
        float ceil = (lVar.aJm.left * f) + ((float) Math.ceil((clone.aND.aIh.aJc - (lVar.aJc * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aND.aIh.aJd - (lVar.aJd * f)) / 2.0d)) + (lVar.aJm.top * f);
        float width = lVar.aJm.width() * f;
        float height = lVar.aJm.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aND.aIh.aJm = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aJk.get(0);
        this.aQg = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.aQg.x, this.aQg.y);
        Iterator<PointF> it = lVar.aJk.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.aQg = this.aQg.y > pointF4.y ? pointF4 : this.aQg;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aND.aIh.aJk = arrayList;
                this.aQf = (int) ((((rect.top + this.aQg.y) - (i / 2)) - this.aQd.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void Bt() {
        this.aQd.Bp();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.aQb.aND.aIh.aJk.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.aQd.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(cy(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.aQb.aND.aIh.aJk.get(i);
            this.aQd.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aQb.aND.aIh.aJm.left, (int) this.aQg.y);
        }
        this.mHandler.removeCallbacks(this.aQi);
        this.mHandler.postDelayed(this.aQi, 5000L);
    }

    public void a(a aVar) {
        this.aQh = aVar;
    }

    public void Bq() {
        this.aQe = 0;
        this.aQc = true;
        if (this.aQd != null) {
            this.aQd.Bp();
        }
        if (this.aQh != null) {
            this.aQh.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.aQd != null) {
            this.aQd.Bp();
            this.aQd = null;
        }
        this.aQh = null;
    }

    private boolean al(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean Bu() {
        return (this.aQb == null || this.aQb.userId == null || !this.aQb.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void zd() {
        if (Bu()) {
            Bq();
        }
    }
}
