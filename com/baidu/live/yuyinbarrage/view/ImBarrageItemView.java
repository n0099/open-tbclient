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
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.cr;
import com.baidu.live.im.b.b;
import com.baidu.live.im.b.d;
import com.baidu.live.lottie.LottieAnimationView;
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
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class ImBarrageItemView extends RelativeLayout implements b {
    private View aEQ;
    private HeadImageView aER;
    private View aES;
    private TextView aET;
    private ImageView aEU;
    private ImageView aEV;
    private LottieAnimationView aEW;
    private ObjectAnimator aEX;
    private ImageView aEY;
    private com.baidu.live.data.a aFa;
    private String aFb;
    private a bZa;
    private String mContent;

    /* loaded from: classes10.dex */
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
        this.bZa = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aHz = d.KQ().KV();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aFa = aVar;
        this.aFb = str;
        this.mContent = str2;
        Af();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(cr crVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && crVar != null) {
            if (crVar.type == 1) {
                if (crVar.price >= 300) {
                    i = 2;
                } else if (crVar.price < 200) {
                    i = 0;
                }
            }
            m(i, z);
            setAvatarBg(crVar.CR());
            e(crVar.CS(), crVar.CT());
            setNobleInfo(crVar);
        }
    }

    private void setNobleInfo(cr crVar) {
        if (crVar != null) {
            if (crVar.type == 17) {
                this.aEY.setVisibility(0);
                if (crVar.aTv == 7) {
                    this.aEY.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aEY.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aEU.setVisibility(8);
                this.aEV.setVisibility(8);
                return;
            }
            this.aEY.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aFa != null && !ListUtils.isEmpty(this.aFa.aHz)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aFa.aHz) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aER != null) {
            this.aER.stopLoad();
        }
        if (this.aEX != null) {
            this.aEX.cancel();
        }
        if (this.aEW != null) {
            this.aEW.cancelAnimation();
        }
    }

    @Override // com.baidu.live.im.b.b
    @NonNull
    public View getView() {
        return this;
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_im_barrage_item, (ViewGroup) this, true);
        this.aEQ = findViewById(a.f.bg_avatar);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aES = findViewById(a.f.mask_avatar);
        this.aET = (TextView) findViewById(a.f.tv_content);
        this.aEU = (ImageView) findViewById(a.f.iv_light);
        this.aEV = (ImageView) findViewById(a.f.iv_sweep);
        this.aEW = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aEY = (ImageView) findViewById(a.f.barrage_prime);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aEW.loop(true);
        this.aEW.setAnimation("im_barrage_item_star.json");
        this.aEQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.bZa != null) {
                    ImBarrageItemView.this.bZa.b(ImBarrageItemView.this.aFa);
                }
            }
        });
        this.aEX = ObjectAnimator.ofFloat(this.aEV, "translationX", 0.0f, 0.0f);
        this.aEX.setDuration(800L);
        this.aEX.setInterpolator(new AccelerateInterpolator());
        this.aEX.setRepeatCount(-1);
        this.aEX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aEV.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aEV.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aEX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aEV.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aEV.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void Af() {
        Ag();
        Ah();
        Ai();
    }

    private void Ag() {
        if (this.aER != null && this.aFa != null) {
            this.aER.stopLoad();
            this.aER.startLoad(this.aFa.portrait, 12, false, false);
        }
    }

    private void Ah() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Aj = Aj();
        if (Aj != null) {
            spannableStringBuilder.append((CharSequence) Aj);
        }
        String nameShow = this.aFa.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aET.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void Ai() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aET.getPaint().measureText(this.aET.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aET.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aET.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Aj() {
        List<AlaLiveMarkData> list = this.aFa.aHz;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> w = w(list);
        if (ListUtils.isEmpty(w)) {
            return null;
        }
        int length = "[img] ".length();
        String str = "";
        for (int i = 0; i < w.size(); i++) {
            str = "[img] " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < w.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = w.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = (i3 + length) - 1;
                String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bUv.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.4
                        @Override // com.baidu.live.view.b.a
                        public void e(Bitmap bitmap) {
                            ImBarrageItemView.this.aET.setText(ImBarrageItemView.this.aET.getText());
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bUv.put(genCacheKey, bVar);
                }
                spannableStringBuilder.setSpan(bVar, i3, i4, 17);
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> w(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aFb)) {
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
        Drawable background = this.aEQ.getBackground();
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
        this.aEQ.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        f fVar;
        Drawable background = this.aET.getBackground();
        if (background instanceof f) {
            fVar = (f) background;
        } else {
            fVar = new f();
            fVar.setAlpha(205);
            fVar.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            fVar.O((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        fVar.f(iArr, iArr2);
        this.aET.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aEX != null) {
            this.aEX.cancel();
        }
        if (this.aEW != null) {
            this.aEW.cancelAnimation();
        }
        this.aEU.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aES.setVisibility(0);
            this.aEX.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.5
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aEX.setFloatValues(0.0f, (ImBarrageItemView.this.aET.getWidth() - ImBarrageItemView.this.aET.getPaddingLeft()) - ImBarrageItemView.this.aET.getPaddingRight());
                    ImBarrageItemView.this.aEX.start();
                }
            });
            this.aEW.setVisibility(0);
            this.aEW.playAnimation();
            this.aET.setTextColor(-531173);
            return;
        }
        this.aES.setVisibility(8);
        this.aEV.setVisibility(8);
        this.aEW.setVisibility(4);
        this.aEW.cancelAnimation();
        this.aET.setTextColor(-1);
    }
}
