package com.baidu.live.yuyingift.graffitigift;

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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.yuyingift.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private c bLE;
    private AlaGiftGraffitiShowView bLF;
    private a bLG;
    private PointF bcw;
    private Context mContext;
    private boolean bcs = true;
    private int bcu = 0;
    private int bcv = 0;
    private Handler mHandler = new Handler();
    private Runnable bcy = new Runnable() { // from class: com.baidu.live.yuyingift.graffitigift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.IJ();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bLF = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.bcs;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aZJ.aTv != null) {
            this.bcs = false;
            this.bLE = p(cVar);
            this.bLF.setOffsetY(this.bcv);
            if (this.bLE.aZJ.aTv.aUB == 0) {
                this.bLF.II();
                IK();
            } else {
                IM();
            }
            this.bLF.setGiftItem(this.bLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IK() {
        if (this.bLE == null || this.bLE.aZJ.aTv == null) {
            this.bcu = 0;
            return;
        }
        if (this.bcu < this.bLE.aZJ.aTv.aUD.size()) {
            List<PointF> list = this.bLE.aZJ.aTv.aUD;
            int i = this.bcu;
            this.bcu = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bLF.getContext());
            tbImageView.startLoad(ey(this.bcu - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bLF.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bLE.aZJ.aTv.aUF.left, (int) this.bcw.y);
            if (ar(this.mContext) && IN()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.graffitigift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.IK();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bcy, 2000L);
    }

    private String ey(int i) {
        if (IL()) {
            if (this.bLE != null && this.bLE.aUG != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.bLE.aUG.size()) {
                        m mVar = this.bLE.aUG.get(i4);
                        if (i3 < i && i <= mVar.Go() + i3) {
                            return mVar.Gn();
                        }
                        i3 += mVar.Go();
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
        if (this.bLE == null || this.bLE.aZJ == null) {
            return null;
        }
        return this.bLE.aZJ.getThumbnail_url();
    }

    private boolean IL() {
        return (this.bLE == null || this.bLE.aUG == null || this.bLE.aUG.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aZJ = new g(cVar.aZJ);
        l lVar = cVar.aZJ.aTv;
        if (lVar.aUG != null && lVar.aUG.size() > 0 && clone.aUG != null) {
            clone.aUG.addAll(lVar.aUG);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aUC;
        clone.aZJ.aTv.aUB = lVar.aUB;
        clone.aZJ.aTv.aUE = lVar.aUE;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aZJ.aTv.aUv = screenDimensions[0];
        clone.aZJ.aTv.aUw = screenDimensions[1];
        float ceil = (lVar.aUF.left * f) + ((float) Math.ceil((clone.aZJ.aTv.aUv - (lVar.aUv * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aZJ.aTv.aUw - (lVar.aUw * f)) / 2.0d)) + (lVar.aUF.top * f);
        float width = lVar.aUF.width() * f;
        float height = lVar.aUF.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aZJ.aTv.aUF = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aUD.get(0);
        this.bcw = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bcw.x, this.bcw.y);
        Iterator<PointF> it = lVar.aUD.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bcw = this.bcw.y > pointF4.y ? pointF4 : this.bcw;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aZJ.aTv.aUD = arrayList;
                this.bcv = (int) ((((rect.top + this.bcw.y) - (i / 2)) - this.bLF.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void IM() {
        this.bLF.II();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bLE.aZJ.aTv.aUD.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bLF.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(ey(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bLE.aZJ.aTv.aUD.get(i);
            this.bLF.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bLE.aZJ.aTv.aUF.left, (int) this.bcw.y);
        }
        this.mHandler.removeCallbacks(this.bcy);
        this.mHandler.postDelayed(this.bcy, 5000L);
    }

    public void a(a aVar) {
        this.bLG = aVar;
    }

    public void IJ() {
        this.bcu = 0;
        this.bcs = true;
        if (this.bLF != null) {
            this.bLF.II();
        }
        if (this.bLG != null) {
            this.bLG.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bLF != null) {
            this.bLF.II();
            this.bLF = null;
        }
        this.bLG = null;
    }

    private boolean ar(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean IN() {
        return (this.bLE == null || this.bLE.userId == null || !this.bLE.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void Gi() {
        if (IN()) {
            IJ();
        }
    }
}
