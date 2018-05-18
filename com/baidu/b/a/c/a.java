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
    private static final TextPaint LB = new TextPaint(1);
    private static Class LC;
    private static Method LD;
    private static Method LE;
    private static Method LG;
    private static Method LH;
    private static Method LI;
    private static Method LJ;
    private static Method LK;
    private static Field LM;
    private static Field LN;
    private static Field LO;
    public String LQ;
    public String LR;
    public String LS;
    public String LT;
    public String LU;
    public int LV;
    public int LW;
    public int LX;
    public String LY;
    public String LZ;
    public String Lr;
    private CriusNode Lz;
    private double MA;
    private double MC;
    private double MD;
    public String ME;
    public String MF;
    public String MG;
    public double MH;
    public double MI;
    public double MJ;
    public String MK;
    public String MM;
    public Typeface MN;
    public double MO;
    public String MP;
    public String MQ;
    public String MR;
    public String MS;
    public String MT;
    public String MU;
    public String MV;
    public String MW;
    public String MX;
    public String MZ;
    private String Ma;
    private String Mb;
    private String Mc;
    private String Md;
    private String Me;
    private String Mf;
    private double Mg;
    private double Mh;
    private double Mi;
    private double Mj;
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
    public String Nc;
    public String Nd;
    public final List<a> Ne;
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
    private final CriusMeasureFunction LP = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
        /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
        @Override // com.baidu.crius.CriusMeasureFunction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            Layout layout;
            TextPaint textPaint = a.LB;
            if (a.this.MO >= 0.0d) {
                textPaint.setTextSize((float) (a.this.MO * a.this.density));
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
                        Object invoke = a.LD.invoke(a.LC, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.LE.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.LG.invoke(invoke, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.LH.invoke(invoke, false);
                        Method method = a.LI;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.LM.get(Layout.class) : a.LN.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.LJ.invoke(invoke, a.LO.get(Layout.class));
                        layout = (Layout) a.LK.invoke(invoke, new Object[0]);
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
                        Object invoke2 = a.LD.invoke(a.LC, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                        a.LE.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                        a.LG.invoke(invoke2, Float.valueOf(0.0f), Float.valueOf(1.0f));
                        a.LH.invoke(invoke2, false);
                        Method method2 = a.LI;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.LM.get(Layout.class) : a.LN.get(Layout.class);
                        method2.invoke(invoke2, objArr2);
                        a.LJ.invoke(invoke2, a.LO.get(Layout.class));
                        layout = (Layout) a.LK.invoke(invoke2, new Object[0]);
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
    public double MY = -10000.0d;
    public final CriusNode LA = new CriusNode();

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0042a {
        String bT(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                LC = Class.forName("android.text.StaticLayout$Builder");
                LD = LC.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                LD.setAccessible(true);
                LE = LC.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                LE.setAccessible(true);
                LG = LC.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                LG.setAccessible(true);
                LH = LC.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                LH.setAccessible(true);
                LI = LC.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                LI.setAccessible(true);
                LJ = LC.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                LJ.setAccessible(true);
                LK = LC.getDeclaredMethod("build", new Class[0]);
                LK.setAccessible(true);
                LM = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                LM.setAccessible(true);
                LN = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                LN.setAccessible(true);
                LO = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                LO.setAccessible(true);
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
        if (mH()) {
            this.LA.setMeasureFunction(this.LP);
        }
        this.LQ = b.e(jSONObject, "component");
        this.src = b.e(jSONObject, "src");
        this.Lr = b.e(jSONObject, "poster");
        this.LR = b.e(jSONObject, "href");
        this.text = b.e(jSONObject, "text");
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(this.LQ) && this.businessConverter != null) {
            this.text = this.businessConverter.bT(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.LS = jSONObject.optString("data-als-stat");
        this.LT = jSONObject.optString("data-url-stat");
        this.LU = jSONObject.optString("data-href-pop");
        this.LV = b.g(jSONObject, "data-share-num");
        this.LW = b.g(jSONObject, "data-reply-num");
        this.LX = b.g(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.LY = jSONObject.optString("data-share-image");
        this.LZ = jSONObject.optString("data-share-link");
    }

    private void d(JSONObject jSONObject) {
        this.Ma = b.e(jSONObject, "display");
        mz();
        this.Mb = b.e(jSONObject, "flex-direction");
        mG();
        this.Mc = b.e(jSONObject, "justify-content");
        mF();
        this.Md = b.e(jSONObject, "align-items");
        mE();
        this.Me = b.e(jSONObject, "align-self");
        mD();
        this.Mf = b.e(jSONObject, "align-content");
        mC();
        this.Mg = b.f(jSONObject, "flex");
        my();
        this.Mh = b.f(jSONObject, "flex-grow");
        mx();
        this.Mi = b.f(jSONObject, "flex-shrink");
        mw();
        this.Mj = b.f(jSONObject, "flex-basis");
        mv();
        this.position = b.e(jSONObject, "position");
        mB();
        this.Mk = b.f(jSONObject, CustomDialogData.POS_LEFT);
        this.Ml = b.f(jSONObject, "top");
        this.Mm = b.f(jSONObject, "right");
        this.Mn = b.f(jSONObject, "bottom");
        mA();
        this.Mo = b.f(jSONObject, "margin");
        mu();
        this.Mp = b.f(jSONObject, "margin-left");
        mq();
        this.Mq = b.f(jSONObject, "margin-top");
        mt();
        this.Mr = b.f(jSONObject, "margin-right");
        ms();
        this.Ms = b.f(jSONObject, "margin-bottom");
        mr();
        this.Mt = b.f(jSONObject, "padding");
        initPadding();
        this.Mu = b.f(jSONObject, "padding-left");
        mm();
        this.Mv = b.f(jSONObject, "padding-top");
        mp();
        this.Mw = b.f(jSONObject, "padding-right");
        mo();
        this.Mx = b.f(jSONObject, "padding-bottom");
        mn();
        this.width = b.f(jSONObject, "width");
        ml();
        this.height = b.f(jSONObject, "height");
        mk();
        this.My = b.f(jSONObject, "min-width");
        mj();
        this.Mz = b.f(jSONObject, "min-height");
        mi();
        this.MA = b.f(jSONObject, "max-width");
        mf();
        this.MC = b.f(jSONObject, "max-height");
        mh();
        this.MD = b.f(jSONObject, "aspect-ratio");
        mg();
    }

    private void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.Na = b.e(optJSONObject, "background-image");
            this.Nb = b.e(optJSONObject, "background-color");
            this.Nc = b.e(optJSONObject, "border-color");
            this.Nd = b.e(optJSONObject, "color");
        }
    }

    private void f(JSONObject jSONObject) {
        this.MV = b.e(jSONObject, "background-image");
        this.MW = b.e(jSONObject, "background-color");
        this.MX = b.e(jSONObject, "border-color");
        this.MY = b.f(jSONObject, "opacity");
        this.MZ = b.e(jSONObject, "color");
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.MR = b.e(optJSONObject, "background-image");
            this.MS = b.e(optJSONObject, "background-color");
            this.MT = b.e(optJSONObject, "border-color");
            this.MU = b.e(optJSONObject, "color");
        }
    }

    private void h(JSONObject jSONObject) {
        this.ME = b.e(jSONObject, "background-image");
        this.MF = b.e(jSONObject, "background-color");
        this.MG = b.e(jSONObject, "border-color");
        this.MJ = b.f(jSONObject, "opacity");
        this.color = b.e(jSONObject, "color");
        this.MH = b.f(jSONObject, "border-width");
        this.MI = b.f(jSONObject, "border-radius");
        this.MK = b.e(jSONObject, "font-style");
        this.MM = b.e(jSONObject, "font-weight");
        this.MN = Typeface.create(Typeface.DEFAULT, md());
        this.MO = jSONObject.optDouble("font-size", 12.0d);
        this.MP = b.e(jSONObject, "text-align");
        this.MQ = b.e(jSONObject, "vertical-align");
        this.gravity = me();
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
                this.Ne = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0042a, false);
                    this.Ne.add(aVar);
                    this.LA.addChildAt(aVar.LA, i);
                }
            } else {
                this.Ne = null;
            }
        } else {
            this.Ne = null;
        }
        if (z) {
            this.Lz = new CriusNode();
            this.Lz.addChildAt(this.LA, 0);
            this.Lz.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int md() {
        return "italic".equalsIgnoreCase(this.MK) ? (TextUtils.isEmpty(this.MM) || "normal".equalsIgnoreCase(this.MM) || !"bold".equalsIgnoreCase(this.MM)) ? 2 : 3 : (TextUtils.isEmpty(this.MM) || "normal".equalsIgnoreCase(this.MM) || !"bold".equalsIgnoreCase(this.MM)) ? 0 : 1;
    }

    private int me() {
        int i;
        if (CustomDialogData.POS_LEFT.equalsIgnoreCase(this.MP)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.MP)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.MP)) {
            i = 1;
        } else {
            i = 0;
        }
        if ("top".equalsIgnoreCase(this.MQ)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.MQ)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.MQ)) {
            return i | 16;
        }
        return i | 0;
    }

    private void mf() {
        if (this.MA >= 0.0d) {
            this.LA.setMaxWidth(f(this.MA));
        } else if (this.MA > -10000.0d) {
            this.LA.setMaxWidth(this.widthPixels);
        }
    }

    private void mg() {
        if (this.MD > 0.0d) {
            this.LA.setAspectRatio((float) this.MD);
        }
    }

    private void mh() {
        if (this.MC >= 0.0d) {
            this.LA.setMaxHeight(f(this.MC));
        } else if (this.MC > -10000.0d) {
            this.LA.setMaxHeight(this.heightPixels);
        }
    }

    private void mi() {
        if (this.Mz >= 0.0d) {
            this.LA.setMinHeight(f(this.Mz));
        } else if (this.Mz > -10000.0d) {
            this.LA.setMinHeight(this.heightPixels);
        }
    }

    private void mj() {
        if (this.My >= 0.0d) {
            this.LA.setMinWidth(f(this.My));
        } else if (this.My > -10000.0d) {
            this.LA.setMinWidth(this.widthPixels);
        }
    }

    private void mk() {
        if (this.height >= 0.0d) {
            this.LA.setHeight(f(this.height));
        } else if (this.height > -10000.0d) {
            this.LA.setHeight(this.heightPixels);
        }
    }

    private void ml() {
        if (this.width >= 0.0d) {
            this.LA.setWidth(f(this.width));
        } else if (this.width > -10000.0d) {
            this.LA.setWidth(this.widthPixels);
        }
    }

    private void mm() {
        if (this.Mu >= -1.0d) {
            this.LA.setPadding(CriusEdge.LEFT, f(this.Mu));
        }
    }

    private void mn() {
        if (this.Mx >= -1.0d) {
            this.LA.setPadding(CriusEdge.BOTTOM, f(this.Mx));
        }
    }

    private void mo() {
        if (this.Mw >= -1.0d) {
            this.LA.setPadding(CriusEdge.RIGHT, f(this.Mw));
        }
    }

    private void mp() {
        if (this.Mv >= -1.0d) {
            this.LA.setPadding(CriusEdge.TOP, f(this.Mv));
        }
    }

    private void initPadding() {
        if (this.Mt >= -1.0d) {
            this.LA.setPadding(CriusEdge.ALL, f(this.Mt));
        }
    }

    private void mq() {
        if (this.Mp >= -1.0d) {
            this.LA.setMargin(CriusEdge.LEFT, f(this.Mp));
        }
    }

    private void mr() {
        if (this.Ms >= -1.0d) {
            this.LA.setMargin(CriusEdge.BOTTOM, f(this.Ms));
        }
    }

    private void ms() {
        if (this.Mr >= -1.0d) {
            this.LA.setMargin(CriusEdge.RIGHT, f(this.Mr));
        }
    }

    private void mt() {
        if (this.Mq >= -1.0d) {
            this.LA.setMargin(CriusEdge.TOP, f(this.Mq));
        }
    }

    private void mu() {
        if (this.Mo >= -1.0d) {
            this.LA.setMargin(CriusEdge.ALL, f(this.Mo));
        }
    }

    private void mv() {
        if (this.Mj >= -1.0d) {
            this.LA.setFlexBasis(f(this.Mj));
        }
    }

    private void mw() {
        if (this.Mi >= -1.0d) {
            this.LA.setFlexShrink((float) this.Mi);
        }
    }

    private void mx() {
        if (this.Mh >= -1.0d) {
            this.LA.setFlexGrow((float) this.Mh);
        }
    }

    private void my() {
        if (this.Mg >= -1.0d) {
            this.LA.setFlex((float) this.Mg);
        }
    }

    private void mz() {
        if (!TextUtils.isEmpty(this.Ma)) {
            if ("flex".equalsIgnoreCase(this.Ma)) {
                this.LA.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.Ma)) {
                this.LA.setDisplay(CriusDisplay.NONE);
            } else {
                this.LA.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void mA() {
        if (!b.b(this.Mk, -10000.0d)) {
            this.LA.setPosition(CriusEdge.LEFT, f(this.Mk));
        }
        if (!b.b(this.Ml, -10000.0d)) {
            this.LA.setPosition(CriusEdge.TOP, f(this.Ml));
        }
        if (!b.b(this.Mm, -10000.0d)) {
            this.LA.setPosition(CriusEdge.RIGHT, f(this.Mm));
        }
        if (!b.b(this.Mn, -10000.0d)) {
            this.LA.setPosition(CriusEdge.BOTTOM, f(this.Mn));
        }
    }

    private void mB() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.LA.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.LA.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void mC() {
        if (!TextUtils.isEmpty(this.Mf)) {
            if ("flex-start".equalsIgnoreCase(this.Mf)) {
                this.LA.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Mf)) {
                this.LA.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Mf)) {
                this.LA.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Mf)) {
                this.LA.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.Mf)) {
                this.LA.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Mf)) {
                this.LA.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.LA.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void mD() {
        if (!TextUtils.isEmpty(this.Me)) {
            if ("auto".equalsIgnoreCase(this.Me)) {
                this.LA.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.Me)) {
                this.LA.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Me)) {
                this.LA.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Me)) {
                this.LA.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Me)) {
                this.LA.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.LA.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void mE() {
        if (!TextUtils.isEmpty(this.Md)) {
            if ("flex-start".equalsIgnoreCase(this.Md)) {
                this.LA.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Md)) {
                this.LA.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Md)) {
                this.LA.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Md)) {
                this.LA.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.LA.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void mF() {
        if (!TextUtils.isEmpty(this.Mc)) {
            if ("flex-start".equalsIgnoreCase(this.Mc)) {
                this.LA.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Mc)) {
                this.LA.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Mc)) {
                this.LA.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.Mc)) {
                this.LA.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Mc)) {
                this.LA.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.LA.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void mG() {
        if (!TextUtils.isEmpty(this.Mb)) {
            if ("column".equalsIgnoreCase(this.Mb)) {
                this.LA.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.Mb)) {
                this.LA.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.Mb)) {
                this.LA.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.Mb)) {
                this.LA.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.LA.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean mH() {
        return "text".equals(this.type);
    }

    public a bQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.Ne != null && this.Ne.size() > 0) {
                for (a aVar : this.Ne) {
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
        if (!str.equalsIgnoreCase(this.LQ)) {
            if (this.Ne != null && this.Ne.size() > 0) {
                for (a aVar : this.Ne) {
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
        if (this.Lz == null || (bR = bR(str)) == null || bR.LA == null) {
            return false;
        }
        bR.LA.setDisplay(CriusDisplay.NONE);
        bR.LA.dirty();
        this.Lz.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a bQ;
        if (this.Lz != null && (bQ = bQ(str)) != null && bQ.LA != null) {
            bQ.MO = f;
            bQ.LA.dirty();
            this.Lz.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
