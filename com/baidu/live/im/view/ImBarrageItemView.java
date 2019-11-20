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
    private HeadImageView Xg;
    private String agM;
    private TextView ahx;
    private View ail;
    private View aim;
    private View ain;
    private ImageView aio;
    private ImageView aip;
    private LottieAnimationView aiq;
    private ObjectAnimator air;
    private a ais;
    private com.baidu.live.data.a ait;
    private ao aiu;
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
        this.ais = aVar;
    }

    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.Op = k.sN().sQ();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.ait = aVar;
        this.agM = str;
        this.mContent = str2;
        tN();
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
            if (this.aiu == null || !this.aiu.id.equals(aoVar.id)) {
                this.aiu = aoVar;
                setAvatarBg(this.aiu.oC());
                setContentBg(this.aiu.oD());
                setContentStroke(this.aiu.oE());
            }
        }
    }

    public void release() {
        if (this.Xg != null) {
            this.Xg.stopLoad();
        }
        if (this.air != null) {
            this.air.cancel();
        }
        if (this.aiq != null) {
            this.aiq.cancelAnimation();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.ail = findViewById(a.g.bg_avatar);
        this.Xg = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aim = findViewById(a.g.mask_avatar);
        this.ain = findViewById(a.g.bg_content);
        this.ahx = (TextView) findViewById(a.g.tv_content);
        this.aio = (ImageView) findViewById(a.g.iv_light);
        this.aip = (ImageView) findViewById(a.g.iv_sweep);
        this.aiq = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.Xg.setIsRound(true);
        this.Xg.setAutoChangeStyle(false);
        this.Xg.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aiq.loop(true);
        this.aiq.setAnimation("im_barrage_item_star.json");
        this.ail.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.ais != null) {
                    ImBarrageItemView.this.ais.d(ImBarrageItemView.this.ait);
                }
            }
        });
        this.air = ObjectAnimator.ofFloat(this.aip, "translationX", 0.0f, 0.0f);
        this.air.setDuration(800L);
        this.air.setInterpolator(new AccelerateInterpolator());
        this.air.setRepeatCount(-1);
        this.air.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aip.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aip.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.air.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aip.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aip.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void tN() {
        tO();
        tP();
    }

    private void tO() {
        if (this.Xg != null && this.ait != null) {
            this.Xg.stopLoad();
            this.Xg.startLoad(this.ait.portrait, 12, false, false);
        }
    }

    private void tP() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder tQ = tQ();
        if (tQ != null) {
            spannableStringBuilder.append((CharSequence) tQ);
        }
        String nameShow = this.ait.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 6) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 6) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.ahx.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private SpannableStringBuilder tQ() {
        List<AlaLiveMarkData> list = this.ait.Op;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> G = G(list);
        if (ListUtils.isEmpty(G)) {
            return null;
        }
        int length = "   ".length();
        String str = "";
        for (int i = 0; i < G.size(); i++) {
            str = "   " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < G.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = G.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = i3 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.ait.level_id;
                    c cVar = ALaImInitialize.afg.get(str2);
                    if (cVar == null) {
                        cVar = new b(getContext(), alaLiveMarkData, this.ait.level_id, false, new c.a() { // from class: com.baidu.live.im.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.ahx.setText(ImBarrageItemView.this.ahx.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.afg.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = ALaImInitialize.afg.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.ahx.setText(ImBarrageItemView.this.ahx.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.afg.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> G(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.agM)) {
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
        Drawable background = this.ail.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(1);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable.setColors(iArr);
        this.ail.setBackground(gradientDrawable);
    }

    @RequiresApi(api = 16)
    private void setContentBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.ahx.getBackground();
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
        this.ahx.setBackground(gradientDrawable);
    }

    @RequiresApi(api = 16)
    private void setContentStroke(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.ain.getBackground();
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
        this.ain.setBackground(gradientDrawable);
    }

    private void h(int i, boolean z) {
        if (this.air != null) {
            this.air.cancel();
        }
        if (this.aiq != null) {
            this.aiq.cancelAnimation();
        }
        this.aio.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aim.setVisibility(0);
            this.air.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.air.setFloatValues(0.0f, (ImBarrageItemView.this.ahx.getWidth() - ImBarrageItemView.this.ahx.getPaddingLeft()) - ImBarrageItemView.this.ahx.getPaddingRight());
                    ImBarrageItemView.this.air.start();
                }
            });
            this.aiq.setVisibility(0);
            this.aiq.playAnimation();
            this.ahx.setTextColor(-531173);
            return;
        }
        this.aim.setVisibility(8);
        this.aip.setVisibility(8);
        this.aiq.setVisibility(4);
        this.aiq.cancelAnimation();
        this.ahx.setTextColor(-1);
    }
}
