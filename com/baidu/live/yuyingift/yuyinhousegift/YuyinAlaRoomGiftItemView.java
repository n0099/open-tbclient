package com.baidu.live.yuyingift.yuyinhousegift;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.yuyingift.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinAlaRoomGiftItemView extends RelativeLayout {
    private AlaWheatInfoData bWA;
    private final int bWB;
    private final int bWC;
    private final int bWf;
    private final int bWg;
    private final int bWh;
    private final int bWi;
    private final int bWj;
    private final float bWk;
    private final float bWl;
    private final int bWm;
    private float bWn;
    private float bWo;
    private ObjectAnimator bWp;
    private ObjectAnimator bWq;
    private ObjectAnimator bWr;
    private ObjectAnimator bWs;
    private ObjectAnimator bWt;
    private a bWu;
    private TbImageView bWv;
    private TextView bWw;
    private TextView bWx;
    private List<ObjectAnimator> bWy;
    private ObjectAnimator bWz;

    /* loaded from: classes4.dex */
    public interface a {
        void ZR();

        void ZS();
    }

    public YuyinAlaRoomGiftItemView(Context context) {
        this(context, null);
    }

    public YuyinAlaRoomGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWf = 500;
        this.bWg = 1500;
        this.bWh = 500;
        this.bWi = 800;
        this.bWj = 500;
        this.bWk = 1.0f;
        this.bWl = 0.76f;
        this.bWm = 4;
        this.bWy = new ArrayList();
        this.bWB = Color.parseColor("#FFEAAA");
        this.bWC = Color.parseColor("#FFFFFF");
        init();
    }

    private void init() {
        inflate(getContext(), a.g.yuyin_ala_item_room_gift_view, this);
        this.bWv = (TbImageView) findViewById(a.f.yuyin_ala_iv_gift_animal_icon);
        this.bWw = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_count);
        this.bWx = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_userhint);
        this.bWn = BdUtilHelper.dip2px(getContext(), 96.0f);
        this.bWo = BdUtilHelper.dip2px(getContext(), 64.0f);
    }

    public void a(float f, float f2, AlaWheatInfoData alaWheatInfoData, c cVar) {
        if (f != 0.0f && f2 != 0.0f && alaWheatInfoData != null && cVar != null) {
            this.bWv.startLoad(cVar.bcN == null ? "fail" : cVar.bcN.getThumbnail_url(), 12, false);
            this.bWw.setText(String.valueOf(cVar.bcU));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cVar.userName);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                spannableStringBuilder.append((CharSequence) "某人");
            }
            if (spannableStringBuilder.length() > 4) {
                spannableStringBuilder.replace(4, spannableStringBuilder.length(), (CharSequence) "");
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bWB), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "送");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bWC), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            this.bWx.setText(spannableStringBuilder);
            setX(f - (this.bWn / 2.0f));
            setY(f2);
            e(alaWheatInfoData);
        }
    }

    private void e(AlaWheatInfoData alaWheatInfoData) {
        if (alaWheatInfoData != null) {
            this.bWA = alaWheatInfoData;
            this.bWp = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
            this.bWp.setInterpolator(new LinearInterpolator());
            this.bWp.setDuration(500L);
            this.bWp.addListener(new b());
            this.bWq = f(alaWheatInfoData);
            this.bWy.clear();
            this.bWy.add(this.bWp);
            this.bWy.add(this.bWq);
            if (alaWheatInfoData.locationCenterX != 0.0f || alaWheatInfoData.locationCenterY != 0.0f) {
                this.bWr = ObjectAnimator.ofInt(this, "stay2", 0, 1);
                this.bWr.setDuration(800L);
                this.bWr.addListener(new b());
                this.bWt = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.76f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.76f, 0.0f));
                this.bWt.setDuration(500L);
                this.bWt.setInterpolator(new LinearInterpolator());
                this.bWt.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.1
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.b, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (YuyinAlaRoomGiftItemView.this.bWu != null) {
                            YuyinAlaRoomGiftItemView.this.bWu.ZS();
                        }
                        if (YuyinAlaRoomGiftItemView.this.bWy != null) {
                            YuyinAlaRoomGiftItemView.this.bWy.clear();
                        }
                    }
                });
                this.bWy.add(this.bWr);
                this.bWy.add(this.bWt);
            }
        }
    }

    private ObjectAnimator f(final AlaWheatInfoData alaWheatInfoData) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "stay1", 0, 1);
        ofInt.setDuration(1500L);
        if (alaWheatInfoData.locationCenterX != 0.0f || alaWheatInfoData.locationCenterY != 0.0f) {
            ofInt.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.b, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.Nj) {
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.76f);
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.76f);
                        float x = YuyinAlaRoomGiftItemView.this.getX();
                        float y = YuyinAlaRoomGiftItemView.this.getY();
                        float width = alaWheatInfoData.locationCenterX - (YuyinAlaRoomGiftItemView.this.getWidth() / 2);
                        float f = alaWheatInfoData.locationCenterY - YuyinAlaRoomGiftItemView.this.bWo;
                        YuyinAlaRoomGiftItemView.this.bWs = ObjectAnimator.ofPropertyValuesHolder(YuyinAlaRoomGiftItemView.this, ofFloat, ofFloat2, PropertyValuesHolder.ofFloat("x", x, width), PropertyValuesHolder.ofFloat("y", y, f));
                        YuyinAlaRoomGiftItemView.this.bWs.setInterpolator(new LinearInterpolator());
                        YuyinAlaRoomGiftItemView.this.bWs.setDuration(500L);
                        YuyinAlaRoomGiftItemView.this.bWs.addListener(new b());
                        YuyinAlaRoomGiftItemView.this.bWz = YuyinAlaRoomGiftItemView.this.bWs;
                        YuyinAlaRoomGiftItemView.this.bWs.start();
                        if (YuyinAlaRoomGiftItemView.this.bWu != null) {
                            YuyinAlaRoomGiftItemView.this.bWu.ZR();
                            return;
                        }
                        return;
                    }
                    super.onAnimationEnd(animator);
                }
            });
        } else {
            ofInt.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.3
                @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.b, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.Nj && YuyinAlaRoomGiftItemView.this.bWu != null) {
                        YuyinAlaRoomGiftItemView.this.bWu.ZR();
                        YuyinAlaRoomGiftItemView.this.bWu.ZS();
                    }
                    super.onAnimationEnd(animator);
                }
            });
        }
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZN() {
        if (this.bWy != null && this.bWy.size() != 0) {
            this.bWz = this.bWy.remove(0);
            if (this.bWz != null) {
                this.bWz.start();
            }
        }
    }

    public boolean q(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean z = this.bWp != null && this.bWp.isRunning();
        boolean z2 = this.bWz != null && a(this.bWz) && this.bWz.isRunning();
        if (z || z2) {
            if (this.bWw != null) {
                try {
                    this.bWw.setText(String.valueOf((int) (Integer.parseInt(this.bWw.getText().toString()) + cVar.bcU)));
                } catch (Exception e) {
                    this.bWw.setText(String.valueOf(cVar.bcU));
                }
            }
            if (z2) {
                ZO();
            }
            return true;
        }
        return false;
    }

    private void ZO() {
        if (this.bWy != null && !ZP()) {
            this.bWy.add(0, f(this.bWA));
        }
        if (a(this.bWz)) {
            this.bWz.cancel();
        }
    }

    private boolean ZP() {
        if (this.bWy != null) {
            for (ObjectAnimator objectAnimator : this.bWy) {
                if (a(objectAnimator)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ZQ() {
        ZN();
    }

    public void setStay1(int i) {
    }

    public void setStay2(int i) {
    }

    private boolean a(ObjectAnimator objectAnimator) {
        return objectAnimator != null && TextUtils.equals(objectAnimator.getPropertyName(), "stay1");
    }

    public void cancel() {
        if (this.bWy != null) {
            for (ObjectAnimator objectAnimator : this.bWy) {
                objectAnimator.cancel();
            }
        }
        if (this.bWz != null) {
            this.bWz.cancel();
        }
    }

    public void setAnimalCallBack(a aVar) {
        this.bWu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        protected boolean Nj;

        private b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.Nj = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YuyinAlaRoomGiftItemView.this.ZN();
        }
    }
}
