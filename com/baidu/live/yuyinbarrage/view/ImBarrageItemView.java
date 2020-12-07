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
import com.baidu.live.data.ci;
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
    private View aFZ;
    private HeadImageView aGa;
    private View aGb;
    private TextView aGc;
    private ImageView aGd;
    private ImageView aGe;
    private LottieAnimationView aGf;
    private ObjectAnimator aGg;
    private ImageView aGh;
    private com.baidu.live.data.a aGj;
    private String aGk;
    private a bSG;
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
        this.bSG = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aID = d.NK().NP();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aGj = aVar;
        this.aGk = str;
        this.mContent = str2;
        DY();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(ci ciVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && ciVar != null) {
            if (ciVar.type == 1) {
                if (ciVar.price >= 300) {
                    i = 2;
                } else if (ciVar.price < 200) {
                    i = 0;
                }
            }
            m(i, z);
            setAvatarBg(ciVar.Gb());
            e(ciVar.Gc(), ciVar.Gd());
            setNobleInfo(ciVar);
        }
    }

    private void setNobleInfo(ci ciVar) {
        if (ciVar != null) {
            if (ciVar.type == 17) {
                this.aGh.setVisibility(0);
                if (ciVar.aSI == 7) {
                    this.aGh.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aGh.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aGd.setVisibility(8);
                this.aGe.setVisibility(8);
                return;
            }
            this.aGh.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aGj != null && !ListUtils.isEmpty(this.aGj.aID)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aGj.aID) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aGa != null) {
            this.aGa.stopLoad();
        }
        if (this.aGg != null) {
            this.aGg.cancel();
        }
        if (this.aGf != null) {
            this.aGf.cancelAnimation();
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
        this.aFZ = findViewById(a.f.bg_avatar);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aGb = findViewById(a.f.mask_avatar);
        this.aGc = (TextView) findViewById(a.f.tv_content);
        this.aGd = (ImageView) findViewById(a.f.iv_light);
        this.aGe = (ImageView) findViewById(a.f.iv_sweep);
        this.aGf = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aGh = (ImageView) findViewById(a.f.barrage_prime);
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aGf.loop(true);
        this.aGf.setAnimation("im_barrage_item_star.json");
        this.aFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.bSG != null) {
                    ImBarrageItemView.this.bSG.b(ImBarrageItemView.this.aGj);
                }
            }
        });
        this.aGg = ObjectAnimator.ofFloat(this.aGe, "translationX", 0.0f, 0.0f);
        this.aGg.setDuration(800L);
        this.aGg.setInterpolator(new AccelerateInterpolator());
        this.aGg.setRepeatCount(-1);
        this.aGg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aGe.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aGe.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aGg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aGe.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aGe.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void DY() {
        DZ();
        Ea();
        Eb();
    }

    private void DZ() {
        if (this.aGa != null && this.aGj != null) {
            this.aGa.stopLoad();
            this.aGa.startLoad(this.aGj.portrait, 12, false, false);
        }
    }

    private void Ea() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Ec = Ec();
        if (Ec != null) {
            spannableStringBuilder.append((CharSequence) Ec);
        }
        String nameShow = this.aGj.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aGc.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void Eb() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aGc.getPaint().measureText(this.aGc.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aGc.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aGc.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Ec() {
        List<AlaLiveMarkData> list = this.aGj.aID;
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
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bON.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.4
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            ImBarrageItemView.this.aGc.setText(ImBarrageItemView.this.aGc.getText());
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bON.put(genCacheKey, bVar);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aGk)) {
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
        Drawable background = this.aFZ.getBackground();
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
        this.aFZ.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        f fVar;
        Drawable background = this.aGc.getBackground();
        if (background instanceof f) {
            fVar = (f) background;
        } else {
            fVar = new f();
            fVar.setAlpha(205);
            fVar.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            fVar.O((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        fVar.f(iArr, iArr2);
        this.aGc.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aGg != null) {
            this.aGg.cancel();
        }
        if (this.aGf != null) {
            this.aGf.cancelAnimation();
        }
        this.aGd.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aGb.setVisibility(0);
            this.aGg.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.5
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aGg.setFloatValues(0.0f, (ImBarrageItemView.this.aGc.getWidth() - ImBarrageItemView.this.aGc.getPaddingLeft()) - ImBarrageItemView.this.aGc.getPaddingRight());
                    ImBarrageItemView.this.aGg.start();
                }
            });
            this.aGf.setVisibility(0);
            this.aGf.playAnimation();
            this.aGc.setTextColor(-531173);
            return;
        }
        this.aGb.setVisibility(8);
        this.aGe.setVisibility(8);
        this.aGf.setVisibility(4);
        this.aGf.cancelAnimation();
        this.aGc.setTextColor(-1);
    }
}
