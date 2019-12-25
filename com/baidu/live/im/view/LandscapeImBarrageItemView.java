package com.baidu.live.im.view;

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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.data.av;
import com.baidu.live.data.w;
import com.baidu.live.im.g;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes2.dex */
public class LandscapeImBarrageItemView extends RelativeLayout {
    private HeadImageView aeR;
    private TbImageView amK;
    private TextView apB;
    private a aqV;
    private w aqW;
    public long aqX;
    public int aqY;
    private View.OnClickListener aqZ;
    private View aqk;
    private View aql;
    private ImageView aqm;
    private ImageView aqn;
    private LottieAnimationView aqo;
    private ObjectAnimator aqp;
    private com.baidu.live.data.a aqr;
    private av aqs;
    private String mContent;
    private int msgType;
    public long timeStamp;

    /* loaded from: classes2.dex */
    public interface a {
        void d(com.baidu.live.data.a aVar);
    }

    public LandscapeImBarrageItemView(Context context) {
        super(context);
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aqV != null) {
                    LandscapeImBarrageItemView.this.aqV.d(LandscapeImBarrageItemView.this.aqr);
                }
            }
        };
        init();
    }

    public LandscapeImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeImBarrageItemView.this.aqV != null) {
                    LandscapeImBarrageItemView.this.aqV.d(LandscapeImBarrageItemView.this.aqr);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aqV = aVar;
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2, int i) {
        this.aqr = aVar;
        this.mContent = str2;
        vJ();
        this.msgType = i;
    }

    public void setEffectInfo(w wVar) {
        if (wVar != null) {
            this.aqW = wVar;
            if (wVar.Zf != 0 || wVar.Zg != 0) {
                a(new int[]{wVar.Zf, wVar.Zg}, new int[]{wVar.Zh, wVar.Zh}, wVar.Zj);
            }
            setTail(wVar.Zk);
        }
    }

    public void setUIInfo(av avVar, boolean z) {
        int i = 0;
        this.aqk.setVisibility(avVar == null ? 8 : 0);
        if (avVar == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            this.apB.setPadding(dimensionPixelOffset, this.apB.getPaddingTop(), dimensionPixelOffset, this.apB.getBottom());
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (avVar.price >= 300) {
                i = 2;
            } else if (avVar.price >= 200) {
                i = 1;
            }
            h(i, z);
            if (this.aqs == null || !this.aqs.id.equals(avVar.id)) {
                this.aqs = avVar;
                setAvatarBg(this.aqs.pW());
                a(this.aqs.pX(), this.aqs.pY(), 205);
            }
        }
    }

    private void init() {
        this.timeStamp = System.currentTimeMillis();
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item_landscape, (ViewGroup) this, true);
        this.aqk = findViewById(a.g.bg_avatar);
        this.aeR = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aql = findViewById(a.g.mask_avatar);
        this.apB = (TextView) findViewById(a.g.tv_content);
        this.aqm = (ImageView) findViewById(a.g.iv_light);
        this.aqn = (ImageView) findViewById(a.g.iv_sweep);
        this.amK = (TbImageView) findViewById(a.g.iv_tail);
        this.aqo = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.apB.setMovementMethod(g.ut());
        this.aeR.setIsRound(true);
        this.aeR.setAutoChangeStyle(false);
        this.aeR.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aqo.loop(true);
        this.aqo.setAnimation("im_barrage_item_star.json");
        this.aqk.setOnClickListener(this.aqZ);
        this.aqp = ObjectAnimator.ofFloat(this.aqn, "translationX", 0.0f, 0.0f);
        this.aqp.setDuration(800L);
        this.aqp.setInterpolator(new AccelerateInterpolator());
        this.aqp.setRepeatCount(-1);
        this.aqp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LandscapeImBarrageItemView.this.aqn.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LandscapeImBarrageItemView.this.aqn.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aqp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    LandscapeImBarrageItemView.this.aqn.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    LandscapeImBarrageItemView.this.aqn.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
        this.amK.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.amK.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.amK.setAutoChangeStyle(false);
    }

    private void vJ() {
        vK();
        vL();
    }

    private void vK() {
        if (this.aeR != null && this.aqr != null) {
            this.aeR.stopLoad();
            this.aeR.startLoad(this.aqr.portrait, 12, false, false);
        }
    }

    private void vL() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.msgType == 1 || this.msgType == 2 || this.msgType == 3) {
            if (this.aqr != null) {
                String nameShow = this.aqr.getNameShow();
                if (nameShow != null) {
                    if (TextHelper.getTextLengthWithEmoji(nameShow) > 14) {
                        nameShow = TextHelper.subStringWithEmoji(nameShow, 14) + StringHelper.STRING_MORE;
                    }
                    if (this.msgType != 3) {
                        nameShow = nameShow + HanziToPinyin.Token.SEPARATOR;
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
            if (this.aqr != null) {
                String nameShow2 = this.aqr.getNameShow();
                if (nameShow2 != null) {
                    if (TextHelper.getTextLengthWithEmoji(nameShow2) > 14) {
                        nameShow2 = TextHelper.subStringWithEmoji(nameShow2, 14) + StringHelper.STRING_MORE;
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
        this.apB.setText(spannableStringBuilder);
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aqk.getBackground();
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
        this.aqk.setBackgroundDrawable(gradientDrawable);
    }

    private void a(int[] iArr, int[] iArr2, int i) {
        com.baidu.live.view.g gVar;
        Drawable background = this.apB.getBackground();
        if (background instanceof com.baidu.live.view.g) {
            gVar = (com.baidu.live.view.g) background;
        } else {
            gVar = new com.baidu.live.view.g();
            if (i >= 0 && i <= 255) {
                gVar.setAlpha(i);
            }
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
        }
        if (iArr2 != null && iArr2.length >= 2 && (iArr2[0] != 0 || iArr2[1] != 0)) {
            gVar.e(iArr, iArr2);
            if (i >= 0 && i <= 255) {
                gVar.C((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), i);
            } else {
                gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, getContext().getResources().getDisplayMetrics()));
            }
        } else {
            gVar.setColors(iArr);
        }
        this.apB.setBackgroundDrawable(gVar);
    }

    private void h(int i, boolean z) {
        if (this.aqp != null) {
            this.aqp.cancel();
        }
        if (this.aqo != null) {
            this.aqo.cancelAnimation();
        }
        this.aqm.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aql.setVisibility(0);
            this.aqp.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.LandscapeImBarrageItemView.3
                @Override // java.lang.Runnable
                public void run() {
                    LandscapeImBarrageItemView.this.aqp.setFloatValues(0.0f, (LandscapeImBarrageItemView.this.apB.getWidth() - LandscapeImBarrageItemView.this.apB.getPaddingLeft()) - LandscapeImBarrageItemView.this.apB.getPaddingRight());
                    LandscapeImBarrageItemView.this.aqp.start();
                }
            });
            this.aqo.setVisibility(0);
            this.aqo.playAnimation();
            this.apB.setTextColor(-531173);
            return;
        }
        this.aql.setVisibility(8);
        this.aqn.setVisibility(8);
        this.aqo.setVisibility(4);
        this.aqo.cancelAnimation();
        this.apB.setTextColor(-1);
    }

    public void setTail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.amK.startLoad(str, 10, false, false);
            this.amK.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i = 0;
            int i2 = -1;
            if (LandscapeImBarrageItemView.this.aqW != null) {
                i = LandscapeImBarrageItemView.this.aqW.Zl;
                i2 = LandscapeImBarrageItemView.this.aqW.Zm;
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
            if (LandscapeImBarrageItemView.this.aqZ != null) {
                LandscapeImBarrageItemView.this.aqZ.onClick(view);
            }
        }
    }
}
