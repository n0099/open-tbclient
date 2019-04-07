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
    private static final TextPaint adh = new TextPaint(1);
    private static Class adi;
    private static Method adj;
    private static Method adk;
    private static Method adl;
    private static Method adm;
    private static Method adn;
    private static Method ado;
    private static Method adp;
    private static Field adq;
    private static Field adr;
    private static Field ads;
    public String acS;
    public int adA;
    public int adB;
    public String adC;
    public String adD;
    public double adE;
    private String adF;
    private String adG;
    private String adH;
    private String adI;
    private String adJ;
    private String adK;
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
    private CriusNode adf;
    public String adu;
    public String adv;
    public String adw;
    public String adx;
    public String ady;
    public int adz;
    public String aeB;
    public String aeC;
    public String aeD;
    public String aeE;
    public String aeF;
    public final List<a> aeG;
    private double aea;
    private double aeb;
    private double aec;
    private double aed;
    private double aee;
    private double aef;
    private double aeg;
    private double aeh;
    public String aei;
    public double aej;
    public double aek;
    public double ael;
    public double aem;
    public double aen;
    public String aeo;
    public String aep;
    public Typeface aeq;
    public String aer;
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
    private final CriusMeasureFunction adt = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.adh;
            if (a.this.fontSize >= 0.0d) {
                textPaint.setTextSize((float) (a.this.fontSize * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.adE > 0.0d ? (float) a.this.adE : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.adj.invoke(a.adi, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.adk.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.adl.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.adm.invoke(invoke, false);
                        Method method = a.adn;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.adq.get(Layout.class) : a.adr.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.ado.invoke(invoke, a.ads.get(Layout.class));
                        layout = (Layout) a.adp.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.adj.invoke(a.adi, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.adk.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.adl.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.adm.invoke(invoke2, false);
                    Method method2 = a.adn;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.adq.get(Layout.class) : a.adr.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.ado.invoke(invoke2, a.ads.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.adp.invoke(invoke2, new Object[0]);
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
    public double aeA = -10000.0d;
    public final CriusNode adg = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0037a {
        String cP(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                adi = Class.forName("android.text.StaticLayout$Builder");
                adj = adi.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                adj.setAccessible(true);
                adk = adi.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                adk.setAccessible(true);
                adl = adi.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                adl.setAccessible(true);
                adm = adi.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                adm.setAccessible(true);
                adn = adi.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                adn.setAccessible(true);
                ado = adi.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                ado.setAccessible(true);
                adp = adi.getDeclaredMethod("build", new Class[0]);
                adp.setAccessible(true);
                adq = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                adq.setAccessible(true);
                adr = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                adr.setAccessible(true);
                ads = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                ads.setAccessible(true);
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
            this.adg.setMeasureFunction(this.adt);
        }
        this.adu = b.h(jSONObject, "component");
        this.src = b.h(jSONObject, "src");
        this.acS = b.h(jSONObject, "poster");
        this.adv = b.h(jSONObject, "href");
        this.text = b.h(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.adu) && this.businessConverter != null) {
            this.text = this.businessConverter.cP(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.adE = b.i(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.adw = jSONObject.optString("data-als-stat");
        this.adx = jSONObject.optString("data-url-stat");
        this.ady = jSONObject.optString("data-href-pop");
        this.adz = b.j(jSONObject, "data-share-num");
        this.adA = b.j(jSONObject, "data-reply-num");
        this.adB = b.j(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.adC = jSONObject.optString("data-share-image");
        this.adD = jSONObject.optString("data-share-link");
    }

    private void n(JSONObject jSONObject) {
        this.adF = b.h(jSONObject, "display");
        sF();
        this.adG = b.h(jSONObject, "flex-direction");
        sM();
        this.adH = b.h(jSONObject, "justify-content");
        sL();
        this.adI = b.h(jSONObject, "align-items");
        sK();
        this.adJ = b.h(jSONObject, "align-self");
        sJ();
        this.adK = b.h(jSONObject, "align-content");
        sI();
        this.adL = b.i(jSONObject, "flex");
        sE();
        this.adM = b.i(jSONObject, "flex-grow");
        sD();
        this.adN = b.i(jSONObject, "flex-shrink");
        sC();
        this.adO = b.i(jSONObject, "flex-basis");
        sB();
        this.position = b.h(jSONObject, "position");
        sH();
        this.adP = b.i(jSONObject, CustomDialogData.POS_LEFT);
        this.adQ = b.i(jSONObject, "top");
        this.adR = b.i(jSONObject, "right");
        this.adS = b.i(jSONObject, "bottom");
        sG();
        this.adT = b.i(jSONObject, "margin");
        sA();
        this.adU = b.i(jSONObject, "margin-left");
        sw();
        this.adV = b.i(jSONObject, "margin-top");
        sz();
        this.adW = b.i(jSONObject, "margin-right");
        sy();
        this.adX = b.i(jSONObject, "margin-bottom");
        sx();
        this.adY = b.i(jSONObject, "padding");
        initPadding();
        this.adZ = b.i(jSONObject, "padding-left");
        ss();
        this.aea = b.i(jSONObject, "padding-top");
        sv();
        this.aeb = b.i(jSONObject, "padding-right");
        su();
        this.aec = b.i(jSONObject, "padding-bottom");
        st();
        this.width = b.i(jSONObject, "width");
        sr();
        this.height = b.i(jSONObject, "height");
        sq();
        this.aed = b.i(jSONObject, "min-width");
        sp();
        this.aee = b.i(jSONObject, "min-height");
        so();
        this.aef = b.i(jSONObject, "max-width");
        sl();
        this.aeg = b.i(jSONObject, "max-height");
        sn();
        this.aeh = b.i(jSONObject, "aspect-ratio");
        sm();
    }

    private void o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aeC = b.h(optJSONObject, "background-image");
            this.aeD = b.h(optJSONObject, "background-color");
            this.aeE = b.h(optJSONObject, "border-color");
            this.aeF = b.h(optJSONObject, "color");
        }
    }

    private void p(JSONObject jSONObject) {
        this.aex = b.h(jSONObject, "background-image");
        this.aey = b.h(jSONObject, "background-color");
        this.aez = b.h(jSONObject, "border-color");
        this.aeA = b.i(jSONObject, "opacity");
        this.aeB = b.h(jSONObject, "color");
    }

    private void q(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aet = b.h(optJSONObject, "background-image");
            this.aeu = b.h(optJSONObject, "background-color");
            this.aev = b.h(optJSONObject, "border-color");
            this.aew = b.h(optJSONObject, "color");
        }
    }

    private void r(JSONObject jSONObject) {
        this.aei = b.h(jSONObject, "background-image");
        this.backgroundColor = b.h(jSONObject, "background-color");
        this.borderColor = b.h(jSONObject, "border-color");
        this.opacity = b.i(jSONObject, "opacity");
        this.color = b.h(jSONObject, "color");
        this.aej = b.i(jSONObject, "border-width");
        this.borderRadius = b.i(jSONObject, "border-radius");
        this.aek = b.i(jSONObject, "border-top-left-radius");
        this.ael = b.i(jSONObject, "border-bottom-left-radius");
        this.aem = b.i(jSONObject, "border-top-right-radius");
        this.aen = b.i(jSONObject, "border-bottom-right-radius");
        this.aeo = b.h(jSONObject, "font-style");
        this.aep = b.h(jSONObject, "font-weight");
        this.aeq = Typeface.create(Typeface.DEFAULT, sj());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.aer = b.h(jSONObject, "text-align");
        this.aes = b.h(jSONObject, "vertical-align");
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
                this.aeG = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0037a, false);
                    this.aeG.add(aVar);
                    this.adg.addChildAt(aVar.adg, i);
                }
            } else {
                this.aeG = null;
            }
        } else {
            this.aeG = null;
        }
        if (z) {
            this.adf = new CriusNode();
            this.adf.addChildAt(this.adg, 0);
            this.adf.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int sj() {
        return "italic".equalsIgnoreCase(this.aeo) ? (TextUtils.isEmpty(this.aep) || "normal".equalsIgnoreCase(this.aep) || !"bold".equalsIgnoreCase(this.aep)) ? 2 : 3 : (TextUtils.isEmpty(this.aep) || "normal".equalsIgnoreCase(this.aep) || !"bold".equalsIgnoreCase(this.aep)) ? 0 : 1;
    }

    private int sk() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.aer)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.aer)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.aer)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.aes)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.aes)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aes)) {
            return i | 16;
        }
        return i | 0;
    }

    private void sl() {
        if (this.aef >= 0.0d) {
            this.adg.setMaxWidth(e(this.aef));
        } else if (this.aef > -10000.0d) {
            this.adg.setMaxWidth(this.widthPixels);
        }
    }

    private void sm() {
        if (this.aeh > 0.0d) {
            this.adg.setAspectRatio((float) this.aeh);
        }
    }

    private void sn() {
        if (this.aeg >= 0.0d) {
            this.adg.setMaxHeight(e(this.aeg));
        } else if (this.aeg > -10000.0d) {
            this.adg.setMaxHeight(this.heightPixels);
        }
    }

    private void so() {
        if (this.aee >= 0.0d) {
            this.adg.setMinHeight(e(this.aee));
        } else if (this.aee > -10000.0d) {
            this.adg.setMinHeight(this.heightPixels);
        }
    }

    private void sp() {
        if (this.aed >= 0.0d) {
            this.adg.setMinWidth(e(this.aed));
        } else if (this.aed > -10000.0d) {
            this.adg.setMinWidth(this.widthPixels);
        }
    }

    private void sq() {
        if (this.height >= 0.0d) {
            this.adg.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.adg.setHeight(this.heightPixels);
        }
    }

    private void sr() {
        if (this.width >= 0.0d) {
            this.adg.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.adg.setWidth(this.widthPixels);
        }
    }

    private void ss() {
        if (this.adZ >= -1.0d) {
            this.adg.setPadding(CriusEdge.LEFT, e(this.adZ));
        }
    }

    private void st() {
        if (this.aec >= -1.0d) {
            this.adg.setPadding(CriusEdge.BOTTOM, e(this.aec));
        }
    }

    private void su() {
        if (this.aeb >= -1.0d) {
            this.adg.setPadding(CriusEdge.RIGHT, e(this.aeb));
        }
    }

    private void sv() {
        if (this.aea >= -1.0d) {
            this.adg.setPadding(CriusEdge.TOP, e(this.aea));
        }
    }

    private void initPadding() {
        if (this.adY >= -1.0d) {
            this.adg.setPadding(CriusEdge.ALL, e(this.adY));
        }
    }

    private void sw() {
        if (this.adU >= -1.0d) {
            this.adg.setMargin(CriusEdge.LEFT, e(this.adU));
        }
    }

    private void sx() {
        if (this.adX >= -1.0d) {
            this.adg.setMargin(CriusEdge.BOTTOM, e(this.adX));
        }
    }

    private void sy() {
        if (this.adW >= -1.0d) {
            this.adg.setMargin(CriusEdge.RIGHT, e(this.adW));
        }
    }

    private void sz() {
        if (this.adV >= -1.0d) {
            this.adg.setMargin(CriusEdge.TOP, e(this.adV));
        }
    }

    private void sA() {
        if (this.adT >= -1.0d) {
            this.adg.setMargin(CriusEdge.ALL, e(this.adT));
        }
    }

    private void sB() {
        if (this.adO >= -1.0d) {
            this.adg.setFlexBasis(e(this.adO));
        }
    }

    private void sC() {
        if (this.adN >= -1.0d) {
            this.adg.setFlexShrink((float) this.adN);
        }
    }

    private void sD() {
        if (this.adM >= -1.0d) {
            this.adg.setFlexGrow((float) this.adM);
        }
    }

    private void sE() {
        if (this.adL >= -1.0d) {
            this.adg.setFlex((float) this.adL);
        }
    }

    private void sF() {
        if (!TextUtils.isEmpty(this.adF)) {
            if ("flex".equalsIgnoreCase(this.adF)) {
                this.adg.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.adF)) {
                this.adg.setDisplay(CriusDisplay.NONE);
            } else {
                this.adg.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void sG() {
        if (!b.c(this.adP, -10000.0d)) {
            this.adg.setPosition(CriusEdge.LEFT, e(this.adP));
        }
        if (!b.c(this.adQ, -10000.0d)) {
            this.adg.setPosition(CriusEdge.TOP, e(this.adQ));
        }
        if (!b.c(this.adR, -10000.0d)) {
            this.adg.setPosition(CriusEdge.RIGHT, e(this.adR));
        }
        if (!b.c(this.adS, -10000.0d)) {
            this.adg.setPosition(CriusEdge.BOTTOM, e(this.adS));
        }
    }

    private void sH() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.adg.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.adg.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void sI() {
        if (!TextUtils.isEmpty(this.adK)) {
            if ("flex-start".equalsIgnoreCase(this.adK)) {
                this.adg.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adK)) {
                this.adg.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adK)) {
                this.adg.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adK)) {
                this.adg.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.adK)) {
                this.adg.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.adK)) {
                this.adg.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.adg.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void sJ() {
        if (!TextUtils.isEmpty(this.adJ)) {
            if ("auto".equalsIgnoreCase(this.adJ)) {
                this.adg.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.adJ)) {
                this.adg.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adJ)) {
                this.adg.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adJ)) {
                this.adg.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adJ)) {
                this.adg.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.adg.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void sK() {
        if (!TextUtils.isEmpty(this.adI)) {
            if ("flex-start".equalsIgnoreCase(this.adI)) {
                this.adg.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adI)) {
                this.adg.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adI)) {
                this.adg.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.adI)) {
                this.adg.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.adg.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void sL() {
        if (!TextUtils.isEmpty(this.adH)) {
            if ("flex-start".equalsIgnoreCase(this.adH)) {
                this.adg.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.adH)) {
                this.adg.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.adH)) {
                this.adg.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.adH)) {
                this.adg.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.adH)) {
                this.adg.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.adg.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void sM() {
        if (!TextUtils.isEmpty(this.adG)) {
            if ("column".equalsIgnoreCase(this.adG)) {
                this.adg.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.adG)) {
                this.adg.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.adG)) {
                this.adg.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.adG)) {
                this.adg.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.adg.setFlexDirection(CriusFlexDirection.COLUMN);
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
            if (this.aeG != null && this.aeG.size() > 0) {
                for (a aVar : this.aeG) {
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
        if (!str.equalsIgnoreCase(this.adu)) {
            if (this.aeG != null && this.aeG.size() > 0) {
                for (a aVar : this.aeG) {
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
        if (this.adf == null || (cN = cN(str)) == null || cN.adg == null) {
            return false;
        }
        cN.adg.setDisplay(CriusDisplay.NONE);
        cN.adg.dirty();
        this.adf.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cM;
        if (this.adf != null && (cM = cM(str)) != null && cM.adg != null) {
            cM.fontSize = f;
            cM.adg.dirty();
            this.adf.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
