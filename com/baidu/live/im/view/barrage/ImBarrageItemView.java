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
import com.baidu.live.data.bo;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.im.m;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.b;
import com.baidu.live.view.c;
import com.baidu.live.view.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ImBarrageItemView extends RelativeLayout {
    private HeadImageView aIh;
    private String aVd;
    private TextView aWB;
    private ImageView aXA;
    private com.baidu.live.data.a aXC;
    private a aXO;
    private View aXt;
    private View aXu;
    private ImageView aXv;
    private ImageView aXw;
    private LottieAnimationView aXy;
    private ObjectAnimator aXz;
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
        this.aXO = aVar;
    }

    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.awD = m.Dm().Dq();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aXC = aVar;
        this.aVd = str;
        this.mContent = str2;
        EZ();
    }

    public void setUIInfo(bo boVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && boVar != null) {
            if (boVar.type == 1) {
                if (boVar.price >= 300) {
                    i = 2;
                } else if (boVar.price < 200) {
                    i = 0;
                }
            }
            l(i, z);
            setAvatarBg(boVar.wW());
            e(boVar.wX(), boVar.wY());
            setNobleInfo(boVar);
        }
    }

    private void setNobleInfo(bo boVar) {
        if (boVar != null) {
            if (boVar.type == 17) {
                this.aXA.setVisibility(0);
                if (boVar.aEn == 7) {
                    this.aXA.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aXA.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aXv.setVisibility(8);
                this.aXw.setVisibility(8);
                return;
            }
            this.aXA.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aXC != null && !ListUtils.isEmpty(this.aXC.awD)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aXC.awD) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    public void release() {
        if (this.aIh != null) {
            this.aIh.stopLoad();
        }
        if (this.aXz != null) {
            this.aXz.cancel();
        }
        if (this.aXy != null) {
            this.aXy.cancelAnimation();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.aXt = findViewById(a.g.bg_avatar);
        this.aIh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aXu = findViewById(a.g.mask_avatar);
        this.aWB = (TextView) findViewById(a.g.tv_content);
        this.aXv = (ImageView) findViewById(a.g.iv_light);
        this.aXw = (ImageView) findViewById(a.g.iv_sweep);
        this.aXy = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aXA = (ImageView) findViewById(a.g.barrage_prime);
        this.aIh.setIsRound(true);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aXy.loop(true);
        this.aXy.setAnimation("im_barrage_item_star.json");
        this.aXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aXO != null) {
                    ImBarrageItemView.this.aXO.c(ImBarrageItemView.this.aXC);
                }
            }
        });
        this.aXz = ObjectAnimator.ofFloat(this.aXw, "translationX", 0.0f, 0.0f);
        this.aXz.setDuration(800L);
        this.aXz.setInterpolator(new AccelerateInterpolator());
        this.aXz.setRepeatCount(-1);
        this.aXz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aXw.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aXw.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aXz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aXw.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aXw.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void EZ() {
        Fa();
        Fb();
        Ff();
    }

    private void Fa() {
        if (this.aIh != null && this.aXC != null) {
            this.aIh.stopLoad();
            this.aIh.startLoad(this.aXC.portrait, 12, false, false);
        }
    }

    private void Fb() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Fg = Fg();
        if (Fg != null) {
            spannableStringBuilder.append((CharSequence) Fg);
        }
        String nameShow = this.aXC.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aWB.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void Ff() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aWB.getPaint().measureText(this.aWB.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aWB.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aWB.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Fg() {
        List<AlaLiveMarkData> list = this.aXC.awD;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> M = M(list);
        if (ListUtils.isEmpty(M)) {
            return null;
        }
        int length = "[img] ".length();
        String str = "";
        for (int i = 0; i < M.size(); i++) {
            str = "[img] " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < M.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = M.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = (i3 + length) - 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aXC.level_id;
                    c cVar = ALaImInitialize.aSV.get(str2);
                    if (cVar == null) {
                        cVar = new b(getContext(), alaLiveMarkData, this.aXC.level_id, false, new c.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aWB.setText(ImBarrageItemView.this.aWB.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.aSV.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = ALaImInitialize.aSV.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aWB.setText(ImBarrageItemView.this.aWB.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.aSV.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> M(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aVd)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aXt.getBackground();
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
        this.aXt.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aWB.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            gVar.L((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.aWB.setBackgroundDrawable(gVar);
    }

    private void l(int i, boolean z) {
        if (this.aXz != null) {
            this.aXz.cancel();
        }
        if (this.aXy != null) {
            this.aXy.cancelAnimation();
        }
        this.aXv.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aXu.setVisibility(0);
            this.aXz.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aXz.setFloatValues(0.0f, (ImBarrageItemView.this.aWB.getWidth() - ImBarrageItemView.this.aWB.getPaddingLeft()) - ImBarrageItemView.this.aWB.getPaddingRight());
                    ImBarrageItemView.this.aXz.start();
                }
            });
            this.aXy.setVisibility(0);
            this.aXy.playAnimation();
            this.aWB.setTextColor(-531173);
            return;
        }
        this.aXu.setVisibility(8);
        this.aXw.setVisibility(8);
        this.aXy.setVisibility(4);
        this.aXy.cancelAnimation();
        this.aWB.setTextColor(-1);
    }
}
