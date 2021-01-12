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
/* loaded from: classes10.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private View aBD;
    private HeadImageView aBE;
    private View aBF;
    private TextView aBG;
    private ImageView aBH;
    private ImageView aBI;
    private LottieAnimationView aBJ;
    private ObjectAnimator aBK;
    private ImageView aBL;
    private com.baidu.live.data.a aBN;
    private TbImageView aCo;
    private a aCp;
    private aw aCq;
    private ck aCr;
    public long aCs;
    public int aCt;
    private View.OnClickListener aCu;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aCu = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aCp != null) {
                    LandscapeImBarrageItemView.this.aCp.b(LandscapeImBarrageItemView.this.aBN);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCu = new View.OnClickListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aCp != null) {
                    LandscapeImBarrageItemView.this.aCp.b(LandscapeImBarrageItemView.this.aBN);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aCp = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aBN = aVar;
        this.mContent = str2;
        zs();
        this.msgType = i;
    }

    public void setEffectInfo(aw awVar) {
        if (awVar != null) {
            this.aCq = awVar;
            if (awVar.aLy != 0 || awVar.aLz != 0) {
                b(new int[]{awVar.aLy, awVar.aLz}, new int[]{awVar.aLA, awVar.aLA}, awVar.aLC);
            }
            setTail(awVar.aLD);
        }
    }

    public void setUIInfo(ck ckVar, boolean z) {
        int i = 0;
        this.aBD.setVisibility(ckVar == null ? 8 : 0);
        if (ckVar == null) {
            this.aBG.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), this.aBG.getPaddingTop(), getResources().getDimensionPixelOffset(a.d.sdk_ds24), this.aBG.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (ckVar.price >= 300) {
                i = 2;
            } else if (ckVar.price >= 200) {
                i = 1;
            }
            m(i, z);
            if (this.aCr == null || !this.aCr.id.equals(ckVar.id)) {
                this.aCr = ckVar;
                setAvatarBg(this.aCr.Bz());
                b(this.aCr.BA(), this.aCr.BB(), 205);
                setNobleInfo(ckVar);
            }
        }
    }

    private void setNobleInfo(ck ckVar) {
        if (ckVar != null) {
            if (ckVar.type == 17) {
                this.aBL.setVisibility(0);
                if (ckVar.aOT == 7) {
                    this.aBL.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aBL.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aBH.setVisibility(8);
                this.aBI.setVisibility(8);
                return;
            }
            this.aBL.setVisibility(8);
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aBD = findViewById(a.f.bg_avatar);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aBF = findViewById(a.f.mask_avatar);
        this.aBG = (TextView) findViewById(a.f.tv_content);
        this.aBH = (ImageView) findViewById(a.f.iv_light);
        this.aBI = (ImageView) findViewById(a.f.iv_sweep);
        this.aCo = (TbImageView) findViewById(a.f.iv_tail);
        this.aBJ = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aBL = (ImageView) findViewById(a.f.barrage_prime);
        this.aBG.setMovementMethod(g.IC());
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aBJ.loop(true);
        this.aBJ.setAnimation("im_barrage_item_star.json");
        this.aBD.setOnClickListener(this.aCu);
        this.aBK = ObjectAnimator.ofFloat(this.aBI, "translationX", 0.0f, 0.0f);
        this.aBK.setDuration(800L);
        this.aBK.setInterpolator(new AccelerateInterpolator());
        this.aBK.setRepeatCount(-1);
        this.aBK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aBI.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aBI.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aBK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aBI.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aBI.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.aCo.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.aCo.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.aCo.setAutoChangeStyle(false);
    }

    private void zs() {
        zt();
        zu();
    }

    private void zt() {
        if (this.aBE != null && this.aBN != null) {
            this.aBE.stopLoad();
            this.aBE.startLoad(this.aBN.portrait, 12, false, false);
        }
    }

    private void zu() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aBN != null) {
                String nameShow = this.aBN.getNameShow();
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
            if (this.aBN != null) {
                String nameShow2 = this.aBN.getNameShow();
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
        this.aBG.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aBD.getBackground();
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
        this.aBD.setBackgroundDrawable(gradientDrawable);
    }

    private void b(int[] iArr, int[] iArr2, int i) {
        f fVar;
        Drawable background = this.aBG.getBackground();
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
        this.aBG.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aBK != null) {
            this.aBK.cancel();
        }
        if (this.aBJ != null) {
            this.aBJ.cancelAnimation();
        }
        this.aBH.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aBF.setVisibility(0);
            this.aBK.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aBK.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.aBG.getWidth() - LandscapeImBarrageItemView.this.aBG.getPaddingLeft()) - LandscapeImBarrageItemView.this.aBG.getPaddingRight());
                    LandscapeImBarrageItemView.this.aBK.start();
                }
            });
            this.aBJ.setVisibility(0);
            this.aBJ.playAnimation();
            this.aBG.setTextColor(-531173);
            return;
        }
        this.aBF.setVisibility(8);
        this.aBI.setVisibility(8);
        this.aBJ.setVisibility(4);
        this.aBJ.cancelAnimation();
        this.aBG.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aCo.startLoad(str, 10, false, false);
            this.aCo.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i = 0;
            int i2 = -1;
            if (LandscapeImBarrageItemView.this.aCq != null) {
                i = LandscapeImBarrageItemView.this.aCq.aLE;
                i2 = LandscapeImBarrageItemView.this.aCq.aLF;
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
            if (LandscapeImBarrageItemView.this.aCu != null) {
                LandscapeImBarrageItemView.this.aCu.onClick(view);
            }
        }
    }
}
