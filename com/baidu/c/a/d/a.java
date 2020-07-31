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
import com.baidu.c.a.e.b;
import com.baidu.crius.CriusDisplay;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
public class a {
    private InterfaceC0095a apV;
    private com.baidu.c.a.c.a criusData;
    private ViewGroup rootView;
    private Map<String, View> apT = new HashMap();
    private Map<String, View> apU = new HashMap();
    private boolean apW = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0095a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0095a interfaceC0095a) {
        this.apV = interfaceC0095a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.apW = true;
        } else {
            this.apW = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.apW) {
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
        if (TextUtils.isEmpty(aVar.aoD) || aVar.aoD.equals(aVar2.aoD)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.apR != null) {
                    if (aVar2.apR != null && aVar.apR.size() == aVar2.apR.size()) {
                        int size = aVar.apR.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.apR.get(i), aVar2.apR.get(i))) {
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
            this.apW = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.aoz != null && view != null) {
            if (aVar.aoz.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.aoz.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.aoz.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.aoz.getLayoutWidth());
                }
            }
            if (aVar.aoz.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.aoz.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.aoz.getLayoutHeight());
                }
            }
            if (aVar.aoz.getLayoutX() > 0.0f) {
                view.setX(aVar.aoz.getLayoutX());
            }
            if (aVar.aoz.getLayoutY() > 0.0f) {
                view.setY(aVar.aoz.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.aoD)) {
                a(aVar.aoD, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.apR != null && aVar.apR.size() > 0) {
                for (int i = 0; i < aVar.apR.size(); i++) {
                    View view2 = null;
                    if (this.apW && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.apR.get(i).aoD)) {
                            view2 = com.baidu.c.a.b.a.ty().A(context, aVar.apR.get(i).aoD);
                            this.apT.put(aVar.apR.get(i).aoD, view2);
                        } else if ("view".equalsIgnoreCase(aVar.apR.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.apR.get(i).type)) {
                            view2 = d.tz().B(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.apR.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.apR.get(i).type)) {
                            view2 = d.tz().B(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.apR.get(i).id)) {
                            this.apU.put(aVar.apR.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.apR.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.aoE)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.aoE)) {
                        if (a.this.apV != null) {
                            a.this.apV.b(aVar.aoE, a.this.b(aVar));
                        } else {
                            com.baidu.c.a.e.d.C(context, aVar.aoE);
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
            if (!z || TextUtils.isEmpty(aVar.apM)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.apH)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dU(aVar.apH), b.dU(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.dU(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.apQ)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dU(aVar.apQ), b.dU(aVar.apM)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.dU(aVar.apM));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.apB);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.aoN > 0.0d ? com.baidu.c.a.c.a.a(aVar.aoN, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.aoO > 0.0d ? (float) aVar.aoO : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.aoz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aoz.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.aoj = (float) aVar.borderRadius;
            aVar2.aok = (float) aVar.apv;
            aVar2.aol = (float) aVar.apw;
            aVar2.aom = (float) aVar.apx;
            aVar2.aon = (float) aVar.apy;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.dU(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.apM)) {
                aVar2.aoo = b.dU(aVar.apM);
            }
            aVar2.aop = (float) aVar.fontSize;
            aVar2.aoq = aVar.aoq;
            com.baidu.c.a.b.a.ty().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.aoz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aoz.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.aoz.getLayoutWidth();
            aVar2.height = (int) aVar.aoz.getLayoutHeight();
            d.tz().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.aoz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aoz.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aoj = (float) aVar.borderRadius;
            aVar2.aok = (float) aVar.apv;
            aVar2.aol = (float) aVar.apw;
            aVar2.aom = (float) aVar.apx;
            aVar2.aon = (float) aVar.apy;
            d.tz().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.apL < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.apL);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.apK)) {
                String str5 = aVar.borderColor;
                str = aVar.apG;
                str2 = str5;
            } else {
                String str6 = aVar.apK;
                str = aVar.apP;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.apJ)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.apF;
            } else {
                str3 = aVar.apJ;
                str4 = aVar.apO;
            }
            if (aVar.apu > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.dU(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.c.a.c.a.a(aVar.apu, f), b.dU(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.apv, f), b(aVar.apx, f), b(aVar.apy, f), b(aVar.apw, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.dU(str4));
                        } else {
                            gradientDrawable2.setColor(b.dU(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.c.a.c.a.a(aVar.apu, f), b.dU(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.apv, f), b(aVar.apx, f), b(aVar.apy, f), b(aVar.apw, f)});
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
                        gradientDrawable3.setColor(b.dU(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.c.a.c.a.a(aVar.apu, f2), b.dU(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.apv, f2), b(aVar.apx, f2), b(aVar.apy, f2), b(aVar.apw, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.apJ)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.apF)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.dU(aVar.apF));
                            ColorDrawable colorDrawable2 = new ColorDrawable(b.dU(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(b.dU(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.apO)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.dU(aVar.apO));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.dU(aVar.apJ));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.dU(aVar.apJ));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.apI)) {
                if (!TextUtils.isEmpty(aVar.apt)) {
                    d.tz().a(aVar.type, view, aVar.apt, aVar.apE);
                    return;
                }
                return;
            }
            d.tz().a(aVar.type, view, aVar.apI, aVar.apN);
        }
    }

    public View dS(String str) {
        return this.apT.get(str);
    }

    public View dT(String str) {
        return this.apU.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.aoF);
        hashMap.put("data-url-stat", aVar.aoG);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.c.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
