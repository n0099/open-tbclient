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
    private final int bMQ;
    private final int bMR;
    private final int bMS;
    private final int bMT;
    private final int bMU;
    private final float bMV;
    private final float bMW;
    private final int bMX;
    private float bMY;
    private float bMZ;
    private ObjectAnimator bNa;
    private ObjectAnimator bNb;
    private ObjectAnimator bNc;
    private ObjectAnimator bNd;
    private ObjectAnimator bNe;
    private a bNf;
    private TbImageView bNg;
    private TextView bNh;
    private TextView bNi;
    private List<ObjectAnimator> bNj;
    private ObjectAnimator bNk;
    private AlaWheatInfoData bNl;
    private final int bNm;
    private final int bNn;

    /* loaded from: classes4.dex */
    public interface a {
        void VA();

        void Vz();
    }

    public YuyinAlaRoomGiftItemView(Context context) {
        this(context, null);
    }

    public YuyinAlaRoomGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMQ = 500;
        this.bMR = 1500;
        this.bMS = 500;
        this.bMT = 800;
        this.bMU = 500;
        this.bMV = 1.0f;
        this.bMW = 0.76f;
        this.bMX = 4;
        this.bNj = new ArrayList();
        this.bNm = Color.parseColor("#FFEAAA");
        this.bNn = Color.parseColor("#FFFFFF");
        init();
    }

    private void init() {
        inflate(getContext(), a.h.yuyin_ala_item_room_gift_view, this);
        this.bNg = (TbImageView) findViewById(a.g.yuyin_ala_iv_gift_animal_icon);
        this.bNh = (TextView) findViewById(a.g.yuyin_ala_tv_gift_animal_count);
        this.bNi = (TextView) findViewById(a.g.yuyin_ala_tv_gift_animal_userhint);
        this.bMY = BdUtilHelper.dip2px(getContext(), 96.0f);
        this.bMZ = BdUtilHelper.dip2px(getContext(), 64.0f);
    }

    public void a(float f, float f2, AlaWheatInfoData alaWheatInfoData, c cVar) {
        if (f != 0.0f && f2 != 0.0f && alaWheatInfoData != null && cVar != null) {
            this.bNg.startLoad(cVar.aZJ == null ? "fail" : cVar.aZJ.getThumbnail_url(), 12, false);
            this.bNh.setText(String.valueOf(cVar.aZP));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cVar.userName);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                spannableStringBuilder.append((CharSequence) "某人");
            }
            if (spannableStringBuilder.length() > 4) {
                spannableStringBuilder.replace(4, spannableStringBuilder.length(), (CharSequence) "");
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bNm), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "送");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bNn), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
            this.bNi.setText(spannableStringBuilder);
            setX(f - (this.bMY / 2.0f));
            setY(f2);
            e(alaWheatInfoData);
        }
    }

    private void e(AlaWheatInfoData alaWheatInfoData) {
        if (alaWheatInfoData != null) {
            this.bNl = alaWheatInfoData;
            this.bNa = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
            this.bNa.setInterpolator(new LinearInterpolator());
            this.bNa.setDuration(500L);
            this.bNa.addListener(new b());
            this.bNb = f(alaWheatInfoData);
            this.bNj.clear();
            this.bNj.add(this.bNa);
            this.bNj.add(this.bNb);
            if (alaWheatInfoData.locationCenterX != 0.0f || alaWheatInfoData.locationCenterY != 0.0f) {
                this.bNc = ObjectAnimator.ofInt(this, "stay2", 0, 1);
                this.bNc.setDuration(800L);
                this.bNc.addListener(new b());
                this.bNe = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.76f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.76f, 0.0f));
                this.bNe.setDuration(500L);
                this.bNe.setInterpolator(new LinearInterpolator());
                this.bNe.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.1
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.b, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (YuyinAlaRoomGiftItemView.this.bNf != null) {
                            YuyinAlaRoomGiftItemView.this.bNf.VA();
                        }
                        if (YuyinAlaRoomGiftItemView.this.bNj != null) {
                            YuyinAlaRoomGiftItemView.this.bNj.clear();
                        }
                    }
                });
                this.bNj.add(this.bNc);
                this.bNj.add(this.bNe);
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
                        float f = alaWheatInfoData.locationCenterY - YuyinAlaRoomGiftItemView.this.bMZ;
                        YuyinAlaRoomGiftItemView.this.bNd = ObjectAnimator.ofPropertyValuesHolder(YuyinAlaRoomGiftItemView.this, ofFloat, ofFloat2, PropertyValuesHolder.ofFloat("x", x, width), PropertyValuesHolder.ofFloat("y", y, f));
                        YuyinAlaRoomGiftItemView.this.bNd.setInterpolator(new LinearInterpolator());
                        YuyinAlaRoomGiftItemView.this.bNd.setDuration(500L);
                        YuyinAlaRoomGiftItemView.this.bNd.addListener(new b());
                        YuyinAlaRoomGiftItemView.this.bNk = YuyinAlaRoomGiftItemView.this.bNd;
                        YuyinAlaRoomGiftItemView.this.bNd.start();
                        if (YuyinAlaRoomGiftItemView.this.bNf != null) {
                            YuyinAlaRoomGiftItemView.this.bNf.Vz();
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
                    if (!this.Mo && YuyinAlaRoomGiftItemView.this.bNf != null) {
                        YuyinAlaRoomGiftItemView.this.bNf.Vz();
                        YuyinAlaRoomGiftItemView.this.bNf.VA();
                    }
                    super.onAnimationEnd(animator);
                }
            });
        }
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vv() {
        if (this.bNj != null && this.bNj.size() != 0) {
            this.bNk = this.bNj.remove(0);
            if (this.bNk != null) {
                this.bNk.start();
            }
        }
    }

    public boolean q(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean z = this.bNa != null && this.bNa.isRunning();
        boolean z2 = this.bNk != null && a(this.bNk) && this.bNk.isRunning();
        if (z || z2) {
            if (this.bNh != null) {
                try {
                    this.bNh.setText(String.valueOf((int) (Integer.parseInt(this.bNh.getText().toString()) + cVar.aZP)));
                } catch (Exception e) {
                    this.bNh.setText(String.valueOf(cVar.aZP));
                }
            }
            if (z2) {
                Vw();
            }
            return true;
        }
        return false;
    }

    private void Vw() {
        if (this.bNj != null && !Vx()) {
            this.bNj.add(0, f(this.bNl));
        }
        if (a(this.bNk)) {
            this.bNk.cancel();
        }
    }

    private boolean Vx() {
        if (this.bNj != null) {
            for (ObjectAnimator objectAnimator : this.bNj) {
                if (a(objectAnimator)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void Vy() {
        Vv();
    }

    public void setStay1(int i) {
    }

    public void setStay2(int i) {
    }

    private boolean a(ObjectAnimator objectAnimator) {
        return objectAnimator != null && TextUtils.equals(objectAnimator.getPropertyName(), "stay1");
    }

    public void cancel() {
        if (this.bNj != null) {
            for (ObjectAnimator objectAnimator : this.bNj) {
                objectAnimator.cancel();
            }
        }
        if (this.bNk != null) {
            this.bNk.cancel();
        }
    }

    public void setAnimalCallBack(a aVar) {
        this.bNf = aVar;
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
            YuyinAlaRoomGiftItemView.this.Vv();
        }
    }
}
