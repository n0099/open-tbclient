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
/* loaded from: classes11.dex */
public class a {
    private InterfaceC0049a Ta;
    private com.baidu.c.a.c.a criusData;
    private ViewGroup rootView;
    private Map<String, View> SY = new HashMap();
    private Map<String, View> SZ = new HashMap();
    private boolean Tb = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0049a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0049a interfaceC0049a) {
        this.Ta = interfaceC0049a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.Tb = true;
        } else {
            this.Tb = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.Tb) {
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
        if (TextUtils.isEmpty(aVar.RB) || aVar.RB.equals(aVar2.RB)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.SW != null) {
                    if (aVar2.SW != null && aVar.SW.size() == aVar2.SW.size()) {
                        int size = aVar.SW.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.SW.get(i), aVar2.SW.get(i))) {
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
            this.Tb = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.Ry != null && view != null) {
            if (aVar.Ry.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.Ry.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.Ry.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.Ry.getLayoutWidth());
                }
            }
            if (aVar.Ry.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.Ry.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.Ry.getLayoutHeight());
                }
            }
            if (aVar.Ry.getLayoutX() > 0.0f) {
                view.setX(aVar.Ry.getLayoutX());
            }
            if (aVar.Ry.getLayoutY() > 0.0f) {
                view.setY(aVar.Ry.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.RB)) {
                a(aVar.RB, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.SW != null && aVar.SW.size() > 0) {
                for (int i = 0; i < aVar.SW.size(); i++) {
                    View view2 = null;
                    if (this.Tb && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.SW.get(i).RB)) {
                            view2 = com.baidu.c.a.b.a.nP().O(context, aVar.SW.get(i).RB);
                            this.SY.put(aVar.SW.get(i).RB, view2);
                        } else if ("view".equalsIgnoreCase(aVar.SW.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.SW.get(i).type)) {
                            view2 = d.nQ().P(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.SW.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.SW.get(i).type)) {
                            view2 = d.nQ().P(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.SW.get(i).id)) {
                            this.SZ.put(aVar.SW.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.SW.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.RC)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.RC)) {
                        if (a.this.Ta != null) {
                            a.this.Ta.b(aVar.RC, a.this.b(aVar));
                        } else {
                            c.Q(context, aVar.RC);
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
            if (!z || TextUtils.isEmpty(aVar.SR)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.SK)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.cy(aVar.SK), com.baidu.c.a.e.a.cy(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.c.a.e.a.cy(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.SV)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.cy(aVar.SV), com.baidu.c.a.e.a.cy(aVar.SR)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.c.a.e.a.cy(aVar.SR));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.SC);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.RL > 0.0d ? com.baidu.c.a.c.a.a(aVar.RL, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.RO > 0.0d ? (float) aVar.RO : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.Ry.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Ry.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.Ri = (float) aVar.borderRadius;
            aVar2.Rj = (float) aVar.Sw;
            aVar2.Rk = (float) aVar.Sx;
            aVar2.Rl = (float) aVar.Sy;
            aVar2.Rm = (float) aVar.Sz;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.c.a.e.a.cy(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.SR)) {
                aVar2.Rn = com.baidu.c.a.e.a.cy(aVar.SR);
            }
            aVar2.Ro = (float) aVar.fontSize;
            aVar2.Rp = aVar.Rp;
            com.baidu.c.a.b.a.nP().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.Ry.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Ry.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.Ry.getLayoutWidth();
            aVar2.height = (int) aVar.Ry.getLayoutHeight();
            d.nQ().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.Ry.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Ry.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Ri = (float) aVar.borderRadius;
            aVar2.Rj = (float) aVar.Sw;
            aVar2.Rk = (float) aVar.Sx;
            aVar2.Rl = (float) aVar.Sy;
            aVar2.Rm = (float) aVar.Sz;
            d.nQ().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.SQ < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.SQ);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.SO)) {
                String str5 = aVar.borderColor;
                str = aVar.SJ;
                str2 = str5;
            } else {
                String str6 = aVar.SO;
                str = aVar.SU;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.SM)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.SH;
            } else {
                str3 = aVar.SM;
                str4 = aVar.ST;
            }
            if (aVar.Sv > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.c.a.e.a.cy(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.c.a.c.a.a(aVar.Sv, f), com.baidu.c.a.e.a.cy(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.Sw, f), b(aVar.Sy, f), b(aVar.Sz, f), b(aVar.Sx, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.cy(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.cy(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.c.a.c.a.a(aVar.Sv, f), com.baidu.c.a.e.a.cy(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.Sw, f), b(aVar.Sy, f), b(aVar.Sz, f), b(aVar.Sx, f)});
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
                    gradientDrawable3.setStroke((int) com.baidu.c.a.c.a.a(aVar.Sv, f2), com.baidu.c.a.e.a.cy(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.Sw, f2), b(aVar.Sy, f2), b(aVar.Sz, f2), b(aVar.Sx, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.SM)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.SH)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.c.a.e.a.cy(aVar.SH));
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
            } else if (!TextUtils.isEmpty(aVar.ST)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.c.a.e.a.cy(aVar.ST));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.c.a.e.a.cy(aVar.SM));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.c.a.e.a.cy(aVar.SM));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.SL)) {
                if (!TextUtils.isEmpty(aVar.Su)) {
                    d.nQ().a(aVar.type, view, aVar.Su, aVar.SG);
                    return;
                }
                return;
            }
            d.nQ().a(aVar.type, view, aVar.SL, aVar.SS);
        }
    }

    public View cw(String str) {
        return this.SY.get(str);
    }

    public View cx(String str) {
        return this.SZ.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.RD);
        hashMap.put("data-url-stat", aVar.RE);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.c.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
