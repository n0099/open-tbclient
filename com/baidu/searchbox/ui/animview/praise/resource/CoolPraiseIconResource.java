package com.baidu.searchbox.ui.animview.praise.resource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class CoolPraiseIconResource {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Drawable> praiseIconDayList;
    public static HashMap<String, Drawable> praiseIconNightList;
    public static List<Uri> webpUri;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1591146903, "Lcom/baidu/searchbox/ui/animview/praise/resource/CoolPraiseIconResource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1591146903, "Lcom/baidu/searchbox/ui/animview/praise/resource/CoolPraiseIconResource;");
                return;
            }
        }
        praiseIconDayList = new HashMap<>();
        praiseIconNightList = new HashMap<>();
        webpUri = new ArrayList();
    }

    public CoolPraiseIconResource() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<Uri> getMiniVideoPraiseAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? webpUri : (List) invokeV.objValue;
    }

    public static Drawable getPraiseIconByType(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = (!z2 ? ComboPraiseProvider.PREFIX_NOT_PRESSED_UNCLICKED : "") + str;
            if (z) {
                if (praiseIconNightList.get(str2) != null) {
                    if (praiseIconNightList.get(ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str2) == null) {
                        return null;
                    }
                    HashMap<String, Drawable> hashMap = praiseIconNightList;
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, hashMap.get(ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str2));
                    stateListDrawable.addState(new int[0], praiseIconNightList.get(str2));
                    return stateListDrawable;
                }
                return null;
            } else if (praiseIconDayList.get(str2) != null) {
                if (praiseIconDayList.get(ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str2) == null) {
                    return null;
                }
                HashMap<String, Drawable> hashMap2 = praiseIconDayList;
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[]{16842919}, hashMap2.get(ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str2));
                stateListDrawable2.addState(new int[0], praiseIconDayList.get(str2));
                return stateListDrawable2;
            } else {
                return null;
            }
        }
        return (Drawable) invokeCommon.objValue;
    }

    public static void storeMiniVideoPraiseAnim(File file) {
        File[] findAllTargetFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file) == null) || (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ComboPraiseProvider.RES_NAME_PRAISE_WEBP_SUFFIX, true)) == null || findAllTargetFiles.length <= 0) {
            return;
        }
        Arrays.sort(findAllTargetFiles);
        for (File file2 : findAllTargetFiles) {
            webpUri.add(Uri.fromFile(file2));
        }
    }

    public static void storePraiseIconResource(Context context, File file, boolean z) {
        File[] findAllTargetFiles;
        Drawable loadImageFromFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, null, context, file, z) == null) || (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ".png", true)) == null || findAllTargetFiles.length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < findAllTargetFiles.length; i2++) {
            if (findAllTargetFiles[i2] != null && (loadImageFromFile = IResourcePackage.Utils.loadImageFromFile(context, findAllTargetFiles[i2])) != null) {
                if (!z) {
                    praiseIconDayList.put(findAllTargetFiles[i2].getName(), loadImageFromFile);
                } else {
                    praiseIconNightList.put(findAllTargetFiles[i2].getName(), loadImageFromFile);
                }
            }
        }
    }
}
