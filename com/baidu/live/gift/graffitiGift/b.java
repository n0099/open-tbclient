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
    private c anK;
    private AlaGiftGraffitiShowView anM;
    private PointF anP;
    private a anQ;
    private Context mContext;
    private boolean anL = true;
    private int anN = 0;
    private int anO = 0;
    private Handler mHandler = new Handler();
    private Runnable anR = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.uB();
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.anM = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.anL;
    }

    public void j(c cVar) {
        if (cVar != null && cVar.alx.ags != null) {
            this.anL = false;
            this.anK = k(cVar);
            this.anM.setOffsetY(this.anO);
            if (this.anK.alx.ags.ahp == 0) {
                this.anM.uA();
                uC();
            } else {
                uE();
            }
            this.anM.setGiftItem(this.anK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC() {
        if (this.anK == null || this.anK.alx.ags == null) {
            this.anN = 0;
            return;
        }
        if (this.anN < this.anK.alx.ags.ahr.size()) {
            List<PointF> list = this.anK.alx.ags.ahr;
            int i = this.anN;
            this.anN = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.anM.getContext());
            tbImageView.startLoad(bN(this.anN - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.anM.b(tbImageView, (int) pointF.x, (int) pointF.y, this.anK.alx.ags.aht.left, (int) this.anP.y);
            if (aB(this.mContext) && uF()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.uC();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.anR, 2000L);
    }

    private String bN(int i) {
        if (uD()) {
            if (this.anK != null && this.anK.ahu != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.anK.ahu.size()) {
                        m mVar = this.anK.ahu.get(i4);
                        if (i3 < i && i <= mVar.st() + i3) {
                            return mVar.ss();
                        }
                        i3 += mVar.st();
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
        if (this.anK == null || this.anK.alx == null) {
            return null;
        }
        return this.anK.alx.rA();
    }

    private boolean uD() {
        return (this.anK == null || this.anK.ahu == null || this.anK.ahu.size() <= 0) ? false : true;
    }

    private c k(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.alx = new g(cVar.alx);
        l lVar = cVar.alx.ags;
        if (lVar.ahu != null && lVar.ahu.size() > 0 && clone.ahu != null) {
            clone.ahu.addAll(lVar.ahu);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.ahq;
        clone.alx.ags.ahp = lVar.ahp;
        clone.alx.ags.ahs = lVar.ahs;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.alx.ags.ahj = screenDimensions[0];
        clone.alx.ags.ahk = screenDimensions[1];
        float ceil = (lVar.aht.left * f) + ((float) Math.ceil((clone.alx.ags.ahj - (lVar.ahj * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.alx.ags.ahk - (lVar.ahk * f)) / 2.0d)) + (lVar.aht.top * f);
        float width = lVar.aht.width() * f;
        float height = lVar.aht.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.alx.ags.aht = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.ahr.get(0);
        this.anP = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.anP.x, this.anP.y);
        Iterator<PointF> it = lVar.ahr.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.anP = this.anP.y > pointF4.y ? pointF4 : this.anP;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.alx.ags.ahr = arrayList;
                this.anO = (int) ((((rect.top + this.anP.y) - (i / 2)) - this.anM.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void uE() {
        this.anM.uA();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.anK.alx.ags.ahr.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.anM.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(bN(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.anK.alx.ags.ahr.get(i);
            this.anM.b(tbImageView, (int) pointF.x, (int) pointF.y, this.anK.alx.ags.aht.left, (int) this.anP.y);
        }
        this.mHandler.removeCallbacks(this.anR);
        this.mHandler.postDelayed(this.anR, 5000L);
    }

    public void a(a aVar) {
        this.anQ = aVar;
    }

    public void uB() {
        this.anN = 0;
        this.anL = true;
        if (this.anM != null) {
            this.anM.uA();
        }
        if (this.anQ != null) {
            this.anQ.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.anM != null) {
            this.anM.uA();
            this.anM = null;
        }
        this.anQ = null;
    }

    private boolean aB(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean uF() {
        return (this.anK == null || this.anK.userId == null || !this.anK.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void sn() {
        if (uF()) {
            uB();
        }
    }
}
