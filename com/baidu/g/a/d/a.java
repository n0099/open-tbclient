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
/* loaded from: classes20.dex */
public class a {
    private InterfaceC0129a auU;
    private com.baidu.g.a.c.a criusData;
    private TbPageContext<?> pageContext;
    private ViewGroup rootView;
    private Map<String, View> auS = new HashMap();
    private Map<String, View> auT = new HashMap();
    private boolean auV = false;

    /* renamed from: com.baidu.g.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0129a {
        void b(String str, Map<String, String> map);
    }

    public a(TbPageContext<?> tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void a(InterfaceC0129a interfaceC0129a) {
        this.auU = interfaceC0129a;
    }

    public ViewGroup a(Context context, com.baidu.g.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.auV = true;
        } else {
            this.auV = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.auV) {
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
        if (TextUtils.isEmpty(aVar.atD) || aVar.atD.equals(aVar2.atD)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.auQ != null) {
                    if (aVar2.auQ != null && aVar.auQ.size() == aVar2.auQ.size()) {
                        int size = aVar.auQ.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.auQ.get(i), aVar2.auQ.get(i))) {
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
            this.auV = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.g.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.atz != null && view != null) {
            if (aVar.atz.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.atz.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.atz.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.atz.getLayoutWidth());
                }
            }
            if (aVar.atz.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.atz.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.atz.getLayoutHeight());
                }
            }
            if (aVar.atz.getLayoutX() > 0.0f) {
                view.setX(aVar.atz.getLayoutX());
            }
            if (aVar.atz.getLayoutY() > 0.0f) {
                view.setY(aVar.atz.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.atD)) {
                a(aVar.atD, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.auQ != null && aVar.auQ.size() > 0) {
                for (int i = 0; i < aVar.auQ.size(); i++) {
                    View view2 = null;
                    if (this.auV && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.auQ.get(i).atD)) {
                            view2 = com.baidu.g.a.b.a.yU().A(context, aVar.auQ.get(i).atD);
                            this.auS.put(aVar.auQ.get(i).atD, view2);
                        } else if ("view".equalsIgnoreCase(aVar.auQ.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.auQ.get(i).type)) {
                            view2 = d.yV().B(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.auQ.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.auQ.get(i).type)) {
                            view2 = d.yV().B(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.auQ.get(i).id)) {
                            this.auT.put(aVar.auQ.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.auQ.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.g.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.atE)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.g.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.atE)) {
                        if (a.this.auU != null) {
                            a.this.auU.b(aVar.atE, a.this.b(aVar));
                        } else {
                            com.baidu.g.a.e.d.C(context, aVar.atE);
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
            if (!z || TextUtils.isEmpty(aVar.auL)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.auG)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.fo(aVar.auG), b.fo(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.fo(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.auP)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.fo(aVar.auP), b.fo(aVar.auL)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.fo(aVar.auL));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.auA);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.atN > 0.0d ? com.baidu.g.a.c.a.a(aVar.atN, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.atO > 0.0d ? (float) aVar.atO : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.atz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.atz.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.atj = (float) aVar.borderRadius;
            aVar2.atk = (float) aVar.auu;
            aVar2.atl = (float) aVar.auv;
            aVar2.atm = (float) aVar.auw;
            aVar2.atn = (float) aVar.aux;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.fo(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.auL)) {
                aVar2.ato = b.fo(aVar.auL);
            }
            aVar2.atp = (float) aVar.fontSize;
            aVar2.atq = aVar.atq;
            com.baidu.g.a.b.a.yU().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.atz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.atz.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.atz.getLayoutWidth();
            aVar2.height = (int) aVar.atz.getLayoutHeight();
            d.yV().a("video", view, aVar2, this.pageContext);
        }
    }

    private void b(View view, com.baidu.g.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.atz.getLayoutWidth());
            view.setMinimumHeight((int) aVar.atz.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.src = aVar.src;
            aVar2.atj = (float) aVar.borderRadius;
            aVar2.atk = (float) aVar.auu;
            aVar2.atl = (float) aVar.auv;
            aVar2.atm = (float) aVar.auw;
            aVar2.atn = (float) aVar.aux;
            d.yV().a("image", view, aVar2, this.pageContext);
        }
    }

    private void b(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.auK < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.auK);
        }
    }

    private void b(Context context, View view, com.baidu.g.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.auJ)) {
                String str5 = aVar.borderColor;
                str = aVar.auF;
                str2 = str5;
            } else {
                String str6 = aVar.auJ;
                str = aVar.auO;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.auI)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.auE;
            } else {
                str3 = aVar.auI;
                str4 = aVar.auN;
            }
            if (aVar.aut > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.fo(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.g.a.c.a.a(aVar.aut, f), b.fo(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.auu, f), b(aVar.auw, f), b(aVar.aux, f), b(aVar.auv, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.fo(str4));
                        } else {
                            gradientDrawable2.setColor(b.fo(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.g.a.c.a.a(aVar.aut, f), b.fo(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.auu, f), b(aVar.auw, f), b(aVar.aux, f), b(aVar.auv, f)});
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
                        gradientDrawable3.setColor(b.fo(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.g.a.c.a.a(aVar.aut, f2), b.fo(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.auu, f2), b(aVar.auw, f2), b(aVar.aux, f2), b(aVar.auv, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.auI)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.auE)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.fo(aVar.auE));
                            ColorDrawable colorDrawable2 = new ColorDrawable(b.fo(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(b.fo(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.auN)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.fo(aVar.auN));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.fo(aVar.auI));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.fo(aVar.auI));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.auH)) {
                if (!TextUtils.isEmpty(aVar.aus)) {
                    d.yV().a(aVar.type, view, aVar.aus, aVar.auD);
                    return;
                }
                return;
            }
            d.yV().a(aVar.type, view, aVar.auH, aVar.auM);
        }
    }

    public View fm(String str) {
        return this.auS.get(str);
    }

    public View fn(String str) {
        return this.auT.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.g.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.atF);
        hashMap.put("data-url-stat", aVar.atG);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.g.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
