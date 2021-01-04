package com.baidu.live.yuyinim.view;

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
import com.baidu.live.entereffect.a.c;
import com.baidu.live.entereffect.b.e;
import com.baidu.live.gift.aj;
import com.baidu.live.im.data.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class ALAImEnterView extends LinearLayout {
    private static int ahy;
    private TextView aGt;
    private TbImageView brh;
    private ObjectAnimator bri;
    private int brj;
    private boolean brk;

    public ALAImEnterView(Context context) {
        super(context);
        this.brk = false;
        init();
    }

    public void A(b bVar) {
        if (!e.FQ().FM() && !e.FQ().hasMsg() && !this.brk) {
            e.FQ().j(bVar);
            Oh();
            return;
        }
        e.FQ().j(bVar);
    }

    public void LI() {
        Of();
    }

    public void release() {
        this.brk = false;
        e.FQ().release();
        setVisibility(4);
        if (this.bri != null) {
            this.bri.cancel();
        }
        if (this.brh != null) {
            this.brh.stopLoad();
        }
        Og();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.brh != null) {
            this.brh.stopLoad();
        }
    }

    private void init() {
        Oe();
        initView();
        setVisibility(4);
        ahy = BdUtilHelper.getEquipmentWidth(getContext());
        this.brj = getResources().getDimensionPixelOffset(a.d.sdk_ds32);
    }

    private void Oe() {
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
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_im_enter, (ViewGroup) this, true);
        this.brh = (TbImageView) findViewById(a.f.iv_icon);
        this.aGt = (TextView) findViewById(a.f.tv_content);
        this.brh.setDefaultBgResource(a.e.sdk_shape_transparent);
    }

    private void Of() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501062, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.fe(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Og() {
        MessageManager.getInstance().unRegisterTask(2501062);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(int i) {
        if (i == 0) {
            Oi();
        } else if (i == 1) {
            Oh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        b FN = e.FQ().FN();
        if (FN != null) {
            com.baidu.live.data.a Nw = FN.Nw();
            if (Nw == null) {
                Oh();
                return;
            }
            c i = com.baidu.live.entereffect.a.FB().i(FN);
            if (i == null) {
                Oh();
            } else if (!a(Nw, i)) {
                b(Nw, i);
                setVisibility(0);
                Oj();
            }
        }
    }

    private void Oi() {
        b FO = e.FQ().FO();
        if (FO == null) {
            Oh();
            return;
        }
        com.baidu.live.data.a Nw = FO.Nw();
        if (Nw == null) {
            Oh();
            return;
        }
        c i = com.baidu.live.entereffect.a.FB().i(FO);
        if (i == null) {
            Oh();
            return;
        }
        b(Nw, i);
        setVisibility(0);
        Oj();
    }

    private boolean a(com.baidu.live.data.a aVar, c cVar) {
        String str = cVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a gu = com.baidu.live.entereffect.a.FB().gu(str);
        if (gu != null) {
            aj.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, gu.priority == 1, cVar.msgId, cVar.aWj);
            return true;
        }
        com.baidu.live.entereffect.a.FB().s(str, cVar.aWi);
        return false;
    }

    private void b(com.baidu.live.data.a aVar, c cVar) {
        setBackground(cVar);
        a(cVar);
        c(aVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBackground(c cVar) {
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
                String str = cVar.aVZ;
                String str2 = cVar.aWa;
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
                    String str3 = cVar.aWb;
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
                    String str4 = cVar.aWc;
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

    private void a(c cVar) {
        if (this.brh != null) {
            this.brh.stopLoad();
            if (!TextUtils.isEmpty(cVar.iconUrl) && cVar.aWg > 0 && cVar.aWh > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brh.getLayoutParams();
                layoutParams.height = this.brj;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / cVar.aWh) * cVar.aWg);
                this.brh.setLayoutParams(layoutParams);
                this.brh.startLoad(cVar.iconUrl, 10, false, false);
                this.brh.setVisibility(0);
                return;
            }
            this.brh.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, c cVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = cVar.aWe;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(cVar.aWe);
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
        if (!TextUtils.isEmpty(cVar.aWf)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(cVar.aWf);
        }
        this.aGt.setText(sb.toString());
        try {
            parseColor = Color.parseColor(cVar.aWd);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aGt.setTextColor(parseColor);
    }

    private void Oj() {
        this.brk = true;
        this.bri = ObjectAnimator.ofFloat(this, "TranslationX", ahy, -ahy);
        this.bri.setDuration(4600L);
        this.bri.setEvaluator(new a());
        this.bri.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.bri.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.brk = false;
                ALAImEnterView.this.Oh();
            }
        });
        this.bri.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.ahy) + (-ALAImEnterView.ahy);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.ahy)) + ALAImEnterView.ahy);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
