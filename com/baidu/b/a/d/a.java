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
    private ViewGroup Nm;
    private InterfaceC0043a Nn;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> Nk = new HashMap();
    private Map<String, View> Nl = new HashMap();
    private boolean No = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0043a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0043a interfaceC0043a) {
        this.Nn = interfaceC0043a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.No = true;
        } else {
            this.No = a(aVar, this.criusData);
        }
        if (this.Nm == null || !this.No) {
            this.Nm = new RelativeLayout(context);
            this.Nm.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.Nm, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.Nm;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.LU) || aVar.LU.equals(aVar2.LU)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.Ni != null) {
                    if (aVar2.Ni != null && aVar.Ni.size() == aVar2.Ni.size()) {
                        int size = aVar.Ni.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.Ni.get(i), aVar2.Ni.get(i))) {
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
            this.No = true;
            a(context, this.criusData, this.Nm, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view2, boolean z) throws Throwable {
        if (aVar != null && aVar.LE != null && view2 != null) {
            if (aVar.LE.getDisplay() == CriusDisplay.NONE) {
                view2.setVisibility(8);
            } else {
                view2.setVisibility(0);
            }
            if (aVar.LE.getLayoutWidth() > 0.0f) {
                if (view2.getLayoutParams() != null) {
                    view2.getLayoutParams().width = (int) aVar.LE.getLayoutWidth();
                } else {
                    view2.setMinimumWidth((int) aVar.LE.getLayoutWidth());
                }
            }
            if (aVar.LE.getLayoutHeight() > 0.0f) {
                if (view2.getLayoutParams() != null) {
                    view2.getLayoutParams().height = (int) aVar.LE.getLayoutHeight();
                } else {
                    view2.setMinimumHeight((int) aVar.LE.getLayoutHeight());
                }
            }
            if (aVar.LE.getLayoutX() > 0.0f) {
                view2.setX(aVar.LE.getLayoutX());
            }
            if (aVar.LE.getLayoutY() > 0.0f) {
                view2.setY(aVar.LE.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.LU)) {
                a(aVar.LU, view2, aVar, z);
            } else {
                a(context, view2, aVar, z);
            }
            a(context, view2, aVar);
            if (aVar.Ni != null && aVar.Ni.size() > 0) {
                for (int i = 0; i < aVar.Ni.size(); i++) {
                    View view3 = null;
                    if (this.No && (view2 instanceof ViewGroup)) {
                        view3 = ((ViewGroup) view2).getChildAt(i);
                    }
                    if (view3 == null) {
                        if (!TextUtils.isEmpty(aVar.Ni.get(i).LU)) {
                            view3 = com.baidu.b.a.b.a.mc().H(context, aVar.Ni.get(i).LU);
                            this.Nk.put(aVar.Ni.get(i).LU, view3);
                        } else if ("view".equalsIgnoreCase(aVar.Ni.get(i).type)) {
                            view3 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.Ni.get(i).type)) {
                            view3 = d.md().I(context, "image");
                            if (view3 == null) {
                                view3 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.Ni.get(i).type)) {
                            view3 = new TextView(context);
                            ((TextView) view3).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.Ni.get(i).type)) {
                            view3 = d.md().I(context, "video");
                        } else {
                            view3 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.Ni.get(i).id)) {
                            this.Nl.put(aVar.Ni.get(i).id, view3);
                        }
                        ((ViewGroup) view2).addView(view3, i);
                    }
                    if ((view2 instanceof ViewGroup) && view3 != null) {
                        a(context, aVar.Ni.get(i), view3, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view2, final com.baidu.b.a.c.a aVar) {
        if (view2 != null && aVar != null && !TextUtils.isEmpty(aVar.LV)) {
            view2.setClickable(true);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (!TextUtils.isEmpty(aVar.LV)) {
                        if (a.this.Nn != null) {
                            a.this.Nn.b(aVar.LV, a.this.a(aVar));
                        } else {
                            c.J(context, aVar.LV);
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
            if (!z || TextUtils.isEmpty(aVar.Nd)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.MY)) {
                        try {
                            TextView textView = (TextView) view2;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.MY), com.baidu.b.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view2).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Nh)) {
                try {
                    TextView textView2 = (TextView) view2;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.Nh), com.baidu.b.a.e.a.parseColor(aVar.Nd)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view2).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.Nd));
                } catch (Throwable th4) {
                }
            }
            if (aVar.MS >= 0.0d) {
                ((TextView) view2).setTextSize(0, (float) (aVar.MS * view2.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view2).setTypeface(aVar.MR);
            ((TextView) view2).setGravity(aVar.gravity);
            ((TextView) view2).setText(aVar.text);
        }
    }

    private void a(String str, View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view2.setMinimumWidth((int) aVar.LE.getLayoutWidth());
            view2.setMinimumHeight((int) aVar.LE.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.Lw = (float) aVar.MN;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.Nd)) {
                aVar2.Lx = com.baidu.b.a.e.a.parseColor(aVar.Nd);
            }
            aVar2.Ly = (float) aVar.MS;
            com.baidu.b.a.b.a.mc().a(str, view2, aVar2, z);
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
            view2.setMinimumWidth((int) aVar.LE.getLayoutWidth());
            view2.setMinimumHeight((int) aVar.LE.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Lv = aVar.Lv;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.LE.getLayoutWidth();
            aVar2.height = (int) aVar.LE.getLayoutHeight();
            d.md().a("video", view2, aVar2);
        }
    }

    private void b(View view2, com.baidu.b.a.c.a aVar) {
        if (view2 != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view2.setMinimumWidth((int) aVar.LE.getLayoutWidth());
            view2.setMinimumHeight((int) aVar.LE.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Lw = (float) aVar.MN;
            d.md().a("image", view2, aVar2);
        }
    }

    private void b(View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (view2 != null && aVar != null) {
            if (!z || aVar.Nc < -1.0d) {
                if (aVar.MO > -1.0d) {
                    view2.setAlpha((float) aVar.MO);
                    return;
                } else {
                    view2.setAlpha(1.0f);
                    return;
                }
            }
            view2.setAlpha((float) aVar.Nc);
        }
    }

    private void b(Context context, View view2, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Nb)) {
                String str5 = aVar.MK;
                str = aVar.MX;
                str2 = str5;
            } else {
                String str6 = aVar.Nb;
                str = aVar.Ng;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.Na)) {
                str3 = aVar.MJ;
                str4 = aVar.MW;
            } else {
                str3 = aVar.Na;
                str4 = aVar.Nf;
            }
            if (aVar.MM > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.MM, f), com.baidu.b.a.e.a.parseColor(str2));
                        if (aVar.MN > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.MN, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.MM, f), com.baidu.b.a.e.a.parseColor(str));
                        if (aVar.MN > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.MN, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.MM, f2), com.baidu.b.a.e.a.parseColor(str2));
                    if (aVar.MN > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.MN, f2));
                    }
                    view2.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (view2 != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.Na)) {
                if (!TextUtils.isEmpty(aVar.MJ)) {
                    if (!TextUtils.isEmpty(aVar.MW)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.MW));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.MJ));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view2.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view2.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.MJ));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.Nf)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Nf));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Na));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view2.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view2.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.Na));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view2, com.baidu.b.a.c.a aVar, boolean z) {
        if (view2 != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.MZ)) {
                if (!TextUtils.isEmpty(aVar.MI)) {
                    d.md().a(aVar.type, view2, aVar.MI, aVar.MV);
                    return;
                }
                return;
            }
            d.md().a(aVar.type, view2, aVar.MZ, aVar.Ne);
        }
    }

    public View bU(String str) {
        return this.Nk.get(str);
    }

    public View bV(String str) {
        return this.Nl.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.LW);
        hashMap.put("data-url-stat", aVar.LX);
        return hashMap;
    }
}
