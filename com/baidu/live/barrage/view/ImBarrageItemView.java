package com.baidu.live.barrage.view;

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
import com.baidu.live.data.ck;
import com.baidu.live.guardclub.g;
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
    private View aBD;
    private HeadImageView aBE;
    private View aBF;
    private TextView aBG;
    private ImageView aBH;
    private ImageView aBI;
    private LottieAnimationView aBJ;
    private ObjectAnimator aBK;
    private ImageView aBL;
    private a aBM;
    private com.baidu.live.data.a aBN;
    private String aBO;
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
        this.aBM = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aEm = d.Jp().Ju();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aBN = aVar;
        this.aBO = str;
        this.mContent = str2;
        zs();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(ck ckVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && ckVar != null) {
            if (ckVar.type == 1) {
                if (ckVar.price >= 300) {
                    i = 2;
                } else if (ckVar.price < 200) {
                    i = 0;
                }
            }
            m(i, z);
            setAvatarBg(ckVar.Bz());
            e(ckVar.BA(), ckVar.BB());
            setNobleInfo(ckVar);
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

    private int getNobleLevel() {
        if (this.aBN != null && !ListUtils.isEmpty(this.aBN.aEm)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aBN.aEm) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aBE != null) {
            this.aBE.stopLoad();
        }
        if (this.aBK != null) {
            this.aBK.cancel();
        }
        if (this.aBJ != null) {
            this.aBJ.cancelAnimation();
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
        this.aBD = findViewById(a.f.bg_avatar);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aBF = findViewById(a.f.mask_avatar);
        this.aBG = (TextView) findViewById(a.f.tv_content);
        this.aBH = (ImageView) findViewById(a.f.iv_light);
        this.aBI = (ImageView) findViewById(a.f.iv_sweep);
        this.aBJ = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aBL = (ImageView) findViewById(a.f.barrage_prime);
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aBJ.loop(true);
        this.aBJ.setAnimation("im_barrage_item_star.json");
        this.aBD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aBM != null) {
                    ImBarrageItemView.this.aBM.b(ImBarrageItemView.this.aBN);
                }
            }
        });
        this.aBK = ObjectAnimator.ofFloat(this.aBI, "translationX", 0.0f, 0.0f);
        this.aBK.setDuration(800L);
        this.aBK.setInterpolator(new AccelerateInterpolator());
        this.aBK.setRepeatCount(-1);
        this.aBK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aBI.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aBI.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aBK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aBI.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aBI.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void zs() {
        zt();
        zu();
        zv();
    }

    private void zt() {
        if (this.aBE != null && this.aBN != null) {
            this.aBE.stopLoad();
            this.aBE.startLoad(this.aBN.portrait, 12, false, false);
        }
    }

    private void zu() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder zw = zw();
        if (zw != null) {
            spannableStringBuilder.append((CharSequence) zw);
        }
        String nameShow = this.aBN.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aBG.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void zv() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aBG.getPaint().measureText(this.aBG.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aBG.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aBG.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder zw() {
        List<AlaLiveMarkData> list = this.aBN.aEm;
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
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= w.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = w.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                if (alaLiveMarkData.isGuardType()) {
                    if (TextUtils.isEmpty(alaLiveMarkData.guardName)) {
                        alaLiveMarkData.guardName = getGuardName();
                    }
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + alaLiveMarkData.level + "*_*" + alaLiveMarkData.guardName + "*_*" + (alaLiveMarkData.isGold() ? "1" : "0") + "*_*" + alaLiveMarkData.guardGoldenType;
                    com.baidu.live.view.b bVar = com.baidu.live.view.b.bPf.get(str2);
                    if (bVar == null) {
                        if (alaLiveMarkData.level < 0) {
                            alaLiveMarkData.level = g.HD().gu(alaLiveMarkData.mark_pic);
                        }
                        Bitmap a2 = com.baidu.live.al.b.a(getContext(), alaLiveMarkData.guardName, alaLiveMarkData.level, 0, a.d.sdk_ds32, alaLiveMarkData.isGold(), alaLiveMarkData.guardGoldenType);
                        if (a2 != null) {
                            bVar = new com.baidu.live.view.b(getContext(), a2);
                            spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                            com.baidu.live.view.b.bPf.put(str2, bVar);
                        }
                    }
                    spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.b bVar2 = com.baidu.live.view.b.bPf.get(genCacheKey);
                    if (bVar2 == null) {
                        bVar2 = new com.baidu.live.view.b(getContext(), alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.aBG.setText(ImBarrageItemView.this.aBG.getText());
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.b.bPf.put(genCacheKey, bVar2);
                    }
                    spannableStringBuilder.setSpan(bVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private String getGuardName() {
        if (this.aBN != null && this.aBN.aEm != null && !this.aBN.aEm.isEmpty()) {
            for (AlaLiveMarkData alaLiveMarkData : this.aBN.aEm) {
                if (alaLiveMarkData.isGuardType()) {
                    return alaLiveMarkData.guardName;
                }
            }
        }
        return null;
    }

    private List<AlaLiveMarkData> w(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aBO)) {
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

    private void e(int[] iArr, int[] iArr2) {
        f fVar;
        Drawable background = this.aBG.getBackground();
        if (background instanceof f) {
            fVar = (f) background;
        } else {
            fVar = new f();
            fVar.setAlpha(205);
            fVar.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            fVar.O((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        fVar.f(iArr, iArr2);
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
            post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.5
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aBK.setFloatValues(0.0f, (ImBarrageItemView.this.aBG.getWidth() - ImBarrageItemView.this.aBG.getPaddingLeft()) - ImBarrageItemView.this.aBG.getPaddingRight());
                    ImBarrageItemView.this.aBK.start();
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
}
