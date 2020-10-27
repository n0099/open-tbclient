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
import com.baidu.live.data.ce;
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
    private View aEo;
    private HeadImageView aEp;
    private View aEq;
    private TextView aEr;
    private ImageView aEs;
    private ImageView aEt;
    private LottieAnimationView aEu;
    private ObjectAnimator aEv;
    private ImageView aEw;
    private com.baidu.live.data.a aEy;
    private String aEz;
    private a bJE;
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
        this.bJE = aVar;
    }

    @Override // com.baidu.live.im.b.b
    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.aGQ = d.LG().LL();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aEy = aVar;
        this.aEz = str;
        this.mContent = str2;
        CE();
    }

    @Override // com.baidu.live.im.b.b
    public void setUIInfo(ce ceVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && ceVar != null) {
            if (ceVar.type == 1) {
                if (ceVar.price >= 300) {
                    i = 2;
                } else if (ceVar.price < 200) {
                    i = 0;
                }
            }
            m(i, z);
            setAvatarBg(ceVar.Ey());
            e(ceVar.Ez(), ceVar.EA());
            setNobleInfo(ceVar);
        }
    }

    private void setNobleInfo(ce ceVar) {
        if (ceVar != null) {
            if (ceVar.type == 17) {
                this.aEw.setVisibility(0);
                if (ceVar.aQp == 7) {
                    this.aEw.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    this.aEw.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
                this.aEs.setVisibility(8);
                this.aEt.setVisibility(8);
                return;
            }
            this.aEw.setVisibility(8);
        }
    }

    private int getNobleLevel() {
        if (this.aEy != null && !ListUtils.isEmpty(this.aEy.aGQ)) {
            for (AlaLiveMarkData alaLiveMarkData : this.aEy.aGQ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.live.im.b.b
    public void release() {
        if (this.aEp != null) {
            this.aEp.stopLoad();
        }
        if (this.aEv != null) {
            this.aEv.cancel();
        }
        if (this.aEu != null) {
            this.aEu.cancelAnimation();
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
        this.aEo = findViewById(a.g.bg_avatar);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aEq = findViewById(a.g.mask_avatar);
        this.aEr = (TextView) findViewById(a.g.tv_content);
        this.aEs = (ImageView) findViewById(a.g.iv_light);
        this.aEt = (ImageView) findViewById(a.g.iv_sweep);
        this.aEu = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aEw = (ImageView) findViewById(a.g.barrage_prime);
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aEu.loop(true);
        this.aEu.setAnimation("im_barrage_item_star.json");
        this.aEo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.bJE != null) {
                    ImBarrageItemView.this.bJE.b(ImBarrageItemView.this.aEy);
                }
            }
        });
        this.aEv = ObjectAnimator.ofFloat(this.aEt, "translationX", 0.0f, 0.0f);
        this.aEv.setDuration(800L);
        this.aEv.setInterpolator(new AccelerateInterpolator());
        this.aEv.setRepeatCount(-1);
        this.aEv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aEt.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aEt.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aEv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aEt.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aEt.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void CE() {
        CF();
        CG();
        CH();
    }

    private void CF() {
        if (this.aEp != null && this.aEy != null) {
            this.aEp.stopLoad();
            this.aEp.startLoad(this.aEy.portrait, 12, false, false);
        }
    }

    private void CG() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder CI = CI();
        if (CI != null) {
            spannableStringBuilder.append((CharSequence) CI);
        }
        String nameShow = this.aEy.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.aEr.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private void CH() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
            int screenWidth = (int) (ScreenHelper.getScreenWidth(getContext()) * 0.75d);
            float measureText = this.aEr.getPaint().measureText(this.aEr.getText().toString());
            ViewGroup.LayoutParams layoutParams = this.aEr.getLayoutParams();
            layoutParams.height = -2;
            if (measureText > screenWidth) {
                layoutParams.width = screenWidth;
            } else {
                layoutParams.width = -2;
            }
            this.aEr.setLayoutParams(layoutParams);
        }
    }

    private SpannableStringBuilder CI() {
        List<AlaLiveMarkData> list = this.aEy.aGQ;
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
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aEy.level_id;
                    c cVar = c.bFL.get(str2);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(getContext(), alaLiveMarkData, this.aEy.level_id, false, new c.a() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aEr.setText(ImBarrageItemView.this.aEr.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        c.bFL.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = c.bFL.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                ImBarrageItemView.this.aEr.setText(ImBarrageItemView.this.aEr.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        c.bFL.put(genCacheKey, cVar2);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aEz)) {
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
        Drawable background = this.aEo.getBackground();
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
        this.aEo.setBackgroundDrawable(gradientDrawable);
    }

    private void e(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.aEr.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            gVar.P((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.f(iArr, iArr2);
        this.aEr.setBackgroundDrawable(gVar);
    }

    private void m(int i, boolean z) {
        if (this.aEv != null) {
            this.aEv.cancel();
        }
        if (this.aEu != null) {
            this.aEu.cancelAnimation();
        }
        this.aEs.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aEq.setVisibility(0);
            this.aEv.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aEv.setFloatValues(0.0f, (ImBarrageItemView.this.aEr.getWidth() - ImBarrageItemView.this.aEr.getPaddingLeft()) - ImBarrageItemView.this.aEr.getPaddingRight());
                    ImBarrageItemView.this.aEv.start();
                }
            });
            this.aEu.setVisibility(0);
            this.aEu.playAnimation();
            this.aEr.setTextColor(-531173);
            return;
        }
        this.aEq.setVisibility(8);
        this.aEt.setVisibility(8);
        this.aEu.setVisibility(4);
        this.aEu.cancelAnimation();
        this.aEr.setTextColor(-1);
    }
}
