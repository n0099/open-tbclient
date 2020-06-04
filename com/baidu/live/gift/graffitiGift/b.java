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
    private c aMa;
    private AlaGiftGraffitiShowView aMc;
    private PointF aMf;
    private a aMg;
    private Context mContext;
    private boolean aMb = true;
    private int aMd = 0;
    private int aMe = 0;
    private Handler mHandler = new Handler();
    private Runnable aMh = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.Ao();
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.aMc = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aMb;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aJC.aEq != null) {
            this.aMb = false;
            this.aMa = p(cVar);
            this.aMc.setOffsetY(this.aMe);
            if (this.aMa.aJC.aEq.aFr == 0) {
                this.aMc.An();
                Ap();
            } else {
                Ar();
            }
            this.aMc.setGiftItem(this.aMa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ap() {
        if (this.aMa == null || this.aMa.aJC.aEq == null) {
            this.aMd = 0;
            return;
        }
        if (this.aMd < this.aMa.aJC.aEq.aFt.size()) {
            List<PointF> list = this.aMa.aJC.aEq.aFt;
            int i = this.aMd;
            this.aMd = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.aMc.getContext());
            tbImageView.startLoad(cm(this.aMd - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.aMc.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aMa.aJC.aEq.aFv.left, (int) this.aMf.y);
            if (ak(this.mContext) && As()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Ap();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.aMh, 2000L);
    }

    private String cm(int i) {
        if (Aq()) {
            if (this.aMa != null && this.aMa.aFw != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.aMa.aFw.size()) {
                        m mVar = this.aMa.aFw.get(i4);
                        if (i3 < i && i <= mVar.yh() + i3) {
                            return mVar.yg();
                        }
                        i3 += mVar.yh();
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
        if (this.aMa == null || this.aMa.aJC == null) {
            return null;
        }
        return this.aMa.aJC.xo();
    }

    private boolean Aq() {
        return (this.aMa == null || this.aMa.aFw == null || this.aMa.aFw.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aJC = new g(cVar.aJC);
        l lVar = cVar.aJC.aEq;
        if (lVar.aFw != null && lVar.aFw.size() > 0 && clone.aFw != null) {
            clone.aFw.addAll(lVar.aFw);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aFs;
        clone.aJC.aEq.aFr = lVar.aFr;
        clone.aJC.aEq.aFu = lVar.aFu;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aJC.aEq.aFl = screenDimensions[0];
        clone.aJC.aEq.aFm = screenDimensions[1];
        float ceil = (lVar.aFv.left * f) + ((float) Math.ceil((clone.aJC.aEq.aFl - (lVar.aFl * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aJC.aEq.aFm - (lVar.aFm * f)) / 2.0d)) + (lVar.aFv.top * f);
        float width = lVar.aFv.width() * f;
        float height = lVar.aFv.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aJC.aEq.aFv = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aFt.get(0);
        this.aMf = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.aMf.x, this.aMf.y);
        Iterator<PointF> it = lVar.aFt.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.aMf = this.aMf.y > pointF4.y ? pointF4 : this.aMf;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aJC.aEq.aFt = arrayList;
                this.aMe = (int) ((((rect.top + this.aMf.y) - (i / 2)) - this.aMc.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void Ar() {
        this.aMc.An();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.aMa.aJC.aEq.aFt.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.aMc.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(cm(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.aMa.aJC.aEq.aFt.get(i);
            this.aMc.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aMa.aJC.aEq.aFv.left, (int) this.aMf.y);
        }
        this.mHandler.removeCallbacks(this.aMh);
        this.mHandler.postDelayed(this.aMh, 5000L);
    }

    public void a(a aVar) {
        this.aMg = aVar;
    }

    public void Ao() {
        this.aMd = 0;
        this.aMb = true;
        if (this.aMc != null) {
            this.aMc.An();
        }
        if (this.aMg != null) {
            this.aMg.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.aMc != null) {
            this.aMc.An();
            this.aMc = null;
        }
        this.aMg = null;
    }

    private boolean ak(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean As() {
        return (this.aMa == null || this.aMa.userId == null || !this.aMa.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void yb() {
        if (As()) {
            Ao();
        }
    }
}
