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
    private static int MC;
    private TbImageView atW;
    private TextView atX;
    private ObjectAnimator atY;
    private int atZ;
    private boolean aua;

    public ALAImEnterView(Context context) {
        super(context);
        this.aua = false;
        init();
    }

    public void r(com.baidu.live.im.data.a aVar) {
        if (!d.ra().rb() && !d.ra().hasMsg() && !this.aua) {
            d.ra().c(aVar);
            xE();
            return;
        }
        d.ra().c(aVar);
    }

    public void wL() {
        xC();
    }

    public void release() {
        this.aua = false;
        d.ra().release();
        setVisibility(4);
        if (this.atY != null) {
            this.atY.cancel();
        }
        if (this.atW != null) {
            this.atW.stopLoad();
        }
        xD();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.atW != null) {
            this.atW.stopLoad();
        }
    }

    private void init() {
        xB();
        initView();
        setVisibility(4);
        MC = BdUtilHelper.getEquipmentWidth(getContext());
        this.atZ = getResources().getDimensionPixelOffset(a.e.sdk_ds28);
    }

    private void xB() {
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
        this.atW = (TbImageView) findViewById(a.g.iv_icon);
        this.atX = (TextView) findViewById(a.g.tv_content);
        this.atW.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.atW.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void xC() {
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

    private void xD() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(int i) {
        if (i == 0) {
            xF();
        } else if (i == 1) {
            xE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE() {
        com.baidu.live.im.data.a rc = d.ra().rc();
        if (rc != null) {
            com.baidu.live.data.a xo = rc.xo();
            if (xo == null) {
                xE();
                return;
            }
            b b = com.baidu.live.entereffect.a.qR().b(rc);
            if (b == null) {
                xE();
            } else if (!a(xo, b)) {
                b(xo, b);
                setVisibility(0);
                xG();
            }
        }
    }

    private void xF() {
        com.baidu.live.im.data.a rd = d.ra().rd();
        if (rd == null) {
            xE();
            return;
        }
        com.baidu.live.data.a xo = rd.xo();
        if (xo == null) {
            xE();
            return;
        }
        b b = com.baidu.live.entereffect.a.qR().b(rd);
        if (b == null) {
            xE();
            return;
        }
        b(xo, b);
        setVisibility(0);
        xG();
    }

    private boolean a(com.baidu.live.data.a aVar, b bVar) {
        String str = bVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a da = com.baidu.live.entereffect.a.qR().da(str);
        if (da != null) {
            t.b(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, da.priority == 1);
            return true;
        }
        com.baidu.live.entereffect.a.qR().db(str);
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
                String str = bVar.afi;
                String str2 = bVar.afj;
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
                    String str3 = bVar.afk;
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
                    String str4 = bVar.afl;
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
        if (this.atW != null) {
            this.atW.stopLoad();
            if (!TextUtils.isEmpty(bVar.iconUrl) && bVar.afo > 0 && bVar.afp > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.atW.getLayoutParams();
                layoutParams.height = this.atZ;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / bVar.afp) * bVar.afo);
                this.atW.setLayoutParams(layoutParams);
                this.atW.startLoad(bVar.iconUrl, 10, false, false);
                this.atW.setVisibility(0);
                return;
            }
            this.atW.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, b bVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(bVar.afm)) {
            sb.append(bVar.afm);
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
        if (!TextUtils.isEmpty(bVar.afn)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(bVar.afn);
        }
        this.atX.setText(sb.toString());
        try {
            parseColor = Color.parseColor(bVar.acA);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.atX.setTextColor(parseColor);
    }

    private void xG() {
        this.aua = true;
        this.atY = ObjectAnimator.ofFloat(this, "TranslationX", MC, -MC);
        this.atY.setDuration(4600L);
        this.atY.setEvaluator(new a());
        this.atY.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.atY.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.aua = false;
                ALAImEnterView.this.xE();
            }
        });
        this.atY.start();
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.MC) + (-ALAImEnterView.MC);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.MC)) + ALAImEnterView.MC);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
