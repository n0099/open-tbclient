package com.baidu.c.a.d;

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
import com.baidu.c.a.b.d;
import com.baidu.c.a.e.c;
import com.baidu.crius.CriusDisplay;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private InterfaceC0049a SX;
    private com.baidu.c.a.c.a criusData;
    private ViewGroup rootView;
    private Map<String, View> SV = new HashMap();
    private Map<String, View> SW = new HashMap();
    private boolean SY = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0049a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0049a interfaceC0049a) {
        this.SX = interfaceC0049a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.SY = true;
        } else {
            this.SY = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.SY) {
            this.rootView = new RelativeLayout(context);
            this.rootView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.rootView;
    }

    private boolean a(com.baidu.c.a.c.a aVar, com.baidu.c.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.Ry) || aVar.Ry.equals(aVar2.Ry)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.ST != null) {
                    if (aVar2.ST != null && aVar.ST.size() == aVar2.ST.size()) {
                        int size = aVar.ST.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.ST.get(i), aVar2.ST.get(i))) {
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
            this.SY = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.Rv != null && view != null) {
            if (aVar.Rv.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.Rv.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.Rv.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.Rv.getLayoutWidth());
                }
            }
            if (aVar.Rv.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.Rv.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.Rv.getLayoutHeight());
                }
            }
            if (aVar.Rv.getLayoutX() > 0.0f) {
                view.setX(aVar.Rv.getLayoutX());
            }
            if (aVar.Rv.getLayoutY() > 0.0f) {
                view.setY(aVar.Rv.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.Ry)) {
                a(aVar.Ry, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.ST != null && aVar.ST.size() > 0) {
                for (int i = 0; i < aVar.ST.size(); i++) {
                    View view2 = null;
                    if (this.SY && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.ST.get(i).Ry)) {
                            view2 = com.baidu.c.a.b.a.nO().O(context, aVar.ST.get(i).Ry);
                            this.SV.put(aVar.ST.get(i).Ry, view2);
                        } else if ("view".equalsIgnoreCase(aVar.ST.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.ST.get(i).type)) {
                            view2 = d.nP().P(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.ST.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.ST.get(i).type)) {
                            view2 = d.nP().P(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.ST.get(i).id)) {
                            this.SW.put(aVar.ST.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.ST.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.Rz)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.Rz)) {
                        if (a.this.SX != null) {
                            a.this.SX.b(aVar.Rz, a.this.b(aVar));
                        } else {
                            c.Q(context, aVar.Rz);
                        }
                    }
                }
            });
        }
    }

    private void a(View view, com.baidu.c.a.c.a aVar, boolean z) {
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
            if (!z || TextUtils.isEmpty(aVar.SM)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.SG)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.cy(aVar.SG), com.baidu.c.a.e.a.cy(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.c.a.e.a.cy(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.SS)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.cy(aVar.SS), com.baidu.c.a.e.a.cy(aVar.SM)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.c.a.e.a.cy(aVar.SM));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.Sz);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.RI > 0.0d ? com.baidu.c.a.c.a.a(aVar.RI, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.RJ > 0.0d ? (float) aVar.RJ : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.Rv.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Rv.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.Rf = (float) aVar.borderRadius;
            aVar2.Rg = (float) aVar.St;
            aVar2.Rh = (float) aVar.Su;
            aVar2.Ri = (float) aVar.Sv;
            aVar2.Rj = (float) aVar.Sw;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.c.a.e.a.cy(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.SM)) {
                aVar2.Rk = com.baidu.c.a.e.a.cy(aVar.SM);
            }
            aVar2.Rl = (float) aVar.fontSize;
            aVar2.Rm = aVar.Rm;
            com.baidu.c.a.b.a.nO().a(str, view, aVar2, z);
        }
    }

    private void a(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
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

    private void a(View view, com.baidu.c.a.c.a aVar) {
        if (aVar != null && "video".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.Rv.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Rv.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Re = aVar.Re;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.Rv.getLayoutWidth();
            aVar2.height = (int) aVar.Rv.getLayoutHeight();
            d.nP().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.Rv.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Rv.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Rf = (float) aVar.borderRadius;
            aVar2.Rg = (float) aVar.St;
            aVar2.Rh = (float) aVar.Su;
            aVar2.Ri = (float) aVar.Sv;
            aVar2.Rj = (float) aVar.Sw;
            d.nP().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.SL < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.SL);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.SK)) {
                String str5 = aVar.borderColor;
                str = aVar.SF;
                str2 = str5;
            } else {
                String str6 = aVar.SK;
                str = aVar.SR;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.SJ)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.SD;
            } else {
                str3 = aVar.SJ;
                str4 = aVar.SQ;
            }
            if (aVar.Ss > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.c.a.e.a.cy(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.c.a.c.a.a(aVar.Ss, f), com.baidu.c.a.e.a.cy(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.St, f), b(aVar.Sv, f), b(aVar.Sw, f), b(aVar.Su, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.cy(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.cy(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.c.a.c.a.a(aVar.Ss, f), com.baidu.c.a.e.a.cy(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.St, f), b(aVar.Sv, f), b(aVar.Sw, f), b(aVar.Su, f)});
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
                        gradientDrawable3.setColor(com.baidu.c.a.e.a.cy(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.c.a.c.a.a(aVar.Ss, f2), com.baidu.c.a.e.a.cy(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.St, f2), b(aVar.Sv, f2), b(aVar.Sw, f2), b(aVar.Su, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.SJ)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.SD)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.c.a.e.a.cy(aVar.SD));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.c.a.e.a.cy(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.c.a.e.a.cy(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.SQ)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.c.a.e.a.cy(aVar.SQ));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.c.a.e.a.cy(aVar.SJ));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.c.a.e.a.cy(aVar.SJ));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.SH)) {
                if (!TextUtils.isEmpty(aVar.Sr)) {
                    d.nP().a(aVar.type, view, aVar.Sr, aVar.SC);
                    return;
                }
                return;
            }
            d.nP().a(aVar.type, view, aVar.SH, aVar.SO);
        }
    }

    public View cw(String str) {
        return this.SV.get(str);
    }

    public View cx(String str) {
        return this.SW.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.RA);
        hashMap.put("data-url-stat", aVar.RB);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.c.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
