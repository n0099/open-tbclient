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
    private c aVp;
    private AlaGiftGraffitiShowView aVr;
    private PointF aVu;
    private a aVv;
    private Context mContext;
    private boolean aVq = true;
    private int aVs = 0;
    private int aVt = 0;
    private Handler mHandler = new Handler();
    private Runnable aVw = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
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
        this.aVr = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aVq;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aSQ.aNs != null) {
            this.aVq = false;
            this.aVp = p(cVar);
            this.aVr.setOffsetY(this.aVt);
            if (this.aVp.aSQ.aNs.aOt == 0) {
                this.aVr.GS();
                GU();
            } else {
                GW();
            }
            this.aVr.setGiftItem(this.aVp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        if (this.aVp == null || this.aVp.aSQ.aNs == null) {
            this.aVs = 0;
            return;
        }
        if (this.aVs < this.aVp.aSQ.aNs.aOv.size()) {
            List<PointF> list = this.aVp.aSQ.aNs.aOv;
            int i = this.aVs;
            this.aVs = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.aVr.getContext());
            tbImageView.startLoad(eo(this.aVs - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.aVr.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aVp.aSQ.aNs.aOx.left, (int) this.aVu.y);
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
        this.mHandler.postDelayed(this.aVw, 2000L);
    }

    private String eo(int i) {
        if (GV()) {
            if (this.aVp != null && this.aVp.aOy != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.aVp.aOy.size()) {
                        m mVar = this.aVp.aOy.get(i4);
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
        if (this.aVp == null || this.aVp.aSQ == null) {
            return null;
        }
        return this.aVp.aSQ.getThumbnail_url();
    }

    private boolean GV() {
        return (this.aVp == null || this.aVp.aOy == null || this.aVp.aOy.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aSQ = new g(cVar.aSQ);
        l lVar = cVar.aSQ.aNs;
        if (lVar.aOy != null && lVar.aOy.size() > 0 && clone.aOy != null) {
            clone.aOy.addAll(lVar.aOy);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aOu;
        clone.aSQ.aNs.aOt = lVar.aOt;
        clone.aSQ.aNs.aOw = lVar.aOw;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aSQ.aNs.aOn = screenDimensions[0];
        clone.aSQ.aNs.aOo = screenDimensions[1];
        float ceil = (lVar.aOx.left * f) + ((float) Math.ceil((clone.aSQ.aNs.aOn - (lVar.aOn * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aSQ.aNs.aOo - (lVar.aOo * f)) / 2.0d)) + (lVar.aOx.top * f);
        float width = lVar.aOx.width() * f;
        float height = lVar.aOx.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aSQ.aNs.aOx = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aOv.get(0);
        this.aVu = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.aVu.x, this.aVu.y);
        Iterator<PointF> it = lVar.aOv.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.aVu = this.aVu.y > pointF4.y ? pointF4 : this.aVu;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aSQ.aNs.aOv = arrayList;
                this.aVt = (int) ((((rect.top + this.aVu.y) - (i / 2)) - this.aVr.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void GW() {
        this.aVr.GS();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.aVp.aSQ.aNs.aOv.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.aVr.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(eo(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.aVp.aSQ.aNs.aOv.get(i);
            this.aVr.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aVp.aSQ.aNs.aOx.left, (int) this.aVu.y);
        }
        this.mHandler.removeCallbacks(this.aVw);
        this.mHandler.postDelayed(this.aVw, 5000L);
    }

    public void a(a aVar) {
        this.aVv = aVar;
    }

    public void GT() {
        this.aVs = 0;
        this.aVq = true;
        if (this.aVr != null) {
            this.aVr.GS();
        }
        if (this.aVv != null) {
            this.aVv.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.aVr != null) {
            this.aVr.GS();
            this.aVr = null;
        }
        this.aVv = null;
    }

    private boolean ao(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean GX() {
        return (this.aVp == null || this.aVp.userId == null || !this.aVp.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void EG() {
        if (GX()) {
            GT();
        }
    }
}
