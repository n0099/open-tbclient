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
    private static final TextPaint Wn = new TextPaint(1);
    private static Class Wo;
    private static Method Wp;
    private static Method Wq;
    private static Method Wr;
    private static Method Ws;
    private static Method Wt;
    private static Method Wu;
    private static Method Wv;
    private static Field Ww;
    private static Field Wx;
    private static Field Wy;
    public String WA;
    public String WB;
    public String WC;
    public String WD;
    public String WE;
    public int WF;
    public int WG;
    public int WH;
    public String WI;
    public String WJ;
    public double WK;
    private String WL;
    private String WM;
    private String WN;
    private String WO;
    private String WP;
    private String WQ;
    private double WR;
    private double WS;
    private double WT;
    private double WU;
    private double WV;
    private double WW;
    private double WX;
    private double WY;
    private double WZ;
    public String Wd;
    private CriusNode Wl;
    public String XA;
    public String XB;
    public String XC;
    public String XD;
    public String XE;
    public String XF;
    public String XG;
    public String XI;
    public String XJ;
    public String XK;
    public String XL;
    public String XM;
    public final List<a> XN;
    private double Xa;
    private double Xb;
    private double Xc;
    private double Xd;
    private double Xe;
    private double Xf;
    private double Xg;
    private double Xh;
    private double Xi;
    private double Xj;
    private double Xk;
    private double Xl;
    private double Xm;
    private double Xn;
    public String Xo;
    public String Xp;
    public String Xq;
    public double Xr;
    public double Xs;
    public double Xt;
    public String Xu;
    public String Xv;
    public Typeface Xw;
    public double Xx;
    public String Xy;
    public String Xz;
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
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;
    public final int widthPixels;
    private final CriusMeasureFunction Wz = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.Wn;
            if (a.this.Xx >= 0.0d) {
                textPaint.setTextSize((float) (a.this.Xx * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.WK > 0.0d ? (float) a.this.WK : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.Wp.invoke(a.Wo, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.Wq.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.Wr.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.Ws.invoke(invoke, false);
                        Method method = a.Wt;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.Ww.get(Layout.class) : a.Wx.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.Wu.invoke(invoke, a.Wy.get(Layout.class));
                        layout = (Layout) a.Wv.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.Wp.invoke(a.Wo, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.Wq.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.Wr.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.Ws.invoke(invoke2, false);
                    Method method2 = a.Wt;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.Ww.get(Layout.class) : a.Wx.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.Wu.invoke(invoke2, a.Wy.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.Wv.invoke(invoke2, new Object[0]);
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
    public double XH = -10000.0d;
    public final CriusNode Wm = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0053a {
        String cM(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Wo = Class.forName("android.text.StaticLayout$Builder");
                Wp = Wo.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                Wp.setAccessible(true);
                Wq = Wo.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                Wq.setAccessible(true);
                Wr = Wo.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                Wr.setAccessible(true);
                Ws = Wo.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                Ws.setAccessible(true);
                Wt = Wo.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                Wt.setAccessible(true);
                Wu = Wo.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                Wu.setAccessible(true);
                Wv = Wo.getDeclaredMethod("build", new Class[0]);
                Wv.setAccessible(true);
                Ww = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                Ww.setAccessible(true);
                Wx = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                Wx.setAccessible(true);
                Wy = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                Wy.setAccessible(true);
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

    public static boolean cI(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cI(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void m(JSONObject jSONObject) {
        this.id = b.f(jSONObject, "id");
        this.name = b.f(jSONObject, "name");
        this.type = b.f(jSONObject, "type");
        if (isText()) {
            this.Wm.setMeasureFunction(this.Wz);
        }
        this.WA = b.f(jSONObject, "component");
        this.src = b.f(jSONObject, "src");
        this.Wd = b.f(jSONObject, "poster");
        this.WB = b.f(jSONObject, "href");
        this.text = b.f(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.WA) && this.businessConverter != null) {
            this.text = this.businessConverter.cM(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.WK = b.g(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.WC = jSONObject.optString("data-als-stat");
        this.WD = jSONObject.optString("data-url-stat");
        this.WE = jSONObject.optString("data-href-pop");
        this.WF = b.h(jSONObject, "data-share-num");
        this.WG = b.h(jSONObject, "data-reply-num");
        this.WH = b.h(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.WI = jSONObject.optString("data-share-image");
        this.WJ = jSONObject.optString("data-share-link");
    }

    private void n(JSONObject jSONObject) {
        this.WL = b.f(jSONObject, "display");
        qV();
        this.WM = b.f(jSONObject, "flex-direction");
        rc();
        this.WN = b.f(jSONObject, "justify-content");
        rb();
        this.WO = b.f(jSONObject, "align-items");
        ra();
        this.WP = b.f(jSONObject, "align-self");
        qZ();
        this.WQ = b.f(jSONObject, "align-content");
        qY();
        this.WR = b.g(jSONObject, "flex");
        qU();
        this.WS = b.g(jSONObject, "flex-grow");
        qT();
        this.WT = b.g(jSONObject, "flex-shrink");
        qS();
        this.WU = b.g(jSONObject, "flex-basis");
        qR();
        this.position = b.f(jSONObject, "position");
        qX();
        this.WV = b.g(jSONObject, CustomDialogData.POS_LEFT);
        this.WW = b.g(jSONObject, "top");
        this.WX = b.g(jSONObject, "right");
        this.WY = b.g(jSONObject, "bottom");
        qW();
        this.WZ = b.g(jSONObject, "margin");
        qQ();
        this.Xa = b.g(jSONObject, "margin-left");
        qM();
        this.Xb = b.g(jSONObject, "margin-top");
        qP();
        this.Xc = b.g(jSONObject, "margin-right");
        qO();
        this.Xd = b.g(jSONObject, "margin-bottom");
        qN();
        this.Xe = b.g(jSONObject, "padding");
        initPadding();
        this.Xf = b.g(jSONObject, "padding-left");
        qI();
        this.Xg = b.g(jSONObject, "padding-top");
        qL();
        this.Xh = b.g(jSONObject, "padding-right");
        qK();
        this.Xi = b.g(jSONObject, "padding-bottom");
        qJ();
        this.width = b.g(jSONObject, "width");
        qH();
        this.height = b.g(jSONObject, "height");
        qG();
        this.Xj = b.g(jSONObject, "min-width");
        qF();
        this.Xk = b.g(jSONObject, "min-height");
        qE();
        this.Xl = b.g(jSONObject, "max-width");
        qB();
        this.Xm = b.g(jSONObject, "max-height");
        qD();
        this.Xn = b.g(jSONObject, "aspect-ratio");
        qC();
    }

    private void o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.XJ = b.f(optJSONObject, "background-image");
            this.XK = b.f(optJSONObject, "background-color");
            this.XL = b.f(optJSONObject, "border-color");
            this.XM = b.f(optJSONObject, "color");
        }
    }

    private void p(JSONObject jSONObject) {
        this.XE = b.f(jSONObject, "background-image");
        this.XF = b.f(jSONObject, "background-color");
        this.XG = b.f(jSONObject, "border-color");
        this.XH = b.g(jSONObject, "opacity");
        this.XI = b.f(jSONObject, "color");
    }

    private void q(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.XA = b.f(optJSONObject, "background-image");
            this.XB = b.f(optJSONObject, "background-color");
            this.XC = b.f(optJSONObject, "border-color");
            this.XD = b.f(optJSONObject, "color");
        }
    }

    private void r(JSONObject jSONObject) {
        this.Xo = b.f(jSONObject, "background-image");
        this.Xp = b.f(jSONObject, "background-color");
        this.Xq = b.f(jSONObject, "border-color");
        this.Xt = b.g(jSONObject, "opacity");
        this.color = b.f(jSONObject, "color");
        this.Xr = b.g(jSONObject, "border-width");
        this.Xs = b.g(jSONObject, "border-radius");
        this.Xu = b.f(jSONObject, "font-style");
        this.Xv = b.f(jSONObject, "font-weight");
        this.Xw = Typeface.create(Typeface.DEFAULT, qz());
        this.Xx = jSONObject.optDouble("font-size", 12.0d);
        this.Xy = b.f(jSONObject, "text-align");
        this.Xz = b.f(jSONObject, "vertical-align");
        this.gravity = qA();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0053a interfaceC0053a, boolean z) {
        this.businessConverter = interfaceC0053a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        this.heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        m(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
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
                this.XN = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0053a, false);
                    this.XN.add(aVar);
                    this.Wm.addChildAt(aVar.Wm, i);
                }
            } else {
                this.XN = null;
            }
        } else {
            this.XN = null;
        }
        if (z) {
            this.Wl = new CriusNode();
            this.Wl.addChildAt(this.Wm, 0);
            this.Wl.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int qz() {
        return "italic".equalsIgnoreCase(this.Xu) ? (TextUtils.isEmpty(this.Xv) || "normal".equalsIgnoreCase(this.Xv) || !"bold".equalsIgnoreCase(this.Xv)) ? 2 : 3 : (TextUtils.isEmpty(this.Xv) || "normal".equalsIgnoreCase(this.Xv) || !"bold".equalsIgnoreCase(this.Xv)) ? 0 : 1;
    }

    private int qA() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.Xy)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.Xy)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.Xy)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.Xz)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.Xz)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.Xz)) {
            return i | 16;
        }
        return i | 0;
    }

    private void qB() {
        if (this.Xl >= 0.0d) {
            this.Wm.setMaxWidth(e(this.Xl));
        } else if (this.Xl > -10000.0d) {
            this.Wm.setMaxWidth(this.widthPixels);
        }
    }

    private void qC() {
        if (this.Xn > 0.0d) {
            this.Wm.setAspectRatio((float) this.Xn);
        }
    }

    private void qD() {
        if (this.Xm >= 0.0d) {
            this.Wm.setMaxHeight(e(this.Xm));
        } else if (this.Xm > -10000.0d) {
            this.Wm.setMaxHeight(this.heightPixels);
        }
    }

    private void qE() {
        if (this.Xk >= 0.0d) {
            this.Wm.setMinHeight(e(this.Xk));
        } else if (this.Xk > -10000.0d) {
            this.Wm.setMinHeight(this.heightPixels);
        }
    }

    private void qF() {
        if (this.Xj >= 0.0d) {
            this.Wm.setMinWidth(e(this.Xj));
        } else if (this.Xj > -10000.0d) {
            this.Wm.setMinWidth(this.widthPixels);
        }
    }

    private void qG() {
        if (this.height >= 0.0d) {
            this.Wm.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.Wm.setHeight(this.heightPixels);
        }
    }

    private void qH() {
        if (this.width >= 0.0d) {
            this.Wm.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.Wm.setWidth(this.widthPixels);
        }
    }

    private void qI() {
        if (this.Xf >= -1.0d) {
            this.Wm.setPadding(CriusEdge.LEFT, e(this.Xf));
        }
    }

    private void qJ() {
        if (this.Xi >= -1.0d) {
            this.Wm.setPadding(CriusEdge.BOTTOM, e(this.Xi));
        }
    }

    private void qK() {
        if (this.Xh >= -1.0d) {
            this.Wm.setPadding(CriusEdge.RIGHT, e(this.Xh));
        }
    }

    private void qL() {
        if (this.Xg >= -1.0d) {
            this.Wm.setPadding(CriusEdge.TOP, e(this.Xg));
        }
    }

    private void initPadding() {
        if (this.Xe >= -1.0d) {
            this.Wm.setPadding(CriusEdge.ALL, e(this.Xe));
        }
    }

    private void qM() {
        if (this.Xa >= -1.0d) {
            this.Wm.setMargin(CriusEdge.LEFT, e(this.Xa));
        }
    }

    private void qN() {
        if (this.Xd >= -1.0d) {
            this.Wm.setMargin(CriusEdge.BOTTOM, e(this.Xd));
        }
    }

    private void qO() {
        if (this.Xc >= -1.0d) {
            this.Wm.setMargin(CriusEdge.RIGHT, e(this.Xc));
        }
    }

    private void qP() {
        if (this.Xb >= -1.0d) {
            this.Wm.setMargin(CriusEdge.TOP, e(this.Xb));
        }
    }

    private void qQ() {
        if (this.WZ >= -1.0d) {
            this.Wm.setMargin(CriusEdge.ALL, e(this.WZ));
        }
    }

    private void qR() {
        if (this.WU >= -1.0d) {
            this.Wm.setFlexBasis(e(this.WU));
        }
    }

    private void qS() {
        if (this.WT >= -1.0d) {
            this.Wm.setFlexShrink((float) this.WT);
        }
    }

    private void qT() {
        if (this.WS >= -1.0d) {
            this.Wm.setFlexGrow((float) this.WS);
        }
    }

    private void qU() {
        if (this.WR >= -1.0d) {
            this.Wm.setFlex((float) this.WR);
        }
    }

    private void qV() {
        if (!TextUtils.isEmpty(this.WL)) {
            if ("flex".equalsIgnoreCase(this.WL)) {
                this.Wm.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.WL)) {
                this.Wm.setDisplay(CriusDisplay.NONE);
            } else {
                this.Wm.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void qW() {
        if (!b.c(this.WV, -10000.0d)) {
            this.Wm.setPosition(CriusEdge.LEFT, e(this.WV));
        }
        if (!b.c(this.WW, -10000.0d)) {
            this.Wm.setPosition(CriusEdge.TOP, e(this.WW));
        }
        if (!b.c(this.WX, -10000.0d)) {
            this.Wm.setPosition(CriusEdge.RIGHT, e(this.WX));
        }
        if (!b.c(this.WY, -10000.0d)) {
            this.Wm.setPosition(CriusEdge.BOTTOM, e(this.WY));
        }
    }

    private void qX() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.Wm.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.Wm.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void qY() {
        if (!TextUtils.isEmpty(this.WQ)) {
            if ("flex-start".equalsIgnoreCase(this.WQ)) {
                this.Wm.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.WQ)) {
                this.Wm.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.WQ)) {
                this.Wm.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.WQ)) {
                this.Wm.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.WQ)) {
                this.Wm.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.WQ)) {
                this.Wm.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.Wm.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void qZ() {
        if (!TextUtils.isEmpty(this.WP)) {
            if ("auto".equalsIgnoreCase(this.WP)) {
                this.Wm.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.WP)) {
                this.Wm.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.WP)) {
                this.Wm.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.WP)) {
                this.Wm.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.WP)) {
                this.Wm.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.Wm.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void ra() {
        if (!TextUtils.isEmpty(this.WO)) {
            if ("flex-start".equalsIgnoreCase(this.WO)) {
                this.Wm.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.WO)) {
                this.Wm.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.WO)) {
                this.Wm.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.WO)) {
                this.Wm.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.Wm.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void rb() {
        if (!TextUtils.isEmpty(this.WN)) {
            if ("flex-start".equalsIgnoreCase(this.WN)) {
                this.Wm.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.WN)) {
                this.Wm.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.WN)) {
                this.Wm.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.WN)) {
                this.Wm.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.WN)) {
                this.Wm.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.Wm.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void rc() {
        if (!TextUtils.isEmpty(this.WM)) {
            if ("column".equalsIgnoreCase(this.WM)) {
                this.Wm.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.WM)) {
                this.Wm.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.WM)) {
                this.Wm.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.WM)) {
                this.Wm.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.Wm.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.XN != null && this.XN.size() > 0) {
                for (a aVar : this.XN) {
                    a cJ = aVar.cJ(str);
                    if (cJ != null) {
                        return cJ;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.WA)) {
            if (this.XN != null && this.XN.size() > 0) {
                for (a aVar : this.XN) {
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

    private float e(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.density * d);
    }

    public float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean cL(String str) {
        a cK;
        if (this.Wl == null || (cK = cK(str)) == null || cK.Wm == null) {
            return false;
        }
        cK.Wm.setDisplay(CriusDisplay.NONE);
        cK.Wm.dirty();
        this.Wl.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cJ;
        if (this.Wl != null && (cJ = cJ(str)) != null && cJ.Wm != null) {
            cJ.Xx = f;
            cJ.Wm.dirty();
            this.Wl.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
