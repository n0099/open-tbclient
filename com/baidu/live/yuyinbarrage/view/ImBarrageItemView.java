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
import com.baidu.live.data.cg;
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
    private View aFe;
    private HeadImageView aFf;
    private View aFg;
    private TextView aFh;
    private ImageView aFi;
    private ImageView aFj;
    private LottieAnimationView aFk;
    private ObjectAnimator aFl;
    private ImageView aFm;
    private com.baidu.live.data.a aFo;
    private String aFp;
    private a bPk;
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
        this.bPk = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aHG = d.Mg().Ml();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aFo = aVar;
        this.aFp = str;
        this.mContent = str2;
        CX();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(cg cgVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && cgVar != null) {
            if (cgVar.type == 1) {
                if (cgVar.price >= 300) {
                    i = 2;
                } else if (cgVar.price < 200) {
                    i = 0;
                }
            }
            m(i, z);
            setAvatarBg(cgVar.EZ());
            e(cgVar.Fa(), cgVar.Fb());
            setNobleInfo(cgVar);
        }
    }

    private void setNobleInfo(cg cgVar) {
        if (cgVar != null) {
            if (cgVar.type == 17) {
                this.aFm.setVisibility(0);
                if (cgVar.aRr == 7) {
                    this.aFm.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aFm.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
                this.aFi.setVisibility(8);
                this.aFj.setVisibility(8);
                return;
            }
            this.aFm.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aFo != null && !ListUtils.isEmpty(this.aFo.aHG)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aFo.aHG) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aFf != null) {
            this.aFf.stopLoad();
        }
        if (this.aFl != null) {
            this.aFl.cancel();
        }
        if (this.aFk != null) {
            this.aFk.cancelAnimation();
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
        this.aFe = findViewById(a.f.bg_avatar);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aFg = findViewById(a.f.mask_avatar);
        this.aFh = (TextView) findViewById(a.f.tv_content);
        this.aFi = (ImageView) findViewById(a.f.iv_light);
        this.aFj = (ImageView) findViewById(a.f.iv_sweep);
        this.aFk = (LottieAnimationView) findViewById(a.f.lottie_star);
        this.aFm = (ImageView) findViewById(a.f.barrage_prime);
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aFk.loop(true);
        this.aFk.setAnimation("im_barrage_item_star.json");
        this.aFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.bPk != null) {
                    ImBarrageItemView.this.bPk.b(ImBarrageItemView.this.aFo);
                }
            }
        });
        this.aFl = ObjectAnimator.ofFloat(this.aFj, "translationX", 0.0f, 0.0f);
        this.aFl.setDuration(800L);
        this.aFl.setInterpolator(new AccelerateInterpolator());
        this.aFl.setRepeatCount(-1);
        this.aFl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aFj.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aFj.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aFl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aFj.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aFj.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void CX() {
        CY();
        CZ();
        Da();
    }

    private void CY() {
        if (this.aFf != null && this.aFo != null) {
            this.aFf.stopLoad();
            this.aFf.startLoad(this.aFo.portrait, 12, false, false);
        }
    }

    private void CZ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder Db = Db();
        if (Db != null) {
            spannableStringBuilder.append((CharSequence) Db);
        }
        String nameShow = this.aFo.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aFh.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void Da() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aFh.getPaint().measureText(this.aFh.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aFh.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aFh.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder Db() {
        List<AlaLiveMarkData> list = this.aFo.aHG;
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
                String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bLq.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.4
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            ImBarrageItemView.this.aFh.setText(ImBarrageItemView.this.aFh.getText());
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bLq.put(genCacheKey, bVar);
                }
                spannableStringBuilder.setSpan(bVar, i3, i4, 17);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aFp)) {
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
        Drawable background = this.aFe.getBackground();
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
        this.aFe.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        f fVar;
        Drawable background = this.aFh.getBackground();
        if (background instanceof f) {
            fVar = (f) background;
        } else {
            fVar = new f();
            fVar.setAlpha(205);
            fVar.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            fVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        fVar.f(iArr, iArr2);
        this.aFh.setBackgroundDrawable(fVar);
    }

    private void m(int i, boolean z) {
        if (this.aFl != null) {
            this.aFl.cancel();
        }
        if (this.aFk != null) {
            this.aFk.cancelAnimation();
        }
        this.aFi.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aFg.setVisibility(0);
            this.aFl.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.5
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aFl.setFloatValues(0.0f, (ImBarrageItemView.this.aFh.getWidth() - ImBarrageItemView.this.aFh.getPaddingLeft()) - ImBarrageItemView.this.aFh.getPaddingRight());
                    ImBarrageItemView.this.aFl.start();
                }
            });
            this.aFk.setVisibility(0);
            this.aFk.playAnimation();
            this.aFh.setTextColor(-531173);
            return;
        }
        this.aFg.setVisibility(8);
        this.aFj.setVisibility(8);
        this.aFk.setVisibility(4);
        this.aFk.cancelAnimation();
        this.aFh.setTextColor(-1);
    }
}
