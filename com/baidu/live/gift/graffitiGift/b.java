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
    private c aGm;
    private AlaGiftGraffitiShowView aGo;
    private PointF aGr;
    private a aGs;
    private Context mContext;
    private boolean aGn = true;
    private int aGp = 0;
    private int aGq = 0;
    private Handler mHandler = new Handler();
    private Runnable aGt = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.zb();
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.aGo = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.aGn;
    }

    public void l(c cVar) {
        if (cVar != null && cVar.aDX.ayS != null) {
            this.aGn = false;
            this.aGm = m(cVar);
            this.aGo.setOffsetY(this.aGq);
            if (this.aGm.aDX.ayS.azT == 0) {
                this.aGo.za();
                zc();
            } else {
                ze();
            }
            this.aGo.setGiftItem(this.aGm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zc() {
        if (this.aGm == null || this.aGm.aDX.ayS == null) {
            this.aGp = 0;
            return;
        }
        if (this.aGp < this.aGm.aDX.ayS.azV.size()) {
            List<PointF> list = this.aGm.aDX.ayS.azV;
            int i = this.aGp;
            this.aGp = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.aGo.getContext());
            tbImageView.startLoad(cd(this.aGp - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.aGo.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aGm.aDX.ayS.azX.left, (int) this.aGr.y);
            if (am(this.mContext) && zf()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.zc();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.aGt, 2000L);
    }

    private String cd(int i) {
        if (zd()) {
            if (this.aGm != null && this.aGm.azY != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.aGm.azY.size()) {
                        m mVar = this.aGm.azY.get(i4);
                        if (i3 < i && i <= mVar.wR() + i3) {
                            return mVar.wQ();
                        }
                        i3 += mVar.wR();
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
        if (this.aGm == null || this.aGm.aDX == null) {
            return null;
        }
        return this.aGm.aDX.vY();
    }

    private boolean zd() {
        return (this.aGm == null || this.aGm.azY == null || this.aGm.azY.size() <= 0) ? false : true;
    }

    private c m(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aDX = new g(cVar.aDX);
        l lVar = cVar.aDX.ayS;
        if (lVar.azY != null && lVar.azY.size() > 0 && clone.azY != null) {
            clone.azY.addAll(lVar.azY);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.azU;
        clone.aDX.ayS.azT = lVar.azT;
        clone.aDX.ayS.azW = lVar.azW;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aDX.ayS.azN = screenDimensions[0];
        clone.aDX.ayS.azO = screenDimensions[1];
        float ceil = (lVar.azX.left * f) + ((float) Math.ceil((clone.aDX.ayS.azN - (lVar.azN * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aDX.ayS.azO - (lVar.azO * f)) / 2.0d)) + (lVar.azX.top * f);
        float width = lVar.azX.width() * f;
        float height = lVar.azX.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aDX.ayS.azX = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.azV.get(0);
        this.aGr = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.aGr.x, this.aGr.y);
        Iterator<PointF> it = lVar.azV.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.aGr = this.aGr.y > pointF4.y ? pointF4 : this.aGr;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aDX.ayS.azV = arrayList;
                this.aGq = (int) ((((rect.top + this.aGr.y) - (i / 2)) - this.aGo.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void ze() {
        this.aGo.za();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.aGm.aDX.ayS.azV.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.aGo.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(cd(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.aGm.aDX.ayS.azV.get(i);
            this.aGo.b(tbImageView, (int) pointF.x, (int) pointF.y, this.aGm.aDX.ayS.azX.left, (int) this.aGr.y);
        }
        this.mHandler.removeCallbacks(this.aGt);
        this.mHandler.postDelayed(this.aGt, 5000L);
    }

    public void a(a aVar) {
        this.aGs = aVar;
    }

    public void zb() {
        this.aGp = 0;
        this.aGn = true;
        if (this.aGo != null) {
            this.aGo.za();
        }
        if (this.aGs != null) {
            this.aGs.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.aGo != null) {
            this.aGo.za();
            this.aGo = null;
        }
        this.aGs = null;
    }

    private boolean am(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean zf() {
        return (this.aGm == null || this.aGm.userId == null || !this.aGm.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void wL() {
        if (zf()) {
            zb();
        }
    }
}
