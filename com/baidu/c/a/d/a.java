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
    private ViewGroup TH;
    private InterfaceC0038a aeL;
    private com.baidu.c.a.c.a criusData;
    private Map<String, View> aeJ = new HashMap();
    private Map<String, View> aeK = new HashMap();
    private boolean aeM = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0038a {
        void c(String str, Map<String, String> map);
    }

    public void a(InterfaceC0038a interfaceC0038a) {
        this.aeL = interfaceC0038a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.aeM = true;
        } else {
            this.aeM = a(aVar, this.criusData);
        }
        if (this.TH == null || !this.aeM) {
            this.TH = new RelativeLayout(context);
            this.TH.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.TH, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.TH;
    }

    private boolean a(com.baidu.c.a.c.a aVar, com.baidu.c.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.adv) || aVar.adv.equals(aVar2.adv)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.aeH != null) {
                    if (aVar2.aeH != null && aVar.aeH.size() == aVar2.aeH.size()) {
                        int size = aVar.aeH.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.aeH.get(i), aVar2.aeH.get(i))) {
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

    public void i(Context context, boolean z) {
        try {
            this.aeM = true;
            a(context, this.criusData, this.TH, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.adh != null && view != null) {
            if (aVar.adh.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.adh.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.adh.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.adh.getLayoutWidth());
                }
            }
            if (aVar.adh.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.adh.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.adh.getLayoutHeight());
                }
            }
            if (aVar.adh.getLayoutX() > 0.0f) {
                view.setX(aVar.adh.getLayoutX());
            }
            if (aVar.adh.getLayoutY() > 0.0f) {
                view.setY(aVar.adh.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.adv)) {
                a(aVar.adv, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.aeH != null && aVar.aeH.size() > 0) {
                for (int i = 0; i < aVar.aeH.size(); i++) {
                    View view2 = null;
                    if (this.aeM && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.aeH.get(i).adv)) {
                            view2 = com.baidu.c.a.b.a.sh().Y(context, aVar.aeH.get(i).adv);
                            this.aeJ.put(aVar.aeH.get(i).adv, view2);
                        } else if ("view".equalsIgnoreCase(aVar.aeH.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.aeH.get(i).type)) {
                            view2 = d.si().Z(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.aeH.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.aeH.get(i).type)) {
                            view2 = d.si().Z(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.aeH.get(i).id)) {
                            this.aeK.put(aVar.aeH.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.aeH.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.adw)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.adw)) {
                        if (a.this.aeL != null) {
                            a.this.aeL.c(aVar.adw, a.this.a(aVar));
                        } else {
                            c.aa(context, aVar.adw);
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
            if (!z || TextUtils.isEmpty(aVar.aeC)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.aex)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.aex), com.baidu.c.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.aeG)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.aeG), com.baidu.c.a.e.a.parseColor(aVar.aeC)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.aeC));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.aer);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            if (aVar.adF > 0.0d) {
                ((TextView) view).setLineSpacing((float) aVar.adF, 1.0f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.adh.getLayoutWidth());
            view.setMinimumHeight((int) aVar.adh.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.acU = (float) aVar.borderRadius;
            aVar2.acV = (float) aVar.ael;
            aVar2.acW = (float) aVar.aem;
            aVar2.acX = (float) aVar.aen;
            aVar2.acY = (float) aVar.aeo;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.c.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.aeC)) {
                aVar2.acZ = com.baidu.c.a.e.a.parseColor(aVar.aeC);
            }
            aVar2.ada = (float) aVar.fontSize;
            com.baidu.c.a.b.a.sh().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.adh.getLayoutWidth());
            view.setMinimumHeight((int) aVar.adh.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.acT = aVar.acT;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.adh.getLayoutWidth();
            aVar2.height = (int) aVar.adh.getLayoutHeight();
            d.si().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.adh.getLayoutWidth());
            view.setMinimumHeight((int) aVar.adh.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.acU = (float) aVar.borderRadius;
            aVar2.acV = (float) aVar.ael;
            aVar2.acW = (float) aVar.aem;
            aVar2.acX = (float) aVar.aen;
            aVar2.acY = (float) aVar.aeo;
            d.si().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.aeB < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.aeB);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aeA)) {
                String str5 = aVar.borderColor;
                str = aVar.aew;
                str2 = str5;
            } else {
                String str6 = aVar.aeA;
                str = aVar.aeF;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.aez)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.aev;
            } else {
                str3 = aVar.aez;
                str4 = aVar.aeE;
            }
            if (aVar.aek > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.c.a.c.a.a(aVar.aek, f), com.baidu.c.a.e.a.parseColor(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.ael, f), b(aVar.aen, f), b(aVar.aeo, f), b(aVar.aem, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.c.a.c.a.a(aVar.aek, f), com.baidu.c.a.e.a.parseColor(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.ael, f), b(aVar.aen, f), b(aVar.aeo, f), b(aVar.aem, f)});
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
                        gradientDrawable3.setColor(com.baidu.c.a.e.a.parseColor(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.c.a.c.a.a(aVar.aek, f2), com.baidu.c.a.e.a.parseColor(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.ael, f2), b(aVar.aen, f2), b(aVar.aeo, f2), b(aVar.aem, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aez)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.aev)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.aev));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.aeE)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.aeE));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.aez));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.aez));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aey)) {
                if (!TextUtils.isEmpty(aVar.aej)) {
                    d.si().a(aVar.type, view, aVar.aej, aVar.aeu);
                    return;
                }
                return;
            }
            d.si().a(aVar.type, view, aVar.aey, aVar.aeD);
        }
    }

    public View cQ(String str) {
        return this.aeJ.get(str);
    }

    public View cR(String str) {
        return this.aeK.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.adx);
        hashMap.put("data-url-stat", aVar.ady);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.c.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
