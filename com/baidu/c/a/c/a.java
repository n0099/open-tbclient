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
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private static final TextPaint aaR = new TextPaint(1);
    private static Class aaS;
    private static Method aaT;
    private static Method aaU;
    private static Method aaV;
    private static Method aaW;
    private static Method aaX;
    private static Method aaY;
    private static Method aaZ;
    private static Field aba;
    private static Field abb;
    private static Field abd;
    public String aaH;
    private CriusNode aaP;
    private double abA;
    private double abB;
    private double abC;
    private double abD;
    private double abE;
    private double abF;
    private double abG;
    private double abH;
    private double abI;
    private double abJ;
    private double abK;
    private double abL;
    private double abM;
    private double abN;
    private double abO;
    private double abP;
    private double abQ;
    private double abR;
    private double abS;
    private double abT;
    public String abU;
    public String abV;
    public String abW;
    public double abX;
    public double abY;
    public double abZ;
    public String abf;
    public String abg;
    public String abh;
    public String abi;
    public String abj;
    public int abk;
    public int abl;
    public int abm;
    public String abn;
    public String abo;
    public double abp;
    private String abq;
    private String abr;
    private String abt;
    private String abu;
    private String abv;
    private String abw;
    private double abx;
    private double aby;
    private double abz;
    public String aca;
    public String acb;
    public Typeface acc;
    public double acd;
    public String ace;
    public String acf;
    public String acg;
    public String ach;
    public String aci;
    public String acj;
    public String ack;
    public String acl;
    public String acm;
    public String aco;
    public String acp;
    public String acq;
    public String acr;
    public String acs;
    public final List<a> act;
    private InterfaceC0069a businessConverter;
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
    private final CriusMeasureFunction abe = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.aaR;
            if (a.this.acd >= 0.0d) {
                textPaint.setTextSize((float) (a.this.acd * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.abp > 0.0d ? (float) a.this.abp : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.aaT.invoke(a.aaS, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.aaU.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.aaV.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.aaW.invoke(invoke, false);
                        Method method = a.aaX;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.aba.get(Layout.class) : a.abb.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.aaY.invoke(invoke, a.abd.get(Layout.class));
                        layout = (Layout) a.aaZ.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.aaT.invoke(a.aaS, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.aaU.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.aaV.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.aaW.invoke(invoke2, false);
                    Method method2 = a.aaX;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.aba.get(Layout.class) : a.abb.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.aaY.invoke(invoke2, a.abd.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.aaZ.invoke(invoke2, new Object[0]);
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
                return CriusMeasureOutput.make(a.this.Y(layout2.getWidth()), a.this.X(layout2.getLineBottom(a.this.maxLines - 1)) - f3);
            }
            if (layout2 != null) {
                float Y = a.this.Y(layout2.getWidth());
                float X = a.this.X(layout2.getHeight());
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
                        if (lineDescent > 0.0f && X > lineCount) {
                            X -= f3;
                        }
                    }
                }
                return CriusMeasureOutput.make(Y, X);
            }
            return CriusMeasureOutput.make(f, f2);
        }
    };
    public double acn = -10000.0d;
    public final CriusNode aaQ = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0069a {
        String db(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                aaS = Class.forName("android.text.StaticLayout$Builder");
                aaT = aaS.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                aaT.setAccessible(true);
                aaU = aaS.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                aaU.setAccessible(true);
                aaV = aaS.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                aaV.setAccessible(true);
                aaW = aaS.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                aaW.setAccessible(true);
                aaX = aaS.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                aaX.setAccessible(true);
                aaY = aaS.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                aaY.setAccessible(true);
                aaZ = aaS.getDeclaredMethod("build", new Class[0]);
                aaZ.setAccessible(true);
                aba = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                aba.setAccessible(true);
                abb = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                abb.setAccessible(true);
                abd = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                abd.setAccessible(true);
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

    public static boolean cX(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float X(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.06f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float Y(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cX(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void p(JSONObject jSONObject) {
        this.id = b.f(jSONObject, "id");
        this.name = b.f(jSONObject, "name");
        this.type = b.f(jSONObject, "type");
        if (isText()) {
            this.aaQ.setMeasureFunction(this.abe);
        }
        this.abf = b.f(jSONObject, "component");
        this.src = b.f(jSONObject, ImageCoverViewModel.KEY_SRC);
        this.aaH = b.f(jSONObject, "poster");
        this.abg = b.f(jSONObject, "href");
        this.text = b.f(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.abf) && this.businessConverter != null) {
            this.text = this.businessConverter.db(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.abp = b.g(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.abh = jSONObject.optString("data-als-stat");
        this.abi = jSONObject.optString("data-url-stat");
        this.abj = jSONObject.optString("data-href-pop");
        this.abk = b.h(jSONObject, "data-share-num");
        this.abl = b.h(jSONObject, "data-reply-num");
        this.abm = b.h(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.abn = jSONObject.optString("data-share-image");
        this.abo = jSONObject.optString("data-share-link");
    }

    private void q(JSONObject jSONObject) {
        this.abq = b.f(jSONObject, "display");
        sO();
        this.abr = b.f(jSONObject, "flex-direction");
        sV();
        this.abt = b.f(jSONObject, "justify-content");
        sU();
        this.abu = b.f(jSONObject, "align-items");
        sT();
        this.abv = b.f(jSONObject, "align-self");
        sS();
        this.abw = b.f(jSONObject, "align-content");
        sR();
        this.abx = b.g(jSONObject, "flex");
        sN();
        this.aby = b.g(jSONObject, "flex-grow");
        sM();
        this.abz = b.g(jSONObject, "flex-shrink");
        sL();
        this.abA = b.g(jSONObject, "flex-basis");
        sK();
        this.position = b.f(jSONObject, AiAppsNaViewModel.KEY_POSITION);
        sQ();
        this.abB = b.g(jSONObject, "left");
        this.abC = b.g(jSONObject, AiAppsNaViewModel.POSITION_KEY_TOP);
        this.abD = b.g(jSONObject, "right");
        this.abE = b.g(jSONObject, "bottom");
        sP();
        this.abF = b.g(jSONObject, "margin");
        sJ();
        this.abG = b.g(jSONObject, "margin-left");
        sF();
        this.abH = b.g(jSONObject, "margin-top");
        sI();
        this.abI = b.g(jSONObject, "margin-right");
        sH();
        this.abJ = b.g(jSONObject, "margin-bottom");
        sG();
        this.abK = b.g(jSONObject, "padding");
        initPadding();
        this.abL = b.g(jSONObject, "padding-left");
        sB();
        this.abM = b.g(jSONObject, "padding-top");
        sE();
        this.abN = b.g(jSONObject, "padding-right");
        sD();
        this.abO = b.g(jSONObject, "padding-bottom");
        sC();
        this.width = b.g(jSONObject, "width");
        sA();
        this.height = b.g(jSONObject, "height");
        sz();
        this.abP = b.g(jSONObject, "min-width");
        sy();
        this.abQ = b.g(jSONObject, "min-height");
        sx();
        this.abR = b.g(jSONObject, "max-width");
        su();
        this.abS = b.g(jSONObject, "max-height");
        sw();
        this.abT = b.g(jSONObject, "aspect-ratio");
        sv();
    }

    private void r(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acp = b.f(optJSONObject, "background-image");
            this.acq = b.f(optJSONObject, "background-color");
            this.acr = b.f(optJSONObject, "border-color");
            this.acs = b.f(optJSONObject, "color");
        }
    }

    private void s(JSONObject jSONObject) {
        this.ack = b.f(jSONObject, "background-image");
        this.acl = b.f(jSONObject, "background-color");
        this.acm = b.f(jSONObject, "border-color");
        this.acn = b.g(jSONObject, CoverViewHelper.OPACITY);
        this.aco = b.f(jSONObject, "color");
    }

    private void t(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acg = b.f(optJSONObject, "background-image");
            this.ach = b.f(optJSONObject, "background-color");
            this.aci = b.f(optJSONObject, "border-color");
            this.acj = b.f(optJSONObject, "color");
        }
    }

    private void u(JSONObject jSONObject) {
        this.abU = b.f(jSONObject, "background-image");
        this.abV = b.f(jSONObject, "background-color");
        this.abW = b.f(jSONObject, "border-color");
        this.abZ = b.g(jSONObject, CoverViewHelper.OPACITY);
        this.color = b.f(jSONObject, "color");
        this.abX = b.g(jSONObject, "border-width");
        this.abY = b.g(jSONObject, "border-radius");
        this.aca = b.f(jSONObject, "font-style");
        this.acb = b.f(jSONObject, "font-weight");
        this.acc = Typeface.create(Typeface.DEFAULT, ss());
        this.acd = jSONObject.optDouble("font-size", 12.0d);
        this.ace = b.f(jSONObject, "text-align");
        this.acf = b.f(jSONObject, "vertical-align");
        this.gravity = st();
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0069a interfaceC0069a, boolean z) {
        this.businessConverter = interfaceC0069a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        this.heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        p(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            q(optJSONObject);
            u(optJSONObject);
            t(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            s(optJSONObject2);
            r(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.act = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0069a, false);
                    this.act.add(aVar);
                    this.aaQ.addChildAt(aVar.aaQ, i);
                }
            } else {
                this.act = null;
            }
        } else {
            this.act = null;
        }
        if (z) {
            this.aaP = new CriusNode();
            this.aaP.addChildAt(this.aaQ, 0);
            this.aaP.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int ss() {
        return "italic".equalsIgnoreCase(this.aca) ? (TextUtils.isEmpty(this.acb) || "normal".equalsIgnoreCase(this.acb) || !"bold".equalsIgnoreCase(this.acb)) ? 2 : 3 : (TextUtils.isEmpty(this.acb) || "normal".equalsIgnoreCase(this.acb) || !"bold".equalsIgnoreCase(this.acb)) ? 0 : 1;
    }

    private int st() {
        int i;
        if ("left".equalsIgnoreCase(this.ace)) {
            i = 3;
        } else if ("right".equalsIgnoreCase(this.ace)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.ace)) {
            i = 1;
        } else {
            i = 0;
        }
        if (AiAppsNaViewModel.POSITION_KEY_TOP.equalsIgnoreCase(this.acf)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.acf)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.acf)) {
            return i | 16;
        }
        return i | 0;
    }

    private void su() {
        if (this.abR >= 0.0d) {
            this.aaQ.setMaxWidth(e(this.abR));
        } else if (this.abR > -10000.0d) {
            this.aaQ.setMaxWidth(this.widthPixels);
        }
    }

    private void sv() {
        if (this.abT > 0.0d) {
            this.aaQ.setAspectRatio((float) this.abT);
        }
    }

    private void sw() {
        if (this.abS >= 0.0d) {
            this.aaQ.setMaxHeight(e(this.abS));
        } else if (this.abS > -10000.0d) {
            this.aaQ.setMaxHeight(this.heightPixels);
        }
    }

    private void sx() {
        if (this.abQ >= 0.0d) {
            this.aaQ.setMinHeight(e(this.abQ));
        } else if (this.abQ > -10000.0d) {
            this.aaQ.setMinHeight(this.heightPixels);
        }
    }

    private void sy() {
        if (this.abP >= 0.0d) {
            this.aaQ.setMinWidth(e(this.abP));
        } else if (this.abP > -10000.0d) {
            this.aaQ.setMinWidth(this.widthPixels);
        }
    }

    private void sz() {
        if (this.height >= 0.0d) {
            this.aaQ.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.aaQ.setHeight(this.heightPixels);
        }
    }

    private void sA() {
        if (this.width >= 0.0d) {
            this.aaQ.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.aaQ.setWidth(this.widthPixels);
        }
    }

    private void sB() {
        if (this.abL >= -1.0d) {
            this.aaQ.setPadding(CriusEdge.LEFT, e(this.abL));
        }
    }

    private void sC() {
        if (this.abO >= -1.0d) {
            this.aaQ.setPadding(CriusEdge.BOTTOM, e(this.abO));
        }
    }

    private void sD() {
        if (this.abN >= -1.0d) {
            this.aaQ.setPadding(CriusEdge.RIGHT, e(this.abN));
        }
    }

    private void sE() {
        if (this.abM >= -1.0d) {
            this.aaQ.setPadding(CriusEdge.TOP, e(this.abM));
        }
    }

    private void initPadding() {
        if (this.abK >= -1.0d) {
            this.aaQ.setPadding(CriusEdge.ALL, e(this.abK));
        }
    }

    private void sF() {
        if (this.abG >= -1.0d) {
            this.aaQ.setMargin(CriusEdge.LEFT, e(this.abG));
        }
    }

    private void sG() {
        if (this.abJ >= -1.0d) {
            this.aaQ.setMargin(CriusEdge.BOTTOM, e(this.abJ));
        }
    }

    private void sH() {
        if (this.abI >= -1.0d) {
            this.aaQ.setMargin(CriusEdge.RIGHT, e(this.abI));
        }
    }

    private void sI() {
        if (this.abH >= -1.0d) {
            this.aaQ.setMargin(CriusEdge.TOP, e(this.abH));
        }
    }

    private void sJ() {
        if (this.abF >= -1.0d) {
            this.aaQ.setMargin(CriusEdge.ALL, e(this.abF));
        }
    }

    private void sK() {
        if (this.abA >= -1.0d) {
            this.aaQ.setFlexBasis(e(this.abA));
        }
    }

    private void sL() {
        if (this.abz >= -1.0d) {
            this.aaQ.setFlexShrink((float) this.abz);
        }
    }

    private void sM() {
        if (this.aby >= -1.0d) {
            this.aaQ.setFlexGrow((float) this.aby);
        }
    }

    private void sN() {
        if (this.abx >= -1.0d) {
            this.aaQ.setFlex((float) this.abx);
        }
    }

    private void sO() {
        if (!TextUtils.isEmpty(this.abq)) {
            if ("flex".equalsIgnoreCase(this.abq)) {
                this.aaQ.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.abq)) {
                this.aaQ.setDisplay(CriusDisplay.NONE);
            } else {
                this.aaQ.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void sP() {
        if (!b.c(this.abB, -10000.0d)) {
            this.aaQ.setPosition(CriusEdge.LEFT, e(this.abB));
        }
        if (!b.c(this.abC, -10000.0d)) {
            this.aaQ.setPosition(CriusEdge.TOP, e(this.abC));
        }
        if (!b.c(this.abD, -10000.0d)) {
            this.aaQ.setPosition(CriusEdge.RIGHT, e(this.abD));
        }
        if (!b.c(this.abE, -10000.0d)) {
            this.aaQ.setPosition(CriusEdge.BOTTOM, e(this.abE));
        }
    }

    private void sQ() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.aaQ.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.aaQ.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void sR() {
        if (!TextUtils.isEmpty(this.abw)) {
            if ("flex-start".equalsIgnoreCase(this.abw)) {
                this.aaQ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abw)) {
                this.aaQ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abw)) {
                this.aaQ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abw)) {
                this.aaQ.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.abw)) {
                this.aaQ.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abw)) {
                this.aaQ.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.aaQ.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void sS() {
        if (!TextUtils.isEmpty(this.abv)) {
            if ("auto".equalsIgnoreCase(this.abv)) {
                this.aaQ.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.abv)) {
                this.aaQ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abv)) {
                this.aaQ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abv)) {
                this.aaQ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abv)) {
                this.aaQ.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.aaQ.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void sT() {
        if (!TextUtils.isEmpty(this.abu)) {
            if ("flex-start".equalsIgnoreCase(this.abu)) {
                this.aaQ.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abu)) {
                this.aaQ.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abu)) {
                this.aaQ.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abu)) {
                this.aaQ.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.aaQ.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void sU() {
        if (!TextUtils.isEmpty(this.abt)) {
            if ("flex-start".equalsIgnoreCase(this.abt)) {
                this.aaQ.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.abt)) {
                this.aaQ.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abt)) {
                this.aaQ.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.abt)) {
                this.aaQ.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abt)) {
                this.aaQ.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.aaQ.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void sV() {
        if (!TextUtils.isEmpty(this.abr)) {
            if ("column".equalsIgnoreCase(this.abr)) {
                this.aaQ.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.abr)) {
                this.aaQ.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.abr)) {
                this.aaQ.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.abr)) {
                this.aaQ.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.aaQ.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.act != null && this.act.size() > 0) {
                for (a aVar : this.act) {
                    a cY = aVar.cY(str);
                    if (cY != null) {
                        return cY;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.abf)) {
            if (this.act != null && this.act.size() > 0) {
                for (a aVar : this.act) {
                    a cZ = aVar.cZ(str);
                    if (cZ != null) {
                        return cZ;
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

    public boolean da(String str) {
        a cZ;
        if (this.aaP == null || (cZ = cZ(str)) == null || cZ.aaQ == null) {
            return false;
        }
        cZ.aaQ.setDisplay(CriusDisplay.NONE);
        cZ.aaQ.dirty();
        this.aaP.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cY;
        if (this.aaP != null && (cY = cY(str)) != null && cY.aaQ != null) {
            cY.acd = f;
            cY.aaQ.dirty();
            this.aaP.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
