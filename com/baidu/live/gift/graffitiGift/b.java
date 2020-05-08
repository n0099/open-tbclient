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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private c aGs;
    private AlaGiftGraffitiShowView aGu;
    private PointF aGx;
    private a aGy;
    private Context mContext;
    private boolean aGt = true;
    private int aGv = 0;
    private int aGw = 0;
    private Handler mHandler = new Handler();
    private Runnable aGz = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.za();
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.aGu = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aGt;
    }

    public void l(c cVar) {
        if (cVar != null && cVar.aEd.ayY != null) {
            this.aGt = false;
            this.aGs = m(cVar);
            this.aGu.setOffsetY(this.aGw);
            if (this.aGs.aEd.ayY.azZ == 0) {
                this.aGu.yZ();
                zb();
            } else {
                zd();
            }
            this.aGu.setGiftItem(this.aGs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb() {
        if (this.aGs == null || this.aGs.aEd.ayY == null) {
            this.aGv = 0;
            return;
        }
        if (this.aGv < this.aGs.aEd.ayY.aAb.size()) {
            List<PointF> list = this.aGs.aEd.ayY.aAb;
            int i = this.aGv;
            this.aGv = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.aGu.getContext());
            tbImageView.startLoad(cd(this.aGv - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.aGu.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aGs.aEd.ayY.aAd.left, (int) this.aGx.y);
            if (aa(this.mContext) && ze()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.zb();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.aGz, 2000L);
    }

    private String cd(int i) {
        if (zc()) {
            if (this.aGs != null && this.aGs.aAe != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.aGs.aAe.size()) {
                        m mVar = this.aGs.aAe.get(i4);
                        if (i3 < i && i <= mVar.wQ() + i3) {
                            return mVar.wP();
                        }
                        i3 += mVar.wQ();
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
        if (this.aGs == null || this.aGs.aEd == null) {
            return null;
        }
        return this.aGs.aEd.vX();
    }

    private boolean zc() {
        return (this.aGs == null || this.aGs.aAe == null || this.aGs.aAe.size() <= 0) ? false : true;
    }

    private c m(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aEd = new g(cVar.aEd);
        l lVar = cVar.aEd.ayY;
        if (lVar.aAe != null && lVar.aAe.size() > 0 && clone.aAe != null) {
            clone.aAe.addAll(lVar.aAe);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aAa;
        clone.aEd.ayY.azZ = lVar.azZ;
        clone.aEd.ayY.aAc = lVar.aAc;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aEd.ayY.azT = screenDimensions[0];
        clone.aEd.ayY.azU = screenDimensions[1];
        float ceil = (lVar.aAd.left * f) + ((float) Math.ceil((clone.aEd.ayY.azT - (lVar.azT * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aEd.ayY.azU - (lVar.azU * f)) / 2.0d)) + (lVar.aAd.top * f);
        float width = lVar.aAd.width() * f;
        float height = lVar.aAd.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aEd.ayY.aAd = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aAb.get(0);
        this.aGx = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.aGx.x, this.aGx.y);
        Iterator<PointF> it = lVar.aAb.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.aGx = this.aGx.y > pointF4.y ? pointF4 : this.aGx;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aEd.ayY.aAb = arrayList;
                this.aGw = (int) ((((rect.top + this.aGx.y) - (i / 2)) - this.aGu.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void zd() {
        this.aGu.yZ();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.aGs.aEd.ayY.aAb.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.aGu.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(cd(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.aGs.aEd.ayY.aAb.get(i);
            this.aGu.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aGs.aEd.ayY.aAd.left, (int) this.aGx.y);
        }
        this.mHandler.removeCallbacks(this.aGz);
        this.mHandler.postDelayed(this.aGz, 5000L);
    }

    public void a(a aVar) {
        this.aGy = aVar;
    }

    public void za() {
        this.aGv = 0;
        this.aGt = true;
        if (this.aGu != null) {
            this.aGu.yZ();
        }
        if (this.aGy != null) {
            this.aGy.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.aGu != null) {
            this.aGu.yZ();
            this.aGu = null;
        }
        this.aGy = null;
    }

    private boolean aa(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean ze() {
        return (this.aGs == null || this.aGs.userId == null || !this.aGs.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void wK() {
        if (ze()) {
            za();
        }
    }
}
