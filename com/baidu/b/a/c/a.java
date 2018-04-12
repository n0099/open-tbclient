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
    private static final TextPaint LG = new TextPaint(1);
    private static Class LH;
    private static Method LI;
    private static Method LJ;
    private static Method LK;
    private static Method LM;
    private static Method LN;
    private static Method LO;
    private static Method LP;
    private static Field LQ;
    private static Field LR;
    private static Field LS;
    private CriusNode LD;
    public String LU;
    public String LV;
    public String LW;
    public String LX;
    public String LY;
    public int LZ;
    public String Lv;
    private double MA;
    private double MC;
    private double MD;
    private double ME;
    private double MF;
    private double MG;
    private double MH;
    public String MI;
    public String MJ;
    public String MK;
    public double MM;
    public double MN;
    public double MO;
    public String MP;
    public String MQ;
    public Typeface MR;
    public double MS;
    public String MT;
    public String MU;
    public String MV;
    public String MW;
    public String MX;
    public String MY;
    public String MZ;
    public int Ma;
    public int Mb;
    public String Mc;
    public String Md;
    private String Me;
    private String Mf;
    private String Mg;
    private String Mh;
    private String Mi;
    private String Mj;
    private double Mk;
    private double Ml;
    private double Mm;
    private double Mn;
    private double Mo;
    private double Mp;
    private double Mq;
    private double Mr;
    private double Ms;
    private double Mt;
    private double Mu;
    private double Mv;
    private double Mw;
    private double Mx;
    private double My;
    private double Mz;
    public String Na;
    public String Nb;
    public String Nd;
    public String Ne;
    public String Nf;
    public String Ng;
    public String Nh;
    public final List<a> Ni;
    private InterfaceC0042a businessConverter;
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
    private final CriusMeasureFunction LT = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
        @Override // com.baidu.crius.CriusMeasureFunction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            Layout layout;
            TextPaint textPaint = a.LG;
            if (a.this.MS >= 0.0d) {
                textPaint.setTextSize((float) (a.this.MS * a.this.density));
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
                        Object invoke = a.LI.invoke(a.LH, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.LJ.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.LK.invoke(invoke, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.LM.invoke(invoke, false);
                        Method method = a.LN;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.LQ.get(Layout.class) : a.LR.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.LO.invoke(invoke, a.LS.get(Layout.class));
                        layout = (Layout) a.LP.invoke(invoke, new Object[0]);
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
                        Object invoke2 = a.LI.invoke(a.LH, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                        a.LJ.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                        a.LK.invoke(invoke2, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.LM.invoke(invoke2, false);
                        Method method2 = a.LN;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.LQ.get(Layout.class) : a.LR.get(Layout.class);
                        method2.invoke(invoke2, objArr2);
                        a.LO.invoke(invoke2, a.LS.get(Layout.class));
                        layout = (Layout) a.LP.invoke(invoke2, new Object[0]);
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
                    return CriusMeasureOutput.make(a.this.N(layout.getWidth()), a.this.M(layout.getLineBottom(a.this.maxLines - 1)));
                }
                if (layout == null) {
                    return CriusMeasureOutput.make(a.this.N(layout.getWidth()), a.this.M(layout.getHeight()));
                }
                return CriusMeasureOutput.make(f, f2);
            }
        }
    };
    public double Nc = -10000.0d;
    public final CriusNode LE = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0042a {
        String bT(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                LH = Class.forName("android.text.StaticLayout$Builder");
                LI = LH.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                LI.setAccessible(true);
                LJ = LH.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                LJ.setAccessible(true);
                LK = LH.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                LK.setAccessible(true);
                LM = LH.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                LM.setAccessible(true);
                LN = LH.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                LN.setAccessible(true);
                LO = LH.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                LO.setAccessible(true);
                LP = LH.getDeclaredMethod("build", new Class[0]);
                LP.setAccessible(true);
                LQ = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                LQ.setAccessible(true);
                LR = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                LR.setAccessible(true);
                LS = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                LS.setAccessible(true);
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

    public static boolean bP(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float M(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.06f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float N(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && bP(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void c(JSONObject jSONObject) {
        this.id = b.e(jSONObject, "id");
        this.name = b.e(jSONObject, "name");
        this.type = b.e(jSONObject, "type");
        if (mI()) {
            this.LE.setMeasureFunction(this.LT);
        }
        this.LU = b.e(jSONObject, "component");
        this.src = b.e(jSONObject, "src");
        this.Lv = b.e(jSONObject, "poster");
        this.LV = b.e(jSONObject, "href");
        this.text = b.e(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.LU) && this.businessConverter != null) {
            this.text = this.businessConverter.bT(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.LW = jSONObject.optString("data-als-stat");
        this.LX = jSONObject.optString("data-url-stat");
        this.LY = jSONObject.optString("data-href-pop");
        this.LZ = b.g(jSONObject, "data-share-num");
        this.Ma = b.g(jSONObject, "data-reply-num");
        this.Mb = b.g(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.Mc = jSONObject.optString("data-share-image");
        this.Md = jSONObject.optString("data-share-link");
    }

    private void d(JSONObject jSONObject) {
        this.Me = b.e(jSONObject, "display");
        mA();
        this.Mf = b.e(jSONObject, "flex-direction");
        mH();
        this.Mg = b.e(jSONObject, "justify-content");
        mG();
        this.Mh = b.e(jSONObject, "align-items");
        mF();
        this.Mi = b.e(jSONObject, "align-self");
        mE();
        this.Mj = b.e(jSONObject, "align-content");
        mD();
        this.Mk = b.f(jSONObject, "flex");
        mz();
        this.Ml = b.f(jSONObject, "flex-grow");
        my();
        this.Mm = b.f(jSONObject, "flex-shrink");
        mx();
        this.Mn = b.f(jSONObject, "flex-basis");
        mw();
        this.position = b.e(jSONObject, "position");
        mC();
        this.Mo = b.f(jSONObject, CustomDialogData.POS_LEFT);
        this.Mp = b.f(jSONObject, "top");
        this.Mq = b.f(jSONObject, "right");
        this.Mr = b.f(jSONObject, "bottom");
        mB();
        this.Ms = b.f(jSONObject, "margin");
        mv();
        this.Mt = b.f(jSONObject, "margin-left");
        mr();
        this.Mu = b.f(jSONObject, "margin-top");
        mu();
        this.Mv = b.f(jSONObject, "margin-right");
        mt();
        this.Mw = b.f(jSONObject, "margin-bottom");
        ms();
        this.Mx = b.f(jSONObject, "padding");
        initPadding();
        this.My = b.f(jSONObject, "padding-left");
        mn();
        this.Mz = b.f(jSONObject, "padding-top");
        mq();
        this.MA = b.f(jSONObject, "padding-right");
        mp();
        this.MC = b.f(jSONObject, "padding-bottom");
        mo();
        this.width = b.f(jSONObject, "width");
        mm();
        this.height = b.f(jSONObject, "height");
        ml();
        this.MD = b.f(jSONObject, "min-width");
        mk();
        this.ME = b.f(jSONObject, "min-height");
        mj();
        this.MF = b.f(jSONObject, "max-width");
        mg();
        this.MG = b.f(jSONObject, "max-height");
        mi();
        this.MH = b.f(jSONObject, "aspect-ratio");
        mh();
    }

    private void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.Ne = b.e(optJSONObject, "background-image");
            this.Nf = b.e(optJSONObject, "background-color");
            this.Ng = b.e(optJSONObject, "border-color");
            this.Nh = b.e(optJSONObject, "color");
        }
    }

    private void f(JSONObject jSONObject) {
        this.MZ = b.e(jSONObject, "background-image");
        this.Na = b.e(jSONObject, "background-color");
        this.Nb = b.e(jSONObject, "border-color");
        this.Nc = b.f(jSONObject, "opacity");
        this.Nd = b.e(jSONObject, "color");
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.MV = b.e(optJSONObject, "background-image");
            this.MW = b.e(optJSONObject, "background-color");
            this.MX = b.e(optJSONObject, "border-color");
            this.MY = b.e(optJSONObject, "color");
        }
    }

    private void h(JSONObject jSONObject) {
        this.MI = b.e(jSONObject, "background-image");
        this.MJ = b.e(jSONObject, "background-color");
        this.MK = b.e(jSONObject, "border-color");
        this.MO = b.f(jSONObject, "opacity");
        this.color = b.e(jSONObject, "color");
        this.MM = b.f(jSONObject, "border-width");
        this.MN = b.f(jSONObject, "border-radius");
        this.MP = b.e(jSONObject, "font-style");
        this.MQ = b.e(jSONObject, "font-weight");
        this.MR = Typeface.create(Typeface.DEFAULT, me());
        this.MS = jSONObject.optDouble("font-size", 12.0d);
        this.MT = b.e(jSONObject, "text-align");
        this.MU = b.e(jSONObject, "vertical-align");
        this.gravity = mf();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0042a interfaceC0042a, boolean z) {
        this.businessConverter = interfaceC0042a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        this.heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        c(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            d(optJSONObject);
            h(optJSONObject);
            g(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            f(optJSONObject2);
            e(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.Ni = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0042a, false);
                    this.Ni.add(aVar);
                    this.LE.addChildAt(aVar.LE, i);
                }
            } else {
                this.Ni = null;
            }
        } else {
            this.Ni = null;
        }
        if (z) {
            this.LD = new CriusNode();
            this.LD.addChildAt(this.LE, 0);
            this.LD.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int me() {
        return "italic".equalsIgnoreCase(this.MP) ? (TextUtils.isEmpty(this.MQ) || "normal".equalsIgnoreCase(this.MQ) || !"bold".equalsIgnoreCase(this.MQ)) ? 2 : 3 : (TextUtils.isEmpty(this.MQ) || "normal".equalsIgnoreCase(this.MQ) || !"bold".equalsIgnoreCase(this.MQ)) ? 0 : 1;
    }

    private int mf() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.MT)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.MT)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.MT)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.MU)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.MU)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.MU)) {
            return i | 16;
        }
        return i | 0;
    }

    private void mg() {
        if (this.MF >= 0.0d) {
            this.LE.setMaxWidth(f(this.MF));
        } else if (this.MF > -10000.0d) {
            this.LE.setMaxWidth(this.widthPixels);
        }
    }

    private void mh() {
        if (this.MH > 0.0d) {
            this.LE.setAspectRatio((float) this.MH);
        }
    }

    private void mi() {
        if (this.MG >= 0.0d) {
            this.LE.setMaxHeight(f(this.MG));
        } else if (this.MG > -10000.0d) {
            this.LE.setMaxHeight(this.heightPixels);
        }
    }

    private void mj() {
        if (this.ME >= 0.0d) {
            this.LE.setMinHeight(f(this.ME));
        } else if (this.ME > -10000.0d) {
            this.LE.setMinHeight(this.heightPixels);
        }
    }

    private void mk() {
        if (this.MD >= 0.0d) {
            this.LE.setMinWidth(f(this.MD));
        } else if (this.MD > -10000.0d) {
            this.LE.setMinWidth(this.widthPixels);
        }
    }

    private void ml() {
        if (this.height >= 0.0d) {
            this.LE.setHeight(f(this.height));
        } else if (this.height > -10000.0d) {
            this.LE.setHeight(this.heightPixels);
        }
    }

    private void mm() {
        if (this.width >= 0.0d) {
            this.LE.setWidth(f(this.width));
        } else if (this.width > -10000.0d) {
            this.LE.setWidth(this.widthPixels);
        }
    }

    private void mn() {
        if (this.My >= -1.0d) {
            this.LE.setPadding(CriusEdge.LEFT, f(this.My));
        }
    }

    private void mo() {
        if (this.MC >= -1.0d) {
            this.LE.setPadding(CriusEdge.BOTTOM, f(this.MC));
        }
    }

    private void mp() {
        if (this.MA >= -1.0d) {
            this.LE.setPadding(CriusEdge.RIGHT, f(this.MA));
        }
    }

    private void mq() {
        if (this.Mz >= -1.0d) {
            this.LE.setPadding(CriusEdge.TOP, f(this.Mz));
        }
    }

    private void initPadding() {
        if (this.Mx >= -1.0d) {
            this.LE.setPadding(CriusEdge.ALL, f(this.Mx));
        }
    }

    private void mr() {
        if (this.Mt >= -1.0d) {
            this.LE.setMargin(CriusEdge.LEFT, f(this.Mt));
        }
    }

    private void ms() {
        if (this.Mw >= -1.0d) {
            this.LE.setMargin(CriusEdge.BOTTOM, f(this.Mw));
        }
    }

    private void mt() {
        if (this.Mv >= -1.0d) {
            this.LE.setMargin(CriusEdge.RIGHT, f(this.Mv));
        }
    }

    private void mu() {
        if (this.Mu >= -1.0d) {
            this.LE.setMargin(CriusEdge.TOP, f(this.Mu));
        }
    }

    private void mv() {
        if (this.Ms >= -1.0d) {
            this.LE.setMargin(CriusEdge.ALL, f(this.Ms));
        }
    }

    private void mw() {
        if (this.Mn >= -1.0d) {
            this.LE.setFlexBasis(f(this.Mn));
        }
    }

    private void mx() {
        if (this.Mm >= -1.0d) {
            this.LE.setFlexShrink((float) this.Mm);
        }
    }

    private void my() {
        if (this.Ml >= -1.0d) {
            this.LE.setFlexGrow((float) this.Ml);
        }
    }

    private void mz() {
        if (this.Mk >= -1.0d) {
            this.LE.setFlex((float) this.Mk);
        }
    }

    private void mA() {
        if (!TextUtils.isEmpty(this.Me)) {
            if ("flex".equalsIgnoreCase(this.Me)) {
                this.LE.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.Me)) {
                this.LE.setDisplay(CriusDisplay.NONE);
            } else {
                this.LE.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void mB() {
        if (!b.b(this.Mo, -10000.0d)) {
            this.LE.setPosition(CriusEdge.LEFT, f(this.Mo));
        }
        if (!b.b(this.Mp, -10000.0d)) {
            this.LE.setPosition(CriusEdge.TOP, f(this.Mp));
        }
        if (!b.b(this.Mq, -10000.0d)) {
            this.LE.setPosition(CriusEdge.RIGHT, f(this.Mq));
        }
        if (!b.b(this.Mr, -10000.0d)) {
            this.LE.setPosition(CriusEdge.BOTTOM, f(this.Mr));
        }
    }

    private void mC() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.LE.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.LE.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void mD() {
        if (!TextUtils.isEmpty(this.Mj)) {
            if ("flex-start".equalsIgnoreCase(this.Mj)) {
                this.LE.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Mj)) {
                this.LE.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Mj)) {
                this.LE.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Mj)) {
                this.LE.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.Mj)) {
                this.LE.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Mj)) {
                this.LE.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.LE.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void mE() {
        if (!TextUtils.isEmpty(this.Mi)) {
            if ("auto".equalsIgnoreCase(this.Mi)) {
                this.LE.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.Mi)) {
                this.LE.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Mi)) {
                this.LE.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Mi)) {
                this.LE.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Mi)) {
                this.LE.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.LE.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void mF() {
        if (!TextUtils.isEmpty(this.Mh)) {
            if ("flex-start".equalsIgnoreCase(this.Mh)) {
                this.LE.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Mh)) {
                this.LE.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Mh)) {
                this.LE.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Mh)) {
                this.LE.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.LE.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void mG() {
        if (!TextUtils.isEmpty(this.Mg)) {
            if ("flex-start".equalsIgnoreCase(this.Mg)) {
                this.LE.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Mg)) {
                this.LE.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Mg)) {
                this.LE.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.Mg)) {
                this.LE.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Mg)) {
                this.LE.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.LE.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void mH() {
        if (!TextUtils.isEmpty(this.Mf)) {
            if ("column".equalsIgnoreCase(this.Mf)) {
                this.LE.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.Mf)) {
                this.LE.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.Mf)) {
                this.LE.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.Mf)) {
                this.LE.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.LE.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean mI() {
        return "text".equals(this.type);
    }

    public a bQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.Ni != null && this.Ni.size() > 0) {
                for (a aVar : this.Ni) {
                    a bQ = aVar.bQ(str);
                    if (bQ != null) {
                        return bQ;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a bR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.LU)) {
            if (this.Ni != null && this.Ni.size() > 0) {
                for (a aVar : this.Ni) {
                    a bR = aVar.bR(str);
                    if (bR != null) {
                        return bR;
                    }
                }
            }
            return null;
        }
        return this;
    }

    private float f(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.density * d);
    }

    public float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean bS(String str) {
        a bR;
        if (this.LD == null || (bR = bR(str)) == null || bR.LE == null) {
            return false;
        }
        bR.LE.setDisplay(CriusDisplay.NONE);
        bR.LE.dirty();
        this.LD.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a bQ;
        if (this.LD != null && (bQ = bQ(str)) != null && bQ.LE != null) {
            bQ.MS = f;
            bQ.LE.dirty();
            this.LD.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
