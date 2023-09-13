package com.baidu.tbadk.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c05;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes4.dex */
public class BDLayoutMode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ATTR_NAME_BACKGROUND = "tb_background";
    public static final String ATTR_NAME_DIVIDER = "tb_divider";
    public static final String ATTR_NAME_DRAWABLE_Left = "tb_drawableLeft";
    public static final String ATTR_NAME_DRAWABLE_Right = "tb_drawableRight";
    public static final String ATTR_NAME_DRAWABLE_TOP = "tb_drawableTop";
    public static final String ATTR_NAME_ID = "id";
    public static final String ATTR_NAME_IMAGE_SRC = "tb_src";
    public static final String ATTR_NAME_PROGRESS_DRAWABLE = "tb_progressDrawable";
    public static final String ATTR_NAME_STYLE = "tb_style";
    public static final String ATTR_NAME_TEXT_COLOR = "tb_textColor";
    public static final String ATTR_NAME_TEXT_COLOR_HINT = "tb_textColorHint";
    public static final String nightSufix = "_2";
    public static String sPackagename;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources contextRes;
    public boolean isForceDayMode;
    public boolean isNightMode;
    public Resources pluginRes;
    public Map<String, c05> viewModeInfos;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1911818337, "Lcom/baidu/tbadk/core/BDLayoutMode;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1911818337, "Lcom/baidu/tbadk/core/BDLayoutMode;");
        }
    }

    public BDLayoutMode() {
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
        this.isNightMode = false;
        this.viewModeInfos = new HashMap();
        this.isForceDayMode = false;
    }

    public void destroy() {
        Map<String, c05> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (map = this.viewModeInfos) != null) {
            map.clear();
            this.viewModeInfos = null;
        }
    }

    public boolean isNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.isNightMode;
        }
        return invokeV.booleanValue;
    }

    private void changeForView(View view2) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int q;
        ColorStateList colorListSafe;
        ColorStateList colorListSafe2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, view2) == null) {
            String str = "@" + view2.getId();
            Map<String, c05> map = this.viewModeInfos;
            if (map != null && map.containsKey(str)) {
                c05 c05Var = this.viewModeInfos.get(str);
                if (view2 instanceof TextView) {
                    if (c05Var.v() != 0 && (colorListSafe2 = getColorListSafe(this.isNightMode, c05Var.u(), c05Var.v())) != null) {
                        ((TextView) view2).setTextColor(colorListSafe2);
                    }
                    if (c05Var.t() != 0 && (colorListSafe = getColorListSafe(this.isNightMode, c05Var.s(), c05Var.t())) != null) {
                        ((TextView) view2).setHintTextColor(colorListSafe);
                    }
                    if (c05Var.r() != 0) {
                        TextView textView = (TextView) view2;
                        Context context = view2.getContext();
                        if (this.isNightMode) {
                            q = c05Var.r();
                        } else {
                            q = c05Var.q();
                        }
                        textView.setTextAppearance(context, q);
                    }
                    if (c05Var.k() != 0) {
                        ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getDrawable(this.isNightMode, c05Var.j(), c05Var.k()), (Drawable) null, (Drawable) null);
                    }
                    if (c05Var.g() != 0) {
                        ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds(getDrawable(this.isNightMode, c05Var.f(), c05Var.g()), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                    if (c05Var.i() != 0) {
                        ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getDrawable(this.isNightMode, c05Var.h(), c05Var.i()), (Drawable) null);
                    }
                } else if (view2 instanceof ImageButton) {
                    if (c05Var.n() != 0 && (drawable3 = getDrawable(this.isNightMode, c05Var.m(), c05Var.n())) != null) {
                        ((ImageView) view2).setImageDrawable(drawable3);
                    }
                } else if (view2 instanceof ImageView) {
                    if (c05Var.n() != 0 && (drawable2 = getDrawable(this.isNightMode, c05Var.m(), c05Var.n())) != null) {
                        ((ImageView) view2).setImageDrawable(drawable2);
                    }
                } else if ((view2 instanceof ProgressBar) && c05Var.p() != 0 && (drawable = getDrawable(this.isNightMode, c05Var.o(), c05Var.p())) != null) {
                    ((ProgressBar) view2).setProgressDrawable(drawable);
                }
                if (c05Var.c() != 0) {
                    int paddingLeft = view2.getPaddingLeft();
                    int paddingTop = view2.getPaddingTop();
                    int paddingRight = view2.getPaddingRight();
                    int paddingBottom = view2.getPaddingBottom();
                    String resourceTypeName = this.contextRes.getResourceTypeName(c05Var.b());
                    if (resourceTypeName != null && resourceTypeName.equals("color")) {
                        view2.setBackgroundColor(getColor(this.isNightMode, c05Var.b(), c05Var.c()));
                    } else {
                        view2.setBackgroundDrawable(getDrawable(this.isNightMode, c05Var.b(), c05Var.c()));
                    }
                    view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            }
        }
    }

    private void changeForViewGroup(ViewGroup viewGroup) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, viewGroup) == null) {
            String str = "@" + viewGroup.getId();
            Map<String, c05> map = this.viewModeInfos;
            if (map != null && map.containsKey(str)) {
                c05 c05Var = this.viewModeInfos.get(str);
                if (viewGroup instanceof AdapterView) {
                    if ((viewGroup instanceof ListView) && c05Var.e() != 0) {
                        ListView listView = (ListView) viewGroup;
                        int dividerHeight = listView.getDividerHeight();
                        listView.setDivider(getDrawable(this.isNightMode, c05Var.d(), c05Var.e()));
                        listView.setDividerHeight(dividerHeight);
                    }
                    Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                    if (adapter != null && (adapter instanceof BaseAdapter)) {
                        ((BaseAdapter) adapter).notifyDataSetChanged();
                    }
                }
                if (c05Var.c() != 0) {
                    int paddingLeft = viewGroup.getPaddingLeft();
                    int paddingTop = viewGroup.getPaddingTop();
                    int paddingRight = viewGroup.getPaddingRight();
                    int paddingBottom = viewGroup.getPaddingBottom();
                    String resourceTypeName = this.contextRes.getResourceTypeName(c05Var.b());
                    if (resourceTypeName != null && resourceTypeName.equals("color")) {
                        viewGroup.setBackgroundColor(getColor(this.isNightMode, c05Var.b(), c05Var.c()));
                    } else {
                        viewGroup.setBackgroundDrawable(getDrawable(this.isNightMode, c05Var.b(), c05Var.c()));
                    }
                    viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            }
        }
    }

    private int getColor(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 2 && (this.isForceDayMode || skinType != 4)) {
                if (!z) {
                    return this.contextRes.getColor(i);
                }
                if (i == i2) {
                    Resources resources = this.contextRes;
                    this.pluginRes = resources;
                    i2 = getNightResouce(resources, resources, i);
                }
                Resources resources2 = this.pluginRes;
                if (resources2 == null) {
                    return this.contextRes.getColor(i);
                }
                try {
                    return resources2.getColor(i2);
                } catch (Resources.NotFoundException unused) {
                    return this.contextRes.getColor(i);
                }
            }
            return SkinManager.getColor(i);
        }
        return invokeCommon.intValue;
    }

    private ColorStateList getColorList(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 2 && (this.isForceDayMode || skinType != 4)) {
                if (!z) {
                    return this.contextRes.getColorStateList(i);
                }
                if (i == i2) {
                    Resources resources = this.contextRes;
                    this.pluginRes = resources;
                    i2 = getNightResouce(resources, resources, i);
                }
                Resources resources2 = this.pluginRes;
                if (resources2 == null) {
                    return this.contextRes.getColorStateList(i);
                }
                try {
                    return resources2.getColorStateList(i2);
                } catch (Resources.NotFoundException unused) {
                    return this.contextRes.getColorStateList(i);
                }
            }
            return SkinManager.getColorList(i);
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    private Drawable getDrawable(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 2 && (this.isForceDayMode || skinType != 4)) {
                if (!z) {
                    try {
                        return this.contextRes.getDrawable(i);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
                if (i == i2) {
                    Resources resources = this.contextRes;
                    this.pluginRes = resources;
                    i2 = getNightResouce(resources, resources, i);
                }
                Resources resources2 = this.pluginRes;
                if (resources2 == null) {
                    try {
                        return this.contextRes.getDrawable(i);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
                try {
                    try {
                        return resources2.getDrawable(i2);
                    } catch (Throwable unused3) {
                        return null;
                    }
                } catch (Resources.NotFoundException unused4) {
                    return this.contextRes.getDrawable(i);
                } catch (ArrayIndexOutOfBoundsException unused5) {
                    return null;
                }
            }
            return SkinManager.getDrawable(i);
        }
        return (Drawable) invokeCommon.objValue;
    }

    public static int getNightResouce(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, resources, resources2, i)) == null) {
            try {
                str = resources.getResourceName(i);
            } catch (Exception unused) {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                String packageName = SkinManager.getPackageName();
                sPackagename = packageName;
                if (StringUtils.isNull(packageName)) {
                    sPackagename = BdBaseApplication.getInst().getPackageName();
                }
                str = sPackagename + str.substring(str.indexOf(":"));
                i2 = resources2.getIdentifier(str + "_2", null, null);
            } else {
                i2 = i;
            }
            if (i2 == 0) {
                BdLog.e(str + " 缺少深色资源,使用了日间资源");
                return i;
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    private ColorStateList getColorListSafe(boolean z, int i, int i2) {
        String str;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                return getColorList(z, i, i2);
            } catch (Exception e) {
                try {
                    str = this.contextRes.getResourceName(i);
                } catch (Exception unused) {
                    str = "";
                }
                TiebaStatic.log(new StatisticItem("getColorListCrash").param("obj_source", e.toString()).param("obj_param1", i).param(TiebaStatic.Params.OBJ_PARAM2, str));
                return null;
            }
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    private final int[] getResID(String str) {
        InterceptResult invokeL;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            if (!TextUtils.isDigitsOnly(str.substring(1)) || (parseInt = Integer.parseInt(str.substring(1))) == 0) {
                return null;
            }
            return new int[]{parseInt, getNightResouce(this.contextRes, this.pluginRes, parseInt)};
        }
        return (int[]) invokeL.objValue;
    }

    public void initModeInfos(String str, Context context, AttributeSet attributeSet) {
        int[] resID;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, context, attributeSet) == null) {
            try {
                Resources resources = context.getResources();
                this.contextRes = resources;
                this.pluginRes = resources;
                int attributeCount = attributeSet.getAttributeCount();
                c05 c05Var = new c05();
                c05Var.R(str);
                boolean z = false;
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    String attributeName = attributeSet.getAttributeName(i2);
                    String attributeValue = attributeSet.getAttributeValue(i2);
                    if (attributeName.equals("id")) {
                        c05Var.G(attributeValue);
                    } else if (attributeName.equals(ATTR_NAME_BACKGROUND)) {
                        int[] resID2 = getResID(attributeValue);
                        if (resID2 != null) {
                            c05Var.w(resID2[0]);
                            c05Var.x(resID2[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_IMAGE_SRC)) {
                        int[] resID3 = getResID(attributeValue);
                        if (resID3 != null) {
                            c05Var.H(resID3[0]);
                            c05Var.I(resID3[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_TEXT_COLOR)) {
                        int[] resID4 = getResID(attributeValue);
                        if (resID4 != null) {
                            c05Var.P(resID4[0]);
                            c05Var.Q(resID4[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_STYLE)) {
                        int[] resID5 = getResID(attributeValue);
                        if (resID5 != null) {
                            c05Var.L(resID5[0]);
                            c05Var.M(resID5[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_DIVIDER)) {
                        int[] resID6 = getResID(attributeValue);
                        if (resID6 != null) {
                            c05Var.y(resID6[0]);
                            c05Var.z(resID6[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_DRAWABLE_TOP)) {
                        int[] resID7 = getResID(attributeValue);
                        if (resID7 != null) {
                            c05Var.E(resID7[0]);
                            c05Var.F(resID7[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_DRAWABLE_Left)) {
                        int[] resID8 = getResID(attributeValue);
                        if (resID8 != null) {
                            c05Var.A(resID8[0]);
                            c05Var.B(resID8[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_DRAWABLE_Right)) {
                        int[] resID9 = getResID(attributeValue);
                        if (resID9 != null) {
                            c05Var.C(resID9[0]);
                            c05Var.D(resID9[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_PROGRESS_DRAWABLE)) {
                        int[] resID10 = getResID(attributeValue);
                        if (resID10 != null) {
                            c05Var.J(resID10[0]);
                            c05Var.K(resID10[1]);
                            z = true;
                        }
                    } else if (attributeName.equals(ATTR_NAME_TEXT_COLOR_HINT) && (resID = getResID(attributeValue)) != null) {
                        c05Var.N(resID[0]);
                        c05Var.O(resID[1]);
                        z = true;
                    }
                    if (z && TbConfig.getDebugSwitch() && (i = JavaTypesHelper.toInt(attributeValue.substring(1), 0)) != 0) {
                        String resourceName = this.contextRes.getResourceName(i);
                        c05Var.a(attributeName + "=" + resourceName);
                    }
                }
                if (z && !TextUtils.isEmpty(c05Var.l()) && this.viewModeInfos != null && !this.viewModeInfos.containsKey(c05Var.l())) {
                    this.viewModeInfos.put(c05Var.l(), c05Var);
                }
            } catch (Resources.NotFoundException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onModeChanged(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || view2 == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(view2);
        while (!stack.isEmpty()) {
            View view3 = (View) stack.pop();
            if (view3 instanceof ViewGroup) {
                try {
                    changeForViewGroup((ViewGroup) view3);
                } catch (Resources.NotFoundException e) {
                    BdLog.e(e);
                }
                if (!(view3 instanceof AdapterView)) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        stack.push(viewGroup.getChildAt(i));
                    }
                }
            } else {
                changeForView(view3);
            }
        }
    }

    public void setNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.isNightMode = z;
        }
    }

    public void setPluginRes(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, resources) == null) {
            this.pluginRes = resources;
        }
    }
}
