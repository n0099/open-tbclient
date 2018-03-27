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
    private static Method azB;
    private static Field azC;
    private static Field azD;
    private static Field azE;
    private static final TextPaint azt = new TextPaint(1);
    private static Class azu;
    private static Method azv;
    private static Method azw;
    private static Method azx;
    private static Method azy;
    private static Method azz;
    public String aAA;
    public String aAB;
    public Typeface aAC;
    public double aAD;
    public String aAE;
    public String aAF;
    public String aAG;
    public String aAH;
    public String aAI;
    public String aAJ;
    public String aAK;
    public String aAL;
    public String aAM;
    public String aAO;
    public String aAP;
    public String aAQ;
    public String aAR;
    public String aAS;
    public final List<a> aAT;
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
    private double aAt;
    public String aAu;
    public String aAv;
    public String aAw;
    public double aAx;
    public double aAy;
    public double aAz;
    public String azG;
    public String azH;
    public String azI;
    public String azJ;
    public String azK;
    public int azL;
    public int azM;
    public int azN;
    public String azO;
    public String azP;
    public String azQ;
    private String azR;
    private String azS;
    private String azT;
    private String azU;
    private String azV;
    private String azW;
    private double azX;
    private double azY;
    private double azZ;
    public String azj;
    private CriusNode azr;
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
    private final CriusMeasureFunction azF = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
        @Override // com.baidu.crius.CriusMeasureFunction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            Layout layout;
            TextPaint textPaint = a.azt;
            if (a.this.aAD >= 0.0d) {
                textPaint.setTextSize((float) (a.this.aAD * a.this.density));
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
                        Object invoke = a.azv.invoke(a.azu, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.azw.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.azx.invoke(invoke, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.azy.invoke(invoke, false);
                        Method method = a.azz;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.azC.get(Layout.class) : a.azD.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.azA.invoke(invoke, a.azE.get(Layout.class));
                        layout = (Layout) a.azB.invoke(invoke, new Object[0]);
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
                        Object invoke2 = a.azv.invoke(a.azu, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                        a.azw.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                        a.azx.invoke(invoke2, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.azy.invoke(invoke2, false);
                        Method method2 = a.azz;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.azC.get(Layout.class) : a.azD.get(Layout.class);
                        method2.invoke(invoke2, objArr2);
                        a.azA.invoke(invoke2, a.azE.get(Layout.class));
                        layout = (Layout) a.azB.invoke(invoke2, new Object[0]);
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
    public double aAN = -10000.0d;
    public final CriusNode azs = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0053a {
        String bW(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                azu = Class.forName("android.text.StaticLayout$Builder");
                azv = azu.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                azv.setAccessible(true);
                azw = azu.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                azw.setAccessible(true);
                azx = azu.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                azx.setAccessible(true);
                azy = azu.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                azy.setAccessible(true);
                azz = azu.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                azz.setAccessible(true);
                azA = azu.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                azA.setAccessible(true);
                azB = azu.getDeclaredMethod("build", new Class[0]);
                azB.setAccessible(true);
                azC = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                azC.setAccessible(true);
                azD = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                azD.setAccessible(true);
                azE = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                azE.setAccessible(true);
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
            this.azs.setMeasureFunction(this.azF);
        }
        this.azG = b.c(jSONObject, "component");
        this.src = b.c(jSONObject, "src");
        this.azj = b.c(jSONObject, "poster");
        this.azH = b.c(jSONObject, "href");
        this.text = b.c(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.azG) && this.businessConverter != null) {
            this.text = this.businessConverter.bW(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.azI = jSONObject.optString("data-als-stat");
        this.azJ = jSONObject.optString("data-url-stat");
        this.azK = jSONObject.optString("data-href-pop");
        this.azL = b.e(jSONObject, "data-share-num");
        this.azM = b.e(jSONObject, "data-reply-num");
        this.azN = b.e(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.azO = jSONObject.optString("data-share-content");
        this.azP = jSONObject.optString("data-share-image");
        this.azQ = jSONObject.optString("data-share-link");
    }

    private void c(JSONObject jSONObject) {
        this.azR = b.c(jSONObject, "display");
        tU();
        this.azS = b.c(jSONObject, "flex-direction");
        ub();
        this.azT = b.c(jSONObject, "justify-content");
        ua();
        this.azU = b.c(jSONObject, "align-items");
        tZ();
        this.azV = b.c(jSONObject, "align-self");
        tY();
        this.azW = b.c(jSONObject, "align-content");
        tX();
        this.azX = b.d(jSONObject, "flex");
        tT();
        this.azY = b.d(jSONObject, "flex-grow");
        tS();
        this.azZ = b.d(jSONObject, "flex-shrink");
        tR();
        this.aAa = b.d(jSONObject, "flex-basis");
        tQ();
        this.position = b.c(jSONObject, "position");
        tW();
        this.aAb = b.d(jSONObject, CustomDialogData.POS_LEFT);
        this.aAc = b.d(jSONObject, "top");
        this.aAd = b.d(jSONObject, "right");
        this.aAe = b.d(jSONObject, "bottom");
        tV();
        this.aAf = b.d(jSONObject, "margin");
        tP();
        this.aAg = b.d(jSONObject, "margin-left");
        tL();
        this.aAh = b.d(jSONObject, "margin-top");
        tO();
        this.aAi = b.d(jSONObject, "margin-right");
        tN();
        this.aAj = b.d(jSONObject, "margin-bottom");
        tM();
        this.aAk = b.d(jSONObject, "padding");
        initPadding();
        this.aAl = b.d(jSONObject, "padding-left");
        tH();
        this.aAm = b.d(jSONObject, "padding-top");
        tK();
        this.aAn = b.d(jSONObject, "padding-right");
        tJ();
        this.aAo = b.d(jSONObject, "padding-bottom");
        tI();
        this.width = b.d(jSONObject, "width");
        tG();
        this.height = b.d(jSONObject, "height");
        tF();
        this.aAp = b.d(jSONObject, "min-width");
        tE();
        this.aAq = b.d(jSONObject, "min-height");
        tD();
        this.aAr = b.d(jSONObject, "max-width");
        tA();
        this.aAs = b.d(jSONObject, "max-height");
        tC();
        this.aAt = b.d(jSONObject, "aspect-ratio");
        tB();
    }

    private void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aAP = b.c(optJSONObject, "background-image");
            this.aAQ = b.c(optJSONObject, "background-color");
            this.aAR = b.c(optJSONObject, "border-color");
            this.aAS = b.c(optJSONObject, "color");
        }
    }

    private void e(JSONObject jSONObject) {
        this.aAK = b.c(jSONObject, "background-image");
        this.aAL = b.c(jSONObject, "background-color");
        this.aAM = b.c(jSONObject, "border-color");
        this.aAN = b.d(jSONObject, "opacity");
        this.aAO = b.c(jSONObject, "color");
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aAG = b.c(optJSONObject, "background-image");
            this.aAH = b.c(optJSONObject, "background-color");
            this.aAI = b.c(optJSONObject, "border-color");
            this.aAJ = b.c(optJSONObject, "color");
        }
    }

    private void g(JSONObject jSONObject) {
        this.aAu = b.c(jSONObject, "background-image");
        this.aAv = b.c(jSONObject, "background-color");
        this.aAw = b.c(jSONObject, "border-color");
        this.aAz = b.d(jSONObject, "opacity");
        this.color = b.c(jSONObject, "color");
        this.aAx = b.d(jSONObject, "border-width");
        this.aAy = b.d(jSONObject, "border-radius");
        this.aAA = b.c(jSONObject, "font-style");
        this.aAB = b.c(jSONObject, "font-weight");
        this.aAC = Typeface.create(Typeface.DEFAULT, ty());
        this.aAD = jSONObject.optDouble("font-size", 12.0d);
        this.aAE = b.c(jSONObject, "text-align");
        this.aAF = b.c(jSONObject, "vertical-align");
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
                this.aAT = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0053a, false);
                    this.aAT.add(aVar);
                    this.azs.addChildAt(aVar.azs, i);
                }
            } else {
                this.aAT = null;
            }
        } else {
            this.aAT = null;
        }
        if (z) {
            this.azr = new CriusNode();
            this.azr.addChildAt(this.azs, 0);
            this.azr.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int ty() {
        return "italic".equalsIgnoreCase(this.aAA) ? (TextUtils.isEmpty(this.aAB) || "normal".equalsIgnoreCase(this.aAB) || !"bold".equalsIgnoreCase(this.aAB)) ? 2 : 3 : (TextUtils.isEmpty(this.aAB) || "normal".equalsIgnoreCase(this.aAB) || !"bold".equalsIgnoreCase(this.aAB)) ? 0 : 1;
    }

    private int tz() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.aAE)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.aAE)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.aAE)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.aAF)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.aAF)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aAF)) {
            return i | 16;
        }
        return i | 0;
    }

    private void tA() {
        if (this.aAr >= 0.0d) {
            this.azs.setMaxWidth(e(this.aAr));
        } else if (this.aAr > -10000.0d) {
            this.azs.setMaxWidth(this.widthPixels);
        }
    }

    private void tB() {
        if (this.aAt > 0.0d) {
            this.azs.setAspectRatio((float) this.aAt);
        }
    }

    private void tC() {
        if (this.aAs >= 0.0d) {
            this.azs.setMaxHeight(e(this.aAs));
        } else if (this.aAs > -10000.0d) {
            this.azs.setMaxHeight(this.heightPixels);
        }
    }

    private void tD() {
        if (this.aAq >= 0.0d) {
            this.azs.setMinHeight(e(this.aAq));
        } else if (this.aAq > -10000.0d) {
            this.azs.setMinHeight(this.heightPixels);
        }
    }

    private void tE() {
        if (this.aAp >= 0.0d) {
            this.azs.setMinWidth(e(this.aAp));
        } else if (this.aAp > -10000.0d) {
            this.azs.setMinWidth(this.widthPixels);
        }
    }

    private void tF() {
        if (this.height >= 0.0d) {
            this.azs.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.azs.setHeight(this.heightPixels);
        }
    }

    private void tG() {
        if (this.width >= 0.0d) {
            this.azs.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.azs.setWidth(this.widthPixels);
        }
    }

    private void tH() {
        if (this.aAl >= -1.0d) {
            this.azs.setPadding(CriusEdge.LEFT, e(this.aAl));
        }
    }

    private void tI() {
        if (this.aAo >= -1.0d) {
            this.azs.setPadding(CriusEdge.BOTTOM, e(this.aAo));
        }
    }

    private void tJ() {
        if (this.aAn >= -1.0d) {
            this.azs.setPadding(CriusEdge.RIGHT, e(this.aAn));
        }
    }

    private void tK() {
        if (this.aAm >= -1.0d) {
            this.azs.setPadding(CriusEdge.TOP, e(this.aAm));
        }
    }

    private void initPadding() {
        if (this.aAk >= -1.0d) {
            this.azs.setPadding(CriusEdge.ALL, e(this.aAk));
        }
    }

    private void tL() {
        if (this.aAg >= -1.0d) {
            this.azs.setMargin(CriusEdge.LEFT, e(this.aAg));
        }
    }

    private void tM() {
        if (this.aAj >= -1.0d) {
            this.azs.setMargin(CriusEdge.BOTTOM, e(this.aAj));
        }
    }

    private void tN() {
        if (this.aAi >= -1.0d) {
            this.azs.setMargin(CriusEdge.RIGHT, e(this.aAi));
        }
    }

    private void tO() {
        if (this.aAh >= -1.0d) {
            this.azs.setMargin(CriusEdge.TOP, e(this.aAh));
        }
    }

    private void tP() {
        if (this.aAf >= -1.0d) {
            this.azs.setMargin(CriusEdge.ALL, e(this.aAf));
        }
    }

    private void tQ() {
        if (this.aAa >= -1.0d) {
            this.azs.setFlexBasis(e(this.aAa));
        }
    }

    private void tR() {
        if (this.azZ >= -1.0d) {
            this.azs.setFlexShrink((float) this.azZ);
        }
    }

    private void tS() {
        if (this.azY >= -1.0d) {
            this.azs.setFlexGrow((float) this.azY);
        }
    }

    private void tT() {
        if (this.azX >= -1.0d) {
            this.azs.setFlex((float) this.azX);
        }
    }

    private void tU() {
        if (!TextUtils.isEmpty(this.azR)) {
            if ("flex".equalsIgnoreCase(this.azR)) {
                this.azs.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.azR)) {
                this.azs.setDisplay(CriusDisplay.NONE);
            } else {
                this.azs.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void tV() {
        if (!b.b(this.aAb, -10000.0d)) {
            this.azs.setPosition(CriusEdge.LEFT, e(this.aAb));
        }
        if (!b.b(this.aAc, -10000.0d)) {
            this.azs.setPosition(CriusEdge.TOP, e(this.aAc));
        }
        if (!b.b(this.aAd, -10000.0d)) {
            this.azs.setPosition(CriusEdge.RIGHT, e(this.aAd));
        }
        if (!b.b(this.aAe, -10000.0d)) {
            this.azs.setPosition(CriusEdge.BOTTOM, e(this.aAe));
        }
    }

    private void tW() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.azs.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.azs.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void tX() {
        if (!TextUtils.isEmpty(this.azW)) {
            if ("flex-start".equalsIgnoreCase(this.azW)) {
                this.azs.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.azW)) {
                this.azs.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.azW)) {
                this.azs.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.azW)) {
                this.azs.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.azW)) {
                this.azs.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.azW)) {
                this.azs.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.azs.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void tY() {
        if (!TextUtils.isEmpty(this.azV)) {
            if ("auto".equalsIgnoreCase(this.azV)) {
                this.azs.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.azV)) {
                this.azs.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.azV)) {
                this.azs.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.azV)) {
                this.azs.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.azV)) {
                this.azs.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.azs.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void tZ() {
        if (!TextUtils.isEmpty(this.azU)) {
            if ("flex-start".equalsIgnoreCase(this.azU)) {
                this.azs.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.azU)) {
                this.azs.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.azU)) {
                this.azs.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.azU)) {
                this.azs.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.azs.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void ua() {
        if (!TextUtils.isEmpty(this.azT)) {
            if ("flex-start".equalsIgnoreCase(this.azT)) {
                this.azs.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.azT)) {
                this.azs.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.azT)) {
                this.azs.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.azT)) {
                this.azs.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.azT)) {
                this.azs.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.azs.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void ub() {
        if (!TextUtils.isEmpty(this.azS)) {
            if ("column".equalsIgnoreCase(this.azS)) {
                this.azs.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.azS)) {
                this.azs.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.azS)) {
                this.azs.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.azS)) {
                this.azs.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.azs.setFlexDirection(CriusFlexDirection.COLUMN);
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
            if (this.aAT != null && this.aAT.size() > 0) {
                for (a aVar : this.aAT) {
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
        if (!str.equalsIgnoreCase(this.azG)) {
            if (this.aAT != null && this.aAT.size() > 0) {
                for (a aVar : this.aAT) {
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
        if (this.azr == null || (bU = bU(str)) == null || bU.azs == null) {
            return false;
        }
        bU.azs.setDisplay(CriusDisplay.NONE);
        bU.azs.dirty();
        this.azr.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a bT;
        if (this.azr != null && (bT = bT(str)) != null && bT.azs != null) {
            bT.aAD = f;
            bT.azs.dirty();
            this.azr.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
