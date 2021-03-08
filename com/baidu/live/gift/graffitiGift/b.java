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
/* loaded from: classes10.dex */
public class b {
    private c bhB;
    private AlaGiftGraffitiShowView bhC;
    private PointF bhF;
    private a bhG;
    private Context mContext;
    private boolean mIsReady = true;
    private int bhD = 0;
    private int bhE = 0;
    private Handler mHandler = new Handler();
    private Runnable bhH = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.HA();
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bhC = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.mIsReady;
    }

    public void p(c cVar) {
        if (cVar != null && cVar.bep.aXE != null) {
            this.mIsReady = false;
            this.bhB = q(cVar);
            this.bhC.setOffsetY(this.bhE);
            if (this.bhB.bep.aXE.aYK == 0) {
                this.bhC.Hz();
                HB();
            } else {
                HD();
            }
            this.bhC.setGiftItem(this.bhB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB() {
        if (this.bhB == null || this.bhB.bep.aXE == null) {
            this.bhD = 0;
            return;
        }
        if (this.bhD < this.bhB.bep.aXE.aYM.size()) {
            List<PointF> list = this.bhB.bep.aXE.aYM;
            int i = this.bhD;
            this.bhD = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bhC.getContext());
            tbImageView.startLoad(m19do(this.bhD - 1), 10, false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bhC.d(tbImageView, (int) pointF.x, (int) pointF.y, this.bhB.bep.aXE.aYO.left, (int) this.bhF.y);
            if (aR(this.mContext) && HE()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.HB();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bhH, 2000L);
    }

    /* renamed from: do  reason: not valid java name */
    private String m19do(int i) {
        if (HC()) {
            int i2 = -1;
            if (this.bhB != null && this.bhB.aYP != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.bhB.aYP.size()) {
                        l lVar = this.bhB.aYP.get(i4);
                        if (i2 < i && i <= lVar.EU() + i2) {
                            return lVar.ET();
                        }
                        i2 += lVar.EU();
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
        if (this.bhB == null || this.bhB.bep == null) {
            return null;
        }
        return this.bhB.bep.getThumbnail_url();
    }

    private boolean HC() {
        return (this.bhB == null || this.bhB.aYP == null || this.bhB.aYP.size() <= 0) ? false : true;
    }

    private c q(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.bep = new g(cVar.bep);
        k kVar = cVar.bep.aXE;
        if (kVar.aYP != null && kVar.aYP.size() > 0 && clone.aYP != null) {
            clone.aYP.addAll(kVar.aYP);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.aYL;
        clone.bep.aXE.aYK = kVar.aYK;
        clone.bep.aXE.aYN = kVar.aYN;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.bep.aXE.aYE = screenDimensions[0];
        clone.bep.aXE.aYF = screenDimensions[1];
        float ceil = (kVar.aYO.left * f) + ((float) Math.ceil((clone.bep.aXE.aYE - (kVar.aYE * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.bep.aXE.aYF - (kVar.aYF * f)) / 2.0d)) + (kVar.aYO.top * f);
        float width = kVar.aYO.width() * f;
        float height = kVar.aYO.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.bep.aXE.aYO = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.aYM.get(0);
        this.bhF = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bhF.x, this.bhF.y);
        Iterator<PointF> it = kVar.aYM.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bhF = this.bhF.y > pointF4.y ? pointF4 : this.bhF;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.bep.aXE.aYM = arrayList;
                this.bhE = (int) ((((rect.top + this.bhF.y) - (i / 2)) - this.bhC.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void HD() {
        this.bhC.Hz();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bhB.bep.aXE.aYM.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bhC.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.startLoad(m19do(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bhB.bep.aXE.aYM.get(i);
            this.bhC.d(tbImageView, (int) pointF.x, (int) pointF.y, this.bhB.bep.aXE.aYO.left, (int) this.bhF.y);
        }
        this.mHandler.removeCallbacks(this.bhH);
        this.mHandler.postDelayed(this.bhH, 5000L);
    }

    public void a(a aVar) {
        this.bhG = aVar;
    }

    public void HA() {
        this.bhD = 0;
        this.mIsReady = true;
        if (this.bhC != null) {
            this.bhC.Hz();
        }
        if (this.bhG != null) {
            this.bhG.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bhC != null) {
            this.bhC.Hz();
            this.bhC = null;
        }
        this.bhG = null;
    }

    private boolean aR(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean HE() {
        return (this.bhB == null || this.bhB.userId == null || !this.bhB.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void EO() {
        if (HE()) {
            HA();
        }
    }
}
