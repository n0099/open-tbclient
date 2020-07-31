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
import com.baidu.live.data.bp;
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
    private a avA;
    private com.baidu.live.data.a avB;
    private String avC;
    private View avr;
    private HeadImageView avs;
    private View avt;
    private TextView avu;
    private ImageView avv;
    private ImageView avw;
    private LottieAnimationView avx;
    private ObjectAnimator avy;
    private ImageView avz;
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
        this.avA = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.axQ = d.Ea().Ee();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.avB = aVar;
        this.avC = str;
        this.mContent = str2;
        vO();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(bp bpVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && bpVar != null) {
            if (bpVar.type == 1) {
                if (bpVar.price >= 300) {
                    i = 2;
                } else if (bpVar.price < 200) {
                    i = 0;
                }
            }
            l(i, z);
            setAvatarBg(bpVar.xz());
            e(bpVar.xA(), bpVar.xB());
            setNobleInfo(bpVar);
        }
    }

    private void setNobleInfo(bp bpVar) {
        if (bpVar != null) {
            if (bpVar.type == 17) {
                this.avz.setVisibility(0);
                if (bpVar.aFH == 7) {
                    this.avz.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.avz.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.avv.setVisibility(8);
                this.avw.setVisibility(8);
                return;
            }
            this.avz.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.avB != null && !ListUtils.isEmpty(this.avB.axQ)) {
            for (AlaLiveMarkData alaLiveMarkData : this.avB.axQ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.avs != null) {
            this.avs.stopLoad();
        }
        if (this.avy != null) {
            this.avy.cancel();
        }
        if (this.avx != null) {
            this.avx.cancelAnimation();
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
        this.avr = findViewById(a.g.bg_avatar);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.avt = findViewById(a.g.mask_avatar);
        this.avu = (TextView) findViewById(a.g.tv_content);
        this.avv = (ImageView) findViewById(a.g.iv_light);
        this.avw = (ImageView) findViewById(a.g.iv_sweep);
        this.avx = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.avz = (ImageView) findViewById(a.g.barrage_prime);
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setDefaultBgResource(a.f.sdk_default_avatar);
        this.avx.loop(true);
        this.avx.setAnimation("im_barrage_item_star.json");
        this.avr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.avA != null) {
                    ImBarrageItemView.this.avA.b(ImBarrageItemView.this.avB);
                }
            }
        });
        this.avy = ObjectAnimator.ofFloat(this.avw, "translationX", 0.0f, 0.0f);
        this.avy.setDuration(800L);
        this.avy.setInterpolator(new AccelerateInterpolator());
        this.avy.setRepeatCount(-1);
        this.avy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.avw.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.avw.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.avy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.avw.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.avw.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void vO() {
        vP();
        vQ();
        vR();
    }

    private void vP() {
        if (this.avs != null && this.avB != null) {
            this.avs.stopLoad();
            this.avs.startLoad(this.avB.portrait, 12, false, false);
        }
    }

    private void vQ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder vS = vS();
        if (vS != null) {
            spannableStringBuilder.append((CharSequence) vS);
        }
        String nameShow = this.avB.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.avu.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void vR() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.avu.getPaint().measureText(this.avu.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.avu.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.avu.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder vS() {
        List<AlaLiveMarkData> list = this.avB.axQ;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> s = s(list);
        if (ListUtils.isEmpty(s)) {
            return null;
        }
        int length = "[img] ".length();
        String str = "";
        for (int i = 0; i < s.size(); i++) {
            str = "[img] " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < s.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = s.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = (i3 + length) - 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.avB.level_id;
                    c cVar = c.bnn.get(str2);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, this.avB.level_id, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.avu.setText(ImBarrageItemView.this.avu.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        c.bnn.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = c.bnn.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.avu.setText(ImBarrageItemView.this.avu.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        c.bnn.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> s(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.avC)) {
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
        Drawable background = this.avr.getBackground();
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
        this.avr.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.avu.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            gVar.L((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.avu.setBackgroundDrawable(gVar);
    }

    private void l(int i, boolean z) {
        if (this.avy != null) {
            this.avy.cancel();
        }
        if (this.avx != null) {
            this.avx.cancelAnimation();
        }
        this.avv.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.avt.setVisibility(0);
            this.avy.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.avy.setFloatValues(0.0f, (ImBarrageItemView.this.avu.getWidth() - ImBarrageItemView.this.avu.getPaddingLeft()) - ImBarrageItemView.this.avu.getPaddingRight());
                    ImBarrageItemView.this.avy.start();
                }
            });
            this.avx.setVisibility(0);
            this.avx.playAnimation();
            this.avu.setTextColor(-531173);
            return;
        }
        this.avt.setVisibility(8);
        this.avw.setVisibility(8);
        this.avx.setVisibility(4);
        this.avx.cancelAnimation();
        this.avu.setTextColor(-1);
    }
}
