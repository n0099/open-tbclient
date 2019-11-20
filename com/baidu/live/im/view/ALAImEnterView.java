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
import com.baidu.live.gift.q;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class ALAImEnterView extends LinearLayout {
    private static int GP;
    private boolean ahA;
    private TbImageView ahw;
    private TextView ahx;
    private ObjectAnimator ahy;
    private int ahz;

    public ALAImEnterView(Context context) {
        super(context);
        this.ahA = false;
        init();
    }

    public void k(com.baidu.live.im.data.a aVar) {
        if (!d.oO().oP() && !d.oO().hasMsg() && !this.ahA) {
            d.oO().c(aVar);
            tv();
            return;
        }
        d.oO().c(aVar);
    }

    public void sX() {
        tt();
    }

    public void release() {
        this.ahA = false;
        d.oO().release();
        setVisibility(4);
        if (this.ahy != null) {
            this.ahy.cancel();
        }
        if (this.ahw != null) {
            this.ahw.stopLoad();
        }
        tu();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.ahw != null) {
            this.ahw.stopLoad();
        }
    }

    private void init() {
        ts();
        initView();
        setVisibility(4);
        GP = BdUtilHelper.getEquipmentWidth(getContext());
        this.ahz = getResources().getDimensionPixelOffset(a.e.sdk_ds28);
    }

    private void ts() {
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
        this.ahw = (TbImageView) findViewById(a.g.iv_icon);
        this.ahx = (TextView) findViewById(a.g.tv_content);
        this.ahw.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.ahw.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void tt() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.bv(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void tu() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(int i) {
        if (i == 0) {
            tw();
        } else if (i == 1) {
            tv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv() {
        com.baidu.live.im.data.a oQ = d.oO().oQ();
        if (oQ != null) {
            com.baidu.live.data.a tf = oQ.tf();
            if (tf == null) {
                tv();
                return;
            }
            b b = com.baidu.live.entereffect.a.oF().b(oQ);
            if (b == null) {
                tv();
            } else if (!a(tf, b)) {
                b(tf, b);
                setVisibility(0);
                tx();
            }
        }
    }

    private void tw() {
        com.baidu.live.im.data.a oR = d.oO().oR();
        if (oR == null) {
            tv();
            return;
        }
        com.baidu.live.data.a tf = oR.tf();
        if (tf == null) {
            tv();
            return;
        }
        b b = com.baidu.live.entereffect.a.oF().b(oR);
        if (b == null) {
            tv();
            return;
        }
        b(tf, b);
        setVisibility(0);
        tx();
    }

    private boolean a(com.baidu.live.data.a aVar, b bVar) {
        String str = bVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a bY = com.baidu.live.entereffect.a.oF().bY(str);
        if (bY != null) {
            q.b(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, bY.priority == 1);
            return true;
        }
        com.baidu.live.entereffect.a.oF().bZ(str);
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
                String str = bVar.Vp;
                String str2 = bVar.Vq;
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
                    String str3 = bVar.Vr;
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
                    String str4 = bVar.Vs;
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
        if (this.ahw != null) {
            this.ahw.stopLoad();
            if (!TextUtils.isEmpty(bVar.iconUrl) && bVar.Vv > 0 && bVar.Vw > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahw.getLayoutParams();
                layoutParams.height = this.ahz;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / bVar.Vw) * bVar.Vv);
                this.ahw.setLayoutParams(layoutParams);
                this.ahw.startLoad(bVar.iconUrl, 10, false, false);
                this.ahw.setVisibility(0);
                return;
            }
            this.ahw.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, b bVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(bVar.Vt)) {
            sb.append(bVar.Vt);
        }
        String str = aVar.name_show;
        if (!TextUtils.isEmpty(str)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            if (str.length() > 5) {
                str = str.substring(0, 5) + StringHelper.STRING_MORE;
            }
            sb.append(str);
        }
        if (!TextUtils.isEmpty(bVar.Vu)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(bVar.Vu);
        }
        this.ahx.setText(sb.toString());
        try {
            parseColor = Color.parseColor(bVar.Tz);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.ahx.setTextColor(parseColor);
    }

    private void tx() {
        this.ahA = true;
        this.ahy = ObjectAnimator.ofFloat(this, "TranslationX", GP, -GP);
        this.ahy.setDuration(4600L);
        this.ahy.setEvaluator(new a());
        this.ahy.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.ahy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.ahA = false;
                ALAImEnterView.this.tv();
            }
        });
        this.ahy.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.GP) + (-ALAImEnterView.GP);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.GP)) + ALAImEnterView.GP);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
