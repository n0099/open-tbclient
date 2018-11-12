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
    private ViewGroup acu;
    private InterfaceC0070a acv;
    private com.baidu.c.a.c.a criusData;
    private Map<String, View> acs = new HashMap();
    private Map<String, View> act = new HashMap();
    private boolean acx = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0070a {
        void d(String str, Map<String, String> map);
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.acv = interfaceC0070a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.acx = true;
        } else {
            this.acx = a(aVar, this.criusData);
        }
        if (this.acu == null || !this.acx) {
            this.acu = new RelativeLayout(context);
            this.acu.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.acu, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.acu;
    }

    private boolean a(com.baidu.c.a.c.a aVar, com.baidu.c.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.abd) || aVar.abd.equals(aVar2.abd)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.acq != null) {
                    if (aVar2.acq != null && aVar.acq.size() == aVar2.acq.size()) {
                        int size = aVar.acq.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.acq.get(i), aVar2.acq.get(i))) {
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
            this.acx = true;
            a(context, this.criusData, this.acu, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.aaO != null && view != null) {
            if (aVar.aaO.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.aaO.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.aaO.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.aaO.getLayoutWidth());
                }
            }
            if (aVar.aaO.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.aaO.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.aaO.getLayoutHeight());
                }
            }
            if (aVar.aaO.getLayoutX() > 0.0f) {
                view.setX(aVar.aaO.getLayoutX());
            }
            if (aVar.aaO.getLayoutY() > 0.0f) {
                view.setY(aVar.aaO.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.abd)) {
                a(aVar.abd, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.acq != null && aVar.acq.size() > 0) {
                for (int i = 0; i < aVar.acq.size(); i++) {
                    View view2 = null;
                    if (this.acx && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.acq.get(i).abd)) {
                            view2 = com.baidu.c.a.b.a.sn().Z(context, aVar.acq.get(i).abd);
                            this.acs.put(aVar.acq.get(i).abd, view2);
                        } else if ("view".equalsIgnoreCase(aVar.acq.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.acq.get(i).type)) {
                            view2 = d.so().aa(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.acq.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.acq.get(i).type)) {
                            view2 = d.so().aa(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.acq.get(i).id)) {
                            this.act.put(aVar.acq.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.acq.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.abe)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.abe)) {
                        if (a.this.acv != null) {
                            a.this.acv.d(aVar.abe, a.this.a(aVar));
                        } else {
                            c.ab(context, aVar.abe);
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
            if (!z || TextUtils.isEmpty(aVar.acl)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.acg)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.acg), com.baidu.c.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acp)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.acp), com.baidu.c.a.e.a.parseColor(aVar.acl)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.acl));
                } catch (Throwable th4) {
                }
            }
            if (aVar.aca >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.aca * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.abZ);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            if (aVar.abn > 0.0d) {
                ((TextView) view).setLineSpacing((float) aVar.abn, 1.0f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.aaO.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaO.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.borderRadius = (float) aVar.abV;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.c.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.acl)) {
                aVar2.aaI = com.baidu.c.a.e.a.parseColor(aVar.acl);
            }
            aVar2.fontSize = (float) aVar.aca;
            com.baidu.c.a.b.a.sn().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.aaO.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaO.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aaH = aVar.aaH;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.aaO.getLayoutWidth();
            aVar2.height = (int) aVar.aaO.getLayoutHeight();
            d.so().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.aaO.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaO.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.borderRadius = (float) aVar.abV;
            d.so().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.ack < -1.0d) {
                if (aVar.abW > -1.0d) {
                    view.setAlpha((float) aVar.abW);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.ack);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acj)) {
                String str5 = aVar.abT;
                str = aVar.acf;
                str2 = str5;
            } else {
                String str6 = aVar.acj;
                str = aVar.aco;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.aci)) {
                str3 = aVar.abS;
                str4 = aVar.ace;
            } else {
                str3 = aVar.aci;
                str4 = aVar.acn;
            }
            if (aVar.abU > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.abU, f), com.baidu.c.a.e.a.parseColor(str2));
                        if (aVar.abV > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.abV, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.abU, f), com.baidu.c.a.e.a.parseColor(str));
                        if (aVar.abV > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.abV, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.abU, f2), com.baidu.c.a.e.a.parseColor(str2));
                    if (aVar.abV > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.abV, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.aci)) {
                if (!TextUtils.isEmpty(aVar.abS)) {
                    if (!TextUtils.isEmpty(aVar.ace)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.ace));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.abS));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.abS));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acn)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.acn));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.aci));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.aci));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.ach)) {
                if (!TextUtils.isEmpty(aVar.abR)) {
                    d.so().a(aVar.type, view, aVar.abR, aVar.acd);
                    return;
                }
                return;
            }
            d.so().a(aVar.type, view, aVar.ach, aVar.acm);
        }
    }

    public View da(String str) {
        return this.acs.get(str);
    }

    public View db(String str) {
        return this.act.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.abf);
        hashMap.put("data-url-stat", aVar.abg);
        return hashMap;
    }
}
