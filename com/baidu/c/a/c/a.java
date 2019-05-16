package com.baidu.c.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.c.a.e.b;
import com.baidu.crius.CriusAlign;
import com.baidu.crius.CriusConstants;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusEdge;
import com.baidu.crius.CriusFlexDirection;
import com.baidu.crius.CriusJustify;
import com.baidu.crius.CriusMeasureFunction;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.crius.CriusMeasureOutput;
import com.baidu.crius.CriusNode;
import com.baidu.crius.CriusPositionType;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static final TextPaint aaU = new TextPaint(1);
    private static Class aaV;
    private static Method aaW;
    private static Method aaX;
    private static Method aaY;
    private static Method aaZ;
    private static Method aba;
    private static Method abb;
    private static Method abd;
    private static Field abe;
    private static Field abf;
    private static Field abg;
    public String aaG;
    private CriusNode aaS;
    private double abA;
    private double abB;
    private double abC;
    private double abD;
    private double abE;
    private double abF;
    private double abG;
    private double abH;
    private double abI;
    private double abJ;
    private double abK;
    private double abL;
    private double abM;
    private double abN;
    private double abO;
    private double abP;
    private double abQ;
    private double abR;
    private double abS;
    private double abT;
    private double abU;
    private double abV;
    private double abW;
    public String abX;
    public double abY;
    public double abZ;
    public String abi;
    public String abj;
    public String abk;
    public String abl;
    public String abm;
    public int abn;
    public int abo;
    public int abp;
    public String abq;
    public String abr;
    public double abt;
    private String abu;
    private String abv;
    private String abw;
    private String abx;
    private String aby;
    private String abz;
    public double aca;
    public double acb;
    public double acd;
    public String ace;
    public String acf;
    public Typeface acg;
    public String ach;
    public String aci;
    public String acj;
    public String ack;
    public String acl;
    public String acm;
    public String acn;
    public String aco;
    public String acp;
    public String acr;
    public String acs;
    public String act;
    public String acu;
    public String acv;
    public final List<a> acx;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0036a businessConverter;
    public String color;
    public final float density;
    public double fontSize;
    public int gravity;
    private double height;
    public final int heightPixels;
    public String id;
    public int maxLines;
    public String name;
    public double opacity;
    private String position;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;
    public final int widthPixels;
    private final CriusMeasureFunction abh = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.aaU;
            if (a.this.fontSize >= 0.0d) {
                textPaint.setTextSize((float) (a.this.fontSize * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.abt > 0.0d ? (float) a.this.abt : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.aaW.invoke(a.aaV, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.aaX.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.aaY.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.aaZ.invoke(invoke, false);
                        Method method = a.aba;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.abe.get(Layout.class) : a.abf.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.abb.invoke(invoke, a.abg.get(Layout.class));
                        layout = (Layout) a.abd.invoke(invoke, new Object[0]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        layout = null;
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        layout = null;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        layout = null;
                    }
                }
                z = false;
                layout2 = layout;
            } else if (isBoring != null && (z2 || isBoring.width <= f)) {
                layout2 = BoringLayout.make(spannableString, textPaint, isBoring.width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, isBoring, false);
                z = true;
            } else if (Build.VERSION.SDK_INT < 23) {
                Layout staticLayout = new StaticLayout(spannableString, textPaint, (int) f, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                z = false;
                layout2 = staticLayout;
            } else {
                try {
                    Object invoke2 = a.aaW.invoke(a.aaV, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.aaX.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.aaY.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.aaZ.invoke(invoke2, false);
                    Method method2 = a.aba;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.abe.get(Layout.class) : a.abf.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.abb.invoke(invoke2, a.abg.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.abd.invoke(invoke2, new Object[0]);
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    z = false;
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                    z = false;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    z = false;
                }
            }
            if (layout2 != null && a.this.maxLines < layout2.getLineCount()) {
                return CriusMeasureOutput.make(a.this.X(layout2.getWidth()), a.this.W(layout2.getLineBottom(a.this.maxLines - 1)) - f3);
            }
            if (layout2 != null) {
                float X = a.this.X(layout2.getWidth());
                float W = a.this.W(layout2.getHeight());
                if (!z) {
                    boolean z3 = false;
                    if (TbadkCoreApplication.getInst().isMIUIRom()) {
                        if (Build.VERSION.SDK_INT < 23) {
                            z3 = true;
                        }
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        float lineDescent = (layout2.getLineDescent(0) - layout2.getLineAscent(0)) - f3;
                        float lineCount = (layout2.getLineCount() * lineDescent) + ((layout2.getLineCount() - 1) * f3);
                        if (lineDescent > 0.0f && W > lineCount) {
                            W -= f3;
                        }
                    }
                }
                return CriusMeasureOutput.make(X, W);
            }
            return CriusMeasureOutput.make(f, f2);
        }
    };
    public double acq = -10000.0d;
    public final CriusNode aaT = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0036a {
        String cz(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                aaV = Class.forName("android.text.StaticLayout$Builder");
                aaW = aaV.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                aaW.setAccessible(true);
                aaX = aaV.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                aaX.setAccessible(true);
                aaY = aaV.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                aaY.setAccessible(true);
                aaZ = aaV.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                aaZ.setAccessible(true);
                aba = aaV.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                aba.setAccessible(true);
                abb = aaV.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                abb.setAccessible(true);
                abd = aaV.getDeclaredMethod("build", new Class[0]);
                abd.setAccessible(true);
                abe = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                abe.setAccessible(true);
                abf = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                abf.setAccessible(true);
                abg = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                abg.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean cv(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float W(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.06f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float X(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cv(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void h(JSONObject jSONObject) {
        this.id = b.g(jSONObject, "id");
        this.name = b.g(jSONObject, "name");
        this.type = b.g(jSONObject, "type");
        if (isText()) {
            this.aaT.setMeasureFunction(this.abh);
        }
        this.abi = b.g(jSONObject, "component");
        this.src = b.g(jSONObject, "src");
        this.aaG = b.g(jSONObject, "poster");
        this.abj = b.g(jSONObject, "href");
        this.text = b.g(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.abi) && this.businessConverter != null) {
            this.text = this.businessConverter.cz(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.abt = b.h(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.abk = jSONObject.optString("data-als-stat");
        this.abl = jSONObject.optString("data-url-stat");
        this.abm = jSONObject.optString("data-href-pop");
        this.abn = b.i(jSONObject, "data-share-num");
        this.abo = b.i(jSONObject, "data-reply-num");
        this.abp = b.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.abq = jSONObject.optString("data-share-image");
        this.abr = jSONObject.optString("data-share-link");
    }

    private void i(JSONObject jSONObject) {
        this.abu = b.g(jSONObject, "display");
        rA();
        this.abv = b.g(jSONObject, "flex-direction");
        rH();
        this.abw = b.g(jSONObject, "justify-content");
        rG();
        this.abx = b.g(jSONObject, "align-items");
        rF();
        this.aby = b.g(jSONObject, "align-self");
        rE();
        this.abz = b.g(jSONObject, "align-content");
        rD();
        this.abA = b.h(jSONObject, "flex");
        rz();
        this.abB = b.h(jSONObject, "flex-grow");
        ry();
        this.abC = b.h(jSONObject, "flex-shrink");
        rx();
        this.abD = b.h(jSONObject, "flex-basis");
        rw();
        this.position = b.g(jSONObject, "position");
        rC();
        this.abE = b.h(jSONObject, CustomDialogData.POS_LEFT);
        this.abF = b.h(jSONObject, "top");
        this.abG = b.h(jSONObject, "right");
        this.abH = b.h(jSONObject, "bottom");
        rB();
        this.abI = b.h(jSONObject, "margin");
        rv();
        this.abJ = b.h(jSONObject, "margin-left");
        rr();
        this.abK = b.h(jSONObject, "margin-top");
        ru();
        this.abL = b.h(jSONObject, "margin-right");
        rt();
        this.abM = b.h(jSONObject, "margin-bottom");
        rs();
        this.abN = b.h(jSONObject, "padding");
        initPadding();
        this.abO = b.h(jSONObject, "padding-left");
        rn();
        this.abP = b.h(jSONObject, "padding-top");
        rq();
        this.abQ = b.h(jSONObject, "padding-right");
        rp();
        this.abR = b.h(jSONObject, "padding-bottom");
        ro();
        this.width = b.h(jSONObject, "width");
        rm();
        this.height = b.h(jSONObject, "height");
        rl();
        this.abS = b.h(jSONObject, "min-width");
        rk();
        this.abT = b.h(jSONObject, "min-height");
        rj();
        this.abU = b.h(jSONObject, "max-width");
        rg();
        this.abV = b.h(jSONObject, "max-height");
        ri();
        this.abW = b.h(jSONObject, "aspect-ratio");
        rh();
    }

    private void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acs = b.g(optJSONObject, "background-image");
            this.act = b.g(optJSONObject, "background-color");
            this.acu = b.g(optJSONObject, "border-color");
            this.acv = b.g(optJSONObject, "color");
        }
    }

    private void k(JSONObject jSONObject) {
        this.acn = b.g(jSONObject, "background-image");
        this.aco = b.g(jSONObject, "background-color");
        this.acp = b.g(jSONObject, "border-color");
        this.acq = b.h(jSONObject, "opacity");
        this.acr = b.g(jSONObject, "color");
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acj = b.g(optJSONObject, "background-image");
            this.ack = b.g(optJSONObject, "background-color");
            this.acl = b.g(optJSONObject, "border-color");
            this.acm = b.g(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.abX = b.g(jSONObject, "background-image");
        this.backgroundColor = b.g(jSONObject, "background-color");
        this.borderColor = b.g(jSONObject, "border-color");
        this.opacity = b.h(jSONObject, "opacity");
        this.color = b.g(jSONObject, "color");
        this.abY = b.h(jSONObject, "border-width");
        this.borderRadius = b.h(jSONObject, "border-radius");
        this.abZ = b.h(jSONObject, "border-top-left-radius");
        this.aca = b.h(jSONObject, "border-bottom-left-radius");
        this.acb = b.h(jSONObject, "border-top-right-radius");
        this.acd = b.h(jSONObject, "border-bottom-right-radius");
        this.ace = b.g(jSONObject, "font-style");
        this.acf = b.g(jSONObject, "font-weight");
        this.acg = Typeface.create(Typeface.DEFAULT, re());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.ach = b.g(jSONObject, "text-align");
        this.aci = b.g(jSONObject, "vertical-align");
        this.gravity = rf();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0036a interfaceC0036a, boolean z) {
        this.businessConverter = interfaceC0036a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        this.heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        h(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        if (optJSONObject != null) {
            i(optJSONObject);
            m(optJSONObject);
            l(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            k(optJSONObject2);
            j(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.acx = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0036a, false);
                    this.acx.add(aVar);
                    this.aaT.addChildAt(aVar.aaT, i);
                }
            } else {
                this.acx = null;
            }
        } else {
            this.acx = null;
        }
        if (z) {
            this.aaS = new CriusNode();
            this.aaS.addChildAt(this.aaT, 0);
            this.aaS.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int re() {
        return "italic".equalsIgnoreCase(this.ace) ? (TextUtils.isEmpty(this.acf) || "normal".equalsIgnoreCase(this.acf) || !"bold".equalsIgnoreCase(this.acf)) ? 2 : 3 : (TextUtils.isEmpty(this.acf) || "normal".equalsIgnoreCase(this.acf) || !"bold".equalsIgnoreCase(this.acf)) ? 0 : 1;
    }

    private int rf() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.ach)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.ach)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.ach)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.aci)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.aci)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aci)) {
            return i | 16;
        }
        return i | 0;
    }

    private void rg() {
        if (this.abU >= 0.0d) {
            this.aaT.setMaxWidth(e(this.abU));
        } else if (this.abU > -10000.0d) {
            this.aaT.setMaxWidth(this.widthPixels);
        }
    }

    private void rh() {
        if (this.abW > 0.0d) {
            this.aaT.setAspectRatio((float) this.abW);
        }
    }

    private void ri() {
        if (this.abV >= 0.0d) {
            this.aaT.setMaxHeight(e(this.abV));
        } else if (this.abV > -10000.0d) {
            this.aaT.setMaxHeight(this.heightPixels);
        }
    }

    private void rj() {
        if (this.abT >= 0.0d) {
            this.aaT.setMinHeight(e(this.abT));
        } else if (this.abT > -10000.0d) {
            this.aaT.setMinHeight(this.heightPixels);
        }
    }

    private void rk() {
        if (this.abS >= 0.0d) {
            this.aaT.setMinWidth(e(this.abS));
        } else if (this.abS > -10000.0d) {
            this.aaT.setMinWidth(this.widthPixels);
        }
    }

    private void rl() {
        if (this.height >= 0.0d) {
            this.aaT.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.aaT.setHeight(this.heightPixels);
        }
    }

    private void rm() {
        if (this.width >= 0.0d) {
            this.aaT.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.aaT.setWidth(this.widthPixels);
        }
    }

    private void rn() {
        if (this.abO >= -1.0d) {
            this.aaT.setPadding(CriusEdge.LEFT, e(this.abO));
        }
    }

    private void ro() {
        if (this.abR >= -1.0d) {
            this.aaT.setPadding(CriusEdge.BOTTOM, e(this.abR));
        }
    }

    private void rp() {
        if (this.abQ >= -1.0d) {
            this.aaT.setPadding(CriusEdge.RIGHT, e(this.abQ));
        }
    }

    private void rq() {
        if (this.abP >= -1.0d) {
            this.aaT.setPadding(CriusEdge.TOP, e(this.abP));
        }
    }

    private void initPadding() {
        if (this.abN >= -1.0d) {
            this.aaT.setPadding(CriusEdge.ALL, e(this.abN));
        }
    }

    private void rr() {
        if (this.abJ >= -1.0d) {
            this.aaT.setMargin(CriusEdge.LEFT, e(this.abJ));
        }
    }

    private void rs() {
        if (this.abM >= -1.0d) {
            this.aaT.setMargin(CriusEdge.BOTTOM, e(this.abM));
        }
    }

    private void rt() {
        if (this.abL >= -1.0d) {
            this.aaT.setMargin(CriusEdge.RIGHT, e(this.abL));
        }
    }

    private void ru() {
        if (this.abK >= -1.0d) {
            this.aaT.setMargin(CriusEdge.TOP, e(this.abK));
        }
    }

    private void rv() {
        if (this.abI >= -1.0d) {
            this.aaT.setMargin(CriusEdge.ALL, e(this.abI));
        }
    }

    private void rw() {
        if (this.abD >= -1.0d) {
            this.aaT.setFlexBasis(e(this.abD));
        }
    }

    private void rx() {
        if (this.abC >= -1.0d) {
            this.aaT.setFlexShrink((float) this.abC);
        }
    }

    private void ry() {
        if (this.abB >= -1.0d) {
            this.aaT.setFlexGrow((float) this.abB);
        }
    }

    private void rz() {
        if (this.abA >= -1.0d) {
            this.aaT.setFlex((float) this.abA);
        }
    }

    private void rA() {
        if (!TextUtils.isEmpty(this.abu)) {
            if ("flex".equalsIgnoreCase(this.abu)) {
                this.aaT.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.abu)) {
                this.aaT.setDisplay(CriusDisplay.NONE);
            } else {
                this.aaT.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void rB() {
        if (!b.c(this.abE, -10000.0d)) {
            this.aaT.setPosition(CriusEdge.LEFT, e(this.abE));
        }
        if (!b.c(this.abF, -10000.0d)) {
            this.aaT.setPosition(CriusEdge.TOP, e(this.abF));
        }
        if (!b.c(this.abG, -10000.0d)) {
            this.aaT.setPosition(CriusEdge.RIGHT, e(this.abG));
        }
        if (!b.c(this.abH, -10000.0d)) {
            this.aaT.setPosition(CriusEdge.BOTTOM, e(this.abH));
        }
    }

    private void rC() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.aaT.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.aaT.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void rD() {
        if (!TextUtils.isEmpty(this.abz)) {
            if ("flex-start".equalsIgnoreCase(this.abz)) {
                this.aaT.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abz)) {
                this.aaT.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abz)) {
                this.aaT.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abz)) {
                this.aaT.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.abz)) {
                this.aaT.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abz)) {
                this.aaT.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.aaT.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void rE() {
        if (!TextUtils.isEmpty(this.aby)) {
            if ("auto".equalsIgnoreCase(this.aby)) {
                this.aaT.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.aby)) {
                this.aaT.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aby)) {
                this.aaT.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aby)) {
                this.aaT.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aby)) {
                this.aaT.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.aaT.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void rF() {
        if (!TextUtils.isEmpty(this.abx)) {
            if ("flex-start".equalsIgnoreCase(this.abx)) {
                this.aaT.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abx)) {
                this.aaT.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abx)) {
                this.aaT.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abx)) {
                this.aaT.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.aaT.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void rG() {
        if (!TextUtils.isEmpty(this.abw)) {
            if ("flex-start".equalsIgnoreCase(this.abw)) {
                this.aaT.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abw)) {
                this.aaT.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abw)) {
                this.aaT.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.abw)) {
                this.aaT.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abw)) {
                this.aaT.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.aaT.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void rH() {
        if (!TextUtils.isEmpty(this.abv)) {
            if ("column".equalsIgnoreCase(this.abv)) {
                this.aaT.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.abv)) {
                this.aaT.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.abv)) {
                this.aaT.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.abv)) {
                this.aaT.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.aaT.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.acx != null && this.acx.size() > 0) {
                for (a aVar : this.acx) {
                    a cw = aVar.cw(str);
                    if (cw != null) {
                        return cw;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.abi)) {
            if (this.acx != null && this.acx.size() > 0) {
                for (a aVar : this.acx) {
                    a cx = aVar.cx(str);
                    if (cx != null) {
                        return cx;
                    }
                }
            }
            return null;
        }
        return this;
    }

    private float e(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.density * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean cy(String str) {
        a cx;
        if (this.aaS == null || (cx = cx(str)) == null || cx.aaT == null) {
            return false;
        }
        cx.aaT.setDisplay(CriusDisplay.NONE);
        cx.aaT.dirty();
        this.aaS.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cw;
        if (this.aaS != null && (cw = cw(str)) != null && cw.aaT != null) {
            cw.fontSize = f;
            cw.aaT.dirty();
            this.aaS.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
