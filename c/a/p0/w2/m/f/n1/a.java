package c.a.p0.w2.m.f.n1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.a;
import c.a.o0.r.t.h;
import c.a.o0.r.t.l;
import c.a.p0.w2.i.f;
import c.a.p0.w2.i.u;
import c.a.p0.w2.m.f.y0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<h> list, l lVar, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, lVar, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.S0() != null) {
                f S0 = pbModel.S0();
                if (S0.h0() && TbadkCoreApplication.isLogin() && !j(postData) && !S0.g0()) {
                    h hVar = new h(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0310), lVar);
                    list.add(hVar);
                    c.a.p0.j4.a.e(hVar.f11053d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<h> b(List<h> list, AgreeData agreeData, SparseArray<Object> sparseArray, l lVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, agreeData, sparseArray, lVar)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    h hVar = new h(-1, y0.h(R.string.obfuscated_res_0x7f0f0359, new Object[0]), lVar);
                    hVar.f11053d.setTag(sparseArray);
                    arrayList.add(hVar);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09169c) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09169c)).booleanValue()) {
                        h hVar2 = new h(-2, y0.h(R.string.obfuscated_res_0x7f0f035a, new Object[0]), lVar);
                        hVar2.f11053d.setTag(sparseArray);
                        arrayList.add(hVar2);
                    }
                } else {
                    h hVar3 = new h(-1, y0.h(R.string.obfuscated_res_0x7f0f0358, new Object[0]), lVar);
                    hVar3.f11053d.setTag(sparseArray);
                    arrayList.add(hVar3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09169c) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09169c)).booleanValue()) {
                        h hVar4 = new h(-2, y0.h(R.string.obfuscated_res_0x7f0f035b, new Object[0]), lVar);
                        hVar4.f11053d.setTag(sparseArray);
                        arrayList.add(hVar4);
                    }
                }
            } else {
                h hVar5 = new h(-1, y0.h(R.string.obfuscated_res_0x7f0f0358, new Object[0]), lVar);
                hVar5.f11053d.setTag(sparseArray);
                arrayList.add(hVar5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09169c) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09169c)).booleanValue()) {
                    h hVar6 = new h(-2, y0.h(R.string.obfuscated_res_0x7f0f035a, new Object[0]), lVar);
                    hVar6.f11053d.setTag(sparseArray);
                    arrayList.add(hVar6);
                }
            }
            h hVar7 = new h(-3, y0.h(R.string.obfuscated_res_0x7f0f0f88, new Object[0]), lVar);
            hVar7.f11053d.setTag(sparseArray);
            arrayList.add(hVar7);
            h hVar8 = new h(-4, y0.h(R.string.obfuscated_res_0x7f0f1107, new Object[0]), lVar);
            hVar8.f11053d.setTag(sparseArray);
            arrayList.add(hVar8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<h> c(List<h> list, AgreeData agreeData, SparseArray<Object> sparseArray, l lVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, lVar)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09169c) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09169c)).booleanValue()) {
                        h hVar = new h(-2, y0.h(R.string.obfuscated_res_0x7f0f0085, new Object[0]), lVar);
                        hVar.f11053d.setTag(sparseArray);
                        arrayList.add(hVar);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09169c) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09169c)).booleanValue()) {
                    h hVar2 = new h(-2, y0.h(R.string.obfuscated_res_0x7f0f035b, new Object[0]), lVar);
                    hVar2.f11053d.setTag(sparseArray);
                    arrayList.add(hVar2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09169c) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09169c)).booleanValue()) {
                h hVar3 = new h(-2, y0.h(R.string.obfuscated_res_0x7f0f0085, new Object[0]), lVar);
                hVar3.f11053d.setTag(sparseArray);
                arrayList.add(hVar3);
            }
            h hVar4 = new h(-3, y0.h(R.string.obfuscated_res_0x7f0f0f88, new Object[0]), lVar);
            hVar4.f11053d.setTag(sparseArray);
            arrayList.add(0, hVar4);
            h hVar5 = new h(-4, y0.h(R.string.obfuscated_res_0x7f0f1107, new Object[0]), lVar);
            hVar5.f11053d.setTag(sparseArray);
            arrayList.add(1, hVar5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable c.a.d.a.f<?> fVar, a.e eVar, a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, fVar, eVar, eVar2) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(activity);
            aVar.setMessageId(R.string.obfuscated_res_0x7f0f048a);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f04d6, eVar);
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f04d1, eVar2);
            aVar.setCancelable(true);
            aVar.create(fVar);
            aVar.show();
        }
    }

    public static List<h> e(List<h> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (h hVar : list) {
                hVar.l(g(hVar));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static SpannableStringBuilder f(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            String tbRichText = postData.N() != null ? postData.N().toString() : "";
            SpannableString n = n(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(tbRichText, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable g(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, hVar)) == null) {
            switch (hVar.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080948, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080932, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (y0.h(R.string.obfuscated_res_0x7f0f035a, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080936, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080937, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (y0.h(R.string.obfuscated_res_0x7f0f0358, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08093f, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080940, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080938, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080947, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080933, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (y0.h(R.string.obfuscated_res_0x7f0f0a7f, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080930, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080931, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (y0.h(R.string.obfuscated_res_0x7f0f0fa2, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080946, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (y0.h(R.string.obfuscated_res_0x7f0f0b17, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080944, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (y0.h(R.string.obfuscated_res_0x7f0f0fa2, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080946, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (y0.h(R.string.obfuscated_res_0x7f0f048e, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080935, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08092b, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08093b, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080920, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (y0.h(R.string.obfuscated_res_0x7f0f0499, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080935, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (y0.h(R.string.obfuscated_res_0x7f0f048e, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080935, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08092f, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (y0.h(R.string.obfuscated_res_0x7f0f0b13, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080942, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (y0.h(R.string.obfuscated_res_0x7f0f1460, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080943, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean h(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pbModel)) == null) ? (pbModel == null || pbModel.S0() == null || !pbModel.S0().h0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean i(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uVar)) == null) ? uVar != null && uVar.q() : invokeL.booleanValue;
    }

    public static boolean j(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, postData)) == null) ? (postData == null || postData.s() == null || StringUtils.isNull(postData.s().getUserId()) || !postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<h> k(List<h> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<h> it = list.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

    public static boolean l(TextView textView, PostData postData, u uVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, textView, postData, uVar)) == null) {
            if (textView != null && uVar != null && postData != null) {
                if (uVar.q() && TbadkCoreApplication.isLogin() && !j(postData) && !uVar.p()) {
                    c.a.p0.j4.a.e(textView, postData);
                    textView.setVisibility(0);
                    return true;
                }
                textView.setVisibility(8);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static int m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            if (i != -4) {
                if (i != -3) {
                    if (i != -2) {
                        if (i != -1) {
                            switch (i) {
                                case 4:
                                    return 5;
                                case 5:
                                    return 7;
                                case 6:
                                    return 6;
                                case 7:
                                    return 9;
                                case 8:
                                    return 8;
                                default:
                                    return 0;
                            }
                        }
                        return 1;
                    }
                    return 2;
                }
                return 3;
            }
            return 4;
        }
        return invokeI.intValue;
    }

    public static SpannableString n(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }
}
