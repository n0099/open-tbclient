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
import android.support.annotation.NonNull;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.entereffect.a.b;
import com.baidu.live.entereffect.b.d;
import com.baidu.live.gift.u;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class ALAImEnterView extends LinearLayout {
    private static int afr;
    private TbImageView aNG;
    private TextView aNH;
    private ObjectAnimator aNI;
    private int aNJ;
    private boolean aNK;

    public ALAImEnterView(Context context) {
        super(context);
        this.aNK = false;
        init();
    }

    public void v(com.baidu.live.im.data.a aVar) {
        if (!d.vx().vy() && !d.vx().hasMsg() && !this.aNK) {
            d.vx().c(aVar);
            Cz();
            return;
        }
        d.vx().c(aVar);
    }

    public void BB() {
        Cx();
    }

    public void release() {
        this.aNK = false;
        d.vx().release();
        setVisibility(4);
        if (this.aNI != null) {
            this.aNI.cancel();
        }
        if (this.aNG != null) {
            this.aNG.stopLoad();
        }
        Cy();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.aNG != null) {
            this.aNG.stopLoad();
        }
    }

    private void init() {
        Cw();
        initView();
        setVisibility(4);
        afr = BdUtilHelper.getEquipmentWidth(getContext());
        this.aNJ = getResources().getDimensionPixelOffset(a.e.sdk_ds28);
    }

    private void Cw() {
        setGravity(16);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds28));
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        setBackgroundDrawable(gradientDrawable);
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_im_enter, (ViewGroup) this, true);
        this.aNG = (TbImageView) findViewById(a.g.iv_icon);
        this.aNH = (TextView) findViewById(a.g.tv_content);
        this.aNG.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aNG.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void Cx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.cn(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Cy() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(int i) {
        if (i == 0) {
            CA();
        } else if (i == 1) {
            Cz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        com.baidu.live.im.data.a vz = d.vx().vz();
        if (vz != null) {
            com.baidu.live.data.a Cf = vz.Cf();
            if (Cf == null) {
                Cz();
                return;
            }
            b b = com.baidu.live.entereffect.a.vo().b(vz);
            if (b == null) {
                Cz();
            } else if (!a(Cf, b)) {
                b(Cf, b);
                setVisibility(0);
                CB();
            }
        }
    }

    private void CA() {
        com.baidu.live.im.data.a vA = d.vx().vA();
        if (vA == null) {
            Cz();
            return;
        }
        com.baidu.live.data.a Cf = vA.Cf();
        if (Cf == null) {
            Cz();
            return;
        }
        b b = com.baidu.live.entereffect.a.vo().b(vA);
        if (b == null) {
            Cz();
            return;
        }
        b(Cf, b);
        setVisibility(0);
        CB();
    }

    private boolean a(com.baidu.live.data.a aVar, b bVar) {
        String str = bVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a dR = com.baidu.live.entereffect.a.vo().dR(str);
        if (dR != null) {
            u.b(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, dR.priority == 1, bVar.msgId);
            return true;
        }
        com.baidu.live.entereffect.a.vo().dS(str);
        return false;
    }

    private void b(com.baidu.live.data.a aVar, b bVar) {
        setBackground(bVar);
        a(bVar);
        c(aVar, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBackground(b bVar) {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6 = -1;
        if (Build.VERSION.SDK_INT >= 16) {
            Drawable background = getBackground();
            if (background instanceof GradientDrawable) {
                String str = bVar.axJ;
                String str2 = bVar.axK;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    i = 0;
                    i2 = 0;
                    z = false;
                } else {
                    try {
                        i5 = Color.parseColor(str);
                        try {
                            int parseColor = Color.parseColor(str2);
                            z = true;
                            i = parseColor;
                            i2 = i5;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            i2 = i5;
                            z = false;
                            i = 0;
                            if (!z) {
                            }
                            ((GradientDrawable) background).setColors(new int[]{i3, i});
                            setBackgroundDrawable(background);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        i5 = 0;
                    }
                }
                if (!z) {
                    String str3 = bVar.axL;
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
                    String str4 = bVar.axM;
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            i6 = Integer.parseInt(str4);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        if (i6 >= 0 && i6 <= 100) {
                            i = ColorUtils.setAlphaComponent(i, (i6 * 255) / 100);
                        }
                    }
                    i3 = i2;
                } else {
                    int parseColor2 = Color.parseColor("#B3FF5460");
                    i = Color.parseColor("#B3D565A9");
                    i3 = parseColor2;
                }
                ((GradientDrawable) background).setColors(new int[]{i3, i});
                setBackgroundDrawable(background);
            }
        }
    }

    private void a(b bVar) {
        if (this.aNG != null) {
            this.aNG.stopLoad();
            if (!TextUtils.isEmpty(bVar.iconUrl) && bVar.axP > 0 && bVar.axQ > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNG.getLayoutParams();
                layoutParams.height = this.aNJ;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / bVar.axQ) * bVar.axP);
                this.aNG.setLayoutParams(layoutParams);
                this.aNG.startLoad(bVar.iconUrl, 10, false, false);
                this.aNG.setVisibility(0);
                return;
            }
            this.aNG.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, b bVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(bVar.axN)) {
            sb.append(bVar.axN);
        }
        String str = aVar.name_show;
        if (str != null) {
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(str);
        }
        if (!TextUtils.isEmpty(bVar.axO)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(bVar.axO);
        }
        this.aNH.setText(sb.toString());
        try {
            parseColor = Color.parseColor(bVar.avc);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aNH.setTextColor(parseColor);
    }

    private void CB() {
        this.aNK = true;
        this.aNI = ObjectAnimator.ofFloat(this, "TranslationX", afr, -afr);
        this.aNI.setDuration(4600L);
        this.aNI.setEvaluator(new a());
        this.aNI.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.aNI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.aNK = false;
                ALAImEnterView.this.Cz();
            }
        });
        this.aNI.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.afr) + (-ALAImEnterView.afr);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.afr)) + ALAImEnterView.afr);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
