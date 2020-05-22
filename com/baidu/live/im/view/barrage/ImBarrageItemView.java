package com.baidu.live.im.view.barrage;

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
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bj;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.im.m;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.b;
import com.baidu.live.view.c;
import com.baidu.live.view.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ImBarrageItemView extends RelativeLayout {
    private HeadImageView aFL;
    private String aSx;
    private TextView aTU;
    private View aUM;
    private View aUN;
    private ImageView aUO;
    private ImageView aUP;
    private LottieAnimationView aUR;
    private ObjectAnimator aUS;
    private ImageView aUT;
    private com.baidu.live.data.a aUV;
    private a aVh;
    private String mContent;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.live.data.a aVar);
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
        this.aVh = aVar;
    }

    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aux = m.CL().CP();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aUV = aVar;
        this.aSx = str;
        this.mContent = str2;
        Ev();
    }

    public void setUIInfo(bj bjVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && bjVar != null) {
            if (bjVar.type == 1) {
                if (bjVar.price >= 300) {
                    i = 2;
                } else if (bjVar.price < 200) {
                    i = 0;
                }
            }
            k(i, z);
            setAvatarBg(bjVar.wy());
            e(bjVar.wz(), bjVar.wA());
            setNobleInfo(bjVar);
        }
    }

    private void setNobleInfo(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.type == 17) {
                this.aUT.setVisibility(0);
                if (bjVar.aCc == 7) {
                    this.aUT.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aUT.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aUO.setVisibility(8);
                this.aUP.setVisibility(8);
                return;
            }
            this.aUT.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aUV != null && !ListUtils.isEmpty(this.aUV.aux)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aUV.aux) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    public void release() {
        if (this.aFL != null) {
            this.aFL.stopLoad();
        }
        if (this.aUS != null) {
            this.aUS.cancel();
        }
        if (this.aUR != null) {
            this.aUR.cancelAnimation();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.aUM = findViewById(a.g.bg_avatar);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aUN = findViewById(a.g.mask_avatar);
        this.aTU = (TextView) findViewById(a.g.tv_content);
        this.aUO = (ImageView) findViewById(a.g.iv_light);
        this.aUP = (ImageView) findViewById(a.g.iv_sweep);
        this.aUR = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aUT = (ImageView) findViewById(a.g.barrage_prime);
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aUR.loop(true);
        this.aUR.setAnimation("im_barrage_item_star.json");
        this.aUM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aVh != null) {
                    ImBarrageItemView.this.aVh.c(ImBarrageItemView.this.aUV);
                }
            }
        });
        this.aUS = ObjectAnimator.ofFloat(this.aUP, "translationX", 0.0f, 0.0f);
        this.aUS.setDuration(800L);
        this.aUS.setInterpolator(new AccelerateInterpolator());
        this.aUS.setRepeatCount(-1);
        this.aUS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aUP.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aUP.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aUS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aUP.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aUP.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void Ev() {
        Ew();
        Ex();
        EB();
    }

    private void Ew() {
        if (this.aFL != null && this.aUV != null) {
            this.aFL.stopLoad();
            this.aFL.startLoad(this.aUV.portrait, 12, false, false);
        }
    }

    private void Ex() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder EC = EC();
        if (EC != null) {
            spannableStringBuilder.append((CharSequence) EC);
        }
        String nameShow = this.aUV.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aTU.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void EB() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aTU.getPaint().measureText(this.aTU.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aTU.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aTU.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder EC() {
        List<AlaLiveMarkData> list = this.aUV.aux;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> I = I(list);
        if (ListUtils.isEmpty(I)) {
            return null;
        }
        int length = "[img] ".length();
        String str = "";
        for (int i = 0; i < I.size(); i++) {
            str = "[img] " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < I.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = I.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = (i3 + length) - 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aUV.level_id;
                    c cVar = ALaImInitialize.aQp.get(str2);
                    if (cVar == null) {
                        cVar = new b(getContext(), alaLiveMarkData, this.aUV.level_id, false, new c.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aTU.setText(ImBarrageItemView.this.aTU.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.aQp.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = ALaImInitialize.aQp.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aTU.setText(ImBarrageItemView.this.aTU.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.aQp.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> I(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aSx)) {
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
        Drawable background = this.aUM.getBackground();
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
        this.aUM.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aTU.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            gVar.J((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.aTU.setBackgroundDrawable(gVar);
    }

    private void k(int i, boolean z) {
        if (this.aUS != null) {
            this.aUS.cancel();
        }
        if (this.aUR != null) {
            this.aUR.cancelAnimation();
        }
        this.aUO.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aUN.setVisibility(0);
            this.aUS.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.barrage.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aUS.setFloatValues(0.0f, (ImBarrageItemView.this.aTU.getWidth() - ImBarrageItemView.this.aTU.getPaddingLeft()) - ImBarrageItemView.this.aTU.getPaddingRight());
                    ImBarrageItemView.this.aUS.start();
                }
            });
            this.aUR.setVisibility(0);
            this.aUR.playAnimation();
            this.aTU.setTextColor(-531173);
            return;
        }
        this.aUN.setVisibility(8);
        this.aUP.setVisibility(8);
        this.aUR.setVisibility(4);
        this.aUR.cancelAnimation();
        this.aTU.setTextColor(-1);
    }
}
