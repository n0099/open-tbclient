package com.baidu.b.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.b.a.e.b;
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
    private static Method azA;
    private static Field azB;
    private static Field azC;
    private static Field azD;
    private static final TextPaint azs = new TextPaint(1);
    private static Class azt;
    private static Method azu;
    private static Method azv;
    private static Method azw;
    private static Method azx;
    private static Method azy;
    private static Method azz;
    public String aAA;
    public Typeface aAB;
    public double aAC;
    public String aAD;
    public String aAE;
    public String aAF;
    public String aAG;
    public String aAH;
    public String aAI;
    public String aAJ;
    public String aAK;
    public String aAL;
    public String aAN;
    public String aAO;
    public String aAP;
    public String aAQ;
    public String aAR;
    public final List<a> aAS;
    private double aAa;
    private double aAb;
    private double aAc;
    private double aAd;
    private double aAe;
    private double aAf;
    private double aAg;
    private double aAh;
    private double aAi;
    private double aAj;
    private double aAk;
    private double aAl;
    private double aAm;
    private double aAn;
    private double aAo;
    private double aAp;
    private double aAq;
    private double aAr;
    private double aAs;
    public String aAt;
    public String aAu;
    public String aAv;
    public double aAw;
    public double aAx;
    public double aAy;
    public String aAz;
    public String azF;
    public String azG;
    public String azH;
    public String azI;
    public String azJ;
    public int azK;
    public int azL;
    public int azM;
    public String azN;
    public String azO;
    public String azP;
    private String azQ;
    private String azR;
    private String azS;
    private String azT;
    private String azU;
    private String azV;
    private double azW;
    private double azX;
    private double azY;
    private double azZ;
    public String azi;
    private CriusNode azq;
    private InterfaceC0053a businessConverter;
    public String color;
    public final float density;
    public int gravity;
    private double height;
    public final int heightPixels;
    public String id;
    public int maxLines;
    public String name;
    private String position;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;
    public final int widthPixels;
    private final CriusMeasureFunction azE = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
        @Override // com.baidu.crius.CriusMeasureFunction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            Layout layout;
            TextPaint textPaint = a.azs;
            if (a.this.aAC >= 0.0d) {
                textPaint.setTextSize((float) (a.this.aAC * a.this.density));
            }
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            boolean z = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                } else {
                    try {
                        Object invoke = a.azu.invoke(a.azt, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.azv.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.azw.invoke(invoke, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.azx.invoke(invoke, false);
                        Method method = a.azy;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.azB.get(Layout.class) : a.azC.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.azz.invoke(invoke, a.azD.get(Layout.class));
                        layout = (Layout) a.azA.invoke(invoke, new Object[0]);
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
                if (layout == null) {
                }
                if (layout == null) {
                }
            } else {
                if (isBoring != null && (z || isBoring.width <= f)) {
                    layout = BoringLayout.make(spannableString, textPaint, isBoring.width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, isBoring, false);
                } else if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, (int) f, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                } else {
                    try {
                        Object invoke2 = a.azu.invoke(a.azt, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                        a.azv.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                        a.azw.invoke(invoke2, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.azx.invoke(invoke2, false);
                        Method method2 = a.azy;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.azB.get(Layout.class) : a.azC.get(Layout.class);
                        method2.invoke(invoke2, objArr2);
                        a.azz.invoke(invoke2, a.azD.get(Layout.class));
                        layout = (Layout) a.azA.invoke(invoke2, new Object[0]);
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                        layout = null;
                    } catch (InvocationTargetException e4) {
                        e4.printStackTrace();
                        layout = null;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        layout = null;
                    }
                }
                if (layout == null && a.this.maxLines < layout.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.Z(layout.getWidth()), a.this.Y(layout.getLineBottom(a.this.maxLines - 1)));
                }
                if (layout == null) {
                    return CriusMeasureOutput.make(a.this.Z(layout.getWidth()), a.this.Y(layout.getHeight()));
                }
                return CriusMeasureOutput.make(f, f2);
            }
        }
    };
    public double aAM = -10000.0d;
    public final CriusNode azr = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0053a {
        String bW(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                azt = Class.forName("android.text.StaticLayout$Builder");
                azu = azt.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                azu.setAccessible(true);
                azv = azt.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                azv.setAccessible(true);
                azw = azt.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                azw.setAccessible(true);
                azx = azt.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                azx.setAccessible(true);
                azy = azt.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                azy.setAccessible(true);
                azz = azt.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                azz.setAccessible(true);
                azA = azt.getDeclaredMethod("build", new Class[0]);
                azA.setAccessible(true);
                azB = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                azB.setAccessible(true);
                azC = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                azC.setAccessible(true);
                azD = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                azD.setAccessible(true);
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

    public static boolean bS(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float Y(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.06f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float Z(float f) {
        if (Build.VERSION.SDK_INT == 19 && this.maxLines == 1 && bS(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void b(JSONObject jSONObject) {
        this.id = b.c(jSONObject, "id");
        this.name = b.c(jSONObject, "name");
        this.type = b.c(jSONObject, "type");
        if (uc()) {
            this.azr.setMeasureFunction(this.azE);
        }
        this.azF = b.c(jSONObject, "component");
        this.src = b.c(jSONObject, "src");
        this.azi = b.c(jSONObject, "poster");
        this.azG = b.c(jSONObject, "href");
        this.text = b.c(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.azF) && this.businessConverter != null) {
            this.text = this.businessConverter.bW(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.azH = jSONObject.optString("data-als-stat");
        this.azI = jSONObject.optString("data-url-stat");
        this.azJ = jSONObject.optString("data-href-pop");
        this.azK = b.e(jSONObject, "data-share-num");
        this.azL = b.e(jSONObject, "data-reply-num");
        this.azM = b.e(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.azN = jSONObject.optString("data-share-content");
        this.azO = jSONObject.optString("data-share-image");
        this.azP = jSONObject.optString("data-share-link");
    }

    private void c(JSONObject jSONObject) {
        this.azQ = b.c(jSONObject, "display");
        tU();
        this.azR = b.c(jSONObject, "flex-direction");
        ub();
        this.azS = b.c(jSONObject, "justify-content");
        ua();
        this.azT = b.c(jSONObject, "align-items");
        tZ();
        this.azU = b.c(jSONObject, "align-self");
        tY();
        this.azV = b.c(jSONObject, "align-content");
        tX();
        this.azW = b.d(jSONObject, "flex");
        tT();
        this.azX = b.d(jSONObject, "flex-grow");
        tS();
        this.azY = b.d(jSONObject, "flex-shrink");
        tR();
        this.azZ = b.d(jSONObject, "flex-basis");
        tQ();
        this.position = b.c(jSONObject, "position");
        tW();
        this.aAa = b.d(jSONObject, CustomDialogData.POS_LEFT);
        this.aAb = b.d(jSONObject, "top");
        this.aAc = b.d(jSONObject, "right");
        this.aAd = b.d(jSONObject, "bottom");
        tV();
        this.aAe = b.d(jSONObject, "margin");
        tP();
        this.aAf = b.d(jSONObject, "margin-left");
        tL();
        this.aAg = b.d(jSONObject, "margin-top");
        tO();
        this.aAh = b.d(jSONObject, "margin-right");
        tN();
        this.aAi = b.d(jSONObject, "margin-bottom");
        tM();
        this.aAj = b.d(jSONObject, "padding");
        initPadding();
        this.aAk = b.d(jSONObject, "padding-left");
        tH();
        this.aAl = b.d(jSONObject, "padding-top");
        tK();
        this.aAm = b.d(jSONObject, "padding-right");
        tJ();
        this.aAn = b.d(jSONObject, "padding-bottom");
        tI();
        this.width = b.d(jSONObject, "width");
        tG();
        this.height = b.d(jSONObject, "height");
        tF();
        this.aAo = b.d(jSONObject, "min-width");
        tE();
        this.aAp = b.d(jSONObject, "min-height");
        tD();
        this.aAq = b.d(jSONObject, "max-width");
        tA();
        this.aAr = b.d(jSONObject, "max-height");
        tC();
        this.aAs = b.d(jSONObject, "aspect-ratio");
        tB();
    }

    private void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aAO = b.c(optJSONObject, "background-image");
            this.aAP = b.c(optJSONObject, "background-color");
            this.aAQ = b.c(optJSONObject, "border-color");
            this.aAR = b.c(optJSONObject, "color");
        }
    }

    private void e(JSONObject jSONObject) {
        this.aAJ = b.c(jSONObject, "background-image");
        this.aAK = b.c(jSONObject, "background-color");
        this.aAL = b.c(jSONObject, "border-color");
        this.aAM = b.d(jSONObject, "opacity");
        this.aAN = b.c(jSONObject, "color");
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aAF = b.c(optJSONObject, "background-image");
            this.aAG = b.c(optJSONObject, "background-color");
            this.aAH = b.c(optJSONObject, "border-color");
            this.aAI = b.c(optJSONObject, "color");
        }
    }

    private void g(JSONObject jSONObject) {
        this.aAt = b.c(jSONObject, "background-image");
        this.aAu = b.c(jSONObject, "background-color");
        this.aAv = b.c(jSONObject, "border-color");
        this.aAy = b.d(jSONObject, "opacity");
        this.color = b.c(jSONObject, "color");
        this.aAw = b.d(jSONObject, "border-width");
        this.aAx = b.d(jSONObject, "border-radius");
        this.aAz = b.c(jSONObject, "font-style");
        this.aAA = b.c(jSONObject, "font-weight");
        this.aAB = Typeface.create(Typeface.DEFAULT, ty());
        this.aAC = jSONObject.optDouble("font-size", 12.0d);
        this.aAD = b.c(jSONObject, "text-align");
        this.aAE = b.c(jSONObject, "vertical-align");
        this.gravity = tz();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0053a interfaceC0053a, boolean z) {
        this.businessConverter = interfaceC0053a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        this.heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        b(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            c(optJSONObject);
            g(optJSONObject);
            f(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            e(optJSONObject2);
            d(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aAS = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0053a, false);
                    this.aAS.add(aVar);
                    this.azr.addChildAt(aVar.azr, i);
                }
            } else {
                this.aAS = null;
            }
        } else {
            this.aAS = null;
        }
        if (z) {
            this.azq = new CriusNode();
            this.azq.addChildAt(this.azr, 0);
            this.azq.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int ty() {
        return "italic".equalsIgnoreCase(this.aAz) ? (TextUtils.isEmpty(this.aAA) || "normal".equalsIgnoreCase(this.aAA) || !"bold".equalsIgnoreCase(this.aAA)) ? 2 : 3 : (TextUtils.isEmpty(this.aAA) || "normal".equalsIgnoreCase(this.aAA) || !"bold".equalsIgnoreCase(this.aAA)) ? 0 : 1;
    }

    private int tz() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.aAD)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.aAD)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.aAD)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.aAE)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.aAE)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aAE)) {
            return i | 16;
        }
        return i | 0;
    }

    private void tA() {
        if (this.aAq >= 0.0d) {
            this.azr.setMaxWidth(e(this.aAq));
        } else if (this.aAq > -10000.0d) {
            this.azr.setMaxWidth(this.widthPixels);
        }
    }

    private void tB() {
        if (this.aAs > 0.0d) {
            this.azr.setAspectRatio((float) this.aAs);
        }
    }

    private void tC() {
        if (this.aAr >= 0.0d) {
            this.azr.setMaxHeight(e(this.aAr));
        } else if (this.aAr > -10000.0d) {
            this.azr.setMaxHeight(this.heightPixels);
        }
    }

    private void tD() {
        if (this.aAp >= 0.0d) {
            this.azr.setMinHeight(e(this.aAp));
        } else if (this.aAp > -10000.0d) {
            this.azr.setMinHeight(this.heightPixels);
        }
    }

    private void tE() {
        if (this.aAo >= 0.0d) {
            this.azr.setMinWidth(e(this.aAo));
        } else if (this.aAo > -10000.0d) {
            this.azr.setMinWidth(this.widthPixels);
        }
    }

    private void tF() {
        if (this.height >= 0.0d) {
            this.azr.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.azr.setHeight(this.heightPixels);
        }
    }

    private void tG() {
        if (this.width >= 0.0d) {
            this.azr.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.azr.setWidth(this.widthPixels);
        }
    }

    private void tH() {
        if (this.aAk >= -1.0d) {
            this.azr.setPadding(CriusEdge.LEFT, e(this.aAk));
        }
    }

    private void tI() {
        if (this.aAn >= -1.0d) {
            this.azr.setPadding(CriusEdge.BOTTOM, e(this.aAn));
        }
    }

    private void tJ() {
        if (this.aAm >= -1.0d) {
            this.azr.setPadding(CriusEdge.RIGHT, e(this.aAm));
        }
    }

    private void tK() {
        if (this.aAl >= -1.0d) {
            this.azr.setPadding(CriusEdge.TOP, e(this.aAl));
        }
    }

    private void initPadding() {
        if (this.aAj >= -1.0d) {
            this.azr.setPadding(CriusEdge.ALL, e(this.aAj));
        }
    }

    private void tL() {
        if (this.aAf >= -1.0d) {
            this.azr.setMargin(CriusEdge.LEFT, e(this.aAf));
        }
    }

    private void tM() {
        if (this.aAi >= -1.0d) {
            this.azr.setMargin(CriusEdge.BOTTOM, e(this.aAi));
        }
    }

    private void tN() {
        if (this.aAh >= -1.0d) {
            this.azr.setMargin(CriusEdge.RIGHT, e(this.aAh));
        }
    }

    private void tO() {
        if (this.aAg >= -1.0d) {
            this.azr.setMargin(CriusEdge.TOP, e(this.aAg));
        }
    }

    private void tP() {
        if (this.aAe >= -1.0d) {
            this.azr.setMargin(CriusEdge.ALL, e(this.aAe));
        }
    }

    private void tQ() {
        if (this.azZ >= -1.0d) {
            this.azr.setFlexBasis(e(this.azZ));
        }
    }

    private void tR() {
        if (this.azY >= -1.0d) {
            this.azr.setFlexShrink((float) this.azY);
        }
    }

    private void tS() {
        if (this.azX >= -1.0d) {
            this.azr.setFlexGrow((float) this.azX);
        }
    }

    private void tT() {
        if (this.azW >= -1.0d) {
            this.azr.setFlex((float) this.azW);
        }
    }

    private void tU() {
        if (!TextUtils.isEmpty(this.azQ)) {
            if ("flex".equalsIgnoreCase(this.azQ)) {
                this.azr.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.azQ)) {
                this.azr.setDisplay(CriusDisplay.NONE);
            } else {
                this.azr.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void tV() {
        if (!b.b(this.aAa, -10000.0d)) {
            this.azr.setPosition(CriusEdge.LEFT, e(this.aAa));
        }
        if (!b.b(this.aAb, -10000.0d)) {
            this.azr.setPosition(CriusEdge.TOP, e(this.aAb));
        }
        if (!b.b(this.aAc, -10000.0d)) {
            this.azr.setPosition(CriusEdge.RIGHT, e(this.aAc));
        }
        if (!b.b(this.aAd, -10000.0d)) {
            this.azr.setPosition(CriusEdge.BOTTOM, e(this.aAd));
        }
    }

    private void tW() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.azr.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.azr.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void tX() {
        if (!TextUtils.isEmpty(this.azV)) {
            if ("flex-start".equalsIgnoreCase(this.azV)) {
                this.azr.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.azV)) {
                this.azr.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.azV)) {
                this.azr.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.azV)) {
                this.azr.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.azV)) {
                this.azr.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.azV)) {
                this.azr.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.azr.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void tY() {
        if (!TextUtils.isEmpty(this.azU)) {
            if ("auto".equalsIgnoreCase(this.azU)) {
                this.azr.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.azU)) {
                this.azr.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.azU)) {
                this.azr.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.azU)) {
                this.azr.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.azU)) {
                this.azr.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.azr.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void tZ() {
        if (!TextUtils.isEmpty(this.azT)) {
            if ("flex-start".equalsIgnoreCase(this.azT)) {
                this.azr.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.azT)) {
                this.azr.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.azT)) {
                this.azr.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.azT)) {
                this.azr.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.azr.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void ua() {
        if (!TextUtils.isEmpty(this.azS)) {
            if ("flex-start".equalsIgnoreCase(this.azS)) {
                this.azr.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.azS)) {
                this.azr.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.azS)) {
                this.azr.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.azS)) {
                this.azr.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.azS)) {
                this.azr.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.azr.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void ub() {
        if (!TextUtils.isEmpty(this.azR)) {
            if ("column".equalsIgnoreCase(this.azR)) {
                this.azr.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.azR)) {
                this.azr.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.azR)) {
                this.azr.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.azR)) {
                this.azr.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.azr.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean uc() {
        return "text".equals(this.type);
    }

    public a bT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.aAS != null && this.aAS.size() > 0) {
                for (a aVar : this.aAS) {
                    a bT = aVar.bT(str);
                    if (bT != null) {
                        return bT;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a bU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.azF)) {
            if (this.aAS != null && this.aAS.size() > 0) {
                for (a aVar : this.aAS) {
                    a bU = aVar.bU(str);
                    if (bU != null) {
                        return bU;
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

    public float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean bV(String str) {
        a bU;
        if (this.azq == null || (bU = bU(str)) == null || bU.azr == null) {
            return false;
        }
        bU.azr.setDisplay(CriusDisplay.NONE);
        bU.azr.dirty();
        this.azq.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a bT;
        if (this.azq != null && (bT = bT(str)) != null && bT.azr != null) {
            bT.aAC = f;
            bT.azr.dirty();
            this.azq.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
