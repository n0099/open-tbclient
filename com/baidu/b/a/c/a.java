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
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
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
    private static final TextPaint TP = new TextPaint(1);
    private static Class TQ;
    private static Method TR;
    private static Method TS;
    private static Method TT;
    private static Method TU;
    private static Method TV;
    private static Method TW;
    private static Method TX;
    private static Field TY;
    private static Field TZ;
    private static Field Ua;
    public String TD;
    private CriusNode TM;
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
    private double UO;
    private double UQ;
    public String UR;
    public String US;
    public String UT;
    public double UU;
    public double UV;
    public double UW;
    public String UX;
    public String UY;
    public Typeface UZ;
    public String Uc;
    public String Ud;
    public String Ue;
    public String Uf;
    public String Ug;
    public int Uh;
    public int Ui;
    public int Uj;
    public String Uk;
    public String Ul;
    private String Um;
    private String Un;
    private String Uo;
    private String Up;
    private String Uq;
    private String Ur;
    private double Us;
    private double Ut;
    private double Uu;
    private double Uv;
    private double Uw;
    private double Ux;
    private double Uy;
    private double Uz;
    public double Va;
    public String Vb;
    public String Vc;
    public String Vd;
    public String Ve;
    public String Vf;
    public String Vg;
    public String Vh;
    public String Vi;
    public String Vj;
    public String Vl;
    public String Vm;
    public String Vn;
    public String Vo;
    public String Vp;
    public final List<a> Vq;
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
    private final CriusMeasureFunction Ub = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
        @Override // com.baidu.crius.CriusMeasureFunction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            Layout layout;
            TextPaint textPaint = a.TP;
            if (a.this.Va >= 0.0d) {
                textPaint.setTextSize((float) (a.this.Va * a.this.density));
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
                        Object invoke = a.TR.invoke(a.TQ, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.TS.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.TT.invoke(invoke, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.TU.invoke(invoke, false);
                        Method method = a.TV;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.TY.get(Layout.class) : a.TZ.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.TW.invoke(invoke, a.Ua.get(Layout.class));
                        layout = (Layout) a.TX.invoke(invoke, new Object[0]);
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
                        Object invoke2 = a.TR.invoke(a.TQ, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                        a.TS.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                        a.TT.invoke(invoke2, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.TU.invoke(invoke2, false);
                        Method method2 = a.TV;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.TY.get(Layout.class) : a.TZ.get(Layout.class);
                        method2.invoke(invoke2, objArr2);
                        a.TW.invoke(invoke2, a.Ua.get(Layout.class));
                        layout = (Layout) a.TX.invoke(invoke2, new Object[0]);
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
    public double Vk = -10000.0d;
    public final CriusNode TO = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0053a {
        String cv(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                TQ = Class.forName("android.text.StaticLayout$Builder");
                TR = TQ.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                TR.setAccessible(true);
                TS = TQ.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                TS.setAccessible(true);
                TT = TQ.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                TT.setAccessible(true);
                TU = TQ.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                TU.setAccessible(true);
                TV = TQ.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                TV.setAccessible(true);
                TW = TQ.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                TW.setAccessible(true);
                TX = TQ.getDeclaredMethod("build", new Class[0]);
                TX.setAccessible(true);
                TY = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                TY.setAccessible(true);
                TZ = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                TZ.setAccessible(true);
                Ua = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                Ua.setAccessible(true);
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

    public static boolean cr(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cr(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void g(JSONObject jSONObject) {
        this.id = b.e(jSONObject, "id");
        this.name = b.e(jSONObject, "name");
        this.type = b.e(jSONObject, "type");
        if (isText()) {
            this.TO.setMeasureFunction(this.Ub);
        }
        this.Uc = b.e(jSONObject, "component");
        this.src = b.e(jSONObject, "src");
        this.TD = b.e(jSONObject, "poster");
        this.Ud = b.e(jSONObject, "href");
        this.text = b.e(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.Uc) && this.businessConverter != null) {
            this.text = this.businessConverter.cv(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.Ue = jSONObject.optString("data-als-stat");
        this.Uf = jSONObject.optString("data-url-stat");
        this.Ug = jSONObject.optString("data-href-pop");
        this.Uh = b.g(jSONObject, "data-share-num");
        this.Ui = b.g(jSONObject, "data-reply-num");
        this.Uj = b.g(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.Uk = jSONObject.optString("data-share-image");
        this.Ul = jSONObject.optString("data-share-link");
    }

    private void h(JSONObject jSONObject) {
        this.Um = b.e(jSONObject, LivenessRecogActivity.f.a);
        pP();
        this.Un = b.e(jSONObject, "flex-direction");
        pW();
        this.Uo = b.e(jSONObject, "justify-content");
        pV();
        this.Up = b.e(jSONObject, "align-items");
        pU();
        this.Uq = b.e(jSONObject, "align-self");
        pT();
        this.Ur = b.e(jSONObject, "align-content");
        pS();
        this.Us = b.f(jSONObject, "flex");
        pO();
        this.Ut = b.f(jSONObject, "flex-grow");
        pN();
        this.Uu = b.f(jSONObject, "flex-shrink");
        pM();
        this.Uv = b.f(jSONObject, "flex-basis");
        pL();
        this.position = b.e(jSONObject, "position");
        pR();
        this.Uw = b.f(jSONObject, CustomDialogData.POS_LEFT);
        this.Ux = b.f(jSONObject, "top");
        this.Uy = b.f(jSONObject, "right");
        this.Uz = b.f(jSONObject, "bottom");
        pQ();
        this.UB = b.f(jSONObject, "margin");
        pK();
        this.UC = b.f(jSONObject, "margin-left");
        pG();
        this.UD = b.f(jSONObject, "margin-top");
        pJ();
        this.UE = b.f(jSONObject, "margin-right");
        pI();
        this.UF = b.f(jSONObject, "margin-bottom");
        pH();
        this.UG = b.f(jSONObject, "padding");
        initPadding();
        this.UH = b.f(jSONObject, "padding-left");
        pC();
        this.UI = b.f(jSONObject, "padding-top");
        pF();
        this.UJ = b.f(jSONObject, "padding-right");
        pE();
        this.UK = b.f(jSONObject, "padding-bottom");
        pD();
        this.width = b.f(jSONObject, "width");
        pB();
        this.height = b.f(jSONObject, "height");
        pA();
        this.UL = b.f(jSONObject, "min-width");
        pz();
        this.UM = b.f(jSONObject, "min-height");
        py();
        this.UN = b.f(jSONObject, "max-width");
        pv();
        this.UO = b.f(jSONObject, "max-height");
        px();
        this.UQ = b.f(jSONObject, "aspect-ratio");
        pw();
    }

    private void i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.Vm = b.e(optJSONObject, "background-image");
            this.Vn = b.e(optJSONObject, "background-color");
            this.Vo = b.e(optJSONObject, "border-color");
            this.Vp = b.e(optJSONObject, "color");
        }
    }

    private void j(JSONObject jSONObject) {
        this.Vh = b.e(jSONObject, "background-image");
        this.Vi = b.e(jSONObject, "background-color");
        this.Vj = b.e(jSONObject, "border-color");
        this.Vk = b.f(jSONObject, "opacity");
        this.Vl = b.e(jSONObject, "color");
    }

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.Vd = b.e(optJSONObject, "background-image");
            this.Ve = b.e(optJSONObject, "background-color");
            this.Vf = b.e(optJSONObject, "border-color");
            this.Vg = b.e(optJSONObject, "color");
        }
    }

    private void l(JSONObject jSONObject) {
        this.UR = b.e(jSONObject, "background-image");
        this.US = b.e(jSONObject, "background-color");
        this.UT = b.e(jSONObject, "border-color");
        this.UW = b.f(jSONObject, "opacity");
        this.color = b.e(jSONObject, "color");
        this.UU = b.f(jSONObject, "border-width");
        this.UV = b.f(jSONObject, "border-radius");
        this.UX = b.e(jSONObject, "font-style");
        this.UY = b.e(jSONObject, "font-weight");
        this.UZ = Typeface.create(Typeface.DEFAULT, pt());
        this.Va = jSONObject.optDouble("font-size", 12.0d);
        this.Vb = b.e(jSONObject, "text-align");
        this.Vc = b.e(jSONObject, "vertical-align");
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
                this.Vq = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0053a, false);
                    this.Vq.add(aVar);
                    this.TO.addChildAt(aVar.TO, i);
                }
            } else {
                this.Vq = null;
            }
        } else {
            this.Vq = null;
        }
        if (z) {
            this.TM = new CriusNode();
            this.TM.addChildAt(this.TO, 0);
            this.TM.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int pt() {
        return "italic".equalsIgnoreCase(this.UX) ? (TextUtils.isEmpty(this.UY) || "normal".equalsIgnoreCase(this.UY) || !"bold".equalsIgnoreCase(this.UY)) ? 2 : 3 : (TextUtils.isEmpty(this.UY) || "normal".equalsIgnoreCase(this.UY) || !"bold".equalsIgnoreCase(this.UY)) ? 0 : 1;
    }

    private int pu() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.Vb)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.Vb)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.Vb)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.Vc)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.Vc)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.Vc)) {
            return i | 16;
        }
        return i | 0;
    }

    private void pv() {
        if (this.UN >= 0.0d) {
            this.TO.setMaxWidth(g(this.UN));
        } else if (this.UN > -10000.0d) {
            this.TO.setMaxWidth(this.widthPixels);
        }
    }

    private void pw() {
        if (this.UQ > 0.0d) {
            this.TO.setAspectRatio((float) this.UQ);
        }
    }

    private void px() {
        if (this.UO >= 0.0d) {
            this.TO.setMaxHeight(g(this.UO));
        } else if (this.UO > -10000.0d) {
            this.TO.setMaxHeight(this.heightPixels);
        }
    }

    private void py() {
        if (this.UM >= 0.0d) {
            this.TO.setMinHeight(g(this.UM));
        } else if (this.UM > -10000.0d) {
            this.TO.setMinHeight(this.heightPixels);
        }
    }

    private void pz() {
        if (this.UL >= 0.0d) {
            this.TO.setMinWidth(g(this.UL));
        } else if (this.UL > -10000.0d) {
            this.TO.setMinWidth(this.widthPixels);
        }
    }

    private void pA() {
        if (this.height >= 0.0d) {
            this.TO.setHeight(g(this.height));
        } else if (this.height > -10000.0d) {
            this.TO.setHeight(this.heightPixels);
        }
    }

    private void pB() {
        if (this.width >= 0.0d) {
            this.TO.setWidth(g(this.width));
        } else if (this.width > -10000.0d) {
            this.TO.setWidth(this.widthPixels);
        }
    }

    private void pC() {
        if (this.UH >= -1.0d) {
            this.TO.setPadding(CriusEdge.LEFT, g(this.UH));
        }
    }

    private void pD() {
        if (this.UK >= -1.0d) {
            this.TO.setPadding(CriusEdge.BOTTOM, g(this.UK));
        }
    }

    private void pE() {
        if (this.UJ >= -1.0d) {
            this.TO.setPadding(CriusEdge.RIGHT, g(this.UJ));
        }
    }

    private void pF() {
        if (this.UI >= -1.0d) {
            this.TO.setPadding(CriusEdge.TOP, g(this.UI));
        }
    }

    private void initPadding() {
        if (this.UG >= -1.0d) {
            this.TO.setPadding(CriusEdge.ALL, g(this.UG));
        }
    }

    private void pG() {
        if (this.UC >= -1.0d) {
            this.TO.setMargin(CriusEdge.LEFT, g(this.UC));
        }
    }

    private void pH() {
        if (this.UF >= -1.0d) {
            this.TO.setMargin(CriusEdge.BOTTOM, g(this.UF));
        }
    }

    private void pI() {
        if (this.UE >= -1.0d) {
            this.TO.setMargin(CriusEdge.RIGHT, g(this.UE));
        }
    }

    private void pJ() {
        if (this.UD >= -1.0d) {
            this.TO.setMargin(CriusEdge.TOP, g(this.UD));
        }
    }

    private void pK() {
        if (this.UB >= -1.0d) {
            this.TO.setMargin(CriusEdge.ALL, g(this.UB));
        }
    }

    private void pL() {
        if (this.Uv >= -1.0d) {
            this.TO.setFlexBasis(g(this.Uv));
        }
    }

    private void pM() {
        if (this.Uu >= -1.0d) {
            this.TO.setFlexShrink((float) this.Uu);
        }
    }

    private void pN() {
        if (this.Ut >= -1.0d) {
            this.TO.setFlexGrow((float) this.Ut);
        }
    }

    private void pO() {
        if (this.Us >= -1.0d) {
            this.TO.setFlex((float) this.Us);
        }
    }

    private void pP() {
        if (!TextUtils.isEmpty(this.Um)) {
            if ("flex".equalsIgnoreCase(this.Um)) {
                this.TO.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.Um)) {
                this.TO.setDisplay(CriusDisplay.NONE);
            } else {
                this.TO.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void pQ() {
        if (!b.b(this.Uw, -10000.0d)) {
            this.TO.setPosition(CriusEdge.LEFT, g(this.Uw));
        }
        if (!b.b(this.Ux, -10000.0d)) {
            this.TO.setPosition(CriusEdge.TOP, g(this.Ux));
        }
        if (!b.b(this.Uy, -10000.0d)) {
            this.TO.setPosition(CriusEdge.RIGHT, g(this.Uy));
        }
        if (!b.b(this.Uz, -10000.0d)) {
            this.TO.setPosition(CriusEdge.BOTTOM, g(this.Uz));
        }
    }

    private void pR() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.TO.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.TO.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void pS() {
        if (!TextUtils.isEmpty(this.Ur)) {
            if ("flex-start".equalsIgnoreCase(this.Ur)) {
                this.TO.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Ur)) {
                this.TO.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Ur)) {
                this.TO.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Ur)) {
                this.TO.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.Ur)) {
                this.TO.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Ur)) {
                this.TO.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.TO.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void pT() {
        if (!TextUtils.isEmpty(this.Uq)) {
            if ("auto".equalsIgnoreCase(this.Uq)) {
                this.TO.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.Uq)) {
                this.TO.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Uq)) {
                this.TO.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Uq)) {
                this.TO.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Uq)) {
                this.TO.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.TO.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void pU() {
        if (!TextUtils.isEmpty(this.Up)) {
            if ("flex-start".equalsIgnoreCase(this.Up)) {
                this.TO.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Up)) {
                this.TO.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Up)) {
                this.TO.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Up)) {
                this.TO.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.TO.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void pV() {
        if (!TextUtils.isEmpty(this.Uo)) {
            if ("flex-start".equalsIgnoreCase(this.Uo)) {
                this.TO.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Uo)) {
                this.TO.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Uo)) {
                this.TO.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.Uo)) {
                this.TO.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Uo)) {
                this.TO.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.TO.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void pW() {
        if (!TextUtils.isEmpty(this.Un)) {
            if ("column".equalsIgnoreCase(this.Un)) {
                this.TO.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.Un)) {
                this.TO.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.Un)) {
                this.TO.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.Un)) {
                this.TO.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.TO.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.Vq != null && this.Vq.size() > 0) {
                for (a aVar : this.Vq) {
                    a cs = aVar.cs(str);
                    if (cs != null) {
                        return cs;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a ct(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.Uc)) {
            if (this.Vq != null && this.Vq.size() > 0) {
                for (a aVar : this.Vq) {
                    a ct = aVar.ct(str);
                    if (ct != null) {
                        return ct;
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

    public boolean cu(String str) {
        a ct;
        if (this.TM == null || (ct = ct(str)) == null || ct.TO == null) {
            return false;
        }
        ct.TO.setDisplay(CriusDisplay.NONE);
        ct.TO.dirty();
        this.TM.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cs;
        if (this.TM != null && (cs = cs(str)) != null && cs.TO != null) {
            cs.Va = f;
            cs.TO.dirty();
            this.TM.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
