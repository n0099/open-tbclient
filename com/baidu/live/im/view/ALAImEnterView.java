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
    private static int afu;
    private TbImageView aNM;
    private TextView aNN;
    private ObjectAnimator aNO;
    private int aNP;
    private boolean aNQ;

    public ALAImEnterView(Context context) {
        super(context);
        this.aNQ = false;
        init();
    }

    public void v(com.baidu.live.im.data.a aVar) {
        if (!d.vw().vx() && !d.vw().hasMsg() && !this.aNQ) {
            d.vw().c(aVar);
            Cy();
            return;
        }
        d.vw().c(aVar);
    }

    public void BA() {
        Cw();
    }

    public void release() {
        this.aNQ = false;
        d.vw().release();
        setVisibility(4);
        if (this.aNO != null) {
            this.aNO.cancel();
        }
        if (this.aNM != null) {
            this.aNM.stopLoad();
        }
        Cx();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.aNM != null) {
            this.aNM.stopLoad();
        }
    }

    private void init() {
        Cv();
        initView();
        setVisibility(4);
        afu = BdUtilHelper.getEquipmentWidth(getContext());
        this.aNP = getResources().getDimensionPixelOffset(a.e.sdk_ds28);
    }

    private void Cv() {
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
        this.aNM = (TbImageView) findViewById(a.g.iv_icon);
        this.aNN = (TextView) findViewById(a.g.tv_content);
        this.aNM.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aNM.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void Cw() {
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

    private void Cx() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(int i) {
        if (i == 0) {
            Cz();
        } else if (i == 1) {
            Cy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cy() {
        com.baidu.live.im.data.a vy = d.vw().vy();
        if (vy != null) {
            com.baidu.live.data.a Ce = vy.Ce();
            if (Ce == null) {
                Cy();
                return;
            }
            b b = com.baidu.live.entereffect.a.vn().b(vy);
            if (b == null) {
                Cy();
            } else if (!a(Ce, b)) {
                b(Ce, b);
                setVisibility(0);
                CA();
            }
        }
    }

    private void Cz() {
        com.baidu.live.im.data.a vz = d.vw().vz();
        if (vz == null) {
            Cy();
            return;
        }
        com.baidu.live.data.a Ce = vz.Ce();
        if (Ce == null) {
            Cy();
            return;
        }
        b b = com.baidu.live.entereffect.a.vn().b(vz);
        if (b == null) {
            Cy();
            return;
        }
        b(Ce, b);
        setVisibility(0);
        CA();
    }

    private boolean a(com.baidu.live.data.a aVar, b bVar) {
        String str = bVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a dR = com.baidu.live.entereffect.a.vn().dR(str);
        if (dR != null) {
            u.b(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, dR.priority == 1, bVar.msgId);
            return true;
        }
        com.baidu.live.entereffect.a.vn().dS(str);
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
                String str = bVar.axP;
                String str2 = bVar.axQ;
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
                    String str3 = bVar.axR;
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
                    String str4 = bVar.axS;
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
        if (this.aNM != null) {
            this.aNM.stopLoad();
            if (!TextUtils.isEmpty(bVar.iconUrl) && bVar.axV > 0 && bVar.axW > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNM.getLayoutParams();
                layoutParams.height = this.aNP;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / bVar.axW) * bVar.axV);
                this.aNM.setLayoutParams(layoutParams);
                this.aNM.startLoad(bVar.iconUrl, 10, false, false);
                this.aNM.setVisibility(0);
                return;
            }
            this.aNM.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, b bVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(bVar.axT)) {
            sb.append(bVar.axT);
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
        if (!TextUtils.isEmpty(bVar.axU)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(bVar.axU);
        }
        this.aNN.setText(sb.toString());
        try {
            parseColor = Color.parseColor(bVar.avi);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aNN.setTextColor(parseColor);
    }

    private void CA() {
        this.aNQ = true;
        this.aNO = ObjectAnimator.ofFloat(this, "TranslationX", afu, -afu);
        this.aNO.setDuration(4600L);
        this.aNO.setEvaluator(new a());
        this.aNO.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.aNO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.aNQ = false;
                ALAImEnterView.this.Cy();
            }
        });
        this.aNO.start();
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.afu) + (-ALAImEnterView.afu);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.afu)) + ALAImEnterView.afu);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
