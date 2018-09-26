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
    private ViewGroup XR;
    private InterfaceC0054a XS;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> XP = new HashMap();
    private Map<String, View> XQ = new HashMap();
    private boolean XT = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0054a {
        void c(String str, Map<String, String> map);
    }

    public void a(InterfaceC0054a interfaceC0054a) {
        this.XS = interfaceC0054a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.XT = true;
        } else {
            this.XT = a(aVar, this.criusData);
        }
        if (this.XR == null || !this.XT) {
            this.XR = new RelativeLayout(context);
            this.XR.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.XR, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.XR;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.WA) || aVar.WA.equals(aVar2.WA)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.XN != null) {
                    if (aVar2.XN != null && aVar.XN.size() == aVar2.XN.size()) {
                        int size = aVar.XN.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.XN.get(i), aVar2.XN.get(i))) {
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
            this.XT = true;
            a(context, this.criusData, this.XR, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.Wm != null && view != null) {
            if (aVar.Wm.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.Wm.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.Wm.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.Wm.getLayoutWidth());
                }
            }
            if (aVar.Wm.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.Wm.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.Wm.getLayoutHeight());
                }
            }
            if (aVar.Wm.getLayoutX() > 0.0f) {
                view.setX(aVar.Wm.getLayoutX());
            }
            if (aVar.Wm.getLayoutY() > 0.0f) {
                view.setY(aVar.Wm.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.WA)) {
                a(aVar.WA, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.XN != null && aVar.XN.size() > 0) {
                for (int i = 0; i < aVar.XN.size(); i++) {
                    View view2 = null;
                    if (this.XT && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.XN.get(i).WA)) {
                            view2 = com.baidu.b.a.b.a.qx().Y(context, aVar.XN.get(i).WA);
                            this.XP.put(aVar.XN.get(i).WA, view2);
                        } else if ("view".equalsIgnoreCase(aVar.XN.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if (TbConfig.TMP_PIC_DIR_NAME.equalsIgnoreCase(aVar.XN.get(i).type)) {
                            view2 = d.qy().Z(context, TbConfig.TMP_PIC_DIR_NAME);
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.XN.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.XN.get(i).type)) {
                            view2 = d.qy().Z(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.XN.get(i).id)) {
                            this.XQ.put(aVar.XN.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.XN.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.WB)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.WB)) {
                        if (a.this.XS != null) {
                            a.this.XS.c(aVar.WB, a.this.a(aVar));
                        } else {
                            c.aa(context, aVar.WB);
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
            if (!z || TextUtils.isEmpty(aVar.XI)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.XD)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.XD), com.baidu.b.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.XM)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.XM), com.baidu.b.a.e.a.parseColor(aVar.XI)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.XI));
                } catch (Throwable th4) {
                }
            }
            if (aVar.Xx >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.Xx * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.Xw);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            if (aVar.WK > 0.0d) {
                ((TextView) view).setLineSpacing((float) aVar.WK, 1.0f);
            }
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.Wm.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Wm.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.We = (float) aVar.Xs;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.XI)) {
                aVar2.Wf = com.baidu.b.a.e.a.parseColor(aVar.XI);
            }
            aVar2.Wg = (float) aVar.Xx;
            com.baidu.b.a.b.a.qx().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.Wm.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Wm.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.Wd = aVar.Wd;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.Wm.getLayoutWidth();
            aVar2.height = (int) aVar.Wm.getLayoutHeight();
            d.qy().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && TbConfig.TMP_PIC_DIR_NAME.equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.Wm.getLayoutWidth());
            view.setMinimumHeight((int) aVar.Wm.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.We = (float) aVar.Xs;
            d.qy().a(TbConfig.TMP_PIC_DIR_NAME, view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.XH < -1.0d) {
                if (aVar.Xt > -1.0d) {
                    view.setAlpha((float) aVar.Xt);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.XH);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.XG)) {
                String str5 = aVar.Xq;
                str = aVar.XC;
                str2 = str5;
            } else {
                String str6 = aVar.XG;
                str = aVar.XL;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.XF)) {
                str3 = aVar.Xp;
                str4 = aVar.XB;
            } else {
                str3 = aVar.XF;
                str4 = aVar.XK;
            }
            if (aVar.Xr > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.Xr, f), com.baidu.b.a.e.a.parseColor(str2));
                        if (aVar.Xs > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.Xs, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.Xr, f), com.baidu.b.a.e.a.parseColor(str));
                        if (aVar.Xs > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.Xs, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.Xr, f2), com.baidu.b.a.e.a.parseColor(str2));
                    if (aVar.Xs > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.Xs, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.XF)) {
                if (!TextUtils.isEmpty(aVar.Xp)) {
                    if (!TextUtils.isEmpty(aVar.XB)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.XB));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.Xp));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.Xp));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.XK)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.XK));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.XF));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.XF));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.XE)) {
                if (!TextUtils.isEmpty(aVar.Xo)) {
                    d.qy().a(aVar.type, view, aVar.Xo, aVar.XA);
                    return;
                }
                return;
            }
            d.qy().a(aVar.type, view, aVar.XE, aVar.XJ);
        }
    }

    public View cN(String str) {
        return this.XP.get(str);
    }

    public View cO(String str) {
        return this.XQ.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.WC);
        hashMap.put("data-url-stat", aVar.WD);
        return hashMap;
    }
}
