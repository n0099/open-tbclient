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
    private static final TextPaint TM = new TextPaint(1);
    private static Class TO;
    private static Method TP;
    private static Method TQ;
    private static Method TR;
    private static Method TS;
    private static Method TT;
    private static Method TU;
    private static Method TV;
    private static Field TW;
    private static Field TX;
    private static Field TY;
    public String TB;
    private CriusNode TK;
    private double UB;
    private double UC;
    private double UD;
    private double UE;
    private double UF;
    private double UG;
    private double UH;
    private double UI;
    private double UJ;
    private double UK;
    private double UL;
    private double UM;
    private double UN;
    public String UO;
    public String UQ;
    public String UR;
    public double US;
    public double UT;
    public double UU;
    public String UV;
    public String UW;
    public Typeface UX;
    public double UY;
    public String UZ;
    public String Ua;
    public String Ub;
    public String Uc;
    public String Ud;
    public String Ue;
    public int Uf;
    public int Ug;
    public int Uh;
    public String Ui;
    public String Uj;
    private String Uk;
    private String Ul;
    private String Um;
    private String Un;
    private String Uo;
    private String Up;
    private double Uq;
    private double Ur;
    private double Us;
    private double Ut;
    private double Uu;
    private double Uv;
    private double Uw;
    private double Ux;
    private double Uy;
    private double Uz;
    public String Va;
    public String Vb;
    public String Vc;
    public String Vd;
    public String Ve;
    public String Vf;
    public String Vg;
    public String Vh;
    public String Vj;
    public String Vk;
    public String Vl;
    public String Vm;
    public String Vn;
    public final List<a> Vo;
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
    private final CriusMeasureFunction TZ = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
        @Override // com.baidu.crius.CriusMeasureFunction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            Layout layout;
            TextPaint textPaint = a.TM;
            if (a.this.UY >= 0.0d) {
                textPaint.setTextSize((float) (a.this.UY * a.this.density));
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
                        Object invoke = a.TP.invoke(a.TO, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.TQ.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.TR.invoke(invoke, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.TS.invoke(invoke, false);
                        Method method = a.TT;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.TW.get(Layout.class) : a.TX.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.TU.invoke(invoke, a.TY.get(Layout.class));
                        layout = (Layout) a.TV.invoke(invoke, new Object[0]);
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
                        Object invoke2 = a.TP.invoke(a.TO, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                        a.TQ.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                        a.TR.invoke(invoke2, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.TS.invoke(invoke2, false);
                        Method method2 = a.TT;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.TW.get(Layout.class) : a.TX.get(Layout.class);
                        method2.invoke(invoke2, objArr2);
                        a.TU.invoke(invoke2, a.TY.get(Layout.class));
                        layout = (Layout) a.TV.invoke(invoke2, new Object[0]);
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
                    return CriusMeasureOutput.make(a.this.X(layout.getWidth()), a.this.W(layout.getLineBottom(a.this.maxLines - 1)));
                }
                if (layout == null) {
                    return CriusMeasureOutput.make(a.this.X(layout.getWidth()), a.this.W(layout.getHeight()));
                }
                return CriusMeasureOutput.make(f, f2);
            }
        }
    };
    public double Vi = -10000.0d;
    public final CriusNode TL = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0053a {
        String ct(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                TO = Class.forName("android.text.StaticLayout$Builder");
                TP = TO.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                TP.setAccessible(true);
                TQ = TO.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                TQ.setAccessible(true);
                TR = TO.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                TR.setAccessible(true);
                TS = TO.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                TS.setAccessible(true);
                TT = TO.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                TT.setAccessible(true);
                TU = TO.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                TU.setAccessible(true);
                TV = TO.getDeclaredMethod("build", new Class[0]);
                TV.setAccessible(true);
                TW = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                TW.setAccessible(true);
                TX = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                TX.setAccessible(true);
                TY = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                TY.setAccessible(true);
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

    public static boolean cp(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cp(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void g(JSONObject jSONObject) {
        this.id = b.e(jSONObject, "id");
        this.name = b.e(jSONObject, "name");
        this.type = b.e(jSONObject, "type");
        if (isText()) {
            this.TL.setMeasureFunction(this.TZ);
        }
        this.Ua = b.e(jSONObject, "component");
        this.src = b.e(jSONObject, "src");
        this.TB = b.e(jSONObject, "poster");
        this.Ub = b.e(jSONObject, "href");
        this.text = b.e(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.Ua) && this.businessConverter != null) {
            this.text = this.businessConverter.ct(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.Uc = jSONObject.optString("data-als-stat");
        this.Ud = jSONObject.optString("data-url-stat");
        this.Ue = jSONObject.optString("data-href-pop");
        this.Uf = b.g(jSONObject, "data-share-num");
        this.Ug = b.g(jSONObject, "data-reply-num");
        this.Uh = b.g(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.Ui = jSONObject.optString("data-share-image");
        this.Uj = jSONObject.optString("data-share-link");
    }

    private void h(JSONObject jSONObject) {
        this.Uk = b.e(jSONObject, "display");
        pP();
        this.Ul = b.e(jSONObject, "flex-direction");
        pW();
        this.Um = b.e(jSONObject, "justify-content");
        pV();
        this.Un = b.e(jSONObject, "align-items");
        pU();
        this.Uo = b.e(jSONObject, "align-self");
        pT();
        this.Up = b.e(jSONObject, "align-content");
        pS();
        this.Uq = b.f(jSONObject, "flex");
        pO();
        this.Ur = b.f(jSONObject, "flex-grow");
        pN();
        this.Us = b.f(jSONObject, "flex-shrink");
        pM();
        this.Ut = b.f(jSONObject, "flex-basis");
        pL();
        this.position = b.e(jSONObject, "position");
        pR();
        this.Uu = b.f(jSONObject, CustomDialogData.POS_LEFT);
        this.Uv = b.f(jSONObject, "top");
        this.Uw = b.f(jSONObject, "right");
        this.Ux = b.f(jSONObject, "bottom");
        pQ();
        this.Uy = b.f(jSONObject, "margin");
        pK();
        this.Uz = b.f(jSONObject, "margin-left");
        pG();
        this.UB = b.f(jSONObject, "margin-top");
        pJ();
        this.UC = b.f(jSONObject, "margin-right");
        pI();
        this.UD = b.f(jSONObject, "margin-bottom");
        pH();
        this.UE = b.f(jSONObject, "padding");
        initPadding();
        this.UF = b.f(jSONObject, "padding-left");
        pC();
        this.UG = b.f(jSONObject, "padding-top");
        pF();
        this.UH = b.f(jSONObject, "padding-right");
        pE();
        this.UI = b.f(jSONObject, "padding-bottom");
        pD();
        this.width = b.f(jSONObject, "width");
        pB();
        this.height = b.f(jSONObject, "height");
        pA();
        this.UJ = b.f(jSONObject, "min-width");
        pz();
        this.UK = b.f(jSONObject, "min-height");
        py();
        this.UL = b.f(jSONObject, "max-width");
        pv();
        this.UM = b.f(jSONObject, "max-height");
        px();
        this.UN = b.f(jSONObject, "aspect-ratio");
        pw();
    }

    private void i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.Vk = b.e(optJSONObject, "background-image");
            this.Vl = b.e(optJSONObject, "background-color");
            this.Vm = b.e(optJSONObject, "border-color");
            this.Vn = b.e(optJSONObject, "color");
        }
    }

    private void j(JSONObject jSONObject) {
        this.Vf = b.e(jSONObject, "background-image");
        this.Vg = b.e(jSONObject, "background-color");
        this.Vh = b.e(jSONObject, "border-color");
        this.Vi = b.f(jSONObject, "opacity");
        this.Vj = b.e(jSONObject, "color");
    }

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.Vb = b.e(optJSONObject, "background-image");
            this.Vc = b.e(optJSONObject, "background-color");
            this.Vd = b.e(optJSONObject, "border-color");
            this.Ve = b.e(optJSONObject, "color");
        }
    }

    private void l(JSONObject jSONObject) {
        this.UO = b.e(jSONObject, "background-image");
        this.UQ = b.e(jSONObject, "background-color");
        this.UR = b.e(jSONObject, "border-color");
        this.UU = b.f(jSONObject, "opacity");
        this.color = b.e(jSONObject, "color");
        this.US = b.f(jSONObject, "border-width");
        this.UT = b.f(jSONObject, "border-radius");
        this.UV = b.e(jSONObject, "font-style");
        this.UW = b.e(jSONObject, "font-weight");
        this.UX = Typeface.create(Typeface.DEFAULT, pt());
        this.UY = jSONObject.optDouble("font-size", 12.0d);
        this.UZ = b.e(jSONObject, "text-align");
        this.Va = b.e(jSONObject, "vertical-align");
        this.gravity = pu();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0053a interfaceC0053a, boolean z) {
        this.businessConverter = interfaceC0053a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        this.heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        g(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            h(optJSONObject);
            l(optJSONObject);
            k(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            j(optJSONObject2);
            i(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.Vo = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0053a, false);
                    this.Vo.add(aVar);
                    this.TL.addChildAt(aVar.TL, i);
                }
            } else {
                this.Vo = null;
            }
        } else {
            this.Vo = null;
        }
        if (z) {
            this.TK = new CriusNode();
            this.TK.addChildAt(this.TL, 0);
            this.TK.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int pt() {
        return "italic".equalsIgnoreCase(this.UV) ? (TextUtils.isEmpty(this.UW) || "normal".equalsIgnoreCase(this.UW) || !"bold".equalsIgnoreCase(this.UW)) ? 2 : 3 : (TextUtils.isEmpty(this.UW) || "normal".equalsIgnoreCase(this.UW) || !"bold".equalsIgnoreCase(this.UW)) ? 0 : 1;
    }

    private int pu() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.UZ)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.UZ)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.UZ)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.Va)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.Va)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.Va)) {
            return i | 16;
        }
        return i | 0;
    }

    private void pv() {
        if (this.UL >= 0.0d) {
            this.TL.setMaxWidth(g(this.UL));
        } else if (this.UL > -10000.0d) {
            this.TL.setMaxWidth(this.widthPixels);
        }
    }

    private void pw() {
        if (this.UN > 0.0d) {
            this.TL.setAspectRatio((float) this.UN);
        }
    }

    private void px() {
        if (this.UM >= 0.0d) {
            this.TL.setMaxHeight(g(this.UM));
        } else if (this.UM > -10000.0d) {
            this.TL.setMaxHeight(this.heightPixels);
        }
    }

    private void py() {
        if (this.UK >= 0.0d) {
            this.TL.setMinHeight(g(this.UK));
        } else if (this.UK > -10000.0d) {
            this.TL.setMinHeight(this.heightPixels);
        }
    }

    private void pz() {
        if (this.UJ >= 0.0d) {
            this.TL.setMinWidth(g(this.UJ));
        } else if (this.UJ > -10000.0d) {
            this.TL.setMinWidth(this.widthPixels);
        }
    }

    private void pA() {
        if (this.height >= 0.0d) {
            this.TL.setHeight(g(this.height));
        } else if (this.height > -10000.0d) {
            this.TL.setHeight(this.heightPixels);
        }
    }

    private void pB() {
        if (this.width >= 0.0d) {
            this.TL.setWidth(g(this.width));
        } else if (this.width > -10000.0d) {
            this.TL.setWidth(this.widthPixels);
        }
    }

    private void pC() {
        if (this.UF >= -1.0d) {
            this.TL.setPadding(CriusEdge.LEFT, g(this.UF));
        }
    }

    private void pD() {
        if (this.UI >= -1.0d) {
            this.TL.setPadding(CriusEdge.BOTTOM, g(this.UI));
        }
    }

    private void pE() {
        if (this.UH >= -1.0d) {
            this.TL.setPadding(CriusEdge.RIGHT, g(this.UH));
        }
    }

    private void pF() {
        if (this.UG >= -1.0d) {
            this.TL.setPadding(CriusEdge.TOP, g(this.UG));
        }
    }

    private void initPadding() {
        if (this.UE >= -1.0d) {
            this.TL.setPadding(CriusEdge.ALL, g(this.UE));
        }
    }

    private void pG() {
        if (this.Uz >= -1.0d) {
            this.TL.setMargin(CriusEdge.LEFT, g(this.Uz));
        }
    }

    private void pH() {
        if (this.UD >= -1.0d) {
            this.TL.setMargin(CriusEdge.BOTTOM, g(this.UD));
        }
    }

    private void pI() {
        if (this.UC >= -1.0d) {
            this.TL.setMargin(CriusEdge.RIGHT, g(this.UC));
        }
    }

    private void pJ() {
        if (this.UB >= -1.0d) {
            this.TL.setMargin(CriusEdge.TOP, g(this.UB));
        }
    }

    private void pK() {
        if (this.Uy >= -1.0d) {
            this.TL.setMargin(CriusEdge.ALL, g(this.Uy));
        }
    }

    private void pL() {
        if (this.Ut >= -1.0d) {
            this.TL.setFlexBasis(g(this.Ut));
        }
    }

    private void pM() {
        if (this.Us >= -1.0d) {
            this.TL.setFlexShrink((float) this.Us);
        }
    }

    private void pN() {
        if (this.Ur >= -1.0d) {
            this.TL.setFlexGrow((float) this.Ur);
        }
    }

    private void pO() {
        if (this.Uq >= -1.0d) {
            this.TL.setFlex((float) this.Uq);
        }
    }

    private void pP() {
        if (!TextUtils.isEmpty(this.Uk)) {
            if ("flex".equalsIgnoreCase(this.Uk)) {
                this.TL.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.Uk)) {
                this.TL.setDisplay(CriusDisplay.NONE);
            } else {
                this.TL.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void pQ() {
        if (!b.b(this.Uu, -10000.0d)) {
            this.TL.setPosition(CriusEdge.LEFT, g(this.Uu));
        }
        if (!b.b(this.Uv, -10000.0d)) {
            this.TL.setPosition(CriusEdge.TOP, g(this.Uv));
        }
        if (!b.b(this.Uw, -10000.0d)) {
            this.TL.setPosition(CriusEdge.RIGHT, g(this.Uw));
        }
        if (!b.b(this.Ux, -10000.0d)) {
            this.TL.setPosition(CriusEdge.BOTTOM, g(this.Ux));
        }
    }

    private void pR() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.TL.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.TL.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void pS() {
        if (!TextUtils.isEmpty(this.Up)) {
            if ("flex-start".equalsIgnoreCase(this.Up)) {
                this.TL.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Up)) {
                this.TL.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Up)) {
                this.TL.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Up)) {
                this.TL.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.Up)) {
                this.TL.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Up)) {
                this.TL.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.TL.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void pT() {
        if (!TextUtils.isEmpty(this.Uo)) {
            if ("auto".equalsIgnoreCase(this.Uo)) {
                this.TL.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.Uo)) {
                this.TL.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Uo)) {
                this.TL.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Uo)) {
                this.TL.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Uo)) {
                this.TL.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.TL.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void pU() {
        if (!TextUtils.isEmpty(this.Un)) {
            if ("flex-start".equalsIgnoreCase(this.Un)) {
                this.TL.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Un)) {
                this.TL.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Un)) {
                this.TL.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Un)) {
                this.TL.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.TL.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void pV() {
        if (!TextUtils.isEmpty(this.Um)) {
            if ("flex-start".equalsIgnoreCase(this.Um)) {
                this.TL.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Um)) {
                this.TL.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Um)) {
                this.TL.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.Um)) {
                this.TL.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Um)) {
                this.TL.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.TL.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void pW() {
        if (!TextUtils.isEmpty(this.Ul)) {
            if ("column".equalsIgnoreCase(this.Ul)) {
                this.TL.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.Ul)) {
                this.TL.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.Ul)) {
                this.TL.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.Ul)) {
                this.TL.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.TL.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.Vo != null && this.Vo.size() > 0) {
                for (a aVar : this.Vo) {
                    a cq = aVar.cq(str);
                    if (cq != null) {
                        return cq;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.Ua)) {
            if (this.Vo != null && this.Vo.size() > 0) {
                for (a aVar : this.Vo) {
                    a cr = aVar.cr(str);
                    if (cr != null) {
                        return cr;
                    }
                }
            }
            return null;
        }
        return this;
    }

    private float g(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.density * d);
    }

    public float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean cs(String str) {
        a cr;
        if (this.TK == null || (cr = cr(str)) == null || cr.TL == null) {
            return false;
        }
        cr.TL.setDisplay(CriusDisplay.NONE);
        cr.TL.dirty();
        this.TK.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cq;
        if (this.TK != null && (cq = cq(str)) != null && cq.TL != null) {
            cq.UY = f;
            cq.TL.dirty();
            this.TK.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
