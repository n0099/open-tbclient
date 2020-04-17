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
    private InterfaceC0067a amY;
    private com.baidu.b.a.c.a criusData;
    private ViewGroup rootView;
    private Map<String, View> amW = new HashMap();
    private Map<String, View> amX = new HashMap();
    private boolean amZ = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0067a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0067a interfaceC0067a) {
        this.amY = interfaceC0067a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.amZ = true;
        } else {
            this.amZ = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.amZ) {
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
        if (TextUtils.isEmpty(aVar.alH) || aVar.alH.equals(aVar2.alH)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.amU != null) {
                    if (aVar2.amU != null && aVar.amU.size() == aVar2.amU.size()) {
                        int size = aVar.amU.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.amU.get(i), aVar2.amU.get(i))) {
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
            this.amZ = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.alD != null && view != null) {
            if (aVar.alD.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.alD.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.alD.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.alD.getLayoutWidth());
                }
            }
            if (aVar.alD.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.alD.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.alD.getLayoutHeight());
                }
            }
            if (aVar.alD.getLayoutX() > 0.0f) {
                view.setX(aVar.alD.getLayoutX());
            }
            if (aVar.alD.getLayoutY() > 0.0f) {
                view.setY(aVar.alD.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.alH)) {
                a(aVar.alH, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.amU != null && aVar.amU.size() > 0) {
                for (int i = 0; i < aVar.amU.size(); i++) {
                    View view2 = null;
                    if (this.amZ && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.amU.get(i).alH)) {
                            view2 = com.baidu.b.a.b.a.sX().M(context, aVar.amU.get(i).alH);
                            this.amW.put(aVar.amU.get(i).alH, view2);
                        } else if ("view".equalsIgnoreCase(aVar.amU.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.amU.get(i).type)) {
                            view2 = d.sY().N(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.amU.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.amU.get(i).type)) {
                            view2 = d.sY().N(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.amU.get(i).id)) {
                            this.amX.put(aVar.amU.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.amU.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.alI)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.alI)) {
                        if (a.this.amY != null) {
                            a.this.amY.b(aVar.alI, a.this.b(aVar));
                        } else {
                            com.baidu.b.a.e.d.O(context, aVar.alI);
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
            if (!z || TextUtils.isEmpty(aVar.amP)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.amK)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dA(aVar.amK), b.dA(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.dA(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.amT)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.dA(aVar.amT), b.dA(aVar.amP)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.dA(aVar.amP));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.amE);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.alR > 0.0d ? com.baidu.b.a.c.a.a(aVar.alR, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.alS > 0.0d ? (float) aVar.alS : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.alD.getLayoutWidth());
            view.setMinimumHeight((int) aVar.alD.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.aln = (float) aVar.borderRadius;
            aVar2.alo = (float) aVar.amy;
            aVar2.alp = (float) aVar.amz;
            aVar2.alq = (float) aVar.amA;
            aVar2.alr = (float) aVar.amB;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.dA(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.amP)) {
                aVar2.als = b.dA(aVar.amP);
            }
            aVar2.alt = (float) aVar.fontSize;
            aVar2.alu = aVar.alu;
            com.baidu.b.a.b.a.sX().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.alD.getLayoutWidth());
            view.setMinimumHeight((int) aVar.alD.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.alD.getLayoutWidth();
            aVar2.height = (int) aVar.alD.getLayoutHeight();
            d.sY().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.alD.getLayoutWidth());
            view.setMinimumHeight((int) aVar.alD.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aln = (float) aVar.borderRadius;
            aVar2.alo = (float) aVar.amy;
            aVar2.alp = (float) aVar.amz;
            aVar2.alq = (float) aVar.amA;
            aVar2.alr = (float) aVar.amB;
            d.sY().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.amO < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.amO);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.amN)) {
                String str5 = aVar.borderColor;
                str = aVar.amJ;
                str2 = str5;
            } else {
                String str6 = aVar.amN;
                str = aVar.amS;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.amM)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.amI;
            } else {
                str3 = aVar.amM;
                str4 = aVar.amR;
            }
            if (aVar.amx > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.dA(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.b.a.c.a.a(aVar.amx, f), b.dA(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.amy, f), b(aVar.amA, f), b(aVar.amB, f), b(aVar.amz, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.dA(str4));
                        } else {
                            gradientDrawable2.setColor(b.dA(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.b.a.c.a.a(aVar.amx, f), b.dA(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.amy, f), b(aVar.amA, f), b(aVar.amB, f), b(aVar.amz, f)});
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
                    gradientDrawable3.setStroke((int) com.baidu.b.a.c.a.a(aVar.amx, f2), b.dA(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.b.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.amy, f2), b(aVar.amA, f2), b(aVar.amB, f2), b(aVar.amz, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.amM)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.amI)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.dA(aVar.amI));
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
            } else if (!TextUtils.isEmpty(aVar.amR)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.dA(aVar.amR));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.dA(aVar.amM));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.dA(aVar.amM));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.amL)) {
                if (!TextUtils.isEmpty(aVar.amw)) {
                    d.sY().a(aVar.type, view, aVar.amw, aVar.amH);
                    return;
                }
                return;
            }
            d.sY().a(aVar.type, view, aVar.amL, aVar.amQ);
        }
    }

    public View dy(String str) {
        return this.amW.get(str);
    }

    public View dz(String str) {
        return this.amX.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.alJ);
        hashMap.put("data-url-stat", aVar.alK);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.b.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
