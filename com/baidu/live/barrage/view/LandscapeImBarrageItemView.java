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
import com.baidu.live.data.ah;
import com.baidu.live.data.bp;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private com.baidu.live.data.a avB;
    private View avr;
    private HeadImageView avs;
    private View avt;
    private TextView avu;
    private ImageView avv;
    private ImageView avw;
    private LottieAnimationView avx;
    private ObjectAnimator avy;
    private ImageView avz;
    private TbImageView awc;
    private a awd;
    private ah awe;
    private bp awf;
    public long awg;
    public int awh;
    private View.OnClickListener awi;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.awi = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.awd != null) {
                    LandscapeImBarrageItemView.this.awd.b(LandscapeImBarrageItemView.this.avB);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awi = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.awd != null) {
                    LandscapeImBarrageItemView.this.awd.b(LandscapeImBarrageItemView.this.avB);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.awd = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.avB = aVar;
        this.mContent = str2;
        vO();
        this.msgType = i;
    }

    public void setEffectInfo(ah ahVar) {
        if (ahVar != null) {
            this.awe = ahVar;
            if (ahVar.aCO != 0 || ahVar.aCP != 0) {
                b(new int[]{ahVar.aCO, ahVar.aCP}, new int[]{ahVar.aCQ, ahVar.aCQ}, ahVar.aCS);
            }
            setTail(ahVar.aCT);
        }
    }

    public void setUIInfo(bp bpVar, boolean z) {
        int i = 0;
        this.avr.setVisibility(bpVar == null ? 8 : 0);
        if (bpVar == null) {
            this.avu.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.avu.getPaddingTop(), getResources().getDimensionPixelOffset(a.e.sdk_ds24), this.avu.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (bpVar.price >= 300) {
                i = 2;
            } else if (bpVar.price >= 200) {
                i = 1;
            }
            l(i, z);
            if (this.awf == null || !this.awf.id.equals(bpVar.id)) {
                this.awf = bpVar;
                setAvatarBg(this.awf.xz());
                b(this.awf.xA(), this.awf.xB(), 205);
                setNobleInfo(bpVar);
            }
        }
    }

    private void setNobleInfo(bp bpVar) {
        if (bpVar != null) {
            if (bpVar.type == 17) {
                this.avz.setVisibility(0);
                if (bpVar.aFH == 7) {
                    this.avz.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.avz.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.avv.setVisibility(8);
                this.avw.setVisibility(8);
                return;
            }
            this.avz.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.avr = findViewById(a.g.bg_avatar);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.avt = findViewById(a.g.mask_avatar);
        this.avu = (TextView) findViewById(a.g.tv_content);
        this.avv = (ImageView) findViewById(a.g.iv_light);
        this.avw = (ImageView) findViewById(a.g.iv_sweep);
        this.awc = (TbImageView) findViewById(a.g.iv_tail);
        this.avx = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.avz = (ImageView) findViewById(a.g.barrage_prime);
        this.avu.setMovementMethod(g.Dz());
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setDefaultBgResource(a.f.sdk_default_avatar);
        this.avx.loop(true);
        this.avx.setAnimation("im_barrage_item_star.json");
        this.avr.setOnClickListener(this.awi);
        this.avy = ObjectAnimator.ofFloat(this.avw, "translationX", 0.0f, 0.0f);
        this.avy.setDuration(800L);
        this.avy.setInterpolator(new AccelerateInterpolator());
        this.avy.setRepeatCount(-1);
        this.avy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.avw.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.avw.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.avy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.avw.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.avw.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.awc.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.awc.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.awc.setAutoChangeStyle(false);
    }

    private void vO() {
        vP();
        vQ();
    }

    private void vP() {
        if (this.avs != null && this.avB != null) {
            this.avs.stopLoad();
            this.avs.startLoad(this.avB.portrait, 12, false, false);
        }
    }

    private void vQ() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.avB != null) {
                String nameShow = this.avB.getNameShow();
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
            if (this.avB != null) {
                String nameShow2 = this.avB.getNameShow();
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
        this.avu.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.avr.getBackground();
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
        this.avr.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.avu.getBackground();
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
                gVar.L((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            gVar.setColors(iArr);
        }
        this.avu.setBackgroundDrawable(gVar);
    }

    private void l(int i, boolean z) {
        if (this.avy != null) {
            this.avy.cancel();
        }
        if (this.avx != null) {
            this.avx.cancelAnimation();
        }
        this.avv.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.avt.setVisibility(0);
            this.avy.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.avy.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.avu.getWidth() - LandscapeImBarrageItemView.this.avu.getPaddingLeft()) - LandscapeImBarrageItemView.this.avu.getPaddingRight());
                    LandscapeImBarrageItemView.this.avy.start();
                }
            });
            this.avx.setVisibility(0);
            this.avx.playAnimation();
            this.avu.setTextColor(-531173);
            return;
        }
        this.avt.setVisibility(8);
        this.avw.setVisibility(8);
        this.avx.setVisibility(4);
        this.avx.cancelAnimation();
        this.avu.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.awc.startLoad(str, 10, false, false);
            this.awc.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.awe != null) {
                i = LandscapeImBarrageItemView.this.awe.aCU;
                i2 = LandscapeImBarrageItemView.this.awe.aCV;
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
            if (LandscapeImBarrageItemView.this.awi != null) {
                LandscapeImBarrageItemView.this.awi.onClick(view);
            }
        }
    }
}
