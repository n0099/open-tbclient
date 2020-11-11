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
import com.baidu.live.gift.k;
import com.baidu.live.gift.l;
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
    private c bRm;
    private AlaGiftGraffitiShowView bRn;
    private a bRo;
    private PointF bdP;
    private Context mContext;
    private boolean bdL = true;
    private int bdN = 0;
    private int bdO = 0;
    private Handler mHandler = new Handler();
    private Runnable bdR = new Runnable() { // from class: com.baidu.live.yuyingift.graffitigift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.Jk();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bRn = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.bdL;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.bbc.aUN != null) {
            this.bdL = false;
            this.bRm = p(cVar);
            this.bRn.setOffsetY(this.bdO);
            if (this.bRm.bbc.aUN.aVT == 0) {
                this.bRn.Jj();
                Jl();
            } else {
                Jn();
            }
            this.bRn.setGiftItem(this.bRm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jl() {
        if (this.bRm == null || this.bRm.bbc.aUN == null) {
            this.bdN = 0;
            return;
        }
        if (this.bdN < this.bRm.bbc.aUN.aVV.size()) {
            List<PointF> list = this.bRm.bbc.aUN.aVV;
            int i = this.bdN;
            this.bdN = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bRn.getContext());
            tbImageView.startLoad(ey(this.bdN - 1), 10, false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bRn.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bRm.bbc.aUN.aVX.left, (int) this.bdP.y);
            if (ar(this.mContext) && Jo()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.graffitigift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Jl();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bdR, 2000L);
    }

    private String ey(int i) {
        if (Jm()) {
            if (this.bRm != null && this.bRm.aVY != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.bRm.aVY.size()) {
                        l lVar = this.bRm.aVY.get(i4);
                        if (i3 < i && i <= lVar.GP() + i3) {
                            return lVar.GO();
                        }
                        i3 += lVar.GP();
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
        if (this.bRm == null || this.bRm.bbc == null) {
            return null;
        }
        return this.bRm.bbc.getThumbnail_url();
    }

    private boolean Jm() {
        return (this.bRm == null || this.bRm.aVY == null || this.bRm.aVY.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.bbc = new g(cVar.bbc);
        k kVar = cVar.bbc.aUN;
        if (kVar.aVY != null && kVar.aVY.size() > 0 && clone.aVY != null) {
            clone.aVY.addAll(kVar.aVY);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.aVU;
        clone.bbc.aUN.aVT = kVar.aVT;
        clone.bbc.aUN.aVW = kVar.aVW;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.bbc.aUN.aVN = screenDimensions[0];
        clone.bbc.aUN.aVO = screenDimensions[1];
        float ceil = (kVar.aVX.left * f) + ((float) Math.ceil((clone.bbc.aUN.aVN - (kVar.aVN * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.bbc.aUN.aVO - (kVar.aVO * f)) / 2.0d)) + (kVar.aVX.top * f);
        float width = kVar.aVX.width() * f;
        float height = kVar.aVX.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.bbc.aUN.aVX = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.aVV.get(0);
        this.bdP = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bdP.x, this.bdP.y);
        Iterator<PointF> it = kVar.aVV.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bdP = this.bdP.y > pointF4.y ? pointF4 : this.bdP;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.bbc.aUN.aVV = arrayList;
                this.bdO = (int) ((((rect.top + this.bdP.y) - (i / 2)) - this.bRn.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void Jn() {
        this.bRn.Jj();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bRm.bbc.aUN.aVV.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bRn.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.c.sdk_transparent);
            tbImageView.startLoad(ey(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bRm.bbc.aUN.aVV.get(i);
            this.bRn.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bRm.bbc.aUN.aVX.left, (int) this.bdP.y);
        }
        this.mHandler.removeCallbacks(this.bdR);
        this.mHandler.postDelayed(this.bdR, 5000L);
    }

    public void a(a aVar) {
        this.bRo = aVar;
    }

    public void Jk() {
        this.bdN = 0;
        this.bdL = true;
        if (this.bRn != null) {
            this.bRn.Jj();
        }
        if (this.bRo != null) {
            this.bRo.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bRn != null) {
            this.bRn.Jj();
            this.bRn = null;
        }
        this.bRo = null;
    }

    private boolean ar(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean Jo() {
        return (this.bRm == null || this.bRm.userId == null || !this.bRm.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void GJ() {
        if (Jo()) {
            Jk();
        }
    }
}
