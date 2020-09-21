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
    private View aBb;
    private HeadImageView aBc;
    private View aBd;
    private TextView aBe;
    private ImageView aBf;
    private ImageView aBg;
    private LottieAnimationView aBh;
    private ObjectAnimator aBi;
    private ImageView aBj;
    private a aBk;
    private com.baidu.live.data.a aBl;
    private String aBm;
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
        this.aBk = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aDE = d.Kh().Kl();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aBl = aVar;
        this.aBm = str;
        this.mContent = str2;
        BB();
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
            setAvatarBg(bzVar.Ds());
            e(bzVar.Dt(), bzVar.Du());
            setNobleInfo(bzVar);
        }
    }

    private void setNobleInfo(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.type == 17) {
                this.aBj.setVisibility(0);
                if (bzVar.aMA == 7) {
                    this.aBj.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aBj.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aBf.setVisibility(8);
                this.aBg.setVisibility(8);
                return;
            }
            this.aBj.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aBl != null && !ListUtils.isEmpty(this.aBl.aDE)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aBl.aDE) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aBc != null) {
            this.aBc.stopLoad();
        }
        if (this.aBi != null) {
            this.aBi.cancel();
        }
        if (this.aBh != null) {
            this.aBh.cancelAnimation();
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
        this.aBb = findViewById(a.g.bg_avatar);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aBd = findViewById(a.g.mask_avatar);
        this.aBe = (TextView) findViewById(a.g.tv_content);
        this.aBf = (ImageView) findViewById(a.g.iv_light);
        this.aBg = (ImageView) findViewById(a.g.iv_sweep);
        this.aBh = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aBj = (ImageView) findViewById(a.g.barrage_prime);
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aBh.loop(true);
        this.aBh.setAnimation("im_barrage_item_star.json");
        this.aBb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aBk != null) {
                    ImBarrageItemView.this.aBk.b(ImBarrageItemView.this.aBl);
                }
            }
        });
        this.aBi = ObjectAnimator.ofFloat(this.aBg, "translationX", 0.0f, 0.0f);
        this.aBi.setDuration(800L);
        this.aBi.setInterpolator(new AccelerateInterpolator());
        this.aBi.setRepeatCount(-1);
        this.aBi.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aBg.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aBg.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aBi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aBg.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aBg.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void BB() {
        BC();
        BD();
        BE();
    }

    private void BC() {
        if (this.aBc != null && this.aBl != null) {
            this.aBc.stopLoad();
            this.aBc.startLoad(this.aBl.portrait, 12, false, false);
        }
    }

    private void BD() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder BF = BF();
        if (BF != null) {
            spannableStringBuilder.append((CharSequence) BF);
        }
        String nameShow = this.aBl.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aBe.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void BE() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aBe.getPaint().measureText(this.aBe.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aBe.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aBe.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder BF() {
        List<AlaLiveMarkData> list = this.aBl.aDE;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> t = t(list);
        if (ListUtils.isEmpty(t)) {
            return null;
        }
        int length = "[img] ".length();
        String str = "";
        for (int i = 0; i < t.size(); i++) {
            str = "[img] " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < t.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = t.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = (i3 + length) - 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aBl.level_id;
                    c cVar = c.bwm.get(str2);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, this.aBl.level_id, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aBe.setText(ImBarrageItemView.this.aBe.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        c.bwm.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = c.bwm.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aBe.setText(ImBarrageItemView.this.aBe.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        c.bwm.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> t(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aBm)) {
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
        Drawable background = this.aBb.getBackground();
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
        this.aBb.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aBe.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            gVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.aBe.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aBi != null) {
            this.aBi.cancel();
        }
        if (this.aBh != null) {
            this.aBh.cancelAnimation();
        }
        this.aBf.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aBd.setVisibility(0);
            this.aBi.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aBi.setFloatValues(0.0f, (ImBarrageItemView.this.aBe.getWidth() - ImBarrageItemView.this.aBe.getPaddingLeft()) - ImBarrageItemView.this.aBe.getPaddingRight());
                    ImBarrageItemView.this.aBi.start();
                }
            });
            this.aBh.setVisibility(0);
            this.aBh.playAnimation();
            this.aBe.setTextColor(-531173);
            return;
        }
        this.aBd.setVisibility(8);
        this.aBg.setVisibility(8);
        this.aBh.setVisibility(4);
        this.aBh.cancelAnimation();
        this.aBe.setTextColor(-1);
    }
}
