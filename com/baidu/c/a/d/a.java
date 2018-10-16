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
    private ViewGroup acx;
    private InterfaceC0070a acy;
    private com.baidu.c.a.c.a criusData;
    private Map<String, View> acv = new HashMap();
    private Map<String, View> acw = new HashMap();
    private boolean acz = false;

    /* renamed from: com.baidu.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0070a {
        void d(String str, Map<String, String> map);
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.acy = interfaceC0070a;
    }

    public ViewGroup a(Context context, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar == this.criusData) {
            this.acz = true;
        } else {
            this.acz = a(aVar, this.criusData);
        }
        if (this.acx == null || !this.acz) {
            this.acx = new RelativeLayout(context);
            this.acx.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.criusData = aVar;
        try {
            a(context, aVar, this.acx, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.acx;
    }

    private boolean a(com.baidu.c.a.c.a aVar, com.baidu.c.a.c.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.abf) || aVar.abf.equals(aVar2.abf)) {
            if (TextUtils.isEmpty(aVar.type) || aVar.type.equals(aVar2.type)) {
                if (aVar.act != null) {
                    if (aVar2.act != null && aVar.act.size() == aVar2.act.size()) {
                        int size = aVar.act.size();
                        for (int i = 0; i < size; i++) {
                            if (!a(aVar.act.get(i), aVar2.act.get(i))) {
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
            this.acz = true;
            a(context, this.criusData, this.acx, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, com.baidu.c.a.c.a aVar, View view, boolean z) throws Throwable {
        if (aVar != null && aVar.aaQ != null && view != null) {
            if (aVar.aaQ.getDisplay() == CriusDisplay.NONE) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            if (aVar.aaQ.getLayoutWidth() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().width = (int) aVar.aaQ.getLayoutWidth();
                } else {
                    view.setMinimumWidth((int) aVar.aaQ.getLayoutWidth());
                }
            }
            if (aVar.aaQ.getLayoutHeight() > 0.0f) {
                if (view.getLayoutParams() != null) {
                    view.getLayoutParams().height = (int) aVar.aaQ.getLayoutHeight();
                } else {
                    view.setMinimumHeight((int) aVar.aaQ.getLayoutHeight());
                }
            }
            if (aVar.aaQ.getLayoutX() > 0.0f) {
                view.setX(aVar.aaQ.getLayoutX());
            }
            if (aVar.aaQ.getLayoutY() > 0.0f) {
                view.setY(aVar.aaQ.getLayoutY());
            }
            if (!TextUtils.isEmpty(aVar.abf)) {
                a(aVar.abf, view, aVar, z);
            } else {
                a(context, view, aVar, z);
            }
            a(context, view, aVar);
            if (aVar.act != null && aVar.act.size() > 0) {
                for (int i = 0; i < aVar.act.size(); i++) {
                    View view2 = null;
                    if (this.acz && (view instanceof ViewGroup)) {
                        view2 = ((ViewGroup) view).getChildAt(i);
                    }
                    if (view2 == null) {
                        if (!TextUtils.isEmpty(aVar.act.get(i).abf)) {
                            view2 = com.baidu.c.a.b.a.sq().Z(context, aVar.act.get(i).abf);
                            this.acv.put(aVar.act.get(i).abf, view2);
                        } else if ("view".equalsIgnoreCase(aVar.act.get(i).type)) {
                            view2 = new RelativeLayout(context);
                        } else if ("image".equalsIgnoreCase(aVar.act.get(i).type)) {
                            view2 = d.sr().aa(context, "image");
                            if (view2 == null) {
                                view2 = new ImageView(context);
                            }
                        } else if ("text".equalsIgnoreCase(aVar.act.get(i).type)) {
                            view2 = new TextView(context);
                            ((TextView) view2).setIncludeFontPadding(false);
                        } else if ("video".equalsIgnoreCase(aVar.act.get(i).type)) {
                            view2 = d.sr().aa(context, "video");
                        } else {
                            view2 = new RelativeLayout(context);
                        }
                        if (!TextUtils.isEmpty(aVar.act.get(i).id)) {
                            this.acw.put(aVar.act.get(i).id, view2);
                        }
                        ((ViewGroup) view).addView(view2, i);
                    }
                    if ((view instanceof ViewGroup) && view2 != null) {
                        a(context, aVar.act.get(i), view2, z);
                    }
                }
            }
        }
    }

    private void a(final Context context, View view, final com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && !TextUtils.isEmpty(aVar.abg)) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.c.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(aVar.abg)) {
                        if (a.this.acy != null) {
                            a.this.acy.d(aVar.abg, a.this.a(aVar));
                        } else {
                            c.ab(context, aVar.abg);
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
            if (!z || TextUtils.isEmpty(aVar.aco)) {
                if (!TextUtils.isEmpty(aVar.color)) {
                    if (!TextUtils.isEmpty(aVar.acj)) {
                        try {
                            TextView textView = (TextView) view;
                            textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.acj), com.baidu.c.a.e.a.parseColor(aVar.color)}));
                        } catch (Throwable th) {
                        }
                    } else {
                        try {
                            ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.color));
                        } catch (Throwable th2) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acs)) {
                try {
                    TextView textView2 = (TextView) view;
                    textView2.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{com.baidu.c.a.e.a.parseColor(aVar.acs), com.baidu.c.a.e.a.parseColor(aVar.aco)}));
                } catch (Throwable th3) {
                }
            } else {
                try {
                    ((TextView) view).setTextColor(com.baidu.c.a.e.a.parseColor(aVar.aco));
                } catch (Throwable th4) {
                }
            }
            if (aVar.acd >= 0.0d) {
                ((TextView) view).setTextSize(0, (float) (aVar.acd * view.getContext().getResources().getDisplayMetrics().density));
            }
            ((TextView) view).setTypeface(aVar.acc);
            ((TextView) view).setGravity(aVar.gravity);
            ((TextView) view).setText(aVar.text);
            if (aVar.abp > 0.0d) {
                ((TextView) view).setLineSpacing((float) aVar.abp, 1.0f);
            }
        }
    }

    private void a(String str, View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (aVar != null) {
            view.setMinimumWidth((int) aVar.aaQ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaQ.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.text = aVar.text;
            aVar2.src = aVar.src;
            aVar2.aaI = (float) aVar.abY;
            if (!TextUtils.isEmpty(aVar.color)) {
                aVar2.color = com.baidu.c.a.e.a.parseColor(aVar.color);
            }
            if (!TextUtils.isEmpty(aVar.aco)) {
                aVar2.aaJ = com.baidu.c.a.e.a.parseColor(aVar.aco);
            }
            aVar2.aaK = (float) aVar.acd;
            com.baidu.c.a.b.a.sq().a(str, view, aVar2, z);
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
            view.setMinimumWidth((int) aVar.aaQ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaQ.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aaH = aVar.aaH;
            aVar2.videoDuration = aVar.videoDuration;
            aVar2.width = (int) aVar.aaQ.getLayoutWidth();
            aVar2.height = (int) aVar.aaQ.getLayoutHeight();
            d.sr().a("video", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar) {
        if (view != null && aVar != null && "image".equalsIgnoreCase(aVar.type)) {
            view.setMinimumWidth((int) aVar.aaQ.getLayoutWidth());
            view.setMinimumHeight((int) aVar.aaQ.getLayoutHeight());
            com.baidu.c.a.a.a aVar2 = new com.baidu.c.a.a.a();
            aVar2.src = aVar.src;
            aVar2.aaI = (float) aVar.abY;
            d.sr().a("image", view, aVar2);
        }
    }

    private void b(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || aVar.acn < -1.0d) {
                if (aVar.abZ > -1.0d) {
                    view.setAlpha((float) aVar.abZ);
                    return;
                } else {
                    view.setAlpha(1.0f);
                    return;
                }
            }
            view.setAlpha((float) aVar.acn);
        }
    }

    private void b(Context context, View view, com.baidu.c.a.c.a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acm)) {
                String str5 = aVar.abW;
                str = aVar.aci;
                str2 = str5;
            } else {
                String str6 = aVar.acm;
                str = aVar.acr;
                str2 = str6;
            }
            if (!z || TextUtils.isEmpty(aVar.acl)) {
                str3 = aVar.abV;
                str4 = aVar.ach;
            } else {
                str3 = aVar.acl;
                str4 = aVar.acq;
            }
            if (aVar.abX > 0.0d && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        if (!TextUtils.isEmpty(str3)) {
                            gradientDrawable.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        float f = context.getResources().getDisplayMetrics().density;
                        gradientDrawable.setStroke((int) aVar.a(aVar.abX, f), com.baidu.c.a.e.a.parseColor(str2));
                        if (aVar.abY > 0.0d) {
                            gradientDrawable.setCornerRadius(aVar.a(aVar.abY, f));
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        if (!TextUtils.isEmpty(str4)) {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str4));
                        } else {
                            gradientDrawable2.setColor(com.baidu.c.a.e.a.parseColor(str3));
                        }
                        gradientDrawable2.setStroke((int) aVar.a(aVar.abX, f), com.baidu.c.a.e.a.parseColor(str));
                        if (aVar.abY > 0.0d) {
                            gradientDrawable2.setCornerRadius(aVar.a(aVar.abY, f));
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
                    gradientDrawable3.setStroke((int) aVar.a(aVar.abX, f2), com.baidu.c.a.e.a.parseColor(str2));
                    if (aVar.abY > 0.0d) {
                        gradientDrawable3.setCornerRadius(aVar.a(aVar.abY, f2));
                    }
                    view.setBackgroundDrawable(gradientDrawable3);
                } catch (Throwable th2) {
                }
            }
        }
    }

    private void c(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.acl)) {
                if (!TextUtils.isEmpty(aVar.abV)) {
                    if (!TextUtils.isEmpty(aVar.ach)) {
                        try {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            ColorDrawable colorDrawable = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.ach));
                            ColorDrawable colorDrawable2 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.abV));
                            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                            stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                            view.setBackgroundDrawable(stateListDrawable);
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    try {
                        view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.abV));
                    } catch (Throwable th2) {
                    }
                }
            } else if (!TextUtils.isEmpty(aVar.acq)) {
                try {
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    ColorDrawable colorDrawable3 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.acq));
                    ColorDrawable colorDrawable4 = new ColorDrawable(com.baidu.c.a.e.a.parseColor(aVar.acl));
                    stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                    stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                    view.setBackgroundDrawable(stateListDrawable2);
                } catch (Throwable th3) {
                }
            } else {
                try {
                    view.setBackgroundColor(com.baidu.c.a.e.a.parseColor(aVar.acl));
                } catch (Throwable th4) {
                }
            }
        }
    }

    private void d(View view, com.baidu.c.a.c.a aVar, boolean z) {
        if (view != null && aVar != null) {
            if (!z || TextUtils.isEmpty(aVar.ack)) {
                if (!TextUtils.isEmpty(aVar.abU)) {
                    d.sr().a(aVar.type, view, aVar.abU, aVar.acg);
                    return;
                }
                return;
            }
            d.sr().a(aVar.type, view, aVar.ack, aVar.acp);
        }
    }

    public View dc(String str) {
        return this.acv.get(str);
    }

    public View dd(String str) {
        return this.acw.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(com.baidu.c.a.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data-als-stat", aVar.abh);
        hashMap.put("data-url-stat", aVar.abi);
        return hashMap;
    }
}
