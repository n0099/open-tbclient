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
import com.baidu.live.gift.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class ALAImEnterView extends LinearLayout {
    private static int ahA;
    private TextView aAw;
    private TbImageView bcK;
    private ObjectAnimator bcL;
    private int bcM;
    private boolean bcN;

    public ALAImEnterView(Context context) {
        super(context);
        this.bcN = false;
        init();
    }

    public void v(com.baidu.live.im.data.a aVar) {
        if (!d.Do().Dp() && !d.Do().hasMsg() && !this.bcN) {
            d.Do().j(aVar);
            Kj();
            return;
        }
        d.Do().j(aVar);
    }

    public void Ju() {
        Kh();
    }

    public void release() {
        this.bcN = false;
        d.Do().release();
        setVisibility(4);
        if (this.bcL != null) {
            this.bcL.cancel();
        }
        if (this.bcK != null) {
            this.bcK.stopLoad();
        }
        Ki();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.bcK != null) {
            this.bcK.stopLoad();
        }
    }

    private void init() {
        Kg();
        initView();
        setVisibility(4);
        ahA = BdUtilHelper.getEquipmentWidth(getContext());
        this.bcM = getResources().getDimensionPixelOffset(a.e.sdk_ds32);
    }

    private void Kg() {
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
        this.bcK = (TbImageView) findViewById(a.g.iv_icon);
        this.aAw = (TextView) findViewById(a.g.tv_content);
        this.bcK.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.bcK.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void Kh() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.ex(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Ki() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(int i) {
        if (i == 0) {
            Kk();
        } else if (i == 1) {
            Kj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj() {
        com.baidu.live.im.data.a Dq = d.Do().Dq();
        if (Dq != null) {
            com.baidu.live.data.a JK = Dq.JK();
            if (JK == null) {
                Kj();
                return;
            }
            b i = com.baidu.live.entereffect.a.Dg().i(Dq);
            if (i == null) {
                Kj();
            } else if (!a(JK, i)) {
                b(JK, i);
                setVisibility(0);
                Kl();
            }
        }
    }

    private void Kk() {
        com.baidu.live.im.data.a Dr = d.Do().Dr();
        if (Dr == null) {
            Kj();
            return;
        }
        com.baidu.live.data.a JK = Dr.JK();
        if (JK == null) {
            Kj();
            return;
        }
        b i = com.baidu.live.entereffect.a.Dg().i(Dr);
        if (i == null) {
            Kj();
            return;
        }
        b(JK, i);
        setVisibility(0);
        Kl();
    }

    private boolean a(com.baidu.live.data.a aVar, b bVar) {
        String str = bVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a fU = com.baidu.live.entereffect.a.Dg().fU(str);
        if (fU != null) {
            v.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, fU.priority == 1, bVar.msgId);
            return true;
        }
        com.baidu.live.entereffect.a.Dg().fV(str);
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
                String str = bVar.aMc;
                String str2 = bVar.aMd;
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
                    String str3 = bVar.aMe;
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
                    String str4 = bVar.aMf;
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
        if (this.bcK != null) {
            this.bcK.stopLoad();
            if (!TextUtils.isEmpty(bVar.iconUrl) && bVar.aMi > 0 && bVar.aMj > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcK.getLayoutParams();
                layoutParams.height = this.bcM;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / bVar.aMj) * bVar.aMi);
                this.bcK.setLayoutParams(layoutParams);
                this.bcK.startLoad(bVar.iconUrl, 10, false, false);
                this.bcK.setVisibility(0);
                return;
            }
            this.bcK.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, b bVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = bVar.aMg;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(bVar.aMg);
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
        if (!TextUtils.isEmpty(bVar.aMh)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(bVar.aMh);
        }
        this.aAw.setText(sb.toString());
        try {
            parseColor = Color.parseColor(bVar.aJg);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aAw.setTextColor(parseColor);
    }

    private void Kl() {
        this.bcN = true;
        this.bcL = ObjectAnimator.ofFloat(this, "TranslationX", ahA, -ahA);
        this.bcL.setDuration(4600L);
        this.bcL.setEvaluator(new a());
        this.bcL.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.bcL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.bcN = false;
                ALAImEnterView.this.Kj();
            }
        });
        this.bcL.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.ahA) + (-ALAImEnterView.ahA);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.ahA)) + ALAImEnterView.ahA);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
