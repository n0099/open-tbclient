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
    private ViewGroup Vq;
    private InterfaceC0054a Vr;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> Vo = new HashMap();
    private Map<String, View> Vp = new HashMap();
    private boolean Vs = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0054a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0054a interfaceC0054a) {
        this.Vr = interfaceC0054a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.Vs = true;
        } else {
            this.Vs = a(aVar, this.criusData);
        }
        if (this.Vq == null || !this.Vs) {
            this.Vq = new RelativeLayout(context);
            this.Vq.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.Vq, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.Vq;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.TY) || aVar.TY.equals(aVar2.TY)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.Vm != null) {
                    if (aVar2.Vm != null && aVar.Vm.size() == aVar2.Vm.size()) {
                        int size = aVar.Vm.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.Vm.get(i), aVar2.Vm.get(i))) {
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
            this.Vs = true;
            a(context, this.criusData, this.Vq, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.TJ != null && view != null) {
            if (aVar.TJ.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.TJ.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.TJ.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.TJ.getLayoutWidth());
                }
            }
            if (aVar.TJ.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.TJ.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.TJ.getLayoutHeight());
                }
            }
            if (aVar.TJ.getLayoutX() > 0.0f) {
                view.setX(aVar.TJ.getLayoutX());
            }
            if (aVar.TJ.getLayoutY() > 0.0f) {
                view.setY(aVar.TJ.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.TY)) {
                a(aVar.TY, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.Vm != null && aVar.Vm.size() > 0) {
                for (int i = 0; i < aVar.Vm.size(); i++) {
                    View view2 = null;
                    if (this.Vs && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.Vm.get(i).TY)) {
                            view2 = com.baidu.b.a.b.a.ps().K(context, aVar.Vm.get(i).TY);
                            this.Vo.put(aVar.Vm.get(i).TY, view2);
                        } else if ("view".equalsIgnoreCase(aVar.Vm.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if (TbConfig.TMP_PIC_DIR_NAME.equalsIgnoreCase(aVar.Vm.get(i).type)) {
                            view2 = d.pt().L(context, TbConfig.TMP_PIC_DIR_NAME);
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.Vm.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.Vm.get(i).type)) {
                            view2 = d.pt().L(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.Vm.get(i).id)) {
                            this.Vp.put(aVar.Vm.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.Vm.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.TZ)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.TZ)) {
                        if (a.this.Vr != null) {
                            a.this.Vr.b(aVar.TZ, a.this.a(aVar));
                        } else {
                            c.M(context, aVar.TZ);
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
            if (!z || TextUtils.isEmpty(aVar.Vh)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.Vc)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.Vc), com.baidu.b.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Vl)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.Vl), com.baidu.b.a.e.a.parseColor(aVar.Vh)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.Vh));
                } catch (Throwable th4) {
                }
            }
            if (aVar.UW >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.UW * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.UV);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.TJ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TJ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.TB = (float) aVar.UR;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.Vh)) {
                aVar2.TC = com.baidu.b.a.e.a.parseColor(aVar.Vh);
            }
            aVar2.TD = (float) aVar.UW;
            com.baidu.b.a.b.a.ps().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.TJ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TJ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.TA = aVar.TA;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.TJ.getLayoutWidth();
            aVar2.height = (int) aVar.TJ.getLayoutHeight();
            d.pt().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && TbConfig.TMP_PIC_DIR_NAME.equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.TJ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.TJ.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.TB = (float) aVar.UR;
            d.pt().a(TbConfig.TMP_PIC_DIR_NAME, view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.Vg < -1.0d) {
                if (aVar.US > -1.0d) {
                    view.setAlpha((float) aVar.US);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.Vg);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Vf)) {
                String str5 = aVar.UO;
                str = aVar.Vb;
                str2 = str5;
            } else {
                String str6 = aVar.Vf;
                str = aVar.Vk;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.Ve)) {
                str3 = aVar.UN;
                str4 = aVar.Va;
            } else {
                str3 = aVar.Ve;
                str4 = aVar.Vj;
            }
            if (aVar.UQ > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.UQ, f), com.baidu.b.a.e.a.parseColor(str2));
                        if (aVar.UR > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.UR, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.UQ, f), com.baidu.b.a.e.a.parseColor(str));
                        if (aVar.UR > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.UR, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.UQ, f2), com.baidu.b.a.e.a.parseColor(str2));
                    if (aVar.UR > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.UR, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Ve)) {
                if (!TextUtils.isEmpty(aVar.UN)) {
                    if (!TextUtils.isEmpty(aVar.Va)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Va));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.UN));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.UN));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Vj)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Vj));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Ve));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.Ve));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Vd)) {
                if (!TextUtils.isEmpty(aVar.UM)) {
                    d.pt().a(aVar.type, view, aVar.UM, aVar.UZ);
                    return;
                }
                return;
            }
            d.pt().a(aVar.type, view, aVar.Vd, aVar.Vi);
        }
    }

    public View cx(String str) {
        return this.Vo.get(str);
    }

    public View cy(String str) {
        return this.Vp.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.Ua);
        hashMap.put("data-url-stat", aVar.Ub);
        return hashMap;
    }
}
