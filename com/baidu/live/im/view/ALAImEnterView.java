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
/* loaded from: classes4.dex */
public class ALAImEnterView extends LinearLayout {
    private static int ags;
    private TbImageView aXu;
    private ObjectAnimator aXv;
    private int aXw;
    private boolean aXx;
    private TextView avu;

    public ALAImEnterView(Context context) {
        super(context);
        this.aXx = false;
        init();
    }

    public void v(com.baidu.live.im.data.a aVar) {
        if (!d.xL().xM() && !d.xL().hasMsg() && !this.aXx) {
            d.xL().j(aVar);
            EE();
            return;
        }
        d.xL().j(aVar);
    }

    public void DR() {
        EC();
    }

    public void release() {
        this.aXx = false;
        d.xL().release();
        setVisibility(4);
        if (this.aXv != null) {
            this.aXv.cancel();
        }
        if (this.aXu != null) {
            this.aXu.stopLoad();
        }
        ED();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.aXu != null) {
            this.aXu.stopLoad();
        }
    }

    private void init() {
        EB();
        initView();
        setVisibility(4);
        ags = BdUtilHelper.getEquipmentWidth(getContext());
        this.aXw = getResources().getDimensionPixelOffset(a.e.sdk_ds32);
    }

    private void EB() {
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
        this.aXu = (TbImageView) findViewById(a.g.iv_icon);
        this.avu = (TextView) findViewById(a.g.tv_content);
        this.aXu.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aXu.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void EC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.cH(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void ED() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(int i) {
        if (i == 0) {
            EF();
        } else if (i == 1) {
            EE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EE() {
        com.baidu.live.im.data.a xN = d.xL().xN();
        if (xN != null) {
            com.baidu.live.data.a Eh = xN.Eh();
            if (Eh == null) {
                EE();
                return;
            }
            b i = com.baidu.live.entereffect.a.xD().i(xN);
            if (i == null) {
                EE();
            } else if (!a(Eh, i)) {
                b(Eh, i);
                setVisibility(0);
                EG();
            }
        }
    }

    private void EF() {
        com.baidu.live.im.data.a xO = d.xL().xO();
        if (xO == null) {
            EE();
            return;
        }
        com.baidu.live.data.a Eh = xO.Eh();
        if (Eh == null) {
            EE();
            return;
        }
        b i = com.baidu.live.entereffect.a.xD().i(xO);
        if (i == null) {
            EE();
            return;
        }
        b(Eh, i);
        setVisibility(0);
        EG();
    }

    private boolean a(com.baidu.live.data.a aVar, b bVar) {
        String str = bVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a eA = com.baidu.live.entereffect.a.xD().eA(str);
        if (eA != null) {
            v.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, eA.priority == 1, bVar.msgId);
            return true;
        }
        com.baidu.live.entereffect.a.xD().eB(str);
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
                String str = bVar.aGS;
                String str2 = bVar.aGT;
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
                    String str3 = bVar.aGU;
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
                    String str4 = bVar.aGV;
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
        if (this.aXu != null) {
            this.aXu.stopLoad();
            if (!TextUtils.isEmpty(bVar.iconUrl) && bVar.aGY > 0 && bVar.aGZ > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXu.getLayoutParams();
                layoutParams.height = this.aXw;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / bVar.aGZ) * bVar.aGY);
                this.aXu.setLayoutParams(layoutParams);
                this.aXu.startLoad(bVar.iconUrl, 10, false, false);
                this.aXu.setVisibility(0);
                return;
            }
            this.aXu.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, b bVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = bVar.aGW;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(bVar.aGW);
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
        if (!TextUtils.isEmpty(bVar.aGX)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(bVar.aGX);
        }
        this.avu.setText(sb.toString());
        try {
            parseColor = Color.parseColor(bVar.aDW);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.avu.setTextColor(parseColor);
    }

    private void EG() {
        this.aXx = true;
        this.aXv = ObjectAnimator.ofFloat(this, "TranslationX", ags, -ags);
        this.aXv.setDuration(4600L);
        this.aXv.setEvaluator(new a());
        this.aXv.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.aXv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.aXx = false;
                ALAImEnterView.this.EE();
            }
        });
        this.aXv.start();
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.ags) + (-ALAImEnterView.ags);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.ags)) + ALAImEnterView.ags);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
