package com.baidu.live.im.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.entereffect.b.d;
import com.baidu.live.gift.ac;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class ALAImEnterView extends LinearLayout {
    private static int agH;
    private TextView aBG;
    private TbImageView bmv;
    private ObjectAnimator bmw;
    private int bmx;
    private boolean bmy;

    public ALAImEnterView(Context context) {
        super(context);
        this.bmy = false;
        init();
    }

    public void A(com.baidu.live.im.data.b bVar) {
        if (!d.BQ().BR() && !d.BQ().hasMsg() && !this.bmy) {
            d.BQ().j(bVar);
            Km();
            return;
        }
        d.BQ().j(bVar);
    }

    public void HN() {
        Kk();
    }

    public void release() {
        this.bmy = false;
        d.BQ().release();
        setVisibility(4);
        if (this.bmw != null) {
            this.bmw.cancel();
        }
        if (this.bmv != null) {
            this.bmv.stopLoad();
        }
        Kl();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.bmv != null) {
            this.bmv.stopLoad();
        }
    }

    private void init() {
        Kj();
        initView();
        setVisibility(4);
        agH = BdUtilHelper.getEquipmentWidth(getContext());
        this.bmx = getResources().getDimensionPixelOffset(a.d.sdk_ds32);
    }

    private void Kj() {
        setGravity(16);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        setBackgroundDrawable(gradientDrawable);
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_im_enter, (ViewGroup) this, true);
        this.bmv = (TbImageView) findViewById(a.f.iv_icon);
        this.aBG = (TextView) findViewById(a.f.tv_content);
        this.bmv.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.bmv.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void Kk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.dy(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Kl() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(int i) {
        if (i == 0) {
            Kn();
        } else if (i == 1) {
            Km();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        com.baidu.live.im.data.b BS = d.BQ().BS();
        if (BS != null) {
            com.baidu.live.data.a JB = BS.JB();
            if (JB == null) {
                Km();
                return;
            }
            com.baidu.live.entereffect.a.c i = com.baidu.live.entereffect.a.BG().i(BS);
            if (i == null) {
                Km();
            } else if (!a(JB, i)) {
                b(JB, i);
                setVisibility(0);
                Ko();
            }
        }
    }

    private void Kn() {
        com.baidu.live.im.data.b BT = d.BQ().BT();
        if (BT == null) {
            Km();
            return;
        }
        com.baidu.live.data.a JB = BT.JB();
        if (JB == null) {
            Km();
            return;
        }
        com.baidu.live.entereffect.a.c i = com.baidu.live.entereffect.a.BG().i(BT);
        if (i == null) {
            Km();
            return;
        }
        b(JB, i);
        setVisibility(0);
        Ko();
    }

    private boolean a(com.baidu.live.data.a aVar, com.baidu.live.entereffect.a.c cVar) {
        String str = cVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a fi = com.baidu.live.entereffect.a.BG().fi(str);
        if (fi != null) {
            ac.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, fi.priority == 1, cVar.msgId);
            return true;
        }
        com.baidu.live.entereffect.a.BG().s(str, cVar.aRv);
        return false;
    }

    private void b(com.baidu.live.data.a aVar, com.baidu.live.entereffect.a.c cVar) {
        setBackground(cVar);
        a(cVar);
        c(aVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBackground(com.baidu.live.entereffect.a.c cVar) {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        if (Build.VERSION.SDK_INT >= 16) {
            Drawable background = getBackground();
            if (background instanceof GradientDrawable) {
                String str = cVar.aRm;
                String str2 = cVar.aRn;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    i = 0;
                    i2 = 0;
                    z = false;
                } else {
                    try {
                        i6 = Color.parseColor(str);
                        try {
                            i = Color.parseColor(str2);
                            i2 = i6;
                            z = true;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            i = 0;
                            i2 = i6;
                            z = false;
                            if (!z) {
                            }
                            ((GradientDrawable) background).setColors(new int[]{i3, i});
                            setBackgroundDrawable(background);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        i6 = 0;
                    }
                }
                if (!z) {
                    String str3 = cVar.aRo;
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            i4 = Integer.parseInt(str3);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            i4 = -1;
                        }
                        if (i4 >= 0 && i4 <= 100) {
                            i2 = ColorUtils.setAlphaComponent(i2, (i4 * 255) / 100);
                        }
                    }
                    String str4 = cVar.aRp;
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            i5 = Integer.parseInt(str4);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            i5 = -1;
                        }
                        if (i5 >= 0 && i5 <= 100) {
                            i = ColorUtils.setAlphaComponent(i, (i5 * 255) / 100);
                        }
                    }
                    i3 = i2;
                } else {
                    int parseColor = Color.parseColor("#B3FF5460");
                    i = Color.parseColor("#B3D565A9");
                    i3 = parseColor;
                }
                ((GradientDrawable) background).setColors(new int[]{i3, i});
                setBackgroundDrawable(background);
            }
        }
    }

    private void a(com.baidu.live.entereffect.a.c cVar) {
        if (this.bmv != null) {
            this.bmv.stopLoad();
            if (!TextUtils.isEmpty(cVar.iconUrl) && cVar.aRt > 0 && cVar.aRu > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmv.getLayoutParams();
                layoutParams.height = this.bmx;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / cVar.aRu) * cVar.aRt);
                this.bmv.setLayoutParams(layoutParams);
                this.bmv.startLoad(cVar.iconUrl, 10, false, false);
                this.bmv.setVisibility(0);
                return;
            }
            this.bmv.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, com.baidu.live.entereffect.a.c cVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = cVar.aRr;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(cVar.aRr);
        }
        String str2 = aVar.name_show;
        if (str2 != null) {
            if (TextHelper.getTextLengthWithEmoji(str2) > 20) {
                str2 = TextHelper.subStringWithEmoji(str2, 20) + StringHelper.STRING_MORE;
            }
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(cVar.aRs)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(cVar.aRs);
        }
        this.aBG.setText(sb.toString());
        try {
            parseColor = Color.parseColor(cVar.aRq);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aBG.setTextColor(parseColor);
    }

    private void Ko() {
        this.bmy = true;
        if (this.bmw != null) {
            this.bmw.cancel();
            this.bmw.removeAllListeners();
            this.bmw.removeAllUpdateListeners();
            this.bmw.setInterpolator(null);
        }
        this.bmw = ObjectAnimator.ofFloat(this, "TranslationX", agH, -agH);
        this.bmw.setDuration(4600L);
        this.bmw.setEvaluator(new a());
        this.bmw.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.bmw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.bmy = false;
                ALAImEnterView.this.Km();
            }
        });
        this.bmw.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends FloatEvaluator {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.animation.TypeEvaluator
        public Float evaluate(float f, Number number, Number number2) {
            float f2;
            float f3 = f * 4600.0f;
            if (f3 <= 300.0f) {
                f2 = ((f3 / 300.0f) * ALAImEnterView.agH) + (-ALAImEnterView.agH);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.agH)) + ALAImEnterView.agH);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
