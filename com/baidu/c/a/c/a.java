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
    private static final TextPaint adi = new TextPaint(1);
    private static Class adj;
    private static Method adk;
    private static Method adl;
    private static Method adm;
    private static Method adn;
    private static Method ado;
    private static Method adp;
    private static Method adq;
    private static Field adr;
    private static Field ads;
    private static Field adt;
    public String acT;
    public int adA;
    public int adB;
    public int adC;
    public String adD;
    public String adE;
    public double adF;
    private String adG;
    private String adH;
    private String adI;
    private String adJ;
    private String adK;
    private String adL;
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
    private CriusNode adg;
    public String adv;
    public String adw;
    public String adx;
    public String ady;
    public String adz;
    public String aeA;
    public String aeC;
    public String aeD;
    public String aeE;
    public String aeF;
    public String aeG;
    public final List<a> aeH;
    private double aea;
    private double aeb;
    private double aec;
    private double aed;
    private double aee;
    private double aef;
    private double aeg;
    private double aeh;
    private double aei;
    public String aej;
    public double aek;
    public double ael;
    public double aem;
    public double aen;
    public double aeo;
    public String aep;
    public String aeq;
    public Typeface aer;
    public String aes;
    public String aet;
    public String aeu;
    public String aev;
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
    private final CriusMeasureFunction adu = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.adi;
            if (a.this.fontSize >= 0.0d) {
                textPaint.setTextSize((float) (a.this.fontSize * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.adF > 0.0d ? (float) a.this.adF : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.adk.invoke(a.adj, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.adl.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.adm.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.adn.invoke(invoke, false);
                        Method method = a.ado;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.adr.get(Layout.class) : a.ads.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.adp.invoke(invoke, a.adt.get(Layout.class));
                        layout = (Layout) a.adq.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.adk.invoke(a.adj, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.adl.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.adm.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.adn.invoke(invoke2, false);
                    Method method2 = a.ado;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.adr.get(Layout.class) : a.ads.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.adp.invoke(invoke2, a.adt.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.adq.invoke(invoke2, new Object[0]);
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
    public double aeB = -10000.0d;
    public final CriusNode adh = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0037a {
        String cP(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                adj = Class.forName("android.text.StaticLayout$Builder");
                adk = adj.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                adk.setAccessible(true);
                adl = adj.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                adl.setAccessible(true);
                adm = adj.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                adm.setAccessible(true);
                adn = adj.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                adn.setAccessible(true);
                ado = adj.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                ado.setAccessible(true);
                adp = adj.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                adp.setAccessible(true);
                adq = adj.getDeclaredMethod("build", new Class[0]);
                adq.setAccessible(true);
                adr = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                adr.setAccessible(true);
                ads = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                ads.setAccessible(true);
                adt = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                adt.setAccessible(true);
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

    public static boolean cL(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cL(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void m(JSONObject jSONObject) {
        this.id = b.h(jSONObject, "id");
        this.name = b.h(jSONObject, "name");
        this.type = b.h(jSONObject, "type");
        if (isText()) {
            this.adh.setMeasureFunction(this.adu);
        }
        this.adv = b.h(jSONObject, "component");
        this.src = b.h(jSONObject, "src");
        this.acT = b.h(jSONObject, "poster");
        this.adw = b.h(jSONObject, "href");
        this.text = b.h(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.adv) && this.businessConverter != null) {
            this.text = this.businessConverter.cP(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.adF = b.i(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.adx = jSONObject.optString("data-als-stat");
        this.ady = jSONObject.optString("data-url-stat");
        this.adz = jSONObject.optString("data-href-pop");
        this.adA = b.j(jSONObject, "data-share-num");
        this.adB = b.j(jSONObject, "data-reply-num");
        this.adC = b.j(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.adD = jSONObject.optString("data-share-image");
        this.adE = jSONObject.optString("data-share-link");
    }

    private void n(JSONObject jSONObject) {
        this.adG = b.h(jSONObject, "display");
        sF();
        this.adH = b.h(jSONObject, "flex-direction");
        sM();
        this.adI = b.h(jSONObject, "justify-content");
        sL();
        this.adJ = b.h(jSONObject, "align-items");
        sK();
        this.adK = b.h(jSONObject, "align-self");
        sJ();
        this.adL = b.h(jSONObject, "align-content");
        sI();
        this.adM = b.i(jSONObject, "flex");
        sE();
        this.adN = b.i(jSONObject, "flex-grow");
        sD();
        this.adO = b.i(jSONObject, "flex-shrink");
        sC();
        this.adP = b.i(jSONObject, "flex-basis");
        sB();
        this.position = b.h(jSONObject, "position");
        sH();
        this.adQ = b.i(jSONObject, CustomDialogData.POS_LEFT);
        this.adR = b.i(jSONObject, "top");
        this.adS = b.i(jSONObject, "right");
        this.adT = b.i(jSONObject, "bottom");
        sG();
        this.adU = b.i(jSONObject, "margin");
        sA();
        this.adV = b.i(jSONObject, "margin-left");
        sw();
        this.adW = b.i(jSONObject, "margin-top");
        sz();
        this.adX = b.i(jSONObject, "margin-right");
        sy();
        this.adY = b.i(jSONObject, "margin-bottom");
        sx();
        this.adZ = b.i(jSONObject, "padding");
        initPadding();
        this.aea = b.i(jSONObject, "padding-left");
        ss();
        this.aeb = b.i(jSONObject, "padding-top");
        sv();
        this.aec = b.i(jSONObject, "padding-right");
        su();
        this.aed = b.i(jSONObject, "padding-bottom");
        st();
        this.width = b.i(jSONObject, "width");
        sr();
        this.height = b.i(jSONObject, "height");
        sq();
        this.aee = b.i(jSONObject, "min-width");
        sp();
        this.aef = b.i(jSONObject, "min-height");
        so();
        this.aeg = b.i(jSONObject, "max-width");
        sl();
        this.aeh = b.i(jSONObject, "max-height");
        sn();
        this.aei = b.i(jSONObject, "aspect-ratio");
        sm();
    }

    private void o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aeD = b.h(optJSONObject, "background-image");
            this.aeE = b.h(optJSONObject, "background-color");
            this.aeF = b.h(optJSONObject, "border-color");
            this.aeG = b.h(optJSONObject, "color");
        }
    }

    private void p(JSONObject jSONObject) {
        this.aey = b.h(jSONObject, "background-image");
        this.aez = b.h(jSONObject, "background-color");
        this.aeA = b.h(jSONObject, "border-color");
        this.aeB = b.i(jSONObject, "opacity");
        this.aeC = b.h(jSONObject, "color");
    }

    private void q(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aeu = b.h(optJSONObject, "background-image");
            this.aev = b.h(optJSONObject, "background-color");
            this.aew = b.h(optJSONObject, "border-color");
            this.aex = b.h(optJSONObject, "color");
        }
    }

    private void r(JSONObject jSONObject) {
        this.aej = b.h(jSONObject, "background-image");
        this.backgroundColor = b.h(jSONObject, "background-color");
        this.borderColor = b.h(jSONObject, "border-color");
        this.opacity = b.i(jSONObject, "opacity");
        this.color = b.h(jSONObject, "color");
        this.aek = b.i(jSONObject, "border-width");
        this.borderRadius = b.i(jSONObject, "border-radius");
        this.ael = b.i(jSONObject, "border-top-left-radius");
        this.aem = b.i(jSONObject, "border-bottom-left-radius");
        this.aen = b.i(jSONObject, "border-top-right-radius");
        this.aeo = b.i(jSONObject, "border-bottom-right-radius");
        this.aep = b.h(jSONObject, "font-style");
        this.aeq = b.h(jSONObject, "font-weight");
        this.aer = Typeface.create(Typeface.DEFAULT, sj());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.aes = b.h(jSONObject, "text-align");
        this.aet = b.h(jSONObject, "vertical-align");
        this.gravity = sk();
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
                this.aeH = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0037a, false);
                    this.aeH.add(aVar);
                    this.adh.addChildAt(aVar.adh, i);
                }
            } else {
                this.aeH = null;
            }
        } else {
            this.aeH = null;
        }
        if (z) {
            this.adg = new CriusNode();
            this.adg.addChildAt(this.adh, 0);
            this.adg.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int sj() {
        return "italic".equalsIgnoreCase(this.aep) ? (TextUtils.isEmpty(this.aeq) || "normal".equalsIgnoreCase(this.aeq) || !"bold".equalsIgnoreCase(this.aeq)) ? 2 : 3 : (TextUtils.isEmpty(this.aeq) || "normal".equalsIgnoreCase(this.aeq) || !"bold".equalsIgnoreCase(this.aeq)) ? 0 : 1;
    }

    private int sk() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.aes)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.aes)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.aes)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.aet)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.aet)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aet)) {
            return i | 16;
        }
        return i | 0;
    }

    private void sl() {
        if (this.aeg >= 0.0d) {
            this.adh.setMaxWidth(e(this.aeg));
        } else if (this.aeg > -10000.0d) {
            this.adh.setMaxWidth(this.widthPixels);
        }
    }

    private void sm() {
        if (this.aei > 0.0d) {
            this.adh.setAspectRatio((float) this.aei);
        }
    }

    private void sn() {
        if (this.aeh >= 0.0d) {
            this.adh.setMaxHeight(e(this.aeh));
        } else if (this.aeh > -10000.0d) {
            this.adh.setMaxHeight(this.heightPixels);
        }
    }

    private void so() {
        if (this.aef >= 0.0d) {
            this.adh.setMinHeight(e(this.aef));
        } else if (this.aef > -10000.0d) {
            this.adh.setMinHeight(this.heightPixels);
        }
    }

    private void sp() {
        if (this.aee >= 0.0d) {
            this.adh.setMinWidth(e(this.aee));
        } else if (this.aee > -10000.0d) {
            this.adh.setMinWidth(this.widthPixels);
        }
    }

    private void sq() {
        if (this.height >= 0.0d) {
            this.adh.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.adh.setHeight(this.heightPixels);
        }
    }

    private void sr() {
        if (this.width >= 0.0d) {
            this.adh.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.adh.setWidth(this.widthPixels);
        }
    }

    private void ss() {
        if (this.aea >= -1.0d) {
            this.adh.setPadding(CriusEdge.LEFT, e(this.aea));
        }
    }

    private void st() {
        if (this.aed >= -1.0d) {
            this.adh.setPadding(CriusEdge.BOTTOM, e(this.aed));
        }
    }

    private void su() {
        if (this.aec >= -1.0d) {
            this.adh.setPadding(CriusEdge.RIGHT, e(this.aec));
        }
    }

    private void sv() {
        if (this.aeb >= -1.0d) {
            this.adh.setPadding(CriusEdge.TOP, e(this.aeb));
        }
    }

    private void initPadding() {
        if (this.adZ >= -1.0d) {
            this.adh.setPadding(CriusEdge.ALL, e(this.adZ));
        }
    }

    private void sw() {
        if (this.adV >= -1.0d) {
            this.adh.setMargin(CriusEdge.LEFT, e(this.adV));
        }
    }

    private void sx() {
        if (this.adY >= -1.0d) {
            this.adh.setMargin(CriusEdge.BOTTOM, e(this.adY));
        }
    }

    private void sy() {
        if (this.adX >= -1.0d) {
            this.adh.setMargin(CriusEdge.RIGHT, e(this.adX));
        }
    }

    private void sz() {
        if (this.adW >= -1.0d) {
            this.adh.setMargin(CriusEdge.TOP, e(this.adW));
        }
    }

    private void sA() {
        if (this.adU >= -1.0d) {
            this.adh.setMargin(CriusEdge.ALL, e(this.adU));
        }
    }

    private void sB() {
        if (this.adP >= -1.0d) {
            this.adh.setFlexBasis(e(this.adP));
        }
    }

    private void sC() {
        if (this.adO >= -1.0d) {
            this.adh.setFlexShrink((float) this.adO);
        }
    }

    private void sD() {
        if (this.adN >= -1.0d) {
            this.adh.setFlexGrow((float) this.adN);
        }
    }

    private void sE() {
        if (this.adM >= -1.0d) {
            this.adh.setFlex((float) this.adM);
        }
    }

    private void sF() {
        if (!TextUtils.isEmpty(this.adG)) {
            if ("flex".equalsIgnoreCase(this.adG)) {
                this.adh.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.adG)) {
                this.adh.setDisplay(CriusDisplay.NONE);
            } else {
                this.adh.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void sG() {
        if (!b.c(this.adQ, -10000.0d)) {
            this.adh.setPosition(CriusEdge.LEFT, e(this.adQ));
        }
        if (!b.c(this.adR, -10000.0d)) {
            this.adh.setPosition(CriusEdge.TOP, e(this.adR));
        }
        if (!b.c(this.adS, -10000.0d)) {
            this.adh.setPosition(CriusEdge.RIGHT, e(this.adS));
        }
        if (!b.c(this.adT, -10000.0d)) {
            this.adh.setPosition(CriusEdge.BOTTOM, e(this.adT));
        }
    }

    private void sH() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.adh.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.adh.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void sI() {
        if (!TextUtils.isEmpty(this.adL)) {
            if ("flex-start".equalsIgnoreCase(this.adL)) {
                this.adh.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adL)) {
                this.adh.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adL)) {
                this.adh.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adL)) {
                this.adh.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.adL)) {
                this.adh.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.adL)) {
                this.adh.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.adh.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void sJ() {
        if (!TextUtils.isEmpty(this.adK)) {
            if ("auto".equalsIgnoreCase(this.adK)) {
                this.adh.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.adK)) {
                this.adh.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adK)) {
                this.adh.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adK)) {
                this.adh.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adK)) {
                this.adh.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.adh.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void sK() {
        if (!TextUtils.isEmpty(this.adJ)) {
            if ("flex-start".equalsIgnoreCase(this.adJ)) {
                this.adh.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adJ)) {
                this.adh.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adJ)) {
                this.adh.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adJ)) {
                this.adh.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.adh.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void sL() {
        if (!TextUtils.isEmpty(this.adI)) {
            if ("flex-start".equalsIgnoreCase(this.adI)) {
                this.adh.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adI)) {
                this.adh.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adI)) {
                this.adh.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.adI)) {
                this.adh.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.adI)) {
                this.adh.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.adh.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void sM() {
        if (!TextUtils.isEmpty(this.adH)) {
            if ("column".equalsIgnoreCase(this.adH)) {
                this.adh.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.adH)) {
                this.adh.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.adH)) {
                this.adh.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.adH)) {
                this.adh.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.adh.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.aeH != null && this.aeH.size() > 0) {
                for (a aVar : this.aeH) {
                    a cM = aVar.cM(str);
                    if (cM != null) {
                        return cM;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.adv)) {
            if (this.aeH != null && this.aeH.size() > 0) {
                for (a aVar : this.aeH) {
                    a cN = aVar.cN(str);
                    if (cN != null) {
                        return cN;
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

    public boolean cO(String str) {
        a cN;
        if (this.adg == null || (cN = cN(str)) == null || cN.adh == null) {
            return false;
        }
        cN.adh.setDisplay(CriusDisplay.NONE);
        cN.adh.dirty();
        this.adg.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cM;
        if (this.adg != null && (cM = cM(str)) != null && cM.adh != null) {
            cM.fontSize = f;
            cM.adh.dirty();
            this.adg.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
