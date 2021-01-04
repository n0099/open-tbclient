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
/* loaded from: classes11.dex */
public class b {
    private c bhI;
    private AlaGiftGraffitiShowView bhJ;
    private PointF bhM;
    private a bhN;
    private Context mContext;
    private boolean mIsReady = true;
    private int bhK = 0;
    private int bhL = 0;
    private Handler mHandler = new Handler();
    private Runnable bhO = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.Kc();
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bhJ = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.mIsReady;
    }

    public void p(c cVar) {
        if (cVar != null && cVar.bex.aXM != null) {
            this.mIsReady = false;
            this.bhI = q(cVar);
            this.bhJ.setOffsetY(this.bhL);
            if (this.bhI.bex.aXM.aYS == 0) {
                this.bhJ.Kb();
                Kd();
            } else {
                Kf();
            }
            this.bhJ.setGiftItem(this.bhI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd() {
        if (this.bhI == null || this.bhI.bex.aXM == null) {
            this.bhK = 0;
            return;
        }
        if (this.bhK < this.bhI.bex.aXM.aYU.size()) {
            List<PointF> list = this.bhI.bex.aXM.aYU;
            int i = this.bhK;
            this.bhK = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bhJ.getContext());
            tbImageView.startLoad(eO(this.bhK - 1), 10, false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bhJ.d(tbImageView, (int) pointF.x, (int) pointF.y, this.bhI.bex.aXM.aYW.left, (int) this.bhM.y);
            if (aT(this.mContext) && Kg()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Kd();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bhO, 2000L);
    }

    private String eO(int i) {
        if (Ke()) {
            int i2 = -1;
            if (this.bhI != null && this.bhI.aYX != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.bhI.aYX.size()) {
                        l lVar = this.bhI.aYX.get(i4);
                        if (i2 < i && i <= lVar.Hw() + i2) {
                            return lVar.Hv();
                        }
                        i2 += lVar.Hw();
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
        if (this.bhI == null || this.bhI.bex == null) {
            return null;
        }
        return this.bhI.bex.getThumbnail_url();
    }

    private boolean Ke() {
        return (this.bhI == null || this.bhI.aYX == null || this.bhI.aYX.size() <= 0) ? false : true;
    }

    private c q(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.bex = new g(cVar.bex);
        k kVar = cVar.bex.aXM;
        if (kVar.aYX != null && kVar.aYX.size() > 0 && clone.aYX != null) {
            clone.aYX.addAll(kVar.aYX);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.aYT;
        clone.bex.aXM.aYS = kVar.aYS;
        clone.bex.aXM.aYV = kVar.aYV;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.bex.aXM.aYM = screenDimensions[0];
        clone.bex.aXM.aYN = screenDimensions[1];
        float ceil = (kVar.aYW.left * f) + ((float) Math.ceil((clone.bex.aXM.aYM - (kVar.aYM * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.bex.aXM.aYN - (kVar.aYN * f)) / 2.0d)) + (kVar.aYW.top * f);
        float width = kVar.aYW.width() * f;
        float height = kVar.aYW.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.bex.aXM.aYW = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.aYU.get(0);
        this.bhM = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bhM.x, this.bhM.y);
        Iterator<PointF> it = kVar.aYU.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bhM = this.bhM.y > pointF4.y ? pointF4 : this.bhM;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.bex.aXM.aYU = arrayList;
                this.bhL = (int) ((((rect.top + this.bhM.y) - (i / 2)) - this.bhJ.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void Kf() {
        this.bhJ.Kb();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bhI.bex.aXM.aYU.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bhJ.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.startLoad(eO(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bhI.bex.aXM.aYU.get(i);
            this.bhJ.d(tbImageView, (int) pointF.x, (int) pointF.y, this.bhI.bex.aXM.aYW.left, (int) this.bhM.y);
        }
        this.mHandler.removeCallbacks(this.bhO);
        this.mHandler.postDelayed(this.bhO, 5000L);
    }

    public void a(a aVar) {
        this.bhN = aVar;
    }

    public void Kc() {
        this.bhK = 0;
        this.mIsReady = true;
        if (this.bhJ != null) {
            this.bhJ.Kb();
        }
        if (this.bhN != null) {
            this.bhN.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bhJ != null) {
            this.bhJ.Kb();
            this.bhJ = null;
        }
        this.bhN = null;
    }

    private boolean aT(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean Kg() {
        return (this.bhI == null || this.bhI.userId == null || !this.bhI.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void Hq() {
        if (Kg()) {
            Kc();
        }
    }
}
