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
/* loaded from: classes7.dex */
public class b {
    private c aVr;
    private AlaGiftGraffitiShowView aVt;
    private PointF aVw;
    private a aVx;
    private Context mContext;
    private boolean aVs = true;
    private int aVu = 0;
    private int aVv = 0;
    private Handler mHandler = new Handler();
    private Runnable aVy = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.GT();
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.aVt = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aVs;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aSS.aNu != null) {
            this.aVs = false;
            this.aVr = p(cVar);
            this.aVt.setOffsetY(this.aVv);
            if (this.aVr.aSS.aNu.aOv == 0) {
                this.aVt.GS();
                GU();
            } else {
                GW();
            }
            this.aVt.setGiftItem(this.aVr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        if (this.aVr == null || this.aVr.aSS.aNu == null) {
            this.aVu = 0;
            return;
        }
        if (this.aVu < this.aVr.aSS.aNu.aOx.size()) {
            List<PointF> list = this.aVr.aSS.aNu.aOx;
            int i = this.aVu;
            this.aVu = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.aVt.getContext());
            tbImageView.startLoad(eo(this.aVu - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.aVt.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aVr.aSS.aNu.aOz.left, (int) this.aVw.y);
            if (ao(this.mContext) && GX()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.GU();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.aVy, 2000L);
    }

    private String eo(int i) {
        if (GV()) {
            if (this.aVr != null && this.aVr.aOA != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.aVr.aOA.size()) {
                        m mVar = this.aVr.aOA.get(i4);
                        if (i3 < i && i <= mVar.EM() + i3) {
                            return mVar.EL();
                        }
                        i3 += mVar.EM();
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
        if (this.aVr == null || this.aVr.aSS == null) {
            return null;
        }
        return this.aVr.aSS.getThumbnail_url();
    }

    private boolean GV() {
        return (this.aVr == null || this.aVr.aOA == null || this.aVr.aOA.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aSS = new g(cVar.aSS);
        l lVar = cVar.aSS.aNu;
        if (lVar.aOA != null && lVar.aOA.size() > 0 && clone.aOA != null) {
            clone.aOA.addAll(lVar.aOA);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aOw;
        clone.aSS.aNu.aOv = lVar.aOv;
        clone.aSS.aNu.aOy = lVar.aOy;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aSS.aNu.aOp = screenDimensions[0];
        clone.aSS.aNu.aOq = screenDimensions[1];
        float ceil = (lVar.aOz.left * f) + ((float) Math.ceil((clone.aSS.aNu.aOp - (lVar.aOp * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aSS.aNu.aOq - (lVar.aOq * f)) / 2.0d)) + (lVar.aOz.top * f);
        float width = lVar.aOz.width() * f;
        float height = lVar.aOz.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aSS.aNu.aOz = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aOx.get(0);
        this.aVw = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.aVw.x, this.aVw.y);
        Iterator<PointF> it = lVar.aOx.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.aVw = this.aVw.y > pointF4.y ? pointF4 : this.aVw;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aSS.aNu.aOx = arrayList;
                this.aVv = (int) ((((rect.top + this.aVw.y) - (i / 2)) - this.aVt.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void GW() {
        this.aVt.GS();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.aVr.aSS.aNu.aOx.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.aVt.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(eo(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.aVr.aSS.aNu.aOx.get(i);
            this.aVt.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aVr.aSS.aNu.aOz.left, (int) this.aVw.y);
        }
        this.mHandler.removeCallbacks(this.aVy);
        this.mHandler.postDelayed(this.aVy, 5000L);
    }

    public void a(a aVar) {
        this.aVx = aVar;
    }

    public void GT() {
        this.aVu = 0;
        this.aVs = true;
        if (this.aVt != null) {
            this.aVt.GS();
        }
        if (this.aVx != null) {
            this.aVx.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.aVt != null) {
            this.aVt.GS();
            this.aVt = null;
        }
        this.aVx = null;
    }

    private boolean ao(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean GX() {
        return (this.aVr == null || this.aVr.userId == null || !this.aVr.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void EG() {
        if (GX()) {
            GT();
        }
    }
}
