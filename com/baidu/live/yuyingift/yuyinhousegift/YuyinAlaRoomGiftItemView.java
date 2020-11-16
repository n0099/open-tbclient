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
    private final int bQP;
    private final int bQQ;
    private final int bQR;
    private final int bQS;
    private final int bQT;
    private final float bQU;
    private final float bQV;
    private final int bQW;
    private float bQX;
    private float bQY;
    private ObjectAnimator bQZ;
    private ObjectAnimator bRa;
    private ObjectAnimator bRb;
    private ObjectAnimator bRc;
    private ObjectAnimator bRd;
    private a bRe;
    private TbImageView bRf;
    private TextView bRg;
    private TextView bRh;
    private List<ObjectAnimator> bRi;
    private ObjectAnimator bRj;
    private AlaWheatInfoData bRk;
    private final int bRl;
    private final int bRm;

    /* loaded from: classes4.dex */
    public interface a {
        void Xp();

        void Xq();
    }

    public YuyinAlaRoomGiftItemView(Context context) {
        this(context, null);
    }

    public YuyinAlaRoomGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQP = 500;
        this.bQQ = 1500;
        this.bQR = 500;
        this.bQS = 800;
        this.bQT = 500;
        this.bQU = 1.0f;
        this.bQV = 0.76f;
        this.bQW = 4;
        this.bRi = new ArrayList();
        this.bRl = Color.parseColor("#FFEAAA");
        this.bRm = Color.parseColor("#FFFFFF");
        init();
    }

    private void init() {
        inflate(getContext(), a.g.yuyin_ala_item_room_gift_view, this);
        this.bRf = (TbImageView) findViewById(a.f.yuyin_ala_iv_gift_animal_icon);
        this.bRg = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_count);
        this.bRh = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_userhint);
        this.bQX = BdUtilHelper.dip2px(getContext(), 96.0f);
        this.bQY = BdUtilHelper.dip2px(getContext(), 64.0f);
    }

    public void a(float f, float f2, AlaWheatInfoData alaWheatInfoData, c cVar) {
        if (f != 0.0f && f2 != 0.0f && alaWheatInfoData != null && cVar != null) {
            this.bRf.startLoad(cVar.aZq == null ? "fail" : cVar.aZq.getThumbnail_url(), 12, false);
            this.bRg.setText(String.valueOf(cVar.aZw));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cVar.userName);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                spannableStringBuilder.append((CharSequence) "某人");
            }
            if (spannableStringBuilder.length() > 4) {
                spannableStringBuilder.replace(4, spannableStringBuilder.length(), (CharSequence) "");
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bRl), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "送");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bRm), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            this.bRh.setText(spannableStringBuilder);
            setX(f - (this.bQX / 2.0f));
            setY(f2);
            e(alaWheatInfoData);
        }
    }

    private void e(AlaWheatInfoData alaWheatInfoData) {
        if (alaWheatInfoData != null) {
            this.bRk = alaWheatInfoData;
            this.bQZ = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
            this.bQZ.setInterpolator(new LinearInterpolator());
            this.bQZ.setDuration(500L);
            this.bQZ.addListener(new b());
            this.bRa = f(alaWheatInfoData);
            this.bRi.clear();
            this.bRi.add(this.bQZ);
            this.bRi.add(this.bRa);
            if (alaWheatInfoData.locationCenterX != 0.0f || alaWheatInfoData.locationCenterY != 0.0f) {
                this.bRb = ObjectAnimator.ofInt(this, "stay2", 0, 1);
                this.bRb.setDuration(800L);
                this.bRb.addListener(new b());
                this.bRd = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.76f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.76f, 0.0f));
                this.bRd.setDuration(500L);
                this.bRd.setInterpolator(new LinearInterpolator());
                this.bRd.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.1
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.b, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (YuyinAlaRoomGiftItemView.this.bRe != null) {
                            YuyinAlaRoomGiftItemView.this.bRe.Xq();
                        }
                        if (YuyinAlaRoomGiftItemView.this.bRi != null) {
                            YuyinAlaRoomGiftItemView.this.bRi.clear();
                        }
                    }
                });
                this.bRi.add(this.bRb);
                this.bRi.add(this.bRd);
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
                    if (!this.Mo) {
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.76f);
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.76f);
                        float x = YuyinAlaRoomGiftItemView.this.getX();
                        float y = YuyinAlaRoomGiftItemView.this.getY();
                        float width = alaWheatInfoData.locationCenterX - (YuyinAlaRoomGiftItemView.this.getWidth() / 2);
                        float f = alaWheatInfoData.locationCenterY - YuyinAlaRoomGiftItemView.this.bQY;
                        YuyinAlaRoomGiftItemView.this.bRc = ObjectAnimator.ofPropertyValuesHolder(YuyinAlaRoomGiftItemView.this, ofFloat, ofFloat2, PropertyValuesHolder.ofFloat("x", x, width), PropertyValuesHolder.ofFloat("y", y, f));
                        YuyinAlaRoomGiftItemView.this.bRc.setInterpolator(new LinearInterpolator());
                        YuyinAlaRoomGiftItemView.this.bRc.setDuration(500L);
                        YuyinAlaRoomGiftItemView.this.bRc.addListener(new b());
                        YuyinAlaRoomGiftItemView.this.bRj = YuyinAlaRoomGiftItemView.this.bRc;
                        YuyinAlaRoomGiftItemView.this.bRc.start();
                        if (YuyinAlaRoomGiftItemView.this.bRe != null) {
                            YuyinAlaRoomGiftItemView.this.bRe.Xp();
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
                    if (!this.Mo && YuyinAlaRoomGiftItemView.this.bRe != null) {
                        YuyinAlaRoomGiftItemView.this.bRe.Xp();
                        YuyinAlaRoomGiftItemView.this.bRe.Xq();
                    }
                    super.onAnimationEnd(animator);
                }
            });
        }
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xl() {
        if (this.bRi != null && this.bRi.size() != 0) {
            this.bRj = this.bRi.remove(0);
            if (this.bRj != null) {
                this.bRj.start();
            }
        }
    }

    public boolean q(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean z = this.bQZ != null && this.bQZ.isRunning();
        boolean z2 = this.bRj != null && a(this.bRj) && this.bRj.isRunning();
        if (z || z2) {
            if (this.bRg != null) {
                try {
                    this.bRg.setText(String.valueOf((int) (Integer.parseInt(this.bRg.getText().toString()) + cVar.aZw)));
                } catch (Exception e) {
                    this.bRg.setText(String.valueOf(cVar.aZw));
                }
            }
            if (z2) {
                Xm();
            }
            return true;
        }
        return false;
    }

    private void Xm() {
        if (this.bRi != null && !Xn()) {
            this.bRi.add(0, f(this.bRk));
        }
        if (a(this.bRj)) {
            this.bRj.cancel();
        }
    }

    private boolean Xn() {
        if (this.bRi != null) {
            for (ObjectAnimator objectAnimator : this.bRi) {
                if (a(objectAnimator)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void Xo() {
        Xl();
    }

    public void setStay1(int i) {
    }

    public void setStay2(int i) {
    }

    private boolean a(ObjectAnimator objectAnimator) {
        return objectAnimator != null && TextUtils.equals(objectAnimator.getPropertyName(), "stay1");
    }

    public void cancel() {
        if (this.bRi != null) {
            for (ObjectAnimator objectAnimator : this.bRi) {
                objectAnimator.cancel();
            }
        }
        if (this.bRj != null) {
            this.bRj.cancel();
        }
    }

    public void setAnimalCallBack(a aVar) {
        this.bRe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        protected boolean Mo;

        private b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.Mo = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YuyinAlaRoomGiftItemView.this.Xl();
        }
    }
}
