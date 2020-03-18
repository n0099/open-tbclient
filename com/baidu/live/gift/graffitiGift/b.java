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
    private c anU;
    private AlaGiftGraffitiShowView anW;
    private PointF anZ;
    private a aoa;
    private Context mContext;
    private boolean anV = true;
    private int anX = 0;
    private int anY = 0;
    private Handler mHandler = new Handler();
    private Runnable aob = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.uG();
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.anW = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.anV;
    }

    public void j(c cVar) {
        if (cVar != null && cVar.alH.agC != null) {
            this.anV = false;
            this.anU = k(cVar);
            this.anW.setOffsetY(this.anY);
            if (this.anU.alH.agC.ahz == 0) {
                this.anW.uF();
                uH();
            } else {
                uJ();
            }
            this.anW.setGiftItem(this.anU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH() {
        if (this.anU == null || this.anU.alH.agC == null) {
            this.anX = 0;
            return;
        }
        if (this.anX < this.anU.alH.agC.ahB.size()) {
            List<PointF> list = this.anU.alH.agC.ahB;
            int i = this.anX;
            this.anX = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.anW.getContext());
            tbImageView.startLoad(bN(this.anX - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.anW.b(tbImageView, (int) pointF.x, (int) pointF.y, this.anU.alH.agC.ahD.left, (int) this.anZ.y);
            if (aA(this.mContext) && uK()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.uH();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.aob, 2000L);
    }

    private String bN(int i) {
        if (uI()) {
            if (this.anU != null && this.anU.ahE != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.anU.ahE.size()) {
                        m mVar = this.anU.ahE.get(i4);
                        if (i3 < i && i <= mVar.sy() + i3) {
                            return mVar.sx();
                        }
                        i3 += mVar.sy();
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
        if (this.anU == null || this.anU.alH == null) {
            return null;
        }
        return this.anU.alH.rF();
    }

    private boolean uI() {
        return (this.anU == null || this.anU.ahE == null || this.anU.ahE.size() <= 0) ? false : true;
    }

    private c k(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.alH = new g(cVar.alH);
        l lVar = cVar.alH.agC;
        if (lVar.ahE != null && lVar.ahE.size() > 0 && clone.ahE != null) {
            clone.ahE.addAll(lVar.ahE);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.ahA;
        clone.alH.agC.ahz = lVar.ahz;
        clone.alH.agC.ahC = lVar.ahC;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.alH.agC.aht = screenDimensions[0];
        clone.alH.agC.ahu = screenDimensions[1];
        float ceil = (lVar.ahD.left * f) + ((float) Math.ceil((clone.alH.agC.aht - (lVar.aht * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.alH.agC.ahu - (lVar.ahu * f)) / 2.0d)) + (lVar.ahD.top * f);
        float width = lVar.ahD.width() * f;
        float height = lVar.ahD.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.alH.agC.ahD = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.ahB.get(0);
        this.anZ = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.anZ.x, this.anZ.y);
        Iterator<PointF> it = lVar.ahB.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.anZ = this.anZ.y > pointF4.y ? pointF4 : this.anZ;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.alH.agC.ahB = arrayList;
                this.anY = (int) ((((rect.top + this.anZ.y) - (i / 2)) - this.anW.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void uJ() {
        this.anW.uF();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.anU.alH.agC.ahB.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.anW.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(bN(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.anU.alH.agC.ahB.get(i);
            this.anW.b(tbImageView, (int) pointF.x, (int) pointF.y, this.anU.alH.agC.ahD.left, (int) this.anZ.y);
        }
        this.mHandler.removeCallbacks(this.aob);
        this.mHandler.postDelayed(this.aob, 5000L);
    }

    public void a(a aVar) {
        this.aoa = aVar;
    }

    public void uG() {
        this.anX = 0;
        this.anV = true;
        if (this.anW != null) {
            this.anW.uF();
        }
        if (this.aoa != null) {
            this.aoa.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.anW != null) {
            this.anW.uF();
            this.anW = null;
        }
        this.aoa = null;
    }

    private boolean aA(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean uK() {
        return (this.anU == null || this.anU.userId == null || !this.anU.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void ss() {
        if (uK()) {
            uG();
        }
    }
}
