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
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.data.ao;
import com.baidu.live.data.u;
import com.baidu.live.im.g;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes6.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private HeadImageView Xy;
    private TextView ahP;
    private View aiD;
    private View aiE;
    private View aiF;
    private ImageView aiG;
    private ImageView aiH;
    private LottieAnimationView aiI;
    private ObjectAnimator aiJ;
    private com.baidu.live.data.a aiL;
    private ao aiM;
    private a ajq;
    private u ajr;
    public long ajs;
    public int ajt;
    private View.OnClickListener aju;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes6.dex */
    public interface a {
        void d(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aju = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.ajq != null) {
                    LandscapeImBarrageItemView.this.ajq.d(LandscapeImBarrageItemView.this.aiL);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aju = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.ajq != null) {
                    LandscapeImBarrageItemView.this.ajq.d(LandscapeImBarrageItemView.this.aiL);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.ajq = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aiL = aVar;
        this.mContent = str2;
        this.msgType = i;
        tM();
    }

    public void setEffectInfo(u uVar) {
        if (uVar != null) {
            this.ajr = uVar;
            int bgColor = uVar.getBgColor();
            int ow = uVar.ow();
            if (bgColor == -1 || Build.VERSION.SDK_INT < 16) {
                return;
            }
            b(new int[]{bgColor, bgColor}, ow);
        }
    }

    public void setUIInfo(ao aoVar, boolean z) {
        int i = 0;
        this.aiD.setVisibility(aoVar == null ? 8 : 0);
        if (aoVar == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            this.ahP.setPadding(dimensionPixelOffset, this.ahP.getPaddingTop(), dimensionPixelOffset, this.ahP.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (aoVar.price >= 300) {
                i = 2;
            } else if (aoVar.price >= 200) {
                i = 1;
            }
            h(i, z);
            if (this.aiM == null || !this.aiM.id.equals(aoVar.id)) {
                this.aiM = aoVar;
                setAvatarBg(this.aiM.oC());
                setContentBg(this.aiM.oD());
                setContentStroke(this.aiM.oE());
            }
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aiD = findViewById(a.g.bg_avatar);
        this.Xy = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aiE = findViewById(a.g.mask_avatar);
        this.aiF = findViewById(a.g.bg_content);
        this.ahP = (TextView) findViewById(a.g.tv_content);
        this.aiG = (ImageView) findViewById(a.g.iv_light);
        this.aiH = (ImageView) findViewById(a.g.iv_sweep);
        this.aiI = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.ahP.setMovementMethod(g.sB());
        this.Xy.setIsRound(true);
        this.Xy.setAutoChangeStyle(false);
        this.Xy.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aiI.loop(true);
        this.aiI.setAnimation("im_barrage_item_star.json");
        this.aiD.setOnClickListener(this.aju);
        this.aiJ = ObjectAnimator.ofFloat(this.aiH, "translationX", 0.0f, 0.0f);
        this.aiJ.setDuration(800L);
        this.aiJ.setInterpolator(new AccelerateInterpolator());
        this.aiJ.setRepeatCount(-1);
        this.aiJ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aiH.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aiH.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aiJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aiH.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aiH.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void tM() {
        tN();
        tO();
    }

    private void tN() {
        if (this.Xy != null && this.aiL != null) {
            this.Xy.stopLoad();
            this.Xy.startLoad(this.aiL.portrait, 12, false, false);
        }
    }

    private void tO() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aiL != null) {
                String nameShow = this.aiL.getNameShow();
                if (nameShow != null) {
                    if (TextHelper.getTextLengthWithEmoji(nameShow) > 14) {
                        nameShow = TextHelper.subStringWithEmoji(nameShow, 14) + StringHelper.STRING_MORE;
                    }
                    if (this.msgType != 3) {
                        nameShow = nameShow + HanziToPinyin.Token.SEPARATOR;
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
            if (this.aiL != null) {
                String nameShow2 = this.aiL.getNameShow();
                if (nameShow2 != null) {
                    if (TextHelper.getTextLengthWithEmoji(nameShow2) > 14) {
                        nameShow2 = TextHelper.subStringWithEmoji(nameShow2, 14) + StringHelper.STRING_MORE;
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
        this.ahP.setText(spannableStringBuilder);
    }

    @RequiresApi(api = 16)
    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aiD.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(1);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable.setColors(iArr);
        this.aiD.setBackground(gradientDrawable);
    }

    @RequiresApi(api = 16)
    private void setContentBg(int[] iArr) {
        b(iArr, -1);
    }

    @RequiresApi(api = 16)
    private void b(int[] iArr, int i) {
        GradientDrawable gradientDrawable;
        Drawable background = this.ahP.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setShape(0);
        }
        if (i != -1) {
            gradientDrawable.setAlpha(i);
        } else {
            gradientDrawable.setAlpha(255);
        }
        gradientDrawable.setColors(iArr);
        this.ahP.setBackground(gradientDrawable);
    }

    @RequiresApi(api = 16)
    private void setContentStroke(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aiF.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setShape(0);
        }
        gradientDrawable.setColors(iArr);
        this.aiF.setBackground(gradientDrawable);
    }

    private void h(int i, boolean z) {
        if (this.aiJ != null) {
            this.aiJ.cancel();
        }
        if (this.aiI != null) {
            this.aiI.cancelAnimation();
        }
        this.aiG.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aiE.setVisibility(0);
            this.aiJ.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aiJ.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.ahP.getWidth() - LandscapeImBarrageItemView.this.ahP.getPaddingLeft()) - LandscapeImBarrageItemView.this.ahP.getPaddingRight());
                    LandscapeImBarrageItemView.this.aiJ.start();
                }
            });
            this.aiI.setVisibility(0);
            this.aiI.playAnimation();
            this.ahP.setTextColor(-531173);
            return;
        }
        this.aiE.setVisibility(8);
        this.aiH.setVisibility(8);
        this.aiI.setVisibility(4);
        this.aiI.cancelAnimation();
        this.ahP.setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i;
            int i2;
            if (LandscapeImBarrageItemView.this.ajr != null) {
                i2 = LandscapeImBarrageItemView.this.ajr.ov();
                i = LandscapeImBarrageItemView.this.ajr.ox();
            } else {
                i = -1;
                i2 = -1;
            }
            if (i2 == -1) {
                if (LandscapeImBarrageItemView.this.msgType == 3) {
                    textPaint.setColor(Color.parseColor("#FFFFA6C4"));
                } else {
                    textPaint.setColor(Color.parseColor("#FFF7E51B"));
                }
            } else {
                textPaint.setColor(i2);
            }
            if (i != -1) {
                textPaint.setAlpha(i);
            } else {
                textPaint.setAlpha(255);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (LandscapeImBarrageItemView.this.aju != null) {
                LandscapeImBarrageItemView.this.aju.onClick(view);
            }
        }
    }
}
