package com.baidu.live.barrage.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.ao;
import com.baidu.live.data.bz;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private TbImageView aBM;
    private a aBN;
    private ao aBO;
    private bz aBP;
    public long aBQ;
    public int aBR;
    private View.OnClickListener aBS;
    private View aBb;
    private HeadImageView aBc;
    private View aBd;
    private TextView aBe;
    private ImageView aBf;
    private ImageView aBg;
    private LottieAnimationView aBh;
    private ObjectAnimator aBi;
    private ImageView aBj;
    private com.baidu.live.data.a aBl;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aBS = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aBN != null) {
                    LandscapeImBarrageItemView.this.aBN.b(LandscapeImBarrageItemView.this.aBl);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBS = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aBN != null) {
                    LandscapeImBarrageItemView.this.aBN.b(LandscapeImBarrageItemView.this.aBl);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aBN = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aBl = aVar;
        this.mContent = str2;
        BB();
        this.msgType = i;
    }

    public void setEffectInfo(ao aoVar) {
        if (aoVar != null) {
            this.aBO = aoVar;
            if (aoVar.aJv != 0 || aoVar.aJw != 0) {
                b(new int[]{aoVar.aJv, aoVar.aJw}, new int[]{aoVar.aJx, aoVar.aJx}, aoVar.aJz);
            }
            setTail(aoVar.aJA);
        }
    }

    public void setUIInfo(bz bzVar, boolean z) {
        int i = 0;
        this.aBb.setVisibility(bzVar == null ? 8 : 0);
        if (bzVar == null) {
            this.aBe.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aBe.getPaddingTop(), getResources().getDimensionPixelOffset(a.e.sdk_ds24), this.aBe.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (bzVar.price >= 300) {
                i = 2;
            } else if (bzVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aBP == null || !this.aBP.id.equals(bzVar.id)) {
                this.aBP = bzVar;
                setAvatarBg(this.aBP.Ds());
                b(this.aBP.Dt(), this.aBP.Du(), 205);
                setNobleInfo(bzVar);
            }
        }
    }

    private void setNobleInfo(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.type == 17) {
                this.aBj.setVisibility(0);
                if (bzVar.aMA == 7) {
                    this.aBj.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aBj.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aBf.setVisibility(8);
                this.aBg.setVisibility(8);
                return;
            }
            this.aBj.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aBb = findViewById(a.g.bg_avatar);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aBd = findViewById(a.g.mask_avatar);
        this.aBe = (TextView) findViewById(a.g.tv_content);
        this.aBf = (ImageView) findViewById(a.g.iv_light);
        this.aBg = (ImageView) findViewById(a.g.iv_sweep);
        this.aBM = (TbImageView) findViewById(a.g.iv_tail);
        this.aBh = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aBj = (ImageView) findViewById(a.g.barrage_prime);
        this.aBe.setMovementMethod(g.JG());
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aBh.loop(true);
        this.aBh.setAnimation("im_barrage_item_star.json");
        this.aBb.setOnClickListener(this.aBS);
        this.aBi = ObjectAnimator.ofFloat(this.aBg, "translationX", 0.0f, 0.0f);
        this.aBi.setDuration(800L);
        this.aBi.setInterpolator(new AccelerateInterpolator());
        this.aBi.setRepeatCount(-1);
        this.aBi.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aBg.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aBg.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aBi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aBg.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aBg.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aBM.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aBM.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aBM.setAutoChangeStyle(false);
    }

    private void BB() {
        BC();
        BD();
    }

    private void BC() {
        if (this.aBc != null && this.aBl != null) {
            this.aBc.stopLoad();
            this.aBc.startLoad(this.aBl.portrait, 12, false, false);
        }
    }

    private void BD() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aBl != null) {
                String nameShow = this.aBl.getNameShow();
                if (nameShow != null) {
                    if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                        nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
                    }
                    if (this.msgType != 3) {
                        nameShow = nameShow + " ";
                    }
                } else {
                    nameShow = "";
                }
                if (this.msgType == 3) {
                    str = String.format(this.mContent, "【" + nameShow + "】");
                } else {
                    str = nameShow + this.mContent;
                }
                SpannableString valueOf = SpannableString.valueOf(str);
                valueOf.setSpan(new b(), 0, valueOf.length(), 17);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
        } else {
            if (this.aBl != null) {
                String nameShow2 = this.aBl.getNameShow();
                if (nameShow2 != null) {
                    if (TextHelper.getTextLengthWithEmoji(nameShow2) > 20) {
                        nameShow2 = TextHelper.subStringWithEmoji(nameShow2, 20) + StringHelper.STRING_MORE;
                    }
                    str2 = nameShow2 + "：";
                } else {
                    str2 = "";
                }
                SpannableString valueOf2 = SpannableString.valueOf(str2);
                valueOf2.setSpan(new b(), 0, valueOf2.length(), 17);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            spannableStringBuilder.append((CharSequence) this.mContent);
        }
        this.aBe.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aBb.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(1);
            if (Build.VERSION.SDK_INT >= 16) {
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable.setColor(iArr[0]);
        }
        this.aBb.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aBe.getBackground();
        if (background instanceof com.baidu.live.view.g) {
            gVar = (com.baidu.live.view.g) background;
        } else {
            gVar = new com.baidu.live.view.g();
            if (i >= 0 && i <= 255) {
                gVar.setAlpha(i);
            }
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
        }
        if (iArr2 != null && iArr2.length >= 2 && (iArr2[0] != 0 || iArr2[1] != 0)) {
            gVar.f(iArr, iArr2);
            if (i >= 0 && i <= 255) {
                gVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            gVar.setColors(iArr);
        }
        this.aBe.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aBi != null) {
            this.aBi.cancel();
        }
        if (this.aBh != null) {
            this.aBh.cancelAnimation();
        }
        this.aBf.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aBd.setVisibility(0);
            this.aBi.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aBi.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aBe.getWidth() - LandscapeImBarrageItemView.this.aBe.getPaddingLeft()) - LandscapeImBarrageItemView.this.aBe.getPaddingRight());
                    LandscapeImBarrageItemView.this.aBi.start();
                }
            });
            this.aBh.setVisibility(0);
            this.aBh.playAnimation();
            this.aBe.setTextColor(-531173);
            return;
        }
        this.aBd.setVisibility(8);
        this.aBg.setVisibility(8);
        this.aBh.setVisibility(4);
        this.aBh.cancelAnimation();
        this.aBe.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aBM.startLoad(str, 10, false, false);
            this.aBM.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i = 0;
            int i2 = -1;
            if (LandscapeImBarrageItemView.this.aBO != null) {
                i = LandscapeImBarrageItemView.this.aBO.aJB;
                i2 = LandscapeImBarrageItemView.this.aBO.aJC;
            }
            if (i == 0) {
                if (LandscapeImBarrageItemView.this.msgType == 3) {
                    textPaint.setColor(Color.parseColor("#FFFFA6C4"));
                } else {
                    textPaint.setColor(Color.parseColor("#FFF7E51B"));
                }
            } else {
                textPaint.setColor(i);
            }
            if (i2 > 0 && i2 <= 255) {
                textPaint.setAlpha(i2);
            } else {
                textPaint.setAlpha(255);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (LandscapeImBarrageItemView.this.aBS != null) {
                LandscapeImBarrageItemView.this.aBS.onClick(view);
            }
        }
    }
}
