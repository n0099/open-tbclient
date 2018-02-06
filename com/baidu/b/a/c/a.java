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
    private static final TextPaint azB = new TextPaint(1);
    private static Class azC;
    private static Method azD;
    private static Method azE;
    private static Method azF;
    private static Method azG;
    private static Method azH;
    private static Method azI;
    private static Method azJ;
    private static Field azK;
    private static Field azL;
    private static Field azM;
    private double aAA;
    private double aAB;
    public String aAC;
    public String aAD;
    public String aAE;
    public double aAF;
    public double aAG;
    public double aAH;
    public String aAI;
    public String aAJ;
    public Typeface aAK;
    public double aAL;
    public String aAM;
    public String aAN;
    public String aAO;
    public String aAP;
    public String aAQ;
    public String aAR;
    public String aAS;
    public String aAT;
    public String aAU;
    public String aAW;
    public String aAX;
    public String aAY;
    public String aAZ;
    private String aAa;
    private String aAb;
    private String aAc;
    private String aAd;
    private String aAe;
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
    private double aAu;
    private double aAv;
    private double aAw;
    private double aAx;
    private double aAy;
    private double aAz;
    public String aBa;
    public final List<a> aBb;
    public String azO;
    public String azP;
    public String azQ;
    public String azR;
    public String azS;
    public int azT;
    public int azU;
    public int azV;
    public String azW;
    public String azX;
    public String azY;
    private String azZ;
    public String azr;
    private CriusNode azz;
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
    private final CriusMeasureFunction azN = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
        @Override // com.baidu.crius.CriusMeasureFunction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            Layout layout;
            TextPaint textPaint = a.azB;
            if (a.this.aAL >= 0.0d) {
                textPaint.setTextSize((float) (a.this.aAL * a.this.density));
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
                        Object invoke = a.azD.invoke(a.azC, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.azE.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.azF.invoke(invoke, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.azG.invoke(invoke, false);
                        Method method = a.azH;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.azK.get(Layout.class) : a.azL.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.azI.invoke(invoke, a.azM.get(Layout.class));
                        layout = (Layout) a.azJ.invoke(invoke, new Object[0]);
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
                        Object invoke2 = a.azD.invoke(a.azC, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                        a.azE.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                        a.azF.invoke(invoke2, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.azG.invoke(invoke2, false);
                        Method method2 = a.azH;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.azK.get(Layout.class) : a.azL.get(Layout.class);
                        method2.invoke(invoke2, objArr2);
                        a.azI.invoke(invoke2, a.azM.get(Layout.class));
                        layout = (Layout) a.azJ.invoke(invoke2, new Object[0]);
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
    public double aAV = -10000.0d;
    public final CriusNode azA = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0053a {
        String bW(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                azC = Class.forName("android.text.StaticLayout$Builder");
                azD = azC.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                azD.setAccessible(true);
                azE = azC.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                azE.setAccessible(true);
                azF = azC.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                azF.setAccessible(true);
                azG = azC.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                azG.setAccessible(true);
                azH = azC.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                azH.setAccessible(true);
                azI = azC.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                azI.setAccessible(true);
                azJ = azC.getDeclaredMethod("build", new Class[0]);
                azJ.setAccessible(true);
                azK = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                azK.setAccessible(true);
                azL = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                azL.setAccessible(true);
                azM = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                azM.setAccessible(true);
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
            this.azA.setMeasureFunction(this.azN);
        }
        this.azO = b.c(jSONObject, "component");
        this.src = b.c(jSONObject, "src");
        this.azr = b.c(jSONObject, "poster");
        this.azP = b.c(jSONObject, "href");
        this.text = b.c(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.azO) && this.businessConverter != null) {
            this.text = this.businessConverter.bW(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.azQ = jSONObject.optString("data-als-stat");
        this.azR = jSONObject.optString("data-url-stat");
        this.azS = jSONObject.optString("data-href-pop");
        this.azT = b.e(jSONObject, "data-share-num");
        this.azU = b.e(jSONObject, "data-reply-num");
        this.azV = b.e(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.azW = jSONObject.optString("data-share-content");
        this.azX = jSONObject.optString("data-share-image");
        this.azY = jSONObject.optString("data-share-link");
    }

    private void c(JSONObject jSONObject) {
        this.azZ = b.c(jSONObject, "display");
        tU();
        this.aAa = b.c(jSONObject, "flex-direction");
        ub();
        this.aAb = b.c(jSONObject, "justify-content");
        ua();
        this.aAc = b.c(jSONObject, "align-items");
        tZ();
        this.aAd = b.c(jSONObject, "align-self");
        tY();
        this.aAe = b.c(jSONObject, "align-content");
        tX();
        this.aAf = b.d(jSONObject, "flex");
        tT();
        this.aAg = b.d(jSONObject, "flex-grow");
        tS();
        this.aAh = b.d(jSONObject, "flex-shrink");
        tR();
        this.aAi = b.d(jSONObject, "flex-basis");
        tQ();
        this.position = b.c(jSONObject, "position");
        tW();
        this.aAj = b.d(jSONObject, CustomDialogData.POS_LEFT);
        this.aAk = b.d(jSONObject, "top");
        this.aAl = b.d(jSONObject, "right");
        this.aAm = b.d(jSONObject, "bottom");
        tV();
        this.aAn = b.d(jSONObject, "margin");
        tP();
        this.aAo = b.d(jSONObject, "margin-left");
        tL();
        this.aAp = b.d(jSONObject, "margin-top");
        tO();
        this.aAq = b.d(jSONObject, "margin-right");
        tN();
        this.aAr = b.d(jSONObject, "margin-bottom");
        tM();
        this.aAs = b.d(jSONObject, "padding");
        initPadding();
        this.aAt = b.d(jSONObject, "padding-left");
        tH();
        this.aAu = b.d(jSONObject, "padding-top");
        tK();
        this.aAv = b.d(jSONObject, "padding-right");
        tJ();
        this.aAw = b.d(jSONObject, "padding-bottom");
        tI();
        this.width = b.d(jSONObject, "width");
        tG();
        this.height = b.d(jSONObject, "height");
        tF();
        this.aAx = b.d(jSONObject, "min-width");
        tE();
        this.aAy = b.d(jSONObject, "min-height");
        tD();
        this.aAz = b.d(jSONObject, "max-width");
        tA();
        this.aAA = b.d(jSONObject, "max-height");
        tC();
        this.aAB = b.d(jSONObject, "aspect-ratio");
        tB();
    }

    private void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aAX = b.c(optJSONObject, "background-image");
            this.aAY = b.c(optJSONObject, "background-color");
            this.aAZ = b.c(optJSONObject, "border-color");
            this.aBa = b.c(optJSONObject, "color");
        }
    }

    private void e(JSONObject jSONObject) {
        this.aAS = b.c(jSONObject, "background-image");
        this.aAT = b.c(jSONObject, "background-color");
        this.aAU = b.c(jSONObject, "border-color");
        this.aAV = b.d(jSONObject, "opacity");
        this.aAW = b.c(jSONObject, "color");
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.aAO = b.c(optJSONObject, "background-image");
            this.aAP = b.c(optJSONObject, "background-color");
            this.aAQ = b.c(optJSONObject, "border-color");
            this.aAR = b.c(optJSONObject, "color");
        }
    }

    private void g(JSONObject jSONObject) {
        this.aAC = b.c(jSONObject, "background-image");
        this.aAD = b.c(jSONObject, "background-color");
        this.aAE = b.c(jSONObject, "border-color");
        this.aAH = b.d(jSONObject, "opacity");
        this.color = b.c(jSONObject, "color");
        this.aAF = b.d(jSONObject, "border-width");
        this.aAG = b.d(jSONObject, "border-radius");
        this.aAI = b.c(jSONObject, "font-style");
        this.aAJ = b.c(jSONObject, "font-weight");
        this.aAK = Typeface.create(Typeface.DEFAULT, ty());
        this.aAL = jSONObject.optDouble("font-size", 12.0d);
        this.aAM = b.c(jSONObject, "text-align");
        this.aAN = b.c(jSONObject, "vertical-align");
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
                this.aBb = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0053a, false);
                    this.aBb.add(aVar);
                    this.azA.addChildAt(aVar.azA, i);
                }
            } else {
                this.aBb = null;
            }
        } else {
            this.aBb = null;
        }
        if (z) {
            this.azz = new CriusNode();
            this.azz.addChildAt(this.azA, 0);
            this.azz.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int ty() {
        return "italic".equalsIgnoreCase(this.aAI) ? (TextUtils.isEmpty(this.aAJ) || "normal".equalsIgnoreCase(this.aAJ) || !"bold".equalsIgnoreCase(this.aAJ)) ? 2 : 3 : (TextUtils.isEmpty(this.aAJ) || "normal".equalsIgnoreCase(this.aAJ) || !"bold".equalsIgnoreCase(this.aAJ)) ? 0 : 1;
    }

    private int tz() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.aAM)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.aAM)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.aAM)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.aAN)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.aAN)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aAN)) {
            return i | 16;
        }
        return i | 0;
    }

    private void tA() {
        if (this.aAz >= 0.0d) {
            this.azA.setMaxWidth(e(this.aAz));
        } else if (this.aAz > -10000.0d) {
            this.azA.setMaxWidth(this.widthPixels);
        }
    }

    private void tB() {
        if (this.aAB > 0.0d) {
            this.azA.setAspectRatio((float) this.aAB);
        }
    }

    private void tC() {
        if (this.aAA >= 0.0d) {
            this.azA.setMaxHeight(e(this.aAA));
        } else if (this.aAA > -10000.0d) {
            this.azA.setMaxHeight(this.heightPixels);
        }
    }

    private void tD() {
        if (this.aAy >= 0.0d) {
            this.azA.setMinHeight(e(this.aAy));
        } else if (this.aAy > -10000.0d) {
            this.azA.setMinHeight(this.heightPixels);
        }
    }

    private void tE() {
        if (this.aAx >= 0.0d) {
            this.azA.setMinWidth(e(this.aAx));
        } else if (this.aAx > -10000.0d) {
            this.azA.setMinWidth(this.widthPixels);
        }
    }

    private void tF() {
        if (this.height >= 0.0d) {
            this.azA.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.azA.setHeight(this.heightPixels);
        }
    }

    private void tG() {
        if (this.width >= 0.0d) {
            this.azA.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.azA.setWidth(this.widthPixels);
        }
    }

    private void tH() {
        if (this.aAt >= -1.0d) {
            this.azA.setPadding(CriusEdge.LEFT, e(this.aAt));
        }
    }

    private void tI() {
        if (this.aAw >= -1.0d) {
            this.azA.setPadding(CriusEdge.BOTTOM, e(this.aAw));
        }
    }

    private void tJ() {
        if (this.aAv >= -1.0d) {
            this.azA.setPadding(CriusEdge.RIGHT, e(this.aAv));
        }
    }

    private void tK() {
        if (this.aAu >= -1.0d) {
            this.azA.setPadding(CriusEdge.TOP, e(this.aAu));
        }
    }

    private void initPadding() {
        if (this.aAs >= -1.0d) {
            this.azA.setPadding(CriusEdge.ALL, e(this.aAs));
        }
    }

    private void tL() {
        if (this.aAo >= -1.0d) {
            this.azA.setMargin(CriusEdge.LEFT, e(this.aAo));
        }
    }

    private void tM() {
        if (this.aAr >= -1.0d) {
            this.azA.setMargin(CriusEdge.BOTTOM, e(this.aAr));
        }
    }

    private void tN() {
        if (this.aAq >= -1.0d) {
            this.azA.setMargin(CriusEdge.RIGHT, e(this.aAq));
        }
    }

    private void tO() {
        if (this.aAp >= -1.0d) {
            this.azA.setMargin(CriusEdge.TOP, e(this.aAp));
        }
    }

    private void tP() {
        if (this.aAn >= -1.0d) {
            this.azA.setMargin(CriusEdge.ALL, e(this.aAn));
        }
    }

    private void tQ() {
        if (this.aAi >= -1.0d) {
            this.azA.setFlexBasis(e(this.aAi));
        }
    }

    private void tR() {
        if (this.aAh >= -1.0d) {
            this.azA.setFlexShrink((float) this.aAh);
        }
    }

    private void tS() {
        if (this.aAg >= -1.0d) {
            this.azA.setFlexGrow((float) this.aAg);
        }
    }

    private void tT() {
        if (this.aAf >= -1.0d) {
            this.azA.setFlex((float) this.aAf);
        }
    }

    private void tU() {
        if (!TextUtils.isEmpty(this.azZ)) {
            if ("flex".equalsIgnoreCase(this.azZ)) {
                this.azA.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.azZ)) {
                this.azA.setDisplay(CriusDisplay.NONE);
            } else {
                this.azA.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void tV() {
        if (!b.b(this.aAj, -10000.0d)) {
            this.azA.setPosition(CriusEdge.LEFT, e(this.aAj));
        }
        if (!b.b(this.aAk, -10000.0d)) {
            this.azA.setPosition(CriusEdge.TOP, e(this.aAk));
        }
        if (!b.b(this.aAl, -10000.0d)) {
            this.azA.setPosition(CriusEdge.RIGHT, e(this.aAl));
        }
        if (!b.b(this.aAm, -10000.0d)) {
            this.azA.setPosition(CriusEdge.BOTTOM, e(this.aAm));
        }
    }

    private void tW() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.azA.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.azA.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void tX() {
        if (!TextUtils.isEmpty(this.aAe)) {
            if ("flex-start".equalsIgnoreCase(this.aAe)) {
                this.azA.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aAe)) {
                this.azA.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aAe)) {
                this.azA.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aAe)) {
                this.azA.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.aAe)) {
                this.azA.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.aAe)) {
                this.azA.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.azA.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void tY() {
        if (!TextUtils.isEmpty(this.aAd)) {
            if ("auto".equalsIgnoreCase(this.aAd)) {
                this.azA.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.aAd)) {
                this.azA.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aAd)) {
                this.azA.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aAd)) {
                this.azA.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aAd)) {
                this.azA.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.azA.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void tZ() {
        if (!TextUtils.isEmpty(this.aAc)) {
            if ("flex-start".equalsIgnoreCase(this.aAc)) {
                this.azA.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aAc)) {
                this.azA.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aAc)) {
                this.azA.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aAc)) {
                this.azA.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.azA.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void ua() {
        if (!TextUtils.isEmpty(this.aAb)) {
            if ("flex-start".equalsIgnoreCase(this.aAb)) {
                this.azA.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aAb)) {
                this.azA.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aAb)) {
                this.azA.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.aAb)) {
                this.azA.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.aAb)) {
                this.azA.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.azA.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void ub() {
        if (!TextUtils.isEmpty(this.aAa)) {
            if ("column".equalsIgnoreCase(this.aAa)) {
                this.azA.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.aAa)) {
                this.azA.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.aAa)) {
                this.azA.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.aAa)) {
                this.azA.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.azA.setFlexDirection(CriusFlexDirection.COLUMN);
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
            if (this.aBb != null && this.aBb.size() > 0) {
                for (a aVar : this.aBb) {
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
        if (!str.equalsIgnoreCase(this.azO)) {
            if (this.aBb != null && this.aBb.size() > 0) {
                for (a aVar : this.aBb) {
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
        if (this.azz == null || (bU = bU(str)) == null || bU.azA == null) {
            return false;
        }
        bU.azA.setDisplay(CriusDisplay.NONE);
        bU.azA.dirty();
        this.azz.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a bT;
        if (this.azz != null && (bT = bT(str)) != null && bT.azA != null) {
            bT.aAL = f;
            bT.azA.dirty();
            this.azz.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
