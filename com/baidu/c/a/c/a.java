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
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
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
    private static Method abA;
    private static Method abB;
    private static Field abC;
    private static Field abD;
    private static Field abE;
    private static final TextPaint abt = new TextPaint(1);
    private static Class abu;
    private static Method abv;
    private static Method abw;
    private static Method abx;
    private static Method aby;
    private static Method abz;
    public final int aap;
    public final int aaq;
    public String abG;
    public String abH;
    public String abI;
    public String abJ;
    public String abK;
    public int abL;
    public int abM;
    public int abN;
    public String abO;
    public String abP;
    public double abQ;
    private String abR;
    private String abS;
    private String abT;
    private String abU;
    private String abV;
    private String abW;
    private double abX;
    private double abY;
    private double abZ;
    public String abd;
    public String abl;
    private CriusNode abq;
    public double acA;
    public double acB;
    public String acC;
    public String acD;
    public Typeface acE;
    public String acF;
    public String acG;
    public String acH;
    public String acI;
    public String acJ;
    public String acK;
    public String acL;
    public String acM;
    public String acN;
    public String acP;
    public String acQ;
    public String acR;
    public String acS;
    public String acT;
    public final List<a> acU;
    private double aca;
    private double acb;
    private double acd;
    private double ace;
    private double acf;
    private double acg;
    private double ach;
    private double aci;
    private double acj;
    private double ack;
    private double acl;
    private double acm;
    private double acn;
    private double aco;
    private double acp;
    private double acq;
    private double acr;
    private double acs;
    private double act;
    private double acu;
    public String acv;
    public double acx;
    public double acy;
    public double acz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0036a businessConverter;
    public String color;
    public double fontSize;
    public int gravity;
    private double height;
    public String id;
    public int maxLines;
    public String name;
    public double opacity;
    public final float pN;
    private String position;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;
    private final CriusMeasureFunction abF = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.abt;
            if (a.this.fontSize >= 0.0d) {
                textPaint.setTextSize((float) (a.this.fontSize * a.this.pN));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.abQ > 0.0d ? (float) a.this.abQ : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.abv.invoke(a.abu, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.abw.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.abx.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.aby.invoke(invoke, false);
                        Method method = a.abz;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.abC.get(Layout.class) : a.abD.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.abA.invoke(invoke, a.abE.get(Layout.class));
                        layout = (Layout) a.abB.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.abv.invoke(a.abu, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.abw.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.abx.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.aby.invoke(invoke2, false);
                    Method method2 = a.abz;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.abC.get(Layout.class) : a.abD.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.abA.invoke(invoke2, a.abE.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.abB.invoke(invoke2, new Object[0]);
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
    public double acO = -10000.0d;
    public final CriusNode abr = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0036a {
        String cB(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                abu = Class.forName("android.text.StaticLayout$Builder");
                abv = abu.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                abv.setAccessible(true);
                abw = abu.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                abw.setAccessible(true);
                abx = abu.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                abx.setAccessible(true);
                aby = abu.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                aby.setAccessible(true);
                abz = abu.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                abz.setAccessible(true);
                abA = abu.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                abA.setAccessible(true);
                abB = abu.getDeclaredMethod("build", new Class[0]);
                abB.setAccessible(true);
                abC = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                abC.setAccessible(true);
                abD = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                abD.setAccessible(true);
                abE = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                abE.setAccessible(true);
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

    public static boolean cx(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float W(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float X(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cx(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void h(JSONObject jSONObject) {
        this.id = b.g(jSONObject, "id");
        this.name = b.g(jSONObject, "name");
        this.type = b.g(jSONObject, "type");
        if (sf()) {
            this.abr.setMeasureFunction(this.abF);
        }
        this.abG = b.g(jSONObject, "component");
        this.src = b.g(jSONObject, "src");
        this.abd = b.g(jSONObject, "poster");
        this.abH = b.g(jSONObject, "href");
        this.text = b.g(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.abG) && this.businessConverter != null) {
            this.text = this.businessConverter.cB(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.abQ = b.h(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.abI = jSONObject.optString("data-als-stat");
        this.abJ = jSONObject.optString("data-url-stat");
        this.abK = jSONObject.optString("data-href-pop");
        this.abL = b.i(jSONObject, "data-share-num");
        this.abM = b.i(jSONObject, "data-reply-num");
        this.abN = b.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.abO = jSONObject.optString("data-share-image");
        this.abP = jSONObject.optString("data-share-link");
    }

    private void i(JSONObject jSONObject) {
        this.abR = b.g(jSONObject, "display");
        rX();
        this.abS = b.g(jSONObject, "flex-direction");
        se();
        this.abT = b.g(jSONObject, "justify-content");
        sd();
        this.abU = b.g(jSONObject, "align-items");
        sc();
        this.abV = b.g(jSONObject, "align-self");
        sb();
        this.abW = b.g(jSONObject, "align-content");
        sa();
        this.abX = b.h(jSONObject, "flex");
        rW();
        this.abY = b.h(jSONObject, "flex-grow");
        rV();
        this.abZ = b.h(jSONObject, "flex-shrink");
        rU();
        this.aca = b.h(jSONObject, "flex-basis");
        rT();
        this.position = b.g(jSONObject, "position");
        rZ();
        this.acb = b.h(jSONObject, CustomDialogData.POS_LEFT);
        this.acd = b.h(jSONObject, "top");
        this.ace = b.h(jSONObject, "right");
        this.acf = b.h(jSONObject, "bottom");
        rY();
        this.acg = b.h(jSONObject, "margin");
        rS();
        this.ach = b.h(jSONObject, "margin-left");
        rO();
        this.aci = b.h(jSONObject, "margin-top");
        rR();
        this.acj = b.h(jSONObject, "margin-right");
        rQ();
        this.ack = b.h(jSONObject, "margin-bottom");
        rP();
        this.acl = b.h(jSONObject, "padding");
        initPadding();
        this.acm = b.h(jSONObject, "padding-left");
        rK();
        this.acn = b.h(jSONObject, "padding-top");
        rN();
        this.aco = b.h(jSONObject, "padding-right");
        rM();
        this.acp = b.h(jSONObject, "padding-bottom");
        rL();
        this.width = b.h(jSONObject, "width");
        rJ();
        this.height = b.h(jSONObject, "height");
        rI();
        this.acq = b.h(jSONObject, "min-width");
        rH();
        this.acr = b.h(jSONObject, "min-height");
        rG();
        this.acs = b.h(jSONObject, "max-width");
        rD();
        this.act = b.h(jSONObject, "max-height");
        rF();
        this.acu = b.h(jSONObject, "aspect-ratio");
        rE();
    }

    private void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acQ = b.g(optJSONObject, "background-image");
            this.acR = b.g(optJSONObject, "background-color");
            this.acS = b.g(optJSONObject, "border-color");
            this.acT = b.g(optJSONObject, "color");
        }
    }

    private void k(JSONObject jSONObject) {
        this.acL = b.g(jSONObject, "background-image");
        this.acM = b.g(jSONObject, "background-color");
        this.acN = b.g(jSONObject, "border-color");
        this.acO = b.h(jSONObject, "opacity");
        this.acP = b.g(jSONObject, "color");
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acH = b.g(optJSONObject, "background-image");
            this.acI = b.g(optJSONObject, "background-color");
            this.acJ = b.g(optJSONObject, "border-color");
            this.acK = b.g(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.acv = b.g(jSONObject, "background-image");
        this.backgroundColor = b.g(jSONObject, "background-color");
        this.borderColor = b.g(jSONObject, "border-color");
        this.opacity = b.h(jSONObject, "opacity");
        this.color = b.g(jSONObject, "color");
        this.acx = b.h(jSONObject, "border-width");
        this.borderRadius = b.h(jSONObject, "border-radius");
        this.acy = b.h(jSONObject, "border-top-left-radius");
        this.acz = b.h(jSONObject, "border-bottom-left-radius");
        this.acA = b.h(jSONObject, "border-top-right-radius");
        this.acB = b.h(jSONObject, "border-bottom-right-radius");
        this.acC = b.g(jSONObject, "font-style");
        this.acD = b.g(jSONObject, "font-weight");
        this.acE = Typeface.create(Typeface.DEFAULT, rB());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.acF = b.g(jSONObject, "text-align");
        this.acG = b.g(jSONObject, "vertical-align");
        this.gravity = rC();
        this.abl = b.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0036a interfaceC0036a, boolean z) {
        this.businessConverter = interfaceC0036a;
        this.pN = context.getResources().getDisplayMetrics().density;
        this.aap = context.getResources().getDisplayMetrics().widthPixels;
        this.aaq = context.getResources().getDisplayMetrics().heightPixels;
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
                this.acU = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0036a, false);
                    this.acU.add(aVar);
                    this.abr.addChildAt(aVar.abr, i);
                }
            } else {
                this.acU = null;
            }
        } else {
            this.acU = null;
        }
        if (z) {
            this.abq = new CriusNode();
            this.abq.addChildAt(this.abr, 0);
            this.abq.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int rB() {
        return "italic".equalsIgnoreCase(this.acC) ? (TextUtils.isEmpty(this.acD) || "normal".equalsIgnoreCase(this.acD) || !"bold".equalsIgnoreCase(this.acD)) ? 2 : 3 : (TextUtils.isEmpty(this.acD) || "normal".equalsIgnoreCase(this.acD) || !"bold".equalsIgnoreCase(this.acD)) ? 0 : 1;
    }

    private int rC() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.acF)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.acF)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.acF)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.acG)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.acG)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.acG)) {
            return i | 16;
        }
        return i | 0;
    }

    private void rD() {
        if (this.acs >= 0.0d) {
            this.abr.setMaxWidth(e(this.acs));
        } else if (this.acs > -10000.0d) {
            this.abr.setMaxWidth(this.aap);
        }
    }

    private void rE() {
        if (this.acu > 0.0d) {
            this.abr.setAspectRatio((float) this.acu);
        }
    }

    private void rF() {
        if (this.act >= 0.0d) {
            this.abr.setMaxHeight(e(this.act));
        } else if (this.act > -10000.0d) {
            this.abr.setMaxHeight(this.aaq);
        }
    }

    private void rG() {
        if (this.acr >= 0.0d) {
            this.abr.setMinHeight(e(this.acr));
        } else if (this.acr > -10000.0d) {
            this.abr.setMinHeight(this.aaq);
        }
    }

    private void rH() {
        if (this.acq >= 0.0d) {
            this.abr.setMinWidth(e(this.acq));
        } else if (this.acq > -10000.0d) {
            this.abr.setMinWidth(this.aap);
        }
    }

    private void rI() {
        if (this.height >= 0.0d) {
            this.abr.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.abr.setHeight(this.aaq);
        }
    }

    private void rJ() {
        if (this.width >= 0.0d) {
            this.abr.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.abr.setWidth(this.aap);
        }
    }

    private void rK() {
        if (this.acm >= -1.0d) {
            this.abr.setPadding(CriusEdge.LEFT, e(this.acm));
        }
    }

    private void rL() {
        if (this.acp >= -1.0d) {
            this.abr.setPadding(CriusEdge.BOTTOM, e(this.acp));
        }
    }

    private void rM() {
        if (this.aco >= -1.0d) {
            this.abr.setPadding(CriusEdge.RIGHT, e(this.aco));
        }
    }

    private void rN() {
        if (this.acn >= -1.0d) {
            this.abr.setPadding(CriusEdge.TOP, e(this.acn));
        }
    }

    private void initPadding() {
        if (this.acl >= -1.0d) {
            this.abr.setPadding(CriusEdge.ALL, e(this.acl));
        }
    }

    private void rO() {
        if (this.ach >= -1.0d) {
            this.abr.setMargin(CriusEdge.LEFT, e(this.ach));
        }
    }

    private void rP() {
        if (this.ack >= -1.0d) {
            this.abr.setMargin(CriusEdge.BOTTOM, e(this.ack));
        }
    }

    private void rQ() {
        if (this.acj >= -1.0d) {
            this.abr.setMargin(CriusEdge.RIGHT, e(this.acj));
        }
    }

    private void rR() {
        if (this.aci >= -1.0d) {
            this.abr.setMargin(CriusEdge.TOP, e(this.aci));
        }
    }

    private void rS() {
        if (this.acg >= -1.0d) {
            this.abr.setMargin(CriusEdge.ALL, e(this.acg));
        }
    }

    private void rT() {
        if (this.aca >= -1.0d) {
            this.abr.setFlexBasis(e(this.aca));
        }
    }

    private void rU() {
        if (this.abZ >= -1.0d) {
            this.abr.setFlexShrink((float) this.abZ);
        }
    }

    private void rV() {
        if (this.abY >= -1.0d) {
            this.abr.setFlexGrow((float) this.abY);
        }
    }

    private void rW() {
        if (this.abX >= -1.0d) {
            this.abr.setFlex((float) this.abX);
        }
    }

    private void rX() {
        if (!TextUtils.isEmpty(this.abR)) {
            if ("flex".equalsIgnoreCase(this.abR)) {
                this.abr.setDisplay(CriusDisplay.FLEX);
            } else if (IXAdSystemUtils.NT_NONE.equalsIgnoreCase(this.abR)) {
                this.abr.setDisplay(CriusDisplay.NONE);
            } else {
                this.abr.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void rY() {
        if (!b.c(this.acb, -10000.0d)) {
            this.abr.setPosition(CriusEdge.LEFT, e(this.acb));
        }
        if (!b.c(this.acd, -10000.0d)) {
            this.abr.setPosition(CriusEdge.TOP, e(this.acd));
        }
        if (!b.c(this.ace, -10000.0d)) {
            this.abr.setPosition(CriusEdge.RIGHT, e(this.ace));
        }
        if (!b.c(this.acf, -10000.0d)) {
            this.abr.setPosition(CriusEdge.BOTTOM, e(this.acf));
        }
    }

    private void rZ() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.abr.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.abr.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void sa() {
        if (!TextUtils.isEmpty(this.abW)) {
            if ("flex-start".equalsIgnoreCase(this.abW)) {
                this.abr.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abW)) {
                this.abr.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abW)) {
                this.abr.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abW)) {
                this.abr.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.abW)) {
                this.abr.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abW)) {
                this.abr.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.abr.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void sb() {
        if (!TextUtils.isEmpty(this.abV)) {
            if ("auto".equalsIgnoreCase(this.abV)) {
                this.abr.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.abV)) {
                this.abr.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abV)) {
                this.abr.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abV)) {
                this.abr.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abV)) {
                this.abr.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.abr.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void sc() {
        if (!TextUtils.isEmpty(this.abU)) {
            if ("flex-start".equalsIgnoreCase(this.abU)) {
                this.abr.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abU)) {
                this.abr.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abU)) {
                this.abr.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abU)) {
                this.abr.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.abr.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void sd() {
        if (!TextUtils.isEmpty(this.abT)) {
            if ("flex-start".equalsIgnoreCase(this.abT)) {
                this.abr.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abT)) {
                this.abr.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abT)) {
                this.abr.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.abT)) {
                this.abr.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abT)) {
                this.abr.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.abr.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void se() {
        if (!TextUtils.isEmpty(this.abS)) {
            if ("column".equalsIgnoreCase(this.abS)) {
                this.abr.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.abS)) {
                this.abr.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.abS)) {
                this.abr.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.abS)) {
                this.abr.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.abr.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean sf() {
        return "text".equals(this.type);
    }

    public a cy(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.acU != null && this.acU.size() > 0) {
                for (a aVar : this.acU) {
                    a cy = aVar.cy(str);
                    if (cy != null) {
                        return cy;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.abG)) {
            if (this.acU != null && this.acU.size() > 0) {
                for (a aVar : this.acU) {
                    a cz = aVar.cz(str);
                    if (cz != null) {
                        return cz;
                    }
                }
            }
            return null;
        }
        return this;
    }

    private float e(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.pN * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean cA(String str) {
        a cz;
        if (this.abq == null || (cz = cz(str)) == null || cz.abr == null) {
            return false;
        }
        cz.abr.setDisplay(CriusDisplay.NONE);
        cz.abr.dirty();
        this.abq.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cy;
        if (this.abq != null && (cy = cy(str)) != null && cy.abr != null) {
            cy.fontSize = f;
            cy.abr.dirty();
            this.abq.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
