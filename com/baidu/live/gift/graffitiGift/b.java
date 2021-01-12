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
    private c bcR;
    private AlaGiftGraffitiShowView bcS;
    private PointF bcV;
    private a bcW;
    private Context mContext;
    private boolean mIsReady = true;
    private int bcT = 0;
    private int bcU = 0;
    private Handler mHandler = new Handler();
    private Runnable bcX = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.Gh();
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bcS = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.mIsReady;
    }

    public void p(c cVar) {
        if (cVar != null && cVar.aZH.aSZ != null) {
            this.mIsReady = false;
            this.bcR = q(cVar);
            this.bcS.setOffsetY(this.bcU);
            if (this.bcR.aZH.aSZ.aUf == 0) {
                this.bcS.Gg();
                Gi();
            } else {
                Gk();
            }
            this.bcS.setGiftItem(this.bcR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi() {
        if (this.bcR == null || this.bcR.aZH.aSZ == null) {
            this.bcT = 0;
            return;
        }
        if (this.bcT < this.bcR.aZH.aSZ.aUh.size()) {
            List<PointF> list = this.bcR.aZH.aSZ.aUh;
            int i = this.bcT;
            this.bcT = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bcS.getContext());
            tbImageView.startLoad(di(this.bcT - 1), 10, false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bcS.d(tbImageView, (int) pointF.x, (int) pointF.y, this.bcR.aZH.aSZ.aUj.left, (int) this.bcV.y);
            if (aS(this.mContext) && Gl()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Gi();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bcX, 2000L);
    }

    private String di(int i) {
        if (Gj()) {
            int i2 = -1;
            if (this.bcR != null && this.bcR.aUk != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.bcR.aUk.size()) {
                        l lVar = this.bcR.aUk.get(i4);
                        if (i2 < i && i <= lVar.DB() + i2) {
                            return lVar.DA();
                        }
                        i2 += lVar.DB();
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
        if (this.bcR == null || this.bcR.aZH == null) {
            return null;
        }
        return this.bcR.aZH.getThumbnail_url();
    }

    private boolean Gj() {
        return (this.bcR == null || this.bcR.aUk == null || this.bcR.aUk.size() <= 0) ? false : true;
    }

    private c q(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aZH = new g(cVar.aZH);
        k kVar = cVar.aZH.aSZ;
        if (kVar.aUk != null && kVar.aUk.size() > 0 && clone.aUk != null) {
            clone.aUk.addAll(kVar.aUk);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.aUg;
        clone.aZH.aSZ.aUf = kVar.aUf;
        clone.aZH.aSZ.aUi = kVar.aUi;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aZH.aSZ.aTZ = screenDimensions[0];
        clone.aZH.aSZ.aUa = screenDimensions[1];
        float ceil = (kVar.aUj.left * f) + ((float) Math.ceil((clone.aZH.aSZ.aTZ - (kVar.aTZ * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aZH.aSZ.aUa - (kVar.aUa * f)) / 2.0d)) + (kVar.aUj.top * f);
        float width = kVar.aUj.width() * f;
        float height = kVar.aUj.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aZH.aSZ.aUj = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.aUh.get(0);
        this.bcV = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bcV.x, this.bcV.y);
        Iterator<PointF> it = kVar.aUh.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bcV = this.bcV.y > pointF4.y ? pointF4 : this.bcV;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aZH.aSZ.aUh = arrayList;
                this.bcU = (int) ((((rect.top + this.bcV.y) - (i / 2)) - this.bcS.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void Gk() {
        this.bcS.Gg();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bcR.aZH.aSZ.aUh.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bcS.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.startLoad(di(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bcR.aZH.aSZ.aUh.get(i);
            this.bcS.d(tbImageView, (int) pointF.x, (int) pointF.y, this.bcR.aZH.aSZ.aUj.left, (int) this.bcV.y);
        }
        this.mHandler.removeCallbacks(this.bcX);
        this.mHandler.postDelayed(this.bcX, 5000L);
    }

    public void a(a aVar) {
        this.bcW = aVar;
    }

    public void Gh() {
        this.bcT = 0;
        this.mIsReady = true;
        if (this.bcS != null) {
            this.bcS.Gg();
        }
        if (this.bcW != null) {
            this.bcW.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bcS != null) {
            this.bcS.Gg();
            this.bcS = null;
        }
        this.bcW = null;
    }

    private boolean aS(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean Gl() {
        return (this.bcR == null || this.bcR.userId == null || !this.bcR.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void Dv() {
        if (Gl()) {
            Gh();
        }
    }
}
