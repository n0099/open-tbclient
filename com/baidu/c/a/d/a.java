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
    private ViewGroup Rr;
    private InterfaceC0037a acB;
    private com.baidu.c.a.c.a criusData;
    private Map<String, View> acz = new HashMap();
    private Map<String, View> acA = new HashMap();
    private boolean acC = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0037a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0037a interfaceC0037a) {
        this.acB = interfaceC0037a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.acC = true;
        } else {
            this.acC = a(aVar, this.criusData);
        }
        if (this.Rr == null || !this.acC) {
            this.Rr = new RelativeLayout(context);
            this.Rr.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.Rr, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.Rr;
    }

    private boolean a(com.baidu.c.a.c.a aVar, com.baidu.c.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.abi) || aVar.abi.equals(aVar2.abi)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.acx != null) {
                    if (aVar2.acx != null && aVar.acx.size() == aVar2.acx.size()) {
                        int size = aVar.acx.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.acx.get(i), aVar2.acx.get(i))) {
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
            this.acC = true;
            a(context, this.criusData, this.Rr, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.aaT != null && view != null) {
            if (aVar.aaT.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.aaT.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.aaT.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.aaT.getLayoutWidth());
                }
            }
            if (aVar.aaT.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.aaT.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.aaT.getLayoutHeight());
                }
            }
            if (aVar.aaT.getLayoutX() > 0.0f) {
                view.setX(aVar.aaT.getLayoutX());
            }
            if (aVar.aaT.getLayoutY() > 0.0f) {
                view.setY(aVar.aaT.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.abi)) {
                a(aVar.abi, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.acx != null && aVar.acx.size() > 0) {
                for (int i = 0; i < aVar.acx.size(); i++) {
                    View view2 = null;
                    if (this.acC && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.acx.get(i).abi)) {
                            view2 = com.baidu.c.a.b.a.rc().K(context, aVar.acx.get(i).abi);
                            this.acz.put(aVar.acx.get(i).abi, view2);
                        } else if ("view".equalsIgnoreCase(aVar.acx.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.acx.get(i).type)) {
                            view2 = d.rd().L(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.acx.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.acx.get(i).type)) {
                            view2 = d.rd().L(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.acx.get(i).id)) {
                            this.acA.put(aVar.acx.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.acx.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.abj)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.abj)) {
                        if (a.this.acB != null) {
                            a.this.acB.b(aVar.abj, a.this.a(aVar));
                        } else {
                            c.M(context, aVar.abj);
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
            if (!z || TextUtils.isEmpty(aVar.acr)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.acm)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.acm), com.baidu.c.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acv)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.acv), com.baidu.c.a.e.a.parseColor(aVar.acr)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.acr));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.acg);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            if (aVar.abt > 0.0d) {
                ((TextView) view).setLineSpacing((float) aVar.abt, 1.0f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.aaT.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaT.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.aaH = (float) aVar.borderRadius;
            aVar2.aaI = (float) aVar.abZ;
            aVar2.aaJ = (float) aVar.aca;
            aVar2.aaK = (float) aVar.acb;
            aVar2.aaL = (float) aVar.acd;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.c.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.acr)) {
                aVar2.aaM = com.baidu.c.a.e.a.parseColor(aVar.acr);
            }
            aVar2.aaN = (float) aVar.fontSize;
            com.baidu.c.a.b.a.rc().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.aaT.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaT.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aaG = aVar.aaG;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.aaT.getLayoutWidth();
            aVar2.height = (int) aVar.aaT.getLayoutHeight();
            d.rd().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.aaT.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaT.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aaH = (float) aVar.borderRadius;
            aVar2.aaI = (float) aVar.abZ;
            aVar2.aaJ = (float) aVar.aca;
            aVar2.aaK = (float) aVar.acb;
            aVar2.aaL = (float) aVar.acd;
            d.rd().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.acq < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.acq);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acp)) {
                String str5 = aVar.borderColor;
                str = aVar.acl;
                str2 = str5;
            } else {
                String str6 = aVar.acp;
                str = aVar.acu;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.aco)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.ack;
            } else {
                str3 = aVar.aco;
                str4 = aVar.act;
            }
            if (aVar.abY > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.c.a.c.a.a(aVar.abY, f), com.baidu.c.a.e.a.parseColor(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.abZ, f), b(aVar.acb, f), b(aVar.acd, f), b(aVar.aca, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.c.a.c.a.a(aVar.abY, f), com.baidu.c.a.e.a.parseColor(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.abZ, f), b(aVar.acb, f), b(aVar.acd, f), b(aVar.aca, f)});
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
                    gradientDrawable3.setStroke((int) com.baidu.c.a.c.a.a(aVar.abY, f2), com.baidu.c.a.e.a.parseColor(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.c.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.abZ, f2), b(aVar.acb, f2), b(aVar.acd, f2), b(aVar.aca, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aco)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.ack)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.ack));
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
            } else if (!TextUtils.isEmpty(aVar.act)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.act));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.aco));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.aco));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acn)) {
                if (!TextUtils.isEmpty(aVar.abX)) {
                    d.rd().a(aVar.type, view, aVar.abX, aVar.acj);
                    return;
                }
                return;
            }
            d.rd().a(aVar.type, view, aVar.acn, aVar.acs);
        }
    }

    public View cA(String str) {
        return this.acz.get(str);
    }

    public View cB(String str) {
        return this.acA.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.abk);
        hashMap.put("data-url-stat", aVar.abl);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.c.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
