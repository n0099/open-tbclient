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
    private ImageView aAA;
    private LottieAnimationView aAB;
    private ObjectAnimator aAC;
    private ImageView aAD;
    private a aAE;
    private com.baidu.live.data.a aAF;
    private String aAG;
    private View aAv;
    private HeadImageView aAw;
    private View aAx;
    private TextView aAy;
    private ImageView aAz;
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
        this.aAE = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aCU = d.JD().JH();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aAF = aVar;
        this.aAG = str;
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
                this.aAD.setVisibility(0);
                if (brVar.aKT == 7) {
                    this.aAD.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aAD.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aAz.setVisibility(8);
                this.aAA.setVisibility(8);
                return;
            }
            this.aAD.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aAF != null && !ListUtils.isEmpty(this.aAF.aCU)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aAF.aCU) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aAw != null) {
            this.aAw.stopLoad();
        }
        if (this.aAC != null) {
            this.aAC.cancel();
        }
        if (this.aAB != null) {
            this.aAB.cancelAnimation();
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
        this.aAv = findViewById(a.g.bg_avatar);
        this.aAw = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aAx = findViewById(a.g.mask_avatar);
        this.aAy = (TextView) findViewById(a.g.tv_content);
        this.aAz = (ImageView) findViewById(a.g.iv_light);
        this.aAA = (ImageView) findViewById(a.g.iv_sweep);
        this.aAB = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aAD = (ImageView) findViewById(a.g.barrage_prime);
        this.aAw.setIsRound(true);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aAB.loop(true);
        this.aAB.setAnimation("im_barrage_item_star.json");
        this.aAv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aAE != null) {
                    ImBarrageItemView.this.aAE.b(ImBarrageItemView.this.aAF);
                }
            }
        });
        this.aAC = ObjectAnimator.ofFloat(this.aAA, "translationX", 0.0f, 0.0f);
        this.aAC.setDuration(800L);
        this.aAC.setInterpolator(new AccelerateInterpolator());
        this.aAC.setRepeatCount(-1);
        this.aAC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aAA.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aAA.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aAC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aAA.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aAA.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
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
        if (this.aAw != null && this.aAF != null) {
            this.aAw.stopLoad();
            this.aAw.startLoad(this.aAF.portrait, 12, false, false);
        }
    }

    private void Bo() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Bq = Bq();
        if (Bq != null) {
            spannableStringBuilder.append((CharSequence) Bq);
        }
        String nameShow = this.aAF.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aAy.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void Bp() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aAy.getPaint().measureText(this.aAy.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aAy.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aAy.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Bq() {
        List<AlaLiveMarkData> list = this.aAF.aCU;
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
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aAF.level_id;
                    c cVar = c.bsV.get(str2);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, this.aAF.level_id, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aAy.setText(ImBarrageItemView.this.aAy.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        c.bsV.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = c.bsV.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aAy.setText(ImBarrageItemView.this.aAy.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        c.bsV.put(genCacheKey, cVar2);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aAG)) {
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
        Drawable background = this.aAv.getBackground();
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
        this.aAv.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aAy.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            gVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.aAy.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aAC != null) {
            this.aAC.cancel();
        }
        if (this.aAB != null) {
            this.aAB.cancelAnimation();
        }
        this.aAz.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aAx.setVisibility(0);
            this.aAC.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.barrage.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aAC.setFloatValues(0.0f, (ImBarrageItemView.this.aAy.getWidth() - ImBarrageItemView.this.aAy.getPaddingLeft()) - ImBarrageItemView.this.aAy.getPaddingRight());
                    ImBarrageItemView.this.aAC.start();
                }
            });
            this.aAB.setVisibility(0);
            this.aAB.playAnimation();
            this.aAy.setTextColor(-531173);
            return;
        }
        this.aAx.setVisibility(8);
        this.aAA.setVisibility(8);
        this.aAB.setVisibility(4);
        this.aAB.cancelAnimation();
        this.aAy.setTextColor(-1);
    }
}
