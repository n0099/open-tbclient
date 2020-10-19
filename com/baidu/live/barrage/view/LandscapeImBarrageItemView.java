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
    private TbImageView aER;
    private a aES;
    private ao aET;
    private bz aEU;
    public long aEV;
    public int aEW;
    private View.OnClickListener aEX;
    private View aEg;
    private HeadImageView aEh;
    private View aEi;
    private TextView aEj;
    private ImageView aEk;
    private ImageView aEl;
    private LottieAnimationView aEm;
    private ObjectAnimator aEn;
    private ImageView aEo;
    private com.baidu.live.data.a aEq;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aEX = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aES != null) {
                    LandscapeImBarrageItemView.this.aES.b(LandscapeImBarrageItemView.this.aEq);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEX = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aES != null) {
                    LandscapeImBarrageItemView.this.aES.b(LandscapeImBarrageItemView.this.aEq);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aES = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aEq = aVar;
        this.mContent = str2;
        Cy();
        this.msgType = i;
    }

    public void setEffectInfo(ao aoVar) {
        if (aoVar != null) {
            this.aET = aoVar;
            if (aoVar.aMA != 0 || aoVar.aMB != 0) {
                b(new int[]{aoVar.aMA, aoVar.aMB}, new int[]{aoVar.aMC, aoVar.aMC}, aoVar.aME);
            }
            setTail(aoVar.aMF);
        }
    }

    public void setUIInfo(bz bzVar, boolean z) {
        int i = 0;
        this.aEg.setVisibility(bzVar == null ? 8 : 0);
        if (bzVar == null) {
            this.aEj.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aEj.getPaddingTop(), getResources().getDimensionPixelOffset(a.e.sdk_ds24), this.aEj.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (bzVar.price >= 300) {
                i = 2;
            } else if (bzVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aEU == null || !this.aEU.id.equals(bzVar.id)) {
                this.aEU = bzVar;
                setAvatarBg(this.aEU.Ep());
                b(this.aEU.Eq(), this.aEU.Er(), 205);
                setNobleInfo(bzVar);
            }
        }
    }

    private void setNobleInfo(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.type == 17) {
                this.aEo.setVisibility(0);
                if (bzVar.aPF == 7) {
                    this.aEo.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aEo.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aEk.setVisibility(8);
                this.aEl.setVisibility(8);
                return;
            }
            this.aEo.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aEg = findViewById(a.g.bg_avatar);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aEi = findViewById(a.g.mask_avatar);
        this.aEj = (TextView) findViewById(a.g.tv_content);
        this.aEk = (ImageView) findViewById(a.g.iv_light);
        this.aEl = (ImageView) findViewById(a.g.iv_sweep);
        this.aER = (TbImageView) findViewById(a.g.iv_tail);
        this.aEm = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aEo = (ImageView) findViewById(a.g.barrage_prime);
        this.aEj.setMovementMethod(g.KM());
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aEm.loop(true);
        this.aEm.setAnimation("im_barrage_item_star.json");
        this.aEg.setOnClickListener(this.aEX);
        this.aEn = ObjectAnimator.ofFloat(this.aEl, "translationX", 0.0f, 0.0f);
        this.aEn.setDuration(800L);
        this.aEn.setInterpolator(new AccelerateInterpolator());
        this.aEn.setRepeatCount(-1);
        this.aEn.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aEl.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aEl.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aEn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aEl.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aEl.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aER.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aER.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aER.setAutoChangeStyle(false);
    }

    private void Cy() {
        Cz();
        CA();
    }

    private void Cz() {
        if (this.aEh != null && this.aEq != null) {
            this.aEh.stopLoad();
            this.aEh.startLoad(this.aEq.portrait, 12, false, false);
        }
    }

    private void CA() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aEq != null) {
                String nameShow = this.aEq.getNameShow();
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
            if (this.aEq != null) {
                String nameShow2 = this.aEq.getNameShow();
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
        this.aEj.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aEg.getBackground();
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
        this.aEg.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aEj.getBackground();
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
        this.aEj.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aEn != null) {
            this.aEn.cancel();
        }
        if (this.aEm != null) {
            this.aEm.cancelAnimation();
        }
        this.aEk.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aEi.setVisibility(0);
            this.aEn.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aEn.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aEj.getWidth() - LandscapeImBarrageItemView.this.aEj.getPaddingLeft()) - LandscapeImBarrageItemView.this.aEj.getPaddingRight());
                    LandscapeImBarrageItemView.this.aEn.start();
                }
            });
            this.aEm.setVisibility(0);
            this.aEm.playAnimation();
            this.aEj.setTextColor(-531173);
            return;
        }
        this.aEi.setVisibility(8);
        this.aEl.setVisibility(8);
        this.aEm.setVisibility(4);
        this.aEm.cancelAnimation();
        this.aEj.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aER.startLoad(str, 10, false, false);
            this.aER.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aET != null) {
                i = LandscapeImBarrageItemView.this.aET.aMG;
                i2 = LandscapeImBarrageItemView.this.aET.aMH;
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
            if (LandscapeImBarrageItemView.this.aEX != null) {
                LandscapeImBarrageItemView.this.aEX.onClick(view);
            }
        }
    }
}
