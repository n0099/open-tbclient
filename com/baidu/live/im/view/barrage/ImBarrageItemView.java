package com.baidu.live.im.view.barrage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bb;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.im.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.b;
import com.baidu.live.view.c;
import com.baidu.live.view.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ImBarrageItemView extends RelativeLayout {
    private HeadImageView ahI;
    private String asS;
    private TextView atX;
    private View auL;
    private View auM;
    private ImageView auN;
    private ImageView auO;
    private LottieAnimationView auP;
    private ObjectAnimator auQ;
    private com.baidu.live.data.a auS;
    private a avf;
    private String mContent;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.live.data.a aVar);
    }

    public ImBarrageItemView(Context context) {
        super(context);
        init();
    }

    public ImBarrageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.avf = aVar;
    }

    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.Xl = k.wA().wE();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.auS = aVar;
        this.asS = str;
        this.mContent = str2;
        yb();
    }

    public void setUIInfo(bb bbVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && bbVar != null) {
            if (bbVar.type == 1) {
                if (bbVar.price >= 300) {
                    i = 2;
                } else if (bbVar.price < 200) {
                    i = 0;
                }
            }
            h(i, z);
            setAvatarBg(bbVar.qN());
            e(bbVar.qO(), bbVar.qP());
        }
    }

    public void release() {
        if (this.ahI != null) {
            this.ahI.stopLoad();
        }
        if (this.auQ != null) {
            this.auQ.cancel();
        }
        if (this.auP != null) {
            this.auP.cancelAnimation();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.auL = findViewById(a.g.bg_avatar);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.auM = findViewById(a.g.mask_avatar);
        this.atX = (TextView) findViewById(a.g.tv_content);
        this.auN = (ImageView) findViewById(a.g.iv_light);
        this.auO = (ImageView) findViewById(a.g.iv_sweep);
        this.auP = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setDefaultBgResource(a.f.sdk_default_avatar);
        this.auP.loop(true);
        this.auP.setAnimation("im_barrage_item_star.json");
        this.auL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.avf != null) {
                    ImBarrageItemView.this.avf.c(ImBarrageItemView.this.auS);
                }
            }
        });
        this.auQ = ObjectAnimator.ofFloat(this.auO, "translationX", 0.0f, 0.0f);
        this.auQ.setDuration(800L);
        this.auQ.setInterpolator(new AccelerateInterpolator());
        this.auQ.setRepeatCount(-1);
        this.auQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.auO.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.auO.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.auQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.auO.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.auO.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void yb() {
        yc();
        yd();
    }

    private void yc() {
        if (this.ahI != null && this.auS != null) {
            this.ahI.stopLoad();
            this.ahI.startLoad(this.auS.portrait, 12, false, false);
        }
    }

    private void yd() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder yh = yh();
        if (yh != null) {
            spannableStringBuilder.append((CharSequence) yh);
        }
        String nameShow = this.auS.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 6) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 6) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.atX.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private SpannableStringBuilder yh() {
        List<AlaLiveMarkData> list = this.auS.Xl;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> D = D(list);
        if (ListUtils.isEmpty(D)) {
            return null;
        }
        int length = "  ".length();
        String str = "";
        for (int i = 0; i < D.size(); i++) {
            str = "  " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < D.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = D.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = i3 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.auS.level_id;
                    c cVar = ALaImInitialize.arn.get(str2);
                    if (cVar == null) {
                        cVar = new b(getContext(), alaLiveMarkData, this.auS.level_id, false, new c.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.atX.setText(ImBarrageItemView.this.atX.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.arn.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = ALaImInitialize.arn.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.atX.setText(ImBarrageItemView.this.atX.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.arn.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> D(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.asS)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 5 ? linkedList.subList(0, 5) : linkedList;
        }
        return list;
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.auL.getBackground();
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
        this.auL.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.atX.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
            gVar.H((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.atX.setBackgroundDrawable(gVar);
    }

    private void h(int i, boolean z) {
        if (this.auQ != null) {
            this.auQ.cancel();
        }
        if (this.auP != null) {
            this.auP.cancelAnimation();
        }
        this.auN.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.auM.setVisibility(0);
            this.auQ.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.auQ.setFloatValues(0.0f, (ImBarrageItemView.this.atX.getWidth() - ImBarrageItemView.this.atX.getPaddingLeft()) - ImBarrageItemView.this.atX.getPaddingRight());
                    ImBarrageItemView.this.auQ.start();
                }
            });
            this.auP.setVisibility(0);
            this.auP.playAnimation();
            this.atX.setTextColor(-531173);
            return;
        }
        this.auM.setVisibility(8);
        this.auO.setVisibility(8);
        this.auP.setVisibility(4);
        this.auP.cancelAnimation();
        this.atX.setTextColor(-1);
    }
}
