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
import com.baidu.b.a.e.b;
import com.baidu.crius.CriusDisplay;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public class a {
    private InterfaceC0091a apZ;
    private com.baidu.b.a.c.a criusData;
    private ViewGroup rootView;
    private Map<String, View> apX = new HashMap();
    private Map<String, View> apY = new HashMap();
    private boolean aqa = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0091a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0091a interfaceC0091a) {
        this.apZ = interfaceC0091a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.aqa = true;
        } else {
            this.aqa = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.aqa) {
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

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.aoH) || aVar.aoH.equals(aVar2.aoH)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.apV != null) {
                    if (aVar2.apV != null && aVar.apV.size() == aVar2.apV.size()) {
                        int size = aVar.apV.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.apV.get(i), aVar2.apV.get(i))) {
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

    public void h(Context context, boolean z) {
        try {
            this.aqa = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.aoD != null && view != null) {
            if (aVar.aoD.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.aoD.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.aoD.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.aoD.getLayoutWidth());
                }
            }
            if (aVar.aoD.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.aoD.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.aoD.getLayoutHeight());
                }
            }
            if (aVar.aoD.getLayoutX() > 0.0f) {
                view.setX(aVar.aoD.getLayoutX());
            }
            if (aVar.aoD.getLayoutY() > 0.0f) {
                view.setY(aVar.aoD.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.aoH)) {
                a(aVar.aoH, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.apV != null && aVar.apV.size() > 0) {
                for (int i = 0; i < aVar.apV.size(); i++) {
                    View view2 = null;
                    if (this.aqa && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.apV.get(i).aoH)) {
                            view2 = com.baidu.b.a.b.a.ty().A(context, aVar.apV.get(i).aoH);
                            this.apX.put(aVar.apV.get(i).aoH, view2);
                        } else if ("view".equalsIgnoreCase(aVar.apV.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.apV.get(i).type)) {
                            view2 = d.tz().B(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.apV.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.apV.get(i).type)) {
                            view2 = d.tz().B(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.apV.get(i).id)) {
                            this.apY.put(aVar.apV.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.apV.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.aoI)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.aoI)) {
                        if (a.this.apZ != null) {
                            a.this.apZ.b(aVar.aoI, a.this.b(aVar));
                        } else {
                            com.baidu.b.a.e.d.C(context, aVar.aoI);
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
            if (!z || TextUtils.isEmpty(aVar.apQ)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.apL)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dV(aVar.apL), b.dV(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.dV(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.apU)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dV(aVar.apU), b.dV(aVar.apQ)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.dV(aVar.apQ));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.apF);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.aoR > 0.0d ? com.baidu.b.a.c.a.a(aVar.aoR, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.aoS > 0.0d ? (float) aVar.aoS : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.aoD.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aoD.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.aon = (float) aVar.borderRadius;
            aVar2.aoo = (float) aVar.apz;
            aVar2.aop = (float) aVar.apA;
            aVar2.aoq = (float) aVar.apB;
            aVar2.aor = (float) aVar.apC;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.dV(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.apQ)) {
                aVar2.aos = b.dV(aVar.apQ);
            }
            aVar2.aot = (float) aVar.fontSize;
            aVar2.aou = aVar.aou;
            com.baidu.b.a.b.a.ty().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.aoD.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aoD.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.aoD.getLayoutWidth();
            aVar2.height = (int) aVar.aoD.getLayoutHeight();
            d.tz().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.aoD.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aoD.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aon = (float) aVar.borderRadius;
            aVar2.aoo = (float) aVar.apz;
            aVar2.aop = (float) aVar.apA;
            aVar2.aoq = (float) aVar.apB;
            aVar2.aor = (float) aVar.apC;
            d.tz().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.apP < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.apP);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.apO)) {
                String str5 = aVar.borderColor;
                str = aVar.apK;
                str2 = str5;
            } else {
                String str6 = aVar.apO;
                str = aVar.apT;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.apN)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.apJ;
            } else {
                str3 = aVar.apN;
                str4 = aVar.apS;
            }
            if (aVar.apy > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.dV(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.b.a.c.a.a(aVar.apy, f), b.dV(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.apz, f), b(aVar.apB, f), b(aVar.apC, f), b(aVar.apA, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.dV(str4));
                        } else {
                            gradientDrawable2.setColor(b.dV(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.b.a.c.a.a(aVar.apy, f), b.dV(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.apz, f), b(aVar.apB, f), b(aVar.apC, f), b(aVar.apA, f)});
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
                        gradientDrawable3.setColor(b.dV(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.b.a.c.a.a(aVar.apy, f2), b.dV(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.apz, f2), b(aVar.apB, f2), b(aVar.apC, f2), b(aVar.apA, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.apN)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.apJ)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.dV(aVar.apJ));
                            ColorDrawable colorDrawable2 = new ColorDrawable(b.dV(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(b.dV(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.apS)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.dV(aVar.apS));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.dV(aVar.apN));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.dV(aVar.apN));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.apM)) {
                if (!TextUtils.isEmpty(aVar.apx)) {
                    d.tz().a(aVar.type, view, aVar.apx, aVar.apI);
                    return;
                }
                return;
            }
            d.tz().a(aVar.type, view, aVar.apM, aVar.apR);
        }
    }

    public View dT(String str) {
        return this.apX.get(str);
    }

    public View dU(String str) {
        return this.apY.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.aoJ);
        hashMap.put("data-url-stat", aVar.aoK);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.b.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
