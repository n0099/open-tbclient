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
import com.baidu.live.data.at;
import com.baidu.live.data.cg;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.view.f;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private TbImageView aFP;
    private a aFQ;
    private at aFR;
    private cg aFS;
    public long aFT;
    public int aFU;
    private View.OnClickListener aFV;
    private View aFe;
    private HeadImageView aFf;
    private View aFg;
    private TextView aFh;
    private ImageView aFi;
    private ImageView aFj;
    private LottieAnimationView aFk;
    private ObjectAnimator aFl;
    private ImageView aFm;
    private com.baidu.live.data.a aFo;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aFV = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aFQ != null) {
                    LandscapeImBarrageItemView.this.aFQ.b(LandscapeImBarrageItemView.this.aFo);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFV = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aFQ != null) {
                    LandscapeImBarrageItemView.this.aFQ.b(LandscapeImBarrageItemView.this.aFo);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aFQ = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aFo = aVar;
        this.mContent = str2;
        CX();
        this.msgType = i;
    }

    public void setEffectInfo(at atVar) {
        if (atVar != null) {
            this.aFR = atVar;
            if (atVar.aOi != 0 || atVar.aOj != 0) {
                b(new int[]{atVar.aOi, atVar.aOj}, new int[]{atVar.aOk, atVar.aOk}, atVar.aOm);
            }
            setTail(atVar.aOn);
        }
    }

    public void setUIInfo(cg cgVar, boolean z) {
        int i = 0;
        this.aFe.setVisibility(cgVar == null ? 8 : 0);
        if (cgVar == null) {
            this.aFh.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), this.aFh.getPaddingTop(), getResources().getDimensionPixelOffset(a.d.sdk_ds24), this.aFh.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (cgVar.price >= 300) {
                i = 2;
            } else if (cgVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aFS == null || !this.aFS.id.equals(cgVar.id)) {
                this.aFS = cgVar;
                setAvatarBg(this.aFS.EZ());
                b(this.aFS.Fa(), this.aFS.Fb(), 205);
                setNobleInfo(cgVar);
            }
        }
    }

    private void setNobleInfo(cg cgVar) {
        if (cgVar != null) {
            if (cgVar.type == 17) {
                this.aFm.setVisibility(0);
                if (cgVar.aRr == 7) {
                    this.aFm.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aFm.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aFi.setVisibility(8);
                this.aFj.setVisibility(8);
                return;
            }
            this.aFm.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aFe = findViewById(a.f.bg_avatar);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aFg = findViewById(a.f.mask_avatar);
        this.aFh = (TextView) findViewById(a.f.tv_content);
        this.aFi = (ImageView) findViewById(a.f.iv_light);
        this.aFj = (ImageView) findViewById(a.f.iv_sweep);
        this.aFP = (TbImageView) findViewById(a.f.iv_tail);
        this.aFk = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aFm = (ImageView) findViewById(a.f.barrage_prime);
        this.aFh.setMovementMethod(g.LG());
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aFk.loop(true);
        this.aFk.setAnimation("im_barrage_item_star.json");
        this.aFe.setOnClickListener(this.aFV);
        this.aFl = ObjectAnimator.ofFloat(this.aFj, "translationX", 0.0f, 0.0f);
        this.aFl.setDuration(800L);
        this.aFl.setInterpolator(new AccelerateInterpolator());
        this.aFl.setRepeatCount(-1);
        this.aFl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aFj.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aFj.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aFl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aFj.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aFj.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aFP.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.aFP.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.aFP.setAutoChangeStyle(false);
    }

    private void CX() {
        CY();
        CZ();
    }

    private void CY() {
        if (this.aFf != null && this.aFo != null) {
            this.aFf.stopLoad();
            this.aFf.startLoad(this.aFo.portrait, 12, false, false);
        }
    }

    private void CZ() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aFo != null) {
                String nameShow = this.aFo.getNameShow();
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
            if (this.aFo != null) {
                String nameShow2 = this.aFo.getNameShow();
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
        this.aFh.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aFe.getBackground();
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
        this.aFe.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        f fVar;
        Drawable background = this.aFh.getBackground();
        if (background instanceof f) {
            fVar = (f) background;
        } else {
            fVar = new f();
            if (i >= 0 && i <= 255) {
                fVar.setAlpha(i);
            }
            fVar.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds16));
        }
        if (iArr2 != null && iArr2.length >= 2 && (iArr2[0] != 0 || iArr2[1] != 0)) {
            fVar.f(iArr, iArr2);
            if (i >= 0 && i <= 255) {
                fVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            fVar.setColors(iArr);
        }
        this.aFh.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aFl != null) {
            this.aFl.cancel();
        }
        if (this.aFk != null) {
            this.aFk.cancelAnimation();
        }
        this.aFi.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aFg.setVisibility(0);
            this.aFl.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aFl.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aFh.getWidth() - LandscapeImBarrageItemView.this.aFh.getPaddingLeft()) - LandscapeImBarrageItemView.this.aFh.getPaddingRight());
                    LandscapeImBarrageItemView.this.aFl.start();
                }
            });
            this.aFk.setVisibility(0);
            this.aFk.playAnimation();
            this.aFh.setTextColor(-531173);
            return;
        }
        this.aFg.setVisibility(8);
        this.aFj.setVisibility(8);
        this.aFk.setVisibility(4);
        this.aFk.cancelAnimation();
        this.aFh.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aFP.startLoad(str, 10, false, false);
            this.aFP.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aFR != null) {
                i = LandscapeImBarrageItemView.this.aFR.aOo;
                i2 = LandscapeImBarrageItemView.this.aFR.aOp;
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
            if (LandscapeImBarrageItemView.this.aFV != null) {
                LandscapeImBarrageItemView.this.aFV.onClick(view);
            }
        }
    }
}
