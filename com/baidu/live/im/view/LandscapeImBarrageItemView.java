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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.data.bb;
import com.baidu.live.data.z;
import com.baidu.live.im.g;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes3.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private HeadImageView ahI;
    private TbImageView aqQ;
    private TextView atY;
    private View auM;
    private View auN;
    private ImageView auO;
    private ImageView auP;
    private LottieAnimationView auQ;
    private ObjectAnimator auR;
    private a auS;
    private com.baidu.live.data.a auT;
    private z auU;
    private bb auV;
    public long auW;
    public int auX;
    private View.OnClickListener auY;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.auY = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.auS != null) {
                    LandscapeImBarrageItemView.this.auS.c(LandscapeImBarrageItemView.this.auT);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auY = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.auS != null) {
                    LandscapeImBarrageItemView.this.auS.c(LandscapeImBarrageItemView.this.auT);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.auS = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.auT = aVar;
        this.mContent = str2;
        yb();
        this.msgType = i;
    }

    public void setEffectInfo(z zVar) {
        if (zVar != null) {
            this.auU = zVar;
            if (zVar.abn != 0 || zVar.abo != 0) {
                b(new int[]{zVar.abn, zVar.abo}, new int[]{zVar.abp, zVar.abp}, zVar.abr);
            }
            setTail(zVar.abt);
        }
    }

    public void setUIInfo(bb bbVar, boolean z) {
        int i = 0;
        this.auM.setVisibility(bbVar == null ? 8 : 0);
        if (bbVar == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            this.atY.setPadding(dimensionPixelOffset, this.atY.getPaddingTop(), dimensionPixelOffset, this.atY.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (bbVar.price >= 300) {
                i = 2;
            } else if (bbVar.price >= 200) {
                i = 1;
            }
            h(i, z);
            if (this.auV == null || !this.auV.id.equals(bbVar.id)) {
                this.auV = bbVar;
                setAvatarBg(this.auV.qN());
                b(this.auV.qO(), this.auV.qP(), 205);
            }
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.auM = findViewById(a.g.bg_avatar);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.auN = findViewById(a.g.mask_avatar);
        this.atY = (TextView) findViewById(a.g.tv_content);
        this.auO = (ImageView) findViewById(a.g.iv_light);
        this.auP = (ImageView) findViewById(a.g.iv_sweep);
        this.aqQ = (TbImageView) findViewById(a.g.iv_tail);
        this.auQ = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.atY.setMovementMethod(g.wo());
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setDefaultBgResource(a.f.sdk_default_avatar);
        this.auQ.loop(true);
        this.auQ.setAnimation("im_barrage_item_star.json");
        this.auM.setOnClickListener(this.auY);
        this.auR = ObjectAnimator.ofFloat(this.auP, "translationX", 0.0f, 0.0f);
        this.auR.setDuration(800L);
        this.auR.setInterpolator(new AccelerateInterpolator());
        this.auR.setRepeatCount(-1);
        this.auR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.auP.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.auP.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.auR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.auP.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.auP.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aqQ.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aqQ.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aqQ.setAutoChangeStyle(false);
    }

    private void yb() {
        yc();
        yd();
    }

    private void yc() {
        if (this.ahI != null && this.auT != null) {
            this.ahI.stopLoad();
            this.ahI.startLoad(this.auT.portrait, 12, false, false);
        }
    }

    private void yd() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.auT != null) {
                String nameShow = this.auT.getNameShow();
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
            if (this.auT != null) {
                String nameShow2 = this.auT.getNameShow();
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
        this.atY.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.auM.getBackground();
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
        this.auM.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.atY.getBackground();
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
                gVar.H((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            gVar.setColors(iArr);
        }
        this.atY.setBackgroundDrawable(gVar);
    }

    private void h(int i, boolean z) {
        if (this.auR != null) {
            this.auR.cancel();
        }
        if (this.auQ != null) {
            this.auQ.cancelAnimation();
        }
        this.auO.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.auN.setVisibility(0);
            this.auR.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.auR.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.atY.getWidth() - LandscapeImBarrageItemView.this.atY.getPaddingLeft()) - LandscapeImBarrageItemView.this.atY.getPaddingRight());
                    LandscapeImBarrageItemView.this.auR.start();
                }
            });
            this.auQ.setVisibility(0);
            this.auQ.playAnimation();
            this.atY.setTextColor(-531173);
            return;
        }
        this.auN.setVisibility(8);
        this.auP.setVisibility(8);
        this.auQ.setVisibility(4);
        this.auQ.cancelAnimation();
        this.atY.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aqQ.startLoad(str, 10, false, false);
            this.aqQ.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.auU != null) {
                i = LandscapeImBarrageItemView.this.auU.abu;
                i2 = LandscapeImBarrageItemView.this.auU.abv;
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
            if (LandscapeImBarrageItemView.this.auY != null) {
                LandscapeImBarrageItemView.this.auY.onClick(view);
            }
        }
    }
}
