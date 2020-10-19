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
    private c bbe;
    private AlaGiftGraffitiShowView bbg;
    private PointF bbj;
    private a bbk;
    private Context mContext;
    private boolean bbf = true;
    private int bbh = 0;
    private int bbi = 0;
    private Handler mHandler = new Handler();
    private Runnable bbl = new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.Iq();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void onEnd();
    }

    public b(AlaGiftGraffitiShowView alaGiftGraffitiShowView, Context context) {
        this.bbg = alaGiftGraffitiShowView;
        this.mContext = context;
    }

    public boolean isReady() {
        return this.bbf;
    }

    public void o(c cVar) {
        if (cVar != null && cVar.aYo.aSz != null) {
            this.bbf = false;
            this.bbe = p(cVar);
            this.bbg.setOffsetY(this.bbi);
            if (this.bbe.aYo.aSz.aTF == 0) {
                this.bbg.Ip();
                Ir();
            } else {
                It();
            }
            this.bbg.setGiftItem(this.bbe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir() {
        if (this.bbe == null || this.bbe.aYo.aSz == null) {
            this.bbh = 0;
            return;
        }
        if (this.bbh < this.bbe.aYo.aSz.aTH.size()) {
            List<PointF> list = this.bbe.aYo.aSz.aTH;
            int i = this.bbh;
            this.bbh = i + 1;
            PointF pointF = list.get(i);
            TbImageView tbImageView = new TbImageView(this.bbg.getContext());
            tbImageView.startLoad(ex(this.bbh - 1), 10, false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            this.bbg.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bbe.aYo.aSz.aTJ.left, (int) this.bbj.y);
            if (ar(this.mContext) && Iu()) {
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.graffitiGift.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Ir();
                    }
                }, 80L);
                return;
            }
        }
        this.mHandler.postDelayed(this.bbl, 2000L);
    }

    private String ex(int i) {
        if (Is()) {
            if (this.bbe != null && this.bbe.aTK != null) {
                int i2 = 0;
                int i3 = -1;
                while (true) {
                    int i4 = i2;
                    if (i4 < this.bbe.aTK.size()) {
                        m mVar = this.bbe.aTK.get(i4);
                        if (i3 < i && i <= mVar.FZ() + i3) {
                            return mVar.FY();
                        }
                        i3 += mVar.FZ();
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
        if (this.bbe == null || this.bbe.aYo == null) {
            return null;
        }
        return this.bbe.aYo.getThumbnail_url();
    }

    private boolean Is() {
        return (this.bbe == null || this.bbe.aTK == null || this.bbe.aTK.size() <= 0) ? false : true;
    }

    private c p(c cVar) {
        int i;
        Rect rect;
        if (cVar == null) {
            return null;
        }
        c clone = cVar.clone();
        clone.aYo = new g(cVar.aYo);
        l lVar = cVar.aYo.aSz;
        if (lVar.aTK != null && lVar.aTK.size() > 0 && clone.aTK != null) {
            clone.aTK.addAll(lVar.aTK);
        }
        float dip2px = BdUtilHelper.dip2px(this.mContext, 1.0f);
        float f = ((int) (32.0f * dip2px)) / lVar.aTG;
        clone.aYo.aSz.aTF = lVar.aTF;
        clone.aYo.aSz.aTI = lVar.aTI;
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        clone.aYo.aSz.aTz = screenDimensions[0];
        clone.aYo.aSz.aTA = screenDimensions[1];
        float ceil = (lVar.aTJ.left * f) + ((float) Math.ceil((clone.aYo.aSz.aTz - (lVar.aTz * f)) / 2.0d));
        float ceil2 = ((float) Math.ceil((clone.aYo.aSz.aTA - (lVar.aTA * f)) / 2.0d)) + (lVar.aTJ.top * f);
        float width = lVar.aTJ.width() * f;
        float height = lVar.aTJ.height() * f;
        float ceil3 = (32.0f * dip2px) + ((float) Math.ceil(i / 2)) + (10.0f * dip2px);
        if (ceil2 >= ceil3) {
            ceil3 = ceil2;
        }
        clone.aYo.aSz.aTJ = new Rect((int) ceil, (int) ceil3, (int) width, (int) height);
        ArrayList arrayList = new ArrayList();
        PointF pointF = lVar.aTH.get(0);
        this.bbj = new PointF(pointF.x * f, pointF.y * f);
        PointF pointF2 = new PointF(this.bbj.x, this.bbj.y);
        Iterator<PointF> it = lVar.aTH.iterator();
        while (true) {
            PointF pointF3 = pointF2;
            if (it.hasNext()) {
                PointF next = it.next();
                PointF pointF4 = new PointF(next.x * f, next.y * f);
                this.bbj = this.bbj.y > pointF4.y ? pointF4 : this.bbj;
                pointF2 = pointF3.y < pointF4.y ? pointF4 : pointF3;
                arrayList.add(pointF4);
            } else {
                clone.aYo.aSz.aTH = arrayList;
                this.bbi = (int) ((((rect.top + this.bbj.y) - (i / 2)) - this.bbg.getInfoView().getHeight()) - (10.0f * dip2px));
                return clone;
            }
        }
    }

    private void It() {
        this.bbg.Ip();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 3.0f * 1.3f), Keyframe.ofFloat(0.05f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.1f, 3.0f * 1.3f), Keyframe.ofFloat(0.15f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.2f, 3.0f * 1.3f), Keyframe.ofFloat(0.25f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.3f, 3.0f * 1.3f), Keyframe.ofFloat(0.35f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.4f, 3.0f * 1.3f), Keyframe.ofFloat(0.45f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.5f, 3.0f * 1.3f), Keyframe.ofFloat(0.55f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.6f, 3.0f * 1.3f), Keyframe.ofFloat(0.65f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.7f, 3.0f * 1.3f), Keyframe.ofFloat(0.75f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.8f, 3.0f * 1.3f), Keyframe.ofFloat(0.85f, (-3.0f) * 1.3f), Keyframe.ofFloat(0.9f, 3.0f * 1.3f), Keyframe.ofFloat(0.95f, (-3.0f) * 1.3f), Keyframe.ofFloat(1.0f, 1.3f * 3.0f));
        int size = this.bbe.aYo.aSz.aTH.size();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = new TbImageView(this.bbg.getContext());
            tbImageView.setIsNight(false);
            tbImageView.setAutoChangeStyle(false);
            tbImageView.setDefaultBgResource(a.d.sdk_transparent);
            tbImageView.startLoad(ex(i), 10, false);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(tbImageView, ofKeyframe);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setDuration(5000L);
            ofPropertyValuesHolder.start();
            PointF pointF = this.bbe.aYo.aSz.aTH.get(i);
            this.bbg.b(tbImageView, (int) pointF.x, (int) pointF.y, this.bbe.aYo.aSz.aTJ.left, (int) this.bbj.y);
        }
        this.mHandler.removeCallbacks(this.bbl);
        this.mHandler.postDelayed(this.bbl, 5000L);
    }

    public void a(a aVar) {
        this.bbk = aVar;
    }

    public void Iq() {
        this.bbh = 0;
        this.bbf = true;
        if (this.bbg != null) {
            this.bbg.Ip();
        }
        if (this.bbk != null) {
            this.bbk.onEnd();
        }
    }

    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.bbg != null) {
            this.bbg.Ip();
            this.bbg = null;
        }
        this.bbk = null;
    }

    private boolean ar(Context context) {
        return context != null && UtilHelper.getRealScreenOrientation(context) == 2;
    }

    private boolean Iu() {
        return (this.bbe == null || this.bbe.userId == null || !this.bbe.userId.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public void FT() {
        if (Iu()) {
            Iq();
        }
    }
}
