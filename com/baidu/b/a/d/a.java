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
    private ViewGroup AE;
    private InterfaceC0041a Mw;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> Mu = new HashMap();
    private Map<String, View> Mv = new HashMap();
    private boolean Mx = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0041a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0041a interfaceC0041a) {
        this.Mw = interfaceC0041a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.Mx = true;
        } else {
            this.Mx = a(aVar, this.criusData);
        }
        if (this.AE == null || !this.Mx) {
            this.AE = new RelativeLayout(context);
            this.AE.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.AE, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.AE;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.Lc) || aVar.Lc.equals(aVar2.Lc)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.Ms != null) {
                    if (aVar2.Ms != null && aVar.Ms.size() == aVar2.Ms.size()) {
                        int size = aVar.Ms.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.Ms.get(i), aVar2.Ms.get(i))) {
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
            this.Mx = true;
            a(context, this.criusData, this.AE, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.KZ != null && view != null) {
            if (aVar.KZ.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.KZ.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.KZ.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.KZ.getLayoutWidth());
                }
            }
            if (aVar.KZ.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.KZ.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.KZ.getLayoutHeight());
                }
            }
            if (aVar.KZ.getLayoutX() > 0.0f) {
                view.setX(aVar.KZ.getLayoutX());
            }
            if (aVar.KZ.getLayoutY() > 0.0f) {
                view.setY(aVar.KZ.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.Lc)) {
                a(aVar.Lc, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.Ms != null && aVar.Ms.size() > 0) {
                for (int i = 0; i < aVar.Ms.size(); i++) {
                    View view2 = null;
                    if (this.Mx && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.Ms.get(i).Lc)) {
                            view2 = com.baidu.b.a.b.a.mG().I(context, aVar.Ms.get(i).Lc);
                            this.Mu.put(aVar.Ms.get(i).Lc, view2);
                        } else if ("view".equalsIgnoreCase(aVar.Ms.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.Ms.get(i).type)) {
                            view2 = d.mH().J(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.Ms.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.Ms.get(i).type)) {
                            view2 = d.mH().J(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.Ms.get(i).id)) {
                            this.Mv.put(aVar.Ms.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.Ms.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.Ld)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.Ld)) {
                        if (a.this.Mw != null) {
                            a.this.Mw.b(aVar.Ld, a.this.b(aVar));
                        } else {
                            c.K(context, aVar.Ld);
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
            if (!z || TextUtils.isEmpty(aVar.Mn)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.Mi)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.bR(aVar.Mi), com.baidu.b.a.e.a.bR(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.b.a.e.a.bR(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Mr)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.bR(aVar.Mr), com.baidu.b.a.e.a.bR(aVar.Mn)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.b.a.e.a.bR(aVar.Mn));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.Mc);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.Lm > 0.0d ? com.baidu.b.a.c.a.a(aVar.Lm, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.Ln > 0.0d ? (float) aVar.Ln : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.KZ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.KZ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.KJ = (float) aVar.borderRadius;
            aVar2.KK = (float) aVar.LW;
            aVar2.KL = (float) aVar.LX;
            aVar2.KM = (float) aVar.LY;
            aVar2.KN = (float) aVar.LZ;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.bR(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.Mn)) {
                aVar2.KO = com.baidu.b.a.e.a.bR(aVar.Mn);
            }
            aVar2.KP = (float) aVar.fontSize;
            aVar2.KQ = aVar.KQ;
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
            view.setMinimumWidth((int) aVar.KZ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.KZ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.KI = aVar.KI;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.KZ.getLayoutWidth();
            aVar2.height = (int) aVar.KZ.getLayoutHeight();
            d.mH().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.KZ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.KZ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.KJ = (float) aVar.borderRadius;
            aVar2.KK = (float) aVar.LW;
            aVar2.KL = (float) aVar.LX;
            aVar2.KM = (float) aVar.LY;
            aVar2.KN = (float) aVar.LZ;
            d.mH().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.Mm < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.Mm);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Ml)) {
                String str5 = aVar.borderColor;
                str = aVar.Mh;
                str2 = str5;
            } else {
                String str6 = aVar.Ml;
                str = aVar.Mq;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.Mk)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.Mg;
            } else {
                str3 = aVar.Mk;
                str4 = aVar.Mp;
            }
            if (aVar.LV > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.bR(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.b.a.c.a.a(aVar.LV, f), com.baidu.b.a.e.a.bR(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.LW, f), b(aVar.LY, f), b(aVar.LZ, f), b(aVar.LX, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.bR(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.bR(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.b.a.c.a.a(aVar.LV, f), com.baidu.b.a.e.a.bR(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.LW, f), b(aVar.LY, f), b(aVar.LZ, f), b(aVar.LX, f)});
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
                    gradientDrawable3.setStroke((int) com.baidu.b.a.c.a.a(aVar.LV, f2), com.baidu.b.a.e.a.bR(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.LW, f2), b(aVar.LY, f2), b(aVar.LZ, f2), b(aVar.LX, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Mk)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.Mg)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.bR(aVar.Mg));
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
            } else if (!TextUtils.isEmpty(aVar.Mp)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.bR(aVar.Mp));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.bR(aVar.Mk));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.b.a.e.a.bR(aVar.Mk));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Mj)) {
                if (!TextUtils.isEmpty(aVar.LU)) {
                    d.mH().a(aVar.type, view, aVar.LU, aVar.Mf);
                    return;
                }
                return;
            }
            d.mH().a(aVar.type, view, aVar.Mj, aVar.Mo);
        }
    }

    public View bP(String str) {
        return this.Mu.get(str);
    }

    public View bQ(String str) {
        return this.Mv.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.Le);
        hashMap.put("data-url-stat", aVar.Lf);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.b.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
