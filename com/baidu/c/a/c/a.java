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
    private static final TextPaint aaY = new TextPaint(1);
    private static Class aaZ;
    private static Method aba;
    private static Method abb;
    private static Method abd;
    private static Method abe;
    private static Method abf;
    private static Method abg;
    private static Method abh;
    private static Field abi;
    private static Field abj;
    private static Field abk;
    public String aaQ;
    private CriusNode aaW;
    private String abA;
    private String abB;
    private String abC;
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
    private double abU;
    private double abV;
    private double abW;
    private double abX;
    private double abY;
    private double abZ;
    public String abm;
    public String abn;
    public String abo;
    public String abp;
    public String abq;
    public int abr;
    public int abt;
    public int abu;
    public String abv;
    public String abw;
    public double abx;
    private String aby;
    private String abz;
    public final List<a> acA;
    public String aca;
    public String acb;
    public String acc;
    public double acd;
    public double ace;
    public double acf;
    public String acg;
    public String ach;
    public Typeface aci;
    public double acj;
    public String ack;
    public String acl;
    public String acm;
    public String acn;
    public String aco;
    public String acp;
    public String acq;
    public String acr;
    public String acs;
    public String acu;
    public String acv;
    public String acx;
    public String acy;
    public String acz;
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
    private final CriusMeasureFunction abl = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            boolean z;
            Layout layout;
            TextPaint textPaint = a.aaY;
            if (a.this.acj >= 0.0d) {
                textPaint.setTextSize((float) (a.this.acj * a.this.density));
            }
            Layout layout2 = null;
            SpannableString spannableString = new SpannableString(a.this.text);
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, textPaint) : Float.NaN;
            float f3 = a.this.abx > 0.0d ? (float) a.this.abx : 0.0f;
            boolean z2 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
            if (isBoring == null && (z2 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil(desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    layout = new StaticLayout(spannableString, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, f3, false);
                } else {
                    try {
                        Object invoke = a.aba.invoke(a.aaZ, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf(ceil));
                        a.abb.invoke(invoke, Layout.Alignment.ALIGN_NORMAL);
                        a.abd.invoke(invoke, Float.valueOf(f3), Float.valueOf(1.0f));
                        a.abe.invoke(invoke, false);
                        Method method = a.abf;
                        Object[] objArr = new Object[1];
                        objArr[0] = Build.VERSION.SDK_INT < 23 ? a.abi.get(Layout.class) : a.abj.get(Layout.class);
                        method.invoke(invoke, objArr);
                        a.abg.invoke(invoke, a.abk.get(Layout.class));
                        layout = (Layout) a.abh.invoke(invoke, new Object[0]);
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
                    Object invoke2 = a.aba.invoke(a.aaZ, spannableString, 0, Integer.valueOf(spannableString.length()), textPaint, Integer.valueOf((int) f));
                    a.abb.invoke(invoke2, Layout.Alignment.ALIGN_NORMAL);
                    a.abd.invoke(invoke2, Float.valueOf(f3), Float.valueOf(1.0f));
                    a.abe.invoke(invoke2, false);
                    Method method2 = a.abf;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Build.VERSION.SDK_INT < 23 ? a.abi.get(Layout.class) : a.abj.get(Layout.class);
                    method2.invoke(invoke2, objArr2);
                    a.abg.invoke(invoke2, a.abk.get(Layout.class));
                    z = false;
                    layout2 = (Layout) a.abh.invoke(invoke2, new Object[0]);
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
    public double act = -10000.0d;
    public final CriusNode aaX = new CriusNode();

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0069a {
        String da(String str);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                aaZ = Class.forName("android.text.StaticLayout$Builder");
                aba = aaZ.getDeclaredMethod("obtain", CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE);
                aba.setAccessible(true);
                abb = aaZ.getDeclaredMethod("setAlignment", Layout.Alignment.class);
                abb.setAccessible(true);
                abd = aaZ.getDeclaredMethod("setLineSpacing", Float.TYPE, Float.TYPE);
                abd.setAccessible(true);
                abe = aaZ.getDeclaredMethod("setIncludePad", Boolean.TYPE);
                abe.setAccessible(true);
                abf = aaZ.getDeclaredMethod("setBreakStrategy", Integer.TYPE);
                abf.setAccessible(true);
                abg = aaZ.getDeclaredMethod("setHyphenationFrequency", Integer.TYPE);
                abg.setAccessible(true);
                abh = aaZ.getDeclaredMethod("build", new Class[0]);
                abh.setAccessible(true);
                abi = Layout.class.getDeclaredField("BREAK_STRATEGY_SIMPLE");
                abi.setAccessible(true);
                abj = Layout.class.getDeclaredField("BREAK_STRATEGY_HIGH_QUALITY");
                abj.setAccessible(true);
                abk = Layout.class.getDeclaredField("HYPHENATION_FREQUENCY_NORMAL");
                abk.setAccessible(true);
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

    public static boolean cW(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cW(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void p(JSONObject jSONObject) {
        this.id = b.g(jSONObject, "id");
        this.name = b.g(jSONObject, "name");
        this.type = b.g(jSONObject, "type");
        if (isText()) {
            this.aaX.setMeasureFunction(this.abl);
        }
        this.abm = b.g(jSONObject, "component");
        this.src = b.g(jSONObject, ImageCoverViewModel.KEY_SRC);
        this.aaQ = b.g(jSONObject, "poster");
        this.abn = b.g(jSONObject, "href");
        this.text = b.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.abm) && this.businessConverter != null) {
            this.text = this.businessConverter.da(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.abx = b.h(jSONObject, "line-space");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.abo = jSONObject.optString("data-als-stat");
        this.abp = jSONObject.optString("data-url-stat");
        this.abq = jSONObject.optString("data-href-pop");
        this.abr = b.i(jSONObject, "data-share-num");
        this.abt = b.i(jSONObject, "data-reply-num");
        this.abu = b.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.abv = jSONObject.optString("data-share-image");
        this.abw = jSONObject.optString("data-share-link");
    }

    private void q(JSONObject jSONObject) {
        this.display = b.g(jSONObject, "display");
        sO();
        this.aby = b.g(jSONObject, "flex-direction");
        sV();
        this.abz = b.g(jSONObject, "justify-content");
        sU();
        this.abA = b.g(jSONObject, "align-items");
        sT();
        this.abB = b.g(jSONObject, "align-self");
        sS();
        this.abC = b.g(jSONObject, "align-content");
        sR();
        this.abD = b.h(jSONObject, "flex");
        sN();
        this.abE = b.h(jSONObject, "flex-grow");
        sM();
        this.abF = b.h(jSONObject, "flex-shrink");
        sL();
        this.abG = b.h(jSONObject, "flex-basis");
        sK();
        this.position = b.g(jSONObject, "position");
        sQ();
        this.abH = b.h(jSONObject, "left");
        this.abI = b.h(jSONObject, AiAppsNaViewModel.POSITION_KEY_TOP);
        this.abJ = b.h(jSONObject, MarkerModel.SubBase.RIGHT);
        this.abK = b.h(jSONObject, "bottom");
        sP();
        this.abL = b.h(jSONObject, "margin");
        sJ();
        this.abM = b.h(jSONObject, "margin-left");
        sF();
        this.abN = b.h(jSONObject, "margin-top");
        sI();
        this.abO = b.h(jSONObject, "margin-right");
        sH();
        this.abP = b.h(jSONObject, "margin-bottom");
        sG();
        this.abQ = b.h(jSONObject, "padding");
        initPadding();
        this.abR = b.h(jSONObject, "padding-left");
        sB();
        this.abS = b.h(jSONObject, "padding-top");
        sE();
        this.abT = b.h(jSONObject, "padding-right");
        sD();
        this.abU = b.h(jSONObject, "padding-bottom");
        sC();
        this.width = b.h(jSONObject, "width");
        sA();
        this.height = b.h(jSONObject, "height");
        sz();
        this.abV = b.h(jSONObject, "min-width");
        sy();
        this.abW = b.h(jSONObject, "min-height");
        sx();
        this.abX = b.h(jSONObject, "max-width");
        su();
        this.abY = b.h(jSONObject, "max-height");
        sw();
        this.abZ = b.h(jSONObject, "aspect-ratio");
        sv();
    }

    private void r(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acv = b.g(optJSONObject, "background-image");
            this.acx = b.g(optJSONObject, "background-color");
            this.acy = b.g(optJSONObject, "border-color");
            this.acz = b.g(optJSONObject, "color");
        }
    }

    private void s(JSONObject jSONObject) {
        this.acq = b.g(jSONObject, "background-image");
        this.acr = b.g(jSONObject, "background-color");
        this.acs = b.g(jSONObject, "border-color");
        this.act = b.h(jSONObject, CoverViewHelper.OPACITY);
        this.acu = b.g(jSONObject, "color");
    }

    private void t(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.acm = b.g(optJSONObject, "background-image");
            this.acn = b.g(optJSONObject, "background-color");
            this.aco = b.g(optJSONObject, "border-color");
            this.acp = b.g(optJSONObject, "color");
        }
    }

    private void u(JSONObject jSONObject) {
        this.aca = b.g(jSONObject, "background-image");
        this.acb = b.g(jSONObject, "background-color");
        this.acc = b.g(jSONObject, "border-color");
        this.acf = b.h(jSONObject, CoverViewHelper.OPACITY);
        this.color = b.g(jSONObject, "color");
        this.acd = b.h(jSONObject, "border-width");
        this.ace = b.h(jSONObject, "border-radius");
        this.acg = b.g(jSONObject, "font-style");
        this.ach = b.g(jSONObject, "font-weight");
        this.aci = Typeface.create(Typeface.DEFAULT, ss());
        this.acj = jSONObject.optDouble("font-size", 12.0d);
        this.ack = b.g(jSONObject, "text-align");
        this.acl = b.g(jSONObject, "vertical-align");
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
                this.acA = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0069a, false);
                    this.acA.add(aVar);
                    this.aaX.addChildAt(aVar.aaX, i);
                }
            } else {
                this.acA = null;
            }
        } else {
            this.acA = null;
        }
        if (z) {
            this.aaW = new CriusNode();
            this.aaW.addChildAt(this.aaX, 0);
            this.aaW.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private int ss() {
        return "italic".equalsIgnoreCase(this.acg) ? (TextUtils.isEmpty(this.ach) || "normal".equalsIgnoreCase(this.ach) || !"bold".equalsIgnoreCase(this.ach)) ? 2 : 3 : (TextUtils.isEmpty(this.ach) || "normal".equalsIgnoreCase(this.ach) || !"bold".equalsIgnoreCase(this.ach)) ? 0 : 1;
    }

    private int st() {
        int i;
        if ("left".equalsIgnoreCase(this.ack)) {
            i = 3;
        } else if (MarkerModel.SubBase.RIGHT.equalsIgnoreCase(this.ack)) {
            i = 5;
        } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.ack)) {
            i = 1;
        } else {
            i = 0;
        }
        if (AiAppsNaViewModel.POSITION_KEY_TOP.equalsIgnoreCase(this.acl)) {
            return i | 48;
        }
        if ("bottom".equalsIgnoreCase(this.acl)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.acl)) {
            return i | 16;
        }
        return i | 0;
    }

    private void su() {
        if (this.abX >= 0.0d) {
            this.aaX.setMaxWidth(e(this.abX));
        } else if (this.abX > -10000.0d) {
            this.aaX.setMaxWidth(this.widthPixels);
        }
    }

    private void sv() {
        if (this.abZ > 0.0d) {
            this.aaX.setAspectRatio((float) this.abZ);
        }
    }

    private void sw() {
        if (this.abY >= 0.0d) {
            this.aaX.setMaxHeight(e(this.abY));
        } else if (this.abY > -10000.0d) {
            this.aaX.setMaxHeight(this.heightPixels);
        }
    }

    private void sx() {
        if (this.abW >= 0.0d) {
            this.aaX.setMinHeight(e(this.abW));
        } else if (this.abW > -10000.0d) {
            this.aaX.setMinHeight(this.heightPixels);
        }
    }

    private void sy() {
        if (this.abV >= 0.0d) {
            this.aaX.setMinWidth(e(this.abV));
        } else if (this.abV > -10000.0d) {
            this.aaX.setMinWidth(this.widthPixels);
        }
    }

    private void sz() {
        if (this.height >= 0.0d) {
            this.aaX.setHeight(e(this.height));
        } else if (this.height > -10000.0d) {
            this.aaX.setHeight(this.heightPixels);
        }
    }

    private void sA() {
        if (this.width >= 0.0d) {
            this.aaX.setWidth(e(this.width));
        } else if (this.width > -10000.0d) {
            this.aaX.setWidth(this.widthPixels);
        }
    }

    private void sB() {
        if (this.abR >= -1.0d) {
            this.aaX.setPadding(CriusEdge.LEFT, e(this.abR));
        }
    }

    private void sC() {
        if (this.abU >= -1.0d) {
            this.aaX.setPadding(CriusEdge.BOTTOM, e(this.abU));
        }
    }

    private void sD() {
        if (this.abT >= -1.0d) {
            this.aaX.setPadding(CriusEdge.RIGHT, e(this.abT));
        }
    }

    private void sE() {
        if (this.abS >= -1.0d) {
            this.aaX.setPadding(CriusEdge.TOP, e(this.abS));
        }
    }

    private void initPadding() {
        if (this.abQ >= -1.0d) {
            this.aaX.setPadding(CriusEdge.ALL, e(this.abQ));
        }
    }

    private void sF() {
        if (this.abM >= -1.0d) {
            this.aaX.setMargin(CriusEdge.LEFT, e(this.abM));
        }
    }

    private void sG() {
        if (this.abP >= -1.0d) {
            this.aaX.setMargin(CriusEdge.BOTTOM, e(this.abP));
        }
    }

    private void sH() {
        if (this.abO >= -1.0d) {
            this.aaX.setMargin(CriusEdge.RIGHT, e(this.abO));
        }
    }

    private void sI() {
        if (this.abN >= -1.0d) {
            this.aaX.setMargin(CriusEdge.TOP, e(this.abN));
        }
    }

    private void sJ() {
        if (this.abL >= -1.0d) {
            this.aaX.setMargin(CriusEdge.ALL, e(this.abL));
        }
    }

    private void sK() {
        if (this.abG >= -1.0d) {
            this.aaX.setFlexBasis(e(this.abG));
        }
    }

    private void sL() {
        if (this.abF >= -1.0d) {
            this.aaX.setFlexShrink((float) this.abF);
        }
    }

    private void sM() {
        if (this.abE >= -1.0d) {
            this.aaX.setFlexGrow((float) this.abE);
        }
    }

    private void sN() {
        if (this.abD >= -1.0d) {
            this.aaX.setFlex((float) this.abD);
        }
    }

    private void sO() {
        if (!TextUtils.isEmpty(this.display)) {
            if ("flex".equalsIgnoreCase(this.display)) {
                this.aaX.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.display)) {
                this.aaX.setDisplay(CriusDisplay.NONE);
            } else {
                this.aaX.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void sP() {
        if (!b.b(this.abH, -10000.0d)) {
            this.aaX.setPosition(CriusEdge.LEFT, e(this.abH));
        }
        if (!b.b(this.abI, -10000.0d)) {
            this.aaX.setPosition(CriusEdge.TOP, e(this.abI));
        }
        if (!b.b(this.abJ, -10000.0d)) {
            this.aaX.setPosition(CriusEdge.RIGHT, e(this.abJ));
        }
        if (!b.b(this.abK, -10000.0d)) {
            this.aaX.setPosition(CriusEdge.BOTTOM, e(this.abK));
        }
    }

    private void sQ() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.aaX.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.aaX.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void sR() {
        if (!TextUtils.isEmpty(this.abC)) {
            if ("flex-start".equalsIgnoreCase(this.abC)) {
                this.aaX.setAlignSelf(CriusAlign.FLEX_START);
            } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.abC)) {
                this.aaX.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abC)) {
                this.aaX.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abC)) {
                this.aaX.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.abC)) {
                this.aaX.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abC)) {
                this.aaX.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.aaX.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void sS() {
        if (!TextUtils.isEmpty(this.abB)) {
            if ("auto".equalsIgnoreCase(this.abB)) {
                this.aaX.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.abB)) {
                this.aaX.setAlignSelf(CriusAlign.FLEX_START);
            } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.abB)) {
                this.aaX.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abB)) {
                this.aaX.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abB)) {
                this.aaX.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.aaX.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void sT() {
        if (!TextUtils.isEmpty(this.abA)) {
            if ("flex-start".equalsIgnoreCase(this.abA)) {
                this.aaX.setAlignItems(CriusAlign.FLEX_START);
            } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.abA)) {
                this.aaX.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abA)) {
                this.aaX.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.abA)) {
                this.aaX.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.aaX.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void sU() {
        if (!TextUtils.isEmpty(this.abz)) {
            if ("flex-start".equalsIgnoreCase(this.abz)) {
                this.aaX.setJustifyContent(CriusJustify.FLEX_START);
            } else if (MarkerModel.SubBase.CENTER.equalsIgnoreCase(this.abz)) {
                this.aaX.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.abz)) {
                this.aaX.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.abz)) {
                this.aaX.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.abz)) {
                this.aaX.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.aaX.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void sV() {
        if (!TextUtils.isEmpty(this.aby)) {
            if ("column".equalsIgnoreCase(this.aby)) {
                this.aaX.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.aby)) {
                this.aaX.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.aby)) {
                this.aaX.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.aby)) {
                this.aaX.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.aaX.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean isText() {
        return "text".equals(this.type);
    }

    public a cX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.acA != null && this.acA.size() > 0) {
                for (a aVar : this.acA) {
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

    public a cY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.abm)) {
            if (this.acA != null && this.acA.size() > 0) {
                for (a aVar : this.acA) {
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

    private float e(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.density * d);
    }

    public float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean cZ(String str) {
        a cY;
        if (this.aaW == null || (cY = cY(str)) == null || cY.aaX == null) {
            return false;
        }
        cY.aaX.setDisplay(CriusDisplay.NONE);
        cY.aaX.dirty();
        this.aaW.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void d(String str, float f) {
        a cX;
        if (this.aaW != null && (cX = cX(str)) != null && cX.aaX != null) {
            cX.acj = f;
            cX.aaX.dirty();
            this.aaW.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
