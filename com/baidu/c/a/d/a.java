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
/* loaded from: classes13.dex */
public class a {
    private InterfaceC0051a UR;
    private com.baidu.c.a.c.a criusData;
    private ViewGroup rootView;
    private Map<String, View> UO = new HashMap();
    private Map<String, View> UQ = new HashMap();
    private boolean US = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0051a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0051a interfaceC0051a) {
        this.UR = interfaceC0051a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.US = true;
        } else {
            this.US = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.US) {
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
        if (TextUtils.isEmpty(aVar.Tu) || aVar.Tu.equals(aVar2.Tu)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.UM != null) {
                    if (aVar2.UM != null && aVar.UM.size() == aVar2.UM.size()) {
                        int size = aVar.UM.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.UM.get(i), aVar2.UM.get(i))) {
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
            this.US = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.Tr != null && view != null) {
            if (aVar.Tr.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.Tr.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.Tr.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.Tr.getLayoutWidth());
                }
            }
            if (aVar.Tr.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.Tr.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.Tr.getLayoutHeight());
                }
            }
            if (aVar.Tr.getLayoutX() > 0.0f) {
                view.setX(aVar.Tr.getLayoutX());
            }
            if (aVar.Tr.getLayoutY() > 0.0f) {
                view.setY(aVar.Tr.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.Tu)) {
                a(aVar.Tu, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.UM != null && aVar.UM.size() > 0) {
                for (int i = 0; i < aVar.UM.size(); i++) {
                    View view2 = null;
                    if (this.US && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.UM.get(i).Tu)) {
                            view2 = com.baidu.c.a.b.a.oD().O(context, aVar.UM.get(i).Tu);
                            this.UO.put(aVar.UM.get(i).Tu, view2);
                        } else if ("view".equalsIgnoreCase(aVar.UM.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.UM.get(i).type)) {
                            view2 = d.oE().P(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.UM.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.UM.get(i).type)) {
                            view2 = d.oE().P(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.UM.get(i).id)) {
                            this.UQ.put(aVar.UM.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.UM.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.Tv)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.Tv)) {
                        if (a.this.UR != null) {
                            a.this.UR.b(aVar.Tv, a.this.b(aVar));
                        } else {
                            com.baidu.c.a.e.d.Q(context, aVar.Tv);
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
            if (!z || TextUtils.isEmpty(aVar.UG)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.UB)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.cF(aVar.UB), b.cF(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.cF(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.UL)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.cF(aVar.UL), b.cF(aVar.UG)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.cF(aVar.UG));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.Uu);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.TF > 0.0d ? com.baidu.c.a.c.a.a(aVar.TF, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.TG > 0.0d ? (float) aVar.TG : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.Tr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Tr.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.Ta = (float) aVar.borderRadius;
            aVar2.Tb = (float) aVar.Uo;
            aVar2.Tc = (float) aVar.Up;
            aVar2.Te = (float) aVar.Uq;
            aVar2.Tf = (float) aVar.Ur;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.cF(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.UG)) {
                aVar2.Tg = b.cF(aVar.UG);
            }
            aVar2.Th = (float) aVar.fontSize;
            aVar2.Ti = aVar.Ti;
            com.baidu.c.a.b.a.oD().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.Tr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Tr.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.Tr.getLayoutWidth();
            aVar2.height = (int) aVar.Tr.getLayoutHeight();
            d.oE().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.Tr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Tr.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Ta = (float) aVar.borderRadius;
            aVar2.Tb = (float) aVar.Uo;
            aVar2.Tc = (float) aVar.Up;
            aVar2.Te = (float) aVar.Uq;
            aVar2.Tf = (float) aVar.Ur;
            d.oE().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.UF < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.UF);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.UE)) {
                String str5 = aVar.borderColor;
                str = aVar.Uz;
                str2 = str5;
            } else {
                String str6 = aVar.UE;
                str = aVar.UK;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.UD)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.Uy;
            } else {
                str3 = aVar.UD;
                str4 = aVar.UJ;
            }
            if (aVar.Un > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.cF(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.c.a.c.a.a(aVar.Un, f), b.cF(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.Uo, f), b(aVar.Uq, f), b(aVar.Ur, f), b(aVar.Up, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.cF(str4));
                        } else {
                            gradientDrawable2.setColor(b.cF(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.c.a.c.a.a(aVar.Un, f), b.cF(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.Uo, f), b(aVar.Uq, f), b(aVar.Ur, f), b(aVar.Up, f)});
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
                        gradientDrawable3.setColor(b.cF(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.c.a.c.a.a(aVar.Un, f2), b.cF(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.Uo, f2), b(aVar.Uq, f2), b(aVar.Ur, f2), b(aVar.Up, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.UD)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.Uy)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.cF(aVar.Uy));
                            ColorDrawable colorDrawable2 = new ColorDrawable(b.cF(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(b.cF(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.UJ)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.cF(aVar.UJ));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.cF(aVar.UD));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.cF(aVar.UD));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.UC)) {
                if (!TextUtils.isEmpty(aVar.Um)) {
                    d.oE().a(aVar.type, view, aVar.Um, aVar.Ux);
                    return;
                }
                return;
            }
            d.oE().a(aVar.type, view, aVar.UC, aVar.UH);
        }
    }

    public View cD(String str) {
        return this.UO.get(str);
    }

    public View cE(String str) {
        return this.UQ.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.Tw);
        hashMap.put("data-url-stat", aVar.Tx);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.c.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
