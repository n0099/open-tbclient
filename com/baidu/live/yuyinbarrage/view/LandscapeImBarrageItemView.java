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
import com.baidu.live.data.au;
import com.baidu.live.data.ci;
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
    private View aFZ;
    private TbImageView aGK;
    private au aGM;
    private ci aGN;
    private View.OnClickListener aGQ;
    private HeadImageView aGa;
    private View aGb;
    private TextView aGc;
    private ImageView aGd;
    private ImageView aGe;
    private LottieAnimationView aGf;
    private ObjectAnimator aGg;
    private ImageView aGh;
    private com.baidu.live.data.a aGj;
    private a bSN;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.bSN != null) {
                    LandscapeImBarrageItemView.this.bSN.b(LandscapeImBarrageItemView.this.aGj);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.bSN != null) {
                    LandscapeImBarrageItemView.this.bSN.b(LandscapeImBarrageItemView.this.aGj);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bSN = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aGj = aVar;
        this.mContent = str2;
        DY();
        this.msgType = i;
    }

    public void setEffectInfo(au auVar) {
        if (auVar != null) {
            this.aGM = auVar;
            if (auVar.aPw != 0 || auVar.aPx != 0) {
                b(new int[]{auVar.aPw, auVar.aPx}, new int[]{auVar.aPy, auVar.aPy}, auVar.aPA);
            }
            setTail(auVar.aPB);
        }
    }

    public void setUIInfo(ci ciVar, boolean z) {
        int i = 0;
        this.aFZ.setVisibility(ciVar == null ? 8 : 0);
        if (ciVar == null) {
            this.aGc.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), this.aGc.getPaddingTop(), getResources().getDimensionPixelOffset(a.d.sdk_ds24), this.aGc.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (ciVar.price >= 300) {
                i = 2;
            } else if (ciVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aGN == null || !this.aGN.id.equals(ciVar.id)) {
                this.aGN = ciVar;
                setAvatarBg(this.aGN.Gb());
                b(this.aGN.Gc(), this.aGN.Gd(), 205);
                setNobleInfo(ciVar);
            }
        }
    }

    private void setNobleInfo(ci ciVar) {
        if (ciVar != null) {
            if (ciVar.type == 17) {
                this.aGh.setVisibility(0);
                if (ciVar.aSI == 7) {
                    this.aGh.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aGh.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aGd.setVisibility(8);
                this.aGe.setVisibility(8);
                return;
            }
            this.aGh.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aFZ = findViewById(a.f.bg_avatar);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aGb = findViewById(a.f.mask_avatar);
        this.aGc = (TextView) findViewById(a.f.tv_content);
        this.aGd = (ImageView) findViewById(a.f.iv_light);
        this.aGe = (ImageView) findViewById(a.f.iv_sweep);
        this.aGK = (TbImageView) findViewById(a.f.iv_tail);
        this.aGf = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aGh = (ImageView) findViewById(a.f.barrage_prime);
        this.aGc.setMovementMethod(g.Na());
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aGf.loop(true);
        this.aGf.setAnimation("im_barrage_item_star.json");
        this.aFZ.setOnClickListener(this.aGQ);
        this.aGg = ObjectAnimator.ofFloat(this.aGe, "translationX", 0.0f, 0.0f);
        this.aGg.setDuration(800L);
        this.aGg.setInterpolator(new AccelerateInterpolator());
        this.aGg.setRepeatCount(-1);
        this.aGg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aGe.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aGe.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aGg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aGe.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aGe.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aGK.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.aGK.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.aGK.setAutoChangeStyle(false);
    }

    private void DY() {
        DZ();
        Ea();
    }

    private void DZ() {
        if (this.aGa != null && this.aGj != null) {
            this.aGa.stopLoad();
            this.aGa.startLoad(this.aGj.portrait, 12, false, false);
        }
    }

    private void Ea() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aGj != null) {
                String nameShow = this.aGj.getNameShow();
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
            if (this.aGj != null) {
                String nameShow2 = this.aGj.getNameShow();
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
        this.aGc.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aFZ.getBackground();
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
        this.aFZ.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        f fVar;
        Drawable background = this.aGc.getBackground();
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
        this.aGc.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aGg != null) {
            this.aGg.cancel();
        }
        if (this.aGf != null) {
            this.aGf.cancelAnimation();
        }
        this.aGd.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aGb.setVisibility(0);
            this.aGg.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aGg.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aGc.getWidth() - LandscapeImBarrageItemView.this.aGc.getPaddingLeft()) - LandscapeImBarrageItemView.this.aGc.getPaddingRight());
                    LandscapeImBarrageItemView.this.aGg.start();
                }
            });
            this.aGf.setVisibility(0);
            this.aGf.playAnimation();
            this.aGc.setTextColor(-531173);
            return;
        }
        this.aGb.setVisibility(8);
        this.aGe.setVisibility(8);
        this.aGf.setVisibility(4);
        this.aGf.cancelAnimation();
        this.aGc.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aGK.startLoad(str, 10, false, false);
            this.aGK.setVisibility(0);
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
            if (LandscapeImBarrageItemView.this.aGM != null) {
                i = LandscapeImBarrageItemView.this.aGM.aPC;
                i2 = LandscapeImBarrageItemView.this.aGM.aPD;
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
            if (LandscapeImBarrageItemView.this.aGQ != null) {
                LandscapeImBarrageItemView.this.aGQ.onClick(view);
            }
        }
    }
}
