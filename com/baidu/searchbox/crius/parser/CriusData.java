package com.baidu.searchbox.crius.parser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crius.CriusAlign;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusEdge;
import com.baidu.crius.CriusFlexDirection;
import com.baidu.crius.CriusJustify;
import com.baidu.crius.CriusNode;
import com.baidu.crius.CriusPositionType;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.ui.CriusUI;
import com.baidu.searchbox.crius.ui.CriusUIFactory;
import com.baidu.searchbox.crius.ui.indicator.IndicatorAttrs;
import com.baidu.searchbox.crius.ui.swiper.SwiperAttrs;
import com.baidu.searchbox.crius.util.CriusUtil;
import com.baidu.searchbox.ui.UnifyTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CriusData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CriusData";
    public static int fontLevel = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int agreeNum;
    public String alignContent;
    public String alignItems;
    public String alignSelf;
    public String alsStat;
    public double aspectRatio;
    public String backgroundColor;
    public String backgroundColorActive;
    public String backgroundColorNight;
    public String backgroundColorNightActive;
    public String backgroundColorNightVisited;
    public String backgroundColorNightVisitedActive;
    public String backgroundColorVisited;
    public String backgroundColorVisitedActive;
    public String backgroundImage;
    public String backgroundImageActive;
    public String backgroundImageNight;
    public String backgroundImageNightActive;
    public String backgroundImageNightVisited;
    public String backgroundImageNightVisitedActive;
    public String backgroundImageVisited;
    public String backgroundImageVisitedActive;
    public String borderColor;
    public String borderColorActive;
    public String borderColorNight;
    public String borderColorNightActive;
    public String borderColorNightVisited;
    public String borderColorNightVisitedActive;
    public String borderColorVisited;
    public String borderColorVisitedActive;
    public double borderRadius;
    public double borderRadiusLeftBottom;
    public double borderRadiusLeftTop;
    public double borderRadiusRightBottom;
    public double borderRadiusRightTop;
    public double borderWidth;
    public double bottom;
    public BusinessConverter businessConverter;
    public String chargeType;
    public List<CriusData> children;
    public String color;
    public String colorActive;
    public String colorNight;
    public String colorNightActive;
    public String colorNightVisited;
    public String colorNightVisitedActive;
    public String colorVisited;
    public String colorVisitedActive;
    public String component;
    public final CriusNode criusNode;
    public int currentFontLevel;
    public float density;
    public String display;
    public int downloadStyle;
    public double flex;
    public double flexBasis;
    public String flexDirection;
    public double flexGrow;
    public double flexShrink;
    public ScaleFocusPoint focusPoint;
    public double fontSize;
    public double[] fontSizes;
    public double fontStrokeWidth;
    public Typeface fontStyle;
    public String fontStyleStr;
    public String fontWeightStr;
    public GradientAttrs gradientAttrs;
    public int gravity;
    public double height;
    public int heightPixels;
    public String href;
    public String hrefPop;
    public String id;
    public boolean ignoreTextPadding;
    public int imageScaleType;
    public Set<String> imageUrls;
    public IndicatorAttrs indicatorAttrs;
    public String justifyContent;
    public double left;
    public double lineMulti;
    public double lineSpace;
    public CriusUI mCriusUI;
    public double margin;
    public double marginBottom;
    public double marginLeft;
    public double marginRight;
    public double marginTop;
    public double maxHeight;
    public int maxLines;
    public double maxWidth;
    public UnifyTextView measureTextView;
    public double minHeight;
    public double minWidth;
    public String name;
    public double opacity;
    public double opacityActive;
    public double opacityNight;
    public double opacityNightActive;
    public double opacityNightVisited;
    public double opacityNightVisitedActive;
    public double opacityVisited;
    public double opacityVisitedActive;
    public JSONObject originData;
    public double padding;
    public double paddingBottom;
    public double paddingLeft;
    public double paddingRight;
    public double paddingTop;
    public CriusData parent;
    public String parentHref;
    public String placeHolderImage;
    public String placeHolderImageNight;
    public int placeHolderScaleType;
    public String position;
    public String poster;
    public PraiseAttrs praiseAttrs;
    public PrefixLabelAttrs preLabelAttrs;
    public String progressColor;
    public String progressNightColor;
    public int replyNum;
    public double right;
    public CriusNode rootNode;
    public String shareContent;
    public String shareImage;
    public String shareLink;
    public int shareNum;
    public String shareTitle;
    public String src;
    public Map<String, String> srcSet;
    public String stat;
    public String strokeColor;
    public String strokeNightColor;
    public double strokeWidth;
    public SwiperAttrs swiperAttrs;
    public SyncInfo syncInfo;
    public String text;
    public String textAlignStr;
    public String textDecoration;
    public String textDecorationColor;
    public double top;
    public String type;
    public String urlStat;
    public String verticalAlignStr;
    public int videoDuration;
    public int voteStyle;
    public double width;
    public int widthPixels;

    /* loaded from: classes2.dex */
    public interface BusinessConverter {
        String changeTimeText(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(505261624, "Lcom/baidu/searchbox/crius/parser/CriusData;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(505261624, "Lcom/baidu/searchbox/crius/parser/CriusData;");
        }
    }

    public CriusData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.currentFontLevel = fontLevel;
        this.opacityActive = -10000.0d;
        this.opacityNight = -10000.0d;
        this.opacityNightActive = -10000.0d;
        this.opacityVisited = -10000.0d;
        this.opacityNightVisited = -10000.0d;
        this.opacityVisitedActive = -10000.0d;
        this.opacityNightVisitedActive = -10000.0d;
        this.criusNode = new CriusNode();
    }

    private void initDisplay() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65550, this) != null) || TextUtils.isEmpty(this.display)) {
            return;
        }
        if ("flex".equalsIgnoreCase(this.display)) {
            this.criusNode.setDisplay(CriusDisplay.FLEX);
        } else if ("none".equalsIgnoreCase(this.display)) {
            this.criusNode.setDisplay(CriusDisplay.NONE);
        } else {
            this.criusNode.setDisplay(CriusDisplay.FLEX);
        }
    }

    private void initHeight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            double d = this.height;
            if (d >= 0.0d) {
                this.criusNode.setHeight(convertFloatValue(d));
            } else if (d > -10000.0d) {
                this.criusNode.setHeight(this.heightPixels);
            }
        }
    }

    private void initMaxHeight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            double d = this.maxHeight;
            if (d >= 0.0d) {
                this.criusNode.setMaxHeight(convertFloatValue(d));
            } else if (d > -10000.0d) {
                this.criusNode.setMaxHeight(this.heightPixels);
            }
        }
    }

    private void initMaxWidth() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            double d = this.maxWidth;
            if (d >= 0.0d) {
                this.criusNode.setMaxWidth(convertFloatValue(d));
            } else if (d > -10000.0d) {
                this.criusNode.setMaxWidth(this.widthPixels);
            }
        }
    }

    private void initMinHeight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            double d = this.minHeight;
            if (d >= 0.0d) {
                this.criusNode.setMinHeight(convertFloatValue(d));
            } else if (d > -10000.0d) {
                this.criusNode.setMinHeight(this.heightPixels);
            }
        }
    }

    private void initMinWidth() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            double d = this.minWidth;
            if (d >= 0.0d) {
                this.criusNode.setMinWidth(convertFloatValue(d));
            } else if (d > -10000.0d) {
                this.criusNode.setMinWidth(this.widthPixels);
            }
        }
    }

    private void initPositionType() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65575, this) != null) || TextUtils.isEmpty(this.position)) {
            return;
        }
        if (CriusAttrConstants.RELATIVE.equalsIgnoreCase(this.position)) {
            this.criusNode.setPositionType(CriusPositionType.RELATIVE);
        } else if (CriusAttrConstants.ABSOLUTE.equalsIgnoreCase(this.position)) {
            this.criusNode.setPositionType(CriusPositionType.ABSOLUTE);
        }
    }

    private void initWidth() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            double d = this.width;
            if (d >= 0.0d) {
                this.criusNode.setWidth(convertFloatValue(d));
            } else if (d > -10000.0d) {
                this.criusNode.setWidth(this.widthPixels);
            }
        }
    }

    public String decoratedHref() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!TextUtils.isEmpty(this.href)) {
                return this.href;
            }
            if (!TextUtils.isEmpty(this.parentHref)) {
                if (!TextUtils.isEmpty(this.alsStat) || !TextUtils.isEmpty(this.urlStat) || !TextUtils.isEmpty(this.stat)) {
                    return this.parentHref;
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public CriusData getPrefixLabel() {
        InterceptResult invokeV;
        PrefixLabelAttrs prefixLabelAttrs;
        CriusData criusData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (TextUtils.equals("text", this.type) && (prefixLabelAttrs = this.preLabelAttrs) != null && prefixLabelAttrs.hasPrefix && !TextUtils.isEmpty(prefixLabelAttrs.bindingId) && (criusData = this.parent) != null) {
                return criusData.getDataById(this.preLabelAttrs.bindingId);
            }
            return null;
        }
        return (CriusData) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CriusData(Context context, JSONObject jSONObject, boolean z, BusinessConverter businessConverter) {
        this(context, jSONObject, z, null, null, businessConverter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject, Boolean.valueOf(z), businessConverter};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (JSONObject) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (String) objArr2[3], (Set) objArr2[4], (BusinessConverter) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public CriusData(Context context, JSONObject jSONObject, boolean z, String str, Set<String> set, BusinessConverter businessConverter) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject, Boolean.valueOf(z), str, set, businessConverter};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.currentFontLevel = fontLevel;
        this.opacityActive = -10000.0d;
        this.opacityNight = -10000.0d;
        this.opacityNightActive = -10000.0d;
        this.opacityVisited = -10000.0d;
        this.opacityNightVisited = -10000.0d;
        this.opacityVisitedActive = -10000.0d;
        this.opacityNightVisitedActive = -10000.0d;
        this.originData = jSONObject;
        this.criusNode = new CriusNode();
        this.businessConverter = businessConverter;
        this.density = DeviceUtil.ScreenInfo.getDensity(context);
        this.widthPixels = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        this.heightPixels = DeviceUtil.ScreenInfo.getDisplayHeight(context);
        this.measureTextView = new UnifyTextView(context);
        this.parentHref = str;
        if (z) {
            this.imageUrls = new HashSet();
        } else {
            this.imageUrls = set;
        }
        initDataAttr(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        optJSONObject = optJSONObject == null ? new JSONObject() : optJSONObject;
        initFlexAttr(optJSONObject);
        initStyleAttr(optJSONObject);
        initActiveStyleAttr(optJSONObject);
        initVisitedStyleAttr(optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(NativeConstants.NIGHT_STYLE);
        if (optJSONObject2 != null) {
            initNightStyleAttr(optJSONObject2);
            initActiveNightStyleAttr(optJSONObject2);
            initVisitedNightStyleAttr(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject(NativeConstants.GRADIENT);
        if (optJSONObject3 != null) {
            this.gradientAttrs = GradientAttrs.Companion.parseGradient(optJSONObject3);
        }
        if (jSONObject.has(CriusAttrConstants.CHILDREN)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(CriusAttrConstants.CHILDREN);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.children = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
                    if (!TextUtils.isEmpty(this.href)) {
                        str2 = this.href;
                    } else {
                        str2 = this.parentHref;
                    }
                    CriusData criusData = new CriusData(context, optJSONObject4, false, str2, this.imageUrls, businessConverter);
                    this.children.add(criusData);
                    criusData.parent = this;
                    this.criusNode.addChildAt(criusData.criusNode, i3);
                }
            } else {
                this.children = null;
            }
        } else {
            this.children = null;
        }
        if (z) {
            CriusNode criusNode = new CriusNode();
            this.rootNode = criusNode;
            criusNode.addChildAt(this.criusNode, 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CriusData(Context context, JSONObject jSONObject, boolean z, Set<String> set, BusinessConverter businessConverter) {
        this(context, jSONObject, z, null, set, businessConverter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject, Boolean.valueOf(z), set, businessConverter};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (JSONObject) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (String) objArr2[3], (Set) objArr2[4], (BusinessConverter) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private float dealTextHeightWithAndroidVersion(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65541, this, f)) == null) {
            if (Build.VERSION.SDK_INT != 19 && !isMIUIRom()) {
                return f;
            }
            return (f * 1.06f) + 0.5f;
        }
        return invokeF.floatValue;
    }

    private void initSyncAttr(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.syncInfo = null;
            } else {
                this.syncInfo = SyncInfo.parse(jSONObject);
            }
        }
    }

    public static boolean isContainNonChinese(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, str)) == null) {
            if (Pattern.compile("[^一-龥]").matcher(str).find()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void putImageUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65586, this, str) == null) && this.imageUrls != null && !TextUtils.isEmpty(str)) {
            this.imageUrls.add(str);
        }
    }

    private void putImageUrls(Collection<String> collection) {
        Set<String> set;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65587, this, collection) == null) && (set = this.imageUrls) != null && collection != null) {
            set.addAll(collection);
        }
    }

    public float convertFloatValue(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)})) == null) {
            return CriusUtil.convertFloatValue(d, this.density);
        }
        return invokeCommon.floatValue;
    }

    public View createView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            if (!hasUI()) {
                CriusUI create = CriusUIFactory.create(context, this);
                setUI(create);
                return create.getView();
            }
            return getUI().getView();
        }
        return (View) invokeL.objValue;
    }

    public CriusData getChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return this.children.get(i);
        }
        return (CriusData) invokeI.objValue;
    }

    public boolean isAlignItems(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equalsIgnoreCase(this.alignItems);
        }
        return invokeL.booleanValue;
    }

    public CriusData removeChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            List<CriusData> list = this.children;
            if (list == null) {
                return null;
            }
            CriusData remove = list.remove(i);
            remove.criusNode.removeChildAt(i);
            remove.parent = null;
            return remove;
        }
        return (CriusData) invokeI.objValue;
    }

    public void setUI(CriusUI criusUI) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, criusUI) == null) {
            this.mCriusUI = criusUI;
        }
    }

    @Nullable
    private CriusData getLabelTextData(CriusData criusData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, criusData)) == null) {
            CriusData criusData2 = null;
            if (criusData != null) {
                if (!TextUtils.equals("text", criusData.type)) {
                    List<CriusData> list = criusData.children;
                    if (list != null) {
                        Iterator<CriusData> it = list.iterator();
                        while (it.hasNext() && (criusData2 = getLabelTextData(it.next())) == null) {
                        }
                    }
                } else {
                    return criusData;
                }
            }
            return criusData2;
        }
        return (CriusData) invokeL.objValue;
    }

    private void initActiveNightStyleAttr(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, jSONObject) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.backgroundImageNightActive = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BACKGROUND_IMAGE);
            this.backgroundColorNightActive = CriusUtil.getStringIfExist(optJSONObject, "background-color");
            this.borderColorNightActive = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BORDER_COLOR);
            this.colorNightActive = CriusUtil.getStringIfExist(optJSONObject, "color");
            this.opacityNightActive = CriusUtil.getDoubleIfExist(optJSONObject, NativeConstants.OPACITY);
        }
    }

    private void initActiveStyleAttr(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, jSONObject) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.backgroundImageActive = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BACKGROUND_IMAGE);
            this.backgroundColorActive = CriusUtil.getStringIfExist(optJSONObject, "background-color");
            this.borderColorActive = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BORDER_COLOR);
            this.colorActive = CriusUtil.getStringIfExist(optJSONObject, "color");
            this.opacityActive = CriusUtil.getDoubleIfExist(optJSONObject, NativeConstants.OPACITY);
        }
    }

    private void initVisitedActiveNightStyleAttr(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65578, this, jSONObject) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.backgroundImageNightVisitedActive = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BACKGROUND_IMAGE);
            this.backgroundColorNightVisitedActive = CriusUtil.getStringIfExist(optJSONObject, "background-color");
            this.borderColorNightVisitedActive = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BORDER_COLOR);
            this.colorNightVisitedActive = CriusUtil.getStringIfExist(optJSONObject, "color");
            this.opacityNightVisitedActive = CriusUtil.getDoubleIfExist(optJSONObject, NativeConstants.OPACITY);
        }
    }

    private void initVisitedActiveStyleAttr(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65579, this, jSONObject) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("active")) != null) {
            this.backgroundImageVisitedActive = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BACKGROUND_IMAGE);
            this.backgroundColorVisitedActive = CriusUtil.getStringIfExist(optJSONObject, "background-color");
            this.borderColorVisitedActive = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BORDER_COLOR);
            this.colorVisitedActive = CriusUtil.getStringIfExist(optJSONObject, "color");
            this.opacityVisitedActive = CriusUtil.getDoubleIfExist(optJSONObject, NativeConstants.OPACITY);
        }
    }

    private void initVisitedNightStyleAttr(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65580, this, jSONObject) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject(NativeConstants.VISITED)) != null) {
            this.backgroundImageNightVisited = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BACKGROUND_IMAGE);
            this.backgroundColorNightVisited = CriusUtil.getStringIfExist(optJSONObject, "background-color");
            this.borderColorNightVisited = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BORDER_COLOR);
            this.colorNightVisited = CriusUtil.getStringIfExist(optJSONObject, "color");
            this.opacityNightVisited = CriusUtil.getDoubleIfExist(optJSONObject, NativeConstants.OPACITY);
            initVisitedActiveNightStyleAttr(optJSONObject);
        }
    }

    private void initVisitedStyleAttr(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65581, this, jSONObject) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject(NativeConstants.VISITED)) != null) {
            this.backgroundImageVisited = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BACKGROUND_IMAGE);
            this.backgroundColorVisited = CriusUtil.getStringIfExist(optJSONObject, "background-color");
            this.borderColorVisited = CriusUtil.getStringIfExist(optJSONObject, NativeConstants.BORDER_COLOR);
            this.colorVisited = CriusUtil.getStringIfExist(optJSONObject, "color");
            this.opacityVisited = CriusUtil.getDoubleIfExist(optJSONObject, NativeConstants.OPACITY);
            initVisitedActiveStyleAttr(optJSONObject);
        }
    }

    public void clearRecursive(CriusData criusData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, criusData) != null) || criusData == null) {
            return;
        }
        criusData.measureTextView = null;
        CriusNode criusNode = criusData.criusNode;
        if (criusNode != null && criusNode.getData() != null) {
            criusData.criusNode.setData(null);
        }
        CriusUI criusUI = criusData.mCriusUI;
        if (criusUI != null) {
            criusUI.clear();
            criusData.mCriusUI = null;
        }
        int childCount = criusData.getChildCount();
        for (int i = 0; i < childCount; i++) {
            clearRecursive(criusData.getChildAt(i));
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public float dealTextWidthWithAndroidVersion(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
            if ((Build.VERSION.SDK_INT == 19 || isMIUIRom()) && this.maxLines == 1 && isContainNonChinese(this.text)) {
                return (f * 1.09859f) + 0.5f;
            }
            return f;
        }
        return invokeF.floatValue;
    }

    public boolean hideComponentFromRoot(String str) {
        InterceptResult invokeL;
        CriusData dataByComponent;
        CriusNode criusNode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            if (this.rootNode == null || (dataByComponent = getDataByComponent(str)) == null || (criusNode = dataByComponent.criusNode) == null) {
                return false;
            }
            criusNode.setDisplay(CriusDisplay.NONE);
            dataByComponent.criusNode.dirty();
            this.rootNode.calculateLayout(Float.NaN, Float.NaN);
            return true;
        }
        return invokeL.booleanValue;
    }

    private void initAlignContent() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65545, this) != null) || TextUtils.isEmpty(this.alignContent)) {
            return;
        }
        if (CriusAttrConstants.FLEX_START.equalsIgnoreCase(this.alignContent)) {
            this.criusNode.setAlignSelf(CriusAlign.FLEX_START);
        } else if ("center".equalsIgnoreCase(this.alignContent)) {
            this.criusNode.setAlignSelf(CriusAlign.CENTER);
        } else if (CriusAttrConstants.FLEX_END.equalsIgnoreCase(this.alignContent)) {
            this.criusNode.setAlignSelf(CriusAlign.FLEX_END);
        } else if (CriusAttrConstants.STRETCH.equalsIgnoreCase(this.alignContent)) {
            this.criusNode.setAlignSelf(CriusAlign.STRETCH);
        } else if (CriusAttrConstants.SPACE_BETWEEN.equalsIgnoreCase(this.alignContent)) {
            this.criusNode.setAlignSelf(CriusAlign.SPACE_BETWEEN);
        } else if (CriusAttrConstants.SPACE_AROUND.equalsIgnoreCase(this.alignContent)) {
            this.criusNode.setAlignSelf(CriusAlign.SPACE_AROUND);
        } else {
            this.criusNode.setAlignSelf(CriusAlign.FLEX_START);
        }
    }

    private void initAlignItems() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65546, this) != null) || TextUtils.isEmpty(this.alignItems)) {
            return;
        }
        if (CriusAttrConstants.FLEX_START.equalsIgnoreCase(this.alignItems)) {
            this.criusNode.setAlignItems(CriusAlign.FLEX_START);
        } else if ("center".equalsIgnoreCase(this.alignItems)) {
            this.criusNode.setAlignItems(CriusAlign.CENTER);
        } else if (CriusAttrConstants.FLEX_END.equalsIgnoreCase(this.alignItems)) {
            this.criusNode.setAlignItems(CriusAlign.FLEX_END);
        } else if (CriusAttrConstants.STRETCH.equalsIgnoreCase(this.alignItems)) {
            this.criusNode.setAlignItems(CriusAlign.STRETCH);
        } else {
            this.criusNode.setAlignItems(CriusAlign.STRETCH);
        }
    }

    private void initAlignSelf() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65547, this) != null) || TextUtils.isEmpty(this.alignSelf)) {
            return;
        }
        if ("auto".equalsIgnoreCase(this.alignSelf)) {
            this.criusNode.setAlignSelf(CriusAlign.AUTO);
        } else if (CriusAttrConstants.FLEX_START.equalsIgnoreCase(this.alignSelf)) {
            this.criusNode.setAlignSelf(CriusAlign.FLEX_START);
        } else if ("center".equalsIgnoreCase(this.alignSelf)) {
            this.criusNode.setAlignSelf(CriusAlign.CENTER);
        } else if (CriusAttrConstants.FLEX_END.equalsIgnoreCase(this.alignSelf)) {
            this.criusNode.setAlignSelf(CriusAlign.FLEX_END);
        } else if (CriusAttrConstants.STRETCH.equalsIgnoreCase(this.alignSelf)) {
            this.criusNode.setAlignSelf(CriusAlign.STRETCH);
        } else {
            this.criusNode.setAlignSelf(CriusAlign.AUTO);
        }
    }

    private void initFlexDirection() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65554, this) != null) || TextUtils.isEmpty(this.flexDirection)) {
            return;
        }
        if (CriusAttrConstants.COLUMN.equalsIgnoreCase(this.flexDirection)) {
            this.criusNode.setFlexDirection(CriusFlexDirection.COLUMN);
        } else if (CriusAttrConstants.COLUMN_REVERSE.equalsIgnoreCase(this.flexDirection)) {
            this.criusNode.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
        } else if (CriusAttrConstants.ROW.equalsIgnoreCase(this.flexDirection)) {
            this.criusNode.setFlexDirection(CriusFlexDirection.ROW);
        } else if (CriusAttrConstants.ROW_REVERSE.equalsIgnoreCase(this.flexDirection)) {
            this.criusNode.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
        } else {
            this.criusNode.setFlexDirection(CriusFlexDirection.COLUMN);
        }
    }

    private void initJustifyContent() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65558, this) != null) || TextUtils.isEmpty(this.justifyContent)) {
            return;
        }
        if (CriusAttrConstants.FLEX_START.equalsIgnoreCase(this.justifyContent)) {
            this.criusNode.setJustifyContent(CriusJustify.FLEX_START);
        } else if ("center".equalsIgnoreCase(this.justifyContent)) {
            this.criusNode.setJustifyContent(CriusJustify.CENTER);
        } else if (CriusAttrConstants.FLEX_END.equalsIgnoreCase(this.justifyContent)) {
            this.criusNode.setJustifyContent(CriusJustify.FLEX_END);
        } else if (CriusAttrConstants.SPACE_BETWEEN.equalsIgnoreCase(this.justifyContent)) {
            this.criusNode.setJustifyContent(CriusJustify.SPACE_BETWEEN);
        } else if (CriusAttrConstants.SPACE_AROUND.equalsIgnoreCase(this.justifyContent)) {
            this.criusNode.setJustifyContent(CriusJustify.SPACE_AROUND);
        } else {
            this.criusNode.setJustifyContent(CriusJustify.FLEX_START);
        }
    }

    private void initPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            if (!CriusUtil.equalsDouble(this.left, -10000.0d)) {
                this.criusNode.setPosition(CriusEdge.LEFT, convertFloatValue(this.left));
            }
            if (!CriusUtil.equalsDouble(this.top, -10000.0d)) {
                this.criusNode.setPosition(CriusEdge.TOP, convertFloatValue(this.top));
            }
            if (!CriusUtil.equalsDouble(this.right, -10000.0d)) {
                this.criusNode.setPosition(CriusEdge.RIGHT, convertFloatValue(this.right));
            }
            if (!CriusUtil.equalsDouble(this.bottom, -10000.0d)) {
                this.criusNode.setPosition(CriusEdge.BOTTOM, convertFloatValue(this.bottom));
            }
        }
    }

    private int parseGravity() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) {
            if ("left".equalsIgnoreCase(this.textAlignStr)) {
                i = GravityCompat.START;
            } else if ("right".equalsIgnoreCase(this.textAlignStr)) {
                i = 8388613;
            } else if ("center".equalsIgnoreCase(this.textAlignStr)) {
                i = 1;
            } else {
                i = 0;
            }
            if ("top".equalsIgnoreCase(this.verticalAlignStr)) {
                return i | 48;
            }
            if ("bottom".equalsIgnoreCase(this.verticalAlignStr)) {
                return i | 80;
            }
            if (NativeConstants.MIDDLE.equalsIgnoreCase(this.verticalAlignStr)) {
                return i | 16;
            }
            return i | 0;
        }
        return invokeV.intValue;
    }

    private void initAspectRatio() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            double d = this.aspectRatio;
            if (d > 0.0d) {
                this.criusNode.setAspectRatio((float) d);
            }
        }
    }

    private void initFlex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            double d = this.flex;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setFlex((float) d);
        }
    }

    private void initFlexBasis() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            double d = this.flexBasis;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setFlexBasis(convertFloatValue(d));
        }
    }

    private void initFlexGrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            double d = this.flexGrow;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setFlexGrow((float) d);
        }
    }

    private void initFlexShrink() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            double d = this.flexShrink;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setFlexShrink((float) d);
        }
    }

    private void initMargin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            double d = this.margin;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setMargin(CriusEdge.ALL, convertFloatValue(d));
        }
    }

    private void initMarginBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            double d = this.marginBottom;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setMargin(CriusEdge.BOTTOM, convertFloatValue(d));
        }
    }

    private void initMarginLeft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            double d = this.marginLeft;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setMargin(CriusEdge.LEFT, convertFloatValue(d));
        }
    }

    private void initMarginRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            double d = this.marginRight;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setMargin(CriusEdge.RIGHT, convertFloatValue(d));
        }
    }

    private void initMarginTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            double d = this.marginTop;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setMargin(CriusEdge.TOP, convertFloatValue(d));
        }
    }

    private void initPadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            double d = this.padding;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setPadding(CriusEdge.ALL, convertFloatValue(d));
        }
    }

    private void initPaddingBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            double d = this.paddingBottom;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setPadding(CriusEdge.BOTTOM, convertFloatValue(d));
        }
    }

    private void initPaddingLeft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            double d = this.paddingLeft;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setPadding(CriusEdge.LEFT, convertFloatValue(d));
        }
    }

    private void initPaddingRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            double d = this.paddingRight;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setPadding(CriusEdge.RIGHT, convertFloatValue(d));
        }
    }

    private void initPaddingTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            double d = this.paddingTop;
            if (d < -1.0d) {
                return;
            }
            this.criusNode.setPadding(CriusEdge.TOP, convertFloatValue(d));
        }
    }

    public float convertedBorderRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return convertFloatValue(this.borderRadius);
        }
        return invokeV.floatValue;
    }

    public float convertedBorderRadiusLB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return convertFloatValue(this.borderRadiusLeftBottom);
        }
        return invokeV.floatValue;
    }

    public float convertedBorderRadiusLT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return convertFloatValue(this.borderRadiusLeftTop);
        }
        return invokeV.floatValue;
    }

    public float convertedBorderRadiusRB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return convertFloatValue(this.borderRadiusRightBottom);
        }
        return invokeV.floatValue;
    }

    public float convertedBorderRadiusRT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return convertFloatValue(this.borderRadiusRightTop);
        }
        return invokeV.floatValue;
    }

    public float convertedBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return convertFloatValue(this.borderWidth);
        }
        return invokeV.floatValue;
    }

    public float convertedStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return convertFloatValue(this.strokeWidth);
        }
        return invokeV.floatValue;
    }

    public double fontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            double[] dArr = this.fontSizes;
            if (dArr != null && dArr.length > 0) {
                int i = fontLevel;
                if (i >= 0 && i < dArr.length) {
                    return dArr[i];
                }
                return this.fontSize;
            }
            return this.fontSize;
        }
        return invokeV.doubleValue;
    }

    public int getChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            List<CriusData> list = this.children;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public String getDisplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.display;
        }
        return (String) invokeV.objValue;
    }

    public Set<String> getImageUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.imageUrls;
        }
        return (Set) invokeV.objValue;
    }

    public CriusUI getUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (hasUI()) {
                return this.mCriusUI;
            }
            return null;
        }
        return (CriusUI) invokeV.objValue;
    }

    public boolean hasUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.mCriusUI != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return NativeConstants.TYPE_HSCROLL.equals(this.type);
        }
        return invokeV.booleanValue;
    }

    public boolean isImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return "image".equals(this.type);
        }
        return invokeV.booleanValue;
    }

    public boolean isIndicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return NativeConstants.TYPE_INDICATOR.equalsIgnoreCase(this.type);
        }
        return invokeV.booleanValue;
    }

    public boolean isMIUIRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI);
        }
        return invokeV.booleanValue;
    }

    public boolean isSwiper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return NativeConstants.TYPE_SWIPER.equalsIgnoreCase(this.type);
        }
        return invokeV.booleanValue;
    }

    public boolean isText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return "text".equals(this.type);
        }
        return invokeV.booleanValue;
    }

    public boolean isVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return "video".equals(this.type);
        }
        return invokeV.booleanValue;
    }

    public boolean isView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return NativeConstants.TYPE_VIEW.equals(this.type);
        }
        return invokeV.booleanValue;
    }

    private void initDataAttr(JSONObject jSONObject) {
        BusinessConverter businessConverter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, jSONObject) == null) {
            this.id = CriusUtil.getStringIfExist(jSONObject, "id");
            this.name = CriusUtil.getStringIfExist(jSONObject, "name");
            this.type = CriusUtil.getStringIfExist(jSONObject, "type");
            this.component = CriusUtil.getStringIfExist(jSONObject, NativeConstants.COMPONENT);
            this.src = CriusUtil.getStringIfExist(jSONObject, "src");
            this.srcSet = CriusUtil.getMapIfExist(jSONObject, NativeConstants.SRCSET);
            this.poster = CriusUtil.getStringIfExist(jSONObject, NativeConstants.POSTER);
            this.href = Uri.decode(CriusUtil.getStringIfExist(jSONObject, NativeConstants.HREF));
            this.text = CriusUtil.getStringIfExist(jSONObject, "text");
            if ("time".equalsIgnoreCase(this.component) && (businessConverter = this.businessConverter) != null) {
                this.text = businessConverter.changeTimeText(this.text);
            }
            this.maxLines = jSONObject.optInt(NativeConstants.MAX_LINES, 1);
            this.lineSpace = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.LINE_SPACE);
            this.lineMulti = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.LINE_MULTI);
            this.videoDuration = jSONObject.optInt(NativeConstants.VIDEO_DURATION);
            this.alsStat = jSONObject.optString(NativeConstants.ALS_STAT);
            this.chargeType = jSONObject.optString(NativeConstants.CHARGE_TYPE);
            this.stat = jSONObject.optString(NativeConstants.STAT);
            this.urlStat = jSONObject.optString(NativeConstants.URL_STAT);
            this.hrefPop = jSONObject.optString(NativeConstants.HREF_POP);
            this.shareNum = CriusUtil.getIntIfExist(jSONObject, NativeConstants.SHARE_NUM);
            this.replyNum = CriusUtil.getIntIfExist(jSONObject, NativeConstants.REPLY_NUM);
            this.agreeNum = CriusUtil.getIntIfExist(jSONObject, NativeConstants.AGREE_NUM);
            this.shareTitle = jSONObject.optString(NativeConstants.SHARE_TITLE);
            this.shareContent = jSONObject.optString(NativeConstants.SHARE_CONTENT);
            this.shareImage = jSONObject.optString(NativeConstants.SHARE_IMAGE);
            this.shareLink = jSONObject.optString(NativeConstants.SHARE_LINK);
            initSyncAttr(jSONObject.optJSONObject(NativeConstants.SYNC_INFO));
            putImageUrl(this.src);
            putImageUrl(this.poster);
            Map<String, String> map = this.srcSet;
            if (map != null && !map.isEmpty()) {
                putImageUrls(this.srcSet.values());
            }
            this.swiperAttrs = SwiperAttrs.parse(jSONObject);
            this.indicatorAttrs = IndicatorAttrs.parse(jSONObject);
            this.preLabelAttrs = PrefixLabelAttrs.getLabelAttrs(jSONObject);
            this.focusPoint = ScaleFocusPoint.getFocusPoint(jSONObject.optJSONObject(NativeConstants.SCALE_FOCUS_CROP_POINT));
            this.ignoreTextPadding = jSONObject.optBoolean(NativeConstants.IGNORE_TEXT_PADDING, false);
            JSONObject optJSONObject = jSONObject.optJSONObject("praise_info");
            if (optJSONObject != null) {
                this.praiseAttrs = PraiseAttrsKt.parsePraiseAttrs(optJSONObject);
            }
        }
    }

    private void initFlexAttr(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, jSONObject) == null) {
            this.display = CriusUtil.getStringIfExist(jSONObject, CriusAttrConstants.DISPLAY);
            initDisplay();
            this.flexDirection = CriusUtil.getStringIfExist(jSONObject, CriusAttrConstants.FLEX_DIRECTION);
            initFlexDirection();
            this.justifyContent = CriusUtil.getStringIfExist(jSONObject, CriusAttrConstants.JUSTIFY_CONTENT);
            initJustifyContent();
            this.alignItems = CriusUtil.getStringIfExist(jSONObject, CriusAttrConstants.ALIGN_ITEMS);
            initAlignItems();
            this.alignSelf = CriusUtil.getStringIfExist(jSONObject, CriusAttrConstants.ALIGN_SELF);
            initAlignSelf();
            this.alignContent = CriusUtil.getStringIfExist(jSONObject, CriusAttrConstants.ALIGN_CONTENT);
            initAlignContent();
            this.flex = CriusUtil.getDoubleIfExist(jSONObject, "flex");
            initFlex();
            this.flexGrow = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.FLEX_GROW);
            initFlexGrow();
            this.flexShrink = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.FLEX_SHRINK);
            initFlexShrink();
            this.flexBasis = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.FLEX_BASIS);
            initFlexBasis();
            this.position = CriusUtil.getStringIfExist(jSONObject, CriusAttrConstants.POSITION);
            initPositionType();
            this.left = CriusUtil.getDoubleIfExist(jSONObject, "left");
            this.top = CriusUtil.getDoubleIfExist(jSONObject, "top");
            this.right = CriusUtil.getDoubleIfExist(jSONObject, "right");
            this.bottom = CriusUtil.getDoubleIfExist(jSONObject, "bottom");
            initPosition();
            this.margin = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MARGIN);
            initMargin();
            this.marginLeft = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MARGIN_LEFT);
            initMarginLeft();
            this.marginTop = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MARGIN_TOP);
            initMarginTop();
            this.marginRight = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MARGIN_RIGHT);
            initMarginRight();
            this.marginBottom = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MARGIN_BOTTOM);
            initMarginBottom();
            this.padding = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.PADDING);
            initPadding();
            this.paddingLeft = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.PADDING_LEFT);
            initPaddingLeft();
            this.paddingTop = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.PADDING_TOP);
            initPaddingTop();
            this.paddingRight = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.PADDING_RIGHT);
            initPaddingRight();
            this.paddingBottom = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.PADDING_BOTTOM);
            initPaddingBottom();
            this.width = CriusUtil.getDoubleIfExist(jSONObject, "width");
            initWidth();
            this.height = CriusUtil.getDoubleIfExist(jSONObject, "height");
            initHeight();
            this.minWidth = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MIN_WIDTH);
            initMinWidth();
            this.minHeight = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MIN_HEIGHT);
            initMinHeight();
            this.maxWidth = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MAX_WIDTH);
            initMaxWidth();
            this.maxHeight = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.MAX_HEIGHT);
            initMaxHeight();
            this.aspectRatio = CriusUtil.getDoubleIfExist(jSONObject, CriusAttrConstants.ASPECT_RATIO);
            initAspectRatio();
        }
    }

    private void initStyleAttr(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, this, jSONObject) == null) {
            int intIfExist = CriusUtil.getIntIfExist(jSONObject, NativeConstants.IMAGE_SCALE_TYPE);
            this.imageScaleType = intIfExist;
            if (intIfExist < 0) {
                this.imageScaleType = 6;
            }
            this.placeHolderImage = CriusUtil.getStringIfExist(jSONObject, NativeConstants.PLACEHOLDER_IMAGE);
            int intIfExist2 = CriusUtil.getIntIfExist(jSONObject, NativeConstants.PLACEHOLDER_SCALE_TYPE);
            this.placeHolderScaleType = intIfExist2;
            if (intIfExist2 < 0) {
                this.placeHolderScaleType = CriusUtil.getIntIfExist(jSONObject, NativeConstants.BACKGROUND_SCALE_TYPE);
            }
            if (this.placeHolderScaleType < 0) {
                this.placeHolderScaleType = 6;
            }
            this.backgroundImage = CriusUtil.getStringIfExist(jSONObject, NativeConstants.BACKGROUND_IMAGE);
            this.backgroundColor = CriusUtil.getStringIfExist(jSONObject, "background-color");
            this.borderColor = CriusUtil.getStringIfExist(jSONObject, NativeConstants.BORDER_COLOR);
            this.opacity = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.OPACITY);
            this.color = CriusUtil.getStringIfExist(jSONObject, "color");
            this.borderWidth = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.BORDER_WIDTH);
            this.borderRadius = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.BORDER_RADIUS);
            this.borderRadiusLeftTop = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.BORDER_RADIUS_LEFT_TOP);
            this.borderRadiusLeftBottom = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.BORDER_RADIUS_LEFT_BOTTOM);
            this.borderRadiusRightTop = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.BORDER_RADIUS_RIGHT_TOP);
            this.borderRadiusRightBottom = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.BORDER_RADIUS_RIGHT_BOTTOM);
            this.fontStyleStr = CriusUtil.getStringIfExist(jSONObject, "font-style");
            this.fontWeightStr = CriusUtil.getStringIfExist(jSONObject, "font-weight");
            this.fontStyle = Typeface.create(Typeface.DEFAULT, parseFontStyle());
            this.fontStrokeWidth = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.TEXT_STROKE_WIDTH);
            this.fontSize = jSONObject.optDouble(NativeConstants.FONT_SIZE, 12.0d);
            JSONArray optJSONArray = jSONObject.optJSONArray(NativeConstants.FONT_SIZES);
            if (optJSONArray != null) {
                this.fontSizes = new double[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.fontSizes[i] = optJSONArray.optDouble(i, 0.0d);
                }
            }
            this.textAlignStr = CriusUtil.getStringIfExist(jSONObject, NativeConstants.TEXT_ALIGN);
            this.verticalAlignStr = CriusUtil.getStringIfExist(jSONObject, NativeConstants.VERTICAL_ALIGN);
            this.gravity = parseGravity();
            this.downloadStyle = CriusUtil.getIntIfExist(jSONObject, NativeConstants.DOWNLOAD_STYLE);
            this.progressColor = CriusUtil.getStringIfExist(jSONObject, NativeConstants.PROGRES_COLOR);
            this.strokeColor = CriusUtil.getStringIfExist(jSONObject, NativeConstants.STROKE_COLOR);
            this.strokeWidth = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.STROKE_WIDTH);
            this.textDecoration = CriusUtil.getStringIfExist(jSONObject, "text-decoration");
            this.textDecorationColor = CriusUtil.getStringIfExist(jSONObject, NativeConstants.TEXT_DECORATION_COLOR);
            this.voteStyle = CriusUtil.getIntIfExist(jSONObject, NativeConstants.VOTE_STYLE);
        }
    }

    private void initNightStyleAttr(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, jSONObject) == null) {
            this.placeHolderImageNight = CriusUtil.getStringIfExist(jSONObject, NativeConstants.PLACEHOLDER_IMAGE);
            this.backgroundImageNight = CriusUtil.getStringIfExist(jSONObject, NativeConstants.BACKGROUND_IMAGE);
            this.backgroundColorNight = CriusUtil.getStringIfExist(jSONObject, "background-color");
            this.borderColorNight = CriusUtil.getStringIfExist(jSONObject, NativeConstants.BORDER_COLOR);
            this.opacityNight = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.OPACITY);
            this.colorNight = CriusUtil.getStringIfExist(jSONObject, "color");
            this.progressNightColor = CriusUtil.getStringIfExist(jSONObject, NativeConstants.PROGRES_COLOR);
            this.strokeNightColor = CriusUtil.getStringIfExist(jSONObject, NativeConstants.STROKE_COLOR);
        }
    }

    public CriusData getDataByComponent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.equalsIgnoreCase(this.component)) {
                return this;
            }
            List<CriusData> list = this.children;
            if (list != null && list.size() > 0) {
                for (CriusData criusData : this.children) {
                    CriusData dataByComponent = criusData.getDataByComponent(str);
                    if (dataByComponent != null) {
                        return dataByComponent;
                    }
                }
            }
            return null;
        }
        return (CriusData) invokeL.objValue;
    }

    public CriusData getDataById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.equalsIgnoreCase(this.id)) {
                return this;
            }
            List<CriusData> list = this.children;
            if (list != null && list.size() > 0) {
                for (CriusData criusData : this.children) {
                    CriusData dataById = criusData.getDataById(str);
                    if (dataById != null) {
                        return dataById;
                    }
                }
            }
            return null;
        }
        return (CriusData) invokeL.objValue;
    }

    public float getLabelTextWidth(CriusData criusData) {
        InterceptResult invokeL;
        CriusData labelTextData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, criusData)) == null) {
            float f = 0.0f;
            if (criusData == null) {
                return 0.0f;
            }
            CriusData prefixLabel = criusData.getPrefixLabel();
            if (prefixLabel != null && (labelTextData = getLabelTextData(prefixLabel)) != null && !TextUtils.isEmpty(labelTextData.text)) {
                Paint paint = new Paint();
                paint.setTextSize(DeviceUtils.ScreenInfo.dp2px(CriusRuntime.context(), (float) labelTextData.fontSize()));
                f = 0.0f + paint.measureText(labelTextData.text);
            }
            PrefixLabelAttrs prefixLabelAttrs = criusData.preLabelAttrs;
            if (prefixLabelAttrs != null) {
                double d = prefixLabelAttrs.prefixWidthWithoutText;
                if (d > 0.0d) {
                    f += criusData.convertFloatValue(d);
                }
                double d2 = criusData.preLabelAttrs.prefixTitleMargin;
                if (d2 > 0.0d) {
                    return f + criusData.convertFloatValue(d2);
                }
                return f;
            }
            return f;
        }
        return invokeL.floatValue;
    }

    private int parseFontStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            if ("italic".equalsIgnoreCase(this.fontStyleStr)) {
                if (TextUtils.isEmpty(this.fontWeightStr) || "normal".equalsIgnoreCase(this.fontWeightStr) || !"bold".equalsIgnoreCase(this.fontWeightStr)) {
                    return 2;
                }
                return 3;
            } else if (TextUtils.isEmpty(this.fontWeightStr) || "normal".equalsIgnoreCase(this.fontWeightStr) || !"bold".equalsIgnoreCase(this.fontWeightStr)) {
                return 0;
            } else {
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public float[] getBorderRadii() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            float positive = CriusUtil.positive(convertedBorderRadiusLT());
            float positive2 = CriusUtil.positive(convertedBorderRadiusRT());
            float positive3 = CriusUtil.positive(convertedBorderRadiusLB());
            float positive4 = CriusUtil.positive(convertedBorderRadiusRB());
            if (positive > 0.0f || positive2 > 0.0f || positive3 > 0.0f || positive4 > 0.0f) {
                return new float[]{positive, positive, positive2, positive2, positive4, positive4, positive3, positive3};
            }
            return null;
        }
        return (float[]) invokeV.objValue;
    }

    public void addChildAt(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, criusData, i) != null) || !(criusData instanceof CriusData)) {
            return;
        }
        if (criusData.parent != null && CriusRuntime.DEBUG) {
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(i, criusData);
        criusData.parent = this;
        this.criusNode.addChildAt(criusData.criusNode, i);
    }

    public String imageSrc(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Map<String, String> map = this.srcSet;
            if (map != null && !map.isEmpty()) {
                String str = "src";
                if (z) {
                    str = "src-n";
                }
                if (z2) {
                    str = str + "-v";
                }
                String str2 = this.srcSet.get(str);
                if (TextUtils.isEmpty(str2) && str.contains("-v")) {
                    str = str.replace("-v", "");
                    str2 = this.srcSet.get(str);
                }
                if (TextUtils.isEmpty(str2) && str.contains("-n")) {
                    str2 = this.srcSet.get(str.replace("-n", ""));
                }
                if (TextUtils.isEmpty(str2)) {
                    return this.src;
                }
                return str2;
            }
            return this.src;
        }
        return (String) invokeCommon.objValue;
    }

    public void insertChild(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048603, this, criusData, i) == null) && hasUI()) {
            getUI().insertChild(criusData, i);
        }
    }

    public void setFontSizeById(String str, float f) {
        CriusData dataById;
        CriusNode criusNode;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048614, this, str, f) == null) && this.rootNode != null && (dataById = getDataById(str)) != null && (criusNode = dataById.criusNode) != null) {
            dataById.fontSize = f;
            criusNode.dirty();
            this.rootNode.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
