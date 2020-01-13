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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private PointF alC;
    private a alD;
    private c alx;
    private AlaGiftGraffitiShowView alz;
    private Context mContext;
    private boolean aly = true;
    private int alA = 0;
    private int alB = 0;
    private Handler mHandler = new Handler();
    private Runnable alE = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.tj();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.alz = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aly;
    }

    public void j(c cVar) {
        if (cVar != null && cVar.ajo.ael != null) {
            this.aly = false;
            this.alx = k(cVar);
            this.alz.setOffsetY(this.alB);
            if (this.alx.ajo.ael.afi == 0) {
                this.alz.ti();
                tk();
            } else {
                tm();
            }
            this.alz.setGiftItem(this.alx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk() {
        if (this.alx == null || this.alx.ajo.ael == null) {
            this.alA = 0;
            return;
        }
        if (this.alA < this.alx.ajo.ael.afk.size()) {
            List<PointF> list = this.alx.ajo.ael.afk;
            int i = this.alA;
            this.alA = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.alz.getContext());
            tbImageView.startLoad(bG(this.alA - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.alz.b(tbImageView, (int) pointF.x, (int) pointF.y, this.alx.ajo.ael.afm.left, (int) this.alC.y);
            if (az(this.mContext) && tn()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.tk();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.alE, 2000L);
    }

    private String bG(int i) {
        if (tl()) {
            if (this.alx != null && this.alx.afn != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.alx.afn.size()) {
                        m mVar = this.alx.afn.get(i4);
                        if (i3 < i && i <= mVar.rs() + i3) {
                            return mVar.rr();
                        }
                        i3 += mVar.rs();
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
        if (this.alx == null || this.alx.ajo == null) {
            return null;
        }
        return this.alx.ajo.qH();
    }

    private boolean tl() {
        return (this.alx == null || this.alx.afn == null || this.alx.afn.size() <= 0) ? false : true;
    }

    private c k(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.ajo = new g(cVar.ajo);
        l lVar = cVar.ajo.ael;
        if (lVar.afn != null && lVar.afn.size() > 0 && clone.afn != null) {
            clone.afn.addAll(lVar.afn);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.afj;
        clone.ajo.ael.afi = lVar.afi;
        clone.ajo.ael.afl = lVar.afl;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.ajo.ael.afc = screenDimensions[0];
        clone.ajo.ael.afd = screenDimensions[1];
        float ceil = (lVar.afm.left * f) + ((float) Math.ceil((clone.ajo.ael.afc - (lVar.afc * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.ajo.ael.afd - (lVar.afd * f)) / 2.0d)) + (lVar.afm.top * f);
        float width = lVar.afm.width() * f;
        float height = lVar.afm.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.ajo.ael.afm = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.afk.get(0);
        this.alC = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.alC.x, this.alC.y);
        Iterator<PointF> it = lVar.afk.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.alC = this.alC.y > pointF4.y ? pointF4 : this.alC;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.ajo.ael.afk = arrayList;
                this.alB = (int) ((((rect.top + this.alC.y) - (i / 2)) - this.alz.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void tm() {
        this.alz.ti();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.alx.ajo.ael.afk.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.alz.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(bG(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.alx.ajo.ael.afk.get(i);
            this.alz.b(tbImageView, (int) pointF.x, (int) pointF.y, this.alx.ajo.ael.afm.left, (int) this.alC.y);
        }
        this.mHandler.removeCallbacks(this.alE);
        this.mHandler.postDelayed(this.alE, 5000L);
    }

    public void a(a aVar) {
        this.alD = aVar;
    }

    public void tj() {
        this.alA = 0;
        this.aly = true;
        if (this.alz != null) {
            this.alz.ti();
        }
        if (this.alD != null) {
            this.alD.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.alz != null) {
            this.alz.ti();
            this.alz = null;
        }
        this.alD = null;
    }

    private boolean az(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean tn() {
        return (this.alx == null || this.alx.userId == null || !this.alx.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void rm() {
        if (tn()) {
            tj();
        }
    }
}
