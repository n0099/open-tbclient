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
/* loaded from: classes11.dex */
public class ImBarrageItemView extends RelativeLayout implements b {
    private com.baidu.live.data.a aGA;
    private String aGB;
    private View aGq;
    private HeadImageView aGr;
    private View aGs;
    private TextView aGt;
    private ImageView aGu;
    private ImageView aGv;
    private LottieAnimationView aGw;
    private ObjectAnimator aGx;
    private ImageView aGy;
    private a aGz;
    private String mContent;

    /* loaded from: classes11.dex */
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
        this.aGz = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aIZ = d.Nk().Np();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aGA = aVar;
        this.aGB = str;
        this.mContent = str2;
        Dn();
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
            setAvatarBg(ckVar.Fu());
            e(ckVar.Fv(), ckVar.Fw());
            setNobleInfo(ckVar);
        }
    }

    private void setNobleInfo(ck ckVar) {
        if (ckVar != null) {
            if (ckVar.type == 17) {
                this.aGy.setVisibility(0);
                if (ckVar.aTG == 7) {
                    this.aGy.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aGy.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aGu.setVisibility(8);
                this.aGv.setVisibility(8);
                return;
            }
            this.aGy.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aGA != null && !ListUtils.isEmpty(this.aGA.aIZ)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aGA.aIZ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aGr != null) {
            this.aGr.stopLoad();
        }
        if (this.aGx != null) {
            this.aGx.cancel();
        }
        if (this.aGw != null) {
            this.aGw.cancelAnimation();
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
        this.aGq = findViewById(a.f.bg_avatar);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aGs = findViewById(a.f.mask_avatar);
        this.aGt = (TextView) findViewById(a.f.tv_content);
        this.aGu = (ImageView) findViewById(a.f.iv_light);
        this.aGv = (ImageView) findViewById(a.f.iv_sweep);
        this.aGw = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aGy = (ImageView) findViewById(a.f.barrage_prime);
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aGw.loop(true);
        this.aGw.setAnimation("im_barrage_item_star.json");
        this.aGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aGz != null) {
                    ImBarrageItemView.this.aGz.b(ImBarrageItemView.this.aGA);
                }
            }
        });
        this.aGx = ObjectAnimator.ofFloat(this.aGv, "translationX", 0.0f, 0.0f);
        this.aGx.setDuration(800L);
        this.aGx.setInterpolator(new AccelerateInterpolator());
        this.aGx.setRepeatCount(-1);
        this.aGx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aGv.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aGv.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aGx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aGv.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aGv.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void Dn() {
        Do();
        Dp();
        Dq();
    }

    private void Do() {
        if (this.aGr != null && this.aGA != null) {
            this.aGr.stopLoad();
            this.aGr.startLoad(this.aGA.portrait, 12, false, false);
        }
    }

    private void Dp() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Dr = Dr();
        if (Dr != null) {
            spannableStringBuilder.append((CharSequence) Dr);
        }
        String nameShow = this.aGA.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aGt.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void Dq() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aGt.getPaint().measureText(this.aGt.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aGt.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aGt.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Dr() {
        List<AlaLiveMarkData> list = this.aGA.aIZ;
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
                    com.baidu.live.view.b bVar = com.baidu.live.view.b.bTR.get(str2);
                    if (bVar == null) {
                        if (alaLiveMarkData.level < 0) {
                            alaLiveMarkData.level = g.Ly().hF(alaLiveMarkData.mark_pic);
                        }
                        Bitmap a2 = com.baidu.live.al.b.a(getContext(), alaLiveMarkData.guardName, alaLiveMarkData.level, 0, a.d.sdk_ds32, alaLiveMarkData.isGold(), alaLiveMarkData.guardGoldenType);
                        if (a2 != null) {
                            bVar = new com.baidu.live.view.b(getContext(), a2);
                            spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                            com.baidu.live.view.b.bTR.put(str2, bVar);
                        }
                    }
                    spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.b bVar2 = com.baidu.live.view.b.bTR.get(genCacheKey);
                    if (bVar2 == null) {
                        bVar2 = new com.baidu.live.view.b(getContext(), alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.aGt.setText(ImBarrageItemView.this.aGt.getText());
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.b.bTR.put(genCacheKey, bVar2);
                    }
                    spannableStringBuilder.setSpan(bVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private String getGuardName() {
        if (this.aGA != null && this.aGA.aIZ != null && !this.aGA.aIZ.isEmpty()) {
            for (AlaLiveMarkData alaLiveMarkData : this.aGA.aIZ) {
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aGB)) {
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
        Drawable background = this.aGq.getBackground();
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
        this.aGq.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        f fVar;
        Drawable background = this.aGt.getBackground();
        if (background instanceof f) {
            fVar = (f) background;
        } else {
            fVar = new f();
            fVar.setAlpha(205);
            fVar.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            fVar.O((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        fVar.f(iArr, iArr2);
        this.aGt.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aGx != null) {
            this.aGx.cancel();
        }
        if (this.aGw != null) {
            this.aGw.cancelAnimation();
        }
        this.aGu.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aGs.setVisibility(0);
            this.aGx.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.5
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aGx.setFloatValues(0.0f, (ImBarrageItemView.this.aGt.getWidth() - ImBarrageItemView.this.aGt.getPaddingLeft()) - ImBarrageItemView.this.aGt.getPaddingRight());
                    ImBarrageItemView.this.aGx.start();
                }
            });
            this.aGw.setVisibility(0);
            this.aGw.playAnimation();
            this.aGt.setTextColor(-531173);
            return;
        }
        this.aGs.setVisibility(8);
        this.aGv.setVisibility(8);
        this.aGw.setVisibility(4);
        this.aGw.cancelAnimation();
        this.aGt.setTextColor(-1);
    }
}
