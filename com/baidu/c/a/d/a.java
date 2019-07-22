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
/* loaded from: classes3.dex */
public class a {
    private ViewGroup RI;
    private InterfaceC0037a acY;
    private com.baidu.c.a.c.a criusData;
    private Map<String, View> acW = new HashMap();
    private Map<String, View> acX = new HashMap();
    private boolean acZ = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0037a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0037a interfaceC0037a) {
        this.acY = interfaceC0037a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.acZ = true;
        } else {
            this.acZ = a(aVar, this.criusData);
        }
        if (this.RI == null || !this.acZ) {
            this.RI = new RelativeLayout(context);
            this.RI.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.RI, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.RI;
    }

    private boolean a(com.baidu.c.a.c.a aVar, com.baidu.c.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.abG) || aVar.abG.equals(aVar2.abG)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.acU != null) {
                    if (aVar2.acU != null && aVar.acU.size() == aVar2.acU.size()) {
                        int size = aVar.acU.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.acU.get(i), aVar2.acU.get(i))) {
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

    public void g(Context context, boolean z) {
        try {
            this.acZ = true;
            a(context, this.criusData, this.RI, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.abr != null && view != null) {
            if (aVar.abr.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.abr.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.abr.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.abr.getLayoutWidth());
                }
            }
            if (aVar.abr.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.abr.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.abr.getLayoutHeight());
                }
            }
            if (aVar.abr.getLayoutX() > 0.0f) {
                view.setX(aVar.abr.getLayoutX());
            }
            if (aVar.abr.getLayoutY() > 0.0f) {
                view.setY(aVar.abr.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.abG)) {
                a(aVar.abG, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.acU != null && aVar.acU.size() > 0) {
                for (int i = 0; i < aVar.acU.size(); i++) {
                    View view2 = null;
                    if (this.acZ && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.acU.get(i).abG)) {
                            view2 = com.baidu.c.a.b.a.rz().K(context, aVar.acU.get(i).abG);
                            this.acW.put(aVar.acU.get(i).abG, view2);
                        } else if ("view".equalsIgnoreCase(aVar.acU.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.acU.get(i).type)) {
                            view2 = d.rA().L(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.acU.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.acU.get(i).type)) {
                            view2 = d.rA().L(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.acU.get(i).id)) {
                            this.acX.put(aVar.acU.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.acU.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.abH)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.abH)) {
                        if (a.this.acY != null) {
                            a.this.acY.b(aVar.abH, a.this.a(aVar));
                        } else {
                            c.M(context, aVar.abH);
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
            if (!z || TextUtils.isEmpty(aVar.acP)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.acK)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.cE(aVar.acK), com.baidu.c.a.e.a.cE(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.c.a.e.a.cE(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acT)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.cE(aVar.acT), com.baidu.c.a.e.a.cE(aVar.acP)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.c.a.e.a.cE(aVar.acP));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.acE);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            if (aVar.abQ > 0.0d) {
                ((TextView) view).setLineSpacing((float) aVar.abQ, 1.0f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.abr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.abr.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.abe = (float) aVar.borderRadius;
            aVar2.abf = (float) aVar.acy;
            aVar2.abg = (float) aVar.acz;
            aVar2.abh = (float) aVar.acA;
            aVar2.abi = (float) aVar.acB;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.c.a.e.a.cE(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.acP)) {
                aVar2.abj = com.baidu.c.a.e.a.cE(aVar.acP);
            }
            aVar2.abk = (float) aVar.fontSize;
            aVar2.abl = aVar.abl;
            com.baidu.c.a.b.a.rz().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.abr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.abr.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.abd = aVar.abd;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.abr.getLayoutWidth();
            aVar2.height = (int) aVar.abr.getLayoutHeight();
            d.rA().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.abr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.abr.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.abe = (float) aVar.borderRadius;
            aVar2.abf = (float) aVar.acy;
            aVar2.abg = (float) aVar.acz;
            aVar2.abh = (float) aVar.acA;
            aVar2.abi = (float) aVar.acB;
            d.rA().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.acO < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.acO);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acN)) {
                String str5 = aVar.borderColor;
                str = aVar.acJ;
                str2 = str5;
            } else {
                String str6 = aVar.acN;
                str = aVar.acS;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.acM)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.acI;
            } else {
                str3 = aVar.acM;
                str4 = aVar.acR;
            }
            if (aVar.acx > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.c.a.e.a.cE(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.c.a.c.a.a(aVar.acx, f), com.baidu.c.a.e.a.cE(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.acy, f), b(aVar.acA, f), b(aVar.acB, f), b(aVar.acz, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.cE(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.cE(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.c.a.c.a.a(aVar.acx, f), com.baidu.c.a.e.a.cE(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.acy, f), b(aVar.acA, f), b(aVar.acB, f), b(aVar.acz, f)});
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
                        gradientDrawable3.setColor(com.baidu.c.a.e.a.cE(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.c.a.c.a.a(aVar.acx, f2), com.baidu.c.a.e.a.cE(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.acy, f2), b(aVar.acA, f2), b(aVar.acB, f2), b(aVar.acz, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acM)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.acI)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.c.a.e.a.cE(aVar.acI));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.c.a.e.a.cE(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.c.a.e.a.cE(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acR)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.c.a.e.a.cE(aVar.acR));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.c.a.e.a.cE(aVar.acM));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.c.a.e.a.cE(aVar.acM));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acL)) {
                if (!TextUtils.isEmpty(aVar.acv)) {
                    d.rA().a(aVar.type, view, aVar.acv, aVar.acH);
                    return;
                }
                return;
            }
            d.rA().a(aVar.type, view, aVar.acL, aVar.acQ);
        }
    }

    public View cC(String str) {
        return this.acW.get(str);
    }

    public View cD(String str) {
        return this.acX.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.abI);
        hashMap.put("data-url-stat", aVar.abJ);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.c.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
