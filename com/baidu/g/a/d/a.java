package com.baidu.g.a.d;

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
import com.baidu.crius.CriusDisplay;
import com.baidu.g.a.b.d;
import com.baidu.g.a.e.b;
import com.baidu.tbadk.TbPageContext;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes26.dex */
public class a {
    private InterfaceC0134a awf;
    private com.baidu.g.a.c.a criusData;
    private TbPageContext<?> pageContext;
    private ViewGroup rootView;
    private Map<String, View> awd = new HashMap();
    private Map<String, View> awe = new HashMap();
    private boolean awg = false;

    /* renamed from: com.baidu.g.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0134a {
        void b(String str, Map<String, String> map);
    }

    public a(TbPageContext<?> tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void a(InterfaceC0134a interfaceC0134a) {
        this.awf = interfaceC0134a;
    }

    public ViewGroup a(Context context, com.baidu.g.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.awg = true;
        } else {
            this.awg = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.awg) {
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

    private boolean a(com.baidu.g.a.c.a aVar, com.baidu.g.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.auO) || aVar.auO.equals(aVar2.auO)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.awb != null) {
                    if (aVar2.awb != null && aVar.awb.size() == aVar2.awb.size()) {
                        int size = aVar.awb.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.awb.get(i), aVar2.awb.get(i))) {
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
            this.awg = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.g.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.auK != null && view != null) {
            if (aVar.auK.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.auK.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.auK.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.auK.getLayoutWidth());
                }
            }
            if (aVar.auK.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.auK.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.auK.getLayoutHeight());
                }
            }
            if (aVar.auK.getLayoutX() > 0.0f) {
                view.setX(aVar.auK.getLayoutX());
            }
            if (aVar.auK.getLayoutY() > 0.0f) {
                view.setY(aVar.auK.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.auO)) {
                a(aVar.auO, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.awb != null && aVar.awb.size() > 0) {
                for (int i = 0; i < aVar.awb.size(); i++) {
                    View view2 = null;
                    if (this.awg && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.awb.get(i).auO)) {
                            view2 = com.baidu.g.a.b.a.zq().C(context, aVar.awb.get(i).auO);
                            this.awd.put(aVar.awb.get(i).auO, view2);
                        } else if ("view".equalsIgnoreCase(aVar.awb.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.awb.get(i).type)) {
                            view2 = d.zr().D(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.awb.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.awb.get(i).type)) {
                            view2 = d.zr().D(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.awb.get(i).id)) {
                            this.awe.put(aVar.awb.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.awb.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.g.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.auP)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.g.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.auP)) {
                        if (a.this.awf != null) {
                            a.this.awf.b(aVar.auP, a.this.b(aVar));
                        } else {
                            com.baidu.g.a.e.d.E(context, aVar.auP);
                        }
                    }
                }
            });
        }
    }

    private void a(View view, com.baidu.g.a.c.a aVar, boolean z) {
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
            if (!z || TextUtils.isEmpty(aVar.avW)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.avR)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.fv(aVar.avR), b.fv(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.fv(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.awa)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.fv(aVar.awa), b.fv(aVar.avW)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.fv(aVar.avW));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.avL);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a2 = aVar.auY > 0.0d ? com.baidu.g.a.c.a.a(aVar.auY, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.auZ > 0.0d ? (float) aVar.auZ : 1.0f;
            if (a2 > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a2, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.auK.getLayoutWidth());
            view.setMinimumHeight((int) aVar.auK.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.auu = (float) aVar.borderRadius;
            aVar2.auv = (float) aVar.avF;
            aVar2.auw = (float) aVar.avG;
            aVar2.aux = (float) aVar.avH;
            aVar2.auy = (float) aVar.avI;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.fv(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.avW)) {
                aVar2.auz = b.fv(aVar.avW);
            }
            aVar2.auA = (float) aVar.fontSize;
            aVar2.auB = aVar.auB;
            com.baidu.g.a.b.a.zq().a(str, view, aVar2, z);
        }
    }

    private void a(Context context, View view, com.baidu.g.a.c.a aVar, boolean z) {
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

    private void a(View view, com.baidu.g.a.c.a aVar) {
        if (aVar != null && "video".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.auK.getLayoutWidth());
            view.setMinimumHeight((int) aVar.auK.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.auK.getLayoutWidth();
            aVar2.height = (int) aVar.auK.getLayoutHeight();
            d.zr().a("video", view, aVar2, this.pageContext);
        }
    }

    private void b(View view, com.baidu.g.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.auK.getLayoutWidth());
            view.setMinimumHeight((int) aVar.auK.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.src = aVar.src;
            aVar2.auu = (float) aVar.borderRadius;
            aVar2.auv = (float) aVar.avF;
            aVar2.auw = (float) aVar.avG;
            aVar2.aux = (float) aVar.avH;
            aVar2.auy = (float) aVar.avI;
            d.zr().a("image", view, aVar2, this.pageContext);
        }
    }

    private void b(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.avV < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.avV);
        }
    }

    private void b(Context context, View view, com.baidu.g.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.avU)) {
                String str5 = aVar.borderColor;
                str = aVar.avQ;
                str2 = str5;
            } else {
                String str6 = aVar.avU;
                str = aVar.avZ;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.avT)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.avP;
            } else {
                str3 = aVar.avT;
                str4 = aVar.avY;
            }
            if (aVar.avE > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.fv(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.g.a.c.a.a(aVar.avE, f), b.fv(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.avF, f), b(aVar.avH, f), b(aVar.avI, f), b(aVar.avG, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.fv(str4));
                        } else {
                            gradientDrawable2.setColor(b.fv(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.g.a.c.a.a(aVar.avE, f), b.fv(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.avF, f), b(aVar.avH, f), b(aVar.avI, f), b(aVar.avG, f)});
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
                        gradientDrawable3.setColor(b.fv(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.g.a.c.a.a(aVar.avE, f2), b.fv(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.avF, f2), b(aVar.avH, f2), b(aVar.avI, f2), b(aVar.avG, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.avT)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.avP)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.fv(aVar.avP));
                            ColorDrawable colorDrawable2 = new ColorDrawable(b.fv(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(b.fv(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.avY)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.fv(aVar.avY));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.fv(aVar.avT));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.fv(aVar.avT));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.avS)) {
                if (!TextUtils.isEmpty(aVar.avD)) {
                    d.zr().a(aVar.type, view, aVar.avD, aVar.avO);
                    return;
                }
                return;
            }
            d.zr().a(aVar.type, view, aVar.avS, aVar.avX);
        }
    }

    public View ft(String str) {
        return this.awd.get(str);
    }

    public View fu(String str) {
        return this.awe.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.g.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.auQ);
        hashMap.put("data-url-stat", aVar.auR);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.g.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
