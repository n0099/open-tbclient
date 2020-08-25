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
import com.baidu.live.data.aj;
import com.baidu.live.data.br;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes7.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private ObjectAnimator aAA;
    private ImageView aAB;
    private com.baidu.live.data.a aAD;
    private View aAt;
    private HeadImageView aAu;
    private View aAv;
    private TextView aAw;
    private ImageView aAx;
    private ImageView aAy;
    private LottieAnimationView aAz;
    private TbImageView aBe;
    private a aBf;
    private aj aBg;
    private br aBh;
    public long aBi;
    public int aBj;
    private View.OnClickListener aBk;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes7.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aBk = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aBf != null) {
                    LandscapeImBarrageItemView.this.aBf.b(LandscapeImBarrageItemView.this.aAD);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBk = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aBf != null) {
                    LandscapeImBarrageItemView.this.aBf.b(LandscapeImBarrageItemView.this.aAD);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aBf = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aAD = aVar;
        this.mContent = str2;
        Bm();
        this.msgType = i;
    }

    public void setEffectInfo(aj ajVar) {
        if (ajVar != null) {
            this.aBg = ajVar;
            if (ajVar.aHY != 0 || ajVar.aHZ != 0) {
                b(new int[]{ajVar.aHY, ajVar.aHZ}, new int[]{ajVar.aIa, ajVar.aIa}, ajVar.aIc);
            }
            setTail(ajVar.aId);
        }
    }

    public void setUIInfo(br brVar, boolean z) {
        int i = 0;
        this.aAt.setVisibility(brVar == null ? 8 : 0);
        if (brVar == null) {
            this.aAw.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aAw.getPaddingTop(), getResources().getDimensionPixelOffset(a.e.sdk_ds24), this.aAw.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (brVar.price >= 300) {
                i = 2;
            } else if (brVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aBh == null || !this.aBh.id.equals(brVar.id)) {
                this.aBh = brVar;
                setAvatarBg(this.aBh.Dc());
                b(this.aBh.Dd(), this.aBh.De(), 205);
                setNobleInfo(brVar);
            }
        }
    }

    private void setNobleInfo(br brVar) {
        if (brVar != null) {
            if (brVar.type == 17) {
                this.aAB.setVisibility(0);
                if (brVar.aKR == 7) {
                    this.aAB.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aAB.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aAx.setVisibility(8);
                this.aAy.setVisibility(8);
                return;
            }
            this.aAB.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aAt = findViewById(a.g.bg_avatar);
        this.aAu = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aAv = findViewById(a.g.mask_avatar);
        this.aAw = (TextView) findViewById(a.g.tv_content);
        this.aAx = (ImageView) findViewById(a.g.iv_light);
        this.aAy = (ImageView) findViewById(a.g.iv_sweep);
        this.aBe = (TbImageView) findViewById(a.g.iv_tail);
        this.aAz = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aAB = (ImageView) findViewById(a.g.barrage_prime);
        this.aAw.setMovementMethod(g.Jc());
        this.aAu.setIsRound(true);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aAz.loop(true);
        this.aAz.setAnimation("im_barrage_item_star.json");
        this.aAt.setOnClickListener(this.aBk);
        this.aAA = ObjectAnimator.ofFloat(this.aAy, "translationX", 0.0f, 0.0f);
        this.aAA.setDuration(800L);
        this.aAA.setInterpolator(new AccelerateInterpolator());
        this.aAA.setRepeatCount(-1);
        this.aAA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aAy.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aAy.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aAA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aAy.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aAy.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aBe.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aBe.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aBe.setAutoChangeStyle(false);
    }

    private void Bm() {
        Bn();
        Bo();
    }

    private void Bn() {
        if (this.aAu != null && this.aAD != null) {
            this.aAu.stopLoad();
            this.aAu.startLoad(this.aAD.portrait, 12, false, false);
        }
    }

    private void Bo() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aAD != null) {
                String nameShow = this.aAD.getNameShow();
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
            if (this.aAD != null) {
                String nameShow2 = this.aAD.getNameShow();
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
        this.aAw.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aAt.getBackground();
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
        this.aAt.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aAw.getBackground();
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
        this.aAw.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aAA != null) {
            this.aAA.cancel();
        }
        if (this.aAz != null) {
            this.aAz.cancelAnimation();
        }
        this.aAx.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aAv.setVisibility(0);
            this.aAA.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aAA.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aAw.getWidth() - LandscapeImBarrageItemView.this.aAw.getPaddingLeft()) - LandscapeImBarrageItemView.this.aAw.getPaddingRight());
                    LandscapeImBarrageItemView.this.aAA.start();
                }
            });
            this.aAz.setVisibility(0);
            this.aAz.playAnimation();
            this.aAw.setTextColor(-531173);
            return;
        }
        this.aAv.setVisibility(8);
        this.aAy.setVisibility(8);
        this.aAz.setVisibility(4);
        this.aAz.cancelAnimation();
        this.aAw.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aBe.startLoad(str, 10, false, false);
            this.aBe.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i = 0;
            int i2 = -1;
            if (LandscapeImBarrageItemView.this.aBg != null) {
                i = LandscapeImBarrageItemView.this.aBg.aIe;
                i2 = LandscapeImBarrageItemView.this.aBg.aIf;
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
            if (LandscapeImBarrageItemView.this.aBk != null) {
                LandscapeImBarrageItemView.this.aBk.onClick(view);
            }
        }
    }
}
