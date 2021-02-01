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
import androidx.annotation.NonNull;
import com.baidu.live.data.ba;
import com.baidu.live.data.cr;
import com.baidu.live.im.g;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.view.f;
/* loaded from: classes11.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private com.baidu.live.data.a aDA;
    private View aDq;
    private HeadImageView aDr;
    private View aDs;
    private TextView aDt;
    private ImageView aDu;
    private ImageView aDv;
    private LottieAnimationView aDw;
    private ObjectAnimator aDx;
    private ImageView aDy;
    private TbImageView aEb;
    private a aEc;
    private ba aEd;
    private cr aEe;
    public long aEf;
    public int aEg;
    private View.OnClickListener aEh;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes11.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aEh = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aEc != null) {
                    LandscapeImBarrageItemView.this.aEc.b(LandscapeImBarrageItemView.this.aDA);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEh = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aEc != null) {
                    LandscapeImBarrageItemView.this.aEc.b(LandscapeImBarrageItemView.this.aDA);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aEc = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aDA = aVar;
        this.mContent = str2;
        Ac();
        this.msgType = i;
    }

    public void setEffectInfo(ba baVar) {
        if (baVar != null) {
            this.aEd = baVar;
            if (baVar.aOv != 0 || baVar.aOw != 0) {
                b(new int[]{baVar.aOv, baVar.aOw}, new int[]{baVar.aOx, baVar.aOx}, baVar.aOz);
            }
            setTail(baVar.aOA);
        }
    }

    public void setUIInfo(cr crVar, boolean z) {
        int i = 0;
        this.aDq.setVisibility(crVar == null ? 8 : 0);
        if (crVar == null) {
            this.aDt.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), this.aDt.getPaddingTop(), getResources().getDimensionPixelOffset(a.d.sdk_ds24), this.aDt.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (crVar.price >= 300) {
                i = 2;
            } else if (crVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aEe == null || !this.aEe.id.equals(crVar.id)) {
                this.aEe = crVar;
                setAvatarBg(this.aEe.CO());
                b(this.aEe.CP(), this.aEe.CQ(), 205);
                setNobleInfo(crVar);
            }
        }
    }

    private void setNobleInfo(cr crVar) {
        if (crVar != null) {
            if (crVar.type == 17) {
                this.aDy.setVisibility(0);
                if (crVar.aRV == 7) {
                    this.aDy.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aDy.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aDu.setVisibility(8);
                this.aDv.setVisibility(8);
                return;
            }
            this.aDy.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aDq = findViewById(a.f.bg_avatar);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aDs = findViewById(a.f.mask_avatar);
        this.aDt = (TextView) findViewById(a.f.tv_content);
        this.aDu = (ImageView) findViewById(a.f.iv_light);
        this.aDv = (ImageView) findViewById(a.f.iv_sweep);
        this.aEb = (TbImageView) findViewById(a.f.iv_tail);
        this.aDw = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aDy = (ImageView) findViewById(a.f.barrage_prime);
        this.aDt.setMovementMethod(g.Ka());
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aDw.loop(true);
        this.aDw.setAnimation("im_barrage_item_star.json");
        this.aDq.setOnClickListener(this.aEh);
        this.aDx = ObjectAnimator.ofFloat(this.aDv, "translationX", 0.0f, 0.0f);
        this.aDx.setDuration(800L);
        this.aDx.setInterpolator(new AccelerateInterpolator());
        this.aDx.setRepeatCount(-1);
        this.aDx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aDv.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aDv.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aDx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aDv.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aDv.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aEb.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.aEb.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.aEb.setAutoChangeStyle(false);
    }

    private void Ac() {
        Ad();
        Ae();
    }

    private void Ad() {
        if (this.aDr != null && this.aDA != null) {
            this.aDr.stopLoad();
            this.aDr.startLoad(this.aDA.portrait, 12, false, false);
        }
    }

    private void Ae() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aDA != null) {
                String nameShow = this.aDA.getNameShow();
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
            if (this.aDA != null) {
                String nameShow2 = this.aDA.getNameShow();
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
        this.aDt.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aDq.getBackground();
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
        this.aDq.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        f fVar;
        Drawable background = this.aDt.getBackground();
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
                fVar.O((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            fVar.setColors(iArr);
        }
        this.aDt.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aDx != null) {
            this.aDx.cancel();
        }
        if (this.aDw != null) {
            this.aDw.cancelAnimation();
        }
        this.aDu.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aDs.setVisibility(0);
            this.aDx.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aDx.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aDt.getWidth() - LandscapeImBarrageItemView.this.aDt.getPaddingLeft()) - LandscapeImBarrageItemView.this.aDt.getPaddingRight());
                    LandscapeImBarrageItemView.this.aDx.start();
                }
            });
            this.aDw.setVisibility(0);
            this.aDw.playAnimation();
            this.aDt.setTextColor(-531173);
            return;
        }
        this.aDs.setVisibility(8);
        this.aDv.setVisibility(8);
        this.aDw.setVisibility(4);
        this.aDw.cancelAnimation();
        this.aDt.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aEb.startLoad(str, 10, false, false);
            this.aEb.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i = 0;
            int i2 = -1;
            if (LandscapeImBarrageItemView.this.aEd != null) {
                i = LandscapeImBarrageItemView.this.aEd.aOB;
                i2 = LandscapeImBarrageItemView.this.aEd.aOC;
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
            if (LandscapeImBarrageItemView.this.aEh != null) {
                LandscapeImBarrageItemView.this.aEh.onClick(view);
            }
        }
    }
}
