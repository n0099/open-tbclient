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
    private static final TextPaint TK = new TextPaint(1);
    private static Class TL;
    private static Method TM;
    private static Method TO;
    private static Method TP;
    private static Method TQ;
    private static Method TR;
    private static Method TS;
    private static Method TT;
    private static Field TU;
    private static Field TV;
    private static Field TW;
    public String TA;
    private CriusNode TI;
    public String TY;
    public String TZ;
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
    public String UM;
    public String UN;
    public String UO;
    public double UQ;
    public double UR;
    public double US;
    public String UT;
    public String UU;
    public Typeface UV;
    public double UW;
    public String UX;
    public String UY;
    public String UZ;
    public String Ua;
    public String Ub;
    public String Uc;
    public int Ud;
    public int Ue;
    public int Uf;
    public String Ug;
    public String Uh;
    private String Ui;
    private String Uj;
    private String Uk;
    private String Ul;
    private String Um;
    private String Un;
    private double Uo;
    private double Up;
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
    public String Vh;
    public String Vi;
    public String Vj;
    public String Vk;
    public String Vl;
    public final List<a> Vm;
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
    private final CriusMeasureFunction TX = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
        @Override // com.baidu.crius.CriusMeasureFunction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            Layout layout;
            TextPaint textPaint = a.TK;
            if (a.this.UW >= 0.0d) {
                textPaint.setTextSize((float) (a.this.UW * a.this.density));
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
                        Object invoke = a.TM.invoke(a.TL, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.TO.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.TP.invoke(invoke, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.TQ.invoke(invoke, false);
                        Method method = a.TR;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.TU.get(Layout.class) : a.TV.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.TS.invoke(invoke, a.TW.get(Layout.class));
                        layout = (Layout) a.TT.invoke(invoke, new Object[0]);
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
                        Object invoke2 = a.TM.invoke(a.TL, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                        a.TO.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                        a.TP.invoke(invoke2, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.TQ.invoke(invoke2, false);
                        Method method2 = a.TR;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.TU.get(Layout.class) : a.TV.get(Layout.class);
                        method2.invoke(invoke2, objArr2);
                        a.TS.invoke(invoke2, a.TW.get(Layout.class));
                        layout = (Layout) a.TT.invoke(invoke2, new Object[0]);
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
    public double Vg = -10000.0d;
    public final CriusNode TJ = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0053a {
        String cw(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                TL = Class.forName("android.text.StaticLayout$Builder");
                TM = TL.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                TM.setAccessible(true);
                TO = TL.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                TO.setAccessible(true);
                TP = TL.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                TP.setAccessible(true);
                TQ = TL.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                TQ.setAccessible(true);
                TR = TL.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                TR.setAccessible(true);
                TS = TL.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                TS.setAccessible(true);
                TT = TL.getDeclaredMethod("build", new Class[0]);
                TT.setAccessible(true);
                TU = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                TU.setAccessible(true);
                TV = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                TV.setAccessible(true);
                TW = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                TW.setAccessible(true);
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

    public static boolean cs(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cs(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void f(JSONObject jSONObject) {
        this.id = b.e(jSONObject, "id");
        this.name = b.e(jSONObject, "name");
        this.type = b.e(jSONObject, "type");
        if (isText()) {
            this.TJ.setMeasureFunction(this.TX);
        }
        this.TY = b.e(jSONObject, "component");
        this.src = b.e(jSONObject, "src");
        this.TA = b.e(jSONObject, "poster");
        this.TZ = b.e(jSONObject, "href");
        this.text = b.e(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.TY) && this.businessConverter != null) {
            this.text = this.businessConverter.cw(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.Ua = jSONObject.optString("data-als-stat");
        this.Ub = jSONObject.optString("data-url-stat");
        this.Uc = jSONObject.optString("data-href-pop");
        this.Ud = b.g(jSONObject, "data-share-num");
        this.Ue = b.g(jSONObject, "data-reply-num");
        this.Uf = b.g(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.Ug = jSONObject.optString("data-share-image");
        this.Uh = jSONObject.optString("data-share-link");
    }

    private void g(JSONObject jSONObject) {
        this.Ui = b.e(jSONObject, LivenessRecogActivity.f.a);
        pQ();
        this.Uj = b.e(jSONObject, "flex-direction");
        pX();
        this.Uk = b.e(jSONObject, "justify-content");
        pW();
        this.Ul = b.e(jSONObject, "align-items");
        pV();
        this.Um = b.e(jSONObject, "align-self");
        pU();
        this.Un = b.e(jSONObject, "align-content");
        pT();
        this.Uo = b.f(jSONObject, "flex");
        pP();
        this.Up = b.f(jSONObject, "flex-grow");
        pO();
        this.Uq = b.f(jSONObject, "flex-shrink");
        pN();
        this.Ur = b.f(jSONObject, "flex-basis");
        pM();
        this.position = b.e(jSONObject, "position");
        pS();
        this.Us = b.f(jSONObject, CustomDialogData.POS_LEFT);
        this.Ut = b.f(jSONObject, "top");
        this.Uu = b.f(jSONObject, "right");
        this.Uv = b.f(jSONObject, "bottom");
        pR();
        this.Uw = b.f(jSONObject, "margin");
        pL();
        this.Ux = b.f(jSONObject, "margin-left");
        pH();
        this.Uy = b.f(jSONObject, "margin-top");
        pK();
        this.Uz = b.f(jSONObject, "margin-right");
        pJ();
        this.UB = b.f(jSONObject, "margin-bottom");
        pI();
        this.UC = b.f(jSONObject, "padding");
        initPadding();
        this.UD = b.f(jSONObject, "padding-left");
        pD();
        this.UE = b.f(jSONObject, "padding-top");
        pG();
        this.UF = b.f(jSONObject, "padding-right");
        pF();
        this.UG = b.f(jSONObject, "padding-bottom");
        pE();
        this.width = b.f(jSONObject, "width");
        pC();
        this.height = b.f(jSONObject, "height");
        pB();
        this.UH = b.f(jSONObject, "min-width");
        pA();
        this.UI = b.f(jSONObject, "min-height");
        pz();
        this.UJ = b.f(jSONObject, "max-width");
        pw();
        this.UK = b.f(jSONObject, "max-height");
        py();
        this.UL = b.f(jSONObject, "aspect-ratio");
        px();
    }

    private void h(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.Vi = b.e(optJSONObject, "background-image");
            this.Vj = b.e(optJSONObject, "background-color");
            this.Vk = b.e(optJSONObject, "border-color");
            this.Vl = b.e(optJSONObject, "color");
        }
    }

    private void i(JSONObject jSONObject) {
        this.Vd = b.e(jSONObject, "background-image");
        this.Ve = b.e(jSONObject, "background-color");
        this.Vf = b.e(jSONObject, "border-color");
        this.Vg = b.f(jSONObject, "opacity");
        this.Vh = b.e(jSONObject, "color");
    }

    private void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.UZ = b.e(optJSONObject, "background-image");
            this.Va = b.e(optJSONObject, "background-color");
            this.Vb = b.e(optJSONObject, "border-color");
            this.Vc = b.e(optJSONObject, "color");
        }
    }

    private void k(JSONObject jSONObject) {
        this.UM = b.e(jSONObject, "background-image");
        this.UN = b.e(jSONObject, "background-color");
        this.UO = b.e(jSONObject, "border-color");
        this.US = b.f(jSONObject, "opacity");
        this.color = b.e(jSONObject, "color");
        this.UQ = b.f(jSONObject, "border-width");
        this.UR = b.f(jSONObject, "border-radius");
        this.UT = b.e(jSONObject, "font-style");
        this.UU = b.e(jSONObject, "font-weight");
        this.UV = Typeface.create(Typeface.DEFAULT, pu());
        this.UW = jSONObject.optDouble("font-size", 12.0d);
        this.UX = b.e(jSONObject, "text-align");
        this.UY = b.e(jSONObject, "vertical-align");
        this.gravity = pv();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0053a interfaceC0053a, boolean z) {
        this.businessConverter = interfaceC0053a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        this.heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        f(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            g(optJSONObject);
            k(optJSONObject);
            j(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            i(optJSONObject2);
            h(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.Vm = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0053a, false);
                    this.Vm.add(aVar);
                    this.TJ.addChildAt(aVar.TJ, i);
                }
            } else {
                this.Vm = null;
            }
        } else {
            this.Vm = null;
        }
        if (z) {
            this.TI = new CriusNode();
            this.TI.addChildAt(this.TJ, 0);
            this.TI.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int pu() {
        return "italic".equalsIgnoreCase(this.UT) ? (TextUtils.isEmpty(this.UU) || "normal".equalsIgnoreCase(this.UU) || !"bold".equalsIgnoreCase(this.UU)) ? 2 : 3 : (TextUtils.isEmpty(this.UU) || "normal".equalsIgnoreCase(this.UU) || !"bold".equalsIgnoreCase(this.UU)) ? 0 : 1;
    }

    private int pv() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.UX)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.UX)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.UX)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.UY)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.UY)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.UY)) {
            return i | 16;
        }
        return i | 0;
    }

    private void pw() {
        if (this.UJ >= 0.0d) {
            this.TJ.setMaxWidth(e(this.UJ));
        } else if (this.UJ > -10000.0d) {
            this.TJ.setMaxWidth(this.widthPixels);
        }
    }

    private void px() {
        if (this.UL > 0.0d) {
            this.TJ.setAspectRatio((float) this.UL);
        }
    }

    private void py() {
        if (this.UK >= 0.0d) {
            this.TJ.setMaxHeight(e(this.UK));
        } else if (this.UK > -10000.0d) {
            this.TJ.setMaxHeight(this.heightPixels);
        }
    }

    private void pz() {
        if (this.UI >= 0.0d) {
            this.TJ.setMinHeight(e(this.UI));
        } else if (this.UI > -10000.0d) {
            this.TJ.setMinHeight(this.heightPixels);
        }
    }

    private void pA() {
        if (this.UH >= 0.0d) {
            this.TJ.setMinWidth(e(this.UH));
        } else if (this.UH > -10000.0d) {
            this.TJ.setMinWidth(this.widthPixels);
        }
    }

    private void pB() {
        if (this.height >= 0.0d) {
            this.TJ.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.TJ.setHeight(this.heightPixels);
        }
    }

    private void pC() {
        if (this.width >= 0.0d) {
            this.TJ.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.TJ.setWidth(this.widthPixels);
        }
    }

    private void pD() {
        if (this.UD >= -1.0d) {
            this.TJ.setPadding(CriusEdge.LEFT, e(this.UD));
        }
    }

    private void pE() {
        if (this.UG >= -1.0d) {
            this.TJ.setPadding(CriusEdge.BOTTOM, e(this.UG));
        }
    }

    private void pF() {
        if (this.UF >= -1.0d) {
            this.TJ.setPadding(CriusEdge.RIGHT, e(this.UF));
        }
    }

    private void pG() {
        if (this.UE >= -1.0d) {
            this.TJ.setPadding(CriusEdge.TOP, e(this.UE));
        }
    }

    private void initPadding() {
        if (this.UC >= -1.0d) {
            this.TJ.setPadding(CriusEdge.ALL, e(this.UC));
        }
    }

    private void pH() {
        if (this.Ux >= -1.0d) {
            this.TJ.setMargin(CriusEdge.LEFT, e(this.Ux));
        }
    }

    private void pI() {
        if (this.UB >= -1.0d) {
            this.TJ.setMargin(CriusEdge.BOTTOM, e(this.UB));
        }
    }

    private void pJ() {
        if (this.Uz >= -1.0d) {
            this.TJ.setMargin(CriusEdge.RIGHT, e(this.Uz));
        }
    }

    private void pK() {
        if (this.Uy >= -1.0d) {
            this.TJ.setMargin(CriusEdge.TOP, e(this.Uy));
        }
    }

    private void pL() {
        if (this.Uw >= -1.0d) {
            this.TJ.setMargin(CriusEdge.ALL, e(this.Uw));
        }
    }

    private void pM() {
        if (this.Ur >= -1.0d) {
            this.TJ.setFlexBasis(e(this.Ur));
        }
    }

    private void pN() {
        if (this.Uq >= -1.0d) {
            this.TJ.setFlexShrink((float) this.Uq);
        }
    }

    private void pO() {
        if (this.Up >= -1.0d) {
            this.TJ.setFlexGrow((float) this.Up);
        }
    }

    private void pP() {
        if (this.Uo >= -1.0d) {
            this.TJ.setFlex((float) this.Uo);
        }
    }

    private void pQ() {
        if (!TextUtils.isEmpty(this.Ui)) {
            if ("flex".equalsIgnoreCase(this.Ui)) {
                this.TJ.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.Ui)) {
                this.TJ.setDisplay(CriusDisplay.NONE);
            } else {
                this.TJ.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void pR() {
        if (!b.b(this.Us, -10000.0d)) {
            this.TJ.setPosition(CriusEdge.LEFT, e(this.Us));
        }
        if (!b.b(this.Ut, -10000.0d)) {
            this.TJ.setPosition(CriusEdge.TOP, e(this.Ut));
        }
        if (!b.b(this.Uu, -10000.0d)) {
            this.TJ.setPosition(CriusEdge.RIGHT, e(this.Uu));
        }
        if (!b.b(this.Uv, -10000.0d)) {
            this.TJ.setPosition(CriusEdge.BOTTOM, e(this.Uv));
        }
    }

    private void pS() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.TJ.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.TJ.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void pT() {
        if (!TextUtils.isEmpty(this.Un)) {
            if ("flex-start".equalsIgnoreCase(this.Un)) {
                this.TJ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Un)) {
                this.TJ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Un)) {
                this.TJ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Un)) {
                this.TJ.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.Un)) {
                this.TJ.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Un)) {
                this.TJ.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.TJ.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void pU() {
        if (!TextUtils.isEmpty(this.Um)) {
            if ("auto".equalsIgnoreCase(this.Um)) {
                this.TJ.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.Um)) {
                this.TJ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Um)) {
                this.TJ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Um)) {
                this.TJ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Um)) {
                this.TJ.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.TJ.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void pV() {
        if (!TextUtils.isEmpty(this.Ul)) {
            if ("flex-start".equalsIgnoreCase(this.Ul)) {
                this.TJ.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Ul)) {
                this.TJ.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Ul)) {
                this.TJ.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Ul)) {
                this.TJ.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.TJ.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void pW() {
        if (!TextUtils.isEmpty(this.Uk)) {
            if ("flex-start".equalsIgnoreCase(this.Uk)) {
                this.TJ.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Uk)) {
                this.TJ.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Uk)) {
                this.TJ.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.Uk)) {
                this.TJ.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Uk)) {
                this.TJ.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.TJ.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void pX() {
        if (!TextUtils.isEmpty(this.Uj)) {
            if ("column".equalsIgnoreCase(this.Uj)) {
                this.TJ.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.Uj)) {
                this.TJ.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.Uj)) {
                this.TJ.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.Uj)) {
                this.TJ.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.TJ.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a ct(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.Vm != null && this.Vm.size() > 0) {
                for (a aVar : this.Vm) {
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

    public a cu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.TY)) {
            if (this.Vm != null && this.Vm.size() > 0) {
                for (a aVar : this.Vm) {
                    a cu = aVar.cu(str);
                    if (cu != null) {
                        return cu;
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

    public boolean cv(String str) {
        a cu;
        if (this.TI == null || (cu = cu(str)) == null || cu.TJ == null) {
            return false;
        }
        cu.TJ.setDisplay(CriusDisplay.NONE);
        cu.TJ.dirty();
        this.TI.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a ct;
        if (this.TI != null && (ct = ct(str)) != null && ct.TJ != null) {
            ct.UW = f;
            ct.TJ.dirty();
            this.TI.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
