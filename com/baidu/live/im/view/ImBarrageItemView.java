package com.baidu.live.im.view;

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
import com.baidu.live.data.av;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.im.k;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.b;
import com.baidu.live.view.c;
import com.baidu.live.view.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class ImBarrageItemView extends RelativeLayout {
    private HeadImageView aeR;
    private String aoN;
    private TextView apB;
    private View aqk;
    private View aql;
    private ImageView aqm;
    private ImageView aqn;
    private LottieAnimationView aqo;
    private ObjectAnimator aqp;
    private a aqq;
    private com.baidu.live.data.a aqr;
    private av aqs;
    private String mContent;

    /* loaded from: classes2.dex */
    public interface a {
        void d(com.baidu.live.data.a aVar);
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
        this.aqq = aVar;
    }

    public void setPreview() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            aVar.name_show = currentAccountInfo.getAccountNameShow();
            aVar.portrait = currentAccountInfo.getPortrait();
            aVar.level_id = currentAccountInfo.getLiveLevel();
            aVar.Vp = k.uF().uJ();
            setDisplayInfo(aVar, "", "弹幕是这个样子的哟～");
        }
    }

    public void setDisplayInfo(com.baidu.live.data.a aVar, String str, String str2) {
        this.aqr = aVar;
        this.aoN = str;
        this.mContent = str2;
        vJ();
    }

    public void setUIInfo(av avVar, boolean z) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 16 && avVar != null) {
            if (avVar.type == 1) {
                if (avVar.price >= 300) {
                    i = 2;
                } else if (avVar.price < 200) {
                    i = 0;
                }
            }
            h(i, z);
            this.aqs = avVar;
            setAvatarBg(this.aqs.pW());
            d(this.aqs.pX(), this.aqs.pY());
        }
    }

    public void release() {
        if (this.aeR != null) {
            this.aeR.stopLoad();
        }
        if (this.aqp != null) {
            this.aqp.cancel();
        }
        if (this.aqo != null) {
            this.aqo.cancelAnimation();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_barrage_item, (ViewGroup) this, true);
        this.aqk = findViewById(a.g.bg_avatar);
        this.aeR = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aql = findViewById(a.g.mask_avatar);
        this.apB = (TextView) findViewById(a.g.tv_content);
        this.aqm = (ImageView) findViewById(a.g.iv_light);
        this.aqn = (ImageView) findViewById(a.g.iv_sweep);
        this.aqo = (LottieAnimationView) findViewById(a.g.lottie_star);
        this.aeR.setIsRound(true);
        this.aeR.setAutoChangeStyle(false);
        this.aeR.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aqo.loop(true);
        this.aqo.setAnimation("im_barrage_item_star.json");
        this.aqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ImBarrageItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImBarrageItemView.this.aqq != null) {
                    ImBarrageItemView.this.aqq.d(ImBarrageItemView.this.aqr);
                }
            }
        });
        this.aqp = ObjectAnimator.ofFloat(this.aqn, "translationX", 0.0f, 0.0f);
        this.aqp.setDuration(800L);
        this.aqp.setInterpolator(new AccelerateInterpolator());
        this.aqp.setRepeatCount(-1);
        this.aqp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ImBarrageItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ImBarrageItemView.this.aqn.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ImBarrageItemView.this.aqn.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                animator.setStartDelay(0L);
            }
        });
        this.aqp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.ImBarrageItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    ImBarrageItemView.this.aqn.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                } else {
                    ImBarrageItemView.this.aqn.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                }
            }
        });
    }

    private void vJ() {
        vK();
        vL();
    }

    private void vK() {
        if (this.aeR != null && this.aqr != null) {
            this.aeR.stopLoad();
            this.aeR.startLoad(this.aqr.portrait, 12, false, false);
        }
    }

    private void vL() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder vM = vM();
        if (vM != null) {
            spannableStringBuilder.append((CharSequence) vM);
        }
        String nameShow = this.aqr.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 6) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 6) + StringHelper.STRING_MORE;
            }
        } else {
            nameShow = "";
        }
        SpannableString valueOf = SpannableString.valueOf(nameShow + "：");
        valueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7E51B")), 0, valueOf.length(), 33);
        this.apB.setText(spannableStringBuilder.append((CharSequence) valueOf).append((CharSequence) this.mContent));
    }

    private SpannableStringBuilder vM() {
        List<AlaLiveMarkData> list = this.aqr.Vp;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> E = E(list);
        if (ListUtils.isEmpty(E)) {
            return null;
        }
        int length = "  ".length();
        String str = "";
        for (int i = 0; i < E.size(); i++) {
            str = "  " + str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 = 0; i2 < E.size(); i2++) {
            AlaLiveMarkData alaLiveMarkData = E.get(i2);
            if (alaLiveMarkData != null) {
                int i3 = i2 * length;
                int i4 = i3 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str2 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + this.aqr.level_id;
                    c cVar = ALaImInitialize.ani.get(str2);
                    if (cVar == null) {
                        cVar = new b(getContext(), alaLiveMarkData, this.aqr.level_id, false, new c.a() { // from class: com.baidu.live.im.view.ImBarrageItemView.4
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.apB.setText(ImBarrageItemView.this.apB.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.ani.put(str2, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i3, i4, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    c cVar2 = ALaImInitialize.ani.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new c(getContext(), alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.view.ImBarrageItemView.5
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                ImBarrageItemView.this.apB.setText(ImBarrageItemView.this.apB.getText());
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.ani.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i3, i4, 17);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> E(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aoN)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 4 ? linkedList.subList(0, 4) : linkedList;
        }
        return list;
    }

    private void setAvatarBg(int[] iArr) {
        GradientDrawable gradientDrawable;
        Drawable background = this.aqk.getBackground();
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
        this.aqk.setBackgroundDrawable(gradientDrawable);
    }

    private void d(int[] iArr, int[] iArr2) {
        g gVar;
        Drawable background = this.apB.getBackground();
        if (background instanceof g) {
            gVar = (g) background;
        } else {
            gVar = new g();
            gVar.setAlpha(205);
            gVar.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds37));
            gVar.C((int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics()), 205);
        }
        gVar.e(iArr, iArr2);
        this.apB.setBackgroundDrawable(gVar);
    }

    private void h(int i, boolean z) {
        if (this.aqp != null) {
            this.aqp.cancel();
        }
        if (this.aqo != null) {
            this.aqo.cancelAnimation();
        }
        this.aqm.setVisibility(i >= 1 ? 0 : 8);
        if (i == 2) {
            this.aql.setVisibility(0);
            this.aqp.setStartDelay(z ? 300L : 0L);
            post(new Runnable() { // from class: com.baidu.live.im.view.ImBarrageItemView.6
                @Override // java.lang.Runnable
                public void run() {
                    ImBarrageItemView.this.aqp.setFloatValues(0.0f, (ImBarrageItemView.this.apB.getWidth() - ImBarrageItemView.this.apB.getPaddingLeft()) - ImBarrageItemView.this.apB.getPaddingRight());
                    ImBarrageItemView.this.aqp.start();
                }
            });
            this.aqo.setVisibility(0);
            this.aqo.playAnimation();
            this.apB.setTextColor(-531173);
            return;
        }
        this.aql.setVisibility(8);
        this.aqn.setVisibility(8);
        this.aqo.setVisibility(4);
        this.aqo.cancelAnimation();
        this.apB.setTextColor(-1);
    }
}
