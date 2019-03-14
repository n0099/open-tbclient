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
    private static final TextPaint adb = new TextPaint(1);
    private static Class adc;
    private static Method ade;
    private static Method adf;
    private static Method adg;
    private static Method adh;
    private static Method adi;
    private static Method adj;
    private static Method adk;
    private static Field adl;
    private static Field adm;
    private static Field adn;
    public String acN;
    private CriusNode acZ;
    private String adA;
    private String adB;
    private String adC;
    private String adD;
    private String adE;
    private String adF;
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
    public String adp;
    public String adq;
    public String adr;
    public String ads;
    public String adt;
    public int adu;
    public int adv;
    public int adw;
    public String adx;
    public String ady;
    public double adz;
    public String aeA;
    public final List<a> aeB;
    private double aea;
    private double aeb;
    private double aec;
    public String aed;
    public double aee;
    public double aef;
    public double aeg;
    public double aeh;
    public double aei;
    public String aej;
    public String aek;
    public Typeface ael;
    public String aem;
    public String aen;
    public String aeo;
    public String aep;
    public String aeq;
    public String aer;
    public String aes;
    public String aet;
    public String aeu;
    public String aew;
    public String aex;
    public String aey;
    public String aez;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0037a businessConverter;
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
    private final CriusMeasureFunction ado = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.adb;
            if (a.this.fontSize >= 0.0d) {
                textPaint.setTextSize((float) (a.this.fontSize * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.adz > 0.0d ? (float) a.this.adz : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.ade.invoke(a.adc, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.adf.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.adg.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.adh.invoke(invoke, false);
                        Method method = a.adi;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.adl.get(Layout.class) : a.adm.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.adj.invoke(invoke, a.adn.get(Layout.class));
                        layout = (Layout) a.adk.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.ade.invoke(a.adc, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.adf.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.adg.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.adh.invoke(invoke2, false);
                    Method method2 = a.adi;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.adl.get(Layout.class) : a.adm.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.adj.invoke(invoke2, a.adn.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.adk.invoke(invoke2, new Object[0]);
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
    public double aev = -10000.0d;
    public final CriusNode ada = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0037a {
        String cN(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                adc = Class.forName("android.text.StaticLayout$Builder");
                ade = adc.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                ade.setAccessible(true);
                adf = adc.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                adf.setAccessible(true);
                adg = adc.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                adg.setAccessible(true);
                adh = adc.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                adh.setAccessible(true);
                adi = adc.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                adi.setAccessible(true);
                adj = adc.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                adj.setAccessible(true);
                adk = adc.getDeclaredMethod("build", new Class[0]);
                adk.setAccessible(true);
                adl = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                adl.setAccessible(true);
                adm = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                adm.setAccessible(true);
                adn = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                adn.setAccessible(true);
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
            this.ada.setMeasureFunction(this.ado);
        }
        this.adp = b.h(jSONObject, "component");
        this.src = b.h(jSONObject, "src");
        this.acN = b.h(jSONObject, "poster");
        this.adq = b.h(jSONObject, "href");
        this.text = b.h(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.adp) && this.businessConverter != null) {
            this.text = this.businessConverter.cN(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.adz = b.i(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.adr = jSONObject.optString("data-als-stat");
        this.ads = jSONObject.optString("data-url-stat");
        this.adt = jSONObject.optString("data-href-pop");
        this.adu = b.j(jSONObject, "data-share-num");
        this.adv = b.j(jSONObject, "data-reply-num");
        this.adw = b.j(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.adx = jSONObject.optString("data-share-image");
        this.ady = jSONObject.optString("data-share-link");
    }

    private void n(JSONObject jSONObject) {
        this.adA = b.h(jSONObject, "display");
        sG();
        this.adB = b.h(jSONObject, "flex-direction");
        sN();
        this.adC = b.h(jSONObject, "justify-content");
        sM();
        this.adD = b.h(jSONObject, "align-items");
        sL();
        this.adE = b.h(jSONObject, "align-self");
        sK();
        this.adF = b.h(jSONObject, "align-content");
        sJ();
        this.adG = b.i(jSONObject, "flex");
        sF();
        this.adH = b.i(jSONObject, "flex-grow");
        sE();
        this.adI = b.i(jSONObject, "flex-shrink");
        sD();
        this.adJ = b.i(jSONObject, "flex-basis");
        sC();
        this.position = b.h(jSONObject, "position");
        sI();
        this.adK = b.i(jSONObject, CustomDialogData.POS_LEFT);
        this.adL = b.i(jSONObject, "top");
        this.adM = b.i(jSONObject, "right");
        this.adN = b.i(jSONObject, "bottom");
        sH();
        this.adO = b.i(jSONObject, "margin");
        sB();
        this.adP = b.i(jSONObject, "margin-left");
        sx();
        this.adQ = b.i(jSONObject, "margin-top");
        sA();
        this.adR = b.i(jSONObject, "margin-right");
        sz();
        this.adS = b.i(jSONObject, "margin-bottom");
        sy();
        this.adT = b.i(jSONObject, "padding");
        initPadding();
        this.adU = b.i(jSONObject, "padding-left");
        st();
        this.adV = b.i(jSONObject, "padding-top");
        sw();
        this.adW = b.i(jSONObject, "padding-right");
        sv();
        this.adX = b.i(jSONObject, "padding-bottom");
        su();
        this.width = b.i(jSONObject, "width");
        ss();
        this.height = b.i(jSONObject, "height");
        sr();
        this.adY = b.i(jSONObject, "min-width");
        sq();
        this.adZ = b.i(jSONObject, "min-height");
        sp();
        this.aea = b.i(jSONObject, "max-width");
        sm();
        this.aeb = b.i(jSONObject, "max-height");
        so();
        this.aec = b.i(jSONObject, "aspect-ratio");
        sn();
    }

    private void o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aex = b.h(optJSONObject, "background-image");
            this.aey = b.h(optJSONObject, "background-color");
            this.aez = b.h(optJSONObject, "border-color");
            this.aeA = b.h(optJSONObject, "color");
        }
    }

    private void p(JSONObject jSONObject) {
        this.aes = b.h(jSONObject, "background-image");
        this.aet = b.h(jSONObject, "background-color");
        this.aeu = b.h(jSONObject, "border-color");
        this.aev = b.i(jSONObject, "opacity");
        this.aew = b.h(jSONObject, "color");
    }

    private void q(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aeo = b.h(optJSONObject, "background-image");
            this.aep = b.h(optJSONObject, "background-color");
            this.aeq = b.h(optJSONObject, "border-color");
            this.aer = b.h(optJSONObject, "color");
        }
    }

    private void r(JSONObject jSONObject) {
        this.aed = b.h(jSONObject, "background-image");
        this.backgroundColor = b.h(jSONObject, "background-color");
        this.borderColor = b.h(jSONObject, "border-color");
        this.opacity = b.i(jSONObject, "opacity");
        this.color = b.h(jSONObject, "color");
        this.aee = b.i(jSONObject, "border-width");
        this.borderRadius = b.i(jSONObject, "border-radius");
        this.aef = b.i(jSONObject, "border-top-left-radius");
        this.aeg = b.i(jSONObject, "border-bottom-left-radius");
        this.aeh = b.i(jSONObject, "border-top-right-radius");
        this.aei = b.i(jSONObject, "border-bottom-right-radius");
        this.aej = b.h(jSONObject, "font-style");
        this.aek = b.h(jSONObject, "font-weight");
        this.ael = Typeface.create(Typeface.DEFAULT, sk());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.aem = b.h(jSONObject, "text-align");
        this.aen = b.h(jSONObject, "vertical-align");
        this.gravity = sl();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0037a interfaceC0037a, boolean z) {
        this.businessConverter = interfaceC0037a;
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
                this.aeB = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0037a, false);
                    this.aeB.add(aVar);
                    this.ada.addChildAt(aVar.ada, i);
                }
            } else {
                this.aeB = null;
            }
        } else {
            this.aeB = null;
        }
        if (z) {
            this.acZ = new CriusNode();
            this.acZ.addChildAt(this.ada, 0);
            this.acZ.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int sk() {
        return "italic".equalsIgnoreCase(this.aej) ? (TextUtils.isEmpty(this.aek) || "normal".equalsIgnoreCase(this.aek) || !"bold".equalsIgnoreCase(this.aek)) ? 2 : 3 : (TextUtils.isEmpty(this.aek) || "normal".equalsIgnoreCase(this.aek) || !"bold".equalsIgnoreCase(this.aek)) ? 0 : 1;
    }

    private int sl() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.aem)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.aem)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.aem)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.aen)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.aen)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aen)) {
            return i | 16;
        }
        return i | 0;
    }

    private void sm() {
        if (this.aea >= 0.0d) {
            this.ada.setMaxWidth(e(this.aea));
        } else if (this.aea > -10000.0d) {
            this.ada.setMaxWidth(this.widthPixels);
        }
    }

    private void sn() {
        if (this.aec > 0.0d) {
            this.ada.setAspectRatio((float) this.aec);
        }
    }

    private void so() {
        if (this.aeb >= 0.0d) {
            this.ada.setMaxHeight(e(this.aeb));
        } else if (this.aeb > -10000.0d) {
            this.ada.setMaxHeight(this.heightPixels);
        }
    }

    private void sp() {
        if (this.adZ >= 0.0d) {
            this.ada.setMinHeight(e(this.adZ));
        } else if (this.adZ > -10000.0d) {
            this.ada.setMinHeight(this.heightPixels);
        }
    }

    private void sq() {
        if (this.adY >= 0.0d) {
            this.ada.setMinWidth(e(this.adY));
        } else if (this.adY > -10000.0d) {
            this.ada.setMinWidth(this.widthPixels);
        }
    }

    private void sr() {
        if (this.height >= 0.0d) {
            this.ada.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.ada.setHeight(this.heightPixels);
        }
    }

    private void ss() {
        if (this.width >= 0.0d) {
            this.ada.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.ada.setWidth(this.widthPixels);
        }
    }

    private void st() {
        if (this.adU >= -1.0d) {
            this.ada.setPadding(CriusEdge.LEFT, e(this.adU));
        }
    }

    private void su() {
        if (this.adX >= -1.0d) {
            this.ada.setPadding(CriusEdge.BOTTOM, e(this.adX));
        }
    }

    private void sv() {
        if (this.adW >= -1.0d) {
            this.ada.setPadding(CriusEdge.RIGHT, e(this.adW));
        }
    }

    private void sw() {
        if (this.adV >= -1.0d) {
            this.ada.setPadding(CriusEdge.TOP, e(this.adV));
        }
    }

    private void initPadding() {
        if (this.adT >= -1.0d) {
            this.ada.setPadding(CriusEdge.ALL, e(this.adT));
        }
    }

    private void sx() {
        if (this.adP >= -1.0d) {
            this.ada.setMargin(CriusEdge.LEFT, e(this.adP));
        }
    }

    private void sy() {
        if (this.adS >= -1.0d) {
            this.ada.setMargin(CriusEdge.BOTTOM, e(this.adS));
        }
    }

    private void sz() {
        if (this.adR >= -1.0d) {
            this.ada.setMargin(CriusEdge.RIGHT, e(this.adR));
        }
    }

    private void sA() {
        if (this.adQ >= -1.0d) {
            this.ada.setMargin(CriusEdge.TOP, e(this.adQ));
        }
    }

    private void sB() {
        if (this.adO >= -1.0d) {
            this.ada.setMargin(CriusEdge.ALL, e(this.adO));
        }
    }

    private void sC() {
        if (this.adJ >= -1.0d) {
            this.ada.setFlexBasis(e(this.adJ));
        }
    }

    private void sD() {
        if (this.adI >= -1.0d) {
            this.ada.setFlexShrink((float) this.adI);
        }
    }

    private void sE() {
        if (this.adH >= -1.0d) {
            this.ada.setFlexGrow((float) this.adH);
        }
    }

    private void sF() {
        if (this.adG >= -1.0d) {
            this.ada.setFlex((float) this.adG);
        }
    }

    private void sG() {
        if (!TextUtils.isEmpty(this.adA)) {
            if ("flex".equalsIgnoreCase(this.adA)) {
                this.ada.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.adA)) {
                this.ada.setDisplay(CriusDisplay.NONE);
            } else {
                this.ada.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void sH() {
        if (!b.c(this.adK, -10000.0d)) {
            this.ada.setPosition(CriusEdge.LEFT, e(this.adK));
        }
        if (!b.c(this.adL, -10000.0d)) {
            this.ada.setPosition(CriusEdge.TOP, e(this.adL));
        }
        if (!b.c(this.adM, -10000.0d)) {
            this.ada.setPosition(CriusEdge.RIGHT, e(this.adM));
        }
        if (!b.c(this.adN, -10000.0d)) {
            this.ada.setPosition(CriusEdge.BOTTOM, e(this.adN));
        }
    }

    private void sI() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.ada.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.ada.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void sJ() {
        if (!TextUtils.isEmpty(this.adF)) {
            if ("flex-start".equalsIgnoreCase(this.adF)) {
                this.ada.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adF)) {
                this.ada.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adF)) {
                this.ada.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adF)) {
                this.ada.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.adF)) {
                this.ada.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.adF)) {
                this.ada.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.ada.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void sK() {
        if (!TextUtils.isEmpty(this.adE)) {
            if ("auto".equalsIgnoreCase(this.adE)) {
                this.ada.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.adE)) {
                this.ada.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adE)) {
                this.ada.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adE)) {
                this.ada.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adE)) {
                this.ada.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.ada.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void sL() {
        if (!TextUtils.isEmpty(this.adD)) {
            if ("flex-start".equalsIgnoreCase(this.adD)) {
                this.ada.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adD)) {
                this.ada.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adD)) {
                this.ada.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adD)) {
                this.ada.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.ada.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void sM() {
        if (!TextUtils.isEmpty(this.adC)) {
            if ("flex-start".equalsIgnoreCase(this.adC)) {
                this.ada.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adC)) {
                this.ada.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adC)) {
                this.ada.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.adC)) {
                this.ada.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.adC)) {
                this.ada.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.ada.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void sN() {
        if (!TextUtils.isEmpty(this.adB)) {
            if ("column".equalsIgnoreCase(this.adB)) {
                this.ada.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.adB)) {
                this.ada.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.adB)) {
                this.ada.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.adB)) {
                this.ada.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.ada.setFlexDirection(CriusFlexDirection.COLUMN);
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
            if (this.aeB != null && this.aeB.size() > 0) {
                for (a aVar : this.aeB) {
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
        if (!str.equalsIgnoreCase(this.adp)) {
            if (this.aeB != null && this.aeB.size() > 0) {
                for (a aVar : this.aeB) {
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
        if (this.acZ == null || (cL = cL(str)) == null || cL.ada == null) {
            return false;
        }
        cL.ada.setDisplay(CriusDisplay.NONE);
        cL.ada.dirty();
        this.acZ.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cK;
        if (this.acZ != null && (cK = cK(str)) != null && cK.ada != null) {
            cK.fontSize = f;
            cK.ada.dirty();
            this.acZ.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
