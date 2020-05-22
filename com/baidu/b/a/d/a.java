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
    private InterfaceC0090a aoG;
    private com.baidu.b.a.c.a criusData;
    private ViewGroup rootView;
    private Map<String, View> aoE = new HashMap();
    private Map<String, View> aoF = new HashMap();
    private boolean aoH = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0090a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0090a interfaceC0090a) {
        this.aoG = interfaceC0090a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.aoH = true;
        } else {
            this.aoH = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.aoH) {
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
        if (TextUtils.isEmpty(aVar.anp) || aVar.anp.equals(aVar2.anp)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.aoC != null) {
                    if (aVar2.aoC != null && aVar.aoC.size() == aVar2.aoC.size()) {
                        int size = aVar.aoC.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.aoC.get(i), aVar2.aoC.get(i))) {
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
            this.aoH = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.anl != null && view != null) {
            if (aVar.anl.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.anl.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.anl.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.anl.getLayoutWidth());
                }
            }
            if (aVar.anl.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.anl.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.anl.getLayoutHeight());
                }
            }
            if (aVar.anl.getLayoutX() > 0.0f) {
                view.setX(aVar.anl.getLayoutX());
            }
            if (aVar.anl.getLayoutY() > 0.0f) {
                view.setY(aVar.anl.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.anp)) {
                a(aVar.anp, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.aoC != null && aVar.aoC.size() > 0) {
                for (int i = 0; i < aVar.aoC.size(); i++) {
                    View view2 = null;
                    if (this.aoH && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.aoC.get(i).anp)) {
                            view2 = com.baidu.b.a.b.a.tf().A(context, aVar.aoC.get(i).anp);
                            this.aoE.put(aVar.aoC.get(i).anp, view2);
                        } else if ("view".equalsIgnoreCase(aVar.aoC.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.aoC.get(i).type)) {
                            view2 = d.tg().B(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.aoC.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.aoC.get(i).type)) {
                            view2 = d.tg().B(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.aoC.get(i).id)) {
                            this.aoF.put(aVar.aoC.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.aoC.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.anq)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.anq)) {
                        if (a.this.aoG != null) {
                            a.this.aoG.b(aVar.anq, a.this.b(aVar));
                        } else {
                            com.baidu.b.a.e.d.C(context, aVar.anq);
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
            if (!z || TextUtils.isEmpty(aVar.aox)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.aos)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dT(aVar.aos), b.dT(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.dT(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.aoB)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dT(aVar.aoB), b.dT(aVar.aox)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.dT(aVar.aox));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.aom);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.anz > 0.0d ? com.baidu.b.a.c.a.a(aVar.anz, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.anA > 0.0d ? (float) aVar.anA : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.anl.getLayoutWidth());
            view.setMinimumHeight((int) aVar.anl.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.amV = (float) aVar.borderRadius;
            aVar2.amW = (float) aVar.aog;
            aVar2.amX = (float) aVar.aoh;
            aVar2.amY = (float) aVar.aoi;
            aVar2.amZ = (float) aVar.aoj;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.dT(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.aox)) {
                aVar2.ana = b.dT(aVar.aox);
            }
            aVar2.anb = (float) aVar.fontSize;
            aVar2.anc = aVar.anc;
            com.baidu.b.a.b.a.tf().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.anl.getLayoutWidth());
            view.setMinimumHeight((int) aVar.anl.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.anl.getLayoutWidth();
            aVar2.height = (int) aVar.anl.getLayoutHeight();
            d.tg().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.anl.getLayoutWidth());
            view.setMinimumHeight((int) aVar.anl.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.amV = (float) aVar.borderRadius;
            aVar2.amW = (float) aVar.aog;
            aVar2.amX = (float) aVar.aoh;
            aVar2.amY = (float) aVar.aoi;
            aVar2.amZ = (float) aVar.aoj;
            d.tg().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.aow < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.aow);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aov)) {
                String str5 = aVar.borderColor;
                str = aVar.aor;
                str2 = str5;
            } else {
                String str6 = aVar.aov;
                str = aVar.aoA;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.aou)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.aoq;
            } else {
                str3 = aVar.aou;
                str4 = aVar.aoz;
            }
            if (aVar.aof > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.dT(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.b.a.c.a.a(aVar.aof, f), b.dT(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.aog, f), b(aVar.aoi, f), b(aVar.aoj, f), b(aVar.aoh, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.dT(str4));
                        } else {
                            gradientDrawable2.setColor(b.dT(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.b.a.c.a.a(aVar.aof, f), b.dT(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.aog, f), b(aVar.aoi, f), b(aVar.aoj, f), b(aVar.aoh, f)});
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
                        gradientDrawable3.setColor(b.dT(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.b.a.c.a.a(aVar.aof, f2), b.dT(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.aog, f2), b(aVar.aoi, f2), b(aVar.aoj, f2), b(aVar.aoh, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aou)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.aoq)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.dT(aVar.aoq));
                            ColorDrawable colorDrawable2 = new ColorDrawable(b.dT(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(b.dT(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.aoz)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.dT(aVar.aoz));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.dT(aVar.aou));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.dT(aVar.aou));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aot)) {
                if (!TextUtils.isEmpty(aVar.aoe)) {
                    d.tg().a(aVar.type, view, aVar.aoe, aVar.aop);
                    return;
                }
                return;
            }
            d.tg().a(aVar.type, view, aVar.aot, aVar.aoy);
        }
    }

    public View dR(String str) {
        return this.aoE.get(str);
    }

    public View dS(String str) {
        return this.aoF.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.anr);
        hashMap.put("data-url-stat", aVar.ans);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.b.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
