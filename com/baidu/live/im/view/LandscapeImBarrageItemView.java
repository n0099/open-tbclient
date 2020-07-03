package com.baidu.live.im.view;

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
import com.baidu.live.data.ag;
import com.baidu.live.data.bo;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes3.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private HeadImageView aIh;
    private bo aVX;
    private TextView aWB;
    private ImageView aXA;
    private a aXB;
    private com.baidu.live.data.a aXC;
    private ag aXD;
    public long aXE;
    public int aXF;
    private View.OnClickListener aXG;
    private View aXt;
    private View aXu;
    private ImageView aXv;
    private ImageView aXw;
    private TbImageView aXx;
    private LottieAnimationView aXy;
    private ObjectAnimator aXz;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aXG = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aXB != null) {
                    LandscapeImBarrageItemView.this.aXB.c(LandscapeImBarrageItemView.this.aXC);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXG = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aXB != null) {
                    LandscapeImBarrageItemView.this.aXB.c(LandscapeImBarrageItemView.this.aXC);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aXB = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aXC = aVar;
        this.mContent = str2;
        EZ();
        this.msgType = i;
    }

    public void setEffectInfo(ag agVar) {
        if (agVar != null) {
            this.aXD = agVar;
            if (agVar.aBt != 0 || agVar.aBu != 0) {
                b(new int[]{agVar.aBt, agVar.aBu}, new int[]{agVar.aBv, agVar.aBv}, agVar.aBx);
            }
            setTail(agVar.aBy);
        }
    }

    public void setUIInfo(bo boVar, boolean z) {
        int i = 0;
        this.aXt.setVisibility(boVar == null ? 8 : 0);
        if (boVar == null) {
            this.aWB.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aWB.getPaddingTop(), getResources().getDimensionPixelOffset(a.e.sdk_ds24), this.aWB.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (boVar.price >= 300) {
                i = 2;
            } else if (boVar.price >= 200) {
                i = 1;
            }
            l(i, z);
            if (this.aVX == null || !this.aVX.id.equals(boVar.id)) {
                this.aVX = boVar;
                setAvatarBg(this.aVX.wW());
                b(this.aVX.wX(), this.aVX.wY(), 205);
                setNobleInfo(boVar);
            }
        }
    }

    private void setNobleInfo(bo boVar) {
        if (boVar != null) {
            if (boVar.type == 17) {
                this.aXA.setVisibility(0);
                if (boVar.aEn == 7) {
                    this.aXA.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aXA.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aXv.setVisibility(8);
                this.aXw.setVisibility(8);
                return;
            }
            this.aXA.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aXt = findViewById(a.g.bg_avatar);
        this.aIh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aXu = findViewById(a.g.mask_avatar);
        this.aWB = (TextView) findViewById(a.g.tv_content);
        this.aXv = (ImageView) findViewById(a.g.iv_light);
        this.aXw = (ImageView) findViewById(a.g.iv_sweep);
        this.aXx = (TbImageView) findViewById(a.g.iv_tail);
        this.aXy = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aXA = (ImageView) findViewById(a.g.barrage_prime);
        this.aWB.setMovementMethod(g.CY());
        this.aIh.setIsRound(true);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aXy.loop(true);
        this.aXy.setAnimation("im_barrage_item_star.json");
        this.aXt.setOnClickListener(this.aXG);
        this.aXz = ObjectAnimator.ofFloat(this.aXw, "translationX", 0.0f, 0.0f);
        this.aXz.setDuration(800L);
        this.aXz.setInterpolator(new AccelerateInterpolator());
        this.aXz.setRepeatCount(-1);
        this.aXz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aXw.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aXw.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aXz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aXw.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aXw.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aXx.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aXx.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aXx.setAutoChangeStyle(false);
    }

    private void EZ() {
        Fa();
        Fb();
    }

    private void Fa() {
        if (this.aIh != null && this.aXC != null) {
            this.aIh.stopLoad();
            this.aIh.startLoad(this.aXC.portrait, 12, false, false);
        }
    }

    private void Fb() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aXC != null) {
                String nameShow = this.aXC.getNameShow();
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
            if (this.aXC != null) {
                String nameShow2 = this.aXC.getNameShow();
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
        this.aWB.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aXt.getBackground();
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
        this.aXt.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aWB.getBackground();
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
        this.aWB.setBackgroundDrawable(gVar);
    }

    private void l(int i, boolean z) {
        if (this.aXz != null) {
            this.aXz.cancel();
        }
        if (this.aXy != null) {
            this.aXy.cancelAnimation();
        }
        this.aXv.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aXu.setVisibility(0);
            this.aXz.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aXz.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aWB.getWidth() - LandscapeImBarrageItemView.this.aWB.getPaddingLeft()) - LandscapeImBarrageItemView.this.aWB.getPaddingRight());
                    LandscapeImBarrageItemView.this.aXz.start();
                }
            });
            this.aXy.setVisibility(0);
            this.aXy.playAnimation();
            this.aWB.setTextColor(-531173);
            return;
        }
        this.aXu.setVisibility(8);
        this.aXw.setVisibility(8);
        this.aXy.setVisibility(4);
        this.aXy.cancelAnimation();
        this.aWB.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aXx.startLoad(str, 10, false, false);
            this.aXx.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i = 0;
            int i2 = -1;
            if (LandscapeImBarrageItemView.this.aXD != null) {
                i = LandscapeImBarrageItemView.this.aXD.aBz;
                i2 = LandscapeImBarrageItemView.this.aXD.aBA;
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
            if (LandscapeImBarrageItemView.this.aXG != null) {
                LandscapeImBarrageItemView.this.aXG.onClick(view);
            }
        }
    }
}
