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
/* loaded from: classes11.dex */
public class ALAImEnterView extends LinearLayout {
    private static int agw;
    private TextView aDt;
    private TbImageView bpW;
    private ObjectAnimator bpX;
    private int bpY;
    private boolean bpZ;

    public ALAImEnterView(Context context) {
        super(context);
        this.bpZ = false;
        init();
    }

    public void G(com.baidu.live.im.data.b bVar) {
        if (!d.Df().Dg() && !d.Df().hasMsg() && !this.bpZ) {
            d.Df().j(bVar);
            LL();
            return;
        }
        d.Df().j(bVar);
    }

    public void Jg() {
        LJ();
    }

    public void release() {
        this.bpZ = false;
        d.Df().release();
        setVisibility(4);
        if (this.bpX != null) {
            this.bpX.cancel();
        }
        if (this.bpW != null) {
            this.bpW.stopLoad();
        }
        LK();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.bpW != null) {
            this.bpW.stopLoad();
        }
    }

    private void init() {
        LI();
        initView();
        setVisibility(4);
        agw = BdUtilHelper.getEquipmentWidth(getContext());
        this.bpY = getResources().getDimensionPixelOffset(a.d.sdk_ds32);
    }

    private void LI() {
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
        this.bpW = (TbImageView) findViewById(a.f.iv_icon);
        this.aDt = (TextView) findViewById(a.f.tv_content);
        this.bpW.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.bpW.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void LJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.dE(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void LK() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(int i) {
        if (i == 0) {
            LM();
        } else if (i == 1) {
            LL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LL() {
        com.baidu.live.im.data.b Dh = d.Df().Dh();
        if (Dh != null) {
            com.baidu.live.data.a KZ = Dh.KZ();
            if (KZ == null) {
                LL();
                return;
            }
            com.baidu.live.entereffect.a.c i = com.baidu.live.entereffect.a.CV().i(Dh);
            if (i == null) {
                LL();
            } else if (!a(KZ, i)) {
                b(KZ, i);
                setVisibility(0);
                LN();
            }
        }
    }

    private void LM() {
        com.baidu.live.im.data.b Di = d.Df().Di();
        if (Di == null) {
            LL();
            return;
        }
        com.baidu.live.data.a KZ = Di.KZ();
        if (KZ == null) {
            LL();
            return;
        }
        com.baidu.live.entereffect.a.c i = com.baidu.live.entereffect.a.CV().i(Di);
        if (i == null) {
            LL();
            return;
        }
        b(KZ, i);
        setVisibility(0);
        LN();
    }

    private boolean a(com.baidu.live.data.a aVar, com.baidu.live.entereffect.a.c cVar) {
        String str = cVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a fD = com.baidu.live.entereffect.a.CV().fD(str);
        if (fD != null) {
            ac.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, fD.priority == 1, cVar.msgId);
            return true;
        }
        com.baidu.live.entereffect.a.CV().s(str, cVar.aUz);
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
                String str = cVar.aUr;
                String str2 = cVar.aUs;
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
                    String str3 = cVar.aUt;
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
                    String str4 = cVar.aUu;
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
        if (this.bpW != null) {
            this.bpW.stopLoad();
            if (!TextUtils.isEmpty(cVar.iconUrl) && cVar.aUx > 0 && cVar.aUy > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bpW.getLayoutParams();
                layoutParams.height = this.bpY;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / cVar.aUy) * cVar.aUx);
                this.bpW.setLayoutParams(layoutParams);
                this.bpW.startLoad(cVar.iconUrl, 10, false, false);
                this.bpW.setVisibility(0);
                return;
            }
            this.bpW.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, com.baidu.live.entereffect.a.c cVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = cVar.aUv;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(cVar.aUv);
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
        if (!TextUtils.isEmpty(cVar.aUw)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(cVar.aUw);
        }
        this.aDt.setText(sb.toString());
        try {
            parseColor = Color.parseColor(cVar.aGI);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aDt.setTextColor(parseColor);
    }

    private void LN() {
        this.bpZ = true;
        if (this.bpX != null) {
            this.bpX.cancel();
            this.bpX.removeAllListeners();
            this.bpX.removeAllUpdateListeners();
            this.bpX.setInterpolator(null);
        }
        this.bpX = ObjectAnimator.ofFloat(this, "TranslationX", agw, -agw);
        this.bpX.setDuration(4600L);
        this.bpX.setEvaluator(new a());
        this.bpX.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.bpX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.bpZ = false;
                ALAImEnterView.this.LL();
            }
        });
        this.bpX.start();
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.agw) + (-ALAImEnterView.agw);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.agw)) + ALAImEnterView.agw);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
