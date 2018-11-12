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
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
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
    private static final TextPaint aaP = new TextPaint(1);
    private static Class aaQ;
    private static Method aaR;
    private static Method aaS;
    private static Method aaT;
    private static Method aaU;
    private static Method aaV;
    private static Method aaW;
    private static Method aaX;
    private static Field aaY;
    private static Field aaZ;
    private static Field aba;
    public String aaH;
    private CriusNode aaN;
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
    public String abR;
    public String abS;
    public String abT;
    public double abU;
    public double abV;
    public double abW;
    public String abX;
    public String abY;
    public Typeface abZ;
    public String abd;
    public String abe;
    public String abf;
    public String abg;
    public String abh;
    public int abi;
    public int abj;
    public int abk;
    public String abl;
    public String abm;
    public double abn;
    private String abo;
    private String abp;
    private String abq;
    private String abr;
    private String abt;
    private double abu;
    private double abv;
    private double abw;
    private double abx;
    private double aby;
    private double abz;
    public double aca;
    public String acb;
    public String acc;
    public String acd;
    public String ace;
    public String acf;
    public String acg;
    public String ach;
    public String aci;
    public String acj;
    public String acl;
    public String acm;
    public String acn;
    public String aco;
    public String acp;
    public final List<a> acq;
    private InterfaceC0069a businessConverter;
    public String color;
    public final float density;
    private String display;
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
    private final CriusMeasureFunction abb = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.aaP;
            if (a.this.aca >= 0.0d) {
                textPaint.setTextSize((float) (a.this.aca * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.abn > 0.0d ? (float) a.this.abn : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.aaR.invoke(a.aaQ, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.aaS.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.aaT.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.aaU.invoke(invoke, false);
                        Method method = a.aaV;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.aaY.get(Layout.class) : a.aaZ.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.aaW.invoke(invoke, a.aba.get(Layout.class));
                        layout = (Layout) a.aaX.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.aaR.invoke(a.aaQ, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.aaS.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.aaT.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.aaU.invoke(invoke2, false);
                    Method method2 = a.aaV;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.aaY.get(Layout.class) : a.aaZ.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.aaW.invoke(invoke2, a.aba.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.aaX.invoke(invoke2, new Object[0]);
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
    public double ack = -10000.0d;
    public final CriusNode aaO = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0069a {
        String cZ(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                aaQ = Class.forName("android.text.StaticLayout$Builder");
                aaR = aaQ.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                aaR.setAccessible(true);
                aaS = aaQ.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                aaS.setAccessible(true);
                aaT = aaQ.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                aaT.setAccessible(true);
                aaU = aaQ.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                aaU.setAccessible(true);
                aaV = aaQ.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                aaV.setAccessible(true);
                aaW = aaQ.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                aaW.setAccessible(true);
                aaX = aaQ.getDeclaredMethod("build", new Class[0]);
                aaX.setAccessible(true);
                aaY = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                aaY.setAccessible(true);
                aaZ = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                aaZ.setAccessible(true);
                aba = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                aba.setAccessible(true);
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

    public static boolean cV(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cV(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void p(JSONObject jSONObject) {
        this.id = b.g(jSONObject, "id");
        this.name = b.g(jSONObject, "name");
        this.type = b.g(jSONObject, "type");
        if (isText()) {
            this.aaO.setMeasureFunction(this.abb);
        }
        this.abd = b.g(jSONObject, "component");
        this.src = b.g(jSONObject, ImageCoverViewModel.KEY_SRC);
        this.aaH = b.g(jSONObject, "poster");
        this.abe = b.g(jSONObject, "href");
        this.text = b.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.abd) && this.businessConverter != null) {
            this.text = this.businessConverter.cZ(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.abn = b.h(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.abf = jSONObject.optString("data-als-stat");
        this.abg = jSONObject.optString("data-url-stat");
        this.abh = jSONObject.optString("data-href-pop");
        this.abi = b.i(jSONObject, "data-share-num");
        this.abj = b.i(jSONObject, "data-reply-num");
        this.abk = b.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.abl = jSONObject.optString("data-share-image");
        this.abm = jSONObject.optString("data-share-link");
    }

    private void q(JSONObject jSONObject) {
        this.display = b.g(jSONObject, "display");
        sL();
        this.abo = b.g(jSONObject, "flex-direction");
        sS();
        this.abp = b.g(jSONObject, "justify-content");
        sR();
        this.abq = b.g(jSONObject, "align-items");
        sQ();
        this.abr = b.g(jSONObject, "align-self");
        sP();
        this.abt = b.g(jSONObject, "align-content");
        sO();
        this.abu = b.h(jSONObject, "flex");
        sK();
        this.abv = b.h(jSONObject, "flex-grow");
        sJ();
        this.abw = b.h(jSONObject, "flex-shrink");
        sI();
        this.abx = b.h(jSONObject, "flex-basis");
        sH();
        this.position = b.g(jSONObject, "position");
        sN();
        this.aby = b.h(jSONObject, "left");
        this.abz = b.h(jSONObject, AiAppsNaViewModel.POSITION_KEY_TOP);
        this.abA = b.h(jSONObject, MarkerModel.SubBase.RIGHT);
        this.abB = b.h(jSONObject, "bottom");
        sM();
        this.abC = b.h(jSONObject, "margin");
        sG();
        this.abD = b.h(jSONObject, "margin-left");
        sC();
        this.abE = b.h(jSONObject, "margin-top");
        sF();
        this.abF = b.h(jSONObject, "margin-right");
        sE();
        this.abG = b.h(jSONObject, "margin-bottom");
        sD();
        this.abH = b.h(jSONObject, "padding");
        initPadding();
        this.abI = b.h(jSONObject, "padding-left");
        sy();
        this.abJ = b.h(jSONObject, "padding-top");
        sB();
        this.abK = b.h(jSONObject, "padding-right");
        sA();
        this.abL = b.h(jSONObject, "padding-bottom");
        sz();
        this.width = b.h(jSONObject, "width");
        sx();
        this.height = b.h(jSONObject, "height");
        sw();
        this.abM = b.h(jSONObject, "min-width");
        sv();
        this.abN = b.h(jSONObject, "min-height");
        su();
        this.abO = b.h(jSONObject, "max-width");
        sr();
        this.abP = b.h(jSONObject, "max-height");
        st();
        this.abQ = b.h(jSONObject, "aspect-ratio");
        ss();
    }

    private void r(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acm = b.g(optJSONObject, "background-image");
            this.acn = b.g(optJSONObject, "background-color");
            this.aco = b.g(optJSONObject, "border-color");
            this.acp = b.g(optJSONObject, "color");
        }
    }

    private void s(JSONObject jSONObject) {
        this.ach = b.g(jSONObject, "background-image");
        this.aci = b.g(jSONObject, "background-color");
        this.acj = b.g(jSONObject, "border-color");
        this.ack = b.h(jSONObject, CoverViewHelper.OPACITY);
        this.acl = b.g(jSONObject, "color");
    }

    private void t(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acd = b.g(optJSONObject, "background-image");
            this.ace = b.g(optJSONObject, "background-color");
            this.acf = b.g(optJSONObject, "border-color");
            this.acg = b.g(optJSONObject, "color");
        }
    }

    private void u(JSONObject jSONObject) {
        this.abR = b.g(jSONObject, "background-image");
        this.abS = b.g(jSONObject, "background-color");
        this.abT = b.g(jSONObject, "border-color");
        this.abW = b.h(jSONObject, CoverViewHelper.OPACITY);
        this.color = b.g(jSONObject, "color");
        this.abU = b.h(jSONObject, "border-width");
        this.abV = b.h(jSONObject, "border-radius");
        this.abX = b.g(jSONObject, "font-style");
        this.abY = b.g(jSONObject, "font-weight");
        this.abZ = Typeface.create(Typeface.DEFAULT, sp());
        this.aca = jSONObject.optDouble("font-size", 12.0d);
        this.acb = b.g(jSONObject, "text-align");
        this.acc = b.g(jSONObject, "vertical-align");
        this.gravity = sq();
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
                this.acq = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0069a, false);
                    this.acq.add(aVar);
                    this.aaO.addChildAt(aVar.aaO, i);
                }
            } else {
                this.acq = null;
            }
        } else {
            this.acq = null;
        }
        if (z) {
            this.aaN = new CriusNode();
            this.aaN.addChildAt(this.aaO, 0);
            this.aaN.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int sp() {
        return "italic".equalsIgnoreCase(this.abX) ? (TextUtils.isEmpty(this.abY) || "normal".equalsIgnoreCase(this.abY) || !"bold".equalsIgnoreCase(this.abY)) ? 2 : 3 : (TextUtils.isEmpty(this.abY) || "normal".equalsIgnoreCase(this.abY) || !"bold".equalsIgnoreCase(this.abY)) ? 0 : 1;
    }

    private int sq() {
        int i;
        if ("left".equalsIgnoreCase(this.acb)) {
            i = 3;
        } else if (MarkerModel.SubBase.RIGHT.equalsIgnoreCase(this.acb)) {
            i = 5;
        } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.acb)) {
            i = 1;
        } else {
            i = 0;
        }
        if (AiAppsNaViewModel.POSITION_KEY_TOP.equalsIgnoreCase(this.acc)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.acc)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.acc)) {
            return i | 16;
        }
        return i | 0;
    }

    private void sr() {
        if (this.abO >= 0.0d) {
            this.aaO.setMaxWidth(e(this.abO));
        } else if (this.abO > -10000.0d) {
            this.aaO.setMaxWidth(this.widthPixels);
        }
    }

    private void ss() {
        if (this.abQ > 0.0d) {
            this.aaO.setAspectRatio((float) this.abQ);
        }
    }

    private void st() {
        if (this.abP >= 0.0d) {
            this.aaO.setMaxHeight(e(this.abP));
        } else if (this.abP > -10000.0d) {
            this.aaO.setMaxHeight(this.heightPixels);
        }
    }

    private void su() {
        if (this.abN >= 0.0d) {
            this.aaO.setMinHeight(e(this.abN));
        } else if (this.abN > -10000.0d) {
            this.aaO.setMinHeight(this.heightPixels);
        }
    }

    private void sv() {
        if (this.abM >= 0.0d) {
            this.aaO.setMinWidth(e(this.abM));
        } else if (this.abM > -10000.0d) {
            this.aaO.setMinWidth(this.widthPixels);
        }
    }

    private void sw() {
        if (this.height >= 0.0d) {
            this.aaO.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.aaO.setHeight(this.heightPixels);
        }
    }

    private void sx() {
        if (this.width >= 0.0d) {
            this.aaO.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.aaO.setWidth(this.widthPixels);
        }
    }

    private void sy() {
        if (this.abI >= -1.0d) {
            this.aaO.setPadding(CriusEdge.LEFT, e(this.abI));
        }
    }

    private void sz() {
        if (this.abL >= -1.0d) {
            this.aaO.setPadding(CriusEdge.BOTTOM, e(this.abL));
        }
    }

    private void sA() {
        if (this.abK >= -1.0d) {
            this.aaO.setPadding(CriusEdge.RIGHT, e(this.abK));
        }
    }

    private void sB() {
        if (this.abJ >= -1.0d) {
            this.aaO.setPadding(CriusEdge.TOP, e(this.abJ));
        }
    }

    private void initPadding() {
        if (this.abH >= -1.0d) {
            this.aaO.setPadding(CriusEdge.ALL, e(this.abH));
        }
    }

    private void sC() {
        if (this.abD >= -1.0d) {
            this.aaO.setMargin(CriusEdge.LEFT, e(this.abD));
        }
    }

    private void sD() {
        if (this.abG >= -1.0d) {
            this.aaO.setMargin(CriusEdge.BOTTOM, e(this.abG));
        }
    }

    private void sE() {
        if (this.abF >= -1.0d) {
            this.aaO.setMargin(CriusEdge.RIGHT, e(this.abF));
        }
    }

    private void sF() {
        if (this.abE >= -1.0d) {
            this.aaO.setMargin(CriusEdge.TOP, e(this.abE));
        }
    }

    private void sG() {
        if (this.abC >= -1.0d) {
            this.aaO.setMargin(CriusEdge.ALL, e(this.abC));
        }
    }

    private void sH() {
        if (this.abx >= -1.0d) {
            this.aaO.setFlexBasis(e(this.abx));
        }
    }

    private void sI() {
        if (this.abw >= -1.0d) {
            this.aaO.setFlexShrink((float) this.abw);
        }
    }

    private void sJ() {
        if (this.abv >= -1.0d) {
            this.aaO.setFlexGrow((float) this.abv);
        }
    }

    private void sK() {
        if (this.abu >= -1.0d) {
            this.aaO.setFlex((float) this.abu);
        }
    }

    private void sL() {
        if (!TextUtils.isEmpty(this.display)) {
            if ("flex".equalsIgnoreCase(this.display)) {
                this.aaO.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.display)) {
                this.aaO.setDisplay(CriusDisplay.NONE);
            } else {
                this.aaO.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void sM() {
        if (!b.b(this.aby, -10000.0d)) {
            this.aaO.setPosition(CriusEdge.LEFT, e(this.aby));
        }
        if (!b.b(this.abz, -10000.0d)) {
            this.aaO.setPosition(CriusEdge.TOP, e(this.abz));
        }
        if (!b.b(this.abA, -10000.0d)) {
            this.aaO.setPosition(CriusEdge.RIGHT, e(this.abA));
        }
        if (!b.b(this.abB, -10000.0d)) {
            this.aaO.setPosition(CriusEdge.BOTTOM, e(this.abB));
        }
    }

    private void sN() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.aaO.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.aaO.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void sO() {
        if (!TextUtils.isEmpty(this.abt)) {
            if ("flex-start".equalsIgnoreCase(this.abt)) {
                this.aaO.setAlignSelf(CriusAlign.FLEX_START);
            } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.abt)) {
                this.aaO.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abt)) {
                this.aaO.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abt)) {
                this.aaO.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.abt)) {
                this.aaO.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abt)) {
                this.aaO.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.aaO.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void sP() {
        if (!TextUtils.isEmpty(this.abr)) {
            if ("auto".equalsIgnoreCase(this.abr)) {
                this.aaO.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.abr)) {
                this.aaO.setAlignSelf(CriusAlign.FLEX_START);
            } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.abr)) {
                this.aaO.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abr)) {
                this.aaO.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abr)) {
                this.aaO.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.aaO.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void sQ() {
        if (!TextUtils.isEmpty(this.abq)) {
            if ("flex-start".equalsIgnoreCase(this.abq)) {
                this.aaO.setAlignItems(CriusAlign.FLEX_START);
            } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.abq)) {
                this.aaO.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abq)) {
                this.aaO.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abq)) {
                this.aaO.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.aaO.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void sR() {
        if (!TextUtils.isEmpty(this.abp)) {
            if ("flex-start".equalsIgnoreCase(this.abp)) {
                this.aaO.setJustifyContent(CriusJustify.FLEX_START);
            } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.abp)) {
                this.aaO.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abp)) {
                this.aaO.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.abp)) {
                this.aaO.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abp)) {
                this.aaO.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.aaO.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void sS() {
        if (!TextUtils.isEmpty(this.abo)) {
            if ("column".equalsIgnoreCase(this.abo)) {
                this.aaO.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.abo)) {
                this.aaO.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.abo)) {
                this.aaO.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.abo)) {
                this.aaO.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.aaO.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.acq != null && this.acq.size() > 0) {
                for (a aVar : this.acq) {
                    a cW = aVar.cW(str);
                    if (cW != null) {
                        return cW;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.abd)) {
            if (this.acq != null && this.acq.size() > 0) {
                for (a aVar : this.acq) {
                    a cX = aVar.cX(str);
                    if (cX != null) {
                        return cX;
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

    public boolean cY(String str) {
        a cX;
        if (this.aaN == null || (cX = cX(str)) == null || cX.aaO == null) {
            return false;
        }
        cX.aaO.setDisplay(CriusDisplay.NONE);
        cX.aaO.dirty();
        this.aaN.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cW;
        if (this.aaN != null && (cW = cW(str)) != null && cW.aaO != null) {
            cW.aca = f;
            cW.aaO.dirty();
            this.aaN.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
