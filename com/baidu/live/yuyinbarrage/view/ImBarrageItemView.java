package com.baidu.live.yuyinbarrage.view;

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
import android.support.annotation.NonNull;
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
import com.baidu.live.data.cg;
import com.baidu.live.im.b.b;
import com.baidu.live.im.b.d;
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
import com.baidu.live.view.f;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ImBarrageItemView extends RelativeLayout implements b {
    private ObjectAnimator aDA;
    private ImageView aDB;
    private com.baidu.live.data.a aDD;
    private String aDE;
    private View aDt;
    private HeadImageView aDu;
    private View aDv;
    private TextView aDw;
    private ImageView aDx;
    private ImageView aDy;
    private LottieAnimationView aDz;
    private a bNA;
    private String mContent;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);
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
        this.bNA = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aFV = d.Lx().LC();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aDD = aVar;
        this.aDE = str;
        this.mContent = str2;
        Co();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(cg cgVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && cgVar != null) {
            if (cgVar.type == 1) {
                if (cgVar.price >= 300) {
                    i = 2;
                } else if (cgVar.price < 200) {
                    i = 0;
                }
            }
            m(i, z);
            setAvatarBg(cgVar.Eq());
            e(cgVar.Er(), cgVar.Es());
            setNobleInfo(cgVar);
        }
    }

    private void setNobleInfo(cg cgVar) {
        if (cgVar != null) {
            if (cgVar.type == 17) {
                this.aDB.setVisibility(0);
                if (cgVar.aPG == 7) {
                    this.aDB.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aDB.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aDx.setVisibility(8);
                this.aDy.setVisibility(8);
                return;
            }
            this.aDB.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aDD != null && !ListUtils.isEmpty(this.aDD.aFV)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aDD.aFV) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aDu != null) {
            this.aDu.stopLoad();
        }
        if (this.aDA != null) {
            this.aDA.cancel();
        }
        if (this.aDz != null) {
            this.aDz.cancelAnimation();
        }
    }

    @Override // com.baidu.live.im.b.b
    @NonNull
    public View getView() {
        return this;
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_im_barrage_item, (ViewGroup) this, true);
        this.aDt = findViewById(a.f.bg_avatar);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aDv = findViewById(a.f.mask_avatar);
        this.aDw = (TextView) findViewById(a.f.tv_content);
        this.aDx = (ImageView) findViewById(a.f.iv_light);
        this.aDy = (ImageView) findViewById(a.f.iv_sweep);
        this.aDz = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aDB = (ImageView) findViewById(a.f.barrage_prime);
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aDz.loop(true);
        this.aDz.setAnimation("im_barrage_item_star.json");
        this.aDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.bNA != null) {
                    ImBarrageItemView.this.bNA.b(ImBarrageItemView.this.aDD);
                }
            }
        });
        this.aDA = ObjectAnimator.ofFloat(this.aDy, "translationX", 0.0f, 0.0f);
        this.aDA.setDuration(800L);
        this.aDA.setInterpolator(new AccelerateInterpolator());
        this.aDA.setRepeatCount(-1);
        this.aDA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aDy.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aDy.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aDA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aDy.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aDy.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void Co() {
        Cp();
        Cq();
        Cr();
    }

    private void Cp() {
        if (this.aDu != null && this.aDD != null) {
            this.aDu.stopLoad();
            this.aDu.startLoad(this.aDD.portrait, 12, false, false);
        }
    }

    private void Cq() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Cs = Cs();
        if (Cs != null) {
            spannableStringBuilder.append((CharSequence) Cs);
        }
        String nameShow = this.aDD.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aDw.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void Cr() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aDw.getPaint().measureText(this.aDw.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aDw.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aDw.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Cs() {
        List<AlaLiveMarkData> list = this.aDD.aFV;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> v = v(list);
        if (ListUtils.isEmpty(v)) {
            return null;
        }
        int length = "[img] ".length();
        String str = "";
        for (int i = 0; i < v.size(); i++) {
            str = "[img] " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < v.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = v.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = (i3 + length) - 1;
                String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bJF.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.4
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            ImBarrageItemView.this.aDw.setText(ImBarrageItemView.this.aDw.getText());
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bJF.put(genCacheKey, bVar);
                }
                spannableStringBuilder.setSpan(bVar, i3, i4, 17);
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> v(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aDE)) {
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
        Drawable background = this.aDt.getBackground();
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
        this.aDt.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        f fVar;
        Drawable background = this.aDw.getBackground();
        if (background instanceof f) {
            fVar = (f) background;
        } else {
            fVar = new f();
            fVar.setAlpha(205);
            fVar.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            fVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        fVar.f(iArr, iArr2);
        this.aDw.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aDA != null) {
            this.aDA.cancel();
        }
        if (this.aDz != null) {
            this.aDz.cancelAnimation();
        }
        this.aDx.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aDv.setVisibility(0);
            this.aDA.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.5
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aDA.setFloatValues(0.0f, (ImBarrageItemView.this.aDw.getWidth() - ImBarrageItemView.this.aDw.getPaddingLeft()) - ImBarrageItemView.this.aDw.getPaddingRight());
                    ImBarrageItemView.this.aDA.start();
                }
            });
            this.aDz.setVisibility(0);
            this.aDz.playAnimation();
            this.aDw.setTextColor(-531173);
            return;
        }
        this.aDv.setVisibility(8);
        this.aDy.setVisibility(8);
        this.aDz.setVisibility(4);
        this.aDz.cancelAnimation();
        this.aDw.setTextColor(-1);
    }
}
