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
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private d adg;
    private AlaGiftGraffitiShowView adi;
    private PointF adl;
    private a adm;
    private Context mContext;
    private boolean adh = true;
    private int adj = 0;
    private int adk = 0;
    private Handler mHandler = new Handler();
    private Runnable adn = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.ri();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.adi = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.adh;
    }

    public void j(d dVar) {
        if (dVar != null && dVar.aaR.WJ != null) {
            this.adh = false;
            this.adg = k(dVar);
            this.adi.setOffsetY(this.adk);
            if (this.adg.aaR.WJ.Xn == 0) {
                this.adi.rh();
                rj();
            } else {
                rk();
            }
            this.adi.setGiftItem(this.adg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rj() {
        if (this.adg == null || this.adg.aaR.WJ == null) {
            this.adj = 0;
            return;
        }
        if (this.adj < this.adg.aaR.WJ.Xp.size()) {
            List<PointF> list = this.adg.aaR.WJ.Xp;
            int i = this.adj;
            this.adj = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.adi.getContext());
            tbImageView.startLoad(this.adg.aaR.pf(), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.adi.b(tbImageView, (int) pointF.x, (int) pointF.y, this.adg.aaR.WJ.Xr.left, (int) this.adl.y);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.rj();
                }
            }, 30L);
            return;
        }
        this.mHandler.postDelayed(this.adn, 2000L);
    }

    private d k(d dVar) {
        int i;
        Rect rect;
        if (dVar == null) {
            return null;
        }
        d clone = dVar.clone();
        clone.aaR = new g(dVar.aaR);
        k kVar = dVar.aaR.WJ;
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / kVar.Xo;
        clone.aaR.WJ.Xn = kVar.Xn;
        clone.aaR.WJ.Xq = kVar.Xq;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aaR.WJ.Xh = screenDimensions[0];
        clone.aaR.WJ.Xi = screenDimensions[1];
        float ceil = (kVar.Xr.left * f) + ((float) Math.ceil((clone.aaR.WJ.Xh - (kVar.Xh * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aaR.WJ.Xi - (kVar.Xi * f)) / 2.0d)) + (kVar.Xr.top * f);
        float width = kVar.Xr.width() * f;
        float height = kVar.Xr.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aaR.WJ.Xr = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = kVar.Xp.get(0);
        this.adl = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.adl.x, this.adl.y);
        Iterator<PointF> it = kVar.Xp.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.adl = this.adl.y > pointF4.y ? pointF4 : this.adl;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aaR.WJ.Xp = arrayList;
                this.adk = (int) ((((rect.top + this.adl.y) - (i / 2)) - this.adi.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void rk() {
        this.adi.rh();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.adg.aaR.WJ.Xp.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.adi.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(this.adg.aaR.pf(), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.adg.aaR.WJ.Xp.get(i);
            this.adi.b(tbImageView, (int) pointF.x, (int) pointF.y, this.adg.aaR.WJ.Xr.left, (int) this.adl.y);
        }
        this.mHandler.removeCallbacks(this.adn);
        this.mHandler.postDelayed(this.adn, 5000L);
    }

    public void a(a aVar) {
        this.adm = aVar;
    }

    public void ri() {
        this.adj = 0;
        this.adh = true;
        if (this.adi != null) {
            this.adi.rh();
        }
        if (this.adm != null) {
            this.adm.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.adi != null) {
            this.adi.rh();
            this.adi = null;
        }
        this.adm = null;
    }
}
