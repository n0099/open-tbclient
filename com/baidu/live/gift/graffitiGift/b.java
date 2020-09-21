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
    private c aXK;
    private AlaGiftGraffitiShowView aXM;
    private PointF aXP;
    private a aXQ;
    private Context mContext;
    private boolean aXL = true;
    private int aXN = 0;
    private int aXO = 0;
    private Handler mHandler = new Handler();
    private Runnable aXR = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.Ht();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.aXM = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aXL;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aVd.aPo != null) {
            this.aXL = false;
            this.aXK = p(cVar);
            this.aXM.setOffsetY(this.aXO);
            if (this.aXK.aVd.aPo.aQu == 0) {
                this.aXM.Hs();
                Hu();
            } else {
                Hw();
            }
            this.aXM.setGiftItem(this.aXK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hu() {
        if (this.aXK == null || this.aXK.aVd.aPo == null) {
            this.aXN = 0;
            return;
        }
        if (this.aXN < this.aXK.aVd.aPo.aQw.size()) {
            List<PointF> list = this.aXK.aVd.aPo.aQw;
            int i = this.aXN;
            this.aXN = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.aXM.getContext());
            tbImageView.startLoad(es(this.aXN - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.aXM.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aXK.aVd.aPo.aQy.left, (int) this.aXP.y);
            if (ao(this.mContext) && Hx()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Hu();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.aXR, 2000L);
    }

    private String es(int i) {
        if (Hv()) {
            if (this.aXK != null && this.aXK.aQz != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.aXK.aQz.size()) {
                        m mVar = this.aXK.aQz.get(i4);
                        if (i3 < i && i <= mVar.Fd() + i3) {
                            return mVar.Fc();
                        }
                        i3 += mVar.Fd();
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
        if (this.aXK == null || this.aXK.aVd == null) {
            return null;
        }
        return this.aXK.aVd.getThumbnail_url();
    }

    private boolean Hv() {
        return (this.aXK == null || this.aXK.aQz == null || this.aXK.aQz.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aVd = new g(cVar.aVd);
        l lVar = cVar.aVd.aPo;
        if (lVar.aQz != null && lVar.aQz.size() > 0 && clone.aQz != null) {
            clone.aQz.addAll(lVar.aQz);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aQv;
        clone.aVd.aPo.aQu = lVar.aQu;
        clone.aVd.aPo.aQx = lVar.aQx;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aVd.aPo.aQo = screenDimensions[0];
        clone.aVd.aPo.aQp = screenDimensions[1];
        float ceil = (lVar.aQy.left * f) + ((float) Math.ceil((clone.aVd.aPo.aQo - (lVar.aQo * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aVd.aPo.aQp - (lVar.aQp * f)) / 2.0d)) + (lVar.aQy.top * f);
        float width = lVar.aQy.width() * f;
        float height = lVar.aQy.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aVd.aPo.aQy = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aQw.get(0);
        this.aXP = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.aXP.x, this.aXP.y);
        Iterator<PointF> it = lVar.aQw.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.aXP = this.aXP.y > pointF4.y ? pointF4 : this.aXP;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aVd.aPo.aQw = arrayList;
                this.aXO = (int) ((((rect.top + this.aXP.y) - (i / 2)) - this.aXM.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void Hw() {
        this.aXM.Hs();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.aXK.aVd.aPo.aQw.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.aXM.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(es(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.aXK.aVd.aPo.aQw.get(i);
            this.aXM.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aXK.aVd.aPo.aQy.left, (int) this.aXP.y);
        }
        this.mHandler.removeCallbacks(this.aXR);
        this.mHandler.postDelayed(this.aXR, 5000L);
    }

    public void a(a aVar) {
        this.aXQ = aVar;
    }

    public void Ht() {
        this.aXN = 0;
        this.aXL = true;
        if (this.aXM != null) {
            this.aXM.Hs();
        }
        if (this.aXQ != null) {
            this.aXQ.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.aXM != null) {
            this.aXM.Hs();
            this.aXM = null;
        }
        this.aXQ = null;
    }

    private boolean ao(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean Hx() {
        return (this.aXK == null || this.aXK.userId == null || !this.aXK.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void EX() {
        if (Hx()) {
            Ht();
        }
    }
}
