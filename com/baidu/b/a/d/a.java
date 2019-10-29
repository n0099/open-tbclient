package com.baidu.b.a.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.b.a.b.d;
import com.baidu.b.a.e.c;
import com.baidu.crius.CriusDisplay;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private ViewGroup Bg;
    private InterfaceC0041a MX;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> MV = new HashMap();
    private Map<String, View> MW = new HashMap();
    private boolean MY = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0041a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0041a interfaceC0041a) {
        this.MX = interfaceC0041a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.MY = true;
        } else {
            this.MY = a(aVar, this.criusData);
        }
        if (this.Bg == null || !this.MY) {
            this.Bg = new RelativeLayout(context);
            this.Bg.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.Bg, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.Bg;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.LC) || aVar.LC.equals(aVar2.LC)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.MT != null) {
                    if (aVar2.MT != null && aVar.MT.size() == aVar2.MT.size()) {
                        int size = aVar.MT.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.MT.get(i), aVar2.MT.get(i))) {
                                return false;
                            }
                        }
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void f(Context context, boolean z) {
        try {
            this.MY = true;
            a(context, this.criusData, this.Bg, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.Lz != null && view != null) {
            if (aVar.Lz.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.Lz.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.Lz.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.Lz.getLayoutWidth());
                }
            }
            if (aVar.Lz.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.Lz.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.Lz.getLayoutHeight());
                }
            }
            if (aVar.Lz.getLayoutX() > 0.0f) {
                view.setX(aVar.Lz.getLayoutX());
            }
            if (aVar.Lz.getLayoutY() > 0.0f) {
                view.setY(aVar.Lz.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.LC)) {
                a(aVar.LC, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.MT != null && aVar.MT.size() > 0) {
                for (int i = 0; i < aVar.MT.size(); i++) {
                    View view2 = null;
                    if (this.MY && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.MT.get(i).LC)) {
                            view2 = com.baidu.b.a.b.a.mG().I(context, aVar.MT.get(i).LC);
                            this.MV.put(aVar.MT.get(i).LC, view2);
                        } else if ("view".equalsIgnoreCase(aVar.MT.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.MT.get(i).type)) {
                            view2 = d.mH().J(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.MT.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.MT.get(i).type)) {
                            view2 = d.mH().J(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.MT.get(i).id)) {
                            this.MW.put(aVar.MT.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.MT.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.LD)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.LD)) {
                        if (a.this.MX != null) {
                            a.this.MX.b(aVar.LD, a.this.b(aVar));
                        } else {
                            c.K(context, aVar.LD);
                        }
                    }
                }
            });
        }
    }

    private void a(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if ((view instanceof TextView) && aVar != null && !TextUtils.isEmpty(aVar.text)) {
            if (aVar.maxLines > 0) {
                if (aVar.maxLines == 1) {
                    ((TextView) view).setSingleLine(true);
                } else {
                    ((TextView) view).setSingleLine(false);
                }
                ((TextView) view).setMaxLines(aVar.maxLines);
                ((TextView) view).setEllipsize(TextUtils.TruncateAt.END);
            }
            if (!z || TextUtils.isEmpty(aVar.MO)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.MI)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.bR(aVar.MI), com.baidu.b.a.e.a.bR(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.b.a.e.a.bR(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.MS)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.bR(aVar.MS), com.baidu.b.a.e.a.bR(aVar.MO)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.b.a.e.a.bR(aVar.MO));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.MC);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.LO > 0.0d ? com.baidu.b.a.c.a.a(aVar.LO, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.LP > 0.0d ? (float) aVar.LP : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.Lz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Lz.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.Lj = (float) aVar.borderRadius;
            aVar2.Lk = (float) aVar.Mw;
            aVar2.Ll = (float) aVar.Mx;
            aVar2.Lm = (float) aVar.My;
            aVar2.Ln = (float) aVar.Mz;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.bR(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.MO)) {
                aVar2.Lo = com.baidu.b.a.e.a.bR(aVar.MO);
            }
            aVar2.Lp = (float) aVar.fontSize;
            aVar2.Lq = aVar.Lq;
            com.baidu.b.a.b.a.mG().a(str, view, aVar2, z);
        }
    }

    private void a(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (context != null && aVar != null) {
            d(view, aVar, z);
            c(view, aVar, z);
            b(context, view, aVar, z);
            b(view, aVar, z);
            a(view, aVar);
            b(view, aVar);
            a(view, aVar, z);
        }
    }

    private void a(View view, com.baidu.b.a.c.a aVar) {
        if (aVar != null && "video".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.Lz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Lz.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Li = aVar.Li;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.Lz.getLayoutWidth();
            aVar2.height = (int) aVar.Lz.getLayoutHeight();
            d.mH().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.Lz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Lz.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Lj = (float) aVar.borderRadius;
            aVar2.Lk = (float) aVar.Mw;
            aVar2.Ll = (float) aVar.Mx;
            aVar2.Lm = (float) aVar.My;
            aVar2.Ln = (float) aVar.Mz;
            d.mH().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.MN < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.MN);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.MM)) {
                String str5 = aVar.borderColor;
                str = aVar.MH;
                str2 = str5;
            } else {
                String str6 = aVar.MM;
                str = aVar.MR;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.MK)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.MG;
            } else {
                str3 = aVar.MK;
                str4 = aVar.MQ;
            }
            if (aVar.Mv > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.bR(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.b.a.c.a.a(aVar.Mv, f), com.baidu.b.a.e.a.bR(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.Mw, f), b(aVar.My, f), b(aVar.Mz, f), b(aVar.Mx, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.bR(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.bR(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.b.a.c.a.a(aVar.Mv, f), com.baidu.b.a.e.a.bR(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.Mw, f), b(aVar.My, f), b(aVar.Mz, f), b(aVar.Mx, f)});
                        }
                        StateListDrawable stateListDrawable = new StateListDrawable();
                        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
                        stateListDrawable.addState(new int[]{-16842919}, gradientDrawable);
                        view.setBackgroundDrawable(stateListDrawable);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
                try {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    if (!TextUtils.isEmpty(str3)) {
                        gradientDrawable3.setColor(com.baidu.b.a.e.a.bR(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.b.a.c.a.a(aVar.Mv, f2), com.baidu.b.a.e.a.bR(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.Mw, f2), b(aVar.My, f2), b(aVar.Mz, f2), b(aVar.Mx, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.MK)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.MG)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.bR(aVar.MG));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.bR(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.b.a.e.a.bR(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.MQ)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.bR(aVar.MQ));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.bR(aVar.MK));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.b.a.e.a.bR(aVar.MK));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.MJ)) {
                if (!TextUtils.isEmpty(aVar.Mu)) {
                    d.mH().a(aVar.type, view, aVar.Mu, aVar.MF);
                    return;
                }
                return;
            }
            d.mH().a(aVar.type, view, aVar.MJ, aVar.MP);
        }
    }

    public View bP(String str) {
        return this.MV.get(str);
    }

    public View bQ(String str) {
        return this.MW.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.LE);
        hashMap.put("data-url-stat", aVar.LG);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.b.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
