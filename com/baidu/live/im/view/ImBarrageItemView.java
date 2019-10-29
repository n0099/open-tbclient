package com.baidu.live.im.view;

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
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
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
import com.baidu.live.data.ao;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.im.k;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.b;
import com.baidu.live.view.c;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ImBarrageItemView extends RelativeLayout {
    private HeadImageView Xy;
    private TextView ahP;
    private String ahe;
    private View aiD;
    private View aiE;
    private View aiF;
    private ImageView aiG;
    private ImageView aiH;
    private LottieAnimationView aiI;
    private ObjectAnimator aiJ;
    private a aiK;
    private com.baidu.live.data.a aiL;
    private ao aiM;
    private String mContent;

    /* loaded from: classes6.dex */
    public interface a {
        void d(com.baidu.live.data.a aVar);
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
        this.aiK = aVar;
    }

    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.OR = k.sM().sP();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aiL = aVar;
        this.ahe = str;
        this.mContent = str2;
        tM();
    }

    public void setUIInfo(ao aoVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 16 && aoVar != null) {
            int i = 0;
            if (aoVar.price >= 300) {
                i = 2;
            } else if (aoVar.price >= 200) {
                i = 1;
            }
            h(i, z);
            if (this.aiM == null || !this.aiM.id.equals(aoVar.id)) {
                this.aiM = aoVar;
                setAvatarBg(this.aiM.oC());
                setContentBg(this.aiM.oD());
                setContentStroke(this.aiM.oE());
            }
        }
    }

    public void release() {
        if (this.Xy != null) {
            this.Xy.stopLoad();
        }
        if (this.aiJ != null) {
            this.aiJ.cancel();
        }
        if (this.aiI != null) {
            this.aiI.cancelAnimation();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.aiD = findViewById(a.g.bg_avatar);
        this.Xy = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aiE = findViewById(a.g.mask_avatar);
        this.aiF = findViewById(a.g.bg_content);
        this.ahP = (TextView) findViewById(a.g.tv_content);
        this.aiG = (ImageView) findViewById(a.g.iv_light);
        this.aiH = (ImageView) findViewById(a.g.iv_sweep);
        this.aiI = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.Xy.setIsRound(true);
        this.Xy.setAutoChangeStyle(false);
        this.Xy.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aiI.loop(true);
        this.aiI.setAnimation("im_barrage_item_star.json");
        this.aiD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aiK != null) {
                    ImBarrageItemView.this.aiK.d(ImBarrageItemView.this.aiL);
                }
            }
        });
        this.aiJ = ObjectAnimator.ofFloat(this.aiH, "translationX", 0.0f, 0.0f);
        this.aiJ.setDuration(800L);
        this.aiJ.setInterpolator(new AccelerateInterpolator());
        this.aiJ.setRepeatCount(-1);
        this.aiJ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aiH.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aiH.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aiJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aiH.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aiH.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void tM() {
        tN();
        tO();
    }

    private void tN() {
        if (this.Xy != null && this.aiL != null) {
            this.Xy.stopLoad();
            this.Xy.startLoad(this.aiL.portrait, 12, false, false);
        }
    }

    private void tO() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder tP = tP();
        if (tP != null) {
            spannableStringBuilder.append((CharSequence) tP);
        }
        String nameShow = this.aiL.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 6) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 6) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.ahP.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private SpannableStringBuilder tP() {
        List<AlaLiveMarkData> list = this.aiL.OR;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> F = F(list);
        if (ListUtils.isEmpty(F)) {
            return null;
        }
        int length = "   ".length();
        String str = "";
        for (int i = 0; i < F.size(); i++) {
            str = "   " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < F.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = F.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = i3 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aiL.level_id;
                    c cVar = ALaImInitialize.afy.get(str2);
                    if (cVar == null) {
                        cVar = new b(getContext(), alaLiveMarkData, this.aiL.level_id, false, new c.a() { // from class: com.baidu.live.im.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.ahP.setText(ImBarrageItemView.this.ahP.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.afy.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = ALaImInitialize.afy.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.ahP.setText(ImBarrageItemView.this.ahP.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.afy.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> F(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.ahe)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 4 ? linkedList.subList(0, 4) : linkedList;
        }
        return list;
    }

    @RequiresApi(api = 16)
    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aiD.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(1);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable.setColors(iArr);
        this.aiD.setBackground(gradientDrawable);
    }

    @RequiresApi(api = 16)
    private void setContentBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.ahP.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setShape(0);
        }
        gradientDrawable.setColors(iArr);
        this.ahP.setBackground(gradientDrawable);
    }

    @RequiresApi(api = 16)
    private void setContentStroke(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aiF.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setShape(0);
        }
        gradientDrawable.setColors(iArr);
        this.aiF.setBackground(gradientDrawable);
    }

    private void h(int i, boolean z) {
        if (this.aiJ != null) {
            this.aiJ.cancel();
        }
        if (this.aiI != null) {
            this.aiI.cancelAnimation();
        }
        this.aiG.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aiE.setVisibility(0);
            this.aiJ.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aiJ.setFloatValues(0.0f, (ImBarrageItemView.this.ahP.getWidth() - ImBarrageItemView.this.ahP.getPaddingLeft()) - ImBarrageItemView.this.ahP.getPaddingRight());
                    ImBarrageItemView.this.aiJ.start();
                }
            });
            this.aiI.setVisibility(0);
            this.aiI.playAnimation();
            this.ahP.setTextColor(-531173);
            return;
        }
        this.aiE.setVisibility(8);
        this.aiH.setVisibility(8);
        this.aiI.setVisibility(4);
        this.aiI.cancelAnimation();
        this.ahP.setTextColor(-1);
    }
}
