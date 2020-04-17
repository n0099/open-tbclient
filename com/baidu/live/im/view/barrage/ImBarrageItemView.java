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
import com.baidu.live.data.be;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.im.m;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
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
    private HeadImageView aAm;
    private String aMr;
    private TextView aNH;
    private ImageView aOA;
    private ImageView aOB;
    private LottieAnimationView aOD;
    private ObjectAnimator aOE;
    private com.baidu.live.data.a aOG;
    private a aOS;
    private View aOy;
    private View aOz;
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
        this.aOS = aVar;
    }

    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.apy = m.Bp().Bt();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aOG = aVar;
        this.aMr = str;
        this.mContent = str2;
        CY();
    }

    public void setUIInfo(be beVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && beVar != null) {
            if (beVar.type == 1) {
                if (beVar.price >= 300) {
                    i = 2;
                } else if (beVar.price < 200) {
                    i = 0;
                }
            }
            k(i, z);
            setAvatarBg(beVar.vj());
            e(beVar.vk(), beVar.vl());
        }
    }

    public void release() {
        if (this.aAm != null) {
            this.aAm.stopLoad();
        }
        if (this.aOE != null) {
            this.aOE.cancel();
        }
        if (this.aOD != null) {
            this.aOD.cancelAnimation();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.aOy = findViewById(a.g.bg_avatar);
        this.aAm = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aOz = findViewById(a.g.mask_avatar);
        this.aNH = (TextView) findViewById(a.g.tv_content);
        this.aOA = (ImageView) findViewById(a.g.iv_light);
        this.aOB = (ImageView) findViewById(a.g.iv_sweep);
        this.aOD = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aAm.setIsRound(true);
        this.aAm.setAutoChangeStyle(false);
        this.aAm.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aOD.loop(true);
        this.aOD.setAnimation("im_barrage_item_star.json");
        this.aOy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aOS != null) {
                    ImBarrageItemView.this.aOS.c(ImBarrageItemView.this.aOG);
                }
            }
        });
        this.aOE = ObjectAnimator.ofFloat(this.aOB, "translationX", 0.0f, 0.0f);
        this.aOE.setDuration(800L);
        this.aOE.setInterpolator(new AccelerateInterpolator());
        this.aOE.setRepeatCount(-1);
        this.aOE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aOB.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aOB.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aOE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aOB.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aOB.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void CY() {
        CZ();
        Da();
        De();
    }

    private void CZ() {
        if (this.aAm != null && this.aOG != null) {
            this.aAm.stopLoad();
            this.aAm.startLoad(this.aOG.portrait, 12, false, false);
        }
    }

    private void Da() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Df = Df();
        if (Df != null) {
            spannableStringBuilder.append((CharSequence) Df);
        }
        String nameShow = this.aOG.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aNH.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void De() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aNH.getPaint().measureText(this.aNH.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aNH.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aNH.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Df() {
        List<AlaLiveMarkData> list = this.aOG.apy;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> I = I(list);
        if (ListUtils.isEmpty(I)) {
            return null;
        }
        int length = "  ".length();
        String str = "";
        for (int i = 0; i < I.size(); i++) {
            str = "  " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < I.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = I.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = i3 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aOG.level_id;
                    c cVar = ALaImInitialize.aKv.get(str2);
                    if (cVar == null) {
                        cVar = new b(getContext(), alaLiveMarkData, this.aOG.level_id, false, new c.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aNH.setText(ImBarrageItemView.this.aNH.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.aKv.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = ALaImInitialize.aKv.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aNH.setText(ImBarrageItemView.this.aNH.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.aKv.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> I(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aMr)) {
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
        Drawable background = this.aOy.getBackground();
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
        this.aOy.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aNH.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
            gVar.G((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.aNH.setBackgroundDrawable(gVar);
    }

    private void k(int i, boolean z) {
        if (this.aOE != null) {
            this.aOE.cancel();
        }
        if (this.aOD != null) {
            this.aOD.cancelAnimation();
        }
        this.aOA.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aOz.setVisibility(0);
            this.aOE.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aOE.setFloatValues(0.0f, (ImBarrageItemView.this.aNH.getWidth() - ImBarrageItemView.this.aNH.getPaddingLeft()) - ImBarrageItemView.this.aNH.getPaddingRight());
                    ImBarrageItemView.this.aOE.start();
                }
            });
            this.aOD.setVisibility(0);
            this.aOD.playAnimation();
            this.aNH.setTextColor(-531173);
            return;
        }
        this.aOz.setVisibility(8);
        this.aOB.setVisibility(8);
        this.aOD.setVisibility(4);
        this.aOD.cancelAnimation();
        this.aNH.setTextColor(-1);
    }
}
