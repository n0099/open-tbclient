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
    private ViewGroup acE;
    private InterfaceC0070a acF;
    private com.baidu.c.a.c.a criusData;
    private Map<String, View> acC = new HashMap();
    private Map<String, View> acD = new HashMap();
    private boolean acG = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0070a {
        void d(String str, Map<String, String> map);
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.acF = interfaceC0070a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.acG = true;
        } else {
            this.acG = a(aVar, this.criusData);
        }
        if (this.acE == null || !this.acG) {
            this.acE = new RelativeLayout(context);
            this.acE.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.acE, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.acE;
    }

    private boolean a(com.baidu.c.a.c.a aVar, com.baidu.c.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.abm) || aVar.abm.equals(aVar2.abm)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.acA != null) {
                    if (aVar2.acA != null && aVar.acA.size() == aVar2.acA.size()) {
                        int size = aVar.acA.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.acA.get(i), aVar2.acA.get(i))) {
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

    public void j(Context context, boolean z) {
        try {
            this.acG = true;
            a(context, this.criusData, this.acE, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.aaX != null && view != null) {
            if (aVar.aaX.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.aaX.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.aaX.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.aaX.getLayoutWidth());
                }
            }
            if (aVar.aaX.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.aaX.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.aaX.getLayoutHeight());
                }
            }
            if (aVar.aaX.getLayoutX() > 0.0f) {
                view.setX(aVar.aaX.getLayoutX());
            }
            if (aVar.aaX.getLayoutY() > 0.0f) {
                view.setY(aVar.aaX.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.abm)) {
                a(aVar.abm, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.acA != null && aVar.acA.size() > 0) {
                for (int i = 0; i < aVar.acA.size(); i++) {
                    View view2 = null;
                    if (this.acG && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.acA.get(i).abm)) {
                            view2 = com.baidu.c.a.b.a.sq().Z(context, aVar.acA.get(i).abm);
                            this.acC.put(aVar.acA.get(i).abm, view2);
                        } else if ("view".equalsIgnoreCase(aVar.acA.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.acA.get(i).type)) {
                            view2 = d.sr().aa(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.acA.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.acA.get(i).type)) {
                            view2 = d.sr().aa(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.acA.get(i).id)) {
                            this.acD.put(aVar.acA.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.acA.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.abn)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.abn)) {
                        if (a.this.acF != null) {
                            a.this.acF.d(aVar.abn, a.this.a(aVar));
                        } else {
                            c.ab(context, aVar.abn);
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
            if (!z || TextUtils.isEmpty(aVar.acu)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.acp)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.acp), com.baidu.c.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acz)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.acz), com.baidu.c.a.e.a.parseColor(aVar.acu)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.acu));
                } catch (Throwable th4) {
                }
            }
            if (aVar.acj >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.acj * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.aci);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            if (aVar.abx > 0.0d) {
                ((TextView) view).setLineSpacing((float) aVar.abx, 1.0f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.aaX.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaX.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.borderRadius = (float) aVar.ace;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.c.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.acu)) {
                aVar2.aaR = com.baidu.c.a.e.a.parseColor(aVar.acu);
            }
            aVar2.fontSize = (float) aVar.acj;
            com.baidu.c.a.b.a.sq().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.aaX.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaX.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aaQ = aVar.aaQ;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.aaX.getLayoutWidth();
            aVar2.height = (int) aVar.aaX.getLayoutHeight();
            d.sr().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.aaX.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaX.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.borderRadius = (float) aVar.ace;
            d.sr().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.act < -1.0d) {
                if (aVar.acf > -1.0d) {
                    view.setAlpha((float) aVar.acf);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.act);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acs)) {
                String str5 = aVar.acc;
                str = aVar.aco;
                str2 = str5;
            } else {
                String str6 = aVar.acs;
                str = aVar.acy;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.acr)) {
                str3 = aVar.acb;
                str4 = aVar.acn;
            } else {
                str3 = aVar.acr;
                str4 = aVar.acx;
            }
            if (aVar.acd > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.acd, f), com.baidu.c.a.e.a.parseColor(str2));
                        if (aVar.ace > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.ace, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.acd, f), com.baidu.c.a.e.a.parseColor(str));
                        if (aVar.ace > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.ace, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.acd, f2), com.baidu.c.a.e.a.parseColor(str2));
                    if (aVar.ace > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.ace, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acr)) {
                if (!TextUtils.isEmpty(aVar.acb)) {
                    if (!TextUtils.isEmpty(aVar.acn)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.acn));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.acb));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.acb));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acx)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.acx));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.acr));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.acr));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acq)) {
                if (!TextUtils.isEmpty(aVar.aca)) {
                    d.sr().a(aVar.type, view, aVar.aca, aVar.acm);
                    return;
                }
                return;
            }
            d.sr().a(aVar.type, view, aVar.acq, aVar.acv);
        }
    }

    public View db(String str) {
        return this.acC.get(str);
    }

    public View dc(String str) {
        return this.acD.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.abo);
        hashMap.put("data-url-stat", aVar.abp);
        return hashMap;
    }
}
