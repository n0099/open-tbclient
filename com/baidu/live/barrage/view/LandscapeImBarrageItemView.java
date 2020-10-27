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
import com.baidu.live.data.ar;
import com.baidu.live.data.ce;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private TbImageView aEZ;
    private View aEo;
    private HeadImageView aEp;
    private View aEq;
    private TextView aEr;
    private ImageView aEs;
    private ImageView aEt;
    private LottieAnimationView aEu;
    private ObjectAnimator aEv;
    private ImageView aEw;
    private com.baidu.live.data.a aEy;
    private a aFa;
    private ar aFb;
    private ce aFc;
    public long aFd;
    public int aFe;
    private View.OnClickListener aFf;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aFf = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aFa != null) {
                    LandscapeImBarrageItemView.this.aFa.b(LandscapeImBarrageItemView.this.aEy);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFf = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aFa != null) {
                    LandscapeImBarrageItemView.this.aFa.b(LandscapeImBarrageItemView.this.aEy);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aFa = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aEy = aVar;
        this.mContent = str2;
        CE();
        this.msgType = i;
    }

    public void setEffectInfo(ar arVar) {
        if (arVar != null) {
            this.aFb = arVar;
            if (arVar.aNf != 0 || arVar.aNg != 0) {
                b(new int[]{arVar.aNf, arVar.aNg}, new int[]{arVar.aNh, arVar.aNh}, arVar.aNj);
            }
            setTail(arVar.aNk);
        }
    }

    public void setUIInfo(ce ceVar, boolean z) {
        int i = 0;
        this.aEo.setVisibility(ceVar == null ? 8 : 0);
        if (ceVar == null) {
            this.aEr.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aEr.getPaddingTop(), getResources().getDimensionPixelOffset(a.e.sdk_ds24), this.aEr.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (ceVar.price >= 300) {
                i = 2;
            } else if (ceVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aFc == null || !this.aFc.id.equals(ceVar.id)) {
                this.aFc = ceVar;
                setAvatarBg(this.aFc.Ey());
                b(this.aFc.Ez(), this.aFc.EA(), 205);
                setNobleInfo(ceVar);
            }
        }
    }

    private void setNobleInfo(ce ceVar) {
        if (ceVar != null) {
            if (ceVar.type == 17) {
                this.aEw.setVisibility(0);
                if (ceVar.aQp == 7) {
                    this.aEw.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aEw.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aEs.setVisibility(8);
                this.aEt.setVisibility(8);
                return;
            }
            this.aEw.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aEo = findViewById(a.g.bg_avatar);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aEq = findViewById(a.g.mask_avatar);
        this.aEr = (TextView) findViewById(a.g.tv_content);
        this.aEs = (ImageView) findViewById(a.g.iv_light);
        this.aEt = (ImageView) findViewById(a.g.iv_sweep);
        this.aEZ = (TbImageView) findViewById(a.g.iv_tail);
        this.aEu = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aEw = (ImageView) findViewById(a.g.barrage_prime);
        this.aEr.setMovementMethod(g.Lg());
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aEu.loop(true);
        this.aEu.setAnimation("im_barrage_item_star.json");
        this.aEo.setOnClickListener(this.aFf);
        this.aEv = ObjectAnimator.ofFloat(this.aEt, "translationX", 0.0f, 0.0f);
        this.aEv.setDuration(800L);
        this.aEv.setInterpolator(new AccelerateInterpolator());
        this.aEv.setRepeatCount(-1);
        this.aEv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aEt.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aEt.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aEv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aEt.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aEt.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aEZ.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aEZ.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aEZ.setAutoChangeStyle(false);
    }

    private void CE() {
        CF();
        CG();
    }

    private void CF() {
        if (this.aEp != null && this.aEy != null) {
            this.aEp.stopLoad();
            this.aEp.startLoad(this.aEy.portrait, 12, false, false);
        }
    }

    private void CG() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aEy != null) {
                String nameShow = this.aEy.getNameShow();
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
            if (this.aEy != null) {
                String nameShow2 = this.aEy.getNameShow();
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
        this.aEr.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aEo.getBackground();
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
        this.aEo.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aEr.getBackground();
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
        this.aEr.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aEv != null) {
            this.aEv.cancel();
        }
        if (this.aEu != null) {
            this.aEu.cancelAnimation();
        }
        this.aEs.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aEq.setVisibility(0);
            this.aEv.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aEv.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aEr.getWidth() - LandscapeImBarrageItemView.this.aEr.getPaddingLeft()) - LandscapeImBarrageItemView.this.aEr.getPaddingRight());
                    LandscapeImBarrageItemView.this.aEv.start();
                }
            });
            this.aEu.setVisibility(0);
            this.aEu.playAnimation();
            this.aEr.setTextColor(-531173);
            return;
        }
        this.aEq.setVisibility(8);
        this.aEt.setVisibility(8);
        this.aEu.setVisibility(4);
        this.aEu.cancelAnimation();
        this.aEr.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aEZ.startLoad(str, 10, false, false);
            this.aEZ.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aFb != null) {
                i = LandscapeImBarrageItemView.this.aFb.aNl;
                i2 = LandscapeImBarrageItemView.this.aFb.aNm;
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
            if (LandscapeImBarrageItemView.this.aFf != null) {
                LandscapeImBarrageItemView.this.aFf.onClick(view);
            }
        }
    }
}
