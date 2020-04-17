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
import com.baidu.live.data.ab;
import com.baidu.live.data.be;
import com.baidu.live.im.g;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes3.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private HeadImageView aAm;
    private TextView aNH;
    private be aNf;
    private ImageView aOA;
    private ImageView aOB;
    private TbImageView aOC;
    private LottieAnimationView aOD;
    private ObjectAnimator aOE;
    private a aOF;
    private com.baidu.live.data.a aOG;
    private ab aOH;
    public long aOI;
    public int aOJ;
    private View.OnClickListener aOK;
    private View aOy;
    private View aOz;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aOK = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aOF != null) {
                    LandscapeImBarrageItemView.this.aOF.c(LandscapeImBarrageItemView.this.aOG);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOK = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aOF != null) {
                    LandscapeImBarrageItemView.this.aOF.c(LandscapeImBarrageItemView.this.aOG);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aOF = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aOG = aVar;
        this.mContent = str2;
        CY();
        this.msgType = i;
    }

    public void setEffectInfo(ab abVar) {
        if (abVar != null) {
            this.aOH = abVar;
            if (abVar.atS != 0 || abVar.atT != 0) {
                b(new int[]{abVar.atS, abVar.atT}, new int[]{abVar.atU, abVar.atU}, abVar.atW);
            }
            setTail(abVar.atX);
        }
    }

    public void setUIInfo(be beVar, boolean z) {
        int i = 0;
        this.aOy.setVisibility(beVar == null ? 8 : 0);
        if (beVar == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            this.aNH.setPadding(dimensionPixelOffset, this.aNH.getPaddingTop(), dimensionPixelOffset, this.aNH.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (beVar.price >= 300) {
                i = 2;
            } else if (beVar.price >= 200) {
                i = 1;
            }
            k(i, z);
            if (this.aNf == null || !this.aNf.id.equals(beVar.id)) {
                this.aNf = beVar;
                setAvatarBg(this.aNf.vj());
                b(this.aNf.vk(), this.aNf.vl(), 205);
            }
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aOy = findViewById(a.g.bg_avatar);
        this.aAm = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aOz = findViewById(a.g.mask_avatar);
        this.aNH = (TextView) findViewById(a.g.tv_content);
        this.aOA = (ImageView) findViewById(a.g.iv_light);
        this.aOB = (ImageView) findViewById(a.g.iv_sweep);
        this.aOC = (TbImageView) findViewById(a.g.iv_tail);
        this.aOD = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aNH.setMovementMethod(g.Bd());
        this.aAm.setIsRound(true);
        this.aAm.setAutoChangeStyle(false);
        this.aAm.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aOD.loop(true);
        this.aOD.setAnimation("im_barrage_item_star.json");
        this.aOy.setOnClickListener(this.aOK);
        this.aOE = ObjectAnimator.ofFloat(this.aOB, "translationX", 0.0f, 0.0f);
        this.aOE.setDuration(800L);
        this.aOE.setInterpolator(new AccelerateInterpolator());
        this.aOE.setRepeatCount(-1);
        this.aOE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aOB.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aOB.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aOE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aOB.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aOB.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aOC.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aOC.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aOC.setAutoChangeStyle(false);
    }

    private void CY() {
        CZ();
        Da();
    }

    private void CZ() {
        if (this.aAm != null && this.aOG != null) {
            this.aAm.stopLoad();
            this.aAm.startLoad(this.aOG.portrait, 12, false, false);
        }
    }

    private void Da() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aOG != null) {
                String nameShow = this.aOG.getNameShow();
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
            if (this.aOG != null) {
                String nameShow2 = this.aOG.getNameShow();
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
        this.aNH.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aOy.getBackground();
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
        this.aOy.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aNH.getBackground();
        if (background instanceof com.baidu.live.view.g) {
            gVar = (com.baidu.live.view.g) background;
        } else {
            gVar = new com.baidu.live.view.g();
            if (i >= 0 && i <= 255) {
                gVar.setAlpha(i);
            }
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
        }
        if (iArr2 != null && iArr2.length >= 2 && (iArr2[0] != 0 || iArr2[1] != 0)) {
            gVar.f(iArr, iArr2);
            if (i >= 0 && i <= 255) {
                gVar.G((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            gVar.setColors(iArr);
        }
        this.aNH.setBackgroundDrawable(gVar);
    }

    private void k(int i, boolean z) {
        if (this.aOE != null) {
            this.aOE.cancel();
        }
        if (this.aOD != null) {
            this.aOD.cancelAnimation();
        }
        this.aOA.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aOz.setVisibility(0);
            this.aOE.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aOE.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aNH.getWidth() - LandscapeImBarrageItemView.this.aNH.getPaddingLeft()) - LandscapeImBarrageItemView.this.aNH.getPaddingRight());
                    LandscapeImBarrageItemView.this.aOE.start();
                }
            });
            this.aOD.setVisibility(0);
            this.aOD.playAnimation();
            this.aNH.setTextColor(-531173);
            return;
        }
        this.aOz.setVisibility(8);
        this.aOB.setVisibility(8);
        this.aOD.setVisibility(4);
        this.aOD.cancelAnimation();
        this.aNH.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aOC.startLoad(str, 10, false, false);
            this.aOC.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aOH != null) {
                i = LandscapeImBarrageItemView.this.aOH.atY;
                i2 = LandscapeImBarrageItemView.this.aOH.atZ;
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
            if (LandscapeImBarrageItemView.this.aOK != null) {
                LandscapeImBarrageItemView.this.aOK.onClick(view);
            }
        }
    }
}
