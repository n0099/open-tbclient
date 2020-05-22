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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class ALAImEnterView extends LinearLayout {
    private static int afQ;
    private TbImageView aTT;
    private TextView aTU;
    private ObjectAnimator aTV;
    private int aTW;
    private boolean aTX;

    public ALAImEnterView(Context context) {
        super(context);
        this.aTX = false;
        init();
    }

    public void v(com.baidu.live.im.data.a aVar) {
        if (!d.wL().wM() && !d.wL().hasMsg() && !this.aTX) {
            d.wL().c(aVar);
            DV();
            return;
        }
        d.wL().c(aVar);
    }

    public void CX() {
        DT();
    }

    public void release() {
        this.aTX = false;
        d.wL().release();
        setVisibility(4);
        if (this.aTV != null) {
            this.aTV.cancel();
        }
        if (this.aTT != null) {
            this.aTT.stopLoad();
        }
        DU();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.aTT != null) {
            this.aTT.stopLoad();
        }
    }

    private void init() {
        DS();
        initView();
        setVisibility(4);
        afQ = BdUtilHelper.getEquipmentWidth(getContext());
        this.aTW = getResources().getDimensionPixelOffset(a.e.sdk_ds32);
    }

    private void DS() {
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
        this.aTT = (TbImageView) findViewById(a.g.iv_icon);
        this.aTU = (TextView) findViewById(a.g.tv_content);
        this.aTT.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aTT.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void DT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913109, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.im.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.cu(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void DU() {
        MessageManager.getInstance().unRegisterTask(2913109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i) {
        if (i == 0) {
            DW();
        } else if (i == 1) {
            DV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DV() {
        com.baidu.live.im.data.a wN = d.wL().wN();
        if (wN != null) {
            com.baidu.live.data.a DB = wN.DB();
            if (DB == null) {
                DV();
                return;
            }
            b b = com.baidu.live.entereffect.a.wD().b(wN);
            if (b == null) {
                DV();
            } else if (!a(DB, b)) {
                b(DB, b);
                setVisibility(0);
                DX();
            }
        }
    }

    private void DW() {
        com.baidu.live.im.data.a wO = d.wL().wO();
        if (wO == null) {
            DV();
            return;
        }
        com.baidu.live.data.a DB = wO.DB();
        if (DB == null) {
            DV();
            return;
        }
        b b = com.baidu.live.entereffect.a.wD().b(wO);
        if (b == null) {
            DV();
            return;
        }
        b(DB, b);
        setVisibility(0);
        DX();
    }

    private boolean a(com.baidu.live.data.a aVar, b bVar) {
        String str = bVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a ew = com.baidu.live.entereffect.a.wD().ew(str);
        if (ew != null) {
            v.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, ew.priority == 1, bVar.msgId);
            return true;
        }
        com.baidu.live.entereffect.a.wD().ex(str);
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
                String str = bVar.aDf;
                String str2 = bVar.aDg;
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
                    String str3 = bVar.aDh;
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
                    String str4 = bVar.aDi;
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
        if (this.aTT != null) {
            this.aTT.stopLoad();
            if (!TextUtils.isEmpty(bVar.iconUrl) && bVar.aDl > 0 && bVar.aDm > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aTT.getLayoutParams();
                layoutParams.height = this.aTW;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / bVar.aDm) * bVar.aDl);
                this.aTT.setLayoutParams(layoutParams);
                this.aTT.startLoad(bVar.iconUrl, 10, false, false);
                this.aTT.setVisibility(0);
                return;
            }
            this.aTT.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, b bVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = bVar.aDj;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(bVar.aDj);
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
        if (!TextUtils.isEmpty(bVar.aDk)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(bVar.aDk);
        }
        this.aTU.setText(sb.toString());
        try {
            parseColor = Color.parseColor(bVar.aAq);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aTU.setTextColor(parseColor);
    }

    private void DX() {
        this.aTX = true;
        this.aTV = ObjectAnimator.ofFloat(this, "TranslationX", afQ, -afQ);
        this.aTV.setDuration(4600L);
        this.aTV.setEvaluator(new a());
        this.aTV.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.im.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.aTV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.aTX = false;
                ALAImEnterView.this.DV();
            }
        });
        this.aTV.start();
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.afQ) + (-ALAImEnterView.afQ);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.afQ)) + ALAImEnterView.afQ);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
