package c.a.r0.j2.k.e.f1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
import c.a.q0.s.s.f;
import c.a.q0.s.s.i;
import c.a.r0.j2.h.e;
import c.a.r0.j2.h.r;
import c.a.r0.j2.k.e.q0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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

    public static boolean a(List<f> list, i iVar, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, iVar, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.P0() != null) {
                e P0 = pbModel.P0();
                if (P0.g0() && TbadkCoreApplication.isLogin() && !j(postData) && !P0.f0()) {
                    f fVar = new f(9, TbadkCoreApplication.getInst().getString(R.string.block_user), iVar);
                    list.add(fVar);
                    c.a.r0.t3.a.e(fVar.f14428d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<f> b(List<f> list, AgreeData agreeData, SparseArray<Object> sparseArray, i iVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, agreeData, sparseArray, iVar)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    f fVar = new f(-1, q0.h(R.string.c_agreeed, new Object[0]), iVar);
                    fVar.f14428d.setTag(sparseArray);
                    arrayList.add(fVar);
                    if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                        f fVar2 = new f(-2, q0.h(R.string.c_disagree, new Object[0]), iVar);
                        fVar2.f14428d.setTag(sparseArray);
                        arrayList.add(fVar2);
                    }
                } else {
                    f fVar3 = new f(-1, q0.h(R.string.c_agree, new Object[0]), iVar);
                    fVar3.f14428d.setTag(sparseArray);
                    arrayList.add(fVar3);
                    if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                        f fVar4 = new f(-2, q0.h(R.string.c_disagreeed, new Object[0]), iVar);
                        fVar4.f14428d.setTag(sparseArray);
                        arrayList.add(fVar4);
                    }
                }
            } else {
                f fVar5 = new f(-1, q0.h(R.string.c_agree, new Object[0]), iVar);
                fVar5.f14428d.setTag(sparseArray);
                arrayList.add(fVar5);
                if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    f fVar6 = new f(-2, q0.h(R.string.c_disagree, new Object[0]), iVar);
                    fVar6.f14428d.setTag(sparseArray);
                    arrayList.add(fVar6);
                }
            }
            f fVar7 = new f(-3, q0.h(R.string.reply, new Object[0]), iVar);
            fVar7.f14428d.setTag(sparseArray);
            arrayList.add(fVar7);
            f fVar8 = new f(-4, q0.h(R.string.share, new Object[0]), iVar);
            fVar8.f14428d.setTag(sparseArray);
            arrayList.add(fVar8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<f> c(List<f> list, AgreeData agreeData, SparseArray<Object> sparseArray, i iVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, iVar)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                        f fVar = new f(-2, q0.h(R.string.action_dislike, new Object[0]), iVar);
                        fVar.f14428d.setTag(sparseArray);
                        arrayList.add(fVar);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    f fVar2 = new f(-2, q0.h(R.string.c_disagreeed, new Object[0]), iVar);
                    fVar2.f14428d.setTag(sparseArray);
                    arrayList.add(fVar2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                f fVar3 = new f(-2, q0.h(R.string.action_dislike, new Object[0]), iVar);
                fVar3.f14428d.setTag(sparseArray);
                arrayList.add(fVar3);
            }
            f fVar4 = new f(-3, q0.h(R.string.reply, new Object[0]), iVar);
            fVar4.f14428d.setTag(sparseArray);
            arrayList.add(0, fVar4);
            f fVar5 = new f(-4, q0.h(R.string.share, new Object[0]), iVar);
            fVar5.f14428d.setTag(sparseArray);
            arrayList.add(1, fVar5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable c.a.e.a.f<?> fVar, a.e eVar, a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, fVar, eVar, eVar2) == null) {
            int i2 = R.string.del_post_confirm;
            int i3 = R.string.dialog_ok;
            int i4 = R.string.dialog_cancel;
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(activity);
            aVar.setMessageId(i2);
            aVar.setPositiveButton(i3, eVar);
            aVar.setNegativeButton(i4, eVar2);
            aVar.setCancelable(true);
            aVar.create(fVar);
            aVar.show();
        }
    }

    public static List<f> e(List<f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (f fVar : list) {
                fVar.k(g(fVar));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static SpannableStringBuilder f(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            String tbRichText = postData.K() != null ? postData.K().toString() : "";
            SpannableString n = n(postData.t().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(tbRichText, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable g(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fVar)) == null) {
            switch (fVar.e()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (q0.h(R.string.c_disagree, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (q0.h(R.string.c_agree, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_like30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_liked30, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_expression30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_save30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_copy30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (q0.h(R.string.mark, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (q0.h(R.string.report_text, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (q0.h(R.string.mute_option, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (q0.h(R.string.report_text, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (q0.h(R.string.delete, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_administration30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_hide30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (q0.h(R.string.delete_post, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (q0.h(R.string.delete, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (q0.h(R.string.mute, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (q0.h(R.string.un_mute, new Object[0]).equals(fVar.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean h(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pbModel)) == null) ? (pbModel == null || pbModel.P0() == null || !pbModel.P0().g0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean i(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, rVar)) == null) ? rVar != null && rVar.q() : invokeL.booleanValue;
    }

    public static boolean j(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, postData)) == null) ? (postData == null || postData.t() == null || StringUtils.isNull(postData.t().getUserId()) || !postData.t().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<f> k(List<f> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<f> it = list.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (next.e() == 2 || next.e() == 1 || next.e() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

    public static boolean l(TextView textView, PostData postData, r rVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, textView, postData, rVar)) == null) {
            if (textView != null && rVar != null && postData != null) {
                if (rVar.q() && TbadkCoreApplication.isLogin() && !j(postData) && !rVar.p()) {
                    c.a.r0.t3.a.e(textView, postData);
                    textView.setVisibility(0);
                    return true;
                }
                textView.setVisibility(8);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            if (i2 != -4) {
                if (i2 != -3) {
                    if (i2 != -2) {
                        if (i2 != -1) {
                            switch (i2) {
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

    public static SpannableString n(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i2)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i2), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }
}
