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
    private final int bSA;
    private final int bSB;
    private final int bSC;
    private final int bSD;
    private final float bSE;
    private final float bSF;
    private final int bSG;
    private float bSH;
    private float bSI;
    private ObjectAnimator bSJ;
    private ObjectAnimator bSK;
    private ObjectAnimator bSL;
    private ObjectAnimator bSM;
    private ObjectAnimator bSN;
    private a bSO;
    private TbImageView bSP;
    private TextView bSQ;
    private TextView bSR;
    private List<ObjectAnimator> bSS;
    private ObjectAnimator bST;
    private AlaWheatInfoData bSU;
    private final int bSV;
    private final int bSW;
    private final int bSz;

    /* loaded from: classes4.dex */
    public interface a {
        void XY();

        void XZ();
    }

    public YuyinAlaRoomGiftItemView(Context context) {
        this(context, null);
    }

    public YuyinAlaRoomGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSz = 500;
        this.bSA = 1500;
        this.bSB = 500;
        this.bSC = 800;
        this.bSD = 500;
        this.bSE = 1.0f;
        this.bSF = 0.76f;
        this.bSG = 4;
        this.bSS = new ArrayList();
        this.bSV = Color.parseColor("#FFEAAA");
        this.bSW = Color.parseColor("#FFFFFF");
        init();
    }

    private void init() {
        inflate(getContext(), a.g.yuyin_ala_item_room_gift_view, this);
        this.bSP = (TbImageView) findViewById(a.f.yuyin_ala_iv_gift_animal_icon);
        this.bSQ = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_count);
        this.bSR = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_userhint);
        this.bSH = BdUtilHelper.dip2px(getContext(), 96.0f);
        this.bSI = BdUtilHelper.dip2px(getContext(), 64.0f);
    }

    public void a(float f, float f2, AlaWheatInfoData alaWheatInfoData, c cVar) {
        if (f != 0.0f && f2 != 0.0f && alaWheatInfoData != null && cVar != null) {
            this.bSP.startLoad(cVar.bbc == null ? "fail" : cVar.bbc.getThumbnail_url(), 12, false);
            this.bSQ.setText(String.valueOf(cVar.bbi));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cVar.userName);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                spannableStringBuilder.append((CharSequence) "某人");
            }
            if (spannableStringBuilder.length() > 4) {
                spannableStringBuilder.replace(4, spannableStringBuilder.length(), (CharSequence) "");
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bSV), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "送");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bSW), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            this.bSR.setText(spannableStringBuilder);
            setX(f - (this.bSH / 2.0f));
            setY(f2);
            e(alaWheatInfoData);
        }
    }

    private void e(AlaWheatInfoData alaWheatInfoData) {
        if (alaWheatInfoData != null) {
            this.bSU = alaWheatInfoData;
            this.bSJ = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
            this.bSJ.setInterpolator(new LinearInterpolator());
            this.bSJ.setDuration(500L);
            this.bSJ.addListener(new b());
            this.bSK = f(alaWheatInfoData);
            this.bSS.clear();
            this.bSS.add(this.bSJ);
            this.bSS.add(this.bSK);
            if (alaWheatInfoData.locationCenterX != 0.0f || alaWheatInfoData.locationCenterY != 0.0f) {
                this.bSL = ObjectAnimator.ofInt(this, "stay2", 0, 1);
                this.bSL.setDuration(800L);
                this.bSL.addListener(new b());
                this.bSN = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.76f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.76f, 0.0f));
                this.bSN.setDuration(500L);
                this.bSN.setInterpolator(new LinearInterpolator());
                this.bSN.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.1
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.b, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (YuyinAlaRoomGiftItemView.this.bSO != null) {
                            YuyinAlaRoomGiftItemView.this.bSO.XZ();
                        }
                        if (YuyinAlaRoomGiftItemView.this.bSS != null) {
                            YuyinAlaRoomGiftItemView.this.bSS.clear();
                        }
                    }
                });
                this.bSS.add(this.bSL);
                this.bSS.add(this.bSN);
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
                        float f = alaWheatInfoData.locationCenterY - YuyinAlaRoomGiftItemView.this.bSI;
                        YuyinAlaRoomGiftItemView.this.bSM = ObjectAnimator.ofPropertyValuesHolder(YuyinAlaRoomGiftItemView.this, ofFloat, ofFloat2, PropertyValuesHolder.ofFloat("x", x, width), PropertyValuesHolder.ofFloat("y", y, f));
                        YuyinAlaRoomGiftItemView.this.bSM.setInterpolator(new LinearInterpolator());
                        YuyinAlaRoomGiftItemView.this.bSM.setDuration(500L);
                        YuyinAlaRoomGiftItemView.this.bSM.addListener(new b());
                        YuyinAlaRoomGiftItemView.this.bST = YuyinAlaRoomGiftItemView.this.bSM;
                        YuyinAlaRoomGiftItemView.this.bSM.start();
                        if (YuyinAlaRoomGiftItemView.this.bSO != null) {
                            YuyinAlaRoomGiftItemView.this.bSO.XY();
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
                    if (!this.Mo && YuyinAlaRoomGiftItemView.this.bSO != null) {
                        YuyinAlaRoomGiftItemView.this.bSO.XY();
                        YuyinAlaRoomGiftItemView.this.bSO.XZ();
                    }
                    super.onAnimationEnd(animator);
                }
            });
        }
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XU() {
        if (this.bSS != null && this.bSS.size() != 0) {
            this.bST = this.bSS.remove(0);
            if (this.bST != null) {
                this.bST.start();
            }
        }
    }

    public boolean q(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean z = this.bSJ != null && this.bSJ.isRunning();
        boolean z2 = this.bST != null && a(this.bST) && this.bST.isRunning();
        if (z || z2) {
            if (this.bSQ != null) {
                try {
                    this.bSQ.setText(String.valueOf((int) (Integer.parseInt(this.bSQ.getText().toString()) + cVar.bbi)));
                } catch (Exception e) {
                    this.bSQ.setText(String.valueOf(cVar.bbi));
                }
            }
            if (z2) {
                XV();
            }
            return true;
        }
        return false;
    }

    private void XV() {
        if (this.bSS != null && !XW()) {
            this.bSS.add(0, f(this.bSU));
        }
        if (a(this.bST)) {
            this.bST.cancel();
        }
    }

    private boolean XW() {
        if (this.bSS != null) {
            for (ObjectAnimator objectAnimator : this.bSS) {
                if (a(objectAnimator)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void XX() {
        XU();
    }

    public void setStay1(int i) {
    }

    public void setStay2(int i) {
    }

    private boolean a(ObjectAnimator objectAnimator) {
        return objectAnimator != null && TextUtils.equals(objectAnimator.getPropertyName(), "stay1");
    }

    public void cancel() {
        if (this.bSS != null) {
            for (ObjectAnimator objectAnimator : this.bSS) {
                objectAnimator.cancel();
            }
        }
        if (this.bST != null) {
            this.bST.cancel();
        }
    }

    public void setAnimalCallBack(a aVar) {
        this.bSO = aVar;
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
            YuyinAlaRoomGiftItemView.this.XU();
        }
    }
}
