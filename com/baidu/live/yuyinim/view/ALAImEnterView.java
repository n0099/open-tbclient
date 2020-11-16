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
import com.baidu.live.entereffect.b.e;
import com.baidu.live.gift.ah;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class ALAImEnterView extends LinearLayout {
    private static int ais;
    private TextView aDw;
    private TbImageView bkq;
    private ObjectAnimator bkr;
    private int bks;
    private boolean bkt;

    public ALAImEnterView(Context context) {
        super(context);
        this.bkt = false;
        init();
    }

    public void x(com.baidu.live.im.data.a aVar) {
        if (!e.EM().EI() && !e.EM().hasMsg() && !this.bkt) {
            e.EM().j(aVar);
            Mg();
            return;
        }
        e.EM().j(aVar);
    }

    public void Kj() {
        Me();
    }

    public void release() {
        this.bkt = false;
        e.EM().release();
        setVisibility(4);
        if (this.bkr != null) {
            this.bkr.cancel();
        }
        if (this.bkq != null) {
            this.bkq.stopLoad();
        }
        Mf();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.bkq != null) {
            this.bkq.stopLoad();
        }
    }

    private void init() {
        Md();
        initView();
        setVisibility(4);
        ais = BdUtilHelper.getEquipmentWidth(getContext());
        this.bks = getResources().getDimensionPixelOffset(a.d.sdk_ds32);
    }

    private void Md() {
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
        this.bkq = (TbImageView) findViewById(a.f.iv_icon);
        this.aDw = (TextView) findViewById(a.f.tv_content);
        this.bkq.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.bkq.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void Me() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501062, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.eJ(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Mf() {
        MessageManager.getInstance().unRegisterTask(2501062);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        if (i == 0) {
            Mh();
        } else if (i == 1) {
            Mg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mg() {
        com.baidu.live.im.data.a EJ = e.EM().EJ();
        if (EJ != null) {
            com.baidu.live.data.a LF = EJ.LF();
            if (LF == null) {
                Mg();
                return;
            }
            c i = com.baidu.live.entereffect.a.Ex().i(EJ);
            if (i == null) {
                Mg();
            } else if (!a(LF, i)) {
                b(LF, i);
                setVisibility(0);
                Mi();
            }
        }
    }

    private void Mh() {
        com.baidu.live.im.data.a EK = e.EM().EK();
        if (EK == null) {
            Mg();
            return;
        }
        com.baidu.live.data.a LF = EK.LF();
        if (LF == null) {
            Mg();
            return;
        }
        c i = com.baidu.live.entereffect.a.Ex().i(EK);
        if (i == null) {
            Mg();
            return;
        }
        b(LF, i);
        setVisibility(0);
        Mi();
    }

    private boolean a(com.baidu.live.data.a aVar, c cVar) {
        String str = cVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a go = com.baidu.live.entereffect.a.Ex().go(str);
        if (go != null) {
            ah.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, go.priority == 1, cVar.msgId, cVar.aRP);
            return true;
        }
        com.baidu.live.entereffect.a.Ex().r(str, cVar.aRO);
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
                String str = cVar.aRF;
                String str2 = cVar.aRG;
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
                    String str3 = cVar.aRH;
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
                    String str4 = cVar.aRI;
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
        if (this.bkq != null) {
            this.bkq.stopLoad();
            if (!TextUtils.isEmpty(cVar.iconUrl) && cVar.aRM > 0 && cVar.aRN > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkq.getLayoutParams();
                layoutParams.height = this.bks;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / cVar.aRN) * cVar.aRM);
                this.bkq.setLayoutParams(layoutParams);
                this.bkq.startLoad(cVar.iconUrl, 10, false, false);
                this.bkq.setVisibility(0);
                return;
            }
            this.bkq.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, c cVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = cVar.aRK;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(cVar.aRK);
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
        if (!TextUtils.isEmpty(cVar.aRL)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(cVar.aRL);
        }
        this.aDw.setText(sb.toString());
        try {
            parseColor = Color.parseColor(cVar.aRJ);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aDw.setTextColor(parseColor);
    }

    private void Mi() {
        this.bkt = true;
        this.bkr = ObjectAnimator.ofFloat(this, "TranslationX", ais, -ais);
        this.bkr.setDuration(4600L);
        this.bkr.setEvaluator(new a());
        this.bkr.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.bkr.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.bkt = false;
                ALAImEnterView.this.Mg();
            }
        });
        this.bkr.start();
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.ais) + (-ALAImEnterView.ais);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.ais)) + ALAImEnterView.ais);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
