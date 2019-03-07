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
    private static final TextPaint ada = new TextPaint(1);
    private static Class adb;
    private static Method adc;
    private static Method ade;
    private static Method adf;
    private static Method adg;
    private static Method adh;
    private static Method adi;
    private static Method adj;
    private static Field adk;
    private static Field adl;
    private static Field adm;
    public String acM;
    private CriusNode acY;
    private String adA;
    private String adB;
    private String adC;
    private String adD;
    private String adE;
    private double adF;
    private double adG;
    private double adH;
    private double adI;
    private double adJ;
    private double adK;
    private double adL;
    private double adM;
    private double adN;
    private double adO;
    private double adP;
    private double adQ;
    private double adR;
    private double adS;
    private double adT;
    private double adU;
    private double adV;
    private double adW;
    private double adX;
    private double adY;
    private double adZ;
    public String ado;
    public String adp;
    public String adq;
    public String adr;
    public String ads;
    public int adt;
    public int adu;
    public int adv;
    public String adw;
    public String adx;
    public double ady;
    private String adz;
    public final List<a> aeA;
    private double aea;
    private double aeb;
    public String aec;
    public double aed;
    public double aee;
    public double aef;
    public double aeg;
    public double aeh;
    public String aei;
    public String aej;
    public Typeface aek;
    public String ael;
    public String aem;
    public String aen;
    public String aeo;
    public String aep;
    public String aeq;
    public String aer;
    public String aes;
    public String aet;
    public String aev;
    public String aew;
    public String aex;
    public String aey;
    public String aez;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0035a businessConverter;
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
    private final CriusMeasureFunction adn = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.ada;
            if (a.this.fontSize >= 0.0d) {
                textPaint.setTextSize((float) (a.this.fontSize * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.ady > 0.0d ? (float) a.this.ady : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.adc.invoke(a.adb, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.ade.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.adf.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.adg.invoke(invoke, false);
                        Method method = a.adh;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.adk.get(Layout.class) : a.adl.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.adi.invoke(invoke, a.adm.get(Layout.class));
                        layout = (Layout) a.adj.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.adc.invoke(a.adb, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.ade.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.adf.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.adg.invoke(invoke2, false);
                    Method method2 = a.adh;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.adk.get(Layout.class) : a.adl.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.adi.invoke(invoke2, a.adm.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.adj.invoke(invoke2, new Object[0]);
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
    public double aeu = -10000.0d;
    public final CriusNode acZ = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0035a {
        String cN(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                adb = Class.forName("android.text.StaticLayout$Builder");
                adc = adb.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                adc.setAccessible(true);
                ade = adb.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                ade.setAccessible(true);
                adf = adb.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                adf.setAccessible(true);
                adg = adb.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                adg.setAccessible(true);
                adh = adb.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                adh.setAccessible(true);
                adi = adb.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                adi.setAccessible(true);
                adj = adb.getDeclaredMethod("build", new Class[0]);
                adj.setAccessible(true);
                adk = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                adk.setAccessible(true);
                adl = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                adl.setAccessible(true);
                adm = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                adm.setAccessible(true);
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

    public static boolean cJ(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cJ(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void m(JSONObject jSONObject) {
        this.id = b.h(jSONObject, "id");
        this.name = b.h(jSONObject, "name");
        this.type = b.h(jSONObject, "type");
        if (isText()) {
            this.acZ.setMeasureFunction(this.adn);
        }
        this.ado = b.h(jSONObject, "component");
        this.src = b.h(jSONObject, "src");
        this.acM = b.h(jSONObject, "poster");
        this.adp = b.h(jSONObject, "href");
        this.text = b.h(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.ado) && this.businessConverter != null) {
            this.text = this.businessConverter.cN(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.ady = b.i(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.adq = jSONObject.optString("data-als-stat");
        this.adr = jSONObject.optString("data-url-stat");
        this.ads = jSONObject.optString("data-href-pop");
        this.adt = b.j(jSONObject, "data-share-num");
        this.adu = b.j(jSONObject, "data-reply-num");
        this.adv = b.j(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.adw = jSONObject.optString("data-share-image");
        this.adx = jSONObject.optString("data-share-link");
    }

    private void n(JSONObject jSONObject) {
        this.adz = b.h(jSONObject, "display");
        sG();
        this.adA = b.h(jSONObject, "flex-direction");
        sN();
        this.adB = b.h(jSONObject, "justify-content");
        sM();
        this.adC = b.h(jSONObject, "align-items");
        sL();
        this.adD = b.h(jSONObject, "align-self");
        sK();
        this.adE = b.h(jSONObject, "align-content");
        sJ();
        this.adF = b.i(jSONObject, "flex");
        sF();
        this.adG = b.i(jSONObject, "flex-grow");
        sE();
        this.adH = b.i(jSONObject, "flex-shrink");
        sD();
        this.adI = b.i(jSONObject, "flex-basis");
        sC();
        this.position = b.h(jSONObject, "position");
        sI();
        this.adJ = b.i(jSONObject, CustomDialogData.POS_LEFT);
        this.adK = b.i(jSONObject, "top");
        this.adL = b.i(jSONObject, "right");
        this.adM = b.i(jSONObject, "bottom");
        sH();
        this.adN = b.i(jSONObject, "margin");
        sB();
        this.adO = b.i(jSONObject, "margin-left");
        sx();
        this.adP = b.i(jSONObject, "margin-top");
        sA();
        this.adQ = b.i(jSONObject, "margin-right");
        sz();
        this.adR = b.i(jSONObject, "margin-bottom");
        sy();
        this.adS = b.i(jSONObject, "padding");
        initPadding();
        this.adT = b.i(jSONObject, "padding-left");
        st();
        this.adU = b.i(jSONObject, "padding-top");
        sw();
        this.adV = b.i(jSONObject, "padding-right");
        sv();
        this.adW = b.i(jSONObject, "padding-bottom");
        su();
        this.width = b.i(jSONObject, "width");
        ss();
        this.height = b.i(jSONObject, "height");
        sr();
        this.adX = b.i(jSONObject, "min-width");
        sq();
        this.adY = b.i(jSONObject, "min-height");
        sp();
        this.adZ = b.i(jSONObject, "max-width");
        sm();
        this.aea = b.i(jSONObject, "max-height");
        so();
        this.aeb = b.i(jSONObject, "aspect-ratio");
        sn();
    }

    private void o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aew = b.h(optJSONObject, "background-image");
            this.aex = b.h(optJSONObject, "background-color");
            this.aey = b.h(optJSONObject, "border-color");
            this.aez = b.h(optJSONObject, "color");
        }
    }

    private void p(JSONObject jSONObject) {
        this.aer = b.h(jSONObject, "background-image");
        this.aes = b.h(jSONObject, "background-color");
        this.aet = b.h(jSONObject, "border-color");
        this.aeu = b.i(jSONObject, "opacity");
        this.aev = b.h(jSONObject, "color");
    }

    private void q(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aen = b.h(optJSONObject, "background-image");
            this.aeo = b.h(optJSONObject, "background-color");
            this.aep = b.h(optJSONObject, "border-color");
            this.aeq = b.h(optJSONObject, "color");
        }
    }

    private void r(JSONObject jSONObject) {
        this.aec = b.h(jSONObject, "background-image");
        this.backgroundColor = b.h(jSONObject, "background-color");
        this.borderColor = b.h(jSONObject, "border-color");
        this.opacity = b.i(jSONObject, "opacity");
        this.color = b.h(jSONObject, "color");
        this.aed = b.i(jSONObject, "border-width");
        this.borderRadius = b.i(jSONObject, "border-radius");
        this.aee = b.i(jSONObject, "border-top-left-radius");
        this.aef = b.i(jSONObject, "border-bottom-left-radius");
        this.aeg = b.i(jSONObject, "border-top-right-radius");
        this.aeh = b.i(jSONObject, "border-bottom-right-radius");
        this.aei = b.h(jSONObject, "font-style");
        this.aej = b.h(jSONObject, "font-weight");
        this.aek = Typeface.create(Typeface.DEFAULT, sk());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.ael = b.h(jSONObject, "text-align");
        this.aem = b.h(jSONObject, "vertical-align");
        this.gravity = sl();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0035a interfaceC0035a, boolean z) {
        this.businessConverter = interfaceC0035a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        this.heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        m(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        if (optJSONObject != null) {
            n(optJSONObject);
            r(optJSONObject);
            q(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            p(optJSONObject2);
            o(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aeA = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0035a, false);
                    this.aeA.add(aVar);
                    this.acZ.addChildAt(aVar.acZ, i);
                }
            } else {
                this.aeA = null;
            }
        } else {
            this.aeA = null;
        }
        if (z) {
            this.acY = new CriusNode();
            this.acY.addChildAt(this.acZ, 0);
            this.acY.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int sk() {
        return "italic".equalsIgnoreCase(this.aei) ? (TextUtils.isEmpty(this.aej) || "normal".equalsIgnoreCase(this.aej) || !"bold".equalsIgnoreCase(this.aej)) ? 2 : 3 : (TextUtils.isEmpty(this.aej) || "normal".equalsIgnoreCase(this.aej) || !"bold".equalsIgnoreCase(this.aej)) ? 0 : 1;
    }

    private int sl() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.ael)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.ael)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.ael)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.aem)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.aem)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aem)) {
            return i | 16;
        }
        return i | 0;
    }

    private void sm() {
        if (this.adZ >= 0.0d) {
            this.acZ.setMaxWidth(e(this.adZ));
        } else if (this.adZ > -10000.0d) {
            this.acZ.setMaxWidth(this.widthPixels);
        }
    }

    private void sn() {
        if (this.aeb > 0.0d) {
            this.acZ.setAspectRatio((float) this.aeb);
        }
    }

    private void so() {
        if (this.aea >= 0.0d) {
            this.acZ.setMaxHeight(e(this.aea));
        } else if (this.aea > -10000.0d) {
            this.acZ.setMaxHeight(this.heightPixels);
        }
    }

    private void sp() {
        if (this.adY >= 0.0d) {
            this.acZ.setMinHeight(e(this.adY));
        } else if (this.adY > -10000.0d) {
            this.acZ.setMinHeight(this.heightPixels);
        }
    }

    private void sq() {
        if (this.adX >= 0.0d) {
            this.acZ.setMinWidth(e(this.adX));
        } else if (this.adX > -10000.0d) {
            this.acZ.setMinWidth(this.widthPixels);
        }
    }

    private void sr() {
        if (this.height >= 0.0d) {
            this.acZ.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.acZ.setHeight(this.heightPixels);
        }
    }

    private void ss() {
        if (this.width >= 0.0d) {
            this.acZ.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.acZ.setWidth(this.widthPixels);
        }
    }

    private void st() {
        if (this.adT >= -1.0d) {
            this.acZ.setPadding(CriusEdge.LEFT, e(this.adT));
        }
    }

    private void su() {
        if (this.adW >= -1.0d) {
            this.acZ.setPadding(CriusEdge.BOTTOM, e(this.adW));
        }
    }

    private void sv() {
        if (this.adV >= -1.0d) {
            this.acZ.setPadding(CriusEdge.RIGHT, e(this.adV));
        }
    }

    private void sw() {
        if (this.adU >= -1.0d) {
            this.acZ.setPadding(CriusEdge.TOP, e(this.adU));
        }
    }

    private void initPadding() {
        if (this.adS >= -1.0d) {
            this.acZ.setPadding(CriusEdge.ALL, e(this.adS));
        }
    }

    private void sx() {
        if (this.adO >= -1.0d) {
            this.acZ.setMargin(CriusEdge.LEFT, e(this.adO));
        }
    }

    private void sy() {
        if (this.adR >= -1.0d) {
            this.acZ.setMargin(CriusEdge.BOTTOM, e(this.adR));
        }
    }

    private void sz() {
        if (this.adQ >= -1.0d) {
            this.acZ.setMargin(CriusEdge.RIGHT, e(this.adQ));
        }
    }

    private void sA() {
        if (this.adP >= -1.0d) {
            this.acZ.setMargin(CriusEdge.TOP, e(this.adP));
        }
    }

    private void sB() {
        if (this.adN >= -1.0d) {
            this.acZ.setMargin(CriusEdge.ALL, e(this.adN));
        }
    }

    private void sC() {
        if (this.adI >= -1.0d) {
            this.acZ.setFlexBasis(e(this.adI));
        }
    }

    private void sD() {
        if (this.adH >= -1.0d) {
            this.acZ.setFlexShrink((float) this.adH);
        }
    }

    private void sE() {
        if (this.adG >= -1.0d) {
            this.acZ.setFlexGrow((float) this.adG);
        }
    }

    private void sF() {
        if (this.adF >= -1.0d) {
            this.acZ.setFlex((float) this.adF);
        }
    }

    private void sG() {
        if (!TextUtils.isEmpty(this.adz)) {
            if ("flex".equalsIgnoreCase(this.adz)) {
                this.acZ.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.adz)) {
                this.acZ.setDisplay(CriusDisplay.NONE);
            } else {
                this.acZ.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void sH() {
        if (!b.c(this.adJ, -10000.0d)) {
            this.acZ.setPosition(CriusEdge.LEFT, e(this.adJ));
        }
        if (!b.c(this.adK, -10000.0d)) {
            this.acZ.setPosition(CriusEdge.TOP, e(this.adK));
        }
        if (!b.c(this.adL, -10000.0d)) {
            this.acZ.setPosition(CriusEdge.RIGHT, e(this.adL));
        }
        if (!b.c(this.adM, -10000.0d)) {
            this.acZ.setPosition(CriusEdge.BOTTOM, e(this.adM));
        }
    }

    private void sI() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.acZ.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.acZ.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void sJ() {
        if (!TextUtils.isEmpty(this.adE)) {
            if ("flex-start".equalsIgnoreCase(this.adE)) {
                this.acZ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adE)) {
                this.acZ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adE)) {
                this.acZ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adE)) {
                this.acZ.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.adE)) {
                this.acZ.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.adE)) {
                this.acZ.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.acZ.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void sK() {
        if (!TextUtils.isEmpty(this.adD)) {
            if ("auto".equalsIgnoreCase(this.adD)) {
                this.acZ.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.adD)) {
                this.acZ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adD)) {
                this.acZ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adD)) {
                this.acZ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adD)) {
                this.acZ.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.acZ.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void sL() {
        if (!TextUtils.isEmpty(this.adC)) {
            if ("flex-start".equalsIgnoreCase(this.adC)) {
                this.acZ.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adC)) {
                this.acZ.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adC)) {
                this.acZ.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adC)) {
                this.acZ.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.acZ.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void sM() {
        if (!TextUtils.isEmpty(this.adB)) {
            if ("flex-start".equalsIgnoreCase(this.adB)) {
                this.acZ.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adB)) {
                this.acZ.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adB)) {
                this.acZ.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.adB)) {
                this.acZ.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.adB)) {
                this.acZ.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.acZ.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void sN() {
        if (!TextUtils.isEmpty(this.adA)) {
            if ("column".equalsIgnoreCase(this.adA)) {
                this.acZ.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.adA)) {
                this.acZ.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.adA)) {
                this.acZ.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.adA)) {
                this.acZ.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.acZ.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.aeA != null && this.aeA.size() > 0) {
                for (a aVar : this.aeA) {
                    a cK = aVar.cK(str);
                    if (cK != null) {
                        return cK;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.ado)) {
            if (this.aeA != null && this.aeA.size() > 0) {
                for (a aVar : this.aeA) {
                    a cL = aVar.cL(str);
                    if (cL != null) {
                        return cL;
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

    public boolean cM(String str) {
        a cL;
        if (this.acY == null || (cL = cL(str)) == null || cL.acZ == null) {
            return false;
        }
        cL.acZ.setDisplay(CriusDisplay.NONE);
        cL.acZ.dirty();
        this.acY.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cK;
        if (this.acY != null && (cK = cK(str)) != null && cK.acZ != null) {
            cK.fontSize = f;
            cK.acZ.dirty();
            this.acY.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
