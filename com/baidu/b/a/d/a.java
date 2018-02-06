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
import com.baidu.b.a.e.c;
import com.baidu.crius.CriusDisplay;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private ViewGroup aBf;
    private InterfaceC0054a aBg;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> aBd = new HashMap();
    private Map<String, View> aBe = new HashMap();
    private boolean aBh = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0054a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0054a interfaceC0054a) {
        this.aBg = interfaceC0054a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.aBh = true;
        } else {
            this.aBh = a(aVar, this.criusData);
        }
        if (this.aBf == null || !this.aBh) {
            this.aBf = new RelativeLayout(context);
            this.aBf.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.aBf, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.aBf;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.azO) || aVar.azO.equals(aVar2.azO)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.aBb != null) {
                    if (aVar2.aBb != null && aVar.aBb.size() == aVar2.aBb.size()) {
                        int size = aVar.aBb.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.aBb.get(i), aVar2.aBb.get(i))) {
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

    public void t(Context context, boolean z) {
        try {
            a(context, this.criusData, this.aBf, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.azA != null && view != null) {
            if (aVar.azA.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.azA.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.azA.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.azA.getLayoutWidth());
                }
            }
            if (aVar.azA.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.azA.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.azA.getLayoutHeight());
                }
            }
            if (aVar.azA.getLayoutX() > 0.0f) {
                view.setX(aVar.azA.getLayoutX());
            }
            if (aVar.azA.getLayoutY() > 0.0f) {
                view.setY(aVar.azA.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.azO)) {
                a(aVar.azO, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.aBb != null && aVar.aBb.size() > 0) {
                for (int i = 0; i < aVar.aBb.size(); i++) {
                    View view2 = null;
                    if (this.aBh && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.aBb.get(i).azO)) {
                            view2 = com.baidu.b.a.b.a.tw().M(context, aVar.aBb.get(i).azO);
                            this.aBd.put(aVar.aBb.get(i).azO, view2);
                        } else if ("view".equalsIgnoreCase(aVar.aBb.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.aBb.get(i).type)) {
                            view2 = d.tx().N(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.aBb.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.aBb.get(i).type)) {
                            view2 = d.tx().N(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.aBb.get(i).id)) {
                            this.aBe.put(aVar.aBb.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.aBb.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.azP)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.azP)) {
                        if (a.this.aBg != null) {
                            a.this.aBg.b(aVar.azP, a.this.a(aVar));
                        } else {
                            c.O(context, aVar.azP);
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
            if (!z || TextUtils.isEmpty(aVar.aAW)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.aAR)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.aAR), com.baidu.b.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.aBa)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.aBa), com.baidu.b.a.e.a.parseColor(aVar.aAW)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.aAW));
                } catch (Throwable th4) {
                }
            }
            if (aVar.aAL >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.aAL * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.aAK);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.azA.getLayoutWidth());
            view.setMinimumHeight((int) aVar.azA.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.azs = (float) aVar.aAG;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.aAW)) {
                aVar2.azt = com.baidu.b.a.e.a.parseColor(aVar.aAW);
            }
            aVar2.azu = (float) aVar.aAL;
            com.baidu.b.a.b.a.tw().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.azA.getLayoutWidth());
            view.setMinimumHeight((int) aVar.azA.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.azr = aVar.azr;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.azA.getLayoutWidth();
            aVar2.height = (int) aVar.azA.getLayoutHeight();
            d.tx().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.azA.getLayoutWidth());
            view.setMinimumHeight((int) aVar.azA.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.azs = (float) aVar.aAG;
            d.tx().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.aAV < -1.0d) {
                if (aVar.aAH > -1.0d) {
                    view.setAlpha((float) aVar.aAH);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.aAV);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aAU)) {
                String str5 = aVar.aAE;
                str = aVar.aAQ;
                str2 = str5;
            } else {
                String str6 = aVar.aAU;
                str = aVar.aAZ;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.aAT)) {
                str3 = aVar.aAD;
                str4 = aVar.aAP;
            } else {
                str3 = aVar.aAT;
                str4 = aVar.aAY;
            }
            if (aVar.aAF > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.aAF, f), com.baidu.b.a.e.a.parseColor(str2));
                        if (aVar.aAG > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.aAG, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.aAF, f), com.baidu.b.a.e.a.parseColor(str));
                        if (aVar.aAG > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.aAG, f));
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
                        gradientDrawable3.setColor(com.baidu.b.a.e.a.parseColor(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) aVar.a(aVar.aAF, f2), com.baidu.b.a.e.a.parseColor(str2));
                    if (aVar.aAG > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.aAG, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aAT)) {
                if (!TextUtils.isEmpty(aVar.aAD)) {
                    if (!TextUtils.isEmpty(aVar.aAP)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.aAP));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.aAD));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.aAD));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.aAY)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.aAY));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.aAT));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.aAT));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aAS)) {
                if (!TextUtils.isEmpty(aVar.aAC)) {
                    d.tx().a(aVar.type, view, aVar.aAC, aVar.aAO);
                    return;
                }
                return;
            }
            d.tx().a(aVar.type, view, aVar.aAS, aVar.aAX);
        }
    }

    public View bX(String str) {
        return this.aBd.get(str);
    }

    public View bY(String str) {
        return this.aBe.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.azQ);
        hashMap.put("data-url-stat", aVar.azR);
        return hashMap;
    }
}
