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
/* loaded from: classes25.dex */
public class a {
    private InterfaceC0130a avw;
    private com.baidu.g.a.c.a criusData;
    private TbPageContext<?> pageContext;
    private ViewGroup rootView;
    private Map<String, View> avu = new HashMap();
    private Map<String, View> avv = new HashMap();
    private boolean avx = false;

    /* renamed from: com.baidu.g.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0130a {
        void b(String str, Map<String, String> map);
    }

    public a(TbPageContext<?> tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void a(InterfaceC0130a interfaceC0130a) {
        this.avw = interfaceC0130a;
    }

    public ViewGroup a(Context context, com.baidu.g.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.avx = true;
        } else {
            this.avx = a(aVar, this.criusData);
        }
        if (this.rootView == null || !this.avx) {
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
        if (TextUtils.isEmpty(aVar.auf) || aVar.auf.equals(aVar2.auf)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.avs != null) {
                    if (aVar2.avs != null && aVar.avs.size() == aVar2.avs.size()) {
                        int size = aVar.avs.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.avs.get(i), aVar2.avs.get(i))) {
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
            this.avx = true;
            a(context, this.criusData, this.rootView, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.g.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.aub != null && view != null) {
            if (aVar.aub.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.aub.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.aub.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.aub.getLayoutWidth());
                }
            }
            if (aVar.aub.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.aub.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.aub.getLayoutHeight());
                }
            }
            if (aVar.aub.getLayoutX() > 0.0f) {
                view.setX(aVar.aub.getLayoutX());
            }
            if (aVar.aub.getLayoutY() > 0.0f) {
                view.setY(aVar.aub.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.auf)) {
                a(aVar.auf, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.avs != null && aVar.avs.size() > 0) {
                for (int i = 0; i < aVar.avs.size(); i++) {
                    View view2 = null;
                    if (this.avx && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.avs.get(i).auf)) {
                            view2 = com.baidu.g.a.b.a.zi().A(context, aVar.avs.get(i).auf);
                            this.avu.put(aVar.avs.get(i).auf, view2);
                        } else if ("view".equalsIgnoreCase(aVar.avs.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.avs.get(i).type)) {
                            view2 = d.zj().B(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.avs.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.avs.get(i).type)) {
                            view2 = d.zj().B(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.avs.get(i).id)) {
                            this.avv.put(aVar.avs.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.avs.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.g.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.aug)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.g.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.aug)) {
                        if (a.this.avw != null) {
                            a.this.avw.b(aVar.aug, a.this.b(aVar));
                        } else {
                            com.baidu.g.a.e.d.C(context, aVar.aug);
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
            if (!z || TextUtils.isEmpty(aVar.avn)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.avi)) {
                        try {
                            ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.fq(aVar.avi), b.fq(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(b.fq(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.avr)) {
                try {
                    ((TextView) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{b.fq(aVar.avr), b.fq(aVar.avn)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(b.fq(aVar.avn));
                } catch (Throwable th4) {
                }
            }
            if (aVar.fontSize >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.fontSize * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.avc);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            float a = aVar.aup > 0.0d ? com.baidu.g.a.c.a.a(aVar.aup, view.getContext().getResources().getDisplayMetrics().density) : 0.0f;
            float f = aVar.auq > 0.0d ? (float) aVar.auq : 1.0f;
            if (a > 0.0f || f > 0.0f) {
                ((TextView) view).setLineSpacing(a, f);
            }
        }
    }

    private void a(String str, View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.aub.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aub.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.atL = (float) aVar.borderRadius;
            aVar2.atM = (float) aVar.auW;
            aVar2.atN = (float) aVar.auX;
            aVar2.atO = (float) aVar.auY;
            aVar2.atP = (float) aVar.auZ;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = b.fq(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.avn)) {
                aVar2.atQ = b.fq(aVar.avn);
            }
            aVar2.atR = (float) aVar.fontSize;
            aVar2.atS = aVar.atS;
            com.baidu.g.a.b.a.zi().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.aub.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aub.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.src = aVar.src;
            aVar2.poster = aVar.poster;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.aub.getLayoutWidth();
            aVar2.height = (int) aVar.aub.getLayoutHeight();
            d.zj().a("video", view, aVar2, this.pageContext);
        }
    }

    private void b(View view, com.baidu.g.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.aub.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aub.getLayoutHeight());
            com.baidu.g.a.a.a aVar2 = new com.baidu.g.a.a.a();
            aVar2.src = aVar.src;
            aVar2.atL = (float) aVar.borderRadius;
            aVar2.atM = (float) aVar.auW;
            aVar2.atN = (float) aVar.auX;
            aVar2.atO = (float) aVar.auY;
            aVar2.atP = (float) aVar.auZ;
            d.zj().a("image", view, aVar2, this.pageContext);
        }
    }

    private void b(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.avm < -1.0d) {
                if (aVar.opacity > -1.0d) {
                    view.setAlpha((float) aVar.opacity);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.avm);
        }
    }

    private void b(Context context, View view, com.baidu.g.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.avl)) {
                String str5 = aVar.borderColor;
                str = aVar.avh;
                str2 = str5;
            } else {
                String str6 = aVar.avl;
                str = aVar.avq;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.avk)) {
                str3 = aVar.backgroundColor;
                str4 = aVar.avg;
            } else {
                str3 = aVar.avk;
                str4 = aVar.avp;
            }
            if (aVar.auV > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(b.fq(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) com.baidu.g.a.c.a.a(aVar.auV, f), b.fq(str2));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.auW, f), b(aVar.auY, f), b(aVar.auZ, f), b(aVar.auX, f)});
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(b.fq(str4));
                        } else {
                            gradientDrawable2.setColor(b.fq(str3));
                        }
                        gradientDrawable2.setStroke((int) com.baidu.g.a.c.a.a(aVar.auV, f), b.fq(str));
                        if (aVar.borderRadius > 0.0d) {
                            gradientDrawable2.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f));
                        } else {
                            gradientDrawable.setCornerRadii(new float[]{b(aVar.auW, f), b(aVar.auY, f), b(aVar.auZ, f), b(aVar.auX, f)});
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
                        gradientDrawable3.setColor(b.fq(str3));
                    }
                    float f2 = context.getResources().getDisplayMetrics().density;
                    gradientDrawable3.setStroke((int) com.baidu.g.a.c.a.a(aVar.auV, f2), b.fq(str2));
                    if (aVar.borderRadius > 0.0d) {
                        gradientDrawable3.setCornerRadius(com.baidu.g.a.c.a.a(aVar.borderRadius, f2));
                    } else {
                        gradientDrawable3.setCornerRadii(new float[]{b(aVar.auW, f2), b(aVar.auY, f2), b(aVar.auZ, f2), b(aVar.auX, f2)});
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.avk)) {
                if (!TextUtils.isEmpty(aVar.backgroundColor)) {
                    if (!TextUtils.isEmpty(aVar.avg)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(b.fq(aVar.avg));
                            ColorDrawable colorDrawable2 = new ColorDrawable(b.fq(aVar.backgroundColor));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(b.fq(aVar.backgroundColor));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.avp)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(b.fq(aVar.avp));
                    ColorDrawable colorDrawable4 = new ColorDrawable(b.fq(aVar.avk));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(b.fq(aVar.avk));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.g.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.avj)) {
                if (!TextUtils.isEmpty(aVar.auU)) {
                    d.zj().a(aVar.type, view, aVar.auU, aVar.avf);
                    return;
                }
                return;
            }
            d.zj().a(aVar.type, view, aVar.avj, aVar.avo);
        }
    }

    public View fo(String str) {
        return this.avu.get(str);
    }

    public View fp(String str) {
        return this.avv.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(com.baidu.g.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.auh);
        hashMap.put("data-url-stat", aVar.aui);
        return hashMap;
    }

    private float b(double d, float f) {
        return com.baidu.g.a.c.a.a(Math.max(d, 0.0d), f);
    }
}
