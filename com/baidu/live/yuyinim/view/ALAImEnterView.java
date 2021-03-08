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
/* loaded from: classes10.dex */
public class ALAImEnterView extends LinearLayout {
    private static int ahO;
    private TextView aET;
    private TbImageView brw;
    private ObjectAnimator brx;
    private int bry;
    private boolean brz;

    public ALAImEnterView(Context context) {
        super(context);
        this.brz = false;
        init();
    }

    public void G(b bVar) {
        if (!e.Dn().Dj() && !e.Dn().hasMsg() && !this.brz) {
            e.Dn().j(bVar);
            LO();
            return;
        }
        e.Dn().j(bVar);
    }

    public void Jj() {
        LM();
    }

    public void release() {
        this.brz = false;
        e.Dn().release();
        setVisibility(4);
        if (this.brx != null) {
            this.brx.cancel();
        }
        if (this.brw != null) {
            this.brw.stopLoad();
        }
        LN();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.brw != null) {
            this.brw.stopLoad();
        }
    }

    private void init() {
        LL();
        initView();
        setVisibility(4);
        ahO = BdUtilHelper.getEquipmentWidth(getContext());
        this.bry = getResources().getDimensionPixelOffset(a.d.sdk_ds32);
    }

    private void LL() {
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
        this.brw = (TbImageView) findViewById(a.f.iv_icon);
        this.aET = (TextView) findViewById(a.f.tv_content);
        this.brw.setDefaultBgResource(a.e.sdk_shape_transparent);
    }

    private void LM() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501062, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ALAImEnterView.this.dF(customMessage.getData().intValue());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void LN() {
        MessageManager.getInstance().unRegisterTask(2501062);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(int i) {
        if (i == 0) {
            LP();
        } else if (i == 1) {
            LO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LO() {
        b Dk = e.Dn().Dk();
        if (Dk != null) {
            com.baidu.live.data.a Lc = Dk.Lc();
            if (Lc == null) {
                LO();
                return;
            }
            c i = com.baidu.live.entereffect.a.CY().i(Dk);
            if (i == null) {
                LO();
            } else if (!a(Lc, i)) {
                b(Lc, i);
                setVisibility(0);
                LQ();
            }
        }
    }

    private void LP() {
        b Dl = e.Dn().Dl();
        if (Dl == null) {
            LO();
            return;
        }
        com.baidu.live.data.a Lc = Dl.Lc();
        if (Lc == null) {
            LO();
            return;
        }
        c i = com.baidu.live.entereffect.a.CY().i(Dl);
        if (i == null) {
            LO();
            return;
        }
        b(Lc, i);
        setVisibility(0);
        LQ();
    }

    private boolean a(com.baidu.live.data.a aVar, c cVar) {
        String str = cVar.id;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.live.entereffect.a.a fJ = com.baidu.live.entereffect.a.CY().fJ(str);
        if (fJ != null) {
            aj.c(str, 1L, "", "", aVar.userId, aVar.portrait, aVar.name_show, "", "", false, "", "", "", false, false, fJ.priority == 1, cVar.msgId, cVar.aWa);
            return true;
        }
        com.baidu.live.entereffect.a.CY().s(str, cVar.aVZ);
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
                String str = cVar.aVR;
                String str2 = cVar.aVS;
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
                    String str3 = cVar.aVT;
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
                    String str4 = cVar.aVU;
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
        if (this.brw != null) {
            this.brw.stopLoad();
            if (!TextUtils.isEmpty(cVar.iconUrl) && cVar.aVX > 0 && cVar.aVY > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brw.getLayoutParams();
                layoutParams.height = this.bry;
                layoutParams.width = (int) (((layoutParams.height * 1.0f) / cVar.aVY) * cVar.aVX);
                this.brw.setLayoutParams(layoutParams);
                this.brw.startLoad(cVar.iconUrl, 10, false, false);
                this.brw.setVisibility(0);
                return;
            }
            this.brw.setVisibility(8);
        }
    }

    private void c(com.baidu.live.data.a aVar, c cVar) {
        int parseColor;
        StringBuilder sb = new StringBuilder();
        String str = cVar.aVV;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.replace(" ", ""))) {
            sb.append(cVar.aVV);
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
        if (!TextUtils.isEmpty(cVar.aVW)) {
            if (sb.length() > 0) {
                sb.append("  ");
            }
            sb.append(cVar.aVW);
        }
        this.aET.setText(sb.toString());
        try {
            parseColor = Color.parseColor(cVar.aIi);
        } catch (Exception e) {
            parseColor = Color.parseColor("#FFFFFFFF");
        }
        this.aET.setTextColor(parseColor);
    }

    private void LQ() {
        this.brz = true;
        this.brx = ObjectAnimator.ofFloat(this, "TranslationX", ahO, -ahO);
        this.brx.setDuration(4600L);
        this.brx.setEvaluator(new a());
        this.brx.setInterpolator(new TimeInterpolator() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.brx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyinim.view.ALAImEnterView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ALAImEnterView.this.setVisibility(4);
                ALAImEnterView.this.brz = false;
                ALAImEnterView.this.LO();
            }
        });
        this.brx.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
                f2 = ((f3 / 300.0f) * ALAImEnterView.ahO) + (-ALAImEnterView.ahO);
            } else if (4600.0f - f3 <= 300.0f) {
                f2 = -((((4600.0f - f3) / 300.0f) * (-ALAImEnterView.ahO)) + ALAImEnterView.ahO);
            } else {
                f2 = 0.0f;
            }
            return Float.valueOf(f2);
        }
    }
}
