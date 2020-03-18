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
import com.baidu.live.gift.t;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class ALAImEnterView extends LinearLayout {
    private static int ME;
    private TbImageView auh;
    private TextView aui;
    private ObjectAnimator auj;
    private int auk;
    private boolean aul;

    public ALAImEnterView(Context context) {
        super(context);
        this.aul = false;
        init();
    }

    public void r(com.baidu.live.im.data.a aVar) {
        if (!d.rf().rg() && !d.rf().hasMsg() && !this.aul) {
            d.rf().c(aVar);
            xJ();
            return;
        }
        d.rf().c(aVar);
    }

    public void wQ() {
        xH();
    }

    public void release() {
        this.aul = false;
        d.rf().release();
        setVisibility(4);
        if (this.auj != null) {
            this.auj.cancel();
        }
        if (this.auh != null) {
            this.auh.stopLoad();
        }
        xI();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.auh != null) {
            this.auh.stopLoad();
        }
    }

    private void init() {
        xG();
        initView();
        setVisibility(4);
        ME = BdUtilHelper.getEquipmentWidth(getContext());
        this.auk = getResources().getDimensionPixelOffset(a.e.sdk_ds28);
    }

    private void xG() {
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
        this.auh = (TbImageView) findViewById(a.g.iv_icon);
        this.aui = (TextView) findViewById(a.g.tv_content);
        this.auh.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.auh.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void xH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.bY(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void xI() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(int i) {
        if (i == 0) {
            xK();
        } else if (i == 1) {
            xJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xJ() {
        com.baidu.live.im.data.a rh = d.rf().rh();
        if (rh != null) {
            com.baidu.live.data.a xt = rh.xt();
            if (xt == null) {
                xJ();
                return;
            }
            b b = com.baidu.live.entereffect.a.qW().b(rh);
            if (b == null) {
                xJ();
            } else if (!a(xt, b)) {
                b(xt, b);
                setVisibility(0);
                xL();
            }
        }
    }

    private void xK() {
        com.baidu.live.im.data.a ri = d.rf().ri();
        if (ri == null) {
            xJ();
            return;
        }
        com.baidu.live.data.a xt = ri.xt();
        if (xt == null) {
            xJ();
            return;
        }
        b b = com.baidu.live.entereffect.a.qW().b(ri);
        if (b == null) {
            xJ();
            return;
        }
        b(xt, b);
        setVisibility(0);
        xL();
    }

    private boolean a(com.baidu.live.data.a aVar, b bVar) {
        String str = bVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a cZ = com.baidu.live.entereffect.a.qW().cZ(str);
        if (cZ != null) {
            t.b(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, cZ.priority == 1);
            return true;
        }
        com.baidu.live.entereffect.a.qW().da(str);
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
                String str = bVar.afs;
                String str2 = bVar.aft;
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
                    String str3 = bVar.afu;
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
                    String str4 = bVar.afv;
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
        if (this.auh != null) {
            this.auh.stopLoad();
            if (!TextUtils.isEmpty(bVar.iconUrl) && bVar.afy > 0 && bVar.afz > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auh.getLayoutParams();
                layoutParams.height = this.auk;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / bVar.afz) * bVar.afy);
                this.auh.setLayoutParams(layoutParams);
                this.auh.startLoad(bVar.iconUrl, 10, false, false);
                this.auh.setVisibility(0);
                return;
            }
            this.auh.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, b bVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(bVar.afw)) {
            sb.append(bVar.afw);
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
        if (!TextUtils.isEmpty(bVar.afx)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(bVar.afx);
        }
        this.aui.setText(sb.toString());
        try {
            parseColor = Color.parseColor(bVar.acK);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aui.setTextColor(parseColor);
    }

    private void xL() {
        this.aul = true;
        this.auj = ObjectAnimator.ofFloat(this, "TranslationX", ME, -ME);
        this.auj.setDuration(4600L);
        this.auj.setEvaluator(new a());
        this.auj.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.auj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.aul = false;
                ALAImEnterView.this.xJ();
            }
        });
        this.auj.start();
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.ME) + (-ALAImEnterView.ME);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.ME)) + ALAImEnterView.ME);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
