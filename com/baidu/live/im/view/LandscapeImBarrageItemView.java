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
import com.baidu.live.data.az;
import com.baidu.live.data.y;
import com.baidu.live.im.g;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes2.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private HeadImageView afA;
    private TbImageView anx;
    private View aqW;
    private View aqX;
    private ImageView aqY;
    private ImageView aqZ;
    private TextView aqn;
    private a arH;
    private y arI;
    public long arJ;
    public int arK;
    private View.OnClickListener arL;
    private LottieAnimationView ara;
    private ObjectAnimator arb;
    private com.baidu.live.data.a ard;
    private az are;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes2.dex */
    public interface a {
        void d(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.arL = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.arH != null) {
                    LandscapeImBarrageItemView.this.arH.d(LandscapeImBarrageItemView.this.ard);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arL = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.arH != null) {
                    LandscapeImBarrageItemView.this.arH.d(LandscapeImBarrageItemView.this.ard);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.arH = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.ard = aVar;
        this.mContent = str2;
        wa();
        this.msgType = i;
    }

    public void setEffectInfo(y yVar) {
        if (yVar != null) {
            this.arI = yVar;
            if (yVar.Zt != 0 || yVar.Zu != 0) {
                a(new int[]{yVar.Zt, yVar.Zu}, new int[]{yVar.Zv, yVar.Zv}, yVar.Zx);
            }
            setTail(yVar.Zy);
        }
    }

    public void setUIInfo(az azVar, boolean z) {
        int i = 0;
        this.aqW.setVisibility(azVar == null ? 8 : 0);
        if (azVar == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            this.aqn.setPadding(dimensionPixelOffset, this.aqn.getPaddingTop(), dimensionPixelOffset, this.aqn.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (azVar.price >= 300) {
                i = 2;
            } else if (azVar.price >= 200) {
                i = 1;
            }
            h(i, z);
            if (this.are == null || !this.are.id.equals(azVar.id)) {
                this.are = azVar;
                setAvatarBg(this.are.qc());
                a(this.are.qd(), this.are.qe(), 205);
            }
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aqW = findViewById(a.g.bg_avatar);
        this.afA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aqX = findViewById(a.g.mask_avatar);
        this.aqn = (TextView) findViewById(a.g.tv_content);
        this.aqY = (ImageView) findViewById(a.g.iv_light);
        this.aqZ = (ImageView) findViewById(a.g.iv_sweep);
        this.anx = (TbImageView) findViewById(a.g.iv_tail);
        this.ara = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aqn.setMovementMethod(g.uK());
        this.afA.setIsRound(true);
        this.afA.setAutoChangeStyle(false);
        this.afA.setDefaultBgResource(a.f.sdk_default_avatar);
        this.ara.loop(true);
        this.ara.setAnimation("im_barrage_item_star.json");
        this.aqW.setOnClickListener(this.arL);
        this.arb = ObjectAnimator.ofFloat(this.aqZ, "translationX", 0.0f, 0.0f);
        this.arb.setDuration(800L);
        this.arb.setInterpolator(new AccelerateInterpolator());
        this.arb.setRepeatCount(-1);
        this.arb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aqZ.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aqZ.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.arb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aqZ.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aqZ.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.anx.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.anx.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.anx.setAutoChangeStyle(false);
    }

    private void wa() {
        wb();
        wc();
    }

    private void wb() {
        if (this.afA != null && this.ard != null) {
            this.afA.stopLoad();
            this.afA.startLoad(this.ard.portrait, 12, false, false);
        }
    }

    private void wc() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.ard != null) {
                String nameShow = this.ard.getNameShow();
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
            if (this.ard != null) {
                String nameShow2 = this.ard.getNameShow();
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
        this.aqn.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aqW.getBackground();
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
        this.aqW.setBackgroundDrawable(gradientDrawable);
    }

    private void a(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aqn.getBackground();
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
            gVar.e(iArr, iArr2);
            if (i >= 0 && i <= 255) {
                gVar.G((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            gVar.setColors(iArr);
        }
        this.aqn.setBackgroundDrawable(gVar);
    }

    private void h(int i, boolean z) {
        if (this.arb != null) {
            this.arb.cancel();
        }
        if (this.ara != null) {
            this.ara.cancelAnimation();
        }
        this.aqY.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aqX.setVisibility(0);
            this.arb.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.arb.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aqn.getWidth() - LandscapeImBarrageItemView.this.aqn.getPaddingLeft()) - LandscapeImBarrageItemView.this.aqn.getPaddingRight());
                    LandscapeImBarrageItemView.this.arb.start();
                }
            });
            this.ara.setVisibility(0);
            this.ara.playAnimation();
            this.aqn.setTextColor(-531173);
            return;
        }
        this.aqX.setVisibility(8);
        this.aqZ.setVisibility(8);
        this.ara.setVisibility(4);
        this.ara.cancelAnimation();
        this.aqn.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.anx.startLoad(str, 10, false, false);
            this.anx.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i = 0;
            int i2 = -1;
            if (LandscapeImBarrageItemView.this.arI != null) {
                i = LandscapeImBarrageItemView.this.arI.Zz;
                i2 = LandscapeImBarrageItemView.this.arI.ZA;
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
            if (LandscapeImBarrageItemView.this.arL != null) {
                LandscapeImBarrageItemView.this.arL.onClick(view);
            }
        }
    }
}
