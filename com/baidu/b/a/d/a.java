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
    private ViewGroup aAW;
    private InterfaceC0054a aAX;
    private com.baidu.b.a.c.a criusData;
    private Map<String, View> aAU = new HashMap();
    private Map<String, View> aAV = new HashMap();
    private boolean aAY = false;

    /* renamed from: com.baidu.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0054a {
        void b(String str, Map<String, String> map);
    }

    public void a(InterfaceC0054a interfaceC0054a) {
        this.aAX = interfaceC0054a;
    }

    public ViewGroup a(Context context, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.aAY = true;
        } else {
            this.aAY = a(aVar, this.criusData);
        }
        if (this.aAW == null || !this.aAY) {
            this.aAW = new RelativeLayout(context);
            this.aAW.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.aAW, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.aAW;
    }

    private boolean a(com.baidu.b.a.c.a aVar, com.baidu.b.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.azF) || aVar.azF.equals(aVar2.azF)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.aAS != null) {
                    if (aVar2.aAS != null && aVar.aAS.size() == aVar2.aAS.size()) {
                        int size = aVar.aAS.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.aAS.get(i), aVar2.aAS.get(i))) {
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
            a(context, this.criusData, this.aAW, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.b.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.azr != null && view != null) {
            if (aVar.azr.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.azr.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.azr.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.azr.getLayoutWidth());
                }
            }
            if (aVar.azr.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.azr.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.azr.getLayoutHeight());
                }
            }
            if (aVar.azr.getLayoutX() > 0.0f) {
                view.setX(aVar.azr.getLayoutX());
            }
            if (aVar.azr.getLayoutY() > 0.0f) {
                view.setY(aVar.azr.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.azF)) {
                a(aVar.azF, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.aAS != null && aVar.aAS.size() > 0) {
                for (int i = 0; i < aVar.aAS.size(); i++) {
                    View view2 = null;
                    if (this.aAY && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.aAS.get(i).azF)) {
                            view2 = com.baidu.b.a.b.a.tw().M(context, aVar.aAS.get(i).azF);
                            this.aAU.put(aVar.aAS.get(i).azF, view2);
                        } else if ("view".equalsIgnoreCase(aVar.aAS.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.aAS.get(i).type)) {
                            view2 = d.tx().N(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.aAS.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.aAS.get(i).type)) {
                            view2 = d.tx().N(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.aAS.get(i).id)) {
                            this.aAV.put(aVar.aAS.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.aAS.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.azG)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.b.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.azG)) {
                        if (a.this.aAX != null) {
                            a.this.aAX.b(aVar.azG, a.this.a(aVar));
                        } else {
                            c.O(context, aVar.azG);
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
            if (!z || TextUtils.isEmpty(aVar.aAN)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.aAI)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.aAI), com.baidu.b.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.aAR)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.b.a.e.a.parseColor(aVar.aAR), com.baidu.b.a.e.a.parseColor(aVar.aAN)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.b.a.e.a.parseColor(aVar.aAN));
                } catch (Throwable th4) {
                }
            }
            if (aVar.aAC >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.aAC * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.aAB);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
        }
    }

    private void a(String str, View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.azr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.azr.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.azj = (float) aVar.aAx;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.b.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.aAN)) {
                aVar2.azk = com.baidu.b.a.e.a.parseColor(aVar.aAN);
            }
            aVar2.azl = (float) aVar.aAC;
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
            view.setMinimumWidth((int) aVar.azr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.azr.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.azi = aVar.azi;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.azr.getLayoutWidth();
            aVar2.height = (int) aVar.azr.getLayoutHeight();
            d.tx().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.azr.getLayoutWidth());
            view.setMinimumHeight((int) aVar.azr.getLayoutHeight());
            com.baidu.b.a.a.a aVar2 = new com.baidu.b.a.a.a();
            aVar2.src = aVar.src;
            aVar2.azj = (float) aVar.aAx;
            d.tx().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.aAM < -1.0d) {
                if (aVar.aAy > -1.0d) {
                    view.setAlpha((float) aVar.aAy);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.aAM);
        }
    }

    private void b(Context context, View view, com.baidu.b.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aAL)) {
                String str5 = aVar.aAv;
                str = aVar.aAH;
                str2 = str5;
            } else {
                String str6 = aVar.aAL;
                str = aVar.aAQ;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.aAK)) {
                str3 = aVar.aAu;
                str4 = aVar.aAG;
            } else {
                str3 = aVar.aAK;
                str4 = aVar.aAP;
            }
            if (aVar.aAw > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.aAw, f), com.baidu.b.a.e.a.parseColor(str2));
                        if (aVar.aAx > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.aAx, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.b.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.aAw, f), com.baidu.b.a.e.a.parseColor(str));
                        if (aVar.aAx > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.aAx, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.aAw, f2), com.baidu.b.a.e.a.parseColor(str2));
                    if (aVar.aAx > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.aAx, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aAK)) {
                if (!TextUtils.isEmpty(aVar.aAu)) {
                    if (!TextUtils.isEmpty(aVar.aAG)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.aAG));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.aAu));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.aAu));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.aAP)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.aAP));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.b.a.e.a.parseColor(aVar.aAK));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.b.a.e.a.parseColor(aVar.aAK));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.b.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aAJ)) {
                if (!TextUtils.isEmpty(aVar.aAt)) {
                    d.tx().a(aVar.type, view, aVar.aAt, aVar.aAF);
                    return;
                }
                return;
            }
            d.tx().a(aVar.type, view, aVar.aAJ, aVar.aAO);
        }
    }

    public View bX(String str) {
        return this.aAU.get(str);
    }

    public View bY(String str) {
        return this.aAV.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.b.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.azH);
        hashMap.put("data-url-stat", aVar.azI);
        return hashMap;
    }
}
