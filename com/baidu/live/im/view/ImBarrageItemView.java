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
import com.baidu.live.data.az;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.im.k;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.b;
import com.baidu.live.view.c;
import com.baidu.live.view.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class ImBarrageItemView extends RelativeLayout {
    private HeadImageView afA;
    private String apA;
    private View aqW;
    private View aqX;
    private ImageView aqY;
    private ImageView aqZ;
    private TextView aqn;
    private LottieAnimationView ara;
    private ObjectAnimator arb;
    private a arc;
    private com.baidu.live.data.a ard;
    private az are;
    private String mContent;

    /* loaded from: classes2.dex */
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
        this.arc = aVar;
    }

    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.VF = k.uW().va();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.ard = aVar;
        this.apA = str;
        this.mContent = str2;
        wa();
    }

    public void setUIInfo(az azVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && azVar != null) {
            if (azVar.type == 1) {
                if (azVar.price >= 300) {
                    i = 2;
                } else if (azVar.price < 200) {
                    i = 0;
                }
            }
            h(i, z);
            this.are = azVar;
            setAvatarBg(this.are.qc());
            d(this.are.qd(), this.are.qe());
        }
    }

    public void release() {
        if (this.afA != null) {
            this.afA.stopLoad();
        }
        if (this.arb != null) {
            this.arb.cancel();
        }
        if (this.ara != null) {
            this.ara.cancelAnimation();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.aqW = findViewById(a.g.bg_avatar);
        this.afA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aqX = findViewById(a.g.mask_avatar);
        this.aqn = (TextView) findViewById(a.g.tv_content);
        this.aqY = (ImageView) findViewById(a.g.iv_light);
        this.aqZ = (ImageView) findViewById(a.g.iv_sweep);
        this.ara = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.afA.setIsRound(true);
        this.afA.setAutoChangeStyle(false);
        this.afA.setDefaultBgResource(a.f.sdk_default_avatar);
        this.ara.loop(true);
        this.ara.setAnimation("im_barrage_item_star.json");
        this.aqW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.arc != null) {
                    ImBarrageItemView.this.arc.d(ImBarrageItemView.this.ard);
                }
            }
        });
        this.arb = ObjectAnimator.ofFloat(this.aqZ, "translationX", 0.0f, 0.0f);
        this.arb.setDuration(800L);
        this.arb.setInterpolator(new AccelerateInterpolator());
        this.arb.setRepeatCount(-1);
        this.arb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aqZ.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aqZ.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.arb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aqZ.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aqZ.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void wa() {
        wb();
        wc();
    }

    private void wb() {
        if (this.afA != null && this.ard != null) {
            this.afA.stopLoad();
            this.afA.startLoad(this.ard.portrait, 12, false, false);
        }
    }

    private void wc() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder wd = wd();
        if (wd != null) {
            spannableStringBuilder.append((CharSequence) wd);
        }
        String nameShow = this.ard.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 6) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 6) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aqn.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private SpannableStringBuilder wd() {
        List<AlaLiveMarkData> list = this.ard.VF;
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
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.ard.level_id;
                    c cVar = ALaImInitialize.anV.get(str2);
                    if (cVar == null) {
                        cVar = new b(getContext(), alaLiveMarkData, this.ard.level_id, false, new c.a() { // from class: com.baidu.live.im.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.aqn.setText(ImBarrageItemView.this.aqn.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.anV.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = ALaImInitialize.anV.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.aqn.setText(ImBarrageItemView.this.aqn.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.anV.put(genCacheKey, cVar2);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.apA)) {
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
        Drawable background = this.aqW.getBackground();
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
        this.aqW.setBackgroundDrawable(gradientDrawable);
    }

    private void d(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aqn.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
            gVar.G((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.e(iArr, iArr2);
        this.aqn.setBackgroundDrawable(gVar);
    }

    private void h(int i, boolean z) {
        if (this.arb != null) {
            this.arb.cancel();
        }
        if (this.ara != null) {
            this.ara.cancelAnimation();
        }
        this.aqY.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aqX.setVisibility(0);
            this.arb.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.arb.setFloatValues(0.0f, (ImBarrageItemView.this.aqn.getWidth() - ImBarrageItemView.this.aqn.getPaddingLeft()) - ImBarrageItemView.this.aqn.getPaddingRight());
                    ImBarrageItemView.this.arb.start();
                }
            });
            this.ara.setVisibility(0);
            this.ara.playAnimation();
            this.aqn.setTextColor(-531173);
            return;
        }
        this.aqX.setVisibility(8);
        this.aqZ.setVisibility(8);
        this.ara.setVisibility(4);
        this.ara.cancelAnimation();
        this.aqn.setTextColor(-1);
    }
}
