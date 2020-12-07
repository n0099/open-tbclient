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
import com.baidu.live.entereffect.a.c;
import com.baidu.live.entereffect.b.d;
import com.baidu.live.gift.ac;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class ALAImEnterView extends LinearLayout {
    private static int ajr;
    private TextView aGc;
    private ObjectAnimator bpA;
    private int bpB;
    private boolean bpC;
    private TbImageView bpz;

    public ALAImEnterView(Context context) {
        super(context);
        this.bpC = false;
        init();
    }

    public void y(com.baidu.live.im.data.b bVar) {
        if (!d.Gs().Gt() && !d.Gs().hasMsg() && !this.bpC) {
            d.Gs().j(bVar);
            OB();
            return;
        }
        d.Gs().j(bVar);
    }

    public void Ml() {
        Oz();
    }

    public void release() {
        this.bpC = false;
        d.Gs().release();
        setVisibility(4);
        if (this.bpA != null) {
            this.bpA.cancel();
        }
        if (this.bpz != null) {
            this.bpz.stopLoad();
        }
        OA();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.bpz != null) {
            this.bpz.stopLoad();
        }
    }

    private void init() {
        Oy();
        initView();
        setVisibility(4);
        ajr = BdUtilHelper.getEquipmentWidth(getContext());
        this.bpB = getResources().getDimensionPixelOffset(a.d.sdk_ds32);
    }

    private void Oy() {
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
        this.bpz = (TbImageView) findViewById(a.f.iv_icon);
        this.aGc = (TextView) findViewById(a.f.tv_content);
        this.bpz.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.bpz.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void Oz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.fg(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void OA() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(int i) {
        if (i == 0) {
            OC();
        } else if (i == 1) {
            OB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OB() {
        com.baidu.live.im.data.b Gu = d.Gs().Gu();
        if (Gu != null) {
            com.baidu.live.data.a NU = Gu.NU();
            if (NU == null) {
                OB();
                return;
            }
            c i = com.baidu.live.entereffect.a.Gi().i(Gu);
            if (i == null) {
                OB();
            } else if (!a(NU, i)) {
                b(NU, i);
                setVisibility(0);
                OD();
            }
        }
    }

    private void OC() {
        com.baidu.live.im.data.b Gv = d.Gs().Gv();
        if (Gv == null) {
            OB();
            return;
        }
        com.baidu.live.data.a NU = Gv.NU();
        if (NU == null) {
            OB();
            return;
        }
        c i = com.baidu.live.entereffect.a.Gi().i(Gv);
        if (i == null) {
            OB();
            return;
        }
        b(NU, i);
        setVisibility(0);
        OD();
    }

    private boolean a(com.baidu.live.data.a aVar, c cVar) {
        String str = cVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a gK = com.baidu.live.entereffect.a.Gi().gK(str);
        if (gK != null) {
            ac.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, gK.priority == 1, cVar.msgId);
            return true;
        }
        com.baidu.live.entereffect.a.Gi().s(str, cVar.aUQ);
        return false;
    }

    private void b(com.baidu.live.data.a aVar, c cVar) {
        setBackground(cVar);
        a(cVar);
        c(aVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
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
        int i6 = -1;
        if (Build.VERSION.SDK_INT >= 16) {
            Drawable background = getBackground();
            if (background instanceof GradientDrawable) {
                String str = cVar.aUH;
                String str2 = cVar.aUI;
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
                    String str3 = cVar.aUJ;
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
                    String str4 = cVar.aUK;
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

    private void a(c cVar) {
        if (this.bpz != null) {
            this.bpz.stopLoad();
            if (!TextUtils.isEmpty(cVar.iconUrl) && cVar.aUO > 0 && cVar.aUP > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bpz.getLayoutParams();
                layoutParams.height = this.bpB;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / cVar.aUP) * cVar.aUO);
                this.bpz.setLayoutParams(layoutParams);
                this.bpz.startLoad(cVar.iconUrl, 10, false, false);
                this.bpz.setVisibility(0);
                return;
            }
            this.bpz.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, c cVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = cVar.aUM;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(cVar.aUM);
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
        if (!TextUtils.isEmpty(cVar.aUN)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(cVar.aUN);
        }
        this.aGc.setText(sb.toString());
        try {
            parseColor = Color.parseColor(cVar.aUL);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aGc.setTextColor(parseColor);
    }

    private void OD() {
        this.bpC = true;
        this.bpA = ObjectAnimator.ofFloat(this, "TranslationX", ajr, -ajr);
        this.bpA.setDuration(4600L);
        this.bpA.setEvaluator(new a());
        this.bpA.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.bpA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.bpC = false;
                ALAImEnterView.this.OB();
            }
        });
        this.bpA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.ajr) + (-ALAImEnterView.ajr);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.ajr)) + ALAImEnterView.ajr);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
