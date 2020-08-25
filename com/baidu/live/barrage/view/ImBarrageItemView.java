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
import com.baidu.live.data.br;
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
/* loaded from: classes7.dex */
public class ImBarrageItemView extends RelativeLayout implements b {
    private ObjectAnimator aAA;
    private ImageView aAB;
    private a aAC;
    private com.baidu.live.data.a aAD;
    private String aAE;
    private View aAt;
    private HeadImageView aAu;
    private View aAv;
    private TextView aAw;
    private ImageView aAx;
    private ImageView aAy;
    private LottieAnimationView aAz;
    private String mContent;

    /* loaded from: classes7.dex */
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
        this.aAC = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aCS = d.JD().JH();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aAD = aVar;
        this.aAE = str;
        this.mContent = str2;
        Bm();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(br brVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && brVar != null) {
            if (brVar.type == 1) {
                if (brVar.price >= 300) {
                    i = 2;
                } else if (brVar.price < 200) {
                    i = 0;
                }
            }
            m(i, z);
            setAvatarBg(brVar.Dc());
            e(brVar.Dd(), brVar.De());
            setNobleInfo(brVar);
        }
    }

    private void setNobleInfo(br brVar) {
        if (brVar != null) {
            if (brVar.type == 17) {
                this.aAB.setVisibility(0);
                if (brVar.aKR == 7) {
                    this.aAB.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aAB.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aAx.setVisibility(8);
                this.aAy.setVisibility(8);
                return;
            }
            this.aAB.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aAD != null && !ListUtils.isEmpty(this.aAD.aCS)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aAD.aCS) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aAu != null) {
            this.aAu.stopLoad();
        }
        if (this.aAA != null) {
            this.aAA.cancel();
        }
        if (this.aAz != null) {
            this.aAz.cancelAnimation();
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
        this.aAt = findViewById(a.g.bg_avatar);
        this.aAu = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aAv = findViewById(a.g.mask_avatar);
        this.aAw = (TextView) findViewById(a.g.tv_content);
        this.aAx = (ImageView) findViewById(a.g.iv_light);
        this.aAy = (ImageView) findViewById(a.g.iv_sweep);
        this.aAz = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aAB = (ImageView) findViewById(a.g.barrage_prime);
        this.aAu.setIsRound(true);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aAz.loop(true);
        this.aAz.setAnimation("im_barrage_item_star.json");
        this.aAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aAC != null) {
                    ImBarrageItemView.this.aAC.b(ImBarrageItemView.this.aAD);
                }
            }
        });
        this.aAA = ObjectAnimator.ofFloat(this.aAy, "translationX", 0.0f, 0.0f);
        this.aAA.setDuration(800L);
        this.aAA.setInterpolator(new AccelerateInterpolator());
        this.aAA.setRepeatCount(-1);
        this.aAA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aAy.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aAy.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aAA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aAy.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aAy.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void Bm() {
        Bn();
        Bo();
        Bp();
    }

    private void Bn() {
        if (this.aAu != null && this.aAD != null) {
            this.aAu.stopLoad();
            this.aAu.startLoad(this.aAD.portrait, 12, false, false);
        }
    }

    private void Bo() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Bq = Bq();
        if (Bq != null) {
            spannableStringBuilder.append((CharSequence) Bq);
        }
        String nameShow = this.aAD.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aAw.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void Bp() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aAw.getPaint().measureText(this.aAw.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aAw.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aAw.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Bq() {
        List<AlaLiveMarkData> list = this.aAD.aCS;
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
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aAD.level_id;
                    c cVar = c.bsS.get(str2);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, this.aAD.level_id, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aAw.setText(ImBarrageItemView.this.aAw.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        c.bsS.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = c.bsS.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aAw.setText(ImBarrageItemView.this.aAw.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        c.bsS.put(genCacheKey, cVar2);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aAE)) {
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
        Drawable background = this.aAt.getBackground();
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
        this.aAt.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aAw.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            gVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.aAw.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aAA != null) {
            this.aAA.cancel();
        }
        if (this.aAz != null) {
            this.aAz.cancelAnimation();
        }
        this.aAx.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aAv.setVisibility(0);
            this.aAA.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aAA.setFloatValues(0.0f, (ImBarrageItemView.this.aAw.getWidth() - ImBarrageItemView.this.aAw.getPaddingLeft()) - ImBarrageItemView.this.aAw.getPaddingRight());
                    ImBarrageItemView.this.aAA.start();
                }
            });
            this.aAz.setVisibility(0);
            this.aAz.playAnimation();
            this.aAw.setTextColor(-531173);
            return;
        }
        this.aAv.setVisibility(8);
        this.aAy.setVisibility(8);
        this.aAz.setVisibility(4);
        this.aAz.cancelAnimation();
        this.aAw.setTextColor(-1);
    }
}
