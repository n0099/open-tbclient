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
    private ObjectAnimator aDA;
    private ImageView aDB;
    private com.baidu.live.data.a aDD;
    private View aDt;
    private HeadImageView aDu;
    private View aDv;
    private TextView aDw;
    private ImageView aDx;
    private ImageView aDy;
    private LottieAnimationView aDz;
    private TbImageView aEe;
    private a aEf;
    private at aEg;
    private cg aEh;
    public long aEi;
    public int aEj;
    private View.OnClickListener aEk;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aEk = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aEf != null) {
                    LandscapeImBarrageItemView.this.aEf.b(LandscapeImBarrageItemView.this.aDD);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEk = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aEf != null) {
                    LandscapeImBarrageItemView.this.aEf.b(LandscapeImBarrageItemView.this.aDD);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aEf = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aDD = aVar;
        this.mContent = str2;
        Co();
        this.msgType = i;
    }

    public void setEffectInfo(at atVar) {
        if (atVar != null) {
            this.aEg = atVar;
            if (atVar.aMx != 0 || atVar.aMy != 0) {
                b(new int[]{atVar.aMx, atVar.aMy}, new int[]{atVar.aMz, atVar.aMz}, atVar.aMB);
            }
            setTail(atVar.aMC);
        }
    }

    public void setUIInfo(cg cgVar, boolean z) {
        int i = 0;
        this.aDt.setVisibility(cgVar == null ? 8 : 0);
        if (cgVar == null) {
            this.aDw.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), this.aDw.getPaddingTop(), getResources().getDimensionPixelOffset(a.d.sdk_ds24), this.aDw.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (cgVar.price >= 300) {
                i = 2;
            } else if (cgVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aEh == null || !this.aEh.id.equals(cgVar.id)) {
                this.aEh = cgVar;
                setAvatarBg(this.aEh.Eq());
                b(this.aEh.Er(), this.aEh.Es(), 205);
                setNobleInfo(cgVar);
            }
        }
    }

    private void setNobleInfo(cg cgVar) {
        if (cgVar != null) {
            if (cgVar.type == 17) {
                this.aDB.setVisibility(0);
                if (cgVar.aPG == 7) {
                    this.aDB.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aDB.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aDx.setVisibility(8);
                this.aDy.setVisibility(8);
                return;
            }
            this.aDB.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aDt = findViewById(a.f.bg_avatar);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aDv = findViewById(a.f.mask_avatar);
        this.aDw = (TextView) findViewById(a.f.tv_content);
        this.aDx = (ImageView) findViewById(a.f.iv_light);
        this.aDy = (ImageView) findViewById(a.f.iv_sweep);
        this.aEe = (TbImageView) findViewById(a.f.iv_tail);
        this.aDz = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aDB = (ImageView) findViewById(a.f.barrage_prime);
        this.aDw.setMovementMethod(g.KX());
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aDz.loop(true);
        this.aDz.setAnimation("im_barrage_item_star.json");
        this.aDt.setOnClickListener(this.aEk);
        this.aDA = ObjectAnimator.ofFloat(this.aDy, "translationX", 0.0f, 0.0f);
        this.aDA.setDuration(800L);
        this.aDA.setInterpolator(new AccelerateInterpolator());
        this.aDA.setRepeatCount(-1);
        this.aDA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aDy.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aDy.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aDA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aDy.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aDy.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aEe.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.aEe.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.aEe.setAutoChangeStyle(false);
    }

    private void Co() {
        Cp();
        Cq();
    }

    private void Cp() {
        if (this.aDu != null && this.aDD != null) {
            this.aDu.stopLoad();
            this.aDu.startLoad(this.aDD.portrait, 12, false, false);
        }
    }

    private void Cq() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aDD != null) {
                String nameShow = this.aDD.getNameShow();
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
            if (this.aDD != null) {
                String nameShow2 = this.aDD.getNameShow();
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
        this.aDw.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aDt.getBackground();
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
        this.aDt.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        f fVar;
        Drawable background = this.aDw.getBackground();
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
        this.aDw.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aDA != null) {
            this.aDA.cancel();
        }
        if (this.aDz != null) {
            this.aDz.cancelAnimation();
        }
        this.aDx.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aDv.setVisibility(0);
            this.aDA.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aDA.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aDw.getWidth() - LandscapeImBarrageItemView.this.aDw.getPaddingLeft()) - LandscapeImBarrageItemView.this.aDw.getPaddingRight());
                    LandscapeImBarrageItemView.this.aDA.start();
                }
            });
            this.aDz.setVisibility(0);
            this.aDz.playAnimation();
            this.aDw.setTextColor(-531173);
            return;
        }
        this.aDv.setVisibility(8);
        this.aDy.setVisibility(8);
        this.aDz.setVisibility(4);
        this.aDz.cancelAnimation();
        this.aDw.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aEe.startLoad(str, 10, false, false);
            this.aEe.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aEg != null) {
                i = LandscapeImBarrageItemView.this.aEg.aMD;
                i2 = LandscapeImBarrageItemView.this.aEg.aME;
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
            if (LandscapeImBarrageItemView.this.aEk != null) {
                LandscapeImBarrageItemView.this.aEk.onClick(view);
            }
        }
    }
}
