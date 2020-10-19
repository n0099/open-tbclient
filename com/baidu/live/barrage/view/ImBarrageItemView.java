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
import com.baidu.live.data.bz;
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
import com.baidu.live.view.c;
import com.baidu.live.view.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ImBarrageItemView extends RelativeLayout implements b {
    private View aEg;
    private HeadImageView aEh;
    private View aEi;
    private TextView aEj;
    private ImageView aEk;
    private ImageView aEl;
    private LottieAnimationView aEm;
    private ObjectAnimator aEn;
    private ImageView aEo;
    private a aEp;
    private com.baidu.live.data.a aEq;
    private String aEr;
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
        this.aEp = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aGI = d.Lm().Lq();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aEq = aVar;
        this.aEr = str;
        this.mContent = str2;
        Cy();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(bz bzVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && bzVar != null) {
            if (bzVar.type == 1) {
                if (bzVar.price >= 300) {
                    i = 2;
                } else if (bzVar.price < 200) {
                    i = 0;
                }
            }
            m(i, z);
            setAvatarBg(bzVar.Ep());
            e(bzVar.Eq(), bzVar.Er());
            setNobleInfo(bzVar);
        }
    }

    private void setNobleInfo(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.type == 17) {
                this.aEo.setVisibility(0);
                if (bzVar.aPF == 7) {
                    this.aEo.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aEo.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aEk.setVisibility(8);
                this.aEl.setVisibility(8);
                return;
            }
            this.aEo.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aEq != null && !ListUtils.isEmpty(this.aEq.aGI)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aEq.aGI) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aEh != null) {
            this.aEh.stopLoad();
        }
        if (this.aEn != null) {
            this.aEn.cancel();
        }
        if (this.aEm != null) {
            this.aEm.cancelAnimation();
        }
    }

    @Override // com.baidu.live.im.b.b
    @NonNull
    public View getView() {
        return this;
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.aEg = findViewById(a.g.bg_avatar);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aEi = findViewById(a.g.mask_avatar);
        this.aEj = (TextView) findViewById(a.g.tv_content);
        this.aEk = (ImageView) findViewById(a.g.iv_light);
        this.aEl = (ImageView) findViewById(a.g.iv_sweep);
        this.aEm = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aEo = (ImageView) findViewById(a.g.barrage_prime);
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aEm.loop(true);
        this.aEm.setAnimation("im_barrage_item_star.json");
        this.aEg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aEp != null) {
                    ImBarrageItemView.this.aEp.b(ImBarrageItemView.this.aEq);
                }
            }
        });
        this.aEn = ObjectAnimator.ofFloat(this.aEl, "translationX", 0.0f, 0.0f);
        this.aEn.setDuration(800L);
        this.aEn.setInterpolator(new AccelerateInterpolator());
        this.aEn.setRepeatCount(-1);
        this.aEn.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aEl.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aEl.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aEn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aEl.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aEl.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void Cy() {
        Cz();
        CA();
        CB();
    }

    private void Cz() {
        if (this.aEh != null && this.aEq != null) {
            this.aEh.stopLoad();
            this.aEh.startLoad(this.aEq.portrait, 12, false, false);
        }
    }

    private void CA() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder CC = CC();
        if (CC != null) {
            spannableStringBuilder.append((CharSequence) CC);
        }
        String nameShow = this.aEq.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aEj.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void CB() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aEj.getPaint().measureText(this.aEj.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aEj.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aEj.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder CC() {
        List<AlaLiveMarkData> list = this.aEq.aGI;
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
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aEq.level_id;
                    c cVar = c.bCP.get(str2);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, this.aEq.level_id, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aEj.setText(ImBarrageItemView.this.aEj.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        c.bCP.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = c.bCP.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aEj.setText(ImBarrageItemView.this.aEj.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        c.bCP.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aEr)) {
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
        Drawable background = this.aEg.getBackground();
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
        this.aEg.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aEj.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            gVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.aEj.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aEn != null) {
            this.aEn.cancel();
        }
        if (this.aEm != null) {
            this.aEm.cancelAnimation();
        }
        this.aEk.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aEi.setVisibility(0);
            this.aEn.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aEn.setFloatValues(0.0f, (ImBarrageItemView.this.aEj.getWidth() - ImBarrageItemView.this.aEj.getPaddingLeft()) - ImBarrageItemView.this.aEj.getPaddingRight());
                    ImBarrageItemView.this.aEn.start();
                }
            });
            this.aEm.setVisibility(0);
            this.aEm.playAnimation();
            this.aEj.setTextColor(-531173);
            return;
        }
        this.aEi.setVisibility(8);
        this.aEl.setVisibility(8);
        this.aEm.setVisibility(4);
        this.aEm.cancelAnimation();
        this.aEj.setTextColor(-1);
    }
}
