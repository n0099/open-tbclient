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
    private ViewGroup Ni;
    private InterfaceC0043a Nj;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> Ng = new HashMap();
    private Map<String, View> Nh = new HashMap();
    private boolean Nk = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0043a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0043a interfaceC0043a) {
        this.Nj = interfaceC0043a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.Nk = true;
        } else {
            this.Nk = a(aVar, this.criusData);
        }
        if (this.Ni == null || !this.Nk) {
            this.Ni = new RelativeLayout(context);
            this.Ni.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.Ni, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.Ni;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.LQ) || aVar.LQ.equals(aVar2.LQ)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.Ne != null) {
                    if (aVar2.Ne != null && aVar.Ne.size() == aVar2.Ne.size()) {
                        int size = aVar.Ne.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.Ne.get(i), aVar2.Ne.get(i))) {
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
            this.Nk = true;
            a(context, this.criusData, this.Ni, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view2, boolean z) throws Throwable {
        if (aVar != null && aVar.LA != null && view2 != null) {
            if (aVar.LA.getDisplay() == CriusDisplay.NONE) {
                view2.setVisibility(8);
            } else {
                view2.setVisibility(0);
            }
            if (aVar.LA.getLayoutWidth() > 0.0f) {
                if (view2.getLayoutParams() != null) {
                    view2.getLayoutParams().width = (int) aVar.LA.getLayoutWidth();
                } else {
                    view2.setMinimumWidth((int) aVar.LA.getLayoutWidth());
                }
            }
            if (aVar.LA.getLayoutHeight() > 0.0f) {
                if (view2.getLayoutParams() != null) {
                    view2.getLayoutParams().height = (int) aVar.LA.getLayoutHeight();
                } else {
                    view2.setMinimumHeight((int) aVar.LA.getLayoutHeight());
                }
            }
            if (aVar.LA.getLayoutX() > 0.0f) {
                view2.setX(aVar.LA.getLayoutX());
            }
            if (aVar.LA.getLayoutY() > 0.0f) {
                view2.setY(aVar.LA.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.LQ)) {
                a(aVar.LQ, view2, aVar, z);
            } else {
                a(context, view2, aVar, z);
            }
            a(context, view2, aVar);
            if (aVar.Ne != null && aVar.Ne.size() > 0) {
                for (int i = 0; i < aVar.Ne.size(); i++) {
                    View view3 = null;
                    if (this.Nk && (view2 instanceof ViewGroup)) {
                        view3 = ((ViewGroup) view2).getChildAt(i);
                    }
                    if (view3 == null) {
                        if (!TextUtils.isEmpty(aVar.Ne.get(i).LQ)) {
                            view3 = com.baidu.b.a.b.a.mb().H(context, aVar.Ne.get(i).LQ);
                            this.Ng.put(aVar.Ne.get(i).LQ, view3);
                        } else if ("view".equalsIgnoreCase(aVar.Ne.get(i).type)) {
                            view3 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.Ne.get(i).type)) {
                            view3 = d.mc().I(context, "image");
                            if (view3 == null) {
                                view3 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.Ne.get(i).type)) {
                            view3 = new TextView(context);
                            ((TextView) view3).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.Ne.get(i).type)) {
                            view3 = d.mc().I(context, "video");
                        } else {
                            view3 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.Ne.get(i).id)) {
                            this.Nh.put(aVar.Ne.get(i).id, view3);
                        }
                        ((ViewGroup) view2).addView(view3, i);
                    }
                    if ((view2 instanceof ViewGroup) && view3 != null) {
                        a(context, aVar.Ne.get(i), view3, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view2, final com.baidu.b.a.c.a aVar) {
        if (view2 != null && aVar != null && !TextUtils.isEmpty(aVar.LR)) {
            view2.setClickable(true);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (!TextUtils.isEmpty(aVar.LR)) {
                        if (a.this.Nj != null) {
                            a.this.Nj.b(aVar.LR, a.this.a(aVar));
                        } else {
                            c.J(context, aVar.LR);
                        }
                    }
                }
            });
        }
    }

    private void a(View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if ((view2 instanceof TextView) && aVar != null && !TextUtils.isEmpty(aVar.text)) {
            if (aVar.maxLines > 0) {
                if (aVar.maxLines == 1) {
                    ((TextView) view2).setSingleLine(true);
                } else {
                    ((TextView) view2).setSingleLine(false);
                }
                ((TextView) view2).setMaxLines(aVar.maxLines);
                ((TextView) view2).setEllipsize(TextUtils.TruncateAt.END);
            }
            if (!z || TextUtils.isEmpty(aVar.MZ)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.MU)) {
                        try {
                            TextView textView = (TextView) view2;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.MU), com.baidu.b.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view2).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Nd)) {
                try {
                    TextView textView2 = (TextView) view2;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.Nd), com.baidu.b.a.e.a.parseColor(aVar.MZ)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view2).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.MZ));
                } catch (Throwable th4) {
                }
            }
            if (aVar.MO >= 0.0d) {
                ((TextView) view2).setTextSize(0, (float) (aVar.MO * view2.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view2).setTypeface(aVar.MN);
            ((TextView) view2).setGravity(aVar.gravity);
            ((TextView) view2).setText(aVar.text);
        }
    }

    private void a(String str, View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view2.setMinimumWidth((int) aVar.LA.getLayoutWidth());
            view2.setMinimumHeight((int) aVar.LA.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.Ls = (float) aVar.MI;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.MZ)) {
                aVar2.Lt = com.baidu.b.a.e.a.parseColor(aVar.MZ);
            }
            aVar2.Lu = (float) aVar.MO;
            com.baidu.b.a.b.a.mb().a(str, view2, aVar2, z);
        }
    }

    private void a(Context context, View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (context != null && aVar != null) {
            d(view2, aVar, z);
            c(view2, aVar, z);
            b(context, view2, aVar, z);
            b(view2, aVar, z);
            a(view2, aVar);
            b(view2, aVar);
            a(view2, aVar, z);
        }
    }

    private void a(View view2, com.baidu.b.a.c.a aVar) {
        if (aVar != null && "video".equalsIgnoreCase(aVar.type)) {
            view2.setMinimumWidth((int) aVar.LA.getLayoutWidth());
            view2.setMinimumHeight((int) aVar.LA.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Lr = aVar.Lr;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.LA.getLayoutWidth();
            aVar2.height = (int) aVar.LA.getLayoutHeight();
            d.mc().a("video", view2, aVar2);
        }
    }

    private void b(View view2, com.baidu.b.a.c.a aVar) {
        if (view2 != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view2.setMinimumWidth((int) aVar.LA.getLayoutWidth());
            view2.setMinimumHeight((int) aVar.LA.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Ls = (float) aVar.MI;
            d.mc().a("image", view2, aVar2);
        }
    }

    private void b(View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (view2 != null && aVar != null) {
            if (!z || aVar.MY < -1.0d) {
                if (aVar.MJ > -1.0d) {
                    view2.setAlpha((float) aVar.MJ);
                    return;
                } else {
                    view2.setAlpha(1.0f);
                    return;
                }
            }
            view2.setAlpha((float) aVar.MY);
        }
    }

    private void b(Context context, View view2, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.MX)) {
                String str5 = aVar.MG;
                str = aVar.MT;
                str2 = str5;
            } else {
                String str6 = aVar.MX;
                str = aVar.Nc;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.MW)) {
                str3 = aVar.MF;
                str4 = aVar.MS;
            } else {
                str3 = aVar.MW;
                str4 = aVar.Nb;
            }
            if (aVar.MH > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.MH, f), com.baidu.b.a.e.a.parseColor(str2));
                        if (aVar.MI > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.MI, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.MH, f), com.baidu.b.a.e.a.parseColor(str));
                        if (aVar.MI > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.MI, f));
                        }
                        StateListDrawable stateListDrawable = new StateListDrawable();
                        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
                        stateListDrawable.addState(new int[]{-16842919}, gradientDrawable);
                        view2.setBackgroundDrawable(stateListDrawable);
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.MH, f2), com.baidu.b.a.e.a.parseColor(str2));
                    if (aVar.MI > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.MI, f2));
                    }
                    view2.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (view2 != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.MW)) {
                if (!TextUtils.isEmpty(aVar.MF)) {
                    if (!TextUtils.isEmpty(aVar.MS)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.MS));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.MF));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view2.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view2.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.MF));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Nb)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Nb));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.MW));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view2.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view2.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.MW));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (view2 != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.MV)) {
                if (!TextUtils.isEmpty(aVar.ME)) {
                    d.mc().a(aVar.type, view2, aVar.ME, aVar.MR);
                    return;
                }
                return;
            }
            d.mc().a(aVar.type, view2, aVar.MV, aVar.Na);
        }
    }

    public View bU(String str) {
        return this.Ng.get(str);
    }

    public View bV(String str) {
        return this.Nh.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.LS);
        hashMap.put("data-url-stat", aVar.LT);
        return hashMap;
    }
}
