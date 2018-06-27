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
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private ViewGroup Vu;
    private InterfaceC0054a Vv;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> Vs = new HashMap();
    private Map<String, View> Vt = new HashMap();
    private boolean Vw = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0054a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0054a interfaceC0054a) {
        this.Vv = interfaceC0054a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.Vw = true;
        } else {
            this.Vw = a(aVar, this.criusData);
        }
        if (this.Vu == null || !this.Vw) {
            this.Vu = new RelativeLayout(context);
            this.Vu.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.Vu, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.Vu;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.Uc) || aVar.Uc.equals(aVar2.Uc)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.Vq != null) {
                    if (aVar2.Vq != null && aVar.Vq.size() == aVar2.Vq.size()) {
                        int size = aVar.Vq.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.Vq.get(i), aVar2.Vq.get(i))) {
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
            this.Vw = true;
            a(context, this.criusData, this.Vu, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.TO != null && view != null) {
            if (aVar.TO.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.TO.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.TO.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.TO.getLayoutWidth());
                }
            }
            if (aVar.TO.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.TO.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.TO.getLayoutHeight());
                }
            }
            if (aVar.TO.getLayoutX() > 0.0f) {
                view.setX(aVar.TO.getLayoutX());
            }
            if (aVar.TO.getLayoutY() > 0.0f) {
                view.setY(aVar.TO.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.Uc)) {
                a(aVar.Uc, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.Vq != null && aVar.Vq.size() > 0) {
                for (int i = 0; i < aVar.Vq.size(); i++) {
                    View view2 = null;
                    if (this.Vw && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.Vq.get(i).Uc)) {
                            view2 = com.baidu.b.a.b.a.pr().J(context, aVar.Vq.get(i).Uc);
                            this.Vs.put(aVar.Vq.get(i).Uc, view2);
                        } else if ("view".equalsIgnoreCase(aVar.Vq.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if (TbConfig.TMP_PIC_DIR_NAME.equalsIgnoreCase(aVar.Vq.get(i).type)) {
                            view2 = d.ps().K(context, TbConfig.TMP_PIC_DIR_NAME);
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.Vq.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.Vq.get(i).type)) {
                            view2 = d.ps().K(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.Vq.get(i).id)) {
                            this.Vt.put(aVar.Vq.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.Vq.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.Ud)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.Ud)) {
                        if (a.this.Vv != null) {
                            a.this.Vv.b(aVar.Ud, a.this.a(aVar));
                        } else {
                            c.L(context, aVar.Ud);
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
            if (!z || TextUtils.isEmpty(aVar.Vl)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.Vg)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.Vg), com.baidu.b.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Vp)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.Vp), com.baidu.b.a.e.a.parseColor(aVar.Vl)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.Vl));
                } catch (Throwable th4) {
                }
            }
            if (aVar.Va >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.Va * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.UZ);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.TO.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TO.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.TF = (float) aVar.UV;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.Vl)) {
                aVar2.TG = com.baidu.b.a.e.a.parseColor(aVar.Vl);
            }
            aVar2.TH = (float) aVar.Va;
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
            view.setMinimumWidth((int) aVar.TO.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TO.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.TD = aVar.TD;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.TO.getLayoutWidth();
            aVar2.height = (int) aVar.TO.getLayoutHeight();
            d.ps().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && TbConfig.TMP_PIC_DIR_NAME.equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.TO.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TO.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.TF = (float) aVar.UV;
            d.ps().a(TbConfig.TMP_PIC_DIR_NAME, view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.Vk < -1.0d) {
                if (aVar.UW > -1.0d) {
                    view.setAlpha((float) aVar.UW);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.Vk);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Vj)) {
                String str5 = aVar.UT;
                str = aVar.Vf;
                str2 = str5;
            } else {
                String str6 = aVar.Vj;
                str = aVar.Vo;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.Vi)) {
                str3 = aVar.US;
                str4 = aVar.Ve;
            } else {
                str3 = aVar.Vi;
                str4 = aVar.Vn;
            }
            if (aVar.UU > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.UU, f), com.baidu.b.a.e.a.parseColor(str2));
                        if (aVar.UV > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.UV, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.UU, f), com.baidu.b.a.e.a.parseColor(str));
                        if (aVar.UV > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.UV, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.UU, f2), com.baidu.b.a.e.a.parseColor(str2));
                    if (aVar.UV > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.UV, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Vi)) {
                if (!TextUtils.isEmpty(aVar.US)) {
                    if (!TextUtils.isEmpty(aVar.Ve)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Ve));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.US));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.US));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Vn)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Vn));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Vi));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.Vi));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Vh)) {
                if (!TextUtils.isEmpty(aVar.UR)) {
                    d.ps().a(aVar.type, view, aVar.UR, aVar.Vd);
                    return;
                }
                return;
            }
            d.ps().a(aVar.type, view, aVar.Vh, aVar.Vm);
        }
    }

    public View cw(String str) {
        return this.Vs.get(str);
    }

    public View cx(String str) {
        return this.Vt.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.Ue);
        hashMap.put("data-url-stat", aVar.Uf);
        return hashMap;
    }
}
