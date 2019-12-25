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
import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.gift.m;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.live.gift.a.b akK;
    private AlaGiftGraffitiShowView akM;
    private PointF akP;
    private a akQ;
    private Context mContext;
    private boolean akL = true;
    private int akN = 0;
    private int akO = 0;
    private Handler mHandler = new Handler();
    private Runnable akR = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.sT();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.akM = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.akL;
    }

    public void j(com.baidu.live.gift.a.b bVar) {
        if (bVar != null && bVar.aiC.adW != null) {
            this.akL = false;
            this.akK = k(bVar);
            this.akM.setOffsetY(this.akO);
            if (this.akK.aiC.adW.aez == 0) {
                this.akM.sS();
                sU();
            } else {
                sW();
            }
            this.akM.setGiftItem(this.akK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sU() {
        if (this.akK == null || this.akK.aiC.adW == null) {
            this.akN = 0;
            return;
        }
        if (this.akN < this.akK.aiC.adW.aeB.size()) {
            List<PointF> list = this.akK.aiC.adW.aeB;
            int i = this.akN;
            this.akN = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.akM.getContext());
            tbImageView.startLoad(bG(this.akN - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.akM.b(tbImageView, (int) pointF.x, (int) pointF.y, this.akK.aiC.adW.aeD.left, (int) this.akP.y);
            if (az(this.mContext) && sX()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.sU();
                    }
                }, 30L);
                return;
            }
        }
        this.mHandler.postDelayed(this.akR, 2000L);
    }

    private String bG(int i) {
        if (sV()) {
            if (this.akK != null && this.akK.aeE != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.akK.aeE.size()) {
                        m mVar = this.akK.aeE.get(i4);
                        if (i3 < i && i <= mVar.rg() + i3) {
                            return mVar.rf();
                        }
                        i3 += mVar.rg();
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
        if (this.akK == null || this.akK.aiC == null) {
            return null;
        }
        return this.akK.aiC.qA();
    }

    private boolean sV() {
        return (this.akK == null || this.akK.aeE == null || this.akK.aeE.size() <= 0) ? false : true;
    }

    private com.baidu.live.gift.a.b k(com.baidu.live.gift.a.b bVar) {
        int i;
        Rect rect;
        if (bVar == null) {
            return null;
        }
        com.baidu.live.gift.a.b clone = bVar.clone();
        clone.aiC = new g(bVar.aiC);
        l lVar = bVar.aiC.adW;
        if (lVar.aeE != null && lVar.aeE.size() > 0 && clone.aeE != null) {
            clone.aeE.addAll(lVar.aeE);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aeA;
        clone.aiC.adW.aez = lVar.aez;
        clone.aiC.adW.aeC = lVar.aeC;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aiC.adW.aet = screenDimensions[0];
        clone.aiC.adW.aeu = screenDimensions[1];
        float ceil = (lVar.aeD.left * f) + ((float) Math.ceil((clone.aiC.adW.aet - (lVar.aet * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aiC.adW.aeu - (lVar.aeu * f)) / 2.0d)) + (lVar.aeD.top * f);
        float width = lVar.aeD.width() * f;
        float height = lVar.aeD.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aiC.adW.aeD = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aeB.get(0);
        this.akP = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.akP.x, this.akP.y);
        Iterator<PointF> it = lVar.aeB.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.akP = this.akP.y > pointF4.y ? pointF4 : this.akP;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aiC.adW.aeB = arrayList;
                this.akO = (int) ((((rect.top + this.akP.y) - (i / 2)) - this.akM.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void sW() {
        this.akM.sS();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.akK.aiC.adW.aeB.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.akM.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(bG(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.akK.aiC.adW.aeB.get(i);
            this.akM.b(tbImageView, (int) pointF.x, (int) pointF.y, this.akK.aiC.adW.aeD.left, (int) this.akP.y);
        }
        this.mHandler.removeCallbacks(this.akR);
        this.mHandler.postDelayed(this.akR, 5000L);
    }

    public void a(a aVar) {
        this.akQ = aVar;
    }

    public void sT() {
        this.akN = 0;
        this.akL = true;
        if (this.akM != null) {
            this.akM.sS();
        }
        if (this.akQ != null) {
            this.akQ.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.akM != null) {
            this.akM.sS();
            this.akM = null;
        }
        this.akQ = null;
    }

    private boolean az(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean sX() {
        return (this.akK == null || this.akK.userId == null || !this.akK.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void ra() {
        if (sX()) {
            sT();
        }
    }
}
