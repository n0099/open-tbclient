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
/* loaded from: classes3.dex */
public class b {
    private c aOG;
    private AlaGiftGraffitiShowView aOI;
    private PointF aOL;
    private a aOM;
    private Context mContext;
    private boolean aOH = true;
    private int aOJ = 0;
    private int aOK = 0;
    private Handler mHandler = new Handler();
    private Runnable aON = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.AO();
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.aOI = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aOH;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aMi.aGM != null) {
            this.aOH = false;
            this.aOG = p(cVar);
            this.aOI.setOffsetY(this.aOK);
            if (this.aOG.aMi.aGM.aHN == 0) {
                this.aOI.AN();
                AP();
            } else {
                AR();
            }
            this.aOI.setGiftItem(this.aOG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP() {
        if (this.aOG == null || this.aOG.aMi.aGM == null) {
            this.aOJ = 0;
            return;
        }
        if (this.aOJ < this.aOG.aMi.aGM.aHP.size()) {
            List<PointF> list = this.aOG.aMi.aGM.aHP;
            int i = this.aOJ;
            this.aOJ = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.aOI.getContext());
            tbImageView.startLoad(cs(this.aOJ - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.aOI.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aOG.aMi.aGM.aHR.left, (int) this.aOL.y);
            if (al(this.mContext) && AS()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.AP();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.aON, 2000L);
    }

    private String cs(int i) {
        if (AQ()) {
            if (this.aOG != null && this.aOG.aHS != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.aOG.aHS.size()) {
                        m mVar = this.aOG.aHS.get(i4);
                        if (i3 < i && i <= mVar.yH() + i3) {
                            return mVar.yG();
                        }
                        i3 += mVar.yH();
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
        if (this.aOG == null || this.aOG.aMi == null) {
            return null;
        }
        return this.aOG.aMi.getThumbnail_url();
    }

    private boolean AQ() {
        return (this.aOG == null || this.aOG.aHS == null || this.aOG.aHS.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aMi = new g(cVar.aMi);
        l lVar = cVar.aMi.aGM;
        if (lVar.aHS != null && lVar.aHS.size() > 0 && clone.aHS != null) {
            clone.aHS.addAll(lVar.aHS);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aHO;
        clone.aMi.aGM.aHN = lVar.aHN;
        clone.aMi.aGM.aHQ = lVar.aHQ;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aMi.aGM.aHH = screenDimensions[0];
        clone.aMi.aGM.aHI = screenDimensions[1];
        float ceil = (lVar.aHR.left * f) + ((float) Math.ceil((clone.aMi.aGM.aHH - (lVar.aHH * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aMi.aGM.aHI - (lVar.aHI * f)) / 2.0d)) + (lVar.aHR.top * f);
        float width = lVar.aHR.width() * f;
        float height = lVar.aHR.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aMi.aGM.aHR = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aHP.get(0);
        this.aOL = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.aOL.x, this.aOL.y);
        Iterator<PointF> it = lVar.aHP.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.aOL = this.aOL.y > pointF4.y ? pointF4 : this.aOL;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aMi.aGM.aHP = arrayList;
                this.aOK = (int) ((((rect.top + this.aOL.y) - (i / 2)) - this.aOI.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void AR() {
        this.aOI.AN();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.aOG.aMi.aGM.aHP.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.aOI.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(cs(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.aOG.aMi.aGM.aHP.get(i);
            this.aOI.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aOG.aMi.aGM.aHR.left, (int) this.aOL.y);
        }
        this.mHandler.removeCallbacks(this.aON);
        this.mHandler.postDelayed(this.aON, 5000L);
    }

    public void a(a aVar) {
        this.aOM = aVar;
    }

    public void AO() {
        this.aOJ = 0;
        this.aOH = true;
        if (this.aOI != null) {
            this.aOI.AN();
        }
        if (this.aOM != null) {
            this.aOM.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.aOI != null) {
            this.aOI.AN();
            this.aOI = null;
        }
        this.aOM = null;
    }

    private boolean al(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean AS() {
        return (this.aOG == null || this.aOG.userId == null || !this.aOG.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void yB() {
        if (AS()) {
            AO();
        }
    }
}
