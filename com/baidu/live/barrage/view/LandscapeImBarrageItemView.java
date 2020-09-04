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
    private ImageView aAA;
    private LottieAnimationView aAB;
    private ObjectAnimator aAC;
    private ImageView aAD;
    private com.baidu.live.data.a aAF;
    private View aAv;
    private HeadImageView aAw;
    private View aAx;
    private TextView aAy;
    private ImageView aAz;
    private TbImageView aBg;
    private a aBh;
    private aj aBi;
    private br aBj;
    public long aBk;
    public int aBl;
    private View.OnClickListener aBm;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes7.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aBm = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aBh != null) {
                    LandscapeImBarrageItemView.this.aBh.b(LandscapeImBarrageItemView.this.aAF);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBm = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aBh != null) {
                    LandscapeImBarrageItemView.this.aBh.b(LandscapeImBarrageItemView.this.aAF);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aBh = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aAF = aVar;
        this.mContent = str2;
        Bm();
        this.msgType = i;
    }

    public void setEffectInfo(aj ajVar) {
        if (ajVar != null) {
            this.aBi = ajVar;
            if (ajVar.aIa != 0 || ajVar.aIb != 0) {
                b(new int[]{ajVar.aIa, ajVar.aIb}, new int[]{ajVar.aIc, ajVar.aIc}, ajVar.aIe);
            }
            setTail(ajVar.aIf);
        }
    }

    public void setUIInfo(br brVar, boolean z) {
        int i = 0;
        this.aAv.setVisibility(brVar == null ? 8 : 0);
        if (brVar == null) {
            this.aAy.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aAy.getPaddingTop(), getResources().getDimensionPixelOffset(a.e.sdk_ds24), this.aAy.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (brVar.price >= 300) {
                i = 2;
            } else if (brVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aBj == null || !this.aBj.id.equals(brVar.id)) {
                this.aBj = brVar;
                setAvatarBg(this.aBj.Dc());
                b(this.aBj.Dd(), this.aBj.De(), 205);
                setNobleInfo(brVar);
            }
        }
    }

    private void setNobleInfo(br brVar) {
        if (brVar != null) {
            if (brVar.type == 17) {
                this.aAD.setVisibility(0);
                if (brVar.aKT == 7) {
                    this.aAD.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aAD.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aAz.setVisibility(8);
                this.aAA.setVisibility(8);
                return;
            }
            this.aAD.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aAv = findViewById(a.g.bg_avatar);
        this.aAw = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aAx = findViewById(a.g.mask_avatar);
        this.aAy = (TextView) findViewById(a.g.tv_content);
        this.aAz = (ImageView) findViewById(a.g.iv_light);
        this.aAA = (ImageView) findViewById(a.g.iv_sweep);
        this.aBg = (TbImageView) findViewById(a.g.iv_tail);
        this.aAB = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aAD = (ImageView) findViewById(a.g.barrage_prime);
        this.aAy.setMovementMethod(g.Jc());
        this.aAw.setIsRound(true);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aAB.loop(true);
        this.aAB.setAnimation("im_barrage_item_star.json");
        this.aAv.setOnClickListener(this.aBm);
        this.aAC = ObjectAnimator.ofFloat(this.aAA, "translationX", 0.0f, 0.0f);
        this.aAC.setDuration(800L);
        this.aAC.setInterpolator(new AccelerateInterpolator());
        this.aAC.setRepeatCount(-1);
        this.aAC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aAA.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aAA.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aAC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aAA.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aAA.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aBg.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aBg.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aBg.setAutoChangeStyle(false);
    }

    private void Bm() {
        Bn();
        Bo();
    }

    private void Bn() {
        if (this.aAw != null && this.aAF != null) {
            this.aAw.stopLoad();
            this.aAw.startLoad(this.aAF.portrait, 12, false, false);
        }
    }

    private void Bo() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aAF != null) {
                String nameShow = this.aAF.getNameShow();
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
            if (this.aAF != null) {
                String nameShow2 = this.aAF.getNameShow();
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
        this.aAy.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aAv.getBackground();
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
        this.aAv.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.aAy.getBackground();
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
        this.aAy.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aAC != null) {
            this.aAC.cancel();
        }
        if (this.aAB != null) {
            this.aAB.cancelAnimation();
        }
        this.aAz.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aAx.setVisibility(0);
            this.aAC.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aAC.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aAy.getWidth() - LandscapeImBarrageItemView.this.aAy.getPaddingLeft()) - LandscapeImBarrageItemView.this.aAy.getPaddingRight());
                    LandscapeImBarrageItemView.this.aAC.start();
                }
            });
            this.aAB.setVisibility(0);
            this.aAB.playAnimation();
            this.aAy.setTextColor(-531173);
            return;
        }
        this.aAx.setVisibility(8);
        this.aAA.setVisibility(8);
        this.aAB.setVisibility(4);
        this.aAB.cancelAnimation();
        this.aAy.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aBg.startLoad(str, 10, false, false);
            this.aBg.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aBi != null) {
                i = LandscapeImBarrageItemView.this.aBi.aIg;
                i2 = LandscapeImBarrageItemView.this.aBi.aIh;
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
            if (LandscapeImBarrageItemView.this.aBm != null) {
                LandscapeImBarrageItemView.this.aBm.onClick(view);
            }
        }
    }
}
