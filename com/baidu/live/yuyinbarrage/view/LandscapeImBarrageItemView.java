package com.baidu.live.yuyinbarrage.view;

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
import com.baidu.live.data.aw;
import com.baidu.live.data.ck;
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
    private com.baidu.live.data.a aGA;
    private View aGq;
    private HeadImageView aGr;
    private View aGs;
    private TextView aGt;
    private ImageView aGu;
    private ImageView aGv;
    private LottieAnimationView aGw;
    private ObjectAnimator aGx;
    private ImageView aGy;
    private TbImageView aHb;
    private aw aHd;
    private ck aHe;
    private View.OnClickListener aHh;
    private a bYu;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes11.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aHh = new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.bYu != null) {
                    LandscapeImBarrageItemView.this.bYu.b(LandscapeImBarrageItemView.this.aGA);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHh = new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.bYu != null) {
                    LandscapeImBarrageItemView.this.bYu.b(LandscapeImBarrageItemView.this.aGA);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bYu = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aGA = aVar;
        this.mContent = str2;
        Dn();
        this.msgType = i;
    }

    public void setEffectInfo(aw awVar) {
        if (awVar != null) {
            this.aHd = awVar;
            if (awVar.aQl != 0 || awVar.aQm != 0) {
                b(new int[]{awVar.aQl, awVar.aQm}, new int[]{awVar.aQn, awVar.aQn}, awVar.aQp);
            }
            setTail(awVar.aQq);
        }
    }

    public void setUIInfo(ck ckVar, boolean z) {
        int i = 0;
        this.aGq.setVisibility(ckVar == null ? 8 : 0);
        if (ckVar == null) {
            this.aGt.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), this.aGt.getPaddingTop(), getResources().getDimensionPixelOffset(a.d.sdk_ds24), this.aGt.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (ckVar.price >= 300) {
                i = 2;
            } else if (ckVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aHe == null || !this.aHe.id.equals(ckVar.id)) {
                this.aHe = ckVar;
                setAvatarBg(this.aHe.Fu());
                b(this.aHe.Fv(), this.aHe.Fw(), 205);
                setNobleInfo(ckVar);
            }
        }
    }

    private void setNobleInfo(ck ckVar) {
        if (ckVar != null) {
            if (ckVar.type == 17) {
                this.aGy.setVisibility(0);
                if (ckVar.aTG == 7) {
                    this.aGy.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aGy.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aGu.setVisibility(8);
                this.aGv.setVisibility(8);
                return;
            }
            this.aGy.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aGq = findViewById(a.f.bg_avatar);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aGs = findViewById(a.f.mask_avatar);
        this.aGt = (TextView) findViewById(a.f.tv_content);
        this.aGu = (ImageView) findViewById(a.f.iv_light);
        this.aGv = (ImageView) findViewById(a.f.iv_sweep);
        this.aHb = (TbImageView) findViewById(a.f.iv_tail);
        this.aGw = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aGy = (ImageView) findViewById(a.f.barrage_prime);
        this.aGt.setMovementMethod(g.Mx());
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aGw.loop(true);
        this.aGw.setAnimation("im_barrage_item_star.json");
        this.aGq.setOnClickListener(this.aHh);
        this.aGx = ObjectAnimator.ofFloat(this.aGv, "translationX", 0.0f, 0.0f);
        this.aGx.setDuration(800L);
        this.aGx.setInterpolator(new AccelerateInterpolator());
        this.aGx.setRepeatCount(-1);
        this.aGx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aGv.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aGv.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aGx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aGv.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aGv.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aHb.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.aHb.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.aHb.setAutoChangeStyle(false);
    }

    private void Dn() {
        Do();
        Dp();
    }

    private void Do() {
        if (this.aGr != null && this.aGA != null) {
            this.aGr.stopLoad();
            this.aGr.startLoad(this.aGA.portrait, 12, false, false);
        }
    }

    private void Dp() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aGA != null) {
                String nameShow = this.aGA.getNameShow();
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
            if (this.aGA != null) {
                String nameShow2 = this.aGA.getNameShow();
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
        this.aGt.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aGq.getBackground();
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
        this.aGq.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        f fVar;
        Drawable background = this.aGt.getBackground();
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
        this.aGt.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aGx != null) {
            this.aGx.cancel();
        }
        if (this.aGw != null) {
            this.aGw.cancelAnimation();
        }
        this.aGu.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aGs.setVisibility(0);
            this.aGx.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aGx.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aGt.getWidth() - LandscapeImBarrageItemView.this.aGt.getPaddingLeft()) - LandscapeImBarrageItemView.this.aGt.getPaddingRight());
                    LandscapeImBarrageItemView.this.aGx.start();
                }
            });
            this.aGw.setVisibility(0);
            this.aGw.playAnimation();
            this.aGt.setTextColor(-531173);
            return;
        }
        this.aGs.setVisibility(8);
        this.aGv.setVisibility(8);
        this.aGw.setVisibility(4);
        this.aGw.cancelAnimation();
        this.aGt.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aHb.startLoad(str, 10, false, false);
            this.aHb.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aHd != null) {
                i = LandscapeImBarrageItemView.this.aHd.aQr;
                i2 = LandscapeImBarrageItemView.this.aHd.aQs;
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
            if (LandscapeImBarrageItemView.this.aHh != null) {
                LandscapeImBarrageItemView.this.aHh.onClick(view);
            }
        }
    }
}
