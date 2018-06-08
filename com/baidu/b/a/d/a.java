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
    private ViewGroup Vs;
    private InterfaceC0054a Vt;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> Vq = new HashMap();
    private Map<String, View> Vr = new HashMap();
    private boolean Vu = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0054a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0054a interfaceC0054a) {
        this.Vt = interfaceC0054a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.Vu = true;
        } else {
            this.Vu = a(aVar, this.criusData);
        }
        if (this.Vs == null || !this.Vu) {
            this.Vs = new RelativeLayout(context);
            this.Vs.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.Vs, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.Vs;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.Ua) || aVar.Ua.equals(aVar2.Ua)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.Vo != null) {
                    if (aVar2.Vo != null && aVar.Vo.size() == aVar2.Vo.size()) {
                        int size = aVar.Vo.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.Vo.get(i), aVar2.Vo.get(i))) {
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

    public void s(Context context, boolean z) {
        try {
            this.Vu = true;
            a(context, this.criusData, this.Vs, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.TL != null && view != null) {
            if (aVar.TL.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.TL.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.TL.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.TL.getLayoutWidth());
                }
            }
            if (aVar.TL.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.TL.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.TL.getLayoutHeight());
                }
            }
            if (aVar.TL.getLayoutX() > 0.0f) {
                view.setX(aVar.TL.getLayoutX());
            }
            if (aVar.TL.getLayoutY() > 0.0f) {
                view.setY(aVar.TL.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.Ua)) {
                a(aVar.Ua, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.Vo != null && aVar.Vo.size() > 0) {
                for (int i = 0; i < aVar.Vo.size(); i++) {
                    View view2 = null;
                    if (this.Vu && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.Vo.get(i).Ua)) {
                            view2 = com.baidu.b.a.b.a.pr().J(context, aVar.Vo.get(i).Ua);
                            this.Vq.put(aVar.Vo.get(i).Ua, view2);
                        } else if ("view".equalsIgnoreCase(aVar.Vo.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.Vo.get(i).type)) {
                            view2 = d.ps().K(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.Vo.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.Vo.get(i).type)) {
                            view2 = d.ps().K(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.Vo.get(i).id)) {
                            this.Vr.put(aVar.Vo.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.Vo.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.Ub)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.Ub)) {
                        if (a.this.Vt != null) {
                            a.this.Vt.b(aVar.Ub, a.this.a(aVar));
                        } else {
                            c.L(context, aVar.Ub);
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
            if (!z || TextUtils.isEmpty(aVar.Vj)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.Ve)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.Ve), com.baidu.b.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Vn)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.Vn), com.baidu.b.a.e.a.parseColor(aVar.Vj)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.Vj));
                } catch (Throwable th4) {
                }
            }
            if (aVar.UY >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.UY * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.UX);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.TL.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TL.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.TC = (float) aVar.UT;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.Vj)) {
                aVar2.TD = com.baidu.b.a.e.a.parseColor(aVar.Vj);
            }
            aVar2.TF = (float) aVar.UY;
            com.baidu.b.a.b.a.pr().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.TL.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TL.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.TB = aVar.TB;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.TL.getLayoutWidth();
            aVar2.height = (int) aVar.TL.getLayoutHeight();
            d.ps().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.TL.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TL.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.TC = (float) aVar.UT;
            d.ps().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.Vi < -1.0d) {
                if (aVar.UU > -1.0d) {
                    view.setAlpha((float) aVar.UU);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.Vi);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Vh)) {
                String str5 = aVar.UR;
                str = aVar.Vd;
                str2 = str5;
            } else {
                String str6 = aVar.Vh;
                str = aVar.Vm;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.Vg)) {
                str3 = aVar.UQ;
                str4 = aVar.Vc;
            } else {
                str3 = aVar.Vg;
                str4 = aVar.Vl;
            }
            if (aVar.US > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.US, f), com.baidu.b.a.e.a.parseColor(str2));
                        if (aVar.UT > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.UT, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.US, f), com.baidu.b.a.e.a.parseColor(str));
                        if (aVar.UT > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.UT, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.US, f2), com.baidu.b.a.e.a.parseColor(str2));
                    if (aVar.UT > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.UT, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Vg)) {
                if (!TextUtils.isEmpty(aVar.UQ)) {
                    if (!TextUtils.isEmpty(aVar.Vc)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Vc));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.UQ));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.UQ));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Vl)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Vl));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Vg));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.Vg));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Vf)) {
                if (!TextUtils.isEmpty(aVar.UO)) {
                    d.ps().a(aVar.type, view, aVar.UO, aVar.Vb);
                    return;
                }
                return;
            }
            d.ps().a(aVar.type, view, aVar.Vf, aVar.Vk);
        }
    }

    public View cu(String str) {
        return this.Vq.get(str);
    }

    public View cv(String str) {
        return this.Vr.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.Uc);
        hashMap.put("data-url-stat", aVar.Ud);
        return hashMap;
    }
}
