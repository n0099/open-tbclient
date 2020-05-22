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
import com.baidu.live.data.af;
import com.baidu.live.data.bj;
import com.baidu.live.im.g;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes3.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private HeadImageView aFL;
    private TextView aTU;
    private bj aTr;
    private View aUM;
    private View aUN;
    private ImageView aUO;
    private ImageView aUP;
    private TbImageView aUQ;
    private LottieAnimationView aUR;
    private ObjectAnimator aUS;
    private ImageView aUT;
    private a aUU;
    private com.baidu.live.data.a aUV;
    private af aUW;
    public long aUX;
    public int aUY;
    private View.OnClickListener aUZ;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aUU != null) {
                    LandscapeImBarrageItemView.this.aUU.c(LandscapeImBarrageItemView.this.aUV);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aUU != null) {
                    LandscapeImBarrageItemView.this.aUU.c(LandscapeImBarrageItemView.this.aUV);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aUU = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aUV = aVar;
        this.mContent = str2;
        Ev();
        this.msgType = i;
    }

    public void setEffectInfo(af afVar) {
        if (afVar != null) {
            this.aUW = afVar;
            if (afVar.azc != 0 || afVar.azd != 0) {
                b(new int[]{afVar.azc, afVar.azd}, new int[]{afVar.aze, afVar.aze}, afVar.azg);
            }
            setTail(afVar.azh);
        }
    }

    public void setUIInfo(bj bjVar, boolean z) {
        int i = 0;
        this.aUM.setVisibility(bjVar == null ? 8 : 0);
        if (bjVar == null) {
            this.aTU.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aTU.getPaddingTop(), getResources().getDimensionPixelOffset(a.e.sdk_ds24), this.aTU.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (bjVar.price >= 300) {
                i = 2;
            } else if (bjVar.price >= 200) {
                i = 1;
            }
            k(i, z);
            if (this.aTr == null || !this.aTr.id.equals(bjVar.id)) {
                this.aTr = bjVar;
                setAvatarBg(this.aTr.wy());
                b(this.aTr.wz(), this.aTr.wA(), 205);
                setNobleInfo(bjVar);
            }
        }
    }

    private void setNobleInfo(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.type == 17) {
                this.aUT.setVisibility(0);
                if (bjVar.aCc == 7) {
                    this.aUT.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aUT.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aUO.setVisibility(8);
                this.aUP.setVisibility(8);
                return;
            }
            this.aUT.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aUM = findViewById(a.g.bg_avatar);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aUN = findViewById(a.g.mask_avatar);
        this.aTU = (TextView) findViewById(a.g.tv_content);
        this.aUO = (ImageView) findViewById(a.g.iv_light);
        this.aUP = (ImageView) findViewById(a.g.iv_sweep);
        this.aUQ = (TbImageView) findViewById(a.g.iv_tail);
        this.aUR = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aUT = (ImageView) findViewById(a.g.barrage_prime);
        this.aTU.setMovementMethod(g.Cy());
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aUR.loop(true);
        this.aUR.setAnimation("im_barrage_item_star.json");
        this.aUM.setOnClickListener(this.aUZ);
        this.aUS = ObjectAnimator.ofFloat(this.aUP, "translationX", 0.0f, 0.0f);
        this.aUS.setDuration(800L);
        this.aUS.setInterpolator(new AccelerateInterpolator());
        this.aUS.setRepeatCount(-1);
        this.aUS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aUP.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aUP.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aUS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aUP.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aUP.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aUQ.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aUQ.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aUQ.setAutoChangeStyle(false);
    }

    private void Ev() {
        Ew();
        Ex();
    }

    private void Ew() {
        if (this.aFL != null && this.aUV != null) {
            this.aFL.stopLoad();
            this.aFL.startLoad(this.aUV.portrait, 12, false, false);
        }
    }

    private void Ex() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aUV != null) {
                String nameShow = this.aUV.getNameShow();
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
            if (this.aUV != null) {
                String nameShow2 = this.aUV.getNameShow();
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
        this.aTU.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aUM.getBackground();
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
        this.aUM.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aTU.getBackground();
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
                gVar.J((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            gVar.setColors(iArr);
        }
        this.aTU.setBackgroundDrawable(gVar);
    }

    private void k(int i, boolean z) {
        if (this.aUS != null) {
            this.aUS.cancel();
        }
        if (this.aUR != null) {
            this.aUR.cancelAnimation();
        }
        this.aUO.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aUN.setVisibility(0);
            this.aUS.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aUS.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aTU.getWidth() - LandscapeImBarrageItemView.this.aTU.getPaddingLeft()) - LandscapeImBarrageItemView.this.aTU.getPaddingRight());
                    LandscapeImBarrageItemView.this.aUS.start();
                }
            });
            this.aUR.setVisibility(0);
            this.aUR.playAnimation();
            this.aTU.setTextColor(-531173);
            return;
        }
        this.aUN.setVisibility(8);
        this.aUP.setVisibility(8);
        this.aUR.setVisibility(4);
        this.aUR.cancelAnimation();
        this.aTU.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aUQ.startLoad(str, 10, false, false);
            this.aUQ.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aUW != null) {
                i = LandscapeImBarrageItemView.this.aUW.azi;
                i2 = LandscapeImBarrageItemView.this.aUW.azj;
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
            if (LandscapeImBarrageItemView.this.aUZ != null) {
                LandscapeImBarrageItemView.this.aUZ.onClick(view);
            }
        }
    }
}
