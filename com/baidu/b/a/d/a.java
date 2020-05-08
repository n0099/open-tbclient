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
    private InterfaceC0088a ane;
    private com.baidu.b.a.c.a criusData;
    private ViewGroup rootView;
    private Map<String, View> anc = new HashMap();
    private Map<String, View> and = new HashMap();
    private boolean anf = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0088a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0088a interfaceC0088a) {
        this.ane = interfaceC0088a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.anf = true;
        } else {
            this.anf = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.anf) {
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
        if (TextUtils.isEmpty(aVar.alN) || aVar.alN.equals(aVar2.alN)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.ana != null) {
                    if (aVar2.ana != null && aVar.ana.size() == aVar2.ana.size()) {
                        int size = aVar.ana.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.ana.get(i), aVar2.ana.get(i))) {
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
            this.anf = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.alJ != null && view != null) {
            if (aVar.alJ.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.alJ.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.alJ.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.alJ.getLayoutWidth());
                }
            }
            if (aVar.alJ.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.alJ.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.alJ.getLayoutHeight());
                }
            }
            if (aVar.alJ.getLayoutX() > 0.0f) {
                view.setX(aVar.alJ.getLayoutX());
            }
            if (aVar.alJ.getLayoutY() > 0.0f) {
                view.setY(aVar.alJ.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.alN)) {
                a(aVar.alN, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.ana != null && aVar.ana.size() > 0) {
                for (int i = 0; i < aVar.ana.size(); i++) {
                    View view2 = null;
                    if (this.anf && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.ana.get(i).alN)) {
                            view2 = com.baidu.b.a.b.a.sW().A(context, aVar.ana.get(i).alN);
                            this.anc.put(aVar.ana.get(i).alN, view2);
                        } else if ("view".equalsIgnoreCase(aVar.ana.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.ana.get(i).type)) {
                            view2 = d.sX().B(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.ana.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.ana.get(i).type)) {
                            view2 = d.sX().B(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.ana.get(i).id)) {
                            this.and.put(aVar.ana.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.ana.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.alO)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.alO)) {
                        if (a.this.ane != null) {
                            a.this.ane.b(aVar.alO, a.this.b(aVar));
                        } else {
                            com.baidu.b.a.e.d.C(context, aVar.alO);
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
            if (!z || TextUtils.isEmpty(aVar.amV)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.amQ)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dA(aVar.amQ), b.dA(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.dA(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.amZ)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dA(aVar.amZ), b.dA(aVar.amV)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.dA(aVar.amV));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.amK);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.alX > 0.0d ? com.baidu.b.a.c.a.a(aVar.alX, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.alY > 0.0d ? (float) aVar.alY : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.alJ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.alJ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.alt = (float) aVar.borderRadius;
            aVar2.alu = (float) aVar.amE;
            aVar2.alv = (float) aVar.amF;
            aVar2.alw = (float) aVar.amG;
            aVar2.alx = (float) aVar.amH;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.dA(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.amV)) {
                aVar2.aly = b.dA(aVar.amV);
            }
            aVar2.alz = (float) aVar.fontSize;
            aVar2.alA = aVar.alA;
            com.baidu.b.a.b.a.sW().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.alJ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.alJ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.alJ.getLayoutWidth();
            aVar2.height = (int) aVar.alJ.getLayoutHeight();
            d.sX().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.alJ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.alJ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.alt = (float) aVar.borderRadius;
            aVar2.alu = (float) aVar.amE;
            aVar2.alv = (float) aVar.amF;
            aVar2.alw = (float) aVar.amG;
            aVar2.alx = (float) aVar.amH;
            d.sX().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.amU < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.amU);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.amT)) {
                String str5 = aVar.borderColor;
                str = aVar.amP;
                str2 = str5;
            } else {
                String str6 = aVar.amT;
                str = aVar.amY;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.amS)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.amO;
            } else {
                str3 = aVar.amS;
                str4 = aVar.amX;
            }
            if (aVar.amD > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.dA(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.b.a.c.a.a(aVar.amD, f), b.dA(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.amE, f), b(aVar.amG, f), b(aVar.amH, f), b(aVar.amF, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.dA(str4));
                        } else {
                            gradientDrawable2.setColor(b.dA(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.b.a.c.a.a(aVar.amD, f), b.dA(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.amE, f), b(aVar.amG, f), b(aVar.amH, f), b(aVar.amF, f)});
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
                        gradientDrawable3.setColor(b.dA(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.b.a.c.a.a(aVar.amD, f2), b.dA(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.amE, f2), b(aVar.amG, f2), b(aVar.amH, f2), b(aVar.amF, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.amS)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.amO)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.dA(aVar.amO));
                            ColorDrawable colorDrawable2 = new ColorDrawable(b.dA(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(b.dA(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.amX)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.dA(aVar.amX));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.dA(aVar.amS));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.dA(aVar.amS));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.amR)) {
                if (!TextUtils.isEmpty(aVar.amC)) {
                    d.sX().a(aVar.type, view, aVar.amC, aVar.amN);
                    return;
                }
                return;
            }
            d.sX().a(aVar.type, view, aVar.amR, aVar.amW);
        }
    }

    public View dy(String str) {
        return this.anc.get(str);
    }

    public View dz(String str) {
        return this.and.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.alP);
        hashMap.put("data-url-stat", aVar.alQ);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.b.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
